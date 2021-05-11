//package com.englishlive.tests.cookie;
///**
// *
// */
//
//import com.englishlive.tests.cookie.core.BaseCookieWindowTest;
//import com.englishtown.helpers.WebDriverWindowHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// removed as no point running it when not fixed for months
//public class DeMobileCookieWindowTest extends BaseCookieWindowTest {
//    private static final Logger logger = LoggerFactory.getLogger(DeMobileCookieWindowTest.class);
//    @Value("#{applicationPropertiesList['home.de.de.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        isMobileExperience = true;
//        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),1200, 900);
//        openUrl(getWebDriver(), pageUrl);
//    }
//}
