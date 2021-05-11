package com.englishtown.driver;
/**
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public abstract class MyRemoteWebDriver extends RemoteWebDriver implements IWebDriverSetting {

    protected static URL url;
    public static String browserVersion = "";
    public static String currentBrowserName;
    public static DesiredCapabilities capability;
    public static String nodeURL = "node not init";
    public static final int TIME_OUT = WaitTool.DEFAULT_IMPLICIT_WAIT;
    //---------------------------------
    public static String currCapabilityPlatformName ;
    public static String currentDeviceName;
    public static boolean isMobileDevice      = false;
    public static boolean isMobileTestOnly    = false;
    public static boolean is_IOS_MobileDevise = false;
    public static boolean is_MacSafari        = false;


    public MyRemoteWebDriver(URL url, DesiredCapabilities capability) throws Exception {
        super(url, capability);
    }

    /**
     * Set system properties
     * @param key          e.g ="webdriver.gecko.driver"
     * @param exeFileName  e.g = "geckodriver.exe"
     */
    public static final void setupSystemProperties (String key, String exeFileName){
        String driverPath = TestUtil.getAbsolutPathToDriverExe(exeFileName) ;
        System.setProperty(key, driverPath);
    }

}
