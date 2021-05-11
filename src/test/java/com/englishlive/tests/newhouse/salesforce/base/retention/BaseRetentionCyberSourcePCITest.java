package com.englishlive.tests.newhouse.salesforce.base.retention;
/**
 * Select the retention record type(europe,Mexico..)
 * Select retention type(cancellation,suspend ..)
 * enter the retention details according to retention type
 * verify if retention is actually created
 * Test flow-Extend->Suspend->cancel Suspend->suspend->resume->cancel
 * Check the isactive flag in the database
 *

 */

import com.englishlive.tests.newhouse.salesforce.base.BaseMapStudentTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.enumpack.RetentionStatus;
import com.englishtown.newhouse.salesforce.enumpack.RetentionType;
import com.englishtown.newhouse.salesforce.pages.PaymentRecordPage;
import com.englishtown.newhouse.salesforce.pages.RetentionPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
/*
import java.awt.*;
import java.awt.event.KeyEvent;*/

public abstract class BaseRetentionCyberSourcePCITest extends BaseMapStudentTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRetentionCyberSourcePCITest.class);


    /**
     * For retention Contact has to be activated
     */


        @Test(dependsOnMethods = "verifyActivationStatusTest")
        public void goToContactAndActivateETownStatus(){
            logger.info("goToContactAndActivateETownStatus");
            openUrl(getWebDriver(),contactUrl);
            JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
            selectETownStatusAndSave("Activated");
            sleep(1000);
            logger.info("Successfully saved the etown status");
        }

        /**
         * Flow to create Extend retention record
         */

        @Test(dependsOnMethods = "goToContactAndActivateETownStatus")
        public void gotoActualAndSelectRetentionRecordTypeTest_extend(){
            logger.info("Open current actual page ");
            sleep(3000);
            openUrl(getWebDriver(), actualUrl);
            JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
            gotoActualAndSelectRetentionRecordType();

        }

        @Test(dependsOnMethods = "gotoActualAndSelectRetentionRecordTypeTest_extend")
        public void enterExtendDetailsAndSubmitForApproval(){
            logger.info("selectExtendRetentionTypeTest , selectRetentionOwnerAndRetentionStatus,enter extend details,submit and verify");
            selectRetentionType(RetentionType.EXTEND.getRetentionType());
            selectRetentionOwnerAndStatus(retentionOwner, RetentionStatus.PENDINGAPPROVAL.getRetentionStatus());
            sleep(1000);
            enterExtendDetails1AndVerify();
            JavaScriptHelper.scrollToXY(getWebDriver(), 0, 800);
            //for extend -you need cancellation status as "None"
            cancelStatus="--None--";
            enterCancelDetails1AndVerify();
            sleep(300);
            retentionUrl= TestUtil.getCurrentUrl(getWebDriver());
            loginAndOpenUrl(salesForceFinanceManager,retentionUrl);
            submitForApproval();
            sleep(1000);
        }

        @Test(dependsOnMethods = "enterExtendDetailsAndSubmitForApproval")
        public void approveRetention_extend(){
            logger.info("approveRetention");
            loginAndOpenUrl(ADMIN_QA,retentionUrl);
            JavaScriptHelper.scrollToXY(getWebDriver(),0,2000);
            approvalProcess();
        }

        @Test(dependsOnMethods ="approveRetention_extend" )
        public void clickExtendBtnAndVerify(){
            logger.info("clickSuspendBtnAndVerify");
            sleep(100);
            clickOnExtendAndVerifyMsg();
           // sleep(100);
            //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
        }

