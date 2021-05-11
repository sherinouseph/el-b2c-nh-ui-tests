//package com.englishlive.tests.mobileandtablets.simulator.android.phone.home;
//
//import com.englishlive.tests.mobileandtablets.general.home.MobileHomePage;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.HomePageTest;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class RUMobileHomePageTest extends MobileHomePage {
//    private static final Logger logger = LoggerFactory.getLogger(RUMobileHomePageTest.class);
//    @Value("#{applicationPropertiesList['home.mobile.ru.ru.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    void setup(){
//        mobileTestUrl = pageUrl;
//        setLanguageAndMarket("ru","ru");
//    }
//}
