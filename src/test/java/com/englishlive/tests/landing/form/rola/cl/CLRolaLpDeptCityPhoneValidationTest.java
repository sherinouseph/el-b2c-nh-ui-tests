//package com.englishlive.tests.landing.form.rola.cl;
///**
// *
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaDepCityPhoneValidation;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CLRolaLpDeptCityPhoneValidationTest extends BaseRolaDepCityPhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(CLRolaLpDeptCityPhoneValidationTest.class);
//    @Value("#{applicationPropertiesList['cl.lp.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        depId      = 0;
//        cityId     = 3;
//        cityWeSize = 5;
//        PRESS_NO_DEPT = 14;
//        PRESS_NO_CITY = 4;
//        DEFAULT_MOBILE_VALUE    = "(56)-9-    -";  //for RANCAGUA
//        DEFAULT_HOMEPHONE_VALUE = "(56)-72-2   -";
//        DEPARTMENT_TO_SELECT = CL_DEP_LIST_VALUES[depId];
//        CITY_LIST = CL_CITY_LIST_VALUES;
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//}
