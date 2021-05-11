package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 06-Dec-17.
 *
 *  Test will : Enrol student using ui [real browser]
 *
 * 0. create Student Account
 * 1. login to school with real browser
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import com.englishtown.pages.common.school.SchoolWelcomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public abstract class BaseUiEnrollSpec extends BaseCreateUser {
    public static final Logger logger = LoggerFactory.getLogger(BaseUiEnrollSpec.class);

    protected SchoolWelcomePage schoolWelcomePage;

    /**
     * Real browser test
     *
     */
    @Test(dependsOnMethods = "createUserIdTest")
    public void loginUserTest() {
        setGridEnvironmentFromDargs();
        createThreadSafeDriver();
        openUrl(baseUrl);  //http://campus-enrollment-ui.vagrant.f8/
        loginUser(null, null);
        logger.info("User should be logged in ...!");
        TestUtil.mySleep(1000);
    }


    @Test(dependsOnMethods = "loginUserTest")
    public void clickGoToEnrolTest() {
        schoolWelcomePage = new SchoolWelcomePage(getWebDriver());
        schoolWelcomePage.simpleTest();
        schoolWelcomePage.clickStartEnroll();
    }




    @Test(dependsOnMethods = "clickGoToEnrolTest")
    public void selectMotivationTest() {
        MotivationPage motivationPage = new MotivationPage(getWebDriver());
        // Step 1 Motivation
        int motivationIndex = 0 ; // career
        motivationPage.simpleTest();
        motivationPage.clickToSelectMotivation(motivationIndex);
        logger.info(" ------- ");
    }

    @Test(dependsOnMethods = "selectMotivationTest")
    public void selectEnglishLevel() {
        enrolStudentCheckAtSchool();
        logger.info(" ----------- ");
    }

    @Test(dependsOnMethods = "selectEnglishLevel")
    public void waitAndClickStartToLearnTest() {
        clickStartToLearn();
        logger.info(" ----------- ");
    }

    /**
     *
     */

    public void enrolStudentCheckAtSchool() {
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        englishLevelPage.selectEnglishLevel(1);
    }

    public void clickStartToLearn() {
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        englishLevelPage.clickStartLearning();
        //TODO check at school
        AssertHelper.assertThat(" Click start does not do anything ....! Fred and Martin to fix ... ", 1==2);
        TestUtil.mySleep(2000);

        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver());
        //enrolmentPage.checkStudentIsAtSchoolCampus();
    }



    @AfterClass
    protected void testAfterClass() {
        destroyDriver();
    }


}