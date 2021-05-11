//package com.englishlive.tests.checkout.newcheckout.upsell.br;
///**
// *
// */
//import com.englishlive.tests.checkout.newcheckout.upsell.core.BaseUpsellScoolTest;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//
// //TODO need to pay on this one
//public class BrUpsellSchoolTest extends BaseUpsellScoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrUpsellSchoolTest.class);
//    //@Value("#{applicationPropertiesList['it.upsell']}")
//    protected String loginURL;
//
//    @BeforeClass
//    public void setup(){
//        String marketLang = "br";
//        upsellExtraUrlParams = "&ctr=br&lng=pt";
//        username ="transact.test1-br@qp1.org";
//        userPass = "1";
//        productMaxId = 4 ; // 5 product for br
//        loginURL= UrlMapper.mapELiveBaseUrlToEtownBaseUrl(getBASEURL())+".englishtown.com.br/login/";
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        openUrl(getWebDriver(), loginURL, -1 ) ;
//        sleep(3000);
//        clickAtWindow(getWebDriver(), 1,1);
//    }
//
//}