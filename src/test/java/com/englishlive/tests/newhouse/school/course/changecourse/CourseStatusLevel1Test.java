package com.englishlive.tests.newhouse.school.course.changecourse;
/**
 *
 * Precondition: user enrolled level < 6
 *
 * 1) login and go to change course page
 * 2) Check spin courses are locked
 * 3) check TofelCourse is active
 *
 * NM: added test steps
 *
 * Sherin
 *
 */
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.GeneralEnglishCourseLevels;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.changecourse.BaseCheckCoursesActive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CourseStatusLevel1Test extends BaseCheckCoursesActive {
    private static final Logger logger = LoggerFactory.getLogger(CourseStatusLevel1Test.class);

    @Value("#{applicationPropertiesList['user.course.status.lessthan6']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
        refresh(getWebDriver());
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLevelNumber(1);
        schoolStudentBean.setLessonNumber(1);
        schoolStudentBean.setStepNumber(1);
        schoolStudentBean.setNoOfCompletedLessons(0);
        schoolStudentBean.setNoOfCompletedSteps(0);
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
        generalEnglishCourseLevels= GeneralEnglishCourseLevels.BEGINNERS_1;
        schoolStudentBean.setStep1Status("start");
        schoolStudentBean.setStep2Status("start");
        schoolStudentBean.setStep3Status("start");
    }


    @AfterClass
    protected void testAfterClass(){

        destroyDriver();
    }

}
