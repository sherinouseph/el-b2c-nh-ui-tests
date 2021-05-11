package com.englishtown.newhouse.school.pages.upsell.module;
/**
 * sherin - 04/11/2019
 *
 * This module contains the selectors of the upsell with a stored payment token
 *
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AdyenStoredPaymentModule extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(AdyenStoredPaymentModule.class);
    public static final String pageUrl = "/buy/upsell/upsell/";


    @FindBy(css = ".adyen-token-radio")
    public WebElement radiobtnWe;

    @FindBy(className = "icon-card")
    public WebElement cardTypeWe;

    @FindBy(className = "token-value")
    public WebElement cardNumberWe;

    @FindBy(className = "add-new-card")
    public WebElement modifyCardWe;

    @FindBy(className = "submit")
    public WebElement buyBtnWe;



    public AdyenStoredPaymentModule(WebDriver webDriver){
        super(webDriver);
    }
    public AdyenStoredPaymentModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public AdyenStoredPaymentModule() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(buyBtnWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(buyBtnWe );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(radiobtnWe, cardTypeWe, cardNumberWe, modifyCardWe,buyBtnWe);
        return true;
    }

    public void clickBuyNow(){
        click(buyBtnWe);
        logger.info("Clicked buy now");
    }

     public void clickModifyCardInfo(){
        click(modifyCardWe);
    }

}
