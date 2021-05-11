package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Base
 */

import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
import com.englishtown.tests.core.common.CommonTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class LandingPageToCheckoutFlowTests extends StandardCheckoutFlowTest{
    private static final Logger logger = LoggerFactory.getLogger(LandingPageToCheckoutFlowTests.class);
    protected String fullName =  "";
    protected static String formSubmitId = "osformsubmit"; // default @override  check this it might be

    @Test(priority = 0)
    public void enterLandingFormDetailsAndSubmit(){
        enterFormData(this.formDataMap);
    }

    @Test(dependsOnMethods = {"enterLandingFormDetailsAndSubmit"} )
    public void setSubmitButtonHrefToNewCheckout(){
        String TEST_BASE_URL = getBASEURL();
        String html = "<input id='nextpageNikol' type='hidden' name='nextpage' value='"+TEST_BASE_URL+
                ".englishtown.fr/buy/default/payment/'/>";        //"<input id='nextpageNikol' type='hidden' name='nextpage' value='https://www.englishtown.fr/buy/default/payment/'/>";
        logger.info(" set html next page to : "+html);
        JavaScriptHelper.addDivToForm(getWebDriver(), By.cssSelector("form"), html);
        sleep(100);
    }
    @Test(dependsOnMethods = {"setSubmitButtonHrefToNewCheckout"} )
    public void submitForToNewCheckout(){
        WebElement we = WebElementHelper.safeFindElement(getWebDriver(), By.id(formSubmitId));
        if(we!=null) {
            we.click();
        }else {
            BasePage.failTest(" formSubmitId Web Element is null ...!");
        }
        try{Thread.sleep(2000);}catch (Exception e){e.printStackTrace();}
    }

    @Test(dependsOnMethods = {"submitForToNewCheckout"})
    public void clickTab(){
        if (isClickTabId) {
            WebElementHelper.clickOnTabByLinkText(getWebDriver(), creditCardLinkText) ;
            sleep(1000);
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
    }

    @Test(dependsOnMethods = {"clickTab"})
    public void remove_pay_validation(){
        remove_PaymentValidation();
        sleep(1000);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = { "remove_pay_validation" })
    public void testNameOnCardValueMatchesPrevStepEnteredData() {
        check_NameOnCardValueMatchesPrevStepEnteredData(fullName);
    }

    //test offer
    @Test(dependsOnMethods = { "testNameOnCardValueMatchesPrevStepEnteredData" })
    void isOfferIdRelatedToPcodeTest(){
        logger.info(" Offer id should be :" + this.getOfferId() + "- for pcode :" + getOfferPcode());
        isOfferIdRelatedToPcode("order.offer_id", getOfferId(), true);
    }

    @Test(dependsOnMethods = { "testNameOnCardValueMatchesPrevStepEnteredData" })
    void isExpectedPcodeOnStateObjectTest(){
        logger.info(" Expected PCode on order.couponCode :"+getOfferPcode());
        isExpectedPcodeOnStateObject("order.couponCode", getOfferPcode(), true);
    }

    //thankyou
    @Test(dependsOnMethods = { "isExpectedPcodeOnStateObjectTest" })
    public void enterPayFormData_and_submit() {
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(2000);  }catch(Exception e){}
    }

    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
    public void check_ThankyouPage(){
        checkPaymentThankyouPage();//thankyouPage, getWebDriver(),"thankyou", WaitTool.MED_WAIT_4_ELEMENT25)
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void checkThankyouPage_trakingEvents(){
        assertThankyouPageStateObject_trakingEvents(); //assertThankyouPageStateObjectElementsNewCheckout();
    }
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void checkThankyouPage_offerId(){
        assertStateObjectElementValue("order.offer_id",getOfferId(), false); // assertThankyouPageStateObject_orderOfferId_NotBlankNorEmpty();
    }
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void checkThankyouPage_userMemberId(){
        assertThankyouPageStateObject_userMemberId_NotBlankNorEmpty();
    }

//    @Test(dependsOnMethods = { "check_ThankyouPage" })
//    public void check_memberId_NotNullTest(){
//        assertThat(" FAILED Member key'" + MEMBERID_KEY + "' Value is Empty/Null ..! :'" + memberId + "'",
//                isNotEmpty_And_isNotBlank(memberId));
//    }

    // offer
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    void isOfferCurrencyPersistedTest(){
        logger.info(" isOfferCurrencyPersistedTest.... getOfferCurrency() :"+getOfferCurrency());
        isOrderCurrencyRelatedToPcodeOnTY("order.phase0.currency", getOfferCurrency(), true);
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    void isOfferPricePersistedTest(){
        logger.info(" isOfferCurrencyPersistedTest....getOfferPrice() :"+getOfferPrice());
        isOrderPriceRelatedToPcodeOnTY("order.phase0.price", getOfferPrice(), true);
    }


}



//String html = "<input id='nextpageNikol' type='hidden' name='nextpage' value='https://www.englishtown.fr/buy/default/payment/'/>";    //<input id="ruboid" type="hidden" value="" name="ruboid" class="firefinder-match">        //JavaScriptHelper.replaceHTML(getWebDriver(), By.cssSelector("form #ruboid"), html) ;        //WebElement weNextpage = WaitTool.waitForElementPresent(getWebDriver(), By.cssSelector("input[name='nextpage']"), 3);      //String hidden = getHidenFieldById("nextpage", 3);        //if(StringUtils.isNotBlank(hidden) ) {
//JavaScriptHelper.addDivToForm(getWebDriver(), By.cssSelector("form"), html);

