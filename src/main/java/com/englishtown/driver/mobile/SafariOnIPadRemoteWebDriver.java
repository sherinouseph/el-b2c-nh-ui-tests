package com.englishtown.driver.mobile;
/**
 * Safari on MAC
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class SafariOnIPadRemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(SafariOnIPadRemoteWebDriver.class);

    private static URL url;

    static {
        logger.info("Static init for SafariOnIPadRemoteWebDriver");
        setSafariDriverOnIpadCapability();     //setIpadSimulatorDriverCapability();
        try {
            url = new URL("http://"+MAC_ADDRESS+":"+APPIUM_SERVER_PORT_IPADMINI+"/wd/hub");
            logger.info(" Appium url : "+url);
        }catch (MalformedURLException mfue){mfue.printStackTrace();}
    }

    public SafariOnIPadRemoteWebDriver() throws MalformedURLException, ConnectException, Exception {
        super(new URL(url.toString()), BaseRemoteWebDriver.capability);
    }

}
