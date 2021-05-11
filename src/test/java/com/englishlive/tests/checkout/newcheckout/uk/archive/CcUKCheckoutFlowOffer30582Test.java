//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * New checkout uk
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
//
//public class CcUKCheckoutFlowOffer30582Test extends CheckEnrolmentTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcUKCheckoutFlowOffer30582Test.class);
//    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")  //  gb.price.page
//    protected String currMemberPageUrl;   //30582 and 30999
//
//    private static final String TRY_FOR_ONE_POUND = ".package .btn.btn-primary";
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        this.formDataMap   = EfConstants.ukMembersFormMap_new;
//        isClickTabId=false;
//        creditCardLinkText="";
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl+"?offerid=30582", -1) ;
//        //click(getWebDriver(), By.cssSelector(TRY_FOR_ONE_POUND));
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}