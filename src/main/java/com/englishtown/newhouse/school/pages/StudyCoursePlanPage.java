package com.englishtown.newhouse.school.pages;
/**
 * Nikol Nov 2017
 *
 * TODO remove BaseHeaderAndFooter; replace with new one and maker sure api test know about it
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


public class StudyCoursePlanPage extends BaseHeaderAndFooterPage {

    public static final Logger logger = LoggerFactory.getLogger(StudyCoursePlanPage.class);
    public static final String pageUrl = "school/studyplan";    // course-> my course


    @FindBy(css = ".ets-sp-sqn-container li")
    public List<WebElement> sequenceNavigatorWe;  // intro , give your name ..

    @FindBy(className = "ets-sp-uno-btn")
    public WebElement unitOverviewBtnWe;

    @FindBy(css = ".ets-showButton .ets-sp-step-start")
    public WebElement startLessonWe;

    @FindBy(css = ".ets-sp-steps div")
    public List<WebElement> lessonListWe;


    public StudyCoursePlanPage(WebDriver webDriver){
        super(webDriver);
    }

    public StudyCoursePlanPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public StudyCoursePlanPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main Navigation and userNotification element displayed ...!");
        AssertHelper.assertWebElementDisplayed(unitOverviewBtnWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(unitOverviewBtnWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }


    public void assertLessonListNumber(int lessonListNo){
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), lessonListWe, lessonListNo);
    }



}
