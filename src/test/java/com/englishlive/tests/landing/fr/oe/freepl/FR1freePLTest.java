//package com.englishlive.tests.landing.fr;
///**
// *
// * Free PL test
// * http://englishlive.ef.com/fr-fr/lp/oe/reservation-cours-particulier/
// *
// *
// */
//
//import com.englishlive.tests.landing.fr.oe.FrOEPageTest;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.landingpages.BaseOETest;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//  redundant test as this page is tested ../..reservation-cours-particulier
//public class FR1freePLTest extends BaseOETest{ //FRfreePLTest {
//    private static final Logger logger = LoggerFactory.getLogger(FR1freePLTest.class);
//    @Value("#{applicationPropertiesList['fr.freepl1']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    public void setupOpenUrl(){
//        setThreadSafeDriver();
//        setTestStartUrl(testUrl);
//        urlContainsThankyou = "thank-you-pl";
//        submitBtn = ".bs3 .btn";
//        formLeadTypeValue = "oe";
//        formDataMap = EfConstants.FR_FREE_PL_CSS;
//        openUrl(getWebDriver(), getTestStartUrl());
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//
//}
