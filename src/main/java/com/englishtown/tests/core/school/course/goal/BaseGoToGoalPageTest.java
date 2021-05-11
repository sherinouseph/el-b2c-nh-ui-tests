package com.englishtown.tests.core.school.course.goal;
/**
 * Base for all goal tests
 * Nikol - 21/03/2018
 *
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGoToGoalPageTest extends BaseGoalTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseGoToGoalPageTest.class);


    @Test(dependsOnMethods = "loadAndCheckSetNewGoalPage")
    protected void goToGoalPage(){
        logger.info("goToGoalPage");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.className(CurrentCourseUnitPage.goalLinkCss)),
                getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        sleep(1000);

        waitForVisibleClickableAndClick(currentCourseUnitPage.goalLinkWe, WaitTool.MED_WAIT_4_ELEMENT25);

        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

    }



}
