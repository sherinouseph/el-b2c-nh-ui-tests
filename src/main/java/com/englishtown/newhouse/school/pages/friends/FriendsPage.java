package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin
 *This is the base page for all the Friends chat pages.
 * All the selectors and functions for the outerframe(TOP and LEFT BLACK) are included here
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.friends.module.ContactModulePage;
import com.englishtown.newhouse.school.pages.friends.module.ProfileModulePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;


public class FriendsPage extends BaseSchoolPage {

    public ProfileModulePage profileModulePage;
    public ContactModulePage contactModulePage;


    public static final Logger logger = LoggerFactory.getLogger(FriendsPage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/search/advanced"; //"/chat/friends/#/?hideTeaser=true";    // course-> my course

    public static final String PENDING_REQUEST_BASE_CSS = "div[class^='pendings_']";
    public static final String RECENT_CHAT_BASE_CSS     = "div[class^='recents']";
    public static final String SEARCH_FRIENDS_BASE_CSS  ="div[class^='result']";

    public static final String HEADING_CSS  =  " [class^='contact-list-heading_']";

    public static final String PROFILEPIC_CSS =  " [class^='avatar_']";
    public static final String DATE_CSS       =  " [class^='time']";
    public static final String STATUS_CSS     =  " [class^='request_']";
    public static final String FLAG_CSS       =  " [class^='flag_']";
    public static final String NAME_CSS       =  " [class^='name_']";
    public static final String SEARCHFRIENDS_RESULTS_HEADING_CSS  = " [class^='result-heading_']";
    public static final String PENDING_REQUEST_HEADING_CSS =  PENDING_REQUEST_BASE_CSS+HEADING_CSS;


    private static final String OPENBRACES_DELIMITER = "\\(";

    @FindBy(css = "[class^='input-field_")//._33p6kv3Lzo
    public List<WebElement> searchFriendsTextAreaWe;

    @FindBy(css = "[class^='greeting_']")
    public WebElement welcomeTxtWe;

    @FindBy(css = "[class^='get-started_']")
    public WebElement getStartedWe;

    @FindBy(css = "[class^='logo-link_']") //a.dispatchEvent(new MouseEvent('click'))
    public WebElement welcomeIconWe;

    @FindBy(css ="a[class^='text-link_']")
    public List<WebElement> chatSideMenusWe;

    //pending friend request
    @FindBy(css = PENDING_REQUEST_HEADING_CSS) //PENDING_REQUEST_BASE_CSS+HEADING_CSS)
    public WebElement pendingFriendReqTitleWe;

    @FindBy(css = PENDING_REQUEST_BASE_CSS+PROFILEPIC_CSS)
    public List<WebElement> pendingFriendReqProfilePicWe;

    @FindBy(css = PENDING_REQUEST_BASE_CSS+NAME_CSS)
    public List<WebElement> pendingFriendReqUserNameWe;

    @FindBy(css = PENDING_REQUEST_BASE_CSS+FLAG_CSS)
    public List<WebElement> pendingFriendReqFlagWe;

    @FindBy(css =PENDING_REQUEST_BASE_CSS+STATUS_CSS)
    public List<WebElement> pendingFriendReqStatusWe;


    //recent chat
    @FindBy(css = RECENT_CHAT_BASE_CSS+HEADING_CSS)
    public WebElement recentChatTitleWe;



    @FindBy(css =RECENT_CHAT_BASE_CSS+PROFILEPIC_CSS)
    public List<WebElement> recentChatProfilePicWe;

    @FindBy(css = RECENT_CHAT_BASE_CSS+NAME_CSS)
    public List<WebElement> recentChatUserNameWe;

    @FindBy(css =RECENT_CHAT_BASE_CSS+FLAG_CSS)
    public List<WebElement> recentChatFlagWe;

    @FindBy(css = RECENT_CHAT_BASE_CSS+DATE_CSS)
    public List<WebElement> recentChatDateWe;


    //search friends and recent chat

    @FindBy(css = SEARCH_FRIENDS_BASE_CSS+SEARCHFRIENDS_RESULTS_HEADING_CSS)
    public List<WebElement >searchResultTitleWe;

    @FindBy(css = SEARCH_FRIENDS_BASE_CSS+NAME_CSS)
    public List<WebElement> searchResultUserNameWe;

    @FindBy(css = SEARCH_FRIENDS_BASE_CSS+DATE_CSS)
    public List<WebElement> searchResultDateWe;

    @FindBy(css = SEARCH_FRIENDS_BASE_CSS+PROFILEPIC_CSS)
    public List<WebElement> searchResultProfilePicWe;

    @FindBy(css = SEARCH_FRIENDS_BASE_CSS+FLAG_CSS)
    public List<WebElement> searchResultFlagWe;

    @FindBy(css = "[class^='btn_'] [class^='icon x']")
    public WebElement searchResultcloseBtn;

    @FindBy(css = "[class^='btn_'] [class^='icon magnifier']")
    public WebElement searchResultIconMagnifier;


    public void initializeContactModule(){
        contactModulePage = new ContactModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    public void initializeProfileModule(){
        profileModulePage = new ProfileModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    public FriendsPage(WebDriver webDriver){
        super(webDriver);
        initializeProfileModule();
    }

    public FriendsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FriendsPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
        initializeProfileModule();
    }

    public FriendsPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(welcomeIconWe,welcomeTxtWe,searchFriendsTextAreaWe.get(0),getStartedWe,chatSideMenusWe.get(0),chatSideMenusWe.get(1),chatSideMenusWe.get(2));
        return false;
    }
    public boolean searchFriendsAndRecentCat_CheckAllComponents() {
        checkAllPageComponentsDisplayed(searchResultTitleWe.get(0),searchResultFlagWe.get(0),searchResultProfilePicWe.get(0),searchResultUserNameWe.get(0));
        return false;//,searchResultDateWe.get(0)
    }

    public boolean recentChat_checkComponentsInMainFrame(int index) {
        checkAllPageComponentsDisplayed(recentChatFlagWe.get(index),recentChatProfilePicWe.get(index),recentChatTitleWe,recentChatUserNameWe.get(index));//recentChatDateWe.get(0)
        return false;
    }

    public boolean pendingFriendRequest_checkComponentsInMainFrame() {
        checkAllPageComponentsDisplayed(pendingFriendReqProfilePicWe.get(0),pendingFriendReqStatusWe.get(0),pendingFriendReqTitleWe,pendingFriendReqUserNameWe.get(0));//pendingFriendReqFlagWe.get(0),
        return false;
    }


    public void clickOnFindNewFriends(){
        logger.info("clickOnFindNewFriends");
        click(chatSideMenusWe.get(0));
     }

    public void clickOnMyFriends(){
        logger.info("clickOnMyFriends");
        click(chatSideMenusWe.get(1));
    }

    public void clickOnMyProfile(){
        logger.info("clickOnMyProfile");
        click(chatSideMenusWe.get(2));
    }

    public void clickOnGetStarted(){
        logger.info("clickOnGetStarted");
        click(getStartedWe);
    }

    public void clickOnWelcomeIcon(){
        logger.info("clickOnWelcomeIcon");
        click(welcomeIconWe);
    }

    public void clickOnRecentChat(int index){
        logger.info("clickOnRecentChat");
        click(recentChatUserNameWe.get(index));
    }
    //todo
    public void clickOnRecentChat(String fullName){
        logger.info("clickOnRecentChat name [{}]", fullName);

        for(WebElement we : recentChatUserNameWe){
            String name = TestUtil.getWebElementText(we);
            if(null != name && StringUtils.equalsIgnoreCase(name, fullName)){
                click(we);
                logger.info("Clicked on name [{}]", fullName);
            }
        }

    }


    public void checkPendingFriendRequestNumber(int numberOfRequests){
        logger.info("checkPendingFriendRequestNumber [{}]", numberOfRequests);
        AssertHelper.assertThat("Pending friend request number not matching ...!", numberOfRequests, is(getPendingFriendRequestNumber()) );
    }

    public void checkPendingFriendRequestGreaterThan(int numberOfRequests){
        logger.info("checkPendingFriendRequestGreaterThan [{}]", numberOfRequests);
        AssertHelper.assertThat("Pending friend request number not matching ...!", getPendingFriendRequestNumber(), greaterThan(numberOfRequests) );
    }

    public void checkPendingFriendRequestNoMoreThan(int numberOfRequests){
        logger.info("checkPendingFriendRequestNumber");
        AssertHelper.assertThat("Pending friend request number not matching ...!", numberOfRequests, greaterThan(getPendingFriendRequestNumber()) );
    }

    /**
     * Get how many pending requests
     *  from heading string Pending friend requests (2)
     * @return
     */
    public int getPendingFriendRequestNumber( ){
        logger.info("getPendingFriendRequestNumber");
        String pendingFriendRequestNo = TestUtil.getWebElementText(pendingFriendReqTitleWe);
        int requestNo = -1;
        // Pending friend requests (2)
        if(null != pendingFriendRequestNo) {
            pendingFriendRequestNo = pendingFriendRequestNo.split("\\(")[1];
            pendingFriendRequestNo = pendingFriendRequestNo.split("\\)")[0];
            logger.info(" pendingFriendRequestNo [{}] ", pendingFriendRequestNo);

            try{
                requestNo = Integer.parseInt(pendingFriendRequestNo);
                return requestNo;
            }catch (NumberFormatException e){
                logger.error("!!!! "+e.getMessage());
                failTest(e, "Cant get number of pending invitations ....!");
            }
        }

        if(requestNo == -1)
            failTest("Cant get number of pending invitations ....!");

        return requestNo;
    }

    public void checkPendingFriendRequestStatus(String status,int index){
        logger.info("checkPendingFriendRequestNumber");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(pendingFriendReqStatusWe.get(index)),status,"Pending friend request status not matching");
    }

