package com.englishlive.tests.checkout.newcheckout.core.worldpay.core;
/**
 *
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public abstract class BaseWorldPayTest extends BaseWorldPay {
    private static final Logger logger = LoggerFactory.getLogger(BaseWorldPayTest.class);


    @Test
    public void enterMemberDetails(){
        logger.info("start enterMemberDetails ....!");
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), 25);
        enterFormData(formDataMap);
        setUserEmail(formDataMap.get("email").toString());
    }
    @Test(dependsOnMethods = { "enterMemberDetails" })
    public void isDefaultFlowType(){
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }
    @Test(dependsOnMethods = { "isDefaultFlowType" })
    public void submitMemberForm() {
        click(getWebDriver(), By.id("form_button") );
    }

    @Test(dependsOnMethods = { "submitMemberForm" })
    protected void verifyPaymentPageTrackingDotEvents(){
        sleep(3000);
        assertPaymentPageTrackingEvents();
    }

    @Test(dependsOnMethods = { "verifyPaymentPageTrackingDotEvents" })
    public void is_Event2_paymentPage() {
        checkMemberCreationEvent(getWebDriver(), "event2", 60);
    }

    @Test(dependsOnMethods = {"is_Event2_paymentPage"})
    public void clickTabAndSwitchFrame(){
        clickPayTabAndSwitchFrame(creditCardLinkText, payFrameId, By.cssSelector(iFrameSelector), 10 );
    }

    @Test(dependsOnMethods = {"clickTabAndSwitchFrame"})
    public void enterPaymentDetails(){
        logger.info("start enterPaymentDetails ....!");
        enterFormData(paymentCardDetails);
    }

    @Test(dependsOnMethods = {"enterPaymentDetails"})
    public void submitPayment(){
        logger.info("start submitPayment ....!");
        click(getWebDriver(), By.id(SUBMMIT_PAYMENNT_ID));
        sleep(7000);
    }

    @Test(dependsOnMethods = { "submitPayment" })
    public void isDefaultFlowTypeAndTrackingAndMemberIdAndOfferIdAtTyPage(){
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
        if(BaseRemoteWebDriver.isMobileDevice){
            logger.warn("Is mobile device, Test not run testThankyouPageStateObject()...! ");
        } else {
            assertThankyouPageStateObjectElementsNewCheckout();
            testUtil.takeScreenshot(TestUtil.generateRandomFilename("NewChecoutOffer_" + this.getClass().getSimpleName() + "_"), getWebDriver(), false);
        }
    }

    @Test(dependsOnMethods = { "isDefaultFlowTypeAndTrackingAndMemberIdAndOfferIdAtTyPage" })
    void clickStartLearningAtTyPage(){
        clickStartLearning();
    }

    @Test(dependsOnMethods = { "clickStartLearningAtTyPage" })
    public void checkEnrolmentPage() {
        userIsAtSchool();
    }

    @AfterClass
    public void cancelSubscription(){
        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            cancelUserSubscription(getUserEmail());
        } else {
            logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
        }
    }
}

