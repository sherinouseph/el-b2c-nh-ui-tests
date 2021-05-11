package com.englishlive.tests.newhouse.school.account;
/**
 *
 * User: nikol.marku
 * Date: 03/09/19
 *
 *
 */
import com.englishtown.tests.core.school.useraccount.BaseChangeEmailNotificationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ChangeEmailNotificationSettingTest extends BaseChangeEmailNotificationTest {
    private static final Logger logger = LoggerFactory.getLogger(ChangeEmailNotificationSettingTest.class);
    @Value("#{applicationPropertiesList['user.profile']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        setUserEmail(username);
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}


/**
 (testUsername, "", CourseLevel.BEGINNERS_1.getCourseLevelName(),
 Integer.parseInt(CourseLevel.BEGINNERS_1.getCourseLevelNumber()),
 Integer.parseInt(CourseUnit.UNIT_1.getUnitNumber()),  2, 2, "uk",
 Language.EN,0,0 ,"","","","")
 */