package com.englishtown.tests.core.school.course.changecourse;
/**
 *check if the courses are active
 *Logic - if the current course is GE and level is 6 or above, then all the courses will be active(no lock message will be there)
 * if the current course is less than 6 ,then BE,Travel and Industry courses will be inactive(Lock message present when you click on these courses)
 * Sherin 07/02/18
 *
 *
 */
//TODO  NOTE: NM this test passes no matter if course shows the disable lock

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseCheckCoursesActive extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckCoursesActive.class);


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnChangeCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.simpleTest();
        changeCourseMainPage.checkAllPageComponentsDisplayed();

    }

    @Test(dependsOnMethods = "clickOnChangeCourseMenu")
    protected void checkAllCoursesAreDisplayed() {
        logger.info("checkAllCoursesAreDisplayed");
        changeCourseMainPage.checkAllCoursesDisplayed(numberOfCoursesAvailable);  // 5
    }

    @Test(dependsOnMethods = "checkAllCoursesAreDisplayed")
    protected void checkIfGECourseActive() {
        logger.info("checkIfGECourseActive");
        changeCourseMainPage.clickOnCourse(courseCodeNumber.GENERAL_ENGLISH.getCourseNumber());
        AssertHelper.assertWebElementNotDisplayed(findElement(By.cssSelector("#GE " + changeCourseMainPage.courseLock)));

    }

    @Test(dependsOnMethods = "checkIfGECourseActive")
    protected void checkBusinessCourseStatus() {
        logger.info("checkBusinessCourseStatus");
        changeCourseMainPage.clickOnCourse(courseCodeNumber.BUSINESS.getCourseNumber());
        changeCourseMainPage.checkCourseStatus(courseCodeNumber.getCourseCode(), schoolStudentBean.getLevelNumber(),courseCodeNumber.BUSINESS.getCourseCode(),8);
    }


    @Test(dependsOnMethods = "checkBusinessCourseStatus")
    protected void checkIndustryCourseStatus() {
        logger.info("checkIndustryCourseStatus");
        changeCourseMainPage.clickOnCourse(courseCodeNumber.INDUSTRY.getCourseNumber());
        changeCourseMainPage.checkCourseStatus(courseCodeNumber.getCourseCode(), schoolStudentBean.getLevelNumber(),courseCodeNumber.INDUSTRY.getCourseCode(),16);


    }


    @Test(dependsOnMethods = "checkIndustryCourseStatus")
    protected void checkTravelCourseStatus() {
        logger.info("checkTravelCourseStatus");
        changeCourseMainPage.clickOnCourse(courseCodeNumber.TRAVEL.getCourseNumber());
        changeCourseMainPage.checkCourseStatus(courseCodeNumber.getCourseCode(), schoolStudentBean.getLevelNumber(),courseCodeNumber.TRAVEL.getCourseCode(),1);

    }

    @Test(dependsOnMethods = "checkTravelCourseStatus")
    protected void checkIfTofelCourseActive() {
        logger.info("checkIfTofelCourseActive");
        changeCourseMainPage.clickOnCourse(courseCodeNumber.TOEFL_TOEIC_PREP.getCourseNumber());
        AssertHelper.assertWebElementNotDisplayed(findElement(By.cssSelector("#TT " + changeCourseMainPage.courseLock)));

    }

}


