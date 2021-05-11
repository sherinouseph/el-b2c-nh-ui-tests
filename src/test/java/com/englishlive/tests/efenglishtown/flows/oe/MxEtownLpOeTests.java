//package com.englishlive.tests.efenglishtown.flows.OE;
///**
// * Test
// *
// */
//
////  server DNS address could not be found. on QA
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.flow.core.lp.BaseFlowLpToTestSetCheckPtnEtagTests;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class MxEtownLpOeTests extends BaseFlowLpToTestSetCheckPtnEtagTests {
//    private static final Logger logger = LoggerFactory.getLogger(MxEtownLpOeTests.class);
//
//    @Value("#{applicationPropertiesList['mx.lp.oe.et']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        lpFormData = EfConstants.mxOEFormMap;
//        submitBtnCss = ".submit-form-se.btn.btn-primary-blue";
//        urlContains = "ty/thank";
//        testUrl = UrlMapper.mapEliveBaseUrlToEtown(testUrl);
//        this.openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT ) ;
//        sleep(2000);
//    }
//
//
//}
