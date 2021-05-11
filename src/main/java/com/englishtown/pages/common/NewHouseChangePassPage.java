package com.englishtown.pages.common;

import com.englishtown.helpers.AssertHelper;
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

import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 12/12/2018.
 * new house double page for pass
 * accounts.ef.com/en/ui/reset/index.html?continue_uri=
 *
 */


public class NewHouseChangePassPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(NewHouseChangePassPage.class);
    public String relativePageUrl = "accounts.ef.com/en/ui/password/index.html";
    public String SUCCESSFUL_MSG  = "check the email";

    /**
     * Main components
     */
    @FindBy(id = "password")
    public WebElement passwordWe;

    @FindBy(id = "confirmation")
    public WebElement confirmPassWE;

    @FindBy(id = "submit-form-btn")
    public WebElement changePassBtnWe;

    @FindBy(id = "")
    public WebElement thankyouMsgWe;


    public NewHouseChangePassPage(WebDriver webDriver){
        super(webDriver);
    }
    public NewHouseChangePassPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public NewHouseChangePassPage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public NewHouseChangePassPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(passwordWe);
        return true;
    }

    public boolean checkMainComponentsDisplayed() {
        AssertHelper.assertWebElementDisplayed(passwordWe);
        AssertHelper.assertWebElementDisplayed(confirmPassWE);
        AssertHelper.assertWebElementDisplayed(changePassBtnWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(passwordWe);
    }

    public void enterPasswords(String pass) {
        sendKey(getWebDriver(), passwordWe, pass, false);
        sendKey(getWebDriver(), confirmPassWE, pass, false);
    }

    public void submit() {
        WebElementHelper.click(changePassBtnWe);
    }

    public void checkThankyouMsg(String msg){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected message ....!",
                TestUtil.getWebElementText(thankyouMsgWe), containsString(msg), true);
    }

}