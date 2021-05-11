package com.englishtown.driver.headles;

/**
 *   Create browser with predefined config
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class PhantomJSWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(PhantomJSWebDriver.class);

    private static String PHANTOMJS_LOCATION = "C:\\selenium\\grid\\exe\\phantomjs.exe";
    static {
        logger.info("PhantomJS driver init ...!");
        try{
            capability = DesiredCapabilities.phantomjs();
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PHANTOMJS_LOCATION);
            /* Command line args to pass to ghostdriver, phantomjs's browser driver. See https://github.com/detro/ghostdriver#faq          */
            ArrayList<String> cliArgsCap = new ArrayList<String>();
            cliArgsCap.add("--web-security=false");//false
            cliArgsCap.add("--ssl-protocol=any");
            cliArgsCap.add("--ignore-ssl-errors=true");//true
            cliArgsCap.add("--loglevel=DEBUG");
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
            //this breaks it capability.setVersion("2.0.0");
            capability.setCapability("takesScreenshot", true);            //capability.setCapability( PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, new String[] { "--logLevel=debug" });
            setCapability(capability, MyBrowserType.PHANTOMJS.getBrowser(), Platform.ANY);
        }catch(Exception e){
            BasePage.failTest(e, "PhantomJSWebDriver setCapability static init Exception " );
        }
    }

    public PhantomJSWebDriver() throws MalformedURLException , ConnectException, Exception {
         super(new URL(nodeURL), capability);
    }

    public static String getPhantomJsLocation(){
        return PHANTOMJS_LOCATION;
    }


}


/**
 * https://github.com/detro/ghostdriver
 Register GhostDriver with a Selenium Grid hub

 Launch the grid server, which listens on 4444 by default: java -jar /path/to/selenium-server-standalone-<SELENIUM VERSION>.jar -role hub
 Register with the hub: phantomjs --webdriver=8080 --webdriver-selenium-grid-hub=http://127.0.0.1:4444
 Now you can use your normal webdriver client with http://127.0.0.1:4444 and just request browserName: phantomjs
 **/