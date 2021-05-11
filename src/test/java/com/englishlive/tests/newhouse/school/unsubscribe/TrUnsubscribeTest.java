//package com.englishlive.tests.newhouse.school.unsubscribe;
///**
// *
// * User: nikol.marku
// * Date: 08/11/18
// */
////cannot create newhouse users on QA. Hence commenting the test
//
//import com.englishtown.dataprovider.bin.StudentBean;
//import com.englishtown.tests.core.school.unsubscribe.BaseUnsubscribeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class TrUnsubscribeTest extends BaseUnsubscribeTest {
//    private static final Logger logger = LoggerFactory.getLogger(TrUnsubscribeTest.class);
//    @Value("#{applicationPropertiesList['tr.login.url']}")
//    protected String testLoginUrl;
//
//
//    @BeforeClass
//    protected void setupCreateUser(){
//        failTestPerEnvironment("live", "This test should run only QA ...!");
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
