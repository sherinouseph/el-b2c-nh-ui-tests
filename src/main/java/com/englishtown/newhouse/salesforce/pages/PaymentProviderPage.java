package com.englishtown.newhouse.salesforce.pages;
/**
 *
 * PCI payment ...
 * Here they can select the payment Provider [worldpay payu cybersource]
 *
 * Nikol 2017
 * https://c.cs5.visual.force.com/apex/PCIChargeTypeSelection?scontrolCaching=1&id=006O0000009wn30
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class PaymentProviderPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(PaymentProviderPage.class);
    public static final String pageUrl = "https://c.cs5.visual.force.com/apex/PCIChargeTypeSelection?scontrolCaching=1&id=006O0000009wn30";




    @FindBy(id = "imgWorldPay")
    public WebElement imgWorldPayWe;

    @FindBy(id = "imgPayU")
    public WebElement imgPayuWe;

    @FindBy(id = "imgCybersource")
    public WebElement imgCybersourceWe;

    @FindBy(css = "input[value='Continue']")
    public WebElement continueBtnWe;

    @FindBy(css = "input[value='Cancel']")
    public WebElement cancelBtnWe;

    public PaymentProviderPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(imgCybersourceWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(imgCybersourceWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void selectPaymentProvider(String paymentProvider){
        logger.info("Select payment provider :"+paymentProvider);
        //TODO add case
        if(StringUtils.equals(paymentProvider, "worldpay")){
            click(imgWorldPayWe);
        } else if(StringUtils.equals(paymentProvider, "payu")){
            click(imgPayuWe);
        }else if(StringUtils.equals(paymentProvider, "cybersource")){
            click(imgCybersourceWe);
        }else {
            logger.warn("Payment Provider not in the list : "+paymentProvider);
            failTest("Payment provider is not allowed to take payemnt ....!");
        }
    }

    public void clickContinue(){
        click(continueBtnWe);
    }



}