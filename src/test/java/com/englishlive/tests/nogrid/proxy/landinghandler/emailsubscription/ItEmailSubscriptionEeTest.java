//package com.englishlive.tests.nogrid.proxy.landinghandler.emailsubscription;
///**
// * Created by nikol.marku on 12/14/2016.
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
//   //not important test other test cover this
//public class ItEmailSubscriptionEeTest extends BaseEmailSubscription {
//    private static final Logger logger = LoggerFactory.getLogger(ItEmailSubscriptionEeTest.class);
//    @Value("#{applicationPropertiesList['it.ee.url']}")
//    protected String currTestUrl ;
//
//
//    @BeforeClass
//    public void setupOpenUrl(){
//        setupJBorwserProxyDriver(currTestUrl);
//        parameterName = "emaillist";
//        formDataMap = EfConstants.baseOsEeFormMap;
//        waitForUrlContains = "conferma";
//        harFilter = "landinghandler";
//        testURL = currTestUrl;
//        TestUtil.openUrl(driver, currTestUrl);
//    }
//
//}