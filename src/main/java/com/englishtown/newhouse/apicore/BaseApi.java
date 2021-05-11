package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 *
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.enumpack.chat.ChatUserStatus;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.bean.ChatTestUserBean;
import com.englishtown.newhouse.apicore.bean.KeyValue;
import com.englishtown.newhouse.school.pages.StudyCoursePlanPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;


public abstract class BaseApi extends BaseApiHelper {
    public static final Logger logger = LoggerFactory.getLogger(BaseApi.class);

    public long testStartTime;
    public long testEndTime;
    public String surveyKey88;    //this is the first elemetne.g  "key": "bfa1f9a2-6dd0-4260-a26e-9bf10fb3baf4",
    public String surveyKey90;    //the second


    @BeforeTest  // 1* runs before class annotation
    public synchronized void setUpBaseApi() {
        testStartTime = System.currentTimeMillis();
        logger.info("setUp beforeTest ...! testStartTime :>" + testStartTime);        //logger.info("Browser should be set to :> System.getProperty browser <<<<< [{}] >>>>>", System.getProperty("browser"));    logger.info("Grid ENV should be set to :> System.getProperty grid <<<<< [{}] >>>>>", System.getProperty("grid"));
    }

    @BeforeClass // 2*
    public synchronized void setUpBeforeClassBaseApi() {
        logger.info("setUpBeforeClass : Environment  : " + getENVIRONMENT());
        logger.info("\t\t : getBASE_PROFILE_URL  : " + getBASE_PROFILE_URL());

        if (StringUtils.isBlank(getENVIRONMENT())) {
            BaseTest.failTest("Cant get environment [null or empty]...!");
        }

        switch (getENVIRONMENT()) {
            case "live":
                setBASE_TEST_URL(BASE_LIVE_URL);
                logger.info("BASE_TEST_URL set to [{}] ...!", BASE_TEST_URL);
                break;
            case "uat":
                setBASE_TEST_URL(BASE_UAT_URL);
                logger.info("BASE_TEST_URL set to [{}] ...!", BASE_TEST_URL);
                break;
            case "qa":
                setBASE_TEST_URL(BASE_QA_URL);
                logger.info("BASE_TEST_URL set to [{}] ...!", BASE_TEST_URL);
                break;
            case "staging":
                setBASE_TEST_URL(BASE_STG_URL);
                logger.info("BASE_TEST_URL set to [{}] ...!", BASE_TEST_URL);
                break;
            default:
                throw new IllegalArgumentException();
        }


    }


    @AfterTest  // 1* runs before class annotation
    public synchronized void afterTestBaseApi() {
        testEndTime = System.currentTimeMillis();
        logger.info(" afterTestBaseApi...! Time :" + testEndTime);

        Long testTime = null;
        Long testTimeSec = null;

        try {
            testTime = testEndTime - testStartTime;
            testTimeSec = testTime / 1000;
        } catch (NullPointerException | ArithmeticException ae) {
            ae.printStackTrace();
        }
        logger.info("Test total time Milliseconds [" + testTime + "] and Seconds [" + testTimeSec + "]");
    }

    public void openUrl(String url) {
        logger.info("open url [" + url + "]");
        getWebDriver().get(url);
    }

    public void openUrl(WebDriver driver, String url) {
        logger.info("open url [" + url + "]");
        driver.get(url);
    }

