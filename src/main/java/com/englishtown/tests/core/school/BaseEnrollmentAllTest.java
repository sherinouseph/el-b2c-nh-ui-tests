package com.englishtown.tests.core.school;
/**
 * On login page
 * Login an existing user
 * check all enrollment Start page anc click start
 * check Motivation page and select
 * check Level page
 * Do not enroll as it needs a new user every time test run
 *  this test covers it go to the second step but dont enroll the user
 * User: nikol.marku
 * Date: 17/01/19
 *
 * Note: New house enroll does not support other reason and navigate back ...
 * Check content of enroll steps and dont finish enroll
 * Note: user is not enrolled ....
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import com.englishtown.pages.common.school.enrolmentui.NewHouseStartEnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.StartLearningPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseEnrollmentAllTest extends BaseLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseEnrollmentAllTest.class);

    public String startEnrolmentUrl = "campus/enrollment/b2c/entrance"; // contains

    public int motivationIndex = 0; // test should set this up
    public int levelIndex      = 1; // test should set this up
    /**
     * Step 0
     * https://englishlive.ef.com/campus/enrollment/b2c/entrance#1
     */
    @Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")
    protected void checkEnrolmentStartPageUrl(){
        logger.info("enterUserCredentialsAndLogin  ...!");
        logger.info("is new house enrol ...!");
        sleep(2000);
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.tagName("button")), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        newHouseStartEnrolmentPage = new NewHouseStartEnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        newHouseStartEnrolmentPage.getPageLoadedCondition();
        newHouseStartEnrolmentPage.checkAllPageComponentsDisplayed();
        sleep(999);        //waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        //waitForElementCondition(ExpectedConditions.elementToBeClickable(By.tagName("button")), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);        //click(By.tagName("button"));        //newHouseStartEnrolmentPage.startEnrolment();
    }

    @Test(dependsOnMethods = "checkEnrolmentStartPageUrl")
    protected void clickStartEnrolmentBtn(){
        logger.info("clickStartEnrolmentBtn  ...!");
        newHouseStartEnrolmentPage.startEnrolment();//        enrolmentPage.startEnrolment();
        sleep(999);
    }

    @Test(dependsOnMethods = "clickStartEnrolmentBtn")
    protected void checkMotivationPageContent(){
        logger.info("checkMotivationPageContent  ...!");
        /*enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        enrolmentPage.getPageLoadedCondition();        enrolmentPage.simpleTest();        enrolmentPage.assertCurrentNavBar(1);        enrolmentPage.assertMotivationPageHas4Options();*/
        motivationPage = new MotivationPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        motivationPage.getPageLoadedCondition();
        motivationPage.checkAllPageComponentsDisplayed();
    }

    /* Not in new house    @Test(dependsOnMethods = "checkMotivationPageContent")    protected void typeAnotherReasonAndClickContinue(){        logger.info("typeAnotherReasonAndClickContinue  ...!");        enrolmentPage.typeAnotherReason("testAnotherReason");        enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        enrolmentPage.clickContinueBtn();        sleep(2000);    }*/

    @Test(dependsOnMethods = "checkMotivationPageContent")
    protected void selectMotivation(){
        logger.info("selectMotivation index ...! [{}]", motivationIndex);
        /*enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        enrolmentPage.getPageLoadedCondition();        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));        enrolmentPage.assertCurrentNavBar(2);        enrolmentPage.assertStepBackDisplayed();        enrolmentPage.assertLevelPageHas7Levels();*/
        motivationPage.clickToSelectMotivation(motivationIndex);
    }

    @Test(dependsOnMethods = "selectMotivation")
    protected void checkLevelPage(){
        logger.info("checkLevelPage  ...!");
        sleep(2000);
        englishLevelPage = new EnglishLevelPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        englishLevelPage.getPageLoadedCondition();
        englishLevelPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "selectMotivation")
    protected void selectLevel(){
        logger.info("selectLevel  ...! levelIndex [{}]", levelIndex);
        // enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        enrolmentPage.getPageLoadedCondition();        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");        //enrolmentPage.selectImproveEnglishFor(2);
        englishLevelPage.selectEnglishLevel(levelIndex);
        sleep(2000);
    }

    @Test(dependsOnMethods = "selectLevel")
    protected void checkStartLearningPage(){
        logger.info("checkStartLearningPage  ...! ");        // enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        enrolmentPage.getPageLoadedCondition();        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");        //enrolmentPage.selectImproveEnglishFor(2);
        startLearningPage = new StartLearningPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        startLearningPage.getPageLoadedCondition();
        startLearningPage.checkAllPageComponentsDisplayed();
        startLearningPage.clickStartLearning();
        sleep(200);
    }
}




/*
    public void check_EnrolmentPageUrl() {
        logger.info("check_EnrolmentPage  ...!");
        waitForUrlContains(getWebDriver(), startEnrolmentUrl, WaitTool.MED_WAIT_4_ELEMENT);
        assertIsUrlContaining(startEnrolmentUrl);
        enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        enrolmentPage.checkAllPageComponentsDisplayed();
    }

   public void enrolStudentCheckAtSchool() {
        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.startEnrolment();
        // Step 1
        enrolmentPage.simpleTest();
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        enrolmentPage.selectImproveEnglishFor(0);
        // Step 2
        sleep(2000);
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        enrolmentPage.selectEnglishLevel(1);
        // Step 3
        sleep(2000);
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.clickStartLearning();
        sleep(2000);
        enrolmentPage.checkStudentIsAtSchoolCampus();
    }*/
