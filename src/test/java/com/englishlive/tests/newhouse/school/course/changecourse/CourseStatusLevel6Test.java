package com.englishlive.tests.newhouse.school.course.changecourse;
/**
 *
 * Precondition: user enrolled level > 5
 *
 * 1) login and go to change course page
 * 2) Check spin courses are locked
 * 3) check TofelCourse is active
 *
 * NM: added test steps
 *
 * Sherin
 *  auto_courseactivebe@qp1.org sid/mid 1025685	11408864
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


public class CourseStatusLevel6Test extends BaseCheckCoursesActive {
    private static final Logger logger = LoggerFactory.getLogger(CourseStatusLevel6Test.class);

    @Value("#{applicationPropertiesList['user.course.status.morethan5']}")
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
        schoolStudentBean.setLessonNumber(1);
        schoolStudentBean.setLevelNumber(6);
        schoolStudentBean.setStepNumber(1);
        schoolStudentBean.setNoOfCompletedLessons(0);
        schoolStudentBean.setNoOfCompletedSteps(0);
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
        generalEnglishCourseLevels= GeneralEnglishCourseLevels.ELEMENTARY_6;
        schoolStudentBean.setStep1Status("start");
        schoolStudentBean.setStep2Status("start");
        schoolStudentBean.setStep3Status("start");

    }


    @AfterClass
    protected void testAfterClass(){

        destroyDriver();
    }

}
