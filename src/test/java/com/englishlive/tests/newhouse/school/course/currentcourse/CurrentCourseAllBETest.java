package com.englishlive.tests.newhouse.school.course.currentcourse;
/**
 *
 * User: sherin.ouseph
 * Date:14/05/2019
 *
 *
 */
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.currentcourse.BaseCurrentCourseAllTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CurrentCourseAllBETest extends BaseCurrentCourseAllTest {
    private static final Logger logger = LoggerFactory.getLogger(CurrentCourseAllBETest.class);

    @Value("#{applicationPropertiesList['user.course.be']}")
    protected String testUsername;


    @BeforeClass
    protected void setupOpenUrl(){
        setThreadSafeDriver();                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
        testStartUrl = getBASEURL();
        username = testUsername;
        openUrl(getWebDriver(), testStartUrl);
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLessonNumber(2);
        schoolStudentBean.setStepNumber(1);
        courseCodeNumber = CourseCodeNumber.BUSINESS;
        schoolStudentBean.setStep1Status("start");
        schoolStudentBean.setStep2Status("start");
        schoolStudentBean.setStep3Status("start");

    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
