//package com.englishlive.tests.hreflen;
///**
// *
// *
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseCheckHrefLenAltenate;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WebClientResponseHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class MXhreflenAlternateHtmlUnitTest extends BaseCheckHrefLenAltenate  {
//    private static final Logger logger = LoggerFactory.getLogger(MXhreflenAlternateHtmlUnitTest.class);
//    @Value("#{applicationPropertiesList['home.page.mx']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    private void setup(){
//        setMarket("de");
//        WebClientResponseHelper.setOptions( false );
//        runTestOnHtmlUnitAndFailIfNotChrome();
//       // testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        myWebDriver = getWebDriver();
//        openUrl(getWebDriver(), testUrl);
//        sleep(3000);        //clickAtWindow(getWebDriver(), 1, 1);        sleep(1000);
//    }
//
//
//
//
//
//}