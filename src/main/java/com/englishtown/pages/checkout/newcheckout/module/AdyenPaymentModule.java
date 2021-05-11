package com.englishtown.pages.checkout.newcheckout.module;
/**
 * Sherin - 02/10/2019
 * Adyen Payment Module
 * https://qa-englishlive.ef.com/it-it
 *

 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.Keys.TAB;

public class AdyenPaymentModule extends BasePage {
    public static final Logger logger = LoggerFactory.getLogger(AdyenPaymentModule.class);
    public static final String pageUrl = "/buy/adyen/payment/";
    boolean isEnabled;




    @FindBy(id = "encryptedCardNumber")
    public WebElement cardNumberWe;

    @FindBy(id = "encryptedExpiryDate")
    public WebElement expiryDateWe;

    @FindBy(id = "encryptedSecurityCode")
    public WebElement cvvWe;

    @FindBy(css = ".chckt-pm__name.js-chckt-pm__name")
    public WebElement cardTypeWe;

    @FindBy(css = ".chckt-pm__image")
    public WebElement cardNameWe;

//    @FindBy(css = ".chckt-pm__radio-button")
//    public WebElement radioBtnWe;

    @FindBy(css = ".chckt-button--disabled")
    public WebElement payBtnDisabledWe;

    @FindBy(css = ".js-chckt-button--submit")
    public WebElement payBtnEnabledWe;

    @FindBy(css = ".headup svg")//stored-payment-details svg
    public WebElement padLockIconWe;

    @FindBy(css = ".headup-note")//stored-method-note
    public WebElement storedInfoTxtWe;


    List <WebElement> iframes=getWebDriver().findElements(By.cssSelector(".js-iframe"));
    public AdyenPaymentModule(WebDriver webDriver) {
        super(webDriver);
    }
    public AdyenPaymentModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public AdyenPaymentModule(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public AdyenPaymentModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public boolean checkAllPageComponentsDisplayed() {
        return checkAllPageComponentsDisplayed( cardNameWe,
                cardTypeWe, padLockIconWe,storedInfoTxtWe);
    }

    public boolean simpleTest() {
        logger.info("check is Displayed...!");
        AssertHelper.assertWebElementDisplayed(cardNumberWe);
        return true;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(expiryDateWe);
    }

    public void enterCardDetails(String cardNumber,String expiryDate,String cvv){
        logger.info("enterCardDetails");
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        enterCvv(cvv);
        logger.info("Card Detaisl entered successfully");
    }

    public void enterCardNumber(String cardNumber){
        logger.info("enterCardNumber");
        switchToFrame(getWebDriver(),iframes.get(0));
        WebElementHelper.clearAndsendKeys(getWebDriver(),cardNumberWe,cardNumber,false);
        WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
    }

    public void enterExpiryDate(String expiryDate){
        logger.info("enterExpiryDate");
        switchToFrame(getWebDriver(),iframes.get(1));
        WebElementHelper.clearAndsendKeys(getWebDriver(),expiryDateWe,expiryDate,false);
        WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
    }
    public void enterCvv(String cVV){
        logger.info("enterCvv");
        switchToFrame(getWebDriver(),iframes.get(2));
        WebElementHelper.clearAndsendKeys(getWebDriver(),cvvWe,cVV,false);
        WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
    }
//
//    public String  getErrorMessage_CCNumber(){
//        logger.info("getErrorMessage_CCNumber");
//        return TestUtil.getWebElementText(getWebDriver(),invalidCCNumberCSS);
//    }
//
//    public String  getErrorMessage_expiryMonth(){
//        logger.info("getErrorMessage_expiryMonth");
//        return TestUtil.getWebElementText(getWebDriver(),invalidExPiryMonthCSS);
//
//    }
//
//    public String  getErrorMessage_CVV(){
//        logger.info("getErrorMessage_CVV");
//        return TestUtil.getWebElementText(getWebDriver(),invalidCVVCSS);
//
//    }

    public void clickPayBtn(){
        logger.info("click on Pay Btn");
        click(payBtnEnabledWe);
    }

    public void  checkIfPayBtnDisabled(){
        logger.info("check if the Pay Btn is disabled");
        AssertHelper.assertWebElementDisplayed(payBtnDisabledWe);
    }

    public void  checkIfPayBtnisEnabled(){
        logger.info("check if the Pay Btn is enabled");
        AssertHelper.assertWebElementDisplayed(payBtnEnabledWe);
    }

    public String getPageUrl(){
        return pageUrl;
    }

    public  void switchToFrame(WebDriver driver,WebElement webElement){

        if(webElement !=null){
            logger.info("\tframe element found time :"+ System.currentTimeMillis());
            driver.switchTo().frame(webElement);
            logger.info("\ttime after switch to :"+ System.currentTimeMillis());
        }else
            BasePage.failTest("Can Not Switch to Frame using frame Element ["+webElement+"]");
    }


}
