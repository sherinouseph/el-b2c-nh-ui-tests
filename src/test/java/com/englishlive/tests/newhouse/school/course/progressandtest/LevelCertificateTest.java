package com.englishlive.tests.newhouse.school.course.progressandtest;
/**
 * Sherin - 16/04/2018
 *
 * Level certificate test for UK
 * see https://jira.eflabs.io/browse/SAND-6471
 *
 * NM: update to new house TR and rename
 *
 */
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.LevelTestScoresBean;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.progressandtest.BaseLevelCertificateTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

 //   // TODO: User need to be setup
public class LevelCertificateTest extends BaseLevelCertificateTest {
    private static final Logger logger = LoggerFactory.getLogger(LevelCertificateTest.class);
    @Value("#{applicationPropertiesList['user.levelcertificate']}")
    protected String testUsername;       


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
        //failTestPerEnvironment("live","This test run  only QA as advance tool works only QA");
        testStartUrl = getBASEURL();
        username = testUsername;
        openUrl(getWebDriver(), testStartUrl);
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setLevelNumber(1);
        certifiedDate="Sep 07, 2020";
        levelName="Beginner";
        studentName="John Doe";
        levelTestScoresBean = new LevelTestScoresBean("100","100","100","100","100");
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;

    }


    @AfterClass
    protected void testAfterClass()
    {
        destroyDriver();
    }


}
