package com.englishtown.tests.core.common;
/**
 * BasePaymentPage TEst
 * remove Validation
 * Enter Payment details
 * Submit it
 *
 */

import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCCpaymentPage extends BaseOnlyOneOfferPage{
    private static final Logger logger = LoggerFactory.getLogger(BaseCCpaymentPage.class);

    @Test(priority=2,dependsOnMethods="checkOfferIdAndPriceOnPaymentPage")
    public void remove_pay_validation(){
        remove_PaymentValidation();
        JavaScriptHelper.waitForPageLoaded(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25 );// WaitTool.DEFAULT_WAIT_4_ELEMENT
    }

    @Test(dependsOnMethods = { "remove_pay_validation" })
    public void enterPayFormData_and_submit() {
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(1000);  }catch(Exception e){}
    }



}


