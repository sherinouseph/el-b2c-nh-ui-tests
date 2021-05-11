//package com.englishlive.tests.checkout.newcheckout.upsell.th;
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
//public class ThUpsellSchoolTest extends BaseUpsellScoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(ThUpsellSchoolTest.class);
//    protected String loginURL;
//
//    @BeforeClass
//    public void setup(){
//        String marketLang = "th-th";
//        username ="transact.test1-th@qp1.org";
//        userPass = "1";
//        loginURL= getBASEURL()+"englishlive.ef.com/"+marketLang+"/login/";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), loginURL, -1 ) ;
//        sleep(2000);
//    }
//
//}