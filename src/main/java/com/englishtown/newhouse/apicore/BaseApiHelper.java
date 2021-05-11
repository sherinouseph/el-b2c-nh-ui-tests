package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 *
 */
// In order to use REST assured effectively it's recommended to statically
// import methods from the following classes:
// import io.restassured.RestAssured.*;
// import io.restassured.matcher.RestAssuredMatchers.*;
// import io.restassured.http.ContentType;
//  String port = System.getProperty("server.port");
// TODO: need to think about setting baseURI and basePath for each test

import com.englishtown.commerceclient.ActionResult;
import com.englishtown.commerceclient.Environment;
import com.englishtown.commerceclient.Wrapper;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.enumpack.GridEnvironment;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
import com.englishtown.newhouse.apicore.bean.ExtraInfoReqBean;
import com.englishtown.newhouse.apicore.bean.PaymentTechExtraInfoReqBean;
import com.englishtown.newhouse.school.pages.StudyCoursePlanPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.pages.checkout.newcheckout.DynamicPaymentMemberPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.services.MyHttpClient;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.UniqueDataObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.testng.Assert.fail;

@ContextConfiguration(locations = {"/applicationContext-test.xml"})
@Configuration
public abstract class BaseApiHelper extends AbstractTestNGSpringContextTests implements IBaseApiTest{
    public static final Logger logger = LoggerFactory.getLogger(BaseApiHelper.class);

    @Value("#{applicationPropertiesList['env.id']}")
    public String ENVIRONMENT;
    @Value("#{applicationPropertiesList['base.url']}")
    public String BASE_PROFILE_URL;

    protected ChatTestUserBean chatTestUserBean1;
    protected ChatTestUserBean chatTestUserBean2;
    protected ChatTestUserBean chatTestUserBean3;
    protected List<ChatTestUserBean> chatTestUserList = new ArrayList<ChatTestUserBean>();

    public List<ChatTestUserBean> getChatTestUserList() {
        return chatTestUserList;
    }

    protected PaymentThankyouPage thankyouPage;


    protected WebDriver webDriver;
    private String protocol = "http://";
    /**
     * Each test should set base url and path
     */
    private String baseURI;       // base url for the ENV   RestAssured.baseURI
    private String basePath;      // path for the request based on project
    private String port;          // not used currently

    protected String testBaseUrl; // each test should set this up // change user testApiUrl
    protected String testApiUrl;  // each test should set this up // replace the above
    protected boolean isClickTabOnPaymentPage = false;  // click on tab on payment page
    protected int paymentPageTabId = 0;  // click on tab on payment page

    protected RequestSpecBuilder    requestSpecBuilder;
    protected ResponseSpecBuilder   responseSpecBuilder;
    protected RequestSpecification  requestSpecification;
    protected ResponseSpecification responseSpecification;
    protected Response response ;
    protected boolean isNewHouseCheckout = false;
    protected boolean isNewHousePayment = true;
    protected boolean isNewHouseEnroll   = false;
    protected boolean isNewHouseLogin    = false;
    protected boolean cancelSubscription = true;
    public String jsonFileName;
    protected ExtraInfoReqBean reqBean;
    protected PaymentTechExtraInfoReqBean payTechReqBean;
    // expected response checks
    protected String expectedGatewayType;
    protected String expectedContentType = "application/json";
    protected String expectedResponseCtr;
    protected int expectedResponseCode   = 200;
    protected  boolean expectedIsSucceed = true ;
    protected String expectedError = null;

    private String host                  = "paymentgateway.vagrant.f8"; //"10.24.208.122:8080";
    private String basePathPaymentGetway = "/paymentflow/standalone";
    public String commerceRestApi       = protocol+host+basePathPaymentGetway;


    public String BASE_TEST_URL = BASE_QA_URL;

    public static String environment = "qa";

    protected String baseUrl = "https://school.vagrant.f8/";
    protected String studyPlanUrl = "school/studyplan?icid=School.StudyPlan.2013";  // or my course

    protected StudentBean studentBean;
    List<StudentBean> studentBeanList = new ArrayList<>(); // hold a list of the above student bean

    protected String school_Id    = "b2c.englishlive";
    protected String businessUnit =  "b2c";
    protected String userEmail; // test should set this up
    protected String user_id;   //  ==||==
    protected String student_level_name = "BEGINNER"; // default level name Beginner
    protected String student_level = "1"; // default level 1
    protected String student_current_unit = "Unit 1";    // Unit 1-6 unit-navigator
    protected int studentLessonNumber = 3;


    //public String commerceRestApi       = protocol+host
    //API end point
    protected String efIdBaseUrl                       = "https://qa-accounts.ef.com/oauth2/users";
    protected String schoolServicesBaseUrl             = "http://school-gateway.vagrant.f8"; // -service
    protected String schoolServiceCreateStudentBaseUrl = schoolServicesBaseUrl+"/admin/create/student";
    protected String schoolServiceCreateAccountBaseUrl = schoolServicesBaseUrl+ "/admin/create/account";
    protected String schoolServiceEnrollBaseUrl        = schoolServicesBaseUrl+ "/admin/enroll";
    protected String schoolServicePatchAccountBaseUrl  = schoolServicesBaseUrl+ "/admin/patch/account";
    protected String schoolServiceAdminCreateAccUrl    = schoolServicesBaseUrl+ "/admin/account/"; //PATCH /admin/account/{EFId}/grants

    protected String campusEnrolmentBaseUrl            = "http://campus-enrollment.vagrant.f8/enrollment/";
    protected String campusMemberEnrollUrl             = campusEnrolmentBaseUrl+"member";
    protected String campusEnrolmentMotivationUrl      = campusEnrolmentBaseUrl+"motivation";
    protected String campusEnrolmentLevelUrl           = campusEnrolmentBaseUrl+"level";
    // commerce  http://commerce.vagrant.f8/swagger/
    protected String commerceBaseUrl               = "http://commerce.vagrant.f8/";
    protected String commerceCreateMemberUrl       = commerceBaseUrl + "Member/Create";
    protected String commercePurchaseOfferUrl      = commerceBaseUrl + "Purchase/BuyOfferWithCreditCardSoap";
    protected String commerceGetSubscriptionUrl    = commerceBaseUrl + "subscription/";  // GET /subscription/{efid} pathparam
    protected String commerceCancelMemberUrl       = commerceBaseUrl + "Member/Cancel";
    protected String commerceMarkCancelMemberUrl   = commerceBaseUrl + "Member/MarkCancelled";
    protected String commerceUnmarkCancelMemberUrl = commerceBaseUrl + "Member/UnmarkCancelled";
    protected String commerceSuspendMemberUrl      = commerceBaseUrl + "Member/Suspend";
    protected String commerceResumeMemberUrl       = commerceBaseUrl + "Member/Resume";
    protected String commerceGetOfferUrl           = commerceBaseUrl + "offer/";   //{id} path
    protected String commerceValidateOfferUrl  ;
    protected String commerceGetOrderUrl           = commerceBaseUrl + "Order/Get";

