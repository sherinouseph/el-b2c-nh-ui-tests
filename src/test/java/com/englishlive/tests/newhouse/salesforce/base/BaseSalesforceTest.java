package com.englishlive.tests.newhouse.salesforce.base;

import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.helpers.*;
import com.englishtown.helpers.mail.SendMail;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.pages.*;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.UniqueDataObject;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public abstract class BaseSalesforceTest extends BaseTestHelper implements IBaseSalesForce{
    public static final Logger logger = LoggerFactory.getLogger(SalesForceBasePage.class);
    //@Value("#{applicationPropertiesList['env.id']}")
    public String SALESFORCE_ENV="qa";
    //@Value("#{applicationPropertiesList['base.url']}")
    public String BASE_SALESFORCE_URL;//should come from test depends on the env
    public String salesForceAgentName = FRANCE_SALESAGENT_QA;
    public String salesForceSupervisorName=FRANCE_SUPERVISOR_QA;
    public String salesForceUserName=ADMIN_QA;
    public String salesForceFinanceManager ;
    public String oppoUrl;
    public String actualUrl;
    public String currentUrl;
    public String retentionUrl;
    public String contactUrl;
    public String accountUrl;
    public String leadurl;
    protected String collectedDate;
    protected String collectedAmount;
    public int noOfInstallments;
    public int noOfPaymentRecords;
    public String leadEmail;
    public String leadType;
    public boolean isEnrolStudent=false;
    public boolean isNewHouseEnroll=false;
    public boolean isAddQuality=false;
    public String  leadIdentifierAtt;
    public boolean ifUpsell=false;




    protected LoginSalesForcePage loginSalesForcePage;
    protected HomeSalesForcePage homeSalesForcePage;
    protected LeadsHomePage leadsHomePage;
    protected SelectLeadRecordType selectLeadRecordType;
    protected NewLeadSalesForcePage newLeadSalesForcePage;
    protected OppoSalesForcePage oppoSalesForcePage;
    protected PaymentSalesForcePage payment ;
    protected AddProductVirtualPayment addProductVirtualPayment;
    protected AddProductPCI addProductPCI;
    protected PaymentProviderPage paymentProviderPage;
    protected BankTransfer bankTransferPage ;
    protected ActualSalesForcePage actualSalesForcePage;
    protected MapStudentPage mapStudentPage;
    protected ActivateCoursePage activateCoursePage;
    protected PaymentRecordPage paymentRecordPage;
    protected ContactPage contactPage;
    protected RetentionPage retentionPage;
    protected AccountPage accountPage;

    // TEST DATA
    protected String productName = "TEST New Payment";
    protected PaymentProviderName paymentProviderName;
    protected String paymentMethod = "Credit Card" ;
    protected String cardTypeId    = "card_type_001"; // visa
    protected Map leadMapData;
    protected Map creditCardMapData ;
    protected Map paymentMapData;
    protected boolean isPciMx = false;
    protected String leadRecordType; // test should set this up
    protected String leadCountry;
    protected String paymentSchedule ;
    protected String installAmount;
    protected String discount;
    protected String cardName;
    protected String numberOfInstallments = "3";
    protected String paymentSuccessMessage = "CONGRATULATIONS!";
    protected String paymentSuccessMsgWorldPay = "Success";
    protected int paymentFrameId = 0;
    protected String opportunityStageApproved = "Opportunity Approved";
    protected String opportunityStageWon = "Closed Won";
    protected String retentionRecordType;
    protected String retentionType;
    protected String retentionOwner=ADMIN_QA_USERNAME;
    protected String retentionStatus;
    protected String suspendDate=getTodaysDate();
    protected String resumeDate;
    protected String cancelStatus="Pending Audit";
    public String cancelDate="";
    public boolean isPCI;
    public boolean isMarkforCancel=false;
    public Alert alert;
    public String todayDate = getTodaysDate();
    public String opportunityStageValueWeCss =".pbSubsection tr:first-child td:last-child";

    protected boolean isChargeNowShowAlertTwice = false; // the alert is shown twice for CC pay but once for DD


    //Get Base Url for SalesForce
    public String getSalesforceBase_URL() {
        if(SALESFORCE_ENV=="Live")
            BASE_SALESFORCE_URL=SALESFORCE_LIVE_URL;
        else
            BASE_SALESFORCE_URL=SALESFORCE_QA_URL;

        return BASE_SALESFORCE_URL;
    }


    /**
     * Open sales force url and login
     * Driver mast be set
     * @param salesForceUserName
     * @param password
     */
    public void openSalesForceAndlogin(String salesForceUserName, String password){
        openUrl(getWebDriver(), getSalesforceBase_URL());
        sleep(1000);
        loginSalesForcePage = new LoginSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        if(SALESFORCE_ENV=="Live")
            salesForceUserName=ADMIN_LIVE;
        loginSalesForcePage.login(salesForceUserName, SALESFORCE_PASS );
            if(SALESFORCE_ENV.contains("Live")) {
                waitForElementCondition(ExpectedConditions.elementToBeClickable(
                        By.id("tryLexDialogX")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
                sleep(3000);
                currWebElement = findElement(By.id("tryLexDialogX"), WaitTool.DEFAULT_WAIT_4_ELEMENT);
                click(currWebElement);
            }
        homeSalesForcePage = new HomeSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        homeSalesForcePage.simpleTest();
    }

    public void openSalesForceAndlogin(String url,String salesForceUserName, String password){
        openUrl(getWebDriver(), url);
        sleep(1000);
        loginSalesForcePage = new LoginSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        loginSalesForcePage.login(salesForceUserName, SALESFORCE_PASS );
        homeSalesForcePage = new HomeSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        homeSalesForcePage.simpleTest();
    }

    public void createLead()    {
        click(homeSalesForcePage.leadTabWe);
        // Lead
        leadsHomePage = new LeadsHomePage(getWebDriver(), SALESFORCE_WAIT_MED);
        leadsHomePage.simpleTest();
        click(leadsHomePage.newBtn);
        if (isPCI == true || StringUtils.contains(salesForceUserName, ADMIN_QA) ){
            selectLeadRecordType = new SelectLeadRecordType(getWebDriver(), SALESFORCE_WAIT_MED);
            selectLeadRecordType.selectRecordTypeAndClickContinue(leadRecordType);
        }
        // new lead
        newLeadSalesForcePage = new NewLeadSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        enterFormData(leadMapData);
        if(isUseCustommEmail)
            setUserTospecificEmailSF(leadEmail);
        else
        enterEmail(getWebDriver(),leadRecordType);
        newLeadSalesForcePage.selectCountry(leadCountry);
        click(newLeadSalesForcePage.aptdateWe);
        // selectDate(newLeadSalesForcePage.aptdateWe);
        newLeadSalesForcePage.saveLead();
    }


    public void openLeadPage(String leademail){
        leademail=StringUtils.lowerCase(leademail);
        logger.info("OpenLeadPage " + leademail);
        leadIdentifierAtt=findElement(By.cssSelector("a[href*='"+leademail+"']"),40).getAttribute("data-seclki");
        leadurl="https://cs5.salesforce.com/"+leadIdentifierAtt+"?srPos=0&srKp=00Q";
        openUrl(getWebDriver(),leadurl);
    }

    public void setLeadStatusInLeadPageAndSave(String leademail,String leadStatus){
        logger.info("setLeadStatusInLeadPageAndSave");
        openLeadPage(leademail);
        clickOnEditBtn_Lead();
        setLeadStatusAndSave(leadStatus);
    }

    public void setLeadOwner(String leadOwner, String leadRecordType){
        logger.info("setLeadOwner");
        String url="https://cs5.salesforce.com/"+leadIdentifierAtt+"/a";
        openUrl(getWebDriver(),url);
        WebElement we=findElement(By.name("newOwn"));
        sendKey(getWebDriver(),we,leadRecordType,false);
        click(By.className("lookupIcon"));
        sleep(3000);
        WebDriverWindowHelper.switchToWindow(getWebDriver(), 1);
        WebDriverWindowHelper.switchToFrameByName(getWebDriver(), "resultsFrame");
        WebElement ounerLinkWe = findElements(By.partialLinkText(leadOwner)).get(0);
        click(ounerLinkWe);
        sleep(2000);
        WebDriverWindowHelper.switchToWindow(getWebDriver(), 0);
        sleep(1000);
        //webDriverSwitchToDefautContent();
        click(By.name("save"));
        sleep(1000);
        openUrl(getWebDriver(),leadurl);
    }

    public void clickOnEditBtn_Lead(){
        leadsHomePage = new LeadsHomePage(getWebDriver(), SALESFORCE_WAIT_MED);
        click(leadsHomePage.editBtn);
    }

    public void setLeadStatusAndSave(String leadStatus){
        leadsHomePage = new LeadsHomePage(getWebDriver(), SALESFORCE_WAIT_MED);
        leadsHomePage.setLeadStatus(leadStatus);
        newLeadSalesForcePage = new NewLeadSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        click(newLeadSalesForcePage.aptdateWe);
        newLeadSalesForcePage.saveLead();
        //leadsHomePage.clickSaveBtn();
    }

    public void selectNewOpportunityRecordType()    {
        if (isPCI == true || StringUtils.contains(salesForceUserName, ADMIN_QA) ){
            selectLeadRecordType = new SelectLeadRecordType(getWebDriver(), SALESFORCE_WAIT_MED);
            selectLeadRecordType.selectRecordTypeAndClickContinue(leadRecordType);
        }
       else{
            logger.info("no need to select the opportunity record type");
        }
    }

    public void verifyLeadType(String leadType) {
        WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector("#Lead_body table tr td:nth-child(6)"), 25, 999);
        String emailidSF = TestUtil.getWebElementText(findElement(By.cssSelector("#Lead_body table tr td:nth-child(6)")));
        AssertHelper.assertThat("Lead not present in salesforce", emailidSF, equalToIgnoringCase(leadEmail));
        logger.info("Lead is present in salesforce..." + leadEmail);
        AssertHelper.assertThat("Lead Type is not " + leadType , TestUtil.getWebElementText(findElement(By.cssSelector("#Lead_body table tr td:nth-child(8)"))), equalToIgnoringCase(leadType));
        logger.info("Lead type is " + leadType + "- Verified");
    }

    /**
     *
     */
    protected void convertLeadToOpportunity(){
        logger.info(("convertLeadToOpportunity ...!"));
        ConvertToOppoPage convertToOppoPage = new ConvertToOppoPage(getWebDriver(), SALESFORCE_WAIT_LONG);
        sleep(2000);
        convertToOppoPage.clickConvertBtn();
        alertAccept(3000);
        logger.info(("Alert Accepted"));
        String currentOppUrl = TestUtil.getCurrentUrl(getWebDriver());
        logger.info("Current browser URL .. opportunity [{}]", currentOppUrl);
    }

    protected void checkOpportunityPage(){
        OppoSalesForcePage oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        oppoSalesForcePage.simpleTest();
        oppoUrl = getWebDriver().getCurrentUrl();
        logger.info("oppo url is " + oppoUrl);
    }

    protected void addQualityAndSaveOppo(){
        logger.info("addQualityAndSaveOppo");
        OppoSalesForcePage oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        oppoSalesForcePage.clickEditbutton();
        oppoSalesForcePage.selectQuality("1");
        logger.info("Quality added successfully");
        //OppoSalesForcePage oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        click(oppoSalesForcePage.oppoSaveBtnWe.get(0));
        logger.info("Opportunity successfully saved");
    }

    protected void clickAddProductBtn(){
        logger.info(("addProduct ...!"));
        sleep(2000);
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        oppoSalesForcePage.clickAddProductBtn();
    }

    protected void clickAddProductPCIBtn(){
        logger.info(("clickAddProductPCIBtn ...!"));
        sleep(2000);
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        oppoSalesForcePage.clickAddProductPciBtn();
    }

    public void addCardInfoForRenewal_Upsell(){
        logger.info("addCardInfoForRenewal");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("Successfully switched to renewal payment window");
        refresh(getWebDriver());
        WaitTool.waitForElementVisible(getWebDriver(), By.name("j_id0:Form:j_id30:j_id31:0:j_id33"), 90, 1000);
        enterRenewal_UpsellPaymentDetails();

    }

    public void enterRenewal_UpsellPaymentDetails(){
        logger.info("enterNewOppoDetails");
        click(findElement(By.name("j_id0:Form:j_id30:j_id31:0:j_id33")));
        click(findElement(By.name("j_id0:Form:j_id30:j_id50:j_id51")));//use selected card to charge
        click(findElement(By.name("j_id0:Form:j_id30:j_id53:j_id54")));//click next button

    }


    protected void selectProductVTP() {
        addProductVirtualPayment = new AddProductVirtualPayment(getWebDriver(), SALESFORCE_WAIT_LONG);
        addProductVirtualPayment.addProductNewPayment(getWebDriver(), productName,  paymentMethod);
        collectedAmount=getText(addProductVirtualPayment.collectedAmountVtpWe);
        logger.info("first installment amount =" +collectedAmount);
        click(addProductVirtualPayment.nextBtn);
        addProductVirtualPayment = new AddProductVirtualPayment(getWebDriver(), SALESFORCE_WAIT_LONG);
        addProductVirtualPayment.clickAddBtn();

    }
    protected void selectProductPCI() {
        addProductPCI = new AddProductPCI(getWebDriver(), SALESFORCE_WAIT_LONG);
        addProductPCI.addProduct(getWebDriver(), productName, paymentMethod, paymentSchedule, discount, numberOfInstallments);
        addProductPCI.clickNext();
        addProductPCI.clickAddBtn();
    }

    protected void verifyProduct(){
        logger.info("verifyProduct ...!");
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        oppoSalesForcePage.verifyProductAdded(productName);
        logger.info("product successfully Added - product present in opportunity page");

    }

    protected void clickeditOppo(){
        logger.info("clickeditOppo ...!");
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        click(oppoSalesForcePage.editBtnWe);
        logger.info("clicked on edit button");

    }

    protected String getSearchByEmailurl(String leadEmail){
        String tmpUrl=StringUtils.replace(leadEmail,"@qp1.org","%40qp1.org");
        String url="https://cs5.salesforce.com/_ui/search/ui/UnifiedSearchResults?searchType=2&sen=a00&sen=00Q&sen=001&sen=003&sen=a01&sen=01t&sen=005&sen=006&sen=a0F&sen=a0V&str="+tmpUrl;
        return url;
    }
    protected void approveProductAsSupperAdmin(){
        logger.info("approveProductAsSupperAdmin ...!");
        //send forr approval
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        sleep(1000);
        oppoSalesForcePage.submitforApproval();
        sleep(1000);
        alertAccept(SALESFORCE_WAIT_MED);
        logger.info("product successfully sent for approval");
        // no need to load it
        oppoSalesForcePage.approveProduct();

    }
    protected void approveProductAsSupervisor(){
        logger.info("approveProductAsSupervisor ...!");
        //send forr approval
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        oppoSalesForcePage.submitforApproval();
        alertAccept(SALESFORCE_WAIT_MED);
        logger.info("product successfully sent for approval ");
        sleep(2000);
        // Login as supervisor and approve it
        oppoUrl=getWebDriver().getCurrentUrl();
        openCurrentOpportunityPageUrl(salesForceSupervisorName);
        oppoSalesForcePage.approveProduct();
       // sleep(2000);
    }

    public void opportunityStageCheck(String stageValue) {
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(),60);
        logger.info("opportunityStageCheck ...! : "+stageValue);        //WebElement stageValueWe = getWebDriver().findElement(By.cssSelector(opportunityStageValueWeCss));       AssertHelper.assertStringContains(getText(stageValueWe), stageValue,"Opportunity stage is not the expected one  ...!");
        sleep(10000);
        refresh(getWebDriver());
        WaitTool.waitForTextPresent(getWebDriver(), By.cssSelector(opportunityStageValueWeCss) , stageValue,
                150, false);


        /*try {
            waitForElementCondition(ExpectedConditions.textToBePresentInElementValue(
                    By.cssSelector(opportunityStageValueWeCss), stageValue), getWebDriver(), SALESFORCE_WAIT_LONG);
        }catch (Exception e){
            failTest("Opportunity Stage is not the expected one ...!["+stageValue+"] "+e.getMessage());
        }*/

    }

    protected void clickOnTakePayment() {
        logger.info("clickOnTakePayment ...!");
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        oppoSalesForcePage.clickTakePayment();
    }

    // if PCI select payment provider
    protected void selectPaymentProviderAndContinue(String paymentProvider) {
        paymentProviderPage = new PaymentProviderPage(getWebDriver(), SALESFORCE_WAIT_MED);
        paymentProviderPage.selectPaymentProvider(paymentProvider);
        sleep(1000);
        paymentProviderPage.clickContinue();
    }


    protected void switchToPaymentIFrame() {
        payment = new PaymentSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        payment.simpleTest();
        payment.switchToPaymentFrame(paymentFrameId);
        logger.info("switchToPaymentFrame executed ...!");
    }

    protected void switchToPaymenWindow(int windowId) {
//        payment = new PaymentSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
//        payment.simpleTest();
        WebDriverWindowHelper.switchToWindow(getWebDriver(),windowId);
        logger.info("switchToPaymenWindow  executed ...!");
    }



    public void approvalProcess(){
        logger.info("starting approvalProcess");
        sleep(5000);
        List <WebElement> approveWeList = WaitTool.waitForListElementsDisplayed(getWebDriver(),By.partialLinkText("Approve / Reject"),35);
        sleep(3000);
        scrollToWeAndClick(getWebDriver(), approveWeList.get(0),0,3000);
        sleep(1000);
        findElement(By.id("Comments")).sendKeys("Approved");
        click(getWebDriver().findElement(By.name("goNext")));
        logger.info("Approved successfully");
    }

    /**
     *
     * @param cardDetailsMap
     * @param cardName  [Visa, Diners, .....]
     */
    protected void enterPaymentDetails(Map cardDetailsMap, String cardName){
        logger.info("enterPaymentDetails ...!");
        payment = new PaymentSalesForcePage(getWebDriver(), 80);
        payment.selectCardType(TestUtil.getMapKeyValue(SalesForceConstants.CARD_TYPE_MAP, cardName));
        enterFormData(cardDetailsMap);
        logger.info("Payment details entered successsfully");

    }
    protected void enterWorldPayPaymentDetails(Map cardDetailsMap, String cardName){
        logger.info("enterPaymentDetails ...!");
        payment = new PaymentSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        //no need to select the card type - new change
        //payment.selectCardTypeWorldPay(TestUtil.getMapKeyValue(SalesForceConstants.WORLDPAY_CARD_TYPE_MAP, cardName));
        enterFormData(cardDetailsMap);
    }
    protected void enterPayUPaymentDetailsAndPay() {
        logger.info("entering the PAYU details");
        enterFormDataCss(paymentMapData);
    }
    /**
     *
     * Bank Transfer details
     */
    protected void enterBankTransferDetails(){
        logger.info("enterPaymentDetails ...!");
        bankTransferPage = new BankTransfer(getWebDriver(),SALESFORCE_WAIT_MED);
        bankTransferPage.simpleTest();
        WaitTool.waitForElementVisible(getWebDriver(),By.name("page:form:j_id35:j_id51:j_id54"),30);
        sleep(2000);
        bankTransferPage.enterBankTransferPaymentDetails("Test Accountholdername");
        sleep(2000);
        collectedDate = addDaysToTodaysDate(-2,"dd/MM/yyyy")+" 13:39";
        sendKey(getWebDriver(), bankTransferPage.collectedDateWe, collectedDate,true);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(bankTransferPage.createActualsBtn), getWebDriver(), 120);
        sleep(2000);
        bankTransferPage.clickCreateActualBtn();

    }
    protected void clickPayAndClose(){
        logger.info("clickPayAndClose");
        click(payment.payBtn);
        checkPaymentMessage();
        getWebDriver().close();
        logger.info("Payment details entered successfully and now back to Opportunity Page");
    }



    public void checkPaymentMessage(){
        logger.info("Check message from Payment provider ...!");
        if(isNewhousePayment)
           StringUtils.contains(TestUtil.getWebElementText(findElements(By.cssSelector("#receipt p")).get(0)),"OP-");
        else
        WaitTool.waitForTextPresent(getWebDriver(), By.cssSelector(".pay-main-box label") , paymentSuccessMessage,
                SALESFORCE_WAIT_LONG, false);
        /*try {
            waitForElementCondition(ExpectedConditions.textToBe(By.cssSelector(".pay-main-box label"), paymentSuccessMessage), getWebDriver(), SALESFORCE_WAIT_LONG);
            //AssertHelper.assertStringContains(getText(findElement(By.cssSelector(".pay-main-box label"))),  paymentSuccessMessage,"Payment FAILED ...!");
        }catch (Exception e){
            failTest("Expected Payment message  is not present ...!["+paymentSuccessMessage+"] "+e.getMessage());
        }*/
    }
    public void checkPaymentMessageWORLDPAY() {
        logger.info("Check message from Payment provider ...!");
        WaitTool.waitForTextPresent(getWebDriver(), By.cssSelector("#paymentResult h2"), paymentSuccessMsgWorldPay,
                SALESFORCE_WAIT_LONG, false);
    }

    /**
     * WaitforAlert
     * @param waitTimeSec
     */

    public void alertAccept(int waitTimeSec){
        boolean presentFlag = false;
        int i = 0;

        while(i++ < waitTimeSec) {
            try {
                alert = getWebDriver().switchTo().alert();
                presentFlag=true;
                break;
            }
            catch (NoAlertPresentException e){
                logger.error("NoAlertPresentException : "+e.getMessage());
                sleep(1000);
            }
            catch (WebDriverException e){
                logger.error("WebDriverException : "+e.getMessage());
                sleep(1000);
            }
            catch (Exception e){
                logger.error("WebDriverException : "+e.getMessage());
                sleep(1000);
            }
        }

        if(presentFlag) {
            logger.info("presentFlag is true, Alert text is :"+alert.getText());
            sleep(500);
            alert.accept();
            logger.info("Alert Accepted");
        }else{
            failTest("No Alert Present....Waited for "+waitTimeSec + "seconds");
        }
    }

    public void selectDate(WebElement dateWe)  {
        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date2 = new Date();
        String today = dateFormat2.format(date2);
        logger.info(today);
        click(dateWe);
        //find the calendar
        WebElement dateWidget = getWebDriver().findElement(By.id("datePicker"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns)  {
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
    }

    public void switchToParentFrame(WebDriver driver) {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Failed to Switch to Parent Frame");
        }
    }

    public void enterEmail(WebDriver driver,String leadRecordType){
        UniqueDataObject udo = new UniqueDataObject(leadRecordType);
        WebElement we =  findElement(By.name("lea11"));
        WebElementHelper.sendKeys(driver, we, udo.getEmail(), false);
        logger.info("(email) : " + udo.getEmail());
        leadEmail=udo.getEmail();
        setUserEmail(udo.getEmail());
    }

    protected void clickSubmitAndClose(){
        logger.info("clickPayAndClose");
        payment = new PaymentSalesForcePage(getWebDriver(),10);
        //payment.payBtn.click();
        click(payment.submitBtn);
        checkPaymentMessage();
        getWebDriver().close();
//        switchToParentFrame(getWebDriver());
//        click(payment.closeBtn);
        logger.info("Payment details entered successfully and now back to Opportunity Page");
    }

    protected void clickContinueAndCloseWorldPay(){
        logger.info("clickPayAndClose");
        //click(payment.continue1Btn);
       // click(payment.continue2Btn);
        click(payment.makePaymentBtn);
        checkPaymentMessageWORLDPAY();
       // switchToParentFrame(getWebDriver());
       // click(payment.closeBtn);
        getWebDriver().close();
        logger.info("Payment details entered successfully and now back to Opportunity Page");
    }

    protected void clickSubmitAndClosePayU(){
        logger.info(("click on submit button of PayU"));
        WebElement payUBtn = findElement(By.cssSelector("button[type='submit']"));
        click(payUBtn);
        checkPaymentMessage();
        getWebDriver().close();
//        switchToParentFrame(getWebDriver());
//        click(payment.closeBtn);
        logger.info("Payment details entered successfully and now back to Opportunity Page");
    }

    protected void getUrlsAndcheckActuals(){
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);

        //get account and contact url
        if(isPCI){
            contactUrl = oppoSalesForcePage.getUrlSalesForceVtp(oppoSalesForcePage.oppoDetailLinkPCIWe.get(4),"Contact");
            accountUrl = oppoSalesForcePage.getUrlSalesForceVtp(oppoSalesForcePage.oppoDetailLinkPCIWe.get(3),"Account");
        }
        else{
            contactUrl = oppoSalesForcePage.getUrlSalesForceVtp(oppoSalesForcePage.contactWe,"Contact");
            accountUrl = oppoSalesForcePage.getUrlSalesForceVtp(oppoSalesForcePage.accountWe,"Account");
        }

        oppoUrl = getWebDriver().getCurrentUrl();
        oppoSalesForcePage = new OppoSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        oppoSalesForcePage.verifyActualsCreated();
        actualUrl = TestUtil.getCurrentUrl(getWebDriver());
        logger.info("Actual url is "+actualUrl);

    }

    protected void checkFinanceDetails(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        actualSalesForcePage.financeDetailsCheck();

    }


    protected void checkMappingstatus(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_LONG);
        sleep(4000);
        refresh(getWebDriver());
        //actualSalesForcePage.simpleTest();
        actualSalesForcePage.verifyMappingStatus();

    }

    protected void checkActivationstatus(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        //actualSalesForcePage.simpleTest();
        refresh(getWebDriver());
        actualSalesForcePage.verifyActivationStatus();
   }

    public String getMemberId(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        //actualSalesForcePage.simpleTest();
        memberId=actualSalesForcePage.getMemberId();;
        return memberId;
    }

    public String getEfId(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        //actualSalesForcePage.simpleTest();
        efId=actualSalesForcePage.getEfId();;
        return efId;
    }


    public String getEtownOrderId(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        //actualSalesForcePage.simpleTest();
        orderId=actualSalesForcePage.getEtownOrderId();
        return  orderId;
    }

    public void clickmapStudentBtn()  {
        logger.info(" scrool and click map student ...!");
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        actualSalesForcePage.simpleTest();
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-2000);
        sleep(1000);
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        //JavaScriptHelper.scrollWebElementToView(getWebDriver(),actualSalesForcePage.mapStudentBtnWe.get(0),ElementScreenPosition.TOP,0);
        actualSalesForcePage.clickMapStudent();
    }

    public void mapStudent() {
        logger.info("mapStudent");
        mapStudentPage = new MapStudentPage(getWebDriver(),SALESFORCE_WAIT_LONG);
        mapStudentPage.simpleTest();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(mapStudentPage.createNewBtnWe), getWebDriver(), 120);
        mapStudentPage.clickCreateNewBtn();
        mapStudentPage.enterPasswordFieldsAndClickCreate();
        mapStudentPage = new MapStudentPage(getWebDriver(),SALESFORCE_WAIT_MED);
        //getWebDriver().close();
        mapStudentPage.clickCloseBtn();

    }

    protected void submitApprovalInActulas(){
        logger.info("approveInActulas ...!");
        //send forr approval
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-4000);
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        actualSalesForcePage.clickOnsubmitforApprovalActuals();
        alertAccept(SALESFORCE_WAIT_MED);
        actualUrl=getWebDriver().getCurrentUrl();
        //sleep(3000);
        //approval process as supervisor
        openCurrentActualPageUrl(salesForceSupervisorName);
        actualSalesForcePage.approveInActuals();
        sleep(3000);
    }

    public void clickActivateCourseBtn() {
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-3000);
        //JavaScriptHelper.scrollWebElementToView(getWebDriver(),actualSalesForcePage.mapStudentBtnWe.get(0),ElementScreenPosition.TOP,0);
        actualSalesForcePage.clickActivateCourse();
    }

    public void activateCourse() {
        activateCoursePage = new ActivateCoursePage(getWebDriver(),SALESFORCE_WAIT_MED);
        activateCoursePage.simpleTest();
        activateCoursePage.clickActivateBtn();
    }

    public void openCurrentOpportunityPageUrl(String username){
        logger.info("Login as " + username);
        openSalesForceAndlogin(username,SALESFORCE_PASS);
        logger.info("opening the opportunity url as user  " + username);
        openUrl(getWebDriver(),oppoUrl);
    }

    public void openCurrentActualPageUrl(String username){
        logger.info("Login as " + username);
        openSalesForceAndlogin(username,SALESFORCE_PASS);
        logger.info("opening the actual url as user  " + username);
        openUrl(getWebDriver(),actualUrl);
    }

    public void loginAndOpenUrl(String username,String currentUrl){
        logger.info("Login as " + username);
        openSalesForceAndlogin(username,SALESFORCE_PASS);
        logger.info("opening the url as user  " + username);
        openUrl(getWebDriver(),currentUrl);
    }
    protected void clickOnPaymentRecord(int index){
        logger.info(("clickOnPaymentRecord"));
        actualSalesForcePage=new ActualSalesForcePage(getWebDriver(),40);
        JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
        actualSalesForcePage.clickPaymentRecord(index);
    }
     protected void verifyPaymentStatus(String status){
        paymentRecordPage=new PaymentRecordPage(getWebDriver(),SALESFORCE_WAIT_MED);
        paymentRecordPage.verifyPaymentStatus(status);
     }
    protected void checkChargeNowFunction(){
        logger.info("Click on charge now button in Payment Record Page");
        paymentRecordPage = new PaymentRecordPage(getWebDriver(), SALESFORCE_WAIT_MED);
        paymentRecordPage.simpleTest();
        paymentRecordPage.clickChargenowBtn();

        alertAccept(SALESFORCE_WAIT_MED);
        if(isChargeNowShowAlertTwice)
            alertAccept(SALESFORCE_WAIT_MED);
        refresh(getWebDriver());
        paymentRecordPage.verifyPaymentStatus("Collected");
    }

    public void getNoOfInstallments(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(),20);
        noOfInstallments= Integer.parseInt(actualSalesForcePage.noOfInstallmentsWe.get(0).getText());

    }

    public int getNoOfPaymentRecords(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(),20);
        noOfPaymentRecords=  actualSalesForcePage.amountCollectedWe.size();
        logger.info("Number of payment records = "+noOfPaymentRecords);
        return noOfPaymentRecords;

    }


    public String getAmountCollected(int indexofPaymentRecord) {
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), 20);
        return actualSalesForcePage.amountCollectedWe.get(indexofPaymentRecord).getText();
    }

    protected void goToContactPage(){
        oppoSalesForcePage=new OppoSalesForcePage(getWebDriver(),20);
        if(isPCI){
            oppoSalesForcePage.clickPCIContactLink();
            contactUrl=getWebDriver().getCurrentUrl();}
              logger.info("successfully navigated to contact url  " +contactUrl);
    }

