package com.englishlive.tests.newhouse.school.enroll;
/**
 * Login an existing user that has not completed Enrollment and
 * check start enroll page .. start button is there etc
 *
 * auto_nostartenroll@qp1.org
 *
 * https://jira.eflabs.io/browse/SAND-5456
 * User: nikol.marku
 * Date: 02/03/18
 *
 *
 */
import com.englishtown.tests.core.school.BaseEnrollmentStartPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// todo : create users not enrolled - Enrollment not wired on school lite yet 19/11/2019
public class EnrollmentTest extends BaseEnrollmentStartPageTest {
    private static final Logger logger = LoggerFactory.getLogger(EnrollmentTest.class);


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
        this.username = "b2c-seg2@qp1.org";
        openUrl(getWebDriver(), getBASEURL());
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
