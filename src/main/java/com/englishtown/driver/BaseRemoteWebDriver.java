package com.englishtown.driver;
/**
 *
 * User: n.marku
 * Date: 19/09/14
 * All type of Drivers classes should extend this class
 * FIREFOX ("firefox"),EXPLORER("internet explorer"),CHROME("chrome"),ANDROID("android"),
 * IPHONE("iPhone"),IPAD("iPad"), OPERA("opera"), SAFARI("safari");
 *
 */

import com.englishtown.enumpack.GridEnvironment;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestConfig;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public abstract class BaseRemoteWebDriver extends MyRemoteWebDriver { //implements IWebDriverSetting {
    //@Value("#{applicationPropertiesList['host.pc']}")
    protected static String testHost;

    private static final Logger logger = LoggerFactory.getLogger(BaseRemoteWebDriver.class);
    public static boolean isSetTimeout = true;  // set this to false for Monitoring Stats test
    public static boolean isSetImplicitWait = false; // need to remove implicit wait
    public static String simulatorDeviceName;

    /** Webdriver factory set the hub now
    static {
        setHubUrl(BaseTest.getGridEnvironment());
    }*/

    public static String getCurrentBrowserName(){
        return currentBrowserName;
    }
    public static String getBrowserName(WebDriver driver){
        String browserName = "notFound";
        try{
            browserName = ((RemoteWebDriver )driver).getCapabilities().getBrowserName();
        }catch (Exception e){
            logger.error("Can't get browser name .....!"+e.getMessage());
        }
        return browserName ;
    }

    public static void setCurrentBrowserName(String currentBrowserName) {
        BaseRemoteWebDriver.currentBrowserName = currentBrowserName;
    }

    public static String getCurrentDeviceName(){
        return currentDeviceName;
    }

    public static void setCurrentDeviceName(String deviceName){
        currentDeviceName = deviceName;
    }


    public static boolean isBrowser(String browserName){
        try{
            return StringUtils.containsIgnoreCase(getCurrentBrowserName(), browserName);
        }catch (Exception e){
            logger.error("isBrowser [{}]  Exception ...!"+TestUtil.getException(e), browserName);
            return false;
        }
    }

    public static boolean isBrowser(String browserName, String isBrowser){
        try{
            return StringUtils.contains(browserName, isBrowser);
        }catch (Exception e){
            logger.error("isBrowser [{}]  Exception ...!"+TestUtil.getException(e), isBrowser);
            return false;
        }
    }

    public static boolean isBrowser(WebDriver driver, String browserName){
        try{
            return StringUtils.contains(getBrowserName(driver), browserName);
        }catch (Exception e){
            logger.error("isBrowser [{}]  Exception ...!"+TestUtil.getException(e), browserName);
            return false;
        }
    }

    public static boolean isBrowserAndVersion(String browserName, String browserVersion){
        if(!browserVersion.isEmpty()){
            return ( BaseRemoteWebDriver.isBrowser("explore") && "10".equals(BaseRemoteWebDriver.getCapability().getVersion()) );
        }else
            return false;
    }

    public BaseRemoteWebDriver(URL url, DesiredCapabilities capability) throws Exception {
        super(url, capability);

        BaseRemoteWebDriver.capability = capability;
        if(isSetTimeout) { setTimeOut();}

        currCapabilityPlatformName = getCapabilities().getPlatform().toString().toLowerCase();
        logger.info(" currCapabilityPlatformName :" + currCapabilityPlatformName);
        try {  // for real devices
            if(simulatorDeviceName == null){
                //String tempDeviceName = getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString().toLowerCase();
                //currentDeviceName = getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString().toLowerCase();
                isMobileDevice = true;
            }

            logger.info(" currentDeviceName    :" + currentDeviceName);
        }catch (NullPointerException npe){
            logger.warn("NullPointerException  NO device NAME set ...! ");
            isMobileDevice = false;  // just to make sure
        }

        if( getCapabilities()!=null ) {
            //new appium  currCapabilityPlatformName :linux   -  currentDeviceName    :r32d1034yky
            if(currentDeviceName != null){
                if ("r32d1034yky".contains(currentDeviceName) || currCapabilityPlatformName.contains("ipad")||
                        currCapabilityPlatformName.contains("ios") || currCapabilityPlatformName.contains("mac"))  {
                    //do not max window
                    if(currentDeviceName != null && isMobileDevice) {
                        logger.info("Is mobile device ...!");
                        if (currentDeviceName.contains("ipad") || currentDeviceName.contains("iphone")) {
                            logger.info("device name :" + currentDeviceName + " is iOS device");
                            is_IOS_MobileDevise = true;
                            //cant delete cookies on iOS
                        } else {
                            logger.info("device name :" + currentDeviceName + " is not IPAD OR iPHONE device");
                        }
                    }
                }
            } else {
                if (isBrowser("safari") ) {
                    try {
                        super.manage().window().setSize(new Dimension(1600, 900));
                    }catch (WebDriverException e){e.printStackTrace();}
                } else  {
                    if(!isBrowser("MicrosoftEdge")) {
                        CookieHandler.deleteCookies(super.manage());
                    } else {
                        super.manage().window().maximize();
                    }
                }
            }
        }

    }

    public static DesiredCapabilities getCapability(){
        return capability;
    }


    public static void setCapability(DesiredCapabilities desiredCapabilities, String browserName,
                                        Platform platform) {
        logger.info("BaseRemoteWebDriver: setCapability.." + desiredCapabilities.toString() + "- " + browserName + " - " + platform);
        capability = desiredCapabilities;
        logger.info("capability : " + capability.toString());
        capability.setBrowserName(browserName);
        currentBrowserName = browserName;
        currCapabilityPlatformName = platform.name();
        capability.setPlatform(platform);

        //capability.setCapability(MobileCapabilityType.DEVICE_NAME, currentDeviceName);
        // General settings
        logger.info("Set javascript Enabled and requireWindowFocus to true ...!");
        capability.setJavascriptEnabled(IS_JAVASCRIPT_ENABLED);
        capability.setCapability("requireWindowFocus", true);
        //
        logger.info("Browser Name is       : " + capability.getBrowserName());
        logger.info("Platform Name is      : " + capability.getPlatform());
        // TODO refactor setting cappability identify all the settings common to all
        switch (browserName) {
            case "chrome":
                logger.info("chrome specific browser setting ...");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("chrome.switches", "--disable-extensions");
                options.addArguments("start-maximized");
                options.addArguments("--dns-prefetch-disable");
                capability.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            case "firefox":
                logger.info(" firefox specific browser setting - NO extras ...");
                break;
            case "internet explorer":
                logger.info(" IE specific browser setting. Force Windows to launch IE through Create Process API and in private browsing mode");
                capability.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                capability.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                //capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capability.setCapability("unexpectedAlertBehaviour", "accept");
                capability.setCapability("enablePersistentHover", true);
                break;
            case "MicrosoftEdge":
                logger.info(" edge driver Windows 10 ...!");
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                capability.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT , true);
                break;
            case "safari":
                logger.info("safari specific browser setting -...CLEAN_SESSION_CAPABILITY");
                SafariOptions safariOptions = new SafariOptions();
                //safariOptions.setUseCleanSession(true);
                safariOptions.setUseTechnologyPreview(true);
                capability.setCapability(SafariOptions.CAPABILITY, safariOptions); //desired capabilities
                capability.setCapability("CLEAN_SESSION_CAPABILITY", true);
                capability.setCapability("safari.cleanSession", true);
                capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
                capability.setBrowserName("safari");
                capability.setPlatform(Platform.MAC);
                //System.setProperty("webdriver.safari.noinstall", "true");
                is_MacSafari=true;
                break;
            case "iPhone":
                logger.info("iPhone specific browser setting ...");
                break;
            case "iPad":
                logger.info("iPad specific browser setting ..");
                setSafariDriverOnIpadCapability();
                break;
            case "chromeOnAndroidNexusPad":
                logger.info("chromeOnAndroidNexusPad specific browser setting ..");
                setChromeOnNexusTabletDriverCapability();
                break;
            case "chromeOnAndroidPhone":
                logger.info("chromeOnAndroidPhone specific browser setting ..");
                break;
            case "htmlunit":
                logger.info("htmlunit specific browser setting if needed ..");
                break;
            case "phantomjs":
                logger.info("phantomjs specific browser setting if needed ..");
                break;
            case "chromeSimulatorIpad": //?????? not sure this will work
                logger.info("chromeSimulatorIpad specific browser setting if needed ..");
                setDefaultMobileCapabilities("Apple iPad");
                break;
            case "chromeSimulatorNexus7":
                logger.info("chromeSimulatorNexus7 specific browser setting if needed ..");
                break;
            default:
                logger.info("Invalid browserName : " + browserName);
                break;
        }
        logger.info("currentDeviceName : " + currentDeviceName);
        logger.info("isMobileDevice    : " + isMobileDevice);
        logger.info("isMobileTestOnly  : " + isMobileTestOnly);
    }

    /**
     * not used anymore
     *
    public static void setHubUrl() {
        try {
            logger.info("Static init hubUrl ...!");
            boolean runFromLocalGrid  = false ; //commit with false all 3 boolean
            boolean runFromOldPC      = false ;
            boolean runFromLocalToTC  = false  ;
            boolean runOnSaucelabs    = false;
            boolean runOnBrowserstack = true;
            //TODO need refactoring ....!
            //String hostName = GetLocalIpAddress.getLocalHostName();

            if(runOnBrowserstack){
                ////public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
                nodeURL = "https://"+BaseTestConfig.BROWSERSTACK_USERNAME+":"+BaseTestConfig.BROWSERSTACK_ACCESS_KEY+
                        "@hub-cloud.browserstack.com/wd/hub";
                logger.info("Set to run on BrowserStack...  nodeURL :" + nodeURL);
            } else  if(runFromLocalGrid){
                nodeURL = LOCAL_HUB_URL;
                logger.info("Set to run on local grid...  nodeURL :" + LOCAL_HUB_URL);
            }else if(runFromOldPC){
                nodeURL = IWebDriverSetting.NMPC_HAB_URL;
                logger.info("Set NM pc grid...  nodeURL :" + nodeURL);
            }else if(runFromLocalToTC){
                nodeURL = IWebDriverSetting.TEAMCITY_HUB_URL;
                logger.info("Set TeamCity grid.. use this to run from local build to TC ..  nodeURL :" + nodeURL);
            }else if(runOnSaucelabs){
                nodeURL = SAUCE_HUB_URL;
            }
            else {
                if (GetLocalIpAddress.isLocalPc()) {
                    nodeURL = IWebDriverSetting.LOCAL_HUB_URL;
                    logger.info("Set local grid - Grid should be up and running at :" + nodeURL);
                } else if (GetLocalIpAddress.isDevPc()) {
                    nodeURL = IWebDriverSetting.DEV_HAB_URL;
                    logger.info("Set DEV grid - Grid should be up and running at :" + nodeURL);
                } else {
                    nodeURL = IWebDriverSetting.TEAMCITY_HUB_URL;
                    logger.info("Set TeamCity grid ... DEFAULT running at Grid on :" + nodeURL);
                }
            }
            testHost = nodeURL.split(":")[0];
        } catch (Exception e) {
            BasePage.failTest(e, " setHubUrl Exception");

        }
    }*/

    /**
     * Use -Dargs to setup grid
     */
    public static void setHubUrl(GridEnvironment gridEnvironment) {
        //gridEnvironment = GridEnvironment.BROWSERSTACK;
              int hostSplitId = 1;             // default split : for getting the host
        try {
            logger.info("Set Selenium[GRID] Hub Url from -D args ...!");

            switch(gridEnvironment){
                case OTHER:
                case LOCAL:
                    nodeURL = LOCAL_HUB_URL;
                    logger.info("Set to run on local grid...  Grid URL :" + LOCAL_HUB_URL);
                    break;

                case TC_GRID:
                    nodeURL = IWebDriverSetting.TEAMCITY_HUB_URL;
                    logger.info("Set TeamCity grid.. use this to run from local build to TC ..  Grid URL :" + nodeURL);
                    break;

                case BROWSERSTACK:
                    nodeURL = "https://"+BaseTestConfig.BROWSERSTACK_USERNAME+":"+BaseTestConfig.BROWSERSTACK_ACCESS_KEY+
                            "@hub-cloud.browserstack.com/wd/hub";
                    logger.info("Set to run on BrowserStack...  Grid URL :" + nodeURL);
                    break;

                default:
                    logger.info("Grid Env is not in the list ...!["+gridEnvironment.getGridEnv()+"]");
            }
            try {
                testHost = nodeURL.split(":")[hostSplitId];
                if(testHost != null)
                    testHost = testHost.replace("/", "");
                logger.info("TestHost set to [" + testHost + "] ; from URL split ...!");
            }catch (Exception e) {
                logger.error(" set testHost Exception ...!"+e.getMessage());
            }
        } catch (Exception e) {
            BasePage.failTest(e, " set Grid Url Exception ...!");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //          MOBILE
    // -----------------------------------------------------------------------------------------------------------------
   /*
    * platformName (either iOS or Android)    - platformVersion (the mobile OS version you want)
    * currentDeviceName (the kind of device you want, like iPhone Simulator)
    * automationName (Selendroid if you want to use Selendroid, otherwise, this can be omitted)
    */

    public static void setDefaultMobileCapabilities() {
        logger.info(" SetMobileCapabilities ");
        /*capability.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, "true");
        capability.setCapability(MobileCapabilityType.SUPPORTS_NETWORK_CONNECTION, "true");
        capability.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");*/
        //capability.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "40000");
        BaseRemoteWebDriver.isMobileDevice = true;
    }
    public static void setDefaultMobileCapabilities(String deviceName) {
        logger.info(" SetMobileCapabilities ");
        /*capability.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, "true");
        capability.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);*/
        BaseRemoteWebDriver.isMobileDevice = true;
    }

    public static void setMobileCapabilities(String platformName, String version, String browserName, String deviceName) {
        logger.info(" SetMobileCapabilities\n .......................................................");
        setCurrentRemoteWebDriverProperties(platformName, browserName, deviceName);
        logger.info("\nPlatform :"+platformName+",\n Version :"+version+", \nBrowser name :"+browserName+"," +
                " \nDeviceName :"+deviceName+", \nCurrentBrowserName :"+currentBrowserName);
       /*capability.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);   //iOS
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capability.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capability.setCapability(MobileCapabilityType.ELEMENT_SCROLL_BEHAVIOR, "elementScrollBehavior");*/
        //capability.setCapability(MobileCapabilityType.APP_ACTIVITY, "");
        //capability.setCapability("newCommandTimeout", "-1");
        BaseRemoteWebDriver.isMobileDevice = true;
    }

    public static void setIpadSimulatorDriverCapability() {
        try {
            capability = new DesiredCapabilities();
            setMobileCapabilities("iOS", "7.1", "Safari", "iPad Simulator");
            setDefaultMobileCapabilities();
        } catch (Exception e) {
            BasePage.failTest(e, "setIpadSimulatorDriverCapability static init Exception ");
        }
    }

    // ipad minis
    public static void setSafariDriverOnIpadCapability() {
        String platformName = "iOS";
        String browserName  = "Safari";
        String deviceName   = "iPad 1 mini";
        String version      = "9.3.5"; // "8.4" ; //"8.3 8.2"; // "8.1.3";
        isMobileDevice = true;
        try {
            capability = new DesiredCapabilities();
            setMobileCapabilities(platformName, version, browserName, deviceName);
            setDefaultMobileCapabilities();
            capability.setCapability("app","Safari");
            capability.setCapability("safariInitialUrl","about:blank");
            //capability.setCapability("appPackage", "Safari");
            capability.setCapability("udid","8f3875eefad92b632c7f9227de1b49027dc13066");
            /*capability.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
            capability.setCapability(MobileCapabilityType.SUPPORTS_NETWORK_CONNECTION, "true");
            capability.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, "true");*/
            //capability.setCapability("bundleId", "SafariLauncher");
            capability.setCapability("safariAllowPopups", false);
            //capability.setCapability("safariOpenLinksInBackground", true);
            capability.setCapability("newCommandTimeout", 60);
            capability.setCapability("launchTimeout", 40000);
            capability.setCapability("automationName", "XCUITest");
            capability.setCapability("xcodeOrgId", "8WR9DN7HHX");
            capability.setCapability("xcodeSigningId", "iPhone Developer");
            capability.setCapability("iosInstallPause", "30000");
            capability.setCapability("fullReset", false);
            capability.setCapability("noReset ", true);
            capability.setCapability("asyncScriptTimeout", 30000);
//            driver.rotate(ScreenOrientation.PORTRAIT);
//            driver.rotate(ScreenOrientation.LANDSCAPE);

        } catch (Exception e) {
            BasePage.failTest(e, "setSafariDriverOnIpadCapability static init Exception ");
        }
    }

    public static void setChromeOnNexusTabletDriverCapability() {
        String platformName = "Android";
        String browserName  = "Chrome";
        String deviceName   = "NexusOne";
        String version      = "5.1.1"; //"5.0.2";
        String deviceID     = "R32D1034YKY";
       // setCurrentRemoteWebDriverProperties(platformName,  browserName,  deviceName);
        try {
            capability = new DesiredCapabilities();
            setMobileCapabilities(platformName, version, browserName, deviceName);
            setDefaultMobileCapabilities();
            capability.setCapability("deviceReadyTimeout", 35);
            capability.setCapability("applicationName",deviceID );
            //BaseRemoteWebDriver.isMobileDevice = true; clearSystemFiles
            //autoLaunch	Whether to have Appium install and launch the app automatically. Default true	true, false
            //R32D1034YKY	device
        } catch (Exception e) {
            BasePage.failTest(e, "setChromeOnNexusTabletDriverCapability static init Exception ...! ") ;
        }
    }



    public static void setCurrentRemoteWebDriverProperties(String platformName, String browserName, String deviceName){
        currCapabilityPlatformName = platformName;
        currentBrowserName         = browserName;
        currentDeviceName          = deviceName;
    }

    /**
     * Set Webdriver wait, pageload and script timeout - Not for safari
     */
    public void setTimeOut(){
        logger.info(" Set Timeouts ...!!");
        if (isSetImplicitWait) {
            WaitTool.setImplicitWaitToDefault(super.manage());
        }
        WaitTool.setJavaScriptDefaultTimeout(super.manage());
        setPageLoadTimeOut(); //NOT FOR SAFARI
    }
    public void setPageLoadTimeOut() {
        if(! "safari".contains(currentBrowserName)){       //if (!is_MacSafari ) {
            WaitTool.setPageLoadTimeOut(super.manage(), WaitTool.DEFAULT_PAGELOAD_TIMEOUT);
        }
    }


    /************************************************************************************************************
     * Destroy browser
     * 1. webDriver.Close() - Close the browser window that the driver has focus of
     * 2. webDriver.Quit()  - Calls dispose
     * 3. webDriver.Dispose() Closes all browser windows and safely ends the session
     */
    // TODO remove driver.close as there are no multy windows
    public static synchronized void destroyDriver(WebDriver driver){
        logger.info("call method destroyDriver(). delete cookies(not for htmlunit and mobile), close() and quite() " +
                "browser... Current currentBrowserName: "+currentBrowserName);
        try{
            //dont delete cookies for htmlunit - error - net.sourceforge.htmlunit.corejs.javascript.EcmaError: TypeError: Cannot find function deleteAllCookies in object function
            if(! "MicrosoftEdge".equals(currentBrowserName )&& ! "htmlunit".equals(currentBrowserName )&& ! "safari".equals(currentBrowserName )&& null != driver ){
              try{
                  CookieHandler.deleteCookies(driver);
              }catch (WebDriverException e){
                  logger.error("Clear cookies error : "+e.getMessage());
              }
            }
            Thread.sleep(50);
            int numberOfWindows = 0;
            Set<String> availableWindows = null;
            String parentWindow = null;
            String newWindow = null;

            if( driver != null ){
                try {
                    // issue with edge browser get windows ...
                    parentWindow = driver.getWindowHandle();
                    availableWindows = driver.getWindowHandles();
                    numberOfWindows = availableWindows.size();
                }catch (Exception e){
                    e.printStackTrace();
                    logger.error(" Can't get the number of windows ...!"+e);
                }

                if(numberOfWindows > 1) {
                    logger.info("Browser has more than ONE WINDOW open ...!" );
                    for (String window : availableWindows) {
                        if (!parentWindow.equals(window)) {
                            newWindow = window;
                            logger.info(" Closing child WINDOWS Name ...!" + newWindow);
                            driver.switchTo().window(newWindow);
                            driver.close();
                            logger.info("Child Window Name...." + newWindow + " is Closed !");
                        }
                    } // get back to parent window
                    driver.switchTo().window(parentWindow);
                }
                // CLOSE PARENT
                logger.info("Closing parent Window ...."+parentWindow);
                //driver.switchTo().window(parentWindow);
                driver.close();
                logger.info("Browser closed...!!!!!");
            } else { logger.info("browser is null so can not be quited, closed ....!!!!!");}
        }catch (Exception e) {
            logger.error(" Driver close throws error :" + TestUtil.getException(e, driver));
        } finally {
            try{
                if(driver != null) {
                    driver.quit();
                    driver=null;
                }
                //ThreadGuardedWebDriverFactory.destroyThreadGuardedWebDriver();
                logger.info("browser QUIT finally ...!");
            }catch (Exception e){
                logger.error(" Driver .quite throws error :"+TestUtil.getException(e), driver);
            }
        }
    }

    // mobile
    /**
     * Set device name for mobile capability using Chrome driver
     * @param deviceName
     */
    public static void setDeviceNameForMobileSimulator(String deviceName){
        Map<String, String> mobileEmulation = new HashMap();
        mobileEmulation.put("deviceName", deviceName);
        currentDeviceName = deviceName;
        isMobileDevice = true;
        Map<String, Object> chromeOptions = new HashMap();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        try {
            BaseRemoteWebDriver.capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }catch (Exception e){
            logger.error("setDeviceNameForMobileSimulator error : "+e.toString());
        }
    }


}


// TODO ned to cast this
//    public static IOSDriver getIOSDriver(WebDriver driver){
//        IOSDriver iosDriver = driver ; //IOSDriver IOSRemoteProxy
//        return iosDriver;
//    }
//    public static void resetIosApp(WebDriver driver){
//        try {
//            logger.info("Try to resetIosApp for mobile ... devices");
//            getIOSDriver(driver).resetApp();
//            logger.info("reset app OK");
//        }catch (Exception e){
//            logger.error("resetApp  Exeption ...! ...!"+TestUtil.getException(e));
//        }
//    }
//    public static void closeIosApp(WebDriver driver){
//        try {
//            logger.info("Try to closeIosApp for mobile ... devices");
//            getIOSDriver(driver).closeApp();
//            logger.info("closeIosApp app OK");
//        }catch (Exception e){
//            logger.error("closeIosApp  Exeption ...! ...!"+TestUtil.getException(e));
//        }
//    }


