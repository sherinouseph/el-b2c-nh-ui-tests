package com.englishtown.driver.local;
/**
 * Nikol 2019
 *
 * Create driver on Demand not using thread local
 *
 * Note : <Make sure you destroy when not needed>
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.IWebDriverSetting;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestConfig;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;


public class EfDriver implements IWebDriverSetting {

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    protected WebDriver driver;


    public EfDriver(MyBrowserType myBrowserType) {
        BaseTestConfig.setGridEnvironmentFromDargs();
        BaseRemoteWebDriver.setHubUrl(BaseTest.getGridEnvironment());
        driver = getBrowser(myBrowserType);
    }

    /**
     *
     * @param myBrowserType
     * @return
     */
    public WebDriver getBrowser(MyBrowserType myBrowserType){
        logger.info("getBrowser() SetupBrowser for :"+ myBrowserType.getBrowser());

        DesiredCapabilities capa = null;
        String nodURL =  BaseRemoteWebDriver.nodeURL;

        try {

            setWebdriverProperties();

            switch (myBrowserType) {

                case FIREFOX:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = getCapability(DesiredCapabilities.firefox(),MyBrowserType.FIREFOX.getBrowser() , Platform.ANY );
                    FirefoxProfile ffProfile = new FirefoxProfile();
                    capa.setCapability(FirefoxDriver.PROFILE, ffProfile);

                    driver = new RemoteWebDriver(new URL(nodURL), capa);
                    maximiseDriver(driver);
                    BaseRemoteWebDriver.setCurrentBrowserName("firefox"); //todo refactor this use basetest
                    break;

                case CHROME:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    capa = getCapability(DesiredCapabilities.chrome(),MyBrowserType.CHROME.getBrowser() ,Platform.ANY );
                    capa.setCapability("browserstack.debug", "true");
                    capa.setCapability("browserstack.networkLogs", "true");

                    driver = new RemoteWebDriver(new URL(nodURL), capa);
                    maximiseDriver(driver);
                    break;

                case CHROME_HEADLESS:
                    logger.info("Getting Browser for [{}]",myBrowserType.getBrowser() );
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("window-size=1600x1200");
                    chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                    capa = DesiredCapabilities.chrome();
                    capa.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    driver = new RemoteWebDriver(new URL(nodURL), capa);

                    break;

                default:
                    logger.error("Cant find setup for browser : " + myBrowserType.getBrowser());
                    BaseTest.failTest("Cant find setup for browser ["+myBrowserType.getBrowser()+"]");
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't create browser ....! "+e.getMessage());
            BasePage.failTest(e, "Can not create browser :"+ myBrowserType.getBrowser());
        }
        if(capa != null)
            logger.info("Cappabilties set to : "+capa.toString());

        return driver;
    }


    public DesiredCapabilities getCapability(DesiredCapabilities capabilities, String browserTypeName, Platform platform ){
        DesiredCapabilities desiredCapabilities = capabilities;
        desiredCapabilities.setBrowserName(browserTypeName);
        desiredCapabilities.setPlatform(platform);
        return desiredCapabilities;
    }

    public static void maximiseDriver(WebDriver driver){
        try {
            driver.manage().window().maximize();
        }catch (WebDriverException e){
            logger.warn("Can't maximise driver ...!  ", e.getMessage());
        }
    }

    public void setWebdriverProperties(){
        System.setProperty("webdriver.ie.driver", IE_EXE_FILE);
        System.setProperty("webdriver.chrome.driver", CHROME_EXE_FILE);
        System.setProperty("webdriver.edge.driver", EDGE_EXE_FILE);
        String driverPath = TestUtil.getAbsolutPathToDriverExe(GECKO_DRIVER_FILENAME) ;
        System.setProperty(GECKO_DRIVER_KEY, driverPath);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver(){
        logger.info("call destroyDriver ...!");
        try {
            if (getDriver() != null) {
                getDriver().quit();
                logger.info("Driver Destroyed .. called quit ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
        }catch (Exception e){
            logger.error("DestroyLocalDriver failed ....! "+e.getMessage());
        }
    }



}
