package com.englishlive.tests.newhouse.school.course.appsandtools;//package com.englishlive.tests.newhouse.school.course.appsandtools.assessmenttest;

 /**
 *Sherin 21/09/2020
 *
 *
 */



import com.englishtown.tests.core.school.course.appsandtools.BaseAppsAndToolsTest;
import com.englishtown.tests.core.school.course.appsandtools.assessment.BaseAssessmentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class AppsAndToolsTest extends BaseAppsAndToolsTest {
    private static final Logger logger = LoggerFactory.getLogger(AppsAndToolsTest.class);
    @Value("#{applicationPropertiesList['user.appsAndTools']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
       // password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
