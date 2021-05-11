package com.englishlive.tests.newhouse.school.login;
/**
 * sherin.ouseph 26/06/2020
 *
 * Login with a school user with different status
 *
 *
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.schoollite.EfIdLoginPage;
import com.englishtown.tests.core.school.core.BaseSchoolTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginRedirectionTest extends BaseSchoolTest
{
    private static final Logger logger = LoggerFactory.getLogger(LoginRedirectionTest.class);


    @Test (dataProvider = "loginredirect",invocationCount = 1, timeOut = 200000 )
    public void loginAndCheckRedirectURl(String testUsername, String expectedUrl){
        logger.info("Test user ["+testUsername+"], Result Should be ["+expectedUrl+"]");
        try {
            setThreadSafeDriver();
            //DriverManager.createDriver(MyBrowserType.CHROME_HEADLESS, 35);
            openUrl(getWebDriver(), getBASEURL());
            sleep(300);
            loginAndCheckResponse(getWebDriver(),testUsername, expectedUrl);
            destroyDriver();
        }catch (WebDriverException e){
            destroyDriver();
        }
    }
    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


    @DataProvider(name = "loginredirect")
    public static Object[][] loginRedirect() {
        // username state
        return new Object[][]{
                {"b2c-n0vv@qp1.org", "contact-us"},//no student
                {"b2c-yjma@qp1.org", "contact-us"},//no grants and credits
                {"b2c-u0vt@qp1.org", "enroll"},//no enrollment
                {"b2c-dpuj@qp1.org", "campus"},//Student

        };
    }


    protected void loginAndCheckResponse(WebDriver driver, String testUsername, String expectedUrl){
        logger.info("enterUserCredentialsAndLogin  ...!");
        efIdLoginPage = new EfIdLoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        efIdLoginPage.getPageLoadedCondition();
        efIdLoginPage.enterCredentials(testUsername, password);
        sleep(1000);
        efIdLoginPage.clickLoginBtn(efIdLoginPage.loginBtn);
        sleep(3000);
        waitForUrlContains(getWebDriver(),expectedUrl,WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertStringContains(driver.getCurrentUrl(),expectedUrl,"current url does not contain "+expectedUrl);
        //assertIsUrlContaining(expectedUrl);
    }
}
