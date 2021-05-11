//package com.englishlive.tests.landing.br.os;
//
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import com.englishtown.pages.landing.OSLandingPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//  // removed as cause ms edge issue .. TODO find solution
//public class BR1OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(BR1OSPageTest.class);
//    @Value("#{applicationPropertiesList['br.os1.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    private String localizedTestPhoneNumber;
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        isConfirmPassword = true;
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        formLeadTypeValue = "os";
//        setLanguageAndMarket("pt","br");
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
//
//
//
//
