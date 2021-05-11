package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 *
 */

import com.englishtown.dataprovider.bin.EnrollLevelBean;
import com.englishtown.dataprovider.bin.EnrollMotivationBean;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.dataprovider.bin.SubscriptionBean;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.enumpack.*;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.TestngListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Map;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

// TODO move specs setup to BaseSpecSuite
// TODO move static calls to another Class
public abstract class BaseApiSpec extends BaseApi {
    public static final Logger logger = LoggerFactory.getLogger(BaseApiSpec.class);

    protected boolean resultCancellationMark = false;     // get member if not marked for cancelled
    protected String resultStatus = "Active";              // if not cancelled    "Status": "Active",
    protected boolean resultHasCancellationReason = true;  // reason is there when cancel
    protected boolean isOrderCancelled = false;
    protected URI continueUri; // send a request to create user returns "continue_uri": "http:/***"

    public String continue_url = ""; // returned from accounts call  https://qa-accounts.ef.com/oauth2/users
    public String xefidAccessTocken = ""; // id_token when you oppen continue url it redirect to uuid and id_token on URL

    //TEST DATA
    protected GatewayType gatewayType = GatewayType.CYBERSOURCE;
    public TestCard testCard;
    public static final String BUY_CC_OFFER_ID = "1001"; //"32282";  //"33368"; //
    public static final String BUY_DD_OFFER_ID = "33358"; //"33230";
    public String orderRedemptionCode = "33358"; //"33230";
    public String REDEMPTION_CODE = "SYSONLY-FROS47F08B45"; //"SYSONLY-FRTRIALFB755CAA7F9F4DF"; //"SYSONLY-FROS47F08B45"; // Live:9ef094b060ab482c90387d7fb9c3dde3   QA:SYSONLY-FROS47F08B45  SYSONLY-FROS47F08B45 = QA .. "SYSONLY-FRTRIALF6D18"; //"33230";

    /**
     ****************************************************
     *     API helpers specs
     * **************************************************
     */

    /**
     * create user ID
     */
    public void createUserId() {
        cleanUp();
        initSpecCreateUserApi();
        initResponseSpecCreateUserApi();

        Response response = defaultGetResponsePostSpec();

        try {
            studentBean.setUser_id(response.jsonPath().getString("user_id"));
            String continueUrl = response.jsonPath().getString("continue_uri");
            //todo
            studentBean.setUuid(getAccessTokenUUID(studentBean.getUserEmail(), "12345678"));
            //studentBean.setUuid(getUUID(continueUrl)); //studentBean.setUuid(getUuidSpec(getENVIRONMENT(), continueUrl));
            logger.info("user_ID [" + studentBean.getUser_id() + "] ");
            logger.info("uuid [" + studentBean.getUuid() + "] ");
        } catch (Exception e) {
            logger.error("Cant get user ID [" + studentBean.getUser_id() + "] " + e.getMessage());
        }
        studentBeanList.add(studentBean);

    }

    public String getAccessTokenUUID(String username, String pass){
        cleanUp();
        initSpecGetAccessTokenUuid(username, pass);
        initResponseGetAccessTokenUuid();

        String uuid = null;
        Response response = defaultGetResponsePostSpec();

        try {
            String tempUuid = response.body().jsonPath().getString("access_token");  //response.jsonPath().getString("user_id")
            uuid = tempUuid.split(":")[1];
            studentBean.setUuid(uuid);
            logger.info("studentBean uuid [" + studentBean.getUuid() + "] ");
        }catch (IndexOutOfBoundsException e) {
            logger.error("Cant get UUID [" + uuid + "] " + e.getMessage());
        }catch (NullPointerException e) {
            logger.error("Cant get UUID [" + uuid + "] " + e.getMessage());
        }
        catch (Exception e) {
            logger.error("Cant get UUID [" + uuid + "] " + e.getMessage());
        }

        if(StringUtils.isBlank(uuid))
            failTest("Cant get UUID ....!");

       return uuid;

    }

    /**
     * **************************************************
     * Setup request Specs and response Spec
     * **************************************************
     */
    public void initSpecGetAccessTokenUuid(String username, String pass){
        testBaseUrl = "https://qa-accounts.ef.com/oauth2/token";        //?client_id=platform-client        // not needed // &redirect_uri=http:/qa-englishlive.ef.com/1/oauth2/redirect &scope=labs-profile        // &grant_type=password // &client_secret=platform-secret // &username=auto_278359718905955_KLX482_xdelx@qp1.org        // &password=12345678"

        if (StringUtils.equals("live", getENVIRONMENT()))
            testBaseUrl = efIdBaseUrl.replace("qa-", "");

        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.URLENC);
        requestSpecBuilder.setBaseUri(getBaseURI());        //requestSpecBuilder.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");        //requestSpecBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded")      //requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");
        requestSpecBuilder.addQueryParam("client_id", "platform-client");
        requestSpecBuilder.addQueryParam("grant_type", "password");
        requestSpecBuilder.addQueryParam("client_secret", "platform-secret");
        requestSpecBuilder.addQueryParam("username", username);
        requestSpecBuilder.addQueryParam("password", pass);

