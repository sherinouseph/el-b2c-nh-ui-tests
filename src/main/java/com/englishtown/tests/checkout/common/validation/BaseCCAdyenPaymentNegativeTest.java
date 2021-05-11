package com.englishtown.tests.checkout.common.validation;
/**
 * Create member and Check validation messages on pay page
 *
 */
import com.englishtown.dataprovider.bin.validation.PaymentPageValidationMsgBean;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.checkout.newcheckout.CheckoutPaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.core.StringContains.containsString;


public abstract class BaseCCAdyenPaymentNegativeTest extends BaseCheckoutNegativeTest implements IPaymentPageNegativeTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseCCAdyenPaymentNegativeTest.class);
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
    public void chekPayBtnIsDisabled(){
        checkPayBtnIsDisabled(getWebDriver());
    }
    @Test (dependsOnMethods ={"chekPayBtnIsDisabled"} )
    public void isCcCardErrorMessageShown(){
        isInvalidCcCard_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isCcCardErrorMessageShown"} )
    public void isInvalidExpiryDateErrorMessageShown(){
        isInvalidExpiryDate_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isInvalidExpiryDateErrorMessageShown"} )
    public void isInvalidCVVErrorMessageShown(){
        isInvalidCVV_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isInvalidCVVErrorMessageShown"} )
    public void enterIncorrectCvvAndPay(){
        enter_AdyenPayFormDataAndSubmit(getWebDriver(),adyenTestCard.getCardNumber(),adyenTestCard.getExpiryDate(),"111");
    }

    @Test (dependsOnMethods ={"enterIncorrectCvvAndPay"} )
    public void enter3DSecurePassAndSubmit(){
        if(is_adyen3DSecure)
        enter3DSecurePassAnd_Submit("passpass");
    }

    @Test (dependsOnMethods ={"enter3DSecurePassAndSubmit"} )
    public void checkPaymentRejectedMessage(){
                sleep(2000);
        isPaymentRejectedMessageShown();
    }


    public void checkPayBtnIsDisabled(WebDriver driver){
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(driver,true);
        checkoutPaymentPage.adyenPaymentModule.checkIfPayBtnDisabled();
    }

    public void isInvalidCcCard_ErrorMessageShown(){
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(getWebDriver(),true);
        checkoutPaymentPage.adyenPaymentModule.enterCardNumber(invalidCardNumber);
        click(By.cssSelector(".chckt-pm__radio-button"));
        sleep(500);
        webElement = findElement(By.cssSelector(invalidCCNumberCSS));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getCardnumber_validationMsg()), false);
    }

    public void isInvalidExpiryDate_ErrorMessageShown(){
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(getWebDriver(),true);
        checkoutPaymentPage.adyenPaymentModule.enterExpiryDate(invalidExpiryDate);
        click(By.cssSelector(".chckt-pm__radio-button"));
        sleep(500);
        webElement = findElement(By.cssSelector(invalidExPiryMonthCSS));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getExpiryDateValidationMsg()), false);
    }

    public void isInvalidCVV_ErrorMessageShown(){
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(getWebDriver(),true);
        checkoutPaymentPage.adyenPaymentModule.enterCvv(invalidCvv);
        click(By.cssSelector(".chckt-pm__radio-button"));
        sleep(500);
        webElement = findElement(By.cssSelector(invalidCVVCSS));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getCode_validationMsg()), false);
    }

    public void isPaymentRejectedMessageShown(){
        webElement = getWebDriver().findElement(By.cssSelector(paymentRejectedMessage));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getPaymentRejected_MSg()), false);
    }

}

