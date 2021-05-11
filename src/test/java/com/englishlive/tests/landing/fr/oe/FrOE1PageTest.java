//package com.englishlive.tests.landing.fr.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.forms.OEForm;
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
//public class FrOE1PageTest extends BaseOEPageTest{
//    private static final Logger logger = LoggerFactory.getLogger(FrOE1PageTest.class);
//
//    @Value("#{applicationPropertiesList['fr1.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.frh']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        TestUtil.printMethodName(logger, 2);
//        //oePageUrl = UrlMapper.mapUrlToELive(oePageUrl, getBASEURL());
//        OEForm.OEFormWaitForWe = ".btn-primary-blue";
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="privateteacher-ty" ;
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
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//}
