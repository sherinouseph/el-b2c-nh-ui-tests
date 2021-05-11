package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: Sherin Ouseph
 * Date: 21/3/2019
 *
 * 1. Go to Billing Page
 * Check if Cancel Link is displayed
 * Click on cancel link and check if iscancelmarked is set to true
 * check if resume link is displayed
 * Click on Resume link and check if IsCancelMarked is set to False
 * Check if cancel Link is displayed again
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.account.BillingPage;
import com.englishtown.services.MyHttpClient;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;


public abstract class BaseMarkForCancellationTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseMarkForCancellationTest.class);

    protected String efId;
    protected String cancelLinkStr;
    protected String resumeLinkStr;


    @Test (dependsOnMethods = "goToMyAccountPage")
    public void goToBillingPageFromAccountPageSubNav(){
        myAccountPage.goToBilling();
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        billingPage.getPageLoadedCondition();uncomment these two lines when oliver change the selectors in the billing page
//        billingPage.simpleTest();
    }

    @Test (dependsOnMethods = "goToBillingPageFromAccountPageSubNav")
    public void checkCancelLinkIsDisplayed(){
        logger.info("checkCancelLinkIsDisplayed");
        AssertHelper.assertWebElementDisplayed(billingPage.cancelLinkWe);
    }

    @Test (dependsOnMethods = "checkCancelLinkIsDisplayed")
    public void clickOnCancelLinkAndSelectNoInAlert() {
        logger.info("click on cancel Link ");
        billingPage.clickOnCancelLink();
        logger.info("Dismiss the cancellation Alert");
        sleep(1000);
        WaitTool.dismissAlert(getWebDriver(), 5);
        logger.info("checkCancelLinkIsDisplayed");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(billingPage.cancelLinkWe), cancelLinkStr, "Cancel Link is not displayed in turkish Lang");
    }


    @Test (dependsOnMethods = "checkCancelLinkIsDisplayed")
    public void clickOnCancelLinkAndSelectYesInAlert(){
        logger.info("click on cancel Link ");
        billingPage.clickOnCancelLink();
        logger.info("Accept the cancellation Alert");
        WaitTool.acceptAlert(getWebDriver(), 25);
    }

    @Test (dependsOnMethods = "clickOnCancelLinkAndSelectYesInAlert")
    public void verifyTheCancellation(){
        logger.info("verifyTheCancellation");
        MyHttpClient.getSubscriptionUserStatusNewHouse(getENVIRONMENT(), efId,true);
        AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Active"));
        logger.info("check IsCancelMark value is true");
        AssertHelper.assertThat("IscancelMark is false", String.valueOf(MyHttpClient.isCancelMarked), equalToIgnoringCase("true"));
        logger.info("verifyResumeLinkIsDisplayed ");
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(billingPage.cancelLinkWe),resumeLinkStr,"Resume Link is not displayed in turkish Lang");
    }

    @Test (dependsOnMethods = "verifyTheCancellation")
    public void clickOnResumeLinkAndSelectNoInAlert() {
        logger.info("clickon Resume Link ");
        billingPage.clickOnResumeLink();
        sleep(1000);
        logger.info("Dismiss the Resume Alert");
        WaitTool.dismissAlert(getWebDriver(), 10);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(billingPage.cancelLinkWe), resumeLinkStr, "Resume Link is not displayed in turkish Lang");
    }
    @Test (dependsOnMethods = "clickOnResumeLinkAndSelectNoInAlert")
    public void clickOnResumeLinkAndSelectYesInAlert() {
        logger.info("clickon Resume Link ");
        billingPage.clickOnResumeLink();
        logger.info("Accept the resume Alert");
        WaitTool.acceptAlert(getWebDriver(), 10);
    }

    @Test (dependsOnMethods = "clickOnResumeLinkAndSelectYesInAlert")
    public void verifyResumption(){
        sleep(2000);
        MyHttpClient.getSubscriptionUserStatusNewHouse(getENVIRONMENT(), efId,true);
        AssertHelper.assertThat("Status is wrong", MyHttpClient.status, equalToIgnoringCase("Active"));
        AssertHelper.assertThat("IscancelMark is false", String.valueOf(MyHttpClient.isCancelMarked), equalToIgnoringCase("false"));
        logger.info("verifyCancelLinkIsDisplayed ");
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("[class^='cancel-link_']"),getWebDriver(),40);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(billingPage.cancelLinkWe),cancelLinkStr,"Cancel Link is not displayed in turkish Lang");

    }

}

