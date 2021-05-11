//package com.englishlive.tests.nogrid.proxy.landinghandler.emailsubscription;
///**
// * Created by nikol.marku o
// *
// */
//
//import com.englishlive.tests.nogrid.proxy.BaseEmailSubscription;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//   // not needed as FR and basic covers this
//public class DeEmailSubscriptionEeTest extends BaseEmailSubscription {
//    private static final Logger logger = LoggerFactory.getLogger(DeEmailSubscriptionEeTest.class);
//    @Value("#{applicationPropertiesList['de.ee.upsell.url']}")
//    protected String currTestUrl ;
//
//
//    @BeforeClass
//    public void setupOpenUrl(){
//        setupChromeWithProxyDriver(testURL);   //setUpProxy();
//        proxyServer.newHar();
//        parameterName = "emaillist";
//        formDataMap = EfConstants.baseOsEeFormMap;
//        waitForUrlContains = "kostenlose-email-";
//        harFilter = "landinghandler";
//        testURL = currTestUrl;
//        TestUtil.openUrl(driver, currTestUrl);
//    }
//
//}