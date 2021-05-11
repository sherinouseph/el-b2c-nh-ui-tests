package com.englishtown.tests.core.school.friends;
/**
 * Base Friends Chat
 *
 * this test contains the helper methods for the FriendsChat
 * and has a test for going to Friends chat page
 *
 * Sherin 13/04/2018
 *
 *
*/

import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.beanandenum.EnglishLevel;
import com.englishtown.newhouse.school.beanandenum.GenderChatProfile;
import com.englishtown.newhouse.school.beanandenum.StudentProfileDetails;
import com.englishtown.newhouse.school.pages.friends.*;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseFriendsChatTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseFriendsChatTest.class);
    protected String chatUserName_FilterSearchOnline;
    protected String chatUserName_SearchByNameOrEMail;
    protected String chatTestUser1;
    protected String chatTestUser2;
    protected String chatTestUser3;
    protected String chatTestUser1EmailId;
    protected String chatTestUser2EmailId;
    protected String chatTestUser3EmailId;
    protected String searchByEmailId;
    protected String searchByName;
    protected String myProfileUserName;
    protected String chatUserName_FilterSearchNOTOnline;
    protected StudentProfileDetails studentProfileDetails;
    protected StudentProfileDetails searchStudentProfileDetails;
    protected StudentProfileDetails studentProfileDetails_FilterSearch;
    protected StudentProfileDetails studentProfileDetails_NOTOnlineUser;
    protected StudentProfileDetails studentProfileDetails_EmailNameSearch;
    protected EnglishLevel englishLevel;
    protected GenderChatProfile genderChatProfile;

    protected  WebDriver driver2;
    protected  WebDriver driver3;
    protected  WebDriver driver1;



    //Friends chat Page
    protected FriendsPage friendsPage;
    protected FindNewFriendsPage findNewFriendsPage;
    protected MyFriendsPage myFriendsPage;
    protected MyProfilePage myProfilePage;
    protected MyFriendDetailsPage myFriendDetailsPage;
    protected GetStartedPage getStartedPage;
    protected ChatWindowPage chatWindowPage;

    protected FindNewFriendsResultPage findNewFriendsResultPage;


    protected int currentPendingRequestsNo  = 0;
    protected int previousPendingRequestsNo = 0;
    protected boolean isGoViaFriendsDirectUrl =true;

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void gotoFriendsPageTest() {
        logger.info("gotoFriendsPage");

        if(isGoViaFriendsDirectUrl)
            gotoFriendsPageInitGetStarted(getWebDriver());
        else {
            gotoFriendsPageViaMenu(getWebDriver());
            initGetStartedPage(getWebDriver());
        }


    }

    protected void gotoFriendsPageInitGetStarted(WebDriver driver) {
        logger.info("gotoFriendsPage");
        gotoFriendsPage(driver);
        sleep(900);
        initGetStartedPage(driver);
        //friendsPage.simpleTest();

    }

    /**
     * HELPERs
     *
     */
    protected void goToFindNewFriendsPage() {
        logger.info("goToFindNewFriendsPage");
        friendsPage=new FriendsPage(getWebDriver(),25);
        friendsPage.clickOnFindNewFriends();
        findNewFriendsPage=new FindNewFriendsPage(getWebDriver(),25);
        findNewFriendsPage.simpleTest();
    }

   /* protected void goToMyFriendsPage() {
        logger.info("goToMyFriendsPage");
        friendsPage=new FriendsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        friendsPage.clickOnMyFriends();
        myFriendsPage=new MyFriendsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myFriendsPage.simpleTest();
    }*/

    /*protected void gotoFriendsPage() {
        logger.info("gotoFriendsPage");
        friendsPage = new FriendsPage(getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT);
        //openUrl(getWebDriver(), getBASEURL() + SCHOOL_BASE_DOMAIN + "/chat/friends/");
        openPageUrl(friendsPage);
        sleep(800);
        refresh(getWebDriver()); // do not remove this
    }*/

    protected void enterUserCredentialsAndLogin(WebDriver driver, String userName, String password){
        logger.info("enterUserCredentialsAndLogin  ...!");
        loginPage = new LoginPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.getPageLoadedCondition();
        loginPage.simpleTest();
        loginPage.enterCredentials(userName, password);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
    }


