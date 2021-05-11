package com.englishtown.driver.local;

/**
 *   Create browser with predefined config
 */


import com.englishtown.driver.*;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.community.BaseCommunityPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestConfig;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class WebDriverFactory extends RemoteWebDriver implements IWebDriverSetting{
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    /*private static final String CHROME_EXE_FILE = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe");
    private static final String IE_EXE_FILE = TestUtil.getAbsolutPathToDriverExe("IEDriverServer.exe") ;
    private static final String EDGE_EXE_FILE = TestUtil.getAbsolutPathToDriverExe("MicrosoftWebDriver.exe") ;
    private static final String PHANTOMJS_EXE_FILE_EXE_FILE = "C:\\selenium\\grid\\phantomjs.exe" ; //TestUtil.getAbsolutPathToDriverExe("IEDriverServer.exe") ;*/

    public static final String[] CHROME_EMULATOR_LIST = { "Galaxy S5", "iPhone 6", "Nexus 10", "iPad Pro"};   //"Samsung Galaxy S4"
    public static String browserName;

    /**
     * https://w3c.github.io/webdriver/#dfn-page-load-strategy
     * Keyword	Page load strategy state	Document readiness state
     "none"	none
     "eager"	eager	"interactive"
     "normal"	normal	"complete"
     */
    public static String pageLoadStrategy = "none";
    public static boolean isPageLoadStrategy = false;

    DesiredCapabilities capa;


    public static String testOnBrowserName;// passed by -D args

    static {
        BaseRemoteWebDriver.setHubUrl(BaseTest.getGridEnvironment());
    }

    /**
     * 
     * Return Protected driver - ThreadGuard.protect(driver)
     * LocalWebdriver Manager make this visible so the access level is set to package
     * this is thread safe as it uses ThreadLocal
     *
     * @param myBrowserType
     * @param //timeoutSeconds if you need to set the timeout
     * @return
     */
    public static WebDriver getBrowser(MyBrowserType myBrowserType) {
        return getBrowser(myBrowserType, WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    public static WebDriver getBrowser(MyBrowserType myBrowserType, int timeoutSeconds){
        logger.info("getBrowser() SetupBrowser for :"+ myBrowserType.getBrowser());
        WebDriver driver = null;
        DesiredCapabilities capa = null;
        BaseRemoteWebDriver.currentDeviceName = null;
        // Nov 2017 https://www.browserstack.com/automate/physical-mobile-devices
        // Default (Android): 1.4.16  Default (iOS): 1.7.0 (iOS only supports this version)
        // https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
        String browserstackAppiumVersionIos = "1.7.0";
        String browserstackAppiumVersionAndroid = "1.6.5";

        try {
            System.setProperty("webdriver.ie.driver", IE_EXE_FILE);
            System.setProperty("webdriver.chrome.driver", CHROME_EXE_FILE);
            System.setProperty("webdriver.edge.driver", EDGE_EXE_FILE);
            String driverPath = TestUtil.getAbsolutPathToDriverExe(GECKO_DRIVER_FILENAME) ;
            System.setProperty(GECKO_DRIVER_KEY, driverPath);


            switch (myBrowserType) {
                case FIREFOX:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = getCapability(DesiredCapabilities.firefox(),MyBrowserType.FIREFOX.getBrowser() ,Platform.ANY );        //DesiredCapabilities.chrome()  //capa.setBrowserName("chrome");    capa.setPlatform(Platform.ANY);
                    FirefoxProfile ffProfile = new FirefoxProfile();
                    JavaScriptError.addExtension(ffProfile); // used to get FF console error
                    capa.setCapability(FirefoxDriver.PROFILE, ffProfile);
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.setCapability("moz:useNonSpecCompliantPointerOrigin", true);
                    firefoxOptions.addArguments("--disable-gpu");
                    setBrowserStackCommonCapabilityNotMobile(capa);
                    capa.setCapability("project", "B2C_NH_UI_FF_Tests");
                    capa.setCapability("resolution", "1920x1080");
                    capa.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                    if(isPageLoadStrategy) {
                        capa.setCapability("pageLoadStrategy", pageLoadStrategy); //"normal"               capa.setCapability("pageLoadingStrategy", pageLoadingStrategy); //"normal"
                        logger.info("Page load strategy cappas added [{}]", pageLoadStrategy);
                    }
                    driver = createProtectDriver(null, capa);                                                                     //ThreadGuard.protect( new RemoteWebDriver(new URL(BaseRemoteWebDriver.nodeURL),capa) );                    //driver = ThreadGuard.protect(new FirefoxDriver());// new FirefoxDriver();
                    maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("firefox"); //todo refactor this use basetest
                    break;                                                                                                              //driver.manage().window().maximize();              return driver;
                case CHROME:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );//driver = ThreadGuard.protect(new ChromeDriver());   //driver.manage().window().maximize();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-gpu");
                    capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );          //DesiredCapabilities.chrome()  //capa.setBrowserName("chrome");    capa.setPlatform(Platform.ANY);
                    setBrowserStackCommonCapabilityNotMobile(capa);
                    capa.setCapability("project", "B2C_NH_UI_CHROME_Tests");
                    capa.setCapability("resolution", "1920x1080");
                    capa.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    capa.setJavascriptEnabled(IS_JAVASCRIPT_ENABLED);
                    if(isPageLoadStrategy) {
                        capa.setCapability("pageLoadStrategy", pageLoadStrategy); //"normal"               capa.setCapability("pageLoadingStrategy", pageLoadingStrategy); //"normal"
                        logger.info("Page load strategy cappas added [{}]", pageLoadStrategy);
                    }
                    driver = createProtectDriver(null, capa);                                                                     //ThreadGuard.protect( new RemoteWebDriver(new URL(BaseRemoteWebDriver.nodeURL),capa) );
                    maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    break;                                                                                                              //driver.manage().window().maximize();                    //return driver;
                case CHROME_HEADLESS:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    ChromeOptions chromeOptions1 = new ChromeOptions();
                    chromeOptions1.addArguments("--headless");
                    chromeOptions1.addArguments("window-size=1600x1200");
                    capa = DesiredCapabilities.chrome();
                    capa.setCapability(ChromeOptions.CAPABILITY, chromeOptions1);
                    if(isPageLoadStrategy) {
                        capa.setCapability("pageLoadStrategy", pageLoadStrategy); //"normal"               capa.setCapability("pageLoadingStrategy", pageLoadingStrategy); //"normal"
                        logger.info("Page load strategy cappas added [{}]", pageLoadStrategy);
                    }
                    driver = createProtectDriver(null, capa);                                              //driver =  new ChromeDriver(chromeOptions);    //maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    break;
                case CHROME_EMULATOR_GALAXY_S5:             //simulator
                    capa = getMobileEmulatorCapability(CHROME_EMULATOR_LIST[0]);                                             //driver = setupMobileEmulator(CHROME_EMULATOR_LIST[0]) ; //   return setupMobileEmulator(CHROME_EMULATOR_LIST[0]);//capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );          //DesiredCapabilities.chrome()  //capa.setBrowserName("chrome");    capa.setPlatform(Platform.ANY);
                    capa.setBrowserName(MyBrowserType.CHROME.getBrowser());
                    capa.setPlatform(Platform.ANY );
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    BaseRemoteWebDriver.setCurrentDeviceName(myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);
                    break;
                case CHROME_EMULATOR_IPHONE6:             //simulator
                    //driver = setupMobileEmulator(CHROME_EMULATOR_LIST[1]) ;                                              //ThreadGuard.protect(setupMobileEmulator(CHROME_EMULATOR_LIST[1]) );       //return setupMobileEmulator(CHROME_EMULATOR_LIST[1]);
                    //BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    capa = getMobileEmulatorCapability(CHROME_EMULATOR_LIST[1]);                                             //driver = setupMobileEmulator(CHROME_EMULATOR_LIST[0]) ; //   return setupMobileEmulator(CHROME_EMULATOR_LIST[0]);//capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );          //DesiredCapabilities.chrome()  //capa.setBrowserName("chrome");    capa.setPlatform(Platform.ANY);
                    capa.setBrowserName(MyBrowserType.CHROME.getBrowser());
                    capa.setPlatform(Platform.ANY );
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    BaseRemoteWebDriver.setCurrentDeviceName(myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);
                    break;

                case CHROME_SIMULATOR_IPAD:
                    capa = getMobileEmulatorCapability(CHROME_EMULATOR_LIST[3]);
                    capa.setBrowserName(MyBrowserType.CHROME.getBrowser());
                    capa.setPlatform(Platform.ANY );
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    driver = createProtectDriver(null, capa);
                    break;
                case CHROME_SIMULATOR_NEXUS:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = getMobileEmulatorCapability(CHROME_EMULATOR_LIST[2]);
                    capa.setBrowserName(MyBrowserType.CHROME.getBrowser());
                    capa.setPlatform(Platform.ANY );
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    driver = createProtectDriver(null, capa);
                    break;
                case EXPLORER10:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = DesiredCapabilities.internetExplorer();
                    capa.setCapability("browserName", MyBrowserType.EXPLORER10.getBrowser());
                    //capa.setCapability("version", "10");
                    //capa = getCapability(DesiredCapabilities.internetExplorer(),MyBrowserType.EXPLORER10.getBrowser() ,Platform.ANY );         //DesiredCapabilities.chrome()  //capa.setBrowserName("chrome");    capa.setPlatform(Platform.ANY);
                    driver = createProtectDriver(null, capa);
                    BaseRemoteWebDriver.setCurrentBrowserName("explorer10");
                    maximiseDriver(driver);
                    break;
                case EXPLORER11:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = DesiredCapabilities.internetExplorer();
                    capa.setCapability("os", "Windows");
                    capa.setBrowserName("IE");
                    capa.setCapability("os_version", "10");
                    capa.setCapability("browser", "IE");
                    capa.setCapability("browser_version", "11.0");
                    capa.setCapability("UseCleanSession", "true");
                    //capa.setCapability("technologyPreview", "true");
                    capa.setCapability("cleanSession", "true");
                    capa.setCapability("nativeEvents", true);
                    capa.setCapability("requireWindowFocus", true);
                    capa.setCapability("browserstack.sendKeys", "true");
                    //capa.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                    //capa.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                    capa.setCapability("ie.ensureCleanSession", true);
                    capa.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

                   // WebDriver driver = new InternetExplorerDriver(options);
                    //capa.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    capa.setCapability("unexpectedAlertBehaviour", "accept");
                    capa.setCapability("enablePersistentHover", true);
                    capa.setJavascriptEnabled(IS_JAVASCRIPT_ENABLED);
                    capa.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    //capa.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                    setBrowserStackCommonCapabilityNotMobile(capa);
                    capa.setCapability("project", "B2C_NH_UI_IE11_Tests");

                    driver = createProtectDriver(null, capa);                                                                                   //        driver = ThreadGuard.protect(new InternetExplorerDriver()); //new InternetExplorerDriver();
                    maximiseDriver(driver);                                                                                                                            //driver.manage().window().maximize();                    //return driver;
                    BaseRemoteWebDriver.setCurrentBrowserName("IE");
                    break;
                case EDGE:
                    logger.info(" edge driver Windows 10 ...!");
                    capa = DesiredCapabilities.edge();
                    capa.setCapability("os", "Windows");
                    capa.setCapability("os_version", "10");
                    capa.setCapability("browser", "Edge");
                    capa.setBrowserName("Edge");
                    setBrowserStackCommonCapabilityNotMobile(capa);
                    capa.setCapability("project", "B2C_NH_UI_Edge_Tests");
                    capa.setCapability("resolution", "1920x1080");
                    BaseRemoteWebDriver.setCurrentBrowserName("Edge");
                    driver = createProtectDriver(null, capa);
                    driver.manage().window().maximize();
                    break;
                case SAFARI:
                case SAFARIPREVIEW:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = getCapability(DesiredCapabilities.safari(),"safari" ,Platform.MAC );          //DesiredCapabilities.chrome()  //capa.setBrowserName("chrome");    capa.setPlatform(Platform.ANY);
                    capa.setJavascriptEnabled(true);
                    capa.setCapability("UseCleanSession", "true");
                    capa.setCapability("technologyPreview", "true");
                    capa.setCapability("cleanSession", "true");
                    BaseRemoteWebDriver.setCurrentBrowserName("safari");
                    driver = createProtectDriver(null, capa);                                                                     //ThreadGuard.protect( new RemoteWebDriver(new URL(BaseRemoteWebDriver.nodeURL),capa) );
                    maximiseDriver(driver);
                    break;

                case HTMLUNIT:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = DesiredCapabilities.htmlUnit();
                    capa.setJavascriptEnabled(true);
                    //capa.setVersion("chrome");    //capa.setBrowserName(MyBrowserType.HTMLUNIT.getBrowser());                //capa.setPlatform(Platform.WINDOWS);capa.setJavascriptEnabled(true);
                    // was driver = new HtmlUnitDriver(BrowserVersion.getDefault(), false);                 // new HtmlUnitDriver(BrowserVersion.CHROME);
                    driver = new HtmlUnitDriver(capa); // ThreadGuard.protect(new HtmlUnitDriver(capa));   //new HtmlUnitDriver(capa);  new HtmlUnitDriver(capability);         //return driver;
                    BaseRemoteWebDriver.setCurrentBrowserName("htmlunit");
                    break;

                /**
                 browserstack.appium_version
                 Use this capability to set the Appium version in your test scripts.
                 1.4.16, 1.5.3, 1.6.5
                 Default (Android): 1.4.16
                 Default (iOS): 1.7.0 (iOS only supports this version)
                 https://www.browserstack.com/automate/capabilities
                 https://www.browserstack.com/app-automate/capabilities
                 Appium's noReset and fullreset capability will not work as we always uninstall the app and clean up the device at the end of each session
                 */
                case BROWSERSTACK_ANDROID_GALAXY_S8:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = new DesiredCapabilities();                   // caps.setCapability("realMobile", true); caps.setCapability("device", "Samsung Galaxy S6"); caps.setCapability("acceptSslCert", true);  caps.setCapability("browserstack.debug", "true");
                    capa.setCapability("device", myBrowserType.getBrowser());
                    capa.setCapability("os_version", "7.0");
                    capa.setCapability("browserstack.appium_version", browserstackAppiumVersionAndroid);
                    setBrowserStackCommonCapability(capa);
                    BaseRemoteWebDriver.setCurrentDeviceName(myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);                                                                                   //        driver = ThreadGuard.protect(new InternetExplorerDriver()); //new InternetExplorerDriver();
                    MyRemoteWebDriver.isMobileDevice = true;
                    //maximiseDriver(driver);                                                                                                                                             //try {driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), capa);}catch ( Exception e){logger.error("Can not create Android driver : "+ e.getMessage());                        e.printStackTrace();                    }
                    break;

                case BROWSERSTACK_ANDROID_NEXUS9:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = new DesiredCapabilities();
                    capa.setCapability("device", myBrowserType.getBrowser());
                    capa.setCapability("os_version", "5.1");
                    capa.setCapability("browserstack.appium_version", browserstackAppiumVersionAndroid);
                    setBrowserStackCommonCapability(capa);
                    BaseRemoteWebDriver.setCurrentDeviceName(myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);                                                                                   //        driver = ThreadGuard.protect(new InternetExplorerDriver()); //new InternetExplorerDriver();
                    MyRemoteWebDriver.isMobileDevice = true;
                    //maximiseDriver(driver);
                    break;

                case BROWSERSTACK_IOS_IPHONE7:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = new DesiredCapabilities();
                    capa.setCapability("device", myBrowserType.getBrowser());
                    capa.setCapability("os_version", "10.0");
                    setBrowserStackCommonCapability(capa);
                    BaseRemoteWebDriver.setCurrentDeviceName(myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);                                                                                   //        driver = ThreadGuard.protect(new InternetExplorerDriver()); //new InternetExplorerDriver();
                    MyRemoteWebDriver.isMobileDevice = true;
                    //maximiseDriver(driver);                                                                                                                            //driver.manage().window().maximize();                    //return driver;
                    break;

                case BROWSERSTACK_IOS_IPHONE7PLUS:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = new DesiredCapabilities();
                    capa.setCapability("device", myBrowserType.getBrowser());
                    capa.setCapability("os_version", "10.0");
                    //capa.setCapability("browserName", "safari");
                    setBrowserStackCommonCapability(capa);
                    BaseRemoteWebDriver.setCurrentDeviceName(myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);                                                                                   //        driver = ThreadGuard.protect(new InternetExplorerDriver()); //new InternetExplorerDriver();
                    MyRemoteWebDriver.isMobileDevice = true;
                    //maximiseDriver(driver);                                                                                                                            //driver.manage().window().maximize();                    //return driver;
                    break;
                 // not supported yet
                /*case BROWSERSTACK_IOS_IPADPRO:
                    capa = new DesiredCapabilities();
                    capa.setCapability("browserName", "iPad");
                    capa.setCapability("platform", "MAC");
                    capa.setCapability("device", myBrowserType.getBrowser());
                    //capa.setCapability("os_version", "10.0");
                    setBrowserStackCommonCapability(capa, myBrowserType.getBrowser());
                    driver = createProtectDriver(null, capa);                                                                                   //        driver = ThreadGuard.protect(new InternetExplorerDriver()); //new InternetExplorerDriver();
                    //maximiseDriver(driver);                                                                                                                            //driver.manage().window().maximize();                    //return driver;
                    break;*/
                // use capability generator https://www.browserstack.com/automate/capabilities
                case BROWSERSTACK_SAFARI:                  //Starting real Safari 11 on macOS High Sierra
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = new DesiredCapabilities();
                    capa.setCapability("os", "OS X");
                    capa.setCapability("os_version", "High Sierra");
                    capa.setCapability("browser", "Safari");
                    capa.setCapability("browser_version", "11.0");
                    capa.setCapability("resolution", "1920x1080");
                    capa.setCapability("browserstack.local", "false");
                    setBrowserStackCommonCapabilityNotMobile(capa);
                    //capa.setCapability("browserstack.selenium_version", "3.6.0");
                    //old local config
                    capa.setCapability("UseCleanSession", "true");
                    //capa.setCapability("technologyPreview", "true");
                    capa.setCapability("cleanSession", "true");
                    BaseRemoteWebDriver.setCurrentBrowserName("safari");

                    driver = createProtectDriver(null, capa);
                    MyRemoteWebDriver.isMobileDevice = false;
                    maximiseDriver(driver);
                    break;

                case BROWSERSTACK_IE11:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = new DesiredCapabilities();
                    capa.setCapability("os", "Windows");
                    capa.setCapability("os_version", "8");
                    capa.setCapability("browser", "IE");
                    capa.setCapability("browser_version", "11.0");
                    capa.setCapability("resolution", "2048x1536");
                    capa.setCapability("browserstack.local", "false");
                    // old configs
                    capa.setCapability("nativeEvents", false);       //ie11 fix click
                    capa.setCapability("requireWindowFocus", true);
                    //capa.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                    //capa.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                    capa.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);                    //capa.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    capa.setCapability("unexpectedAlertBehaviour", "accept");
                    capa.setCapability("enablePersistentHover", true);
                    capa.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    capa.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

                    setBrowserStackCommonCapabilityNotMobile(capa);
                    BaseRemoteWebDriver.setCurrentBrowserName("explorer11");

                    driver = createProtectDriver(null, capa);
                    MyRemoteWebDriver.isMobileDevice = false;
                    maximiseDriver(driver);                                                                                                                            //driver.manage().window().maximize();                    //return driver;
                    break;

                default:
                    logger.error("Cant find setup for browser : " + myBrowserType.getBrowser());
                    BaseTest.failTest("Cant find setup for browser ["+myBrowserType.getBrowser()+"]");
                    break;
            }
            try{
                WaitTool.setJavaScriptTimeout(driver, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT);
                browserName = capa.getBrowserName();
                logger.info("browserName set from capa.getBrowserName() to :" + browserName);
            }catch (Exception e){e.printStackTrace();logger.error(e.getMessage());}
            if (BaseRemoteWebDriver.isSetImplicitWait) {
               // driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't create browser ....! "+e.getMessage());
             BasePage.failTest(e, "Can not create browser :"+ myBrowserType.getBrowser());
        }
        if(capa != null)
            logger.info("Cappabilties set to : "+capa.toString());

        return driver;
    }

    /**
     *
     * use application name to create driver on a specific node
     *
     * //todo for all browser ... IE .. edge.... FF
     *
     */
    /**
     *
     * @param myBrowserType
     * @param node
     * @return
     */
    public static WebDriver getBrowser(MyBrowserType myBrowserType, GridNode node){
        logger.info("getBrowser() on specific node SetupBrowser for :"+ myBrowserType.getBrowser()+" on node [{}]", node);
        WebDriver driver = null;
        DesiredCapabilities capa = null;
        BaseRemoteWebDriver.currentDeviceName = null;

        try {
            System.setProperty("webdriver.ie.driver", IE_EXE_FILE);
            System.setProperty("webdriver.chrome.driver", CHROME_EXE_FILE);
            System.setProperty("webdriver.edge.driver", EDGE_EXE_FILE);
            String driverPath = TestUtil.getAbsolutPathToDriverExe(GECKO_DRIVER_FILENAME) ;
            System.setProperty(GECKO_DRIVER_KEY, driverPath);

            switch (node) {

                case WIN10_GBLCM_211:
                    logger.info("Getting Browser for [{}]", node.getAppName());
                    capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );
                    capa.setCapability("applicationName", node.getAppName());
                    driver = createProtectDriver(null, capa);
                    maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    break;


                case WIN10_GBLCM_209:
                    logger.info("Getting Browser for [{}]", node.getAppName());
                    capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );
                    capa.setCapability("applicationName", node.getAppName());
                    driver = createProtectDriver(null, capa);
                    maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    break;

                case WIN7_GBLCM:
                    logger.info("Getting Browser for [{}]", node.getAppName());
                    capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );
                    capa.setCapability("applicationName", node.getAppName());
                    driver = createProtectDriver(null, capa);
                    maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("chrome");
                    break;

                default:
                    logger.error("Cant find setup for browser : " + node.getAppName());
                    BaseTest.failTest("Cant find setup for browser ["+myBrowserType.getBrowser()+"]");
                    break;
            }

            try{
                browserName = capa.getBrowserName();
                logger.info("browserName set from capa.getBrowserName() to :" + browserName);
            }catch (Exception e){
                logger.error(e.getMessage());}

        }catch (Exception e){
            logger.error("Can't create browser ....! "+e.getMessage());
            BaseTest.failTest("Can not create browser :"+ myBrowserType.getBrowser()+"; ERROR :"+e.getMessage());
        }

        return driver;
    }





    public static void setBrowserStackCommonCapability(DesiredCapabilities capa){
        capa.setCapability("browserstack.selenium_version", "3.5.2" );
        capa.setCapability("realMobile", "true");
        capa.setCapability("project", BaseTest.getProjectName()+"_"+BaseTest.getBuildNumber());
        capa.setCapability("build", BaseTest.getBuildNumber());
        capa.setCapability("browserstack.debug", "true");
        capa.setCapability("acceptSslCerts", "true");        // capa.setCapability("fullReset", "true"); capa.setCapability("browserstack.appium_version", appiumVersion);
    }

    public static void setBrowserStackCommonCapabilityNotMobile(DesiredCapabilities capa){
        capa.setCapability("browserstack.debug", "true");
        capa.setCapability("browserstack.networkLogs", "true");
        capa.setCapability("browserstack.local", true);
        capa.setCapability("browserstack.name", true);
        capa.setCapability("browserstack.timezone", "GMT");
        capa.setCapability("browserstack.localIdentifier", "b2c_qa_test");
        capa.setCapability("build", java.time.LocalDate.now().toString());
        capa.setCapability("name", BaseTestConfig.getTestName());
    }

    /**
     * need some work
     * @param deviceName
     * @return
     */
    public static WebDriver setupMobileEmulator(String deviceName){
        System.setProperty("webdriver.chrome.driver", CHROME_EXE_FILE);
        Map<String, String> mobileEmulation = new HashMap();
        mobileEmulation.put("deviceName", deviceName);
        Map<String, Object> chromeOptions = new HashMap();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        BaseRemoteWebDriver.currentDeviceName = deviceName;
        WebDriver driver = null; //new ChromeDriver(capability);

        try{
            driver = ThreadGuard.protect(new RemoteWebDriver(new URL(BaseRemoteWebDriver.nodeURL),capability) );
        }catch (MalformedURLException ue){
            BaseCommunityPage.failTest(ue, "Can not create browser emulator for ["+ deviceName+"]");
        }
        if(driver == null) {
            BasePage.failTest("Driver is null ...!");
        }

        return  driver ;
    }

    /**
     *
     * @param deviceName
     * @return Capas
     */
    public static DesiredCapabilities getMobileEmulatorCapability(String deviceName){
        System.setProperty("webdriver.chrome.driver", CHROME_EXE_FILE);
        Map<String, String> mobileEmulation = new HashMap();
        mobileEmulation.put("deviceName", deviceName);
        Map<String, Object> chromeOptions = new HashMap();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capability ; // = DesiredCapabilities.chrome();
        capability = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );
        capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return  capability ;
    }


    public static DesiredCapabilities getCapability(DesiredCapabilities capabilities, String browserTypeName, Platform platform ){
        DesiredCapabilities desiredCapabilities = capabilities;
        desiredCapabilities.setBrowserName(browserTypeName);
        desiredCapabilities.setPlatform(platform);
        return desiredCapabilities;
    }

    /**
     * Create protected driver using ThreadGuard.protect(driver)
     * IF
     * @param gridNodeUrl gridNodeUrl (IF value is null, use default node, if =local don't use grid)
     * @param capabilities
     * @return
     */
    public static WebDriver createProtectDriver(String gridNodeUrl, DesiredCapabilities capabilities){
        String nodURL =  BaseRemoteWebDriver.nodeURL; //"http://usb-etbuild5:4444/wd/hub";//

        if(gridNodeUrl == null){
            //logger.info("Use Default grid BaseRemoteWebDriver.nodeURL ["+nodURL+"]  ....!");
            return createThreadGuardDriver(nodURL, capabilities);
        }else if(StringUtils.equals(gridNodeUrl , "local") ) {
            logger.info("Create local driver; No grid used ....!");
            return ThreadGuard.protect( new RemoteWebDriver(capabilities) );
        }else {
            logger.info("Create grid driver ....! Grid node:"+nodURL);
            return createThreadGuardDriver(nodURL, capabilities);
        }
    }


    public static WebDriver createThreadGuardDriver(String nodURL, DesiredCapabilities capabilities){
        StringBuilder sb = new StringBuilder("Exception :");
        int count = 0;
        WebDriver driver = null;
        do {
            count++;
            logger.info("Try count [{}]", count);
            TestUtil.mySleep(1000);

            try {
                driver = ThreadGuard.protect(new RemoteWebDriver(new URL(nodURL), capabilities));
                if (driver instanceof WebDriver) {
                    logger.info("Driver created ...!");
                    break;
                }
            } catch (MalformedURLException e) {
                sb.append(" \n " + e.getMessage());
                //e.printStackTrace();                if(count >= CREATE_DRIVER_WAITTIME)                    BaseTest.failTest("Can't create browser ...! " + capabilities.toString() + " \n" + e.getMessage());
            } catch (Exception e) {
                sb.append(" \n " + e.getMessage());
               // e.printStackTrace();                if(count >= CREATE_DRIVER_WAITTIME)                    BaseTest.failTest("Can't create browser ...! " + capabilities.toString() + " \n" + e.getMessage());
            }
        } while (count < CREATE_DRIVER_WAITTIME);

        if(!"Exception :".equalsIgnoreCase(sb.toString()))
            logger.warn(sb.toString());

        if(!(driver instanceof WebDriver))
            BaseTest.failTest("Can't create browser ...! " + capabilities.toString() + " \n" + sb.toString());

        return driver;
    }

    public static void maximiseDriver(WebDriver driver){
        driver.manage().window().maximize();
    }


    public static String getTestOnBrowserName() {
        return testOnBrowserName;
    }

    public static void setTestOnBrowserName(String testOnBrowserName) {
        WebDriverFactory.testOnBrowserName = testOnBrowserName;
    }

    /**
     * Set browser the test will run and set browser name
     * on BaseRemoteWebdriver to support existing platform
     */
    public static void setTestOnBrowserNameFromDargs() {
        String browserName = TestUtil.getProperty("browser");
        if(StringUtils.isBlank(browserName)){
            logger.warn("\nCould not get browser name from D args ...! Set it to chrome");
            browserName = MyBrowserType.CHROME.getBrowser();
            BaseRemoteWebDriver.setCurrentBrowserName(browserName);
        }
        logger.info("Browser Name set to [{}]", browserName);
        WebDriverFactory.testOnBrowserName = browserName;
    }


}







