package com.englishtown.driver.mobile;
/**
 *
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


public class ChromeSimulatorGoogleNexus10WebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        simulatorDeviceName= "Google Nexus 10";
        logger.info("Static init for Chrome for Mobile:"+simulatorDeviceName);

        try{
            String chromeFile = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe") ;
            BaseRemoteWebDriver.isMobileTestOnly = true;
            logger.info("chromeFile  : " + chromeFile);
            System.setProperty("webdriver.chrome.driver", chromeFile);
            setCapability(DesiredCapabilities.chrome(), MyBrowserType.CHROME.getBrowser(), Platform.WINDOWS);
            setDeviceNameForMobileSimulator(simulatorDeviceName);
        }catch(Exception e){
            BasePage.failTest(e, "ChromeRemoteWebDriver setCapability static init Exception " );
        }
    }

    public ChromeSimulatorGoogleNexus10WebDriver() throws MalformedURLException , ConnectException, Exception {
            super(new URL(nodeURL), capability);
    }
    public ChromeSimulatorGoogleNexus10WebDriver(String deviceName) throws MalformedURLException , ConnectException, Exception {
        super(new URL(nodeURL), capability);
        setDeviceNameForMobileSimulator(deviceName);
    }




}