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
//public class TRCheckTrackingServerOnMemberPage extends BaseCheckTrackingServerOnMemberPage {
//    private static final Logger logger = LoggerFactory.getLogger(TRCheckTrackingServerOnMemberPage.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.tr.tr.url']}")
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