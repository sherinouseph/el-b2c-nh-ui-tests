package com.englishtown.tests.core.school.friends;
/**
 * CheckIf Main Friends outerframeworkis loaded and get started should be selected by default
 * click on get started close button, find new friends page should be present there and online only checkbox and everyone radio button should be
 *                 selected by default
 * Search all online users by entering all the filter values - check the results page- click on the card- check the profile value of the user is matches with the accoutn settings values of teh user
 * Search for the users in all the status after filtering through every fields and check results page
 * Click on the search by name or email tab and search by email-check result page and clik onc ard- check if profile values are pulled from accoutn setting spage
 * search by full name
 * search by partial name
 * search for the user whose profile viewable is set to friends. So our user shouldnt be able to see this particular user whose profile viewability is "FRIENDS"
 * Search in the filter tab and check if it returns multiple results
 * search by email and check if it returns multiple results
 *
 *  * Sherin 30/04/2018
 *
 *
*/

import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.beanandenum.GenderChatProfile;
import com.englishtown.newhouse.school.pages.friends.FindNewFriendsPage;

import com.englishtown.newhouse.school.pages.friends.FindNewFriendsResultPage;
import com.englishtown.newhouse.school.pages.friends.MyFriendDetailsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseFindNewFriendsSearchTest extends BaseFriendsChatTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseFindNewFriendsSearchTest.class);


    /**
     * Make user to appear online
     */
    /*@Test(dependsOnMethods ="gotoFriendsPageTest")
    protected void loginAndGoToFriendsPageUser2() {
        loginAndGoToFriendPage(testStartUrl, MyBrowserType.FIREFOX, searchByEmailId, "password");
    }*/

    @Test(dependsOnMethods ="gotoFriendsPageTest") //"loginAndGoToFriendsPageUser2")
    protected void searchUsingAllFiltersOnlineOnlyUsers() {
        logger.info("searchUsingAllFiltersOnlineOnlyUsers");
        closeGetStartedWindow(getWebDriver());
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        //findNewFriendsPage.onlineOnlycheckboxWe.isSelected();//by default online checkbox should be selected
        findNewFriendsPage.lookingForListWe.get(2).isSelected();//By default everyone should be seelcted
        findNewFriendsPage.filterThroughAllfields(englishLevel.getEnglishLevelcode(), genderChatProfile.getIndex(),"90","94", studentProfileDetails_FilterSearch.getLivingIn(), studentProfileDetails_FilterSearch.getNativeLanguage(), studentProfileDetails_FilterSearch.getIndustry());
        findNewFriendsPage.clickOnFindNewFriendsBtn_Search();
    }

    @Test(dependsOnMethods ="searchUsingAllFiltersOnlineOnlyUsers")
    protected void checkFindNewFriendsResultPageAndCheckProfileValues() {
        logger.info("checkFindNewFriendsResultPage");
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),25);
        findNewFriendsResultPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        findNewFriendsResultPage.contactModulePage.checkName(0,chatUserName_FilterSearchOnline);
        findNewFriendsResultPage.contactModulePage.clickOnCard(0);
        myFriendDetailsPage=new MyFriendDetailsPage(getWebDriver(),20);
        myFriendDetailsPage.profileModulePage.checkProfileActionsDisplayed();
        myFriendDetailsPage.profileModulePage.checkAllPageComponentsDisplayed();
        myFriendDetailsPage.profileModulePage.checkProfileSettingsValues(studentProfileDetails_FilterSearch.getEnglishLevel(), studentProfileDetails_FilterSearch.getGender(), studentProfileDetails_FilterSearch.getAge(), studentProfileDetails_FilterSearch.getLivingIn(), studentProfileDetails_FilterSearch.getNativeLanguage(), studentProfileDetails_FilterSearch.getIndustry(), studentProfileDetails_FilterSearch.getChatAccessibility());
        myFriendDetailsPage.profileModulePage.checkUserName(chatUserName_FilterSearchOnline);
        click(myFriendDetailsPage.backLinkWe);
    }

    @Test(dependsOnMethods ="checkFindNewFriendsResultPageAndCheckProfileValues")
    protected void clickOnEditSearchAndSearchUsingAllFilters_NOT_OnlineUsers() {
        logger.info("click On Edit Search");
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),25);
        findNewFriendsResultPage.clickOnEditLink();
        refresh(getWebDriver());//this is temporary as the developer is supposed to reset the search field when you click on edit
        genderChatProfile =GenderChatProfile.MALE;
        findNewFriendsPage.filterThroughAllfields(englishLevel.getEnglishLevelcode(), genderChatProfile.getIndex(),"95","100", studentProfileDetails_NOTOnlineUser.getLivingIn(), studentProfileDetails_NOTOnlineUser.getNativeLanguage(), studentProfileDetails_NOTOnlineUser.getIndustry());
        findNewFriendsPage.clickOnOnlineOnlycheckbox();
        findNewFriendsPage.clickOnFindNewFriendsBtn_Search();
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),25);
        findNewFriendsResultPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        findNewFriendsResultPage.contactModulePage.checkName(0,chatUserName_FilterSearchNOTOnline);
        findNewFriendsResultPage.contactModulePage.clickOnCard(0);
    }

    @Test(dependsOnMethods ="clickOnEditSearchAndSearchUsingAllFilters_NOT_OnlineUsers")
    protected void clickOnSearchNameOrEmailTabAndSearchByEmail() {
        logger.info("clickOnSearchNameOrEmailTabAndSearchByEmail");
        friendsPage.clickOnFindNewFriends();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage.searchByEmail(searchByEmailId);
        findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();

    }

    @Test(dependsOnMethods ="clickOnSearchNameOrEmailTabAndSearchByEmail")
    protected void checkResultsPageAndProfileValues_searchEmail() {
        logger.info("checkResultsPageAndProfileValues_searchEmail");
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),25);
        findNewFriendsResultPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        findNewFriendsResultPage.contactModulePage.checkName(0,chatUserName_SearchByNameOrEMail);
        findNewFriendsResultPage.contactModulePage.clickOnCard(0);
        myFriendDetailsPage=new MyFriendDetailsPage(getWebDriver(),20);
        myFriendDetailsPage.profileModulePage.checkProfileActionsDisplayed();
        myFriendDetailsPage.profileModulePage.checkAllPageComponentsDisplayed();
        myFriendDetailsPage.profileModulePage.checkProfileSettingsValues(studentProfileDetails_EmailNameSearch.getEnglishLevel(), studentProfileDetails_EmailNameSearch.getGender(), studentProfileDetails_EmailNameSearch.getAge(), studentProfileDetails_EmailNameSearch.getLivingIn(), studentProfileDetails_EmailNameSearch.getNativeLanguage(), studentProfileDetails_EmailNameSearch.getIndustry(), studentProfileDetails_EmailNameSearch.getChatAccessibility());
        myFriendDetailsPage.profileModulePage.checkUserName(chatUserName_SearchByNameOrEMail);
        click(myFriendDetailsPage.backLinkWe);
    }

    @Test(dependsOnMethods ="checkResultsPageAndProfileValues_searchEmail")
    protected void searchByNameAndCheckResults() {
        logger.info("cclickOnEditSearchAndSearchUsingName");
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),25);
        findNewFriendsResultPage.clickOnEditLink();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage.searchByEmail(chatUserName_SearchByNameOrEMail);
        findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),25);
        findNewFriendsResultPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        findNewFriendsResultPage.contactModulePage.checkName(0,chatUserName_SearchByNameOrEMail);
    }

    @Test(dependsOnMethods ="searchByNameAndCheckResults")
    protected void clickOnEditSearchAndSearchUsingPartialName() {
        logger.info("clickOnEditSearchAndSearchUsingPartialName");
        findNewFriendsResultPage.clickOnEditLink();
        findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage.searchByEmail(chatUserName_SearchByNameOrEMail.split(" ")[0]);
        findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();
        findNewFriendsResultPage.contactModulePage.checkAllTopicCardsElementsDisplayed(0);
        findNewFriendsResultPage.contactModulePage.checkName(0,chatUserName_SearchByNameOrEMail);
    }

    @Test(dependsOnMethods ="clickOnEditSearchAndSearchUsingPartialName")
    protected void searchForUser_ProfileViewableOnlyByFriends() {
        findNewFriendsResultPage.clickOnEditLink();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage.searchByEmail("testprofile_viewableonlybyfriends@qp1.org");
        findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),20);
        findNewFriendsResultPage.checkErrorMessageForNoMatchingResults();
        AssertHelper.assertWebElementDisplayed(findNewFriendsResultPage.editSearchLinkWe);

    }

    @Test(dependsOnMethods ="searchForUser_ProfileViewableOnlyByFriends")
    protected void checkIfSearchReturnMultipleValuesBySearchByName() {
        findNewFriendsResultPage.clickOnSearchnowBtn();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage.searchByName("test");
        findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();
        findNewFriendsResultPage=new FindNewFriendsResultPage(getWebDriver(),20);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),findNewFriendsResultPage.contactModulePage.contactListWe,5);

    }

    @Test(dependsOnMethods ="checkIfSearchReturnMultipleValuesBySearchByName")
    protected void checkIfSearchReturnMultipleValuesByFilterSearch() {
        findNewFriendsResultPage.clickOnEditLink();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        refresh(getWebDriver());//temp solution till they reset the search
        findNewFriendsPage.clickOnOnlineOnlycheckbox();
        findNewFriendsPage.clickOnFindNewFriendsBtn_Search();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),20);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),findNewFriendsResultPage.contactModulePage.contactListWe,5);
    }



}


