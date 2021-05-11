//package com.englishlive.tests.home.id;
///**
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.core.HomePageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeSuite;
//
//
//public class IndonesiaHomePageTest extends HomePageTest {
//    private static final Logger logger = LoggerFactory.getLogger(IndonesiaHomePageTest.class);
//
//    @Value("#{applicationPropertiesList['home.page.id']}")
//    private String pageUrl;
//
//
//    @BeforeSuite
//    void setupBeforeSuite(){
//        isGetTestNodeIpAddress = true;
//    }
//
//    @Override
//    protected HomePage createPage() {
//        //pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
//        return new HomePage(getWebDriver(), this.pageUrl);
//    }
//
//}
