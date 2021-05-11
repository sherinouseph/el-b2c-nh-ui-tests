//package com.englishlive.tests.misc.elivetemp.stagethreethree.checkContent;
///**
// * Open URL
// * check page source contains text 'text...'
// * https://jira-bos.englishtown.com/browse/SAND-2488
// */
//// manual run only
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.core.common.BaseCheckPageContainsText;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class JPCheckPageContainsNglishtownTest extends BaseCheckPageContainsText {
//    private static final Logger logger = LoggerFactory.getLogger(JPCheckPageContainsNglishtownTest.class);
//    @Value("#{applicationPropertiesList['home.jp.jp.url']}")
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