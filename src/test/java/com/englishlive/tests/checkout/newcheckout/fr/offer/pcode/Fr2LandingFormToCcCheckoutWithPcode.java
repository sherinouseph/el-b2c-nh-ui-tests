//package com.englishlive.tests.checkout.newcheckout.fr.offer.pcode;
///**
// * New checkout
// * Open Landing page and enter details, then submit
// * pay for the offer
// * Check offer details match pcode
// *
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.LandingPageToCheckoutFlowTests;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Map;
//
//
//public class Fr2LandingFormToCcCheckoutWithPcode extends LandingPageToCheckoutFlowTests {
//    private static final Logger logger = LoggerFactory.getLogger(Fr2LandingFormToCcCheckoutWithPcode.class);
//    @Value("#{applicationPropertiesList['checkout.os.fr.pcode2.url']}")
//    protected String currMemberPageUrl;
//
//    // this should be in testClass
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        this.formDataMap = EfConstants.form_os_default;
//        this.fullName =  formDataMap.get("firstname")+" "+formDataMap.get("lastname");
//        this.offer = EfConstants.FR_OFFER_30888;
//        this.isClickTabId = false;
//        creditCardLinkText="Carte";
//        logger.info("setup url: "+currMemberPageUrl + " TEST_BASE_URL : ");
//        this.openUrl(getWebDriver(), currMemberPageUrl, -1);
//    }
//
//
//
//
//    protected String getPageUrl() {
//        return currMemberPageUrl ;
//    }
//
//    @Override
//    protected String getPaymentPageUrl() {
//        return null;
//    }
//    @Override
//    protected String getMemberPageUrl() {
//        return null;
//    }
//    @Override
//    protected String getThankYouPageUrl() {
//        return null;
//    }
//
//    @Override
//    public Map getOffer() {
//        return offer ;
//    }
//
//}
//
