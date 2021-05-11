//package com.englishlive.tests.misc.elivetemp.stagethreeOne.stateObject;
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
//public class AtOpenHomePageWithPtnCheckPartnerAndCubitTrackin extends BaseCheckPartnerAndCubitTrackin {
//    private static final Logger logger = LoggerFactory.getLogger(AtOpenHomePageWithPtnCheckPartnerAndCubitTrackin.class);
//    @Value("#{applicationPropertiesList['page.home.at.de.wws']}")
//    private String currentTestUrl;
//
//    @BeforeClass
//    private void setup() {
//        testUrl = UrlMapper.mapUrlToELive(currentTestUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//    }
//
//}
