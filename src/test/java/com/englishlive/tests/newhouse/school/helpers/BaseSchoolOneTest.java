package com.englishlive.tests.newhouse.school.helpers;

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.enumpack.chat.ChatUserStatus;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolPageName;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.newhouse.school.beanandenum.StepStatus;
import com.englishtown.newhouse.school.beanandenum.bean.StudentSecurityDetails;
import com.englishtown.newhouse.school.beanandenum.enums.Enroll;
import com.englishtown.newhouse.school.pages.account.*;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.ConversationClassPage;
import com.englishtown.newhouse.school.pages.core.ISchoolPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.AppsAndToolsPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.GrammarlabPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseModulePage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.ChangeYourGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.newhouse.school.pages.support.newhouse.SupportPage;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.school.BaseLogin;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

//depends on the need extend this class to BaseEnrollmentAllTest or BaseLogin

public abstract class BaseSchoolOneTest extends BaseLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseSchoolOneTest.class);
    protected String waitForUrlContains = "campus/mypage/home"; // test should set this up
    public static final String SCHOOL_BASE_DOMAIN = "englishlive.ef.com";
    int levelIndex;
    protected String upsellUrl = ""; // test set this up "englishlive.ef.com/en-gb/buy/upsell/upsell?ctr=gb";

    protected String currencySymbol; // e.g £ $
    protected String initialTotalPriceTxt = "£0.00";
    protected String currentTotalPriceTxt;
    protected double initialTotalPrice = 0.00;
    protected double currentTotalPrice;
    protected double prevCurrentTotalPrice;

    protected int offerRowIndex = 1;                  // add this product
    protected int otherOfferRowIndex = offerRowIndex + 3; // add this product when second product added


    protected StudentBean studentBean;
    protected StudentSecurityDetails studentSecurityDetails;
    public String closeButtonTimeZone = "fancybox-close";//".timezone-management-form-submit"
    public boolean isNewHouseUser = false; // use this to update the urls with /1/ for new house users
    public String closeRecommendPopupCss = "fancybox-close"; // a popup is shown on login ... could be one of 2 change clock on survey
    public String recommendSurveyFrameCss = ".fancybox-outer iframe";
    public static final int recommendPopupWaitTimeSec = WaitTool.SHORT_WAIT_4_ELEMENT;  // time to wait popup shown then close

    public static final String BASECALLBACK = "var callback = arguments[arguments.length - 1];" + "et.state.get('";
    public static final String BASECALLBACKTHEN = "').then(function(v){callback(v[0])})";
    public static final String MEMBERID_KEY = BASECALLBACK + "user.member_id" + BASECALLBACKTHEN;
    public static final String EFID_KEY = BASECALLBACK + "user.ef_id" + BASECALLBACKTHEN;

    public int numberOfUsersToCreate = 2;
    public List<ChatTestUserBean> userBeanList = new ArrayList<>();

    protected String memberPageUrl = "englishlive.ef.com/en-gb/buy/default/member/?ctr=gb";

    protected String currentgoalHours;

    public String activeCourse;
    protected boolean changeToSpealizationCourse;
    protected String newgoalHours;

    protected int numberOfCoursesAvailable = 5; // on change course page todo ... add this to student bean

    /**
     * Test should setup this data
     */
    protected String goalDaysLef;   // e.g 0 day(s) left
    protected String goalPaceMsg;   // e.g YOU MISSED YOUR STUDY GOAL
    protected String goalStudyPace; // e.g 3-5 Hours Weekly shown for current goal if not set to own pace
    protected String goalDate;      // e.g Feb 8 2018
    protected CourseLevel courseLevel = CourseLevel.BEGINNERS_1;
    protected SchoolHeaderAndFooterPage schoolHeaderAndFooterPage;
    protected SchoolStudentBean schoolStudentBean;
    protected StepStatus stepStatus;
    private String loginUrl = "qa.school.englishlive.ef.com";
    protected ProgressPage progressPage;
    protected CourseCodeNumber courseCodeNumber;
    protected ChangeYourGoalPage changeYourGoalPage;
    protected String totalTime;
    protected int selectTopicIndex = 0;
    protected int selectTimeSlotIndex = 0;
    protected CourseUnit courseUnit;
    public String plLeftMsg = "testShouldSetThisUP"; // contains // test should set this up
    public String noGlLeft = "testShouldSetThisUP"; // contains // test should set this up
    public String totalGl = "testShouldSetThisUP";
    protected String noOfPLsAvailable;
    protected int index = 0;
    protected boolean isPLWithin24hrs = false;
    protected String teachername = "f f.BELive";


    @Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")//if test  requires no enrollment use this
    //@Test(dependsOnMethods = "checkStartLearningPage")//if test is for enrollment, use this
    protected void checkMyPageAllComponents() {
        sleep(2000);
        //getWebDriver().findElement(By.cssSelector(".timezone-management-form-submit")).click();
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
    }

    //if Kafka Test requires Booking and cancellation uncomment this

