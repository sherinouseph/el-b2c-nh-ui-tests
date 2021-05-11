//package com.englishlive.tests.landing.de.earningscalculator;
///**
// *
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.earningcal.BaseEarningCalculator;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class DeEarningCalculatorTest extends BaseEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(DeEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['de.ec.url']}")
//    private String osPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setupTestValues();
//        this.getPage().loadPage();
//    }
//    @Override
//    public void setupTestValues(){
//        selectIndex    = 2;
//        experienceId   = 2;
//        englishLevelId = 6;
//        headerValue    = "5,859";
//        earnUpToValue  = "292,968";
//        lifeTimeValue  = "2,500,000";
//        // advanced
//        advancedHeaderValue    = "15,034";
//        advancedLifeTimeValue = "2,500,000"; //"1,748,251";
//        withAdvanceValue         = "2,792,968";
//        withAdvanceValueAdvanced = "1,748,251";
//        formDataMap = EfConstants.GEN_EARNING_DETAILS;
//        formDataMapEarnings = EfConstants.GEN_EARNING_CALCULATE;
//        tryMeId="par_contentfragment-4_fragment_spacer_spacercontent_button";
//        isMemberPageUrl="buy/default/member";
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
