//package com.englishlive.tests.landing.fr.oe;
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageToBrochurePageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
///**
// * Date: 03/11/14
// * Time: 11:03
// *
// */
//// age is not shown on the form anymore
//public class FrOEPage13to17Test extends BaseOEPageToBrochurePageTest {
//    private static final Logger logger = LoggerFactory.getLogger(FrOEPage13to17Test.class);
//
//    @Value("#{applicationPropertiesList['fr.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger, 2);
//        this.getPage().isUrlValidForThisPage();
//        PRESS_NO = 2;
//        thankyou_page_url_contains ="ef.fr/oct/englishtown" ;
//        formDataMap = EfConstants.frOEFormMap13to17;
//    }
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(getWebDriver(), this.oePageUrl);
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//}
