//package com.englishlive.tests.newsite.market.mx;
//
///**
// * Created by nikol.marku on 8/24/2016.
// *
// *  lead_id: 280264
// *  leadtype: "oe"
// *
///// Niko: BR Team changes this now so test removed
// *
// */
//
//import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class MxHomePageFormTest extends EnterFormDataSubmitCheckTyMsgTest {
//    public static final Logger logger = LoggerFactory.getLogger(MxHomePageFormTest.class);
//    @Value("#{applicationPropertiesList['home.page.mx']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        formDataMap = EfConstants.mxOEFormMapWithPhone; //MX_POPUP_CSS; //mxOEFormMapWithPhone;
//        //isEnterFormDataUsingCssMap = true;
//        submitFormBtnCss = "";
//        telNo = "4492270000";
//        formLeadTypeValue = "oe";
//        //urlContainsThankyou = "es-mx";
//        isInlineTyMsg = false;
//        urlContainsThankyou = "thank-you";
//        openUrl(getWebDriver(), testUrl);
//        thankYouMsgTxtCss = "h1.caption";
//        thankYouMsgContains = "Gracias";//"Muchas gracias por registrate"
//        //WebElement popupMainWe = findElement(By.className("popup-offer-and-form-content")); //.findElement(By.cssSelector("[name=first_name]"));
//        clickAtWindow(getWebDriver(), 7, 7);
//        logger.info("");
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
