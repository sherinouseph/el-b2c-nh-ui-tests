//package com.englishlive.tests.checkout.newcheckout.row;
///**
// * New checkout Swiden
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
//public class SeCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
//    private static final Logger logger = LoggerFactory.getLogger(SeCCpayReturningExStudentTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.en.se.url']}")
//    protected String currMemberPageUrl;
//    private String myRmLoginSelector = ".form span a";
//    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
//    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
//
//
//    @BeforeClass
//    public void setup(){
//        password = BaseTestConfig.getPassword8();
//        setThreadSafeDriver();
//        phase1OfferPrice="59";
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        isClickTabId = false;
//        memberPageUrl = currMemberPageUrl;
//        isNewDesignLogin=true;
//        rmLoginSelector = myRmLoginSelector;
//        confirPayBtnId = myConfirmPayBtnId;
//        submitBtnCss = "#form_button_default";
//        validationMsgContainsTxt = "Please agree to";
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        offerNotValidLinkCss = myOfferNotValidLinkCss;
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