//    /**
//     * Get property value from -D args .. if not return empty ""
//     * @param key  -D args key
//     * @return key
//     */
//    public static String getProperty(String key) {
//        String keyValue = "";
//        try{
//            logger.info("System.getProperty [{}]", key);
//            keyValue = System.getProperty(key);
//        }catch (Exception e){
//            logger.error("Return Chrome default browser; Can not get -D args for [{}]", key+"\n"+e.getMessage());
//        }
//
//        logger.info("System.getProperty key: [{}] - Value: "+keyValue, key);
//
//        return keyValue;
//    }

/**
 *
 /*String nameBuildNo = "ProjectName_BuildNo";
 String buildNo = "00";

 try {
 nameBuildNo = BaseTest.getProjectName()+"_"+BaseTest.getBuildNumber();
 buildNo = BaseTest.getBuildNumber();
 }catch (NullPointerException ne){
 logger.error("Build number or project name is null ...! ", ne.getMessage());
 }  */



 //IE cappas
 /*capa.setPlatform(Platform.WINDOWS);                    capa.setCapability("nativeEvents", false);       //ie11 fix click                    capa.setCapability("requireWindowFocus", true);
 capa.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);                    capa.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
 capa.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);                    //capa.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
 capa.setCapability("unexpectedAlertBehaviour", "accept");                    capa.setCapability("enablePersistentHover", true);                    capa.setJavascriptEnabled(IS_JAVASCRIPT_ENABLED);

 *
 *

 // DesiredCapabilities desiredCaps = DesiredCapabilities.safari();
 SafariOptions sOptions = new SafariOptions();
 sOptions.setUseCleanSession(true); // init a clean Safari session at all times
 sOptions.setUseTechnologyPreview(true); // enable Technology Preview //capa.setCapability("UseTechnologyPreview", "true");
 //capa.setCapability(SafariOptions.CAPABILITY, sOptions);
 ///DesiredCapabilities safariCapas = DesiredCapabilities.safari();               safariCapas.setBrowserName("safari"); //MyBrowserType.SAFARI.getBrowser()
 *
 *
 *
 *case JBROWSER:     //you can use driver.getStatusCode() on Jbrowser
        //capa = new DesiredCapabilities("jbrowserdriver", "1", Platform.ANY);                              // Optionally customize the settings     /*capa.merge( Settings.builder().timezone(Timezone.AMERICA_NEWYORK).buildCapabilities());*/
        // driver = ThreadGuard.protect( new JBrowserDriver(Settings.builder().userAgent(UserAgent.CHROME).build()) ); //Settings.builder().timezone(Timezone.AMERICA_NEWYORK).build()
        // BaseRemoteWebDriver.setCurrentBrowserName("jbrowser");
        //break;
        //case PHANTOMJS:                                                                                         //DesiredCapabilities caps = new DesiredCapabilities();           driver = new PhantomJSDriver(caps);
        //driver = new PhantomJSDriver();                                                                     //return driver;
        //break;*/

