//package com.englishlive.tests.efenglishtown.flows.OE;
///**
// * Test ptn and etag
// *
// */
//
//// this is only for OS not oe
//// 209.235.2.144     qa.efenglishtown.com
//// 209.235.2.98       staging.efenglishtown.com

////  server DNS address could not be found. on QA
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.flow.core.lp.BaseFlowLpToTestSetCheckPtnEtagTests;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class FrLpOeToTestSetPtnEtagTests extends BaseFlowLpToTestSetCheckPtnEtagTests {
//    private static final Logger logger = LoggerFactory.getLogger(FrLpOeToTestSetPtnEtagTests.class);
//
//    @Value("#{applicationPropertiesList['fr.ef.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        lpFormData = EfConstants.frOEToTestFormMap;
//        submitBtnCss = ".submit-form-se.btn.btn-primary-blue";
//        urlContains = "ty/thank";
//        //TODO urlcontains should be lp/ty/thankyou_2014/  after they set it up
//        this.openUrl(getWebDriver(), this.testUrl, WaitTool.MED_WAIT_4_ELEMENT ) ;
//        sleep(2000);
//    }
//
//
//}
