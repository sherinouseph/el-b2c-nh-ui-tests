package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Enter LP details and submit; Pay; check thankyou page
 * Base
 */

import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
import com.englishtown.tests.core.common.CommonTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class LPtoCheckoutWithOfferId extends StandardCheckoutFlowTest{
    private static final Logger logger = LoggerFactory.getLogger(LPtoCheckoutWithOfferId.class);
    protected String fullName =  "";
    protected static String formSubmitId = "osformsubmit";
    protected String memberSpinnerCss = ".container-fluid .spinner";

    @Test(priority = 0)
    public void enterLandingFormDetails(){
        enterFormData(this.formDataMap);
    }

    @Test(dependsOnMethods = {"enterLandingFormDetails"} )        // {"setSubmitButtonHrefToNewCheckout"} )
    public void submitFormToNewCheckout(){
        WebElement we = WebElementHelper.safeFindElement(getWebDriver(), By.id(formSubmitId));
        click(we);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = {"submitFormToNewCheckout"})
    public void clickTab(){
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
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
    public void enterPayFormData_and_submit() {
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(2000);  }catch(Exception e){}
    }

    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
    public void check_ThankyouPage(){
        checkPaymentThankyouPage();//thankyouPage, getWebDriver(),"thankyou", WaitTool.MED_WAIT_4_ELEMENT25)
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void checkThankyouPage_offerId(){
        assertStateObjectElementValue("order.offer_id", getOfferId(), true);
    }
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void checkThankyouPage_userMemberId(){
        assertThankyouPageStateObject_userMemberId_NotBlankNorEmpty();
    }


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




//    @Test(dependsOnMethods = {"enterLandingFormDetailsAndSubmit"} )
//    public void setSubmitButtonHrefToNewCheckout(){
//        String TEST_BASE_URL = getBASEURL();
//        String html = "<input id='nextpageNikol' type='hidden' name='nextpage' value='"+TEST_BASE_URL+
//                ".englishtown.fr/buy/default/payment/'/>";
//        logger.info(" set html next page to : "+html);
//        JavaScriptHelper.addDivToForm(getWebDriver(), By.cssSelector("form"), html);
//        sleep(100);
//    }