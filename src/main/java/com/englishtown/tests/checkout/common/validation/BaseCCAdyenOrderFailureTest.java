package com.englishtown.tests.checkout.common.validation;
/**
 * Create member and Check validation messages on pay page
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.CheckoutPaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.core.StringContains.containsString;


public abstract class BaseCCAdyenOrderFailureTest extends BaseCheckoutNegativeTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseCCAdyenOrderFailureTest.class);
    public String invalidCardNumber="411111";
    public String invalidExpiryDate="41";
    public String invalidCvv="41";
    public String errorMessageCss=" .chckt-form-label__error-text";
    public String invalidCCNumberCSS=".chckt-form-label--full-width"+errorMessageCss;
    public String invalidExPiryMonthCSS=".chckt-form-label--exp-date"+errorMessageCss;
    public String invalidCVVCSS=".chckt-form-label--cvc"+errorMessageCss;
    public String paymentRejectedMessage=".message.alert";

    @Test
    public void createMemberTest(){
        create_Member();
    }


    @Test (dependsOnMethods ={"createMemberTest"} )
    public void enterPaymentCardDetails(){
        sleep(2000);
        enter_AdyenPayFormDataAndSubmit(getWebDriver());
    }

//    @Test (dependsOnMethods ={"enterPaymentCardDetails"} )
//    public void enter3DSecurePassAndSubmit(){
//        if(is_adyen3DSecure)
//        enter3DSecurePassAnd_Submit("password");
//    }

    @Test (dependsOnMethods ={"enterPaymentCardDetails"} )
    public void checkOrderFailureMessage(){
        sleep(2000);
        checkOrderFailureMessage(getWebDriver());
    }


    public void checkPayBtnIsDisabled(WebDriver driver){
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(driver,true);
        checkoutPaymentPage.adyenPaymentModule.checkIfPayBtnDisabled();
    }

    public void checkOrderFailureMessage(WebDriver driver){
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"order-creation-failed","Order failure url incorrect");
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(findElements(By.cssSelector(".context-aware-editor-tag-p")).get(2)), containsString(paymentPageValidationMsgBean.getOrderFailureMsg()), false);
    }

}

