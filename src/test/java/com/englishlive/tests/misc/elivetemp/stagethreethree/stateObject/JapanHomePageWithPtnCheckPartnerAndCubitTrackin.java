//package com.englishlive.tests.misc.elivetemp.stagethreethree.stateObject;
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
//public class JapanHomePageWithPtnCheckPartnerAndCubitTrackin extends BaseCheckPartnerAndCubitTrackin {
//    private static final Logger logger = LoggerFactory.getLogger(JapanHomePageWithPtnCheckPartnerAndCubitTrackin.class);
//    @Value("#{applicationPropertiesList['home.jp.jp.url']}")
//    private String currentTestUrl;
//
//    @BeforeClass
//    private void setup() {
//        //testUrl = UrlMapper.mapUrlToELive(currentTestUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//    }
//
//}
