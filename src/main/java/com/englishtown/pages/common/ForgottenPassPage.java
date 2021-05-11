package com.englishtown.pages.common;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.MyBasePage;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.openqa.selenium.By;
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
 * https://qa-englishlive.ef.com/en-gb/forgotten-password/
 * Submit without entering anything and check validation msg shown ... check txt
 * Submit with entering anything TY msg shown .. check text
 */


public class ForgottenPassPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(ForgottenPassPage.class);
    public String relativePageUrl = "forgotten-password/";
    public String USERNAME_VALIDATION_MSG = "your email or user name";
    public String SUCCESSFUL_MSG          = "check the email";
    public boolean isOldPage = false;

    /**
     * Old forgotten pass selectors
     * https://englishlive.ef.com/id-id/forgotten-password/
     */
    private static String userNameTxtCss = "#emailOrUsername";
    private static String submitOldBtn   = "#submitForgotPasswordForm";
    private static String emailOrUserNameCss = "EmailOrUserName"; // name


    /**
     * Main components
     */
    @FindBy(name = "EmailOrUserName")
    public WebElement emailOrUserName;


    @FindBy(css = ".bs3 .btn.btn-primary")
    public WebElement submitBtn;

    @FindBy(css = ".tooltip-inner")
    public WebElement validationErrorWe;

    @FindBy(css = ".the.message p")
    public WebElement thankyouMsg;  //Thanks, please check the email account provided for further instructions



    public ForgottenPassPage(WebDriver webDriver){
        super(webDriver);
    }
    public ForgottenPassPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ForgottenPassPage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public ForgottenPassPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(emailOrUserName);
        return true;
    }

    public boolean checkMainComponentsDisplayed() {
        if(isOldPage){
            logger.info("Old page ...! ");
            WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(userNameTxtCss)),
                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            AssertHelper.assertWebElementDisplayed(WaitTool.findElement(getWebDriver(), By.cssSelector(userNameTxtCss)));
            AssertHelper.assertWebElementDisplayed(WaitTool.findElement(getWebDriver(), By.cssSelector(submitOldBtn)));
        }else {
            logger.info("New page ...!");
            WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.name(emailOrUserNameCss)),
                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            AssertHelper.assertWebElementDisplayed(emailOrUserName);
            AssertHelper.assertWebElementDisplayed(submitBtn);
        }
        return true;
    }


    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(submitBtn);
    }

    public void enterEmailOrUserName(String usernameTxt) {
        WebElement webElement = WaitTool.findElement(getWebDriver(), By.name("EmailOrUserName"));
        WebElementHelper.clearAndsendKeys(getWebDriver(), emailOrUserName, usernameTxt, false);
    }

    public void enterEmailOrUserNameAndSubmit(String emailOrUsername) {
        enterEmailOrUserName(emailOrUsername);
        submit();
    }

    public void submit() {
        WebElementHelper.click(submitBtn);
    }

    public void assertValidationMessage(){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Validation message ....!",
                TestUtil.getWebElementText(validationErrorWe), containsString(USERNAME_VALIDATION_MSG), true);
    }

    public void assertThankyouMessage(String successfulMsg){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Thank you message ....!",
                TestUtil.getWebElementText(thankyouMsg), containsString(successfulMsg), true);
    }

    public String getUSERNAME_VALIDATION_MSG() {
        return USERNAME_VALIDATION_MSG;
    }

    public void setUSERNAME_VALIDATION_MSG(String USERNAME_VALIDATION_MSG) {
        this.USERNAME_VALIDATION_MSG = USERNAME_VALIDATION_MSG;
    }

    public String getSUCCESSFUL_MSG() {
        return SUCCESSFUL_MSG;
    }

    public void setSUCCESSFUL_MSG(String SUCCESSFUL_MSG) {
        this.SUCCESSFUL_MSG = SUCCESSFUL_MSG;
    }



}


/**
 public String getValidationMessage(){
 String msg = "notInit";
 msg = TestUtil.getWebElementText(validationErrorWe);
 return msg;
 }
 *
 */
