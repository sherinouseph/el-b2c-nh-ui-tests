package com.englishtown.tests.core.school.friends;
/**
 * Base Friends Test
 * click on my friends page
 * Check the friend list
 * Click on that friend card
 * check the profile values of Friend
 * check the mutual friend list
 * click on mutual friend
 * check if it is going to profile of that mutual friend
 *
 * My Profile Test:
 * Test my profile setting values
 * Check username
 * Click on update profile settings and check if it is navigated to accoutn settings page
 *
 * 
 *

 * Sherin 02/05/2018
 *
 *
*/


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.beanandenum.StudentProfileDetails;
import com.englishtown.newhouse.school.pages.friends.MyFriendDetailsPage;
import com.englishtown.newhouse.school.pages.friends.MyFriendsPage;
import com.englishtown.newhouse.school.pages.friends.MyProfilePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseMyFriendsAndMyProfileTest extends BaseFriendsChatTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseMyFriendsAndMyProfileTest.class);
    protected String friendUserName;
    protected String mutualFriendUserName;
    protected StudentProfileDetails friendProfileDetails;

    @Test(dependsOnMethods ="gotoFriendsPageTest")
    protected void clickOnMyFriendsAndCheckFriendsResultPage() {
        logger.info("clickOnMyFriendsAndCheckFriendsPage");
        initGetStartedPage(getWebDriver());
        getStartedPage.clickOncloseBtn();
        friendsPage.clickOnMyFriends();
        myFriendsPage = new MyFriendsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        myFriendsPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        myFriendsPage.contactModulePage.checkName(0,friendUserName);
    }

    @Test(dependsOnMethods ="clickOnMyFriendsAndCheckFriendsResultPage")
    protected void clickOnFriendCardAndcheckProfileValues() {
        logger.info("clickOnFriendCardAndcheckProfileValues");
        myFriendsPage = new MyFriendsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        myFriendsPage.contactModulePage.clickOnCard(0);
        myFriendDetailsPage=new MyFriendDetailsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myFriendDetailsPage.simpleTest();
        myFriendDetailsPage.profileModulePage.checkAllPageComponentsDisplayed();
        myFriendDetailsPage.profileModulePage.checkProfileActionsDisplayed();
        myFriendDetailsPage.profileModulePage.checkProfileSettingsValues(friendProfileDetails.getEnglishLevel(), friendProfileDetails.getGender(), friendProfileDetails.getAge(), friendProfileDetails.getLivingIn(), friendProfileDetails.getNativeLanguage(), friendProfileDetails.getIndustry(), friendProfileDetails.getChatAccessibility());

    }

    @Test(dependsOnMethods ="clickOnFriendCardAndcheckProfileValues")
    protected void checkMutualFriendSection() {
        logger.info("checkMutualFriendSection");
        AssertHelper.assertWebElementDisplayed(myFriendDetailsPage.mutualFriendsWe);
        myFriendDetailsPage.checkMinimumNumberOfMutualFriendsShown(1);
        myFriendDetailsPage.checkUserFirstNameOnMutualFriendsSectionHeading(friendUserName.split(" ")[0]);
        myFriendDetailsPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        myFriendDetailsPage.contactModulePage.checkName(0,mutualFriendUserName.split(" ")[0]);
        myFriendDetailsPage.contactModulePage.clickOnCard(0);
        myFriendDetailsPage.profileModulePage.simpleTest();

    }

    @Test(dependsOnMethods ="checkMutualFriendSection")
    protected void goToMyProfile() {
        logger.info("goToMyProfile");
        friendsPage.clickOnMyProfile();
        myProfilePage = new MyProfilePage(getWebDriver(),25);
        myProfilePage.simpleTest();
        myProfilePage.checkAllPageComponentsDisplayed();

    }

    @Test(dependsOnMethods ="goToMyProfile")
    protected void assertProfileValues() {
        logger.info("clickOnMyProfileAndcheckMyProfilePage");
        myProfilePage.profileModulePage.checkAllPageComponentsDisplayed();
        myProfilePage.profileModulePage.checkProfileSettingsValues(studentProfileDetails.getEnglishLevel(), studentProfileDetails.getGender(), studentProfileDetails.getAge(), studentProfileDetails.getLivingIn(), studentProfileDetails.getNativeLanguage(), studentProfileDetails.getIndustry(), studentProfileDetails.getChatAccessibility());
        myProfilePage.profileModulePage.checkUserName(myProfileUserName);

    }

    @Test(dependsOnMethods = "assertProfileValues")
    protected void clickOnUpdateProfileSettings() {
        logger.info("clickOnUpdateProfileSettings");
        myProfilePage.clickOnUpdateProfileSettings();
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"customerservice/personaldetails","User not in profile settings page");
    }






}


