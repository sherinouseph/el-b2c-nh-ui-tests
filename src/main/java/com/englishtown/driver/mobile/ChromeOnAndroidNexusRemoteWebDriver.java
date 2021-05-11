package com.englishtown.driver.mobile;
/**
 * chrome on Nexus PAD
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.utils.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class ChromeOnAndroidNexusRemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(ChromeOnAndroidNexusRemoteWebDriver.class);

    private static URL url;

    static {
        logger.info("Static init for ChromeOnAndroidNexusRemoteWebDriver");
        String chromeFile = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe") ;
        logger.info("chromeFile  : "+chromeFile);
        System.setProperty("webdriver.chrome.driver", chromeFile);
        setChromeOnNexusTabletDriverCapability();
        try {
            url = new URL("http://" + MAC_ADDRESS + ":" + APPIUM_SERVER_PORT + "/wd/hub");
            logger.info(" GRID url : "+url);
        } catch (MalformedURLException mfue) {
            logger.error(""+mfue.getStackTrace());
        }
    }

    public ChromeOnAndroidNexusRemoteWebDriver() throws MalformedURLException, ConnectException, Exception {
        super(new URL(url.toString()), BaseRemoteWebDriver.capability);
    }

}