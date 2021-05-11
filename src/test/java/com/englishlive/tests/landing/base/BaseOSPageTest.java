package com.englishlive.tests.landing.base;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseLandingPageTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public abstract class BaseOSPageTest extends BaseLandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOSPageTest.class);


    @Test
    public void valid_inputOs_goesToPayment(){
        try{Thread.sleep(1000);}catch (Exception e){}
        logger.info("localizedTestPhoneNumger : "+this.getLocalizedTestPhoneNumber());
        validInputSubmissionGoesToPaymentPage(this.getLocalizedTestPhoneNumber());
        try{Thread.sleep(5000);}catch (Exception e){}
    }
    @Test (dependsOnMethods = { "valid_inputOs_goesToPayment" })
    void validate_is_paymentFormTest(){
        assertIsPaymentForm("payment");
    }

    @Test(dependsOnMethods = { "validate_is_paymentFormTest" })
    protected void verifyPaymentPageTrackingDotEvents(){
        assertPaymentPageTrackingEvents();
    }
/* no more 1 jun 2017
    @Test (dependsOnMethods = { "verifyPaymentPageTrackingDotEvents" })
    void isLeadType(){
        logger.info("Check lead type is ["+formLeadTypeValue+"] ; No Check run for Brazil ....");
        // if not brazil do
        if(!StringUtils.equals(getMarket(), "br") ){ // is BR (!isConfirmPassword)
            logger.info(" For brazil there is no lead type on old checkout .... .. using isConfirmPassword ");
            assertStateObjectElementValue(formLeadTypeKey, formLeadTypeValue, false);   // there is type as well ==
        }
    }*/

    public static void isFirstLastNamePersisted(WebDriver webDriver, String scriptGetCCName, String equalTo){
        String fullName =  JavaScriptHelper.executeJavaScript(scriptGetCCName, webDriver, WaitTool.DEFAULT_WAIT_4_ELEMENT);
        logger.info("validate_is_FirstLastNamePersisted() ...fullName is :" + fullName);
        if(fullName!=null) {
            AssertHelper.myAssertThat(webDriver, "FAILED...!, Name not persisted ", fullName, equalTo(equalTo), true); // assertThat("FAILED...!, Name not persisted ", fullName, equalTo(equalTo));
        } else {
            BasePage.failTest(" fullName is null ...!", true);
        }

    }


}



//TODO open this test when new checkout open to all markets
// need to setup full name value on the setup of the test  and remove same test on UK1/2OSPageTest
//    @Test(priority = 5)
//    void validate_is_FirstLastNamePersisted(){
//        String fullName =  BasePage.executeJavaScript(scriptGetCCName, webDriver, 15);
//        logger.info("validate_is_FirstLastNamePersisted() ...fullName is :"+fullName);
//        assertTrue(fullName.equals(this.FULL_NAME), "FAILED :" + fullName + " NOT equal to : " + FULL_NAME);
//    }







