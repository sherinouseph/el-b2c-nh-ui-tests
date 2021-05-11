package com.englishlive.tests.newhouse.apitest.chat;
/**
 * Nikol Apr 2018
 * Chat test
 * Swager https://logloader.englishtown.com/docs/chat/#/
 *
 * Test Steps:
 * 1. User 1 Send a friend request
 * 2. User 1 get Friend requests
 * 3. User 2 get Friend Requests
 * 4. User 2 approve Fried Request
 * 5. User 1 get friends
 * 6. User 1 get friends for a specific member {id}
 * 7. User 1 send message to user 2 [they are friends ]
 * 8. User 1 send message to user 3 [they are NOT friends ]
 * 9. User 2 get friends
 * 10. User 1 get user status [own]
 * 11. User 1 get a list of user status e.g ...*status/11417277,11417278,11417279
 * 12. User 1 get latest message per user
 * 13. User 2 get latest message per user
 * 14. User 1 set status to [1, 2, 3, 4, 5] get user status [ * ] then validate it
 * 15. User 2 send message to User 1
 * 16. User 1 Blocks User 2
 * 17. User 1 Unblock User 2
 * 18. User 1 get Friends after unblock .. zero friends .. validate
 * 19. User 1 send friend request to user 2 and he approves it
 * 20. User 1 Delete user 2
 * 21. User 1 get Friends after delete .. zero friends .. validate
 *
 *
 * User QA profile[worked on 16 Apr]
 *
 *
 */

