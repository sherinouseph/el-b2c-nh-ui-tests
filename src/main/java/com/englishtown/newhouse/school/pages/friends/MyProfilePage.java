package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin/[Nikol] May 2018
 *
 * On CHAT app I click my profile ... my profile details shown
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


public class MyProfilePage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(MyProfilePage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/profile";    // course-> my course

    public static final String PROFILE_BASE_CSS  = "div[class^='profile_']";
    public static final String PROFILE_HEADING_CSS = PROFILE_BASE_CSS +"  [class^='title_']";
    public static final String PROFILE_UPDATE_LINK_CSS = PROFILE_BASE_CSS +" a[class^='link_']";



    // heading
    @FindBy(css = PROFILE_HEADING_CSS)
    public WebElement myProfileHeadingWe;  // shows : My profile

    @FindBy(css = PROFILE_UPDATE_LINK_CSS)   //Update profile & settings
    public WebElement updateProfileLinkWe;




    public MyProfilePage(WebDriver webDriver){
        super(webDriver);
        initializeProfileModule();
    }

    public MyProfilePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MyProfilePage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
        initializeProfileModule();
    }

    public MyProfilePage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(updateProfileLinkWe);
        return false;
    }




    public void clickOnUpdateProfileSettings(){
        logger.info("clickOnUpdateProfileSettings");
        click(updateProfileLinkWe);
     }


    public boolean simpleTest() {
        logger.info("simpleTest on my profile page..!");
        AssertHelper.assertWebElementDisplayed(myProfileHeadingWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(myProfileHeadingWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
