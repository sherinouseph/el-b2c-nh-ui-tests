package com.englishlive.tests.newhouse.school.course.currentcourse.goal;
/**
 * Change goal test
 * Sherin - 07/02/2018
 * Click on goal link in current course
 * Check current goal hours are displayed
 * click onchange goal button, click on set new goal button after selecting new goal hours
 * check if the goal has changed
 * Click on change goal and cancel the goal change...Goal shouldn't change
 *
 *
 *  auto_changegoal@qp1.org simd/mid 1025687	11408866
 */
import com.englishtown.tests.core.school.course.goal.BaseChangeGoalTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ChangeGoalTest extends BaseChangeGoalTest {
    private static final Logger logger = LoggerFactory.getLogger(ChangeGoalTest.class);

    @Value("#{applicationPropertiesList['user.changegoal']}")
    protected String testUsername;


    @BeforeClass
    protected void setupOpenUrl(){
        setThreadSafeDriver();//MyBrowserType.EDGE, 36);                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";

        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), getBASEURL());
        refresh(getWebDriver());
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
