//package com.englishlive.tests.landing.tw.oe;
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
// * Date: 03/11/14
// * Time: 11:03
// *
// */
//// new ui ... remove this test
//public class TwOeFreeConsultationTest extends BaseTWOEPageTest{
//    private static final Logger logger = LoggerFactory.getLogger(TwOeFreeConsultationTest.class);
//
//    @Value("#{applicationPropertiesList['tw.consultationn.url']}")
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
//        thankyou_page_url_contains ="oe-thankyou" ;
//        formDataMap = EfConstants.twOEFormMap;
//    }
//
//    @Override
//    protected void verifyStateObjectLeadId(){
//        logger.info("THIS TEST IS NOT RUN ...! NO LEAD CREATED FOR FREE COSULTATION ");
//    }
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
