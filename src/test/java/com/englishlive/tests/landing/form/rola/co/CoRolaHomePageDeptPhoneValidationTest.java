//package com.englishlive.tests.landing.form.rola.co;
///**
// *
// */
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaDepPhoneValidation;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CoRolaHomePageDeptPhoneValidationTest extends BaseRolaDepPhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(CoRolaHomePageDeptPhoneValidationTest.class);
//    @Value("#{applicationPropertiesList['co.lp.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        depId      = 0;
//        PRESS_NO_DEPT = 1; // for ie 10 select option
//        DEFAULT_MOBILE_VALUE    = "(57)-3  -";  //for Bogota
//        DEFAULT_HOMEPHONE_VALUE = "(57)-1-   -";
//        DEPARTMENT_TO_SELECT = CO_DEP_LIST_VALUES[depId];
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//}
