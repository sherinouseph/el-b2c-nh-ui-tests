package com.englishtown.pages.common;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 12/29/2016.
 */
public class LoginPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public static final String[] loginFormType = {"old", "new", "latest"};
    public static String loginFormCurrentType = loginFormType[1]; // default set this up from the above
    public String relativePageUrl = "login/";

    public String userNameValidationMsg = "in your email";
    public String passValidationMsg     = "in your password";
    public String loginFailedMsg        = "Login failed";
    public String invalidErrorMsg       = "Unknown"; // on DE entering nothing  Unknown "invalid" error

    public static String loginBtnOldCss = "[type=submit]";
    public boolean isOldPage = false; // use loginBtnOldCss for old pages checks
    public boolean isNewPage = false;
    public boolean isLatest  = true; // there are 3 login pages formats old new latest[gb it sa]
    /**
     * Main components
     */
    @FindBy(name = "UserName")
    public WebElement userName;

    @FindBy(name = "Password")
    public WebElement password;

    @FindBy(css = ".bs3 .btn.btn-primary")    // .login-area .btn
    public WebElement loginBtn; //new   //for de .button-submit

    @FindBy(css = ".btn.btn-secondary")
    public WebElement loginBtnLatest;

    @FindBy(css = "[type=submit]")
    public WebElement loginBtnOld;

    @FindBy(css = ".tooltip-inner")
    public WebElement validationErrorWe;

    @FindBy(css = "a[href*='/forgotten-password/']")
    public WebElement forgottenPassWe;

    @FindBy(css = ".message.alert.alert-danger")
    public WebElement loginFailedMsgWe;

    @FindBy(css = ".do-not-have-account + div > button")
    public WebElement signupBtnWe;



    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }
    public LoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public LoginPage(WebDriver webDriver, int timeOutSec) {
        super(webDriver, timeOutSec);
    }
    public LoginPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(userName);
        //AssertHelper.assertWebElementDisplayed(loginBtn);
        return true;
    }

    public boolean checkUserNameAndPassTxtDisplayed() {
        AssertHelper.assertWebElementDisplayed(userName);
        AssertHelper.assertWebElementDisplayed(password);
        return true;
    }

    public boolean isUsernameDisplayed() {
        logger.info(" isUsernameDisplayed() ...! ");
        AssertHelper.assertWebElementDisplayed(userName);
        return true;
    }

    public boolean isSignupDisplayed() {
        logger.info(" isSignupDisplayed() ...! ");
        AssertHelper.assertWebElementDisplayed(signupBtnWe);
        return true;
    }

    public boolean checkLoginBtnDisplayed() {
        if(isOldPage){
            logger.info("Old page ...!");
                        AssertHelper.assertWebElementDisplayed(loginBtnOld);
        }else if(isLatest){
            logger.info("Latest page ...!");
            WaitTool.waitForElementVisible_fluentWait(getWebDriver(),loginBtnLatest,10,1000);
            AssertHelper.assertWebElementDisplayed(loginBtnLatest);
        }else {
            logger.info("New page ...!");
            AssertHelper.assertWebElementDisplayed(loginBtn);
        }
        return true;
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
        click(loginBtWe);
    }

    public void enterCredentialsAndClickLogin(String usernameTxt, String passwordTxt) {
        enterCredentials(usernameTxt, passwordTxt);
        login();
    }

    public void assertValidationMessage(String validationMsg){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Validation message ....!",
                TestUtil.getWebElementText(validationErrorWe), containsString(validationMsg), true);
    }

    public void assertLoginFailedMessage(){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Validation message ....!",
                TestUtil.getWebElementText(loginFailedMsgWe), containsIgnoringCase(loginFailedMsg), true);
    }

    public ForgottenPassPage goToForgottenPassPage(){
        WebElementHelper.click(forgottenPassWe);
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

    public String getUserNameValidationMsg() {
        return userNameValidationMsg;
    }

    public void setUserNameValidationMsg(String userNameValidationMsg) {
        this.userNameValidationMsg = userNameValidationMsg;
    }

    public String getPassValidationMsg() {
        return passValidationMsg;
    }

    public void setPassValidationMsg(String passValidationMsg) {
        this.passValidationMsg = passValidationMsg;
    }

    public String getLoginFailedMsg() {
        return loginFailedMsg;
    }

    public void setLoginFailedMsg(String loginFailedMsg) {
        this.loginFailedMsg = loginFailedMsg;
    }

    public String getInvalidErrorMsg() {
        return invalidErrorMsg;
    }

    public void setInvalidErrorMsg(String invalidErrorMsg) {
        this.invalidErrorMsg = invalidErrorMsg;
    }

}
