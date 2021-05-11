package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.cq.CqCorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Top Right .. 2 tabs shown website and Search...
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *
 *
 */
public class SearchTabModule extends CqCoreModule {
    protected static final Logger logger = LoggerFactory.getLogger(SearchTabModule.class);

    /**
     * Main components
     *
     */
    @FindBy(id = "cq-siteadmin-tabpanel__cq-siteadminsearchpanel")
    public WebElement searchTabWe;

    @FindBy(id = "ext-comp-1125")
    public WebElement fullTextTxtSearchWe;  // visible after clicking searchTab

    public SearchTabModule(WebDriver webDriver){
        super(webDriver);
    }
    public SearchTabModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SearchTabModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(fullTextTxtSearchWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(fullTextTxtSearchWe);
    }


}