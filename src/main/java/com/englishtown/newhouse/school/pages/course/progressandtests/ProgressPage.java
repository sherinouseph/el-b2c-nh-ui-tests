package com.englishtown.newhouse.school.pages.course.progressandtests;

//sherin - 09/02/2018
//
//Progress and test Page

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class ProgressPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(ProgressPage.class);
    public static final String pageUrl = "/school/progressreport?icid=School.Progress.2012";




    @FindBy(className = "ets-pr-top-title")
    public WebElement progressTitleWe;

    @FindBy(className = "ets-active")
    public WebElement activeCourseWe;

    @FindBy(className = "ets-pr-nav-button")
    public List<WebElement>subMenusWe;

    @FindBy(css = "button.ets-pr-cert-view")
    public WebElement viewCertificateBtn;



    //GE

    @FindBy(className = "ets-pr-level-stage")
    public List<WebElement>noOfStagesGE;

    @FindBy(className = "ets-pr-level-num")
    public List<WebElement>noOfLevelsGE;

    @FindBy(className = "ets-pr-state-circle")
    public List<WebElement>noOfLevelCirclesGE;

    //special interestcourses

    @FindBy(className = "ets-pr-spin-nav-card-header")
    public WebElement cardHeaderWe;



    //progress section


    @FindBy(css = ".ets-pr-level-info h2")
    public WebElement levelHeadingWe;

    @FindBy(css = ".ets-pr-level-info h3")
    public WebElement noOfLessonsLeftWe;

    @FindBy(className = "ets-pr-unit-list-header")
    public WebElement unitListHeadingWe;



    @FindBy(css = ".ets-pr-container-ge .ets-pr-unit-item")
    public List<WebElement> unitListGEWe;

    @FindBy(css = ".ets-pr-container-spin .ets-pr-unit-item")
    public List<WebElement> unitListSpinWe;

    @FindBy(css = ".ets-pr-container-spin .ets-pr-unit-item")
    public List<WebElement> unitListOtherCoursesWe;

    @FindBy(className = "ets-pr-unit-no")
    public List<WebElement> unitNumberWe;

    @FindBy(className = "ets-pr-unit-name")
    public List<WebElement> unitHeadingWe;

    //level certifcate tooltip



    @FindBy(css = "button.ets-pr-btn")
    public WebElement gotItBtnlevelCertificate;

    @FindBy(className = "ets-pr-cert-description")
    public WebElement tooltipDescription;

    //leveltest

    @FindBy(className = "ets-pr-score-title")
    public WebElement leveltestTitleWe;

    @FindBy(className = "ets-pr-percentage")
    public WebElement levelScoreWe;

    @FindBy(className = "ets-pr-score-score")
    public List <WebElement> topicScoreListWe;

    @FindBy(className = "ets-pr-retake")
    public WebElement retakeTestLinkWe;

    @FindBy(className = "ets-pr-complete")
    public WebElement tickMarkWe;

    @FindBy(className = "ets-pr-flag")
    public WebElement flagIconLevelTestWe;

    @FindBy(className = "ets-pr-header-title")
    public List<WebElement> efsetTestHeading;

    @FindBy(className = "ets-pr-ts-date")
    public WebElement efsetDate;

    @FindBy(className = "ets-pr-ts-title")
    public WebElement efsetTitle;

    @FindBy(className = "ets-pr-ts-score")
    public WebElement efsetScore;

    @FindBy(className = "ets-pr-ts-clickable")
    public WebElement efsetRetakeTestLink;



