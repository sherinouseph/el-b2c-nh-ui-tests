//package com.englishlive.tests.checkout.newcheckout.us;
///**
// *
// *
// *enus@qp1.org
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class USenCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//
//    private static final Logger logger = LoggerFactory.getLogger(USenCCpayReturningExStudentTest.class);
//
//    @Value("#{applicationPropertiesList['new.checkout.member.en.us.url']}")
//    protected String currMemberPageUrl;
//
//    //private String myConfirmPayButton= "form_tabctrl_tab-0_button"; //bs3 button = 3 element #form_tabctrl_tab-0_button
//    //private String memberPageLoginLinkCss = ".rightCol_offer_default_footer-parsys_spacer-0 p a";
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//
//    @BeforeClass
//    public void setup(){
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        TestUtil.printMethodName(logger);
//        failTestPerBrowser("explore", "");
//        this.memberPageUrl = currMemberPageUrl;
//        creditCardLinkText="Card";
//        isNewDesignLogin = true;
//        password = "pass";
//        tabId = 0;
//        isClickTabId = false;
//        submitBtnCss = "#form_button_default";
//        validationMsgContainsTxt = "Please agree to the Terms";
//        offerNotValidLinkCss = myOfferNotValidLinkCss;
//        memberPageUrl = currMemberPageUrl;
//        rmLoginSelector = myRmLoginSelector;
//        confirPayBtnId = myConfirmPayBtnId;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl+" ENV is : "+getENVIRONMENT());
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
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
//}
//
