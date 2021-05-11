package com.englishlive.tests.nogrid.proxy.landinghandler.emailsubscription;
/**
 * Created by nikol.marku
 *
 */

import com.englishlive.tests.nogrid.proxy.BaseEmailSubscription;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class FrEmailSubscriptionEeTest extends BaseEmailSubscription {
    private static final Logger logger = LoggerFactory.getLogger(FrEmailSubscriptionEeTest.class);
    @Value("#{applicationPropertiesList['fr.ee.url']}")
    protected String currTestUrl ;


    @BeforeClass
    public void setupOpenUrl(){
        setupProxyAndDriver(); //setupChromeWithProxyDriver(currTestUrl); //setUpProxy(); jbrowser
        //driver = ThreadSafeProxy.getWebDriver();
        //proxyServer.newHar("FrEmailSubscriptionEeTest-har");
        parameterName = "emaillist";
        formDataMap = EfConstants.baseOsEeFormMap;
        waitForUrlContains = "confirmation";
        harFilter = "landinghandler";
        testURL = currTestUrl;
        TestUtil.openUrl(driver, currTestUrl);
    }

    @AfterClass
    public void destroyDriverAndProxy(){
        //destroyDriverAndProxyServer();
        stopProxy();
        stopDriver();
    }

}