    /*******************************************************************************************************************
     * commerce.api  calls commerce services ....
     *
     */
    protected String commerceApiGetAccountDetailsUrl  = COMMERCE_GATEWAY_BASE_URL + "account";
    protected String commerceApiGetIsOldLoginUrl      = COMMERCE_GATEWAY_BASE_URL + "member/use-old-login-handler";

    // member
    protected String commerceApiBaseUrl                = "removed/use/COMMERCE_GATEWAY_BASE_URL";
    protected String commerceApiLeadUrl                = COMMERCE_GATEWAY_BASE_URL + "lead";
    protected String commerceApiGetMemberUrl           = COMMERCE_GATEWAY_BASE_URL + "member";
    protected String commerceApiCancelSubscriptionUrl  = COMMERCE_GATEWAY_BASE_URL + "member/Cancel";
    protected String commerceApiUpdateMemberUrl        = COMMERCE_GATEWAY_BASE_URL + "member/Update";
    protected String commerceApiCreateMemberUrl        = COMMERCE_GATEWAY_BASE_URL + "member";
    protected String commerceApiMemberTockenAccountUrl = COMMERCE_GATEWAY_BASE_URL + "member/payment-token-account";

    // base security Proxy
    protected String BASE_SECURITY_PROXY_URL = "http://api.vagrant.f8/";
    // Payment   //school
    protected String commerceApiGetMemberPayInfoUrl           = COMMERCE_GATEWAY_BASE_URL + "member/subscription";
    protected String commerceApiGetStudentTypeUrl             = COMMERCE_GATEWAY_BASE_URL + "member/student-type";
    protected String commerceApiBuyWithCreditCardUrl          = COMMERCE_GATEWAY_BASE_URL + "order/credit-card-capture";
    protected String commerceApiBuyWithExistingPaymentInfoUrl = COMMERCE_GATEWAY_BASE_URL + "payment/BuyWithExistingPaymentInfo";
    protected String commerceApiBuyWithDebitCardUrl           = COMMERCE_GATEWAY_BASE_URL + "payment/BuyWithDebitCard";
    protected String commerceApiBuyWithDirectDebitUrl         = COMMERCE_GATEWAY_BASE_URL + "order/direct-debit-capture";
    // Offer
    protected String commerceApiGetOfferUrl           = COMMERCE_GATEWAY_BASE_URL + "offer/";
    protected String commerceApiValidateOfferUrl      = COMMERCE_GATEWAY_BASE_URL + "/offer/student-validate-offers" ;
    // Order
    protected String commerceApiGetOrderUrl           = COMMERCE_GATEWAY_BASE_URL + "order/";
    protected String commerceApiGetOrderRedeemUrl     = COMMERCE_GATEWAY_BASE_URL + "order/redeem";
    protected String commerceApiValidateRCodeUrl      = COMMERCE_GATEWAY_BASE_URL + "redemption/"; //+{code}/validate";
    protected String commerceApiGetOrderRecurUrl      = COMMERCE_GATEWAY_BASE_URL + "order/Recur";
    protected String commerceApiOrderPaymentTokenUrl  = COMMERCE_GATEWAY_BASE_URL + "order/payment-token-capture";
    //------------------------------------------------------------------------------------------------------------------
    // notification
    protected static String STUDENT_NOTIFICATION = "api/student-settings/v1/student/settings/notifications";


    // Chat end points

    protected static String chat_base        = "/chat/2.0/";
    protected static String chat_base_url    = chat_base;
    protected static String chat_friend      = chat_base_url+"friend/";
    protected static String chat_message     = chat_base_url+"message";
    protected static String chat_status      = chat_base_url+"status/";  // +{id,id1,id2}
    protected static String chat_search      = "/1/shared/api-legacy/chat-profile/v1/_search";

    protected static String login_handler    = "/login/handler.ashx";

    // User setting  New House PUT
    protected static String user_setting_newhouse = "/1/shared/api/user-settings/v1/users/settings/chat";

    /**
     *
     */
    protected static final String CONTACT_DETAILS_ENDPOINT = "api/commerce-gateway/contact/details?email=";

    protected static String migrate_qa_user    = "http://qa.englishtown.com/chat/2.0/legacyfriend/"; //+11416354/migrate";
    protected static String migrate_qa_user_x_ef_access    = "eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleXMvcHVibGljL2NoYXQvY2hhdC5wZW0ifQ.eyJpc3MiOiJjaGF0IiwiZXhwIjoxNTUzNjYwODg0LCJpYXQiOjE1MjIxMjQ4ODR9.eIh2fWNVAf_8l7EDs-DXMO5tjMmIz_DzJ6JfSls2dApQdCa_jqrAArrh4wROk3vjHR2zD5Ps3qVArcWEnAt4fKZL-Eeb4vBcHu4Qw0uMWu7EWQKGcz10q1cyQ1tKxmCLpn-9mb0nOwWPiGTcJ_uxvfcxq5izmR8bW5zcbVU8pFU";


    protected String user1_cookie_et_sid = "";
    protected String user1_cookie_cmus = "";
    protected String user2_cookie_et_sid = "";
    protected String user2_cookie_cmus = "";

    //****************************************** end chat
    protected String debugRequest = "?svc_debug";


    protected boolean isPatchAccount = false;

    protected boolean isRunGetMemberAndHasEnrol = false;
    protected boolean isSchoolEnrolment = true;

    protected String reqHeaderUsername = "paymentgateway";
    protected String reqHeaderHostname = "b2cLondonAutoTeam";


    /**
     * Maps
     */
    protected Map memberFormDataMap;
    protected Map paymentFormDataMap;
    /**
     * Common selectors
     */
    protected String loginSubmitButtonCss = ".form-group button";
    public static String memberSpinnerCss = ".container-fluid .spinner";
    protected String paymentTabsListCss = ".nav.nav-tabs li a";
    public String paymentSubmitBtnCss = "div.active .bs3 .btn";
    protected int payTabId = 0;


    public static final String BASECALLBACK      = "var callback = arguments[arguments.length - 1];"+ "et.state.get('";
    public static final String BASECALLBACKTHEN  = "').then(function(v){callback(v[0])})";
    public static final String MEMBERID_KEY      = BASECALLBACK + "user.member_id" + BASECALLBACKTHEN;
    public static final String EFID_KEY          = BASECALLBACK + "user.ef_id" + BASECALLBACKTHEN;
    public static final String MEMBER_EMAIL_KEY  = BASECALLBACK + "form.email" + BASECALLBACKTHEN;
    public static final String MEMBER_MARKET_KEY = BASECALLBACK + "user.market" + BASECALLBACKTHEN;
    public static final String ORDER_ID_KEY      = BASECALLBACK + "order.order_id" + BASECALLBACKTHEN;

    /**
     * POMs
     */
    protected SchoolHomePage schoolHomePage;
    protected StudyCoursePlanPage studyCoursePlanPage;


    protected void initReqAndResponseSpecBuilder(){
        requestSpecBuilder    = new RequestSpecBuilder();
        responseSpecBuilder   = new ResponseSpecBuilder();
    }

    protected void intResponseBuilder(){
        responseSpecBuilder = new ResponseSpecBuilder();
    }

