package com.englishtown.tests.core.school.course.progressandtest;
/**
 * Sherin - 26/03/2018
 * updated to TR test on 07/01/2019
 * Click on progress and test menu
 * click on teacher feedback
 * Check all components displayed
 * Expand the  teacher feedback for the first row
 * Check all components displayed
 * click on test tab and check efset components
 * click on retaketestlink and check if efset iframe exists
 *

 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.newhouse.school.pages.course.progressandtests.TeacherFeedbackPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseTeacherFeedbackTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseTeacherFeedbackTest.class);
    protected TeacherFeedbackPage teacherFeedbackPage;



    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnProgressAndTestMenu() {
        logger.info("clickOnProgressAndTestMenu");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToProgressAndTests();
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.simpleTest();
    }


    @Test(dependsOnMethods = "clickOnProgressAndTestMenu")
    protected void clickOnTeacherfeedback(){
        logger.info("checkCurrentLevelSelected");
        progressPage.clickTeacherFeedback();
       logger.info("Successfully clicked on teacher  feedback");

    }


    @Test(dependsOnMethods = "clickOnTeacherfeedback")
    protected void checkAllComponents(){
        logger.info("checkAllComponents");
        teacherFeedbackPage = new TeacherFeedbackPage(getWebDriver(),25);
        teacherFeedbackPage.simpleTest();
        teacherFeedbackPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponents")
    protected void expandTeacherFeedback(){
        logger.info("expandTeacherFeedback");
        teacherFeedbackPage.expandTeacherFeedback(0);
        WaitTool.waitForElementVisible(getWebDriver(), By.className("ets-pr-fb-score-large"),30);
        teacherFeedbackPage.checkComponentsFeedbackPage();
       // AssertHelper.assertThat("Score not correct", Integer.parseInt(TestUtil.getWebElementText(findElements(By.className("ets-pr-fb-score")).get(1))),greaterThanOrEqualTo(Integer.parseInt(schoolStudentBean.getTotalScore())));
    }

    @Test(dependsOnMethods = "expandTeacherFeedback")
    protected void clickOnTestTabAndCheckEFSETTestComponents() {
        logger.info("clickOnTestTabAndCheckEFSETTestComponents");
        progressPage.clickOnTestTab();
        progressPage.checkEFSETComponents();
        progressPage.clickOnEFSETTestLink();
        WebDriverWindowHelper.switchToWindow(getWebDriver(), 1);
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()), "/school-ui-progress-report-testresult-b2c/latest/static/frame.html?provided_user_id", "EFSET tet stat url incorrect");
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), "efset-iframe", 5);
    }

//    @Test(dependsOnMethods = "expandTeacherFeedback")
//    protected void clickOnsurveyLinkandcheckNoOfQuestions(){
//        logger.info("clickOnsurveyLink");
//        //failTest("Survey not working for newhouse users.This issue will be resolved with SAND-5363");
//        click(teacherFeedbackPage.surveyLinkWe);
//        sleep(1000);
//        logger.info("checkSurveyQuestionSize");
//        teacherFeedbackPage.checkSurveyQuestionSize();
//    }


}
