//package com.englishlive.tests.newsite.market.eswws.cl;
//
///**
// *
// */
//
//import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//// flow changed
//public class ClHomepageOeTest extends EnterFormDataSubmitCheckTyMsgTest {
//    public static final Logger logger = LoggerFactory.getLogger(ClHomepageOeTest.class);
//    @Value("#{applicationPropertiesList['home.es.cl.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        formDataMap = EfConstants.AR_LATAM_MAP;
//        formLeadTypeValue = "oe";
//        openUrl(getWebDriver(), testUrl);
//        thankYouMsgContains = "Muchas gracias por registrate";
//    }
//
//
//
//}
