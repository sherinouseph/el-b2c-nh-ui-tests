package com.englishtown.pages.checkout.newcheckout;
/**
 * UPsell payment page
 * https://qa-englishlive.ef.com/it-it/buy/upsell/payment/?offerid=31541
 */
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UpsellPaymentPage extends CheckoutPaymentPage {

    public static final Logger logger = LoggerFactory.getLogger(UpsellPaymentPage.class);
    public static final String upsellUrl = "https://qa-englishlive.ef.com/it-it/buy/upsell/payment/?offerid=31541";


    public UpsellPaymentPage(WebDriver webDriver){
        super(webDriver);
    }






}