    /**
     * Instead of having to duplicate response expectations and/or request parameters for different
     * tests you can re-use an entire specification. To do this you define a specification using either
     * the RequestSpecBuilder or ResponseSpecBuilder.
     */
    public RequestSpecBuilder getRequestSpecBuilder() {
        return requestSpecBuilder;
    }

    public void setRequestSpecBuilder(RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
    }

    /**
     * @param paramKeyValue
     */
    public void addRequestSpecBuilderParam( Map<String, String> paramKeyValue ) {
        if(!paramKeyValue.isEmpty()) {
            requestSpecBuilder.addParams(paramKeyValue);
        }else
            logger.warn("Map is empty or null ....!");
    }

    public void addRequestSpecBuilderHeader( Map<String, String> headerKeyValue ) {
        if(!headerKeyValue.isEmpty()) {
            requestSpecBuilder.addHeaders(headerKeyValue);
        }else
            logger.warn("Map is empty or null ....!");
    }

    public void addRequestSpecBuilderBody(ExtraInfoReqBean reqBean) {
        if(null != reqBean) {
            requestSpecBuilder.setBody(reqBean);
        }else
            logger.warn("Map is empty or null ....!");
    }

    // RESPONSE
    public void setExpectedResponseCode( int responseCode ) {
        responseSpecBuilder.expectStatusCode(responseCode);
    }

    public void setExpectedResponseSuccess( boolean isSuccess ) {
        responseSpecBuilder.expectBody("Success", is(isSuccess));
    }
    public void setExpectedResponseCodeAndSuccess(int responseCode, boolean isSuccess){
        responseSpecBuilder.expectStatusCode(responseCode);
        responseSpecBuilder.expectBody("Success", is(isSuccess));
    }

    public ResponseSpecification buildRequestSpec(int responseCode ) {
        ResponseSpecification responseSpec = responseSpecBuilder.build();
        return responseSpec;
    }

    public ResponseSpecBuilder getResponseSpecBuilder() {
        return responseSpecBuilder;
    }

    public void setResponseSpecBuilder(ResponseSpecBuilder responseSpecBuilder) {
        this.responseSpecBuilder = responseSpecBuilder;
    }


    //-------------------------------

    public String getTestBaseUrl() {
        return testBaseUrl;
    }

    public void setTestBaseUrl(String testBaseUrl) {
        this.testBaseUrl = testBaseUrl;
    }


    public String getTestApiUrl() {
        return testApiUrl;
    }

    public void setTestApiUrl(String testApiUrl) {
        this.testApiUrl = testApiUrl;
    }

