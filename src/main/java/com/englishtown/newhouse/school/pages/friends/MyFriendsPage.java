package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin
 *
 *Click on My Friends in the side Menu of the Friends chat and this is called as MyFriends Page
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MyFriendsPage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(MyFriendsPage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/friends";    // course-> my course


    public static final String MYFRIENDS_BASE_CSS        = "div[class^='default_']";
    public static final String MYFRIENDS_HEADING_CSS     = "[class^='heading_']";
    public static final String MYFRIENDS_NOFRIENDSTEXT_CSS     = MYFRIENDS_BASE_CSS + " [class^='copy-head']";
    public static final String MYFRIENDS_NOFRIENDSSUBTEXT_CSS     = MYFRIENDS_BASE_CSS + " [class^='copy-subhead']";



    @FindBy(css = MYFRIENDS_HEADING_CSS)
    public WebElement myFriendsTitleWe;



    @FindBy(css = MYFRIENDS_NOFRIENDSTEXT_CSS)
    public WebElement textWe;

    @FindBy(css = MYFRIENDS_NOFRIENDSSUBTEXT_CSS) //a.dispatchEvent(new MouseEvent('click'))
    public WebElement subtextWe;





    public MyFriendsPage(WebDriver webDriver){
        super(webDriver);
        initializeContactModule();
    }

    public MyFriendsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MyFriendsPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
        initializeContactModule();
    }

    public MyFriendsPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(myFriendsTitleWe);
        return false;
    }


    public void checkMessageWhenYouYouDontHaveANyFriends(){
        logger.info("checkMessageWhenYouYouDontHaveANyFriends");
        AssertHelper.assertStringContains(textWe.getText(),"Feeling lonely","Message Incorrect");
        AssertHelper.assertStringContains(subtextWe.getText(),"Start a new search for friends today","Message Incorrect");
    }




    public boolean simpleTest() {
        logger.info("simpleTest on my friends page..!");
        AssertHelper.assertWebElementDisplayed(myFriendsTitleWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(myFriendsTitleWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
