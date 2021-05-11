package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class HomeSalesForcePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(HomeSalesForcePage.class);
    public static final String pageUrl = "/home/home.jsp";  //TODO this should be dynamic


    @FindBy(id = "home_Tab")
    public WebElement homeTabWe;

    @FindBy(id = "Lead_Tab")
    public WebElement leadTabWe;


    @FindBy(css = "#tabBar>li")
    public List<WebElement> headerMenuListWe;

    // top right corner
    @FindBy(id = "tsid")
    public WebElement appMenuBtWe;

    @FindBy(css = "#tsid-menuItems")
    public WebElement appMenuItemsWe;

    @FindBy(css = "#tsid-menuItems a")
    public List<WebElement> appMenuItemsListWe;


    public HomeSalesForcePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomeSalesForcePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest Assert  anotherReasonCss element displayed ...!");
        AssertHelper.assertWebElementDisplayed(leadTabWe);
        return true;
    }

//    public ExpectedCondition getPageLoadedCondition() {
//        return ExpectedConditions.visibilityOf(LeadTabWe);
//    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void clickAppMenu(){
        click(appMenuBtWe);
        sleep(500);
    }


    public void checkNumberOfTabsMainNavigator(int noOfTabs){
        logger.info("checkNumberOfMenuItemsToNavigation  is ["+noOfTabs+"]");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), headerMenuListWe, noOfTabs);
    }


    public void checkAppMenuItemsWeDisplayed(){
        AssertHelper.assertWebElementDisplayed(appMenuItemsWe);
    }

    public void checkNumberOfAppMenuItems(int numberOfAppItems){
        logger.info("checkNumberOfAppMenuItemsListWe  is ["+numberOfAppItems+"]");
        clickAppMenu();
        checkAppMenuItemsWeDisplayed();
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), appMenuItemsListWe, numberOfAppItems);
    }

}