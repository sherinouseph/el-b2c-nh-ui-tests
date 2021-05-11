//package com.englishlive.tests.newsite.market.ru;
//
///**
// * Created by sherin 23/04/2018
// *
// *
// */
//
//import com.englishlive.tests.newsite.core.BaseConsultationTest;
//import com.englishtown.pages.common.core.PriceAndPackagekPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//   // RU not with us any more
//public class RuConsultationTest extends BaseConsultationTest {
//    public static final Logger logger = LoggerFactory.getLogger(RuConsultationTest.class);
//     @Value("#{applicationPropertiesList['ru.price.page']}")
//    protected String testUrl;//="https://qa.ef.ru/englishlive/free-consultation/";
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), testUrl);
//        formDataMap = EfConstants.ruFreeConsultationFormMap;
//        isInlineTyMsg = false;
//        urlContainsThankyou = "thank-you";
//        isClickConsultationBtn=false;
//        submitFormBtnCss = ".formset-button";
//        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
