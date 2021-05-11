//package com.englishlive.tests.hreflen;
///**
// * Open URL on e.g <link href="http://www.englishtown.com/zh-tw/content/englishtown/tw/zh/" hreflang="zh" rel="alternate"/>
// * check page source Does not contains text '404...'
// * hrfelen
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseCheckHrefLenAltenate;
//import com.englishtown.tests.core.common.BaseCheckPageContainsText;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//// MANUAL RUN TEST ONLY
//public class IThreflenAlternateTest extends BaseCheckHrefLenAltenate {
//    private static final Logger logger = LoggerFactory.getLogger(IThreflenAlternateTest.class);
//    @Value("#{applicationPropertiesList['home.page.it']}")
//    private String testUrl;
//
//    @BeforeClass
//    private void setup(){
//        setMarket("de");
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        currentURL=testUrl;
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + testUrl);
//        myWebDriver = getWebDriver();
//        openUrl(myWebDriver, testUrl);
//        sleep(1000);
//        clickAtWindow(getWebDriver(), 1, 1);
//        sleep(1000);
//    }
//
//}