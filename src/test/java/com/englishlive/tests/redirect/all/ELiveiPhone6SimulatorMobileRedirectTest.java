//package com.englishlive.tests.redirect.all;
///**
// * when using mobile browser/device urls are redirected to mobile page
// * Run only on Mobile browser and simulator
// */
//
//import com.englishlive.tests.basetest.BaseMobileRedirectTest;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.mobile.ChromeSimulatoriPhone6WebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
//public class ELiveiPhone6SimulatorMobileRedirectTest extends BaseMobileRedirectTest {
//    private static final Logger logger = LoggerFactory.getLogger(ELiveiPhone6SimulatorMobileRedirectTest.class);
//    protected static int TEST_COUNT =0;
//    protected static int TEST_ENDCOUNT =0;
//    private static int waitTime = WaitTool.DEFAULT_WAIT_4_ELEMENT;
//
//    @BeforeClass
//    private void setup(){
//        setScreenShotOnFailure(false);
//        if(BaseRemoteWebDriver.isBrowser("chrome")  ) {
//            try {
//                WebDriver iPhone6SimulatorDriver = new ChromeSimulatoriPhone6WebDriver();
//                setWebDriver(iPhone6SimulatorDriver);
//            } catch (Exception e) {
//                logger.error(" Mobile driver not chreated : " + TestUtil.getException(e));
//            }
//        }else if (BaseRemoteWebDriver.isMobileTestOnly){
//            // run test no need to update driver
//        }
//        else {
//            BasePage.failTest("This test should run only on Mobile device [iphone, galaxy, etc ...!] and simulators -- chrome");
//        }
//    }
//
//}
//
