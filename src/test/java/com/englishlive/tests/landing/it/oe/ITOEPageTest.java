//package com.englishlive.tests.landing.it.oe;
///**
// * https://jira.eflabs.io/browse/SAND-4991
// *
// * Note there is a redirect on this
// *
// */
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.landingpages.BaseOETest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//// there are 2 forms on this
//public class ITOEPageTest extends BaseOETest {
//    private static final Logger logger = LoggerFactory.getLogger(ITOEPageTest.class);
//
//    @Value("#{applicationPropertiesList['it.oe']}")
//    private String oePageUrl;
//
//
//    @BeforeClass
//    protected void setupOpenLP(){
//        setThreadSafeDriver();
//        formLeadTypeValue = "oe";
//        urlContainsThankyou ="lp/ty";
//        submitBtn = ".bs3 .btn-primary-blue";
//        formDataMap = EfConstants.itFCoeFormMap;
//        openUrl(getWebDriver(), oePageUrl);
//    }
//
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//}
//
