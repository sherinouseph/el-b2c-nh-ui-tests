//package com.englishlive.tests.mobileandtablets.simulator.android.phone.home;
//
//import com.englishlive.tests.mobileandtablets.general.home.MobileHomePage;
//import com.englishtown.driver.MyBrowserType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class DeWwsMobileHomePageTest extends MobileHomePage {
//    private static final Logger logger = LoggerFactory.getLogger(DeWwsMobileHomePageTest.class);
//    @Value("#{applicationPropertiesList['home.mobile.de.wws.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    void setup(){
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        setThreadSafeDriver(MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25);
//        mobileTestUrl = pageUrl;
//        setLanguageAndMarket("de","cz");
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}
