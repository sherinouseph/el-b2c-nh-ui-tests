//package com.englishlive.tests.checkout.newcheckout.ru;
///**
// *
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//
//
//public class CcRUCheckoutTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcRUCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.ru.ru.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
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
//
//}
//
