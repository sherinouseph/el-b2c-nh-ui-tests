//package com.englishlive.tests.misc.elivetemp.stageThreeTwo.stateObject;
///**
// *
// */
//
//import com.englishlive.tests.basetest.BaseCheckPartnerAndCubitTrackin;
//import com.englishtown.helpers.UrlMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class UkOpenHomePageWithPtnCheckPartnerAndCubitTrackin extends BaseCheckPartnerAndCubitTrackin {
//    private static final Logger logger = LoggerFactory.getLogger(UkOpenHomePageWithPtnCheckPartnerAndCubitTrackin.class);
//    @Value("#{applicationPropertiesList['page.home.en.gb.url']}")
//    private String currentTestUrl;
//
//    @BeforeClass
//    private void setup() {
//        testUrl = currentTestUrl; // UrlMapper.mapUrlToELive(currentTestUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//    }
//
//}