    /***
     * Check Recent chat is more or = 1      "Recent chats (3)"
     * @param expectedChatNumber
     */
    public void checkRecentChatNumber(int expectedChatNumber){
        logger.info("checkRecentChatNumber");

        int currChatNum = -1;

        try {
            String recentChatStr = recentChatTitleWe.getText();
            String recentChatNumberPart = recentChatStr.split("\\(")[1].trim().replace(")", "");
            currChatNum     = Integer.parseInt(recentChatNumberPart);
        }catch (NumberFormatException e){
            failTest(e, "\n Can not GET/Convert String for recent chat ...!");
        }

        AssertHelper.assertThat("", currChatNum , greaterThanOrEqualTo( expectedChatNumber)); //AssertHelper.assertStringContains(recentChatNumber,chatNumber,"Recent Chat number not matching");
    }

    //search friends and recent chat functions

    public void searchRecentChatAndFriendsUsers(String searchKey){
        logger.info("searchRecentChatAndFriendsUsers");
        WebElementHelper.clearAndsendKeys(getWebDriver(),searchFriendsTextAreaWe.get(0),searchKey,false);
    }

    public void checkResultsForRecentChatAndFriendsSearch(String searchKey){
        logger.info("checkResultsForRecentChatAndFriendsSearch");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(searchResultUserNameWe.get(0)),searchKey,"username cant see in the results of the search");
    }

    public boolean checkIfUsersFromBothRecentchatAndFriendListAppeared() {
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),searchResultTitleWe,2);
        return false;
    }


    public boolean simpleTest() {
        logger.info("simpleTest Assert Main Navigation and userNotification element displayed ...!");
        AssertHelper.assertWebElementDisplayed(welcomeIconWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(welcomeIconWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
