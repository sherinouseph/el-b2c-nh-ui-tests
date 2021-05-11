package com.englishtown.tests.core.school;

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.enumpack.BillingTables;
import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;

import com.englishtown.enumpack.modules.TopicCardDetails;
import com.englishtown.helpers.*;

import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;

import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.newhouse.school.beanandenum.StepStatus;


import com.englishtown.newhouse.school.pages.account.*;

import com.englishtown.newhouse.school.pages.classroom.BookEFTVPage;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.ConversationClassPage;
import com.englishtown.newhouse.school.pages.classroom.CurrentBookingsPage;

import com.englishtown.newhouse.school.pages.course.appsandtools.AppsAndToolsPage;

import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseModulePage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.ChangeYourGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.pages.common.LoginPage;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsNot;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

public abstract class BaseSchoolSmokeTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseSchoolSmokeTest.class);

    int levelIndex=0;

    protected StudentBean studentBean;


    protected String currentgoalHours;
    protected String newgoalHours;

    protected CourseLevel courseLevel = CourseLevel.BEGINNERS_1;
    protected SchoolHeaderAndFooterPage schoolHeaderAndFooterPage;
    protected SchoolStudentBean schoolStudentBean;
    protected StepStatus stepStatus;
    protected ProgressPage progressPage;
    protected CourseCodeNumber courseCodeNumber;
    protected  ChangeYourGoalPage changeYourGoalPage;
    protected  String totalTime;
    protected int selectTopicIndex    = 0;
    protected int selectTimeSlotIndex = 0;
    protected CourseUnit courseUnit ;
    public String plLeftMsg = "testShouldSetThisUP"; // contains // test should set this up
    protected  int  index=0;


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void checkMyPageAllComponents(){
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.simpleTest();
        schoolHeaderAndFooterPage.checkAllPageComponentsDisplayed();
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
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
        conversationClassPage = new ConversationClassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        conversationClassPage.getPageLoadedCondition();
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
    //GL Page
    @Test (dependsOnMethods = "clickContinueStudyingTestCheckCurrentCourse")
    public void goToConversationGLpage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookGroupClass();
        conversationClassPage = new ConversationClassPage(getWebDriver());
        waitForUrlContains(getWebDriver(), "evc/gl?icid=School.GroupClass", 25);
        assertIsUrlContaining("evc/gl?icid=School.GroupClass");
    }

    @Test (dependsOnMethods = "goToConversationGLpage")
    public void checkConversationPageAllElements(){
        AssertHelper.assertWebElementDisplayed(conversationClassPage.classScheduleDropdownWe);
        conversationClassPage.checkAllPageComponentsDisplayed();
    }

    @Test (dependsOnMethods = "checkConversationPageAllElements")
    public void checkShowClassScheduleDaysDropdown(){
        sleep(3000);
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),conversationClassPage.classScheduleDropdownWe,5,1000);
        click(conversationClassPage.classScheduleDropdownWe);
        conversationClassPage = new ConversationClassPage(getWebDriver());
        waitForElementCondition(ExpectedConditions.visibilityOf(conversationClassPage.scheduleDaysListWe.get(6)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        //conversationClassPage.checkClassScheduleDaysAndTitleSize_isSeven();
        // click to close the popup
        click(conversationClassPage.classScheduleDropdownWe);
        waitForElementCondition(ExpectedConditions.invisibilityOf(conversationClassPage.scheduleDaysListWe.get(3)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertWebElementNotDisplayed(conversationClassPage.scheduleDaysListWe.get(3));
    }

    @Test (dependsOnMethods = "checkShowClassScheduleDaysDropdown")
    private void checkMyBookingsPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentBooking();
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.getPageLoadedCondition();
        currentBookingsPage.isBookALessonBtnShown();
        click(currentBookingsPage.bookALessonWe);
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.simpleTest();
    }


    @Test (dependsOnMethods = "checkMyBookingsPage")
    public void goToBookPrivateClassPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookPrivateClass();
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        bookPrivateLessonPage.getPageLoadedCondition();
        bookPrivateLessonPage.simpleTest();
    }

    @Test (dependsOnMethods = "goToBookPrivateClassPage")
    private void checkSelectTopicSectionShown(){
        AssertHelper.assertThat("User page is not at step 1 ; Select a topic is not active step ..!",
                bookPrivateLessonPage.isActiveStep("1"));
        bookPrivateLessonPage.checkSelectTopicSection();
    }

    @Test (dependsOnMethods = "checkSelectTopicSectionShown")
    private void checkTopicCardAllDetails(){
        logger.info("checkTopicCardAllDetails all topic card details ...");
        bookPrivateLessonPage.topicCardModule.checkAllTopicCardsElementsDisplayed(selectTopicIndex, false);
    }

    @Test (dependsOnMethods = "checkTopicCardAllDetails")
    private void selectTopicCard_checkTimeStepActive(){
        logger.info("selectTopicCard_checkTimeStepActive ...");
        click(bookPrivateLessonPage.topicCardModule.getCardElement(selectTopicIndex, TopicCardDetails.SELECT));
        logger.info("checkSelectTimeShown  ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.getPageLoadedCondition();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(bookPrivateLessonPage.activeStepWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertThat("SelectTime should be active and is not ....!",
                bookPrivateLessonPage.isActiveStep("2") );
    }


    @Test (dependsOnMethods = "selectTopicCard_checkTimeStepActive")
    private void selectATime(){
        logger.info("selectATime ...");
        bookPrivateLessonPage.selectTimeModule.simpleTest();
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex),WaitTool.LONG_WAIT_4_ELEMENT,1000);

        MyWebDriverAction.mouseOver(getWebDriver(), findElement(By.className("statusbar-edit")));
             sleep(100);
        click(bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex));
    }

    @Test (dependsOnMethods = "selectATime")
    private void bookingSummaryPageShown(){
        logger.info("bookingSummaryPageShown ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.bookPlSummaryModule.checkAllPageComponentsDisplayed();
    }

    @Test (dependsOnMethods = "bookingSummaryPageShown")
    private void checkClickToBookIsClickable(){
        logger.info("checkClickToBookIsClickable ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        waitForElementCondition(ExpectedConditions.elementToBeClickable(
                bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        logger.info("Book this class should be clickable by now ...");

    }

    @Test(dependsOnMethods ="checkClickToBookIsClickable")
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
        if(levelIndex==5) {
            changeCourseMainPage.clickOnLevel(6);
            schoolStudentBean.setLevelNumber(7);
        }
        else {
            changeCourseMainPage.clickOnLevel(5);
            schoolStudentBean.setLevelNumber(6);
        }
      AssertHelper.assertElementSizeEqual(getWebDriver(),changeCourseMainPage.recommendedCoursesWe,3);
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
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage.simpleTest();
        if(changeCourseMainPage.findSelectLevelIndex()!=levelIndex){
            logger.info( " Level changed to "+schoolStudentBean.getLevelNumber());
        }else{
            failTest("Level did not Change");
        }
    }

    @Test(dependsOnMethods = "checkLevelHasChanged")
    protected void clickOnProgressAndTestMenu() {
        logger.info("clickOnProgressAndTestMenu");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToProgressAndTests();
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.simpleTest();
    }
    @Test(dependsOnMethods = "clickOnProgressAndTestMenu")
    protected void checkCurrentLevelSelected(){
        logger.info("checkCurrentLevelSelected");
        waitForElementCondition(ExpectedConditions.visibilityOf(progressPage.progressTitleWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        if(courseCodeNumber.getCourseCode()=="GE") {
            int currentLevel = progressPage.getCurrentLevel((schoolStudentBean.getLevelNumber() - 1));
            logger.info("current level number is " + currentLevel);
            if (currentLevel == schoolStudentBean.getLevelNumber())
                logger.info("Current Level number is correct");
            else
                failTest("Level name incorrect");
        }else
            AssertHelper.assertWebElementDisplayed(progressPage.cardHeaderWe);

    }

    @Test(dependsOnMethods = "checkCurrentLevelSelected")
    protected void checkAllLevelsAndStagesAredisplayed(){
        if(courseCodeNumber.getCourseCode()=="GE") {
            logger.info("checkAllLevelsAndStagesAredisplayed");
            progressPage.assertTotalNumberOfLevelsAndStagesInGE();
        }
        else logger.info("No need to check levels and stages if the course is not General English");
    }

    @Test(dependsOnMethods = "checkAllLevelsAndStagesAredisplayed")
    protected void checkAllTabsAreDisplayed(){
        logger.info("checkAllTabsAreDisplayed");
        progressPage.assertTotalNumberOfMainTabs();
    }

    @Test(dependsOnMethods = "checkAllTabsAreDisplayed")
    protected void checkAllUnitsAredisplayed(){
        logger.info("checkAllUnitsAredisplayed");
        progressPage.assertTotalNumberOfUnits(courseCodeNumber.getCourseCode());
        progressPage.checkUnitComponents(schoolStudentBean.getUnitNumber()-1);
    }

    @Test(dependsOnMethods = "checkAllUnitsAredisplayed")
    protected void goToEFTVAndCheckIfBookEFTVBtnClickable(){
        logger.info("goToEFTVAndCheckIfBookEFTVBtnClickable");
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(),30);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookEFTV();
        bookEFTVPage=new BookEFTVPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        bookEFTVPage.getPageLoadedCondition();
        bookEFTVPage.checkAllPageComponentsDisplayed();
        bookEFTVPage.selectTimeModule.simpleTest();
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookEFTVPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex),WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        click(bookEFTVPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex));
        bookEFTVPage = new BookEFTVPage(getWebDriver());
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookEFTVPage.bookPlSummaryModule.bookThisClassBtnWe,WaitToolConfig.MED_WAIT_4_ELEMENT25,1000);
        bookEFTVPage.bookPlSummaryModule.checkAllPageComponentsDisplayedEFTV();
        logger.info("Book EFTV button is visible");
    }

    @Test(dependsOnMethods = "goToEFTVAndCheckIfBookEFTVBtnClickable")
    protected void goTocurrentCourse(){
        logger.info("goTocurrentCourse  ...!");
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(),30);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentCourse();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.simpleTest();
    }

    @Test(dependsOnMethods = "goTocurrentCourse")
    protected void checkInitialStatusOfSteps(){
        logger.info("checkInitialStatusOfSteps");
        AssertHelper.assertThat("Step 1 Status is not start",currentCourseUnitPage.getStepStatus(1),equalTo(stepStatus.START.getStepStatus()));
        AssertHelper.assertThat("Step 2 Status is not start",currentCourseUnitPage.getStepStatus(2),equalTo(stepStatus.START.getStepStatus()));
        logger.info("Click  button on first step");
    }


    @Test(dependsOnMethods = "checkInitialStatusOfSteps")
    protected void clickOnstartBtnOfFirstStep(){
        logger.info("clickOnstartBtnOfFirstStep");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(currentCourseUnitPage.stepNoWe.get(0)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
        click(currentCourseUnitPage.stepNoWe.get(0));
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.activityTitleWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("successfully navigated to first activity");

    }

    @Test(dependsOnMethods = "clickOnstartBtnOfFirstStep")
    protected void closeActivityWindow (){
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),currentCourseUnitPage.activityTitleWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertWebElementDisplayed(currentCourseUnitPage.activityMainClassWe);
        logger.info("Click on close button of the activity");
        click(currentCourseUnitPage.activityCloseBtnWe);
        waitForElementCondition(ExpectedConditions.invisibilityOf(currentCourseUnitPage.activityCloseBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = "closeActivityWindow")
    protected void checkCurrentGoal(){
        logger.info("checkCurrentGoal");
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

    }
    @Test(dependsOnMethods = "checkCurrentGoal")
    protected void checkAllComponentsGoalPage(){
        logger.info("checkAllComponents");
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        changeYourGoalPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponentsGoalPage")
    protected void getCurrentGoalHours(){
        logger.info("getCurrentGoalHours");
        currentgoalHours = changeYourGoalPage.getCurrentGoalHours();
        logger.info("current goal hours "+currentgoalHours);
    }

    @Test(dependsOnMethods = "getCurrentGoalHours")
    protected void clickOnChangeYourGoal(){
        logger.info("clickOnChangeYourGoal");
        changeYourGoalPage.clickOnChangeYourGoal();
        setNewGoalPage =new SetNewGoalPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.simpleTest();
        setNewGoalPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnChangeYourGoal")
    protected void setNewGoal(){
        logger.info("setNewGoal");
        if(StringUtils.equalsIgnoreCase(currentgoalHours,"3-5")) {
            logger.info("select 1-2 hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_1_2.getGoalHoursIndex());
            newgoalHours=studyGoals.GOAL_1_2.getGoalHours();

        }else{
            logger.info("select 3-5 hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_3_5.getGoalHoursIndex());
            newgoalHours=studyGoals.GOAL_3_5.getGoalHours();
        }
        setNewGoalPage.clickOnSetNewGoal();
    }

    @Test(dependsOnMethods = "setNewGoal")
    protected void checkNewGoalChange(){
        logger.info("checkNewGoalChange");
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.getPageLoadedCondition();
        changeYourGoalPage.simpleTest();
        waitForElementCondition(ExpectedConditions.visibilityOf(changeYourGoalPage.goalHoursWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertThat("New Goal hours wrong",changeYourGoalPage.getCurrentGoalHours(),equalToIgnoringCase(newgoalHours));
        logger.info("Goal hours was "+currentgoalHours+" Now change to "+newgoalHours);
    }

    @Test(dependsOnMethods = "checkNewGoalChange")
    public void goToProfilePage() {
        if(WebDriverFactory.browserName=="IE") {
            throw new SkipException("These Tests shouldn't  run in IE");
        }
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToMyAccountSetting();
        initMyAccountPage();
        myAccountPage.goToYourProfile();
        profilePage = new ProfilePage(getWebDriver(), 35);
        profilePage.getPageLoadedCondition();
        schoolStudentBean  = new SchoolStudentBean();
    }

    @Test(dependsOnMethods = "goToProfilePage")
    public void checkProfilePageElementsShown() {
        profilePage.checkAllPageComponentsDisplayed();
        sleep(1000);
        profilePage.checkPersonalDetailsNotEmptyOrNull();
    }

    @Test(dependsOnMethods = "checkProfilePageElementsShown")
    public void updateFirstName() {
        logger.info("update First Name ...!");
        schoolStudentBean = profilePage.getSchoolStudentBean();
        if(StringUtils.containsIgnoreCase(schoolStudentBean.getFirstName(),schoolStudentUpdatedBean.getFirstName()))
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.firstNameWe, schoolStudentUpdatedBean2.getFirstName());
        else
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.firstNameWe, schoolStudentUpdatedBean.getFirstName());
        sleep(700);
    }
    @Test(dependsOnMethods = "updateFirstName")
    public void checkMyAccountPageAllElements() {
        openPageUrl(myAccountPage);
        myAccountPage.checkAllPageComponentsDisplayed();
        myAccountPage.checkOfferDescription();
        myAccountPage.checkUsername(username);
        myAccountPage.checkLastBill();
        myAccountPage.checkNextBill();
        myAccountPage.checkPaymentMethod();
    }

    @Test (dependsOnMethods = "checkMyAccountPageAllElements")
    public void clickViewDetailsLink(){
        myAccountPage.clickViewDetailsLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        billingPage.getPageLoadedCondition();
    }

    @Test (dependsOnMethods = "clickViewDetailsLink")
    public void clickExploreYourUpgradeCheckBillingPage(){
        openPageUrl(myAccountPage);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.LONG_WAIT_4_ELEMENT);
        waitForUrlContains(getWebDriver(), "dashboard", WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.clickExploreUpgradeOptionLink();
        waitForUrlContains(getWebDriver(), "contact-us/", WaitTool.MED_WAIT_4_ELEMENT);
        AssertHelper.assertStringContains(getWebDriver().getCurrentUrl(),"contact-us/","User not navigated to contact us page");

    }
    @Test (dependsOnMethods = "clickExploreYourUpgradeCheckBillingPage")
    public void goToBillingPageFromAccountPageSubNav(){
        openPageUrl(myAccountPage);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.goToBilling();
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        billingPage.getPageLoadedCondition();
        billingPage.simpleTest();
    }

      @Test (dependsOnMethods = "goToBillingPageFromAccountPageSubNav")
    public void checkBillPageAllComponentsDisplayedTest(){
        billingPage.checkAllPageComponentsDisplayed();
        AssertHelper.assertThat("Table Heading is NULL or Empty...! ...!",
                billingPage.getTableColumnHeadingText(billingPage.getTable(BillingTables.PAYMENT), 0),
                IsNot.not(isEmptyOrNullString()));
        AssertHelper.assertThat("Table rows missing  ...!",
                billingPage.getTableRowNumber(billingPage.getTable(BillingTables.PAYMENT)),  Matchers.greaterThan(0));
          AssertHelper.assertThat("Table heading is NULL or Empty...! ...!",
                  billingPage.getTableColumnHeadingText(billingPage.getTable(BillingTables.SUBSCRIPTION), 2),
                  IsNot.not(isEmptyOrNullString()));
          String firstSubscriptionDate = billingPage.getTableCellText(billingPage.getTable(BillingTables.SUBSCRIPTION_ITEMS), 3);
          AssertHelper.assertThat("Subscription Expire Date is NULL or Empty...! ...!",firstSubscriptionDate, IsNot.not(isEmptyOrNullString()));
      }

    @Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void navigateToNotificationSettingsAndCheckElementsDisplayed(){
        openPageUrl(myAccountPage);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.goToEmailAndNotification();
        emailAndNotificationPage = new EmailAndNotificationPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        emailAndNotificationPage.getPageLoadedCondition();
        emailAndNotificationPage.checkAllPageComponentsDisplayed();
    }


    @Test(dependsOnMethods = "navigateToNotificationSettingsAndCheckElementsDisplayed")
    protected void clickOnAppsAndToolsMenu() {
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToAppsAndTools();
        appsAndToolsPage = new AppsAndToolsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        appsAndToolsPage.simpleTest();
        appsAndToolsPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnAppsAndToolsMenu")
    protected void checkAllAppsAreDisplayed() {
        logger.info("checkAllAppsAreDisplayed");
        appsAndToolsPage.checkAllAppsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllAppsAreDisplayed")
    protected void goToAssessmentTest() {
        logger.info("goToAssessmentTest");
        appsAndToolsPage.goToAssessmentTest();
        sleep(5000);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"test/placementtest/","Url doesn't contain placement");
    }

    @Test(dependsOnMethods = "goToAssessmentTest")
    protected void logoutAndCheckUserOutOfSchoolTest() {
        logger.info("checkUserIsAtSchoolHomePage  ...!" + waitForUrlContains);
        SchoolHeaderPage schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderPage.simpleTest();
        schoolHeaderPage.goToMyAccountAndLogout();
        loginPage = new LoginPage(getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
        loginPage.checkLoginBtnDisplayed();
    }

}










