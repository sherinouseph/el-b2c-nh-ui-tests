package com.englishtown.pages.common.school;
/**
 * Nikol Dec 2017
 *
 * Once user logged in and user is not enrolled
 * this page is shown
 *
 * //http://campus-enrollment-ui.vagrant.f8/#access_token=uuid%3A5c89e04d-15e2-3ffe-8ca2-69
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.core.BaseHeaderAndFooterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.containsString;


public class SchoolWelcomePage extends BaseHeaderAndFooterPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolWelcomePage.class);
    public static final String pageUrl = "http://campus-enrollment-ui.vagrant.f8/";

    protected final String GO_ENROL_CSS     = "Enrollment-btn";


    @FindBy(className = GO_ENROL_CSS)
    public WebElement goEnrolBtWe;


    public SchoolWelcomePage(WebDriver webDriver){
        super(webDriver);
    }

    public SchoolWelcomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public SchoolWelcomePage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("simpleTest displayed ...!");
        AssertHelper.assertWebElementDisplayed(goEnrolBtWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(goEnrolBtWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    // click on go btn
    public void clickStartEnroll(){
        click(goEnrolBtWe);
    }


}
