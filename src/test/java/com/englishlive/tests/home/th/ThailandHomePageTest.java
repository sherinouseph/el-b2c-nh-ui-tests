//package com.englishlive.tests.home.th;
///**
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.core.HomePageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//
//public class ThailandHomePageTest extends HomePageTest {
//    private static final Logger logger = LoggerFactory.getLogger(ThailandHomePageTest.class);
//
//    @Value("#{applicationPropertiesList['home.page.th']}")
//    private String pageUrl;
//
//
//    @Override
//    protected HomePage createPage() {
//       // pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
//        return new HomePage(getWebDriver(), this.pageUrl);
//    }
//
//}
