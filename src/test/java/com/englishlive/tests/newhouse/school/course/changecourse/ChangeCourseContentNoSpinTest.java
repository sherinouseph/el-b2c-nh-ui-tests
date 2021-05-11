//package com.englishlive.tests.newhouse.school.course.changecourse;
///**
// *Change the course
// *  Sherin
// *
// *
// * //this user do not have special interest courses offer AND TOEFL/TOEIC Ccourses in their offer
// * this user when go to change course page, will have only 2 course
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
//public class ChangeCourseContentNoSpinTest extends BaseChangeCourseContent {
//    private static final Logger logger = LoggerFactory.getLogger(ChangeCourseContentNoSpinTest.class);
//    @Value("#{applicationPropertiesList['user.change.course.nospin']}")
//    protected String testUsername;
//
//    @BeforeClass
//    protected void setup() {
//        setThreadSafeDriver();
//        testStartUrl = getBASEURL();
//        username = testUsername;
//        password = "passpass";
//        openUrl(getWebDriver(), testStartUrl);
//        refresh(getWebDriver());  // note: login page not shown sometime but shows after refresh
//        schoolStudentBean = new SchoolStudentBean();
//        schoolStudentBean.setUnitNumber(1);
//        schoolStudentBean.setLessonNumber(1);
//        schoolStudentBean.setStepNumber(1);
//        schoolStudentBean.setNoOfCompletedLessons(0);
//        schoolStudentBean.setNoOfCompletedSteps(0);
//        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
//        generalEnglishCourseLevels= GeneralEnglishCourseLevels.BEGINNERS_1;
//        enabledCourses= EnabledCourses.SPIN_FALSE_TOEFLTOEIC_TRUE;
//
//   }
//
//
//        @AfterClass
//        protected void testAfterClass () {
//            destroyDriver();
//        }
//
//
//    }