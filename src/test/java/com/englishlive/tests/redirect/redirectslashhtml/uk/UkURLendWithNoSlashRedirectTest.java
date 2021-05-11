//package com.englishlive.tests.redirect.redirectslashhtml.uk;
///**
// *
// *
// */
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.redirect.BaseRedirectURLTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class UkURLendWithNoSlashRedirectTest extends BaseRedirectURLTest {
//    private static final Logger logger = LoggerFactory.getLogger(UkURLendWithNoSlashRedirectTest.class);
//    @Value("#{applicationPropertiesList['redirect.uk.noslash.url']}")
//    protected String pageUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        this.openUrl(getWebDriver(), this.pageUrl, -1) ;// this is 3 seconds slower this.createPage().loadPage();
//    }
//
//
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(getWebDriver(), this.pageUrl);
//    }
//
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//        destroyDriver();
//    }
//}
//