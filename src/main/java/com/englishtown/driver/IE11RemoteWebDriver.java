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


public class IE11RemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        try{
            logger.info("Static init for ExplorerRemoteWebDriver");
            String ieFile = TestUtil.getAbsolutPathToDriverExe("IEDriverServer.exe") ;
            logger.info("ExplorerRemoteWebDriver ieFile " + ieFile);
            System.setProperty("webdriver.ie.driver", ieFile);
            setCapability(DesiredCapabilities.internetExplorer(), MyBrowserType.EXPLORER11.getBrowser(), Platform.WINDOWS);
            // selenium 3 does not like this browserVersion = "11";     capability.setVersion(browserVersion);
            logger.info("Browser Version is    : " + capability.getVersion());
            capability.setCapability("nativeEvents", false);       //ie11 fix click
        }catch(Exception e){
            BasePage.failTest(e, "setCapability static init Exception ");
        }
    }

    public IE11RemoteWebDriver() throws MalformedURLException, ConnectException, Exception {
        super(new URL(nodeURL), BaseRemoteWebDriver.capability);
    }


}




