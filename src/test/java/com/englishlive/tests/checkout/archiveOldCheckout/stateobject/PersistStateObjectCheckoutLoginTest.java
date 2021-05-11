//package com.englishlive.tests.checkout.archiveOldCheckout.stateobject;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.checkout.common.core.ExtensiveStateObjectTestCheckoutFlowTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeTest;
//
///**
//* Test state object
//*
//* Test defined in ExtensiveStateObjectTestCheckoutFlowTest
//*
//*/
//public class PersistStateObjectCheckoutLoginTest extends ExtensiveStateObjectTestCheckoutFlowTest {
//    @Value("#{applicationPropertiesList['checkout.member.br.br.url']}")
//    private String memberPageUrl;
//    @Value("#{applicationPropertiesList['checkout.payment.br.br.url']}")
//    private String paymentPageUrl;
//    @Value("#{applicationPropertiesList['checkout.thankyou.br.br.url']}")
//    private String thankYouPageUrl;
//
//    protected static String USERNAME; // GET THE VALUE from the test ???
//    private static final String MY_CURRENCY = "BRL";
//    private static final Logger logger = LoggerFactory.getLogger(PersistStateObjectCheckoutLoginTest.class);
//
//    @BeforeTest
//    void setup(){
//        logger.info("setup 0............. !");
//        this.currency=MY_CURRENCY;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        return this.memberPageUrl = UrlMapper.mapBaseUrlToEtown(memberPageUrl, getBASEURL());
//    }
//    @Override
//    protected String getPaymentPageUrl() {
//        return this.paymentPageUrl;
//    }
//    @Override
//    protected String getThankYouPageUrl() {
//        return this.thankYouPageUrl;
//    }
//
//}
