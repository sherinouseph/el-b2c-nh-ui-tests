package com.englishtown.newhouse.school.pages.home.modules;
/**
 * Nikol Jan 2018
 *
 * Course SubMenu
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CourseSubMenuPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(CourseSubMenuPage.class);
    public static final String pageUrl = "/campus/mypage/home";
    // course menu
    public final String courseCurrentCourseCss    = ".ue-td[data-code='School.StudyPlan.2013'] a";
    public final String courseProgressAndTestCss  = ".ue-td[data-code='School.Progress.2012'] a";
    public final String courseChangeCourseCss     = ".ue-td[data-code='School.ChangeCourse.2012'] a";
    public final String courseAppAndToolCss      = ".ue-td[data-code='School.Tools.2015'] a";


    /**
     * Course menu [Current Course, progress, change, apps&tools]
     */
    @FindBy(css = courseCurrentCourseCss)
    public WebElement currentCourseMenuItemWe;

    @FindBy(css = courseProgressAndTestCss)
    public WebElement progressAndTestMenuItemWe;

    @FindBy(css = courseChangeCourseCss)
    public WebElement changeCourseMenuItemWe;

    @FindBy(css = courseAppAndToolCss)
    public WebElement appsAndToolMenuItemWe;

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main Navigation and Course element displayed ...!");
        AssertHelper.assertWebElementDisplayed(currentCourseMenuItemWe);
        AssertHelper.assertWebElementDisplayed(progressAndTestMenuItemWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(currentCourseMenuItemWe);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents []...!");
        checkAllPageComponentsDisplayed(currentCourseMenuItemWe, progressAndTestMenuItemWe, changeCourseMenuItemWe, appsAndToolMenuItemWe);
        return true;
    }

    public CourseSubMenuPage(WebDriver webDriver){
        super(webDriver);
    }
    public CourseSubMenuPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CourseSubMenuPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public CourseSubMenuPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }


}