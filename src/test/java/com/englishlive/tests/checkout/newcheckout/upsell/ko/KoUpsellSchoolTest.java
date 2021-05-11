//package com.englishlive.tests.checkout.newcheckout.upsell.ko;
///**
// *
// */
//import com.englishlive.tests.checkout.newcheckout.upsell.core.BaseUpsellScoolTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//
//
//public class KoUpsellSchoolTest extends BaseUpsellScoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(KoUpsellSchoolTest.class);
//    //@Value("#{applicationPropertiesList['it.upsell']}")
//    protected String loginURL;
//
//    @BeforeClass
//    public void setup(){
//        String marketLang = "ko-kr";
//        username ="transact.test1-kr@qp1.org"; // "autotest_upsell@qp1.org";
//        userPass = "1";
//        loginURL= getBASEURL()+"englishlive.ef.com/"+marketLang+"/login/";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), loginURL, -1 ) ;
//        sleep(2000);
//    }
//
//}