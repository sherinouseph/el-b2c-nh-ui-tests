//package com.englishtown.tests.landing.fr.hiddenfields;
///**
// * Hidden field test for : crt, lng,
// * User: nikol.marku
// * Date: 01/09/14 .
// */
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.landing.base.BaseOsLandingPageHiddenFieldTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//// this test flow has changed
//public class FrHiddenFieldsOsPageTest extends BaseOsLandingPageHiddenFieldTest {
//    @Value("#{applicationPropertiesList['fr1.os.url']}")
//    private String osPageUrl;
//
//
//
//    private String ctrValue       ="fr";
//    private String langValue      ="fr";
//    private String leadTypeValue  ="os";
//
//    @BeforeClass
//    void openPage(){
//        openPageAndValidate(osformsubmitId);
//    }
//    @Test
//    void testCTRcodeHiddenFieldTest(){
//        checkOsHiddenFildTest(ctrId, ctrValue, 10);
//    }
//    @Test
//     void testLangCodeHiddenFieldTest(){
//        checkOsHiddenFildTest(langId, langValue, 5);
//    }  //
//    @Test
//    void testLeadTypeCodeCodeHiddenFieldTest(){
//        checkOsHiddenFildTest(leadId, leadTypeValue, 3);
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
