//package com.englishlive.tests.redirect.redirectslashhtml.fr;
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
//public class FrURLendWithNoSlashRedirectTest extends BaseRedirectURLTest {
//    private static final Logger logger = LoggerFactory.getLogger(FrURLendWithNoSlashRedirectTest.class);
//    @Value("#{applicationPropertiesList['redirect.fr.noslash.url']}")
//    protected String pageUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        this.openUrl(getWebDriver(), this.pageUrl, -1) ;// this is 3 seconds slower this.createPage().loadPage();
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
