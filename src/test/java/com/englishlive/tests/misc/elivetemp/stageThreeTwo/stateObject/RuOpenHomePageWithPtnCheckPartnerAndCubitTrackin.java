//package com.englishlive.tests.misc.elivetemp.stageThreeTwo.stateObject;
///**
// *
// */
//
//import com.englishlive.tests.basetest.BaseCheckPartnerAndCubitTrackin;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class RuOpenHomePageWithPtnCheckPartnerAndCubitTrackin extends BaseCheckPartnerAndCubitTrackin {
//    private static final Logger logger = LoggerFactory.getLogger(RuOpenHomePageWithPtnCheckPartnerAndCubitTrackin.class);
//    @Value("#{applicationPropertiesList['page.home.ru.ru.url']}")
//    private String currentTestUrl;
//
//    @BeforeClass
//    private void setup() {
//        testUrl = currentTestUrl; // UrlMapper.mapUrlToELive(currentTestUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//    }
//
//}