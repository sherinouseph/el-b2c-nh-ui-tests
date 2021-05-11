//package com.englishlive.tests.newhouse.school.course.changecourse;
///**
// *Change the course
// *  Sherin
// *
// *
// */
//import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.changecourse.BaseChangeCourse;
//import com.englishtown.tests.core.school.course.changecourse.BaseChangeCourseCancel;
//import com.englishtown.tests.core.school.course.changecourse.BaseChangeCourseContent;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class UKChangeCourseCancelTest extends BaseChangeCourseCancel {
//    private static final Logger logger = LoggerFactory.getLogger(UKChangeCourseCancelTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.progresstestbe']}")
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
//        schoolStudentBean.setLevelNumber(1);
//        courseCodeNumber=CourseCodeNumber.BUSINESS;
//        schoolStudentBean.setLessonCompleted(true);
//        schoolStudentBean.setTotalTime("1");
//        schoolStudentBean.setTotalScore("100");
//
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
