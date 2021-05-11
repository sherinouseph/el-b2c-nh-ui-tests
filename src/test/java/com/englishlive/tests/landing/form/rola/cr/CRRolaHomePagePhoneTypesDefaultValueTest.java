//package com.englishlive.tests.landing.form.rola.cr;
///**
// *
// */
//import com.englishlive.tests.landing.form.rola.baserolaforms.BasePhoneTypeDefaultValues;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CRRolaHomePagePhoneTypesDefaultValueTest extends BasePhoneTypeDefaultValues {
//    private static final Logger logger = LoggerFactory.getLogger(CRRolaHomePagePhoneTypesDefaultValueTest.class);
//    @Value("#{applicationPropertiesList['home.cr.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        clickToCloseDamPopup = true;
//        DEFAULT_MOBILE_VALUE    = "+506-    -";  //for Piura
//        DEFAULT_HOMEPHONE_VALUE = "+506-    -";
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//}
