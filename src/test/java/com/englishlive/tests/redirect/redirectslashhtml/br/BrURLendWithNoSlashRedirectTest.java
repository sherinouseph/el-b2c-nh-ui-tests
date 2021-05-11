//package com.englishlive.tests.redirect.redirectslashhtml.br;
///**
// *
// * NM .. this is not redirecting to no slash now BR has changed this so all on them
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.redirect.BaseRedirectURLTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class BrURLendWithNoSlashRedirectTest extends BaseRedirectURLTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrURLendWithNoSlashRedirectTest.class);
//    @Value("#{applicationPropertiesList['redirect.br.noslash.url']}")
//    protected String pageUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        this.openUrl(getWebDriver(), this.pageUrl, -1) ;
//        sleep(1000);
//    }
//
//
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(getWebDriver(), this.pageUrl);
//    }
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//        destroyDriver();
//    }
//
//}
//
