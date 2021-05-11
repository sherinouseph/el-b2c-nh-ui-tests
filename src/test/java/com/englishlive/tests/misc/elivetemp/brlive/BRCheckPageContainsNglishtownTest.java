//package com.englishlive.tests.misc.elivetemp.brlive;//package com.englishlive.tests.misc.elivetemp.stagethreeOne.checkContent;
///**
// * Open URL
// * check page source contains text 'text...'
// * https://jira-bos.englishtown.com/browse/SAND-2488
// */
//
//import com.englishtown.tests.core.common.BaseCheckPageContainsText;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//// note one extra URL open ... not a good one http://qa.englishtown.de/#modal_1be8ctaBannerModal
//// MANUAL RUN TEST ONLY
//public class BRCheckPageContainsNglishtownTest extends BaseCheckPageContainsText {
//    private static final Logger logger = LoggerFactory.getLogger(BRCheckPageContainsNglishtownTest.class);
//    @Value("#{applicationPropertiesList['home.pt.br.url']}")
//    private String testUrl;
//
//    @BeforeClass
//    private void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        //failTest("Need to run this only manually on request");
//        currentURL=testUrl;
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//        myWebDriver = getWebDriver();
//        openUrl(myWebDriver, testUrl);
//    }
//
//}