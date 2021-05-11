package com.englishtown.newhouse.school.pages.course.currentcourse.unit;

//sherin - 02/02/2018
//
// Current Course page object

// NM TODO split this up on section and new pom for start activity page

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.apache.commons.lang3.Validate.notBlank;

public class CurrentCourseUnitPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(CurrentCourseUnitPage.class);
    public static final String pageUrl = "/1/school/studyplan?icid=School.StudyPlan.2013";   // #study/

    public static final String goalLinkCss     = "ets-icon-badge-goal-poly"; // class name
//    public static final String goalDaysLeftCss = "campus-badge-normal";      // class name   text = 0 day(s) left
//    public static final String goalPaceMsgCss  = "cp-progress-msg";          // class name  text =  You are studying at your own pace / You missed your study goal / "Left to complete this unit"


//Unit header selectors

    @FindBy(className = "ets-sp-unn-title")
    public WebElement unitNameWe;

    @FindBy(css = ".ets-sp-uno-main button")
    public WebElement unitOverviewLinkWe;

    @FindBy(className = "ets-sp-chc-link-url")
    public WebElement changeCourseLinkWe;

    @FindBy(className = "ets-sp-unn-next")  //.ets-sp-unn-next i
    public WebElement unitNextArrowWe;

    @FindBy(className = "ets-sp-unn-prev")
    public WebElement unitPreviousArrowWe;

    @FindBy(css = ".ets-sp-unn-prev.ets-disabled")
    public WebElement disabledUnitPreviousArrowWe;

    @FindBy(css = ".ets-sp-unn-next.ets-disabled")
    public WebElement disabledUnitNextArrowWe;

    @FindBy(css = ".ets-sp-chc-hd h3")
    public WebElement courseNameWe;

    @FindBy(css = ".ets-sp-chc-hd h4")
    public WebElement levelNameWe;

    @FindBy(className = "ets-icon-lock")
    public WebElement unitLockWe;


   //Lesson

    @FindBy(css = ".ets-sp-sqn-main li")
    public List<WebElement> iconList;

    @FindBy(css = ".ets-icon-badge-lesson")
    public List<WebElement> lessonList;

    @FindBy(css = ".ets-sp-lsn-info h4")
    public WebElement lessonNumberWe;

    @FindBy(css = ".ets-sp-lsn-info h1")
    public WebElement lessonNameWe;

    @FindBy(className = "ets-icon-badge-checkmark")  //".ets-sp-sqn-main .ets-icon-badge-checkmark"
    public List<WebElement> lessonGreenTickWe;

    // Goal
    @FindBy(className = goalLinkCss)
    public WebElement goalLinkWe;

    @FindBy(css = ".tooltip-content")
    public WebElement goalTooltipWe;

    @FindBy(css = ".ets-icon-cp-close")
    public WebElement goalTooltipCloseBtnWe;



    //steps

    @FindBy(css = "li.ets-sp-step-no")
    public List<WebElement> stepNoWe;

    @FindBy(css = "li.ets-sp-step-type")
    public List<WebElement> stepNameWe;

    @FindBy(css = "li.ets-sp-step-title")
    public List<WebElement> stepDescWe;

    @FindBy(css = "li.ets-sp-step-action")
    public List<WebElement> stepStatusWe;

    @FindBy(css = ".ets-sp-step-action .ets-icon-badge-checkmark")
    public List<WebElement> stepGreenTickWe;

    @FindBy(css = ".ets-sp-step-action .ets-icon-badge-checkmark")
    public List<WebElement> stepPerfectStatusWe;

    @FindBy(css = "span[data-text-en='Start']")
    public List<WebElement> startBtnWe;

    @FindBy(css = "span[data-text-en='Continue']")
    public List<WebElement> continueBtnWe;

    //Activity

    @FindBy(css = "div[class*='ets-btn-fn-next']")
    public WebElement nextBtnWe;

    @FindBy(css = ".ets-ui-acc-step-title")
    public WebElement activityTitleWe;

    @FindBy(css = ".ets-activity")
    public WebElement activityMainClassWe;

    @FindBy(className = "ets-btn-fn-move")
    public WebElement activityNextBtnWe;

    @FindBy(css = ".ets-ui-acc-btn-close")
    public WebElement activityCloseBtnWe;

    @FindBy(css = ".ets-ui-acc-act-nav a")
    public List<WebElement> activityStepsListWe;

    public CurrentCourseUnitPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CurrentCourseUnitPage(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(unitNameWe, levelNameWe, courseNameWe, unitOverviewLinkWe, unitNextArrowWe,
                changeCourseLinkWe, lessonNameWe, lessonNumberWe,stepNameWe.get(0));
        return false;
    }

    public boolean simpleTest() {
        logger.info("check General English course is displayed...!");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),unitOverviewLinkWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertWebElementDisplayed(unitOverviewLinkWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),unitOverviewLinkWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        return ExpectedConditions.visibilityOf(unitOverviewLinkWe);
    }

    public void assertTotalNumberOfLessonsInAUnit(int unitNumber, String courseCode) {
        logger.info("Check if total number of lessons in a unit is always greater than or equal to 4");//this number excludes private and conversation class
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), lessonList, 4);
        logger.info("No of lessons in unit " + unitNumber + ": " + lessonList.size());

    }

