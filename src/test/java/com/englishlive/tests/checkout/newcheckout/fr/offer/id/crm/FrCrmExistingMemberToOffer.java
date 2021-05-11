//package com.englishlive.tests.checkout.newcheckout.fr.offer.id.crm;
///**
// * Test for existing member that has not payed - ever ;
// * Create a member on the /lp/os/crm-acq-3months-1monthfree/   3 month offer 31340
// * Don't pay
// * open login url should see same offer - 3 month one
// * one offer is shown
// * check offer
// * buy Offer
// * check thankyou page
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.common.BasePaymentThankyou;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Map;
//
////BaseEnterFormDataAndSubmit
////  BaseOnlyOneOfferPage
////    BaseCCpaymentPage
////      BasePaymentThankyou
//
//public class FrCrmExistingMemberToOffer extends BasePaymentThankyou{
//    private static final Logger logger = LoggerFactory.getLogger(FrCrmExistingMemberToOffer.class);
//    @Value("#{applicationPropertiesList['lp.os.fr.crm.3month.url']}")
//    protected String currMemberPageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        this.offer = EfConstants.OFFER_ID_31340;
//        tabId = 0;
//        formDataMap =EfConstants.form_os_default;
//        logger.info("setup url: "+memberPageUrl+" ENV is : "+getENVIRONMENT());
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
//    }
//
//
//    protected String getTestPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @Override
//    public Map getOffer() {
//        return offer ;
//    }
//}
//
