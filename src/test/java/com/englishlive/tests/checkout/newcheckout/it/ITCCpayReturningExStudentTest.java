//package com.englishlive.tests.checkout.newcheckout.it;
///**
// * New checkout
// */
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// IT is oe only now
//
//public class ITCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(ITCCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.it.it.url']}")
//    protected String currMemberPageUrl;
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//
//
//    @BeforeClass
//    public void setup(){
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        creditCardLinkText="Card Paymment";  //Card Payment
//        tabId = 0;
//        isClickTabId = false;
//        password = "pass";
//        this.memberPageUrl = currMemberPageUrl;
//        this.rmLoginSelector = myRmLoginSelector;
//        this.confirPayBtnId = myConfirmPayBtnId;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        this.offerNotValidLinkCss = myOfferNotValidLinkCss;
//        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
//        failTestPerBrowser("explore", "");
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
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
