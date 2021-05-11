package com.englishlive.tests.newhouse.school.course.currentcourse.goal;
/**
 *
 * Nikol - 21/03/2018
 * Check a user with expired goal is showing the correct message, Days, goal data
 *
 *   User should miss goal on the 21st of Jan
 *
 */

import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.tests.core.school.course.goal.BaseGoalPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MissedGoalTest extends BaseGoalPageTest {
    private static final Logger logger = LoggerFactory.getLogger(MissedGoalTest.class);

    @Value("#{applicationPropertiesList['user.goal.expired']}")
    protected String testUsername;


    @BeforeClass
    protected void setupOpenUrl(){
        setThreadSafeDriver();
        setTestGoalData(SetNewGoalPage.ZERO_DAYS_LEFT_MSG, SetNewGoalPage.GOAL_PACE_MISSED_MSG,
                "5+ Hours Weekly", "Sep 14 2020");
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
