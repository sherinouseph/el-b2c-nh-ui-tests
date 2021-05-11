package com.englishtown.tests.core;
/**
 * BaseTestConfig
 * All configuration should be handled here for test cases
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.GetTestGridNodeInfo;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.enumpack.CardType;
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.enumpack.GridEnvironment;
import com.englishtown.exception.WebDriverNotInitialisedException;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.reader.ReadWriteToFile;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.pages.checkout.newcheckout.DynamicPaymentMemberPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import com.englishtown.pages.common.school.enrolmentui.NewHouseStartEnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.StartLearningPage;
import com.englishtown.pages.core.EnglishtownStateObject;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;


@Listeners(TestngListener.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@Configuration


public abstract class BaseTestConfig extends AbstractTestNGSpringContextTests implements IBaseTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseTestConfig.class);
    public TestUtil testUtil ;
    //@Resource(name="driver")
    protected WebDriver webDriver;
    //    @Value("#{applicationPropertiesList['test.browser.name']}")  protected String testBrowserName;
    @Value("#{applicationPropertiesList['test.password']}")
    protected String password;
    @Value("#{applicationPropertiesList['env.id']}")
    public String ENVIRONMENT;
    @Value("#{applicationPropertiesList['base.url']}")
    public String BASE_URL;
    @Value("#{applicationPropertiesList['schooldomain.url']}")
    public String SCHOOL_URL;
    @Value("#{applicationPropertiesList['test.cc.num.live']}")
    public String CC_CARD_NO_LIVE;
    @Value("#{applicationPropertiesList['test.cc.num.qa']}")
    public String CC_CARD_NO_QA;

    @Value("#{applicationPropertiesList['test.mastercard.num']}")
    protected String MASTERCARD_CARD_NUM;
    @Value("#{applicationPropertiesList['test.maestro.num']}")
    protected String MAESTRO_CARD_NUM;
    @Value("#{applicationPropertiesList['test.amex.num']}")
    protected String AMEX_CARD_NUM;
    @Value("#{applicationPropertiesList['test.discover.num']}")
    protected String DISCOVER_CARD_NUM;
    @Value("#{applicationPropertiesList['test.dine.num']}")
    protected String DINE_CARD_NUM;
    @Value("#{applicationPropertiesList['test.jcb.num']}")
    protected String JCB_CARD_NUM;
    @Value("#{applicationPropertiesList['test.webpay.num']}")
    protected String VISA_WEBPAY;

    protected String BASE_DOMAIN = "englishlive.ef.com";

    // use isNewhousePayment public static boolean isNewhouse = false;//if this is true, then it means that market is actually moved to newhouse rather than just the style of the page
    public boolean isNewhouseCheckout = false;
    public boolean isRadioButonAtPaymentPage = false;  // no tabs anymore FR the first to do this
    public boolean isNewhouseTyPage   = false;
    public boolean isNewhousePayment  = false;
    public static String testName="";

    // debug logs
    public boolean isLogDebug = false;

    // BrowserStack config
    public static final String BROWSERSTACK_USERNAME      = "vahid41"; // "nikmak2";
    public static final String BROWSERSTACK_ACCESS_KEY  = "3HQeZMXch8EsdAsNGsKj";//"JBRiKiDSCppHfAUvMoMq";
    //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static String projectName = ""; // CI info
    public static String buildNumber = "";
    //---------------
    private String testCardNumber = "4222222222222222";//CC_CARD_NO_LIVE; // by default
    public CardType testCardType = CardType.VISA;

    public String testStartUrl; // this is the URL the test start ... open first time
    public String homePageUrl;
    public static int PRESS_NO = 3; // default option used by arrow down method
    public int PRESS_NO_DEPT = 3;
    public int PRESS_NO_CITY = 3;
    public static final boolean LOG_PAGE_SOURCE = false;
    public static final boolean LOG_STEP_IMAGE  = true;

    public static String memberSpinnerCss = ".container-fluid .spinner";
    protected String mTestCaseName = "";
    //tracking
    public static String stateObjKeyTrackEventCubit = "tracking.qubit_enabled";
    // state object keys values
    public String formLeadTypeKey    = "form.leadtype";
    public String formLeadTypeValue  = "oe"; // test set this up
    public String formLeadIdKey      = "form.lead_id";
    public String formTypeKey    = "form.type";
    public String formTypeValue ;

    public Long  testStartTime , testEndTime;
    public boolean isJCBpayment = false; // use this for JP JCB payment

    public boolean isTestCheckoutFlowType = false;
    public CheckoutFlowType checkoutFlowType ; //= "notInit"; //'default',    'return', 'upsell', 'redemption', 'welcome-back'

    // Web element selectors
    //public static String genSubmitCssBtn = "[id*=submit],[class*=submit]";
    public String osFormSubmitId = "osformsubmit";
    public String upsellSubmitBtnCss = ".btn-block";  //http://englishlive.ef.com/de-de/lp/ty/kostenlose-email-lektionen-ohne-anmeldung/
    public static String TEST_NODE_IP;         // grid node ip address where test is running
    public static boolean isGetTestNodeIpAddress = false; // if true then will get the IP address of the node running test
    public static String TEST_NODEIP_FILE ="test_node_ip.txt";

    protected String pageGeoLocatedCtr = "notInit"; // state object page.geo_located_ctr
    /**
     * Shared selectors
     */
    public String memberPageSubmitBtnCss  = ".bs3 .btn.btn-primary";

    // used to stop testing of state object and someplaces to distinguish is the new checkout 2018
    public boolean checkStateObject = true;
    /**
     * System properties
     */
    public static GridEnvironment gridEnvironment;
    
    //------------------------------------------------------------------------------------------------------------------
    @BeforeTest  // 1* runs before class annotation
    public synchronized void setUp(){
        testStartTime = System.currentTimeMillis();
        logger.info("setUp beforeTest ...! testStartTime :>"+testStartTime);
        logger.info("Browser should be set to :> System.getProperty browser <<<<< [{}] >>>>>", System.getProperty("browser"));
        logger.info("Grid ENV should be set to :> System.getProperty grid <<<<< [{}] >>>>>", System.getProperty("grid"));
        setGridEnvironmentFromDargs();
        setProjectNameAndBuildNoFromDargs(); // used for browserstack test
        testUtil = new TestUtil();
    }
    @BeforeClass // 2*
    public synchronized void setUpBeforeClass(){
        logger.info("setUpBeforeClass : Environment  : "+getENVIRONMENT());
        //setup driver        //logger.info("Create driver using thread local ");       //DriverManager.createDriver(MyBrowserType.CHROME, 15);        //setWebDriver(DriverManager.getDriver());
        RemoteWebDriver remoteDriver = null;
        if(isGetTestNodeIpAddress) {
            try {
                remoteDriver = new RemoteWebDriver(new URL(BaseRemoteWebDriver.nodeURL), BaseRemoteWebDriver.capability);
                TEST_NODE_IP = GetTestGridNodeInfo.getHostName(BaseRemoteWebDriver.nodeURL.split(":")[1].substring(2), remoteDriver.getSessionId());  //"10.43.40.103"  IWebDriverSetting.TEAMCITY_HUB_HOSTNAME
                logger.info("Test Node IP is [" + TEST_NODE_IP + "]");
                System.setProperty("test.node.ip", TEST_NODE_IP);
                logger.info("System prop : test.node.ip ["+System.getProperty("test.node.ip")+"]");
                ReadWriteToFile.writeSmallTextFile(TEST_NODE_IP, TEST_NODEIP_FILE);
            } catch (Exception e) {
                logger.error("Cant get IP address of the node executing test ...!" + e.getMessage());
            } finally {
                if (remoteDriver != null) {
                    remoteDriver.quit();
                    logger.info("Before Class calls remoteDriver.quit() ...!");
                }
            }
        }else {logger .info("NO need to get IP address ....! isGetTestNodeIpAddress is :"+isGetTestNodeIpAddress);}

        try {
            TestUtil.usersFileLocation = ReadWriteToFile.getTestUserFilePath();
            TestUtil.userFilePath      = Paths.get("C:/work/testusers/"+TestUtil.getFileName(getENVIRONMENT())); //ReadWriteToFile.getFileLocation(TestUtil.usersFileLocation, TestUtil.RESOURCE_PATH, TestUtil.getFileName(getENVIRONMENT()));
            logger.info(" User File Path is :"+TestUtil.userFilePath.toString());
        }catch (Exception e){
            logger.error(" Failed to set up projectLocation : "+ TestUtil.getExceptionFirstLine(e)) ;
        }
    }

    /*******************************************************************************************************************
     * Write user data to file if isStoreData = true and set cookies to "" empty
     *
     * Note: Do Not use driver.close/.quit for Mobile drivers
     */
    @AfterTest
    public synchronized void tearDown(){
        testEndTime = System.currentTimeMillis();
        logger.info(" AfterTest tearDown...! Time :"+testEndTime) ;
        if(isNewhousePayment)
            ReadWriteToFile.storeDataNewHouse(isStoreData, userEmail, efId, orderId, getENVIRONMENT(), market);
        else
        ReadWriteToFile.storeData(isStoreData, userEmail, memberId, orderId, getENVIRONMENT(), market);
        /*if (!"safari".equals(BaseRemoteWebDriver.getCurrentBrowserName() ) ) {
            //CookieHandler.setCookies(getWebDriver(), BaseRemoteWebDriver.getCurrentBrowserName(), "");
        }*/
        //destroy();
        //destroyDriver();
        Long testTime = null;
        Long testTimeSec = null;
        
        try{
            if(testEndTime != null && testStartTime != null) {
                testTime = testEndTime - testStartTime;
            }
            testTimeSec = testTime/1000;
        }catch (NullPointerException | ArithmeticException ae){ae.printStackTrace();}
        logger.info("Test total time Miliseconds ["+testTime+"] and Seconds ["+testTimeSec+"]");
    }


    /**
     * Get WebDriver instance
     */

    public WebDriver getWebDriver() {
        return DriverManager.getDriver(); //webDriver;
    }

    public WebDriver getNewDriver(MyBrowserType myBrowserType, int waitTimeSec) {
        return  WebDriverFactory.getBrowser(myBrowserType, waitTimeSec);
    }



    protected void setWebDriver(WebDriver driver) {
        DriverManager.setWebDriver(driver); //this.webDriver = driver; //ThreadGuardedWebDriverFactory.getThreadGuardedWebDriver(driver);
    }

    /*******************************************************************************************************************
     * Destroy browser Wrapper
     */
    public synchronized void destroy(){
        logger.info("This destroy method does nothing now on parallel .. exe ...!");
        /*try{
            if(getWebDriver() != null) {
                //getWebDriver().quit();
                //webDriver = null;
                ThreadGuardedWebDriverFactory.destroyThreadGuardedWebDriver();
                destroyDriver();
            }
            //ThreadGuardedWebDriverFactory.destroyThreadGuardedWebDriver();
            logger.info("browser QUIT finally ...!");
        }catch (Exception e){
            logger.error(" Driver .quite throws error :"+e.getMessage());
        }*/
            //BaseRemoteWebDriver.destroyDriver(getWebDriver());
    }

    public static GridEnvironment getGridEnvironment() {
        return gridEnvironment;
    }

    public static void setGridEnvironment(GridEnvironment gridEnvironment) {
        BaseTestConfig.gridEnvironment = gridEnvironment;
    }

    /**
     * Set grid ENV from -D args in command line
     *
     */
    public static void setGridEnvironmentFromDargs() {
       // BaseTestConfig.gridEnvironment = GridEnvironment.BROWSERSTACK;
       BaseTestConfig.gridEnvironment = GridEnvironment.getGridEnvFromString(TestUtil.getProperty("grid"));
    }


    public String getStateObjectValue(String stateObjectElement,  boolean isLoadStateObject) {
        loadStateObject(isLoadStateObject);
        String currentStateObjectValue = englishtownStateObject.getStateObjectValueFromMap(englishtownStateObject.getStateObjectMap(), stateObjectElement);
        return currentStateObjectValue;
    }
    public void loadStateObject( boolean isLoadStateObject){
        if(isLoadStateObject){
            englishtownStateObject = new EnglishtownStateObject(getWebDriver());
            //this.getPage().getEnglishtownStateObject();
            englishtownStateObject.load(getWebDriver());                                     //String currentStateObjectValue = englishtownStateObject.getStateObjectValue(stateObjectElement);
            logger.info(" State object Loaded ...!");
        } else {logger.info(" State object reused - NOT reloaded") ; }

    }
    // double the above methods with driver
    public String getStateObjectValue(WebDriver driver, String stateObjectElement,  boolean isLoadStateObject) {
        loadStateObject(driver,isLoadStateObject);
        String currentStateObjectValue = englishtownStateObject.getStateObjectValueFromMap(englishtownStateObject.getStateObjectMap(), stateObjectElement);
        return currentStateObjectValue;
    }
    public void loadStateObject(WebDriver driver, boolean isLoadStateObject){
        if(isLoadStateObject){
            englishtownStateObject = new EnglishtownStateObject(driver);
            englishtownStateObject.load(getWebDriver());
            logger.info(" State object Loaded ...!");
        } else {logger.info(" State object reused - NOT reloaded") ; }

    }

    /*******************************************************************************************************************
     *    Getters
     ******************************************************************************************************************/
    public CardType getTestCardType() {
        return testCardType;
    }

    public void setTestCardType(CardType testCardType) {
        this.testCardType = testCardType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map getOffer(){
        return offer;
    }
    protected String getOfferPrice(){
        return getOffer().get("price").toString();
    }
    protected String getOfferCurrency(){
        return getOffer().get("currency").toString();
    }
    protected String getOfferPcode(){
        return getOffer().get("pcode").toString();
    }
    protected String getOfferId(){
        return getOffer().get("offerId").toString();
    }
    public String getMemberId(){
        return memberId;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public String getENVIRONMENT() {
        return ENVIRONMENT;
    }
    public String getBASEURL(){
        return BASE_URL;
    }
    public String getSCHOOL_URL(){
        return SCHOOL_URL;
    }
    public void setBASEURL( String startUrl ){
        this.BASE_URL = startUrl; //UrlMapper.mapETtoELive(BASE_URL)
    }
    /*******************************************************************************************************************
     *    Setters
     ******************************************************************************************************************/
    public void setUserMemberId(){
        memberId = getStateObjectValue(MEMBERID_KEY, true);
        logger.info("setUserMemberId memberId : "+memberId);
    }
    public void setUserMemberId(String memberId){
        this.memberId = memberId;
        logger.info("setUserMemberId memberId : "+memberId);
    }

    public void setEfId(String EfId){
        this.efId = EfId;
        logger.info("setUserEfId EfId : "+efId);
    }
    public void setUserEmail(){
        userEmail = getStateObjectValue(MEMBER_EMAIL_KEY, true);
        logger.info("setUserEmail userEmail : "+userEmail);
    }
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    public void setMarketFromStateObj(){
        market   = getStateObjectValue(MEMBER_MARKET_KEY, true);
        logger.info("setMarketFromStateObj - Market :"+market);
    }
    public void setMemberIdFromStateObj(){
        memberId   = getStateObjectValue(MEMBERID_KEY, false);
        logger.info("setMemberIdFromStateObj memberId : "+memberId );
    }

    public void setEfIdFromStateObj(){
        efId   = getStateObjectValue(EFID_KEY, true);
        logger.info("setEfIdFromStateObj EfId : "+efId );
    }

    public void setOrderIdFromStateObj(){
        if(isNewhousePayment)
            orderId   = getStateObjectValue(ORDER_ID_NEWHOUSE_KEY, true);
        else
        orderId   = getStateObjectValue(ORDER_ID_KEY, true);
        logger.info("setOrderIdFromStateObj order order_ID : "+orderId );
    }
    public void setOfferIdFromStateObj(){
        offer_id   = getStateObjectValue(OFFER_ID_KEY, false);
        logger.info("setofferIdFromStateObj order offer_ID : "+offer_id );
    }
    // language and market setting
    protected String getMarket() {
        return this.market;
    }
    protected String getLanguage() {
        return this.language;
    }
    protected void setLanguage(String language) {
        this.language = language;
    }
    protected void setMarket(String market) {
        this.market = market;
    }
    // this should be doen vie interface
    /**
     * Set the language and market for each of the test to run test verify language and verify market
     */
    protected void setLanguageAndMarket(String language, String market){
        logger.info(" setTestLanguageAndMarket () -> Lang ="+language+" Market ="+market);
        this.language = language;
        this.market   = market;
    }

    /*******************************************************************************************************************
     *   store user info to file,
     * ********************************************/
    public String memberId   = "notinit";
    public String userEmail  = "notinit";  // set it on setup from pap or get it form state obj
    public String userPass   = getPassword8();
    public String language  = "notinit";
    public String market     = "notinit";
    public static boolean isStoreData = false;
    public String orderId = "notinit";
    public String efId = "notinit";
    public String uuid = "notinit";  // bearer uuid token  // set this on payment page
    //keys
    public static final String MEMBERID_KEY      = "user.member_id";
    public static final String MEMBER_EMAIL_KEY  = "form.email";
    public static final String MEMBER_MARKET_KEY = "user.market";
    public static final String ORDER_ID_KEY       = "order.order_id";
    public static final String ORDER_ID_NEWHOUSE_KEY       = "order.Order_id";
    public static final String OFFER_ID_KEY       = "order.offer_id";
    public static final String EFID_KEY           = "session.efid";
    //--------------------------------------------------------------
    protected String emailId                 = "email";
    protected String passwordId              = "password";
    public String username;
    public String submitBtn    = "button.btn, form button.btn, [type*=submit]" ; //"form input.btn" ;   input.btn
    public String loginBtn     = "input.btn" ; //"form input.btn" ;   input.btn
    public EnglishtownStateObject englishtownStateObject ;
    public WebElement currWebElement;
    public String START_TEST_URL = "not init";
    public static final String[] userObjectNonExistentKeys = {"user.member_id","user.member_type","user.username"}  ;
    protected static String[] checkoutPaymenttEventListNoEmailEnglis =  {"MemberRegistration"}; ///,"MemberRevenue"
    protected static String[] checkoutPaymentEventListWithEmailEnglish =   {"MemberRegistration","EmailEnglish"}; //"MemberRevenue","EmailEnglishRevenue"
    protected static String[] payThankyouEventList  = { "OrderCreation","FTORevenue"};
    //@thank you page
    protected String member_id  = "notNull";   // user  member_id     =	29763177  not null
    protected String offer_id   = "";   // order  offer_id     =	9262
    protected String item_id    = "notNull";   // order items item_id =  3642891  [and name=Offer 1 EUR, quatity=1, type=Subscription]
    protected static final String MATCH_ANY_CHAR_ONE_OR_MORE_TIMES = ".{1,}";
    protected static final String MATCH_ANY_CHAR_TWO_OR_MORE_TIMES = ".{2,}";
    protected static final String MATCH_ANY_CHAR_THREE_OR_MORE_TIMES = ".{3,}";
    //
    public static final String JS_TRACKING_EF = "return window.s.trackingServer";
    public static final String JS_WINDOWS_S_OBJ = "return window.s";
    public static final String JS_WINDOWS_S_EVENTS_OBJ = "return window.s.events";
    public static final String TRACKING_SERVER = "efeducationfirst.112.2o7.net"  ;
    public static final String CONTAINS_TRACKING_SERVER = "efeducationfirst"  ;
    // checkout
    protected DynamicMemberPage         memberPage;
    protected DynamicPaymentMemberPage  paymentPage;
    protected PaymentThankyouPage       thankyouPage;
    protected EnrolmentPage             enrolmentPage;

    protected NewHouseStartEnrolmentPage newHouseStartEnrolmentPage;
    protected MotivationPage             motivationPage;
    protected EnglishLevelPage           englishLevelPage;
    protected StartLearningPage          startLearningPage;

    protected Map offer;

    // checkout flow old/new
    protected String creditCardLinkText;
    protected String paymentTabsListCss = ".nav.nav-tabs li a";  //a[href="#form_tabctrl_1"]   .nav.nav-tabs li'   $('li[tabindex=1]')
    protected String inputLastNameCss = "input[name='lastname']";
    protected int listSize = 1;
    // pay tabs
    public String tabsListWe = ".nav.nav-tabs li";
    public int tabId = 1;                // default second tab
    public boolean isClickTabId = true;  // set it to false if there is only one pay method
    protected String memberPageUrl;
    protected Map formDataMap;
    protected String payButtonSelector = "form_tabctrl_tab-0_button";
    protected String urlContainsThankyou = "thankyou";
    protected String urlContainsPayment  = "payment";

    //
    public static boolean is_SEND_EMAIL = false;

    public String getSubmitBtn() {
        return submitBtn;
    }
    public String getLoginBtn(){
        return loginBtn;
    }
    public void setSubmitBtn(String submitBtn) {
        this.submitBtn = submitBtn;
    }

    public String getTestStartUrl() {
        return testStartUrl;
    }

    public void setTestStartUrl(String testStartUrl) {
        this.testStartUrl = testStartUrl;
    }

    public boolean isBrowser(MyBrowserType browserType){
        return BaseRemoteWebDriver.isBrowser(browserType.getBrowser());
    }

    public String getTestCardNumber() {
        return testCardNumber;
    }

    public void setTestCardNumber(String testCardNumber) {
        this.testCardNumber = testCardNumber;
    }

    public static String getProjectName() {
        return projectName;
    }

    public static void setProjectName(String projectName) {
        BaseTestConfig.projectName = projectName;
    }

    public static String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        BaseTestConfig.buildNumber = buildNumber;
    }

    public void setProjectNameAndBuildNoFromDargs(){
        BaseTestConfig.projectName = getCiProjectNameFromDargs();
        BaseTestConfig.buildNumber = getCiBuildNumberFromDargs();
        logger.info("project name ["+projectName+"] BuildNo ["+buildNumber+"]");
    }



    /**
     * Set credit card number based on the environment
     * @param testEnvironment
     */
    public void setTestCardNumberPerEnv(String testEnvironment){
        logger.info("setCardNumberPerEnv ....!");
        switch (testEnvironment){
            case "live":
            case "staging":
                setTestCardNumber(CC_CARD_NO_LIVE);
                break;
            case "qa":
                setTestCardNumber(CC_CARD_NO_QA);
                break;
            default :
                logger.error("Invalid Environment ... Card number set to live card No ... 42{15}");
        }
        logger.info("Test Card Number set to["+getTestCardNumber()+"]");
    }

    public void setTestCardNumber(String testEnvironment, CardType cardType){
        logger.info("setCardNumberPerEnv ....!");
        switch (cardType){
            case VISA:
                 if(StringUtils.equals(testEnvironment,"qa"))
                     setTestCardNumber(CC_CARD_NO_QA);

                 if(StringUtils.equals(testEnvironment,"live") && isNewhousePayment)
                     setTestCardNumber(CC_CARD_NO_QA);

                break;
            case MASTERCARD:
                setTestCardNumber(MASTERCARD_CARD_NUM);
                break;
            case MAESTRO:
                setTestCardNumber(MAESTRO_CARD_NUM);
                break;
            case AMEX:
                setTestCardNumber(AMEX_CARD_NUM);
                break;
            case DISCOVER:
                setTestCardNumber(DISCOVER_CARD_NUM);
                break;
            case DINE:
                setTestCardNumber(DINE_CARD_NUM);
                break;
            case JCB:
                setTestCardNumber(JCB_CARD_NUM);
                break;
            /*case PAYPAL:
                setTestCardNumber(PAYPAL_CARD_NUM);
                break;
            case CASHU:
                setTestCardNumber(CASHU_CARD_NUM);
                break;
            case DIRECTDEBIT:
                setTestCardNumber(DIRECTDEBIT_CARD_NUM);
                break;
            case SEPA:
                setTestCardNumber(SEPA_CARD_NUM);
                break;*/
            case VISA_WEBPAY:
                setTestCardNumber(VISA_WEBPAY);
                break;
            default :
                logger.error("Invalid Environment or CardType [ "+testEnvironment+" - "+cardType.getCardType()+" ]");
        }
        logger.info("Test Card Number set to["+getTestCardNumber()+"]");
    }



    /*************************************************************************************************
     *
     *                 Parallel execution configuration
     *
     *$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
     */
    protected void destroyDriver(){
        logger.info("Start destroyDriver.......!");
        try {
            if (getWebDriver() != null) {
                getWebDriver().quit();
                logger.info("webDriver Destroyed ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
            if(null != webDriver)
                webDriver.quit();
            //DriverManager.destroyLocalDriver();
        }catch (Exception e){
            logger.error("Destroy  webDriver failed :"+e.getMessage());
        }
        setWebDriver(null);
        logger.info("BaseTestConfig webDriver set to null ...!");
    }

    protected void destroyDriver(WebDriver driver){
        logger.info("Start destroyDriver.......!");
        try {
            if (driver != null) {
                driver.quit();
                logger.info("webDriver Destroyed ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
        }catch (Exception e){
            logger.error("Destroy  webDriver failed :"+e.getMessage());
        }
        driver = null;
        logger.info("BaseTestConfig webDriver set to null ...!");
    }

    /**
     * get driver or throw error if driver not set/init
     * @return
     */
    protected WebDriver getThreadSafeDriver(){
        logger.info("getThreadSafeDriver [threadSafeDriver]...!");
        if(null != webDriver){
            return webDriver;
        }else {
            logger.error("Driver is null . Not init ...!");
            throw new WebDriverNotInitialisedException();
        }
    }

    /**
     * this method create new driver and set threaded driver to the new created driver
     */
    @Override
    public void setThreadSafeDriver(){
        WebDriverFactory.setTestOnBrowserNameFromDargs();
        webDriver = DriverManager.getNewDriver(MyBrowserType.getMyBrowserTypeFromString(
                WebDriverFactory.getTestOnBrowserName()), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    /**
     *
     * @param browserType
     * @param waitTimeSec
     */
    @Override
    public void setThreadSafeDriver(MyBrowserType browserType, int waitTimeSec) {
        webDriver = DriverManager.getNewDriver(browserType, waitTimeSec);
    }

    public void setThreadSafeDriver( int waitTimeSec) {
        WebDriverFactory.setTestOnBrowserNameFromDargs();
        webDriver = DriverManager.getNewDriver(MyBrowserType.getMyBrowserTypeFromString(
                WebDriverFactory.getTestOnBrowserName()), waitTimeSec);
    }

    public void setTestName(String name) {
        testName = name;
    }

    public static String getTestName( ) {
        return testName ;
    }
    public static String getPassword8(){
        return PASSWORD8;
    }

    public String getCiProjectNameFromDargs(){
        if(StringUtils.isBlank(TestUtil.getProperty("projectName") ))
            return "IdeRun";
        else
            return TestUtil.getProperty("projectName");
    }

    public String getCiBuildNumberFromDargs(){
        if(StringUtils.isBlank(TestUtil.getProperty("buildNumber") ))
            return "no";
        else
            return TestUtil.getProperty("buildNumber");
    }

}

