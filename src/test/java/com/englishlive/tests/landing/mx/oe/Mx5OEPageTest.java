//package com.englishtown.tests.landing.mx.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
////http://jira-bos.englishtown.com/browse/SAND-1999
////no form
//public class Mx5OEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Mx5OEPageTest.class);
//
//    @Value("#{applicationPropertiesList['mx5.oe.url']}")
//    private String oePageUrl;
////    @Value("#{applicationPropertiesList['test.telephone.br']}")
////    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        noOfWebFormElements = 8;
//        formDataMap = EfConstants.mxOEFormMapWithPhoneType;
//    }
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//
//
//}
