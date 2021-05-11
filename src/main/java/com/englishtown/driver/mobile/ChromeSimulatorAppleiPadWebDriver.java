package com.englishtown.driver.mobile;
/**
 *   Create chrome browser with predefined config for few mobile types
 *   is is done by setting cap to mobile user agent
 *   : https://sites.google.com/a/chromium.org/chromedriver/mobile-emulation
 *
 *   Default set to iPhone
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class ChromeSimulatorAppleiPadWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        simulatorDeviceName= "Apple iPad";
        logger.info("Static init for Chrome for Mobiles :"+simulatorDeviceName);
        try{
            String chromeFile = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe") ;
            logger.info("chromeFile  : " + chromeFile);
            BaseRemoteWebDriver.isMobileTestOnly = true;
            currentDeviceName = simulatorDeviceName;
            isMobileDevice = true;
            System.setProperty("webdriver.chrome.driver", chromeFile);
            setCapability(DesiredCapabilities.chrome(), MyBrowserType.CHROME.getBrowser(), Platform.WINDOWS);
            setDeviceNameForMobileSimulator(simulatorDeviceName);// Apple iPad , Samsung Galaxy S4, Google Nexus 7

        }catch(Exception e){
            BasePage.failTest(e, "ChromeRemoteWebDriver setCapability static init Exception " );
        }
    }

    public ChromeSimulatorAppleiPadWebDriver() throws MalformedURLException , ConnectException, Exception {
            super(new URL(nodeURL), capability);
    }
    public ChromeSimulatorAppleiPadWebDriver(String deviceName) throws MalformedURLException , ConnectException, Exception {
        super(new URL(nodeURL), capability);
        setDeviceNameForMobileSimulator(deviceName);
    }




}