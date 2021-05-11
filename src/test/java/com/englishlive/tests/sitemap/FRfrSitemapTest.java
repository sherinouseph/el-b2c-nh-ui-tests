//package com.englishlive.tests.sitemap;
///**
// *
// *
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class FRfrSitemapTest extends BaseResponseCodeTest {
//    private static final Logger logger = LoggerFactory.getLogger(FRfrSitemapTest.class);
//    @Value("#{applicationPropertiesList['sitemap.fr.fr.url']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    private void setup() {
//        runTestOnHtmlUnitAndFailIfNotChrome();
//        htmlUnitTestUrl = testUrl;
//    }
//
//}