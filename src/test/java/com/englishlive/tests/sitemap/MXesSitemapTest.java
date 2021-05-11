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
//public class MXesSitemapTest extends BaseResponseCodeTest {
//    private static final Logger logger = LoggerFactory.getLogger(MXesSitemapTest.class);
//    @Value("#{applicationPropertiesList['sitemap.mx.es.url']}")
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