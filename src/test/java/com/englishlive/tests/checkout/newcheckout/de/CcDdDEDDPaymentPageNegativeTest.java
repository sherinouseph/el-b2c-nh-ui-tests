//package com.englishlive.tests.checkout.newcheckout.de;
///**
// * Check validation messages on pay page
// * CreditCard and Direct debit validation message tested on first form field
// * // NO DD for DE anomore so remove
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.validation.BaseDDPaymentPageNegativeTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcDdDEDDPaymentPageNegativeTest extends BaseDDPaymentPageNegativeTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcDdDEDDPaymentPageNegativeTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
//    protected String currMemberPageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        isClickTabId = false;
//        phase1OfferPrice ="49";
//        TestUtil.printMethodName(logger);
//        FULL_NAME_VALIDATION_MSG = "Name erforderlich";
//        creditCardLinkText="Kreditkarte";
//        submitCCbuttonSelector = ".active .bs3 button";
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
//
