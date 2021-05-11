package com.englishtown.driver;

/**
 *   Create chrome browser with predefined config
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class ChromeRemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(ChromeRemoteWebDriver.class);

    static {
        logger.info("Static init for Chrome");
        try{
            String chromeFile = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe") ;
            logger.info("chromeFile  : "+chromeFile);
            System.setProperty("webdriver.chrome.driver", chromeFile);
            setCapability( DesiredCapabilities.chrome(), MyBrowserType.CHROME.getBrowser(), Platform.WINDOWS );
        }catch(Exception e){
            BasePage.failTest(e, "ChromeRemoteWebDriver setCapability static init Exception " );
        }
    }

    public ChromeRemoteWebDriver() throws MalformedURLException , ConnectException, Exception {
            super(new URL(nodeURL), capability);

    }


}