//package com.englishlive.tests.landing.it.os;
//
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import com.englishtown.pages.forms.BaseForm;
//import com.englishtown.pages.landing.OSLandingPage;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class It9OSPageTest extends BaseOSPageTest {
//    @Value("#{applicationPropertiesList['it9.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.it']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    public void setup(){
//        BaseForm.isSpecialSubmit=true;
//    }
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