//    public void assertTotalLessonsExcludingPrivateAndGroupClass() {
//        logger.info("assertTotalLessonsExclPrivateAndGroupClass");
//        WebElement noClickWe = null;
//
//        int noOfLesson = 0;
//
//        for(WebElement we : lessonList) {
//            try {
//                noClickWe = we.findElement(By.className("ets-icon-badge-group-lesson"));
//                logger.info("Found Element .. exclude it ..!");
//            }catch (Exception e){
//                //noOfLesson++;
//                logger.info("Not found ....! go to click");
//                //click(we);
//            }
//            if(null == noClickWe){
//                noOfLesson++;
//                logger.info("going to click NO :"+noOfLesson);
//                click(we);
//            }
//        }
//        logger.info("Total lessons "+noOfLesson);


    // }


    public void checkUnitLockMessageIsPresent() {
        logger.info("checkUnitLockMessageIsPresent..!");
        AssertHelper.assertWebElementDisplayed(unitLockWe);
        logger.info("Lock message present");

    }

    public void clickOnNextBtn(){
        logger.info("clickOnNextBtn..!");
        click(activityNextBtnWe);
    }

    public void clickOnNextUnitArrow(int currentUnitNumber) {
        logger.info("clickOnNextUnitArrow");
        //next arrow will be disabled if you are currently in the last unit
        if (currentUnitNumber == 6) {
            AssertHelper.assertWebElementDisplayed(disabledUnitNextArrowWe);
        } else {
            WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(unitNextArrowWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            click(unitNextArrowWe);
        }
    }

    public void clickOnpreviousUnitArrow(int currentUnitNumber) {
        logger.info("clickOnpreviousUnitArrow");
        //previous arrow of the unit 1 will be disabled if you are currently in unit 1
        if (currentUnitNumber == 1) {
            AssertHelper.assertWebElementDisplayed(disabledUnitPreviousArrowWe);
        } else {
            WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(unitPreviousArrowWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            click(unitPreviousArrowWe);
        }
    }


    public void clickOnGoalToolTipClose() {
        logger.info("clickOnGoaltooltipClose icon");
        AssertHelper.assertWebElementDisplayed(goalTooltipWe);
        click(goalTooltipCloseBtnWe);
        logger.info("successfully clicked on goal tooltip");
    }

    public int getLessonCompleted() {
        logger.info("get Actual LessonCompleted");
        int noOfLessonsCompleted = lessonGreenTickWe.size();
        return noOfLessonsCompleted;

    }

    //need to check later what is the actual diff between a step marked as complete and a green tick
    public int getStepsCompleted() {
        logger.info("get Actual StepsCompleted");
        int noOfStepsCompleted = stepGreenTickWe.size();
        try {
             List <WebElement> we = getWebDriver().findElements(By.cssSelector("span[data-text-en='Perfect']"));
             noOfStepsCompleted=noOfStepsCompleted + we.size();

        } catch (WebDriverException e) {
            logger.warn("this step is not marked as completed ...!  " + e.getMessage());
        }
        return noOfStepsCompleted;
    }

//    public int checktotalNoOfSteps(){
//        logger.info("checktotalNoOfSteps");
//        return stepNoWe.size();
//
//    }

    public void checkLessonName(String lessonName) {
        logger.info("checkLessonName");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(lessonNameWe), lessonName, "Lesson Name incorrect");
        logger.info("Lesson name is " + TestUtil.getWebElementText(lessonNameWe));
    }


    public void checkStepNameDisplayed() {
        logger.info("checkStepNameDisplayed");
        AssertHelper.assertThat("", TestUtil.getWebElementText(stepNameWe.get(0)), notBlank(null));
        logger.info("Step name is " + TestUtil.getWebElementText(stepNameWe.get(0)));

    }

    public int numberOfStartButtonDisplayed() {
        logger.info("numberOfStartButtonDisplayed");
        return startBtnWe.size();
    }

    public int numberOfContinueButtonDisplayed() {
        logger.info("numberOfContinueButtonDisplayed");
        return continueBtnWe.size();
    }

    public void clickOnStartButton(int stepNumber) {
        logger.info("clickOnStartButton");
        click(startBtnWe, stepNumber);
        logger.info("successfully clicked ons tart button");
    }

    public String getStepStatus(int stepNumber) {
        logger.info("getStepStatus");

        WebElement webElement = null;

        try {
            webElement = stepStatusWe.get(stepNumber).findElement(By.className("ets-icon-badge-checkmark"));
            return "completed";
        } catch (WebDriverException e) {
            logger.warn("this step is not marked as completed ...!  " + e.getMessage());
        }

        try {
            webElement = stepStatusWe.get(stepNumber).findElement(By.cssSelector("span[data-text-en='Perfect']"));
            return "perfect";
        } catch (WebDriverException e) {
            logger.warn("this step is not marked as Perfect ...!  " + e.getMessage());
        }

        try {
            webElement = stepStatusWe.get(stepNumber).findElement(By.cssSelector("span[data-text-en='Continue']"));
            return "continue";
        } catch (WebDriverException e) {
            logger.warn("this step is not marked as continue ...!  " + e.getMessage());
        }

        try {
            webElement = stepStatusWe.get(stepNumber).findElement(By.cssSelector("span[data-text-en='Start']"));
            return "start";
        } catch (WebDriverException e) {
            logger.warn("this step is not marked as continue ...!  " + e.getMessage());
        }
        return null;
    }


    public void assertUnitNumber(int unitNumber, String courseCode) {
        logger.info("check Unit Number");
        if (courseCode != null) {
            if (StringUtils.equalsIgnoreCase(courseCode, "GE")) {
                AssertHelper.assertStringContains(TestUtil.getWebElementText(unitNameWe), Integer.toString(unitNumber), "Incorrect UnitNumber");
                logger.info("Unit number :" + TestUtil.getWebElementText(unitNameWe));
            } else {
                AssertHelper.assertStringContains(TestUtil.getWebElementText(unitNameWe), getUnitNumber_SpecializedCourses(unitNumber), "Incorrect UnitNumber");
                logger.info("Unit number :" + TestUtil.getWebElementText(unitNameWe));
            }
        } else
            BaseTest.failTest("No course code present");
    }


    public void assertlevelNumber(int levelNumber, String courseCode) {
        logger.info("check Level Number");
        if (courseCode == "GE") {
            AssertHelper.assertStringContains(TestUtil.getWebElementText(levelNameWe), Integer.toString(levelNumber), "Incorrect Level number");
            logger.info("Level number :" + TestUtil.getWebElementText(levelNameWe));
        } else
            logger.info("Level number not present for specialisation courses");
    }

    public void assertlessonNumber(int lessonNumber) {
        logger.info("check Lesson Number");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(lessonNumberWe), Integer.toString(lessonNumber), "Incorrect Lesson number");
        logger.info("Lesson number :" + TestUtil.getWebElementText(lessonNumberWe));
    }



    public void navigateToLesson(int lessonNumber) {
        logger.info("navigateToLesson" +lessonNumber);
        click(lessonList.get(lessonNumber));
        logger.info("successfully clicked on next lesson");

    }

    public String getUnitNumber_SpecializedCourses(int unitNumber) {
        logger.info("Get Unit number for specialized Courses");
         String roman="";
         int n;
            int repeat;
            int magnitude[]={1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String symbol[]={"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            repeat=unitNumber/1;
            for(int x=0; unitNumber>0; x++){
                repeat=unitNumber/magnitude[x];
                for(int i=1; i<=repeat; i++){
                    roman=roman + symbol[x];
                }
                unitNumber=unitNumber%magnitude[x];
            }
            logger.info("Unit number is "+roman);
            return roman;
        }




    @Override
    public String getPageUrl(){
        return pageUrl;
    }


}











