//package com.englishlive.tests.landing.jp;
///**
// * Only one cooke et_s should be present
// */
////NOTE: not sure if this should be part of regression test so commenting it out untill Norman advices
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
///**
// * Created by nikol.marku on 27/01/2016.
// */
//public class JPCheckOnlyOneCookieTest extends BaseTestHelper{
//    private static final Logger logger = LoggerFactory.getLogger(JPCheckOnlyOneCookieTest.class);
//    @Value("#{applicationPropertiesList['jp.os.checkCookie']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    protected void setup() {
//        testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//        openUrl(getWebDriver(), testUrl);
//        sleep(3000);
//    }
//    @Test
//    protected void checkOnlyOneCookieET_S_exist(){
//        isOnlyOneCookie("et_s", 35);
//    }
//
//
//
//    //TODO refactor this
//}
