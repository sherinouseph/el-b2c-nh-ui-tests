//package com.englishlive.tests.mobileandtablets.simulator.android.phone.englishcentre;
//
//import com.englishlive.tests.englishcentre.core.ECBaseFormTest;
//import com.englishlive.tests.englishcentre.data.ECECTestDataConstants;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
//import com.englishtown.driver.mobile.ChromeSimulatoriPhone6WebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
///**
// * Created by nikol.marku on 26/01/2016.
// */
//// 404 error content changed ... few times by now imposible to manage
//public class CEformToTYTest extends ECBaseFormTest {
//    private static final Logger logger = LoggerFactory.getLogger(CEformToTYTest.class);
//
//    @Value("#{applicationPropertiesList['home.efec.form.ce']}")
//    private String pageUrl;
//
//
//
//    @BeforeClass
//    private void setup() {
//    //setupMobile
//        BaseRemoteWebDriver.setDeviceNameForMobileSimulator("Samsung Galaxy S4");
//        setScreenShotOnFailure(false);
//        if(BaseRemoteWebDriver.isBrowser("chrome")){
//            try {
//                WebDriver simulatorDriver = new ChromeSimulatorSamsungGalaxyS4WebDriver();
//                setWebDriver(simulatorDriver);
//            } catch (Exception e) {
//                logger.error(" Mobile driver not created : " + TestUtil.getException(e));
//            }
//        } else {
//            BasePage.failTest("This test should run only on chrome Mobile simulator [iphone, galaxy, etc ...!] ");
//        }
//        formLeadTypeValue = "ce";
//        formDataMap = ECECTestDataConstants.EFEC_CE;
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + pageUrl);
//        openUrl(getWebDriver(), pageUrl);
//    }
//
//
//}
