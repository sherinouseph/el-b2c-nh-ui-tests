package com.englishtown.tests.core.school.course.changecourse;
/**
 * check if all the elemetns are displayed in the main page
 * click on each course and check the total number of levels in each course
 * Check the elements displayed inside each level
 *
 *
 * Sherin 08/02/18
 *go to change course
 * check the total number of levels in the current course
 * Check total number of courses displayed
 *
 */
//

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.beanandenum.EnabledCourses;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseChangeCourseContent extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangeCourseContent.class);

    public String activeCourse;



    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnChangeCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.LONG_WAIT_4_ELEMENT);
        changeCourseMainPage.getPageLoadedCondition();

    }

    @Test(dependsOnMethods ="clickOnChangeCourseMenu")
    public void checkRecommendedCourses(){
        logger.info("checkRecommendedCourses");
        AssertHelper.assertWebElementDisplayed(changeCourseMainPage.recommendedLevel1);
        if(courseCodeNumber.getCourseNumber()==0 && schoolStudentBean.getLevelNumber()>=6){
           changeCourseMainPage.checkAllPageComponentsDisplayed(changeCourseMainPage.recommendedLevel2,changeCourseMainPage.recommendedLevel3);
           logger.info("Recommended courses 2 and 3 are also displayed");
        }
    }

    @Test(dependsOnMethods ="checkRecommendedCourses")
    protected void checkTotalNoOfCoursesPresent() {
        logger.info("checkTotalNoOfCoursesPresent");
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.getPageLoadedCondition();
        changeCourseMainPage.simpleTest();
        checkTotalNoOfCourses(enabledCourses);
        logger.info("Total number of courses shown are correct");
    }


    @Test(dependsOnMethods ="checkTotalNoOfCoursesPresent")
     protected void checkNoOfLevelsInAllCourse() {
        logger.info("checkNoOfLevelsInTheCourse");
        changeCourseMainPage.totalLevelsInACourse(courseCodeNumber.getCourseNumber());
    }



    @Test(dependsOnMethods = "checkNoOfLevelsInAllCourse")
    protected void checkAllComponentsInTheSelectedLevel() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        int levelIndex = changeCourseMainPage.findSelectLevelIndex();
        changeCourseMainPage.levelLearnMoreLink(levelIndex,courseCodeNumber.getCourseCode());
        changeCourseMainPage.levelNumber(levelIndex,courseCodeNumber.getCourseCode());
        changeCourseMainPage.levelDescription(levelIndex,courseCodeNumber.getCourseCode());
        changeCourseMainPage.levelName(levelIndex,courseCodeNumber.getCourseCode());


    }

    public  void checkTotalNoOfCourses (EnabledCourses enabledCourses){

        switch (enabledCourses){
            case SPIN_TRUE_TOEFLTOEIC_TRUE:
                changeCourseMainPage.checkAllCoursesDisplayed(5);
                break;
            case SPIN_FALSE_TOEFLTOEIC_FALSE:
                changeCourseMainPage.checkAllCoursesDisplayed(1);
                break;
            case SPIN_FALSE_TOEFLTOEIC_TRUE:
                changeCourseMainPage.checkAllCoursesDisplayed(2);
                break;
            case SPIN_TRUE_TOEFLTOEIC_FALSE:
                changeCourseMainPage.checkAllCoursesDisplayed(4);
                break;
        }


        }


}








