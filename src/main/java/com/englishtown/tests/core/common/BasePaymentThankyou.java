package com.englishtown.tests.core.common;
/**
 * New checkout
 * Base
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class BasePaymentThankyou extends BaseCCpaymentPage{
    private static final Logger logger = LoggerFactory.getLogger(BasePaymentThankyou.class);


    @Test(priority=3,dependsOnMethods="enterPayFormData_and_submit")
    public void check_ThankyouPage(){
        int waitTimeSec = WaitTool.DEFAULT_WAIT_4_ELEMENT;
        myAssertThat(getWebDriver(), "Failed ...!. URL does not contains 'thankyou'...!" +
                ". Seconds Waited for :" +waitTimeSec, PaymentThankyouPage.waitForUrlContains(getWebDriver(), "thankyou", waitTimeSec), true);
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void testThankyouPageStateObject(){
        assertThankyouPageStateObjectElementsNewCheckout();
        testUtil.takeScreenshot(TestUtil.generateRandomFilename("offerCRMthankyouPage"+this.getClass().getSimpleName()+"_"), getWebDriver(), false);
    }


}


