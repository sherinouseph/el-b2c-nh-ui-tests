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
//
//import java.util.Arrays;
//// failed QA 23-04 2018 .. Centers have changed this and not imporant for eLive so removing it
//public class EfDotComMobileHomePageTest extends MobileHomePage {
//    private static final Logger logger = LoggerFactory.getLogger(EfDotComMobileHomePageTest.class);
//    @Value("#{applicationPropertiesList['home.mobile.ef.com.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    void setup(){
//        String[] browserList = {"chrome"};
//        failTestIfIsNotBrowser(browserList, " Run only on ["+ Arrays.toString(browserList)+"] ...!");
//        setThreadSafeDriver(MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25);
//        mobileTestUrl = pageUrl;
//        setLanguageAndMarket("es","es");
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        //simulatorDriver = null;
//        destroyDriver();
//    }
//}
