//package com.englishlive.tests.newhouse.school.enroll;
///**
// * New checkout uk
// * No Cancel account links in newhouse
// * https://jira.eflabs.io/browse/SAND-5952-Waiting for Ben's response.
// */
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.school.useraccount.BaseNewUserCancelAccountTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcUKCheckoutEnrollCancelAccountTest extends BaseNewUserCancelAccountTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcUKCheckoutEnrollCancelAccountTest.class);
//    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        setLanguageAndMarket("en", "gb");
//        cancelSubscription = false;
//        phase1OfferPrice ="49";
//        isEnrolStudent = true;
//        //isNewHouseEnroll = true;
//        isNewhouseCheckout = true;
//        isNewhousePayment=true;
//        isNewHouseEnroll=true;
//        paymentSubmitBtnCss=".btn.btn-primary";
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