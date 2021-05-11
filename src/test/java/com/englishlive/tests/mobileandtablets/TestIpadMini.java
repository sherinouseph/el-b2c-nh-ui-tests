//package com.englishlive.tests.mobileandtablets;
//
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import static com.englishtown.driver.IWebDriverSetting.MAC_ADDRESS;
//
///**
// * Created by nikol.marku on 12/28/2016.
// */
//public class TestIpadMini {
//    @Test
//    public void testIOS () throws MalformedURLException {
//        DesiredCapabilities Caps = new DesiredCapabilities();
//        Caps.setCapability("platformVersion", "9.3.5");
//        Caps.setCapability("platformName", "iOS");
//        Caps.setCapability("deviceName", "iPad 1 mini");
//        Caps.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
//        Caps.setCapability("bundleId", "SafariLauncher");  //"com.byterac.*" ); //
//        Caps.setCapability("app", "/usr/local/lib/node_modules/appium/node_modules/appium-ios-driver/build/SafariLauncher/SafariLauncher.app");
//        Caps.setCapability("udid","8f3875eefad92b632c7f9227de1b49027dc13066");
//        Caps.setCapability("fullReset", false);
//        Caps.setCapability("noReset ", true);
//        //url = new URL("http://"+MAC_ADDRESS+":"+APPIUM_SERVER_PORT_IPADMINI+"/wd/hub");
//        //        //
//        //SafariOnIPadRemoteWebDriver
//        WebDriver driver = new IOSDriver(new URL("http://"+MAC_ADDRESS+":4724/wd/hub"), Caps);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://www.google.com/");
//
//    }
//}
