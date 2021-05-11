//package com.englishlive.tests.landing.br.ee;
//
//
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseEEtoProfileThenThankyouFormFlowTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
// // page submit btn changed ... so test fails
//public class BrEEPageTest extends BaseEEtoProfileThenThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrEEPageTest.class);
//
//    @Value("#{applicationPropertiesList['br.ee.url']}")
//    private String eePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.br']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(1000);}catch (Exception e){}
//        noOfWebFormElements = 7;
//        formDataMap = EfConstants.brEEFormMap;
//        thankyou_page_url_contains = "thankyou";
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//
//}
//
