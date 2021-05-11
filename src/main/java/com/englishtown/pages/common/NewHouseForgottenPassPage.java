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


public class NewHouseForgottenPassPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(NewHouseForgottenPassPage.class);

    /**
     * Main components
     */
    @FindBy(id = "email")
    public WebElement emailWe;

    @FindBy(id = "submit-form-btn")
    public WebElement submitBtn;

    @FindBy(css = "#message-box h2")
    public WebElement thankyouMsgWe;  // Thank you!

    public NewHouseForgottenPassPage(WebDriver webDriver){
        super(webDriver);
    }
    public NewHouseForgottenPassPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public NewHouseForgottenPassPage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public NewHouseForgottenPassPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(emailWe);
        return true;
    }

    public boolean checkMainComponentsDisplayed() {
        AssertHelper.assertWebElementDisplayed(emailWe);
        AssertHelper.assertWebElementDisplayed(submitBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(submitBtn);
    }

    public void enterEmail(String usernameTxt) {
        WebElementHelper.clearAndsendKeys(getWebDriver(), emailWe, usernameTxt, false);
    }

    public void submit() {
        WebElementHelper.click(submitBtn);
    }

    public void checkThankyouMsg(String msg){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected message ....!",
                TestUtil.getWebElementText(thankyouMsgWe), containsString(msg), true);
    }

}