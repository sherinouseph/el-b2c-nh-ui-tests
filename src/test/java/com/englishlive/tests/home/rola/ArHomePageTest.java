//package com.englishlive.tests.home.rola;//package com.englishtown.tests.home.all;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.core.HomePageTest;
//import com.englishlive.tests.home.co.EnglishHomePageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//// this url is redirected to en-wws now so url change test is at expected page will fail
//public class ArHomePageTest extends HomePageTest {
//    private static final Logger logger = LoggerFactory.getLogger(EnglishHomePageTest.class);
//
//    @Value("#{applicationPropertiesList['home.es.ar.url']}")
//    private String pageUrl;
//
//    @BeforeClass
//    private void setup(){
//        pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
//        logger.info("setup ... baseurl :"+getBASEURL()+"  page url is : "+pageUrl);
//    }
//
//    @Override
//    protected HomePage createPage() {
//        return new HomePage(getWebDriver(), this.pageUrl);
//    }
//
//
//}
