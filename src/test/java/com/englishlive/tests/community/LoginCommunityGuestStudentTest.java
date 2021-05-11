//package com.englishlive.tests.community;
//
//import com.englishtown.pages.community.CommunityLoginPage;
//import com.englishtown.tests.core.BaseTestConfig;
//import com.englishtown.tests.core.community.BaseLoginCommunityNonActiveStudentTest;
//import com.englishtown.tests.core.community.BaseLoginCommunityTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
///**
// * Login in
// */
// //Retire community project ... chat new project
//public class LoginCommunityGuestStudentTest extends BaseLoginCommunityNonActiveStudentTest {
//    private static final Logger logger = LoggerFactory.getLogger(LoginCommunityGuestStudentTest.class);
//    @Value("#{applicationPropertiesList['community.login.url']}")
//    protected String pageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testCommunityUsername = getGuestUserPerEnv();
//        testCommunityUserPass = BaseTestConfig.getPassword8();
//        openUrl(getWebDriver(), pageUrl);
//        communityLoginPage = new CommunityLoginPage(getWebDriver());
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
