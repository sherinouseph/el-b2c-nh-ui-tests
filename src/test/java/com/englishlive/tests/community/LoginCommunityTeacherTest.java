//package com.englishlive.tests.community;
//
//import com.englishtown.pages.community.CommunityLoginPage;
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
// // retire .. chat new project
//public class LoginCommunityTeacherTest extends BaseLoginCommunityTest {
//    private static final Logger logger = LoggerFactory.getLogger(LoginCommunityTeacherTest.class);
//    @Value("#{applicationPropertiesList['community.login.url']}")
//    protected String pageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testCommunityUsername = getActiveTeacherPerEnv();
//        testCommunityUserPass = "1";
//        openUrl(getWebDriver(), pageUrl);
//        communityLoginPage = new CommunityLoginPage(getWebDriver());
//    }
//
//    @Test (dependsOnMethods = { "loginCommunityUser" })
//    public void isActiveStudent(){
//        communityHomePage.isActiveStudent();
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}
