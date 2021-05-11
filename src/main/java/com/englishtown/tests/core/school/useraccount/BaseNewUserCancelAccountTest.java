//package com.englishtown.tests.core.school.useraccount;
///**
// * Create a new user and cancel the account
// * Nikol March 2018
// *
// *
// */
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebDriverWindowHelper;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.newhouse.school.pages.account.BillingPage;
//import com.englishtown.tests.checkout.common.core.CheckCampusPageTest;
//import com.englishtown.tests.core.school.core.BaseSchoolTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//
//public abstract class BaseNewUserCancelAccountTest extends CheckCampusPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseNewUserCancelAccountTest.class);
//
//    protected BillingPage billingPage;
//
//    @Test(dependsOnMethods = { "checkAtCampusPage" })
//    public void goToBillingPage() {
//        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        BaseSchoolTest.openPageUrl(getWebDriver(), billingPage, getBASEURL()+ BaseSchoolTest.SCHOOL_BASE_DOMAIN);
//        sleep(1000);
//        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        billingPage.getPageLoadedCondition();
//        billingPage.simpleTest();
//    }
//
//    /**
//     * new window shown
//     * /school/cancellation/confirm.aspx
//     */
//    @Test(dependsOnMethods = { "goToBillingPage" })
//    public void clickCancelAccountAndConfirmCancel() {
//        String parentWindow = getWebDriver().getWindowHandle();
//        ///TODO not in new house billingPage.click(billingPage.cancelSubscriptionWe);
//        sleep(1000);
//        waitForElementCondition(ExpectedConditions.numberOfWindowsToBe(2), getWebDriver(),
//                                                                                     WaitTool.DEFAULT_IMPLICIT_WAIT);
//        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
//        currWebElement = findElement(By.className("stv3_btn_m"), WaitTool.MED_WAIT_4_ELEMENT);
//        currWebElement.click();
//        sleep(3000);
//    }
//
//    /**
//     * new tab shown
//     * https://qa-englishlive.ef.com/school/cancellation/surveystep1.aspx
//     */
//    @Test(dependsOnMethods = { "clickCancelAccountAndConfirmCancel" })
//    public void enterReasonAndSubmit() {
//        currWebElement = null;
//        waitForElementCondition(ExpectedConditions.numberOfWindowsToBe(2), getWebDriver(),
//                                                        WaitTool.DEFAULT_IMPLICIT_WAIT);
//        WebDriverWindowHelper.switchToWindowUrl(getWebDriver(),"surveystep1", 10);
//        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.id("sl_reason")), getWebDriver(), 35);
//        WebElementHelper.selectByIndex(getWebDriver(),By.id("sl_reason"), 4);
//        sleep(300);
//        WebElement submitReason = findElement(By.name("sub_reasons"));
//        WebElementHelper.ensureCheckBoxChecked(submitReason);//   click(submitReason); // click to checkthe box
//        sleep(300);
//        sendKey(getWebDriver(), findElement(By.id("tx_comment")), "tired of you", false);
//        waitForElementVisibleAndClick(getWebDriver(), findElements(By.cssSelector("#btn_continue span")).get(1), 15);
//        sleep(200);
//    }
//
//    //Your current Account Status is: Cancelled
//    @Test(dependsOnMethods = { "enterReasonAndSubmit" })
//    public void checkConfirmationPageAccountStatusCancelled() {
//        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector(".stv3_c_cancel_btns .stv3_btn_m")), getWebDriver(), 35);
//
//        WebElement accountStatusWe = findElement(By.id("ctl01_ctl00_main_Content_accountStatus_lbAccountStatus"));
//        assertWebElementText(accountStatusWe, "Cancelled");
//
//        WebElement backToSchoolWe = findElement(By.cssSelector(".stv3_c_cancel_btns .stv3_btn_m"));
//        AssertHelper.assertWebElementDisplayed(backToSchoolWe);
//        backToSchoolWe.click();
//        sleep(200);
//        assertIsUrlContaining(campusUrlContains);
//    }
//}