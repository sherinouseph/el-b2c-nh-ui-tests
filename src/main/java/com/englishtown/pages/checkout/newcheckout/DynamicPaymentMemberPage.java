package com.englishtown.pages.checkout.newcheckout;

import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Member payment page
 * Date: 27/08/14
 *
 */
public class DynamicPaymentMemberPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(DynamicMemberPage.class);
    public static final String membersPayPageUrl = "/en-gb/buy/default/payment/";  //TODO this should be dynamic
    public WebElement currWebElement;

    @FindBy(className = "login-link")	//@CacheLookup
    public WebElement loginLink;

    @FindBy(name = "ExpirationMonth")
    public WebElement expirationMonth;

    @FindBy(id = "form_button") //"buttons_columnscontrol_column1_button")
    public WebElement confirmPay;

    public DynamicPaymentMemberPage(WebDriver webDriver){                                                               //        this.webDriver = webDriver;//        PageFactory.initElements(new AjaxElementLocatorFactory(getWebDriver(), 30), this);
        super(webDriver);
    }

    public DynamicPaymentMemberPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public DynamicPaymentMemberPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Override
    public boolean simpleTest() {
        logger.info(" simpleTest()");
        return confirmPay.isDisplayed() ;
    }
    @Override
    public ExpectedCondition getPageLoadedCondition() {
        logger.info(" DynPage condition .....");
        return ExpectedConditions.visibilityOf(expirationMonth);
    }
    public String getPageUrl() {
        return membersPayPageUrl;
    }



}
