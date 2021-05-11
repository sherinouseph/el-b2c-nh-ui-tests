//package com.englishlive.tests.checkout.newcheckout.ja;
///**
// *
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//// considered as overtested so removing it NM
//// this test is on the old flow and FR is on the new flow --- after user login payment page is shown
//public class JaCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(JaCCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.ja.jp.url']}")
//    protected String currMemberPageUrl;
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId = "#form_tabctrl_tab-0_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//    //private String myConfirmPayButton= "form_tabctrl_tab-0_button"; //bs3 button = 3 element #form_tabctrl_tab-0_button
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        phase1OfferPrice="8532";
//        paymentSubmitBtnCss = ".bs3 .btn";
//        setLanguageAndMarket("ja","jp");
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        TestUtil.printMethodName(logger);
//        failTestPerBrowser("explore", "");
//        this.memberPageUrl = currMemberPageUrl;
//        offerNotValidMessageText ="現在のお申込は有効で" ;
//        validationMsgContainsTxt  = "ご同意いただける場合は、チェックボックスをクリックください。";//errorFailmeAs msg should be in JA ...!"; //TODO update txt of the error
//        submitBtnCss = myConfirmPayBtnId;
//        isClickTabId = false;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        confirPayBtnId = myConfirmPayBtnId;
//        this.rmLoginSelector = myRmLoginSelector;
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
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
