//package com.englishlive.tests.misc.elivetemp.stagethreeOne.checkContent;
///**
// * Open URL
// * check page source contains text 'text...' *
// */
//// no need to run this test all the time at CI
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.core.common.BaseCheckPageContainsText;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//
//// MANUAL RUN TEST ONLY
//public class MXCheckPageContainsNglishtownTest extends BaseCheckPageContainsText {
//    private static final Logger logger = LoggerFactory.getLogger(MXCheckPageContainsNglishtownTest.class);
//    @Value("#{applicationPropertiesList['page.home.es.mx.url']}")
//    private String testUrl;
//
//    @BeforeClass
//    private void setup(){
//        testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        currentURL=testUrl;
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//        myWebDriver = getWebDriver();
//        openUrl(myWebDriver, testUrl);
//    }
//
//}