//package com.englishlive.tests.landing.fr.earningscalculator.lead;
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
//public class FrLeadEarningCalculatorTest extends BaseLeadEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(FrLeadEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['fr.lead.ec.url']}")
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
//        formDataMap = EfConstants.GEN_EARNING_DETAILS;
//        formDataMapEarnings = EfConstants.GEN_EARNING_CALCULATE;
//        tryMeId="par_contentfragment-5_fragment_spacer_spacercontent_button";
//        isMemberPageUrl="checkout/member/index";
//        selectIndex    = 2;
//        experienceId   = 2;
//        englishLevelId = 5;
//        headerValue      = "13,274";
//        earnUpToValue    = "663,716";
//        lifeTimeValue    = "2,500,000";
//        withAdvanceValue = "3,163,716";
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
