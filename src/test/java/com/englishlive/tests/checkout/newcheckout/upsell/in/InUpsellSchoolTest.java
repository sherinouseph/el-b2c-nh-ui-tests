//package com.englishlive.tests.checkout.newcheckout.upsell.in;
///**
// *
// */
//import com.englishlive.tests.checkout.newcheckout.upsell.core.BaseUpsellScoolTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//
////no in-in
//public class InUpsellSchoolTest extends BaseUpsellScoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(InUpsellSchoolTest.class);
//    protected String loginURL;
//
//    @BeforeClass
//    public void setup(){
//        String marketLang = "id-id";
//        username ="transact.test1-in@qp1.org"; // "autotest_upsell@qp1.org";
//        userPass = "1";
//        productMaxId = 2 ;
//        loginURL= getBASEURL()+"englishlive.ef.com/"+marketLang+"/login/";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), loginURL, -1 ) ;
//        sleep(2000);
//    }
//
//}