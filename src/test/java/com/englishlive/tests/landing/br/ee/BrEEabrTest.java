//package com.englishlive.tests.landing.br.ee;
//
//import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.landingpages.BaseLPtoPayment;
//import com.englishtown.tests.core.landingpages.BaseLPtoTy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
// // page changed so removed test
//public class BrEEabrTest extends BaseLPtoTy { //BaseEEtoThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrEEabrTest.class);
//
//    @Value("#{applicationPropertiesList['br.ee.abr.url']}")
//    private String eePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.br']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        this.setLanguageAndMarket("pt","br");
//        setThreadSafeDriver();
//        formLeadTypeValue = "ee";
//        submitBtn = "form button.btn";
//        formDataMap = EfConstants.brEEFormMap;
//        urlContainsThankyou = "thankyou";
//        openUrl(getWebDriver(), eePageUrl);
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
//
//
