//package com.englishlive.tests.mobileandtablets.simulator.android.phone.home;
//
//import com.englishlive.tests.mobileandtablets.general.home.MobileHomePage;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.HomePageTest;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
////karim updated to go to homepage .. so no need for this test
//public class FrWwsMobileHomePageTest extends MobileHomePage {
//    private static final Logger logger = LoggerFactory.getLogger(FrWwsMobileHomePageTest.class);
//    @Value("#{applicationPropertiesList['home.mobile.fr.wws.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    void setup(){
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        setThreadSafeDriver(MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25);
//        mobileTestUrl = pageUrl;
//        setLanguageAndMarket("fr","be");
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        //simulatorDriver = null;
//        destroyDriver();
//    }
//}