//    @Test (dependsOnMethods = "checkMyPageAllComponents")
//    public void goToBookPrivateClassPage(){
//        initSchoolHeaderAndFooter();
//        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookPrivateClass();
//        //sleep(2000);
//        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        waitForElementCondition(ExpectedConditions.visibilityOf(bookPrivateLessonPage.plbHeaderWE),
//                getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
//        //bookPrivateLessonPage.getPageLoadedCondition();
//        //bookPrivateLessonPage.simpleTest();
//    }
//
//    @Test (dependsOnMethods = "goToBookPrivateClassPage")
//    private void selectTopicCard_checkTimeStepActive(){
//        logger.info("selectTopicCard_checkTimeStepActive ...");
//        click(bookPrivateLessonPage.topicCardModule.getCardElement(selectTopicIndex, TopicCardDetails.SELECT));
//        logger.info("checkSelectTimeShown  ...");
//        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
//        bookPrivateLessonPage.getPageLoadedCondition();
//    }
//
//    @Test (dependsOnMethods = "selectTopicCard_checkTimeStepActive")
//    private void selectATeacherAndTime(){
//        logger.info("selectATime ...");
//        JavaScriptHelper.scrollToXY(getWebDriver(),0,-2000);
//        click(findElement(By.cssSelector("a[href='#allAvailable']")));
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".plb-glyphicon-arrow-right")),getWebDriver(),WaitTool.LONG_WAIT_4_ELEMENT);
//        bookPrivateLessonPage=new BookPrivateLessonPage(getWebDriver(),25);
//        bookPrivateLessonPage.selectTimeModule.simpleTest();
//        if(!isPLWithin24hrs)
//            click(bookPrivateLessonPage.selectTimeModule.rightTimeArrowWe);
//        bookPrivateLessonPage=new BookPrivateLessonPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(
//                bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex)), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
//        click(bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex));
//    }
//
//
//    @Test (dependsOnMethods = "selectATeacherAndTime")
//    private void clickOnBookPL(){
//        logger.info("clickOnBookPL ...");
//        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(
//                bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
//        click( bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe);
//        logger.info("clicked on book PL button successfully");
//    }
//
//    @Test (dependsOnMethods = "clickOnBookPL")
//    private void checkIfUserIsInMyBookingsPage(){
//        logger.info("checkIfUSerIsInMyBookingsPage ...");
//        sleep(2000);
//        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
////        waitForElementCondition(ExpectedConditions.visibilityOf(
////                currentBookingsPage.getClassNotOpenWe(index)), getWebDriver(),  WaitTool.LONG_WAIT_4_ELEMENT);
//        currentBookingsPage.getPageLoadedCondition();
//        currentBookingsPage.simpleTest();
//        //currentBookingsPage.checkAllComponentsWhenbookingIsDone(index);
//        //AssertHelper.assertWebElementDisplayed(currentBookingsPage.getClassNotOpenWe(index));
//
//    }
//
//    @Test (dependsOnMethods = "checkIfUserIsInMyBookingsPage")
//    private void goToMybookingsandclickOnCancel(){
//        logger.info("goToMybookingsandclickOnCancel");
//        //schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentBooking();
//        currentBookingsPage.clickOnCancelLink(index);
//        logger.info("check if Dont cancel Lesson Link is displayed ...");
//        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        currentBookingsPage.checkDontCancelLinkIsDisplayed(index);
//        currentBookingsPage.checkCancellationMessage(index);
//        logger.info("click on confirm cancel link");
//        currentBookingsPage.clickOnCancelConfirmLink(index);
//    }

