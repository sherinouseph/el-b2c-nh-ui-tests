//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * New checkout uk
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutChangePcodeOnPayPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// not used anymore
//public class NewCcUKCheckoutChangePcodeOnPayPage extends NewCcBaseCheckoutChangePcodeOnPayPage {
//
//    private static final Logger logger = LoggerFactory.getLogger(NewCcUKCheckoutChangePcodeOnPayPage.class);
//    @Value("#{applicationPropertiesList['checkout.member.en.en.pcode.url']}")
//    protected String currMemberPageUrl;
//    @Value("#{applicationPropertiesList['checkout.payment.en.en.pcode.url']}")
//    protected String payPageUrlWitPcode;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//
//        setLanguageAndMarket("en", "gb");
//        paymentSubmitBtnCss=".btn.btn-primary";
//        isNewhouseCheckout = true;
//        checkStateObject = false;
//        phase0OfferPrice = null;
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        this.formDataMap   = EfConstants.ukMembersFormMap_new;
//        isClickTabId=false;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1);
//
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
//        return payPageUrlWitPcode;
//    }
//
//    @Override
//    protected String getThankYouPageUrl() {
//        return null;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
