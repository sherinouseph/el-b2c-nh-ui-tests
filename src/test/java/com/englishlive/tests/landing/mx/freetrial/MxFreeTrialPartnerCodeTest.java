//package com.englishlive.tests.landing.mx.freetrial;
////
/////**
//// * Created by sherin 08/11/2017-SAND-4809
//// * Branded search for ?ctr=MX- This has a partner code and the user should go to lead form->Thank you
//// * Non Branded Search-This has a different partner code and the user should go to lead form->Thank you Page
////   gbmx|gomx|ggmx|gdmx|ggus|ggco|godm|ggcl|ggpe|ggro|ggrl|godm
//// */
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.CookieHandler;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.UniqueDataObject;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
//// jan 2018 karim removed .. no more free
//public class MxFreeTrialPartnerCodeTest extends BaseFreeTrialPartnerCodeTest {
//    public static final Logger logger = LoggerFactory.getLogger(MxFreeTrialPartnerCodeTest.class);
//
//    @Value("#{applicationPropertiesList['page.home.es.mx.url']}")
//    protected String testUrl ;
//    protected String nonBrandedSearchUrlMx;
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        testStartUrl = testUrl+"&ptn=GBMX";;
//        nonBrandedSearchUrlMx=testUrl+"&ptn=GGMX";
//        nonBrandedSearchUrl=nonBrandedSearchUrlMx;
//        setThreadSafeDriver();
//        formDataMap = EfConstants.mxFreeTrialFormMapWithPhoneType;
//    }
//
//    @Override
//    public void verifyPasswordPage(){
//        logger.info("if ?ctr=mx, then the branded search should redirect to Thank you Page instead of Password Page");
//        logger.info("verifythankyouPage");
//        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"thank-you","URL incorrect");
//        logger.info("Thank you page URL successfully verified");
//
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
