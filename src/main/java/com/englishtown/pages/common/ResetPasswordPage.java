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

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 28/02/2017
 * https://englishlive.ef.com/it-it/reset-password/
 */
public class ResetPasswordPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(ResetPasswordPage.class);
    public String relativePageUrl = "reset-password/";
    // looks the same selectors for old and new pages    public static String newPasswordOldCss      = "newPassword";     public static String confirmpasswordOldCss  = "confirmpassword";    public static String submitOldCss = ".bs3 .btn.btn-primary";

    /**
     * Main components : new desing
     */
    @FindBy(name = "newPassword")
    public WebElement newPassword;

    @FindBy(name = "confirmpassword")
    public WebElement confirmpassword;

    @FindBy(css = ".bs3 .btn.btn-primary")
    public WebElement submit;


    public ResetPasswordPage(WebDriver webDriver){
        super(webDriver);
    }
    public ResetPasswordPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ResetPasswordPage(WebDriver webDriver, int timeOutSec) {
        super(webDriver, timeOutSec);
    }
    public ResetPasswordPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkMainComponetsTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(newPassword);
        AssertHelper.assertWebElementDisplayed(confirmpassword);
        AssertHelper.assertWebElementDisplayed(submit);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(submit);
    }








}
