//package com.englishtown.tests.landing.mx.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class Mx4OEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Mx4OEPageTest.class);
//
//    @Value("#{applicationPropertiesList['mx4.oe.url']}")
//    private String oePageUrl;
////    @Value("#{applicationPropertiesList['test.telephone.br']}")
////    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        noOfWebFormElements = 10;
//        formDataMap = EfConstants.mxOEFormMapWithPhoneType;
//        thankyou_page_url_contains = "pt-tyou-generic";
//    }
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//
//
//}