//    protected void goToAccountPage(){
//        oppoSalesForcePage=new OppoSalesForcePage(getWebDriver(),20);
//        if(isPCI)
//          //  oppoSalesForcePage.clickVtpAccount();
//        else{
//            oppoSalesForcePage.clickContactLink();}
//        accountUrl=getWebDriver().getCurrentUrl();
//        logger.info("successfully navigated to contact url  " +contactUrl);
//    }


    protected void selectETownStatusAndSave(String status){
        logger.info("Selecting the ETown status");
        contactPage = new ContactPage(getWebDriver(),SALESFORCE_WAIT_MED);
        contactPage.selectETownstatus(status);
        sleep(500);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -1000);
        contactPage.clickSaveOnContact();
        sleep(1000);
        contactPage = new ContactPage(getWebDriver(),SALESFORCE_WAIT_MED);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(contactPage.editWe), getWebDriver(), 120);
    }

    protected void gotoActualAndSelectRetentionRecordType(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(),70);
        click(actualSalesForcePage.newRetentionWeBtn);
        retentionPage=new RetentionPage(getWebDriver(),70);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(retentionPage.retentionRecordDropdownWe), getWebDriver(), 80);
        retentionPage.selectRetentionRecordTypeAndContinue(retentionRecordType);
    }

    protected void selectRetentionType(String retentionType){

        retentionPage=new RetentionPage(getWebDriver(),20);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(retentionPage.retentionTypeWe), getWebDriver(), 70);
        retentionUrl=getWebDriver().getCurrentUrl();
        logger.info("Retention url " +retentionUrl);
        retentionPage.selectRetentionType(retentionType);
        logger.info("Retention type selected successfully");

    }

    protected void selectRetentionOwnerAndStatus(String retentionOwner,String retentionStatus){
        retentionPage=new RetentionPage(getWebDriver(),20);
        retentionPage.selectRetentionOwnerAndRetentionStatus(retentionOwner,retentionStatus);
        logger.info("Retention Owner and status seelctedsuccessfully");
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(retentionPage.saveRetentionWe), getWebDriver(), 45);
        retentionPage.clickSaveRetention();
        logger.info("Retention save successful");
    }

    public String getTodaysDate(){
        Date date = new Date();
        String todayDate= new SimpleDateFormat("dd/MM/yyyy").format(date);
        logger.info(("Today's date is "+todayDate));
        return todayDate;
    }

    public String  addDaysToTodaysDate(int noOfDays,String pattern){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(c.DATE, noOfDays);
        Format formatter = new SimpleDateFormat(pattern);
        String addedDate = formatter.format( c.getTime());
        logger.info("added date is " +addedDate);
        return addedDate;
    }

    //retention helper methods


    protected void enterExtendDetails1AndVerify(){
        retentionPage=new RetentionPage(getWebDriver(),SALESFORCE_WAIT_MED);
        logger.info("fill all fields in extend details page");
        retentionPage.enterExtendDetails();
        assertWebElementText(getWebDriver().findElement(By.id("00N9000000EzLUy_ileinner")), "Technical issues" );

    }

    protected void enterSuspendDetails1AndVerify(){
        retentionPage=new RetentionPage(getWebDriver(),20);
        logger.info("fill all fields in suspend details page");
        retentionPage.enterSuspendDetails(suspendDate,resumeDate);
        logger.info("check refund payment btn is enable");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(retentionPage.refundPaymentBtnWe), getWebDriver(), 120);
        assertWebElementText(retentionPage.suspendReasonInRetentionWe, "S-Sick/Pregnant" );
        logger.info("suspend reason successfully changed");


    }

    protected void clickOnsuspendAndVerifyMsg(){
        logger.info("switch to iframe and click on suspend button");
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        sleep(100);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        sleep(100);
        retentionPage = new RetentionPage(getWebDriver(),60);
        //retentionPage.simpleTest();
        retentionPage.clickOnsuspendBtn();
        String suspendMsg = "Suspend Successfully";
        waitForElementCondition(ExpectedConditions.textToBe(By.className("messageCell"), suspendMsg), getWebDriver(), 150);
        assertWebElementText(retentionPage.msgWe, "Suspend Successfully") ;

    }
    protected void clickOnCancelsuspendBtnAndVerifyMsg() {
        retentionPage = new RetentionPage(getWebDriver(), 20);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        click(retentionPage.cancelSuspendBtnWe);
        String cancelSuspendMsg = "Cancel Suspend Successfully";
        waitForElementCondition(ExpectedConditions.textToBe(By.className("messageCell"), cancelSuspendMsg), getWebDriver(), 120);
        assertWebElementText(retentionPage.msgWe, "Cancel Suspend Successfully") ;
    }

    protected void clickOnResumeBtnAndVerifyMsg() {
        retentionPage = new RetentionPage(getWebDriver(), 20);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        click(retentionPage.resumeBtnWe);
        String resumeMsg = "Resume Successfully";
        waitForElementCondition(ExpectedConditions.textToBe(By.className("messageCell"), resumeMsg), getWebDriver(), 120);
        assertWebElementText(retentionPage.msgWe, "Resume Successfully") ;
    }

    protected void enterCancelDetails1AndVerify(){
        retentionPage=new RetentionPage(getWebDriver(),SALESFORCE_WAIT_MED);
        logger.info("fill all fields for cancellation");
        retentionPage.enterCancellationDetails(cancelStatus,isMarkforCancel);
        logger.info("check refund payment btn is enable");
        retentionPage=new RetentionPage(getWebDriver(),SALESFORCE_WAIT_MED);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(retentionPage.refundPaymentBtnWe), getWebDriver(), 120);
        logger.info("Cancel details entered and saved successfully");
    }


    protected void submitForApproval(){
        logger.info("submitForApproval");
        retentionPage=new RetentionPage(getWebDriver(),20);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(retentionPage.submitForApprovalWe.get(0)), getWebDriver(), 120);
        click(retentionPage.submitForApprovalWe.get(0));
        alertAccept(50);
        logger.info("Successfully sent for approval");

    }

    protected void clickOnCancelAndVerifyMsg() {
        logger.info("switch to iframe and click on cancel course button");
        retentionPage = new RetentionPage(getWebDriver(), 20);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        sleep(100);
        retentionPage.clickOnCancelBtn();
        String cancelMsg = "Cancel Successfully";
        waitForElementCondition(ExpectedConditions.textToBe(By.className("messageCell"), cancelMsg), getWebDriver(), SALESFORCE_WAIT_MED);
        assertWebElementText(retentionPage.msgWe, "Cancel Successfully");


    }

    protected void clickOnCancelBtn() {
        logger.info("switch to iframe and click on cancel course button");
        retentionPage = new RetentionPage(getWebDriver(), 20);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        sleep(100);
        retentionPage.clickOnCancelBtn();
    }



    protected void clickOnUndoCancelAndVerifyMsg() {
        logger.info("switch to iframe and click on cancel course button");
        retentionPage = new RetentionPage(getWebDriver(), 20);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        sleep(100);
        retentionPage.clickUndoCancel();
        //String cancelMsg = "Cancel Successfully";
       // waitForElementCondition(ExpectedConditions.textToBe(By.className("messageCell"), cancelMsg), getWebDriver(), SALESFORCE_WAIT_MED);
        assertWebElementText(retentionPage.msgWe, "Undo Cancellation Successfully");


    }

    protected void clickOnExtendAndVerifyMsg() {
        logger.info("switch to iframe and click on extend button");
        retentionPage = new RetentionPage(getWebDriver(), 20);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
        sleep(100);
        //retentionPage.extendBtnWe.sendKeys(Keys.ENTER);
        retentionPage.click(retentionPage.extendBtnWe);
        String extendMsg = "Extend Successfully";
        waitForElementCondition(ExpectedConditions.textToBe(By.className("messageCell"), extendMsg), getWebDriver(), SALESFORCE_WAIT_MED);
        assertWebElementText(retentionPage.msgWe, "Extend Successfully");


    }
    protected void checkPaymenStatus(String paymentstatus) {
        logger.info("checking payment status in actuals ");
        if((getWebDriver().getCurrentUrl())!=actualUrl)
        openUrl(getWebDriver(),actualUrl);
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), 70);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -2000);
        AssertHelper.assertStringContains(getText(actualSalesForcePage.paymentStatusWe), paymentstatus, "Status not correct  ...!" + actualSalesForcePage.paymentStatusWe.getText());

    }

    protected void checkCancelDate(){
        logger.info("checking checkCancelDate in actuals ");
        if((getWebDriver().getCurrentUrl())!=actualUrl)
            openUrl(getWebDriver(),actualUrl);
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), 70);
        AssertHelper.assertStringContains(getText(actualSalesForcePage.cancellationDateWe), getTodaysDate(), "date not correct  ...!" + actualSalesForcePage.paymentStatusWe.getText());

    }

    protected void detailCheckActualFields_Vtp(){
        actualSalesForcePage = new ActualSalesForcePage(getWebDriver(), 70);
       // AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
        logger.info( actualSalesForcePage.collectedAmountWe.getText() + collectedAmount.substring(1));
        AssertHelper.myAssertThat(getWebDriver(), "payment method incorrect", actualSalesForcePage.paymentMethodWe.getText(), equalToIgnoringCase(paymentMethod), true);
        AssertHelper.myAssertThat(getWebDriver(), "collected amount incorrect", actualSalesForcePage.collectedAmountWe.getText(),equalToIgnoringCase(collectedAmount), true);
        AssertHelper.myAssertThat(getWebDriver(), "course activation date incorrect", actualSalesForcePage.courseActivationDateWe.getText(),equalToIgnoringCase(getTodaysDate()), true);
        sleep(2000);
        clickOnPaymentRecord(0);
        paymentRecordPage=new PaymentRecordPage(getWebDriver(),SALESFORCE_WAIT_MED);
        paymentRecordPage.verifyPaymentStatus("Collected");

    }
    protected  void deleteObject(String objectName){
        logger.info("Get the url to delete the " + objectName);
        String onclickUrl = findElement(By.cssSelector("[id^='topButtonRow'] input[value='Delete']")).getAttribute("onclick");
        String result=onclickUrl.split("/setup")[1].split("',")[0];
        if(SALESFORCE_ENV=="Live"){
            result="https://ap1.salesforce.com/setup"+result;
        }
        else
            result="https:///cs5.salesforce.com/setup"+result;
        URL url=null;
        try {
            url = new URL(result);
        }catch (MalformedURLException e){
            SendMail.sendMail("sherin.ouseph@ef.com", getTodaysDate() +objectName +" Deletion FAILED on LIVE", " Dear Sherin, \n\n " +
                    objectName+" deletion failed on Live sales force. Please login to login.salesforce.com and delete them manually ,\n\n" +
                    "Kind Regards\nSherin\n\n EnglishLive QA Engineer");
            failTest("Incorrect URL---"+objectName+"  DID NOT GET DELETED  "+e.getMessage());


        }
        logger.info("open the url to delete "+url);
        openUrl(getWebDriver(),url.toString());
        logger.info(objectName+ " DELETED ");

    }

    protected void verifyObjectDeletion(String objectName,String urlEndsWith,String selector,int index,String message,String objectUrl ){
        logger.info("Check the current url after deletion ----It should end with salesforce.com/"+urlEndsWith);
        assertIsUrlContaining(urlEndsWith);
        logger.info("Current url is correct");
        logger.info("open url and verify the message  for "+objectName);
        openUrl(getWebDriver(),objectUrl);
        AssertHelper.assertStringContains(getText(findElements(By.cssSelector(selector)).get(0)),message,"Not the expected message");
        logger.info(objectName + "Deleted successfully");
    }


    public String getSalesForceAgentName() {
        return salesForceAgentName;
    }

    public void setSalesForceAgentName(String salesForceAgentName) {
        this.salesForceAgentName = salesForceAgentName;
    }


    /**
     * Salesforce
     * #userNavLabel this store the user logged in username
     * @param usernameId
     * @return
     */
    public String getLoggedinUserName(String usernameId){
        String username = "";
        if(null == usernameId)
            usernameId = "userNavLabel";

        WebElement usernameWe = findElement(By.id(usernameId));

        username = getText(usernameWe);

        return username;
    }

    public void setUserTospecificEmailSF(String email){
        WebElement we =  findElement(By.name("lea11"));
        WebElementHelper.sendKeys(getWebDriver(), we, email, false);
        logger.info("(email) : " + email);
        logger.info("Email : " + email);
        setUserEmail(email);
    }

}
