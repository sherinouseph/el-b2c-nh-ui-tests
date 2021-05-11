package com.englishlive.tests.landing.base;
/**
* Hidden field test for : ptn
* User: nikol.marku
* Date: 01/09/14 .
 *
 * TODO - 1- submit emty ptn should progress to next page as empty ""
 * TODO - 2- submit ptn code should progress to next page as the code entered
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class BasePartnerEmptyPtnGoesToPayTest extends BaseOsLandingPageHiddenFieldTest {
    private static final Logger logger = LoggerFactory.getLogger(BasePartnerEmptyPtnGoesToPayTest.class);

    @Test
    void getOsPageAndValidateIt(){
        myAssertThat(getWebDriver(), "Url is not valid for this page.", this.getPage().isUrlValidForThisPage(), true);
    }

    @Test  (dependsOnMethods = { "getOsPageAndValidateIt" })
    void testEtagHiddenFieldIsNoneValueTest(){
        checkOsHiddenFildTest(partnerId, "None", 10);
    }

    @Test (dependsOnMethods = { "testEtagHiddenFieldIsNoneValueTest" })
    public void valid_inputOs_goesToPayment(){
        try{Thread.sleep(2000);}catch (Exception e){}
        validInputSubmissionGoesToPaymentPage(getLocalizedTestPhoneNumber())  ;
    }

    @Test (dependsOnMethods = { "valid_inputOs_goesToPayment" })
    void validate_is_paymentFormTest(){
        assertIsPaymentForm("payment"); //validate_is_paymentForm();
    }

    @Test  (dependsOnMethods = { "validate_is_paymentFormTest" })
    void checkPartnerCodeStateObjectSessionValueOnPayPageTest(){
        assertStateObjectValue("session.partner_code","None");
    }

}
