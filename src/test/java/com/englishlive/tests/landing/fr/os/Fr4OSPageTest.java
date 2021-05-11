//package com.englishtown.tests.landing.fr.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// 404 error shown
//public class Fr4OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Fr4OSPageTest.class);
//    @Value("#{applicationPropertiesList['fr4.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.fr']}")
//    private String localizedTestPhoneNumber;
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//    @Override
//    public void valid_inputOs_goesToPayment(){
//        try{Thread.sleep(3000);}catch (Exception e){}
//        validInputSubmissionGoesToPaymentPage()  ;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//
////    /**
////     * TODO  Note
////     * When test click submit payment page is shown in english and not if french - caused by old/new pages mix
////     */
//////    @Override
//////    public  void verifyLanguage(){}