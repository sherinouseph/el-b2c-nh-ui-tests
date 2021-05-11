//package com.englishlive.tests.checkout.newcheckout.row;
///**
// * New checkout
// */
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class ETCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(ETCCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.en.et.url']}")
//    protected String currMemberPageUrl;
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//
//
//    @BeforeClass
//    public void setup(){
//        failTestPerBrowser("explore", "");
//        creditCardLinkText="Card Paymment";
//        validationMsgContainsTxt = "agree to the Terms";
//        isClickTabId = false;
//        this.memberPageUrl = currMemberPageUrl;
//        this.rmLoginSelector = myRmLoginSelector;
//        this.confirPayBtnId = myConfirmPayBtnId;
//        submitBtnCss = "#form_button_default"; //submitBtnCss
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        this.offerNotValidLinkCss = myOfferNotValidLinkCss;
//        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//}
//
