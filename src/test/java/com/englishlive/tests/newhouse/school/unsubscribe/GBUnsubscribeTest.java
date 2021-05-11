//package com.englishlive.tests.newhouse.school.unsubscribe;
///**
// *
// * User: nikol.marku
// * Date: 08/11/18
// */
////cannot create newhouse users anymore.Hence commenting the tests
//import com.englishtown.dataprovider.bin.StudentBean;
//import com.englishtown.tests.core.school.unsubscribe.BaseUnsubscribeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class GBUnsubscribeTest extends BaseUnsubscribeTest {
//    private static final Logger logger = LoggerFactory.getLogger(GBUnsubscribeTest.class);
//    @Value("#{applicationPropertiesList['gb.login.page']}")
//    protected String testLoginUrl;
//
//
//    @BeforeClass
//    protected void setupCreateUser(){
//        failTestPerEnvironment("live", "This test should run only QA ...!");
//        successMsg  = "been unsubscribed from";
//        errorMsg    = "error occurred while trying to unsubscribe";
//
//        testStartUrl = testLoginUrl;
//        loginUrl     = testLoginUrl;
//
//        studentBean = new StudentBean();
//        studentBean.setCountry("tr");
//        studentBean.setLang("tr");
//        studentBean = getEnrolledStudentBean(studentBean);
//    }
//
//}
