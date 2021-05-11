//package com.englishtown.tests.landing.mx.ee;
///**
//* EE test
//*/
//
//import com.englishtown.pages.responsivecore.BasePage;
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.responsivecore.PageTest;
//import org.openqa.selenium.By;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertTrue;
//// TODO refactor test cases - this is a differnt flow - uniq so far
//// User can not sumit currently -
//public class MxEEPageTest extends PageTest {
//    @Value("#{applicationPropertiesList['mx.ee.url']}")
//    private String eePageUrl;
//
//    @Test
//    void loadEEPage(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//    }
//    @Test (dependsOnMethods={"loadEEPage"})
//    void enterEeFormData(){
//        assertTrue(isElementVisible(this.createPage().getForm().submitBtn, 10)," Failed to find submit btn");
//        this.enterFormData(EfConstants.mxEEFormMap);
//
//    }
//    @Test (dependsOnMethods={"enterEeFormData"})
//    void submitFormTest(){
//        this.createPage().getForm().submit();
//        try{Thread.sleep(50000);}catch (Exception e){}
//    }
//    @Test (dependsOnMethods={"submitFormTest"})
//    void enterLastNameAndPassAndSubmit(){
//        this.enterFormData(EfConstants.osEeFormMapLasNameAndPass);
//        this.getWebDriver().findElement(By.cssSelector("[id*=submit]")).submit();
//    }
//    @Test (dependsOnMethods={"enterLastNameAndPassAndSubmit"})
//    void validateAtPaymentPage(){
//        assertTrue(BasePage.waitForUrlContains(getWebDriver(), "checkout/payment", 15)) ;//isElementVisible();
//    }
//
//@Override
//protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//}
//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//}
//
//
//
//
//
////    @Value("#{applicationPropertiesList['test.telephone']}")
////    private String localizedTestPhoneNumber;
////
////    MyDynamicFormPage myDynamicFormPage;
////    EeThankyouPage eeThankyouPage;
////
////    @BeforeClass
////    void openPage(){
////        this.getPage().loadPage(); //        WebElementHelper.safeFindElement(getWebDriver(), By.id(elementId));
////    }
////
////    @Test(priority = 1)
////    public void openMembers_page() {          //this.createPage().isUrlValidForThisPage(); //getWebDriver().get(this.oseePageUrl);
////        myDynamicFormPage = PageFactory.initElements(getWebDriver(), MyDynamicFormPage.class);
////        myDynamicFormPage.setWebDriver(getWebDriver());
////        ExpectedCondition pageLoadCondition =  myDynamicFormPage.getPageLoadedCondition();    //TODO refactor - move to basePage
////        myDynamicFormPage.waitForPageToLoad(pageLoadCondition);
////        try{Thread.sleep(1000);  }catch(Exception e){e.printStackTrace();}
////    }
////
////    @Test (dependsOnMethods = { "openMembers_page" })
////    public void valid_inputOs_goesToThankyouPage(){
////        enterFormData(EfConstants.frOsEeFormMap);
////        try{Thread.sleep(1000);  }catch(Exception e){e.printStackTrace();}
////        myDynamicFormPage.formSubmitButton.click();   //this.submitOsForm(); //submitForm(memberPage.nextStep);
////
////    }
////    @Test (dependsOnMethods = { "valid_inputOs_goesToThankyouPage" })
////    void validateNextStepShowsVideoId(){
////        waitForExpectedCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.id("et-player-img"))), 10, 1);
////    }
////
////    @Test (dependsOnMethods = { "validateNextStepShowsVideoId" })
////    void enterLastNameAndPasswordAndSubmit(){
////        eeThankyouPage = PageFactory.initElements(getWebDriver(), EeThankyouPage.class);
////        eeThankyouPage.setWebDriver(getWebDriver());
////        ExpectedCondition pageLoadCondition =  eeThankyouPage.getPageLoadedCondition();    //TODO refactor - move to basePage
////        eeThankyouPage.waitForPageToLoad(pageLoadCondition);
////        eeThankyouPage.lastname.clear();
////        WebElementHelper.clearAndsendKeys(getWebDriver(), eeThankyouPage.lastname,"AutoLastName", true);
////        WebElementHelper.clearAndsendKeys(getWebDriver(), eeThankyouPage.mypassword,"123", true);
////        try{Thread.sleep(1000);  }catch(Exception e){e.printStackTrace();}
////        eeThankyouPage.submitForm(eeThankyouPage.submitBtn);
////    }
////
////    @Test (dependsOnMethods = { "enterLastNameAndPasswordAndSubmit" })
////    void validate_is_paymentFormTest(){
////        validate_is_paymentForm();
////    }
//
//
