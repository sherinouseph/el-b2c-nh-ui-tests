//package com.englishtown.tests.core.school.useraccount;
///**
// *
// * User: nikol.marku
// * Date: 26/10/18
// *
// * 1. Go to Privacy setting using account page navigation
// *
// *
// */
//
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.newhouse.school.pages.account.PrivacySettingPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//
//public abstract class BasePrivacySettingsTest extends BaseAccountSettingsTest {
//    private static final Logger logger = LoggerFactory.getLogger(BasePrivacySettingsTest.class);
//
//
//    @Test(dependsOnMethods = "goToMyAccountPage")
//    public void goToPrivacySetting(){
//        click(myAccountPage.updatePrivacySettingLinkWe);
//        privacySettingPage = new PrivacySettingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT); //openPageUrl(privacySettingPage);
//        privacySettingPage.getPageLoadedCondition();
//        privacySettingPage.simpleTest();
//    }
//
//
//}
//
