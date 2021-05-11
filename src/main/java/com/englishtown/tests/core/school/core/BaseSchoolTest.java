package com.englishtown.tests.core.school.core;
/**
 * Nikol Jan 2018
 * All school test should extend this
 *
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.chat.ChatUserStatus;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
import com.englishtown.newhouse.school.beanandenum.SchoolPageName;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.newhouse.school.beanandenum.bean.StudentSecurityDetails;
import com.englishtown.newhouse.school.beanandenum.enums.Enroll;
import com.englishtown.newhouse.school.pages.account.BillingPage;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.ConversationClassPage;
import com.englishtown.newhouse.school.pages.core.ISchoolPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.AppsAndToolsPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.GrammarlabPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.newhouse.school.pages.support.newhouse.SupportPage;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.schoollite.EfIdLoginPage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.util.postman.PostmanRunnerUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.fail;


public class BaseSchoolTest extends BaseTestHelper implements ISchoolTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseSchoolTest.class);
    protected String waitForUrlContains = "campus/mypage/home"; // test should set this up
    public static final String SCHOOL_BASE_DOMAIN= "englishlive.ef.com";

    protected StudentBean studentBean;
    protected StudentSecurityDetails studentSecurityDetails;

    public boolean isPopupTest    = false; // use this to test the popups[survey, timezone..]
    public boolean isNewHouseUser = false; // use this to update the urls with /1/ for new house users
    public String closeRecommendPopupCss  = "fancybox-close"; // a popup is shown on login ... could be one of 2 change clock on survey
    public String recommendSurveyFrameCss = ".fancybox-outer iframe";
    public static final int recommendPopupWaitTimeSec = WaitTool.SHORT_WAIT_4_ELEMENT;  // time to wait popup shown then close

    public static final String BASECALLBACK      = "var callback = arguments[arguments.length - 1];"+ "et.state.get('";
    public static final String BASECALLBACKTHEN  = "').then(function(v){callback(v[0])})";
    public static final String MEMBERID_KEY      = BASECALLBACK + "user.member_id" + BASECALLBACKTHEN;
    public static final String EFID_KEY          = BASECALLBACK + "user.ef_id" + BASECALLBACKTHEN;

    public int numberOfUsersToCreate = 2;
    public List<ChatTestUserBean> userBeanList = new ArrayList<>();

    protected String memberPageUrl = "englishlive.ef.com/en-gb/buy/default/member/?ctr=gb";

    protected String currentgoalHours;
    protected String newgoalHours;

    protected int numberOfCoursesAvailable = 5; // on change course page todo ... add this to student bean

    // postman
    public static final String createUserDefaultCollection = "create_user_default_collection.json";
    public static final String qaCollectionEnvFileName     = "qa_postman_environment.json";
    public static final String completeLevelCollection     = "complete_level_collection";

    /**
     * Test should setup this data
     */
    protected String goalDaysLef;   // e.g 0 day(s) left
    protected String goalPaceMsg;   // e.g YOU MISSED YOUR STUDY GOAL
    protected String goalStudyPace; // e.g 3-5 Hours Weekly shown for current goal if not set to own pace
    protected String goalDate;      // e.g Feb 8 2018

    public void setTestGoalData(String goalDaysLef, String goalPaceMsg, String goalStudyPace, String goalDate) {
        this.goalDaysLef = goalDaysLef;
        this.goalPaceMsg = goalPaceMsg;
        this.goalStudyPace = goalStudyPace;
        this.goalDate = goalDate;
    }



    @BeforeSuite
    protected void setupBaseSchoolTest(){
        //logger.info("setupBaseSchoolTest .. take shot for all tests");
        //TestngListener.setIsStoreScreenShotAllTest(true);
        memberSpinnerCss = ".ets-backdrop";
        setTestName(this.getClass().getSimpleName());
    }

    @AfterSuite
    protected void teardownAfterBaseSchoolTest(){
        logger.info("@ after suite ...!");
    }

    public void initSchoolHeaderPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.initializeHeader();
    }

    public void initSchoolFooterPage(){
        schoolHeaderAndFooterPage.initializeFooter();
    }

    public void initSchoolHeaderAndFooter() {
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        //schoolHeaderAndFooterPage.simpleTest();
    }





    /**
     * Pass the page object to open that url
     * getPageUrl should return the page relative url
     * @param schoolPage
     */
    public void openPageUrl(ISchoolPage schoolPage){
        sleep(500);
        String url = SCHOOL_URL+schoolPage.getPageUrl();
        openUrl(getWebDriver(), url);
        sleep(500);
    }

    /**
     *
     * @param driver
     * @param schoolPage
     * @param schoolBaseDomain  ---> getBASEURL()+SCHOOL_BASE_DOMAIN
     */
    public static void openPageUrl(WebDriver driver, ISchoolPage schoolPage, String schoolBaseDomain){
        sleep(500);
        String url = schoolBaseDomain+schoolPage.getPageUrl();
        logger.info("openPageUrl [{}]", url);
        TestUtil.openUrl(driver, url);
        sleep(500);
    }

    // Todo do the same but use Header pom to navigate this time
    public void openSchoolPageUrl(SchoolPageName pagesName){
        logger.info("openSchoolPageUrl [{}]", pagesName);
        schoolHeaderPage = new SchoolHeaderPage(getWebDriver());
        schoolHeaderPage.simpleTest();

        switch (pagesName){
            case MYPAGE:
                logger.info("My account page Case .. this is the page when user login ...NOT implemented  ...!");
                // do we really need this
                break;

            case MY_ACCOUNT_PAGE:
                logger.info("My account page Case ...!");
                schoolHeaderPage.goToMyAccountSetting();
                break;
            case PERSONAL_DETAILS:
                logger.info("My account page Case ...!");
                schoolHeaderPage.goToMyAccountSetting();
                break;
            //TODO
            default:  logger.warn("Can not find the option requested [{}]", pagesName);;
        }

    }
