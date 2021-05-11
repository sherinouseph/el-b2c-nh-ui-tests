package com.englishlive.tests.newhouse.school.course.progressandtest;
/**
 * Login an existing user and Logout
 * User: sherin ouseph
 * Date: 16/01/2019
 *
 *  autob2c_tr_progressge@qp1.org
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.progressandtest.BaseProgressTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ProgressGETest extends BaseProgressTest {
    private static final Logger logger = LoggerFactory.getLogger(ProgressGETest.class);

    @Value("#{applicationPropertiesList['user.progresstestge']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
        testStartUrl = getBASEURL();
        username = testUsername;
        openUrl(getWebDriver(), testStartUrl);
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLessonNumber(1);
        schoolStudentBean.setLevelNumber(1);
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
        schoolStudentBean.setTotalTime("3");
        schoolStudentBean.setLessonCompleted(true);
        schoolStudentBean.setTotalScore("82");
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}
