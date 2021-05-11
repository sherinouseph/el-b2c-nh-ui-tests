//package com.englishlive.tests.checkout.newcheckout.fr.offer.id.crm;
///**
// * New checkout
// *
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.SelectOfferAndPayAlumni;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class FRCCpayReturningExStudentWithOfferTest extends SelectOfferAndPayAlumni { //BaseCCpayReturningStudent {
//
//    private static final Logger logger = LoggerFactory.getLogger(FRCCpayReturningExStudentWithOfferTest.class);
//
//    @Value("#{applicationPropertiesList['member.fr.fr.offerid31338.url']}")
//    protected String currMemberPageUrl;
//
//    private String myConfirmPayButton= "form_tabctrl_tab-0_button"; //bs3 button = 3 element #form_tabctrl_tab-0_button
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger);
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        this.memberPageUrl = currMemberPageUrl;
//        creditCardLinkText="Carte";
//        submitBtn = "[type*=submit]";
//        tabId = 0;
//        isClickTabId = false;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        confirPayBtnId = myConfirmPayButton;
//        logger.info("setup url: "+memberPageUrl+" ENV is : "+getENVIRONMENT());
//        //memberPageUrl = UrlMapper.mapUrlToELive(memberPageUrl, getBASEURL());
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
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
