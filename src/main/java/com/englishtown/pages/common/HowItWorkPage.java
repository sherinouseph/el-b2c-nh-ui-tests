package com.englishtown.pages.common;
/**
 * how it works page
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.common.core.BaseHeaderAndFooterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.is;


public class HowItWorkPage extends BaseHeaderAndFooterPage {

    public static final Logger logger = LoggerFactory.getLogger(HowItWorkPage.class);
    public static final String pageUrl = "not int";

    @FindBy(css = "nav.secondary")
    public WebElement navSecondary;  //sub nav

    @FindBy(css = "nav.secondary .active")
    public WebElement activeNav;  // the selected sub nav


    @FindBy(css = "nav.secondary li")
    public List<WebElement> navSecondaryLiList;  //sub nav list   .active for active element; only one

    public HowItWorkPage(WebDriver webDriver){
        super(webDriver);
    }

    public HowItWorkPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public HowItWorkPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        super.simpleTest();
        logger.info(" simpleTest() check subnav has active element and displayed ...!");
        //TODO add assert
        AssertHelper.assertThat("Sub nav should have an active link dislplayed ...!", activeNav.isDisplayed(), is(true));
        return true;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(navSecondary);
    }
    public String getPageUrl() {
        return pageUrl;
    }




}
