package com.englishtown.tests.core.school.course.goal;
/**
 *
 * Sherin - 07/02/2018   ... NM
 *
 * Check current goal hours are displayed
 * click onchange goal buton, click on set new goal button after selecting new goal hours
 * check if the goal has changed
 * Click on change goal and cancel the goal change...Goal shouldn't change
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.ChangeYourGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;


public abstract class BaseChangeGoalTest extends BaseGoToGoalPageTest{ //BaseGoalTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseChangeGoalTest.class);

    /*@Test(dependsOnMethods = "goToCurrentCoursePage")
    protected void clickOnGoal(){
        logger.info("clickOnGoal");        // this is not shown once you missed the goal   currentCourseUnitPage.startBtnWe.get(0)
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.className(CurrentCourseUnitPage.goalLinkCss)),
                getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        sleep(1000);
        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
    }*/

    @Test(dependsOnMethods = "goToGoalPage")
    protected void checkAllComponents(){
        logger.info("checkAllComponents");
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        changeYourGoalPage.simpleTest();
        changeYourGoalPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponents")
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
        if(StringUtils.equalsIgnoreCase(currentgoalHours,"5+")) {
            logger.info("select 1-2 hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_1_2.getGoalHoursIndex());
            newgoalHours=studyGoals.GOAL_1_2.getGoalHours();

        }else{
            logger.info("select 5+ hours ");
            setNewGoalPage.selectNewGoal(studyGoals.GOAL_5_PLUS.getGoalHoursIndex());
            newgoalHours=studyGoals.GOAL_5_PLUS.getGoalHours();
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

    //check cancel in set new goal page
    @Test(dependsOnMethods = "checkNewGoalChange")
    protected void clickOnChangeGoalAndSelectNewGoal(){
        logger.info("clickOnChangeYourGoal_Cancel");
        changeYourGoalPage.clickOnChangeYourGoal();
        logger.info("successfully clicked on change your goal button");
        setNewGoalPage =new SetNewGoalPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.simpleTest();
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(setNewGoalPage.setNewGoalBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        logger.info("select new goal");
        setNewGoalPage.selectNewGoal(1);
    }

    @Test(dependsOnMethods = "clickOnChangeGoalAndSelectNewGoal")
    protected void cancelChangeGoal(){
        logger.info("cancelChangeGoal");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(setNewGoalPage.cancelLinkWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage.clickOnCancelLink();
    }

    @Test(dependsOnMethods = "cancelChangeGoal")
    protected void assertGoalHours(){
        logger.info("checkNewGoalChange");
        changeYourGoalPage = new ChangeYourGoalPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(changeYourGoalPage.goalHoursWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertThat("New Goal hours wrong",changeYourGoalPage.getCurrentGoalHours(),equalToIgnoringCase(newgoalHours));
        logger.info("Goal hours was "+newgoalHours+" Now Also it is  "+changeYourGoalPage.getCurrentGoalHours()+" Hence cancel goal hours is successful");

    }


}
