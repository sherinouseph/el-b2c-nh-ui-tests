//package com.englishtown.tests.landing.fr.os;
////new flow
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// this test can be removed as same url is used for new checkout tests with pcode
//public class Fr5OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Fr5OSPageTest.class);
//    @Value("#{applicationPropertiesList['fr5.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.fr']}")
//    private String localizedTestPhoneNumber;
//    /**
//     * TODO  Note
//     * When test click submit payment page is shown in english and not if french - caused by old/new pages mix
//     */
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//