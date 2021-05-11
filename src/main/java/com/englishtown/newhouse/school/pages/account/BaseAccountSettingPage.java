package com.englishtown.newhouse.school.pages.account;
/**
 * Nikol Jan 2018
 * base page for navigating to your account, personal details, bill, email and privacy
 *
 *
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public abstract class BaseAccountSettingPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(BaseAccountSettingPage.class);
    public static final String pageUrl = "account/dashboard";
    public static final String IsShowAsOnlineByDefault       = "IsShowAsOnlineByDefault";      // class contains
    public static final String CanProfileViewableByEveryone  = "CanProfileViewableByEveryone";
    public static final String CanReceiveMessageFromEveryone = "CanReceiveMessageFromEveryone";

    public static final String CANCEL_SUBSCRIPTION_CSS = ".glyphicon.glyphicon-remove-sign";
    public static final String UNDO_CANCEL_SUBSCRIPTION_CSS = ".glyphicon glyphicon-repeat";

    public static final String [] PRIVACY_SETTING_ITEMS = {"Promote my profile", "List my profile",
            "Display profile status online", "My profile viewable by everyone", "My updates viewable by everyone",
            "My photo viewable by everyone", "My live chat accessibility by everyone"};

    /**
     * page title Account settings
     */
    @FindBy(css = "header h1")
    public WebElement pageTitleWe;                // Account setting
    /**
     * Your account     Personal details     Billing & features     Email & notifications
     */
    @FindBy(className = "container-navbar")       // sub menu
    public WebElement accountSettingNavBarWe;

    @FindBy(css = ".ui.compact a")
    public List<WebElement> navBarListWe;
    
    //@FindBy(css =".ui.grid a[href*='help.englishlive']")  //div a[href='/1/support/'] //    @FindBy(css = "div a[href='https://help.englishlive.ef.com/']")  //needHelpContainer_'] a")
    @FindBy(css = "a.btn-action[href$='/customerservice/helpcenter']")
    public WebElement viewCommonQuestionLinkWe;

    @FindBy(css = CANCEL_SUBSCRIPTION_CSS)
    public WebElement cancelLinkWe;   // red circle (x)

    @FindBy(css = UNDO_CANCEL_SUBSCRIPTION_CSS)
    public WebElement undoCancelLinkWe;


    //--------------------------------------------------------------------------------------
    public WebElement getActiveNavBarItem(){
        WebElement activeWe = accountSettingNavBarWe.findElement(By.cssSelector("li.active"));
        return activeWe;
    }

    // your account
    public void goToYourAccount(){
        logger.info("goToYourAccount ...!");
        click(navBarListWe.get(0));
    }

    public void goToYourProfile(){
        logger.info("goToYourProfile ...!");
        click(navBarListWe.get(1));
    }

    public void goToBilling(){
        logger.info("goToBilling ...!");
        click(navBarListWe.get(2));
    }

    public void goToEmailAndNotification(){
        logger.info("goToEmailAndNotification ...!");
        click(navBarListWe.get(3));
    }

    public void goToPrivacySetting(){
        logger.info("goToPrivacySetting ...!");

    }

    //*****************************
    public BaseAccountSettingPage(WebDriver webDriver){
        super(webDriver);
    }
    public BaseAccountSettingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BaseAccountSettingPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public BaseAccountSettingPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(getActiveNavBarItem()), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT);
        return ExpectedConditions.visibilityOf(getActiveNavBarItem());
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),accountSettingNavBarWe,WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertComponentsDisplayed(accountSettingNavBarWe, navBarListWe.get(3) );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( accountSettingNavBarWe);
        return true;
    }

    public boolean getToggleStatus(WebElement webElement){

        WebElement we = WebElementHelper.safeFindElement(webElement,By.cssSelector("div[class*='react-toggle--checked']"));
        if(we != null )
            return  true;
         else
           return false;

    }


}