/*
 * FWIW: Window sizing has been working for me with the newly-released Safari 11.0.
 *
 * https://github.com/SeleniumHQ/selenium/issues/3796
 I'm using os.arch: 'x86_64', os.version: '10.12.6', java.version: '1.8.0_144', selenium: 3.4.0, safari: 10.1.2 and with Safari Technology Preview (Release 38, August 2017) works fine. This is my Java code:

 SafariOptions safariOpts = new SafariOptions();
 safariOpts.setUseCleanSession(true);
 safariOpts.setUseTechnologyPreview(true);

 DesiredCapabilities cap = DesiredCapabilities.safari();
 cap.setCapability(SafariOptions.CAPABILITY, safariOpts);
 And after that, the driver.manage().window().maximize() instruction, started working.
 */

// working bstack
/*capa = DesiredCapabilities.safari();
                    capa.setPlatform(Platform.MAC);                   //"os", "OS X High Sierra");
                    capa.setBrowserName("Safari");                    //capa.setCapability("os_version", "11");
                    capa.setCapability("browser_version", "11");
                    capa.setCapability("UseCleanSession", "true");
                    //capa.setCapability("technologyPreview", "true");
                    capa.setCapability("cleanSession", "true");
                    setBrowserStackCommonCapabilityNotMobile(capa);
                    driver = createProtectDriver(null, capa);
                    MyRemoteWebDriver.isMobileDevice = false;
                    maximiseDriver(driver);*/    //driver.manage().window().maximize();                    //return driver;

    /*capa = DesiredCapabilities.internetExplorer();
                    //TODO specify the win 10 .. find out //capa.setPlatform(Platform.WIN10);  //capa.setCapability("platform", "WINDOWS");
                    capa.setCapability("browserName", MyBrowserType.EXPLORER11.getBrowser());
                    // capa.setCapability("nativeEvents", false);       //ie11 fix click
                    capa.setCapability("requireWindowFocus", true);
                    capa.setCapability("browser_version", "11");
                    capa.setCapability("UseCleanSession", "true");
                    capa.setCapability("cleanSession", "true");*/
