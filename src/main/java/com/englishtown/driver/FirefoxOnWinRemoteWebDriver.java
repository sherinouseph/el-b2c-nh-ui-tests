package com.englishtown.driver;
/**
 *   Create Firefox browser with predefined config
 *   *   Note: to use default ... new FirefoxDriver(new FirefoxProfileManager().GetProfile("default"));
 *    http://www.gerbenvanadrichem.com/quality-assurance/selenium-firefox-and-single-sign-on/
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class FirefoxOnWinRemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        logger.info("Static init for FirefoxOnWinRemoteWebDriver");
        try{
            setupSystemProperties(GECKO_DRIVER_KEY, GECKO_DRIVER_FILENAME );
            setCapability( DesiredCapabilities.firefox(), MyBrowserType.FIREFOX.getBrowser(), Platform.WINDOWS );
            FirefoxProfile ffProfile = new FirefoxProfile();
            JavaScriptError.addExtension(ffProfile);
            capability.setCapability(FirefoxDriver.PROFILE, ffProfile);
        }catch(Exception e){
            BasePage.failTest(e, "setCapability static init Exception " );
        }
    }

    public FirefoxOnWinRemoteWebDriver() throws MalformedURLException, ConnectException , Exception{
        super(new URL(nodeURL), capability);
    }


}

