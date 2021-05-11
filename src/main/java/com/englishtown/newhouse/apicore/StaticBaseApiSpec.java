package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 23-Jan-19.
 *
 * All the static calls shoudl be here
 *
 */

import com.englishtown.dataprovider.bin.LeadBean;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.driver.local.EfDriver;
import com.englishtown.enumpack.RestCallType;
import com.englishtown.enumpack.TestCard;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.beanandenum.enums.ChatNotificationSettingKey;
import com.englishtown.newhouse.school.beanandenum.enums.MemberEmailNotificationSettingKey;
import com.englishtown.newhouse.school.beanandenum.enums.ProfilePrivacySettingKey;
import com.englishtown.newhouse.school.beanandenum.enums.StudentSettings;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.TestngListener;
import com.englishtown.tests.core.UniqueDataObject;
import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;


public abstract class StaticBaseApiSpec extends BaseApiSpec{
    public static final Logger logger = LoggerFactory.getLogger(StaticBaseApiSpec.class);


    /**
     ****************************************************
     *     API helpers specs
     * **************************************************
     */
    //////////////////////////////////////////////////////////////////////////////
    /**
     * TODO move all statics on a new class
     *
     * Create a static method to be called from any place to sent rest request
     *
     *
     * @param requestSpecBuilder
     * @param requestUrl
     * @param restCallType ... post or get
     * @return Response
     *
     * Note : you must set RequestSpecBuilder [headers, setContentType, body, form as needed]
     */
    public static synchronized Response getResponse(
            RequestSpecBuilder requestSpecBuilder, String requestUrl, RestCallType restCallType,
            boolean isPrintBody, int expectedResponseCode){

        Response response = null;
        switch (restCallType) {
            case POST:
                logger.info("Call POST");
                response = postSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
                break;

            case GET:
                logger.info("Call GET");
                response = getSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
                break;

            case PUT:
                logger.info("Call PUT");
                response = putSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
                break;

            case PATCH:
                logger.info("Call PATCH");
                response = patchSpec(requestSpecBuilder.build(), requestUrl, expectedResponseCode);
                break;

            default:
                logger.error("Case must be get or post for the time being ... or add support");
                break;
        }

        if(null == response && StringUtils.isBlank(response.getHeaders().toString()))
            failTest("Could not get the response or is blank ...!");

        logger.info("\n < Restponse Status line ["+response.getStatusLine()+"]; Response Status code ["+response.getStatusCode()+"]");
        logger.info("\n < Restponse > \n "+response.getHeaders().toString());
        if(isPrintBody)
            logger.info("\n < Restponse > \n "+response.body().prettyPrint());

        return response;
    }

    /**
     *
     * Request method:	POST
     * Request URI:	https://qa-accounts.ef.com/oauth2/users
     */
    public static StudentBean createUserId(String env, StudentBean studentBean, int expectedResponseCode){
        String endPointUrl = "https://qa-accounts.ef.com/oauth2/users";

        if(StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.URLENC);
        requestSpecBuilder.setBaseUri(endPointUrl);
        requestSpecBuilder.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        requestSpecBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");

        UniqueDataObject udo = new UniqueDataObject();
        studentBean.setUserEmail(udo.getEmail());
        //studentBean.setUserEmail();
        logger.info("generateEmail (email) : " + studentBean.getUserEmail());

        CREATE_USER_MAP.replace("email", studentBean.getUserEmail());

        String continueUrl = CREATE_USER_MAP.get("continue_uri");

        if(StringUtils.equals("live", env)) {
            continueUrl = continueUrl.replace("qa-", "");
            CREATE_USER_MAP.replace("continue_uri", continueUrl);

            requestSpecBuilder.addHeader("Origin", "https://accounts.ef.com");
            requestSpecBuilder.addHeader("host", "accounts.ef.com");
        } else {
            requestSpecBuilder.addHeader("Origin", "https://qa-accounts.ef.com");
            requestSpecBuilder.addHeader("host", "qa-accounts.ef.com");
        }

        requestSpecBuilder.addFormParams(CREATE_USER_MAP);        /*RequestSpecification requestSpecification = requestSpecBuilder              .addFormParams(CREATE_USER_MAP)              .addFilter(new ResponseLoggingFilter())                .addFilter(new RequestLoggingFilter())                .setRelaxedHTTPSValidation()   // for ssl                .build();*/

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);

