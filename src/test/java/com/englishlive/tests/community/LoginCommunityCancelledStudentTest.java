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
//public class LoginCommunityCancelledStudentTest extends BaseLoginCommunityNonActiveStudentTest {
//    private static final Logger logger = LoggerFactory.getLogger(LoginCommunityCancelledStudentTest.class);
//    @Value("#{applicationPropertiesList['community.login.url']}")
//    protected String pageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testCommunityUsername = getCancelledUserPerEnv();
//        testCommunityUserPass = BaseTestConfig.getPassword8();
//        openUrl(getWebDriver(), pageUrl);
//        communityLoginPage = new CommunityLoginPage(getWebDriver());
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
