//package com.englishlive.tests.newsite.market.sa;
//
///**
// * Created by nikol.marku on 8/24/2016.
// *
// * 1. open mx honme page
// * 2. Enter form data and submit
// * 3.
// *
// */
//// open this once new design goes live
//import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class SaConsultationTest extends EnterFormDataSubmitCheckTyMsgTest {
//    public static final Logger logger = LoggerFactory.getLogger(SaConsultationTest.class);
//    @Value("#{applicationPropertiesList['home.page.sa']}")
//    protected String testUrl;
//    private String saConsultationUrl = "free-consultation/";
//
//
//    @BeforeClass
//    protected void setup(){
//        formDataMap = EfConstants.saFreeConsultationFormMap;
//        isInlineTyMsg = false;
//        thankYouMsgTxtCss = ".message p";
//        openUrl(getWebDriver(), testUrl+saConsultationUrl);
//        thankYouMsgContains = "خطة تعليمية تناسب";
//    }
//
//
//
//}
