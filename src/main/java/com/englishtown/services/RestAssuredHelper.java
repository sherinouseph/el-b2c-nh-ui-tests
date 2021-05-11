package com.englishtown.services;
/**
 * Nikol Apr 2018
 * API test helper for main framework
 *
 * To be able to use rest assured with the rest of framework will use
 * this class to add the helpers for the common methods
 *
 * TODO: test it with a new user and log in and see if user data properly migrated ... no pop up shown when go to chat
 *
 */

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;



public class RestAssuredHelper {
    public static final Logger logger = LoggerFactory.getLogger(RestAssuredHelper.class);

    protected static String migrate_user_url = ".englishtown.com/chat/2.0/legacyfriend/"; //+11416354/migrate";
    protected static String migrate_qa_user_x_ef_access = "eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleXMvcHVibGljL2NoYXQvY2hhdC5wZW0ifQ.eyJpc3MiOiJjaGF0IiwiZXhwIjoxNTUzNjYwODg0LCJpYXQiOjE1MjIxMjQ4ODR9.eIh2fWNVAf_8l7EDs-DXMO5tjMmIz_DzJ6JfSls2dApQdCa_jqrAArrh4wROk3vjHR2zD5Ps3qVArcWEnAt4fKZL-Eeb4vBcHu4Qw0uMWu7EWQKGcz10q1cyQ1tKxmCLpn-9mb0nOwWPiGTcJ_uxvfcxq5izmR8bW5zcbVU8pFU";


    public static RequestSpecification initSpecMigrateUser(String env, String userId) {
        logger.info("initSpecMigrateUser ...!");
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("http://"+env+migrate_user_url+ userId + "/migrate")
                .addHeader("X-EF-ACCESS", migrate_qa_user_x_ef_access)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
        logger.info("build spec [{}] ", spec);
        return spec;
    }


    public static void migrateChatUserData(String env, String memberId) {
        given()
                .spec(initSpecMigrateUser(env, memberId))
                .when().post("")
                .then()
                .statusCode(200)
                .body(containsString("Queued"));
    }


    /*******************************************************************************************************************
     * Test this class methods
     */

    /*@Test
    void testMigrateUser(){
        migrateChatUserData("qa", "11416990");
    }*/

}