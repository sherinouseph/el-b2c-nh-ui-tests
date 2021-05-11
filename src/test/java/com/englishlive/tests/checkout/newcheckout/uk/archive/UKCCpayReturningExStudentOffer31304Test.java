//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * Returning student by offer 31304 on returning flow
// *
// *  Buy default offer
// *  become Alumni
// *  login with offer 31304
// *  then buy buy it again
// *  check edit cc details
// *  and validation msg
// */
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.BaseTestConfig;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//   // there are no login with offer opption ...  so removed

//public class UKCCpayReturningExStudentOffer31304Test extends BaseCCpayReturningStudent {
//
//    private static final Logger logger = LoggerFactory.getLogger(UKCCpayReturningExStudentOffer31304Test.class);
//
//    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
//    protected String currMemberPageUrl;
//
//    private final String OFFER_ID = ""; // use default and buy this on return "31304";
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        offer_id = "31304";
//        phase1OfferPrice ="49";
//        setLanguageAndMarket("en","gb");
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        logger.info("setup url: "+memberPageUrl);
//        this.memberPageUrl = currMemberPageUrl;
//        isNewDesignLogin = true;
//        password = BaseTestConfig.getPassword8();
//        isClickTabId       = false;
//        confirPayBtnId     = "form_button";
//        validationMsgContainsTxt = "Please agree to the Terms";
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1);  //+"?offerid="+OFFER_ID
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        return memberPageUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}