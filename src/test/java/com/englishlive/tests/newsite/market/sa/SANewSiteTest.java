//package com.englishlive.tests.newsite.market.sa;
///**
// * Created by nikol.marku on 8/5/2016.
// * New website base test
// *
// */
//import com.englishlive.tests.newsite.core.BaseNewSiteDesktopNavigation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
// // not live yet
//public class SANewSiteTest extends BaseNewSiteDesktopNavigation {
//    private static final Logger logger = LoggerFactory.getLogger(SANewSiteTest.class);
//
//    @Value("#{applicationPropertiesList['home.ar.sa.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        openUrl(getWebDriver(), testUrl);
//    }
//
//}
