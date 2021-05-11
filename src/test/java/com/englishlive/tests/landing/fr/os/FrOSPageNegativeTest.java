//package com.englishtown.tests.landing.fr.os;
///**
// * Negative testing
// * User: nikol.marku
// * Date: 27/08/14
// *
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.landing.base.BaseOSPageNegativeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
////url changed it oppens PP page
//public class FrOSPageNegativeTest extends BaseOSPageNegativeTest {
//    private static final Logger logger = LoggerFactory.getLogger(FrOSPageNegativeTest.class);
//    @Value("#{applicationPropertiesList['fr1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.fr']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    void setup(){
//         noOfWebFormElements = 8;
//         super.setup("test1Dotcom_os",this.getLocalizedTestPhoneNumber(),EfConstants.deOsFormMap_empty ,noOfWebFormElements,
//                     ".form .controls input",".popover-content", "entrez" );
//         this.getPage().isUrlValidForThisPage();
//    }
//
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
