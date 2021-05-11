//package com.englishlive.tests.checkout.newcheckout.ch;
///**
// * switzerland
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcCHdeCheckoutTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcCHdeCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.de.ch.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger);
//        isClickTabId=true;
//        creditCardLinkText="Kreditkarte";
//        tabId = 1;
//        this.memberPageUrl = currMemberPageUrl;
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
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}