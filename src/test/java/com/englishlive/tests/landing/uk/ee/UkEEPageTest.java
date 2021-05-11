package com.englishlive.tests.landing.uk.ee;
/**
* EE test
*/

//TODO udate test case acordin to below fix
//Note test will fail until https://jira-bos.englishtown.com/browse/SAND-1963 resolved
// does not go to thanks you page but /en-gb
//public class UkEEPageTest extends BaseEEtoThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(UkEEPageTest.class);
//    @Value("#{applicationPropertiesList['uk.ee.url']}")
//    private String eePageUrl;
//
//    @Value("#{applicationPropertiesList['test.telephone']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        noOfWebFormElements = 5;
//        formDataMap = EfConstants.ukEEFormMap;
//        thankyou_page_url_contains = "en-gb";
//    }
//       @Override
//protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//}
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//}