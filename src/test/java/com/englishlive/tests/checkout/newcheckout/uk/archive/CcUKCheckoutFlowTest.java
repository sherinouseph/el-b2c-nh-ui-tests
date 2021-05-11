//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * New checkout uk
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcUKCheckoutFlowTest extends CheckEnrolmentTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcUKCheckoutFlowTest.class);
//    @Value("#{applicationPropertiesList['gb.price.page']}")  //  gb.price.page checkout.member.en.en.url
//    protected String currMemberPageUrl;
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
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
//        click(getWebDriver(), By.cssSelector(TRY_FOR_ONE_POUND));
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