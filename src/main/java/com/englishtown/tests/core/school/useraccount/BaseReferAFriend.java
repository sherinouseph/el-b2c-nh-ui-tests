package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: Sherin
 * Date: 09/03/2018
 * Go to refer a friend->Email-
 *
 * 1. go to account setting my account page
 *
 */

import com.englishtown.newhouse.school.pages.ReferAFriendPage;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import com.englishtown.newhouse.school.pages.account.PersonalDetailsPage;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.bouncycastle.crypto.tls.ContentType.alert;


public abstract class BaseReferAFriend extends BaseSchoolHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseReferAFriend.class);


    @Test(dependsOnMethods = "checkMyPage")
    public void goToReferADriend() {
        logger.info("goToReferADriend");
        referAFriendPage = new ReferAFriendPage(getWebDriver());
        openPageUrl(referAFriendPage);
        referAFriendPage = new ReferAFriendPage(getWebDriver());
        referAFriendPage.simpleTest();
        referAFriendPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "goToReferADriend")
    public void checkFreqAskedquestions() {
        logger.info("checkFreqAskedquestions");
        referAFriendPage.assertFreqAskedQuestion();
    }

    @Test(dependsOnMethods = "checkFreqAskedquestions")
    public void referAFriendViaEmail() {
        logger.info("referAFriendViaEmail");
        referAFriendPage.checkAllEmailProviderIconsArePresent();
        referAFriendPage.referFriend_email();

    }

    @Test(dependsOnMethods = "referAFriendViaEmail")
    public void verifyReferals_email() {
        logger.info("verifyReferals_email");
        referAFriendPage.referFriend_email();
        referAFriendPage.verifyYourReferrals("Pending");

    }
}