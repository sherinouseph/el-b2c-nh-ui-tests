package com.englishtown.pages.checkout.newcheckout;
/**
 *  Date: 26/08/14
 * Nikol Revised 2018
 * URL:  https://www.englishtown.fr/buy/welcome-back/alumni/
 * same as https://qa-englishlive.ef.com/tr-tr/buy/welcome-back/member/
 * Normally 3 offers e.g FR
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class BaseAlumniOfferPage extends BaseOfferPage {
    public static final Logger logger = LoggerFactory.getLogger(BaseAlumniOfferPage.class);

    public BaseAlumniOfferPage(WebDriver webDriver){
        super(webDriver);
    }
    public BaseAlumniOfferPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BaseAlumniOfferPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        boolean isTestPassed = false;
        logger.info(" simpleTest()");
        if(weOfferButtons != null){
            try {
                isTestPassed = weOfferButtons.get(0).isDisplayed();
            }catch (WebDriverException e){
                BasePage.failTest(e, "FAIL simpleTest ...! nextStep element is not displayed", true);
            }
        } else {                                                                                                        //logger.error("FAIL simpleTest  ... nextStep element not found or is not displayed");
            BasePage.failTest("FAIL simpleTest ...! nextStep element not found or is not displayed", true);                   //fail("FAIL  nextStep element not found or is not displayed");
            return false;
        }
        return isTestPassed;
    }

    public void isNoOfOffersShownEqualOrMore(int numberOfOffers, int waitTimeSec) {
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), weOfferButtons, numberOfOffers);
    }


    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(weOfferButtons.get(0));
    }



}
