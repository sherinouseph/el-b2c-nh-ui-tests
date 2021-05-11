//package com.englishlive.tests.landing.uk.calculator;//package com.englishlive.tests.landing.it.earningscalculator;
///**
// *
// */
//
//// not important so remove it 
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.earningcal.BaseLeadEarningCalculator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class UKEarningCalculatorTest extends BaseLeadEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(UKEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['uk.et.ec.url']}")
//    private String osPageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        setupTestValues();
//        this.getPage().loadPage();
//    }
//    @Override
//    public void setupTestValues(){
//        selectIndex    = 2;
//        experienceId   = 2;
//        englishLevelId = 6;
//        headerValue    = "105,646"; //"5,859";   29,292,900
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
//        //submitEarningsId = "contentPar_spacer_spacercontent_slider_slide-2-s_columnscontrol_column1_columnscontrol_column0_spacer_spacercontent_button";
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(getWebDriver(), this.osPageUrl);
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//
//}
//
