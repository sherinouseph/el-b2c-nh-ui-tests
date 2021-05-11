package com.englishlive.tests.checkout.newcheckout.content.newdesign;
/**
 * Nikol Nov 2018
 *
 * TODO fix TR check out as it has different selectors
 */

import com.englishtown.helpers.bean.OfferFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TRCheckOfferFeatureNewDesignTest extends BaseNewDesignCheckOfferFeature {
    private static final Logger logger = LoggerFactory.getLogger(TRCheckOfferFeatureNewDesignTest.class);

    protected String currMemberPageUrl;


    @BeforeClass
    protected void setupDriver() {
        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");
        setThreadSafeDriver();
        this.offerFeature = new OfferFeature(32044, "tr-tr", "TL", "99", "none", "none", "aylık 99TL", false, "", "");
        currMemberPageUrl = getBASEURL()+BASE_DOMAIN +"/"+offerFeature.getMarket()+"/buy/default/member/?ctr="+
                offerFeature.getMarket().split("-")[1]+"&offerid="+offerFeature.getId();
    }


    @AfterClass
    protected void destroyTestDriver() {
        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
        destroyDriver();
    }

}