        requestSpecification = requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()   // for ssl
                .build();
    }

    /**
     * Check the response for the following content
     */
    public void initResponseGetAccessTokenUuid() {
        logger.info("Check Response ");
        responseSpecBuilder.expectBody("access_token", not(isEmptyOrNullString()));
        responseSpecification = responseSpecBuilder.build();
    }

    ////************

    public void createStudent() {
        initSpecCreateStudentReq();
        initResponseSpecCreateStudentRes();

        Response response = defaultGetResponsePostSpec();

        try {
            studentBean.setStudent_id(response.jsonPath().getString("id"));
            logger.info("student_id [" + studentBean.getStudent_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get student ID [" + studentBean.getStudent_id() + "] " + e.getMessage());
        }
    }

    // not used anymore need to use the patch PATCH /admin/account/{EFId}/grants
    public void createAccount() {
        initSpecCreateAccount();
        initResponseSpecCreateAccount();
        Response response = defaultGetResponsePostSpec();

        try {
            studentBean.setAccount_id(response.jsonPath().getString("id"));
            logger.info("account_id [" + studentBean.getAccount_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get account ID [" + studentBean.getAccount_id() + "] " + e.getMessage());
        }
    }

    // same as createAccount but use dif call api
    public void adminCreateAccount() {
        initSpecAdminCreateAccount();
        initResponseSpecCreateAccount();

        Response response = defaultGetResponsePatchSpec();
                /*given().
                        spec(getRequestSpecification()).
                when().
                        patch("").
                then().
                        spec(getResponseSpecification()).
                extract().response();*/

        try {
            studentBean.setAccount_id(response.jsonPath().getString("id"));
            logger.info("account_id [" + studentBean.getAccount_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get account ID [" + studentBean.getAccount_id() + "] " + e.getMessage());
        }
    }

    public void enrollStudentUsingSchoolServices() {
        initSpecSchoolServicesEnrollStudent();
        initResponseSpecSchoolServicesEnrollStudent();

        Response response = defaultGetResponsePostSpec();

        try {
            studentBean.setIsEnrolled(response.asString());
            logger.info("isEnrolled [" + studentBean.getIsEnrolled() + "] ");
        } catch (Exception e) {
            logger.error("Cant get isEnrolled [" + studentBean.getIsEnrolled() + "] " + e.getMessage());
        }
    }

    public void enrollStudentUsingCampusServices() {
        cleanUp();
        initSpecCampusServicesEnrollStudent();
        initResponseSpecCampusServicesEnrollStudent();

        Response response = defaultGetResponsePostSpec();

        try {
            studentBean.setIsEnrolled(response.asString());
            logger.info("isEnrolled [" + studentBean.getIsEnrolled() + "] ");
        } catch (Exception e) {
            logger.error("Cant get isEnrolled [" + studentBean.getIsEnrolled() + "] " + e.getMessage());
        }
    }

    public void patchAccount() {
        if (isPatchAccount) {
            logger.info("patchAccount test running ...!");
            initSpecPatchAccount();
            initResponseSpecPatchAccount();
            Response response = defaultGetResponsePostSpec();

            try {
                studentBean.setIsPatched(response.asString());
                logger.info("isPatched [" + studentBean.getIsPatched() + "] ");
            } catch (Exception e) {
                logger.error("Cant get isEnrolled [" + studentBean.getIsPatched() + "] " + e.getMessage());
            }
        } else
            logger.warn(" Patch Account TEST is not run as isPatchAccount is false ...!  <[" + isPatchAccount + "]>");

    }

    public void getEnrollmentMotivation() {
        cleanUp();
        initSpecGetMotivationApi();
        initResponseSpecMotivationApi();

        Response response = defaultGetResponseGetSpec();
    }

    public void getEnrollmentLevel() {
        cleanUp();
        initSpecGetEnrollLeveApi();
        initResponseSpecEnrollLevelApi();

        Response response = defaultGetResponseGetSpec();
    }


    public void getCampusEnrollmentMember() {
        cleanUp();
        initSpecGetCampusMemberApi();
        initResponseSpecGetCampusMemberApi();

        Response response = defaultGetResponseGetSpec();
    }

    public void getCampusEnrollmentMemberHasEnrollment() {
        cleanUp();
        initSpecGetMemberHasEnrollmentApi();
        initResponseSpecGetMemberHasEnrollmentApi();

        Response response = defaultGetResponseGetSpec();
    }

    /**
     * **************************************************
     * Setup request Specs and response Spec
     * **************************************************
     */
    public void initSpecCreateUserApi() {
        testBaseUrl = efIdBaseUrl;

        if (StringUtils.equals("live", getENVIRONMENT()))
            testBaseUrl = efIdBaseUrl.replace("qa-", "");

        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.URLENC);
        requestSpecBuilder.setBaseUri(getBaseURI());

        requestSpecBuilder.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        requestSpecBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");

        // set user email
        userEmail = generateEmail();
        studentBean.setUserEmail(userEmail);

        CREATE_USER_MAP.replace("email", userEmail);

        String continueUrl = CREATE_USER_MAP.get("continue_uri");

        if (StringUtils.equals("live", getENVIRONMENT())) {
            continueUrl = continueUrl.replace("qa-", "");
            CREATE_USER_MAP.replace("continue_uri", continueUrl);

            requestSpecBuilder.addHeader("Origin", "https://accounts.ef.com");
            requestSpecBuilder.addHeader("host", "accounts.ef.com");
        } else {
            requestSpecBuilder.addHeader("Origin", "https://qa-accounts.ef.com");
            requestSpecBuilder.addHeader("host", "qa-accounts.ef.com");
        }

        //requestSpecBuilder.setBody(CREATE_USER_MAP);

        requestSpecification = requestSpecBuilder
                .addFormParams(CREATE_USER_MAP)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()   // for ssl
                .build();
    }

    /**
     * Check the response for the following content
     */
    public void initResponseSpecCreateUserApi() {
        logger.info("Check Response ");
        responseSpecBuilder.expectBody("user_id", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("continue_uri", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("code", equalTo(0));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Create student
     */
    public void initSpecCreateStudentReq() {
        testBaseUrl = schoolServiceCreateStudentBaseUrl;
        setBaseURI(testBaseUrl);

        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Content-Type", "application/json");

        requestSpecBuilder.setBaseUri(getBaseURI());

        // set user id
        CREATE_STUDENT_MAP.replace("userId", studentBean.getUser_id());
        CREATE_STUDENT_MAP.replace("schoolId", school_Id);
        CREATE_STUDENT_MAP.replace("businessUnit", businessUnit);

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(CREATE_STUDENT_MAP);

        requestSpecification = buildDefaultRequestSpecBuilder(jsonString);
    }

    public void initResponseSpecCreateStudentRes() {
        logger.info("Check Response Student created");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("id", not(isEmptyOrNullString()));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Create Account,  returns account id
     */
    public void initSpecCreateAccount() {
        testBaseUrl = schoolServiceCreateAccountBaseUrl;
        setBaseURI(testBaseUrl);

        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Accept", "application/json");

        requestSpecBuilder.setBaseUri(getBaseURI());

        createAccountJson = createAccountJson.replace("userIdReplaceMeWithDynamicOne", studentBean.getUser_id());
        createAccountJson = createAccountJson.replace("schoolIdReplaceMeWithDynamicOne", school_Id);
        createAccountJson = createAccountJson.replace("businessUnitReplaceMeWithDynamicOne", businessUnit);

        requestSpecification = buildDefaultRequestSpecBuilder(createAccountJson);
    }


    public void initSpecAdminCreateAccount() {
        testBaseUrl = schoolServiceCreateAccountBaseUrl + studentBean.getUser_id() + "/grants";
        setBaseURI(testBaseUrl);

        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Accept", "application/json");

        requestSpecBuilder.setBaseUri(getBaseURI());

        requestSpecification = buildDefaultRequestSpecBuilder(createAccountJson);
    }

    public void initResponseSpecCreateAccount() {
        logger.info("Check Response Account created");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("id", equalTo(studentBean.getUser_id()));
        responseSpecBuilder.expectBody("activeCredits", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("activeGrants", not(isEmptyOrNullString()));
        //Integer.parseInt(studentBean.getOffer_id())
        responseSpecBuilder.expectBody("activeCredits.code", hasItem("27"));
        responseSpecBuilder.expectBody("activeGrants.code", hasItem("33"));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Enroll Student, returns enrol id
     * "http://school-services.vagrant.f8"
     */
    public void initSpecSchoolServicesEnrollStudent() {
        testBaseUrl = schoolServiceEnrollBaseUrl;
        setBaseURI(testBaseUrl);

        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.ANY);
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Accept", "application/json");

        requestSpecBuilder.setBaseUri(getBaseURI());

        enrollStudentSchoolServicesJson = enrollStudentSchoolServicesJson.replace("studentIdReplaceWithDynamic", studentBean.getStudent_id());
        enrollStudentSchoolServicesJson = enrollStudentSchoolServicesJson.replace("userIdReplaceWithDynamic", studentBean.getUser_id());
        enrollStudentSchoolServicesJson = enrollStudentSchoolServicesJson.replace("levelNoReplaceWithDynamic", student_level);

        requestSpecification = buildDefaultRequestSpecBuilder(enrollStudentSchoolServicesJson);
    }

    public void initResponseSpecSchoolServicesEnrollStudent() {
        logger.info("Check Response Account created");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody(containsString("true"));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Campus enrollment
     */
    public void initSpecCampusServicesEnrollStudent() {
        testBaseUrl = campusMemberEnrollUrl;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Accept", "application/json");

        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("userIdReplaceWithDynamic", studentBean.getUser_id());
        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("levelIdReplaceWithDynamic", studentBean.getStudent_level_id());
        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("levelCodeReplaceWithDynamic", studentBean.getStudent_level_code());
        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("studentIdReplaceWithDynamic", studentBean.getStudent_id());
        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("motivationIdReplaceWithDynamic", studentBean.getMotivation_id());
        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("courseTemplateIdReplaceWithDynamic", "10000001");
        enrollStudentCampusServicesJson = enrollStudentCampusServicesJson.replace("courseTypeCodeReplaceWithDynamic", "GE");//"b2c");


        //requestSpecification = buildDefaultRequestSpecBuilder(enrollStudentCampusServicesJson);
        setBodyRequestSpecBuilder(enrollStudentCampusServicesJson);
        requestSpecification = setDefaultFilterRequestSpecBuilder();

    }

    public void initResponseSpecCampusServicesEnrollStudent() {
        logger.info("Check Response Account created");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecification = responseSpecBuilder.build();
    }

    /***
     * Campus enrolment Level Get test
     *
     */
    public void initSpecGetCampusMemberApi() {
        testBaseUrl = campusMemberEnrollUrl + "/" + studentBean.getUser_id();
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addQueryParam("schoolId", "b2c.englishlive");

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetCampusMemberApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("student.schoolId", equalTo(studentBean.getSchool_id()));
        responseSpecBuilder.expectBody("student.businessUnit", equalTo(studentBean.getBusinessUnit()));
        //TODO need to check the response details as they blank at the moment ... oneal to advice
        //responseSpecBuilder.expectBody("user.givenName", equalTo("NikoAutotestF"));
        // TODO
        AssertHelper.assertThat(" User object not populated ....! Oneal to fix ... ", 1 == 2);
        responseSpecification = responseSpecBuilder.build();
    }


    public void initSpecGetMemberHasEnrollmentApi() {
        testBaseUrl = campusMemberEnrollUrl + "/" + studentBean.getUser_id() + "/has-enrollment";
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetMemberHasEnrollmentApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody(containsString("true"));
        responseSpecification = responseSpecBuilder.build();
    }

    public void initSpecGetMotivationApi() {
        testBaseUrl = campusEnrolmentMotivationUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     * Check the response for the following content
     */
    public void initResponseSpecMotivationApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("code", hasItems(EnrollMotivationBean.getAllEnrolMotivation().get(0).getCode(),
                EnrollMotivationBean.getAllEnrolMotivation().get(1).getCode(),
                EnrollMotivationBean.getAllEnrolMotivation().get(2).getCode(),
                EnrollMotivationBean.getAllEnrolMotivation().get(3).getCode(),
                EnrollMotivationBean.getAllEnrolMotivation().get(4).getCode())); //"career","traveling", "test", "development", "another"));
        responseSpecification = responseSpecBuilder.build();
    }

    public void initSpecGetEnrollLeveApi() {
        testBaseUrl = campusEnrolmentLevelUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecEnrollLevelApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("code", hasItems(
                EnrollLevelBean.getAllEnrolLevels().get(0).getCode(),
                EnrollLevelBean.getAllEnrolLevels().get(1).getCode(),
                EnrollLevelBean.getAllEnrolLevels().get(2).getCode(),
                EnrollLevelBean.getAllEnrolLevels().get(3).getCode(),
                EnrollLevelBean.getAllEnrolLevels().get(4).getCode(),
                EnrollLevelBean.getAllEnrolLevels().get(5).getCode(),
                EnrollLevelBean.getAllEnrolLevels().get(6).getCode()));
        responseSpecification = responseSpecBuilder.build();
    }

    /***
     *
     * Create Account,  returns account id
     * Request URL   http://school-services.vagrant.f8/admin/patch/account?accountId=5f0b4f13-743a-4786-8a26-36f1e4e0e018
     *
     */
    public void initSpecPatchAccount() {
        testBaseUrl = schoolServicePatchAccountBaseUrl;
        setBaseURI(testBaseUrl);

        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addQueryParam("accountId", studentBean.getAccount_id());
        requestSpecBuilder.setBaseUri(getBaseURI());

        requestSpecification = buildDefaultRequestSpecBuilder(patchAccountJson);
    }

    public void initResponseSpecPatchAccount() {
        logger.info("Check Response Account created");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody(containsString("true"));
        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }

    /**
     * Commerce
     */
    public void createCommerceMember() {
        cleanUp();
        initSpecCreateCommerceMemberApi();
        initResponseSpecCreateCommerceMemberApi();

        Response response = defaultGetResponsePostSpec();

        /*try {
            studentBean.setUser_id(response.jsonPath().getString("user_id"));
            logger.info("user_ID [" + studentBean.getUser_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get user ID [" +  studentBean.getUser_id()+ "] " + e.getMessage());
        }*/
    }

    public void commercePurchase() {
        cleanUp();
        initSpecCommercePurchaseApi();
        initResponseSpecCommercePurchaseApi();

        Response response = defaultGetResponsePostSpec();

        try {
            studentBean.setOrder_id(response.jsonPath().getString("Result.Order_id"));
            logger.info(" Purchase OrderId [" + studentBean.getOrder_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get order ID  " + e.getMessage());
        }
    }

    public void commerceGetMember() {
        cleanUp();
        initSpecGetCommerceMemberApi(commerceGetSubscriptionUrl, studentBean);
        initResponseSpecGetCommerceMemberApi();

        Response response = defaultGetResponseGetSpec();
    }


    /**
     * http://commerce.vagrant.f8
     */
    public void commerceGetOffer() {
        cleanUp();
        initSpecGetOfferCommerceServices(commerceGetOfferUrl, studentBean.getOffer_id());
        initResponseSpecGetCommerceServicesOffer(Currency.USD, OfferType.SUBSCRIPTION);

        Response response = defaultGetResponseGetSpec();
    }

    public void commerceGetOrder(String specUrl) {
        cleanUp();
        initSpecGetCommerceOrderApi(specUrl);
        initResponseSpecGetCommerceOrderApi();

        Response response = defaultGetResponseGetSpec();
    }

    public void commerceMarkCancelled() {
        cleanUp();
        initSpecCommerceMarkCancelledApi();
        initResponseSpecMarkCancelledApi();

        Response response = defaultGetResponsePostSpec();
    }

    public void commerceUnMarkCancelled() {
        cleanUp();
        initSpecCommerceUnMarkCancelledApi();
        initResponseSpecUnMarkCancelledApi();

        Response response = defaultGetResponsePostSpec();
    }

    public void commerceSuspendMember() {
        cleanUp();
        initSpecCommerceSuspendApi();
        initResponseSpecSuspendApi();

        Response response = defaultGetResponsePostSpec();
    }

    public void commerceResumeMember() {
        cleanUp();
        initSpecCommerceResumeApi();
        initResponseSpecResumeApi();

        Response response = defaultGetResponsePostSpec();
    }

    public void commerceCancelMember() {
        cleanUp();
        initSpecCommerceCancelApi();
        initResponseSpecCancelApi();

        Response response = defaultGetResponseGetSpec();
    }


    /**
     *
     */

    public void initSpecCreateCommerceMemberApi() {
        testBaseUrl = commerceCreateMemberUrl; //+"?svc_debug=1"; //http://commerce.vagrant.f8/Member/Create
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Content-Type", "application/json-patch+json");

        CREATE_COMMERCE_MEMBER.replace("EFId", studentBean.getUser_id());
        CREATE_COMMERCE_MEMBER.replace("Country", studentBean.getCountry());

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(CREATE_COMMERCE_MEMBER);

        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(jsonString, ContentType.JSON);
    }

    /**
     * Check the response for the following content
     */
    public void initResponseSpecCreateCommerceMemberApi() {
        logger.info("Check Response ");
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.EFId", equalTo(studentBean.getUser_id())); //efid
        responseSpecBuilder.expectBody("Result.Status", equalTo("Active"));
        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }


    /*******************************************************************************************************************
     * purchase
     */
    public void initSpecCommercePurchaseApi() {
        testBaseUrl = commercePurchaseOfferUrl + debugRequest;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();

        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Content-Type", "application/json-patch+json");

        commercePurchaseVisa = commercePurchaseVisa.replace("efidReplaceWithDynamic", studentBean.getUser_id());
        // note setContentType not added
        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(commercePurchaseVisa, ContentType.JSON);
    }

    public void initSpecBuyWithCcCommerceApi(StudentBean studentBean, TestCard testCard) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiBuyWithCreditCardUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(getBaseURI());
        addHeaderAcceptAndContentType(null, null);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());

        commerceApiDefaultPayLoad = commerceApiDefaultPayLoad.replace("piCountryReplaceWithDynamic", studentBean.getCountry());
        commerceApiDefaultPayLoad = commerceApiDefaultPayLoad.replace("channelReplaceWithDynamic", studentBean.getChannel());
        commerceApiDefaultPayLoad = commerceApiDefaultPayLoad.replace("offerIdReplaceWithDynamic", studentBean.getOffer_id());

        commerceApiDefaultPayLoad = commerceApiDefaultPayLoad.replace("ccNumberReplaceWithDynamic", testCard.getCardNumber());
        commerceApiDefaultPayLoad = commerceApiDefaultPayLoad.replace("ciCountryReplaceWithDynamic", studentBean.getCountry());

        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(commerceApiDefaultPayLoad, ContentType.JSON);
    }

    // refactor this with initResponseSpecBuyWithCardCommerceApi
    public void initResponseSpecCommercePurchaseApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.Success", is(true)); //efid
        //Note... need to think if we need to store the last order id in a file and check the new order id is greater
        //        or get the last order id from DB table  ...  if order id is incremental field
        responseSpecBuilder.expectBody("Result.OrderId", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("Result.OrderId", greaterThan(0));
        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }

    // refactor  initResponseBuyWithExistingPayInfoCommerceApi  initResponseBuyWithDirectDebitCommerceApi   initResponseSpecBuyWithCardCommerceApi
    public void initResponseSpecBuyWithCardCommerceApi(StudentBean studentBeanIn, SalesOrderStatus salesOrderStatus, boolean isTokenCheck) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectBody("Order_id", greaterThan(0));
        responseSpecBuilder.expectBody("Status", equalTo(salesOrderStatus.ORDERED.getSalesOrderStatus()));
        responseSpecBuilder.expectBody("EFId", equalTo(studentBeanIn.getUser_id()));

        if (isTokenCheck)
            responseSpecBuilder.expectBody("Token", not(isEmptyOrNullString()));

        responseSpecBuilder.expectBody("Items.OrderItem_id", hasSize(greaterThan(0))); //.body("find { it.userId == '123' }.roles", containsInAnyOrder("ROLE_OPERATOR", "ROLE_ADMIN")).
        responseSpecBuilder.expectBody("Items.Order_id", hasSize(greaterThan(0)));
        responseSpecBuilder.expectBody("Items.Offer_id[0]", is(Integer.parseInt(studentBeanIn.getOffer_id())));
        // TODO add more test for inner data
        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }

    /*******************************************************************************************************************
     * get member
     */
    public void initSpecGetCommerceMemberApi(String testUrl, StudentBean studentBeanIn) {
        testBaseUrl = getBASE_TEST_URL() + testUrl; // commerceGetSubscriptionUrl;
        logger.info("REQ url [" + testBaseUrl + "]");
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        //requestSpecBuilder.addFormParam("EFId", studentBeanIn.getUser_id());

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    // Todo replace with initResponseSpecGetSubscription(int responseCode, boolean isSuccess, SubscriptionBean subscriptionBean)
    public void initResponseSpecGetCommerceMemberApi() { //boolean resultCancellationMark, String resultStatus){
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);

        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.Status", equalTo(resultStatus));
        responseSpecBuilder.expectBody("Result.EFId", equalTo(studentBean.getUser_id()));
        responseSpecBuilder.expectBody("Result.Country", equalTo(studentBean.getCountry()));
        responseSpecBuilder.expectBody("Result.StudentId", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("Result.CancellationMark", is(resultCancellationMark));

        if (resultHasCancellationReason)
            responseSpecBuilder.expectBody("Result.CancellationReason", not(isEmptyOrNullString()));
        else
            responseSpecBuilder.expectBody("Result.CancellationReason", is(isEmptyOrNullString()));
        //"CancellationReason": "NikolTest",   "CancellationMark": true,/false
        responseSpecification = responseSpecBuilder.build();
    }

    /*******************************************************************************************************************
     * get offer commerce-api
     * @param specUrl
     * @param offerId
     */
    public void initSpecGetOfferCommerceApi(String specUrl, String offerId) {
        setSpecUrl(getBASE_TEST_URL() + specUrl + offerId);
        setContentTypeAndAcceptToJson();
        //requestSpecBuilder.addQueryParam("id", offerId);
        //requestSpecBuilder.addPathParam("offerId", offerId);
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /*******************************************************************************************************************
     * get offer commerce services
     * @param specUrl
     * @param offerId
     */
    public void initSpecGetOfferCommerceServices(String specUrl, String offerId) {
        specUrl = specUrl + offerId;           // does not work ... requestSpecBuilder.addPathParam("id", offerId);
        setSpecUrl(specUrl);
        setContentTypeAndAcceptToJson();

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetCommerceServicesOffer(Currency currency, OfferType offerType) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("Id", is(Integer.parseInt(studentBean.getOffer_id())));
        responseSpecBuilder.expectBody("Currency", equalTo(currency.getIso4217Code()));
        responseSpecBuilder.expectBody("Phases.OfferId", hasItem(Integer.parseInt(studentBean.getOffer_id())));
        responseSpecification = responseSpecBuilder.build();
    }


    public void initResponseSpecGetCommerceApiOffer(Currency currency, OfferType offerType) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        // need to get the array element TODO n
        responseSpecBuilder.expectBody("Offer_id", is(Integer.parseInt(studentBean.getOffer_id())));
        responseSpecBuilder.expectBody("Currency", equalTo(currency.getIso4217Code()));
        responseSpecBuilder.expectBody("Phases.Offer_id", hasItem(Integer.parseInt(studentBean.getOffer_id())));
        //responseSpecBuilder.expectBody("Result.Phases.Features.Id", greaterThan(0));
        responseSpecification = responseSpecBuilder.build();
    }

    /*******************************************************************************************************************
     * Validate commerce-api
     *  http://commerce-api.vagrant.f8/_api/commerce/offer/ValidateOffer?EFId=9627a46e-a31f-41a7-9fc0-a9fd2d989746&offerId=32282&offerType=All
     {
     "Channel": "string",
     "OfferIds": [
     0
     ]
     }
     * @param apiUrl
     * @param EFId
     * @param offerId
     * @param offerType
     */
    public void initSpecValidateOffer(String apiUrl, String EFId, String offerId, OfferType offerType) {
        setSpecUrl(getBASE_TEST_URL() + apiUrl);
        setContentTypeAndAcceptToJson();
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        //requestSpecBuilder.addParam("EFId", EFId);   requestSpecBuilder.addParam("offerId", offerId);        requestSpecBuilder.addParam("offerType", offerType.getOfferType());
        validateOfferCommerceApi = validateOfferCommerceApi.replace("channelReplaceWithDynamic", studentBean.getChannel());
        validateOfferCommerceApi = validateOfferCommerceApi.replace("00000", studentBean.getOffer_id());

        setBodyRequestSpecBuilder(validateOfferCommerceApi);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initSpecValidateOfferCommerceServices(String apiUrl, String EFId, String offerId, OfferType offerType) {
        setSpecUrl(apiUrl);
        requestSpecBuilder.addHeader("Accept", "text/plain"); //
        //setContentTypeAndAcceptToJson();        //
        requestSpecBuilder.addQueryParam("EFId", EFId);
        requestSpecBuilder.addQueryParam("offerType", offerType.getOfferType());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecValidateOffer() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        //responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        //responseSpecBuilder.expectBody("Success",         is(true));
        responseSpecBuilder.expectBody("Valid", is(true));

        responseSpecification = responseSpecBuilder.build();
    }

    /*******************************************************************************************************************
     *  Get order
     */
    public void initSpecGetCommerceOrderApi(String specUrl) {
        setSpecUrl(specUrl); //commerceGetOrderUrl);
        setContentTypeAndAcceptToJson();
        requestSpecBuilder.addFormParam("id", studentBean.getOrder_id());

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetCommerceOrderApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        //TODO fred to fix as 500 error
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.Country", is(studentBean.getCountry()));
        responseSpecBuilder.expectBody("Result.Id", is(Integer.parseInt(studentBean.getOrder_id())));
        responseSpecBuilder.expectBody("Result.Items.OrderId", hasItem(Integer.parseInt(studentBean.getOrder_id())));
        responseSpecBuilder.expectBody("Result.Items.OfferId", hasItem(Integer.parseInt(studentBean.getOffer_id())));

        if (isOrderCancelled)
            responseSpecBuilder.expectBody("Result.Status", equalTo("Cancelled"));
        else
            responseSpecBuilder.expectBody("Result.Status", equalTo("Ordered"));

        responseSpecification = responseSpecBuilder.build();
    }

    /*******************************************************************************************************************
     * Mark cancelled
     */
    public void initSpecCommerceMarkCancelledApi() {
        setSpecUrl(commerceMarkCancelMemberUrl);
        setContentTypeAndAcceptToJson();

        requestSpecification = requestSpecBuilder
                .addQueryParam("EFId", studentBean.getUser_id())
                .addQueryParam("reason", "NikolTest")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public void initResponseSpecMarkCancelledApi() {
        initResponseSpecSuccessAndEFIdCheckApi();
    }

    /**
     * Check response code, success status , and efID is the correct one
     */
    public void initResponseSpecSuccessAndEFIdCheckApi() {
        logger.info("initResponseSpecSuccessAndEFIdCheckApi Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.EFId", equalTo(studentBean.getUser_id()));
        responseSpecification = responseSpecBuilder.build();
    }

    /*******************************************************************************************************************
     * Un mark cancelled
     *
     */
    public void initSpecCommerceUnMarkCancelledApi() {
        setSpecUrl(commerceUnmarkCancelMemberUrl);
        setContentTypeAndAcceptToJson();

        requestSpecification = requestSpecBuilder
                .addQueryParam("EFId", studentBean.getUser_id())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public void initResponseSpecUnMarkCancelledApi() {
        initResponseSpecSuccessAndEFIdCheckApi();
    }

    /*******************************************************************************************************************
     * suspend
     *
     */
    public void initSpecCommerceSuspendApi() {
        setSpecUrl(commerceSuspendMemberUrl);
        setContentTypeAndAcceptToJson();

        requestSpecification = requestSpecBuilder
                .addQueryParam("EFId", studentBean.getUser_id())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public void initResponseSpecSuspendApi() {
        initResponseSpecSuccessAndEFIdCheckApi();
    }

    /*******************************************************************************************************************
     * Resume
     *
     */
    public void initSpecCommerceResumeApi() {
        setSpecUrl(commerceResumeMemberUrl);
        setContentTypeAndAcceptToJson();

        requestSpecification = requestSpecBuilder
                .addQueryParam("EFId", studentBean.getUser_id())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public void initResponseSpecResumeApi() {
        initResponseSpecSuccessAndEFIdCheckApi();
    }

    /*******************************************************************************************************************
     * Cancel
     *
     */
    public void initSpecCommerceCancelApi() {
        setSpecUrl(commerceCancelMemberUrl);
        setContentTypeAndAcceptToJson();

        requestSpecification = requestSpecBuilder
                .addQueryParam("EFId", studentBean.getUser_id())
                .addQueryParam("reason", "NikolTest")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public void initResponseSpecCancelApi() {
        initResponseSpecSuccessAndEFIdCheckApi();
    }


    /********************************************************************************************
     *
     * Commerce-api  Front end
     *
     */
    public void getCommerceApiAccountDetails() {
        cleanUp();
        initSpecGetCommerceApiAccountDetails(commerceApiGetAccountDetailsUrl);
        initResponseSpecGetCommerceApiAccountDetails();
        defaultGetSpec();
    }

    public void initSpecGetCommerceApiAccountDetails(String specUrl) {
        //String url = "https://school.vagrant.f8/api/commerce-api/_api/commerce/account/GetAccountDetails";        specUrl=url;
        setSpecUrl(getBASE_TEST_URL() + specUrl);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetCommerceApiAccountDetails() {
        logger.info("Check Response ");
        responseSpecBuilder.expectContentType(ContentType.JSON);
        expectedResponseCode = 200;
       /* responseSpecBuilder.expectStatusCode( expectedResponseCode);
        responseSpecBuilder.expectBody("status",    equalTo("ok"));
        responseSpecBuilder.expectBody("date",      not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("host_name", not(isEmptyOrNullString()));*/
        responseSpecification = responseSpecBuilder.build();
    }


    public void createCommerceApiMember() {
        cleanUp();
        initSpecCreateCommerceApiMember();
        initResponseSpecCreateCommerceApiMember();

        defaultPostSpec();
    }

    public void initSpecCreateCommerceApiMember() {
        testBaseUrl = getBASE_TEST_URL() + commerceApiCreateMemberUrl;  // http://commerce-api.vagrant.f8/_api/commerce/member/Create
        // work testBaseUrl = "https://school.vagrant.f8/api/commerce-api/_api/commerce/member";

        Map createMember = CREATE_COMMERCE_MEMBER;

        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();

        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Content-Type", "application/json-patch+json");
        //requestSpecBuilder.addHeader("X-EF-EFID", studentBean.getUuid());
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        //CREATE_COMMERCE_MEMBER.replace("EFId",          studentBean.getUser_id());

        createMember.replace("Country", studentBean.getCountry());
        createMember.replace("Language", studentBean.getLang());
        createMember.replace("UserName", studentBean.getUserEmail());
        createMember.replace("email", studentBean.getUserEmail());

        /*CREATE_COMMERCE_MEMBER.replace("Country", studentBean.getCountry());
        CREATE_COMMERCE_MEMBER.replace("Language", studentBean.getLang());
        CREATE_COMMERCE_MEMBER.replace("UserName", studentBean.getUserEmail());
        CREATE_COMMERCE_MEMBER.replace("email", studentBean.getUserEmail());*/

        //CREATE_COMMERCE_MEMBER.replace("CountryCode",   studentBean.getCountry());

        //String payload = CREATE_COMMERCE_MEMBER.toString();
        //new JSONObject(map);
        Gson gson = new Gson();
        String json = gson.toJson(createMember);
        json = json.replace("\"true\"", "true");
        json = json.replace("\"false\"", "false");
        //logger.info("....");        //json.replace("", "")
        // requestSpecification = buildDefaultRequestSpecBuilderWithContentType(CREATE_COMMERCE_MEMBER, ContentType.JSON);
        logger.info("....");
        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(json, ContentType.JSON);
    }

    public void initResponseSpecCreateCommerceApiMember() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);

        responseSpecBuilder.expectBody("EFId", not(isEmptyOrNullString()));

        responseSpecBuilder.expectBody("Email", equalToIgnoringCase(studentBean.getUserEmail()));
        responseSpecBuilder.expectBody("Country", equalToIgnoringCase(studentBean.getCountry()));
        responseSpecification = responseSpecBuilder.build();
    }

    public void updateMemberCommerceApi() {
        cleanUp();
        initSpecUpdateMemberCommerceApi();
        initResponseSpecUpdateMemberCommerceApi();

        defaultPatchSpec();        //defaultPutSpec();
    }

    public void initSpecUpdateMemberCommerceApi() {
        testBaseUrl = getBASE_TEST_URL() + commerceApiCreateMemberUrl;  // http://commerce-api.vagrant.f8/_api/commerce/member/Create
        // work testBaseUrl = "https://school.vagrant.f8/api/commerce-api/_api/commerce/member";

        Map createMember = CREATE_COMMERCE_MEMBER;

        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();

        requestSpecBuilder.setBaseUri(getBaseURI());
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Content-Type", "application/json-patch+json");
        //requestSpecBuilder.addHeader("X-EF-EFID", studentBean.getUuid());
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        //CREATE_COMMERCE_MEMBER.replace("EFId",          studentBean.getUser_id());

        createMember.replace("CountryCode", studentBean.getCountry());
        createMember.replace("LanguageCode", studentBean.getLang());
        createMember.replace("UserName", studentBean.getUserEmail());                // CREATE_COMMERCE_MEMBER.replace("email",         studentBean.getUserEmail());
        createMember.replace("CountryCode", studentBean.getCountry());        //update field
        createMember.replace("FirstName", "updatedFirstName"); //todo use as param
        /**
         CREATE_COMMERCE_MEMBER.replace("CountryCode", studentBean.getCountry());
         CREATE_COMMERCE_MEMBER.replace("LanguageCode", studentBean.getLang());
         CREATE_COMMERCE_MEMBER.replace("UserName", studentBean.getUserEmail());                // CREATE_COMMERCE_MEMBER.replace("email",         studentBean.getUserEmail());
         CREATE_COMMERCE_MEMBER.replace("CountryCode", studentBean.getCountry());        //update field
         CREATE_COMMERCE_MEMBER.replace("FirstName", "updatedFirstName"); //todo use as param
         */

        Gson gson = new Gson();
        String json = gson.toJson(createMember);
        json = json.replace("\"true\"", "true");
        json = json.replace("\"false\"", "false");
        logger.info("gson : "+gson);
        //requestSpecification = buildDefaultRequestSpecBuilderWithContentType(CREATE_COMMERCE_MEMBER, ContentType.JSON);
        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(json, ContentType.JSON);
    }

    public void initResponseSpecUpdateMemberCommerceApi() {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        //responseSpecBuilder.expectBody("EFId",equalTo(studentBean.getUser_id()));
        responseSpecBuilder.expectBody("FirstName", equalTo("updatedFirstName"));
        responseSpecification = responseSpecBuilder.build();
        //requestSpecification = buildDefaultRequestSpecBuilderWithContentType(CREATE_COMMERCE_MEMBER, ContentType.JSON);

    }

    public void getCommerceApiMember() {
        cleanUp();
        initSpecGetCommerceMemberApi(commerceApiGetMemberUrl, studentBean);
        initResponseSpecGetCommerceApiMember();

        defaultGetSpec();
    }

    public void initResponseSpecGetCommerceApiMember() {
        logger.info("Check Response ");
        responseSpecBuilder.expectContentType(ContentType.JSON);
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        //responseSpecBuilder.expectBody("EFId",equalTo(studentBean.getUser_id()));
        responseSpecBuilder.expectBody("Email", equalToIgnoringCase(studentBean.getUserEmail()));
        responseSpecBuilder.expectBody("StudentId", not(isEmptyOrNullString()));

        responseSpecBuilder.expectBody("Partner", equalTo(studentBean.getPtn()));
        responseSpecBuilder.expectBody("Etag", equalTo(studentBean.getEtag()));
        responseSpecBuilder.expectBody("HasOffersTransactionId", equalTo(studentBean.getHasOffersTransactionId()));
        responseSpecBuilder.expectBody("GoogleClickId", equalTo(studentBean.getGoogleClickId()));
        responseSpecBuilder.expectBody("MarinClickId", equalTo(studentBean.getMarinClickId()));
        responseSpecBuilder.expectBody("UtmSource", equalTo(studentBean.getUtmSource()));
        responseSpecBuilder.expectBody("UtmMedium", equalTo(studentBean.getUtmMedium()));
        responseSpecBuilder.expectBody("UtmCampaign", equalTo(studentBean.getUtmCampaign()));
        responseSpecBuilder.expectBody("UtmTerm", equalTo(studentBean.getUtmTerm()));
        responseSpecBuilder.expectBody("UtmContent", equalTo(studentBean.getUtmContent()));
        responseSpecBuilder.expectBody("UtmAdGroup", equalTo(studentBean.getUtmAdGroup()));
        responseSpecBuilder.expectBody("ReferredBy", equalTo(Integer.parseInt(studentBean.getReferredBy())));
        responseSpecBuilder.expectBody("ReferredFrom", equalTo(studentBean.getReferredFrom()));
        responseSpecBuilder.expectBody("SubscribeToMarketCampaign", is(true));

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * isUseOldLoginCommerceApi
     * TODO udpated to pass student bean as parametter
     */
    public void getIsUseOldLoginCommerceApi(boolean isOldLoginStudent) {
        logger.info("getIsUseOldLoginCommerceApi  ...!");
        cleanUp();
        initSpecGetIsUseOldLoginCommerceApi(isOldLoginStudent);
        initResponseSpecIsOldLoginCommerceApi(isOldLoginStudent);
        response = defaultGetResponseGetSpec();//response.getBody().asString()
    }

    public void initSpecGetIsUseOldLoginCommerceApi(boolean isOldLoginStudent) {
        //to simulate old login resonse use non existent email user
        // ...TestUtil.reverseString(studentBean.getUserEmail().split("\\@")[0])
        String useEmail = studentBean.getUserEmail();

        if (isOldLoginStudent) {                                                                                         //tmpEmail = studentBean.getUserEmail().split("\\@")[0];         //tmpEmail = TestUtil.reverseString(tmpEmail); // new StringBuffer().reverse().toString();            //tmpEmail = tmpEmail + "@qp1.org";
            //studentBean.setUserEmail(TestUtil.reverseEmailAddress(studentBean.getUserEmail()));
            useEmail = "nonexistemailtestapi@nikol.she";
            logger.info("Email reversed [{}]", useEmail);
        }
        testBaseUrl = getBASE_TEST_URL() + commerceApiGetIsOldLoginUrl;//+"?Email="+studentBean.getUserEmail();
        setBaseURI(testBaseUrl);
        RestAssured.useRelaxedHTTPSValidation();
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(getBaseURI());

        requestSpecBuilder.addQueryParam("Email", useEmail);// studentBean.getUserEmail());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
        requestSpecification = requestSpecBuilder.build();
    }

    public void initResponseSpecIsOldLoginCommerceApi(boolean isOldLoginStudent) {
        logger.info("Check Response ");        //responseSpecBuilder.expectContentType(ContentType.JSON);
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        //https://github.com/rest-assured/rest-assured/issues/949
        //TODO need to check the body but is not working
        //responseSpecBuilder.expectBody("",    equalTo(String.valueOf(isOldLoginStudent)));
        //AssertHelper.assertThat("Note the expected response ...!", response.asString(), equalTo(String.valueOf(isOldLoginStudent)));
        responseSpecification = responseSpecBuilder.build();
    }


    /**
     * used for commerce-api
     *
     * @param apiUrl
     */
    public void getOfferCommerceApi(String apiUrl) {
        cleanUp();
        initSpecGetOfferCommerceApi(apiUrl, studentBean.getOffer_id());
        initResponseSpecGetCommerceApiOffer(Currency.USD, OfferType.SUBSCRIPTION);

        defaultGetSpec();
    }

    public void validateOffer(String apiUrl, String EFId, String offerId, OfferType offerType) {
        cleanUp();
        initSpecValidateOffer(apiUrl, EFId, offerId, offerType);
        initResponseSpecValidateOffer();

        defaultPostSpec();
    }

    public void validateOfferCommerceServices(String apiUrl, String EFId, String offerId, OfferType offerType) {
        cleanUp();
        initSpecValidateOfferCommerceServices(apiUrl, EFId, offerId, offerType);
        initResponseSpecValidateOffer();

        defaultGetSpec();
    }

    public void validateOfferCommerceApi(String EFId, String offerId, OfferType offerType) {
        validateOffer(commerceApiValidateOfferUrl, EFId, offerId, offerType);
    }

    /*******************************************************************************************************************
     * MONITOR
     *
     */

    public void initSpecMonitorApi(String apiUrl) {
        cleanUp();
        initSpecApiHealth(apiUrl);
        initResponseApiHealth();

        defaultGetSpec();
    }

    public void initSpecApiHealth(String specUrl) {
        setSpecUrl(specUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseApiHealth() {
        logger.info("Check Response ");
        responseSpecBuilder.expectContentType(ContentType.JSON);
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("status", equalTo("ok"));
        responseSpecBuilder.expectBody("date", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("host_name", not(isEmptyOrNullString()));
        responseSpecification = responseSpecBuilder.build();
    }


    /**
     * http://commerce-api.vagrant.f8/swagger/#!/Payment/apiCommercePaymentBuyWithCreditCardPost
     * POST /_api/commerce/payment/BuyWithCreditCard
     */
    public void commerceApiBuyWithCreditCard(StudentBean studentBeanIn, TestCard testCard, SalesOrderStatus salesOrderStatus, boolean isTokenCheck) {
        cleanUp();
        initSpecBuyWithCcCommerceApi(studentBeanIn, testCard);
        initResponseSpecBuyWithCardCommerceApi(studentBeanIn, salesOrderStatus, isTokenCheck);

        Response response = defaultGetResponsePostSpec();
        try {
            studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
            logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get Order ID [" + studentBean.getOrder_id() + "] " + e.getMessage());
        }
    }

    public void commerceApiGetMemberPayInfo(StudentBean studentBeanIn, GatewayType gatewayType, CardType gatewayCardType, String accountNumber) {
        cleanUp();
        initSpecGetMemberPayInfoCommerceApi(studentBeanIn);
        initResponseGetMemberPayInfoApi(gatewayType, gatewayCardType, accountNumber);

        defaultGetResponseGetSpec();
    }

    public void initSpecGetMemberPayInfoCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = commerceApiGetMemberPayInfoUrl;//+"?EFId="+studentBeanIn.getUser_id();
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addQueryParam("EFId", studentBeanIn.getUser_id());
        requestSpecification = setDefaultFilterRequestSpecBuilder();

    }

    public void initResponseGetMemberPayInfoApi(GatewayType gatewayType, CardType gatewayCardType, String accountNumber) {
        logger.info("Check Response ");
        //responseSpecBuilder.expectContentType(ContentType.JSON);
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.GatewayType", equalTo(gatewayType.getGatewayType()));
        responseSpecBuilder.expectBody("Result.GatewayCardType", equalTo(gatewayCardType.getCardType()));
        responseSpecBuilder.expectBody("Result.AccountId", containsString("******"));
        //TODO add test to be added for Result.accountId  as this is not there yet
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Buy with existing cc
     */
    public void commerceApiBuyWithExistingPayInfo(StudentBean studentBeanIn, SalesOrderStatus salesOrderStatus) {
        cleanUp();
        studentBeanIn.setOffer_id("195");
        initSpecBuyWithExistingPayInfoCommerceApi(studentBeanIn);
        initResponseBuyWithExistingPayInfoCommerceApi(studentBeanIn, salesOrderStatus);

        defaultGetResponsePostSpec();
    }

    public void initSpecBuyWithExistingPayInfoCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = commerceApiBuyWithExistingPaymentInfoUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(getBaseURI());
        addHeaderAcceptAndContentType(null, null);

        commerceApiBuyWithExistingPayInfoPayLoad = commerceApiBuyWithExistingPayInfoPayLoad.replace(
                "efidReplaceWithDynamic", studentBeanIn.getUser_id());
        commerceApiBuyWithExistingPayInfoPayLoad = commerceApiBuyWithExistingPayInfoPayLoad.replace(
                "offerIdReplaceWithDynamic", studentBeanIn.getOffer_id());

        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(commerceApiBuyWithExistingPayInfoPayLoad, ContentType.JSON);

    }

    public void initResponseBuyWithExistingPayInfoCommerceApi(StudentBean studentBeanIn, SalesOrderStatus salesOrderStatus) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("Result.EFId", equalTo(studentBeanIn.getUser_id()));
        responseSpecBuilder.expectBody("Result.Status", equalTo(salesOrderStatus.getSalesOrderStatus()));
        responseSpecBuilder.expectBody("Result.Items.OfferId", hasItem(Integer.parseInt(studentBeanIn.getOffer_id())));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Buy with Direct Debit uses paymentTech
     */
    //TODO once Erden update it
    public void commerceApiBuyWithDirectDebit(StudentBean studentBeanIn, SalesOrderStatus salesOrderStatus) {
        cleanUp();        //AssertHelper.assertThat("Not implemented YET By Dev Team...!", 0==1);
        StudentBean testStudentBean = (StudentBean) SerializationUtils.clone(studentBeanIn);//new StudentBean();

        testStudentBean.setOffer_id(studentBean.getOffer_id());
        initSpecBuyWithDirectDebitCommerceApi(testStudentBean);
        initResponseBuyWithDirectDebitCommerceApi(testStudentBean, salesOrderStatus);

        //defaultGetResponsePostSpec();
        Response response = defaultGetResponsePostSpec();
        try {
            studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
            logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get Order ID [" + studentBean.getOrder_id() + "] " + e.getMessage());
        }
    }

    public void initSpecBuyWithDirectDebitCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiBuyWithDirectDebitUrl; //commerceApiBuyWithDebitCardUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(getBaseURI());
        addHeaderAcceptAndContentType(null, null);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBeanIn.getUuid());

        commerceApiBuyWithDeDirectDebitInfo = commerceApiBuyWithDeDirectDebitInfo.replace("efidReplaceWithDynamic", studentBeanIn.getUser_id());
        commerceApiBuyWithDeDirectDebitInfo = commerceApiBuyWithDeDirectDebitInfo.replace("offerIdReplaceWithDynamic", studentBeanIn.getOffer_id());
        commerceApiBuyWithDeDirectDebitInfo = commerceApiBuyWithDeDirectDebitInfo.replace("piCountryReplaceWithDynamic", studentBeanIn.getCountry());
        commerceApiBuyWithDeDirectDebitInfo = commerceApiBuyWithDeDirectDebitInfo.replace("ddiCountryReplaceWithDynamic", "FR");//studentBeanIn.getCountry());
        commerceApiBuyWithDeDirectDebitInfo = commerceApiBuyWithDeDirectDebitInfo.replace("channelReplaceWithDynamic", studentBeanIn.getChannel());

        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(commerceApiBuyWithDeDirectDebitInfo, ContentType.JSON);

    }

    public void initResponseBuyWithDirectDebitCommerceApi(StudentBean studentBeanIn, SalesOrderStatus salesOrderStatus) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("EFId", equalTo(studentBeanIn.getUser_id()));
        responseSpecBuilder.expectBody("Status", equalTo(salesOrderStatus.getSalesOrderStatus()));
        responseSpecBuilder.expectBody("Items.Offer_id", hasItem(Integer.parseInt(studentBeanIn.getOffer_id())));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Commerce api get order
     */
    public void commerceApiGetOrder(StudentBean studentBeanIn) {
        cleanUp();
        initSpecGetOrderCommerceApi(studentBeanIn);
        initResponseSpecGetOrderCommerceApi(studentBeanIn);

        defaultGetResponseGetSpec();
    }

    public void initResponseSpecGetOrderCommerceApi(StudentBean studentBeanIn) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectBody("Order_id", equalTo(Integer.parseInt(studentBeanIn.getOrder_id())));
        responseSpecBuilder.expectBody("EFId", equalTo(studentBeanIn.getUser_id()));
        responseSpecBuilder.expectBody("Status", equalTo("Ordered"));
        responseSpecBuilder.expectBody("Token", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("Items.OrderItem_id", hasSize(greaterThan(0))); //hasSize(greaterThan(0))); //.body("find { it.userId == '123' }.roles", containsInAnyOrder("ROLE_OPERATOR", "ROLE_ADMIN")).
        responseSpecBuilder.expectBody("Items.Order_id", hasItem(Integer.parseInt(studentBeanIn.getOrder_id())));
        responseSpecBuilder.expectBody("Items.Offer_id", hasItem(Integer.parseInt(studentBeanIn.getOffer_id())));
        // TODO add more test for inner data
        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }

    public void initSpecGetOrderCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiGetOrderUrl + studentBeanIn.getOrder_id();

        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.addPathParam("orderId", studentBeanIn.getOrder_id());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     * Get subscription
     */
    public void commerceApiGetSubscription(StudentBean studentBeanIn, String status, boolean isCancellationMark) {
        cleanUp();
        initSpecGetSubscriptionCommerceApi(studentBeanIn);
        initResponseGetSubscriptionCommerceApi(studentBeanIn, status, isCancellationMark);

        defaultGetResponseGetSpec();
    }

    public void initSpecGetSubscriptionCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiGetMemberPayInfoUrl;//+"?EFId="+studentBeanIn.getUser_id();
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        //requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBeanIn.getUuid());
        //requestSpecBuilder.addQueryParam("EFId", studentBeanIn.getUser_id());
        requestSpecification = setDefaultFilterRequestSpecBuilder();

    }

    public void initResponseGetSubscriptionCommerceApi(StudentBean studentBeanIn, String status, boolean isCancellationMark) {
        logger.info("Check Response ");
        //responseSpecBuilder.expectContentType(ContentType.JSON);
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("EFId", equalTo(studentBeanIn.getUser_id()));
        responseSpecBuilder.expectBody("Country", equalTo(studentBeanIn.getCountry()));
        responseSpecBuilder.expectBody("Status", equalTo(status)); // Active
        responseSpecBuilder.expectBody("CancelMark", is(isCancellationMark)); // false
        responseSpecification = responseSpecBuilder.build();
    }


    public void commerceApiGetStudentType(StudentBean studentBeanIn, int responseCode, String studentType) {
        cleanUp();
        initSpecGetStudentTypeCommerceApi(studentBeanIn);
        initResponseGetStudentTypeCommerceApi(responseCode, studentType);

        response = defaultGetResponseGetSpec();
    }

    public void initSpecGetStudentTypeCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiGetStudentTypeUrl;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBeanIn.getUuid());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetStudentTypeCommerceApi(int responseCode, String studentType) {
        logger.info("initResponseGetStudentTypeCommerceApi Check Response ");
        responseSpecBuilder.expectStatusCode(responseCode);
        //responseSpecBuilder.expectBody("", equalTo(studentType));
        responseSpecification = responseSpecBuilder.build();
    }


    public void commerceApiGetOrderRedeem(StudentBean studentBeanIn) {
        cleanUp();
        initSpecGetOrderRedeemCommerceApi(studentBeanIn);
        initResponseGetOrderRedeem();

        defaultGetResponsePostSpec();
    }

    public void initSpecGetOrderRedeemCommerceApi(StudentBean studentBeanIn) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiGetOrderRedeemUrl;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBeanIn.getUuid());

        commerceApiOrderRedeemPayLoad = commerceApiOrderRedeemPayLoad.replace("countryReplaceWithDynamic", studentBean.getCountry());
        commerceApiOrderRedeemPayLoad = commerceApiOrderRedeemPayLoad.replace("channelReplaceWithDynamic", studentBean.getChannel());
        commerceApiOrderRedeemPayLoad = commerceApiOrderRedeemPayLoad.replace("redemptionReplaceWithDynamic", REDEMPTION_CODE); //"SYSONLY-FRTRIALF6D18"); //BaseTestHelper.getRedemptionCode(getENVIRONMENT()));
        //not needed Fred commerceApiOrderRedeemPayLoad = commerceApiOrderRedeemPayLoad.replace("offerIdReplaceWithDynamic", studentBean.getOffer_id());

        requestSpecification = buildDefaultRequestSpecBuilderWithContentType(commerceApiOrderRedeemPayLoad, ContentType.JSON);
        //requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetOrderRedeem() {
        logger.info("initResponseGetStudentTypeCommerceApi Check Response ");
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectBody("Order_id", greaterThan(0));
        responseSpecification = responseSpecBuilder.build();
    }


    public void commerceApiValidateRedempionCode(StudentBean studentBeanIn, String redemptionCode) {
        cleanUp();
        initSpecGetValidateRedemptionCodeCommerceApi(studentBeanIn, redemptionCode);
        initResponseGetValidateRedemptionCodeCommerceApi();

        defaultGetResponseGetSpec();
    }

    public void initSpecGetValidateRedemptionCodeCommerceApi(StudentBean studentBeanIn, String rCode) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiValidateRCodeUrl + rCode + "/validate";
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBeanIn.getUuid());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetValidateRedemptionCodeCommerceApi() {
        logger.info("initResponseGetStudentTypeCommerceApi Check Response ");
        responseSpecBuilder.expectStatusCode(200);
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * commerce api create lead
     */
    public void commerceApiCreateLead(StudentBean studentBean) {
        cleanUp();
        initSpecCreateLeadReq(studentBean);
        initResponseSpecCreateLeadRes(studentBean);

        defaultGetResponsePostSpec();
    }

    public void initSpecCreateLeadReq(StudentBean studentBean) {
        testBaseUrl = getBASE_TEST_URL() + commerceApiLeadUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        addHeaderAcceptAndContentType(null, null);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        // TODO   ADD DIFFERENT STUDENT TYPE
        //Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        //String jsonString = gson.toJson(CREATE_LEAD_MAP);
        //requestSpecification = buildDefaultRequestSpecBuilder(jsonString);
        CREATE_LEAD_MAP.replace("Country", studentBean.getCountry()); //gb
        CREATE_LEAD_MAP.replace("Language", studentBean.getLang());    //en
        CREATE_LEAD_MAP.replace("Partner", studentBean.getPtn());     //"MKGE"); //todo set this dy
        CREATE_LEAD_MAP.replace("Etag", studentBean.getEtag());    //"goes"); //todo set this dy
        CREATE_LEAD_MAP.replace("LeadType", studentBean.getLeadType());
        //CREATE_LEAD_MAP.replace("MemberType", "");

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(CREATE_LEAD_MAP);

        requestSpecification = buildDefaultRequestSpecBuilder(jsonString);


    }

    public void initResponseSpecCreateLeadRes(StudentBean studentBean) {
        logger.info("Check Response Student created");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("Lead_id", greaterThan(0));
        responseSpecBuilder.expectBody("LeadType", equalTo(studentBean.getLeadType()));
        responseSpecBuilder.expectBody("Country", equalTo(studentBean.getCountry()));
        responseSpecBuilder.expectBody("Language", equalTo(studentBean.getLang()));
        responseSpecBuilder.expectBody("FirstName", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("LastName", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("Email", not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("Telephone", equalTo("0786523869"));
        responseSpecBuilder.expectBody("Partner", equalTo(studentBean.getPtn()));
        responseSpecBuilder.expectBody("Etag", equalTo(studentBean.getEtag()));
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * CommerceApi cancel subscription
     */
    public void commerceApiCancelSubscription(StudentBean studentBeanIn, int responseCode, boolean isSuccess) {
        cleanUp();
        initSpecCommerceApiCancelSubscription(studentBeanIn);
        initResponseSpecCheckStatusCodeAndIsSuccess(responseCode, isSuccess);
        defaultGetResponsePostSpec();
    }

    public void initSpecCommerceApiCancelSubscription(StudentBean studentBeanIn) {
        testBaseUrl = commerceApiCancelSubscriptionUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        addHeaderAcceptAndContentType(null, null);

        requestSpecBuilder.addQueryParam("EFId", studentBeanIn.getUser_id());
        requestSpecBuilder.addQueryParam("reason", "Test cancel Subscription autotest api");
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     * Commerce and CommerceApi cancel subscription
     * Note:
     * EFId : req
     * commerce in path
     * commerceApi query param
     * 'http://commerce.vagrant.f8/                     subscription/e3362a7e-5530-4a15-8ff9-6118f6f71ce0'
     * 'http://commerce-api.vagrant.f8/_api/commerce/   subscription/Get?EFId=e3362a7e-5530-4a15-8ff9-6118f6f71ce0'
     */
    public void getSubscription(String testUrl, StudentBean studentBeanIn, int responseCode, boolean isSuccess) {
        cleanUp();
        initSpecGetSubscription(testUrl, studentBeanIn);
        initResponseSpecCheckStatusCodeAndIsSuccess(responseCode, isSuccess);
        defaultGetResponsePostSpec();
    }

    /**
     * Use this for both commerce and commerceApi
     *
     * @param testUrl
     * @param studentBeanIn
     */
    public void initSpecGetSubscription(String testUrl, StudentBean studentBeanIn) {
        testBaseUrl = testUrl;
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        addHeaderAcceptAndContentType(null, null);

        if (StringUtils.contains(testUrl, "commerce-api")) {
            logger.info("Commerce-Api request param added ....!");
            requestSpecBuilder.addQueryParam("EFId", studentBeanIn.getUser_id());
        } else {
            logger.info("Commerce request path param added....!");
            requestSpecBuilder.addPathParam("EFId", studentBeanIn.getUser_id());
        }

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetSubscription(int responseCode, boolean isSuccess, SubscriptionBean subscriptionBean) { //boolean isSuccess, StudentBean studentBeanIn){
        logger.info("Check Response Student created");
        //if(StringUtils.contains(testBaseUrl, "commerce-api")) {
        logger.info("Commerce-Api response ....!");
        setExpectedResponseCodeAndSuccess(responseCode, isSuccess);
        responseSpecBuilder.expectBody("Result.EFId", is(subscriptionBean.getEfid())); //studentBeanIn.getUser_id()));
        responseSpecBuilder.expectBody("Result.Country", is(subscriptionBean.getCountry()));
        responseSpecBuilder.expectBody("Result.Status", is(subscriptionBean.getStatus()));
        responseSpecBuilder.expectBody("Result.CancellationMark", is(subscriptionBean.isCancellationMark()));
        //TODO check if more data need tested
        // ???  responseSpecBuilder.expectBody("Result.Token",  not(isEmptyOrNullString()));
        /*}else {
            logger.info("Commerce response....!");
            responseSpecBuilder.expectStatusCode(responseCode);
            responseSpecBuilder.expectBody("EFId",    is(subscriptionBean.getUser_id()));
            responseSpecBuilder.expectBody("Country",    is(studentBeanIn.getUser_id()));
            responseSpecBuilder.expectBody("Status",    is(studentBeanIn.getUser_id()));
            responseSpecBuilder.expectBody("CancellationMark",    is(""));
        }*/
        responseSpecBuilder.expectBody("Success", is(true));
        responseSpecBuilder.expectBody("LeadId", not(isEmptyOrNullString()));

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Reusable response check for responseCode and Success
     * { "Success": true }
     *
     * @param responseCode
     * @param isSuccess
     */
    public void initResponseSpecCheckStatusCodeAndIsSuccess(int responseCode, boolean isSuccess) {
        logger.info("Check Response Student created");
        setExpectedResponseCodeAndSuccess(responseCode, isSuccess);
        responseSpecification = responseSpecBuilder.build();
    }

    //TODO use the below response check for all pay methods 

    /**
     * CommerceApi all pay Response
     * Buy with CC DC or Direct Debit
     * No token only for buy with existing card
     ***/
    public void initResponseSpecComBuy(StudentBean studentBeanIn, SalesOrderStatus salesOrderStatus, int responseCode, boolean isSuccess) {
        logger.info("Check Response ");
        responseSpecBuilder.expectStatusCode(responseCode);
        responseSpecBuilder.expectBody("Success", is(isSuccess));
        responseSpecBuilder.expectBody("Result.Id", greaterThan(0));
        responseSpecBuilder.expectBody("Result.Status", equalTo(salesOrderStatus.getSalesOrderStatus()));
        responseSpecBuilder.expectBody("Result.EFId", equalTo(studentBeanIn.getUser_id()));
        responseSpecBuilder.expectBody("Result.Items.OfferId", hasItem(Integer.parseInt(studentBeanIn.getOffer_id())));
        // buy with existing pay info no token returned
        if (StringUtils.contains(getBaseURI(), "BuyWithExistingPaymentInfo")) {
            logger.info("Commerce-token empty checked  ....!");
            responseSpecBuilder.expectBody("Result.Token", isEmptyOrNullString());
        } else {
            logger.info("Commerce token cheked ...!");
            responseSpecBuilder.expectBody("Result.Token", not(isEmptyOrNullString()));
        }

        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * COMMERCE API
     */
    // GET /_api/commerce/member/payment-token-account
    public void commerceApiGetMemberPaymentToken(GatewayType gatewayType) {
        cleanUp();
        initSpecGetMemberPayTokenCommerceApi();
        initResponseGetPayTokenCommerceApi(gatewayType);
        //defaultGetResponseGetSpec();

        Response response = defaultGetResponseGetSpec();
        /*try {
            studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
            logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get Order ID [" +  studentBean.getOrder_id()+ "] " + e.getMessage());
        }*/

    }

    public void initSpecGetMemberPayTokenCommerceApi() {
        testBaseUrl = getBASE_TEST_URL() + commerceApiMemberTockenAccountUrl;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     * use for member and order
     *
     * @param gatewayType
     */
    public void initResponseGetPayTokenCommerceApi(GatewayType gatewayType) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("GatewayType", containsIgnoringCase(gatewayType.getGatewayType()));
        responseSpecBuilder.expectBody("GatewayCardType", containsIgnoringCase(testCard.getCardShortName()));
        responseSpecification = responseSpecBuilder.build();
    }

    public void commerceApiGetOrderPaymentToken(StudentBean studentBean, SalesOrderStatus orderStatus, boolean isTokenCheck) {
        cleanUp();
        initSpecGetOrderPayTokenCommerceApi();
        //initResponseGetPayTokenCommerceApi(gatewayType);
        initResponseSpecBuyWithCardCommerceApi(studentBean, orderStatus, isTokenCheck);

        defaultGetResponsePostSpec();
    }

    public void initSpecGetOrderPayTokenCommerceApi() {
        testBaseUrl = getBASE_TEST_URL() + commerceApiOrderPaymentTokenUrl;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());

        orderPaymentTokeCommerceApi = orderPaymentTokeCommerceApi.replace("channelReplaceWithDynamic", studentBean.getChannel());
        orderPaymentTokeCommerceApi = orderPaymentTokeCommerceApi.replace("00000", studentBean.getOffer_id());

        setBodyRequestSpecBuilder(orderPaymentTokeCommerceApi);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public StudentBean enrollStudent(String env, StudentBean studentBean, String loginUrl) {
        logger.info("Create user, buy, enroll ...!");
        TestngListener.isStoreScreenShotOnFailure = false;
        studentBean = StaticBaseApiSpec.getUUID_afterPay(env, studentBean, 200);
        String xefidAccessTocken = StaticBaseApiSpec.getXefAccessToken(env, studentBean, loginUrl);
        studentBean.setXefaccess(xefidAccessTocken);
        studentBean = StaticBaseApiSpec.enrolStudent(env, studentBean, 201);
        studentBean.setEnroll(studentBean.getEnroll()); //Enroll.INTERMEDIATE);
        studentBean = StaticBaseApiSpec.updateEnrollment(env, studentBean, 200);
        studentBean.print();

        return studentBean;
    }

    /**
     * Student survey notification
     */
    //get
    public void getStudentNotification(StudentBean studentBean, int remainingViews88, int remainingViews90) {
        cleanUp();
        initSpecGetStudentNotification(studentBean);
        initResponseSpecGetStudentNotification(studentBean, remainingViews88, remainingViews90);

        response = defaultGetResponseGetSpec();

        try {
            surveyKey88 = response.jsonPath().getString("settings.key[0]");
            surveyKey90 = response.jsonPath().getString("settings.key[1]");
            logger.info("surveyKey88 [" + surveyKey88 + "]  key 90 [" + surveyKey90 + "]");
        } catch (Exception e) {
            logger.error("Cant get survey keys " + e.getMessage());
            failTest("Cant get survey keys ...!");
        }
    }

    public void initSpecGetStudentNotification(StudentBean studentBean) {
        testBaseUrl = getBASE_TEST_URL() + STUDENT_NOTIFICATION;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecBuilder.addHeader("X-EF-Access", studentBean.getXefaccess());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecGetStudentNotification(StudentBean studentBeanIn, int remainingViews88, int remainingViews90) {
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        //responseSpecBuilder.expectBody("settings.key", greaterThan(0)); hasSize(greaterThan(0))
        responseSpecBuilder.expectBody("settings.key", hasSize(equalTo(2)));
        responseSpecBuilder.expectBody("settings.value.sourceItemId[0]", is(equalTo("88")));
        responseSpecBuilder.expectBody("settings.value.sourceItemId[1]", is(equalTo("90")));
        responseSpecBuilder.expectBody("settings.value.remainingViews[0]", is(equalTo(remainingViews88)));
        responseSpecBuilder.expectBody("settings.value.remainingViews[1]", is(equalTo(remainingViews90)));
        responseSpecification = responseSpecBuilder.build();
    }

    // put
    public void updateStudentNotification(StudentBean studentBean) {
        cleanUp();
        initSpecPutUpdateStudentNotification(studentBean);
        initResponseSpecPutUpdateStudentNotification(studentBean);

        defaultPutSpec();
    }

    public void initSpecPutUpdateStudentNotification(StudentBean studentBean) {
        testBaseUrl = getBASE_TEST_URL() + STUDENT_NOTIFICATION;
        String studentNotification = putStudentNotification;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecBuilder.addHeader("X-EF-Access", studentBean.getXefaccess());

        studentNotification = studentNotification.replace("keyReplaceWithDynamic88", surveyKey88);
        studentNotification = studentNotification.replace("keyReplaceWithDynamic90", surveyKey90);
        setBodyRequestSpecBuilder(studentNotification);
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseSpecPutUpdateStudentNotification(StudentBean studentBeanIn) {
        logger.info("Check Response ");
        expectedResponseCode = 201;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);        //responseSpecBuilder.expectBody("Order_id", greaterThan(0));        //responseSpecBuilder.expectBody("Items.Order_id", hasSize(greaterThan(0)));        //responseSpecBuilder.expectBody("Items.Offer_id[0]", is(Integer.parseInt(studentBeanIn.getOffer_id())) );
        responseSpecification = responseSpecBuilder.build();
    }


    /***
     * Get all user data
     *
     * https://qa-englishlive.ef.com/1/api/commerce-gateway/contact/details?email=auto_80288268624228_BYFLHFG938802925_xdelx@qp1.org
     */
    public void getAllUserData(String userEmail, int responseCode) {
        cleanUp();
        initSpecGetAllUserDataApi(userEmail);
        initResponseGetAllUserDataApi(responseCode);

        Response response = defaultGetResponseGetSpec();
    }

    public void initSpecGetAllUserDataApi(String userEmail) {
        testBaseUrl = getBASE_TEST_URL() + BaseApiHelper.CONTACT_DETAILS_ENDPOINT + userEmail;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("accept", "application/json");
        requestSpecBuilder.addHeader("credentials", "include");
        requestSpecBuilder.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetAllUserDataApi(int responseCode) {
        logger.info("Check Response ");
        expectedResponseCode = responseCode;
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecification = responseSpecBuilder.build();
    }

    /**
     * Login a user and get account gwt token to set X-EF-ACCESS on the request for enroll
     *
     * @param env
     * @return
     */
    public String getXefAccessGwtToken(String env, StudentBean studentBean, String loginUrl) {
        setGridEnvironmentFromDargs();
        WebDriver webDriver = null;
        String xefAccountAccess = "";

        try {
            webDriver = DriverManager.getNewDriver(MyBrowserType.CHROME_HEADLESS, WaitTool.MED_WAIT_4_ELEMENT25);
            webDriver.get(loginUrl);
            LoginPage loginPage = new LoginPage(webDriver, 25);
            loginPage.getPageLoadedCondition();
            loginPage.simpleTest();
            loginPage.enterCredentials(studentBean.getUserEmail(), "12345678");
            loginPage.clickLoginBtn(loginPage.loginBtnLatest);
            Thread.sleep(2000);

            WaitTool.waitForCondition(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("[class^='welcome-step_'] button")),
                    webDriver, 35);

            //xefidAccessTocken
            xefAccountAccess = CookieHandler.getAccountXEFid(webDriver);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            logger.info("BaseApiTest tart destroyDriver.......!");
            try {
                if (webDriver != null) {
                    webDriver.quit();
                    DriverManager.destroyLocalDriver();
                    logger.info("webDriver Destroyed ...!");
                } else {
                    logger.info("Driver Not Destroyed ...is NULL ...!");
                }
            } catch (Exception e) {
                logger.error("Destroy  webDriver failed :" + e.getMessage());
            }
            webDriver = null;
        }
        return xefAccountAccess;
    }


}


    //
//    //////////////////////////////////////////////////////////////////////////////
//    /**
//     * TODO move all statics on a new class
//     *
//     * Create a static method to be called from any place to sent rest request
//     *
//     *
//     * @param requestSpecBuilder
//     * @param requestUrl
//     * @param restCallType ... post or get
//     * @return Response
//     *
//     * Note : you must set RequestSpecBuilder [headers, setContentType, body, form as needed]
//     */
//    public static Response getResponse(
//            RequestSpecBuilder requestSpecBuilder, String requestUrl, RestCallType restCallType,
//            boolean isPrintBody, int expectedResponseCode){
//
//        Response response = null;
//        switch (restCallType) {
//            case POST:
//                logger.info("Call POST");
//                response = postSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
//                break;
//
//            case GET:
//                logger.info("Call GET");
//                response = getSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
//                break;
//
//            case PUT:
//                logger.info("Call PUT");
//                response = putSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
//                break;
//
//            case PATCH:
//                logger.info("Call PATCH");
//                response = patchSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
//                break;
//
//            default:
//                logger.error("Case must be get or post for the time being ... or add support");
//                break;
//        }
//
//        if(null == response && StringUtils.isBlank(response.getHeaders().toString()))
//            failTest("Could not get the response or is blank ...!");
//
//        logger.info("\n < Restponse Status line ["+response.getStatusLine()+"]; Response Status code ["+response.getStatusCode()+"]");
//        logger.info("\n < Restponse > \n "+response.getHeaders().toString());
//        if(isPrintBody)
//            logger.info("\n < Restponse > \n "+response.body().prettyPrint());
//
//        return response;
//    }
//
//    /**
//     *
//     * Request method:	POST
//     * Request URI:	https://qa-accounts.ef.com/oauth2/users
//     */
//    public static StudentBean createUserId(String env, StudentBean studentBean, int expectedResponseCode){
//        String endPointUrl = "https://qa-accounts.ef.com/oauth2/users";
//
//        if(StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.setContentType(ContentType.URLENC);
//        requestSpecBuilder.setBaseUri(endPointUrl);
//        requestSpecBuilder.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        requestSpecBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
//        requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");
//
//        UniqueDataObject udo = new UniqueDataObject();
//        studentBean.setUserEmail(udo.getEmail());
//        //studentBean.setUserEmail();
//        logger.info("generateEmail (email) : " + studentBean.getUserEmail());
//
//        CREATE_USER_MAP.replace("email", studentBean.getUserEmail());
//
//        String continueUrl = CREATE_USER_MAP.get("continue_uri");
//
//        if(StringUtils.equals("live", env)) {
//            continueUrl = continueUrl.replace("qa-", "");
//            CREATE_USER_MAP.replace("continue_uri", continueUrl);
//
//            requestSpecBuilder.addHeader("Origin", "https://accounts.ef.com");
//            requestSpecBuilder.addHeader("host", "accounts.ef.com");
//        } else {
//            requestSpecBuilder.addHeader("Origin", "https://qa-accounts.ef.com");
//            requestSpecBuilder.addHeader("host", "qa-accounts.ef.com");
//        }
//
//        requestSpecBuilder.addFormParams(CREATE_USER_MAP);        /*RequestSpecification requestSpecification = requestSpecBuilder              .addFormParams(CREATE_USER_MAP)              .addFilter(new ResponseLoggingFilter())                .addFilter(new RequestLoggingFilter())                .setRelaxedHTTPSValidation()   // for ssl                .build();*/
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);
//
//        try {
//            studentBean.setUser_id(response.jsonPath().getString("user_id"));
//            continue_url = response.jsonPath().getString("continue_uri");
//
//            studentBean.setUuid(getUserUID(continue_url));
//            logger.info("user_ID [" + studentBean.getUser_id() + "] ");
//        } catch (Exception e) {
//            logger.error("Cant get user ID [" +  studentBean.getUser_id()+ "] " + e.getMessage());
//        }
//
//        return studentBean;
//    }
//
//    /**
//     *
//     * @param env
//     * @param studentBean
//     *
//     * Request method:	POST
//     * Request URI:	https://qa-englishlive.ef.com/1/api/commerce-gateway/member
//     */
//    public static StudentBean createCommApiMember(String env, StudentBean studentBean, int expectedResponseCode){
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if(StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        requestSpecBuilder.setBaseUri(endPointUrl);
//        //requestSpecBuilder.setContentType( ContentType.JSON);
//        requestSpecBuilder.addHeader("Accept", "application/json");
//        requestSpecBuilder.addHeader("Content-Type", "application/json; charset=UTF-8");
//
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
//
//        CREATE_COMMERCE_MEMBER.replace("Country",   studentBean.getCountry());
//        CREATE_COMMERCE_MEMBER.replace("Language",  studentBean.getLang());
//        CREATE_COMMERCE_MEMBER.replace("UserName",  studentBean.getUserEmail());
//        CREATE_COMMERCE_MEMBER.replace("email",     studentBean.getUserEmail());
//        if(StringUtils.isNotBlank(studentBean.getPtn()))
//            CREATE_COMMERCE_MEMBER.replace("Partner",     studentBean.getPtn());
//
//        requestSpecBuilder.setBody(CREATE_COMMERCE_MEMBER);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);
//
//        try {
//            //studentBean.setUser_id(response.jsonPath().getString("user_id"));
//            studentBean.setUser_id(response.jsonPath().getString("EFId"));
//            logger.info("setUser_id [" + studentBean.getStudent_id() + "] ");
//            String responseContinueUrl = response.jsonPath().getString("continue_uri");
//
//            //studentBean.setUuid(getUserUID(responseContinueUrl));
//            //logger.info("user_ID [" + studentBean.getUser_id() + "] "+"  EFId [" + studentBean.getStudent_id() + "] ");
//        } catch (Exception e) {
//            logger.error("Cant get user ID [" +  studentBean.getUser_id()+ "] " + e.getMessage());
//        }
//
//        return studentBean;
//
//    }
//
//    public static StudentBean buyWithCreditCardComApiTest(String env, StudentBean studentBean, TestCard testCard, int expectedResponseCode) {
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/order/credit-card-capture";
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if(StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        if(StringUtils.equals("live", env)) {
//            logger.warn("This is live no CC/DD test run ... ONLY QA we run this ...!");
//        }
//        else {
//            studentBean.setOffer_id("2006");
//            requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
//            requestSpecBuilder.setContentType(ContentType.JSON);
//            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("piCountryReplaceWithDynamic", studentBean.getCountry());
//            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("channelReplaceWithDynamic",   studentBean.getChannel());
//            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("offerIdReplaceWithDynamic",   studentBean.getOffer_id());
//
//            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("ccNumberReplaceWithDynamic",  testCard.getCardNumber());
//            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("ciCountryReplaceWithDynamic", studentBean.getCountry());
//
//            requestSpecBuilder.setBody(comApiDefaultPayLoad);
//
//            requestSpecBuilder
//                    .addFilter(new ResponseLoggingFilter())
//                    .addFilter(new RequestLoggingFilter())
//                    .setRelaxedHTTPSValidation();
//
//            Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);
//
//            try {
//                studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
//                logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
//            } catch (Exception e) {
//                logger.error("Cant get Order ID [" +  studentBean.getOrder_id()+ "] " + e.getMessage());
//            }
//        }
//
//        return studentBean;
//    }
//
//    public static StudentBean buyDeliverWithoutCapture(String env, StudentBean studentBean, int expectedResponseCode) {
//        logger.info("....... buyDeliverWithoutCapture .....!");
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/order/delivery-without-capture";
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        String payload = salesForceDeliverWithoutCapturePayLoad;
//
//        if(StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        if(StringUtils.equals("live", env)) {
//            logger.warn("This is live no CC/DD test run ... ONLY QA we run this ...!");
//        }
//        else {
//            studentBean.setOffer_id("2006");
//            if(StringUtils.containsIgnoreCase(environment, "live") ){
//                requestSpecBuilder.addHeader("Authorization", "Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiY4YzFtMnIzYw==");//old Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiRwJjhjMW0ycjNj
//            } else //use QA and see ....? erden nnnnnn
//                requestSpecBuilder.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");
//
//            //requestSpecBuilder.addHeader("Authorization", "Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiY4YzFtMnIzYw==" ); //"Bearer uuid:"+studentBean.getUuid());
//            String oppNo = Integer.toString(TestUtil.getRandomNumberInRange(7, 99999));
//            logger.info("Opportunity number [{}]", oppNo);
//            requestSpecBuilder.setContentType(ContentType.JSON);
//            payload = payload.replace("offerIdReplaceWithDynamic",   studentBean.getOffer_id());
//            payload = payload.replace("oppNoReplaceWithDynamic", oppNo );
//            payload = payload.replace("efidReplaceWithDynamic",   studentBean.getUser_id()); //User_id());
//            payload = payload.replace("countryReplaceWithDynamic", studentBean.getCountry());
//            payload = payload.replace("partnerReplaceWithDynamic", studentBean.getPtn());
//            payload = payload.replace("etagReplaceWithDynamic", studentBean.getEtag());
//            payload = payload.replace("channelReplaceWithDynamic", studentBean.getChannel());
//
//            requestSpecBuilder.setBody(payload);
//
//            requestSpecBuilder
//                    .addFilter(new ResponseLoggingFilter())
//                    .addFilter(new RequestLoggingFilter())
//                    .setRelaxedHTTPSValidation();
//
//            Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);
//
//            try {
//                studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
//                logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
//            } catch (Exception e) {
//                logger.error("Cant get Order ID [" +  studentBean.getOrder_id()+ "] " + e.getMessage());
//            }
//        }
//
//        return studentBean;
//    }
//
//    // TODO enroll users    NEEd X-EF access token ...
//    //post https://qa-accounts.ef.com/oauth2/v2/login/email
//    // returns continue_uri
//    // open that in a browser and get be uuid from the URL
//    /**
//     * Call login email to get student uuid
//     *
//     * Continue url :
//     * https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2F1%2Foauth2%2Fredirect%3Fcustom-redirect
//     *
//     */
//    public static StudentBean getUUID_afterPay(String env, StudentBean studentBean, int expectedResponseCode){ //, String continueUrl) {
//        String endPointUrl = "https://qa-accounts.ef.com/oauth2/v2/login/email";
//        //                    https://qa-accounts.ef.com/oauth2/cors/v1/login/email
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        requestSpecBuilder.setConfig(
//                RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs(
//                        "x-www-form-urlencoded",ContentType.URLENC)));
//
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        requestSpecBuilder.setUrlEncodingEnabled(true);
//        //requestSpecBuilder.setContentType("application/x-www-form-urlencoded; charset=UTF-8");  //ContentType.URLENC);//
//
//        requestSpecBuilder.addFormParam("email",    studentBean.getUserEmail());
//        requestSpecBuilder.addFormParam("password", "12345678");
//        requestSpecBuilder.addFormParam("continue_uri", "https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2F1%2Foauth2%2Fredirect%3Fcustom-redirect"); //continue_url);
//        //
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, true, expectedResponseCode);
//
//        try {
//            continue_url = response.jsonPath().getString("continue_uri");
//            logger.info("user continue_url : "+continue_url);
//            studentBean.setUuid(getUserUID(continue_url));
//            //
//        } catch (Exception e) {
//            logger.error("Cant get continue url " + e.getMessage());
//        }
//
//        return studentBean;
//    }
//
//    /**
//     * Enrol student, need to call login services
//     * @param env
//     * @return
//     *
//     * Request URL: https://qa-englishlive.ef.com/1/api/enrollment/v1/enrollments
//     * Request Method: POST     *
//     * Authorization: Bearer uuid:055e76f3-91f5-3eb3-9028-af1be5d1df83
//     * Content-Type: application/json     *
//     * payload
//     * {industry: "", motivation: "traveling", level: "13", pace: "THREE_TO_FIVE"}     *     *
//     * Request URL: https://qa-englishlive.ef.com/1/api/school-englishlive/v1/commands/courseEnrollment/update
//     * Request Method: POST     *
//     * Authorization: Bearer uuid:055e76f3-91f5-3eb3-9028-af1be5d1df83     *
//     * payload      *
//     * {args: {levelNumber: 13, courseTypeCode: "GE"}}
//     *
//     * TODO: need X-EF-ACCESS
//     */
//    public static StudentBean enrolStudent(String env, StudentBean studentBean, int expectedResponseCode) {
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/enrollment/v1/enrollments";
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        requestSpecBuilder.setAccept("*/*");
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
//        requestSpecBuilder.addHeader("X-EF-ACCESS", studentBean.getXefaccess());
//
//        enrollStudentJson = enrollStudentJson.replace("industryReplaceWithDynamic", "");
//        enrollStudentJson = enrollStudentJson.replace("motivationReplaceWithDynamic", "traveling");
//        enrollStudentJson = enrollStudentJson.replace("levelReplaceWithDynamic", studentBean.getEnroll().getLevelNo()); //studentBean.getEnroll().getId());
//
//        requestSpecBuilder.setBody(enrollStudentJson);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, false, expectedResponseCode);
//
//
//        return studentBean;
//    }
//
//    /**
//     * need to update enrollment
//     *
//     */
//    public static StudentBean updateEnrollment(String env, StudentBean studentBean, int expectedResponseCode) {
//        //String endPointUrl = "https://qa-englishlive.ef.com/1/api/school-proxy/v1/commands/courseEnrollment/update";
//        String endPointUrl =   "https://qa-englishlive.ef.com/1/api/school-englishlive/v1/commands/courseEnrollment/update";
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        requestSpecBuilder.setAccept("*/*");
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
//        requestSpecBuilder.addHeader("X-EF-ACCESS", studentBean.getXefaccess());
//
//        //        /*updateEnrollmentJson = updateEnrollmentJson.replace("courseTypeCodedReplaceWithDynamic", CourseCodeNumber.GENERAL_ENGLISH.getCourseCode()); //"GE");        updateEnrollmentJson = updateEnrollmentJson.replace("levelNumberReplaceWithDynamic", "5");*/
//        //TODO set course Type from input    templateId
//
//        updateEnrollmentFirstPartJson = updateEnrollmentFirstPartJson + " \"levelNumber\":"+
//                Integer.parseInt(studentBean.getEnroll().getLevelNo()) +", \n"+ updateEnrollmentLastPartJson;
//
//        requestSpecBuilder.setBody(updateEnrollmentFirstPartJson);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, false, expectedResponseCode);
//
//
//        return studentBean;
//    }
//
//    /**
//     * Login a user and get account gwt token to set X-EF-ACCESS on the request for enroll
//     * @param env
//     * @return
//     */
//    public static String getXefAccessToken(String env, StudentBean studentBean, String loginUrl){
//        setGridEnvironmentFromDargs();
//        WebDriver webDriver = null;
//        String xefAccountAccess = "";
//
//        try {
//            webDriver = DriverManager.getNewDriver(MyBrowserType.CHROME_HEADLESS, WaitTool.MED_WAIT_4_ELEMENT25);
//            webDriver.get(loginUrl);
//            LoginPage loginPage = new LoginPage(webDriver, 25);
//            loginPage.getPageLoadedCondition();
//            loginPage.simpleTest();
//            loginPage.enterCredentials(studentBean.getUserEmail(), "12345678");
//            loginPage.clickLoginBtn(loginPage.loginBtnLatest);
//            Thread.sleep(2000);
//            //EnrolmentPage enrolmentPage = new EnrolmentPage(webDriver, 35);
//            //enrolmentPage.getPageLoadedCondition();
//            //enrolmentPage.simpleTest();
//            WaitTool.waitForCondition(
//                    ExpectedConditions.elementToBeClickable(By.cssSelector("[class^='welcome-step_'] button")),
//                    webDriver, 35);
//
//            //xefidAccessTocken
//            xefAccountAccess = CookieHandler.getAccountXEFid(webDriver);//            xefAccountAccess = CookieHandler.getAccountXEFid(webDriver);
//
//        }catch (Exception e){
//            logger.info(e.getMessage());
//        }finally {
//            logger.info("BaseApiTest tart destroyDriver.......!");
//            try {
//                if (webDriver != null) {
//                    webDriver.quit();
//                    DriverManager.destroyLocalDriver();
//                    logger.info("webDriver Destroyed ...!");
//                } else {
//                    logger.info("Driver Not Destroyed ...is NULL ...!");
//                }
//            }catch (Exception e){
//                logger.error("Destroy  webDriver failed :"+e.getMessage());
//            }
//            webDriver = null;
//        }
//        return xefAccountAccess;
//    }
//
//    public static StudentBean createUserNoEnrol(String env,boolean patchPhoneNumberInTYPage,String phoneNumber,String country, String language){
//        logger.info("Create users without enrollment on [{}]", env);
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        TestngListener.isStoreScreenShotOnFailure = false;
//        StudentBean studentBean = new StudentBean();
//        studentBean.setChannel("Online");
//        studentBean.setCountry(country);
//        studentBean.setLang(language);
//        studentBean = BaseApiSpec.createUserId(env, studentBean, 200);
//        studentBean = BaseApiSpec.createCommApiMember(env, studentBean, 200);
//        studentBean = BaseApiSpec.buyWithCreditCardComApiTest(env, studentBean, TestCard.VISA_QA, 200);
//        if(patchPhoneNumberInTYPage) {
//            studentBean.setTelephoneNumber(phoneNumber);
//            updateMemberWithPhoneNumber(studentBean);
//        }
//        studentBean.print();
//
//        return studentBean;
//    }
//
//    /**
//     *
//     * @param env
//     * @param studentBean
//     * @param paymentEndPoint   -- credit-card-capture or delivery-without-capture   for SF
//     * @return
//     */
//    public static StudentBean createUserNoEnrol(String env, StudentBean studentBean, String paymentEndPoint){
//        logger.info("Create users without enrollment on [{}]", env);
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        TestngListener.isStoreScreenShotOnFailure = false;
//        studentBean = BaseApiSpec.createUserId(env, studentBean, 200);
//        studentBean = BaseApiSpec.createCommApiMember(env, studentBean, 200);
//
//        if(StringUtils.containsIgnoreCase("cc", paymentEndPoint))
//            studentBean = BaseApiSpec.buyWithCreditCardComApiTest(env, studentBean, TestCard.VISA_QA, 200);
//        else
//            studentBean  = BaseApiSpec.buyDeliverWithoutCapture(env, studentBean, 200);
//
//        studentBean.print();
//
//        return studentBean;
//    }
//
//    public static StudentBean createUserWithEnroll(String env, StudentBean studentBean, String loginUrl) {
//        logger.info("Create user, buy, enroll ...!");
//        TestngListener.isStoreScreenShotOnFailure = false;
//        studentBean.setChannel("Online"); //("Telesales");//
//        studentBean = BaseApiSpec.createUserId(env, studentBean, 200);
//        studentBean = BaseApiSpec.createCommApiMember(env, studentBean, 200);
//        studentBean = BaseApiSpec.buyWithCreditCardComApiTest(env, studentBean, TestCard.VISA_QA, 200);
//        studentBean = BaseApiSpec.getUUID_afterPay(env, studentBean, 200);
//        String xefidAccessTocken = BaseApiSpec.getXefAccessToken(env, studentBean, loginUrl);
//        studentBean.setXefaccess(xefidAccessTocken);
//        studentBean = BaseApiSpec.enrolStudent(env, studentBean, 201);
//        studentBean.setEnroll(studentBean.getEnroll()); //Enroll.INTERMEDIATE);
//        studentBean = BaseApiSpec.updateEnrollment(env, studentBean, 200);
//        studentBean.print();
//
//        return studentBean;
//    }
//
//    /**
//     * Get student data StudentId
//     * GET => https://qa-englishlive.ef.com/1/api/commerce-gateway/member
//     * Headers:		Accept=application/json
//     * 				Authorization=Bearer uuid:40b24cd2-d389-3aa1-8513-b587b5c1bd18
//     * 				Content-Type=application/json; charset=UTF-8
//     *
//     */
//    public static StudentBean getCommerceMember(String env, StudentBean studentBean, int expectedResponseCode){
//        logger.info("getCommerceMember ...!");
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.GET, false, expectedResponseCode);
//
//        try {
//            studentBean.setStudent_id(response.jsonPath().getString("StudentId"));
//            studentBean.setUser_id(response.jsonPath().getString("EFId"));
//            logger.info("StudentId [" + studentBean.getStudent_id() + "] ");
//            logger.info("EFId [" + studentBean.getUser_id() + "] ");
//        } catch (Exception e) {
//            logger.error("Cant get StudentId  [" +  studentBean.getStudent_id()+ "] " + e.getMessage());
//        }
//        return studentBean;
//    }
//
//    // As we cant get the lead from the ui can not use this for the ui test
//    // get lead
//    // GET :  https://qa-englishlive.ef.com/1/api/salesforce-gateway/lead/200007846
//    // https://jira.eflabs.io/browse/SAND-5970
//    //
//    /**
//     * Need to get the lead ; this will only work if we could get lead id from the UI
//     * @param environment
//     * @param leadId_or_email
//     * @return
//     */
//    //TODO .. this need to be checked as merge issues
//    public static LeadBean getLeadById(String environment, String leadId_or_email) {
//        logger.info("get lead [{}] ...!", leadId_or_email);
//        LeadBean leadBean = new LeadBean();
//        leadBean.print();
//        // QA url
//        String leadUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/lead/" + leadId_or_email;
//
//        // set creds per environment and url
//        if (StringUtils.containsIgnoreCase(environment, "live")) {
//            leadUrl = leadUrl.replace("qa-", "");
//        } else if (StringUtils.containsIgnoreCase(environment, "stg")) {
//            leadUrl = leadUrl.replace("qa-", "stg-");
//        }
//
//        logger.info(" leadUrl [{}] ", leadUrl);
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        return leadBean;
//    }
//
//    /**
//     * Privacy setting
//     * //TODO set settings using the api calls
//     *      ** *      *
//     *      * PUT https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat
//     *      *     Authorization: Bearer uuid:afcf6d7d-ea08-3e20-8f4c-5b5b803471d8
//     *      *  {settings: [{key: "chat_status", value: 5/1/4}]}
//     *         {"settings":[{"key":"profile_privacy","value":"Public"}]}  {"settings":[{"key":"profile_privacy","value":"Friends"}]}
//     *         {"settings":[{"key":"chat_privacy","value":"Public"}]}     {"settings":[{"key":"chat_privacy","value":"Friends"}]}
//     *      *
//     *
//     * Show Profile status online or not
//     *
//     * @param env
//     * @param bearer
//     * @param privacySettingKey       5-offline 1-online 4-busy
//     * @param expectedResponseCode
//     *
//     * {"settings":[{"key":"chat_status","value":5}]}
//     */
//    public static final void setUserProfilePrivacySetting(String env, String bearer,
//                                                          ProfilePrivacySettingKey privacySettingKey, int expectedResponseCode){
//        logger.info("setUserProfileStatus ...! - [{}]", privacySettingKey);
//        String CHANGE_CHAT_STATUS = "{\"settings\":[{\"key\":\""+privacySettingKey.getKey()+"\",\"value\":\""+privacySettingKey.getValue()+"\"}]}";
//        String endPointUrl = "https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat";
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);
//
//        requestSpecBuilder.setBody(CHANGE_CHAT_STATUS);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, expectedResponseCode);
//    }
//
//    /***
//     * todo
//     * Request URL: https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences
//     * Request Method: PUT
//     *
//     * {"settings":[{"key":"is_notify_im","value":true}]}     NEW MESSAGE
//     * {"settings":[{"key":"is_friend_request","value":true}]}
//     * {"settings":[{"key":"enable_study_notification","value":true}]}
//     *
//     *
//     * @param env
//     * @param bearer
//     * @param chatNotificationSettingKey
//     * @param expectedResponseCode
//     */
//    public static final void setChatNotificationSetting(String env, String bearer,
//                                                        ChatNotificationSettingKey chatNotificationSettingKey, int expectedResponseCode){
//        logger.info("setChatNotificationSetting ...! - [{}]", chatNotificationSettingKey);
//
//        String CHANGE_CHAT_STATUS = "{\"settings\":[{\"key\":\""+chatNotificationSettingKey.getKey()+"\",\"value\":"+chatNotificationSettingKey.getValue()+"}]}";
//        String endPointUrl = "https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences";
//
//        if(StringUtils.containsIgnoreCase(chatNotificationSettingKey.getKey(), "enable_study_notification"))
//            endPointUrl = "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notification-preferences";
//
//        //https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notification-preferences        {"settings":[{"key":"enable_study_notification","value":true}]}
//        //https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences {"settings":[{"key":"is_notify_im","value":false}]}
//        //https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences {"settings":[{"key":"is_friend_request","value":false}]}
//
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);
//
//
//        requestSpecBuilder.setBody(CHANGE_CHAT_STATUS);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, expectedResponseCode);
//    }
//
//    /***
//     * Email Notification settings
//     *
//     * /**
//     *  * API calls
//     *  * Request URL: https://qa-englishlive.ef.com/1/api/commerce-gateway/member
//     *  * Request Method: PATCH
//     *  *    Authorization: Bearer uuid:a0cc9001-4fbb-366a-83c7-f350de58775b
//     *  {"SubscribeToStudyPlanEmail":true}
//     *  {"SubscribeToMarketCampaign":true}
//     *  {"SubscribeToDailyLesson":true}
//     *  {"SubscribeToPartnerPromo":true}
//     *  *
//     *
//     * @param env
//     * @param bearer
//     * @param memberEmailNotificationSettingKey
//     * @param expectedResponseCode
//     *
//     */
//    public static final void setCommerceMemberNotificationSetting(String env, String bearer,
//                                                              MemberEmailNotificationSettingKey memberEmailNotificationSettingKey,
//                                                             int expectedResponseCode){
//        logger.info("setUserEmailsNotificationSetting ...! - [{}]", memberEmailNotificationSettingKey);
//        String CHANGE_EMAIL_STATUS = "{\""+memberEmailNotificationSettingKey.getKey()+"\":"+memberEmailNotificationSettingKey.getValue()+"}";
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);
//
//        requestSpecBuilder.setBody(CHANGE_EMAIL_STATUS);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PATCH, false, expectedResponseCode);
//    }
//    /**
//     * Static impl get all user data
//     */
//    public  static Response getAllUserDataResponse(String userEmail, int responseCode, String env){
//        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/contact/details?email=" + userEmail;
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.setAccept(ContentType.JSON);        //requestSpecBuilder.addHeader("accept", "application/json");
//        requestSpecBuilder.addHeader("credentials", "include");
//        requestSpecBuilder.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.GET, false, responseCode);
//
//        return response;
//    }
//
//    /**
//     * Survey
//     */
//
//    /**
//     *
//     * @param env
//     * @param studentBean
//     * @param responseCode
//     * @return
//     */
//    public static Response getStudentNotification(String env, StudentBean studentBean, int responseCode){
//        String endPointUrl =  "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notifications";
//        String studentNotification = putStudentNotificationStatic;
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
//        requestSpecBuilder.addHeader("X-EF-Access", studentBean.getXefaccess());
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.GET, false, responseCode);
//
//        /*try {
//            surveyKey88 = response.jsonPath().getString("settings.key[0]");
//            surveyKey90 = response.jsonPath().getString("settings.key[1]");
//            logger.info("surveyKey88 [" + surveyKey88 + "]  key 90 ["+surveyKey90+"]");
//        } catch (Exception e) {
//            logger.error("Cant get survey keys " + e.getMessage());
//            failTest("Cant get survey keys ...!");
//        }*/
//        return response;
//    }
//
//    /**
//     *
//     * @param env
//     * @param studentBean
//     * @param responseCode
//     * @param surveyKey88   // get this by getting current setting
//     * @param surveyKey90
//     * @return
//     */
//    public static Response updateStudentNotificationPut(String env, StudentBean studentBean, int responseCode,
//                                                        String surveyKey88, String surveyKey90){
//        String endPointUrl =  "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notifications";
//        String studentNotification = putStudentNotificationStatic;
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//
//        if (StringUtils.equals("live", env))
//            endPointUrl = endPointUrl.replace("qa-", "");
//
//        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
//        requestSpecBuilder.setContentType(ContentType.JSON);
//        requestSpecBuilder.setAccept(ContentType.JSON);        //requestSpecBuilder.addHeader("accept", "application/json");
//
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
//        requestSpecBuilder.addHeader("X-EF-Access", studentBean.getXefaccess());
//
//        studentNotification = studentNotification.replace("keyReplaceWithDynamic88", surveyKey88);
//        studentNotification = studentNotification.replace("keyReplaceWithDynamic90", surveyKey90);
//        //setBodyRequestSpecBuilder( studentNotification);
//        requestSpecBuilder.setBody(studentNotification);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, responseCode);
//
//        return response;
//    }
//
//    public static Response updateMemberWithPhoneNumber(StudentBean studentBean) {
//        String testBaseUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.addHeader("Accept", "*/*");
//        requestSpecBuilder.addHeader("Content-Type", "application/json");
//        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
//        requestSpecBuilder.setBody(UPDATE_MEMBER_PHONE);
//
//        requestSpecBuilder
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .setRelaxedHTTPSValidation();
//
//        Response response = getResponse(requestSpecBuilder, testBaseUrl, RestCallType.PATCH, false, 200);
//
//        return response;
//
//    }
//}