//package com.englishlive.tests.landing.mx.earningscalculator;
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
//public class MxEarningCalculatorTest extends BaseEarningCalculator {
//    private static final Logger logger = LoggerFactory.getLogger(MxEarningCalculatorTest.class);
//    @Value("#{applicationPropertiesList['mx.ec.url']}")
//    private String osPageUrl;
//    // TODO update url to englishlive months after release of elive
//
//    @BeforeClass
//    public void setup(){
//        setupTestValues();
//        osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        this.getPage().loadPage();
//        try{Thread.sleep(2000);}catch (Exception e) {}
//    }
//
//    @Override
//    public void setupTestValues(){
////        osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
////        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + osPageUrl);
//        isAdvanced     = true;
//        this.formDataMap = EfConstants.MX_EARNING_DETAILS;
//        formDataMapEarnings = EfConstants.GEN_EARNING_CALCULATE;
//        advancedHeaderValueId = 2;
//       // tryMeId="par_contentfragment_fragment_spacer_spacercontent_button";
//        //isMemberPageUrl="checkout/member/index";
//        selectIndex    = 3;
//        experienceId   = 2;
//        englishLevelId = 7;
//        // advanced
//        advancedHeaderValue    = "15,517";
//        advancedLifeTimeValue = "2,500,000"; //"1,748,251";
//        withAdvanceValue         = "2,792,968";
//        withAdvanceValueAdvanced = "1,724,137";
//
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
