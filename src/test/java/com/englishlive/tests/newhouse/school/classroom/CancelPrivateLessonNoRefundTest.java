//package com.englishlive.tests.newhouse.school.classroom;
///**
// *
// *test commented as  no PLS are available within 24 hours when the test run
// * User: sherin ouseph
// * Date: 19/02/2020
// * run this on demand as most of the times, there are no classes available within 24 hours
// *
// *
// */
//import com.englishtown.enumpack.CourseLevel;
//import com.englishtown.enumpack.CourseUnit;
//import com.englishtown.enumpack.Language;
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.classroom.BaseBookPLAndCancelPLTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CancelPrivateLessonNoRefundTest extends BaseBookPLAndCancelPLTest {
//    private static final Logger logger = LoggerFactory.getLogger(CancelPrivateLessonNoRefundTest.class);
////    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
////    protected String testUrl;
//    @Value("#{applicationPropertiesList['user.bookcancelnorefund']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testStartUrl = getBASEURL();
//        username = "b2c-zphl@qp1.org";
//        password = "passpass";
//        isPLWithin24hrs=true;
//        selectTopicIndex = 0;
//        openUrl(getWebDriver(), testStartUrl);
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