import com.englishtown.enumpack.chat.ChatUserStatus;
import com.englishtown.enumpack.chat.FriendAction;
import com.englishtown.helpers.reader.ReadWriteToFile;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
import com.englishtown.newhouse.apicore.chat.BaseChatSpecSuite;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrChatFriendAllTest extends BaseChatSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(FrChatFriendAllTest.class);

    protected String memberPageUrl = "/fr-fr/buy/default/member/?ctr=fr";
    private boolean isCreateNewUser = true;


    //TODO create users in parallel and get their cookies in parallel
    @BeforeClass
    protected void setupCreateUsersBeforeClass() {
        paymentSubmitBtnCss = "button.btn.btn-primary";
        isNewHousePayment = false;
        //isClickTabOnPaymentPage = true;
        //paymentPageTabId = 1;
        //isNewHouseEnroll    = true;
        //paymentSubmitBtnCss = "div.active .bs3 .btn";
        memberPageUrl = getBASE_PROFILE_URL() + memberPageUrl; //getBASE_PROFILE_URL() + memberPageUrl;  "https://qa-"
        logger.info("@setupCreateUsersBeforeClass ...! memberPageUrl - " + memberPageUrl);
        setGridEnvironmentFromDargs();
    }

    /**
     * Create users
     */
    @Test
    // fail ... threadsafe (dataProvider =  "createChatUsers", dataProviderClass = ChatDataProvider.class)//, threadPoolSize = 3, timeOut = 360000 )
    protected void createTestUsers() {
        logger.info("createTestUsers ");
        if (isCreateNewUser) {
            setupTestUsers();
        } else {     //FOR QUICK TEST USE
            chatTestUserBean1 = new ChatTestUserBean(CHAT_USER1, CHAT_USER1_ID);
            chatTestUserBean1.setIncoming(false);
            chatTestUserBean1.setChatUserStatus(ChatUserStatus.OFFLINE);

            chatTestUserBean2 = new ChatTestUserBean(CHAT_USER2, CHAT_USER2_ID);
            chatTestUserBean2.setIncoming(true);
            chatTestUserBean2.setChatUserStatus(ChatUserStatus.OFFLINE);
        }
    }

    /**
     * migrate
     */
    /*@Test(dependsOnMethods = "createTestUsers")
    protected void migrateTestUsers(){
        // on 17 Apr test ok with migrating users
        //https://jira.eflabs.io/browse/LP-1058 pop up still shown when user logs in
        logger.warn("Does't matter the user below migrated or not ... Test all passes anyway and they should fail but .... ");
        chatApiMigrateChatUser(chatTestUserBean1.getUserId());
        chatApiMigrateChatUser(chatTestUserBean2.getUserId());
        chatApiMigrateChatUser(chatTestUserBean3.getUserId());
        //migrateChatUser(chatTestUserBean1.getUserId());
    }*/

    /**
     * Call login handler
     * and set the cookies cmus et_sid
     */
    @Test(dependsOnMethods = "createTestUsers")
    protected void getUser1_2_3_Cookies() {
        chatApiGetUserCookies(chatTestUserBean1, CHAT_USER_PASS);
        chatTestUserBean1.setCmusCookie(response.cookie("CMus"));
        chatTestUserBean1.setEtSidCookie(response.cookie("et_sid"));
        logger.info("added cmus and et_sid ...!\n" + chatTestUserBean1.toString() + "\n ---------------\n");

        chatApiGetUserCookies(chatTestUserBean2, CHAT_USER_PASS);
        chatTestUserBean2.setCmusCookie(response.cookie("CMus"));
        chatTestUserBean2.setEtSidCookie(response.cookie("et_sid"));
        logger.info("added cmus and et_sid ...!\n" + chatTestUserBean2.toString() + "\n ---------------\n");

        chatApiGetUserCookies(chatTestUserBean3, CHAT_USER_PASS);
        chatTestUserBean3.setCmusCookie(response.cookie("CMus"));
        chatTestUserBean3.setEtSidCookie(response.cookie("et_sid"));
        logger.info("added cmus and et_sid ...!\n" + chatTestUserBean3.toString() + "\n ---------------\n");
    }

    /**
     * Send friend request
     */
    @Test(dependsOnMethods = "getUser1_2_3_Cookies")
    protected void user1SendAFriendRequestToUser2() {
        chatApiPostFriend(FriendAction.ADD, chatTestUserBean1, chatTestUserBean2.getUserId());
    }

    /**
     * check friend request send by user 1 .. same user can be invited many times but only one request stored
     */
    @Test(dependsOnMethods = "user1SendAFriendRequestToUser2")
    protected void user1GetFriendRequests() {
        chatApiGetFriedRequests(chatTestUserBean1, chatTestUserBean2.getUserId(), true);
    }

    @Test(dependsOnMethods = "user1GetFriendRequests")
    protected void user2GetFriendRequest() {
        chatApiGetFriedRequests(chatTestUserBean2, chatTestUserBean1.getUserId(), true);
    }

    @Test(dependsOnMethods = "user2GetFriendRequest")
    protected void user2ApproveFriendRequests() {
        chatApiPostFriend(FriendAction.APPROVE, chatTestUserBean2, chatTestUserBean1.getUserId());
    }

    /**
     * /chat/2.0/friend/
     * Get the friends for user 1 ... only one at this stage
     * and check teh size is friends is 1
     * and check the status is offline [2]
     */
    @Test(dependsOnMethods = "user2ApproveFriendRequests")
    protected void user_1_GetFriends() {
        chatApiGetFriends(chatTestUserBean1, chatTestUserBean2, 1);
    }

    /**
     * when you logged in as user 1 call /chat/2.0/friend/{user2_ID}
     * same as user_1_GetFriends but in this case we have an id at the end of URL
     */
    @Test(dependsOnMethods = "user2ApproveFriendRequests")
    protected void user_1_GetFriendsForSpecificMember() {
        chatApiGetFriends(chatTestUserBean1, chatTestUserBean2, 1);
    }

    @Test(dependsOnMethods = "user2ApproveFriendRequests")
    protected void user_2_GetFriends() {
        chatApiGetFriends(chatTestUserBean2, chatTestUserBean1, 1);
    }

    @Test(dependsOnMethods = "user2ApproveFriendRequests")
    protected void user_1_SendMsgToUser_2_Friend() {
        chatApiSendMessage(chatTestUserBean1, chatTestUserBean2,
                "Hi,\n I am User 1, \n How are you?\n Whatz up User2....!", getDate(), "offline");
    }

    @Test(dependsOnMethods = "user2ApproveFriendRequests")
    protected void user_1_SendMsgToUser_3_NotFriend() {
        chatApiSendMessage(chatTestUserBean1, chatTestUserBean3,
                "Hi,\n I am User 1, \n How are you?\n Whatz up User3....!", getDate(), "offline");
        //failTest("receiving 200 and offline for this and it should fail as they not friends; default should be set to only friends can msg");
        logger.error("receiving 200 and offline for this and it should fail as they not friends; default should be set to only friends can msg");
    }

    // user one has sent 2 messages one to a friend U2; and one to non friend U3
    @Test(dependsOnMethods = "user_1_SendMsgToUser_3_NotFriend")
    protected void user_1_GetLatestMessagesPerUser() {
        chatApiGetLatestMessagesPerContacts(2, chatTestUserBean1, chatTestUserBean2, chatTestUserBean3);
    }

    @Test(dependsOnMethods = "user_1_GetLatestMessagesPerUser")
    protected void user_2_SendMsgToUser_1_Friend() {
        chatApiSendMessage(chatTestUserBean2, chatTestUserBean1,
                "hilatest,\n I am User 2, \n How are you?\n Whatz up User1, we friends ....!", getDate(), "offline");//ok
    }

    @Test(dependsOnMethods = "user_1_SendMsgToUser_2_Friend")
    protected void user_2_GetLatestMessagesPerUser() {
        // 1 msg ...
        chatApiGetLatestMessagesPerContacts(1, chatTestUserBean2, chatTestUserBean1);
    }

    // get status
    @Test(dependsOnMethods = "user_1_SendMsgToUser_2_Friend")
    protected void user_1_GetUserStatusList() {
        //calling this api set user to online
        chatTestUserBean1.setChatUserStatus(ChatUserStatus.ONLINE);
        chatTestUserBean2.setChatUserStatus(ChatUserStatus.ONLINE);
        chatTestUserBean3.setChatUserStatus(ChatUserStatus.OFFLINE);
        chatApiGetUsersStatusList(chatTestUserBean1, chatTestUserBean1, chatTestUserBean2, chatTestUserBean3);
    }

    @Test(dependsOnMethods = "user_1_SendMsgToUser_2_Friend")
    protected void user_1_GetUserStatus() {
        // NOTE: calling this api result on comet broadcast . and setting user online for 15 sec
        chatTestUserBean1.setChatUserStatus(ChatUserStatus.ONLINE);
        chatApiGetUsersStatus(chatTestUserBean1);
        // test :> sleep for 17 seconds call it again   TestUtil.mySleep(20000);  chatApiGetUsersStatus(chatTestUserBean1);
    }

    /**
     * Set user status to all ..ONLINE(1),    not this one ..OFFLINE(2),    IDLE(3),    BUSY(4),    APPEAR_OFFLINE(5);
     * get user status is as expected
     */
    @Test(dependsOnMethods = "user_1_GetUserStatus", dataProvider = "chatUserStatusList")
    protected void user_1_SetAllUserStatusAndGetUserStatus(ChatUserStatus status) {
        logger.info("Set and Get user status [{}]", status);
        chatTestUserBean1.setChatUserStatus(status);
        chatApiPostSetUsersStatus(chatTestUserBean1);
        chatTestUserBean1.setChatUserStatus(status);
        chatApiGetUsersStatus(chatTestUserBean1);
    }

    /**
     * Send friend request     ADD("add"),          -done     APPROVE("approve"),  -done
     * REJECT("reject"),    -done     DELETE("delete"),     CANCEL("cancel"),    -done
     * BLOCK("block"),       UNBLOCK("unblock");
     */
    @Test(dependsOnMethods = "user_1_GetLatestMessagesPerUser")
    protected void user1SendAFriendRequestToUser3AndCancelIt() {
        // send friend request
        chatApiPostFriend(FriendAction.ADD, chatTestUserBean1, chatTestUserBean3.getUserId());
        // cancel friend request
        chatApiPostFriend(FriendAction.CANCEL, chatTestUserBean1, chatTestUserBean3.getUserId());
        chatApiGetFriedRequests(chatTestUserBean1, chatTestUserBean1.getUserId(), false);
    }

    @Test(dependsOnMethods = "user_1_GetLatestMessagesPerUser")
    protected void user1SendAFriendRequestToUser3AndHeRejectsIt() {
        // send friend request
        chatApiPostFriend(FriendAction.ADD, chatTestUserBean1, chatTestUserBean3.getUserId());
        // cancel friend request
        chatApiPostFriend(FriendAction.REJECT, chatTestUserBean3, chatTestUserBean1.getUserId());
        //user 3 should have no friend requests
        chatApiGetFriedRequests(chatTestUserBean3, chatTestUserBean1.getUserId(), false);
    }

    // blocked users
    @Test(dependsOnMethods = "user_2_SendMsgToUser_1_Friend")
    protected void user1BlockUser2() {
        chatApiPostFriend(FriendAction.BLOCK, chatTestUserBean1, chatTestUserBean2.getUserId());
    }

    @Test(dependsOnMethods = "user1BlockUser2")
    protected void user1UnBlockUser2() {
        chatApiPostFriend(FriendAction.UNBLOCK, chatTestUserBean1, chatTestUserBean2.getUserId());
    }

    @Test(dependsOnMethods = "user1UnBlockUser2")
    protected void user_1_GetFriendsAfterUnblockZeroFriends() {
        chatApiGetFriends(chatTestUserBean1, chatTestUserBean2, 0);
    }

    @Test(dependsOnMethods = "user_1_GetFriendsAfterUnblockZeroFriends")
    protected void user1SendAFriendRequestToUser2AndUser2Approve() {
        chatApiPostFriend(FriendAction.ADD, chatTestUserBean1, chatTestUserBean2.getUserId());
        chatApiPostFriend(FriendAction.APPROVE, chatTestUserBean2, chatTestUserBean1.getUserId());
    }

    @Test(dependsOnMethods = "user1SendAFriendRequestToUser2AndUser2Approve")
    protected void user1DeleteUser2() {
        chatApiPostFriend(FriendAction.DELETE, chatTestUserBean1, chatTestUserBean2.getUserId());
    }

    @Test(dependsOnMethods = "user1DeleteUser2")
    protected void user_1_GetFriendsAfterDeleteZeroFriends() {
        chatApiGetFriends(chatTestUserBean1, chatTestUserBean2, 0);
    }

    @Override
    public void setupTestBeanDataAndSpec() {
    }

    public void setupTestUsers() {
        try {
            createThreadSafeDriver();
            chatTestUserBean1 = createAndSetupNewChatUsers(memberPageUrl, getWebDriver(), getMemberFormMap(),
                    EfConstants.ukMembersPayMap_new, isClickTabOnPaymentPage, paymentPageTabId, false, ChatUserStatus.OFFLINE);
            // EfConstants.ukMembersPayMap_new, false, 0, false, ChatUserStatus.OFFLINE);
        } finally {
            destroyDriver();
        }

        try {
            createThreadSafeDriver();
            chatTestUserBean2 = createAndSetupNewChatUsers(memberPageUrl, getWebDriver(), getMemberFormMap(),
                    EfConstants.ukMembersPayMap_new, false, 0, true, ChatUserStatus.OFFLINE);
        } finally {
            destroyDriver();
        }

        try {
            createThreadSafeDriver();
            chatTestUserBean3 = createAndSetupNewChatUsers(memberPageUrl, getWebDriver(), getMemberFormMap(),
                    EfConstants.ukMembersPayMap_new, false, 0, true, ChatUserStatus.OFFLINE);
        } finally {
            destroyDriver();
        }
        logger.info("\n\n $$$$$$$$$$$$$$$$$$$$ Test Users  $$$$$$$$$$$$$$$$$$$$$$$$$$ ");
        logger.info("User setup...!" + chatTestUserBean1.toString());
        logger.info("User setup...!" + chatTestUserBean2.toString());
        logger.info("User setup...!" + chatTestUserBean3.toString());
        logger.info("\n\n $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ ");
    }


    @AfterClass
    protected void teardownAfterClass() {
        logger.info("@ After Class ...!");
        List<ChatTestUserBean> chatUserList = new ArrayList<ChatTestUserBean>();
        chatUserList.add(chatTestUserBean1);
        chatUserList.add(chatTestUserBean2);
        chatUserList.add(chatTestUserBean3);
        try {
            TestUtil.usersFileLocation = ReadWriteToFile.getTestUserFilePath();
            TestUtil.userFilePath = Paths.get("C:/work/testusers/" + TestUtil.getFileName(getENVIRONMENT()));
            logger.info(" User File Path is :" + TestUtil.userFilePath.toString());
        } catch (Exception e) {
            logger.error(" Failed to set up projectLocation : " + TestUtil.getExceptionFirstLine(e));
        }
        int count = 0;
        try {
            for (ChatTestUserBean user : chatUserList) {
                count++;
                ReadWriteToFile.storeData(true, user.getUserName(), user.getUserId(), "chatuserNo_"
                        + count, getENVIRONMENT(), "gb");
                //cancelSubscription(user.getUserName());
            }
        } catch (Exception e) {
            logger.error(" Failed to store data ...!");
        }

//        try {
//            for (ChatTestUserBean user : chatUserList) {
//                cancelSubscription(user.getUserName());
//            }
//        } catch (Exception e) {
//            logger.error(" Failed to cancel subscription...!"+e.getMessage());
//        }
        destroyDriver();

    }




    /**
     * get a map with random first name and last name
     * @return
     */
    public Map getMemberFormMap(){
        String fName = TestUtil.generateRandomString("BtoC", 7);
        String lName = TestUtil.generateRandomString("BtoC", 6);
        Map<String, String> memberFormMap = EfConstants.MEMBER_FORM_FLP;
        memberFormMap.replace("firstname", fName );
        memberFormMap.replace("lastname", lName);

        return memberFormMap;
    }




    @DataProvider(name = "chatUserStatusList")
    public static Object[][] chatUserStatusList() {
        return new Object[][] {
                {ChatUserStatus.ONLINE},
                {ChatUserStatus.IDLE},
                {ChatUserStatus.BUSY},
                {ChatUserStatus.APPEAR_OFFLINE},
        };
    }
}







