package com.englishtown.newhouse.apicore.chat;
/**
 * Created by nikol.marku on 03-Apr-18.
 *
 * Base chat suite, All chant test should extend this class
 *
 */

import com.englishtown.enumpack.chat.FriendAction;
import com.englishtown.newhouse.apicore.BaseSpecSuite;
import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
import com.englishtown.newhouse.school.beanandenum.bean.chat.ChatFriendsSearchResultBean;
import com.englishtown.newhouse.school.beanandenum.bean.chat.HitSourceBean;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

//https://qa-englishlive.ef.com/chat/friends/#/?hideTeaser=true
public abstract class BaseChatSpecSuite extends BaseSpecSuite implements IChat{
    public static final Logger logger = LoggerFactory.getLogger(BaseChatSpecSuite.class);


    protected ChatFriendsSearchResultBean searchResultBean; // can have one or many sources .. profiles
    protected HitSourceBean hitSourceBean;
    protected String currentSearchMemberId = "37578726"; //"11411591"; //"11417984";//QA /// stg 29948679  //"11417982"; // with level 11417405
    protected String searchMemberId        = "37578726"; //"11411591";
    protected String searchMemberId_qa     = "11417984";
    protected String searchMemberId_stg    = "14893638";
    // qa users  auto_1854641437881_OGUQRIN311487233_xdelx@qp1.org auto_1894169222558_OSOFEMS240697934_xdelx@qp1.org
    protected String searchByEmail  = "auto_api_searchbyemail@qp1.org";  // qa/stg auto_api_searchbyemail@qp1.org was ...auto_18653838045674000_FNOLFLA143223083_xdelx@qp1.org user
    protected String searchByEmailRegEx  = "auto*xdelx@qp1.org";

    /**
     *
     * New house users default privacy for prifile and chat is friends only so need to change it to public
     *
     * {"settings":[{"key":"profile_privacy","value":"Public"}]}
     * {"settings":[{"key":"chat_privacy","value":"Public"}]}
     * {"settings":[{"key":"chat_status","value":1}]}
     *
     * Do one at a time
     *
     */
    public void chatApiPutProfilePrivacyAndStatus(String key, String value, ChatTestUserBean chatTestUserBean){
        cleanUp();
        initSpecPutProfilePrivacy(key, value, chatTestUserBean);
        initResponsePutProfilePrivacy();
        defaultPutSpec();
    }

    public void initSpecPutProfilePrivacy(String key, String value, ChatTestUserBean chatTestUserBean){
        testBaseUrl =  getBASE_PROFILE_URL()+ user_setting_newhouse;

        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        setDefaultChatApiPutUserSettingRequestBody();
        requestSpecBuilder.setContentType(ContentType.JSON);

        //isNewHouseLogin   valueReplaceWithDynamic\"\n" +keyReplaceWithDynamic
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+chatTestUserBean.getUuid());
        chatApiPutUserSettingRequestBody = chatApiPutUserSettingRequestBody.replace("keyReplaceWithDynamic", key);
        chatApiPutUserSettingRequestBody = chatApiPutUserSettingRequestBody.replace("valueReplaceWithDynamic", value);

        setBodyRequestSpecBuilder(chatApiPutUserSettingRequestBody);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponsePutProfilePrivacy( ){
        logger.info("initResponsePutProfilePrivacy Check Response 201 ...! Created");
        responseSpecBuilder.expectStatusCode(201);
        responseSpecification = responseSpecBuilder.build();
    }
// end change profile privacy


    /**
     * Friend api all actions
     * POST /chat/2.0/friend {Action : [add]}
     * curl -X POST "https://qa.englishtown.com/chat/2.0/friend" -H "accept: text/plain" -H
     * "Content-Type: application/json" -d "{ \"userID\": 242432323, \"action\": \"add/approve/reject/delete/cancel/block/unblock\"}"
     *
     */
    public void chatApiPostFriend(FriendAction action, ChatTestUserBean chatTestUserBean, String userId){
        cleanUp();
        initSpecPostFriend(action, chatTestUserBean, userId);
        initResponsePostAddFried();
        defaultGetResponsePostSpec();
    }

