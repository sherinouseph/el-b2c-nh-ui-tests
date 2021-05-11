//package com.englishlive.tests.sitemap;
///**
// *
// *
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverConfig;
//import com.englishtown.dataprovider.SiteMapDataProvider;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WebClientResponseHelper;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.not;
//// vahid adviced remove this test
//// Uses webclient headless browser
//public class AllSitemapTest extends BaseHtmlUnitDriverConfig {
//    private static final Logger logger = LoggerFactory.getLogger(AllSitemapTest.class);
//    @Value("#{applicationPropertiesList['sitemap.fr.fr.url']}")
//    private String testUrl;
//
//    protected String NOT_DEFINED = "SITEMAP-NOT-DEFINED-YET";
//
//    @BeforeClass
//    private void setup() {
//        htmlUnitTestUrl = testUrl;
//        setBrowserName("webclient");
//    }
//
//    @Test (dataProvider = "siteMapUrlall", dataProviderClass = SiteMapDataProvider.class,  threadPoolSize = 10, invocationCount = 1, timeOut = 15000  )
//    public void openUrl_CheckResponseCode200(String country, String url) {
//        int expectedResponseCode = 200;
//        url = getBASE_URL()+url;
//        logger.info("Test Response for URL ["+url+"] ; is :"+expectedResponseCode);
//        openUrlCheckResponseCode( expectedResponseCode, url);
//    }
//
//
//}