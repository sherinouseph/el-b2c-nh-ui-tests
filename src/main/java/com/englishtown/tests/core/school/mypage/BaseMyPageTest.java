package com.englishtown.tests.core.school.mypage;
/**
 * Check my page content
 * User: nikol.marku
 * Date: 23/03/18
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


public abstract class BaseMyPageTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseMyPageTest.class);

    protected CourseLevel courseLevel = CourseLevel.BEGINNERS_1;
    protected CourseUnit courseUnit ;
    public String plLeftMsg = "testShouldSetThisUP"; // contains // test should set this up
    public String noGlLeft  = "testShouldSetThisUP"; // contains // test should set this up
    public String totalGl   = "testShouldSetThisUP"; // contains // test should set this up

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")//downloadAppsSectionWe, downloadAppsListWeb.get(3)
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


   @Test(dependsOnMethods = "checkMyPageAllComponents")
    protected void checkGroupClassesTakenAndLeft(){
        logger.info("checkGroupClassesTakenAndLeft  ...! ");
        schoolHomePage.checkGroupClassesTakenAndLeft(totalGl, noGlLeft);
    }

    @Test(dependsOnMethods = "checkMyPageAllComponents")
    protected void assertStudentLevelName(){
        logger.info("assertStudentLevelName  ...! ");
        schoolHomePage.assertStudentLevelName(courseLevel);
    }

    @Test(dependsOnMethods = "checkMyPageAllComponents")
    protected void assertStudentLevelNumber(){
        logger.info("checkHowManyGroupClassesLeft  ...! ");
        schoolHomePage.assertStudentLevelNumber(courseLevel);
    }

    @Test(dependsOnMethods = "checkMyPageAllComponents")
    protected void checkCurrentUnit(){
        logger.info("checkCurrentUnit  ...! ");
        schoolHomePage.checkCurrentUnit(courseUnit);
    }



}
