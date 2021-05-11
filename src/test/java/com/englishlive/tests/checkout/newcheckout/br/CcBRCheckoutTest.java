//package com.englishlive.tests.checkout.newcheckout.br;
///**
// * //this test is for Br-New checkout - creditcard visa
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// TODO open this once BR team is ready for release
//public class CcBRCheckoutTest extends CheckEnrolmentTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcBRCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.es.br.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger);
//        phase1OfferPrice="111";
//        isEnrolStudent=true;
//        isClickTabId = false;
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.BR_MEMBER_MAP;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//
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
//
