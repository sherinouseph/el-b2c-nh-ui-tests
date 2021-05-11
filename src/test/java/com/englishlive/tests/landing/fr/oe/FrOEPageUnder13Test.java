//package com.englishtown.tests.landing.fr.oe;
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.landing.base.BaseOEPageToBrochurePageTest;
//import com.englishtown.tests.landing.base.BaseOEPageUnder13Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// Option to select is not available any longer
///**
// * user stay at same page and validation mesage is shown
// *
// */
//public class FrOEPageUnder13Test extends BaseOEPageUnder13Test {
//    private static final Logger logger = LoggerFactory.getLogger(FrOEPageUnder13Test.class);
//
//    @Value("#{applicationPropertiesList['fr.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        TestUtil.printMethodName(logger, 2);
//        this.getPage().isUrlValidForThisPage();
//        PRESS_NO = 1;
//        thankyou_page_url_contains = oePageUrl; // stay at same page msg shown //"ef.com.fr/oct/englishtown" ;
//        formDataMap = EfConstants.frOEFormMapUnder13;
//    }
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//}
