package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class OppoSalesForcePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(OppoSalesForcePage.class);
    public static final String pageUrl = "/006O0000009";
    String hrefnew="";


    @FindBy(name = "add_product_vtpay")
    public List <WebElement> addProductVtpBtnList;

    @FindBy(name = "add_product")
    public WebElement addProductPciBtn;

//    @FindBy(id = "opp7_ileinner")
//    public WebElement collectedAmountVtpWe;

    @FindBy(css = ".pbButton input[value='Take Payment']" )  //"take_payment_vtf")
    public WebElement takePaymentBtn;

    @FindBy(css ="#CF00N9000000DF60G_ileinner a")
    public WebElement oppoProductWe;

    @FindBy(name = "submit")
    public WebElement submitApprovalBtn;

    @FindBy(id = "00N300000017UzD_ileinner")
    public WebElement opportunityNumberWe;

    @FindBy(css = "#CF00N400000029yFF_ileinner a")
    public WebElement contactWe;

    @FindBy(css = ".dataCol.col02  a")
    public List <WebElement> oppoDetailLinkPCIWe;

    @FindBy(css = "#opp4_ileinner a")
    public WebElement accountWe;

    @FindBy(name = "save")
    public List <WebElement> oppoSaveBtnWe;

    @FindBy(name = "edit")
    public WebElement editBtnWe;

    @FindBy(id = "00N300000017T8g")
    public WebElement emailWe;

    @FindBy(id = "00NO0000003mqyX")
    public WebElement qualityDDMWe;




    public OppoSalesForcePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        //AssertHelper.assertUrlContains(getCurrentUrl(),pageUrl,"Url not correct");
        AssertHelper.assertWebElementDisplayed(takePaymentBtn);
        logger.info("Opportunity number is "+opportunityNumberWe.getText());
        return true;
    }

    public String getPageUrl() {
        return pageUrl;
    }


    public void clickAddProductBtn() {
        click(addProductVtpBtnList.get(0));
        logger.info("Product added successfully");
    }

    public void clickAddProductPciBtn() {
        click(addProductPciBtn);
    }

    public void clickTakePayment(){
        click(takePaymentBtn);
    }

    public void submitforApproval() {
        click(submitApprovalBtn);
    }

    public void approveProduct(){
        logger.info("approveProduct");
        sleep(3000);
        List <WebElement> approveWeList = getWebDriver().findElements(By.partialLinkText("Approve / Reject"));
        scrollToWeAndClick(getWebDriver(), approveWeList.get(0),0,300);
        getWebDriver().findElement(By.id("Comments")).sendKeys("Approved");
        click(getWebDriver().findElement(By.name("goNext")));
    }

    public void verifyProductAdded(String productName){
        AssertHelper.assertStringContains(oppoProductWe.getText(), productName,"Product Present in the Oppo");
    }

    public void selectQuality(String qualityValue){
        logger.info("select Quality value as  "+qualityValue);
       selectDropdownValue(getWebDriver(),qualityDDMWe,qualityValue);
    }
    public void verifyActualsCreated() {
        logger.info("Get and Click on Actual link ");

        WebElement actualLinkWe ;

        if(StringUtils.containsIgnoreCase(getLoggedinUserName(null), "meast")){
            logger.info("Meast user is logged in ...! ");
            actualLinkWe = WaitTool.findElement(getWebDriver(), By.cssSelector(actualCss));                              //// if oman meast MEAST_SALESAGENT_QA    = "b2cauto_Meast_agent@ef.com.qa";
        } else
            actualLinkWe = getWebDriver().findElement(By.partialLinkText("FIN-"));                                       //int lastListWeId = -1;        if( !actualLinksList.isEmpty()) {        lastListWeId = actualLinksList.size() - 1;    logger.info("List of Actuals : lastWeId [{}]", lastListWeId);     } else       failTest("Can not get Actual WE or is empty ....! using ["+ actualCss +"]");

        logger.info("Actual ID is [{}] ..!",TestUtil.getWebElementText(actualLinkWe));

        scrollToWeAndClick(getWebDriver(), actualLinkWe, 0, 200);
        //TODO does this really mean actual is created
        logger.info("Actual successfully created as I could click on the last actual link ...!");
    }

    public void clickContactLink() {
        click(contactWe);
    }

    public void clickPCIContactLink(){

        click(oppoDetailLinkPCIWe.get(4));
    }

    public void clickEditbutton(){

        click(editBtnWe);
    }

    public String getUrlSalesForceVtp(WebElement we,String salesForceObjectName){
        //url=null;
        url="";
        hrefnew="";
        hrefnew = we.getAttribute("href");

        if(StringUtils.equals(salesForceObjectName,"Contact"))
            url=salesForceStartUrl+"apex/OverrideContactView?id"+hrefnew.replace( salesForceStartUrl,"=")+"&sfdc.override=1";
         else
            url=hrefnew;

         logger.info(salesForceObjectName+ " url is  " +url);
        return url;
    }

    public void  addNewOppoDetails(){
        WebElementHelper.sendKeys(getWebDriver(),getWebDriver().findElement(By.id("opp3")),"New OppoName",true);
        WebElementHelper.sendKeys(getWebDriver(),getWebDriver().findElement(By.id("opp11")),"Set Appt",true);
        WebElementHelper.sendKeys(getWebDriver(),getWebDriver().findElement(By.id("00N40000001dWe3")),"Renewal",true);

    }



}