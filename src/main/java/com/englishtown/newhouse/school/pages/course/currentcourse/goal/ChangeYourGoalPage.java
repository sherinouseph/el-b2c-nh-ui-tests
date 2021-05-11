package com.englishtown.newhouse.school.pages.course.currentcourse.goal;

//sherin - 02/02/2018
//
//Change your Goal page object

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class ChangeYourGoalPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(ChangeYourGoalPage.class);
    public static final String pageUrl = "school/studyplan?icid=School.StudyPlan.2013#study/";


//Change goal page

    @FindBy(className = "cp-goal-change")  //.cp-goal-change
    public WebElement changeYourGoalBtnWe;

    @FindBy(css = "div[class*='ets-sp-goal-progress']")
    public WebElement titleWe;

    @FindBy(css = ".goal-date")
    public WebElement goalDateWe;


    @FindBy(css = ".cp-pace-readonly span.pace-value")
    public WebElement goalHoursWe;

    @FindBy(css = ".goal-mail input[type='checkbox']")
    public WebElement goalemailcheckboxWe;


    public ChangeYourGoalPage(WebDriver webDriver){
        super(webDriver);
    }
    public ChangeYourGoalPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(changeYourGoalBtnWe,titleWe,goalHoursWe,goalDateWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check change your goal button is displayed...!");
        AssertHelper.assertWebElementDisplayed(changeYourGoalBtnWe);
        return true;
    }


    public void clickOnChangeYourGoal(){
            logger.info("clickOnChangeYourGoal");
            click(changeYourGoalBtnWe);
    }

    public String getCurrentGoalHours(){
        logger.info("getCurrentGoalHours");
        logger.info("current goal hours is "+TestUtil.getWebElementText(goalHoursWe));
        return TestUtil.getWebElementText(goalHoursWe);

    }

    public void checkCurrentGoalHours(String goalHours) {
        AssertHelper.assertThat("Goal is wrong", goalHours, equalToIgnoringCase(goalHoursWe.getText()));
    }


    @Override
    public String getPageUrl() {
        return pageUrl;
    }




}











