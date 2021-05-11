package com.englishtown.driver;
/**
 *
 */

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

import static org.testng.Assert.fail;


public class IE10RemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        try{
            logger.info("Static init for ExplorerRemoteWebDriver");
            String ieFile = TestUtil.getAbsolutPathToDriverExe("IEDriverServer.exe") ;
            logger.info("ExplorerRemoteWebDriver ieFile " + ieFile);
            System.setProperty("webdriver.ie.driver", ieFile);
            setCapability(DesiredCapabilities.internetExplorer(), MyBrowserType.EXPLORER10.getBrowser(), Platform.WINDOWS);
            browserVersion = "10";
            capability.setVersion(browserVersion);
            logger.info("Browser Version is    : " + capability.getVersion());
            //capability.setCapability("nativeEvents", true); //ie10 fix click
        }catch(Exception e){
            BasePage.failTest(e, "setCapability static init Exception ");
        }
    }

    public IE10RemoteWebDriver() throws MalformedURLException, ConnectException, Exception {
        super(new URL(nodeURL), BaseRemoteWebDriver.capability);
    }


}


/**
 * // Setting attribute nativeEvents to false enable click button in IE11
 capability.setCapability("unexpectedAlertBehaviour", "accept");
 capability.setCapability("ignoreProtectedModeSettings", true);
 capability.setCapability("disable-popup-blocking", true);
 capability.setCapability("ignoreZoomSetting", true);
 capability.setCapability("enablePersistentHover", true);
 capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
 */