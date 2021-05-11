//package com.englishlive.tests.checkout.newcheckout.memberpage.tracking;
///**
// *
// *
// */
//
//import com.englishtown.tests.checkout.common.core.BaseCheckTrackingServerOnMemberPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class THCheckTrackingServerOnMemberPage extends BaseCheckTrackingServerOnMemberPage {
//    private static final Logger logger = LoggerFactory.getLogger(THCheckTrackingServerOnMemberPage.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.th.th.url']}")
//    protected String currMemberPageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        this.openUrl(getWebDriver(), this.currMemberPageUrl, -1) ;
//    }
//
//
//}
//
