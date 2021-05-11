package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: sherin.ouseph
 * Date:20/05/2019
 *
 * 1. check page elements
 * 2. Turn of settings
 * 3. Check settings
 * 4.Turn on All settings
 * 5. Check Settings Values
 * 3. Clear cookies, logout and login ... check setting persisted
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.account.EmailAndNotificationPage;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseChangeEmailNotificationTest extends BaseEmailNotificationTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangeEmailNotificationTest.class);


    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
    public void turnOffAllSettings(){
        emailAndNotificationPage.clickOnTogglesToSetOff();
        refresh(getWebDriver());
        sleep(3000);
    }

    @Test (dependsOnMethods = "turnOffAllSettings")
    public void checkSettingsAllOff(){
        emailAndNotificationPage.assert_all_toggle_status(false);
    }

    /**
     * Now click to turn all settings ON ... green
     */
    @Test (dependsOnMethods = "checkSettingsAllOff")
    public void clickOnToggleToSetItOn(){
        emailAndNotificationPage.clickOnTogglesToSetOn();
    }

    @Test (dependsOnMethods = "clickOnToggleToSetItOn")
    public void checkSettingsAll_ON() {
        emailAndNotificationPage.assert_all_toggle_status(true);
    }

//    @Test(dependsOnMethods = { "checkSettingsAll_ON" })
//    public void logoutAndLoginTest() {
//        logger.info("Logout and Login");
//        logout(true);
//        loginEFIDPage(username, password, false);
//        //sleep(3000);
//    }
//
//    @Test (dependsOnMethods = "logoutAndLoginTest")
//    public void goToAndcheck_EmailSettingsPersisted_AfterRelogin() {
//        emailAndNotificationPage = new EmailAndNotificationPage(getWebDriver());
//        openPageUrl(emailAndNotificationPage);
//        sleep(1000);
////        myAccountPage = new MyAccountPage(getWebDriver(), 35);
////        myAccountPage.getPageLoadedCondition();
////        myAccountPage.goToEmailAndNotification();
//        emailAndNotificationPage = new EmailAndNotificationPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        emailAndNotificationPage.getPageLoadedCondition();
//        //emailAndNotificationPage.simpleTest();
//        emailAndNotificationPage.assert_all_toggle_status(true);
//    }

}