    /**
     * Enter user credentials and click login
     * if params passed as null use main userEmail and default pass
     *
     * @param email
     * @param pass
     */
    public void loginUser(String email, String pass) {
        if (null == email)
            email = userEmail;
        if (null == pass)
            pass = DEFAULT_PASS;

        Map<String, String> userCredentials = new LinkedHashMap<>();
        userCredentials.put("email", email);
        userCredentials.put("password", pass);

        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.id("email")), getWebDriver(), 35);
        TestUtil.enterFormData(getWebDriver(), userCredentials);
        WebElementHelper.click(WaitTool.findElement(getWebDriver(), By.cssSelector(loginSubmitButtonCss)));
    }

    /**
     * use only variables not objects
     *
     * @param response
     * @param valueToSet
     * @param responsePathToGetValueFrom
     */
    public void setValueFromResponse(Response response, String valueToSet, String responsePathToGetValueFrom) {
        try {
            valueToSet = response.jsonPath().getString(responsePathToGetValueFrom);
            logger.info("valueToSet [" + valueToSet + "] ");
        } catch (Exception e) {
            logger.error("Cant get value from response for [" + responsePathToGetValueFrom + "] " + e.getMessage());
        }
    }

    /**
     * Todo: Could use an object
     *
     * @param student_level_name
     * @param student_level
     */
    public void checkStudentLevelNameNumber(String student_level_name, String student_level) {
        logger.info("Student level Name & level Number should be [" + student_level_name + " : " + student_level + "]");
        schoolHomePage = new SchoolHomePage(getWebDriver());
        schoolHomePage.simpleTest();
        //TODO schoolHomePage.assertStudentLevelName(student_level_name);
        //schoolHomePage.assertStudentLevelNumber(student_level);
    }

    public void checkStudentCurrentUnit(String student_current_unit) {
        logger.info("Student Current unit selected should be[" + student_current_unit + "]");
        // todo schoolHomePage.assertCurrentUnitSelected(student_current_unit);
    }

    public void checkStudentCoursePlan(int studentLessonNumber) {
        logger.info("checkStudentCoursePlan  ...!");
        openUrl(baseUrl + studyPlanUrl);
        studyCoursePlanPage = new StudyCoursePlanPage(getWebDriver());
        studyCoursePlanPage.simpleTest();
        studyCoursePlanPage.assertLessonListNumber(studentLessonNumber);
    }

    /**
     * Specs hepler
     *
     * @param specUrl use on set spec :
     *                1. setSpecUrl()
     *                2. setContentTypeAndAcceptToJson();
     */
    protected void setSpecUrl(String specUrl) {
        testBaseUrl = specUrl;
        logger.info("REQ url [" + testBaseUrl + "]");
        setBaseURI(testBaseUrl);
        initReqAndResponseSpecBuilder();
        requestSpecBuilder.setBaseUri(getBaseURI());
    }

    protected void setContentTypeAndAcceptToJson() {
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Accept", "application/json");
    }

    public void addHeaderAcceptAndContentType(String acceptStr, String contentTypeStr) {
        if (null == acceptStr)
            acceptStr = "application/json";
        if (null == contentTypeStr)
            contentTypeStr = "application/json";

        requestSpecBuilder.addHeader("Accept", acceptStr);
        requestSpecBuilder.addHeader("Content-Type", contentTypeStr);
        //        requestSpecBuilder.addHeader("Accept", "application/json"); requestSpecBuilder.addHeader("Content-Type", "application/json-patch+json");
    }

    /**
     * Helpers to add params on the request spec builder
     *
     * @param requestSpecBuilder
     * @param keyValue
     */
    public void addHeader(RequestSpecBuilder requestSpecBuilder, Set keyValue) {
        for (Object entry : keyValue) {
            KeyValue tmpKeyValue = (KeyValue) keyValue;
            logger.info("tmpKeyValue :" + tmpKeyValue.toString());
            requestSpecBuilder.addHeader(tmpKeyValue.getKey().toString(), tmpKeyValue.getValue().toString());
        }
    }

    public void addQueryParam(RequestSpecBuilder requestSpecBuilder, Set keyValue) {
        for (Object entry : keyValue) {
            KeyValue tmpKeyValue = (KeyValue) keyValue;
            logger.info("tmpKeyValue :" + tmpKeyValue.toString());
            requestSpecBuilder.addHeader(tmpKeyValue.getKey().toString(), tmpKeyValue.getValue().toString());
        }
    }

    public void addFormParam(RequestSpecBuilder requestSpecBuilder, Set keyValue) {
        for (Object entry : keyValue) {
            KeyValue tmpKeyValue = (KeyValue) keyValue;
            logger.info("tmpKeyValue :" + tmpKeyValue.toString());
            requestSpecBuilder.addHeader(tmpKeyValue.getKey().toString(), tmpKeyValue.getValue().toString());
        }
    }

    //
    public void addPathParam(RequestSpecBuilder requestSpecBuilder, Set keyValue) {
        for (Object entry : keyValue) {
            KeyValue tmpKeyValue = (KeyValue) keyValue;
            logger.info("tmpKeyValue :" + tmpKeyValue.toString());
            requestSpecBuilder.addHeader(tmpKeyValue.getKey().toString(), tmpKeyValue.getValue().toString());
        }
    }

    /**
     * Post spec and check response specification
     */
    public void defaultPostSpec() {
        //try await().atMost(Duration.TWO_SECONDS).until(() -> {     });
        //Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> this.getStatus() == 200)
        //Awaitility.await().atMost(100000, TimeUnit.SECONDS).until(() ->{
        given().
                spec(getRequestSpecification()).
                when().
                post("").
                then().
                spec(getResponseSpecification());

        //return null;
        //});

    }

    public Response defaultGetResponsePostSpec() {
        Response response =
                given().
                        spec(getRequestSpecification()).
                        when().
                        post("").
                        then().
                        spec(getResponseSpecification()).
                        extract().response();
        return response;
    }

    public void defaultPutSpec() {
        given().
                spec(getRequestSpecification()).
                when().
                put("").
                then().
                spec(getResponseSpecification());
    }

    public void defaultPatchSpec() {
        given().
                spec(getRequestSpecification()).
                when().
                patch("").
                then().
                spec(getResponseSpecification());
    }

    public Response defaultGetResponsePatchSpec() {
        Response response =
                given().
                        spec(getRequestSpecification()).
                        when().
                        patch("").
                        then().
                        spec(getResponseSpecification()).
                        extract().response();
        return response;
    }

    public void defaultGetSpec() {
        given().
                spec(getRequestSpecification()).
                when().
                get("").
                then().
                spec(getResponseSpecification());
    }

    public Response defaultGetResponseGetSpec() {

        Response response =
                given().//log().all().
                        spec(getRequestSpecification()).
                        when().
                        get("").
                        then(). //log().all().
                        spec(getResponseSpecification()).
                        extract().response();
        //logger.info("\n ----- response asString \n"+response.asString());
        return response;
    }


    public Headers defaultGetResponseHedearsSpec() {

        Headers responseHeaders =
                given().//log().all().
                        spec(getRequestSpecification()).
                        when().
                        get("").
                        then(). //log().all().
                        spec(getResponseSpecification()).
                        extract().headers();
        //logger.info("\n ----- response asString \n"+response.asString());
        return responseHeaders;
    }


    public boolean isURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            logger.error("Not a valid URL ....! [" + url + "]   error ..." + e.getMessage());
            return false;
        }
    }

    /**
     * access_token=uuid%3Aa7663c52-a8ef-3bd5-8898-b7263584f7d3&scope
     *
     * Get UUID by using browser
     * @param url
     * @return
     */
    public String getUUID(String url) {
        String uuid = null;
        if (isURL(url)) {
            try {
                setGridEnvironmentFromDargs();
                createThreadSafeDriver(MyBrowserType.CHROME_HEADLESS);//      webDriver = WebDriverFactory.getBrowser(MyBrowserType.CHROME, 30);
                openUrl(url);
                String currentUrl = getWebDriver().getCurrentUrl();

                logger.info("currentBrowserUrl [{}]", currentUrl);
                try {
                    uuid = CookieHandler.getUUID(getWebDriver());             //uuid = currentUrl.split("uuid%3A")[1];  uuid = uuid.split("&id_token")[0];
                } catch (Exception e) {
                    logger.error("Cant get uuid value ...!" + e.getMessage());
                }

                if (StringUtil.isBlank(uuid))
                    BasePage.failTest("Can not get UUID ....!");
            } catch (WebDriverException e) {
                logger.error("Cant get current url ...!" + e.getMessage());
            } finally {
                destroyDriver();
            }

        } else
            BasePage.failTest("Can not get UUID; return uri is not URL formatted ....!");

        return uuid;
    }

    /**
     * User API calls and get UUID from response header location value
     * @param env
     * @param requestUrl  ... continue url
     * @return
     *  Not working ... content type
    public String getUuidSpec(String env, String requestUrl) throws NullPointerException{
        String endPointUrl = requestUrl ;
        String uuid = null ;

        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.defaultParser = Parser.JSON;


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(endPointUrl);
        //requestSpecBuilder.setContentType(ContentType.JSON);
        setDefaultFilterReqSpecBuilder(requestSpecBuilder);

        Headers response =  defaultGetResponseHedearsSpec(); //getResponse(  requestSpecBuilder,  endPointUrl, RestCallType.POST,  false, expectedResponseCode);

        try {

            // response.getHeader("Location").split("uuid:")[1].split("%")[0]
            String location = response.getValue("Location");
            //String location = response.getHeader("Location");
            String[] locationParts = location.split("uuid:");
            uuid = locationParts[1].split("%")[0];
            studentBean.setUuid(uuid);
            logger.info("UUID IS [{}]", uuid);
        }catch (NullPointerException n){
            logger.error("Cant get uuid or toke value .. NULL ...! "+n.getMessage());
        }
        catch (IndexOutOfBoundsException i){
            logger.error("cant get uuid from response header at index specified ...!"+i.getMessage());
        } catch (Exception e) {
            logger.error("Cant get uuid [" +  studentBean.getUser_id()+ "] " + e.getMessage());
        }
        //if(StringUtils.isBlank(uuid))
            //failTest("Cant get uuid .....!");
        return uuid;
    }*/


    public ChatTestUserBean createAndSetupNewChatUsers(String memberPageUrl, WebDriver driver,
                                                       Map memberMap, Map paymentMap, boolean isClickTab, int tabId,
                                                       boolean isIncoming, ChatUserStatus status) {
        openUrl(memberPageUrl);
        ChatTestUserBean user = createNewUser(getWebDriver(), memberMap, paymentMap, isClickTab, tabId);
        user.setIncoming(isIncoming);
        user.setChatUserStatus(status);
        //logger.info("User setup...!\n"+user.toString()+"\n ---------------\n");
        chatTestUserList.add(user);
        return user;
    }

}

