//package com.englishlive.tests.home.us;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.core.HomePageTest;
//import org.springframework.beans.factory.annotation.Value;
// // moved to mx so no need for this test
//public class ESHomePageTest extends HomePageTest {
//
//    @Value("#{applicationPropertiesList['page.home.es.us.url']}")
//    private String pageUrl;
//
//    @Override
//    protected HomePage createPage() {
//        setLanguageAndMarket();
//        return new HomePage(getWebDriver(), this.pageUrl);
//    }
//}
