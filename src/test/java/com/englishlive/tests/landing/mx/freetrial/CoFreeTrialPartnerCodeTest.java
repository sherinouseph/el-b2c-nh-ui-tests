//package com.englishlive.tests.landing.mx.freetrial;
////
/////**
//// * Created by sherin 08/11/2017-SAND-4809
//// * Branded search for ?ctr=CO- This has a partner code and the user should go to lead form->Password form->Enrollment
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
////// Jan 2018 Karim removed free trial
//public class CoFreeTrialPartnerCodeTest extends BaseFreeTrialPartnerCodeTest {
//    public static final Logger logger = LoggerFactory.getLogger(CoFreeTrialPartnerCodeTest.class);
//
//    @Value("#{applicationPropertiesList['page.home.es.mx.url']}")
//    protected String testUrl ;
//    protected String nonBrandedSearchUrlCo;
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        testStartUrl = testUrl.replace("=mx","=co")+"&ptn=GBCO";;
//        setThreadSafeDriver();
//        nonBrandedSearchUrlCo=testUrl.replace("=mx","=co")+"&ptn=GGCO";;
//        nonBrandedSearchUrl=nonBrandedSearchUrlCo;
//        formDataMap = EfConstants.mxFreeTrialFormMapWithPhoneType;
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
