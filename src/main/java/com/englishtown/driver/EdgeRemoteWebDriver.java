package com.englishtown.driver;
/**
 *http://www.automationtestinghub.com/selenium-3-launch-microsoft-edge-with-microsoftwebdriver/
 *https://developer.microsoft.com/en-us/microsoft-edge/platform/documentation/webdriver-commands/
 *
 * driver.Navigate().GoToUrl("about:InPrivate");
 */
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class EdgeRemoteWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        try{                                         //C:\\Program Files (x86)\\Microsoft Web Driver\    C:\selenium\grid\exe\MicrosoftWebDriver.exe
            //taskkill /F /IM MicrosoftWebDriver.exe /T
            System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
            logger.info("Static init for Windows 10 Edge browser ....!"+System.getProperty("webdriver.edge.driver") ) ;
            EdgeOptions edgeOptions = new EdgeOptions();                                                                //
            //edgeOptions.wait(5000); ->  Exception..! :'java.lang.IllegalMonitorStateException
            edgeOptions.setPageLoadStrategy("eager");
            DesiredCapabilities capabilities = DesiredCapabilities.edge();
            //capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
            capabilities.setCapability( "ensureCleanSession", true);                                                    //"ensureCleanSession ", true); //capability.setCapability("nativeEvents", false);      //ie11 fix click
            setCapability(capabilities, MyBrowserType.EDGE.getBrowser(), Platform.WINDOWS);
            setCurrentBrowserName("MicrosoftEdge");
        }catch(Exception e){
            BasePage.failTest(e, "setCapability static init Exception ");
        }
    }

    public EdgeRemoteWebDriver() throws MalformedURLException, ConnectException, Exception {
        super(new URL(nodeURL), BaseRemoteWebDriver.capability);
    }


}