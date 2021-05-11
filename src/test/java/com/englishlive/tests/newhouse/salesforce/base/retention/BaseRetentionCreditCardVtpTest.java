package com.englishlive.tests.newhouse.salesforce.base.retention;
/**
 * Select the retention record type(europe,Mexico..)
 * Select retention type(cancellation,suspend ..)
 * enter the retention details according to retention type
 * verify if retention is actually created
 *  * check the status through api
  */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.commerceclient.generated.SubscriptionInfo;
import com.englishtown.helpers.*;
import com.englishtown.newhouse.salesforce.enumpack.RetentionStatus;
import com.englishtown.newhouse.salesforce.enumpack.RetentionType;
import com.englishtown.newhouse.salesforce.pages.PaymentRecordPage;
import com.englishtown.newhouse.salesforce.pages.RetentionPage;
import com.englishtown.services.MyHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;


public abstract class BaseRetentionCreditCardVtpTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRetentionCreditCardVtpTest.class);



    @Test(dependsOnMethods = "getUrlsndVerifyActuals")
    public void goToContactAndActivateETownStatus(){
        logger.info("goToContactAndActivateETownStatus");
        openUrl(getWebDriver(),contactUrl);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        selectETownStatusAndSave("Activated");
        sleep(40);
        logger.info("Successfully saved the etown status");
    }

    /**
     * Flow to create Extend retention record
     */


    @Test(dependsOnMethods = "goToContactAndActivateETownStatus")
    public void gotoActualAndSelectRetentionRecordTypeTest_extend(){
        logger.info("Open current actual page ");
        openUrl(getWebDriver(), actualUrl);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
        gotoActualAndSelectRetentionRecordType();

    }

    @Test(dependsOnMethods = "gotoActualAndSelectRetentionRecordTypeTest_extend")
    public void enterExtendDetailsAndSubmitForApproval(){
        logger.info("selectExtendRetentionTypeTest , selectRetentionOwnerAndRetentionStatus,enter extend details,submit and verify");
        selectRetentionType(RetentionType.EXTEND.getRetentionType());
        selectRetentionOwnerAndStatus(retentionOwner, RetentionStatus.PENDINGAPPROVAL.getRetentionStatus());
        enterExtendDetails1AndVerify();
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 800);
        //for extend -you need cancellation status as "None"
        cancelStatus="--None--";//"Pending Supervision Approval";
        enterCancelDetails1AndVerify();
        sleep(300);
        submitForApproval();
    }

    @Test(dependsOnMethods = "enterExtendDetailsAndSubmitForApproval")
    public void approveRetention_extend(){
        logger.info("approveRetention");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,2000);
        approvalProcess();
    }

    @Test(dependsOnMethods ="approveRetention_extend" )
    public void clickExtendBtnAndVerify(){
        logger.info("clickSuspendBtnAndVerify");
        clickOnExtendAndVerifyMsg();
            //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));

    }
      /**
     * Flow to create Suspend retention record and Resume the Student
     */

    @Test(dependsOnMethods = "clickExtendBtnAndVerify")
    public void goToActualsAndCreateNewRetentionForResumeSuspend() {
        openUrl(getWebDriver(), actualUrl);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
        gotoActualAndSelectRetentionRecordType();
        selectRetentionType(RetentionType.SUSPEND.getRetentionType());
        selectRetentionOwnerAndStatus(retentionOwner, RetentionStatus.NOTRETAINED.getRetentionStatus());
        logger.info("enterSuspendDetails");
        logger.info("enterSuspendDetails_Resume");
        suspendDate = getTodaysDate();
        resumeDate =addDaysToTodaysDate(10,"dd/MM/yyyy");
        enterSuspendDetails1AndVerify();


    }

    @Test(dependsOnMethods ="goToActualsAndCreateNewRetentionForResumeSuspend" )
    public void clickSuspendBtnAndVerify_Resume(){
        logger.info("clickSuspendBtnAndVerify_Resume");
        clickOnsuspendAndVerifyMsg();
        //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(false));
        logger.info("Student suspended successfully");
        if (isNewhousePayment) {
            MyHttpClient.getSubscriptionUserStatusNewHouse("qa", efId,false);
            AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Suspended"));
        }
        retentionUrl=getWebDriver().getCurrentUrl();
    }

    @Test(dependsOnMethods = "clickSuspendBtnAndVerify_Resume")
    public void goToContactAndSuspendETownStatus(){
        logger.info("goToContactAndSuspendETownStatus");
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        openUrl(getWebDriver(),contactUrl);
        selectETownStatusAndSave("Suspended");
        sleep(40);
        logger.info("Successfully saved the etown status");
        openUrl(getWebDriver(),retentionUrl);
    }

    @Test(dependsOnMethods ="goToContactAndSuspendETownStatus" )
    public void clickOnResumeBtnTestAndCheckMsg(){
        logger.info("clickOnResumeBtnTestAndCheckMsg");
        refresh(getWebDriver());
        sleep(300);
        clickOnResumeBtnAndVerifyMsg();
       // AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
        if (isNewhousePayment) {
            MyHttpClient.getSubscriptionUserStatusNewHouse("qa", efId,false);
            AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Active"));
        }
        logger.info("Student Resumed successfully");
    }
          //flow to create cancel retention

    @Test(dependsOnMethods = "clickOnResumeBtnTestAndCheckMsg")
        public void goToActualsAndCreateNewRetention_Cancel(){
        openUrl(getWebDriver(),actualUrl);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
        gotoActualAndSelectRetentionRecordType();
        selectRetentionType(RetentionType.CANCELLATION.getRetentionType());
        selectRetentionOwnerAndStatus(retentionOwner,RetentionStatus.NOTRETAINED.getRetentionStatus());



    }

    @Test(dependsOnMethods = "goToActualsAndCreateNewRetention_Cancel")
    public void enterCancelDetailsAndsubmitForApproval(){
        logger.info("goToActualsAndCreateNewRetention_Cancel");
        cancelStatus="Pending Audit";
        clickOnCancelAndVerifyMsg();
        logger.info("submitCancelRetentionForApproval");
        getWebDriver().switchTo().frame(0);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -4000);
        sleep(300);
        submitForApproval();
    }

    @Test(dependsOnMethods = "enterCancelDetailsAndsubmitForApproval")
    public void approveRetention(){
        logger.info("approveRetention");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,2000);
        approvalProcess();
    }

    @Test(dependsOnMethods ="approveRetention" )
    public void clickCancelCourseBtnAndVerify(){
        logger.info("clickCancelCourseBtnAndVerify");
        clickOnCancelAndVerifyMsg();
        //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(false));
        checkPaymenStatus("Cancelled-In Guarantee");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
        checkCancelDate();
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-1000);
        logger.info("verify payment record status");
        clickOnPaymentRecord(1);
        paymentRecordPage = new PaymentRecordPage(getWebDriver(),SALESFORCE_WAIT_MED);
        paymentRecordPage.verifyPaymentStatus("Cancelled");
        if (isNewhousePayment) {
            MyHttpClient.getSubscriptionUserStatusNewHouse("qa", efId,false);
            AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Inactive"));
        }
    }

    //flow to create mark for cancellation
    @Test(dependsOnMethods = "clickCancelCourseBtnAndVerify")
    public void goToActualsAndCreateCancel2_Retention(){
        openUrl(getWebDriver(),actualUrl);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
        gotoActualAndSelectRetentionRecordType();
        selectRetentionType(RetentionType.CANCELLATION.getRetentionType());
        selectRetentionOwnerAndStatus(retentionOwner,RetentionStatus.NOTRETAINED.getRetentionStatus());
    }

    @Test(dependsOnMethods = "goToActualsAndCreateCancel2_Retention")
    public void enterMarkForCancelDetailsAndsubmitForApproval(){
        logger.info("goToActualsAndCreateNewRetention_Cancel");
        cancelStatus="Pending Audit";
        isMarkforCancel=true;
        cancelDate=addDaysToTodaysDate(5,"dd/MM/yyyy");
         logger.info("cancellation request date is "+cancelDate);
        retentionPage=new RetentionPage(getWebDriver(),45);
        retentionPage.enterCancelDate(cancelDate);
        retentionPage=new RetentionPage(getWebDriver(),40);
        click(retentionPage.saveCancelRetentionWe);
        sleep(2000);
        enterCancelDetails1AndVerify();
        logger.info("submitCancelRetentionForApproval");
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -4000);
        sleep(3000);
        submitForApproval();
    }

    @Test(dependsOnMethods = "enterMarkForCancelDetailsAndsubmitForApproval")
    public void approveRetention_MarkForCancellation(){
        logger.info("approveRetention");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,2000);
        approvalProcess();
    }

    @Test(dependsOnMethods ="approveRetention_MarkForCancellation" )
    public void clickCancelCourseBtn_AndVerifyPaymentStatus(){
        logger.info("clickCancelCourseBtnAndVerify");
        clickOnCancelBtn();
        retentionUrl=getWebDriver().getCurrentUrl();
        //checkPaymenStatus("In Progress");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
        if (isNewhousePayment) {
            MyHttpClient.getSubscriptionUserStatusNewHouse("qa", efId,true);
            AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Active"));
        }
    }

    @Test(dependsOnMethods ="clickCancelCourseBtn_AndVerifyPaymentStatus" )
    public void clickUndoCancelBtn_AndVerify(){
        logger.info("clickCancelCourseBtnAndVerify");
        openUrl(getWebDriver(),retentionUrl);
        clickOnUndoCancelAndVerifyMsg();
        if (isNewhousePayment) {
            MyHttpClient.getSubscriptionUserStatusNewHouse("qa", efId,true);
            AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Active"));
        }
    }


    /**
     * Flow to create Suspend retention record and cancel the suspend
     */
