package com.englishtown.tests.core.school.course.changecourse;
/**
 * Change course from one to another and check is changed
 *
 * This will get the current course BE or GE and change it ot BE or GE
 *
 * Sherin 07/02/18
 *
 *
 */
//SLEEP COMMAND TO BE REPLACED BY EXPLICIT WAIT

import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseModulePage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseChangeCourse extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangeCourse.class);

    public String activeCourse;
    protected boolean changeToSpealizationCourse;

    private  String totalTime;
    private String totalScore;



    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnChangeCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.getPageLoadedCondition();
        changeCourseMainPage.simpleTest();
        changeCourseMainPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods ="clickOnChangeCourseMenu")
    protected void getCurrentProgressOfCourse() {
        logger.info("getCurrentProgressOfCourse");
        activeCourse = changeCourseMainPage.activeCourseWe.getAttribute("href");
        getCurrentProgress();//this is  to save the current status of the courses before changing the course
    }

    @Test(dependsOnMethods ="getCurrentProgressOfCourse")
    protected void changeCourseTab() {
        logger.info("changeCourse");
        if (StringUtils.contains(activeCourse,"GE")) {
            logger.info("current course is GE");
                logger.info("if current course is GE, change it to Business course");
                changeCourseMainPage.clickOnCourse(courseCodeNumber.BUSINESS.getCourseNumber());
                changeToSpealizationCourse=true;
        } else {
              logger.info("current course is : Specialization course");
                logger.info("if current course is not GE, change it to GE course");
                changeCourseMainPage.clickOnCourse(courseCodeNumber.GENERAL_ENGLISH.getCourseNumber());
                changeToSpealizationCourse=false;
            }
    }

    @Test(dependsOnMethods = "changeCourseTab")
    protected void selectLevelInTheCourse() {
        logger.info("0 selectLevelInTheCourse ..currentTimeMillis/1000"+ System.currentTimeMillis()/1000);
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("1 selectLevelInTheCourse ..currentTimeMillis/1000"+ System.currentTimeMillis()/1000);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        logger.info("2 selectLevelInTheCourse ..currentTimeMillis/1000"+ System.currentTimeMillis()/1000);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        logger.info("3 selectLevelInTheCourse ..currentTimeMillis/1000"+ System.currentTimeMillis()/1000);
        changeCourseMainPage.getPageLoadedCondition();
        if(changeToSpealizationCourse){
            WaitTool.waitForElementClickable_fluentWait(getWebDriver(),changeCourseMainPage.levelListWe.get(0),8,1000);
           // waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(0)),
                    //getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
            logger.info("changeToSpealizationCourse 4 selectLevelInTheCourse ..currentTimeMillis/1000"+ System.currentTimeMillis()/1000);
            changeCourseMainPage.clickOnLevel(0);}//change it first level of the specialization course
        else {
            //JavaScriptHelper.scrollToXY(getWebDriver(), 0, 600);
            WaitTool.waitForElementClickable_fluentWait(getWebDriver(),changeCourseMainPage.levelListWe.get(5),8,1000);
//            waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(5)),
//                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
            logger.info("5 selectLevelInTheCourse ..currentTimeMillis/1000"+ System.currentTimeMillis()/1000);
            changeCourseMainPage.clickOnLevel(5);
        }//chnage it to level 6 of the ge course
    }


    @Test(dependsOnMethods = "selectLevelInTheCourse")
    protected void checkAllComponentsInTheSelectedLevel() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("1");
        //todo this takes forever .... INV
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),changeCourseModulePage.changeToThisCourseBtnWe,8,1000);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeToThisCourseBtnWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        logger.info("2");
        changeCourseModulePage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponentsInTheSelectedLevel")
    protected void clickOnchangeTothisCourse() {
        logger.info("clickOnchangeTothisCourse");
        changeCourseModulePage.clickChangeToThisCourseBtn();
    }

    @Test(dependsOnMethods = "clickOnchangeTothisCourse")
    protected void checkPopUpcontent() {
        logger.info("checkPopUpcontent");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),changeCourseModulePage.changeCoursepopUptitleWe,8,1000);