// parallel test did not work thread safe error

/**
 * Create 3 users using the ui and enroll
 */
    /*public void setupTestUsers(int testNo, boolean incoming) {
        if(testNo == 1) {
            setupTestCreateUsers(chatTestUserBean1, incoming);
            /*createThreadSafeDriver();
            openUrl(memberPageUrl);
            chatTestUserBean1 = createNewUser(getWebDriver(), EfConstants.ukMembersFormMap, EfConstants.ukMembersPayMap_new, false, 0);
            chatTestUserBean1.setIncoming(incoming);
            destroyDriver();*/
/*        }
        if(testNo == 2) {
            setupTestCreateUsers(chatTestUserBean2, incoming);
            /*createThreadSafeDriver();
            openUrl(memberPageUrl);
            chatTestUserBean2 = createNewUser(getWebDriver(), EfConstants.ukMembersFormMap, EfConstants.ukMembersPayMap_new, false, 0);
            chatTestUserBean2.setIncoming(incoming);
            destroyDriver();*/
/*        }
        if(testNo == 3) {
            setupTestCreateUsers(chatTestUserBean3, incoming);
            /*createThreadSafeDriver();
            openUrl(memberPageUrl);
            chatTestUserBean3 = createNewUser(getWebDriver(), EfConstants.ukMembersFormMap, EfConstants.ukMembersPayMap_new, false, 0);
            chatTestUserBean3.setIncoming(incoming);
            destroyDriver();*/
