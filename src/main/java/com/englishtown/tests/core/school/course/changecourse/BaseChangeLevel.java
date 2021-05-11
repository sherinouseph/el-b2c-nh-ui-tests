package com.englishtown.tests.core.school.course.changecourse;
/**
 * check the current course
 *
 * Sherin 07/02/18
 *
 *
 */
//SLEEP COMMAND TO BE REPLACED BY EXPLICIT WAIT

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.beanandenum.EnabledCourses;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseModulePage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseChangeLevel extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangeLevel.class);

    int levelIndex;

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnChangeCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.LONG_WAIT_4_ELEMENT);
        //changeCourseMainPage.getPageLoadedCondition();
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),changeCourseMainPage.levelListWe.get(levelIndex), WaitTool.SHORT_WAIT_4_ELEMENT,1000);



    }

    @Test(dependsOnMethods ="clickOnChangeCourseMenu")
    public void checkRecommendedCourses(){
        logger.info("checkRecommendedCourses");
        AssertHelper.assertWebElementDisplayed(changeCourseMainPage.recommendedLevel1);
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

    @Test(dependsOnMethods = "checkAllComponentsInTheSelectedLevel")
    protected void selectLevelInTheCourse() {
        logger.info("selectLevelInTheCourse");
        changeCourseMainPage=new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        levelIndex=changeCourseMainPage.findSelectLevelIndex();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(levelIndex)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        if(levelIndex==5)
            changeCourseMainPage.clickOnLevel(6);
        else {
//            changeCourseMainPage.checkAllPageComponentsDisplayed(changeCourseMainPage.recommendedCourse2, changeCourseMainPage.recommendedCourse3);
//            logger.info("Recommended courses 2 and 3 are also displayed");
            changeCourseMainPage.clickOnLevel(5);
        }

    }

    @Test(dependsOnMethods = "selectLevelInTheCourse")
    protected void checkComponentsInTheSelectedLevel() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        sleep(2000);
        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeToThisCourseBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.checkAllPageComponentsDisplayed();

    }

    @Test(dependsOnMethods = "checkComponentsInTheSelectedLevel")
    protected void clickOnchangeTothisCourse() {
        logger.info("clickOnchangeTothisCourse");
        changeCourseModulePage.clickChangeToThisCourseBtn();
        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.visibilityOf(changeCourseModulePage.changeCoursepopUpContentWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);

    }

    @Test(dependsOnMethods = "clickOnchangeTothisCourse")
    protected void checkPopUpcontent() {
        logger.info("checkPopUpcontent");
        waitForElementCondition(ExpectedConditions.visibilityOf(findElement(By.className("btn-change-course"))),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.assertChangeCoursePopUpElements();
    }

    @Test(dependsOnMethods = "checkPopUpcontent")
    protected void clickOnChangeCourseBtnPopUp() {
        logger.info("clickOnChangeCourseBtnPopUp");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCoursePopUpBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseModulePage.clickChangeCoursePopUpBtn();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(),"studyplan",WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "clickOnChangeCourseBtnPopUp")
    protected void checkLevelHasChanged() {
        logger.info("checkLevelHasChanged");
        sleep(1000);
        //openPageUrl(changeCourseMainPage);
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage.simpleTest();
        if(changeCourseMainPage.findSelectLevelIndex()!=levelIndex){
            logger.info("Level was "+ levelIndex +" Now Changed to Level "+changeCourseMainPage.findSelectLevelIndex());
        }else{
            failTest("Level did not Change");
        }
    }

    public  void checkTotalNoOfCourses (EnabledCourses enabledCourses) {

        switch (enabledCourses) {
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








