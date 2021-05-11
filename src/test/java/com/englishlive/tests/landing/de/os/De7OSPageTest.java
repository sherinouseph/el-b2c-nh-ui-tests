//package com.englishlive.tests.landing.de.os;
//
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import com.englishtown.pages.forms.BaseForm;
//import com.englishtown.pages.landing.OSLandingPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//// note there is a test and target on this   goes to DE8
//public class De7OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(De7OSPageTest.class);
//    @Value("#{applicationPropertiesList['de7.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    private String localizedTestPhoneNumber;
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        BaseForm.cssSubmitBt = ".btn-lg.btn-block";
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
//
//
//
//
