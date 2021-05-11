//package com.englishlive.tests.landing.form.rola.pe;
///**
// * Open form with department not shown and then change to the country where form is shown
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseCheckDepartmentIsShown;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CheckDepartmentIsShownAfterChangeCountryToPe extends BaseCheckDepartmentIsShown {
//    private static final Logger logger = LoggerFactory.getLogger(CheckDepartmentIsShownAfterChangeCountryToPe.class);
//    @Value("#{applicationPropertiesList['cr.lp.url']}")
//    private String testUrl ;
//
//
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        logger.info("test url is :  "+testUrl ) ;
//        String countryCode = "pe";
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//        // Department is shown
//        validateWebElementNotShown(By.id(DEPT_SELECT), FAIL_MSG_DEPT_SHOULD_NOT_SHOW, 7);
//        // change country
//        TestUtil.actionOnSelectElement(getWebDriver(), true, null, countryCode, By.cssSelector(COUNTRY_CSS));
//        sleep(1000);
//    }
//
//}
