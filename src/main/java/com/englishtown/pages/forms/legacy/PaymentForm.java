package com.englishtown.pages.forms.legacy;

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentForm extends BaseForm {
    private WebElementHelper<PaymentForm> creditCardSubmitButton;
    private WebElementHelper<PaymentForm> creditCardNumber;
    private WebElementHelper<PaymentForm> creditCardExpirationMonth;
    private WebElementHelper<PaymentForm> creditCardExpirationYear;
    private WebElementHelper<PaymentForm> creditCardVerificationCode;
    private WebElementHelper<PaymentForm> creditCardFirstName;
    private WebElementHelper<PaymentForm> creditCardLastName;
    private WebElementHelper<PaymentForm> creditCardCountry;
    private WebElementHelper<PaymentForm> creditCardAuthorizeUsage; // Terms and conditions agreement

    public PaymentForm(WebDriver webDriver) {
        super(webDriver);
        this.creditCardSubmitButton = this.createHelper(By.id("creditCardSubmit"));
        this.creditCardNumber = this.createHelper(By.name("CreditCardNumber"));
        this.creditCardExpirationMonth = this.createHelper(By.name("ExpirationMonth"));
        this.creditCardExpirationYear = this.createHelper(By.name("ExpirationYear"));
        this.creditCardVerificationCode = this.createHelper(By.name("CardVerificationCode"));
        this.creditCardFirstName = this.createHelper(By.name("CCFirstName"));
        this.creditCardLastName = this.createHelper(By.name("CCLastName"));
        this.creditCardCountry = this.createHelper(By.name("CreditCardCountry"));
        this.creditCardAuthorizeUsage = this.createHelper(By.name("CCAuthorized"));
    }

    public WebElementHelper<PaymentForm> getCreditCardAuthorizeUsage() {
        return creditCardAuthorizeUsage;
    }

    public WebElementHelper<PaymentForm> getCreditCardCountry() {
        return creditCardCountry;
    }

    public WebElementHelper<PaymentForm> getCreditCardLastName() {
        return creditCardLastName;
    }

    public WebElementHelper<PaymentForm> getCreditCardFirstName() {
        return creditCardFirstName;
    }

    public WebElementHelper<PaymentForm> getCreditCardVerificationCode() {
        return creditCardVerificationCode;
    }

    public WebElementHelper<PaymentForm> getCreditCardExpirationYear() {
        return creditCardExpirationYear;
    }

    public WebElementHelper<PaymentForm> getCreditCardExpirationMonth() {
        return creditCardExpirationMonth;
    }

    public WebElementHelper<PaymentForm> getCreditCardNumber() {
        return creditCardNumber;
    }

    public WebElementHelper<PaymentForm> getCreditCardSubmitButton() {
        return creditCardSubmitButton;
    }

    @Override
    public void submit() {
        try{
            Thread.sleep(200);
            this.creditCardSubmitButton.scrollTo();
            this.creditCardSubmitButton.click();
        }catch (Exception e){logger.info(" Exception on Submit : "+e.getCause());}

    }

    @Override
    protected By getFormLocator() {
        return By.id("creditCardForm");
    }
}
