//package com.englishlive.tests.landing.form.rola.all;
///**
// * englishlive.ef.com/es-co/lp/oe/englishtown
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseChangeCountryCheckUrlAndTxtFiled;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//  // new design rola move to es-wws
//
//public class RolaChangeCountryCheckUrlAndTxtFiled extends BaseChangeCountryCheckUrlAndTxtFiled {
//    private static final Logger logger = LoggerFactory.getLogger(RolaChangeCountryCheckUrlAndTxtFiled.class);
//    @Value("#{applicationPropertiesList['co.lp.url']}")
//    private String testUrl ;
//
//
//    @BeforeClass
//    void setup(){
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//}
