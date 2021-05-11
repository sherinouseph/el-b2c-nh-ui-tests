//package com.englishlive.tests.landing.de.hiddenfields;
///**
// * Hidden field test for : crt, lng, leadtype
// * User: nikol.marku
// * Date: 01/09/14 .
// */
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseHiddenFieldsOsPageTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class DeHiddenFieldsOsPageTest extends BaseHiddenFieldsOsPageTest {
//    @Value("#{applicationPropertiesList['de1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    void openPage(){
//        ctrValue      ="de";
//        langValue     ="de";
//        leadTypeValue ="os";
//        openPageAndValidate(getOsformsubmitId());
//        try{Thread.sleep(1000);}catch (Exception e){}
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//
//}
