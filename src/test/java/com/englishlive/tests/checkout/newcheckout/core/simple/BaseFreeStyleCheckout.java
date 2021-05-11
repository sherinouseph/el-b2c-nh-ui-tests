package com.englishlive.tests.checkout.newcheckout.core.simple;
/**
 * No page object used
 * New liberal check test
 * Each test case should setup buttton selectors; submit etc .... all that change from test to test
 *
 * all test steps in one test class
 *
 * 1. open member page; enter details; [check state object] submit
 * 2. remove pay validation; enter pay details [check state object] and submit
 * 3. check TY page [check state object] [start school is there]
 * NOT covered ... [4. click start school and check next page shown]
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.util.Map;

public abstract class BaseFreeStyleCheckout extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseFreeStyleCheckout.class);
    @Value("#{applicationPropertiesList['new.checkout.member.ru.ru.url']}")
    protected String testUrl;
    protected Map memberFormMap = null;
    protected Map payFormMap = null;
    protected String submitMemberBtnSelector = "#form_button";


    @Test
    public void enterMemberDetails(){
        logger.info("start enterMemberDetails ....!");
        //setUserEmail(memberFormMap.get("email").toString());
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        enterFormData(memberFormMap);
        enterEmail(getWebDriver(), true);
    }
    /* no more window.s
    @Test(dependsOnMethods = { "enterMemberDetails" })
    public void isTrackingEfEducationFirst_windowDotS(){
        myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }*/

    @Test(dependsOnMethods = { "enterMemberDetails" })
    public void submitMemberForm() {
        submitMembersForm(By.cssSelector(submitMemberBtnSelector));
        sleep(1000);
    }

    @Test(dependsOnMethods = {"submitMemberForm"})
    public void waitForSpinnerNotVisibleAndClickTab(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        if (isClickTabId) {
            WebElementHelper.clickOnTabByLinkText(getWebDriver(), creditCardLinkText) ;
            logger.info(" Tab clicked ...!");
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
    }

    @Test(dependsOnMethods = {"waitForSpinnerNotVisibleAndClickTab"})
    public void remove_pay_validation(){
        sleep(3000);
        remove_PaymentValidation();
        sleep(3000);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT );
    }

    @Test(dependsOnMethods = { "remove_pay_validation" })
    protected void verifyPaymentPageTrackingDotEvents(){
        assertPaymentPageTrackingEvents();
    }

////    // check s.events event42 fired : SAND-2708
//    @Test(dependsOnMethods = { "verifyPaymentPageTrackingDotEvents" })
//    public void is_Event2_paymentPage() {
//        checkMemberCreationEvent(getWebDriver(), "event2", 60);
//    }

    @Test(dependsOnMethods = { "verifyPaymentPageTrackingDotEvents" })
    public void enterPayFormData_and_submit() {
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(5000);  }catch(Exception e){} //very slow
    }

    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
    public void check_ThankyouPage(){
        checkPaymentThankyouPage(thankyouPage, getWebDriver(), urlContainsThankyou, WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void testThankyouPageStateObject(){
        if(BaseRemoteWebDriver.isMobileDevice){
            logger.warn("Is mobile device, Test not run testThankyouPageStateObject()...! ");
        } else {
            assertThankyouPageStateObjectElementsNewCheckout();
            testUtil.takeScreenshot(TestUtil.generateRandomFilename("NewChecoutOffer_" + this.getClass().getSimpleName() + "_"), getWebDriver(), false);
        }
        setMemberIdFromStateObj();
        //setMarketFromStateObj();
    }

    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    public void cancelSubscription(){
        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            cancelUserSubscription(getUserEmail());
        } else {
            logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
        }
    }

//    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
//    public void is_Event42_thankyouPage() {
//        checkMemberCreationEvent(getWebDriver(), "event42", 60);
//    }





    // helpers
    public void submitMembersForm(By byBtn) {
        String deviceName = BaseRemoteWebDriver.currentDeviceName;
        logger.info("Submit member form .... on : "+deviceName);
        try {
            WebElement submit = WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), byBtn, WaitTool.DEFAULT_WAIT_4_ELEMENT);
            if(deviceName !=null){
                if( "NexusOne".contains(deviceName) ) {
                    logger.info("Is mobile Device ipad or nexus one ....");
                    JavaScriptHelper.highlightElement(submit, getWebDriver());
                    MyWebDriverAction.moveToElementAndClick(getWebDriver(), submit);           // does not work for ipad mini
                }if( deviceName.contains("ipad") ) {
                    submit.click();
                } else {
                    logger.info("deviceName does not contains ipad or nexus one. No click done ....");
                }
            }else {
                click(submit);
            }
        }catch (Exception e){
            BasePage.failTest(e, "FAIL submit_MembersForm ...!", true );
        }

    }

}

