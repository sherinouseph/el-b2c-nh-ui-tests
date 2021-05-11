//package com.englishlive.tests.efenglishtown.flows.os;
///**
// * Test ptn and etag
// * NO more englishtown
// *
// */
//
//
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.flow.core.lp.BaseFlowLpToPaymentAndCCcheckoutPtnEtagTests;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// note 21 Apr 2017 some how this test is not running
//public class AADeLpOsToPaymentPtnEtagTest extends BaseFlowLpToPaymentAndCCcheckoutPtnEtagTests {
//    private static final Logger logger = LoggerFactory.getLogger(AADeLpOsToPaymentPtnEtagTest.class);
//
//    @Value("#{applicationPropertiesList['de.ef.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        testUrl = UrlMapper.mapBaseUrlToEtown(testUrl, getBASEURL());
//        lpFormData    = EfConstants.deEfOsFormMap;
//        phase1OfferPrice="49";
//        submitBtnCss  = "#osformsubmit"; //"button.btn.btn-primary-blue";  // os
//        this.openUrl(getWebDriver(), this.testUrl, WaitTool.MED_WAIT_4_ELEMENT ) ;
//        sleep(1000);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
