//package com.englishlive.tests.newsite.market.eswws.ar;
//
///**
// * Created by nikol.marku on 8/24/2016.
// *
// *  lead_id: 280264
// *  leadtype: "oe"
// *
// *
// */
//
//import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class ArHomepageOeTest extends EnterFormDataSubmitCheckTyMsgTest {
//    public static final Logger logger = LoggerFactory.getLogger(ArHomepageOeTest.class);
//    @Value("#{applicationPropertiesList['home.es.ar.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        formDataMap = EfConstants.AR_LATAM_MAP;
//        formLeadTypeValue = "oe";
//        submitFormBtnCss = "#osformsubmit";
//        urlContainsThankyou = "es-mx";
//        isInlineTyMsg = true;
//        openUrl(getWebDriver(), testUrl);
//        thankYouMsgContains = "Muchas gracias por registrate";
//        findElement(By.className("popup-offer-and-form-content"));
//        clickAtWindow(getWebDriver(), 7, 7);
//    }
//
//
//
//}
