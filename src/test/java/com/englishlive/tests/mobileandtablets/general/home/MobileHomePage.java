package com.englishlive.tests.mobileandtablets.general.home;
/**
 * Run existing home page test on mobiles
 * setup mobile browser
 *
 * Note: redundant ... use BaseMobileHomePage
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.HomePage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.HomePageTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 12/02/2016.
 */
public abstract class MobileHomePage extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(MobileHomePage.class);
    protected String mobileTestUrl="TestShouldInitThis";


    @Override
    protected HomePage createPage() {
        return new HomePage(getWebDriver(), mobileTestUrl);
    }

}