    public void initSpecPostFriend(FriendAction action, ChatTestUserBean chatTestUserBean, String inviteUserId){
        testBaseUrl =  getBASE_PROFILE_URL()+ chat_friend;

        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        setDefaultChatApiPostFriedRequestBody();
        requestSpecBuilder.setAccept("text/plain");
        requestSpecBuilder.setContentType(ContentType.JSON);

        if(isNewHouseLogin){
            requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+chatTestUserBean.getUuid());
            chatApiPostFriendRequestBody = chatApiPostFriendRequestBody.replace("userIdReplaceWithDynamic", inviteUserId);
            chatApiPostFriendRequestBody = chatApiPostFriendRequestBody.replace("actionReplaceWithDynamic", action.getAction());
        }else {
            requestSpecBuilder.addCookie("CMus", chatTestUserBean.getCmusCookie());
            requestSpecBuilder.addCookie("et_sid", chatTestUserBean.getEtSidCookie());
            chatApiPostFriendRequestBody = chatApiPostFriendRequestBody.replace("userIdReplaceWithDynamic", inviteUserId);
            chatApiPostFriendRequestBody = chatApiPostFriendRequestBody.replace("actionReplaceWithDynamic", action.getAction());
        }


        setBodyRequestSpecBuilder(chatApiPostFriendRequestBody);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponsePostAddFried( ){
        logger.info("Check Response ");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * GET "https://qa.englishtown.com/chat/2.0/friend" -H "accept: application/json"
     * @param userId
     *
     */
    public void chatApiGetFriedRequests(ChatTestUserBean chatTestUserBean, String userId, boolean hasRequests){
        cleanUp();
        initSpecGetFriendsRequest(chatTestUserBean);
        initResponseGetFriendsRequest(userId, chatTestUserBean.isIncoming(), hasRequests);
        response = defaultGetResponseGetSpec();
    }

    public void initSpecGetFriendsRequest(ChatTestUserBean chatTestUserBean){
        testBaseUrl = getBASE_PROFILE_URL()+ chat_friend+"request";
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setAccept("text/plain");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addCookie("CMus", chatTestUserBean.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatTestUserBean.getEtSidCookie());

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetFriendsRequest(String userId, boolean isIncoming, boolean hasRequests){
        logger.info("Check Response hasRequests [{}] ", hasRequests);
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        if(hasRequests) {
            responseSpecBuilder.expectBody("userID", hasItem(userId));
            responseSpecBuilder.expectBody("incoming", hasItem(isIncoming));                                               //responseSpecBuilder.expectBody("Phases.OfferId", hasItem(Integer.parseInt(studentBean.getOffer_id())));
        }else {
            logger.info("User should have no requests ...!");
            responseSpecBuilder.expectBody("size()", equalTo(0));
            //responseSpecBuilder.expectBody(empty()); //Expected: (null or an empty string)        Actual: []            //responseSpecBuilder.expectBody(isEmptyOrNullString());      //responseSpecBuilder.expectBody("$", Matchers.hasSize(0));         //responseSpecBuilder.expectBody("isEmpty()", Matchers.is(true));
        }
        responseSpecification = responseSpecBuilder.build();
    }




    /**
     *
     * Get user cmus and et_sid cookies and set it to global vars
     * This is for the old house
     *
     *
     * @param pass
     */
    public void chatApiGetUserCookies(ChatTestUserBean chatTestUserBean, String pass){
        cleanUp();
        initSpecPostLoginHandler(chatTestUserBean.getUserName(), pass);
        initResponsePostLoginHandler();
        response = defaultGetResponsePostSpec();

        /*try {
            logger.info("Setup cookies cmus and et_sid ..! ");            //setUser1_cookie_cmus(response.cookie("CMus"));        //setUser1_cookie_et_sid(response.cookie("et_sid"));            logger.info(" user1_cookie_cmus [{}]", getUser1_cookie_cmus());            logger.info(" user1_cookie_et_sid [{}]", getUser1_cookie_et_sid());
        } catch (Exception e) {
            logger.error("Cant get Cookies ...! ");
            BaseTest.failTest("Cant get user Cookies ..."+e.getMessage());
        }*/
    }

    /**
     * OLd house post reqaest
     * @param username
     * @param pass
     */
    public void initSpecPostLoginHandler(String username, String pass){
        testBaseUrl = getBASE_PROFILE_URL() + login_handler;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.addFormParam("UserName",username);
        requestSpecBuilder.addFormParam("Password",pass);
        //todo get base url from profile   BASE_TEST_URL set to [https://qa-b2c.eflabs.io]
        requestSpecBuilder.addFormParam("referer",getBASE_PROFILE_URL() + login_handler);   //"englishlive.ef.com/en-gb/login/");

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponsePostLoginHandler(){
        logger.info("Check Response 302 and has expected cookies");
        responseSpecBuilder.expectStatusCode(302);
        responseSpecBuilder.expectCookie("CMus");
        responseSpecBuilder.expectCookie("et_sid");
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * need to migrate the users chat data
     *
     * curl -X POST "http://qa.englishtown.com/chat/2.0/legacyfriend/11416354/migrate" -H "X-EF-ACCESS: eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleXMvcHVibGljL2NoYXQvY2hhdC5wZW0ifQ.eyJpc3MiOiJjaGF0IiwiZXhwIjoxNTUzNjYwODg0LCJpYXQiOjE1MjIxMjQ4ODR9.eIh2fWNVAf_8l7EDs-DXMO5tjMmIz_DzJ6JfSls2dApQdCa_jqrAArrh4wROk3vjHR2zD5Ps3qVArcWEnAt4fKZL-Eeb4vBcHu4Qw0uMWu7EWQKGcz10q1cyQ1tKxmCLpn-9mb0nOwWPiGTcJ_uxvfcxq5izmR8bW5zcbVU8pFU" -H "Content-Length: 0"
     *
     */
    public void chatApiMigrateChatUser(String memberId) {
        cleanUp();
        initSpecPostMigrateChatUser(memberId);
        initResponsePostMigrateChatUser();
        response = defaultGetResponsePostSpec();
    }

    public void initSpecPostMigrateChatUser(String memberId){
        //TODO get base url per ENVs
        testBaseUrl = migrate_qa_user+memberId+"/migrate";
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.addHeader("X-EF-ACCESS", migrate_qa_user_x_ef_access);
        requestSpecBuilder.addHeader("ontent-Length", "0");

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponsePostMigrateChatUser(){
        logger.info("Check Response 302 and has expected cookies");
        responseSpecBuilder.expectStatusCode(200);
        responseSpecification = responseSpecBuilder.build();
    }


    //------------------------------------------------------------------------------------------------------------------

    /**
     * Get Friends ....
     * @param invitee, invited [the one who sent the invite, the one invited]
     *
     */
    public void chatApiGetFriends(ChatTestUserBean invitee, ChatTestUserBean invited, int howManyFriends){
        cleanUp();
        initSpecGetFriends(invitee);
        initResponseGetFriends(invited, howManyFriends);
        defaultGetResponseGetSpec();
    }

    public void initSpecGetFriends(ChatTestUserBean chatTestUserBean){
        testBaseUrl = getBASE_PROFILE_URL()+chat_friend;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setAccept("text/plain");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addCookie("CMus", chatTestUserBean.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatTestUserBean.getEtSidCookie());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetFriends(ChatTestUserBean chatTestUserBean, int howManyFriends){
        logger.info("Check Response User Id, status, body size ....!");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        if(howManyFriends == 0){
            logger.info("no friends ");
            responseSpecBuilder.expectBody("size()", equalTo(0));
        } else {
            responseSpecBuilder.expectBody("userID", hasItem(chatTestUserBean.getUserId()));
            responseSpecBuilder.expectBody("status", hasItem(chatTestUserBean.getChatUserStatus().getId()));
            responseSpecBuilder.expectBody("size()", equalTo(howManyFriends));
        }
        responseSpecification = responseSpecBuilder.build();
    }

    public void chatApiGetFriendsById(ChatTestUserBean invitee, ChatTestUserBean invited, int howManyFriends){
        cleanUp();
        initSpecGetFriendsByMemberId(invitee, invited.getUserId());
        initResponseGetFriends(invited, howManyFriends);
        defaultGetResponseGetSpec();
    }

    public void initSpecGetFriendsByMemberId(ChatTestUserBean chatTestUserBean, String memberIdToFindFriendsOf){
        testBaseUrl =  getBASE_PROFILE_URL() + chat_friend+"/"+memberIdToFindFriendsOf;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setAccept("text/plain");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addCookie("CMus", chatTestUserBean.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatTestUserBean.getEtSidCookie());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     * User 1 send msg to user 2
     *
     */
    public void chatApiSendMessage(ChatTestUserBean sender, ChatTestUserBean receiver, String msg, long msgTime, String sendMsgResponseHtmlBody){
        cleanUp();
        initSpecPostMessage(sender, receiver, msg, msgTime );
        initResponseSpecPostMessage(sender, receiver, sendMsgResponseHtmlBody);
        defaultGetResponsePostSpec();
    }

    public void initSpecPostMessage(ChatTestUserBean sender, ChatTestUserBean receiver, String msg, long msgTime){
        testBaseUrl =  getBASE_PROFILE_URL() + chat_message;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setAccept("text/plain");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addCookie("CMus", sender.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", sender.getEtSidCookie());
        // create message
        String bodyJasonReqStr = chatApiPostMessage;
        bodyJasonReqStr = bodyJasonReqStr.replace("userIdReplaceWithDynamic", receiver.getUserId());
        bodyJasonReqStr = bodyJasonReqStr.replace("messageReplaceWithDynamic", msg);
        bodyJasonReqStr = bodyJasonReqStr.replace("timeReplaceWithDynamic", ""+System.currentTimeMillis());
        setBodyRequestSpecBuilder(bodyJasonReqStr);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     *
     * @param sender
     * @param receiver
     * @param sendMsgResponseHtmlBody    e.g "offline"
     */
    public void initResponseSpecPostMessage(ChatTestUserBean sender, ChatTestUserBean receiver, String sendMsgResponseHtmlBody){
        logger.info("Check Response User Id, status, body size ....!");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        // this return OK and sometimg offline ... so commenting out .. responseSpecBuilder.expectBody("html.body",  equalTo(sendMsgResponseHtmlBody));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     *  GET     /chat/2.0/message     Get latest contacts message User 1
     */
    public void chatApiGetLatestMessagesPerContacts(int howManyMsg, ChatTestUserBean chatUser, ChatTestUserBean... chatUserList){
        cleanUp();
        initSpecGetLatestMsgPerContacts(chatUser);
        initResponseGetLatestMsgPerContacts(howManyMsg, chatUserList);
        defaultGetResponseGetSpec();
    }

    public void initSpecGetLatestMsgPerContacts(ChatTestUserBean chatTestUserBean){
        testBaseUrl =  getBASE_PROFILE_URL() + chat_message;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setAccept("text/plain");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addCookie("CMus", chatTestUserBean.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatTestUserBean.getEtSidCookie());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    // TODO add contains string as param with if statement
    public void initResponseGetLatestMsgPerContacts(int howManyMsg, ChatTestUserBean... chatTestUserBeansList){
        logger.info("Check Response User Id, status, body size ....!");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);

        for(ChatTestUserBean user : chatTestUserBeansList) {
            responseSpecBuilder.expectBody("userID", hasItem(user.getUserId()));
            responseSpecBuilder.expectBody("message", not(isEmptyOrNullString()));
            //responseSpecBuilder.expectBody("message", containsString("latest"));
        }
        responseSpecBuilder.expectBody("size()", equalTo(howManyMsg) );

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * A client time ticks, when provided, return history chat messages before the specified time
     * GET
     /chat/2.0/message/{userID}/{since}     Get friend chat history messages
      * @param howManyMsg
     * @param chatUser
     * @param chatUserList
     */
       // todo as not used yet

    /**
     * GET
     /chat/2.0/status/{userIDs}
     Get chat user status of a list of users
     */
    public void chatApiGetUsersStatusList(ChatTestUserBean chatUser, ChatTestUserBean... chatUserList){
        cleanUp();
        initSpecGetUsersStatusList(chatUser, chatUserList);
        initResponseGetUsersStatusList(chatUserList);
        defaultGetResponseGetSpec();
    }

    public void initSpecGetUsersStatusList(ChatTestUserBean chatUser, ChatTestUserBean... chatUserList){
        String chatUserIds = "";
        int count = 0;
        for(ChatTestUserBean user : chatUserList){
            count++;
            //don't add comma for last id
            if(count == chatUserList.length){
                chatUserIds = chatUserIds+user.getUserId();
            }else
                chatUserIds = chatUserIds+user.getUserId()+",";
        }                                                                                                                //RequestSpecification spec = new RequestSpecBuilder().setUrlEncodingEnabled(false);

        testBaseUrl = getBASE_PROFILE_URL() +  chat_status+chatUserIds; //Note: url needs to be NOT encoded
        logger.info("testBaseUrl [{}]", testBaseUrl);
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setUrlEncodingEnabled(false);
        requestSpecBuilder.addCookie("CMus", chatUser.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatUser.getEtSidCookie());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetUsersStatusList(ChatTestUserBean ... chatUserList){
        logger.info("Check Response User Id, status, body size ....!");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        //get("/json").then().assertThat().body("records.any { it.containsKey('Phone') }", is(true)); get("/json").then().assertThat().body("any { it.key == 'size' }", is(true));

        for(ChatTestUserBean user : chatUserList) {
            responseSpecBuilder.expectBody(user.getUserId()+".status", equalTo(user.getChatUserStatus().getId()));
        }
        responseSpecBuilder.expectBody("size()", equalTo(chatUserList.length) );
        //responseSpecBuilder.expectBody("userID", hasItem(chatTestUserBean.getUserId()));

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * GET     /chat/2.0/status/     Get chat user status
     */
    public void chatApiGetUsersStatus(ChatTestUserBean chatUser){
        cleanUp();
        initSpecGetUsersStatus(chatUser);
        initResponseGetUsersStatus(chatUser);
        defaultGetResponseGetSpec();
    }

    public void initSpecGetUsersStatus(ChatTestUserBean chatUsers){
        testBaseUrl =  getBASE_PROFILE_URL() + chat_status;
        logger.info("testBaseUrl [{}]", testBaseUrl);
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        //requestSpecBuilder.setUrlEncodingEnabled(false);
        requestSpecBuilder.addCookie("CMus", chatUsers.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatUsers.getEtSidCookie());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetUsersStatus(ChatTestUserBean chatUser){
        logger.info("Check status, body size ....!");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("status", equalTo(chatUser.getChatUserStatus().getId()));
        //todo ... when you change the status this changes as well ....responseSpecBuilder.expectBody("defaultStatus", equalTo(1) );

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Set users status
     * new api https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat
     */
    public void chatApiPostSetUsersStatus(ChatTestUserBean chatUser){
        cleanUp();
        initSpecPostSetUsersStatus(chatUser);
        initResponseSetUsersStatus(chatUser);
        defaultPostSpec();
    }

    public void initSpecPostSetUsersStatus(ChatTestUserBean chatUsers){
        testBaseUrl =  getBASE_PROFILE_URL() + chat_status;
        logger.info("testBaseUrl [{}]", testBaseUrl);
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addCookie("CMus", chatUsers.getCmusCookie());
        requestSpecBuilder.addCookie("et_sid", chatUsers.getEtSidCookie());
        //set body
        String bodyJasonReqStr = chatApiPostStatus;
        bodyJasonReqStr = bodyJasonReqStr.replace("statusReplaceWithDynamic", ""+chatUsers.getChatUserStatus().getId());
        setBodyRequestSpecBuilder(bodyJasonReqStr);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSetUsersStatus(ChatTestUserBean chatUser){
        logger.info("Check status, body size ....!");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("html.body", equalTo("ok"));

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Search for users
     *
     * @param chatTestUserBean   ... user doing the search
     * @param bodySearch         ... query string
     * @param hitsTotal          ... minimum hits
     * @param checkProfileData   ... check user data
     */
    public void chatApiPostSearch(ChatTestUserBean chatTestUserBean, String bodySearch, int hitsTotal, boolean checkProfileData ){
        cleanUp();
        initSpecPostSearchFriend(chatTestUserBean, bodySearch);
        initResponsePostSearchFriend(hitsTotal, checkProfileData);
        defaultGetResponsePostSpec();
    }

    public void initSpecPostSearchFriend(ChatTestUserBean chatTestUserBean, String bodySearch){
        testBaseUrl = getBASE_PROFILE_URL()+ chat_search;
        if(isNewHouseLogin){
            //change urls to new house
            testBaseUrl = testBaseUrl.replace("api-legacy", "api");
            logger.info("Replaced URL as is new house [{}]", testBaseUrl);
        }
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setAccept("*/*");
        requestSpecBuilder.setContentType(ContentType.JSON);                                                            //requestSpecBuilder.addHeader("Content-Type", "application/json");        //requestSpecBuilder.addHeader("Referer", "https://qa-englishlive.ef.com/chat/friends/");

        if(isNewHouseLogin){
            //requestSpecBuilder.addHeader("Accept", "application/json");
            //requestSpecBuilder.addHeader("Content-Type", "application/json-patch+json");
            //requestSpecBuilder.addHeader("X-EF-EFID", studentBean.getUuid());
            requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
        } else {
            requestSpecBuilder.addHeader("X-ET-CMUS", chatTestUserBean.getCmusCookie());
            requestSpecBuilder.addHeader("X-ET-SID", chatTestUserBean.getEtSidCookie());
        }

        //bodySearch.replace("replaceID", currentSearchMemberId);
        setBodyRequestSpecBuilder(bodySearch);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponsePostSearchFriend(int hitsTotal, boolean checkProfileData  ){
        logger.info("Check Response ");
        responseSpecBuilder.expectStatusCode(expectedResponseCode);

        responseSpecBuilder.expectBody("hits.total", greaterThanOrEqualTo(hitsTotal) );

        if(hitsTotal == 0){
            responseSpecBuilder.expectBody("hits.max_score", equalTo(null) );
        }                                                                                                                   //else if(hitsTotal == 1) {responseSpecBuilder.expectBody("hits.hits._source.size()", equalTo(hitsTotal) );      }
        else {
            //random number  responseSpecBuilder.expectBody("hits.max_score", greaterThan(Float.valueOf(0)) );
            responseSpecBuilder.expectBody("hits.hits._source.size()", greaterThanOrEqualTo(hitsTotal) );                              //builder.expectBody("x.y.size()", is(2));
            //responseSpecBuilder.expectBody("hits.max_score", greaterThan(0) );
        }   // TO do create test object with exact data
        if(checkProfileData){
            //check hit profile data source  searchResultBean
            responseSpecBuilder.expectBody("hits.hits._index", hasItem(searchResultBean.getIndex()) );
            responseSpecBuilder.expectBody("hits.hits._type", hasItem(searchResultBean.getType()) );
            responseSpecBuilder.expectBody("hits.hits._id",  not(isEmptyOrNullString())) ;// hasItem(searchResultBean.getId()) );
            //random number  responseSpecBuilder.expectBody("hits.hits._score", greaterThan(Double.valueOf(searchResultBean.getScore())) );
            responseSpecBuilder.expectBody("hits.hits._source.given_name",  not(isEmptyOrNullString())); //hasItem(searchResultBean.hitSourceBean.getGiven_name()) );
            responseSpecBuilder.expectBody("hits.hits._source.family_name",  not(isEmptyOrNullString()));//hasItem(searchResultBean.hitSourceBean.getFamily_name()) );
            responseSpecBuilder.expectBody("hits.hits._source.identifier",  not(isEmptyOrNullString()) );//hasItem(searchResultBean.hitSourceBean.getIdentifier()) );
            responseSpecBuilder.expectBody("hits.hits._source.identifier_type", hasItem(searchResultBean.hitSourceBean.getIdentifier_type()) );
            responseSpecBuilder.expectBody("hits.hits._source.email", not(isEmptyOrNullString()) );  // hash searchResultBean.hitSourceBean.getEmail()
            responseSpecBuilder.expectBody("hits.hits._source.profile_privacy", hasItem(searchResultBean.hitSourceBean.getProfile_privacy()) );
            responseSpecBuilder.expectBody("hits.hits._source.chat_privacy", hasItem(searchResultBean.hitSourceBean.getChat_privacy()) );

            //qa shows uk not gb responseSpecBuilder.expectBody("hits.hits._source.country_code", hasItem(searchResultBean.hitSourceBean.getCountry_code()) );
            //  fail dif res live and QA Actual: [M]          responseSpecBuilder.expectBody("hits.hits._source.gender".toLowerCase(), hasItem(searchResultBean.hitSourceBean.getGender().getGender().toLowerCase()) );
            // responseSpecBuilder.expectBody("hits.hits._source.gender", hasItem(searchResultBean.hitSourceBean.getGender().getGender().toUpperCase()) );

            responseSpecBuilder.expectBody("hits.hits._source.english_level", hasItem(searchResultBean.hitSourceBean.getEnglish_level()) );
            responseSpecBuilder.expectBody("hits.hits._source.english_level_code", hasItem(searchResultBean.hitSourceBean.getEnglish_level_code()) );
            //responseSpecBuilder.expectBody("hits.hits._source.last_seen", equalTo(searchResultBean.hitSourceBean.getGender().getGender()) );


        }

        responseSpecification = responseSpecBuilder.build();
    }


    /*********************************************************************************************************
     *
     * Test data
     *
     */

    /**
     * Chat
     */
    public String chatApiPostFriendRequestBody = "{\n" +
            "         \"userID\": \"userIdReplaceWithDynamic\",\n" +
            "         \"action\": \"actionReplaceWithDynamic\" \n"+
            "     }";

    public void setDefaultChatApiPostFriedRequestBody(){
        chatApiPostFriendRequestBody = "{\n" +
                "         \"userID\": \"userIdReplaceWithDynamic\",\n" +
                "         \"action\": \"actionReplaceWithDynamic\" \n"+
                "     }";
    }

    public String chatApiPostMessage = "{\n" +
            "         \"userID\": userIdReplaceWithDynamic,\n" +
            "         \"message\": \"messageReplaceWithDynamic\",\n"+
            "         \"time\": timeReplaceWithDynamic\n"+             //42342342342
            "     }";

    public String chatApiPostStatus =   "{\n" +
                                        "         \"status\": statusReplaceWithDynamic\n"+
                                        "}";


    public String MIGRATE_CHAT_USER_SCRIPT = "curl -X POST \\\n" +
            "  http://qa.englishtown.com/chat/2.0/legacyfriend/replaceMeUserId/migrate \\\n" +
            "  -H 'X-EF-ACCESS: eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleXMvcHVibGljL2NoYXQvY2hhdC5wZW0ifQ.eyJpc3MiOiJjaGF0IiwiZXhwIjoxNTUzNjYwODg0LCJpYXQiOjE1MjIxMjQ4ODR9.eIh2fWNVAf_8l7EDs-DXMO5tjMmIz_DzJ6JfSls2dApQdCa_jqrAArrh4wROk3vjHR2zD5Ps3qVArcWEnAt4fKZL-Eeb4vBcHu4Qw0uMWu7EWQKGcz10q1cyQ1tKxmCLpn-9mb0nOwWPiGTcJ_uxvfcxq5izmR8bW5zcbVU8pFU' \\\n" +
            "  -H 'Content-Length: 0'";


    public String SEARCH_BY_NAME_EMAIL_EMPTY = "{\"query\":{\"query\":{\"bool\":{\"should\":[{\"match\":{\"given_name\"" +
            ":\"\"}},{\"match\":{\"family_name\":\"\"}},{\"match\":{\"given_name\":\"\"}},{\"match\":" +
            "{\"family_name\":\"\"}}]}}}}";

    public String SEARCH_BY_NAME = "{\"query\":{\"query\":{\"bool\":{\"should\":[{\"match\":{\"given_name\":\"auto\"}},{\"match\":{\"family_name\":\"auto\"}}]}}}}";
    public String SEARCH_BY_ID = "{\"query\":{\"query\":{\"bool\":{\"should\":[{\"match\":{\"identifier\":\"replaceID\"}}]}}}}";
    public String SEARCH_BY_EMAIL = "{\"query\":{\"query\":{\"bool\":{\"should\":[{\"match\":{\"email\":\""+searchByEmail+"\"}}]}}}}";

    public String SEARCH_BY_CRITERIA_GB = "{\"query\":{\"size\":21,\"query\":{\"function_score\":{\"query\":{\"bool\":{\"must\":[{\"match\":{\"country_code\":\"gb\"}}],\"mustNot\":[]}},\"functions\":[{\"random_score\":{\"seed\":\"17_b9490bfe6cf04bc5a46fd745e1c9d0c0\"}}],\"score_mode\":\"sum\"}}}}";


    /**
     * privacy setting
     */
    public String chatApiPutUserSettingRequestBody =    "{  \n" +
                                                        "   \"settings\":[  \n" +
                                                        "      {  \n" +
                                                        "         \"key\":\"keyReplaceWithDynamic\",\n" +
                                                        "         \"value\":\"valueReplaceWithDynamic\"\n" +
                                                        "      }\n" +
                                                        "   ]\n" +
                                                        "}";

    public void setDefaultChatApiPutUserSettingRequestBody(){
        chatApiPutUserSettingRequestBody =   "{\n" +
                                            "   \"settings\":[  \n" +
                                            "      {  \n" +
                                            "         \"key\":\"keyReplaceWithDynamic\",\n" +
                                            "         \"value\":\"valueReplaceWithDynamic\"\n" +
                                            "      }\n" +
                                            "   ]\n" +
                                            "}";
    }


}
