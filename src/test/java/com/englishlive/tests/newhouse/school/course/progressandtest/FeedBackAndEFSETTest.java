package com.englishlive.tests.newhouse.school.course.progressandtest;
/**
 *
 *
 *
 */
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.progressandtest.BaseTeacherFeedbackTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class FeedBackAndEFSETTest extends BaseTeacherFeedbackTest {
    private static final Logger logger = LoggerFactory.getLogger(FeedBackAndEFSETTest.class);
    @Value("#{applicationPropertiesList['user.feedbackpage']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
        testStartUrl = getBASEURL();
        this.username = testUsername;
        openUrl(getWebDriver(), testStartUrl);
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLessonNumber(1);
        schoolStudentBean.setLevelNumber(1);
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
    }


    @AfterClass
    protected void testAfterClass()
    {
        destroyDriver();
    }


}
