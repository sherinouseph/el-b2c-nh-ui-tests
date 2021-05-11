//package com.englishlive.tests.newhouse.school.enroll;
///**
// *
// * https://jira.eflabs.io/browse/SAND-5456
// * User: nikol.marku
// * Date: 02/03/18
// *
// *
// *
// *
// */
//import com.englishtown.tests.core.school.BaseEnrollmentAllTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
// // NM use TR
////TODO use api to create user that is not enrolled ....
//public class UkEnrollAllTest extends BaseEnrollmentAllTest {
//    private static final Logger logger = LoggerFactory.getLogger(UkEnrollAllTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    //enrolled user testuser.with.startenroll
//    @Value("#{applicationPropertiesList['testuser.noenroll']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();                                                          //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
//        testStartUrl = testUrl;
//        this.username = testUsername;
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
