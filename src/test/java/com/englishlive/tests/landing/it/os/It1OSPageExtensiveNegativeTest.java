//package com.englishlive.tests.landing.it.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.BaseLandingPageTest;
//import com.englishtown.tests.core.EfConstants;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
///**
// * Negative testing
// * User: nikol.marku
// * Date: 27/08/14
// *
// */
////TODO refactor with ItOSPageNegativeTest
//
//public class It1OSPageExtensiveNegativeTest extends BaseLandingPageTest {
//
//    @Value("#{applicationPropertiesList['it1.os.url']}")
//    private String osPageUrl;
//
//    @Test
//    void enter_empty_FisrName_submit(){
//        enter_data_click_submit_check_validation_Shown(EfConstants.itOsFormMap_noFname);
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//}
