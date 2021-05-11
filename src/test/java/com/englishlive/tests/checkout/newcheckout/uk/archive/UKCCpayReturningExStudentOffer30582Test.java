//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * New checkout uk
// * // flow has changed so need new flow set up for this test~: Think it might change again next day? is it worth it?
// *
// */
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class UKCCpayReturningExStudentOffer30582Test extends BaseCCpayReturningStudent {
//
//    private static final Logger logger = LoggerFactory.getLogger(UKCCpayReturningExStudentOffer30582Test.class);
//
//    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
//    protected String currMemberPageUrl;
//
//    private final String OFFER_ID = "30582";
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        logger.info("setup url: "+memberPageUrl);
//        this.memberPageUrl = currMemberPageUrl;
//        isNewDesignLogin = true;
//        password = "pass";
//        isClickTabId       = false;
//        confirPayBtnId     = "form_button";
//        validationMsgContainsTxt = "Please agree to the Terms";
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        this.openUrl(getWebDriver(), this.memberPageUrl+"?offerid="+OFFER_ID, -1);
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