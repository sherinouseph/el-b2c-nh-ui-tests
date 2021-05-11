//package com.englishlive.tests.landing.uk.sb;
///**
// *
// *(Liam did cleanup and removed this page,
// hence we checked if we have any other sb page and decided not to have this test anymore
// since we have de test for sb)
// */
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.landingpages.BaseSbLeadTypeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class UKSbLeadTypeTest extends BaseSbLeadTypeTest {
//    private static final Logger logger = LoggerFactory.getLogger(UKSbLeadTypeTest.class);
//
//    @Value("#{applicationPropertiesList['uk.sb.url']}")
//    private String testURL;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        formDataMap = EfConstants.UK_SB_MAP;
//        urlContainsThankyou = "payment"; // "thankyou-sb";
//        //submitBtn = ".formFooter .btn";
//        openUrl(getWebDriver(), testURL);
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
