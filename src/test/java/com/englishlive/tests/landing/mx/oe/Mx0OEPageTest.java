//package com.englishlive.tests.landing.mx.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
// // not being used Karim advised
//public class Mx0OEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Mx0OEPageTest.class);
//
//    @Value("#{applicationPropertiesList['mx0.oe.url']}")
//    private String oePageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        formLeadTypeValue = "oe";
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        noOfWebFormElements = 9;
//        isMoveMouseTop = true;
//        isPopupShown=true;
//        formDataMap = EfConstants.mxOEFormMapWithPhone;
//    }
//
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(getWebDriver(), this.oePageUrl);
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//}
//
