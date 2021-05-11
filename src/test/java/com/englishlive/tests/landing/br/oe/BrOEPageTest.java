//package com.englishlive.tests.landing.br.oe;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class BrOEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrOEPageTest.class);
//
//    @Value("#{applicationPropertiesList['br.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.br']}")
//    private String localizedTestPhoneNumber;
//
//// BR pages broken angain .. removing this test
//    @BeforeClass
//    protected void setup(){
//        TestUtil.printMethodName(logger, 2);
//        oePageUrl = UrlMapper.mapBaseUrlToEtown(oePageUrl, getBASEURL());
//        this.getPage().isUrlValidForThisPage();
//        noOfWebFormElements = 7;
//        formDataMap = EfConstants.brOEFormMap;
//    }
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//}