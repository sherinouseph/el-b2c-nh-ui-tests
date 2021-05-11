//package com.englishtown.tests.core.school.useraccount;
///**
// *
// * User: nikol.marku
// * Date: 24/10/18
// * updated to OH sept 2019
// *
// *  1. Change Privacy setting
// *  2. Validate Setting changed
// *  3. Check My Profile page shows the changes
// *  4. Check Your Account page shows changes
// *  5. ..
// *
// *  *      TODO : Logout and login ... see changes persisted
// *                  on chat profile check status_3fv_L online_3rCmb
// *  *             Login as another user and make sure chat shows the status as expected
// *  Note: appear busy option not test ... out of scope ...
// */
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.newhouse.school.beanandenum.enums.PrivacySetting;
//import com.englishtown.newhouse.school.pages.account.PrivacySettingPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
//
//
//public abstract class BaseChangePrivacySettingsTest extends BasePrivacySettingsTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseChangePrivacySettingsTest.class);
//
//    //setUserProfileStatus(String env, String bearer, ChatUserStatus chatUserStatus, int expectedResponseCode)
//    @Test (dependsOnMethods = "goToPrivacySetting")
//    public void setupUserPrivacySetting(){
//        privacySettingPage.setToggle(true);
//        //privacySettingPage.changePrivacySetting(ProfilePrivacySettingKey.,privacySettingPage.canProfileViewableByEveryoneSelectWe );
//        // api call to set the setting to first options of UI [online, everyone, everyone]
//        /*StaticBaseApiSpec.setUserProfilePrivacySetting(getENVIRONMENT(), uuid, ProfilePrivacySettingKey.CHAT_STATUS_1, 201);
//        StaticBaseApiSpec.setUserProfilePrivacySetting(getENVIRONMENT(), uuid, ProfilePrivacySettingKey.PROFILE_PRIVACY_PULIC, 201);
//        StaticBaseApiSpec.setUserProfilePrivacySetting(getENVIRONMENT(), uuid, ProfilePrivacySettingKey.CHAT_PRIVACY_PUBLIC, 201);
//        sleep(300);*/
//        refresh(getWebDriver());
//        sleep(3000);
//    }
//
//    /**
//     * Validate api changed the UI
//     */
//    @Test (dependsOnMethods = "setupUserPrivacySetting")
//    public void checkPrivacySettingsAreOnlineAndEveryone_AsSetViaApiCall(){
//        privacySettingPage = new PrivacySettingPage(getWebDriver(), WaitTool.SHORT_WAIT_4_ELEMENT);
//        privacySettingPage.simpleTest();
//        String currentSetting = getText(
//                WebElementHelper.getSelectedOptionWe(privacySettingPage.canProfileViewableByEveryoneSelectWe));
//        AssertHelper.assertThat("Not the expected status ...!", currentSetting,
//                containsIgnoringCase(PrivacySetting.EN_PROFILE_VIEWABLE_EVERYONE.getDes()) );
//
//
//        currentSetting = getText(
//                WebElementHelper.getSelectedOptionWe(privacySettingPage.canReceiveMessageFromEveryoneSelectWe));
//        AssertHelper.assertThat("Not the expected status ...!", currentSetting,
//                containsIgnoringCase(PrivacySetting.EN_CHAT_ACCESS_EVERYONE.getDes()) );
//
//        /*assertWebElementTextEqualsTo(privacySettingPage.canProfileViewableByEveryoneSelectWe, PrivacySetting.EN_PROFILE_VIEWABLE_EVERYONE.getDes());   //"Everyone");
//        assertWebElementTextEqualsTo(privacySettingPage.canEveryoneSeeMyUpdatesSelectWe, PrivacySetting.EN_APPEAR_ONLINE_TRUE.getDes());         //"Appear Online");
//        assertWebElementTextEqualsTo(privacySettingPage.canPhotoViewableByEveryoneSelectWe, PrivacySetting.EN_APPEAR_ONLINE_TRUE.getDes());         //"Appear Online");
//        assertWebElementTextEqualsTo(privacySettingPage.canReceiveMessageFromEveryoneSelectWe, PrivacySetting.EN_CHAT_ACCESS_EVERYONE.getDes());          //"Everyone");*/
//    }
//
//    /**
//     * get status , viewable, chat access
//     */
//    @Test (dependsOnMethods = "checkPrivacySettingsAreOnlineAndEveryone_AsSetViaApiCall")
//    public void getCurrentSettings(){
//        /* Todo studentProfileSettingBean.setAllPrivacySetting(
//                PrivacySetting.getFromDesString(TestUtil.getWebElementText(privacySettingPage.displayProfileStatusSelectWe)),
//                PrivacySetting.getFromDesString(TestUtil.getWebElementText(privacySettingPage.myProfileViewableBySelectWe)),
//                PrivacySetting.getFromDesString(TestUtil.getWebElementText(privacySettingPage.chatAccessibilitySelectWe))
//                );
//        studentProfileSettingBean.setShowAsOnlineByDefault(studentProfileSettingBean.getProfileStatus().getStatus());
//        studentProfileSettingBean.setProfileViewableByEveryone(studentProfileSettingBean.getProfileViewableBy().getStatus());
//        studentProfileSettingBean.setReceiveMessageFromEveryone(studentProfileSettingBean.getProfileChatAccessContact().getStatus());
//
//        logger.info("GetCurrentSettings > " + studentProfileSettingBean.toString());*/
//    }
//
//    /**
//     * Change Settings
//     */
//    @Test (dependsOnMethods = "getCurrentSettings")
//    public void changeProfileStatusToOffline(){
//        logger.info("changeProfileStatus to offline ...!");
//        privacySettingPage.setToggle(false);
//        logger.info("changed ...!");
//    }
//
//    /*@Test (dependsOnMethods = "getCurrentSettings")
//    public void changeProfileViewableByToOnlyFriends(){
//        logger.info("changeProfileViewableByToOnlyFriends ...!");
//        privacySettingPage.changePrivacySetting(PrivacySetting.EN_PROFILE_VIEWABLE_ONLY_FRIENDS.getDes(), privacySettingPage.canProfileViewableByEveryoneSelectWe);
//        logger.info("changed ...!");
//    }*/
//
//   /* @Test (dependsOnMethods = "getCurrentSettings")
//    public void changeChatAccessibilityToOnlyFriends(){
//        logger.info("changeChatAccessibilityToOnlyFriends ...!");
//        privacySettingPage.changePrivacySetting(PrivacySetting.EN_CHAT_ACCESS_ONLY_FRIENDS.getDes(), privacySettingPage.canReceiveMessageFromEveryoneSelectWe);
//        logger.info("changed ...!");
//    }*/
//
//    /*@Test (dependsOnMethods = "changeProfileViewableByToOnlyFriends")
//    public void checkPrivacySettingsAreOfflineAndFriendsOnly(){
//        sleep(1000);
//        privacySettingPage = new PrivacySettingPage(getWebDriver(), WaitTool.SHORT_WAIT_4_ELEMENT);
//        privacySettingPage.simpleTest();
//        assertWebElementTextEqualsTo(privacySettingPage.profileSettingToggleList.get(2), PrivacySetting.EN_APPEAR_OFFLINE_FALSE.getDes());
//        assertWebElementTextEqualsTo(privacySettingPage.canProfileViewableByEveryoneSelectWe, PrivacySetting.EN_PROFILE_VIEWABLE_ONLY_FRIENDS.getDes());
//        assertWebElementTextEqualsTo(privacySettingPage.canReceiveMessageFromEveryoneSelectWe, PrivacySetting.EN_CHAT_ACCESS_ONLY_FRIENDS.getDes());
//    }*/
//
//    /**
//     * Check my account page profile settings
//     *
//    @Test (dependsOnMethods = "checkPrivacySettingsAreOfflineAndFriendsOnly")
//    public void goToYourAccountPage(){
//        privacySettingPage.goToYourAccount();
//        initMyAccountPage();
//        myAccountPage.getPageLoadedCondition();
//        myAccountPage.simpleTest();
//    }
//
//    @Test (dependsOnMethods = "goToYourAccountPage")
//    public void profileIsShowAsOfflineTest(){
//        //myAccountPage.checkWebElementSetting(MyAccountPage.IsShowAsOnlineByDefault, false);//studentProfileSettingBean.isShowAsOnlineByDefault());
//       // myAccountPage.isPrivacySetting(MyAccountPage.IsShowAsOnlineByDefault, false);//studentProfileSettingBean.isShowAsOnlineByDefault());
//    }
//
//    //My profile viewable by everyone
//    @Test (dependsOnMethods = "goToYourAccountPage")
//    public void profileViewableByEveryoneViewableTest(){
//        //myAccountPage.checkWebElementSetting(MyAccountPage.CanProfileViewableByEveryone, false);
//    }
//
//    //My live chat accessibility by everyone
//    @Test (dependsOnMethods = "goToYourAccountPage")
//    public void profileCanReceiveMessageFromEveryoneTest(){
//        //myAccountPage.checkWebElementSetting( MyAccountPage.CanReceiveMessageFromEveryone, false);
//    }
//
//    @Test (dependsOnMethods = "profileViewableByEveryoneViewableTest")
//    public void goToYourProfilePage(){
//        myAccountPage.goToYourProfile();
//
//        personalDetailsPage = new PersonalDetailsPage(getWebDriver(), 25);
//        personalDetailsPage.getPageLoadedCondition();
//        personalDetailsPage.simpleTest();
//    }
//
//    @Test (dependsOnMethods = "goToYourProfilePage")
//    public void checkPrivacySettingViewAndChat(){
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(personalDetailsPage.canProfileViewableByEveryoneSelectWe), //.canProfileViewableByEveryoneWe),
//                PrivacySetting.EN_PROFILE_VIEWABLE_ONLY_FRIENDS.getDes(),"Should Be only friends");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(personalDetailsPage.canReceiveMessageFromEveryoneSelectWe),
//                PrivacySetting.EN_CHAT_ACCESS_ONLY_FRIENDS.getDes(),"Should Be only friends");
//    }
//    */
//
//}
//
