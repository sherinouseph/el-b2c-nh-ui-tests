package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin
 *click on get started link at the left top corner
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class GetStartedPage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(GetStartedPage.class);
   // public static final String pageUrl = "/chat/friends/#/chat/friends/user/";    // course-> my course




    public static final String GETSTARTED_BASE_CSS        = "div[class^='get-started']";
    public static final String GETSTARTED_HEADING_CSS     = GETSTARTED_BASE_CSS + " [class^='header_']";
    public static final String GETSTARTED_DESCRIPTION_CSS     = GETSTARTED_BASE_CSS + " [class^='description_']";
    public static final String GETSTARTED_ICONS_CSS     = GETSTARTED_BASE_CSS + " [class^='body_'] [class^='action_']";

    @FindBy(css = GETSTARTED_HEADING_CSS)
    public WebElement getStartedTitleWe;

    @FindBy(css = GETSTARTED_ICONS_CSS)
    public List<WebElement> getStartedIconListWe;


    @FindBy(css = GETSTARTED_BASE_CSS+ " button")
    public WebElement getstarted_findNewFriendsBtn;

    @FindBy(css =GETSTARTED_BASE_CSS+" [class^='close_']")
    public WebElement closeBtn;

    @FindBy(css = GETSTARTED_DESCRIPTION_CSS)
    public WebElement getStartedDescriptionWe;





    public GetStartedPage(WebDriver webDriver){
        super(webDriver);
    }

    public GetStartedPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public GetStartedPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    public GetStartedPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(getstarted_findNewFriendsBtn,getStartedIconListWe.get(0),getStartedIconListWe.get(1),getStartedIconListWe.get(2),getStartedTitleWe,getStartedDescriptionWe);
        return false;
    }



    public boolean simpleTest() {
        logger.info("simpleTest on get started Page..!");
        AssertHelper.assertWebElementDisplayed(getstarted_findNewFriendsBtn);
        return true;
    }


    public void clickOnfindNewFriends_GetStarted(){
        logger.info("clickOnfindNewFriends_GetStarted");
        click(getStartedIconListWe.get(0));
    }

    public void clickOnchatwithFriends_GetStarted(){
        logger.info("clickOnchatwithFriends_GetStarted");
        click(getStartedIconListWe.get(1));
    }

    public void clickOnEditProfile_GetStarted(){
        logger.info("clickOnEditProfile_GetStarted");
        click(getStartedIconListWe.get(2));
    }
    public void ClickOnGetstarted_FindNewFriendsBtn(){
        logger.info("ClickOnGetstarted_FindNewFriendsBtn");
        click(getstarted_findNewFriendsBtn);
    }

    public void clickOncloseBtn(){
        logger.info("clickOncloseBtn");
        click(closeBtn);
    }

    public void checkTitleAndDescription_GetStarted(){
        logger.info("checkTitleAndSubTitle_GetStarted");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(getStartedTitleWe),"Welcome to Friends,","Get started- Welcome Title Wrong");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(getStartedDescriptionWe),"Here you can find other like minded students","Get started Description Wrong");
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(getstarted_findNewFriendsBtn);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
