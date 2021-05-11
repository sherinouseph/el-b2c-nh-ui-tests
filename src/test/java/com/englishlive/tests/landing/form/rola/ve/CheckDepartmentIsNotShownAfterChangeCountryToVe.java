//package com.englishlive.tests.landing.form.rola.ve;
///**
// * Open form with department shown and then change to the country where form is not shown
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseCheckDepartmentIsNotShown;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
// // this country is not supported curretly
//
//public class CheckDepartmentIsNotShownAfterChangeCountryToVe extends BaseCheckDepartmentIsNotShown {
//    private static final Logger logger = LoggerFactory.getLogger(CheckDepartmentIsNotShownAfterChangeCountryToVe.class);
//    @Value("#{applicationPropertiesList['cl.lp.url']}")
//    private String testUrl ;
//
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        logger.info("test url is :  "+testUrl ) ;
//        String countryCode = "ve";
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//        // Department is shown
//        validateWebElementShown(By.id(DEPT_SELECT), FAIL_MSG_DEPT_SHOULD_SHOW, 7);
//        // change country
//        TestUtil.actionOnSelectElement(getWebDriver(), true, null, countryCode, By.id(COUNTRY_ID));
//        sleep(1000);
//    }
//
//}
