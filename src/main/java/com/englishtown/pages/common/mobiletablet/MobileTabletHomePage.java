package com.englishtown.pages.common.mobiletablet;
/**
 * New website Mobile and Tablet experience
 * Logo and menu shown ... user click on menu to naviagate to other section
 *
 * User: nikol.marku
 *  *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.common.CookiePage;
import com.englishtown.pages.common.core.BaseHeaderAndFooterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;


public class MobileTabletHomePage extends BaseHeaderAndFooterPage {
    public static final Logger logger = LoggerFactory.getLogger(MobileTabletHomePage.class);

    CookiePage cookiePage; // shown on first visit


    /**
     * Main components
     */
    @FindBy(className = "primary")
    public WebElement headerWe;

    @FindBy( className = "menu-mobile")
    public WebElement mobileMenuWe;


    @FindBy( className = "phone-icon-and-number")
    public WebElement phoneIconWe;



    public MobileTabletHomePage(WebDriver webDriver){
        super(webDriver);
    }
    public MobileTabletHomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MobileTabletHomePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        //super.simpleTest();
        logger.info(" simpleTest() check header menu and phone icon");
        AssertHelper.assertWebElementDisplayed(headerWe);
        AssertHelper.assertWebElementDisplayed(mobileMenuWe);
        //AssertHelper.assertWebElementDisplayed(phoneIconWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(headerWe);
    }


   /* public void clickMobileMenu(){
        logger.info("clickMobileMenu ...!");
        click(mobileMenuWe);
    }*/
}