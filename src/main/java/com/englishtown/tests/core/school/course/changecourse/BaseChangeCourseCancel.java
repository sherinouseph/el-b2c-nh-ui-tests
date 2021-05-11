//package com.englishtown.tests.core.school.course.changecourse;
///**
// * check the current course
// *
// * Sherin 07/02/18
// *
// *
// */
////SLEEP COMMAND TO BE REPLACED BY EXPLICIT WAIT
//
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
//import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseModulePage;
//import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
//import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
//import com.englishtown.tests.core.school.BaseSimpleLogin;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//
//public abstract class BaseChangeCourseCancel extends BaseSimpleLogin {
//    private static final Logger logger = LoggerFactory.getLogger(BaseChangeCourseCancel.class);
//
//    public String activeCourse;
//    protected boolean changeToSpealizationCourse;
//
//    private  String totalTime;
//    private String totalScore;
//
//
//
//    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
//    protected void clickOnChangeCourseMenu() {
//        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
//        initSchoolHeaderAndFooter();
//        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
//        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//        changeCourseMainPage.simpleTest();
//        changeCourseMainPage.checkAllPageComponentsDisplayed();
//    }
//
//
//    @Test(dependsOnMethods ="clickOnChangeCourseMenu")
//    protected void changeCourseTab() {
//        logger.info("Change to Business Course Tab");
//        changeCourseMainPage.clickOnCourse(courseCodeNumber.BUSINESS.getCourseNumber());
//
//    }
//
//    @Test(dependsOnMethods = "changeCourseTab")
//    protected void selectLevelInTheCourse() {
//        changeCourseMainPage=new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//        logger.info("selectLevelInTheCourse");
//        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        waitForElementCondition(ExpectedConditions.visibilityOf(changeCourseMainPage.currentLevelTextWe),
//                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        changeCourseMainPage.clickOnLevel(1);//change it first level of the specialization course
//
//    }
//
//
//    @Test(dependsOnMethods = "selectLevelInTheCourse")
//    protected void clickOnchangeTothisCourse() {
//        logger.info("clickOnchangeTothisCourse");
//        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//        changeCourseModulePage.simpleTest();
//        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        waitForElementCondition(ExpectedConditions.visibilityOf(changeCourseModulePage.changeToThisCourseBtnWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        changeCourseModulePage.clickChangeToThisCourseBtn();
//    }
//
//
//    @Test(dependsOnMethods = "clickOnchangeTothisCourse")
//    protected void clickOnCancelBtnInThePopUp() {
//        logger.info("clickOnCancelBtnInThePopUp");
//        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCourseCancelPopUpBtnWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        changeCourseModulePage.clickChangeCourseCancelBtn();
//    }
//
//    @Test(dependsOnMethods = "clickOnCancelBtnInThePopUp")
//    protected void checkCourseHasChanged() {
//        logger.info("checkCourseHasChanged");
//        openPageUrl(changeCourseMainPage);
//        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
//        changeCourseMainPage.simpleTest();
//        if(StringUtils.contains(changeCourseMainPage.activeCourseWe.getAttribute("href"),courseCodeNumber.getCourseCode()))
//            logger.info("Course did not Change ");
//        else
//            failTest("Course Changed even after clicking on cancel button");
//
//    }
//
//    @Test(dependsOnMethods = "checkCourseHasChanged")
//    protected void checkProgressAndTest() {
//        logger.info("checkProgressAndTest");
//        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
//        openPageUrl(progressPage);
//        waitForElementCondition(ExpectedConditions.visibilityOf(progressPage.progressTitleWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        progressPage =new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//        progressPage.assertTotalTime(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,schoolStudentBean.getTotalTime(), courseCodeNumber.getCourseCode());
//        progressPage.assertTotalScore(schoolStudentBean.getUnitNumber()-1,schoolStudentBean.getLessonNumber()-1,schoolStudentBean.getTotalScore(),courseCodeNumber.getCourseCode());
//
//    }
//
//
//
//}
//
//
//
//
//
//
//
//
