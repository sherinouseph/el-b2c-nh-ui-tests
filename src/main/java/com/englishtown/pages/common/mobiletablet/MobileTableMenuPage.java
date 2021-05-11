package com.englishtown.pages.common.mobiletablet;
/**
 * On mobile expererience click on menu should show menu items
 *
 * User: nikol.marku  2017
 *  *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.pages.common.core.BaseHeaderAndFooterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MobileTableMenuPage extends BaseHeaderAndFooterPage {
    public static final Logger logger = LoggerFactory.getLogger(MobileTableMenuPage.class);


    /**
     * Main components
     */
    @FindBy(css = ".menu a")
    public List<WebElement> menuTopListWe; // home, how it works, offers/pricing

    @FindBy( css = ".icon-profile") //"a[href*='login'] span")
    public WebElement loginWe;


    @FindBy( className = "phone-icon-and-number")
    public WebElement phoneIconAndNumberWe;


    public MobileTableMenuPage(WebDriver webDriver){
        super(webDriver);
    }
    public MobileTableMenuPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MobileTableMenuPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() check how it works link and login ....!");
        AssertHelper.assertWebElementDisplayed(menuTopListWe.get(1));
        AssertHelper.assertWebElementDisplayed(loginWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(loginWe);
    }

    public void goToHomepage(){
        logger.info("click on Homepage link ....!");
        JavaScriptHelper.highlightElement(menuTopListWe.get(0), getWebDriver());
        click(menuTopListWe.get(0));
    }

    public void goToHowItWorks(){
        logger.info("click on HowItWorks link ....!");
        JavaScriptHelper.highlightElement(menuTopListWe.get(1), getWebDriver());
        click(menuTopListWe.get(1));
    }

    public void goToOffersPrice(){
        logger.info("click on OffersPrice link ....!");
        JavaScriptHelper.highlightElement(menuTopListWe.get(2), getWebDriver());
        click(menuTopListWe.get(2));
    }

    public void goToLoginPage(){
        logger.info("click on Login link ....!");
        JavaScriptHelper.highlightElement(loginWe, getWebDriver());
        click(loginWe);
    }

}