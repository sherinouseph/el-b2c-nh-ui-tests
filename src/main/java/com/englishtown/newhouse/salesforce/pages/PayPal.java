package com.englishtown.newhouse.salesforce.pages;
/**
 *PayPal page details
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PayPal extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(PayPal.class);
    public static final String pageUrl = "setup/ui/recordtypeselect.jsp?ent=Lead";


    @FindBy(id = "email")
    public WebElement userNameWe;

    @FindBy(id="password")
    public WebElement passwordWe;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    @FindBy(id="confirmButtonTop")
    public WebElement continueBtn;

    String userName="yangyang.liu-buyer-1@ef.com";
    String password="123123123";

    public PayPal(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(userNameWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }


    public void loginToPayPal() {
        WebElementHelper.sendKeys(getWebDriver(), userNameWe, userName, false);
        WebElementHelper.sendKeys(getWebDriver(), passwordWe, password, false);
        click(loginBtn);
    }

    public void clickContinueBtn(){
        click((continueBtn));
    }

}