        try {
            studentBean.setUser_id(response.jsonPath().getString("user_id"));
            String continue_url = response.jsonPath().getString("continue_uri");

            studentBean.setUuid(getUserUID(continue_url));
            logger.info("user_ID [" + studentBean.getUser_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get user ID [" +  studentBean.getUser_id()+ "] " + e.getMessage());
        }

        return studentBean;
    }

    /**
     *
     * @param env
     * @param studentBean
     *
     * Request method:	POST
     * Request URI:	https://qa-englishlive.ef.com/1/api/commerce-gateway/member
     */
    public static StudentBean createCommApiMember(String env, StudentBean studentBean, int expectedResponseCode){
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        Map createMember = CREATE_COMMERCE_MEMBER;

        if(StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        requestSpecBuilder.setBaseUri(endPointUrl);
        //requestSpecBuilder.setContentType( ContentType.JSON);
        requestSpecBuilder.addHeader("Accept", "application/json");
        requestSpecBuilder.addHeader("Content-Type", "application/json; charset=UTF-8");

        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());

        createMember.replace("Country",   studentBean.getCountry());
        createMember.replace("Language",  studentBean.getLang());
        createMember.replace("UserName",  studentBean.getUserEmail());
        createMember.replace("email",     studentBean.getUserEmail());
        if(StringUtils.isNotBlank(studentBean.getPtn()))
            createMember.replace("Partner",     studentBean.getPtn());

        Gson gson = new Gson();
        String json = gson.toJson(createMember);
        json = json.replace("\"true\"", "true");
        json = json.replace("\"false\"", "false");

        //requestSpecBuilder.setBody(CREATE_COMMERCE_MEMBER);
        requestSpecBuilder.setBody(json);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);

        try {
            //studentBean.setUser_id(response.jsonPath().getString("user_id"));
            studentBean.setUser_id(response.jsonPath().getString("EFId"));
            logger.info("setUser_id [" + studentBean.getStudent_id() + "] ");
            String responseContinueUrl = response.jsonPath().getString("continue_uri");

            //studentBean.setUuid(getUserUID(responseContinueUrl));
            //logger.info("user_ID [" + studentBean.getUser_id() + "] "+"  EFId [" + studentBean.getStudent_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get user ID [" +  studentBean.getUser_id()+ "] " + e.getMessage());
        }