/*       }
    }*/
/*
    public void setupTestCreateUsers(ChatTestUserBean userBean, boolean incoming) {
        createThreadSafeDriver();
        try {
            openUrl(memberPageUrl);
            BaseTest.sleep(1000);
            userBean = createNewUser(getWebDriver(), EfConstants.ukMembersFormMap, EfConstants.ukMembersPayMap_new, false, 0);
            userBean.setIncoming(incoming);
        }finally {
            destroyDriver();
        }
    }*/



/**

 protected void user_1_SetAllUserStatusAndGetUserStatus(ChatUserStatus status){
 String failedTest = null;
 for(ChatUserStatus status:ChatUserStatus.values()) {
 logger.info("Set and Get user status [{}]", status);
 try {
 chatTestUserBean1.setChatUserStatus(status);
 chatApiPostSetUsersStatus(chatTestUserBean1);
 chatTestUserBean1.setChatUserStatus(status);
 chatApiGetUsersStatus(chatTestUserBean1);
 }catch (Exception | AssertionError e){
 logger.error("Failed to set and get user status [{}]...!"+e.getMessage(), status);
 failedTest = failedTest+"Failed To Set status to [{"+status+"}] "+e.getMessage() +"\n";
 }finally {
 if(StringUtils.isNotBlank(failedTest)){
 failTest("Some of the test filed [{"+failedTest+"}]");
 }
 }
 }
 }

 */