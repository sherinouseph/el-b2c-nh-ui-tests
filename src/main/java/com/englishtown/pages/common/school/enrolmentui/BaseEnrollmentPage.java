package com.englishtown.pages.common.school.enrolmentui;
/**
 *  Base Enroll   Header page
 *
 * User: nikol.marku
 * Date: 17/01/19 NH
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public abstract class BaseEnrollmentPage extends BasePage {
    public static final Logger logger = LoggerFactory.getLogger(BaseEnrollmentPage.class);

    public static final String pageUrl = "englishlive.ef.com/1/enrollment/"; // same for all 3 steps

    protected final String ENROLL_STEPS_CSS   = "div[class^='step-indicator-bar_'] > div";     //  3 steps ;
    protected final String CURRENT_STEP_CSS   = ENROLL_STEPS_CSS+"[class*='current_']";   // past current future_
    protected final String CURRENT_PAST_CSS   = ENROLL_STEPS_CSS+"[class*='past_']";
    protected final String CURRENT_FUTURE_CSS = ENROLL_STEPS_CSS+"[class*='future_']";


    @FindBy(css = ENROLL_STEPS_CSS)
    public List<WebElement> enrollStepsList ;



    public BaseEnrollmentPage(WebDriver webDriver){
        super(webDriver);
    }

    public BaseEnrollmentPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public BaseEnrollmentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public BaseEnrollmentPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("element displayed ...!");
        AssertHelper.assertWebElementDisplayed(enrollStepsList.get(2));
        return true;
    }

    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponentsDisplayed ...!");
        checkAllPageComponentsDisplayed(enrollStepsList.get(0), enrollStepsList.get(2));
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(enrollStepsList.get(0));
    }

    public String getPageUrl() {
        return pageUrl;
    }

    //get steps text  -- 0 - 2
    public String getStepIdName(int stepId){
        if (stepId > -1 && stepId < 3){
            return TestUtil.getWebElementText(enrollStepsList.get(stepId));
        } else
            failTest("Step index ID mast be between -1 and 3");
        return null;
    }

    public String getCurrentEnrollStep(){
        return TestUtil.getWebElementText(currWebElement = WaitTool.findElementDontFailTest(getWebDriver(), By.cssSelector(CURRENT_STEP_CSS)));
    }


}
