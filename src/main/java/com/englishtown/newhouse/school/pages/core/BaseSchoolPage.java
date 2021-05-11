package com.englishtown.newhouse.school.pages.core;
/**
 * Nikol Jan 2018
 * All school pages should extend this page
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseSchoolPage extends BasePage implements ISchoolPage{
    private static final Logger logger = LoggerFactory.getLogger(BaseSchoolPage.class);

    String ACCOUNT_PAGE_SPINNER_CSS = "div [class^='sk-fading-circle_']";

    public BaseSchoolPage(WebDriver webDriver){
        super(webDriver);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForSchoolSpinnerNotVisible();
    }

    public BaseSchoolPage(WebDriver webDriver, String url) {
        super(webDriver, url);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForSchoolSpinnerNotVisible();
    }

    public BaseSchoolPage(WebDriver webDriver, int pageLoadTime) {
        super(webDriver, pageLoadTime);
        // for edge when you click download document status is not ready but interactive state .. on chat friends page FF does the same
        if(!StringUtils.containsIgnoreCase(BaseRemoteWebDriver.getCurrentBrowserName(), "edge") ||
                !StringUtils.containsIgnoreCase(BaseRemoteWebDriver.getCurrentBrowserName(), "firefox")) {
            if(WebDriverFactory.isPageLoadStrategy){
                //     dont wait
            } else
                JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        }
        waitForSchoolSpinnerNotVisible();
    }

    public BaseSchoolPage() {
        this(null, null);
    }

    public void waitForSchoolSpinnerNotVisible(){
        logger.info("Wait for spinner invisible [{}]", schoolSpinnerCss);
        sleep(1000);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.className(schoolSpinnerCss)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        //(1000);
    }

    /**
     * On account pages there is a spinner showing ... need to wait for it to disappear
     *
     * @return
     */
    public void waitForAccountPageSpinnerDisappear(int waitTimeSec){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(ACCOUNT_PAGE_SPINNER_CSS)),getWebDriver(), waitTimeSec);
        sleep(500);
    }

}
