//package com.englishlive.tests.checkout.newcheckout.meast;
///**
// * Nageria
// * Run only one for rest of Asia, meast and world
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.responsivecore.CheckEnrolmentTest;
//import com.englishtown.tests.responsivecore.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcNGfrCheckoutTest extends CheckEnrolmentTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcNGfrCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.fr.ng.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        isClickTabId=false;
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//    @Override
//    protected String getTestPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//
//}