//        waitForElementCondition(ExpectedConditions.visibilityOf(changeCourseModulePage.changeCoursepopUptitleWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseModulePage.assertChangeCoursePopUpElements();
    }

    @Test(dependsOnMethods = "checkPopUpcontent")
    protected void clickOnChangeCourseBtnPopUp() {
        logger.info("clickOnChangeCourseBtnPopUp");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),changeCourseModulePage.changeCoursepopUptitleWe,8,1000);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCoursePopUpBtnWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.clickChangeCoursePopUpBtn();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(),"studyplan",WaitTool.MED_WAIT_4_ELEMENT25);
    }

    /// todo close popup then do the rest
    //    @Test(dependsOnMethods = "clickOnchangeTothisCourse")
//    protected void clickOnCancelBtnInThePopUp() {
//        logger.info("clickOnCancelBtnInThePopUp");
//        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCourseCancelPopUpBtnWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        changeCourseModulePage.clickChangeCourseCancelBtn();
//    }
    @Test(dependsOnMethods = "clickOnChangeCourseBtnPopUp")
    protected void checkCourseHasChanged() {
        logger.info("checkCourseHasChanged");
        openPageUrl(changeCourseMainPage);
        //schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage.simpleTest();
        if(changeCourseMainPage.activeCourseWe.getAttribute("href")!=activeCourse){
            logger.info("Course successfully changed");
        }else{
            failTest("Course did not Change");
        }
    }

//    @Test(dependsOnMethods = "checkCourseHasChanged")
//    protected void checkProgressAndTest() {
//        logger.info("checkProgressAndTest");
//        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
//        openPageUrl(progressPage);
//        //schoolHeaderAndFooterPage.schoolHeaderPage.goToProgressAndTests();
//        waitForElementCondition(ExpectedConditions.visibilityOf(progressPage.progressTitleWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        if(!changeToSpealizationCourse){
//            logger.info("Go to General English Course and check if the progress of the course is maintained");
//            click(progressPage.subMenusWe.get(0));
//            progressPage =new ProgressPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//            progressPage.getPageLoadedCondition();
//            //  // todo .. need to setup user live and qa
//            //progressPage.assertTotalTime(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,schoolStudentBean.getTotalTime(), courseCodeNumber.GENERAL_ENGLISH.getCourseCode());
//            //progressPage.assertTotalScore(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,schoolStudentBean.getTotalScore(), courseCodeNumber.GENERAL_ENGLISH.getCourseCode());
//
//        }else{
//            logger.info("Go to Special Interest Course and check if the progress of the course is maintained");
//            click(progressPage.subMenusWe.get(1));
//            progressPage =new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//            progressPage.getPageLoadedCondition();
//            // todo .. need to setup the user
//            //progressPage.assertTotalTime(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,schoolStudentBean.getTotalTime(), courseCodeNumber.BUSINESS.getCourseCode());
//            //progressPage.assertTotalScore(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,schoolStudentBean.getTotalScore(), courseCodeNumber.BUSINESS.getCourseCode());
//
//        }
//    }


    public void getCurrentProgress(){
        logger.info("current progress");
        if (StringUtils.contains(activeCourse,"GE")){
           // schoolStudentBean.setTotalTime("28");
            schoolStudentBean.setTotalScore("100");
            logger.info("Total time :"+schoolStudentBean.getTotalTime()+ "total Score :"+schoolStudentBean.getTotalScore());
        }else{
            //schoolStudentBean.setTotalTime("1");
            schoolStudentBean.setTotalScore("100");
            logger.info("Total time : "+schoolStudentBean.getTotalTime()+ "total Score : "+schoolStudentBean.getTotalScore());
        }


    }

}