//@Test(dependsonMethods="goToMybookingsandclickOnCancel")
    @Test(dependsOnMethods = "checkMyPageAllComponents")
    protected void goTocurrentCourse() {
        logger.info("goTocurrentCourse  ...!");
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), 30);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentCourse();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.simpleTest();
        sleep(10000);
    }

    @Test(dependsOnMethods = "goTocurrentCourse")
    protected void checkCurrentGoal() {
        logger.info("checkCurrentGoal");
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "checkCurrentGoal")
    protected void checkAllComponentsGoalPage() {
        logger.info("checkAllComponents");
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        changeYourGoalPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponentsGoalPage")
    protected void getCurrentGoalHours() {
        logger.info("getCurrentGoalHours");
        currentgoalHours = changeYourGoalPage.getCurrentGoalHours();
        sleep(3000);
        logger.info("current goal hours " + currentgoalHours);
    }

    @Test(dependsOnMethods = "getCurrentGoalHours")
    protected void clickOnChangeYourGoal() {
        logger.info("clickOnChangeYourGoal");
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 150);
        sleep(2000);
        changeYourGoalPage.clickOnChangeYourGoal();
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.simpleTest();
        setNewGoalPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnChangeYourGoal")
    protected void setNewGoal() {
        logger.info("setNewGoal");
        logger.info("current goalhours = " + currentgoalHours);
        if (StringUtils.equalsIgnoreCase(currentgoalHours, "5+")) {
            logger.info("select 3-5 hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_3_5.getGoalHoursIndex());
            sleep(3000);
            newgoalHours = studyGoals.GOAL_3_5.getGoalHours();
        } else if (StringUtils.equalsIgnoreCase(currentgoalHours, "3-5")) {
            logger.info("select 1-2 hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_1_2.getGoalHoursIndex());
            newgoalHours = studyGoals.GOAL_1_2.getGoalHours();

        } else {
            logger.info("select 5+ hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_5_PLUS.getGoalHoursIndex());
            newgoalHours = studyGoals.GOAL_5_PLUS.getGoalHours();
        }
        setNewGoalPage.clickOnSetNewGoal();
    }

    @Test(dependsOnMethods = "setNewGoal")
    protected void checkNewGoalChange() {
        logger.info("checkNewGoalChange");
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.getPageLoadedCondition();
        changeYourGoalPage.simpleTest();
        waitForElementCondition(ExpectedConditions.visibilityOf(changeYourGoalPage.goalHoursWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertThat("New Goal hours wrong", changeYourGoalPage.getCurrentGoalHours(), equalToIgnoringCase(newgoalHours));
        logger.info("Goal hours was " + currentgoalHours + " Now change to " + newgoalHours);
    }


    @Test(dependsOnMethods = "checkNewGoalChange")
    protected void clickOnChangeCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(2000);
        changeCourseMainPage.simpleTest();
        changeCourseMainPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnChangeCourseMenu")
    protected void getCurrentProgressOfCourse() {
        sleep(4000);
        logger.info("getCurrentProgressOfCourse");
        activeCourse = changeCourseMainPage.activeCourseWe.getAttribute("href");
    }

    @Test(dependsOnMethods = "getCurrentProgressOfCourse")
    protected void changeCourseTab() {
        logger.info("changeCourse");
        if (StringUtils.contains(activeCourse, "GE")) {
            logger.info("if current course is not GE, change it to GE course");
            changeCourseMainPage.clickOnCourse(courseCodeNumber.GENERAL_ENGLISH.getCourseNumber());
            changeToSpealizationCourse = false;
        }
    }

    @Test(dependsOnMethods = "changeCourseTab")
    protected void selectLevelInTheCourse() {
        logger.info("selectLevelInTheCourse");
        sleep(3000);
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        levelIndex = changeCourseMainPage.findSelectLevelIndex();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(levelIndex)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.scrollToXY(getWebDriver(),0,3500);
        if (levelIndex == 5)
            changeCourseMainPage.clickOnLevel(6);
        else
            changeCourseMainPage.clickOnLevel(5);

    }

    @Test(dependsOnMethods = "selectLevelInTheCourse")
    protected void checkAllComponentsInTheSelectedLevel() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeToThisCourseBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.checkAllPageComponentsDisplayed();

    }

    @Test(dependsOnMethods = "checkAllComponentsInTheSelectedLevel")
    protected void clickOnchangeTothisCourse() {
        logger.info("clickOnchangeTothisCourse");
        changeCourseModulePage.clickChangeToThisCourseBtn();
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
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
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(), "studyplan", WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "clickOnChangeCourseBtnPopUp")
    protected void checkLevelHasChanged() {
        logger.info("checkLevelHasChanged");
        sleep(5000);
        //openPageUrl(changeCourseMainPage);
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        //changeCourseMainPage.simpleTest();
        changeCourseMainPage.getPageLoadedCondition();
        if (changeCourseMainPage.findSelectLevelIndex() != levelIndex) {
            logger.info("Level was " + levelIndex + " Now Changed to Level " + changeCourseMainPage.findSelectLevelIndex());
        } else {
            failTest("Level did not Change");
        }
    }


    @Test(dependsOnMethods = "checkLevelHasChanged")
    protected void changeCourseTabBE() {
        logger.info("if current course is GE, change it to Business course");
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), 10);
        changeCourseMainPage.clickOnCourse(courseCodeNumber.BUSINESS.getCourseNumber());
        changeToSpealizationCourse = true;
    }

    @Test(dependsOnMethods = "changeCourseTabBE")
    protected void selectLevel3BE() {
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        changeCourseMainPage.getPageLoadedCondition();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(2)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseMainPage.clickOnLevel(2);
  }

    @Test(dependsOnMethods = "selectLevel3BE")
    protected void checkAllComponentsInTheSelectedLevel3() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeToThisCourseBtnWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseModulePage.clickChangeToThisCourseBtn();
    }

    @Test(dependsOnMethods = "checkAllComponentsInTheSelectedLevel3")
    protected void clickOnChangeCourseBtnPopUp3() {
        logger.info("clickOnChangeCourseBtnPopUp");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCoursePopUpBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.clickChangeCoursePopUpBtn();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(),"studyplan",WaitTool.MED_WAIT_4_ELEMENT25);
    }
    @Test(dependsOnMethods = "clickOnChangeCourseBtnPopUp3")
    protected void changeGoalBE() {
        logger.info("checkCurrentGoal");
        sleep(8000);
        //currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 150);
        sleep(2000);
        changeYourGoalPage.clickOnChangeYourGoal();
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.simpleTest();
        logger.info("select 1-2 hours ");
        setNewGoalPage.selectNewGoal(studyGoals.GOAL_1_2.getGoalHoursIndex());
        newgoalHours = studyGoals.GOAL_1_2.getGoalHours();
        setNewGoalPage.clickOnSetNewGoal();
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.getPageLoadedCondition();
        changeYourGoalPage.simpleTest();
        waitForElementCondition(ExpectedConditions.visibilityOf(changeYourGoalPage.goalHoursWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

        AssertHelper.assertThat("New Goal hours wrong", changeYourGoalPage.getCurrentGoalHours(), equalToIgnoringCase(newgoalHours));
        logger.info("Goal hours was " + currentgoalHours + " Now change to " + newgoalHours);
    }

    @Test(dependsOnMethods ="changeGoalBE")
    protected void changeCourseTabIND() {
        logger.info(" change it to Industry course");
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage=new ChangeCourseMainPage(getWebDriver(),10);
        changeCourseMainPage.clickOnCourse(courseCodeNumber.INDUSTRY.getCourseNumber());
        changeToSpealizationCourse=true;

    }

    @Test(dependsOnMethods = "changeCourseTabIND")
    protected void selectLevelI2InID() {
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        changeCourseMainPage.getPageLoadedCondition();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(1)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("changeToSpealizationCourse 4 selectLevelInTheCourse ..currentTimeMillis/1000" + System.currentTimeMillis() / 1000);
        changeCourseMainPage.clickOnLevel(1);
    }


    @Test(dependsOnMethods = "selectLevelI2InID")
    protected void checkAllComponentsInTheSelectedLevel2() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        sleep(3000);
        changeCourseModulePage.clickChangeToThisCourseBtn();
    }

    @Test(dependsOnMethods = "checkAllComponentsInTheSelectedLevel2")
    protected void clickOnChangeCourseBtnPPIND() {
        logger.info("clickOnChangeCourseBtnPopUp");
        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCoursePopUpBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.clickChangeCoursePopUpBtn();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(),"studyplan",WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "clickOnChangeCourseBtnPPIND")
    protected void changeGoalIND() {
        logger.info("checkCurrentGoal");
        sleep(12000);
        //currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 150);
        sleep(2000);
        changeYourGoalPage.clickOnChangeYourGoal();
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.simpleTest();
        logger.info("select goal my own pace ");
        setNewGoalPage.selectNewGoal(studyGoals.GOAL.getGoalHoursIndex());
        newgoalHours = studyGoals.GOAL.getGoalHours();
        setNewGoalPage.clickOnSetNewGoal();
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.getPageLoadedCondition();
        changeYourGoalPage.simpleTest();
//        waitForElementCondition(ExpectedConditions.invisibilityOf(changeYourGoalPage.goalHoursWe),
//                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

    }

    @Test(dependsOnMethods ="changeGoalIND")
    protected void changeCourseTabTRV() {
        logger.info(" change it to Travel course");
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage=new ChangeCourseMainPage(getWebDriver(),10);
        changeCourseMainPage.clickOnCourse(courseCodeNumber.TRAVEL.getCourseNumber());
        changeToSpealizationCourse=true;
    }

    @Test(dependsOnMethods = "changeCourseTabTRV")
    protected void selectLevel_1_Travel() {
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        changeCourseMainPage.getPageLoadedCondition();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(0)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("changeToSpealizationCourse 4 selectLevelInTheCourse ..currentTimeMillis/1000" + System.currentTimeMillis() / 1000);
        changeCourseMainPage.clickOnLevel(0);
    }


    @Test(dependsOnMethods = "selectLevel_1_Travel")
    protected void checkAllComponents() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        sleep(3000);
        changeCourseModulePage.clickChangeToThisCourseBtn();
    }

    @Test(dependsOnMethods = "checkAllComponents")
    protected void clickOnChangeCourseBtnPPTRV() {
        logger.info("clickOnChangeCourseBtnPopUp");
        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCoursePopUpBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.clickChangeCoursePopUpBtn();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(),"studyplan",WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "clickOnChangeCourseBtnPPTRV")
    protected void changeGoalTRV() {
        logger.info("changeGoalTRV");
        sleep(12000);
        //currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 150);
        sleep(2000);
        changeYourGoalPage.clickOnChangeYourGoal();
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.simpleTest();
        logger.info("select 5+ hours ");
        setNewGoalPage.selectNewGoal(studyGoals.GOAL_5_PLUS.getGoalHoursIndex());
        newgoalHours = studyGoals.GOAL_5_PLUS.getGoalHours();
        setNewGoalPage.clickOnSetNewGoal();
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.getPageLoadedCondition();
        changeYourGoalPage.simpleTest();
        waitForElementCondition(ExpectedConditions.visibilityOf(changeYourGoalPage.goalHoursWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertThat("New Goal hours wrong", changeYourGoalPage.getCurrentGoalHours(), equalToIgnoringCase(newgoalHours));
        logger.info("Goal hours was " + currentgoalHours + " Now change to " + newgoalHours);
    }

    @Test(dependsOnMethods ="changeGoalTRV")
    protected void changeCourseBackToGE() {
        logger.info(" change it to GE course");
        schoolHeaderAndFooterPage.schoolHeaderPage.goToChangeCourse();
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeCourseMainPage=new ChangeCourseMainPage(getWebDriver(),10);
        changeCourseMainPage.clickOnCourse(courseCodeNumber.GENERAL_ENGLISH.getCourseNumber());
        changeToSpealizationCourse=true;
    }

    @Test(dependsOnMethods = "changeCourseBackToGE")
    protected void selectLevel6GE() {
        changeCourseMainPage = new ChangeCourseMainPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        JavaScriptHelper.scrollToXY(getWebDriver(), 0, 300);
        changeCourseMainPage.getPageLoadedCondition();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseMainPage.levelListWe.get(5)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("changeToSpealizationCourse 4 selectLevelInTheCourse ..currentTimeMillis/1000" + System.currentTimeMillis() / 1000);
        changeCourseMainPage.clickOnLevel(5);
    }


    @Test(dependsOnMethods = "selectLevel6GE")
    protected void checkAllComponentsGE() {
        logger.info("checkAllComponentsInTheSelectedLevel");
        changeCourseModulePage = new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        sleep(3000);
        changeCourseModulePage.clickChangeToThisCourseBtn();
    }

    @Test(dependsOnMethods = "checkAllComponentsGE")
    protected void clickOnChangeCoursePPGE() {
        logger.info("clickOnChangeCourseBtnPopUp");
        changeCourseModulePage=new ChangeCourseModulePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeCourseModulePage.changeCoursePopUpBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        changeCourseModulePage.clickChangeCoursePopUpBtn();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForUrlContains(getWebDriver(),"studyplan",WaitTool.MED_WAIT_4_ELEMENT25);
    }



    public void selectTeacher(String teachername){
        int length=findElements(By.className("teacher-card-name")).size();
        for(int i=0;i<=length;i++){
            if(StringUtils.contains(findElements(By.className("teacher-card-name")).get(i).getText(),teachername)){
                click(findElements(By.className("teacher-card-name")).get(i));
                break;
            }
        }

    }

    public void initSchoolHeaderAndFooter() {
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
    }


    public void setTestGoalData(String goalDaysLef, String goalPaceMsg, String goalStudyPace, String goalDate) {
        this.goalDaysLef = goalDaysLef;
        this.goalPaceMsg = goalPaceMsg;
        this.goalStudyPace = goalStudyPace;
        this.goalDate = goalDate;
    }



    @BeforeSuite
    protected void setupBaseSchoolTest(){
        //logger.info("setupBaseSchoolTest .. take shot for all tests");
        //TestngListener.setIsStoreScreenShotAllTest(true);
        memberSpinnerCss = ".ets-backdrop";
    }

    @AfterSuite
    protected void teardownAfterBaseSchoolTest(){
        logger.info("@ after suite ...!");

        if(null != userBeanList && !userBeanList.isEmpty()) {
            for (ChatTestUserBean user : userBeanList) {
                if (StringUtils.containsIgnoreCase(getENVIRONMENT(), "live")) {
                    cancelUserSubscription(user.getUserName());
                } else {
                    logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
                }

            }
        } else
            logger.info("Nothing to cancel as User bean list is empty ....!");


    }



    /**
     * Pass the page object to open that url
     * getPageUrl should return the page relative url
     * @param schoolPage
     */
    public void openPageUrl(ISchoolPage schoolPage){
        sleep(500);
        String url = getBASEURL()+SCHOOL_BASE_DOMAIN+schoolPage.getPageUrl();
        if(isNewHouseUser){
            url = convertUtlToNewHouse(url);
        }
        openUrl(getWebDriver(), url);
        sleep(500);
    }

    /**
     *
     * @param driver
     * @param schoolPage
     * @param schoolBaseDomain  ---> getBASEURL()+SCHOOL_BASE_DOMAIN
     */
    public static void openPageUrl(WebDriver driver, ISchoolPage schoolPage, String schoolBaseDomain){
        sleep(500);
        String url = schoolBaseDomain+schoolPage.getPageUrl();
        logger.info("openPageUrl [{}]", url);
        TestUtil.openUrl(driver, url);
        sleep(500);
    }

    // Todo do the same but use Header pom to navigate this time
    public void openSchoolPageUrl(SchoolPageName pagesName){
        logger.info("openSchoolPageUrl [{}]", pagesName);
        schoolHeaderPage = new SchoolHeaderPage(getWebDriver());
        schoolHeaderPage.simpleTest();

        switch (pagesName){
            case MYPAGE:
                logger.info("My account page Case .. this is the page when user login ...NOT implemented  ...!");
                // do we really need this
                break;

            case MY_ACCOUNT_PAGE:
                logger.info("My account page Case ...!");
                schoolHeaderPage.goToMyAccountSetting();
                break;
            case PERSONAL_DETAILS:
                logger.info("My account page Case ...!");
                schoolHeaderPage.goToMyAccountSetting();
                break;
            //TODO
            default:  logger.warn("Can not find the option requested [{}]", pagesName);;
        }

    }
    //in recommendpopup answer first question ans then close the popup
    public void waitForRecommendPopupAndClose(){
        logger.info("wait For Recommend Popup And Close ...!");

        boolean isRecommendPopupShown =   WaitTool.waitForIsDisplayed(getWebDriver(), By.cssSelector(recommendSurveyFrameCss),
                recommendPopupWaitTimeSec);
        if(isRecommendPopupShown){
           /* findElement(By.className("fancybox-iframe"), WaitTool.DEFAULT_IMPLICIT_WAIT);
            WebDriverWindowHelper.switchToFrameByFrameWebElement(getWebDriver(), By.className("fancybox-iframe"));
            //getWebDriver().switchTo().frame(getWebDriver().findElement(By.className("fancybox-iframe")));
            logger.info("Answer first question in recommended popup ...!");
            currWebElement = findElement(By.cssSelector(".radio-buttons .first-child"),WaitTool.DEFAULT_IMPLICIT_WAIT);
            click(currWebElement);
            logger.info("close recommended popup ...!");
            WebDriverWindowHelper.switchToDefaultContent(getWebDriver()); //getWebDriver().switchTo().defaultContent();*/
            click(By.className(closeRecommendPopupCss));
            logger.info("Clicked to close recommended popup...!");
            sleep(500);
        }else
            logger.info("No popup shown ...!");
    }
    public void waitForTimeZonePopupAndSaveTimeZone(){
        logger.info("wait For TimeZone Popup And Close ...!");
        boolean isTimeZonePopupShown =   WaitTool.waitForIsDisplayed(getWebDriver(), By.className(closeButtonTimeZone),
                40);
        if(isTimeZonePopupShown){
            getWebDriver().findElement(By.className(closeButtonTimeZone)).click();
            //click(By.className(closeButtonTimeZone));
            logger.info("Clicked to close  TimeZone popup...!");
            sleep(500);
        }else
            logger.info("No popup shown ...!");
    }


    /**
     * Init page object
     * get page condition and execute simpleTest
     *
     */
    public void initSchoolHomePage(){
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
    }

    public void initBookPrivateLessonPage(){
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        bookPrivateLessonPage.getPageLoadedCondition();
        bookPrivateLessonPage.simpleTest();
    }

    public void initConversationClassPage(){
        conversationClassPage = new ConversationClassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        conversationClassPage.getPageLoadedCondition();
        conversationClassPage.simpleTest();
    }

    public void initCurrentCourseUnitPage(){
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.simpleTest();
    }

    public void initMyAccountPage(){
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.simpleTest();
    }

    public void initUpdatePaymentPage(){
        /*updatePaymentPage = new UpdatePaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        updatePaymentPage.getPageLoadedCondition();
        updatePaymentPage.simpleTest();*/
    }

    public void initBillingPage(){
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        billingPage.getPageLoadedCondition();
        billingPage.simpleTest();
    }

    public void initAppsAndToolsPage(){
        appsAndToolsPage = new AppsAndToolsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        appsAndToolsPage.getPageLoadedCondition();
        appsAndToolsPage.simpleTest();
    }

    public void initGrammarLabPage(){
        grammarlabPage = new GrammarlabPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        grammarlabPage.getPageLoadedCondition();
        grammarlabPage.simpleTest();
    }

    public void initNewHouseSupportPage(){
        supportPage = new SupportPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        supportPage.getPageLoadedCondition();
        supportPage.simpleTest();
    }

    public List<ChatTestUserBean> setupTestUsers(int howManyUsers) {
        ChatTestUserBean chatTestUserBean = new ChatTestUserBean();

        for(int i= 0; i < howManyUsers; i++){
            try {
                setThreadSafeDriver();
                chatTestUserBean = createAndSetupNewChatUsers(memberPageUrl, getWebDriver(), getMemberFormMap(),
                        EfConstants.ukMembersPayMap_new, false, 0, false, ChatUserStatus.OFFLINE);
                userBeanList.add(chatTestUserBean);
            }catch (Exception e){
                logger.error("Could not create user [{}]  ...!"+e.getMessage(), i);
            }finally {
                destroyDriver();
            }

        }

        logger.info("\n\n $$$$$$$$$$$$$$$$$$$$ Test Users  $$$$$$$$$$$$$$$$$$$$$$$$$$ ");
        for(ChatTestUserBean user : userBeanList) {
            logger.info("" + user.toString());
        }
        logger.info("\n\n $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ ");
        sleep(30000);

        if(null == userBeanList || userBeanList.isEmpty() )
            failTest("Could not create the users needed for testing ....!");

        return userBeanList;
    }


    public ChatTestUserBean createAndSetupNewChatUsers(String memberPageUrl, WebDriver driver,
                                                       Map memberMap, Map paymentMap, boolean isClickTab, int tabId,
                                                       boolean isIncoming, ChatUserStatus status){
        openUrl(driver, memberPageUrl);
        ChatTestUserBean user = createNewUser(driver, memberMap, paymentMap, isClickTab, tabId);
        user.setIncoming(isIncoming);
        user.setChatUserStatus(status);

        return user;
    }

    /**
     * Create users using UI and enroll
     * set username, pass, member id
     * Should start at member page
     * @param driver
     * @param memberMap
     * @param paymentMap
     * @param isClickTab
     */
    public ChatTestUserBean createNewUser(WebDriver driver, Map memberMap, Map paymentMap, boolean isClickTab, int tabId){
        logger.info("start enterMemberDetails ....!");
        ChatTestUserBean chatTestUserBean = new ChatTestUserBean();
        waitForSpinnerDisappear(driver);
        memberPage = initMemberPage(driver);
        TestUtil.enterFormData(driver, memberMap);
        enterEmail(driver, true);
        chatTestUserBean.setUserName(userEmail);
        memberPage.submit();
        logger.info("Member page submitted ....!");

        clickTab(isClickTab, driver, tabId);
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(paymentSubmitBtnCss), getWebDriver(), 25);
        removePaymentValidation();
        waitForSpinnerDisappear(driver);

        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "qa")) {
            paymentMap.replace("CreditCardNumber", "4111111111111111");
        }
        TestUtil.enterFormData(driver, paymentMap);
        WebElement submitElement = findElement(driver, By.cssSelector(paymentSubmitBtnCss), 15);
        click(submitElement);

        try{Thread.sleep(3000);}catch (Exception e){}
        waitForSpinnerDisappear(driver);
        logger.info("Pay page submitted ....!");
        PaymentThankyouPage paymentThankyouPage = new PaymentThankyouPage(driver, 35) ;
        paymentThankyouPage.waitForPageToLoad(paymentThankyouPage.getPageLoadedCondition(isNewhouseCheckout));
        paymentThankyouPage.simpleTest(isNewhouseCheckout);
        chatTestUserBean.setUserId(JavaScriptHelper.executeAsyncScript(MEMBERID_KEY, driver, 15));
        chatTestUserBean.setEfId(JavaScriptHelper.executeAsyncScript(EFID_KEY, driver, 10));

        //click(paymentThankyouPage.startLearning);
        if(isNewhouseCheckout)
            click(paymentThankyouPage.startLearningNewCheckOut);
        else
            click(paymentThankyouPage.startLearning);
        sleep(3000);
        // enroll
        BasePage.waitForUrlContains(driver, "enrollment/b2c/entrance", 35);
        enrolStudentCheckAtSchool();
        logger.info("User created...!\n"+chatTestUserBean.toString()+"\n ---------------\n");

        return chatTestUserBean;
    }
    protected void getTotalTimeBeforeCourse(int unitNumber,int lessonNumber,String expTotalTime,String courseCode) {
        if(courseCode=="GE")
            totalTime = TestUtil.getWebElementText(progressPage.unitListGEWe.get(
                    unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(
                    By.className("ets-pr-lesson-time-spent")));
        else{
            totalTime = TestUtil.getWebElementText( progressPage.unitListOtherCoursesWe.get(
                    unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(
                    By.className("ets-pr-lesson-time-spent")));}

        AssertHelper.myAssertThat(getWebDriver(),
                "time value is present even before start of course....that is WRONG",
                totalTime, equalToIgnoringWhiteSpace("--"),false);
        logger.info("Total time ="+totalTime);
    }


    public static DynamicMemberPage initMemberPage(WebDriver driver){
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=firstname]"), driver, WaitTool.MED_WAIT_4_ELEMENT);
        DynamicMemberPage memberPage = new DynamicMemberPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        memberPage.simpleTest();
        return memberPage;
    }

    public static void waitForSpinnerDisappear(WebDriver driver){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),driver, WaitTool.MED_WAIT_4_ELEMENT);
    }

    public static void clickTab(boolean isClickTab, WebDriver driver, int tabId){
        String paymentTabsListCss = ".nav.nav-tabs li a";
        waitForSpinnerDisappear(driver);
        if (isClickTab) {
            findElement(driver, By.cssSelector(paymentTabsListCss), 15);
            List<WebElement> tabsWe = WaitTool.waitForListElementsDisplayed(driver, By.cssSelector(paymentTabsListCss), 15);
            tabsWe.get(tabId).click();
            BaseTest.sleep(1000);
            logger.info(" Tab clicked ...!");
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
    }

    public static WebElement findElement(WebDriver webDriver, By selector, int waitTimeSec) throws NullPointerException{
        return WaitTool.waitForElementVisible(webDriver, selector, waitTimeSec, 1000);
    }

    public Map getMemberFormMap(){
        String fName = TestUtil.generateRandomString("BtoC", 7);
        String lName = TestUtil.generateRandomString("BtoC", 6);
        Map<String, String> memberFormMap = EfConstants.MEMBER_FORM_FLP;
        memberFormMap.replace("firstname", fName );
        memberFormMap.replace("lastname", lName);

        return memberFormMap;
    }

    public void logoutAndLogin(String username, String pass, boolean isOpenLoginUrl, boolean isClearCookies){
        logger.info("Logout and Login ... u:"+username+"; p:"+pass+"; isOpenLoginUrl:"+isOpenLoginUrl);
        logout(isClearCookies);
        login(username, pass, isOpenLoginUrl);
    }

    public void loginAndLogout(String username, String pass, boolean isOpenLoginUrl, boolean isClearCookies){
        logger.info("Logout and Login ... u:"+username+"; p:"+pass+"; isOpenLoginUrl:"+isOpenLoginUrl);
        login(username, pass, isOpenLoginUrl);
        logout(isClearCookies);
    }

    public void logout(boolean isClearCookies) {
        logger.info("logoutAndClearCookies ...!");
        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHeaderPage.getPageLoadedCondition();
        schoolHeaderPage.goToMyAccountAndLogout();
        if(isClearCookies) {
            sleep(1000);
            CookieHandler.deleteCookies(getWebDriver());
            sleep(1000);
        }
    }

    public void login(String username, String pass, boolean isOpenLoginUrl) {
        openLoginUrl(isOpenLoginUrl);
        logger.info("enterUserCredentialsAndLogin  ...!");
        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.getPageLoadedCondition();
        loginPage.simpleTest();
        loginPage.enterCredentials(username, pass);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
    }

    public void openLoginUrl(boolean isOpenLoginUrl) {
        logger.info("openLoginUrlAndLogin  ...!");
        String loginUrl = getBASEURL() + "englishlive.ef.com/" + getLanguage()+"-"+getMarket()+"/login" ;

        if(isOpenLoginUrl)
            openUrl(getWebDriver(), loginUrl);

        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    public StudentBean createNewHouseUserAndEnroll(String environment, Enroll enrolLevel, String country, String language){
        String loginUrl = "https://qa-englishlive.ef.com/"+ language +"-"+ country +"/login";

        if(StringUtils.contains(environment, "live"))
            loginUrl = loginUrl.replace("qa-", "");

        logger.info("Login URL set to [{}]", loginUrl);
        StudentBean studentBean = new StudentBean();
        studentBean.setCountry(country);
        studentBean.setLang(language);
        studentBean.setEnroll(enrolLevel);

        StaticBaseApiSpec.createUserWithEnroll(environment, studentBean, loginUrl);
        //StaticBaseApiSpec.getAllUserDataResponse(studentBean.getUserEmail(), 200, "qa");

        return studentBean;
    }

    public StudentBean createNewHouseUserPayNoEnroll(String environment,  String country, String language){
        StudentBean studentBean = new StudentBean();
//        studentBean.setCountry(country);
//        studentBean.setLang(language);
        StaticBaseApiSpec.createUserNoEnrol(environment,true,"50987556",country,language);

        return studentBean;
    }

    public String getNoOfPLSLeft(int wordNumber){
        logger.info("Private Classes PL checkPLLeft ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(findElement(By.cssSelector(".private-lesson .coupon"))), getWebDriver(), 35);
        String plLeft1 = TestUtil.getWebElementText(findElement(By.cssSelector(".private-lesson .coupon")));
        String[] plLeft=plLeft1.split(" ");
        String noOfPL=plLeft[wordNumber];
        logger.info("currently plLeft is...!"+ noOfPL);
        return  noOfPL;

    }



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










