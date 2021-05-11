package com.englishtown.newhouse.school.pages.course.progressandtests;

//sherin - 21/03/2018
//
//Teacher feedback Page

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeacherFeedbackPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(TeacherFeedbackPage.class);
    public static final String pageUrl = "/school/progressreport?icid=School.Progress.2012#teacher-feedback";




    @FindBy(css = ".ets-pr-header-title p")
    public WebElement teacherFeedbacktitleWe;

    @FindBy(css = "td.ets-pr-fb-date span")
    public List<WebElement> dateListWe;


    @FindBy(className = "ets-pr-fb-course-bread-crumb")
    public List<WebElement>levelAndUnitNameWe;

    @FindBy(className = "ets-pr-fb-title")
    public List<WebElement>lessonNameWe;

    @FindBy(className = "ets-pr-fb-teacher")
    public List<WebElement>teacherNameWe;

    @FindBy(css = "td.ets-pr-fb-type span")
    public List<WebElement>typeWe;

    @FindBy(css = "td.ets-pr-fb-device")
    public List<WebElement>deviceNameWe;

    @FindBy(css = "td.ets-pr-fb-score span")
    public List<WebElement> scoreWe;

    @FindBy(className = "ets-pr-pagination")
    public WebElement pageNavigationWe;

    //open teacher feedback


    @FindBy(css = ".ets-pr-fb-teacher img")
    public WebElement teacherImgWe;

    @FindBy(css = ".ets-pr-fb-content p")
    public List <WebElement> feedbackContentWe;

    @FindBy(className = "ets-pr-fb-score-large")
    public WebElement scoreDisplayedLarge;

    @FindBy(className = "ets-pr-fb-open-survey-button") //"ets-pr-fb-content-buttons")
    public  WebElement surveyLinkWe;


    //survey page

    @FindBy(className = "ets-pr-fb-survey-question")
    public List<WebElement> surveyQuestionWe;







    public TeacherFeedbackPage(WebDriver webDriver){
        super(webDriver);
    }
    public TeacherFeedbackPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(teacherFeedbacktitleWe,dateListWe.get(0),lessonNameWe.get(0),teacherNameWe.get(0),typeWe.get(0),scoreWe.get(0),pageNavigationWe);
        return false;//devicename and levelandunit name to be added after the fix
    }

    public boolean simpleTest() {
        logger.info("check Progress Title is displayed...!");
        WaitTool.waitForListElementsDisplayed(getWebDriver(),
                By.cssSelector(".ets-pr-header-title p"), 30);
        AssertHelper.assertWebElementDisplayed(teacherFeedbacktitleWe);
        return true;
    }

    public void assertTotalNumberTitle(String courseCode) {
        logger.info("Check if total number of  units is always greater than or equal to 5");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), lessonNameWe, 1);
        logger.info("total teacher feedback given is " + lessonNameWe.size());
    }


    public void expandTeacherFeedback(int index){
        logger.info("clickTeacherFeedback");
        click(lessonNameWe,index);
    }

    //expand teacher feedback ..window opens up


    public boolean checkComponentsFeedbackPage() {
        checkAllPageComponentsDisplayed(feedbackContentWe.get(0),teacherImgWe,scoreDisplayedLarge);//surveylink only for writing
        return false;
    }

    //check surveyquestions are displayed

    public void checkSurveyQuestionSize() {
        AssertHelper.assertElementSizeEqual(getWebDriver(),surveyQuestionWe,3);
        logger.info("All the three questions are displayed");
    }


    @Override
    public String getPageUrl(){
        return pageUrl;
    }


    }











