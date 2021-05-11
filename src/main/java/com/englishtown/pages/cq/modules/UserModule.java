package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.CqCorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;

/**
 * Top Right .. shows name of user ... if user click on it submenu shown .. signout
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *
 *
 */
public class UserModule extends CqCoreModule {
    protected static final Logger logger = LoggerFactory.getLogger(UserModule.class);

    /**
     * Main components
     *
     */
    @FindBy(id = "cq-gen167")
    public WebElement userMenu;

    @FindBy(id = "cq-gen662")
    public WebElement signOutMenuItem;  // visible after clicking userMenu

    public UserModule(WebDriver webDriver){
        super(webDriver);
    }
    public UserModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public UserModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(userMenu);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(userMenu);
    }


}