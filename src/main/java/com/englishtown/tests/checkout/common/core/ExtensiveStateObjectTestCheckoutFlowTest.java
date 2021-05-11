package com.englishtown.tests.checkout.common.core;
/**
 * Check state Object
 */

import com.englishtown.helpers.CookieHandler;
import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
import com.englishtown.tests.checkout.common.StandardMemberPageTest;
import com.englishtown.tests.checkout.common.StandardPaymentPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.core.IsNull.nullValue;


public abstract class ExtensiveStateObjectTestCheckoutFlowTest extends StandardCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(ExtensiveStateObjectTestCheckoutFlowTest.class);
    protected String currency = "EUR";
    protected static StandardPaymentPageTest paymentPageTest;
    protected static StandardMemberPageTest memberPageTest;

    //Cookie cmus = getCookie("SMus");
    // test 1: if "CMus" is empty, user.member_id should be empty.
    // Test 2 :  if "CMus" is with value, user.member_id should be with the value of member who matches this CMus.
    // call to services : http://www.englishtown.com/services/commerce-v4/membermanager/GetMember


    @Test
    void openMembersPage(){
        logger.info("1...setup .openMemberPage()............ !");
        openMemberPage(memberPageTest);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    @Test   (dependsOnMethods = { "openMembersPage" })
    public void isMemberPageCMusCookieNull(){
        //assertThat("fail CMus cookie is not null when it should be", CookieHandler.getCookie(getWebDriver(),"CMus"), nullValue() );
        myAssertThat(getWebDriver(), "fail CMus cookie is not null when it should be", CookieHandler.getCookie(getWebDriver(), "CMus"), nullValue(), true);
    }
    @Test   (dependsOnMethods = { "isMemberPageCMusCookieNull" })
    public void isMemberIdTypeUsernameEmptyNonExistent(){
        assertMemberPageStateOjectKeysAreEmptyNotNull();
    }

    @Test (dependsOnMethods = { "isMemberIdTypeUsernameEmptyNonExistent" })
    public void testCheckoutFlowGoToPaymentPage(){
        submitMemberPage(paymentPageTest);
        try{Thread.sleep(3000);}catch (Exception e){                    }
    }

    @Test(dependsOnMethods = { "testCheckoutFlowGoToPaymentPage" })
    public void testPayPageStateObject(){
        isCheckoutPaymentStateObject(true);
        assertStateObjectValue("order.phase0.currency", this.currency);
        assertStateObjectValue("order.phase1.currency", this.currency);
    }

    @Test   (dependsOnMethods = { "testPayPageStateObject" })
    public void testPayPageCMusCookieIsNotNullAndContainsChars(){
        CookieHandler.checkCookieNotNull(getWebDriver(), "CMus");
        CookieHandler.checkCookieWithRegx(getWebDriver(), "CMus", MATCH_ANY_CHAR_THREE_OR_MORE_TIMES);
        //Cookie cookie = CookieHandler.getCookie(getWebDriver(), "CMus");
        //assertThat( "fail CMus cookie is not null ", cookie, notNullValue());
        //myAssertThat(getWebDriver(), "Fail CMus cookie is not null ", cookie, notNullValue(), true);
        //assertTrue(cookie.toString().matches(MATCH_ANY_CHAR_THREE_OR_MORE_TIMES), "fail CMus cookie" + cookie.toString() + " does not match " + MATCH_ANY_CHAR_THREE_OR_MORE_TIMES);
        //myAssertThat(getWebDriver(), "Fail CMus cookie" + cookie.toString() + " does not match " + MATCH_ANY_CHAR_THREE_OR_MORE_TIMES, cookie.toString().matches(MATCH_ANY_CHAR_THREE_OR_MORE_TIMES),true  );
    }

    @Test(dependsOnMethods = { "testPayPageCMusCookieIsNotNullAndContainsChars" })
    public void testEnterCreditCardDetailsAndGoToThankyouPage(){
        paymentPageTest = this.getPaymentPageTest(this.getWebDriver());
        enterCreditCardFormDetailsAndCheckThankyouPage(paymentPageTest);
    }

    @Test(dependsOnMethods = { "testEnterCreditCardDetailsAndGoToThankyouPage" })
    public void testThankyouPageStateObjectValues(){
        try{Thread.sleep(3000);}catch (Exception e){}
        assertThankyouPageStateObjectElements();
    }
    @Test(dependsOnMethods = { "testThankyouPageStateObjectValues" })
    public void testThankyouPage_Form_StateObjectValues(){
        assertThankyouPageStateObjectElements();
    }

    @Test   (dependsOnMethods = { "testThankyouPage_Form_StateObjectValues" })
    public void testThankyouPageCMusCookieIsNotNullAndContainsChars(){
        CookieHandler.checkCookieNotNull(getWebDriver(), "CMus");
        CookieHandler.checkCookieWithRegx(getWebDriver(), "CMus", MATCH_ANY_CHAR_THREE_OR_MORE_TIMES);
        //Cookie cookie = getCookie(getWebDriver(), "CMus");
        //assertThat("fail CMus cookie is not null...!", cookie, notNullValue() );
        //assertTrue(cookie.toString().matches( MATCH_ANY_CHAR_THREE_OR_MORE_TIMES ), "fail CMus cookie"+cookie.toString()+" does not match "+MATCH_ANY_CHAR_THREE_OR_MORE_TIMES);
    }



}