//    protected void loginAsUser2AndGoToFriendsPage(String userName,String password) {
//        logger.info("loginAsUser2AndGoToFriendsPage");
//        driver2= WebDriverFactory.getBrowser(MyBrowserType.FIREFOX, 20);
//       // driver2= DriverManager.getNewDriver(MyBrowserType.FIREFOX, 20);; // WebDriverFactory.getBrowser(MyBrowserType.EDGE, 20); //DriverManager.getNewDriver(MyBrowserType.EDGE, 20);
//        openUrl(driver2, testStartUrl);
//        enterUserCredentialsAndLogin(driver2,chatTestUser2EmailId,password);
//        gotoFriendsPage(driver2);
//
//    }

    protected void gotoFriendsPage(WebDriver driver) {
        logger.info("gotoFriendsPage");
        friendsPage = new FriendsPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        openPageUrl(driver, friendsPage, getBASEURL()+SCHOOL_BASE_DOMAIN);
        //openUrl(driver, getBASEURL() + SCHOOL_BASE_DOMAIN + "/chat/friends/#/chat/friends/search/advanced", WaitTool.DEFAULT_IMPLICIT_WAIT);  //#/?hideTeaser=true
        refresh(driver); //d.la1t1.salesforceliveagent.com c.la1t1.salesforceliveagent.com
    }

    protected void gotoFriendsPageViaMenu(WebDriver driver) {
        logger.info("gotoFriendsPageViaMenu");
        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderPage.goToFriends();
        gotoFriendsPage(getWebDriver());//this is to remove the teaser

    }

    /*protected void loginAsUser3AndGoToFriendsPage(String userName,String password) {
        logger.info("loginAsUser3AndGoToFriendsPage");
        driver3= DriverManager.getNewDriver(MyBrowserType.EDGE, 20);; // WebDriverFactory.getBrowser(MyBrowserType.EDGE, 20); //DriverManager.getNewDriver(MyBrowserType.EDGE, 20);
        openUrl(driver3, testStartUrl);
        enterUserCredentialsAndLogin(driver3,userName,password);
        gotoFriendsPage();
    }*/

    /**
     * init, page load condition and simple test
     */
    public void initFindNewFriendsResultPage(WebDriver driver){
        findNewFriendsResultPage = new FindNewFriendsResultPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        findNewFriendsResultPage.getPageLoadedCondition();
        findNewFriendsResultPage.simpleTest();
    }

    public void initMyFriendDetailsPage(WebDriver driver){
        myFriendDetailsPage = new MyFriendDetailsPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        myFriendDetailsPage.getPageLoadedCondition();
        myFriendDetailsPage.simpleTest();
    }

    public void initGetStartedPage(WebDriver driver){
        getStartedPage = new GetStartedPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        getStartedPage.getPageLoadedCondition();
        getStartedPage.simpleTest();
    }

    public void closeGetStartedWindow(WebDriver driver){
        getStartedPage = new GetStartedPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        getStartedPage.clickOncloseBtn();
    }

    public void initFriendsPage(WebDriver driver){
        friendsPage = new FriendsPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        friendsPage.getPageLoadedCondition();
        friendsPage.simpleTest();
    }

    public void initChatWindowPage(WebDriver driver){
        chatWindowPage = new ChatWindowPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        chatWindowPage.getPageLoadedCondition();
        chatWindowPage.simpleTest();
    }

    /**
     * Should be on Chat window and get started window closed
     * 1. Click on search by name tab
     * 2. enter search string
     * 3. click search and init result page
     * @param driver
     * @param searchByEmailOrName
     */
    protected void goto_FindByNameOrEmail_EnterEmailAndSearch(WebDriver driver, String searchByEmailOrName) {
        logger.info("goto_FindByNameOrEmail_EnterEmailAndSearch [{}]", searchByEmailOrName );
        findNewFriendsPage = new FindNewFriendsPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        findNewFriendsPage.clickOnSearchNameOrEmailTab();
        findNewFriendsPage = new FindNewFriendsPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        findNewFriendsPage.searchByEmail(searchByEmailOrName);
        findNewFriendsPage.clickOnFindNewFriendsBtn_SearchEmailName();
        initFindNewFriendsResultPage(driver);
    }

    /**
     * Check number of results shown and click on a card , init Friends Page
     * @param driver
     * @param numberOfContacts
     * @param clickOncardIndex
     */
    protected void check_SearchResult_AndClickOnACard(WebDriver driver, int numberOfContacts, int clickOncardIndex) {
        logger.info("check_SearchResult_AndClickOnACard");
        findNewFriendsPage = new FindNewFriendsPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        findNewFriendsResultPage.contactModulePage.checkNumberOfContactModules(numberOfContacts); //1
        findNewFriendsResultPage.contactModulePage.clickOnCard(clickOncardIndex); //0
        // note user must have pending requests
        initFriendsPage(driver);
    }



    /**
     * = friendsPage.getPendingFriendRequestNumber();
     * @param requestNo
     */
    protected void setCurrentPendingRequest(int requestNo){
        currentPendingRequestsNo  = requestNo;
        logger.info("currentPendingRequestsNo [{}]", currentPendingRequestsNo);
    }

    protected void setPreviousPendingRequestsNo(int requestNo){
        previousPendingRequestsNo = requestNo;
        logger.info("setPreviousPendingRequestsNo [{}]", previousPendingRequestsNo);
    }



    /**
     * User a new driver e.g MyBrowserType.CHROME_HEADLESS
     *  to make user appear online login
     *  loginAsUser2AndGoToFriendsPage();
     *  testchatUI userthree testchatuiuserthree@qp1.org
     */
    protected void loginAndGoToFriendPage(String loginUrl, MyBrowserType browserType, String username, String pass, boolean isQuitDriverEndOfMethod) {
        logger.info("loginAndGoToFriendPage to make user active");
        WebDriver driver = null;
        boolean failTest = false;
        String error = "";

        try {
            driver2 =  WebDriverFactory.getBrowser(browserType,  WaitTool.PAGELOAD_TIMEOUT_45);// DriverManager.getNewDriver(browserType, WaitTool.MED_WAIT_4_ELEMENT25);
            openUrl(driver2, loginUrl);
            enterUserCredentialsAndLogin(driver2, username, pass);
            gotoFriendsPage(driver2);
            logger.info("User [{}] went to friends page");
        }catch (WebDriverException e){
            failTest = true;
            error = e.getMessage();
            logger.error("Can't login user with another driver to make it online ...! "+error );
        }finally {
            if (isQuitDriverEndOfMethod) {
                if (driver != null) {
                    logger.info("try to Quit driver ....!");
                    try {
                        driver.quit();
                        logger.info("Extra driver quited ....!");
                    } catch (Exception e) {
                        logger.error("Can't quit driver [{}]", e.getMessage());
                    }
                }
                if (failTest)
                    failTest("Can't login user with another driver to make it online ...! " + error);
            }
        }

    }


}


