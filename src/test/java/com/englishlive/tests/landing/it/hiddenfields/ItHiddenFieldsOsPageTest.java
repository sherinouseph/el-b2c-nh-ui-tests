//package com.englishlive.tests.landing.it.hiddenfields;
///**
// * Hidden field test for : crt, lng, lead type
// * User: nikol.marku
// * Date: 01/09/14 .
// */
//
//import com.englishlive.tests.landing.base.BaseHiddenFieldsOsPageTest;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOsLandingPageHiddenFieldTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class ItHiddenFieldsOsPageTest extends BaseHiddenFieldsOsPageTest {//BaseOsLandingPageHiddenFieldTest
//    @Value("#{applicationPropertiesList['it5.os.url']}")
//    protected String osPageUrl;
//
//    @BeforeClass
//    void openPage(){
//        ctrValue      ="it";
//        langValue     ="it";
//        leadTypeValue ="os";
//        openPageAndValidate(osformsubmitId);
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//}