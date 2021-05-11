//package com.englishlive.tests.checkout.newcheckout.mx;
///**
// *
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcMXCheckoutTest extends CheckEnrolmentTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcMXCheckoutTest.class);
//    @Value("#{applicationPropertiesList['mx.member.mx.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        //currMemberPageUrl = UrlMapper.mapUrlToELive(currMemberPageUrl, getBASEURL());
//       // creditCardLinkText="Card Paymment";       // tabId = 0;
//        isClickTabId = false;
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
//}