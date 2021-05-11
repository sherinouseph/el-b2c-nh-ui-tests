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
//
//import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.Matchers.containsString;
//
// // new site will cover this
//public class SaHomepageOeTest extends EnterFormDataSubmitCheckTyMsgTest {
//    public static final Logger logger = LoggerFactory.getLogger(SaHomepageOeTest.class);
//    @Value("#{applicationPropertiesList['home.page.sa']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        formDataMap = EfConstants.ukFreeConsultationFormMap;
//        thankYouMsgTxtCss = ".message p";
//        openUrl(getWebDriver(), testUrl);
//        thankYouMsgContains = "خطة تعليمية تناسب";
//    }
//
//
//
//}
