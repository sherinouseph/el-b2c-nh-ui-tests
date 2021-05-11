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


public class AssessmentTestGrammarPage extends BaseAssessmentTestPage {

    public static final Logger logger = LoggerFactory.getLogger(AssessmentTestGrammarPage.class);
    public static final String pageUrl = "/1/school/test/assessmenttest/";



    @FindBy(linkText = "Start now")
    public WebElement startNowWe;

    //--------------------------------------------------------------------------------------

    public AssessmentTestGrammarPage(WebDriver webDriver){
        super(webDriver);
    }


    public AssessmentTestGrammarPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public AssessmentTestGrammarPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public AssessmentTestGrammarPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(startNowWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(startNowWe );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( startNowWe);
        return true;
    }

    public void startTest(){
        click(startNowWe);
    }
}
