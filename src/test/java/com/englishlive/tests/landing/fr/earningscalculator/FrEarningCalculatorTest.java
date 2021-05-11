//package com.englishlive.tests.landing.fr.earningscalculator;
///**
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.earningcal.BaseEarningCalculator;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class FrEarningCalculatorTest extends BaseEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(FrEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['fr.ec.url']}")
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
//        osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//
//}
//
