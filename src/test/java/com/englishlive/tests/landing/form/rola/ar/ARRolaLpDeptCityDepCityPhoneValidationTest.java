//package com.englishlive.tests.landing.form.rola.ar;
///**
// *
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaDepCityPhoneValidation;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// page has changed and there is no form so remove
//public class ARRolaLpDeptCityDepCityPhoneValidationTest extends BaseRolaDepCityPhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(ARRolaLpDeptCityDepCityPhoneValidationTest.class);
//    @Value("#{applicationPropertiesList['home.ar.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        setThreadSafeDriver();
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        depId      = 0;
//        cityId     = 0;
//        PRESS_NO_DEPT = 2; // need to press twice arrow to reach to this selection AR_DEP_LIST_VALUES[depId];
//        PRESS_NO_CITY = 6;
//        cityWeSize = 300;
//        clickToCloseDamPopup = true;
//        DEFAULT_MOBILE_VALUE    = "(54)-9221-   -";  //for RANCAGUA
//        DEFAULT_HOMEPHONE_VALUE = "(54)-221-   -";
//        DEPARTMENT_TO_SELECT = AR_DEP_LIST_VALUES[depId];
//        CITY_LIST = AR_CITY_LIST_VALUES;
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//}
