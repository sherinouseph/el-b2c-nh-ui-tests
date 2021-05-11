//package com.englishlive.tests.checkout.newcheckout.fr;
///**
// *
// *
// *
// */
//import com.englishtown.enumpack.CheckoutFlowType;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.BaseTestConfig;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class FRCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(FRCCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.fr.fr.url']}")
//    protected String currMemberPageUrl;
//
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId  = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//    //private String myConfirmPayButton= "form_tabctrl_tab-0_button"; //bs3 button = 3 element #form_tabctrl_tab-0_button
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        phase0OfferPrice ="89";
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        setLanguageAndMarket("fr", "fr");
//        validationMsgContainsTxt = "Vous devez accepter les conditions générales de vente";
//        isTestCheckoutFlowType = true;
//        checkoutFlowType = CheckoutFlowType.DEFAULT;
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        creditCardLinkText="Carte";
//        isNewDesignLogin=true;
//        password=BaseTestConfig.getPassword8();
//        tabId = 0;
//        isClickTabId = false;
//        password = BaseTestConfig.getPassword8();
//        setSubmitBtn("input[type=submit]");
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        confirPayBtnId = myConfirmPayBtnId;
//        this.rmLoginSelector = myRmLoginSelector;
//        this.offerNotValidLinkCss = myOfferNotValidLinkCss;
//        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//
//    protected String getTestPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//
//    @Override
//    protected String getMemberPageUrl() {
//        return memberPageUrl;
//    }
//
//    @Override
//    protected String getThankYouPageUrl() {
//        return null;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
