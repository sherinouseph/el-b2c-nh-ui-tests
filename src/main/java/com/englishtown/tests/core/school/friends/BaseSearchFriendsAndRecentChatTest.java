package com.englishtown.tests.core.school.friends;
/**
 *Search for a user in recent chat using their full name and check the results
 * search for a user in friend list using their partial name and check the results
 * search for a user who appears in recent chat and friends list
 *
 *  * Sherin 01/05/2018
 *
 *
*/

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.friends.FriendsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseSearchFriendsAndRecentChatTest extends BaseFriendsChatTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseSearchFriendsAndRecentChatTest.class);
    protected String recentChatUser;
    protected String friendUser;


   @Test(dependsOnMethods ="gotoFriendsPageTest")
    protected void searchTheRecentChatUsers() {
       logger.info("searchTheRecentChatUsers");
       gotoFriendsPageInitGetStarted(getWebDriver());
       getStartedPage.clickOncloseBtn();
       friendsPage.searchRecentChatAndFriendsUsers(recentChatUser);
       friendsPage = new FriendsPage(getWebDriver(),25);
        friendsPage.searchFriendsAndRecentCat_CheckAllComponents();
        friendsPage.checkResultsForRecentChatAndFriendsSearch(recentChatUser);
    }

    @Test(dependsOnMethods ="searchTheRecentChatUsers")
    protected void searchTheFriendsUsersWithPartialName() {
        logger.info("searchTheFriendsUsers");
        friendsPage.searchRecentChatAndFriendsUsers(friendUser.split(" ")[0]);
        friendsPage = new FriendsPage(getWebDriver(),25);
        friendsPage.searchFriendsAndRecentCat_CheckAllComponents();
        friendsPage.checkResultsForRecentChatAndFriendsSearch(friendUser);
    }

    @Test(dependsOnMethods ="searchTheFriendsUsersWithPartialName")
    protected void checkIfBothRecentChatAndFriendListUSerAppearInSearch() {
        logger.info("checkIfBothRecentChatAndFriendListUSerAppearInSearch");
        friendsPage.searchRecentChatAndFriendsUsers("TEst");//test using uppercase just to check if the search is case sensitive
        friendsPage = new FriendsPage(getWebDriver(),25);
        friendsPage. checkIfUsersFromBothRecentchatAndFriendListAppeared();

    }

    @Test(dependsOnMethods ="checkIfBothRecentChatAndFriendListUSerAppearInSearch")
    protected void clickOnCloseIconAndCheckIfResultsDisappeared() {
        logger.info("clickOnCloseIconAndCheckIfResultsDisappeared");
        click(friendsPage.searchResultcloseBtn);
        friendsPage=new FriendsPage(getWebDriver(),20);
        AssertHelper.assertWebElementDisplayed(friendsPage.searchResultIconMagnifier );
    }







}


