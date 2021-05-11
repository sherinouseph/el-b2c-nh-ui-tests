package com.englishtown.tests.core.school.course.progressandtest;
/**
 * Progress
 * Sherin - 06/01/2019
 *Go to progress page
 * check all levels,units,tabs are displayed
 * check the device used
 * check total score and total time
 * check if lesson is completed
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseProgressTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseProgressTest.class);
    protected String deviceUsed="desktop";



    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnProgressAndTestMenu() {
        logger.info("clickOnProgressAndTestMenu");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToProgressAndTests();
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.simpleTest();
    }


    @Test(dependsOnMethods = "clickOnProgressAndTestMenu")
    protected void checkCurrentLevelSelected(){
        logger.info("checkCurrentLevelSelected");
        waitForElementCondition(ExpectedConditions.visibilityOf(progressPage.progressTitleWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        if(courseCodeNumber.getCourseCode()=="GE") {
                        int currentLevel = progressPage.getCurrentLevel((schoolStudentBean.getLevelNumber() - 1));
            logger.info("current level number is " + currentLevel);
            if (currentLevel == schoolStudentBean.getLevelNumber())
                logger.info("Current Level number is correct");
            else
                failTest("Level name incorrect");
        }else
            AssertHelper.assertWebElementDisplayed(progressPage.cardHeaderWe);

    }


    @Test(dependsOnMethods = "checkCurrentLevelSelected")
    protected void checkAllComponents(){
        logger.info("checkAllComponents");
        progressPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponents")
    protected void checkAllLevelsAndStagesAredisplayed(){
        if(courseCodeNumber.getCourseCode()=="GE") {
            logger.info("checkAllLevelsAndStagesAredisplayed");
            progressPage.assertTotalNumberOfLevelsAndStagesInGE();
        }
        else logger.info("No need to check levels and stages if the course is not General English");
    }

    @Test(dependsOnMethods = "checkAllLevelsAndStagesAredisplayed")
    protected void checkAllTabsAreDisplayed(){
        logger.info("checkAllTabsAreDisplayed");
        progressPage.assertTotalNumberOfMainTabs();
    }

    @Test(dependsOnMethods = "checkAllTabsAreDisplayed")
    protected void checkAllUnitsAredisplayed(){
        logger.info("checkAllUnitsAredisplayed");
        progressPage.assertTotalNumberOfUnits(courseCodeNumber.getCourseCode());
        progressPage.checkUnitComponents(schoolStudentBean.getUnitNumber()-1);
    }


    @Test(dependsOnMethods = "checkAllUnitsAredisplayed")
    protected void checkIfLessonCompleted(){
        logger.info("checkIfLessonCompleted");
        if(schoolStudentBean.isLessonCompleted())
            progressPage.assertLessonCompleted(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,courseCodeNumber.getCourseCode());
    }

    @Test(dependsOnMethods = "checkIfLessonCompleted")
    protected void checkDeviceUsed(){
        logger.info("checkDeviceUsed");
        progressPage.assertDeviceUsed(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,deviceUsed);
    }

    @Test(dependsOnMethods = "checkIfLessonCompleted")
    protected void checkTotalScoreAndTotalTime(){
        logger.info("checkTotalScoreAndTotalTime");
        progressPage.assertTotalTime(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,courseCodeNumber.getCourseCode());
        progressPage.assertTotalScore(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,courseCodeNumber.getCourseCode());
    }





}
