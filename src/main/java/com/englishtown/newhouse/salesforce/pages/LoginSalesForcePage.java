package com.englishtown.newhouse.salesforce.pages;
/**
 *
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


public class LoginSalesForcePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(LoginSalesForcePage.class);
    public static final String loginpageUrl = "test.salesforce.com";  //TODO this should be dynamic


    @FindBy(id = "username")
    public WebElement usernameWe;

    @FindBy(id = "password")
    public WebElement passWe;

    @FindBy(id = "Login")
    public WebElement loginWe;

    public LoginSalesForcePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest()....!");
        AssertHelper.assertWebElementDisplayed(loginWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(loginWe);
    }

    public String getPageUrl() {
        return loginpageUrl;
    }

    public void login(String usernameTxt, String passTxt){
        WebElementHelper.sendKeys(getWebDriver(), usernameWe, usernameTxt, false );
        WebElementHelper.sendKeys(getWebDriver(), passWe, passTxt, false );
        click(loginWe);
    }

}