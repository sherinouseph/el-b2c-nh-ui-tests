//package com.englishlive.tests.referral;
///**
// * Login an existing user [de] and go to referral page and sent a referral
// * User: nikol.marku
// * Date: 09/09/14
// *
// * [10:59:35] reina.toeda.ef: offer id = 30594
//  pcode = USOS9MTRIAL  thats a 9 month offer, for new students only
//  or you can also use CRM6M139US, thats the same as the DE offer and is available to both new students and alumni :)
// *
// */
//
//import com.englishtown.helpers.bean.ReferralUser;
//import com.englishtown.tests.core.referral.BaseReferallTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class BrSenReferallTest extends BaseReferallTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrSenReferallTest.class);
//    @Value("#{applicationPropertiesList['en.us.login.url']}") //http://www.englishtown.com.br/login/  auto_1475244774533_xdelx@qp1.org
//    protected String currentLoginUrl;
//    @Value("#{applicationPropertiesList['en.us.referral.url']}")
//    protected String currentReferralUrl;
//    @Value("#{applicationPropertiesList['us.member.withOffer.url']}")// over 5 months
//    protected String currentMemberUrlwithOffer;
//    @Value("#{applicationPropertiesList['en.us.dashboard.url']}")
//    protected String currentDashboardUrl;
//
//    protected String currentTestUsername = "enus@qp1.org";
//    protected static final String nextPayDateCss = ".panel-body .clearfix:nth-child(2) p";  //49(EUR) angesetzt für den 2016-05-02
//
//
//    @BeforeClass
//    protected void setup(){
//        this.username = testUsername;
//        isClickAtWindow=true;
//        setupTestData();
//        //loginUrl = UrlMapper.mapUrlToELive(loginUrl, getBASEURL());
//        openUrl(getWebDriver(), loginUrl);
//        inviter = new ReferralUser(testUsername, PASS, "");
//        inviterAfterInviteePaid = new ReferralUser(testUsername, PASS, "");
//        inviter.print();
//    }
//
//
//    public void setupTestData(){
//         testUsername       = currentTestUsername;
//         dashboardUrl       = currentDashboardUrl;
//         referralUrl        = currentReferralUrl;
//         loginUrl           = currentLoginUrl;
//         memberUrlwithOffer = currentMemberUrlwithOffer;
//        isClickTabId        = false;
//        creditCardLinkText  = "card";
//    }
//
//
//}