//    @Test(dependsOnMethods = "goToContactAndActivateETownStatus")
//    public void goToActualsAndCreateNewRetentionForSuspend(){
//        logger.info("goToActualsAndCreateNewRetentionForSuspend");
//        openUrl(getWebDriver(),actualUrl);
//        JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
//        gotoActualAndSelectRetentionRecordType();
//        selectRetentionType(RetentionType.SUSPEND.getRetentionType());
//        selectRetentionOwnerAndStatus(retentionOwner,RetentionStatus.NOTRETAINED.getRetentionStatus());
//        logger.info("enterSuspendDetails");
//        // put future date as suspend date and check if the suspend date is inactive
//        suspendDate = addDaysToTodaysDate(2,"dd/MM/yyyy"); // 2
//        resumeDate =addDaysToTodaysDate(10,"dd/MM/yyyy");
//        enterSuspendDetails1AndVerify();
//    }

//    @Test(dependsOnMethods ="goToActualsAndCreateNewRetentionForSuspend" )
//    public void checkSuspendButtonDisabled(){
//        //Note: if the suspension date is in the future the suspend Button is inactive as new logic is in place now -- Minlin advised
//        logger.info("Check if the suspend button is disabled");
//        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
//        sleep(100);
//        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
//        sleep(100);
//        retentionPage = new RetentionPage(getWebDriver(),60);
//        //retentionPage.simpleTest();
//        Assert.assertFalse(retentionPage.suspendBtnWe.isEnabled());
//        logger.info("Suspend button is not enabled ");
    //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
    //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).getSuspendDate().toString(), suspendDate);
    // getSubscriptioInfo(Integer.parseInt(memberId)).getResumeDate();
    //logger.info("Student suspended successfully");
    // }

    //check cancel suspend is working(cancel suspend date will work only if suspend date>today's date.)

//    @Test(dependsOnMethods ="checkSuspendButtonDisabled" )
//    public void clickOnCancelsuspendBtnTest(){
//        logger.info("clickOnCancelsuspendBtnTest");
//        refresh(getWebDriver());
//        clickOnCancelsuspendBtnAndVerifyMsg();
//        AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
//        logger.info("Student suspension has been cancelled successfully");
//    }




}
