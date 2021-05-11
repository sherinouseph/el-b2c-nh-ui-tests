//package com.englishlive.tests.landing.sa.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
///**
// *2017
// */
//public class ArSa1OEPageTest extends BaseOEPageTest{
//    private static final Logger logger = LoggerFactory.getLogger(ArSa1OEPageTest.class);
//// submit is not working
//    @Value("#{applicationPropertiesList['sa.oe.crm.sa1']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        TestUtil.printMethodName(logger, 2);
//        formLeadTypeValue = "oe";
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="crm-thankyou" ;
//        noOfWebFormElements = 9;
//        formDataMap = EfConstants.frOEFormMap;
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
//}
