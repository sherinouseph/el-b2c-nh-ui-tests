package com.englishtown.tests.core.login;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
import com.englishtown.driver.mobile.ChromeSimulatoriPhone6WebDriver;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 24/03/2016.
 *
 */
public class BaseMobileHelper extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public void setDriverMobileSimulatorGalaxyS4(){
        //if(BaseRemoteWebDriver.isBrowser("chrome")){
            try {
                WebDriver simulatorDriver = new ChromeSimulatorSamsungGalaxyS4WebDriver();
                setWebDriver(simulatorDriver);
            } catch (Exception e) {
                logger.error(" Mobile driver not created : " + TestUtil.getException(e));
            }
        //} else {
        //    BasePage.failTest("This test should run only on chrome Mobile simulator [iphone, galaxy, etc ...!] ");
        //}
    }

    public void setDriverMobileSimulatoriPhone6(){
        BaseRemoteWebDriver.setDeviceNameForMobileSimulator("Apple iPhone 6");
        //if(BaseRemoteWebDriver.isBrowser("chrome")){
            try {
                WebDriver simulatorDriver = new ChromeSimulatoriPhone6WebDriver();
                setWebDriver(simulatorDriver);
            } catch (Exception e) {
                logger.error(" Mobile driver not created : " + TestUtil.getException(e));
            }
       // } else {
       //     BasePage.failTest("This test should run only on chrome Mobile simulator [iphone, galaxy, etc ...!] ");
       // }
    }
}
