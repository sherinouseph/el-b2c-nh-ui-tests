package com.englishtown.driver;

import com.englishtown.driver.local.DriverManager;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *  Protect driver
 *
 */
public class ThreadGuardedWebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(ThreadGuardedWebDriverFactory.class);
      /* System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());*/
    private static InheritableThreadLocal<WebDriver> threadLocalWebDriver = new InheritableThreadLocal<WebDriver>();

    private ThreadGuardedWebDriverFactory() {
        //Do-nothing..Do not allow to initialize this class from outside
    }

    public static WebDriver getDriver() throws NullPointerException {
        logger.info("getDriver() ...!");
        if(threadLocalWebDriver != null && threadLocalWebDriver.get() != null) {
            logger.info("Thread id = " + Thread.currentThread().getId());
            logger.info("Hashcode of webDriver instance = " + threadLocalWebDriver.get().hashCode());
            return threadLocalWebDriver.get();
        }else {
            //BaseTest.failTest("Can't get guarded driver ...!");
        }
        return null;
    }

    private static void setWebDriver(WebDriver driver) {
        threadLocalWebDriver.set(driver);
    }

    public static void unset() {
        threadLocalWebDriver.remove();
    }

    public static WebDriver getThreadGuardedWebDriver(WebDriver driver){
        logger.info("getThreadGuardedWebDriver [...!]");
        try {
            setWebDriver(driver);

            return ThreadGuard.protect(driver);
        }catch (Exception e) {
            BaseTest.failTest("Can't create browser ...! " + " \n"+e.getMessage());
        }
        return null;
    }


    public static void destroyThreadGuardedWebDriver(){
        logger.info("destroyThreadGuardedWebDriver ...!");
        try {
            if (getDriver() != null) {
                getDriver().quit();
                unset();
                logger.info("Destroyed ...!");
            } else {
                logger.info("Not Destroyed ...is NULL ...!");
            }
        }catch (Exception e){
            logger.error("destroyThreadGuardedWebDriver error : "+e.getMessage());
        }
    }
   //same as above
    public static void quit(){
        logger.info("destroyThreadGuardedWebDriver ...!");
        if (getDriver() != null) {
            getDriver().quit();
            unset();
            logger.info("Destroyed ...!");
        }else {
            logger.info("Not Destroyed ...is NULL ...!");
        }
    }

}


//*****************************************************************************
// this was the only method
    /*public static WebDriver getThreadGuardedWebDriver(WebDriver driver) {
        return ThreadGuard.protect(driver);
    }*/
