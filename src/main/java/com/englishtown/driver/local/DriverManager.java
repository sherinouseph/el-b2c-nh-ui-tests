package com.englishtown.driver.local;

import com.englishtown.driver.MyBrowserType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 11/05/2016.
 *
 *  Create ThreadLocal webdriver instance
 *
 * WebDriver driver = LocalDriverFactory.createInstance(browserName);
   LocalDriverManager.setWebDriver(driver);

   LocalDriverManager.getDriver().get(url);
   Thread.currentThread().getId()
   LocalDriverManager.getDriver().hashCode()

   http://tutorials.jenkov.com/java-concurrency/threadlocal.html
 */
public class DriverManager {
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    // NOT sure if should create this in createDriver method .. see WebDriver driver = ThreadGuard.protect(new FirefoxDriver());
    private static final ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<WebDriver>();


    private DriverManager() {
        //Do-nothing..Do not allow to initialize this class from outside
    }

    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }

    public static void setDriver(MyBrowserType browserType, int waitTimeSec) {
        createDriver(browserType, waitTimeSec);
    }

    public static void createDriver(MyBrowserType browserType, int waitTimeSec){
        logger.info("DriverManager createDriver() :"+browserType.getBrowser());
        WebDriver driver = WebDriverFactory.getBrowser(browserType, waitTimeSec);
        DriverManager.setWebDriver(driver);
        printThreadInfo();
    }

    public static void createDriver(String browserType, int waitTimeSec){
        logger.info("createDriver() :"+browserType);
        createDriver(MyBrowserType.getMyBrowserTypeFromString(browserType), waitTimeSec);
    }

    public static WebDriver getNewDriver(MyBrowserType browserType, int waitTimeSec){
        //browserType = MyBrowserType.EXPLORER11;
        logger.info("getNewDriver() :"+browserType.getBrowser());
        WebDriver driver = WebDriverFactory.getBrowser(browserType, waitTimeSec);
        DriverManager.setWebDriver(driver);
        printThreadInfo();
        return getDriver();
    }

    public static void setWebDriver(WebDriver driver) {
        threadLocalWebDriver.set(driver);
    }

    public static void unset() {
        printThreadInfo();
        threadLocalWebDriver.remove();
    }


    public static void destroyLocalDriver(){
        logger.info("call destroyLocalDriver ...!");
        try {
            printThreadInfo();
            if (getDriver() != null) {
                getDriver().quit();
                unset();
                logger.info("Driver Destroyed ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
        }catch (Exception e){
            logger.error("DestroyLocalDriver failed :"+e.getMessage());
        }
    }

    public static void printThreadInfo(){
        try {
            logger.info("Thread id = " + Thread.currentThread().getId());
            logger.info("Hashcode of webDriver instance = " + threadLocalWebDriver.get().hashCode());
        }catch (Exception e){
            logger.error("Could't print thread info ....! "+e.getMessage());
        }
    }


}

//
//    protected static WebDriver getNewLocalThreadDriver(MyBrowserType browserType, int waitTimeSec){
//        logger.info("createLocalThreadDriver() :"+browserType.getBrowser());
//        LocalDriverManager.createDriver(browserType, waitTimeSec);
//        return  LocalDriverManager.getDriver();
//    }
