package com.englishtown.driver;
/**
 * Safari on MAC
 */
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


public class SafariRemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        logger.info("Static init for SafariRemoteWebDriver");
        try{
            setCapability(DesiredCapabilities.safari(), MyBrowserType.SAFARI.getBrowser(),  Platform.MAC);
        }catch(Exception e){
            BasePage.failTest(e,"setCapability static init Exception ...!"  );
        }
    }

    public SafariRemoteWebDriver() throws MalformedURLException, ConnectException, Exception {
        super(new URL(nodeURL), BaseRemoteWebDriver.capability);
    }


}

