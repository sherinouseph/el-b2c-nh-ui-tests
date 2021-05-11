//package com.englishlive.tests.landing.de.upsell;
///**
//* EE test
//*/
//
//import com.englishtown.enumpack.CheckoutFlowType;
//import com.englishtown.tests.flow.core.lp.LPtoTYupsellToMemberPageFlow;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//  // form changed
//public class DeEEToUpsellToMemberTest extends LPtoTYupsellToMemberPageFlow {
//    private static final Logger logger = LoggerFactory.getLogger(DeEEToUpsellToMemberTest.class);
//    @Value("#{applicationPropertiesList['de.ee.upsell.url']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        logger.info("setup ... baseurl :" + testUrl);
//        isTestCheckoutFlowType = true;
//        checkoutFlowType = CheckoutFlowType.DEFAULT;
//        //this.language = "de";        this.market   = "de";
//        formLeadTypeValue = "ee";
//        formDataMap   = EfConstants.LP_UPSELL;
//        osFormSubmitId = ".btn.btn-primary";
//        openUrl(getWebDriver(), testUrl);
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//
//}