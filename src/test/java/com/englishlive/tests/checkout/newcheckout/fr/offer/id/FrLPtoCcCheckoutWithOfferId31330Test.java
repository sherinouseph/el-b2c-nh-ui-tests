//package com.englishlive.tests.checkout.newcheckout.fr.offer.id;
///**
// * New checkout
// * Open Landing page and enter details, then submit [Note submit button is changed to go to new checkout]
// * pay for the offer
// * Check offer details match pcode
// *
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.LPtoCheckoutWithOfferId;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Map;
//// flow Changed
//public class FrLPtoCcCheckoutWithOfferId31330Test extends LPtoCheckoutWithOfferId {
//    private static final Logger logger = LoggerFactory.getLogger(FrLPtoCcCheckoutWithOfferId31330Test.class);
//    @Value("#{applicationPropertiesList['lp.os.fr.offerid31330.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        this.formDataMap = EfConstants.form_os_default;
//        this.fullName =  formDataMap.get("firstname")+" "+formDataMap.get("lastname");
//        this.offer = EfConstants.OFFER_ID_31330;
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
