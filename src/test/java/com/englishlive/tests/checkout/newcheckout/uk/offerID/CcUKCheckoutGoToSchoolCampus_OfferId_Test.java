//package com.englishlive.tests.checkout.newcheckout.uk.offerID;
///**
// * New checkout uk
// * incoming -- fried request/msg received
// * outgoing -- fried request/msg sent
// */
//
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcUKCheckoutGoToSchoolCampus_OfferId_Test extends NewCcBaseCheckoutFlowTest { //CheckCampusPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcUKCheckoutGoToSchoolCampus_OfferId_Test.class);
//    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        // gb offers to buy
//        //currMemberPageUrl = "https://qa-englishlive.ef.com/en-gb/buy/default/member/?offerid=29183&ctr=gb";
//        //currMemberPageUrl = "https://qa-englishlive.ef.com/en-gb/buy/default/member/?offerid=30582&ctr=gb";
//        //currMemberPageUrl = "https://qa-englishlive.ef.com/en-gb/buy/default/member/?offerid=30999&ctr=gb";
//        //currMemberPageUrl = "https://qa-englishlive.ef.com/en-gb/buy/default/member/?offerid=9500&ctr=gb";
//        //
//        /*currMemberPageUrl = "https://englishlive.ef.com/en-gb/buy/test-default-2/member/?offerid=9500";
//        /"https://englishlive.ef.com/en-gb/buy/test-default-2/member/?offerid=30999"
//        "https://englishlive.ef.com/en-gb/buy/test-default-2/member/?offerid=30582"        29183 -    2044  */
//        password = "passpass";
//        //if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "qa")) {            isNewHouseEnroll = true;            isRunTestPhoneTextCheckPhoneTxtOnTy = false;        }
//        isStoreData = true;
//        isNewhouseCheckout = true;
//        paymentSubmitBtnCss = ".btn.btn-primary";
//        setLanguageAndMarket("en", "gb");
//
//        isNewhousePayment = true;
//        isNewHouseEnroll = true;
//        phase1OfferPrice ="49";
//        //isEnrolStudent = true;
//        this.memberPageUrl = currMemberPageUrl;
//        this.formDataMap   = EfConstants.ukMembersFormMap_new;
//        isClickTabId=false;
//        creditCardLinkText="";
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}