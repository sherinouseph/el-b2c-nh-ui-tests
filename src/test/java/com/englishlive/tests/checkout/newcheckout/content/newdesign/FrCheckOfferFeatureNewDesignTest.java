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


public class FrCheckOfferFeatureNewDesignTest extends BaseNewDesignCheckOfferFeature {
    private static final Logger logger = LoggerFactory.getLogger(FrCheckOfferFeatureNewDesignTest.class);

    protected String currMemberPageUrl;


    @BeforeClass
    protected void setupDriver() {
        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");
        setThreadSafeDriver();
        //this.offerFeature = new OfferFeature(32337, "fr-fr", "€", "89", "4", "20", "89€/mois. Annulez quand", false, "", "");
        this.offerFeature = new OfferFeature(35097, "fr-fr", "€", "19", "none", "4", "19€/mois. Annulez quand", false, "", "");
        currMemberPageUrl = getBASEURL()+BASE_DOMAIN +"/"+offerFeature.getMarket()+"/buy/default/member/?ctr="+
                offerFeature.getMarket().split("-")[1]+"&offerid="+offerFeature.getId();
    }


    @AfterClass
    protected void destroyTestDriver() {
        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
        destroyDriver();
    }

}

