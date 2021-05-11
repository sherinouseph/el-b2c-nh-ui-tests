//package com.englishlive.tests.sauce;
//
///**
// * Created by nikol.marku on 12/16/2016.
// * https://wiki.saucelabs.com/display/DOCS/Java+Example+Script+for+Android+Mobile+Application+Tests
// * https://saucelabs.com/docs/platforms
// *
// * google for 'facebook login appium test'
// * http://stackoverflow.com/questions/37565491/how-to-automate-facebook-login-test-using-appium-in-android
// * https://wiki.saucelabs.com/display/DOCS/Supported+Devices+and+Operating+Systems+for+Mobile+Application+Testing.
// *https://wiki.saucelabs.com/display/DOCS/Example+Desired+Capabilities+for+Android+Real+Device+Tests#ExampleDesiredCapabilitiesforAndroidRealDeviceTests-SettingautomationNameforAndroidApps
// * get capabilities : https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
// *
// * nikol.marku@GBLCM-L0252 ~/app
// $ curl -u efnikolmarku:d4f02e16-dcd6-4d0a-a0ff-3ecfffc1ba17 -X POST -H "Content-Type: application/octet-stream" https://sau
// celabs.com/rest/v1/storage/efnikolmarku/facebook.apk?overwrite=true --data-binary "com.facebook.katana_106.apk"
// *
// */
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import io.appium.java_client.MobileElement;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//
//public abstract class BaseTestSauseLab implements ISauseLab{
//    private static final Logger logger = LoggerFactory.getLogger(BaseTestSauseLab.class);
//    public static final String URL = BaseRemoteWebDriver.SAUCE_HUB_URL;
//    protected static WebDriver driver ;
//
//
//    /*public BaseTestSauseLab(WebDriver driver) {
//        this.driver = driver;
//    }*/
//
//    @BeforeClass
//    public void setUpBefore() throws Exception {
//
//    }
//
//    @AfterClass
//    public void tearDownAfter() throws Exception {
//
//    }
//
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
//        caps.setCapability("deviceName","Sxxxxxxxxx");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("platformVersion", "6.0");
//        caps.setCapability("platformName","Android");
//
//        return caps;
//    }
//
//    protected static DesiredCapabilities getCapabilityAndroidEmulator(){
//        DesiredCapabilities caps = DesiredCapabilities.android();
//        caps.setCapability("appiumVersion", "1.5.3");
//        caps.setCapability("deviceName","Samsung Galaxy S4 Emulator");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("browserName", "Browser");
//        caps.setCapability("platformVersion", "4.4");
//        caps.setCapability("platformName","Android");
//
//        return caps;
//    }
//
//
//    //apps
//    protected static DesiredCapabilities getCapabilitySafariIphone7(){
//        DesiredCapabilities caps = DesiredCapabilities.iphone();
//        caps.setCapability("appiumVersion", "1.6.3");
//        caps.setCapability("deviceName","iPhone 5 Simulator");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("platformVersion","10.0");
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("browserName", "Safari");
//        return caps;
//    }
//
//   // public static MobileElement findElementByScrollingAndroidNative(WebDriver driver){
//        // driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/attachment_button_text\")").click();
//        //driver.findElementByAndroidUIAutomator("new UiScrollable().resourceId(\"com.facebook.katana:id/attachment_button_text\")");
//    //}
//
//}
//
//
//    /***
//     *
//     Example Desired Capabilities for Android Real Device Tests
//     Samsung Galaxy S6 on 6.0 Real Device Native and Hybrid Application
//     {
//     deviceName:'Samsung Galaxy S6 Device',
//     platformVersion:'6.0',
//     platformName:'Android',
//     "appActivity": ".ContactManager",
//     "appPackage": "com.example.android.contactmanager",
//     app:"http://saucelabs.com/example_files/ContactManager.apk",
//     "appium-version":"1.5.3"
//     }
//     Samsung Galaxy S5 on 5.0 Real Device Native or Hybrid Application
//     {
//     deviceName:'Samsung Galaxy S5 Device',
//     platformVersion:'5.0',
//     platformName:'Android',
//     "appActivity": ".ContactManager",
//     "appPackage": "com.example.android.contactmanager",
//     app:"http://saucelabs.com/example_files/ContactManager.apk",
//     "appium-version":"1.5.3"
//     }
//
//
//
//
// @Before
// public void setUp() throws Exception {
// String sauceUserName = "YOUR_SAUCE_USERNAME";
// String sauceAccessKey = "YOUR_SAUCE_ACCESS_KEY";
//
// DesiredCapabilities capabilities = new DesiredCapabilities();
// capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS 6.0");
// capabilities.setCapability("device", "iPhone Simulator");
// capabilities.setCapability(CapabilityType.PLATFORM, "Mac 10.8");
//
// //zip file containing your app to be tested
// capabilities.setCapability("app", "http://appium.s3.amazonaws.com/TestApp6.0.app.zip");
//
// driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)),
// capabilities);
// }
// //ios
// DesiredCapabilities caps = DesiredCapabilities.iphone();
// caps.setCapability("appiumVersion", "1.5.3");
// caps.setCapability("deviceName","iPhone 6 Device");
// caps.setCapability("deviceOrientation", "portrait");
// caps.setCapability("platformVersion","9.3");
// caps.setCapability("platformName", "iOS");
// caps.setCapability("browserName", "Safari");
//
// // set up appium against a local application
// //File appDir = new File(System.getProperty("user.dir"), "../../../apps/TestApp/build/Release-iphonesimulator");
// //File app = new File(appDir, "TestApp.app");
// /*DesiredCapabilities capabilities = new DesiredCapabilities();
// capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
// capabilities.setCapability(CapabilityType.VERSION, "6.0");
// capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
// //tell Appium where the location of the app is
// capabilities.setCapability("app", app.getAbsolutePath());*/
//
////create a RemoteWebDriver, the default port for Appium is 4723
////driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//
///*
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
//        capabilities.setCapability("platformVersion", "4.4");
//        capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
//        capabilities.setCapability("browserName", "");
//        capabilities.setCapability("deviceOrientation", "portrait");
//        capabilities.setCapability("appiumVersion", "1.5.3");
//        //caps.setCapability("app","sauce-storage:com.google.android.youtube_11.35.60-113560130.apk");
//*/
//
///*
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
//        capabilities.setCapability("platformVersion", "4.4");
//        capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
//        capabilities.setCapability("browserName", "");
//        capabilities.setCapability("deviceOrientation", "portrait");
//        capabilities.setCapability("appiumVersion", "1.5.3");
//        //caps.setCapability("app","sauce-storage:com.google.android.youtube_11.35.60-113560130.apk");
//*/
//
//
