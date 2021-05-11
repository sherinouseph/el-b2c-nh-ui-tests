package com.englishlive.tests.newsite.core;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website base test
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.common.HowItWorkPage;
import com.englishtown.pages.common.NewHomePage;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public abstract class BaseNewSiteDesktopNavigation extends BaseNewSiteNavigationTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseNewSiteDesktopNavigation.class);


    @Test
    void simpleTest(){
        sleep(3000);
        newHomePage = new NewHomePage(getWebDriver());
        newHomePage.simpleTest();
    }

    @Test (priority = 1)
    void checkHeaderIsVisible(){
        AssertHelper.assertWebElementDisplayed(newHomePage.header);
    }

    @Test(priority = 2)
    void checkAllLogos(){
        logger.info("Check all logos are visible....!");
        if(newHomePage.logoList.isEmpty()) {
            failTest("Can't get web element; is empty ...! ");
        }
        for(int i=0; i < newHomePage.logoList.size(); i++) {
            logger.info("isElementVisible ["+i+"]");
            AssertHelper.assertThat("Footer link should be Visible [ contact us etc ...]", WaitTool.isElementVisible(newHomePage.logoList.get(i)), is(true) );
        }
    }

    @Test(priority = 2)
    void checkHowItWorkIsVisible(){
        AssertHelper.assertWebElementDisplayed(newHomePage.topMenuList.get(1));
    }
    @Test(priority = 3)
    void checkPriceLinkIsVisible(){
        AssertHelper.assertWebElementDisplayed(newHomePage.topMenuList.get(2));
    }

    @Test(priority = 4)
    void checkLoginIsVisible(){
        AssertHelper.assertWebElementDisplayed(newHomePage.topRightMenuList.get(0));
    }

    @Test(priority = 5)
    void checkPhoneNoIsVisible(){
        logger.info("checkPhoneNoIsVisible");
        if(isHomePagePhoneNumberPresent)
            AssertHelper.assertWebElementDisplayed(newHomePage.topRightMenuList.get(1));
        else
            logger.info("Phone number is not expected to be present in the Home Page");
    }

    @Test(priority = 6)
    void checkAllTryUsAreVisible(){
        // 3 for desktop and 2 for mob
        if(runTestCheckTryUs){
            if(newHomePage.tryUsList.isEmpty()) {
                failTest("Can't get web element; is empty ...! ");
            }
            List<WebElement> tryUsWebElements = WaitTool.getVisibleElements(getWebDriver(), WaitTool.findElements(
                    getWebDriver(), By.cssSelector(WebElementHelper.getElementLocator(newHomePage.tryUsList.get(0)))));   // edge issue ... JavaScriptHelper.jQuery_getVisibleElements(  WebElementHelper.getElementLocator(newHomePage.tryUsList.get(0)), getWebDriver(), 3, true);
            if (BaseRemoteWebDriver.getCurrentDeviceName() != null) {
                AssertHelper.assertThat("Mobile page should show 2 visible try us buttons", tryUsWebElements.size() > 0);
            } else {
                AssertHelper.assertThat("Desktop page should show 3 visible try us buttons, OR No elements found," +
                        " tryUs size :"+tryUsWebElements.size(), tryUsWebElements.size() > 0);
            }
        }  else {
            logger.warn("<<<<<<<<<<     This test is set Not to Run    >>>>>>>> - runTestCheckTryUs :"+runTestCheckTryUs);
        }

    }

    @Test(priority = 7)
    void checkAllFooterLinksAreVisible(){
        if(newHomePage.footerLinks.isEmpty()) {
            failTest("Can't get web element; is empty ...! ");
        }
        for(int i=0; i < newHomePage.footerLinks.size(); i++) {
            logger.info("isElementVisible ["+i+"]");
            AssertHelper.assertWebElementDisplayed(newHomePage.footerLinks.get(i));
        }
    }

    @Test(priority = 20)
    void navigateToPriceAndHowItWorksPage(){
        logger.info("go to how it work and price page and run simpleTest() ...!");
        if(runTestGotoPPpage){
            for (int i = 1; i < newHomePage.topMenuList.size(); i++) { // first element HOME is not visible
                navigateTopMenu(newHomePage, i);
                sleep(500);
                if (i == 1) {
                    howItWorkPage = new HowItWorkPage(getWebDriver());
                    howItWorkPage.simpleTest();
                } else if (i == 2) {
                    priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
                    priceAndPackagekPage.simpleTest();
                }
                logger.info("Clicked on index : " + i);

            }
        }  else {
            logger.warn("<<<<<<<<<<     This test is set Not to Run    >>>>>>>> - runTestGotoPPpage :"+runTestGotoPPpage);
        }
    }



}
