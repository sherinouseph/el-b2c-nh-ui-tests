package com.englishtown.tests.core.school.course.currentcourse;
/**
 * check the current course
 * clickOnCurrentCourseMenu
 * assertNumberOfLessonsInAUnit
 * checkStepStatus*
 * assertCurrentUnitLevelAndLessonNumber
 * checkNavigationAcrossStepsInLesson
 * checkNavigationAcrossLessons
 * clickOnChangeCourseLink
 * Sherin 05/02/18
 *
 *
 */
//TODO SLEEP COMMAND TO BE REPLACED BY EXPLICIT WAIT

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public abstract class BaseCurrentCourseAllTest extends BaseCurrentCourse {
    private static final Logger logger = LoggerFactory.getLogger(BaseCurrentCourseAllTest.class);


    @Test(dependsOnMethods = "goToCurrentCoursePage")
    protected void checkAllPageComponents() {
        logger.info("checkAllPageComponents are displayed");
        currentCourseUnitPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllPageComponents")
    protected void assertNumberOfLessonsInAUnit() {
        logger.info("assertNumberOfLessons");
        currentCourseUnitPage.assertTotalNumberOfLessonsInAUnit(schoolStudentBean.getUnitNumber(),courseCodeNumber.getCourseCode());

    }

    @Test(dependsOnMethods = "assertNumberOfLessonsInAUnit")
    protected void assertCurrentUnitLevelAndLessonNumber() {
        logger.info("Check unit  number, level number and lesson number");
        currentCourseUnitPage.assertUnitNumber(schoolStudentBean.getUnitNumber(),courseCodeNumber.getCourseCode());
        currentCourseUnitPage.assertlevelNumber(schoolStudentBean.getLevelNumber(),courseCodeNumber.getCourseCode());
        currentCourseUnitPage.assertlessonNumber(schoolStudentBean.getLessonNumber());
    }
// TODO this take over 2.5 mins so until fix remove it
//    @Test(dependsOnMethods = "assertCurrentUnitLevelAndLessonNumber")
//    protected void assertNoOfCompletedLessonsAndSteps(){
//        logger.info("assertNoOfCompletedLessonsAndSteps");
//        Assert.assertEquals(currentCourseUnitPage.getLessonCompleted(),schoolStudentBean.getNoOfCompletedLessons());
//        logger.info("Completed Lessons : "+currentCourseUnitPage.getLessonCompleted());
//        Assert.assertEquals(currentCourseUnitPage.getStepsCompleted(),schoolStudentBean.getNoOfCompletedSteps());
//        logger.info("Completed steps : "+currentCourseUnitPage.getStepsCompleted());
//    }

    @Test(dependsOnMethods = "assertNumberOfLessonsInAUnit")
    protected void checkStepStatus(){
        logger.info("checkStep1Status");
        AssertHelper.assertThat("Step 1 Status not correct",currentCourseUnitPage.getStepStatus(0),equalTo(schoolStudentBean.getStep1Status()));
        AssertHelper.assertThat("Step 2 Status not correct",currentCourseUnitPage.getStepStatus(1),equalTo(schoolStudentBean.getStep2Status()));
        AssertHelper.assertThat("Step 3 Status not correct",currentCourseUnitPage.getStepStatus(2),equalTo(schoolStudentBean.getStep3Status()));
        if(schoolStudentBean.getStep4Status()!=null)
        AssertHelper.assertThat("Step 4 Status not correct",currentCourseUnitPage.getStepStatus(3),equalTo(schoolStudentBean.getStep4Status()));
    }

    @Test(dependsOnMethods = "checkStepStatus")
    protected void checkNavigationAcrossStepsInLesson(){
        logger.info("checkNavigationAcrossStepsInLesson");
        logger.info("get the description of current step");
        String currentstepDesc = (currentCourseUnitPage.stepDescWe.get(schoolStudentBean.getStepNumber())).getText();
        logger.info("click on any other step");
        click(currentCourseUnitPage.stepNoWe.get(schoolStudentBean.getStepNumber()));
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.activityTitleWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        if(currentCourseUnitPage.activityTitleWe.getText().equalsIgnoreCase(currentstepDesc)) {
            logger.info("successfully navigated to next activity");
            logger.info("Click on close button of the activity");
            click(currentCourseUnitPage.activityCloseBtnWe);
            waitForElementCondition(ExpectedConditions.invisibilityOf(currentCourseUnitPage.activityCloseBtnWe),
                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);}
        else{
            BaseTest.failTest("Not able to navigate through steps");}

    }

    @Test(dependsOnMethods = "checkNavigationAcrossStepsInLesson")
    protected void checkNavigationAcrossLessons() {
        logger.info("Check if the user is able to navigate across Lessons");
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.simpleTest();
        currentCourseUnitPage.navigateToLesson(schoolStudentBean.getLessonNumber());
        waitForElementCondition(ExpectedConditions.textToBePresentInElement(currentCourseUnitPage.lessonNumberWe,Integer.toString(schoolStudentBean.getLessonNumber() + 1)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);//we do lessonnumber +1 because now we clicked on next lesson
        AssertHelper.assertStringContains(currentCourseUnitPage.lessonNumberWe.getText(), Integer.toString(schoolStudentBean.getLessonNumber() + 1), "Lesson number incorrect..did not navigate thrugh lessons");
        logger.info("Successfully navigated to other lesson");
        logger.info("Come back to previous Lesson");
        sleep(2000);
        currentCourseUnitPage.navigateToLesson(schoolStudentBean.getLessonNumber()-1);//lesson number -1 to navigate back to previous lesson and this is the index of the lesson
        waitForElementCondition(ExpectedConditions.textToBePresentInElement(currentCourseUnitPage.lessonNumberWe,Integer.toString(schoolStudentBean.getLessonNumber())),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        AssertHelper.assertStringContains(currentCourseUnitPage.lessonNumberWe.getText(), Integer.toString(schoolStudentBean.getLessonNumber()), "Lesson number incorrect..did not navigate through lessons");
        logger.info("Successfully navigated to the previous lesson");

    }

    @Test(dependsOnMethods = "checkNavigationAcrossLessons")
    protected void checkNavigationAcrossUnits(){
        logger.info("Check if the user is able to navigate across units");
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.unitPreviousArrowWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.clickOnpreviousUnitArrow(schoolStudentBean.getUnitNumber());
        logger.info("Click on next button to go to next unit page and check if it is locked");
        sleep(2000);
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.clickOnNextUnitArrow(schoolStudentBean.getUnitNumber());
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.unitLockWe),
                getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.checkUnitLockMessageIsPresent();
        logger.info("Click on previous button to come back to current unit page");

        click(currentCourseUnitPage.unitPreviousArrowWe);
        sleep(3000);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.className("ets-backdrop")),
                getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT);

        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.assertUnitNumber(schoolStudentBean.getUnitNumber(),courseCodeNumber.getCourseCode());
    }


    @Test(dependsOnMethods = "checkNavigationAcrossUnits")
    protected void clickOnChangeCourseLink(){
        logger.info("clickOnChangeCourseLink");
        waitForVisibleClickableAndClick(currentCourseUnitPage.changeCourseLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage.getPageLoadedCondition();
        changeCourseMainPage.simpleTest();
    }


}



/*backward(getWebDriver());  //   getWebDriver().navigate().back();
        sleep(3000);
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.simpleTest();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(currentCourseUnitPage.goalTooltipCloseBtnWe),
                getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);*/
//  check in which scenario goaltooltip is present and accordlingly write test
//    @Test(dependsOnMethods = "clickOnChangeCourseLink")
//    protected void checkGoalTooltip(){
//        logger.info("checkGoalTooltip");
//        AssertHelper.assertThat("Tool tip content is null",TestUtil.getWebElementText(currentCourseUnitPage.goalTooltipWe),notNullValue());
//        logger.info("close the goal tool tip");
//        sleep(3000);
//        click(currentCourseUnitPage.goalTooltipCloseBtnWe);
//        waitForElementCondition(ExpectedConditions.invisibilityOf(currentCourseUnitPage.goalTooltipCloseBtnWe),
//                getWebDriver(),120);
//        logger.info("Successfully clicked on goal tooltip close button");
//
//
//    }
