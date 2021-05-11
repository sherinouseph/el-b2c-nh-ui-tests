package com.englishtown.pages.common;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.MyBasePage;
import com.englishtown.tests.core.BaseTestHelper;
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
 * Open any page for the first time shows cookie popup(desktop) or stripe [Mob]
 * e.g https://englishlive.ef.com/fr-fr/
 */


public class CookiePage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(CookiePage.class);
    public String relativePageUrl = "";
    private static String cookieDesc ;            // expected text shown on popup
    private static final String mainCookieWeCss = ".cookie-policy";

    /**
     * Main components
     */
    @FindBy(className = "cookie-policy")              // main component
    public WebElement cookieWe;


    @FindBy(css = mainCookieWeCss+" .inline-text")    // heading 'COOKIES'
    public WebElement cookieHeadingWe;

    @FindBy(css = mainCookieWeCss+" .desc p")         // txt desc
    public WebElement cookieDescWe;

    @FindBy(css = mainCookieWeCss+" a")               // Link open how to manage cookie
    public WebElement manageCookieWe;

    @FindBy(css = mainCookieWeCss+" .close")               // close popup
    public WebElement closeWe;


    public CookiePage(WebDriver webDriver){
        super(webDriver);
    }
    public CookiePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CookiePage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public CookiePage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(cookieWe);
        AssertHelper.assertWebElementDisplayed(closeWe);
        return true;
    }

    public boolean fullTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(cookieWe);
        AssertHelper.assertWebElementDisplayed(closeWe);
        AssertHelper.assertWebElementDisplayed(cookieHeadingWe);
        AssertHelper.assertWebElementDisplayed(manageCookieWe);
        return true;
    }

    public String getCookieHeading() {
        return TestUtil.getWebElementText(cookieHeadingWe);
    }

    public String getCookieDesc() {
        return TestUtil.getWebElementText(cookieDescWe);
    }

    /*public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(cookieWe);
    }*/

    public void closeCookie() {
        WebElementHelper.click(closeWe);
    }

    public void setCookieDesc(String cookieDesc) {
        this.cookieDesc = cookieDesc;
    }

    public void isCookieShown(){
        ExpectedConditions.visibilityOf(cookieWe);        //AssertHelper.assertWebElementDisplayed(cookieWe);
    }

    public void isCookieNotShown(){
        ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(mainCookieWeCss));
    }



    public static String getMainCookieWeCss() {
        return mainCookieWeCss;
    }

}


//AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Thank you message ....!",   TestUtil.getWebElementText(thankyouMsg), containsString(successfulMsg), true);



