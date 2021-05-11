//package com.englishlive.tests.checkout.newcheckout.de;
///**
// * Date: 01 07 2016
// *
// * Dirty usage ... use CC pay returning flow with a flag to enter DD and pay with it
// *
// */
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
//public class DEDDpayReturningExStudentTest extends BaseCCpayReturningStudent {
//
//    private static final Logger logger = LoggerFactory.getLogger(DEDDpayReturningExStudentTest.class);
//
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
//        payDdWeId = ".bs3 .btn.btn-primary";
//        setLanguageAndMarket("de","de");
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        isDeTest = true;
//        isDDpay = true ;
//        isClickTabId = false;
//        isNewDesignLogin = true;
//        password = BaseTestConfig.getPassword8();
//        tabId = 1;
//        memberPageUrl = currMemberPageUrl;
//        validationMsgContainsTxt = "AGB akzeptieren um fortfahren zu können";
//        rmLoginSelector = myRmLoginSelector;
//        confirPayBtnId = myConfirPayBtnId;
//        formDataMap = EfConstants.DE_MEMBER_FORM;  //ukMembersFormMap_new;
//        offerNotValidLinkCss = myOfferNotValidLinkCss;
//        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
//        failTestPerBrowser("explore", "");
//        openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
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
