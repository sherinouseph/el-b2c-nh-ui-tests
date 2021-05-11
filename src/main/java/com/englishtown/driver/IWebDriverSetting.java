package com.englishtown.driver;

import com.englishtown.helpers.utils.TestUtil;

/**
 * Hub configuration
 */ //final class
public interface IWebDriverSetting {

    int CREATE_DRIVER_WAITTIME = 21; // SEC

    // Versions
    String FF_VERSION = "31.0";
    String IE_VERSION = "";
    String SAFARY_VERSION = "";
    String CHROME_VERSION = "";
    String[] SIMULATOR_NAME_LIST = {"iOS Simulator", "", ""};
//    String browserVersion = "";
//    String baseUrl="notinit";
    // Grid config
    String TEAMCITY_HUB_HOSTNAME   = "10.162.85.203"; //"USB-ETBUILD5";
    String DEV_HUB_HOSTNAME        = "GBLCM-L0321";
    //String LOCAL_HUB_HOSTNAME      = "GBLCM-W0096"; // "GBLCM-W0096" ; //"NIKOLMARKU-PC";
    String NNPC_HUB_HOSTNAME       = "GBLCM-W0096" ;
    String HOMELAPTOP_HUB_HOSTNAME = "NIKOLMARKU-PC";  //192.168.1.64
    //String LOCAL_GRID_HUB_HOSTNAME = LOCAL_HUB_HOSTNAME ; // MY OLD PC"GBLCM-W0096";                                                                                                                         //oldLaptopIpAddress = "10.24.205.87";//static final String myOldHubIpAddressPC = "10.24.208.142" ;//static final String myHubIpAddress   = "10.24.209.22" ; //old pc "10.24.208.142";     //NM pc
    String HUB_PORT = "4444";
    String TEAMCITY_HUB_URL ="http://"+TEAMCITY_HUB_HOSTNAME+":"+   HUB_PORT +"/wd/hub";
    String DEV_HAB_URL      ="http://"+DEV_HUB_HOSTNAME+":"+        HUB_PORT +"/wd/hub";
    String NMPC_HAB_URL      ="http://"+NNPC_HUB_HOSTNAME+":"+        HUB_PORT +"/wd/hub"; //GBLCM-W0096
    String LOCAL_HUB_URL    ="http://"+GetLocalIpAddress.getLocalHostName()+":"+ HUB_PORT +"/wd/hub"; //LOCAL_GRID_HUB_HOSTNAME

    String MAC_ADDRESS ="10.24.208.249"; // "autotestmac" ;  //10.24.209.41 //"autotestmac"; //"10.24.208.176"; "AUTOTESTMAC"; //"10.24.208.226";
    String APPIUM_SERVER_PORT = "4723";  // androing tablet
    String APPIUM_SERVER_PORT_IPADMINI = "4726";

    boolean IS_JAVASCRIPT_ENABLED = true;
    int SCRIPT_TIME_OUT = 30;

    // SAUCE LAB
    public static final String USERNAME   = "efnikolmarku";
    public static final String ACCESS_KEY = "d4f02e16-dcd6-4d0a-a0ff-3ecfffc1ba17";
    public static final String SAUCE_HUB_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    //"http://efnikolmarku:d4f02e16-dcd6-4d0a-a0ff-3ecfffc1ba17@ondemand.saucelabs.com:80/wd/hub";

    //
    String GECKO_DRIVER_KEY       = "webdriver.gecko.driver";
    String GECKO_DRIVER_FILENAME  = "geckodriver.exe";
    String CHROME_DRIVER_KEY      = "webdriver.chrome.driver";
    String CHROME_DRIVER_FILENAME = "chromedriver.exe";


    String CHROME_EXE_FILE = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe");
    String IE_EXE_FILE = TestUtil.getAbsolutPathToDriverExe("IEDriverServer.exe") ;
    String EDGE_EXE_FILE = TestUtil.getAbsolutPathToDriverExe("MicrosoftWebDriver.exe") ;
   // String PHANTOMJS_EXE_FILE_EXE_FILE = "C:\\selenium\\grid\\phantomjs.exe" ; //TestUtil.getAbsolutPathToDriverExe("IEDriverServer.exe") ;

    // browser stack 2017 free trial
    public static final String BROWSERSTACK_USERNAME = "nikmak2";
    public static final String BROWSERSTACK_AUTOMATE_KEY = "U6sH3Ty4hKjdgHKUyscg";
    public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
}