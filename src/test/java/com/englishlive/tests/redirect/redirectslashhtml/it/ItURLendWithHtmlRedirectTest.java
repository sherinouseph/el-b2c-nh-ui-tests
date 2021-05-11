//package com.englishlive.tests.redirect.redirectslashhtml.it;
///**
// *
// *
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.redirect.BaseRedirectURLTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class ItURLendWithHtmlRedirectTest extends BaseRedirectURLTest {
//    private static final Logger logger = LoggerFactory.getLogger(ItURLendWithHtmlRedirectTest.class);
//    @Value("#{applicationPropertiesList['redirect.it.endsWitHtml.url']}")
//    protected String pageUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        this.openUrl(getWebDriver(), this.pageUrl, -1) ;
//    }
//
//
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.pageUrl);
//    }
//
//
//}
//
