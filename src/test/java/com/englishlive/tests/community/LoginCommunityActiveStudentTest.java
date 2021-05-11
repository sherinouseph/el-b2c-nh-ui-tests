//package com.englishlive.tests.community;
//
//import com.englishtown.pages.community.CommunityLoginPage;
//import com.englishtown.tests.core.community.BaseLoginCommunityTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
///**
// * Login in
// */
//  // retire .. new chat
//public class LoginCommunityActiveStudentTest extends BaseLoginCommunityTest {
//    private static final Logger logger = LoggerFactory.getLogger(LoginCommunityActiveStudentTest.class);
//    @Value("#{applicationPropertiesList['community.login.url']}")
//    protected String pageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testCommunityUsername = getActiveUserPerEnv();
//        testCommunityUserPass = "a";
//        openUrl(getWebDriver(), pageUrl);
//        communityLoginPage = new CommunityLoginPage(getWebDriver());
//    }
//
////    @Test (dependsOnMethods = { "loginCommunityUser" })
////    public void isActiveStudent(){
////        communityHomePage.isActiveStudent();
////    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}
