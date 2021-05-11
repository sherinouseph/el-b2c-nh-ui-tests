//package com.englishlive.tests.checkout.newcheckout.ja;
///**
// *
// *
// */
//import com.englishtown.tests.checkout.common.core.PayPalBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
///**
// * This user run ONLY not LIVE ENVs
// */
//// Aki removed pay pal ... on jp
//public class PayPalJPCheckoutTest extends PayPalBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(PayPalJPCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.ja.jp.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        //isStoreData=false;
//        testCountry = "jp";
//        continuePayPalId = "continue";
//        submitToPpId = "submitLogin";
//        payPalDataMap = EfConstants.payPalJP;
//        creditCardLinkText="Paypal";
//        this.formDataMap = EfConstants.ukMembersFormMap_new;
//        this.memberPageUrl = currMemberPageUrl;
//        tabId = 1;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @Override
//    protected String getPaymentPageUrl() {
//        return null;
//    }
//
//    @Override
//    protected String getThankYouPageUrl() {
//        return null;
//    }
//
//}
//