//in recommendpopup answer first question ans then close the popup
    public void waitForRecommendPopupAndClose(){
        logger.info("wait For Recommend Popup And Close ...!");

        boolean isRecommendPopupShown =   WaitTool.waitForIsDisplayed(getWebDriver(), By.cssSelector(recommendSurveyFrameCss),
                                                                                             recommendPopupWaitTimeSec);
        if(isRecommendPopupShown){
           /* findElement(By.className("fancybox-iframe"), WaitTool.DEFAULT_IMPLICIT_WAIT);
            WebDriverWindowHelper.switchToFrameByFrameWebElement(getWebDriver(), By.className("fancybox-iframe"));
            //getWebDriver().switchTo().frame(getWebDriver().findElement(By.className("fancybox-iframe")));
            logger.info("Answer first question in recommended popup ...!");
            currWebElement = findElement(By.cssSelector(".radio-buttons .first-child"),WaitTool.DEFAULT_IMPLICIT_WAIT);
            click(currWebElement);
            logger.info("close recommended popup ...!");
            WebDriverWindowHelper.switchToDefaultContent(getWebDriver()); //getWebDriver().switchTo().defaultContent();*/
            click(By.className(closeRecommendPopupCss));
            logger.info("Clicked to close recommended popup...!");
            sleep(500);
        }else
            logger.info("No popup shown ...!");
    }

    /**
     * Init page object
     * get page condition and execute simpleTest
     *
     */
    public void initSchoolHomePage(){
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
    }

    public void initBookPrivateLessonPage(){
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        bookPrivateLessonPage.getPageLoadedCondition();
        bookPrivateLessonPage.simpleTest();
    }

    public void initConversationClassPage(){
        conversationClassPage = new ConversationClassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        conversationClassPage.getPageLoadedCondition();
        conversationClassPage.simpleTest();
    }

    public void initCurrentCourseUnitPage(){
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.simpleTest();
    }

    public void initMyAccountPage(){
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.simpleTest();
    }

    public void initUpdatePaymentPage(){
        /*updatePaymentPage = new UpdatePaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        updatePaymentPage.getPageLoadedCondition();
        updatePaymentPage.simpleTest();*/
    }

    public void initBillingPage(){
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        billingPage.getPageLoadedCondition();
        billingPage.simpleTest();
    }

    public void initAppsAndToolsPage(){
        appsAndToolsPage = new AppsAndToolsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        appsAndToolsPage.getPageLoadedCondition();
        appsAndToolsPage.simpleTest();
    }

    public void initGrammarLabPage(){
        grammarlabPage = new GrammarlabPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        grammarlabPage.getPageLoadedCondition();
        grammarlabPage.simpleTest();
    }

    public void initNewHouseSupportPage(){
        supportPage = new SupportPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        supportPage.getPageLoadedCondition();
        supportPage.simpleTest();
    }

    public List<ChatTestUserBean> setupTestUsers(int howManyUsers) {
        ChatTestUserBean chatTestUserBean = new ChatTestUserBean();

        for(int i= 0; i < howManyUsers; i++){
            try {
                setThreadSafeDriver();
                chatTestUserBean = createAndSetupNewChatUsers(memberPageUrl, getWebDriver(), getMemberFormMap(),
                        EfConstants.ukMembersPayMap_new, false, 0, false, ChatUserStatus.OFFLINE);
                userBeanList.add(chatTestUserBean);
            }catch (Exception e){
                logger.error("Could not create user [{}]  ...!"+e.getMessage(), i);
            }finally {
                destroyDriver();
            }

        }

        logger.info("\n\n $$$$$$$$$$$$$$$$$$$$ Test Users  $$$$$$$$$$$$$$$$$$$$$$$$$$ ");
        for(ChatTestUserBean user : userBeanList) {
            logger.info("" + user.toString());
        }
        logger.info("\n\n $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ ");
        sleep(30000);

        if(null == userBeanList || userBeanList.isEmpty() )
            failTest("Could not create the users needed for testing ....!");

        return userBeanList;
    }


    public ChatTestUserBean createAndSetupNewChatUsers(String memberPageUrl, WebDriver driver,
                                                       Map memberMap, Map paymentMap, boolean isClickTab, int tabId,
                                                       boolean isIncoming, ChatUserStatus status){
        openUrl(driver, memberPageUrl);
        ChatTestUserBean user = createNewUser(driver, memberMap, paymentMap, isClickTab, tabId);
        user.setIncoming(isIncoming);
        user.setChatUserStatus(status);

        return user;
    }

    /**
     * Create users using UI and enroll
     * set username, pass, member id
     * Should start at member page
     * @param driver
     * @param memberMap
     * @param paymentMap
     * @param isClickTab
     */
    public ChatTestUserBean createNewUser(WebDriver driver, Map memberMap, Map paymentMap, boolean isClickTab, int tabId){
        logger.info("start enterMemberDetails ....!");
        ChatTestUserBean chatTestUserBean = new ChatTestUserBean();
        waitForSpinnerDisappear(driver);
        memberPage = initMemberPage(driver);
        TestUtil.enterFormData(driver, memberMap);
        enterEmail(driver, true);
        chatTestUserBean.setUserName(userEmail);
        memberPage.submit();
        logger.info("Member page submitted ....!");

        clickTab(isClickTab, driver, tabId);
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(paymentSubmitBtnCss), getWebDriver(), 25);
        removePaymentValidation();
        waitForSpinnerDisappear(driver);

        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "qa")) {
            paymentMap.replace("CreditCardNumber", "4111111111111111");
        }
        TestUtil.enterFormData(driver, paymentMap);
        WebElement submitElement = findElement(driver, By.cssSelector(paymentSubmitBtnCss), 15);
        click(submitElement);

        try{Thread.sleep(3000);}catch (Exception e){}
        waitForSpinnerDisappear(driver);
        logger.info("Pay page submitted ....!");
        PaymentThankyouPage paymentThankyouPage = new PaymentThankyouPage(driver, 35) ;
        paymentThankyouPage.waitForPageToLoad(paymentThankyouPage.getPageLoadedCondition(isNewhouseCheckout));
        paymentThankyouPage.simpleTest(isNewhouseCheckout);
        chatTestUserBean.setUserId(JavaScriptHelper.executeAsyncScript(MEMBERID_KEY, driver, 15));
        chatTestUserBean.setEfId(JavaScriptHelper.executeAsyncScript(EFID_KEY, driver, 10));

        //click(paymentThankyouPage.startLearning);
        if(isNewhouseCheckout)
            click(paymentThankyouPage.startLearningNewCheckOut);
        else
            click(paymentThankyouPage.startLearning);
        sleep(3000);
        // enroll
        BasePage.waitForUrlContains(driver, "enrollment/b2c/entrance", 35);
        enrolStudentCheckAtSchool();
        logger.info("User created...!\n"+chatTestUserBean.toString()+"\n ---------------\n");

        return chatTestUserBean;
    }

    public static DynamicMemberPage initMemberPage(WebDriver driver){
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=firstname]"), driver, WaitTool.MED_WAIT_4_ELEMENT);
        DynamicMemberPage memberPage = new DynamicMemberPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        memberPage.simpleTest();
        return memberPage;
    }

    public static void waitForSpinnerDisappear(WebDriver driver){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),driver, WaitTool.MED_WAIT_4_ELEMENT);
    }

    public static void clickTab(boolean isClickTab, WebDriver driver, int tabId){
        String paymentTabsListCss = ".nav.nav-tabs li a";
        waitForSpinnerDisappear(driver);
        if (isClickTab) {
            findElement(driver, By.cssSelector(paymentTabsListCss), 15);
            List<WebElement> tabsWe = WaitTool.waitForListElementsDisplayed(driver, By.cssSelector(paymentTabsListCss), 15);
            tabsWe.get(tabId).click();
            BaseTest.sleep(1000);
            logger.info(" Tab clicked ...!");
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
    }

    public static WebElement findElement(WebDriver webDriver, By selector, int waitTimeSec) throws NullPointerException{
        return WaitTool.waitForElementVisible(webDriver, selector, waitTimeSec, 1000);
    }

    public Map getMemberFormMap(){
        String fName = TestUtil.generateRandomString("BtoC", 7);
        String lName = TestUtil.generateRandomString("BtoC", 6);
        Map<String, String> memberFormMap = EfConstants.MEMBER_FORM_FLP;
        memberFormMap.replace("firstname", fName );
        memberFormMap.replace("lastname", lName);

        return memberFormMap;
    }

    public void logoutAndLogin(String username, String pass, boolean isOpenLoginUrl, boolean isClearCookies){
        logger.info("Logout and Login ... u:"+username+"; p:"+pass+"; isOpenLoginUrl:"+isOpenLoginUrl);
        logout(isClearCookies);
        login(username, pass, isOpenLoginUrl);
    }

    public void loginAndLogout(String username, String pass, boolean isOpenLoginUrl, boolean isClearCookies){
        logger.info("Logout and Login ... u:"+username+"; p:"+pass+"; isOpenLoginUrl:"+isOpenLoginUrl);
        login(username, pass, isOpenLoginUrl);
        logout(isClearCookies);
    }

    public void logout(boolean isClearCookies) {
        logger.info("logoutAndClearCookies ...!");
        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHeaderPage.getPageLoadedCondition();
        schoolHeaderPage.goToMyAccountAndLogout();
        if(isClearCookies) {
            sleep(1000);
            CookieHandler.deleteCookies(getWebDriver());
            sleep(1000);
        }
    }

    public void login(String username, String pass, boolean isOpenLoginUrl) {
        openLoginUrl(isOpenLoginUrl);
        logger.info("enterUserCredentialsAndLogin  ...!");
        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.getPageLoadedCondition();
        loginPage.simpleTest();
        loginPage.enterCredentials(username, pass);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
    }

    public void loginEFIDPage(String username, String pass, boolean isOpenLoginUrl) {
         openLoginUrl(isOpenLoginUrl);
        logger.info("enterUserCredentialsAndLogin  ...!");
        efIdLoginPage = new EfIdLoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        efIdLoginPage.getPageLoadedCondition();
        efIdLoginPage.simpleTest();
        //CookieHandler.setCookiesValueForTimeZone(getWebDriver(),"1");
        efIdLoginPage.enterCredentials(username, password);
        sleep(1000);
        efIdLoginPage.clickLoginBtn(efIdLoginPage.loginBtn);
    }


    public void openLoginUrl(boolean isOpenLoginUrl) {
        logger.info("openLoginUrlAndLogin  ...!");
        String loginUrl = getBASEURL() ;

        if(isOpenLoginUrl)
            openUrl(getWebDriver(), loginUrl);

        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    public StudentBean createNewHouseUserAndEnroll(String environment, Enroll enrolLevel, String country, String language){
        String loginUrl = "https://qa-englishlive.ef.com/"+ language +"-"+ country +"/login";

        if(StringUtils.contains(environment, "live"))
            loginUrl = loginUrl.replace("qa-", "");

        logger.info("Login URL set to [{}]", loginUrl);
        StudentBean studentBean = new StudentBean();
        studentBean.setCountry(country);
        studentBean.setLang(language);
        studentBean.setEnroll(enrolLevel);

        StaticBaseApiSpec.createUserWithEnroll(environment, studentBean, loginUrl);
        //StaticBaseApiSpec.getAllUserDataResponse(studentBean.getUserEmail(), 200, "qa");

        return studentBean;
    }

    public StudentBean createNewHouseUserPayNoEnroll(String environment,  String country, String language){
        StudentBean studentBean = new StudentBean();
//        studentBean.setCountry(country);
//        studentBean.setLang(language);
        StaticBaseApiSpec.createUserNoEnrol(environment,true,"50987556",country,language);

        return studentBean;
    }

    public void createDefaultUser(String username){
        schoolStudentUpdatedBean = new SchoolStudentBean();
        schoolStudentUpdatedBean.setFirstName("NikolF");
        schoolStudentUpdatedBean.setLastName("MarkuL");
        schoolStudentUpdatedBean.setMobilePhone("122222222900");
        schoolStudentUpdatedBean.setUserEmail(username);
        createTestUser( username, createUserDefaultCollection, qaCollectionEnvFileName);
    }

    public void setSchoolBean2(String username){
        schoolStudentUpdatedBean2 = new SchoolStudentBean();
        schoolStudentUpdatedBean2.setFirstName("firstnameupdate");
        schoolStudentUpdatedBean2.setLastName("lastnameupdate");
        schoolStudentUpdatedBean2.setMobilePhone("122222222903");
        schoolStudentUpdatedBean2.setUserEmail(username);
    }
    /**************************************************************
     *  Create user using Newman to run postman collection
     *
     * @param userEmail
     * @param collectionFileName
     * @param collectionEnvFileName
     *
     *  TODO: once postman collection are stable use collection URL
     * ***********************************************************/
    public void createTestUser(String userEmail, String collectionFileName, String collectionEnvFileName ) {
        logger.info("Create Test User ............!");
        logger.info("collectionFileName [{}]", collectionFileName);
        logger.info("collectionEnvFileName [{}]", collectionEnvFileName);
        logger.info("userEmail [{}]", userEmail);
        logger.info(" **********************************************");

        PostmanRunnerUtil postmanRunnerUtil = new PostmanRunnerUtil();

        String basePostmanCollectionDir = getPostmanBaseDir();
        String collectionFileLocation    = basePostmanCollectionDir +  collectionFileName;
        String collectionEnvFileLocation = basePostmanCollectionDir + collectionEnvFileName;

        logger.info("collectionFileLocation ["+collectionFileLocation+"]");
        logger.info("collectionEnvFileLocation ["+collectionEnvFileLocation+"]");

        String newmanReportFile = TestUtil.getUserDir()+ File.separator+"target"+File.separator+"newman" +
                File.separator+"testreport"+File.separator + userEmail.split("@")[0].split("_")[1] + ".html";

        String runNewmanCmd = "CMD /C newman.cmd run "+ collectionFileLocation +" -e "+ collectionEnvFileLocation +
                " --global-var USER_EMAIL_OVERRIDE="+userEmail + " --ignore-redirects" +
                " -r cli,htmlextra --reporter-htmlextra-export "+ newmanReportFile+" --reporter-htmlextra-darkTheme";
        postmanRunnerUtil.executeCmdCommand( runNewmanCmd, WaitTool.MED_WAIT_4_ELEMENT);
    }

    public void completeLevel(String userId,String studentId, String collectionFileName, String collectionEnvFileName ) {
        logger.info("Finish first Level............!");
        logger.info("collectionFileName [{}]", collectionFileName);
        logger.info("collectionEnvFileName [{}]", collectionEnvFileName);
        logger.info("userEmail [{}]", userEmail);
        logger.info(" **********************************************");

        PostmanRunnerUtil postmanRunnerUtil = new PostmanRunnerUtil();

        String basePostmanCollectionDir = getPostmanBaseDir();
        String collectionFileLocation    = basePostmanCollectionDir +  collectionFileName;
        String collectionEnvFileLocation = basePostmanCollectionDir + collectionEnvFileName;

        logger.info("collectionFileLocation ["+collectionFileLocation+"]");
        logger.info("collectionEnvFileLocation ["+collectionEnvFileLocation+"]");

        String newmanReportFile = TestUtil.getUserDir()+ File.separator+"target"+File.separator+"newman" +
                File.separator+"testreport"+File.separator + userEmail.split("@")[0].split("_")[1] + ".html";

        String runNewmanCmd = "CMD /C newman.cmd run "+ collectionFileLocation +" -e "+ collectionEnvFileLocation +
                " --global-var USER_ID="+userId + " --global-var STUDENT_ID="+studentId + "--ignore-redirects" +
                " -r cli,htmlextra --reporter-htmlextra-export "+ newmanReportFile+" --reporter-htmlextra-darkTheme";
        postmanRunnerUtil.executeCmdCommand( runNewmanCmd, WaitTool.MED_WAIT_4_ELEMENT);
    }

    public String getPostmanBaseDir(){
        logger.info("getPostmanBaseDir  ....!");
        String basePostmanDir = "";

        try {
            basePostmanDir = TestUtil.getUserDir()+ File.separator+"postman"+File.separator+"collection"+File.separator;
            logger.info("basePostmanDir set to [{}] ...!", basePostmanDir );
        }catch (Exception io){
            fail("Can't get collection location  "+ io.getMessage());
        }

        if(org.apache.commons.lang3.StringUtils.isBlank(basePostmanDir)){
            fail("Can't get Postman collection base directory location... to get collection .json ...!");
        }

        return basePostmanDir;
    }


}