        return studentBean;

    }

    public static StudentBean buyWithCreditCardComApiTest(String env, StudentBean studentBean, TestCard testCard, int expectedResponseCode) {
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/order/credit-card-capture";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if(StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        if(StringUtils.equals("live", env)) {
            logger.warn("This is live no CC/DD test run ... ONLY QA we run this ...!");
        }
        else {
            studentBean.setOffer_id("2006");
            requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
            requestSpecBuilder.setContentType(ContentType.JSON);
            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("piCountryReplaceWithDynamic", studentBean.getCountry());
            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("channelReplaceWithDynamic",   studentBean.getChannel());
            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("offerIdReplaceWithDynamic",   studentBean.getOffer_id());

            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("ccNumberReplaceWithDynamic",  testCard.getCardNumber());
            comApiDefaultPayLoad = comApiDefaultPayLoad.replace("ciCountryReplaceWithDynamic", studentBean.getCountry());

            requestSpecBuilder.setBody(comApiDefaultPayLoad);

            requestSpecBuilder
                    .addFilter(new ResponseLoggingFilter())
                    .addFilter(new RequestLoggingFilter())
                    .setRelaxedHTTPSValidation();

            Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);

            try {
                studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
                logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
            } catch (Exception e) {
                logger.error("Cant get Order ID [" +  studentBean.getOrder_id()+ "] " + e.getMessage());
            }
        }

        return studentBean;
    }

    public static StudentBean buyDeliverWithoutCapture(String env, StudentBean studentBean, int expectedResponseCode) {
        logger.info("....... buyDeliverWithoutCapture .....!");
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/order/delivery-without-capture";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        String payload = salesForceDeliverWithoutCapturePayLoad;

        if(StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        if(StringUtils.equals("live", env)) {
            logger.warn("This is live no CC/DD test run ... ONLY QA we run this ...!");
        }
        else {
            studentBean.setOffer_id("2006");
            if(StringUtils.containsIgnoreCase(environment, "live") ){
                requestSpecBuilder.addHeader("Authorization", "Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiY4YzFtMnIzYw==");//old Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiRwJjhjMW0ycjNj
            } else //use QA and see ....? erden nnnnnn
                requestSpecBuilder.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");

            //requestSpecBuilder.addHeader("Authorization", "Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiY4YzFtMnIzYw==" ); //"Bearer uuid:"+studentBean.getUuid());
            String oppNo = Integer.toString(TestUtil.getRandomNumberInRange(7, 99999));
            logger.info("Opportunity number [{}]", oppNo);
            requestSpecBuilder.setContentType(ContentType.JSON);
            payload = payload.replace("offerIdReplaceWithDynamic",   studentBean.getOffer_id());
            payload = payload.replace("oppNoReplaceWithDynamic", oppNo );
            payload = payload.replace("efidReplaceWithDynamic",   studentBean.getUser_id()); //User_id());
            payload = payload.replace("countryReplaceWithDynamic", studentBean.getCountry());
            payload = payload.replace("partnerReplaceWithDynamic", studentBean.getPtn());
            payload = payload.replace("etagReplaceWithDynamic", studentBean.getEtag());
            payload = payload.replace("channelReplaceWithDynamic", studentBean.getChannel());

            requestSpecBuilder.setBody(payload);

            requestSpecBuilder
                    .addFilter(new ResponseLoggingFilter())
                    .addFilter(new RequestLoggingFilter())
                    .setRelaxedHTTPSValidation();

            Response response = getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);

            try {
                studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
                logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
            } catch (Exception e) {
                logger.error("Cant get Order ID [" +  studentBean.getOrder_id()+ "] " + e.getMessage());
            }
        }

        return studentBean;
    }

    // TODO enroll users    NEEd X-EF access token ...
    //post https://qa-accounts.ef.com/oauth2/v2/login/email
    // returns continue_uri
    // open that in a browser and get be uuid from the URL
    /**
     * Call login email to get student uuid
     *
     * Continue url :
     * https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2F1%2Foauth2%2Fredirect%3Fcustom-redirect
     *
     */
    public static StudentBean getUUID_afterPay(String env, StudentBean studentBean, int expectedResponseCode){
        String endPointUrl = "https://qa-accounts.ef.com/oauth2/v2/login/email";
        String continueUrl = "https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2F1%2Foauth2%2Fredirect%3Fcustom-redirect";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env)) {
            endPointUrl = endPointUrl.replace("qa-", "");
            continueUrl = continueUrl.replace("qa-", "");
        }

        requestSpecBuilder.setConfig(
                RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs(
                        "x-www-form-urlencoded",ContentType.URLENC)));

        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.setUrlEncodingEnabled(true);
        //requestSpecBuilder.setContentType("application/x-www-form-urlencoded; charset=UTF-8");  //ContentType.URLENC);//

        requestSpecBuilder.addFormParam("email",    studentBean.getUserEmail());
        requestSpecBuilder.addFormParam("password", "12345678");
        requestSpecBuilder.addFormParam("continue_uri", continueUrl); //"https://qa-accounts.ef.com/oauth2/auth?response_type=token&client_id=englishlive&scope=&redirect_uri=https%3A%2F%2Fqa-englishlive.ef.com%2F1%2Foauth2%2Fredirect%3Fcustom-redirect"); //continue_url);
        //
        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, true, expectedResponseCode);

        try {
            String continue_url = response.jsonPath().getString("continue_uri");
            logger.info("user continue_url : "+continue_url);
            studentBean.setUuid(getUserUID(continue_url));
            //
        } catch (Exception e) {
            logger.error("Cant get continue url " + e.getMessage());
        }

        return studentBean;
    }

    /**
     * Enrol student, need to call login services
     * @param env
     * @return
     *
     * Request URL: https://qa-englishlive.ef.com/1/api/enrollment/v1/enrollments
     * Request Method: POST     *
     * Authorization: Bearer uuid:055e76f3-91f5-3eb3-9028-af1be5d1df83
     * Content-Type: application/json     *
     * payload
     * {industry: "", motivation: "traveling", level: "13", pace: "THREE_TO_FIVE"}     *     *
     * Request URL: https://qa-englishlive.ef.com/1/api/school-englishlive/v1/commands/courseEnrollment/update
     * Request Method: POST     *
     * Authorization: Bearer uuid:055e76f3-91f5-3eb3-9028-af1be5d1df83     *
     * payload      *
     * {args: {levelNumber: 13, courseTypeCode: "GE"}}
     *
     * TODO: need X-EF-ACCESS
     */
    public static StudentBean enrolStudent(String env, StudentBean studentBean, int expectedResponseCode) {
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/enrollment/v1/enrollments";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        requestSpecBuilder.setAccept("*/*");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecBuilder.addHeader("X-EF-ACCESS", studentBean.getXefaccess());

        enrollStudentJson = enrollStudentJson.replace("industryReplaceWithDynamic", "");
        enrollStudentJson = enrollStudentJson.replace("motivationReplaceWithDynamic", "traveling");
        enrollStudentJson = enrollStudentJson.replace("levelReplaceWithDynamic", studentBean.getEnroll().getLevelNo()); //studentBean.getEnroll().getId());

        requestSpecBuilder.setBody(enrollStudentJson);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, false, expectedResponseCode);


        return studentBean;
    }

    /**
     * need to update enrollment
     *
     */
    public static StudentBean updateEnrollment(String env, StudentBean studentBean, int expectedResponseCode) {
        //String endPointUrl = "https://qa-englishlive.ef.com/1/api/school-proxy/v1/commands/courseEnrollment/update";
        String endPointUrl =   "https://qa-englishlive.ef.com/1/api/school-englishlive/v1/commands/courseEnrollment/update";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        requestSpecBuilder.setAccept("*/*");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecBuilder.addHeader("X-EF-ACCESS", studentBean.getXefaccess());

        //        /*updateEnrollmentJson = updateEnrollmentJson.replace("courseTypeCodedReplaceWithDynamic", CourseCodeNumber.GENERAL_ENGLISH.getCourseCode()); //"GE");        updateEnrollmentJson = updateEnrollmentJson.replace("levelNumberReplaceWithDynamic", "5");*/
        //TODO set course Type from input    templateId

        updateEnrollmentFirstPartJson = updateEnrollmentFirstPartJson + " \"levelNumber\":"+
                Integer.parseInt(studentBean.getEnroll().getLevelNo()) +", \n"+ updateEnrollmentLastPartJson;

        requestSpecBuilder.setBody(updateEnrollmentFirstPartJson);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, false, expectedResponseCode);


        return studentBean;
    }

    public static String getXefAccessToken(String env, StudentBean studentBean, String loginUrl){
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
            //EnrolmentPage enrolmentPage = new EnrolmentPage(webDriver, 35);
            //enrolmentPage.getPageLoadedCondition();
            //enrolmentPage.simpleTest();
            WaitTool.waitForCondition(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("[class^='welcome-step_'] button")),
                    webDriver, 35);

            //xefidAccessTocken
            xefAccountAccess = CookieHandler.getAccountXEFid(webDriver);//            xefAccountAccess = CookieHandler.getAccountXEFid(webDriver);

        }catch (Exception e){
            logger.info(e.getMessage());
        }finally {
            logger.info("BaseApiTest tart destroyDriver.......!");
            try {
                if (webDriver != null) {
                    webDriver.quit();
                    DriverManager.destroyLocalDriver();
                    logger.info("webDriver Destroyed ...!");
                } else {
                    logger.info("Driver Not Destroyed ...is NULL ...!");
                }
            }catch (Exception e){
                logger.error("Destroy  webDriver failed :"+e.getMessage());
            }
            webDriver = null;
        }
        return xefAccountAccess;
    }

    public static StudentBean createUserNoEnrol(String env,boolean patchPhoneNumberInTYPage,String phoneNumber,String country, String language){
        logger.info("Create users without enrollment on [{}]", env);
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        TestngListener.isStoreScreenShotOnFailure = false;
        StudentBean studentBean = new StudentBean();
        studentBean.setChannel("Online");
        studentBean.setCountry(country);
        studentBean.setLang(language);
        studentBean = StaticBaseApiSpec.createUserId(env, studentBean, 200);
        studentBean = StaticBaseApiSpec.createCommApiMember(env, studentBean, 200);
        studentBean = StaticBaseApiSpec.buyWithCreditCardComApiTest(env, studentBean, TestCard.VISA_QA, 200);
        if(patchPhoneNumberInTYPage) {
            studentBean.setTelephoneNumber(phoneNumber);
            updateMemberWithPhoneNumber(studentBean);
        }
        studentBean.print();

        return studentBean;
    }

    /**
     *
     * @param env
     * @param studentBean
     * @param paymentEndPoint   -- credit-card-capture or delivery-without-capture   for SF
     * @return
     */
    public static StudentBean createUserNoEnrol(String env, StudentBean studentBean, String paymentEndPoint){
        logger.info("Create users without enrollment on [{}]", env);
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        TestngListener.isStoreScreenShotOnFailure = false;
        studentBean = StaticBaseApiSpec.createUserId(env, studentBean, 200);
        studentBean = StaticBaseApiSpec.createCommApiMember(env, studentBean, 200);

        if(StringUtils.containsIgnoreCase("cc", paymentEndPoint))
            studentBean = StaticBaseApiSpec.buyWithCreditCardComApiTest(env, studentBean, TestCard.VISA_QA, 200);
        else
            studentBean  = StaticBaseApiSpec.buyDeliverWithoutCapture(env, studentBean, 200);

        studentBean.print();

        return studentBean;
    }

    public static StudentBean createUserWithEnroll(String env, StudentBean studentBean, String loginUrl) {
        logger.info("Create user, buy, enroll ...!");
        TestngListener.isStoreScreenShotOnFailure = false;
        studentBean.setChannel("Online"); //("Telesales");//
        studentBean = StaticBaseApiSpec.createUserId(env, studentBean, 200);
        studentBean = StaticBaseApiSpec.createCommApiMember(env, studentBean, 200);
        studentBean = StaticBaseApiSpec.buyWithCreditCardComApiTest(env, studentBean, TestCard.VISA_QA, 200);
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
     * Get student data StudentId
     * GET => https://qa-englishlive.ef.com/1/api/commerce-gateway/member
     * Headers:		Accept=application/json
     * 				Authorization=Bearer uuid:40b24cd2-d389-3aa1-8513-b587b5c1bd18
     * 				Content-Type=application/json; charset=UTF-8
     *
     */
    public static StudentBean getCommerceMember(String env, StudentBean studentBean, int expectedResponseCode){
        logger.info("getCommerceMember ...!");
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");

        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.GET, false, expectedResponseCode);

        try {
            studentBean.setStudent_id(response.jsonPath().getString("StudentId"));
            studentBean.setUser_id(response.jsonPath().getString("EFId"));
            logger.info("StudentId [" + studentBean.getStudent_id() + "] ");
            logger.info("EFId [" + studentBean.getUser_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get StudentId  [" +  studentBean.getStudent_id()+ "] " + e.getMessage());
        }
        return studentBean;
    }

    // As we cant get the lead from the ui can not use this for the ui test
    // get lead
    // GET :  https://qa-englishlive.ef.com/1/api/salesforce-gateway/lead/200007846
    // https://jira.eflabs.io/browse/SAND-5970
    //
    /**
     * Need to get the lead ; this will only work if we could get lead id from the UI
     * @param environment
     * @param leadId_or_email
     * @return
     */
    public static LeadBean getLeadById(String environment, String leadId_or_email) {
        logger.info("get lead [{}] ...!", leadId_or_email);
        LeadBean leadBean = new LeadBean();
        leadBean.print();
        // QA url
        String leadUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/lead/" + leadId_or_email;

        // set creds per environment and url
        if (StringUtils.containsIgnoreCase(environment, "live")) {
            leadUrl = leadUrl.replace("qa-", "");
        } else if (StringUtils.containsIgnoreCase(environment, "stg")) {
            leadUrl = leadUrl.replace("qa-", "stg-");
        }

        logger.info(" leadUrl [{}] ", leadUrl);

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        return leadBean;
    }

    /**
     * Privacy setting
     * //TODO set settings using the api calls
     *      ** *      *
     *      * PUT https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat
     *      *     Authorization: Bearer uuid:afcf6d7d-ea08-3e20-8f4c-5b5b803471d8
     *      *  {settings: [{key: "chat_status", value: 5/1/4}]}
     *         {"settings":[{"key":"profile_privacy","value":"Public"}]}  {"settings":[{"key":"profile_privacy","value":"Friends"}]}
     *         {"settings":[{"key":"chat_privacy","value":"Public"}]}     {"settings":[{"key":"chat_privacy","value":"Friends"}]}
     *      *
     *
     * Show Profile status online or not
     *
     * @param env
     * @param bearer
     * @param privacySettingKey       5-offline 1-online 4-busy
     * @param expectedResponseCode
     *
     * {"settings":[{"key":"chat_status","value":5}]}
     */
    public static final void setUserProfilePrivacySetting(String env, String bearer,
                                                          ProfilePrivacySettingKey privacySettingKey, int expectedResponseCode){
        logger.info("setUserProfileStatus ...! - [{}]", privacySettingKey);
        String CHANGE_CHAT_STATUS = "{\"settings\":[{\"key\":\""+privacySettingKey.getKey()+"\",\"value\":\""+privacySettingKey.getValue()+"\"}]}";
        String endPointUrl = "https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");

        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);

        requestSpecBuilder.setBody(CHANGE_CHAT_STATUS);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, expectedResponseCode);
    }

    /***
     * todo
     * Request URL: https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences
     * Request Method: PUT
     *
     * {"settings":[{"key":"is_notify_im","value":true}]}     NEW MESSAGE
     * {"settings":[{"key":"is_friend_request","value":true}]}
     * {"settings":[{"key":"enable_study_notification","value":true}]}
     *
     *
     * @param env
     * @param bearer
     * @param chatNotificationSettingKey
     * @param expectedResponseCode
     */
    public static final void setChatNotificationSetting(String env, String bearer,
                                                        ChatNotificationSettingKey chatNotificationSettingKey, int expectedResponseCode){
        logger.info("setChatNotificationSetting ...! - [{}]", chatNotificationSettingKey);

        String CHANGE_CHAT_STATUS = "{\"settings\":[{\"key\":\""+chatNotificationSettingKey.getKey()+"\",\"value\":"+chatNotificationSettingKey.getValue()+"}]}";
        String endPointUrl = "https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences";

        if(StringUtils.containsIgnoreCase(chatNotificationSettingKey.getKey(), "enable_study_notification"))
            endPointUrl = "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notification-preferences";

        //https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notification-preferences        {"settings":[{"key":"enable_study_notification","value":true}]}
        //https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences {"settings":[{"key":"is_notify_im","value":false}]}
        //https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat-notification-preferences {"settings":[{"key":"is_friend_request","value":false}]}


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");

        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);


        requestSpecBuilder.setBody(CHANGE_CHAT_STATUS);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, expectedResponseCode);
    }

    /***
     * Email Notification settings
     *
     * /**
     *  * API calls
     *  * Request URL: https://qa-englishlive.ef.com/1/api/commerce-gateway/member
     *  * Request Method: PATCH
     *  *    Authorization: Bearer uuid:a0cc9001-4fbb-366a-83c7-f350de58775b
     *
     *  {"SubscribeToMarketCampaign":true}
     *  {"SubscribeToDailyLesson":true}
     *  {"SubscribeToPartnerPromo":true}
     *  *
     *
     * @param env
     * @param bearer
     * @param memberEmailNotificationSettingKey
     * @param expectedResponseCode
     *
     */
    public static final void setCommerceMemberNotificationSetting(String env, String bearer,
                                                                  MemberEmailNotificationSettingKey memberEmailNotificationSettingKey,
                                                                  int expectedResponseCode){
        logger.info("setUserEmailsNotificationSetting ...! - [{}]", memberEmailNotificationSettingKey);
        String CHANGE_EMAIL_STATUS = "{\""+memberEmailNotificationSettingKey.getKey()+"\":"+memberEmailNotificationSettingKey.getValue()+"}";
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");

        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);

        requestSpecBuilder.setBody(CHANGE_EMAIL_STATUS);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PATCH, false, expectedResponseCode);
    }

    /**
     *
     * @param env
     * @param bearer
     * @param studentSettings
     * @param expectedResponseCode
     *
     *
     * Request URL: https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/studyplan
     * Request Method: PUT
     * Status Code: 201 Created
     *
     * {"settings":[{"key":"email","value":{"isSubscribed":false}}]}
     *
     * could reuse for https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notification-preferences
     * {"settings":[{"key":"enable_study_notification","value":false}]}
     *
     *
     */
    public static final synchronized void setStudentSetting(String xefAccess, String env, String bearer,
                                                                     StudentSettings studentSettings,
                                                                  int expectedResponseCode){
        logger.info("setUserEmailsNotificationSetting ...! - [{}]", studentSettings);

        String studyPlanPayload             = "{\"settings\":[{\"key\":\""+studentSettings.getKey()+"\",\"value\":{\"isSubscribed\":"+studentSettings.getValue()+"}}]}";
        String notificationPrefsPlanPayload = "{\"settings\":[{\"key\":\""+studentSettings.getKey()+"\",\"value\":"+studentSettings.getValue()+"}]}";
        String bodyPayload = studyPlanPayload;

        String endPointUrl = "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/";

        endPointUrl = endPointUrl+studentSettings.getGroup();

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("endPointUrl [{}]", endPointUrl);

        if (StringUtils.endsWith(endPointUrl, "settings/notification-preferences"))
            bodyPayload = notificationPrefsPlanPayload;

        logger.info("bodyPayload [{}]", bodyPayload);

        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);
        requestSpecBuilder.addHeader("X-EF-ACCESS", xefAccess);


        requestSpecBuilder.setBody(bodyPayload);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, expectedResponseCode);
    }



    /**
     * Static impl get all user data
     */
    public  static Response getAllUserDataResponse(String userEmail, int responseCode, String env){
        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/contact/details?email=" + userEmail;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);        //requestSpecBuilder.addHeader("accept", "application/json");
        requestSpecBuilder.addHeader("credentials", "include");
        requestSpecBuilder.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.GET, false, responseCode);

        return response;
    }

    /**
     *
     * @param env
     * @param studentBean
     * @param responseCode
     * @return
     */
    public static Response getStudentNotification(String env, StudentBean studentBean, int responseCode){
        String endPointUrl =  "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notifications";
        String studentNotification = putStudentNotificationStatic;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");

        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
        requestSpecBuilder.addHeader("X-EF-Access", studentBean.getXefaccess());

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.GET, false, responseCode);

        /*try {
            surveyKey88 = response.jsonPath().getString("settings.key[0]");
            surveyKey90 = response.jsonPath().getString("settings.key[1]");
            logger.info("surveyKey88 [" + surveyKey88 + "]  key 90 ["+surveyKey90+"]");
        } catch (Exception e) {
            logger.error("Cant get survey keys " + e.getMessage());
            failTest("Cant get survey keys ...!");
        }*/
        return response;
    }

    /**
     *
     * @param env
     * @param studentBean
     * @param responseCode
     * @param surveyKey88   // get this by getting current setting
     * @param surveyKey90
     * @return
     */
    public static Response updateStudentNotificationPut(String env, StudentBean studentBean, int responseCode,
                                                        String surveyKey88, String surveyKey90){
        String endPointUrl =  "https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notifications";
        String studentNotification = putStudentNotificationStatic;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("REQ endPointUrl url ["+endPointUrl+"]");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);        //requestSpecBuilder.addHeader("accept", "application/json");

        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
        requestSpecBuilder.addHeader("X-EF-Access", studentBean.getXefaccess());

        studentNotification = studentNotification.replace("keyReplaceWithDynamic88", surveyKey88);
        studentNotification = studentNotification.replace("keyReplaceWithDynamic90", surveyKey90);
        //setBodyRequestSpecBuilder( studentNotification);
        requestSpecBuilder.setBody(studentNotification);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.PUT, false, responseCode);

        return response;
    }

    public static Response updateMemberWithPhoneNumber(StudentBean studentBean) {
        String testBaseUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/member";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Accept", "*/*");
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + studentBean.getUuid());
        requestSpecBuilder.setBody(UPDATE_MEMBER_PHONE);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, testBaseUrl, RestCallType.PATCH, false, 200);

        return response;

    }

    /**
     * get user uuid and X-EF-ACCESS token
     * @param url
     * @return
     */
    public static synchronized String getUserUID(String url) {
        String uuid = null;
        EfDriver efDriver = null;

        try {

            efDriver = new EfDriver(MyBrowserType.CHROME_HEADLESS);

            efDriver.getDriver().get(url);

            String currentUrl = efDriver.getDriver().getCurrentUrl();
            logger.info("currentBrowserUrl [{}]", currentUrl);

            try {
                uuid = currentUrl.split("uuid%3A")[1];
                String tmpStr = uuid;
                logger.info("tmp str :"+tmpStr);
                uuid = uuid.split("&id_token")[0];
            } catch (Exception e) {
                logger.error("Cant get uuid value ...!" + e.getMessage());
            }

            if (StringUtil.isBlank(uuid))
                BasePage.failTest("Can not get UUID ....!");
        }
        catch (Exception e) {
            logger.error("Cant create driver or get uuid and access token ...!" + e.getMessage());
        } finally {
            if(null != efDriver.getDriver())
                efDriver.destroyDriver();
        }

        logger.info("uuid [{}]", uuid);

        return uuid;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**

     * @param requestSpecification
     * @param endpointUrl
     * @return
     */
    public static synchronized Response postSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
        Response response =
                given().
                        spec(requestSpecification).
                        when().
                        post(endpointUrl).
                        then().statusCode(expectedResponseCode).
                        extract().response();
        return response;
    }

    public static synchronized Response getSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
        Response response =
                given().
                        spec(requestSpecification).
                        when().
                        get(endpointUrl).
                        then().
                        statusCode(expectedResponseCode).
                        extract().response();
        return response;
    }
    //

    public static synchronized Response putSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
        Response response =
                given().
                        spec(requestSpecification).
                        when().
                        put(endpointUrl).
                        then().
                        statusCode(expectedResponseCode).
                        extract().response();
        return response;
    }

    public static synchronized Response patchSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
        Response response =
                given().
                        spec(requestSpecification).
                        when().
                        patch(endpointUrl).
                        then().
                        statusCode(expectedResponseCode).
                        extract().response();
        return response;
    }

    /**
     * Get POJOS
     *
     */
    //todo public static  <T> T getResource(RequestSpecification requestSpecification, String endpointUrl, Class<T> responseClass) {
    public static synchronized  <T> T getResource(RequestSpecification requestSpecification, String endpointUrl, Class<T> responseClass) {
        return given()
                .spec( requestSpecification)
                .when()
                .get(endpointUrl)
                .then()
                .statusCode(200)
                .extract().as(responseClass);
    }

    public static final synchronized void updateCreditCard( String env, String bearer,String cardNumber,
                                                            int expectedResponseCode){
        logger.info("updateCreditCard ...! - [{}]");

        String updateCardPayLoad             = "{\"FirstName\":\"sg\",\"LastName\":\"sds\",\"Number\":"+cardNumber+",\"ExpirationMonth\":\"5\",\"ExpirationYear\":\"2025\",\"VerificationCode\":\"123\"}";

        String endPointUrl = "https://qa-englishlive.ef.com/1/api/commerce-gateway/order/credit-card-update";


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (StringUtils.equals("live", env))
            endPointUrl = endPointUrl.replace("qa-", "");

        logger.info("endPointUrl [{}]", endPointUrl);
        logger.info("bodyPayload [{}]", updateCardPayLoad);

        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer uuid:" + bearer);

        requestSpecBuilder.setBody(updateCardPayLoad);

        requestSpecBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setRelaxedHTTPSValidation();

        Response response = getResponse(requestSpecBuilder, endPointUrl, RestCallType.POST, false, expectedResponseCode);
    }




}