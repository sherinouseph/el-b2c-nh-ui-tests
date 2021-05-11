//package com.englishlive.tests.newhouse.school.course.changecourse;
///**
// * check the main components in the change course page
// * this user's offers include SPIN course and toefl/toeic
// * Sherin
// *
// * auto_tr_changecoursecontent@qp1.org mid=11408861 sid=1025682
// *
// * Should work on new house ...
// */
//import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
//import com.englishtown.newhouse.school.beanandenum.EnabledCourses;
//import com.englishtown.newhouse.school.beanandenum.GeneralEnglishCourseLevels;
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.changecourse.BaseChangeCourseContent;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class ChangeCourseContentTest extends BaseChangeCourseContent {
//    private static final Logger logger = LoggerFactory.getLogger(ChangeCourseContentTest.class);
//
//    @Value("#{applicationPropertiesList['user.change.course.content']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testStartUrl = getBASEURL();
//        username = testUsername;
//        password = "passpass";
//        openUrl(getWebDriver(), testStartUrl);
//        refresh(getWebDriver());  // note: login page not shown sometime but shows after refresh
//        schoolStudentBean = new SchoolStudentBean();
//        schoolStudentBean.setUnitNumber(1);
//        schoolStudentBean.setLessonNumber(1);
//        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
//        generalEnglishCourseLevels= GeneralEnglishCourseLevels.BEGINNERS_1;
//        enabledCourses= EnabledCourses.SPIN_TRUE_TOEFLTOEIC_TRUE;
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
