package com.englishtown.pages.checkout.newcheckout;

import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Payment thank you page
 * User: nikol.marku
 * Date: 27/08/14
 *
 */
//https://www.englishtown.com/

public class PaymentThankyouPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(DynamicMemberPage.class);
    public static final String thankyouPageUrl = "/en-gb/buy/default/thankyou/";  //TODO this should be dynamic
    public static final String startLearningCss = ".btn-lg";

    @FindBy(className = "plate")    //.plate 1 - 2 -3
    public WebElement plate;  //

    @FindBy(className = "btn-lg")     //.btn-lg
    public WebElement startLearning;

    @FindBy(css = ".btn.btn-primary")     //.btn-lg
    public WebElement startLearningNewCheckOut;

    public PaymentThankyouPage(WebDriver webDriver){
        super(webDriver);
    }

    public PaymentThankyouPage(WebDriver webDriver, int waitTimeSec){
        super(webDriver, waitTimeSec);
    }

    public PaymentThankyouPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public PaymentThankyouPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean simpleTest(boolean isNewCheckOut) {
        logger.info(" simpleTest()");
        if(isNewCheckOut)
            return startLearningNewCheckOut.isDisplayed();
        else
            return startLearning.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition(boolean isNewCheckOut) {
        if(isNewCheckOut)
            return ExpectedConditions.visibilityOf(startLearningNewCheckOut);
        else
            return ExpectedConditions.visibilityOf(startLearning);
    }

    public String getPageUrl() {
        return thankyouPageUrl;
    }

    public boolean isUrlThankyouPage(String containsMe){
        logger.info("Is thankyou URL ");
        return (getWebDriver().getCurrentUrl().contains(containsMe))  ;
    }



}