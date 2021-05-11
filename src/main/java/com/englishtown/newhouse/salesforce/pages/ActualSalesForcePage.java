package com.englishtown.newhouse.salesforce.pages;
/**
 * Sherin - 08/11/2017
 * Check the mapping and activation status
 * Check etownorderid and memberId
 */
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

import static com.englishtown.tests.core.BaseTestHelper.refresh;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class ActualSalesForcePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(ActualSalesForcePage.class);
    public static final String pageUrl = "OverrideActualView?id=a00O00";
    protected String cardType;


    @FindBy(id = "00N9000000DHy5Cpage_j_id2_ileinner")
    public WebElement mappingStatusWe;

    @FindBy(id="00N900000020yNfpage_j_id2_ileinner")
    public WebElement activationStatusWe;

    @FindBy(name="pci_map_student")
    public List<WebElement> mapStudentBtnWe;

    @FindBy(name="pci_activate_course")
    public List <WebElement> activateCourseBtnWe;

    @FindBy(id="00N90000007r1wapage_j_id2_ileinner")
    public WebElement memberIdWe;

    @FindBy(id="00NO0000003Pfv8page_j_id2_ileinner")
    public WebElement efIdWe;

    @FindBy(id="00N40000001RFBqpage_j_id2_ileinner")
    public WebElement cancellationDateWe;

    @FindBy(id = "00N40000001QTIKpage_j_id2_ileinner")
    public WebElement paymentStatusWe;

    @FindBy(id = "00N300000017V1Npage_j_id2_ileinner")
    public WebElement paymentMethodWe;

    @FindBy(id = "00N90000001OdBkpage_j_id2_ileinner")
    public WebElement collectedAmountWe;

    @FindBy(id="00N40000001QTIUpage_j_id2_ileinner")
    public WebElement etownOrderIdWe;

    @FindBy(name = "submit")
    public WebElement submitApprovalBtn;

    @FindBy(id = "00N40000001TOHspage_j_id2_ileinner")
    public WebElement courseActivationDateWe;

    @FindBy(name = "update_card_vtf")
    public WebElement updatePaymentBtnVtpWe;

    @FindBy(id = "00N3000000184STpage_j_id2_ileinner")
    public WebElement creditCardTypeWe;

    @FindBy(id = "00N9000000EWJjCpage_j_id2_ileinner")
    public WebElement paymentFlowTokenWe;

    @FindBy(css = ".pbButton input[value='New Retention']")
    public WebElement newRetentionWeBtn;

    //virtual terminal payment
    @FindBy(css="#ep_page_j_id2 tr:nth-child(6) td:last-child")
    public List<WebElement> noOfInstallmentsWe;


    @FindBy(css ="[id^='page_j_id2_a00'] .dataRow td:nth-child(7)")
    public List<WebElement> amountCollectedWe;



    public ActualSalesForcePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(mappingStatusWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }

    public void clickMapStudent() {
        logger.info(" click map student ...!");
        click(mapStudentBtnWe.get(0));
    }
    public void clickUpdatePaymentBtnVtp() {
        click(updatePaymentBtnVtpWe);
        logger.info("Successfully clicked on Update Payment Button");
    }

    public void clickActivateCourse() {
        logger.info("Clicking on Activate button");
        click(activateCourseBtnWe.get(0));
    }


    public void verifyMappingStatus(){
        logger.info("verifyMappingStatus");
        WaitTool.waitForTextPresent(getWebDriver(), By.id("00N9000000DHy5Cpage_j_id2_ileinner") , "Mapped",
                120, false);
        refresh(getWebDriver());
        AssertHelper.myAssertThat(getWebDriver(), "Mapping status is incorrect", mappingStatusWe.getText(), equalToIgnoringCase("Mapped"), true);
        logger.info("Student successfully mapped");
    }

    public void verifyActivationStatus(){
        logger.info("verifyActivationStatus");
        WaitTool.waitForTextPresent(getWebDriver(), By.id("00N900000020yNfpage_j_id2_ileinner") , "Activated",
                120, false);
        refresh(getWebDriver());
        AssertHelper.myAssertThat(getWebDriver(), "Activation status is incorrect",activationStatusWe.getText(), equalToIgnoringCase("Activated"), true);
        logger.info("Activation success");
    }

    public String getMemberId(){
        logger.info("getMemberId");
        String memberId = memberIdWe.getText();
        logger.info("Member Id is "+ memberId);
        return memberId;
    }

    public String getEfId(){
        logger.info("getEfId");
        String efId = efIdWe.getText();
        logger.info("EF Id is "+ efId);
        return efId;


    }

    public String getEtownOrderId(){
        logger.info("getEtownOrderId");
        String eTownOrderId = etownOrderIdWe.getText();
        logger.info("Order Id is "+ eTownOrderId);
        return eTownOrderId;

    }

    public void clickOnsubmitforApprovalActuals() {
        click(submitApprovalBtn);
    }

    public void approveInActuals(){
        logger.info("approveInActuals");
        List <WebElement> approveWeList = getWebDriver().findElements(By.partialLinkText("Approve"));
        //scrollToWeAndClick(getWebDriver(), approveWeList.get(0),0,1000);
        click(approveWeList.get(0));
        getWebDriver().findElement(By.id("Comments")).sendKeys("Approved");
        click(getWebDriver().findElement(By.name("goNext")));
    }

    public void clickPaymentRecord(int index){
        List <WebElement> paymentRecordList = getWebDriver().findElements(By.cssSelector("[id^='page_j_id2_a0'] .dataCell a[href*='a01']"));
        sleep(1000);
        click(paymentRecordList.get(index));
    }

    public String getCardType() {
        logger.info("Check the Card Type");
        return  cardType = creditCardTypeWe.getText();
    }

    public void financeDetailsCheck() {
        logger.info("financeDetailsCheck");
        logger.info("Payment flow token is "+paymentFlowTokenWe.getText());
         Assert.assertNotNull(paymentFlowTokenWe.getText());//payment flow token
         Assert.assertNotNull(getWebDriver().findElement(By.id("00N300000017V1Npage_j_id2_ileinner")).getText());//creditcard number

    }

}