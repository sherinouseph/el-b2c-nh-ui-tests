package com.englishtown.tests.core.school;
/**
 * sherin - 12/03/2018
 * Create new user via UI
 * go to progress and page.check total time --no value before you start the course
 * go to current course unit page
 * all the step status should be start
 * Once you start the activity in the first step, the step status changes to continue
 * check the goal page..for this user,it is "3-5"
 * Go to progress and test page .check if the total time has a value greater than 1
 * TODO: get the list of things that the new users see in school
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.newhouse.school.beanandenum.StepStatus;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.ChangeYourGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.tests.checkout.common.core.CheckCampusPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;


public abstract class BaseSchoolNewUserTest extends CheckCampusPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseSchoolNewUserTest.class);
    protected SchoolHeaderAndFooterPage schoolHeaderAndFooterPage;
    protected CurrentCourseUnitPage currentCourseUnitPage;
    protected SchoolStudentBean schoolStudentBean;
    protected StepStatus stepStatus;
    protected ProgressPage progressPage;
    protected CourseCodeNumber courseCodeNumber;
    protected  ChangeYourGoalPage changeYourGoalPage;
    protected  String totalTime;

    @Test(dependsOnMethods = "checkAtCampusPage")
    protected void clickSavebtnInTimeZonePopUpTest(){
        clickSavebtnInTimeZonePopUp();
    }


    @Test(dependsOnMethods = "clickSavebtnInTimeZonePopUpTest")
    protected void clickOnProgressAndTestMenuAndCheckTotalTime() {
        logger.info("clickOnProgressAndTestMenu");
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToProgressAndTests();
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.getPageLoadedCondition();
        progressPage.simpleTest();
        getTotalTimeBeforeCourse(schoolStudentBean.getUnitNumber()-1,
                schoolStudentBean.getLessonNumber()-1, schoolStudentBean.getTotalTime(), courseCodeNumber.getCourseCode());
    }



    @Test(dependsOnMethods = "clickOnProgressAndTestMenuAndCheckTotalTime")
    protected void goTocurrentCourse(){
        logger.info("goTocurrentCourse  ...!");
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(),30);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentCourse();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.simpleTest();
    }

    @Test(dependsOnMethods = "goTocurrentCourse")
    protected void checkInitialStatusOfSteps(){
        logger.info("checkInitialStatusOfSteps");
        AssertHelper.assertThat("Step 1 Status is not start",currentCourseUnitPage.getStepStatus(0),equalTo(stepStatus.START.getStepStatus()));
        AssertHelper.assertThat("Step 1 Status is not start",currentCourseUnitPage.getStepStatus(1),equalTo(stepStatus.START.getStepStatus()));
        AssertHelper.assertThat("Step 1 Status is not start",currentCourseUnitPage.getStepStatus(2),equalTo(stepStatus.START.getStepStatus()));
        logger.info("Click start button on first step");


    }


    @Test(dependsOnMethods = "checkInitialStatusOfSteps")
    protected void clickOnstartBtnOfFirstStep(){
        logger.info("clickOnstartBtnOfFirstStep");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(currentCourseUnitPage.stepNoWe.get(0)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
        click(currentCourseUnitPage.stepNoWe.get(0));
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.activityTitleWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("successfully navigated to first activity");

    }


    @Test(dependsOnMethods = "clickOnstartBtnOfFirstStep")
    protected void clickNextBtnAndAssertStep1Status (){
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.activityNextBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        click(currentCourseUnitPage.activityStepsListWe.get(1));
        sleep(2000);
        /* activity button is not active any more Jan 2019 NM
        currentCourseUnitPage.clickOnNextBtn();
        logger.info("successfully clicked on next btn");*/
        logger.info("Click on close button of the activity");
        click(currentCourseUnitPage.activityCloseBtnWe);
        waitForElementCondition(ExpectedConditions.invisibilityOf(currentCourseUnitPage.activityCloseBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        AssertHelper.assertThat("Step 1 Status is not continue",currentCourseUnitPage.getStepStatus(0),equalTo(stepStatus.CONTINUE.getStepStatus()));
        logger.info("step 1 sttaus is continue");

    }

    @Test(dependsOnMethods = "clickNextBtnAndAssertStep1Status")
    protected void checkCurrentGoal(){
        logger.info("checkCurrentGoal");
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        AssertHelper.assertThat("New Goal hours wrong",changeYourGoalPage.getCurrentGoalHours(),equalToIgnoringCase("3-5"));

    }


    @Test(dependsOnMethods = "checkCurrentGoal")
    protected void getProgress_TimeAfterStartOfCourse(){
        logger.info("getProgress_TimeAfterStartOfCourse");
        sleep(2000);
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(),30);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToProgressAndTests();
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.assertTotalTime(schoolStudentBean.getUnitNumber()-1,
                schoolStudentBean.getLessonNumber()-1,courseCodeNumber.getCourseCode());

    }

    protected void getTotalTimeBeforeCourse(int unitNumber,int lessonNumber,String expTotalTime,String courseCode) {
        if(courseCode=="GE")
            totalTime = TestUtil.getWebElementText(progressPage.unitListGEWe.get(
                    unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(
                            By.className("ets-pr-lesson-time-spent")));
        else{
            totalTime = TestUtil.getWebElementText( progressPage.unitListOtherCoursesWe.get(
                    unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(
                            By.className("ets-pr-lesson-time-spent")));}

        AssertHelper.myAssertThat(getWebDriver(),
                "time value is present even before start of course....that is WRONG",
                totalTime, equalToIgnoringWhiteSpace("--"),false);
        logger.info("Total time ="+totalTime);
    }


}