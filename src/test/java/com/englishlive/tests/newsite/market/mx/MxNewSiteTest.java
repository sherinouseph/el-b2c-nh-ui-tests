//package com.englishlive.tests.newsite.market.mx;
///**
// * Created by nikol.marku on 8/5/2016.
// * New website base test
// *
// * Niko: BR team ;changed this .. CSS is different .. so removed
// *
// */
//import com.englishlive.tests.newsite.core.BaseNewSiteDesktopNavigation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class MxNewSiteTest extends BaseNewSiteDesktopNavigation {
//    private static final Logger logger = LoggerFactory.getLogger(MxNewSiteTest.class);
//
//    @Value("#{applicationPropertiesList['home.page.mx']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        runTestCheckTryUs = false;
//        runTestGotoPPpage = false;
//        openUrl(getWebDriver(), testUrl);
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
