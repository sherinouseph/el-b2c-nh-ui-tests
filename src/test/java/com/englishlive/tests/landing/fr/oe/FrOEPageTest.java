//package com.englishlive.tests.landing.fr.oe;
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.tests.core.landingpages.BaseOETest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
///**
// * Date: 03/11/14
// * Time: 11:03
// *
// * NOv 2017 there is a 301 now on this page and TY page has been archived
// * so it goes to P&P page
// *
// */
//public class FrOEPageTest extends BaseOETest { //BaseOEPageTest{
//    private static final Logger logger = LoggerFactory.getLogger(FrOEPageTest.class);
//
//    @Value("#{applicationPropertiesList['fr.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger, 2);
//        formLeadTypeValue = "oe";
//
//        submitBtn = ".formset-button";
//        urlContainsThankyou ="welcome" ;
//
//        formDataMap = EfConstants.frOEFormMap;
//        openUrl(getWebDriver(), oePageUrl);
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//}