    public void setTestApiUrl() {
        this.testApiUrl = getBaseURI()+getBasePath();
        logger.info("setTestApiUrl [{}]", testApiUrl);
    }


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }

    public void setResponseSpecification(ResponseSpecification responseSpecification) {
        this.responseSpecification = responseSpecification;
    }

    public String getTestDataFile( String fileName){
        return RestUtil.getTestDataFile(fileName);
    }

    public String getBaseURI() {
        return baseURI;
    }

    public String getBaseURI(String environment) {
        if(StringUtils.contains(environment, "qa"))
            return BASE_QA_URL;
        else if(StringUtils.contains(environment, "stg"))
            return BASE_STG_URL;
        else if(StringUtils.contains(environment, "live"))
            return BASE_LIVE_URL;
        else
            return null;

    }

    public String getENVIRONMENT() {
        return ENVIRONMENT;
    }

    public String getBASE_PROFILE_URL(){
        return BASE_PROFILE_URL;
    }

    public void setBASE_PROFILE_URL( String startUrl ){
        this.BASE_PROFILE_URL = startUrl;
    }


    public String getBASE_TEST_URL() {
        return BASE_TEST_URL;
    }

    public void setBASE_TEST_URL(String BASE_TEST_URL) {
        this.BASE_TEST_URL = BASE_TEST_URL;
    }


    public void setBaseURI(String baseURI) {
        logger.info("setBaseURI to [{}]", baseURI);
        this.baseURI = baseURI;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void cleanUp() {
        logger.info("Clean up ....!");
        requestSpecBuilder = null;
        responseSpecBuilder = null;
        requestSpecification = null;
        responseSpecification = null;
        reqBean = null;
    }

    /**
     * build
     */
    public RequestSpecification buildDefaultRequestSpecBuilder(String bodyJsonString){
        setBodyRequestSpecBuilder(bodyJsonString);
        setDefaultFilterReqSpecBuilder();
        return requestSpecBuilder.build();
    }

    public RequestSpecification buildDefaultRequestSpecBuilder(Map bodyMap){
        setBodyRequestSpecBuilder(bodyMap);
        setDefaultFilterReqSpecBuilder();

        return requestSpecBuilder.build();
    }

    public RequestSpecification buildDefaultRequestSpecBuilderWithContentType(String bodyStr, ContentType contentType){
        requestSpecBuilder.setContentType(contentType);
        setBodyRequestSpecBuilder(bodyStr);
        setDefaultFilterReqSpecBuilder();
        return requestSpecBuilder.build();
    }

    public RequestSpecification buildDefaultRequestSpecBuilderWithContentType(Map bodyMap, ContentType contentType){
        requestSpecBuilder.setContentType(contentType);
        setBodyRequestSpecBuilder(bodyMap);
        setDefaultFilterReqSpecBuilder();
        return requestSpecBuilder.build();
    }

    public RequestSpecification setDefaultFilterRequestSpecBuilder(){
        setDefaultFilterReqSpecBuilder();
        return requestSpecBuilder.build();
    }
    /**
     * Get a request spec builder and add json body and default filters
     * @param bodyJsonString
     * @return
     */
    public void setBodyRequestSpecBuilder(String bodyJsonString){
        requestSpecBuilder.setBody(bodyJsonString);
    }
    public void setBodyRequestSpecBuilder(Map bodyMap){
        requestSpecBuilder.setBody(bodyMap);
    }
    /**
     * Set default filters
     * @return
     */
    public void setDefaultFilterReqSpecBuilder(){
        requestSpecBuilder
                        .addFilter(new ResponseLoggingFilter())
                        .addFilter(new RequestLoggingFilter())
                        .setRelaxedHTTPSValidation();
    }

    public void setDefaultFilterReqSpecBuilder(RequestSpecBuilder requestSpecBuilder){
        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();
    }


    /**
     *  WEBDRIVER
     *
     * Each test need to specifically create driver and destroy it
     *
     */
    public void createThreadSafeDriver() {
        WebDriverFactory.setTestOnBrowserNameFromDargs();
        webDriver = DriverManager.getNewDriver(MyBrowserType.getMyBrowserTypeFromString(
                WebDriverFactory.getTestOnBrowserName()), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    public void createThreadSafeDriver(MyBrowserType browserType) {
        webDriver = DriverManager.getNewDriver(browserType, WaitTool.MED_WAIT_4_ELEMENT25);
    }

    public WebDriver getThreadSafeDriver() {
        WebDriverFactory.setTestOnBrowserNameFromDargs();
        return webDriver = DriverManager.getNewDriver(MyBrowserType.getMyBrowserTypeFromString(
                WebDriverFactory.getTestOnBrowserName()), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    protected void destroyDriver(){
        logger.info("BaseApiTest tart destroyDriver.......!");
        try {
            if (webDriver != null) {
                webDriver.quit();
                logger.info("webDriver Destroyed ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
        }catch (Exception e){
            logger.error("Destroy  webDriver failed :"+e.getMessage());
        }
        webDriver = null;
        logger.info("BaseApi webDriver set to null ...!");
    }

    protected void destroyDriver(WebDriver webDriver){
        logger.info("BaseApiTest tart destroyDriver.......!");
        try {
            if (webDriver != null) {
                webDriver.quit();
                logger.info("webDriver Destroyed ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
        }catch (Exception e){
            logger.error("Destroy  webDriver failed :"+e.getMessage());
        }
        webDriver = null;
        logger.info("BaseApi webDriver set to null ...!");
    }

    public WebDriver getWebDriver() {
        return DriverManager.getDriver(); //return webDriver;
    }

    public static void setGridEnvironmentFromDargs() {
        //BaseTestConfig.gridEnvironment = GridEnvironment.TC_GRID;
        BaseTestConfig.gridEnvironment = GridEnvironment.getGridEnvFromString(TestUtil.getProperty("grid"));
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public String getUser1_cookie_et_sid() {
        return user1_cookie_et_sid;
    }

    public void setUser1_cookie_et_sid(String user1_cookie_et_sid) {
        this.user1_cookie_et_sid = user1_cookie_et_sid;
    }

    public String getUser1_cookie_cmus() {
        return user1_cookie_cmus;
    }

    public void setUser1_cookie_cmus(String user1_cookie_cmus) {
        this.user1_cookie_cmus = user1_cookie_cmus;
    }


    public String getUser2_cookie_et_sid() {
        return user2_cookie_et_sid;
    }

    public void setUser2_cookie_et_sid(String user2_cookie_et_sid) {
        this.user2_cookie_et_sid = user2_cookie_et_sid;
    }

    public String getUser2_cookie_cmus() {
        return user2_cookie_cmus;
    }

    public void setUser2_cookie_cmus(String user2_cookie_cmus) {
        this.user2_cookie_cmus = user2_cookie_cmus;
    }


    /**
     *
     */
    protected DynamicMemberPage memberPage;



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
        waitForSpinnerDisappear();
        initMemberPage(driver);
        TestUtil.enterFormData(driver, memberMap);
        enterEmail(driver, true);
        chatTestUserBean.setUserName(userEmail);
        memberPage.submit();
        logger.info("Member page submitted ....!");

        clickTab(isClickTab, driver, tabId);
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(paymentSubmitBtnCss), getWebDriver(), 25);
        removePaymentValidation(driver, isNewHousePayment);
        waitForSpinnerDisappear();

        //if(!StringUtils.equalsIgnoreCase(getENVIRONMENT(), "live")) {
            if (isNewHousePayment)
                paymentMap = TestUtil.setMapKeyValue(EfConstants.ukMembersPayMap_new, "CreditCardNumber", "4111111111111111");
       // }

        TestUtil.enterFormData(driver, paymentMap);

        String uuid = CookieHandler.getUUID(getWebDriver());
        logger.info("UUID IS [{}]", uuid);
        chatTestUserBean.setUuid(uuid);

        WebElement submitElement = findElement(driver, By.cssSelector(paymentSubmitBtnCss), 15);
        click(submitElement);

        try{Thread.sleep(3000);}catch (Exception e){}
        waitForSpinnerDisappear();
        logger.info("Pay page submitted ....!");
        PaymentThankyouPage paymentThankyouPage = new PaymentThankyouPage(driver, 35) ;
        paymentThankyouPage.getPageLoadedCondition(isNewHouseCheckout);
       // paymentThankyouPage.waitForPageToLoad(paymentThankyouPage.getPageLoadedCondition());
        //ty page .btn.btn-primary
        paymentThankyouPage.simpleTest(isNewHouseCheckout);
        chatTestUserBean.setUserId(JavaScriptHelper.executeAsyncScript(MEMBERID_KEY, driver, 35));
        chatTestUserBean.setEfId(JavaScriptHelper.executeAsyncScript(EFID_KEY, driver, 10));


        /*click(paymentThankyouPage.startLearningNewCheckOut);
        BaseTest.sleep(3000);

        // enroll
        BasePage.waitForUrlContains(driver, "enrollment/b2c/entrance", 35);
        //enrolStudentCheckAtSchool();
        enrolStudentCheckAtSchool(isNewHouseEnroll, 1, 1);*/


        if(isNewHouseCheckout) {
            WaitTool.waitForElementVisibleAndClickable(By.cssSelector(".btn.btn-primary"), driver, WaitToolConfig.MED_WAIT_4_ELEMENT25);
            click(paymentThankyouPage.startLearningNewCheckOut);
            BasePage.waitForUrlContains(driver, "enrollment", 35);
        }
        else {
            WaitTool.waitForElementVisibleAndClickable(By.className("btn-lg"), driver, WaitToolConfig.MED_WAIT_4_ELEMENT25);
            click(paymentThankyouPage.startLearning);
        }
        BaseTest.sleep(3000);
        //click_StartLearning();        // enroll
        enrolStudentCheckAtSchool(isNewHouseEnroll, 1, 1);

        logger.info("User created...!\n"+chatTestUserBean.toString()+"\n ---------------\n");

        return chatTestUserBean;
    }

    public void click_StartLearning(){
        logger.info("click start learning ...!");
        try{ Thread.sleep(2000);}catch (InterruptedException e){}
        thankyouPage = new PaymentThankyouPage(getWebDriver()) ;
        if(isNewHouseCheckout)
            click(thankyouPage.startLearningNewCheckOut);
        else
            click(thankyouPage.startLearning);
        try{ Thread.sleep(3000);}catch (InterruptedException e){}
    }

    public void enrolStudentCheckAtSchool(boolean isNewHouseEnroll, int motivationId, int levelId) {
        if(isNewHouseEnroll){
            logger.info("is new house enrol ...!");
            click(findElement(getWebDriver(), By.tagName("button"), 35));
            enrolStudentCheckAtSchoolNewHouse(motivationId, levelId);
        }else {
            logger.info("is old house enrol ...!");
            enrolStudentCheckAtSchool();
        }

    }

    public void enrolStudentCheckAtSchoolNewHouse(int motivationId, int levelId) {
        MotivationPage motivationPage = new MotivationPage(getWebDriver());
        //enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        motivationPage.clickToSelectMotivation(motivationId);
        // Step 2
        try{ Thread.sleep(2000);}catch (InterruptedException e){}
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        //enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        // enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        englishLevelPage.selectEnglishLevel(levelId);
        englishLevelPage.clickStartLearning();
        try{ Thread.sleep(2000);}catch (InterruptedException e){}
        //waitForUrlContains(getWebDriver(), "campus", 55);        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"campus","Not the expected URL ...!");
    }

    public void waitForSpinnerDisappear(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    public void initMemberPage(WebDriver driver){
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=firstname]"), driver, WaitTool.MED_WAIT_4_ELEMENT);
        memberPage = new DynamicMemberPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        memberPage.simpleTest();
    }

    /**
     * Enter email and set userEmail
     * @param driver
     * @param isSendKeyTab
     */
    public void enterEmail(WebDriver driver, boolean isSendKeyTab){
        UniqueDataObject udo = new UniqueDataObject();
        WebElement we =  WaitTool.findElement(driver, By.name("email"));
        WebElementHelper.sendKeys(driver, we, udo.getEmail(), false);
        if(isSendKeyTab) {
            we.sendKeys(Keys.TAB);
            we.sendKeys(Keys.TAB);
        }
        logger.info("(email) : " + udo.getEmail());
        userEmail = udo.getEmail();
    }

    public void clickTab(boolean isClickTab, WebDriver driver, int tabId){
        waitForSpinnerDisappear();
        if (isClickTab) {
            findElement(driver, By.cssSelector(paymentTabsListCss), 15);
            List<WebElement> tabsWe = WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(paymentTabsListCss), 15);
            click(tabsWe.get(tabId));
            BaseTest.sleep(1000);
            logger.info(" Tab clicked ...!");
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
    }


    /**
     * New house
     * Cancel user subscription
     *
     */
    public void cancelSubscription(String userEFId ){
        logger.info("Cancel subscription for user EFID [{}]", userEFId);

        if(StringUtils.isBlank(userEFId))
            failTest("Can't cancel Subscription for NULL EFID or blank ["+ userEFId+"]");

        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            if(cancelSubscription)
                MyHttpClient.cancelOrSuspendSubscriptionNewHouse(getENVIRONMENT(), userEFId, true);
            else
                logger.info("Subscription for user EFID {{}} is not canceled 'cancelSubscription is false'...!", userEFId);
        } else {
            logger.info("Subscription for user EFID {{}} is not canceled as this is not live ENV ...!", userEFId);
        }
    }

    /**
     * OLD house
     * @param email
     */
    public void cancelUserSubscription_OldHouse(String email){
        logger.info("Cancel Subscription for user {{}}", email);
        try{
            Wrapper client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
            ActionResult result = client.cancelSubscriptionByEmail(email);
            AssertHelper.assertThat("Failed to cancel subscription ...", result.getSucceed(), Matchers.is(true) );
            logger.info("    <<<<<<<<       Subscription Cancelled OK ...! {{}}  >>>>>>>>>", email );
        } catch (AssertionError ae) {
            ae.printStackTrace();
            logger.error("Could not Cancel subscription ....!"+ae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            // Should not fail the test if user not cancelled but how should I know if this is working ... so have to
            logger.error("Could not Cancel subscription ....!"+e.getMessage());
            //BasePage.failTest(e, "Cancel Subscription failed ...!");
        }
    }
    /*
    public void cancelUserSubscription_OldHouse(int memberId){
        try{
            Wrapper client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
            ActionResult result = client.cancelSubscriptionForMember(memberId); //Integer.parseInt
            myAssertThat(getWebDriver(), "Failed to cancel subscription ...", result.getSucceed(), true);
        } catch (Exception e) {
            BasePage.failTest(e, "Cancel Subscrition failed ...!");
        }
    }

    public void cancelSubscription(String email){
        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            if(cancelSubscription)
                cancelUserSubscription_OldHouse(email);
            else
                logger.info("Subscription for user {{}} is not canceled 'cancelSubscription is false'...!", email);
        } else {
            logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", email);
        }
    }*/

    /**
     * Find visible Element
     * @param webDriver
     * @param selector
     * @param waitTimeSec
     * @return
     * @throws NullPointerException
     */
    public WebElement findElement(WebDriver webDriver, By selector, int waitTimeSec) throws NullPointerException{
        return WaitTool.waitForElementVisible(webDriver, selector, waitTimeSec, 1000);
    }

    public void click(WebElement webElement){
        WebElementHelper.click(webElement);
    }

    public void removePaymentValidation(WebDriver driver, boolean isNewHousePayment) {
        DynamicPaymentMemberPage paymentPage = new DynamicPaymentMemberPage(driver);
        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "live")) {
            paymentPage.removePaymentValidationNew(driver, isNewHousePayment);
        }else {
            if(isNewHousePayment)
                logger.info("New House payment so no need to remove pay validation .....!");   //no need to remove validation
            else
                 paymentPage.removePaymentValidationNew();  // not new house pay
        }

        paymentPage = new DynamicPaymentMemberPage(driver);
        paymentPage.waitForPageToLoad(paymentPage.getPageLoadedCondition());
    }

    public void enrolStudentCheckAtSchool() {
        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.startEnrolment();
        // Step 1
        enrolmentPage.simpleTest();
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        enrolmentPage.selectImproveEnglishFor(0);
        // Step 2
        BaseTest.sleep(2000);
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        enrolmentPage.selectEnglishLevel(1);
        // Step 3
        BaseTest.sleep(2000);
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
        /*enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.clickStartLearning();
        BaseTest.sleep(2000);
        enrolmentPage.checkStudentIsAtSchoolCampus();*/
    }

    public void failTestPerEnvironment(String environment, String message){
        if(getENVIRONMENT() !=null && getENVIRONMENT().equals(environment)){
            BasePage.failTest("This test is set to FAIL FOR '" + getENVIRONMENT()
                    + "' Environment -check other Environments \n" +"Extra info :" + message);
        }
    }

    public static void failTest(String msg){
        fail("\nFailed ...! :'" + msg );
    }

    /**
     * get time long
     */
    public long getDate(){
        return System.currentTimeMillis();
    }


    /**
     *
     *
     *
     */
    public static final Map<String, String> CREATE_USER_MAP = new LinkedHashMap<>();
    static {
        CREATE_USER_MAP.put( "continue_uri", "https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2F1%2Foauth2%2Fredirect%3Fcustom-redirect"); //https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2Fcampus%2Fmypage%2Fhome&providers=facebook%2Cgoogle%2Clinkedin");
        CREATE_USER_MAP.put( "given_name",   "NikoAutotestF");
        CREATE_USER_MAP.put( "family_name",  "famNameTest");
        CREATE_USER_MAP.put( "email",        "do this before using it call generate email to update the value");
        CREATE_USER_MAP.put( "password",     "12345678");
        CREATE_USER_MAP.put( "confirmation", "12345678");
    }

    public static final Map<String, String> CREATE_STUDENT_MAP = new LinkedHashMap<>();
    static {
        CREATE_STUDENT_MAP.put( "userId",       "getItFrom prev Test");
        CREATE_STUDENT_MAP.put( "schoolId",     "b2c.englishlive"); // default
        CREATE_STUDENT_MAP.put( "businessUnit", "b2c");
    }

    /**
     * commerceapi
     */
    public static final Map<String, String> CREATE_LEAD_MAP = new LinkedHashMap<>();
    static {
        CREATE_LEAD_MAP.put( "Country",     "countryReplace");
        CREATE_LEAD_MAP.put( "Language",    "languageReplace");
        CREATE_LEAD_MAP.put( "Telephone",   "0786523869");
        CREATE_LEAD_MAP.put( "Partner",     "partnerReplace");
        CREATE_LEAD_MAP.put( "Etag",        "etagReplace");
        CREATE_LEAD_MAP.put( "LeadType",    "leadTypeReplace"   );
        CREATE_LEAD_MAP.put( "Email",       createEmail());
        CREATE_LEAD_MAP.put( "FirstName",   TestUtil.generateRandomString("F", 9) );
        CREATE_LEAD_MAP.put( "LastName",    TestUtil.generateRandomString("L", 10) );
        CREATE_LEAD_MAP.put( "MemberType",  "MemberTypeReplace");
        CREATE_LEAD_MAP.put( "StudentType",      "StudentTypeReplace");
    }

    public static String createEmail(){
        String randonStr = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        String emailfirstPart = "auto_api_"+currTime+"_"+randonStr+"_xdelx@qp1.org";
        return emailfirstPart;
    }

    public static Map<String, String> CREATE_COMMERCE_MEMBER = new LinkedHashMap<>();
    static {
        //CREATE_COMMERCE_MEMBER.put("EFId",         "efidReplaceWithDynamic");
        CREATE_COMMERCE_MEMBER.put("FirstName",    "NikolApi");
        CREATE_COMMERCE_MEMBER.put("LastName",     "MakApi");
        CREATE_COMMERCE_MEMBER.put("UserName",     "userNameReplaceWithDynamic");
        CREATE_COMMERCE_MEMBER.put("email" ,       "emailReplaceWithDynamic");
        CREATE_COMMERCE_MEMBER.put("Country",  "countryCodeReplaceWithDynamic");
        CREATE_COMMERCE_MEMBER.put("Language", "languageCodeReplaceWithDynamic");
        CREATE_COMMERCE_MEMBER.put("SubscribeToMarketCampaign", "true");
        CREATE_COMMERCE_MEMBER.put("SubscribeToDailyLesson", "true");
        CREATE_COMMERCE_MEMBER.put("SubscribeToPartnerPromo", "true");
        CREATE_COMMERCE_MEMBER.put("SubscribeToStudyPlanEmail", "true");

        CREATE_COMMERCE_MEMBER.put("Partner",  "MKGE");
        CREATE_COMMERCE_MEMBER.put("Etag", "goes");

        CREATE_COMMERCE_MEMBER.put("HasOffersTransactionId", "hasOffersTransactionIdTest");
        CREATE_COMMERCE_MEMBER.put("GoogleClickId", "googleClickIdTest");
        CREATE_COMMERCE_MEMBER.put("MarinClickId", "marinClickId");
        CREATE_COMMERCE_MEMBER.put("UtmSource", "utmSourceTest");
        CREATE_COMMERCE_MEMBER.put("UtmMedium", "utmMediumTest");
        CREATE_COMMERCE_MEMBER.put("UtmCampaign", "utmCampaignTest");
        CREATE_COMMERCE_MEMBER.put("UtmTerm", "utmTermTest");
        CREATE_COMMERCE_MEMBER.put("UtmContent", "utmContentTest");
        CREATE_COMMERCE_MEMBER.put("UtmAdGroup", "utmAdGroupTest");
        CREATE_COMMERCE_MEMBER.put("ReferredBy", "3");
        CREATE_COMMERCE_MEMBER.put("ReferredFrom", "SherinAndNMTest");
        //CREATE_COMMERCE_MEMBER.put("Status",   "Active");
        /*CREATE_COMMERCE_MEMBER.put("Status", "Active");
        CREATE_COMMERCE_MEMBER.put("StudentId", "string");
        CREATE_COMMERCE_MEMBER.put("AccountId", "string");
        CREATE_COMMERCE_MEMBER.put("Partner", "string");

        CREATE_COMMERCE_MEMBER.put("CancellationMark", "true");
        CREATE_COMMERCE_MEMBER.put("CancellationReason", "string");
        CREATE_COMMERCE_MEMBER.put("DateActivated", "2017-12-08T14,57,48.451Z");
        CREATE_COMMERCE_MEMBER.put("DateDeactivated", "2017-12-08T14,57,48.451Z");
        CREATE_COMMERCE_MEMBER.put("DateExpires", "2017-12-08T14,57,48.451Z");
        CREATE_COMMERCE_MEMBER.put("UpdateDate", "2017-12-08T14,57,48.451Z");
        CREATE_COMMERCE_MEMBER.put("InsertDate", "2017-12-08T14,57,48.451Z");*/
    }

    public static Map<String, String> UPDATE_MEMBER_PHONE = new LinkedHashMap<>();
    static {
        //CREATE_COMMERCE_MEMBER.put("EFId",         "efidReplaceWithDynamic");
        UPDATE_MEMBER_PHONE.put("RequestSource", "https://qa-englishlive.ef.com/tr-tr/buy/default/thankyou/");
        UPDATE_MEMBER_PHONE.put("Telephone", "0999999999999");
    }

    public String generateEmail(){
        UniqueDataObject udo = new UniqueDataObject();
        userEmail = udo.getEmail();
        logger.info("generateEmail (email) : " + userEmail);
        return userEmail;
    }

    //{industry: "", motivation: "traveling", level: "04", pace: "THREE_TO_FIVE"}
    public static String enrollStudentJson = "{\n" +
            //"  \"id\": \"\",\n" +
            "  \"industry\": \"industryReplaceWithDynamic\",\n" +
            "  \"motivation\": \"motivationReplaceWithDynamic\",\n" +
            "  \"level\": \"levelReplaceWithDynamic\",\n" +
            "  \"pace\": \"THREE_TO_FIVE\"\n" +
            "}"
            ;

    private static int levelNumberReplace;
    public static String updateEnrollmentJson = "{\n" +
            //"  \"courseTypeCode\": \"courseTypeCodedReplaceWithDynamic\",\n" +            //"  \"levelNumber\": \"levelNumberReplaceWithDynamic\"\n" +            //"  \"levelNumber\": 5 \n" +
            "\"args\":{\n"+
//                " \"levelNumber\":20000677, \n"+
                " \"levelNumber\":"+ levelNumberReplace +", \n"+
                //" \"levelNumber\":02, \n"+
                //" \"level\": 2, \n"+
                " \"courseTypeCode\":\"GE\", \n"+
                " \"map\":{} \n"+
                "} \n"+
            "}"
            ;
    public static String updateEnrollmentFirstPartJson = "{\n" +
            "\"args\":{\n"  ;
    public static String updateEnrollmentLastPartJson = "\"courseTypeCode\":\"GE\""+         // " \"map\":{} \n"+
            "} \n"+
            "}";
    /*public static String setEnrollLevelNumber(int levelNumber){
        updateEnrollmentJson = updateEnrollmentJson.replace(""+levelNumberReplace, levelNumber)
    }*/

    String enrollStudentSchoolServicesJson = "{\n" +
            "  \"studentId\": \"studentIdReplaceWithDynamic\",\n" +
            "  \"userId\": \"userIdReplaceWithDynamic\",\n" +
            "  \"courseTemplateId\": \"10000001\",\n" +
            "  \"level\": \"levelNoReplaceWithDynamic\"\n" +
            "}"
            ;


    String enrollStudentCampusServicesJson = "{\n" +
            "  \"userId\": \"userIdReplaceWithDynamic\",\n" +
            "  \"levelId\": \"levelIdReplaceWithDynamic\",\n" +
            "  \"levelCode\": \"levelCodeReplaceWithDynamic\",\n" +
            "  \"motivationId\": \"motivationIdReplaceWithDynamic\",\n" +
            "  \"motivationReason\": \"career\",\n" +
            "  \"studentId\": \"studentIdReplaceWithDynamic\",\n" +
           // "  \"courseTemplateId\": \"courseTemplateIdReplaceWithDynamic\",\n" +
            "  \"courseTypeCode\": \"courseTypeCodeReplaceWithDynamic\"\n" +
            "}"
            ;

    String createAccountJson = "{  \n" +
            "   \"credits\":[  \n" +
            "      {  \n" +
            "         \"id\":\"b3182f8b-90ea-4e6b-9d7f-00696237c554\",\n" +
            "         \"code\":\"11\",\n" +
            "         \"startDate\":1508769672213,\n" +
            "         \"expirationDate\":1608769672213,\n" +
            "         \"quantity\":1\n" +
            "      },\n" +
            "      {  \n" +
            "         \"id\":\"2fe326a5-085b-48c7-aeb8-7e74d5b78cfc\",\n" +
            "         \"code\":\"27\",\n" +
            "         \"quantity\":1,\n" +
            "         \"startDate\":1508769672213,\n" +
            "         \"expirationDate\":1611365272213\n" +
            "      }\n" +
            "   ],\n" +
            "   \"grants\":[  \n" +
            "      {  \n" +
            "         \"id\":\"e757b33c-2745-47c5-a2d8-f63bc66b8798\",\n" +
            "         \"code\":\"21\",\n" +
            "         \"startDate\":1508769672213,\n" +
            "         \"expirationDate\":1608769672213\n" +
            "      },\n" +
            "      {  \n" +
            "         \"id\":\"39fe6a6c-c532-4eda-96c9-3e7d470c9289\",\n" +
            "         \"code\":\"33\",\n" +
            "         \"startDate\":1508769672213,\n" +
            "         \"expirationDate\":1608769672213\n" +
            "      }\n" +
            "   ]\n" +
            "}";


    String patchAccountJson = "{\n" +
            "   \"credits\": [\n" +
            "      {\n" +
            "         \"creditType\": \"feature\",\n" +
            "         \"code\": \"11\",\n" +      // was 11
            "         \"quantity\": 31,\n" +      // was 30
            "         \"creditDate\": 1508769672213,\n" +
            "         \"expirationDate\": 1511365272213\n" +
            "      },\n" +
            "      {\n" +
            "         \"creditType\": \"feature\",\n" +
            "         \"code\": \"27\",\n" +
            "         \"quantity\": 3,\n" +       // was 1
            "         \"quantity\": 3,\n" +       // was 1
            "         \"creditDate\": 1508769672213,\n" +
            "         \"expirationDate\": 1511365272213\n" +
            "      },\n" +
            "      {\n" +   // this is new
            "         \"creditType\": \"feature\",\n" +
            "         \"code\": \"38\",\n" +
            "         \"quantity\": 2,\n" +
            "         \"creditDate\": 1508769672213,\n" +
            "         \"expirationDate\": 1511365272213\n" +
            "      }\n" +
            "   ],\n" +
            "   \"grants\": [\n" +
            "      {\n" +
            "         \"grantType\": \"template_course\",\n" +  // was feature
            "         \"code\": \"21\",\n" +
            "        \"startDate\": null,\n" +
            "         \"expirationDate\": null\n" +
            "      },\n" +
            "      {\n" +   // add new
            "         \"grantType\": \"feature\",\n" +
            "         \"code\": \"36\",\n" +
            "        \"startDate\": null,\n" +
            "         \"expirationDate\": null\n" +
            "      },\n" +
            "   ]\n" +
            "}";


    // commerce purchase    commerceApi
    public String commercePurchaseVisa =  "{\n" +
            "  \"PurchaseInfo\": {\n" +
            "    \"EFId\": \"efidReplaceWithDynamic\",\n" +
            "    \"Etag\": \"NIK\",\n" +
            "    \"Offer_ids\": [\n" +
            "      32282\n" +
            "    ]\n" +
            "  },\n" +
            "  \"CreditCardInfo\": {\n" +
            "    \"FirstName\": \"NikoAutotestF\",\n" +
            "    \"LastName\": \"famNameTest\",\n" +
            "    \"HolderName\": \"test\",\n" +
            "    \"Number\": \"4111111111111111\",\n" +
            "    \"ExpirationMonth\": 8,\n" +
            "    \"ExpirationYear\": 2020,\n" +
            "    \"VerificationCode\": \"123\" \n" +
            "  }\n" +
            "}";

    public String commerceApiDefaultPayLoad =  "{\n" +
            "  \"PurchaseInfo\": {\n" +
            "    \"Country\": \"piCountryReplaceWithDynamic\",\n" +
            "    \"Partner\": \"None\",\n" +
           // "    \"Etag\": \"NIK\",\n" +
            "    \"Channel\": \"channelReplaceWithDynamic\",\n" +
            "    \"Offer_ids\": [\n" +
            "      offerIdReplaceWithDynamic\n" +  //32282
            "    ]\n" +
            "  },\n" +
            "  \"CreditCardInfo\": {\n" +
            "    \"FirstName\": \"NikoAutotestF\",\n" +
            "    \"LastName\": \"famNameTest\",\n" +
            //            "    \"HolderName\": \"test\",\n" +
            "    \"Number\": \"ccNumberReplaceWithDynamic\",\n" +
            "    \"ExpirationMonth\": 8,\n" +
            "    \"ExpirationYear\": 2022,\n" +
            "    \"VerificationCode\": \"123\",\n" +
            "    \"Country\": \"ciCountryReplaceWithDynamic\" ,\n" +
            "    \"Address1\": \"string\" ,\n" +
            "    \"Address2\": \"string\" ,\n" +
            "    \"City\": \"string\" ,\n" +
            "    \"State\": \"string\" ,\n" +
            "    \"PostalCode\": \"string\" \n" +
            "  }\n" +
            "}";

    public static String comApiDefaultPayLoad =  "{\n" +
            "  \"PurchaseInfo\": {\n" +
            "  \"Country\": \"piCountryReplaceWithDynamic\",\n" +
            "  \"Partner\": \"None\",\n" +
            // "    \"Etag\": \"NIK\",\n" +
            "    \"Channel\": \"channelReplaceWithDynamic\",\n" +
            "    \"Offer_ids\": [\n" +
            "      offerIdReplaceWithDynamic\n" +  //32282
            "    ]\n" +
            "  },\n" +
            "  \"CreditCardInfo\": {\n" +
            "    \"FirstName\": \"NikoAutotestF\",\n" +
            "    \"LastName\": \"famNameTest\",\n" +
            //            "    \"HolderName\": \"test\",\n" +
            "    \"Number\": \"ccNumberReplaceWithDynamic\",\n" +
            "    \"ExpirationMonth\": 8,\n" +
            "    \"ExpirationYear\": 2022,\n" +
            "    \"VerificationCode\": \"123\",\n" +
            "    \"Country\": \"ciCountryReplaceWithDynamic\" ,\n" +
            "    \"Address1\": \"string\" ,\n" +
            "    \"Address2\": \"string\" ,\n" +
            "    \"City\": \"string\" ,\n" +
            "    \"State\": \"string\" ,\n" +
            "    \"PostalCode\": \"string\" \n" +
            "  }\n" +
            "}";

    public static String salesForceDeliverWithoutCapturePayLoad =  "{\n" +
            "    \"Offer_ids\": [\n" +
            "      offerIdReplaceWithDynamic\n" +
            "    ],\n\n" +
            "    \"OpportunityNumber\": \"1234567892\",\n" +
            "    \"EFId\": \"efidReplaceWithDynamic\",\n" +
            "    \"Country\": \"countryReplaceWithDynamic\",\n" +
            "    \"Partner\": \"partnerReplaceWithDynamic\",\n" +
            "    \"Etag\": \"etagReplaceWithDynamic\",\n" +
            "    \"Channel\": \"channelReplaceWithDynamic\",\n" +
            "  }\n" +
            "}";

    public String commerceApiOrderRedeemPayLoad =  "{\n" +
            "    \"PurchaseInfo\": {\n" +
            "    \"Country\": \"countryReplaceWithDynamic\",\n" +
            "    \"Partner\": \"partner\",\n" +
            "    \"Etag\": \"NIK\",\n" +
            "    \"Channel\": \"channelReplaceWithDynamic\"\n" +
            //"    \"Offer_ids\": [\n" +
            //"      offerIdReplaceWithDynamic\n" +  //32282
            //"    ]\n" +
            "  },\n" +
            "    \"Redemption\": \"redemptionReplaceWithDynamic\"" +
            "}";

    public String commerceApiBuyWithExistingPayInfoPayLoad =  "{\n" +
            "  \"EFId\": \"efidReplaceWithDynamic\",\n" +
            "  \"Etag\": \"NIK\",\n" +
            "  \"Offer_ids\": [\n" +
            "    offerIdReplaceWithDynamic\n" +
            "  ]\n" +
            "}";

    public static String loginEmail =  "{\n" +
            "  \"email\": \"emailReplaceWithDynamic\",\n" +
            "  \"password\": \"passwordReplaceWithDynamic\",\n" +
            "  \"continue_uri\": \"continue_uriReplaceWithDynamic\",\n" +
            "  ]\n" +
            "}";

    public String commerceApiBuyWithDeDirectDebitInfo = "{\n" +
            "  \"PurchaseInfo\": {\n" +
            "    \"Country\": \"piCountryReplaceWithDynamic\",\n" +
            "    \"Partner\": \"None\",\n" +
            //"    \"Etag\": \"NIK\",\n" +
//            "    \"Currency\": \"EUR\",\n" +
            "    \"Channel\": \"channelReplaceWithDynamic\",\n" +
            "    \"Offer_ids\": [\n" +
            "      offerIdReplaceWithDynamic\n" +  //32282
            "    ]\n" +
            "  },\n" +
            "  \"DirectDebitInfo\": {\n" +
            "    \"AccountName\": \"TAMMY OCONNOR\",\n" +
            "    \"AccountNumber\": \"FR7610011000200012345678934\",\n" +
            "    \"BankCode\": \"PSSTFRPPCNE\",\n" +
            "    \"Country\": \"ddiCountryReplaceWithDynamic\" \n" +  //TODO replace this with dynamic value
            "  }\n" +
            "}";
    //public Map<String, String> offerMap32282 = new HashMap<>();    static {   }

    public String validateOfferCommerceApi = "{\n" +
            "         \"Channel\": \"channelReplaceWithDynamic\",\n" +
            "         \"Offer_ids\": [\n" +
            "                   00000\n" +
            "         ]\n" +
            "     }";

    public String orderPaymentTokeCommerceApi = "{\n" +
            "         \"Country\": \"FR\",\n" +
            "         \"Partner\": \"none\",\n" +
            "         \"Etag\": \"NIK\",\n" +
            "         \"Channel\": \"channelReplaceWithDynamic\",\n" +
            "         \"Offer_ids\": [\n" +
            "                   00000\n" +
            "         ]\n" +
            "     }";

    public static final String endDate = "1707696000000";  // GMT: Monday, February 12, 2024 12:00:00 AM    19 dec 2019  1576747109690

    public String putStudentNotification = "{\n" +
            "    \"settings\": [\n" +
            "        {\n" +
            "            \"key\": \"keyReplaceWithDynamic88\",\n" +
            "            \"value\": {\n" +
            "                \"sourceItemId\": \"88\",\n" +
            "                \"startDate\": 1548426312211,\n" +
            "                \"endDate\": "+System.currentTimeMillis()+",\n" +
            "                \"remainingViews\": 1\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"key\": \"keyReplaceWithDynamic90\",\n" +
            "            \"value\": {\n" +
            "                \"sourceItemId\": \"90\",\n" +
            "                \"startDate\": 1569162312211,\n" +
            "                \"endDate\": "+System.currentTimeMillis()+",\n" +
            "                \"remainingViews\": 2\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    public static String putStudentNotificationStatic = "{\n" +
            "    \"settings\": [\n" +
            "        {\n" +
            "            \"key\": \"keyReplaceWithDynamic88\",\n" +
            "            \"value\": {\n" +
            "                \"sourceItemId\": \"88\",\n" +
            "                \"startDate\": 1,\n" +
            "                \"endDate\": "+endDate+",\n" +
            "                \"remainingViews\": 3\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"key\": \"keyReplaceWithDynamic90\",\n" +
            "            \"value\": {\n" +
            "                \"sourceItemId\": \"90\",\n" +
            "                \"startDate\": "+endDate+",\n" +
            "                \"endDate\": "+endDate+",\n" +
            "                \"remainingViews\": 0\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";



}


/**

 public String putStudentNotification = "{\n" +
 "    \"settings\": [\n" +
 "        {\n" +
 "            \"key\": \"0a5b10cb-367c-4f37-91cf-422b9ac41326\",\n" +
 "            \"value\": {\n" +
 "                \"sourceItemId\": \"88\",\n" +
 "                \"startDate\": 1548426312211,\n" +
 "                \"endDate\": 1551018312211,\n" +
 "                \"remainingViews\": 3\n" +
 "            }\n" +
 "        },\n" +
 "        {\n" +
 "            \"key\": \"0c27b282-0c9e-40f3-b932-27cf886d8dd2\",\n" +
 "            \"value\": {\n" +
 "                \"sourceItemId\": \"90\",\n" +
 "                \"startDate\": 1569162312211,\n" +
 "                \"endDate\": 1571754312211,\n" +
 "                \"remainingViews\": 3\n" +
 "            }\n" +
 "        }\n" +
 "    ]\n" +
 "}";

 */