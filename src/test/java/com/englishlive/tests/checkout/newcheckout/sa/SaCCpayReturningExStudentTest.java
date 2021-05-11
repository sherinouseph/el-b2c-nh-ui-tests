//package com.englishlive.tests.checkout.newcheckout.sa;
///**
// * New checkout
// */
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class SaCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(SaCCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.ar.sa.url']}")
//    protected String currMemberPageUrl;
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//
//
//    @BeforeClass
//    public void setup(){
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        //BaseRemoteWebDriver.currentBrowserName = "chrome";
////        failTestPerBrowser("explore", "");
//        setThreadSafeDriver();
//        creditCardLinkText="Card Paymment";
//        isClickTabId = false;
//        loginBtn = ".bs3  .btn-secondary";
//        this.memberPageUrl = currMemberPageUrl;
//        this.rmLoginSelector = myRmLoginSelector;
//        this.confirPayBtnId = myConfirmPayBtnId;
//        validationMsgContainsTxt =   "الرجاء";
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        this.offerNotValidLinkCss = myOfferNotValidLinkCss;
//        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
//
//
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
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