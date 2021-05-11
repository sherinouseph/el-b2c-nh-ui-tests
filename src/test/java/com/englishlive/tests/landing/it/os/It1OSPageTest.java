//package com.englishlive.tests.landing.it.os;
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//// note: page deleted .... karim
//public class It1OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(It1OSPageTest.class);
//    @Value("#{applicationPropertiesList['it1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.it']}")
//    private String localizedTestPhoneNumber;
//
////    @BeforeClass
////    private void setupMobileSimulator(){
////        //BaseRemoteWebDriver.setDeviceNameForMobileSimulator("Samsung Galaxy S4");
////        setScreenShotOnFailure(false);
////        if (BaseRemoteWebDriver.isBrowser("chrome")) {
////            try {
////                WebDriver s4SimulatorDriver = new ChromeSimulatorSamsungGalaxyS4WebDriver();
////                setWebDriver(s4SimulatorDriver);
////            } catch (Exception e) {
////                logger.error(" Mobile driver not created : " + TestUtil.getException(e));
////            }
////        } else if (BaseRemoteWebDriver.isMobileTestOnly) {
////            // run test no need to update driver
////        } else {
////            BasePage.failTest("This test should run only on Mobile device [iphone, galaxy, etc ...!] and simulators -- chrome");
////        }
////    }
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        formLeadTypeValue = "os";
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
