//package com.englishlive.tests.cookie;
///**
// *
// */
//
//import com.englishlive.tests.cookie.core.BaseCookieWindowTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class ITDesktopCookieWindowTest extends BaseCookieWindowTest {
//    private static final Logger logger = LoggerFactory.getLogger(ITDesktopCookieWindowTest.class);
//    @Value("#{applicationPropertiesList['home.it.it.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        openUrl(getWebDriver(), pageUrl);
//    }
//}
