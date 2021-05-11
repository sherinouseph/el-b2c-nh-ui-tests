package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Base
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.services.MyHttpClient;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


public abstract class NewCcBaseCheckoutFlowTest extends NewBaseCheckoutFlow{
    private static final Logger logger = LoggerFactory.getLogger(NewCcBaseCheckoutFlowTest.class);
    //temp
    protected String saOfferId = "?offerId=32305";

    protected boolean isPhoneTextInputShownOnTYpage       = false;
    protected boolean isRunTestPhoneTextCheckPhoneTxtOnTy = false;
    protected boolean isTypePhoneNumberOnTyPage           = false ;   // TR mast enter phone
    protected String confirm=".btn.btn-primary.confirm-button";
    protected boolean cancelSubscription = true;

    @Test(dependsOnMethods = {"clickTab"})
    public void remove_pay_validation(){
        if(isDDpay){
            //not needed
        }else {
            if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
                remove_PaymentValidation(DriverManager.getDriver());
                sleep(3000);
            } else
                logger.info("No need to remove payment validation as ENV is not LIVE ....!");
        }
    }

    @Test(dependsOnMethods = { "remove_pay_validation" })
    public void testNameOnCardValueMatchesPrevStepEnteredData() {
        if(!is_adyenPayment)
        check_NameOnCardValueMatchesPrevStepEnteredData();
    }

    @Test(dependsOnMethods = { "testNameOnCardValueMatchesPrevStepEnteredData" })
    protected void verifyPaymentPageTrackingDotEvents(){

        assertPaymentPageTrackingEvents();
    }

// todo add test for this on other place
//    // check s.events event42 fired : SAND-2708
//    @Test(dependsOnMethods = { "verifyPaymentPageTrackingDotEvents" })
//    public void is_Event2_paymentPage() {
//        // s.event gone by norman ... checkMemberCreationEvent(getWebDriver(), "event2", 60);
//        logger.info("");
//    }

    @Test(dependsOnMethods = { "verifyPaymentPageTrackingDotEvents" })
    public void isCheckoutFlowTypeDefaultAtPaymentPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
        printUserDateDebug("Member created at pay page ");
    }

    @Test(dependsOnMethods = { "isCheckoutFlowTypeDefaultAtPaymentPage" })
    public void enterPayFormData_and_submit() {
        if(is_adyenPayment){
            enter_AdyenPayFormDataAndSubmit(getWebDriver());
        }else {
        if(isNewhousePayment) {
            uuid = CookieHandler.getUUID(getWebDriver());
            if(StringUtils.isBlank(uuid)){
                logger.warn("Try to get uuid from state object ... as getting cookies on IE 11 has issues ...!");
                uuid = getStateObjectValueWithWait("persistent.accessToken.value", true );

                if(StringUtils.isBlank(uuid))
                    logger.error("\tCan NOT get UUID ....!  DB check will fail ....!");
                try{
                    uuid = uuid.replace("uuid:", "");
                }catch (Exception e){
                    logger.error("Can not replace str uuid ....! "+e.getMessage());
                }
            }
            logger.info("UUID IS [{}]", uuid);
        }

        if(isDDpay){
            enterFormData(ddPayInfoMap);
            failTestPerEnvironment("live", " Fail DD test on live at submit DD form page ...!");
            List<WebElement> submitElementList = WebElementHelper.safeFindListOfElementsPresent(getWebDriver(), By.cssSelector(payDdWeId), 45);
            click(submitElementList.get(0));
            WebElementHelper.safeFindAndClick(getWebDriver(),By.cssSelector(confirm));
        }else {
            enter_PayFormDataAndSubmit();
        }}
        try{Thread.sleep(5000);  }catch(Exception e){} //very slow
    }

    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
    public void enter3DSecurePassAndSubmit(){
        if(is_adyen3DSecure){
            enter3DSecurePassAnd_Submit("password");
        }
    }

    @Test(dependsOnMethods = { "enter3DSecurePassAndSubmit" })
    public void check_ThankyouPage(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),waitTime);
        checkPaymentThankyouPage();
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void testThankyouPageStateObject(){
        if(BaseRemoteWebDriver.isMobileDevice){
            logger.warn("Is mobile device, Test not run testThankyouPageStateObject()...! ");
        }
        else if(checkStateObject) {
            if(isNewhousePayment)
                assertThankyouPageStateObjectElementsNewhouse();
            else
                assertThankyouPageStateObjectElementsNewCheckout();
            }
        else
            logger.warn("Thank you page state object is not checked");

    }

    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    public void isCheckoutFlowTypeDefaultAtThankyouPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }

    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    public void isPhoneTextInputOnTyPage() {
        String telIdcss = "input[name=telephone]";
        if(isRunTestPhoneTextCheckPhoneTxtOnTy) {
            if (isPhoneTextInputShownOnTYpage) {
                logger.info("Form input field for Tel number should be shown ...!");
                waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(telIdcss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
                waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(telIdcss)), getWebDriver(), 10);
                sleep(1000);//waitForElementVisibleAndClick(telIdcss, 25);
                if(isTypePhoneNumberOnTyPage) {
                    logger.info("typing phone number ....!");
                    WebElement phoneWE = findElement(By.cssSelector(telIdcss));
                    sendKey(getWebDriver(), phoneWE, phoneNubmer, false); //todo add phone for each market
                }
            } else {
                logger.info("Form input field for Tel Number should NOT be shown ...!");
                AssertHelper.assertThat("Tel text input field should not be shown ",
                        WaitTool.isElementPresentAndDisplay(getWebDriver(), By.cssSelector(telIdcss)), is(false));
            }
        }else {
            logger.info("No need to check Tel Text input form field here ...!");
        }

    }

    //------------
    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    public void setMemberIdAndMarket_check_memberId_NotNullTest(){
        if(BaseRemoteWebDriver.isMobileDevice){
            logger.warn("Is mobile device, Test not run setMemberIdAndMarket_check_memberId_NotNullTest()...! ");
        } else {

            if (checkStateObject){
                setOrderIdFromStateObj();
                setOfferIdFromStateObj();
                if(isNewhousePayment){
                    setEfIdFromStateObj();
                     myAssertThat(getWebDriver(), " FAILED EFID key'" + EFID_KEY + "' Value is Empty/Null ..! :'" + efId +
                        "'", isNotEmpty_And_isNotBlank(efId), true);}
                else{
                    setMemberIdFromStateObj();
                    myAssertThat(getWebDriver(), " FAILED Member key'" + MEMBERID_KEY + "' Value is Empty/Null ..! :'" + memberId +
                        "'", isNotEmpty_And_isNotBlank(memberId), true);}
            }else
                logger.warn("Not setting member id/Efid  and order id from state object ...!");
        }
    }
