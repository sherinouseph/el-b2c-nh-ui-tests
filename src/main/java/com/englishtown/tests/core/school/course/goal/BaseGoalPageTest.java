package com.englishtown.tests.core.school.course.goal;
/**
 * Goal test Expired/missed
 * Nikol - 21/03/2018
 * When you go in current course
 * .. CHECK  your goal msg shown
 * CHECK Goal shows $ days left
 * goal section shows the current goal Pace and date
 *
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGoalPageTest extends BaseGoalTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseGoalPageTest.class);


    @Test(dependsOnMethods = "loadAndCheckSetNewGoalPage")
    protected void checkGoalDays() {
        logger.info("checkGoalDays shown ...!");
        setNewGoalPage.assertGoalDaysLeft(goalDaysLef);
    }

    @Test(dependsOnMethods = "loadAndCheckSetNewGoalPage")
    protected void checkStudyGoasMsg() {
        logger.info("checkStudyGoasMsg  ...!");
        setNewGoalPage.assertGoalPaceMsg(goalPaceMsg);
    }

    @Test(dependsOnMethods = "loadAndCheckSetNewGoalPage")
    protected void checkCurrentStudyPace() {
        logger.info("checkCurrentStudyPase  ...!");
        setNewGoalPage.assertGoalStudyPace(goalStudyPace);
    }

    @Test(dependsOnMethods = "loadAndCheckSetNewGoalPage")
    protected void checkGoalDate() {
        logger.info("checkGoalDate  ...!");
        setNewGoalPage.assertCurrentGoalDate(goalDate);
    }


}
