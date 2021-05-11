//package com.englishlive.tests.checkout.newcheckout.upsell.it;
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
//public class ITUpsellSchoolTest extends BaseUpsellScoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(ITUpsellSchoolTest.class);
//    //@Value("#{applicationPropertiesList['it.upsell']}")
//    protected String loginURL;
//
//    @BeforeClass
//    public void setup(){
//        String marketLang = "it-it";
//       //username = "autotest_upsell@qp1.org"; //qa:"test12345et1458665623019@qp1.org"; live : test12345et1458733168672@qp1.org
//        username ="transact.test1-it@qp1.org"; // "autotest_upsell@qp1.org";
//        userPass = "1";
//        loginURL= getBASEURL()+"englishlive.ef.com/"+marketLang+"/login/";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), loginURL, -1 ) ;
//        sleep(2000);
//    }
//
//}