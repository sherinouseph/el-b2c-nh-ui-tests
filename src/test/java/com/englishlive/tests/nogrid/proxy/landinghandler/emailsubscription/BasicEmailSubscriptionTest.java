package com.englishlive.tests.nogrid.proxy.landinghandler.emailsubscription;
/**
 * Created by nikol.marku on 05/04/2016.
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



public class BasicEmailSubscriptionTest extends BaseEmailSubscription {
    private static final Logger logger = LoggerFactory.getLogger(BasicEmailSubscriptionTest.class);
    @Value("#{applicationPropertiesList['de.emai.subscribe']}")
    protected String currTestUrl ; //"http://qa-englishlive.ef.com/en-gb/lp/ee/nikol-test/";


    @BeforeClass
    public void setupOpenUrl(){
        testURL = currTestUrl;
        setupProxyAndDriver(); //setupChromeWithProxyDriver(testURL);   //setUpProxy(); setupJBorwserProxyDriver
        //driver = ThreadSafeProxy.getWebDriver();
        //proxyServer.newHar("BasicEmailSubscriptionTest-har");
        //expectedValueWhenSelected    = "4,5,17";
        //expectedValueWhenNotSelected = "";
        formDataMap = EfConstants.BASIC_OE_LEAD;
        parameterName = "emaillist";
        waitForUrlContains = "ty";
        harFilter = "landinghandler";

        TestUtil.openUrl(driver, currTestUrl);
    }

    @AfterClass
    public void destroyDriverAndProxy(){
        //destroyDriverAndProxyServer();
        stopProxy();
        stopDriver();
    }

}