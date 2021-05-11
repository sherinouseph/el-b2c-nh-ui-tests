//package com.englishlive.tests.landing.br.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
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
////// 2018 dec flow changed so removed
//public class BrOeFreeConsultationTest extends BaseOEPageTest{
//    private static final Logger logger = LoggerFactory.getLogger(BrOeFreeConsultationTest.class);
//
//    @Value("#{applicationPropertiesList['br.free.consult']}")
//    private String testURL;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        formLeadTypeValue = "oe";
//        isPopupShown = true;
//        TestUtil.printMethodName(logger, 2);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="thank" ;
//        formDataMap = EfConstants.brFreeConsultation;
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
//        return new OELandingPage(getWebDriver(), this.testURL);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}