//string

    private String totalTime;
    private String totalScore;



    public ProgressPage(WebDriver webDriver){
        super(webDriver);
    }
    public ProgressPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(progressTitleWe,levelHeadingWe,noOfLessonsLeftWe,unitListHeadingWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check Progress Title is displayed...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),progressTitleWe, WaitToolConfig.SHORT_WAIT_4_ELEMENT,1000);

      //  AssertHelper.assertWebElementDisplayed(progressTitleWe);
        return true;
    }

    public void assertTotalNumberOfUnits(String courseCode) {
        logger.info("Check if total number of  units is always greater than or equal to 5");
        if (courseCode == "GE"){
            AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), unitListGEWe, 5);
           logger.info("total units is " + unitListGEWe.size());}
        else {
            AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), unitListOtherCoursesWe, 3);
            logger.info("total units is " + unitListOtherCoursesWe.size());}
    }


    public void clickTeacherFeedback(){
        logger.info("clickTeacherFeedback");
        click(subMenusWe,2);
    }

    public void clickOnViewCertificateBtn(){
        logger.info("clickOnViewCertificateBtn");
        click(viewCertificateBtn);
    }

    public void clickOnTestTab(){
        logger.info("clickOnTestTab");
        click(subMenusWe,3);
    }

    public void checkLevelcertificateTooltip(){
        logger.info("checkLevelcertificateTooltip");
        checkAllPageComponentsDisplayed(tooltipDescription,gotItBtnlevelCertificate);
        logger.info("clickon Got it button in tooltip");
        click(gotItBtnlevelCertificate);
        logger.info("successfully clicked on got it button");
        AssertHelper.assertWebElementNotDisplayed(tooltipDescription);
    }

    public void checkLevelTestScore(String levelTestScore,String grammarScore,String vocabularyScore,String readingScore,String listeningScore){
        logger.info("checkLevelTestScore");
        checkAllPageComponentsDisplayed(leveltestTitleWe,tickMarkWe,levelScoreWe,retakeTestLinkWe,flagIconLevelTestWe);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(levelScoreWe),levelTestScore,"Level test score not correct");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(topicScoreListWe.get(0)),grammarScore,"Grammar score not correct");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(topicScoreListWe.get(1)),vocabularyScore,"Vocabulary score not correct");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(topicScoreListWe.get(2)),readingScore,"Reading score not correct");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(topicScoreListWe.get(3)),listeningScore,"Listening score not correct");
        AssertHelper.assertWebElementDisplayed(tickMarkWe);
    }

    public void checkEFSETComponents(){
        logger.info("checkEFSETComponents");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),efsetRetakeTestLink, WaitToolConfig.PAGELOAD_TIMEOUT_45,1000);
        checkAllPageComponentsDisplayed(efsetTestHeading.get(1),efsetDate,efsetScore,efsetTitle,efsetRetakeTestLink);
        AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.cssSelector(".ets-pr-ts-date span")));
        AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.cssSelector(".ets-pr-ts-title span strong[data-text-en='EFSET']")));
        AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.cssSelector(".ets-pr-ts-score span")));
    }

    public void clickOnRetestLink() {
        logger.info("click on retake test");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(), retakeTestLinkWe, WaitToolConfig.LONG_WAIT_4_ELEMENT, 1000);
        click(retakeTestLinkWe);
    }

    public void clickOnEFSETTestLink() {
        logger.info("clickOnEFSETTestLink");
        click(efsetRetakeTestLink);

    }

    public void assertTotalNumberOfLevelsAndStagesInGE() {
        logger.info("assertTotalNumberOfLevelsInGE");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), noOfLevelCirclesGE, 16);
        logger.info("assertTotalNumberOfStagesInGE");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), noOfStagesGE, 6);

    }

    public void assertTotalNumberOfMainTabs() {
        logger.info("assertTotalNumberOfMainTabs");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), subMenusWe, 4);

    }

    public int getCurrentLevel(int levelIndex) {
        logger.info("checkCurrentLevel");
        return Integer.parseInt(noOfLevelsGE.get(levelIndex).getText());
    }


    public void checkStatusOfLesson(int unitNumber,int lessonNumber,String courseCode) {
         logger.info("checkStatusOfLesson..!");
         if(courseCode=="GE")
         unitListGEWe.get(unitNumber).findElement(By.className("ets-pr-lesson-state"));
         else
             unitListOtherCoursesWe.get(unitNumber).findElement(By.className("ets-pr-lesson-state"));

    }

    public void checkUnitComponents(int unitIndex){
        logger.info("checkUnitComponents..!");
        logger.info("Unit Number" +unitNumberWe.get(unitIndex));
        logger.info("Unit Name" +unitHeadingWe.get(unitIndex));


    }

//    public String getLessonStatus(int unitNumber,int lessonNumber) {
//        logger.info("getLessonStatus");
//
//        WebElement webElement = null;
//
//        try {
//            webElement = unitListWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.cssSelector(".ets-pr-checkmark circle"));
//            return "completed";
//        } catch (WebDriverException e) {
//            logger.warn("this step is not marked as completed ...!  " + e.getMessage());
//        }
//        return null;
//    }

    public void assertLessonCompleted(int unitNumber,int lessonNumber,String courseCode){
        logger.info("assertLessonCompleted");
        if(courseCode=="GE")
        AssertHelper.assertWebElementDisplayed(unitListGEWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.cssSelector(".ets-pr-checkmark circle")));
        else
        AssertHelper.assertWebElementDisplayed(unitListOtherCoursesWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.cssSelector(".ets-pr-checkmark-passed")));

        logger.info("Lesson Completed");
    }

    public void assertDeviceUsed(int unitNumber,int lessonNumber,String deviceUsed){
        logger.info("assertDeviceUsed");
      // AssertHelper.assertStringContains(unitListSpinWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.cssSelector(".ets-pr-ico-pc")).getAttribute("data-at-device"),deviceUsed,"Device used is not "+deviceUsed);
        AssertHelper.assertWebElementDisplayed(unitListGEWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.cssSelector(".ets-pr-ico-pc")));

    }


    public void assertTotalTime(int unitNumber,int lessonNumber,String courseCode) {
        logger.info("assertTotaltime");
        if(courseCode=="GE")
        totalTime = TestUtil.getWebElementText(unitListGEWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.className("ets-pr-lesson-time-spent")));
        else{
        totalTime = TestUtil.getWebElementText(unitListOtherCoursesWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.className("ets-pr-lesson-time-spent")));}
        int totalTime1=Integer.parseInt(totalTime.split(" ")[0]);
        AssertHelper.myAssertThat(getWebDriver(),"time not present",totalTime1, greaterThanOrEqualTo(1),false);
        //AssertHelper.assertStringContains(totalTime,expTotalTime,"total time not matching");
        logger.info("Total time ="+totalTime);

    }

    public void assertTotalScore(int unitNumber,int lessonNumber,String courseCode) {
        logger.info("assertTotalScore");
        if(courseCode=="GE")
            totalScore = TestUtil.getWebElementText(unitListGEWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.className("ets-pr-lesson-score")));

        else
            totalScore = TestUtil.getWebElementText(unitListOtherCoursesWe.get(unitNumber).findElements(By.className("ets-pr-lesson")).get(lessonNumber).findElement(By.className("ets-pr-lesson-score")));

        AssertHelper.assertThat(totalScore+" received is not greater than 0 ...!" , Integer.parseInt(StringUtils.remove(totalScore, "%")), greaterThan(0) ) ;
        logger.info("Total Score ="+totalScore);

    }


    @Override
    public String getPageUrl(){
        return pageUrl;
    }


    }











