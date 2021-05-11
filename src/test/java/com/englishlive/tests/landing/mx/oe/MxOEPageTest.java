//package com.englishtown.tests.landing.mx.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class MxOEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(MxOEPageTest.class);
//
//    @Value("#{applicationPropertiesList['mx.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.br']}")
//    private String localizedTestPhoneNumber;
//
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="privateteacher_verify_thankyou";
//        noOfWebFormElements = 10;
//        formDataMap = EfConstants.mxOEFormMapWithPhoneType;
//    }
//
////    @Test
////    protected void enterOeFormdata(){
////        this.enterFormData(EfConstants.mxOEFormMap);
////    }
////
////    @Test (dependsOnMethods = { "enterOeFormdata" })
////    protected void verifyTheNumberOfFormElement(){
////        assertTrue(isNoOfFormElements(getWebDriver(), By.cssSelector(allformElementSelector), noOfWebFormElements),
////                " Failed no of form element test ..!");
////    }
////    @Test(dependsOnMethods = { "verifyTheNumberOfFormElement" })
////    protected void submitEeFormTest(){
////        this.getPage().getForm().submit();
////    }
////
////    @Test(dependsOnMethods = { "submitEeFormTest" })
////    protected void verifyAtThankyouPage(){
////        assertTrue(BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains , 15))  ;
////    }
////    @Test(dependsOnMethods = { "verifyAtThankyouPage" })
////    protected void verifyStateObjectEvents(){
////        assertThankyouPageStateObjectLpOeTrackingEvents();
////    }
////    @Test(dependsOnMethods = { "verifyStateObjectEvents" })
////    protected void verifyStateObjectLeadId(){
////        logger.info("SAND-1887  need to bee fixed for this test to pass");
////        assertThankyouPageStateObjectLpOeLeadId() ;  //This will fail until SAND-1887 is fixed
////    }
//
//
//    //TODO
////    @Test(dependsOnMethods = { "verifyStateObject" })
////    protected void verifyFormValuesArePersisted(){
////
////    }
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
////    @Override
////    public  void verifyLanguage(){}
////    @Override
////    public  void verifyMarket(){}
//
//}
