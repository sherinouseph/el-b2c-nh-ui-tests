package com.englishtown.tests.core.school.mypage;
/**
 * Login an existing user click on all the links/buttons on my page
 1. book a PL
 2. GL learn more
 3. continue studying
 * User: nikol.marku
 * Date: 27/03/18
 *
 *
 */

import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class BaseMyPageNavigationTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseMyPageNavigationTest.class);

    protected String videoPopupCss = "vjs-tech"; // video play class name
    protected CourseLevel courseLevel = CourseLevel.BEGINNERS_1;
    protected CourseUnit courseUnit ;
    public String plLeftMsg = "testShouldSetThisUP"; // contains // test should set this up
//    public String noGlLeft  = "testShouldSetThisUP"; // contains // test should set this up
//    public String totalGl   = "testShouldSetThisUP"; // contains // test should set this up


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void initMyPage(){
        initSchoolHomePage();
    }

    @Test(dependsOnMethods = "initMyPage")//downloadAppsSectionWe, downloadAppsListWeb.get(3)
    protected void checkMyPageAllComponents(){
        logger.info("checkMyPageAllComponents  ...! \n[{levelNavigatorWe, activeLevelNavigatorWe, activeLevelNavigatorWe,\n" +
                "                                     unitItemsListWe.get(3), selfStudySectionWe, selfStudyActionButtonWe, privateLessonSectionWe,\n" +
                "    privateLessonTeacherImgWe, bookClassNowBtnWe, groupLessonSectionWe, glSectionLearnMoreOrJoinClassBtnWe,\n" +
                "    mypageArrowDown}]\n" );
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.simpleTest();
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkMyPageAllComponents")
    protected void checkHowManyPrivateClassesLeft(){
        logger.info("checkHowManyPrivateClassesLeft  ...! ");
        schoolHomePage.checkPLLeft(plLeftMsg);
    }


    @Test(dependsOnMethods = "checkHowManyPrivateClassesLeft")
    protected void checkGroupClassesSection(){
        logger.info("checkGroupClassesTakenAndLeft  ...! ");
        schoolHomePage.checkGroupLessonSection();
    }

    @Test(dependsOnMethods = "checkGroupClassesSection")
    protected void assertStudentLevelName(){
        logger.info("assertStudentLevelName  ...! ");
        schoolHomePage.assertStudentLevelName(courseLevel);
    }

    @Test(dependsOnMethods = "assertStudentLevelName")
    protected void assertStudentLevelNumber(){
        logger.info("checkHowManyGroupClassesLeft  ...! ");
        schoolHomePage.assertStudentLevelNumber(courseLevel);
    }

    @Test(dependsOnMethods = "assertStudentLevelNumber")
    protected void checkCurrentUnit(){
        logger.info("checkCurrentUnit  ...! ");
        schoolHomePage.checkCurrentUnit(courseUnit);
    }

    @Test(dependsOnMethods = "checkCurrentUnit")
    protected void checkBookAPrivateLessonLink(){
        schoolHomePage.clickBookAPrivateClass();
        initBookPrivateLessonPage();
    }

    @Test(dependsOnMethods = "checkBookAPrivateLessonLink")
    protected void goBackToMyPageAndInitMyPage(){
        openPageUrl(schoolHomePage);
        initSchoolHomePage();
    }

    // GL this shows no class scheduled so removing it  .. TODO find a solution to show this all time
    @Test(dependsOnMethods = "goBackToMyPageAndInitMyPage")
    protected void checkLearnMoreAndConversationPage(){
        schoolHomePage.clickLearnMore();
        sleep(2000);
        initConversationClassPage();
    }

    @Test(dependsOnMethods = "checkLearnMoreAndConversationPage")
    protected void goBackToMyPage(){
        openPageUrl(schoolHomePage);
        initSchoolHomePage();
    }

    // video
    @Test(dependsOnMethods = "goBackToMyPage")
    protected void clickContinueStudyingTestCheckCurrentCourse(){
        schoolHomePage.clickContinueStudying();
        sleep(1000);
        initCurrentCourseUnitPage();

    }


    //TODO add test for the apps once the new apps section done
}
