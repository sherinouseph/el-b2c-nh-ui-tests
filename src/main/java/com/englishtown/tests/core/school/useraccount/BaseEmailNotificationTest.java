package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: nikol.marku
 * Date: 23/10/18
 *
 * 1. check page elements
 * 2. check page content [email, and all toggles status ]
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.account.EmailAndNotificationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseEmailNotificationTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseEmailNotificationTest.class);


    @Test (dependsOnMethods = "goToMyAccountPage")
    public void goToEmailNotificationPageFromAccountPageSubNav(){
        myAccountPage.goToEmailAndNotification();
        emailAndNotificationPage = new EmailAndNotificationPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        emailAndNotificationPage.getPageLoadedCondition();
        emailAndNotificationPage.simpleTest();
    }


}

