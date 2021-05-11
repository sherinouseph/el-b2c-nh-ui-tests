package com.englishtown.tests.core.school.friends;
/**
 * Base ChatWindow Test
 *
 * Sherin 13/04/2018
 *
 *
*/

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.friends.*;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseChatWindowTest extends BaseFriendsChatTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseChatWindowTest.class);
    protected String chatUserName;
    int recentChatIndex;
    protected String message1="Hey, Can we be friends";
    protected String message2="Yes, I am glad to be your friend";




    @Test(dependsOnMethods ="gotoFriendsPageTest")
    protected void clickOnRecentChatofUserWithChatAcessAll() {
        closeGetStartedWindow(getWebDriver());
        logger.info("clickOnRecentChatofUserWithChatAcessAll");
        friendsPage=new FriendsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        friendsPage.clickOnRecentChat(chatTestUser1);
//        recentChatIndex=getIndexOfMatchingUserNAme_recentChat();
//        friendsPage.clickOnRecentChat(recentChatIndex);
    }

    @Test(dependsOnMethods = "clickOnRecentChatofUserWithChatAcessAll")
    protected void sendMessageToUserWithChatAccessAll() {
        logger.info("checkRecentChatComponents");
        chatWindowPage= new ChatWindowPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        chatWindowPage.simpleTest();
        chatWindowPage.assertUserName(chatTestUser1);
        chatWindowPage.checkAllPageComponentsDisplayed();
        AssertHelper.assertWebElementDisplayed(chatWindowPage.cancelReqLinkWe);//cancel request and becoem friends link same.
        chatWindowPage.sendMessage(message1);
        chatWindowPage.checkLatestMessage(message1);

    }

    @Test(dependsOnMethods ="sendMessageToUserWithChatAccessAll")
    protected void searchForUserWithChatAccessFriends() {
        logger.info("searchForUserWithChatAccessFriends");
       friendsPage.clickOnFindNewFriends();
       findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
       findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
       findNewFriendsPage.searchByEmail(chatTestUser2EmailId);
       findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();
       findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
       findNewFriendsResultPage.simpleTest();
       findNewFriendsResultPage.contactModulePage.clickOnCard(0);

    }

    @Test(dependsOnMethods = "searchForUserWithChatAccessFriends")
    protected void clickOnChatNowAndsendMessageToUserWithChatAccessFriends() {
        myFriendDetailsPage = new MyFriendDetailsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        myFriendDetailsPage.profileModulePage.clickOnChatNow();
        logger.info("checkRecentChatComponents");
        chatWindowPage= new ChatWindowPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        chatWindowPage.simpleTest();
        chatWindowPage.checkAllPageComponentsDisplayed();
        AssertHelper.assertWebElementDisplayed(chatWindowPage.disabledChatBoxWe);
    }

    protected int getIndexOfMatchingUserNAme_recentChat(){
        int i;
        for(i=0;i<=friendsPage.recentChatUserNameWe.size();i++) {
            if (StringUtils.equalsIgnoreCase(friendsPage.recentChatUserNameWe.get(i).getText(), chatTestUser2))
                break;
            else
                i++;
        }
        return i;
        }






}


