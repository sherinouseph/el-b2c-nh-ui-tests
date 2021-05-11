//package com.englishlive.tests.checkout.newcheckout.upsell.it;
///**
// *
// *
// */
//import com.englishtown.enumpack.CheckoutFlowType;
//import com.englishtown.tests.checkout.common.core.BaseUpsellTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class ITUpsellTest extends BaseUpsellTest {
//    private static final Logger logger = LoggerFactory.getLogger(ITUpsellTest.class);
//    @Value("#{applicationPropertiesList['it.upsell']}")
//    protected String redemptionPage;
//
//    @BeforeClass
//    public void setup(){
//        isTestCheckoutFlowType = true;
//        setThreadSafeDriver();
//        phase0OfferPrice ="0";
//        checkoutFlowType = CheckoutFlowType.UPSELL;
//        //runTestOnThisEnvironmentOnly("qa", "This test runs only on QA environment ...!");
//        redemptionCode = getRedemptionCodePerEnv(); //"FASTWEBQA";
//        String marketLang = "it-it";
//        upsellDirectUrl = getBASEURL()+"englishlive.ef.com/"+marketLang+"/buy/upsell/payment/?offerid=31658";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), redemptionPage, -1 ) ;
//        sleep(3000);
//    }
//
//
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//        destroyDriver();
//    }
//
//
//}