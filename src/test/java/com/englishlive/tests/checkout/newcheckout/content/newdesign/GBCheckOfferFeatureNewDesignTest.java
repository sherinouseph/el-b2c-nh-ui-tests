package com.englishlive.tests.checkout.newcheckout.content.newdesign;
/**
 * Nikol Nov 2018
 *
 * TODO fix TR check out as it has different selectors
 * //29183 has been replaced with 34223
 */

import com.englishtown.helpers.bean.OfferFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class GBCheckOfferFeatureNewDesignTest extends BaseNewDesignCheckOfferFeature {
    private static final Logger logger = LoggerFactory.getLogger(GBCheckOfferFeatureNewDesignTest.class);

    protected String currMemberPageUrl;


    @BeforeClass
    protected void setupDriver() {
        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");
        setThreadSafeDriver();
        this.offerFeature = new OfferFeature(34223, "en-gb", "£", "49", "none", "4", "£49 per month after", false, "", "");
        currMemberPageUrl = getBASEURL()+BASE_DOMAIN +"/"+offerFeature.getMarket()+"/buy/default/member/?ctr="+
                offerFeature.getMarket().split("-")[1]+"&offerid="+offerFeature.getId();
    }


    @AfterClass
    protected void destroyTestDriver() {
        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
        destroyDriver();
    }

}