//        /**
//         * Flow to create Suspend retention record and cancel the suspend
//         */
//        @Test(dependsOnMethods = "clickExtendBtnAndVerify")
//        public void goToActualsAndCreateNewRetentionForSuspend(){
//            logger.info("goToActualsAndCreateNewRetentionForSuspend");
//            openUrl(getWebDriver(),actualUrl);
//            JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
//            gotoActualAndSelectRetentionRecordType();
//            selectRetentionType(RetentionType.SUSPEND.getRetentionType());
//            selectRetentionOwnerAndStatus(retentionOwner,RetentionStatus.NOTRETAINED.getRetentionStatus());
//            logger.info("enterSuspendDetails");
//            suspendDate = addDaysToTodaysDate(2,"dd/MM/yyyy");
//            //suspendDate="26/11/2017";
//            resumeDate =addDaysToTodaysDate(10,"dd/MM/yyyy");
//            enterSuspendDetails1AndVerify();
//
//        }
//
//        @Test(dependsOnMethods ="goToActualsAndCreateNewRetentionForSuspend" )
//        public void checkSuspendButtonDisabled(){
//            logger.info("Check if the suspend button is disabled");
//            JavaScriptHelper.scrollToXY(getWebDriver(), 0, 400);
//            sleep(100);
//            WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "06690000005tjeK", 25);
//            sleep(100);
//            retentionPage = new RetentionPage(getWebDriver(),60);
//            //retentionPage.simpleTest();
//            Assert.assertFalse(retentionPage.suspendBtnWe.isEnabled());
//            logger.info("Suspend button is not enabled ");
//            AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
//            //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).getSuspendDate().toString(), suspendDate);
//            getSubscriptioInfo(Integer.parseInt(memberId)).getResumeDate();
//
//            logger.info("Student suspended successfully");
//        }
//
//        //check cancel suspend is working(cancel suspend date will work only if suspend date>today's date.)
//
//        @Test(dependsOnMethods ="checkSuspendButtonDisabled" )
//        public void clickOnCancelsuspendBtnTest(){
//            logger.info("clickOnCancelsuspendBtnTest");
//            refresh(getWebDriver());
//            clickOnCancelsuspendBtnAndVerifyMsg();
//            AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
//            logger.info("Student suspension has been cancelled successfully");
//        }

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
           // AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(false));

            //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).getSuspendDate(),suspendDate);
            logger.info("Student suspended successfully");
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
            //AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(true));
            logger.info("Student Resumed successfully");
        }
        //flow to create cancel retention

        @Test(dependsOnMethods = "clickOnResumeBtnTestAndCheckMsg")
        public void goToActualsAndCreateNewRetention_Cancel(){
            openUrl(getWebDriver(),actualUrl);
            JavaScriptHelper.scrollToXY(getWebDriver(), 0, -300);
            gotoActualAndSelectRetentionRecordType();
            selectRetentionType(RetentionType.CANCELLATION.getRetentionType());
            selectRetentionOwnerAndStatus(retentionOwner,RetentionStatus.PENDINGSUPERVISORAPPROVAL.getRetentionStatus());
        }

        @Test(dependsOnMethods = "goToActualsAndCreateNewRetention_Cancel")
        public void enterCancelDetailsAndsubmitForApproval(){
            logger.info("goToActualsAndCreateNewRetention_Cancel");
            RetentionPage.isEnterInfoForPayment=true;
            cancelStatus="Pending supervisor approval";
            enterCancelDetails1AndVerify();
            retentionUrl=getWebDriver().getCurrentUrl();
            sleep(300);
            loginAndOpenUrl(salesForceFinanceManager,retentionUrl);
            submitForApproval();
            sleep(1000);
        }

        @Test(dependsOnMethods = "enterCancelDetailsAndsubmitForApproval")
        public void approveRetention(){
            logger.info("approveRetention");
            loginAndOpenUrl(ADMIN_QA,retentionUrl);
            JavaScriptHelper.scrollToXY(getWebDriver(),0,2000);
            approvalProcess();
            sleep(2000);
            refresh(getWebDriver());
            approvalProcess();
            refresh(getWebDriver());
            sleep(2000);
        }

        @Test(dependsOnMethods ="approveRetention" )
        public void clickCancelCourseBtnAndVerify(){
            logger.info("clickCancelCourseBtnAndVerify");
            clickOnCancelAndVerifyMsg();
           // AssertHelper.assertThat("", getSubscriptioInfo(Integer.parseInt(memberId)).isIsActive(), is(false));
            checkPaymenStatus("Cancelled-In Guarantee");
            JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
            checkCancelDate();
            JavaScriptHelper.scrollToXY(getWebDriver(),0,-1000);
            logger.info("verify payment record status");
            clickOnPaymentRecord(1);
            paymentRecordPage = new PaymentRecordPage(getWebDriver(),SALESFORCE_WAIT_MED);
            paymentRecordPage.verifyPaymentStatus("Cancelled");
        }




    }
