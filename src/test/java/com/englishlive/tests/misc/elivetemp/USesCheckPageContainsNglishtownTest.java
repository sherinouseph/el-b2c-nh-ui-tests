//package com.englishlive.tests.misc.elivetemp;
///**
// * Open URL
// * check page source contains text 'text...'
// * on -> page source
// * on -> a tags
// * on -> src tags
// *
// * https://jira-bos.englishtown.com/browse/SAND-2488
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
//// MANUAL RUN TEST ONLY
//public class USesCheckPageContainsNglishtownTest extends BaseCheckPageContainsText {
//    private static final Logger logger = LoggerFactory.getLogger(USesCheckPageContainsNglishtownTest.class);
//    @Value("#{applicationPropertiesList['page.home.es.us.url']}")
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