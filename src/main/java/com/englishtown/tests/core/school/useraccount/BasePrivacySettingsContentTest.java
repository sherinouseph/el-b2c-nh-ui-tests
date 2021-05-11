//package com.englishtown.tests.core.school.useraccount;
///**
// *
// * User: nikol.marku
// * Date: 24/10/18
// *
// * 1. check page elements
// * 2. check page content settings[ ]
// *
// *
// */
//
//import com.englishtown.helpers.AssertHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
//
//
//public abstract class BasePrivacySettingsContentTest extends BasePrivacySettingsTest {
//    private static final Logger logger = LoggerFactory.getLogger(BasePrivacySettingsContentTest.class);
//
//
//    /*@Test (dependsOnMethods = "goToMyAccountPage")
//    public void goToPrivacySetting(){
//        myAccountPage.goToPrivacySetting();
//        privacySettingPage = new PrivacySettingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        privacySettingPage.getPageLoadedCondition();
//        privacySettingPage.simpleTest();
//    }*/
//
//    @Test (dependsOnMethods = "goToPrivacySetting")
//    public void checkPrivacySettingPageComponentsDisplayed(){
//        privacySettingPage.checkAllPageComponentsDisplayed();
//    }
//
//    /**
//     * Profile public preferences
//     * isShowAsOnlineByDefault;  isProfileViewableByEveryone;   isReceiveMessageFromEveryone;
//     */
//    /* TODO this needs to be translated as translation is     Expected :Çevrim İçi Görün Actual   :Online Görün
//    @Test (dependsOnMethods = "goToPrivacySetting")
//    public void checkDisplayProfile(){
//        assertWebElementTextEqualsTo(privacySettingPage.displayProfileStatusSelectWe, displayProfileStatus);
//    }*/
//
//    @Test (dependsOnMethods = "goToPrivacySetting")
//    public void checkProfileViewableBy(){
//        String selectedOption  = getSelectedOption(privacySettingPage.canProfileViewableByEveryoneSelectWe);
//        AssertHelper.assertThat("Profile viewable is not the expected one ...!",
//                selectedOption, containsIgnoringCase(profileViewableByStatus));
//    }
//
//    @Test (dependsOnMethods = "goToPrivacySetting")
//    public void checkChatAccessibilityBy(){
//        String selectedOption  = getSelectedOption(privacySettingPage.canReceiveMessageFromEveryoneSelectWe);
//        AssertHelper.assertThat("Chat accessibility can receive message Setting is not the expected one ...!",
//                selectedOption, containsIgnoringCase(chatAccessibilityStatus));
//    }
//
//
//}
//
