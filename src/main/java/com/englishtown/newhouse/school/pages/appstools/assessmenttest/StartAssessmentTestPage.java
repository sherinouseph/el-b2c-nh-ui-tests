package com.englishtown.newhouse.school.pages.appstools.assessmenttest;
/**
 * Nikol  Feb 2019
 *
 */

import com.englishtown.helpers.AssertHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StartAssessmentTestPage extends BaseAssessmentTestPage {

    public static final Logger logger = LoggerFactory.getLogger(StartAssessmentTestPage.class);
    public static final String pageUrl = "/1/school/test/placementtest/";




    @FindBy(linkText = startTestlinkText)  //todo .. need proper css
    public WebElement startTestWe;

    //--------------------------------------------------------------------------------------

    public StartAssessmentTestPage(WebDriver webDriver){
        super(webDriver);
    }


    public StartAssessmentTestPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public StartAssessmentTestPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public StartAssessmentTestPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(startTestWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(startTestWe );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( startTestWe);
        return true;
    }

    public void startTest(){
        click(startTestWe);
    }
}
