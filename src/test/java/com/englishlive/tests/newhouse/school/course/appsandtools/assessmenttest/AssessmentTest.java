//package com.englishlive.tests.newhouse.school.course.appsandtools.assessmenttest;
///**
// *
// * Nikol Feb 2019
// *
// *
// */
//
//
////TODO school lite update user
//
//import com.englishtown.tests.core.school.course.appsandtools.assessment.BaseAssessmentTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class AssessmentTest extends BaseAssessmentTest {
//    private static final Logger logger = LoggerFactory.getLogger(AssessmentTest.class);
//    @Value("#{applicationPropertiesList['user.assessment']}")
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
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
