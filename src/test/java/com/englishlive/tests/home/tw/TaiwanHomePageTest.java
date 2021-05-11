//package com.englishlive.tests.home.tw;
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
//public class TaiwanHomePageTest extends HomePageTest {
//    private static final Logger logger = LoggerFactory.getLogger(TaiwanHomePageTest.class);
//
//    @Value("#{applicationPropertiesList['home.page.tw']}")
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
