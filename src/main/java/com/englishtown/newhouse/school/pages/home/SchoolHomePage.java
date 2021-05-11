package com.englishtown.newhouse.school.pages.home;
/**
 * Nikol Sept 2017
 *
 * Once user logged in and completed enrolment school page is shown [MyPageHome]
 * new user: auto_91176753577554_OYSHRJH570270271_xdelx@qp1.org
 * user started courses :  auto_97028562096928_UHKMNTZ313412232_xdelx@qp1.org
 *
 * Page has these main components
 * 1. Course and Units [top of the page] ... Unit 1  -- Unit 2 ... * Test
 * 2. self studying section [shows Student unit, lesson, continue studying(if student started any of course steps
 *                           or if student is new watch video how it works button) ]
 * 3. Book private class
 * 4 Conversation class
 */

import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.enumpack.DownloadAppType;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.containsString;


public class SchoolHomePage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolHomePage.class);
    public static final String pageUrl = "/campus/mypage/home";
    //public static final String SCHOOL_LITE_HOMEPAGE_QA_URL = "https://school.eu-west-1.qa.elb2c.ef-cloud.io/campus/mypage/home";


    protected final String CURRENT_LEVEL_NAME_CSS = "[class='level-target-info'] .level-name";
    protected final String LEVEL_TARGET_CSS = "[class='level-target-info'] .target-date";
    protected final String PL_MSG_CSS = ".private-lesson [class='pl-info']";

    // header cover this   @FindBy(className = "ue-header")    public WebElement mainNavigationWe;          //top nav ... cource support user etc

    /**
     * Section : contains  level - Unit 1  -- Unit 2 ... * Test
     */
    @FindBy(className = "level-navigator")
    public WebElement levelNavigatorWe;          // the selected sub nav

    @FindBy(css = CURRENT_LEVEL_NAME_CSS)   // e.g 1-Beginner
    public WebElement currentLevelNameWe;

    @FindBy(css = ".level-navigator .active")
    public WebElement activeLevelNavigatorWe;


    @FindBy(css = ".level-navigator .unit-item")    // e.g 1-6 and test if available so 7 elements max
    public List<WebElement> unitItemsListWe;

    @FindBy(css = ".unit-item.current .name")    // e.g Unit 1
    public WebElement currentUnitNameTxtWe;


    @FindBy(css = ".nav-item.next-level")
    public WebElement levelTargetWe;  // Next Level 2-Beginner // not shown for top/last course

    @FindBy(css = ".nav-item.next-level .name span")   // Next level
    public WebElement levelTargetNameTxtWe;

    @FindBy(css = ".nav-item.next-level .level-name")  // 2-beginners
    public WebElement levelTargetLevelNameTxtWe;

    /**
     * self study section
     *
     */
    @FindBy(className = "self-studying-standard")  // content and action
    public WebElement selfStudySectionWe;

    @FindBy(css = ".self-studying-content-unit span")   // e.g [0]Unit 1, [1]Greeting and Intro
    public List<WebElement> selfStudyCurrentUnitNumberAndNameListWe;

    // shows only if user started lessons
    @FindBy(css = ".self-studying-content-lesson-aside")  // Complete Lesson 2,
    public WebElement selfStudyCurrentLessonNumberWe;

    @FindBy(css = ".self-studying-standard .self-studying-content-lesson-name")  // Giving your name to someone
    public WebElement selfStudyCurrentLessonNameWe;

    @FindBy(css = ".self-studying-standard .self-studying-action-text")  // e.g you are on track ... or not
    public WebElement selfStudyActionTextWe;

    /**
     * both new and exiting user with progress
     * button continue to study or if new shows watch video how it works .. span contain text
     */
    @FindBy(css = ".self-studying-standard .self-studying-action-button")
    public WebElement selfStudyActionButtonWe;
    // end shows if user started lesson

    // new users that have not started any lesson
    @FindBy(css = ".self-studying-standard .self-studying-content-lesson")  // watch how it works
    public WebElement watchHowItWorksTxtWe;

    /**
     *
     * Book a Private class with Teacher section
     *
     */
    @FindBy(className = "private-lesson")
    public WebElement privateLessonSectionWe;

    @FindBy(css = PL_MSG_CSS)
    public WebElement privateLessonSectionMsgWe;

    @FindBy(css = ".private-lesson .teacher-img")
    public WebElement privateLessonTeacherImgWe;

    @FindBy(css = ".private-lesson .btn-container .button")   // e.g 3 private class left
    public WebElement bookClassNowBtnWe;

    @FindBy(css = ".private-lesson .coupon")
    public WebElement privateLessonClassesLeftTxtWe;

    /**
     * Conversation GL section
     *
     */
    @FindBy(className = "self-studying-mini")
    public WebElement groupLessonSectionWe;

    @FindBy(css = ".group-lesson .self-studying-content-lesson-name")  // where you from
    public WebElement groupLessonClassTopicNameWe;

    @FindBy(css = ".self-studying-mini .self-studying-action-button")
    public WebElement glSectionLearnMoreOrJoinClassBtnWe;

    // e.g The classroom open in 4 mins or The classroom is open no time
    // You can enter during the first 10 minutes of the class.
    @FindBy(css = ".self-studying-mini .self-studying-action-text :first-child")
    public WebElement groupLessonClassroomOpenTxtWe;

    @FindBy(css = ".self-studying-mini .coupon-left-text")   // e.g 3/3 classes left
    public WebElement groupLessonClassesLeftTxtWe;
    //-------------

    @FindBy(css = ".mypage-icon-arrow-down")
    public WebElement mypageArrowDown;

    /**
     * Download apps
     *
     */
    @FindBy(css = ".download-apps")
    public WebElement downloadAppsSectionWe;

    @FindBy(css = ".download-apps a")
    public List <WebElement> downloadAppsListWeb;                //{mobile[0=ios, 1=android]; tablet[2=ios, 3=android]}

    /**
     *
     * @param courseLevel
     */
    public void assertStudentLevelName(CourseLevel courseLevel){
        logger.info("assertStudentLevelName ...! ->"+courseLevel.getCourseLevel());
        AssertHelper.assertThat("Student levelName is not the expected one ["+courseLevel.getCourseLevelName()+"]",
                TestUtil.getWebElementText(currentLevelNameWe), containsString(courseLevel.getCourseLevelName()));
    }

    public void assertStudentLevelNumber(CourseLevel courseLevel){
        logger.info("assertStudentLevelNumber ...! -> "+courseLevel.getCourseLevelNumber());
        AssertHelper.assertThat("Student level Number is not the expected one ["+courseLevel.getCourseLevelNumber()+"]",
                TestUtil.getWebElementText(currentLevelNameWe), containsString(courseLevel.getCourseLevelNumber()));
    }

    public void checkCurrentUnit(CourseUnit courseUnit){
        logger.info("checkCurrentUnit ...! ->"+courseUnit.getUnitName());
        AssertHelper.assertThat("Student currentUnit is not the expected one ["+courseUnit.getUnitName()+"]",
                TestUtil.getWebElementText(currentUnitNameTxtWe), containsString(courseUnit.getUnitName()));
    }

    public void checkGroupLessonSection(){
        logger.info("checkGroupLessonSection ...");
        checkAllPageComponentsDisplayed(groupLessonSectionWe,groupLessonClassTopicNameWe,glSectionLearnMoreOrJoinClassBtnWe);

    }

    public void clickWatchHowItWorksVideo(){
        logger.info("clickContinueStudying ...!");
        click(selfStudyActionButtonWe);
    }
    public void clickContinueStudying(){
        logger.info("clickContinueStudying ...!");
        click(selfStudyActionButtonWe);
    }

    /**
     * GL
     *
     */
    public void clickJoinAClassNow(){
        logger.info("clickJoinAClassNow ...!");
        click(glSectionLearnMoreOrJoinClassBtnWe);
    }
    public void clickLearnMore(){
        logger.info("GL clickLearnMore ...!");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),glSectionLearnMoreOrJoinClassBtnWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        click(glSectionLearnMoreOrJoinClassBtnWe);
    }

    public void checkClassroomIsOpen(){
        logger.info("checkClassroomIsOpen ...!");
        String classroomStatusTxt = TestUtil.getWebElementText(groupLessonClassroomOpenTxtWe);
        AssertHelper.assertStringContains(classroomStatusTxt,"classroom is open","Classroom is not open and should be ...!");
    }

    public void checkClassroomNotOpen(){
        logger.info("checkClassroomNotOpen ...!");
        String classroomStatusTxt = TestUtil.getWebElementText(groupLessonClassesLeftTxtWe);
        AssertHelper.assertStringContains(classroomStatusTxt,"classroom open in","Classroom is open and should not be ...!");
    }

    /**
     * GL
     * e.g 3/3 classes left
     *
     *
     * GL
     * @param totalsNoOfclasses
     * @param noOfclassesLeft
     */
    public void checkGroupClassesTakenAndLeft(String totalsNoOfclasses, String noOfclassesLeft){
        logger.info("GL checkClassesLeft ...!");
        String classroomStatusTxt = TestUtil.getWebElementText(groupLessonClassesLeftTxtWe);
        String classesLeft    = "-0";  // this is the left side of 19/20
        String totalClasses   = "-0";

        if(StringUtils.isNotBlank(classroomStatusTxt)){
            classesLeft   =  TestUtil.getSplitPart(classroomStatusTxt, "/", 0);
            totalClasses  =  TestUtil.safeSplit(classroomStatusTxt, "/", 1, 0, 2);
            logger.info("classesLeft["+classesLeft+"]; totalClasses["+totalClasses+"]; should match ["+noOfclassesLeft +"/"+totalsNoOfclasses+"]");
            if(null == classesLeft && null == totalClasses)
                failTest("Can't get classes information [ NULL ]...!" );
        }else
            failTest("Can't get classes information ...! classroomStatusTxt:"+classroomStatusTxt);
        AssertHelper.assertStringContains(classesLeft, noOfclassesLeft,"Not the expected Number of Classes Left ...!");
        AssertHelper.assertStringContains(totalClasses, totalsNoOfclasses,"Not the expected Number of Total Classes ...!");
    }

    /**
     * PL
     *
     * @param plLeftMessage ...e.g 4 private classes left
     */
    public void checkPLLeft(String plLeftMessage){
        logger.info("Private Classes PL checkPLLeft ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(privateLessonClassesLeftTxtWe), getWebDriver(), 35);
        String plLeft = TestUtil.getWebElementText(privateLessonClassesLeftTxtWe);
        logger.info("currently plLeft [{}] ; should be ["+plLeftMessage+"] ...!", plLeft);

        if(StringUtils.isNotBlank(plLeft)){
            AssertHelper.assertStringContains(plLeft, plLeftMessage,"Not the expected Number of PL Classes Left ...!");
        }else
            failTest("Can't get PL classes information ...! plLeft:"+plLeft);

    }

    public String getNoOfPLSLeft(){
        logger.info("Private Classes PL checkPLLeft ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(privateLessonClassesLeftTxtWe), getWebDriver(), 35);
        String plLeft = TestUtil.getWebElementText(privateLessonClassesLeftTxtWe);
        plLeft=plLeft.split(" ")[0];
        logger.info("currently plLeft is...!", plLeft);
        return  plLeft;

    }

    /**
     * PL
     */
    public void clickBookAPrivateClass(){
        logger.info("clickBookAPrivateClass ...!");
        click(bookClassNowBtnWe);
    }

    /**
     * App section
     */
    public void checkAllDownloadAppsIconLinks(){
        logger.info("Checking download icon for Tablet/Phones ios or android");
        checkAllPageComponentsDisplayed(downloadAppsListWeb.get(0), downloadAppsListWeb.get(1),
                                         downloadAppsListWeb.get(2), downloadAppsListWeb.get(3));
    }

    public void clickOnDownloadAppsIcon(DownloadAppType downloadAppType){
        logger.info(" clickOnDownloadAppsIcon  ...! appLinkIndex ->"+downloadAppType.getAppTypeId());
        click(downloadAppsListWeb.get(downloadAppType.getAppTypeId()));
    }


    public SchoolHomePage(WebDriver webDriver){
        super(webDriver);
    }
    public SchoolHomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SchoolHomePage(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }
    public SchoolHomePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(CURRENT_LEVEL_NAME_CSS), WaitTool.LONG_WAIT_4_ELEMENT);
        return ExpectedConditions.visibilityOf(levelNavigatorWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),levelNavigatorWe,WaitTool.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertComponentsDisplayed(levelNavigatorWe );//downloadappsectioncheck
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents [logo, menus and icons]...!");
        checkAllPageComponentsDisplayed( levelNavigatorWe, activeLevelNavigatorWe, activeLevelNavigatorWe,
                unitItemsListWe.get(2), selfStudySectionWe, selfStudyActionButtonWe, privateLessonSectionWe,
                privateLessonTeacherImgWe, bookClassNowBtnWe, groupLessonSectionWe,
                mypageArrowDown);//downloadAppsSectionWe, downloadAppsListWeb.get(3)
        return true;
    }

}