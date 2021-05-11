package com.englishlive.tests.newhouse.school.login;
/**
 * nikol.marku * Date: 09/09/14
 *
 * Login with an existing user and Logout
 *
 *
 */
import com.englishtown.driver.MyBrowserType;
import com.englishtown.tests.core.school.BaseLogout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginToSchoolAndLogoutTest extends BaseLogout {
    private static final Logger logger = LoggerFactory.getLogger(LoginToSchoolAndLogoutTest.class);

    @Value("#{applicationPropertiesList['user.login']}")
    protected String testUsername;


    @BeforeClass
    protected void setupOpenLoginUrl(){
        printTestName(logger);
        setThreadSafeDriver();
        username = testUsername;
        openUrl(getWebDriver(), getBASEURL());

    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
