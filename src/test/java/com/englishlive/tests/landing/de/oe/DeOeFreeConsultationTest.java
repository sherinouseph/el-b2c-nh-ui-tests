//package com.englishlive.tests.landing.de.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.helpers.UrlMapper;
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
//public class DeOeFreeConsultationTest extends BaseOEPageTest{
//    private static final Logger logger = LoggerFactory.getLogger(DeOeFreeConsultationTest.class);
//
//    @Value("#{applicationPropertiesList['de.free.consult']}")
//    private String testURL;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        formLeadTypeValue = "oe";
//        //testURL = UrlMapper.mapUrlToELive(testURL, getBASEURL());
//        TestUtil.printMethodName(logger, 2);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="thank" ;
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
//        return new OELandingPage(this.webDriver, this.testURL);
//    }
//
//}
