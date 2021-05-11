//package com.englishlive.tests.landing.form.rola.pe;
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
//   // new page design ...
//public class PERolaHomePageDeptPhoneValidationTest extends BaseRolaDepPhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(PERolaHomePageDeptPhoneValidationTest.class);
//    @Value("#{applicationPropertiesList['home.pe.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        depId      = 0;
//        PRESS_NO_DEPT = 1; // for ie 10 select option
//        clickToCloseDamPopup = false;
//        DEFAULT_MOBILE_VALUE    = "(51)-9  -   -";  //for Piura
//        DEFAULT_HOMEPHONE_VALUE = "(51)-73-   -";
//        DEPARTMENT_TO_SELECT = PE_DEP_LIST_VALUES[depId];
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//}
