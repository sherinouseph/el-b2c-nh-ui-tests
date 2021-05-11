//package com.englishlive.tests.newhouse.school.course.changecourse;
///**
// *Check if the courses are active
// * Sherin
// *
// *
// */
//import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
//import com.englishtown.newhouse.school.beanandenum.GeneralEnglishCourseLevels;
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.changecourse.BaseCheckCoursesActive;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class UKCheckCourseActiveTest extends BaseCheckCoursesActive {
//    private static final Logger logger = LoggerFactory.getLogger(UKCheckCourseActiveTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testStartUrl = testUrl;
//        this.username = testUsername;
//        openUrl(getWebDriver(), testStartUrl);
//        schoolStudentBean = new SchoolStudentBean();
//        schoolStudentBean.setUnitNumber(1);
//        schoolStudentBean.setLessonNumber(1);
//        schoolStudentBean.setStepNumber(1);
//        schoolStudentBean.setNoOfCompletedLessons(0);
//        schoolStudentBean.setNoOfCompletedSteps(0);
//        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
//        generalEnglishCourseLevels= GeneralEnglishCourseLevels.BEGINNERS_1;
//        schoolStudentBean.setStep1Status("start");
//        schoolStudentBean.setStep2Status("start");
//        schoolStudentBean.setStep3Status("start");
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
