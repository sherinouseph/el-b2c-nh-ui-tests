package com.englishlive.tests.newhouse.school.classroom;
/**
 * User: nikol.marku
 * Date: 05/02/18
 *
 *
 */
import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.enumpack.Language;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.classroom.BaseConverstaionTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ConversationClassTest extends BaseConverstaionTest {
    private static final Logger logger = LoggerFactory.getLogger(ConversationClassTest.class);
    @Value("#{applicationPropertiesList['user.conversationclass']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
