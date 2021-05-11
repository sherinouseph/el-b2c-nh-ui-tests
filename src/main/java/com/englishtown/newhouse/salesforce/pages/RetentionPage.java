package com.englishtown.newhouse.salesforce.pages;
/**
 * Sherin - 10/11/2017
 * MAp Student Page
 */
import com.englishtown.helpers.*;
import com.englishtown.newhouse.salesforce.enumpack.RetentionType;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


public class RetentionPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(RetentionPage.class);
    public static final String pageUrl = "MapStudentFromActual?id=a00O00";
    protected String passwordTxt = "password";
    public static boolean isEnterInfoForPayment=true;


    @FindBy(id = "p3")
    public WebElement retentionRecordDropdownWe;

    @FindBy(css = ".pbSubsection select")
    public WebElement retentionRecordDropdownPCIWe;

    @FindBy(css = ".pbButtonb [name='save']")
    public WebElement continueWe;

    @FindBy(id = "00N9000000EzaLY")
    public WebElement retentionTypeWe;

    @FindBy(id = "CF00N40000002A7fw")
    public WebElement retentionOwnerWe;

    @FindBy(id = "00N40000002A6u7")
    public WebElement retentionStatuseWe;

    @FindBy(id = "00N9000000EzaLY")
    public WebElement retentioenTypeWe;

    @FindBy(css = ".pbButton [name='save']")
    public WebElement saveRetentionWe;

    @FindBy(name = "submit")
    public List<WebElement> submitForApprovalWe;

    //Extend webelement details

    @FindBy(css = "[id='00N9000000EzO8l_ileinner'] a")
    public WebElement clickUpdateExtendWe;

    @FindBy(id = "j_id0:form:j_id28:j_id33:j_id34:j_id36")
    public WebElement extendDaysWe;

    @FindBy(name = "j_id0:form:j_id28:j_id33:j_id37:j_id39")
    public WebElement extendReasonWe;

    @FindBy(name = "j_id0:form:j_id28:j_id33:j_id41:j_id43")
    public WebElement extendCommentsWe;

    @FindBy(name = "j_id0:form:j_id28:j_id29:j_id30")
    public WebElement extendSaveBtnWe;


    //suspend webelement details
    @FindBy(css = "[id='00N9000000EkhUc_ileinner'] a")
    public WebElement clickUpdateSuspendWe;

    @FindBy(name = "j_id0:form:j_id28:j_id33:j_id34:j_id36")
    public WebElement suspendReasonWe;

    @FindBy(css = ".dateFormat")
    public WebElement suspendOnDateWe;

    @FindBy(id = "j_id0:form:j_id28:j_id33:j_id41:j_id43")
    public WebElement resumeOnDateWe;

    @FindBy(name = "j_id0:form:j_id28:j_id33:j_id44:j_id46")
    public WebElement suspendComments;

    @FindBy(css = ".pbButtonb [value='Save']")
    public WebElement saveSuspendBtnWe;

    @FindBy(css = ".pbButton [name='refund_payment']")
    public WebElement refundPaymentBtnWe;

    @FindBy(id = "00N9000000Ekgix_ileinner")
    public WebElement suspendReasonInRetentionWe;

    @FindBy(css = "input[value='Suspend']")
    public WebElement suspendBtnWe;

    @FindBy(className = "messageCell")
    public WebElement msgWe;

    @FindBy(name = "j_id0:form:pb:j_id31")
    public WebElement cancelSuspendBtnWe;

    @FindBy(name = "j_id0:form:pb:j_id33")
    public WebElement resumeBtnWe;

    @FindBy(name = "j_id0:form:pb:j_id30")
    public WebElement extendBtnWe;


    //cancel retention webelement details
    @FindBy(css = "[id='00N9000000EzO8g_ileinner'] a")
    public WebElement clickUpdateCancelWe;

    @FindBy(css = ".dateFormat")
    public WebElement cancelOnDateWe;

    @FindBy(id = "00N40000002A6ts_ileinner")
    public WebElement cancelInputDateWe;

    @FindBy(id = "j_id0:form:j_id28:j_id33:j_id37:j_id39:0")
    public WebElement cancelTypeWe;

    @FindBy(name = "j_id0:form:j_id28:j_id33:j_id41:j_id43")
    public WebElement cancelReason1We;


    @FindBy(name = "j_id0:form:j_id28:j_id33:j_id46:j_id49:1:j_id51")
    public WebElement cancelReason2We;

    @FindBy(id = "00N40000002A7fm_ilecell")
    public WebElement cancelCommentsWe;

    @FindBy(css = ".buttons.zen [value='OK']")
    public WebElement cancelCommentsOkBtnWe;

    @FindBy(css = ".pbBottomButtons [value='Save']")
    public WebElement savecancelBtnWe;

    @FindBy(id = "00N40000002A6ts_ileinner")
    public WebElement cancelRequestDateWe;

    @FindBy(id = "00N40000002A7uw_ilecell")
    public WebElement cancelStatusWe;

    @FindBy(id = "00N40000002A7uw")
    public WebElement cancelStatusDropdownWe;

    @FindBy(id = "00N40000002AAlY_ilecell")
    public WebElement infoforPaymentWe;

    @FindBy(id = "00N40000002AAlY")
    public WebElement infoforPaymentDropdownWe;

    @FindBy(css = ".pbButton [name='inlineEditSave']")
    public WebElement saveCancelRetentionWe;

    @FindBy(css = "input[value='Undo Cancellation']")
    public WebElement undoCancelWe;


    @FindBy(css = "input[value='Cancel Course']")
    public WebElement cancelBtnWe;


    @FindBy(css = ".pbButton [name='Edit']")
    public WebElement editBtnWe;


    public RetentionPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(retentionTypeWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }

    public void selectRetentionRecordTypeAndContinue(String retentionRecordType){
    WebElementHelper.sendKeys(getWebDriver(),retentionRecordDropdownWe, retentionRecordType,  true);
    click(continueWe);
}

    public void selectRetentionRecordTypeAndContinue_PCI(String retentionRecordType){
        WebElementHelper.sendKeys(getWebDriver(),retentionRecordDropdownPCIWe, retentionRecordType,  true);
        WebElementHelper.selectByValue(getWebDriver(),retentionRecordDropdownPCIWe,retentionRecordType);
        click(continueWe);
    }
    public void selectRetentionType(String retentionType) {
        WebElementHelper.sendKeys(getWebDriver(),retentionTypeWe,retentionType,  true);
    }

    public void selectRetentionOwnerAndRetentionStatus(String retentionOwner,String retentionStatus) {
        WebElementHelper.sendKeys(getWebDriver(),retentionOwnerWe,retentionOwner,  true);
        WebElementHelper.sendKeys(getWebDriver(),retentionStatuseWe,retentionStatus,  true);
    }

    public void clickSaveRetention() {
        click(saveRetentionWe);
    }

    public void clickUndoCancel() {
        logger.info("clickUndoCancel");
        click(undoCancelWe);
    }


    public void enterExtendDetails() {
        logger.info("click on  update link");
        click(clickUpdateExtendWe);
        WebElementHelper.sendKeys(getWebDriver(), extendDaysWe, "10", true);
        sleep(300);
        WebElementHelper.sendKeys(getWebDriver(), extendReasonWe, "Technical issues", true);
        sleep(300);
        WebElementHelper.sendKeys(getWebDriver(), extendCommentsWe, "this is an Extend--Test", true);
        click(extendSaveBtnWe);
        logger.info("Extend details entered and clicked on Save button");
        sleep(300);
    }
    public void enterSuspendDetails(String suspendDate,String resumeDate){
        click(clickUpdateSuspendWe);
        WebElementHelper.sendKeys(getWebDriver(),suspendReasonWe, "Sick/Pregnant",  true);
        WebElement suspendDate1We=getWebDriver().findElement(By.id("j_id0:form:j_id28:j_id33:j_id38:j_id40"));
        WebElementHelper.sendKeys(getWebDriver(), suspendDate1We, suspendDate,  true);
        suspendDate1We.sendKeys(Keys.TAB);
        //List<WebElement> suspendDateWe = getWebDriver().findElements(By.cssSelector(".dateFormat"));
        //click(suspendDateWe.get(0));
        WebElementHelper.sendKeys(getWebDriver(), resumeOnDateWe, resumeDate,  true);
        resumeOnDateWe.sendKeys(Keys.TAB);      //sendKeyWithoutWebElement(KeyEvent.VK_TAB); //weList.get(1).sendKeys(Keys.TAB);
        WebElementHelper.sendKeys(getWebDriver(),suspendComments, "Sick-Test-comments",  true);
        click(saveSuspendBtnWe);
        logger.info("suspend details entered successfully");
    }

    public void clickOnsuspendBtn(){
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(suspendBtnWe), getWebDriver(), 55);
        click(suspendBtnWe); //findElement(By.name("j_id0:form:pb:j_id30")));//!!!!
        logger.info("clicked on suspend button successfully");

    }

    public void clickOnCancelBtn(){
        click(cancelBtnWe); //findElement(By.name("j_id0:form:pb:j_id30")));//!!!!
        logger.info("clicked on Cancel button successfully");

    }

    public void enterCancellationDetails(String cancelStatus,boolean isMarkForCancellation) {
        logger.info("click on cancel update link");
        click(clickUpdateCancelWe);
        if(!isMarkForCancellation)
            click(cancelOnDateWe);
        WebElementHelper.sendKeys(getWebDriver(), cancelReason1We, "Not satisfied with Sales experience", true);
        sleep(400);
       // WaitTool.waitForElementVisibleAndClickable(By.name("j_id0:form:j_id28:j_id33:j_id46:j_id49:1:j_id51"), getWebDriver(), 40);
        click(cancelReason2We);
        sleep(300);
        click(savecancelBtnWe);
        sleep(300);
        logger.info("Cancellation reasons entered successfully");
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 500);
        entercancelStatus(cancelStatus);
        entercancelcomments();
        if(isEnterInfoForPayment)
        enterInfoForPayment();
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -1000);
        click(saveCancelRetentionWe);
        logger.info("Cancel details entered and clicked on Save button");
        sleep(300);
    }
        public void entercancelStatus(String cancelStatus){
        logger.info("Select the cancellation status");
        MyWebDriverAction.doubleClick(getWebDriver(), cancelStatusWe);
        sleep(300);
        WebElementHelper.sendKeys(getWebDriver(), cancelStatusDropdownWe, cancelStatus, true);
        sleep(300);
        logger.info("Status changed successfully");
    }
    public void entercancelcomments() {
        logger.info("entercancelcomments");
        MyWebDriverAction.doubleClick(getWebDriver(), cancelCommentsWe);
        sleep(300);
        WebElementHelper.sendKeys(getWebDriver(), getWebDriver().findElement(By.id("00N40000002A7fm")), "I am cancelling my course because of improper sales experience.This is a Test", false);
        sleep(2000);
        cancelCommentsOkBtnWe.sendKeys(Keys.ENTER);
        logger.info("Cancel comments entered successfully");
    }

    public void enterCancelDate(String cancelDate) {
        logger.info("enterCancelDate");
        MyWebDriverAction.doubleClick(getWebDriver(), cancelInputDateWe);
        WebElementHelper.sendKeys(getWebDriver(), getWebDriver().findElement(By.id("00N40000002A6ts")), cancelDate, true);
    }

    public void enterInfoForPayment(){
        logger.info("enterInfoForPayment");
        MyWebDriverAction.doubleClick(getWebDriver(), infoforPaymentWe);
        sleep(300);
        WebElementHelper.sendKeys(getWebDriver(),infoforPaymentDropdownWe , "Cancelled-In Guarantee", true);
        sleep(300);
        logger.info("Info for payment - selected");
    }



}