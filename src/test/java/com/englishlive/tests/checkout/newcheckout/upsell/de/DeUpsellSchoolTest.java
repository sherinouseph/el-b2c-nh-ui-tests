//package com.englishlive.tests.checkout.newcheckout.upsell.de;
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
//public class DeUpsellSchoolTest extends BaseUpsellScoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(DeUpsellSchoolTest.class);
//    protected String loginURL;
//
//    @BeforeClass
//    public void setup(){
//        String marketLang = "de-de";
//        username ="transact.test1-de@qp1.org"; // "autotest_upsell@qp1.org";
//        userPass = "1";
//        loginURL= getBASEURL()+"englishlive.ef.com/"+marketLang+"/login/";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), loginURL, -1 ) ;
//        sleep(2000);
//    }
//
//}