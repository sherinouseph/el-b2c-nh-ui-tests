package com.englishtown.tests.checkout.common.core;
/**
 *
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.checkout.newcheckout.UpsellPaymentPage;
import com.englishtown.tests.flow.redemption.BaseRedemptionFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;


public class BaseUpsellTest extends BaseRedemptionFlow {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellTest.class);

    protected String redemptionPage;

    @Test
    public void enterRedemptionAndSubmit() {
        WebElementHelper.sendKeys(getWebDriver(),findElement(By.id("redemptionCode")), redemptionCode, false);
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(submitRCcss));
        sleep(1000);
    }

    @Test (dependsOnMethods = {"enterRedemptionAndSubmit"})
    public void enterMemberDetails(){
        logger.info("start enterMemberDetails ....!");
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),35);
        enterFormData(formDataMap);
        enterEmail(getWebDriver(), true);
        sleep(1000);
    }

    @Test (dependsOnMethods = {"enterMemberDetails"})
    public void submitRedemptionMemberForm() {
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(".bs3 .btn"));
        sleep(1000);
    }

    @Test(dependsOnMethods = { "submitRedemptionMemberForm" })
    public void checkRedemptionThankyouPage(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),35);
        checkPaymentThankyouPage();
    }

    @Test(dependsOnMethods = { "checkRedemptionThankyouPage" })
    public void testThankyouPageStateObject(){
        if(BaseRemoteWebDriver.isMobileDevice){
            logger.warn("Is mobile device, Test not run testThankyouPageStateObject()...! ");
        } else {
            assertThankyouPageStateObjectElementsNewCheckout();
            testUtil.takeScreenshot(TestUtil.generateRandomFilename("NewChecoutOffer_" + this.getClass().getSimpleName() + "_"), getWebDriver(), false);
        }
    }

//    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
//    public void is_Event42_thankyouPage() {
//        checkMemberCreationEvent(getWebDriver(), "event42", 30);
//    }
    // .btn.btn-lg

    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    public void openUrlForUpsell() {
        sleep(3000);
        PaymentThankyouPage thankyouPage = new PaymentThankyouPage(getWebDriver()) ;
        //thankyouPage.startLearning.click(); // CQ page does not have the button this is a dami solution
        openUrl(getWebDriver(), upsellDirectUrl );
        sleep(3000);
    }

    @Test (dependsOnMethods = { "openUrlForUpsell" })
    public void remove_pay_validation(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),35);
        UpsellPaymentPage paymentPage = new UpsellPaymentPage(getWebDriver());
        paymentPage.getPageLoadedCondition();
        remove_PaymentValidation();
        JavaScriptHelper.waitForPageLoaded(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT );// WaitTool.DEFAULT_WAIT_4_ELEMENT
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), 10);
    }

    @Test(dependsOnMethods = { "remove_pay_validation" })
    public void enterPayFormData_and_submit() {
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(3000);  }catch(Exception e){}
    }

    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
    public void check_ThankyouPageAgain(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),15);
        checkPaymentThankyouPage();
    }

    @Test(dependsOnMethods = { "check_ThankyouPageAgain" })
    public void isCheckoutFlowTypeUpsellAtThankyouPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }
    @Test(dependsOnMethods = { "isCheckoutFlowTypeUpsellAtThankyouPage" })
    public void click_StartLearning(){
        thankyouPage = new PaymentThankyouPage(getWebDriver()) ;
        thankyouPage.startLearning.click();
        sleep(5000);
    }

    @Test(dependsOnMethods = { "click_StartLearning" })
    public void check_EnrolmentPage() {
        enrolmentPage= PageFactory.initElements(getWebDriver(), EnrolmentPage.class);
        enrolmentPage.simpleTest();
        myAssertThat(getWebDriver(), "Failed, URL does not contains enrollment : url is : " + enrolmentPage.getUrl(),
                waitForUrlContains(this.getWebDriver(), "enrollment", WaitTool.DEFAULT_WAIT_4_ELEMENT), true) ;
    }


}