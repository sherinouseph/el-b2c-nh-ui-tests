//package com.englishlive.tests.sauce;
//
///**
// * Created by nikolmarku on 18/12/2016.
// *
//
// */
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidKeyCode;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//public class FacebookLoginTest extends BaseTestSauseLab {
//    private static final Logger logger = LoggerFactory.getLogger(FacebookLoginTest.class);
//
//
//    @Test
//    public void testLoginFB() throws MalformedURLException, InterruptedException {
//        String baseAppLoc = "C:\\cygwin64\\home\\nikol.marku\\app\\";  //engage app ...engage-englishtown-qa-release.apk
//        String appName = "facebook1.apk";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("automationName", "Appium");
//        capabilities.setCapability("appiumVersion", "1.5.3");
//        capabilities.setCapability("platformName","Android");
//        capabilities.setCapability("platformVersion", "4.4");
//        capabilities.setCapability("deviceName","R32D1034YKY"); //"Samsung Galaxy S4 Emulator");
//        capabilities.setCapability("deviceOrientation", "portrait");        //capabilities.setCapability("browserName", "Chromium");        //capabilities.setCapability("fullReset", true);        //capabilities.setCapability("noReset ", false);           // facebook4_0_3_min.apk invalid apk for 106  // //facebook.apk point to 106 invalid apk    ///e.ge capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");        //capabilities.setCapability("app",baseAppLoc+appName) ;  //"sauce-storage:facebook.apk");     //:com.facebook.katana_106.0.0.15.68-45500248   "http://saucelabs.com/example_files/ContactManager.apk"); //                                                                             //"https://saucelabs.com/rest/v1/storage/efnikolmarku/facebook.apk");        //"https://drive.google.com/open?id=0B4PisVdrPbMON0FWc3pGMkZzUU0");               //"D:\\EF\\project\\nikol\\qa\\src\\test\\java\\com\\englishlive\\tests\\sauce\\apps\\android\\facebook.apk" ); //"C:\Users\Jenny\Downloads\facebook.apk");
//        capabilities.setCapability("appPackage", "com.facebook.katana");
//        capabilities.setCapability("appActivity", "com.facebook.katana.LoginActivity");
//
//        logger.info("Sauce Hub url : "+LOCAL_APPIUM);
//        AndroidDriver driver = new AndroidDriver(new URL(LOCAL_APPIUM),capabilities); //capabilities );   getCapabilityAndroidEmulator()                     // new AndroidDriver<>(new URL(URL), getCapabilityAndroidEmulator());
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        //driver.get("http://google.co.uk/?nikol");
//        Thread.sleep(8000);
//        String intallNowEngage = "com.facebook.katana:id/attachment_button_text";
//        //driver.findElementByAndroidUIAutomator("new UiScrollable().resourceId(\"com.facebook.katana:id/attachment_button_text\")").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/attachment_button_text\")").click();
//        Thread.sleep(80000);
//
//        driver.context("NATIVE_APP");// set the context to Native*/
//        // _fb_sign_in_button.click(); // click on the fb button in native app
//        Thread.sleep(10000); // sleep
//        Set<String> contextNames = driver.getContextHandles();
//        for (String contextName : contextNames) {
//            System.out.println(contextName);
//            if (contextName.contains("WEBVIEW")) {
//                driver.context(contextName);
//            }
//        }
//        /*driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")").sendKeys("xxxxxx@gmail.com");
//        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_password\")").sendKeys("xxxxxx");
//        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_login\").text(\"LOG IN \")").click();
//        Thread.sleep(8000);
//
//        //driver.findElement(By.id("com.hathy.fblogin:id/login_button")).click();
//        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")").
//        //driver.findElementByXPath("//android.widget.EditText[@index='0']").sendKeys("abc@gmail.com");
//       /* driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")").sendKeys("chinatest23@gmail.com");
//        //driver.sendKeyEvent(AndroidKeyCode.ENTER);
//        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_password\")").sendKeys("XXXXX");
//        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_login\").text(\"LOG IN\")").click();
//        Thread.sleep(8000);*/
//    }
//}
//
//
//
//
//
//
///*
//
// capabilities.setCapability("platformName", "Android");
//    capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
//    capabilities.setCapability("platformVersion", "4.4");
//    capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
//    capabilities.setCapability("browserName", "");
//    capabilities.setCapability("deviceOrientation", "portrait");
//    capabilities.setCapability("appiumVersion", "1.5.3");
//
//
//
//    Set the Desired Capabilities of Your Test to Reference Your Application File in Sauce Storage
//Sauce Storage URLs are in the form sauce-storage:<upload_filename>. After you've uploaded the file, you can set your test to reference the application at the Sauce Storage URL with the app capability, as shown in this example for Java.
//DesiredCapabilities caps = DesiredCapabilities.iphone();
//caps.setCapability("appiumVersion", "1.4.16");
//caps.setCapability("deviceName","iPhone 6");
//caps.setCapability("deviceOrientation", "portrait");
//caps.setCapability("platformVersion","9.2");
//caps.setCapability("platformName", "iOS");
//caps.setCapability("browserName", "");
//caps.setCapability("app","sauce-storage:myapp.zip");
//
////capabilities.setCapability("browserName", "Browser");
//        //capabilities.setCapability("automationName", "Appium");
//        //capabilities.setCapability("platformnName", "Android");
//        //capabilities.setCapability("platformVersion", "5.1.1");
//        //capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator" ); // "Nexus 6");
//
//DesiredCapabilities caps = DesiredCapabilities.android();
//caps.setCapability("automationName","appium");
//caps.setCapability("appiumVersion", "1.5.3");
//caps.setCapability("deviceName","Samsung Galaxy Tab 3 Emulator");
//caps.setCapability("deviceOrientation", "portrait");
//caps.setCapability("browserName", "");
//caps.setCapability("platformVersion","4.2");
//caps.setCapability("platformName","Android");
//caps.setCapability("app","sauce-storage:instagram-4-2-2-en-android.apk");
//caps.setCapability("automationName","Selendroid");
// */
