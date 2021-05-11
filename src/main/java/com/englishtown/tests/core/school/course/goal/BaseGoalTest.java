package com.englishtown.tests.core.school.course.goal;
/**
 * Base for all goal tests
 * Nikol - 21/03/2018
 * No actions
 * Wait for
 *
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.tests.core.school.course.currentcourse.BaseCurrentCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGoalTest extends BaseCurrentCourse {
    private static final Logger logger = LoggerFactory.getLogger(BaseGoalTest.class);


    /**
     * Do not do anything here as different pages shown depending on the user
     */
    @Test(dependsOnMethods = "goToCurrentCoursePage")
    protected void loadAndCheckSetNewGoalPage() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");        //WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(  By.className(SetNewGoalPage.goalPaceMsgCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        setNewGoalPage = new SetNewGoalPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }


}
