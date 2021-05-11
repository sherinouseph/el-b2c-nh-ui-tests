package com.englishtown.tests.core.school.friends;
/**
 * Base Friends Chat
 * Nikol 08/05/2018
 *
 * this test contains All chat interactions test
 * All actions performed by friends [add/cancel/reject/accept/chat/block/unblock/un friend]
 *
 * Setup [create 1 new users ]
 *
 * 1. User 1 block user 2 and unblock it and Unfriend it
 *
*/

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.friends.MyFriendDetailsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.bouncycastle.crypto.tls.ContentType.alert;


public abstract class BaseFriendBlockUnblockUnfriendTest extends BaseFriendsChatTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseFriendBlockUnblockUnfriendTest.class);


    @Test(dependsOnMethods = "gotoFriendsPageTest")
    protected void closeGetStarted() {
        logger.info("closeGetStarted");
        initGetStartedPage(getWebDriver());
        getStartedPage.clickOncloseBtn();
    }

    @Test(dependsOnMethods = "closeGetStarted")
    protected void gotoFindByNameOrEmailEnterEmailsAndSearch() {
        chatUserName_SearchByNameOrEMail = userBeanList.get(0).getUserName();
        goto_FindByNameOrEmail_EnterEmailAndSearch(getWebDriver(), chatUserName_SearchByNameOrEMail);
    }

    @Test(dependsOnMethods = "gotoFindByNameOrEmailEnterEmailsAndSearch")
    protected void checkSearchResultAndClickOnACard() {
        check_SearchResult_AndClickOnACard(getWebDriver(), 1, 0);
        setCurrentPendingRequest(friendsPage.getPendingFriendRequestNumber());  //friendsPage.getPendingFriendRequestNumber()
        setPreviousPendingRequestsNo(currentPendingRequestsNo);
        logger.info("setup Current pending Requests No [{}]", currentPendingRequestsNo);
    }

    @Test(dependsOnMethods = "checkSearchResultAndClickOnACard")
    protected void clickAddFriend() {
        logger.info("clickAddFriend");
        initMyFriendDetailsPage(getWebDriver());
        myFriendDetailsPage.profileModulePage.clickOnAddFriend();
        sleep(900);
    }


    //Block ; unblock; unfriend
    // send message and check text and message status received and sent for each users
    @Test(dependsOnMethods = "clickAddFriend")
    protected void user1_block_User2() {
        logger.info("user1_block_User2");
        initMyFriendDetailsPage(getWebDriver());
        myFriendDetailsPage.profileModulePage.clickOnBlock();
        WaitTool.acceptAlert(getWebDriver(),15);
        sleep(900);
        myFriendDetailsPage = new MyFriendDetailsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(myFriendDetailsPage.profileModulePage.blockBtnWe),"Unblock","Unblock link not present");
        sleep(900);
        //todo check button changed
    }

    @Test(dependsOnMethods = "user1_block_User2")
    protected void user1_unBlockUser2() {
        logger.info("user1_unBlockUser2");
        myFriendDetailsPage.profileModulePage.clickOnUnBlock();
        WaitTool.acceptAlert(getWebDriver(),15);
        sleep(900);
        myFriendDetailsPage = new MyFriendDetailsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(myFriendDetailsPage.profileModulePage.blockBtnWe),"Block","Block link not present");
        sleep(900);
    }


}


