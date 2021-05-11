//package com.englishlive.tests.checkout.archiveOldCheckout.br;
//
//import com.englishtown.helpers.CookieHandler;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.checkout.common.StandardCheckoutFlowWithTests;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//
//public class CreateManyBrUsersCheckoutFlowTest extends StandardCheckoutFlowWithTests {
//    private static final Logger logger = LoggerFactory.getLogger(CreateManyBrUsersCheckoutFlowTest.class);
//
//    @Value("#{applicationPropertiesList['checkout.member.br.br.url']}")
//    private String memberPageUrl;
//    @Value("#{applicationPropertiesList['checkout.payment.br.br.url']}")
//    private String paymentPageUrl;
//    @Value("#{applicationPropertiesList['checkout.thankyou.br.br.url']}")
//    private String thankYouPageUrl;
//
//    private int numberOfTimes;
//
//
//    @Test
//    public void createUsers(){
//            testFlow();
//            assertThankyouPageStateObjectElements();
//            CookieHandler.deleteCookies(getWebDriver());
//    }
//
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = UrlMapper.mapBaseUrlToEtown(memberPageUrl, getBASEURL());
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
//
//}
