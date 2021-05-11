//package com.englishtown.tests.landing.it.os;
//
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.responsivecore.BaseLandingPageTest;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.dataprovider.ItTelNoDataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
///**
// *
// * User: nikol.marku
// *
// * REQ  : {0d(1-9)dddddd????} {3d(2349)dddddd????} _|{0dd(=)d(=)d(=)d(=)d(=)d(=)????} _|{3d(2349)dd(=)d(=)d(=)d(=)d(=)????}
//*/
//
//
//public class ItTelNoShowsValidationPopup extends BaseLandingPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(ItTelephoneNumberPositiveTest.class);
//
//    @Value("#{applicationPropertiesList['it1.os.url']}")
//    private String osPageUrl;
//    private String validationMsgContains = "tele";
//
//    WebElement webElement;
//    String phoneId           = "telephone";
//    String controlClass      =".controls";
//    String validationMsgWe   = "popover-content";
//    String osformsubmitId    = "osformsubmit";
//    int count = -1;
//
//    @BeforeClass
//    void openTestUrlLoadpage(){
//        Assert.assertTrue(this.getPage().isUrlValidForThisPage(), "Url is not valid for this page.");
//    }
//
//    @Test(dataProvider =  "itTelNoNegativeTestCasesShowAlertPopup", dataProviderClass = ItTelNoDataProvider.class)
//    void enterTelNoAndCheckValidationPopUpShown(String info, String tel)throws Exception{
//        count++;
//        if(count==0){           // do this first time only
//            webElement = WebElementHelper.safeFindElement(getWebDriver(), By.id(phoneId));
//            enterFormDataAll(EfConstants.itOsFormMap)  ;
//        }
//        webElement.click();
//        WebElementHelper.clearAndsendKeys(getWebDriver(), webElement, tel, true);
//        try{Thread.sleep(1000);}catch (Exception e){e.printStackTrace();}
//        webElement.sendKeys("\t");
//        try{Thread.sleep(1000);}catch (Exception e){e.printStackTrace();}
//        testOsValidationMessageShown(validationMsgContains) ;
//        try{Thread.sleep(500);}catch (Exception e){e.printStackTrace();}
//
//    }
//
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//}
//
