//package com.englishlive.tests.newhouse.apitest.chat;
///**
// * Nikol Apr 2018
// * Chat test
// * Swager https://logloader.englishtown.com/docs/chat/#/
// *
// * Test Steps:
// *  User login get cookies and do search BY[*] check response
// * 1. Get user cookies
// * 2. Search by Email (one result)
// * 4. Search by ID (one result)
// * 5. Search by Name First and last name .. many results
// * 6. Search by  Name First and last name empty .. NO results
// * 7. Search by criteria Country Code [uk]
// *     // TODO : search form [beginners, uk, everyone [male, female]]  currently not working ad user level is not in DB
// * // auto_18653838045674000_FNOLFLA143223083_xdelx@qp1.org create on staging
// *
// * For new house search url is https://qa-  englishlive.ef.com /1/shared/api/chat-profile/v1/_search
// * old house serch url         https://qa-  englishlive.ef.com /1/shared/api-legacy/chat-profile/v1/_search
// */
//
////todo : create FR chat user on QA and live then open the test for it
//
//import com.englishtown.enumpack.Gender;
//import com.englishtown.enumpack.chat.ChatUserStatus;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
//import com.englishtown.newhouse.apicore.chat.BaseChatSpecSuite;
//import com.englishtown.newhouse.school.beanandenum.bean.chat.ChatFriendsSearchResultBean;
//import com.englishtown.newhouse.school.beanandenum.bean.chat.HitSourceBean;
//import com.englishtown.tests.core.EfConstants;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
//
//public class FRChatFriendSearchTest extends BaseChatSpecSuite {
//    public static final Logger logger = LoggerFactory.getLogger(FRChatFriendSearchTest.class);
//
//
//    @BeforeClass
//    protected void setupCreateUsersBeforeClass(){
//        logger.info("@setupCreateUsersBeforeClass ...!  - ");
//        cancelSubscription = false;
//        setGridEnvironmentFromDargs();
//        setupTestUser();
//    }
//
//    /**
//     * Call login handler
//     * New house GET  https://qa-englishlive.ef.com/1/api/commerce-gateway/member/use-old-login-handler?Email=auto_chat_search%40qp1.org
//     * Old house POST https://qa-englishlive.ef.com/login/handler.ashx
//     * and set the cookies cmus et_sid
//     *
//     */
//    @Test
//    protected void getUserCookies(){
//        chatApiGetUserCookies(chatTestUserBean1, CHAT_USER_PASS);
//        chatTestUserBean1.setCmusCookie(response.cookie("CMus"));
//        chatTestUserBean1.setEtSidCookie(response.cookie("et_sid"));
//        logger.info("added cmus and et_sid ...!\n"+chatTestUserBean1.toString()+"\n ---------------\n");
//    }
//
//    // TOdo empty search
//    /**
//     *
//     */
//    @Test(dependsOnMethods = "getUserCookies")
//    protected void searchByNameOrEmail_Empty(){
//        chatApiPostSearch( chatTestUserBean1, SEARCH_BY_NAME_EMAIL_EMPTY, 0, false);
//    }
//
//    @Test(dependsOnMethods = "getUserCookies")
//    protected void searchByNameManyResults(){
//        chatApiPostSearch( chatTestUserBean1, SEARCH_BY_NAME, 3, false);
//    }
//
//    @Test(dependsOnMethods = "getUserCookies")
//    protected void searchByIdOneResults(){
//        chatApiPostSearch( chatTestUserBean1, SEARCH_BY_ID, 1, true);
//    }
//
//    @Test(dependsOnMethods = "getUserCookies")
//    protected void searchByEmailOneResults(){
//        chatApiPostSearch( chatTestUserBean1, SEARCH_BY_EMAIL, 1, true);
//    }
//
//    @Test(dependsOnMethods = "getUserCookies")
//    protected void searchByCriteriaManyResults_CountryCode_GB(){
//        chatApiPostSearch( chatTestUserBean1, SEARCH_BY_CRITERIA_GB, 21, false);
//    }
//
//    @Override
//    public void setupTestBeanDataAndSpec(){}
//
//    protected void setupTestUser(){
//        logger.info("setupTestUser " );
//        chatTestUserBean1 = new ChatTestUserBean(CHAT_USER_SEARCH, "");
//        chatTestUserBean1.setIncoming(false);
//        chatTestUserBean1.setChatUserStatus(ChatUserStatus.ONLINE);
//        logger.info("added cmus and et_sid ...!\n"+chatTestUserBean1.toString()+"\n ---------------\n");
//        //
//        /**
//         * (given_name, family_name, identifier,  identifier_type,  Gender gender,  country_code,  email,  profile_privacy,  chat_privacy,
//         english_level,  english_level_code)          */
//        if(StringUtils.containsIgnoreCase(getBASE_PROFILE_URL(), "stg-" )){
//            // todo refactor and get the id per INV
//            currentSearchMemberId = searchMemberId_stg; // todo refactor and get the id per INV
//        }else if(StringUtils.containsIgnoreCase(getBASE_PROFILE_URL(), "qa-" )) {
//            currentSearchMemberId = searchMemberId_qa;
//        }else
//            currentSearchMemberId = searchMemberId;
//
//
//        SEARCH_BY_ID = SEARCH_BY_ID.replace("replaceID", currentSearchMemberId);
//
//        hitSourceBean = new HitSourceBean("testing", "AutoLastName", currentSearchMemberId,
//                "member", Gender.MALE,"gb",
//                "08533dbc92664bf5af890306e39bc391c1982e1b9dcbf900caa542241d620f21", "public",
//                "public", "Beginner", "0"
//                );
//        //(int hitsTotal, String maxScore, String index, String type, String id, String score, HitSourceBean hitSourceBean)
//        searchResultBean = new ChatFriendsSearchResultBean(1, "9.66413", "chat_profile",
//                "profile", "member:"+currentSearchMemberId, "9.66413", hitSourceBean);        // searchResultBean.setIndex("chat_profile"); searchResultBean.setType("profile"); searchResultBean.setId("member:11403328");  searchResultBean.setMaxScore("9.650958");        searchResultBean.setScore("9.650958");        searchResultBean.setHitsTotal(1);
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        logger.info("@ After Class ...!");
//        //cancelSubscription(chatTestUserBean1.getUserName());
//        destroyDriver();
//    }
//
//    /**
//     * get a map with random first name and last name
//     * @return
//     */
//    public Map getMemberFormMap(){
//        String fName = TestUtil.generateRandomString("BtoC", 7);
//        String lName = TestUtil.generateRandomString("BtoC", 6);
//        Map<String, String> memberFormMap = EfConstants.MEMBER_FORM_FLP;
//        memberFormMap.replace("firstname", fName );
//        memberFormMap.replace("lastname", lName);
//
//        return memberFormMap;
//    }
//
//
//
//}
//
//
///***
// searchResultBean = "hits": [
//                             {
//                             "_index": "chat_profile",
//                             "_type": "profile",
//                             "_id": "member:11403328",
//                             "_score": 9.650958,
//                             "_source": {
//                             "given_name": "auto",
//                             "family_name": "iris",
//                             "identifier": "11403328",
//                             "identifier_type": "member",
//                             "gender": "U",
//                             "country_code": "un",
//                             "email": "4232e868e575c4624dd33bf72d6ea6e32dccf4fc02a83d243c2c02340c30d850",
//                             "profile_privacy": "public",
//                             "chat_privacy": "public",
//                             "update_timestamps": {
//                             "member/created": 1524105912633,
//                             "member/updated": 1524105927725
//                             },
//                             "english_level": "Elementary",
//                             "english_level_code": "2"
//                             }
//                             }
//                            ]
//
//
//
// MemberId	UserName	FirstName	LastName	Country	Email
// 11417984	BBtoCLPSRQD	BtoCXOYXUJC	BtoCLPSRQD	gb	auto_18653838045674000_FNOLFLA143223083_xdelx@qp1.org    used for search
// 11417982	BBtoCEHFRVB	BtoCTEUEJDN	BtoCEHFRVB	gb	auto_18653768393875000_TTAUPAD502772360_xdelx@qp1.org
// 11417979	BBtoCSJMNKG	BtoCKVUFXHJ	BtoCSJMNKG	gb	auto_246148295057416_YLTHHWJ429751427_xdelx@qp1.org
// 11417978	BBtoCFNLYJE	BtoCMMZBNTX	BtoCFNLYJE	gb	auto_246043372213914_CJKJSGI417645429_xdelx@qp1.org
// 11417976	BBtoCFNDWDZ	BtoCPXTZBXA	BtoCFNDWDZ	gb	auto_245887947297820_TMAEXGA942027319_xdelx@qp1.org
// 11417970	BBtoCCBEKYK	BtoCFJDZWVI	BtoCCBEKYK	gb	auto_244990508360654_XGSEIMT422817955_xdelx@qp1.org
// 11417968	BBtoCXESLGR	BtoCOHIVLRZ	BtoCXESLGR	gb	auto_244949068424343_EQNKESN165896491_xdelx@qp1.org
// 11417962	BBtoCPMLFXI	BtoCDENOLIJ	BtoCPMLFXI	gb	auto_244906756004806_BCGCORO665596236_xdelx@qp1.org
// 11417896	BBtoCQFLVSQ	BtoCPDVCGXR	BtoCQFLVSQ	gb	auto_188459633372201_ZVJZGKS40348700_xdelx@qp1.org
// 11417895	BBtoCMIBSBE	BtoCTSOSRGY	BtoCMIBSBE	gb	auto_188366985263149_AAGDVKG397503230_xdelx@qp1.org
//
//
// ****/