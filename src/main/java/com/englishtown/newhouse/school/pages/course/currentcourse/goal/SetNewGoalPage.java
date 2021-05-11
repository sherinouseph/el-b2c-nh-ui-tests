package com.englishtown.newhouse.school.pages.course.currentcourse.goal;

//sherin - 05/02/2018
//
// Set New Goal page object

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class SetNewGoalPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(SetNewGoalPage.class);
    public static final String pageUrl = "/school/studyplan?icid=School.StudyPlan.2013#study/";

    public static final String ZERO_DAYS_LEFT_MSG = "0 day(s) left";
    public static final String GOAL_PACE_MISSED_MSG = "YOU MISSED YOUR STUDY GOAL";
    public static final String GOAL_OWN_PACE_MSG    = "YOU ARE STUDYING AT YOUR OWN PACE"; //YOU ARE STUDYING AT YOUR OWN PACE";
    public static final String goalDaysLeftCss = "campus-badge-normal";      // class name   text = 0 day(s) left
    public static final String goalPaceMsgCss  = "cp-progress-msg";          // class name  text =  You are studying at your own pace / You missed your study goal / "Left to complete this unit"
    public static final String currentGoalStudyPaceCss  = ".cp-pace-readonly .cp-pace-left-body";  // css   part of it text =  pace-value=> 3-5 pace-name=> Hours Weekly
    public static final String currentGoalDatePaceCss   = "goal-date";                             // class name   txt = Feb 8 2018


    @FindBy(className = goalDaysLeftCss)
    public WebElement goalDaysLeftWe;   // to get the text how many days left to complete goal

    @FindBy(className = goalPaceMsgCss)
    public WebElement goalPaceMsgWe;

    @FindBy(css = currentGoalStudyPaceCss)
    public WebElement currentGoalStudyPaceWe;

    @FindBy(className = currentGoalDatePaceCss)
    public WebElement currentGoalDatePaceWe;
    //currentGoalDatePaceWe currentGoalStudyPaceWe  goalPaceMsgWe goalDaysLeftWe

    @FindBy(className = "cp-goal-set")
    public WebElement setNewGoalBtnWe;

    @FindBy(className = "cp-goal-cancel")
    public WebElement cancelLinkWe;

    @FindBy(css = ".goal-mail input[type='checkbox']")
    public WebElement goalemailcheckboxWe;

    @FindBy(className = "pace-item-edit")
    public List <WebElement> goalhrsWe;


    @FindBy(className = "cp-progress-msg-goal-set")
    public WebElement setNewGoalTitleWe;

    @FindBy(className = "cp-progress-sub-msg-goal-set")
    public WebElement setNewGoalSubTitleWe;

    @FindBy(className = "ets-icon-badge-goal-poly")
    public WebElement setNewGoalFlagIconWe;


    public SetNewGoalPage(WebDriver webDriver){
        super(webDriver);
    }

    public SetNewGoalPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(setNewGoalBtnWe,cancelLinkWe,setNewGoalSubTitleWe,setNewGoalTitleWe,goalhrsWe.get(0));
        return false;
    }

    public boolean simpleTest() {
        logger.info("check set new goal button  is displayed...!");
        AssertHelper.assertWebElementDisplayed(setNewGoalBtnWe);
        return true;

    }

    public void clickOnSetNewGoal(){
            logger.info("clickOnSetNewGoal");
            click(setNewGoalBtnWe);
           logger.info("successfully clicked on set new goal btn");
    }

    public void clickOnCancelLink(){
        logger.info("clickOnCancelLink");
        click(cancelLinkWe);
        logger.info("successfully clicked on cancel");
    }

    public void selectNewGoal(int newGoalHours) {
        logger.info("selectNewGoal");
        click(goalhrsWe,newGoalHours);

    }

    /**
     * Get text from web element
     * @return
     */
    public String getGoalDaysLeft() {
        return TestUtil.getWebElementText(goalDaysLeftWe);
    }

    public String getGoalPaceMsg() {
        return TestUtil.getWebElementText(goalPaceMsgWe);
    }

    public String getCurrentGoalStudyPace() {
        return TestUtil.getWebElementText(currentGoalStudyPaceWe);
    }

    public String getCurrentGoalDatePace() {
        return TestUtil.getWebElementText(currentGoalDatePaceWe);
    }
    /**
     *
     * @param daysLeft e.g "0 day(s) left"
     */
    public void assertGoalDaysLeft(String daysLeft){
        AssertHelper.assertThat("Not the expected  Days left...!", getGoalDaysLeft(), containsString(daysLeft));;
    }

    public void assertGoalPaceMsg(String goalPaceMsg){
        AssertHelper.assertWebElementDisplayed(goalPaceMsgWe);
        //AssertHelper.assertThat("Not the expected  goal pace...!", getGoalPaceMsg(), containsString(goalPaceMsg));;
    }

    public void assertCurrentGoalDate(String goalDate){
        AssertHelper.assertWebElementDisplayed(currentGoalDatePaceWe);
        //AssertHelper.assertThat("Not the expected  goal date...!", getCurrentGoalDatePace(), containsString(goalDate));;
    }

    public void assertGoalStudyPace(String studyPace){
        AssertHelper.assertThat("Not the expected studyPace ...!", getCurrentGoalStudyPace(), containsString(studyPace));;
    }



    @Override
    public String getPageUrl() {
        return pageUrl;
    }

}











