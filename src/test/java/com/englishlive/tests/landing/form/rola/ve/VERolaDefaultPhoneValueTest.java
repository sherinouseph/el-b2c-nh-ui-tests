//package com.englishlive.tests.landing.form.rola.ve;
///**
// *
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaDefaultPhoneValue;
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaDepCityPhoneValidation;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class VERolaDefaultPhoneValueTest extends BaseRolaDefaultPhoneValue {
//    private static final Logger logger = LoggerFactory.getLogger(VERolaDefaultPhoneValueTest.class);
//    @Value("#{applicationPropertiesList['home.ve.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        DEFAULT_PHONE_VALUE    = "(58)-   -   -";
//        clickToCloseDamPopup = true;
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//        sleep(1000);
//    }
//}
