package com.englishtown.pages.cq;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 12/29/2016.
 */
public class CqLoginPage extends CqCorePage {
    public static final Logger logger = LoggerFactory.getLogger(CqLoginPage.class);

    /**
     * Main components
     */
    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;


    @FindBy(id = "submit-button")
    public WebElement loginBtn;

    @FindBy(css = "#error div")
    public WebElement loginFailedMsgWe; // "... don not much"


    public CqLoginPage(WebDriver webDriver){
        super(webDriver);
    }
    public CqLoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqLoginPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(userName);
        AssertHelper.assertWebElementDisplayed(loginBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(loginBtn);
    }

    public void enterCredentials(String usernameTxt, String passwordTxt) {
        enterUserName(usernameTxt);
        enterPassword(passwordTxt);
    }

    public void enterUserName(String usernameTxt) {
        WebElementHelper.clearAndsendKeys(webDriver, userName, usernameTxt, false);
    }
    public void enterPassword( String passwordTxt) {
        WebElementHelper.clearAndsendKeys(webDriver, password, passwordTxt, false);

    }

    public void login() {
        WebElementHelper.click(loginBtn);
    }

    public void enterCredentialsAndClickLogin(String usernameTxt, String passwordTxt) {
        enterCredentials(usernameTxt, passwordTxt);
        login();
    }

}
