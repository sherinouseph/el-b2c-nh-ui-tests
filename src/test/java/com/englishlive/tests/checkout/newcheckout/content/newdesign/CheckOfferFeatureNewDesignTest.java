//package com.englishlive.tests.checkout.newcheckout.content.newdesign;
///**
// * Nikol Nov 2018
// *
// * TODO fix TR check out as it has different selectors
// */
//
//import com.englishtown.dataprovider.OfferFeaturesDatatProvider;
//import com.englishtown.helpers.bean.OfferFeature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Factory;
//
//  // uses data factory
//public class CheckOfferFeatureNewDesignTest extends BaseNewDesignCheckOfferFeature {
//
//    private static final Logger logger = LoggerFactory.getLogger(CheckOfferFeatureNewDesignTest.class);
//
//
//    @Factory(dataProvider = "getOfferFeatureNewHouse", dataProviderClass = OfferFeaturesDatatProvider.class )
//    public CheckOfferFeatureNewDesignTest(OfferFeature offerFeature) {
//        logger.info("Running constructor set up Test data bean ...!");
//        this.offerFeature = offerFeature;
//    }
//
//    @BeforeClass
//    protected void setupDriver() {
//        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");
//        setThreadSafeDriver();
//    }
//
//
//    @AfterClass
//    protected void destroyTestDriver() {
//        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
//        destroyDriver();
//    }
//
//}
