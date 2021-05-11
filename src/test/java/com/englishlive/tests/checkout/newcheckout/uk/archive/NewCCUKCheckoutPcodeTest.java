//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * New checkout uk
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowWithPcodeTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Map;
//
//
//public class NewCCUKCheckoutPcodeTest extends NewCcBaseCheckoutFlowWithPcodeTest {
//    private static final Logger logger = LoggerFactory.getLogger(NewCCUKCheckoutPcodeTest.class);
//    @Value("#{applicationPropertiesList['checkout.member.en.en.pcode.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        this.formDataMap   = EfConstants.ukMembersFormMap_new;
//        isClickTabId=false;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1);
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
//    @Override
//    public Map getOffer() {
//        return offer = EfConstants.OFFER_30582;
//    }
//}
//
