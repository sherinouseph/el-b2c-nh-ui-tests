package com.englishtown.tests.core.school.friends;
/**
 * Base Friends Chat
 * Nikol 08/05/2018
 *
 * this test contains All chat interactions test
 * All actions performed by friends [add/cancel/reject/accept/chat/block/unblock/un friend]
 *
 * Setup [create 2 new users ]
 * 1.  Login as existing user [User 1]
 * 2.  Search[by name or email] for one of the new users created and click on in the result
 * 3.  Click add on profile details and check pending request number increased
 * 4.  Click cancel request on Profile details and check pending request decreased
 * 5.  Click add on profile, check pending requests, Click cancel on chat window, check pending request
 * 6.  Click add friend on chat window; check pending request
 * 7.  Login as user 2 [he has been invited] go to chat page
 * 8.  Click on first pending request [Should be only one] and click decline on chat window ... check no pending request shown
 * 9.  Login as User 1 and check pending request decreased
 * //moved to other test ... 10. User 1 block user 2 and unblock it and Un friend it
 *
*/

import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseFriendInteractionTest extends BaseFriendsChatTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseFriendInteractionTest.class);


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

    @Test(dependsOnMethods = "clickAddFriend")
    protected void checkPendingRequestsNumberIncreased() {
        logger.info("checkPendingRequest");
        initFriendsPage(getWebDriver());
        //todo check what happen when there are more than 21 requests
        friendsPage.checkPendingFriendRequestNumber(currentPendingRequestsNo+1);  // one more request should be added
    }

    @Test(dependsOnMethods = "checkPendingRequestsNumberIncreased")
    protected void clickOnCancelRequestOnProfileDetails() {
        logger.info("clickOnCancelRequestOnProfileDetails");
        initFriendsPage(getWebDriver());
        friendsPage.profileModulePage.clickOnCancelRequest();
        sleep(900);
        WaitTool.acceptAlert(getWebDriver(),15);
        sleep(900);
    }

    @Test(dependsOnMethods = "clickOnCancelRequestOnProfileDetails")
    protected void checkPendingRequestsNumberDecreased() {
        logger.info("checkPendingRequest");
        initFriendsPage(getWebDriver());
        //todo check what happen when there are more than 21 requests
        friendsPage.checkPendingFriendRequestNumber(currentPendingRequestsNo);  // one more request should be added
    }

    @Test(dependsOnMethods = "clickOnCancelRequestOnProfileDetails")
    protected void clickAddFriend_CheckPendingRequests_cancelFromChatWindow() {
        logger.info("clickAddFriend");
        initMyFriendDetailsPage(getWebDriver());
        myFriendDetailsPage.profileModulePage.clickOnAddFriend();
        sleep(5000);
        initFriendsPage(getWebDriver());
        friendsPage.checkPendingFriendRequestNumber(currentPendingRequestsNo+1);

        logger.info("Cancel from chat window");
        click(friendsPage.pendingFriendReqUserNameWe.get(0));
        initChatWindowPage(getWebDriver());
        chatWindowPage.clickOnCancelRequestLink();

        sleep(500);
        WaitTool.acceptAlert(getWebDriver(),15);
        sleep(900);
        friendsPage.checkPendingFriendRequestNumber(currentPendingRequestsNo);
    }

    @Test(dependsOnMethods = "clickAddFriend_CheckPendingRequests_cancelFromChatWindow")
    protected void clickAddFriend_OnChatWindow() {
        logger.info("clickAddFriend_OnChatWindow");
        initChatWindowPage(getWebDriver());
        chatWindowPage.clickOnBecomeFriedLink();
        sleep(500);
        initFriendsPage(getWebDriver());
        friendsPage.checkPendingFriendRequestNumber(currentPendingRequestsNo+1);
    }

    /**
     * User 2 Invitee
     */
    @Test(dependsOnMethods = "clickAddFriend_OnChatWindow")
    protected void openLoginPage_LoginAsUser2() {
        logger.info("openLoginPage_LoginAsUser2");
        // setup another driver instance for user 2
        driver2 = getNewDriver(MyBrowserType.FIREFOX, WaitTool.MED_WAIT_4_ELEMENT);
        openUrl(driver2, testStartUrl);
        enterUserCredentialsAndLogin(driver2, userBeanList.get(0).getUserName() , PASS);
        sleep(3000);
    }

    @Test(dependsOnMethods = "openLoginPage_LoginAsUser2")
    protected void goToChatFriendsPage_CloseGetStarted() {
        logger.info("goToChatFriendsPage_CloseGetStarted");
        gotoFriendsPageInitGetStarted(driver2);
        try {
            getStartedPage.clickOncloseBtn();
        }catch (WebDriverException e){
            logger.error("Could not close get started .. probably popup not shown ....!"+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "goToChatFriendsPage_CloseGetStarted")
    protected void clickOnPendingFriendRequest() {
        logger.info("clickOnPendingFriendRequest");
        initFriendsPage(driver2);
        click(friendsPage.pendingFriendReqUserNameWe.get(0));
    }

    @Test(dependsOnMethods = "clickOnPendingFriendRequest")
    protected void user2DeclineRequest_OnChatWindow() {
        logger.info("user2DeclineRequest_OnChatWindow");
        initChatWindowPage(driver2);
        click(chatWindowPage.declineRequestWe);
        sleep(900);
        WaitTool.acceptAlert(driver2,15);
        sleep(900);
        //
        initFriendsPage(driver2);
        WebElement pendingWe = WaitTool.findElementDontFailTest(driver2, By.cssSelector(friendsPage.PENDING_REQUEST_HEADING_CSS));
        AssertHelper.assertThat("WebElement should be NULL ... ", pendingWe == null);
    }

    /**
     * User 1
     */
    @Test(dependsOnMethods = "user2DeclineRequest_OnChatWindow")
    protected void user1_login_checkPendingRequestsNo_Decreased() {
        logger.info("user1_login_checkPendingRequestsNoDecreased");
        destroyDriver();
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl);
        enterUserCredentialsAndLogin(getWebDriver(), username , PASS);
        sleep(1000);
        gotoFriendsPageInitGetStarted(getWebDriver());
        getStartedPage.clickOncloseBtn();
        initFriendsPage(getWebDriver());
        friendsPage.checkPendingFriendRequestNumber(previousPendingRequestsNo);
    }

}


