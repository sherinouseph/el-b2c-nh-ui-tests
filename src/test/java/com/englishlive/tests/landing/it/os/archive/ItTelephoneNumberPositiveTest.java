//package com.englishtown.tests.landing.it.os;
//
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.responsivecore.BaseLandingPageTest;
//import com.englishtown.dataprovider.ItTelNoDataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertTrue;
//
///**
// *
// * User: nikol.marku
// * Date: 29/08/14
// *
// * REQ  : {0d(1-9)dddddd????} {3d(2349)dddddd????} _|{0dd(=)d(=)d(=)d(=)d(=)d(=)????} _|{3d(2349)dd(=)d(=)d(=)d(=)d(=)????}
// *
// * Start with	0 or 3
// Start with 0 Second number (1-9)
// Start with 3 Second number (2349)
// Start with 0 Allow up to 7 repetitive no
// Start with 3 Allow up to 6 repetitive no
// 8 to 12chars that start with 0
// 8 to 12chars that start with 3
// Start with 0 Max 12 chars
// Start with 0 Min 8 chars
// Start with 3 Max 12 chars
// Start with 3 Min 8 chars
//
// */
//
//
//public class ItTelephoneNumberPositiveTest extends BaseLandingPageTest {
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
//    String successIconClass  = ".success-icon";
//    int count = 0;
//
////TODO fix this after norman fix
//    @BeforeClass
//    void openTestUrlLoadpage(){
//        assertTrue(this.getPage().isUrlValidForThisPage(),"Url is not valid for this page.");
//    }
//
//    @Test(dataProvider =  "itTelNoPositiveTestCases", dataProviderClass = ItTelNoDataProvider.class)
//    void enterTelNoAndCheckNoValidation(String info, String tel)throws Exception{
//        if(count==0){           // do this first time only
//           webElement = WebElementHelper.safeFindElement(getWebDriver(), By.id(phoneId));
//        }
//        webElement.click();
//        WebElementHelper.clearAndsendKeys(getWebDriver(), webElement, tel, true);
//        try{Thread.sleep(300);}catch (Exception e){e.printStackTrace();}
//        webElement.sendKeys("\t");
//        try{Thread.sleep(300);}catch (Exception e){e.printStackTrace();}
//        assertTrue(WebElementHelper.safeFindElement(getWebDriver(), By.className(validationMsgWe))==null );
//        //getWebDriver().navigate().refresh();
//        count++;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//
//
////
////    @Test(dataProvider =  "itTelNoNegativeTestCasesChopEntry", dataProviderClass = ItTelNoDataProvider.class)
////    void enterTelNoAndCheckEntryChoped(String info, String tel)throws Exception{
////        count = 0;
////        if(count==0){           // do this first time only
////            webElement = WebElementHelper.safeFindElement(getWebDriver(), By.id(phoneId));
////        }
////        WebElementHelper.clearAndsendKeys(getWebDriver(), webElement, tel, true);
////        try{Thread.sleep(500);}catch (Exception e){e.printStackTrace();}
////        webElement.sendKeys("\t");
////        if(count < 3){
////            isTelFieldText("");
////        }else {
////            isTelFieldText(tel.substring(0,tel.length()-1)) ;
////        }
////        try{Thread.sleep(1000);}catch (Exception e){e.printStackTrace();}
////        webElement.click();
////        try{Thread.sleep(500);}catch (Exception e){e.printStackTrace();}
////        count ++;
////    }
//
