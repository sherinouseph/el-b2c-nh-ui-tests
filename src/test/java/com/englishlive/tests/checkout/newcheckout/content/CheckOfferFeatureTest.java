package com.englishlive.tests.checkout.newcheckout.content;
/**
 * Created by nikol.marku on 10-Jul-17.
 * https://jira.eflabs.io/browse/SAND-4255
 * open member page and check offer features like price, classes etc
 *
 * Old design
 *
 */

import com.englishtown.dataprovider.OfferFeaturesDatatProvider;
import com.englishtown.helpers.bean.OfferFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;


public class CheckOfferFeatureTest extends BaseCheckOfferFeature {

    private static final Logger logger = LoggerFactory.getLogger(CheckOfferFeatureTest.class);


    @Factory(dataProvider = "getOfferFeature", dataProviderClass = OfferFeaturesDatatProvider.class )
    public CheckOfferFeatureTest(OfferFeature offerFeature) {
        logger.info("Running constructor set up Test data bean ...!");
        this.offerFeature = offerFeature;
    }

    @BeforeClass
    protected void setupDriver() {
        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");
        setThreadSafeDriver();
    }


    @AfterClass
    protected void destroyTestDriver() {
        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
        destroyDriver();
        //if(null != webDriver)            webDriver.quit();
    }

}
