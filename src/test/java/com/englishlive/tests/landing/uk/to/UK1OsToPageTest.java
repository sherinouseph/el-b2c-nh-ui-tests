//package com.englishlive.tests.landing.uk.to;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.springframework.beans.factory.annotation.Value;
//
//public class UK1OsToPageTest extends BaseOSPageTest {
//    @Value("#{applicationPropertiesList['uk.to.url']}")
//    private String osPageUrl;
//    //@Value("#{applicationPropertiesList['test.telephone']}")
//    private String localizedTestPhoneNumber = null;
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        formLeadTypeValue = "os";
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//
