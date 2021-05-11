package com.englishtown.newhouse.school.pages.friends;
/**
 * Nikol May 2018
 *
 * [shown when you click on a friend card or when you click on find friends result card,
 * and when you click on the mutual friends cards, or any profile contact card on pending/recent chat]
 * contains 2 modules [ProfileDetails* CardDetails*]
 *
 */

import com.englishtown.helpers.AssertHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyFriendDetailsPage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(MyFriendDetailsPage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/user/"; //+$id  123548879556  /chat/friends/#/chat/friends/user/11418863

    public static final String BACK_LINK_CSS = "div[class^='contact_'] [class^='title_']";
    public static final String MUTUAL_FRIENDS_CSS = "div[class^='friends_'] [class^='contact-name_']";   //BtoCFDOSMFR`s friends (2)



    @FindBy(css = BACK_LINK_CSS)
    public WebElement backLinkWe;

    @FindBy(css = MUTUAL_FRIENDS_CSS)
    public WebElement mutualFriendsWe;  // fName friends(2) mutual friends heading


    public MyFriendDetailsPage(WebDriver webDriver){
        super(webDriver);
        initializeProfileModule();
        initializeContactModule();
    }

    public MyFriendDetailsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public MyFriendDetailsPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
        initializeProfileModule();
        initializeContactModule();
    }

    public MyFriendDetailsPage() {
        this(null, null);
        initializeProfileModule();
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(backLinkWe);
        profileModulePage.simpleTest();
        return false;
    }

    public boolean simpleTest() {
        logger.info("simpleTest on my friends page..!");
        AssertHelper.assertWebElementDisplayed(backLinkWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(backLinkWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    //----------------------------------------------------------------------------------------------------------------

    public void checkNumberOfMutualFriendsSectionHeading(int numberOfFriends){
        logger.info("checkNumberOfMutualFriends ...is [{}]", numberOfFriends);
        AssertHelper.assertWebElementTextContains(numberOfFriends, mutualFriendsWe);
    }

    public void checkUserFirstNameOnMutualFriendsSectionHeading(String fName){
        logger.info("checkUserFirstNameOnMutualFriendsSectionHeading ...is [{}]", fName);
        AssertHelper.assertWebElementTextContains(fName, mutualFriendsWe);
    }

    public void checkMinimumNumberOfMutualFriendsShown(int numberOfFriends){
        logger.info("checkMinimumNumberOfMutualFriendsShown ...is [{}]", numberOfFriends);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), contactModulePage.contactListWe , numberOfFriends);
    }

    public void clickOnMutualFriedContactCard(int cardIndex){
        logger.info("clickOnMutualFriedCard ...is [{}]", cardIndex);
        contactModulePage.clickOnCard(cardIndex);
    }


}
