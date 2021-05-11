//package com.englishlive.tests.sauce;
//
///**
// * Created by nikol.marku on 12/16/2016.
// * https://wiki.saucelabs.com/display/DOCS/Java+Example+Script+for+Android+Mobile+Application+Tests
// *
// */
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.AssertHelper;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.android.AndroidDriver;
//import org.testng.annotations.Test;
//
//import java.net.URL;
//
//import static org.hamcrest.core.Is.is;
//
//
//public class NikolTestSauseLabAndroidTestOld {
//
//    public static final String URL = BaseRemoteWebDriver.SAUCE_HUB_URL;
//
//    @Test
//    public static void testMain() throws Exception {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
//        capabilities.setCapability("platformVersion", "4.4");
//        capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
//        capabilities.setCapability("browserName", "");
//        capabilities.setCapability("deviceOrientation", "portrait");
//        capabilities.setCapability("appiumVersion", "1.5.3");
//
//        WebDriver driver = new AndroidDriver<>(new URL(URL), capabilities) ; // getCapabilitySafariIphone7());
//
//        /**
//         * Test Actions here...
//         */
//        String testUrl = "https://englishlive.ef.com/it-it/";
//        driver.get(testUrl);
//        AssertHelper.assertThat("Not the expected page title ...!", "title", is(driver.getTitle()));
//
//        driver.quit();
//    }
//
//    //web
//    protected static DesiredCapabilities getCapabilityIos(){
//        DesiredCapabilities caps = DesiredCapabilities.iphone();
//        caps.setCapability("appiumVersion", "1.5.3");
//        caps.setCapability("deviceName","iPhone 6 Device");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("platformVersion","9.3");
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("browserName", "Safari");
//
//        return caps;
//    }
//    protected static DesiredCapabilities getCapabilityAndroid(){
//        DesiredCapabilities caps = DesiredCapabilities.android();
//        caps.setCapability("appiumVersion", "1.5.3");
//        caps.setCapability("deviceName","Samsung Galaxy S7 Device");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("platformVersion", "6.0");
//        caps.setCapability("platformName","Android");
//
//        return caps;
//    }
//
//    //apps
//    protected static DesiredCapabilities getCapabilitySafariIphone7(){
//        DesiredCapabilities caps = DesiredCapabilities.iphone();
//        caps.setCapability("appiumVersion", "1.6.3");
//        caps.setCapability("deviceName","iPhone 7 Simulator");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("platformVersion","10.0");
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("browserName", "Safari");
//        return caps;
//    }
//
//}
//
//
///***
//
// //ios
// DesiredCapabilities caps = DesiredCapabilities.iphone();
// caps.setCapability("appiumVersion", "1.5.3");
// caps.setCapability("deviceName","iPhone 6 Device");
// caps.setCapability("deviceOrientation", "portrait");
// caps.setCapability("platformVersion","9.3");
// caps.setCapability("platformName", "iOS");
// caps.setCapability("browserName", "Safari");
//
//
// ****/