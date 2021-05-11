//package com.englishlive.tests.landing.dotcom.earningscalculator.lead;
///**
// *
// */
//// TODO  check this test when martin fix the ids for emailenglish and submit buttton firststep
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.earningcal.BaseLeadEarningCalculator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class DotComLeadEarningCalculatorTest extends BaseLeadEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(DotComLeadEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['uk.lead.ec.url']}")
//    private String osPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setupTestValues();
//        this.getPage().loadPage();
//    }
//
//    @Override
//    public void setupTestValues(){
//        isDifSubmitFirstStep = true;
//        submitBtnFirstStepUk = "osformsubmit";
//        selectIndex    = 2;
//        experienceId   = 2;
//        englishLevelId = 6;
//        headerValue    = "5,859";
//        earnUpToValue  = "292,968";
//        lifeTimeValue  = "2,500,000";
//        withAdvanceValue = "2,792,968";
//        formDataMap = EfConstants.GEN_EARNING_DETAILS;
//        formDataMapEarnings = EfConstants.GEN_EARNING_CALCULATE;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//
//}
//
