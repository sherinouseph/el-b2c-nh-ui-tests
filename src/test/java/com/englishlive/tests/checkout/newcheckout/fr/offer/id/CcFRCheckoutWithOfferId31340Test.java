//package com.englishlive.tests.checkout.newcheckout.fr.offer.id;
///**
// *
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcFRCheckoutWithOfferId31340Test extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcFRCheckoutWithOfferId31340Test.class);
//    @Value("#{applicationPropertiesList['member.fr.fr.offerid31340.url']}")
//    protected String currMemberPageUrl;
//    protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        setLanguageAndMarket("fr","fr");
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        creditCardLinkText="Carte";
//        tabId = 0;
//        isClickTabId =false;
//        paymentSubmitBtnCss = ".btn.btn-primary";
//        isNewhouseTyPage = true;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @Override
//    public void check_EnrolmentPage() {
//        /* FR only */
//        assertIsUrlContaining("enrollment/b2c/entrance");
//        // waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ue-logo")), getWebDriver(), 30);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//