//package com.englishlive.tests.checkout.archiveOldCheckout.br;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.checkout.common.StandardCheckoutFlowWithTests;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//// flow changed 2018 dec so remove , br team do this
//// element order.phase1.currency is :null
////@Category(CheckoutTests.class)
//public class BrCheckoutFlowTest extends StandardCheckoutFlowWithTests {
//    @Value("#{applicationPropertiesList['br.pp.url']}")
//    private String memberPageUrl;
//    @Value("#{applicationPropertiesList['checkout.payment.br.br.url']}")
//    private String paymentPageUrl;
//    @Value("#{applicationPropertiesList['checkout.thankyou.br.br.url']}")
//    private String thankYouPageUrl;
//
//
//
//    @BeforeClass
//    void setupDriver(){
//        setThreadSafeDriver();
//        phase1OfferPrice="111";
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//       // memberPageUrl = UrlMapper.mapBaseUrlToEtown(memberPageUrl, getBASEURL());
//        StandardCheckoutFlowWithTests.isCardVerification =true;
//        return this.memberPageUrl;
//    }
//
//    @Override
//    protected String getPaymentPageUrl() {
//        paymentPageUrl = UrlMapper.mapBaseUrlToEtown(paymentPageUrl, getBASEURL());
//        return this.paymentPageUrl;
//    }
//
//    @Override
//    protected String getThankYouPageUrl() {
//        thankYouPageUrl = UrlMapper.mapBaseUrlToEtown(thankYouPageUrl, getBASEURL());
//        return this.thankYouPageUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
