//package com.englishlive.tests.newhouse.apitest;
///**
// * test
// * https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
// */
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.core.IsEqual.equalTo;
//
///**
// * Created by nikol.marku on 02-Oct-17.
// */
//public class NikolRestTest { //extends BaseApiTest {
//    public static final Logger logger = LoggerFactory.getLogger(NikolRestTest.class);
//    protected static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91";
//    protected static String url         = "https://englishlive.ef.com/online/" ; //https://qa-englishlive.ef.com/online/landinghandler.ashx?lp=true&responsemode=json
//
//    Response response ;
//    //String url = "https://englishlive.ef.com/en-gb/?ctr=gb";
//    private static RequestSpecification spec;
//
//    /**
//     http://api.zippopotam.us/?country=us&zipcode=90210
//     Structure: api.zippopotam.us/country/postal-code
//     Example: api.zippopotam.us/us/90210
//     NEW! City->Zip: api.zippopotam.us/country/state/city
//     Example: api.zippopotam.us/us/ma/belmont
//     */
//    //private String zippopatamApi = "http://api.zippopotam.us/us/90210";
//    //int id = 90210;
//
//    private static String host = "10.24.208.122:8080"; //"GBLCM-L1066";
//    //http://GBLCM-L1066:32713/api/PaymentGateway
//    //10.24.208.122 erden
//    private static String erdenRestApi = "http://"+host+"/api/PaymentGateway/ProcessStandaloneCapture";
//    private static String myJson = "{\n" +
//            "  \"GatewayType\": \"Cybersource\",\n" +
//            "  \"RefNumber\": \"123456\",\n" +
//            "  \"Email\": \"fred@soapui.test\",\n" +
//            "  \"Amount\": 0,\n" +
//            "  \"Currency\": \"BRL\",\n" +
//            "  \"ExtraInfo\": \n" +
//            "   {\n" +
//            "     \"country\":\"FR\",\n" +
//            "\"ccFirstName\":\"Fred\",\n" +
//            "\"ccLastName\":\"Feng\",\n" +
//            "\"ccNumber\":\"4111111111111111\",\n" +
//            "\"ccCardVerifyNum\":\"1234\",\n" +
//            "\"ccCardType\":\"001\",\n" +
//            "\"ccExpYear\":\"2030\",\n" +
//            "\"ccExpMonth\":\"12\"\n" +
//            "    },\n" +
//            "  \"User_id\": 1287\n" +
//            "}";
//    /**
//     *  formParam("formParamName", "value1").
//     queryParam("queryParamName", "value2").
//     */
//    @BeforeClass
//    public static void initSpec(){
//        spec = new RequestSpecBuilder()
//                .setBaseUri(erdenRestApi)
//                .setContentType(ContentType.JSON)
//                .addHeader("username","paymentgateway")
//                .addHeader("hostname","b2cLondonAutoTeam")
//                .setBody(myJson)
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
//                .build();
//        //logger.info("spec : ");
//
//    }
//
//    @Test
//    void testErden() {
//        given()
//                .spec(spec)
//                //.log().all()
//                .when().post("")
//                .then()
//                .log().all();
//    }
//
//
//    //@Test
//    void testGoogle() {
//        given()
//                //.log().all().when().get(zippopatamApi)    //  Response res = post("landinghandler.ashx")   ValidatableResponse res =
//                .then()
//                .log().all()
//                .statusCode(200)
//                .body("country",equalTo("United States"))
//                .body("places.state",equalTo("[California]"));
//
//    }
//
//
//    //@Test
//    void createMemberTest(){
//        given()
//                .contentType(ContentType.URLENC)
//                .spec(spec)
//                .body(new HashMap<String, Object>() {{
//                    for (Entry<String, String> entry : memberMap.entrySet()) {
//                        //System.out.println(entry.getKey() + ":" + entry.getValue());
//                        put(entry.getKey(), entry.getValue());
//                    }
//                }})
//                .log().all()
//                .log().all().when().post("landinghandler.ashx?lp=true&responsemode=json")    //  Response res = post("landinghandler.ashx")   ValidatableResponse res =
//        .then()
//                .log().all()
//                .statusCode(200);                       //assertThat("nikol failed ... body ...", res.toString(), containsString("something") );        // "Success":true,
//    }
//
//
//
//    /// DATA
//    static Map<String, String > memberMap = new HashMap<String, String>();
//    static {
//         memberMap.put( "first_name", "AutoTestKlisman");
//         memberMap.put( "last_name", "NikolLastNametest");
//         memberMap.put( "email", "auto_t_99estxdelx@nikol.org");
//         memberMap.put( "telephone", "0478987456"); //"03047898745");
//         memberMap.put( "leadtype", "ee");
//         memberMap.put( "lang", "de");
//         memberMap.put( "local", "de");
//         memberMap.put( "partner", "None");
//         memberMap.put( "OnSuccessUrl", "/de-de/lp/ty/emailenglish-ty/");
//         memberMap.put( "emailenglish", "true");
//         memberMap.put( "englishemail", "true");
//         memberMap.put( "emaillist", "17");
//    }
//
//
//}
//
//
///***
// *
// *
// {
// "Success":true,
// "RedirectUrl":"http://www.englishtown.com/online/pt-thankyou.aspx?omnievents=event5,event34,event4,event33&omniproducts=;EmailEnglish_LeadOE;1;0;event34=0|event33=0&csf=eyJmaXJzdF9uYW1lIjoiQXV0b1Rlc3RLbGlzbWFuIiwiZW1haWwiOiJhdXRvX2ExYTY0Mjc5MDQwMDM1NDFfWUdYWkg1Mjc1M19feGRlbHhAbmlrb2wub3JnIiwicGhvbmUiOiIwNDc4OTg3NDU2ICAgICAgICIsImxlYWRfaWQiOjQxNTk2MX0%3d",
// "LeadId":415961
// }
// *
// *
// *
// *
// *
// * Using parameters:
//     given().
//     param("key1", "value1").
//     param("key2", "value2").
//     when().
//     post("/somewhere").
//     then().
//     body(containsString("OK"));
//
// @Test
// public void exampleRestTest() {
//     given()
//     .contentType(ContentType.JSON)
//     .pathParam("id", "AskJsd8Sd")
//     .when()
//     .get("/examplepath/{id}")
//     .then()
//     .statusCode(200)
//     .body("firstName", equalTo("Onur"))
//     .body("Surname", equalTo("Baskirt"));
// }
// Also, you can get JSON response as a string and send it to the JsonPath class and use its methods to write more structured tests. I generally prefer JsonPath for more structured tests.
//
// exampleJsonPathTestJava
//
// @Test
// public void exampleJsonPathTest() {
//     Response res = get("/service/example");
//     assertEquals(200, res.getStatusCode());
//     String json = res.asString();
//     JsonPath jp = new JsonPath(json);
//     assertEquals("onur@swtestacademy", jp.get("email"));
//     assertEquals("Onur", jp.get("firstName"));
//     assertEquals("Baskirt", jp.get("lastName"));
// }
//
//
// */
//
//// https://github.com/rest-assured/rest-assured/wiki/Usage
//
///*given().
//                //config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
//        when().
//                get("/store").    ///get("loto.json").
//        then().
//                body("store.book.findAll { it.price < 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));
//                */
//// body("$", hasItems(1, 2, 3)); // An empty string "" would work as well
//// body("price", is(new BigDecimal(12.12))) ;
//
//
//
//// get("https://englishlive.ef.com/en-gb/?ctr=gb").       then().                statusCode(200);