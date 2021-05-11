//package com.englishlive.tests.referral;
///**
// * Created by nikol.marku on 19/02/2016.
// *
// */
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
///**EF London not responsible for oldhouse accordign to Axel.sand-7033 created and assigned to Alisha
// * This test a a bit unstable so removing it as it has not found any issues anyway
// * Click fail as pop up shown ... so need to add a click TwiterReferralTest.ClickTwiterTabAndcheckRemainingCharsNotNegative
// */
//
//public class TwiterReferralTest extends BaseTwiterReferral {
//    private static final Logger logger = LoggerFactory.getLogger(TwiterReferralTest.class);
//    @Value("#{applicationPropertiesList['en.us.login.url']}")
//    protected String currentLoginUrl;
//    @Value("#{applicationPropertiesList['en.us.referral.url']}")
//    protected String currentReferralUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testUsername       = currentTestUsername;
//        referralUrl = currentReferralUrl;
//        loginUrl           = currentLoginUrl;
//        openUrl(getWebDriver(), loginUrl);
//    }
//
//    @AfterClass
//    public void destroy(){
//        destroyDriver();
//    }
//
//
//}
//
