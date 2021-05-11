package com.englishtown.driver.headles;
/**
 *   Create Jbrowser
 *   you can use driver.getStatusCode()
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.pages.core.BasePage;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import com.machinepublishers.jbrowserdriver.UserAgent;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class JBrowserWebDriver extends BaseRemoteWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(RemoteWebDriver.class);

    static {
        logger.info("Static init for JBROWSER .. chrome user agent");
        UserAgent userAgent = UserAgent.CHROME;
        try{
            capability = new DesiredCapabilities("jbrowserdriver", "1", Platform.ANY);
            // Optionally customize the settings   /*capability.merge(Settings.builder().timezone(Timezone.AMERICA_NEWYORK).buildCapabilities());*/
            //WebDriver driver = new JBrowserDriver(Settings.builder().userAgent(UserAgent.CHROME).build());
            capability.merge(Settings.builder().userAgent(userAgent).buildCapabilities());
            //???? setCapability(capability, MyBrowserType.JBROWSER.getBrowser(), Platform.ANY);
        }catch(Exception e){
            BasePage.failTest(e, "setCapability static init Exception ...!");
        }
    }

    public JBrowserWebDriver() throws MalformedURLException, ConnectException , Exception{
        super(new URL(nodeURL), capability);
    }


}

// note
// http://www.programcreek.com/java-api-examples/index.php?api=org.openqa.selenium.htmlunit.HtmlUnitDriver
// https://code.google.com/p/selenium/issues/detail?id=2462
// //http://blog.willmer.org/2011/07/selenium-webdriver-wont-let-you-addchange-request-headers/
//http://java.dzone.com/articles/htmlunit-%E2%80%93-quick-introduction
