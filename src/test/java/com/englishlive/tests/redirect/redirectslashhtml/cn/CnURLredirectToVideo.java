//package com.englishlive.tests.redirect.redirectslashhtml.cn;
///**
// *
// In live could you please add this regression test for community:
//
// Visit:
// http://www.englishtown.cn/community/HotWords/XMzE5MjIxMDI4.html
// end up in page:
// http://center.ef.com.cn/blog/video/angryyouth
// // dont care remove
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.redirect.BaseRedirectURLTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class CnURLredirectToVideo extends BaseRedirectURLTest {
//    private static final Logger logger = LoggerFactory.getLogger(CnURLredirectToVideo.class);
//    @Value("#{applicationPropertiesList['redirect.cn.url']}")
//    protected String pageUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        this.openUrl(getWebDriver(), this.pageUrl, -1) ;
//        urlEndsWith = "center.ef.com.cn/blog/video/angryyouth";
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
