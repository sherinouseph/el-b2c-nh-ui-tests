//package com.englishtown.tests.redirect;
///**
// *
// *
// */
//import com.englishtown.tests.responsivecore.BaseRedirect404Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
////
//// TODO these sort of test should be run using HTML unit driver or other plat form -
//public class DeNonExistentRedirectTest extends BaseRedirect404Test {
//    private static final Logger logger = LoggerFactory.getLogger(DeNonExistentRedirectTest.class);
//    @Value("#{applicationPropertiesList['404.de.url']}")
//    protected String pageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        ERROR_404 = DE_ERROR_404;
//        this.openUrl(getWebDriver(), this.pageUrl, -1 ) ;
//        sleep(1000);
//    }
//
//
//
//}
//
