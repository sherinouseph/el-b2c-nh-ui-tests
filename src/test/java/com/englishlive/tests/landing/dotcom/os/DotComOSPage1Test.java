//package com.englishlive.tests.landing.dotcom.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//// US  // Martin advices no need to test /online/ urls  .. see url
//public class DotComOSPage1Test extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(DotComOSPage1Test.class);
//    @Value("#{applicationPropertiesList['eu.en.os.url1']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.com']}")
//    protected String localizedTestPhoneNumber ; //= "8558558585";
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//    @Override
//    public void verifyLanguage() {}
//
//    @Override
//    public void verifyMarket() {}
//
//    @Override
//    protected OSLandingPage createPage() {
//        formLeadTypeValue = "os";
//        this.verifyLanguage();
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//
