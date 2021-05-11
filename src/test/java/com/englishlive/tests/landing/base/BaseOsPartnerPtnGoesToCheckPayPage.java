package com.englishlive.tests.landing.base;
/**
* Hidden field test for : crt, lng,
* User: nikol.marku
* Date: 01/09/14 .
 *
 *
 *
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;



public abstract class BaseOsPartnerPtnGoesToCheckPayPage extends BaseOsLandingPageHiddenFieldTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOsPartnerPtnGoesToCheckPayPage.class);

    @Test
    void getOsPageAndValidateIt(){
        //assertThat("Url is not valid for this page.", this.getPage().isUrlValidForThisPage(), is(true));
        myAssertThat(getWebDriver(), "Url is not valid for this page.", this.getPage().isUrlValidForThisPage(), true);
    }

    @Test  (dependsOnMethods = { "getOsPageAndValidateIt" })
    void testEtagHiddenFieldIsValueTest(){
        checkOsHiddenFildTest(partnerId, partnerPtnCode, 15);
    }

    @Test (dependsOnMethods = { "testEtagHiddenFieldIsValueTest" })
    public void valid_inputOs_goesToPayment(){
        try{Thread.sleep(1000);}catch (Exception e){}
        validInputSubmissionGoesToPaymentPage(this.getLocalizedTestPhoneNumber())  ;
    }
    @Test (dependsOnMethods = { "valid_inputOs_goesToPayment" })
    void validate_is_paymentFormTest(){
        assertIsPaymentForm("payment"); //validate_is_paymentForm();
    }
    //TODO add test to check the ptn here as well on the session state object
    @Test  (dependsOnMethods = { "validate_is_paymentFormTest" })
    void checkPartnerCodeStateObjectSessionValueTest(){
        assertStateObjectValue("session.partner_code","goes");
    }


}


//    @BeforeClass
//    public void setup(){
//       // localizedTestPhoneNumber = localizedTestPhoneNumber1;
//        logger.info("setup localizedTestPhoneNumber"+localizedTestPhoneNumber);
//    }

