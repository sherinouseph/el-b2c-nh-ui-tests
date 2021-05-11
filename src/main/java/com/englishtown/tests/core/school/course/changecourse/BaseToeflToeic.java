package com.englishtown.tests.core.school.course.changecourse;
/**
 * Base Toefl toeic test
 * go to change course menu
 * click on toefl course
 * Check if the all the components are displayed
 * iterate the same steps for TOEIC
 *
 *
 * Sherin 19/02/2018
 *
 * Niko: updated to new house and click on trainer link
 *
*/

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ToeflToeicPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseToeflToeic extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseToeflToeic.class);


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnChangeCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.getPageLoadedCondition();
        changeCourseMainPage.simpleTest();
    }

    @Test(dependsOnMethods ="clickOnChangeCourseMenu")
    protected void clickOnToeflCourse() {
        logger.info("clickOnToeflCourse");
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.clickOnCourse(courseCodeNumber.TOEFL_TOEIC_PREP.getCourseNumber());

        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(0)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        clickListWebElement(getWebDriver(),By.cssSelector("#TT a"),toeflToeicLevels.TT_TOEFL.getLevelNumber());
        logger.info("successfully clicked on Toefl course");
    }

    @Test(dependsOnMethods ="clickOnToeflCourse")
    protected void  checkToeflPageTest(){  //switchToToeflIframeAndCheckComponents() {
        logger.info("checkToeflPageTest");
        checkToeflToickPage();
    }

    @Test(dependsOnMethods ="checkToeflPageTest")
    protected void  clickOnTrainerSpeakAndWriteAndCheckNextPageShown(){  //switchToToeflIframeAndCheckComponents() {
        logger.info("checkToeflPageTest");
        click(toeflToeicPage.toeflSpeckWriteWe);
        //todo open once fixed ... waitForElementCondition(ExpectedConditions.elementToBeClickable(By.id("tBar")), getWebDriver(), 15);
    }

    @Test(dependsOnMethods ="clickOnTrainerSpeakAndWriteAndCheckNextPageShown")  //switchToToeflIframeAndCheckComponents")
    protected void clickOnToeicTrainerSpeakWrite() {
        logger.info("clickOnToeicTrainerSpeakWrite");
        //openPageUrl(changeCourseMainPage);
        openUrl(getWebDriver(), getBASEURL() + SCHOOL_BASE_DOMAIN + changeCourseMainPage.getPageUrl());
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.getPageLoadedCondition();
        changeCourseMainPage.simpleTest();
        changeCourseMainPage.clickOnCourse(courseCodeNumber.TOEFL_TOEIC_PREP.getCourseNumber());

        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(1)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        clickListWebElement(getWebDriver(),By.cssSelector("#TT a"),toeflToeicLevels.TT_TOEIC.getLevelNumber());
        logger.info("successfully clicked on toeic course");
    }

    @Test(dependsOnMethods ="clickOnToeicTrainerSpeakWrite")
    public void checkToickPageTest( ){
        checkToickPage();
    }

    @Test(dependsOnMethods ="checkToickPageTest")
    protected void  clickOnTOEICTrainer_CheckNextPageShown(){  //switchToToeflIframeAndCheckComponents() {
        logger.info("checkToeflPageTest");
        click(toeflToeicPage.toeicTrainerWe);
        //todo open once fixed ... waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".et-main-left a")), getWebDriver(), 25);
    }
//todo open once fixed ...
    /*@Test(dependsOnMethods ="clickOnTOEICTrainer_CheckNextPageShown")
    protected void  clickStartYourToeicPreTest_CheckNextPageShown(){  //switchToToeflIframeAndCheckComponents() {
        logger.info("checkToeflPageTest");
        click(findElement(By.cssSelector(".et-main-left a")));
        //form input[src^="/images  next button
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector("form input[src^='/images']")),
                getWebDriver(), 25);
    }*/

    /*@Test(dependsOnMethods ="clickOnToeicTrainerSpeakWrite")
    protected void switchToToickIframeAndCheckComponents() {
        logger.info("switchToIframeAndCheckComponents - TOEIC");
        checkToeflToickPage();
    }*/


    public void checkToeflToickPage( ){
        logger.info("checkToeflToickPage ...!");
        toeflToeicPage = new ToeflToeicPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

        toeflToeicPage.getPageLoadedCondition();
        //waitForElementCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(toeflToeicPage.iframeToefl),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        /*WebDriverWindowHelper.switchToFrameByName(getWebDriver(), toeflToeicPage.iframeName); //   getWebDriver().switchTo().frame(toeflToeicPage.iframeName);
        waitForElementCondition(ExpectedConditions.visibilityOf(toeflToeicPage.titleWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);*/
        toeflToeicPage. moveToIframe();
        toeflToeicPage.checkAllPageComponentsDisplayed();
    }

    public void checkToickPage( ){
        logger.info("checkToeflToickPage ...!");
        toeflToeicPage = new ToeflToeicPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        toeflToeicPage.moveToIframe();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(toeflToeicPage.TOEIC_TRAINER)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

}




//not needed the below test as the whole thing is inside an iframe,we just need to check if the iframe is loaded .

//    @Test(dependsOnMethods = "switchToIframeAndCheckAllComponents")
//    protected void checkAlltrainerCoursesLink() {
//        logger.info("checkAlltrainerCoursesLink");
//        toeflPage.clickOnspeakingAndWriting();
//        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"TofelToeic/ToeicTofelContainer.aspx?visitType=tofel","url incorrect");
//        toeflPage.clickOnListeningAndReading();
//        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"TofelToeic/ToeicTofelContainer.aspx?visitType=tofel","url incorrect");
//    }
//
//
//    @Test(dependsOnMethods = "checkAlltrainerCoursesLink")
//    protected void checkAllPractiseTestLinks() {
//        logger.info("checkAllPractiseTestLinks");
//        toeflPage.clickOnEachPractiseTest();
//    }
//
//
//










