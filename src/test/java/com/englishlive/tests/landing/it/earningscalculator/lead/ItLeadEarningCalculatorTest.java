//package com.englishlive.tests.landing.it.earningscalculator.lead;
///**
// *
// */
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.earningcal.BaseLeadEarningCalculator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class ItLeadEarningCalculatorTest extends BaseLeadEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(ItLeadEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['it.lead.ec.url']}")
//    private String osPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setupTestValues();
//        this.getPage().loadPage();
//        try{Thread.sleep(2000);}catch (Exception e) {}
//    }
//
//    @Override
//    public void setupTestValues(){
//        formDataMap = EfConstants.GEN_EARNING_DETAILS;
//        formDataMapEarnings = EfConstants.GEN_EARNING_CALCULATE;
//        tryMeId="par_contentfragment-4_fragment_spacer_spacercontent_button";
//        isMemberPageUrl="checkout/member/index";
//        selectIndex    = 3;
//        experienceId   = 3;
//        englishLevelId = 6;
//        headerValue      = "6,153";
//        earnUpToValue    = "307,692";
//        lifeTimeValue    = "2,500,000";
//        withAdvanceValue = "2,807,692";
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
