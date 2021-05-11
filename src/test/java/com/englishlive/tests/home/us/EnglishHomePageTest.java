//package com.englishlive.tests.home.us;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.core.HomePageTest;
//import org.springframework.beans.factory.annotation.Value;
//
//public class EnglishHomePageTest extends HomePageTest {
//
//    @Value("#{applicationPropertiesList['page.home.en.us.url']}")
//    private String pageUrl;
//
//    @Override
//    protected HomePage createPage() {
//        pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
//        return new HomePage(getWebDriver(), this.pageUrl);
//    }
//
//
//}
