//package com.englishlive.tests.landing.it.os;
///**
// * Negative testing
// * User: nikol.marku
// * Date: 27/08/14
// *
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOSPageNegativeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//
//public class ItOSPageNegativeTest extends BaseOSPageNegativeTest {
//    private static final Logger logger = LoggerFactory.getLogger(ItOSPageNegativeTest.class);
//    @Value("#{applicationPropertiesList['it1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.it']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    void setup(){
//        noOfWebFormElements = 8;
//         super.setup("test1Dotcom_os",this.getLocalizedTestPhoneNumber(),EfConstants.deOsFormMap_empty ,noOfWebFormElements,
//                 ".form .controls input",".tooltip-inner", "inserisci" ); //per favore inserisci almeno 6  //.popover-content
//         this.getPage().isUrlValidForThisPage();
//    }
//
//
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
