package com.englishtown.pages.schoollite;

import com.englishtown.helpers.*;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class EfIdLoginPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(EfIdLoginPage.class);

    public String relativePageUrl = "/en/ui/login/index.html";


    /**
     * Main components
     */
    @FindBy(id = "email")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form-btn")
    public WebElement loginBtn;

    @FindBy(id = "link-to-reset")
    public WebElement restPassLink;


    public EfIdLoginPage(WebDriver webDriver){
        super(webDriver);
    }
    public EfIdLoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public EfIdLoginPage(WebDriver webDriver, int timeOutSec) {
        super(webDriver, timeOutSec);
    }
    public EfIdLoginPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(userName);
        return true;
    }

    public boolean checkUserNameAndPassTxtDisplayed() {
        AssertHelper.assertWebElementDisplayed(userName);
        AssertHelper.assertWebElementDisplayed(password);
        return true;
    }

    public void checkLoginBtnDisplayed() {
        AssertHelper.assertWebElementDisplayed(loginBtn);
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(userName), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT);
        return ExpectedConditions.visibilityOf(userName); //loginBtn
    }

    public void enterCredentials(String usernameTxt, String passwordTxt) {
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(userName), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(password), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        enterUserName(usernameTxt);
        enterPassword(passwordTxt);
    }

    public void enterUserName(String usernameTxt) {
        WebElementHelper.clearAndsendKeys(webDriver, userName, usernameTxt, false);
    }
    public void enterPassword( String passwordTxt) {
        WebElementHelper.clearAndsendKeys(webDriver, password, passwordTxt, false);

    }

    /**
     * Login by sending submit on username web element
     */
    public void login() {
        WebElementHelper.submit(userName);
    }

    /**
     * Click login button to submit form
     * @param loginBtWe
     */
    public void clickLoginBtn(WebElement loginBtWe){
       WaitTool.waitForElementClickable_fluentWait(getWebDriver(),loginBtWe,5,1000);
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(loginBtWe).perform();
        actions.moveToElement(loginBtWe).click().build().perform();
        //click(loginBtWe);
    }

    public void enterCredentialsAndClickLogin(String usernameTxt, String passwordTxt) {
        enterCredentials(usernameTxt, passwordTxt);
        login();
    }


    public ForgottenPassPage goToForgottenPassPage(){
        WebElementHelper.click(restPassLink);
        //TODO ... new EF id reset pass page need to be defined
        ForgottenPassPage forgottenPassPage = new ForgottenPassPage(getWebDriver());
        forgottenPassPage.getPageLoadedCondition();
        return forgottenPassPage;
    }


    public String getRelativePageUrl() {
        return relativePageUrl;
    }

    public void setRelativePageUrl(String relativePageUrl) {
        this.relativePageUrl = relativePageUrl;
    }



}
