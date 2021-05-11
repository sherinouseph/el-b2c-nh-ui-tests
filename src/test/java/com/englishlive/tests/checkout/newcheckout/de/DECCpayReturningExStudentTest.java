//package com.englishlive.tests.checkout.newcheckout.de;
///**
// * DE returning student test
// *
// */
//
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.BaseTestConfig;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class DECCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(DECCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
//    protected String currMemberPageUrl;
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirPayBtnId  = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        phase1OfferPrice ="59";
//        setLanguageAndMarket("de","de");
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        validationMsgContainsTxt = "AGB akzeptieren um fortfahren zu können";
//        isDeTest = true;
//        isClickTabId = true;
//        isNewDesignLogin = true;
//        creditCardLinkText="Kreditkarte";
//        password = BaseTestConfig.getPassword8();
//        tabId = 1;
//        memberPageUrl = currMemberPageUrl;
//        rmLoginSelector = myRmLoginSelector;
//        confirPayBtnId = myConfirPayBtnId;
//        formDataMap = EfConstants.deMembersMap; //ukMembersFormMap_new;
//        offerNotValidLinkCss = myOfferNotValidLinkCss;
//        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
//        openUrl(getWebDriver(), memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
