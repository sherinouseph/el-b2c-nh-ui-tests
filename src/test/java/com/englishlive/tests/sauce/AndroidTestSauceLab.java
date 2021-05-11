//package com.englishlive.tests.sauce;
//
///**
// * Created by nikol.marku on 12/16/2016.
// * https://wiki.saucelabs.com/display/DOCS/Java+Example+Script+for+Android+Mobile+Application+Tests
// * https://saucelabs.com/docs/platforms
// *https://drive.google.com/open?id=0B4PisVdrPbMON0FWc3pGMkZzUU0
// * google for 'facebook login appium test'
// */
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.AssertHelper;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.android.AndroidDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import java.net.URL;
//
//import static org.hamcrest.core.Is.is;
//
//
//public class AndroidTestSauceLab extends BaseTestSauseLab {
//    private static final Logger logger = LoggerFactory.getLogger(BaseTestSauseLab.class);
//
//
//    @Test
//    public static void testMain() throws Exception {
//
//        driver = new AndroidDriver<>(new URL(URL), getCapabilityAndroidEmulator()); // getCapabilitySafariIphone7());
//
//        /**
//         * Test Actions here...
//         */
//        String testUrl = "https://englishlive.ef.com/it-it/";
//        driver.get(testUrl);
//        AssertHelper.assertThat("Not the expected page title ...!",
//                "Corso di Inglese Online | EF English Live | Englishtown", is(driver.getTitle()));
//
//        driver.quit();
//    }
//
//
//}