//    @Test(dependsOnMethods = { "setUserMemberIdAndMarketTest" })
//    public void StoreUserDataToFile(){
//        logger.info("StoreUserDataToFile ");
//        String line = userEmail+","+memberId+","+getENVIRONMENT()+","+market;
//        ReadWriteToFile.appendAlineToFile(line, BaseRemoteWebDriver.userFilePath);
//    }

    @Test(dependsOnMethods = { "setMemberIdAndMarket_check_memberId_NotNullTest" })
    void check_EFID_StudentId_StoredInDB(){
        if(isNewhousePayment) {
            StudentBean studentBean = new StudentBean();
            studentBean.setUuid(uuid);
            studentBean.setUser_id(efId);
            StudentBean dbStudentBean = StaticBaseApiSpec.getCommerceMember(getENVIRONMENT(), studentBean, 200);

            myAssertThat(null, "EFID not stored in DB ....!", efId, equalToIgnoringCase(dbStudentBean.getUser_id()), false);//StringUtils.isNotBlank(efId), false);
            myAssertThat(null, "getStudent_id not stored in DB or null....!", StringUtils.isNotBlank(dbStudentBean.getStudent_id()), false); //uuid, equalToIgnoringCase(dbStudentBean.getStudent_id()), false);//
        }else
            logger.warn("This is old house so no EFID ....! Test not executed ...!");
    }


    @AfterClass
    public void cancelSubscription(){
        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            if(cancelSubscription) {
                if (isNewhousePayment) {
                    MyHttpClient.cancelOrSuspendSubscriptionNewHouse(getENVIRONMENT(), efId, true);
                } else {
                    logger.info("\t\t memberId :> " + memberId);
                    cancelUserSubscription(getUserEmail());
                }
            }else
                logger.info("Subscription for user {{}} is not canceled 'cancelSubscription is false'...!", getUserEmail());
        } else {
            logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
        }
    }

    @Override
    protected String getPaymentPageUrl() {
        return null;
    }

    @Override
    protected String getThankYouPageUrl() {
        return null;
    }

}


