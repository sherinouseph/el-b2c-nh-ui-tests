//package com.englishlive.tests.landing.form.rola.ve;
///**
// *
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseCheckDepartmentIsNotShown;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class VeCheckDepartmentIsNotShown extends BaseCheckDepartmentIsNotShown {
//    private static final Logger logger = LoggerFactory.getLogger(VeCheckDepartmentIsNotShown.class);
//    @Value("#{applicationPropertiesList['ve.lp.url']}")
//    private String testUrl ;
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//}
