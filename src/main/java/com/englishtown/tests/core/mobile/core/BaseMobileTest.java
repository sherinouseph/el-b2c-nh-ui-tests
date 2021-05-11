package com.englishtown.tests.core.mobile.core;
/**
 * Created by nikol.marku on 12/02/2016.
 *
 * Mobile pages that use mobile designs
 *
 * All Mobile test extends this
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.mobile.ChromeSimulatorSamsungGalaxyS4WebDriver;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.HowItWorkPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import com.englishtown.pages.common.mobiletablet.MobileTableMenuPage;
import com.englishtown.pages.common.mobiletablet.MobileTabletHomePage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.transform.trait.Traits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.security.PublicKey;


public abstract class BaseMobileTest extends BaseTestHelper implements IBaseMobile{
    private static final Logger logger = LoggerFactory.getLogger(BaseMobileTest.class);

    public String offersOndPricePageUrl;
    public String howItWorksPageUrl;
    public String loginPageUrl;

    public MobileTabletHomePage mobileTabletHomePage;
    public MobileTableMenuPage mobileTableMenuPage;
    public HowItWorkPage howItWorkPage;
    public PriceAndPackagekPage priceAndPackagekPage;
    public LoginPage loginPage;



    @Override
    public void setNavigationPagesUrls(String offersOndPricePageUrl, String howItWorksPageUrl, String loginPageUrl) {
        this.offersOndPricePageUrl = offersOndPricePageUrl;
        this.howItWorksPageUrl = howItWorksPageUrl;
        this.loginPageUrl = loginPageUrl;
    }


    /**
     * Helpers
     */
    public void checkMobileHomePage(){
        mobileTabletHomePage = new MobileTabletHomePage(getWebDriver());
        mobileTabletHomePage.simpleTest();
    }


    public void goToHowItWorksAndCheckPage(){
        mobileTabletHomePage.clickMobileMenuIcon();
        sleep(1000);
        waitForElementCondition(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".menu a")), getWebDriver(), 30);
        sleep(1000);
        mobileTableMenuPage = new MobileTableMenuPage(getWebDriver());
        mobileTableMenuPage.getPageLoadedCondition();
        mobileTableMenuPage.simpleTest();
        mobileTableMenuPage.goToHowItWorks();
        sleep(1000);
        howItWorkPage = new HowItWorkPage(getWebDriver());
        howItWorkPage.simpleMobileTest();
        assertIsUrlContaining(howItWorksPageUrl);
    }


    public void goToOfferPriceAndCheckPage(){
        howItWorkPage.clickMobileMenuIcon();
        sleep(1000);
        mobileTableMenuPage = new MobileTableMenuPage(getWebDriver());
        mobileTableMenuPage.goToOffersPrice();

        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
        priceAndPackagekPage.simpleMobileTest();
        assertIsUrlContaining(offersOndPricePageUrl);
    }


    public void goToHomePage(){
        priceAndPackagekPage.clickMobileMenuIcon();
        sleep(1000);
        mobileTableMenuPage = new MobileTableMenuPage(getWebDriver());
        mobileTableMenuPage.getPageLoadedCondition();
        mobileTableMenuPage.goToHomepage();

        mobileTabletHomePage = new MobileTabletHomePage(getWebDriver());
        mobileTabletHomePage.simpleTest();
        assertIsUrlContaining(homePageUrl);
    }


    public void goToLoginPage(){
        mobileTabletHomePage.clickMobileMenuIcon();
        sleep(1000);
        mobileTableMenuPage = new MobileTableMenuPage(getWebDriver());
        mobileTableMenuPage.goToLoginPage();
        sleep(3000);
        loginPage = new LoginPage(getWebDriver());
        loginPage.isUsernameDisplayed();
        assertIsUrlContaining(loginPageUrl);
    }

    /**
     * remove ctr from url as it is not visible once page is open e.g *ef-ef/?ctr=ef => *ef-ef/
     * all teh part after ctr= will be removed and the '?'
     * @param testHomePageUrl
     * @return
     */
    public String removeCtrParamFromHomePageUrl(String testHomePageUrl){
        String homePageUrl =  testHomePageUrl;
        if(StringUtils.contains(testHomePageUrl, "ctr=") ) {
            homePageUrl = testHomePageUrl.split("ctr=")[0];
            homePageUrl = homePageUrl.replace("?", "");
        }else
            homePageUrl = testHomePageUrl;

        logger.info("URL without ctr now is ["+homePageUrl+"]");
        return homePageUrl;
    }


}








//    /**
//     *
//     * @param browserNameToRunSimulator  e.g = "chrome"
//     */
//    public void setupMobileSimulator(String browserNameToRunSimulator, BaseRemoteWebDriver simulatorDriver){
//        setScreenShotOnFailure(false);
//        if(BaseRemoteWebDriver.isBrowser(browserNameToRunSimulator)){
//            try {
//                WebDriver mydriver = simulatorDriver; //ChromeSimulatorSamsungGalaxyS4WebDriver();
//                setWebDriver(mydriver);
//            } catch (Exception e) {
//                logger.error(" Mobile Simulator driver not created : " + TestUtil.getException(e));
//            }
//        } else {
//            BasePage.failTest("This test should run only on chrome Mobile simulator [iphone, galaxy, etc ...!]");
//        }
//    }
