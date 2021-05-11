//package com.englishlive.tests.galen.test;
///**
// *
// */
//import com.englishlive.tests.galen.core.BaseGalenAllPagesAllMarkets;
//import com.englishlive.tests.galen.core.BaseHomePageTest;
//import com.englishtown.helpers.utils.TestUtil;
//import com.galenframework.api.Galen;
//import com.galenframework.reports.GalenTestInfo;
//import com.galenframework.reports.HtmlReportBuilder;
//import com.galenframework.reports.model.LayoutReport;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
// //USE this to quick test only one URL site
//public class SaHomePageGalenTest extends BaseHomePageTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseGalenAllPagesAllMarkets.class);
//    // each test seth this up
//    private static final String GSPEC    = "homepage_SA.gspec";
//    private static final String TEST_URL = "http://qa-englishlive.ef.com/ar-sa/";
//
//
//    @Override
//    protected void setupSpecFileAndTestUrl() {
//        logger.info("setupSpecFileAndTestUrl - TEST_GSPEC_FILENAME ["+GSPEC+"] ; TEST URL ["+TEST_URL+"]");
//        testGspecFilename = GSPEC;
//        testUrl           = TEST_URL;
//    }
//
//    @AfterClass
//    protected void storeReport(){
//        // Exporting all test reports to html
//        try {
//            logger.info("Store report");
//            new HtmlReportBuilder().build(tests, GALEN_REPORTS_DIR+ this.getClass().getSimpleName());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
