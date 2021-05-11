//package com.englishlive.tests.checkout.newcheckout.tr.fielderrorvalidation;
///**
// * Nikol 2018
// *
// * Check validation page for each of the fields and for the exiting user email
// *
// * open member page
// * Click submit
// *
// */
//import com.englishtown.dataprovider.bin.validation.MemberPageValidationMsgBean;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.validation.BaseMemberPageNegativeTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// NM .. ocmmmented out .. as back to OH... this is covered on DEMemberPageNegative test
//
//public class TRMemberNegativeTest extends BaseMemberPageNegativeTest {
//    private static final Logger logger = LoggerFactory.getLogger(TRMemberNegativeTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.tr.tr.url']}")
//    protected String currMemberPageUrl;
//
//
//    @BeforeClass
//    public void setupOpenMemberPage(){
//        setThreadSafeDriver();
//        isNewhouseCheckout=true;
//        TestUtil.printMethodName(logger);
//        setMemberPageValidationMsgBean();
//        submitBtnCss = ".btn.btn-primary";
//        setLanguageAndMarket("tr", "tr");
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//    @Override
//    public void setMemberPageValidationMsgBean() {
//        //try with full length ... if keep changing try with a shorter string
//        memberPageValidationMsgBean = new MemberPageValidationMsgBean(
//                "Lütfen isminizi Türkçe karakterler kullanmadan girin",
//                "Lütfen soyadınızı Türkçe karakterler kullanmadan girin",
//                "Geçerli bir email adresi girin.",
//                "Üzgünüz, bu e-posta adresi sistemimizde kayıtlı, lütfen",
//                "Lütfen bir şifre oluşturun",
//                "Devam etmek için lütfen şart ve koşullarımızı kabul edin");
//    }
//}
////inuse email error message yet to translate to turkish
////"Bu email bir kullanıcıya ait",email inuse validation message tr oldhouse