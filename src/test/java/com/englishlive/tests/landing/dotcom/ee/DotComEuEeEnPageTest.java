//package com.englishtown.tests.landing.dotcom.ee;
///**
//* EE test -
// * Option 1: EE form then member then checkout[pay]
// *        2:
//*/
//
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.landing.base.BaseEEtoProfileThenThankyouFormFlowTest;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
////TODO this test require new flow - EE - to member - to checkout
//public class DotComEuEeEnPageTest extends BaseEEtoProfileThenThankyouFormFlowTest { //BaseEEtoThankyouFormFlowTest { //PageTest {
//    private static final Logger logger = LoggerFactory.getLogger(DotComEuEeEnPageTest.class);
//
//    @Value("#{applicationPropertiesList['eu.en.ee.url']}")
//    private String eePageUrl;
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        noOfWebFormElements = 6;
//        formDataMap = EfConstants.baseOsEeFormMap;
//    }
//    //@Override
//    public void selectEmailCheckBoxAndsubmitFormAgainTest(){
//        this.enterFormData(EfConstants.osEeFormMapLasNameAndPass);
//        WebElementHelper.safeFindElement(this.getWebDriver(), By.id("et-lp-osmember-submit")).click(); //this.getPage().getForm().submit();         //this.getPage().getForm().submit();
//        try{Thread.sleep(3000);}catch (Exception e){}
//    }
//
//    @Override
//    protected void verifyAtThankyouPage(){
//        verifyUrlContains("checkout/payment", 15);
//    }
//
//    @Override
//    protected void verifyStateObjectEvents(){
//        assertStateObjectValue("tracking.events", "MemberRegistration", "EmailEnglish","MemberRevenue", "EmailEnglishRevenue");
//    }
//    @Override
//    protected void verifyStateObjectLeadId(){
//        logger.info(" Test verifyStateObjectLeadId NOT run ");
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//}
