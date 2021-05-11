package com.englishlive.tests.newhouse.school.classroom;
/**
 * User: nikol.marku
 * Date: 05/02/18
 *
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.enumpack.Language;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.classroom.BaseCurrentBookingTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CurrentBookingTest extends BaseCurrentBookingTest {
    private static final Logger logger = LoggerFactory.getLogger(CurrentBookingTest.class);

    @Value("#{applicationPropertiesList['user.currentbookings']}")
    protected String testUsername;

    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
        if(WebDriverFactory.browserName=="IE") {
            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("document.execCommand(\"ClearAuthenticationCache\");");
        }
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
