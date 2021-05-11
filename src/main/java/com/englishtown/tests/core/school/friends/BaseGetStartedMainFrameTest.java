package com.englishtown.tests.core.school.friends;
/**
 *
 *  GetStartedPopUpTestTest
 * check title and description  of get started popup
 * click on find new friends, my friends, edit profile link adn check if it is going to correct pages
 * click on find new friends button in popup and check ifit is going to correct page
 * Click on close button and check if it is displaying the page you opened before
 *
 * Main Frame Test
 * Go to Friends Page and check if All the menu options are there
 * Check Find new friends is selected bydefault and check the element in find new friends page
 * Click on My Friends page and check element in myfriends page
 * Click on My Profile Page adn check element in MyProfile Page
 * Click on Get Started Page and check element in getstarted Page
 * Do the check for pending Friend request,Recent chat
 *
 *
 *
 * Sherin 13/04/2018
 *
 *
*/

import com.englishtown.newhouse.school.pages.friends.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

//todo rename .... ?
public  abstract class BaseGetStartedMainFrameTest extends BaseFriendsChatTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseGetStartedMainFrameTest.class);
    protected String chatUserName;



    @Test(dependsOnMethods ="gotoFriendsPageTest")
    protected void clickOnGetStartedAndcheckGetStartedPage() {
        getStartedPage = new GetStartedPage(getWebDriver(),25);
        getStartedPage.simpleTest();
        getStartedPage.checkAllPageComponentsDisplayed();
        getStartedPage.checkTitleAndDescription_GetStarted();

    }

    @Test(dependsOnMethods ="clickOnGetStartedAndcheckGetStartedPage")
    protected void clickOnEachLinkInGetStarted() {
        logger.info("clickOnEachLinkInGetStarted");

        getStartedPage.clickOnfindNewFriends_GetStarted();
        findNewFriendsPage = new FindNewFriendsPage(getWebDriver(), 25);
        findNewFriendsPage.simpleTest();
        friendsPage.clickOnGetStarted();

        getStartedPage.clickOnchatwithFriends_GetStarted();
        myFriendsPage = new MyFriendsPage(getWebDriver(), 25);
        myFriendsPage.simpleTest();
        friendsPage.clickOnGetStarted();

        getStartedPage.clickOnEditProfile_GetStarted();
        myProfilePage = new MyProfilePage(getWebDriver(), 25);
        myProfilePage.simpleTest();
        friendsPage.clickOnGetStarted();

    }
    @Test(dependsOnMethods ="clickOnEachLinkInGetStarted")
    protected void clickOnfindNewFriendsBtnInGetStartedAndclickOnCloseBtn() {
        logger.info("clickOnfindNewFriendsBtn");
        getStartedPage.ClickOnGetstarted_FindNewFriendsBtn();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.simpleTest();
        friendsPage.clickOnGetStarted();
        logger.info("click on close btn");
        getStartedPage.clickOncloseBtn();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.simpleTest();//Close will return to the page where we left. MFind new friends was the last page and hence checking the element in the myprofile page
    }




    @Test(dependsOnMethods ="clickOnfindNewFriendsBtnInGetStartedAndclickOnCloseBtn")
    protected void clickOnMyFriendsAndcheckMyFriendsPage() {
        logger.info("checkFrameComponentsInchat");
        friendsPage.checkAllPageComponentsDisplayed();
        friendsPage.clickOnMyFriends();
        myFriendsPage = new MyFriendsPage(getWebDriver(),25);
        myFriendsPage.simpleTest();

    }

    @Test(dependsOnMethods ="clickOnMyFriendsAndcheckMyFriendsPage")
    protected void clickOnMyProfileAndcheckMyProfilePage() {
        logger.info("clickOnMyProfileAndcheckMyProfilePage");
        friendsPage.clickOnMyProfile();
        sleep(1000);
        myProfilePage = new MyProfilePage(getWebDriver(),25);
        myProfilePage.simpleTest();

    }

    @Test(dependsOnMethods ="clickOnMyProfileAndcheckMyProfilePage")
    protected void clickOnFindNewFriendsAndCheckFindNewFriendsPage() {
        logger.info("clickOnFindNewFriendsAndCheckFindNewFriendsPage");
        friendsPage.clickOnFindNewFriends();
        sleep(1000);
        findNewFriendsPage = new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.simpleTest();
    }

    @Test(dependsOnMethods ="clickOnFindNewFriendsAndCheckFindNewFriendsPage")
    protected void checkRecentChat() {
        logger.info("checkRecentChat");
        friendsPage=new FriendsPage(getWebDriver(),25);
        friendsPage.recentChat_checkComponentsInMainFrame(0);
        friendsPage.checkRecentChatNumber(1);
        click(friendsPage.recentChatUserNameWe.get(0));
        chatWindowPage = new ChatWindowPage(getWebDriver(),25);//replace with initchatwindow
        chatWindowPage.simpleTest();
    }

    @Test(dependsOnMethods ="checkRecentChat")
    protected void checkPendingFriendRequest() {
        logger.info("checkPendingFriendRequest");
        friendsPage.pendingFriendRequest_checkComponentsInMainFrame();
        friendsPage.checkPendingFriendRequestGreaterThan(0);
        friendsPage.checkPendingFriendRequestStatus("Sent",0);
        click(friendsPage.pendingFriendReqUserNameWe.get(0));
        chatWindowPage = new ChatWindowPage(getWebDriver(),25);//replace with initchatwindow
        chatWindowPage.simpleTest();
    }



}


