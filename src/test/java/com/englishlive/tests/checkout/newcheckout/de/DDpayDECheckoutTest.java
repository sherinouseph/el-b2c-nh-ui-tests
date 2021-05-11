//package com.englishlive.tests.checkout.newcheckout.de;
///**
//*
//*
//*/
//import com.englishtown.tests.checkout.common.core.NewDDBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//import static org.testng.AssertJUnit.fail;
//
///**
//* This run NOT live env
//*/
//public class DDpayDECheckoutTest extends NewDDBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(DDpayDECheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
//    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal
//
//    @BeforeClass
//    public void setup(){
//        ddTabId = 0;
//        isClickTabId=false;
//        this.formDataMap = EfConstants.deMembersFormMap;
//        this.memberPageUrl = currMemberPageUrl;
//        logger.info("setup url: "+memberPageUrl);
//        // fail for live ENV
////        failTestPerEnvironment("live", "");
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
//
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
//}
//
