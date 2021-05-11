//package com.englishlive.tests.checkout.newcheckout.restasia;
///**
// * Malasia
// * covered by CcNGCheckoutTest as well could use the same
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// overkill gb test this
//public class CcMYCheckoutTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcMYCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.en.my.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        phase1OfferPrice ="49";
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        isClickTabId=false;
//        creditCardLinkText="Kreditkarte";
//        formDataMap = EfConstants.ukMembersFormMap_new;
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
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}