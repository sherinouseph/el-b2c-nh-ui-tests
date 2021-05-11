package com.englishlive.tests.newhouse.school.course.currentcourse.goal;
/**
 *
 * Nikol - 21/03/2018
 * Check a user OWN PACE GOAL
 *
 *
 */

import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.tests.core.school.course.goal.BaseOwnPaceGoalPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class OwnPaceGoalTest extends BaseOwnPaceGoalPageTest {
    private static final Logger logger = LoggerFactory.getLogger(OwnPaceGoalTest.class);

    @Value("#{applicationPropertiesList['user.goal.ownpace']}")
    protected String testUsername;


    @BeforeClass
    protected void setupOpenUrl(){
        setThreadSafeDriver();
        setTestGoalData("", SetNewGoalPage.GOAL_OWN_PACE_MSG,
                "", "");
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
        refresh(getWebDriver());
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
