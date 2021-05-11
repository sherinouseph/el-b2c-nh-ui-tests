package com.englishtown.tests.core.school.course.goal;
/**
 * Goal test Own pace
 * Nikol - 21/03/2018
 * When you go in current course
 * .. CHECK  your goal msg shown
 *
 *
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseOwnPaceGoalPageTest extends BaseGoToGoalPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOwnPaceGoalPageTest.class);


    @Test(dependsOnMethods = "goToGoalPage")
    protected void checkStudyGoalOwnPaceMsg() {
        logger.info("checkStudyGoalOwnPaceMsg  ...!");
        setNewGoalPage.assertGoalPaceMsg(goalPaceMsg);

    }


}