//
//
// moved to static class
//    /**
//     * get user uuid and X-EF-ACCESS token
//     * @param url
//     * @return
//     */
//    public static String getUserUID(String url) {
//        String uuid = null;
//        WebDriver webDriver = null;
//
//        try {
//            setGridEnvironmentFromDargs();
//            webDriver = DriverManager.getNewDriver(MyBrowserType.CHROME_HEADLESS, 35);
//            webDriver.get(url);
//
//            String currentUrl = webDriver.getCurrentUrl();
//            logger.info("currentBrowserUrl [{}]", currentUrl);
//            try {
//                uuid = currentUrl.split("uuid%3A")[1];
//                String tmpStr = uuid;
//                logger.info("tmp str :"+tmpStr);
//                uuid = uuid.split("&id_token")[0];
//                /*BaseApiSpec.xefidAccessTocken = tmpStr.split("&id_token=")[1].split(".&")[0];
//                logger.info("xefidAccessTocken  [{}]",BaseApiSpec.xefidAccessTocken  );*/
//            } catch (Exception e) {
//                logger.error("Cant get uuid value ...!" + e.getMessage());
//            }
//
//            if (StringUtil.isBlank(uuid))
//                BasePage.failTest("Can not get UUID ....!");
//        }
//        catch (Exception e) {
//            logger.error("Cant create driver or get uuid and access token ...!" + e.getMessage());
//        } finally {
//            if(null != webDriver)
//                webDriver.quit();
//        }
//
//        logger.info("uuid [{}]", uuid);
//
//        return uuid;
//    }
//
//
//    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * For static usage
//     * @param requestSpecification
//     * @param endpointUrl
//     * @return
//     */
//    public static Response postSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
//        Response response =
//                given().
//                        spec(requestSpecification).
//                        when().
//                        post(endpointUrl).
//                        then().statusCode(expectedResponseCode).
//                        extract().response();
//        return response;
//    }
//
//    public static Response getSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
//        Response response =
//                given().
//                        spec(requestSpecification).
//                when().
//                        get(endpointUrl).
//                then().
//                        statusCode(expectedResponseCode).
//                        extract().response();
//        return response;
//    }
//    //
//
//    public static Response putSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
//        Response response =
//                given().
//                        spec(requestSpecification).
//                when().
//                        put(endpointUrl).
//                then().
//                       statusCode(expectedResponseCode).
//                           extract().response();
//        return response;
//    }
//
//    public static Response patchSpec(RequestSpecification requestSpecification, String endpointUrl, int expectedResponseCode){
//        Response response =
//                given().
//                        spec(requestSpecification).
//                when().
//                        patch(endpointUrl).
//                then().
//                        statusCode(expectedResponseCode).
//                        extract().response();
//        return response;
//    }
//
//    /**
//     * Get POJOS
//     *
//     */
//    //todo public static  <T> T getResource(RequestSpecification requestSpecification, String endpointUrl, Class<T> responseClass) {
//    public static  <T> T getResource(RequestSpecification requestSpecification, String endpointUrl, Class<T> responseClass) {
//        return given()
//                .spec( requestSpecification)
//                .when()
//                .get(endpointUrl)
//                .then()
//                .statusCode(200)
//                .extract().as(responseClass);
//    }

//}
//


//com.jayway.awaitility.Awaitility.await().atMost(Duration.TWO_SECONDS).until(() -> {
        /*RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 100000)
                        .setParam(CoreConnectionPNames.SO_TIMEOUT, 100000));  given().
                config(config)*/