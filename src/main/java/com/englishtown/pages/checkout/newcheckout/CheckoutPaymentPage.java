package com.englishtown.pages.checkout.newcheckout;
/**
 * payment page
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.checkout.newcheckout.module.AdyenPaymentModule;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CheckoutPaymentPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(CheckoutPaymentPage.class);
    public static final String upsellUrl = "https://qa-englishlive.ef.com/it-it/buy/upsell/payment/?offerid=31541";
    public AdyenPaymentModule adyenPaymentModule;

    @FindBy(id = "CreditCardNumber")
    public WebElement ccNumber;  //

    @FindBy(id = "CreditCardName")
    public WebElement ccName;

    @FindBy(id = "ExpirationMonth")
    public WebElement ccExpireMonth;

    @FindBy(id = "ExpirationYear")
    public WebElement ccExpireYear;

    @FindBy(id = "CardVerificationCode")
    public WebElement ccVerifyCode;

    @FindBy(id = "CCAuthorized")
    public WebElement CCAuthorizeCheckBox;


    public CheckoutPaymentPage(WebDriver webDriver){
        super(webDriver);
    }
    public CheckoutPaymentPage(WebDriver webDriver, boolean isAdyenPayment) {
        if(isAdyenPayment)
            adyenPaymentModule = new AdyenPaymentModule(webDriver);
    }


    public CheckoutPaymentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CheckoutPaymentPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean simpleTest() {
        logger.info(" simpleTest()");
        return ccExpireMonth.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(ccNumber);
    }
    public String getPageUrl() {
        return upsellUrl;
    }




}
