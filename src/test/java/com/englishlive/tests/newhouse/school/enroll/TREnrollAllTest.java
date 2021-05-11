//package com.englishlive.tests.newhouse.school.enroll;
///**
// *
// * https://jira.eflabs.io/browse/SAND-5456
// * User: nikol.marku
// * Date: 02/03/18
// *
// *
// *
// * TODO: check other test finish enroll and check school
// */
//import com.englishtown.tests.core.school.BaseEnrollmentAllTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
////TODO use api to create user that is not enrolled ....
//public class TREnrollAllTest extends BaseEnrollmentAllTest {
//    private static final Logger logger = LoggerFactory.getLogger(TREnrollAllTest.class);
//    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
//    protected String testUrl;
//    //enrolled user testuser.with.startenroll
//    @Value("#{applicationPropertiesList['testuser.tr.noenroll']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        startEnrolmentUrl = "/1/enrollment/";    //submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
//        testStartUrl = testUrl;
//        username = testUsername; //"auto_tr_287213088101528_CWH926_xdelx@qp1.org"; //  testUsername;
//        password = "passpass";
//        motivationIndex = 3;
//        levelIndex = 3;
//        openUrl(getWebDriver(), testStartUrl);
//        sleep(1000);
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
