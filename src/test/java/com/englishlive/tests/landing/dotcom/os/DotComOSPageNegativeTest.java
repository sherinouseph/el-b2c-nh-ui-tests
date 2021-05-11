//package com.englishtown.tests.landing.dotcom.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.landing.base.BaseOSPageNegativeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
///**
// * Negative testing
// * User: nikol.marku
// * Date: 27/08/14
// *
// */
//// issue with click on chrome
//public class DotComOSPageNegativeTest extends BaseOSPageNegativeTest {
//    private static final Logger logger = LoggerFactory.getLogger(DotComOSPageNegativeTest.class);
//    @Value("#{applicationPropertiesList['eu.en.os.url1']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.com.eu']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    void setup(){
//         super.setup("test1Dotcom_os",this.getLocalizedTestPhoneNumber(),EfConstants.deOsFormMap_empty ,7,".et-sp-form-realtime input",
//                      ".et-cnt", "please enter" );                    //         userName =  "test12345et_osdotcom"+System.currentTimeMillis()+"@qp1.org"; //"noInit";   //         userMap = EfConstants.createMap(userName, localizedTestPhoneNumber)  ;  //         logger.info("Setup map with username : "+userName);  //         EfConstants.dumpMap(userMap);
//         this.getPage().isUrlValidForThisPage();
//    }
//
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
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
//
////    @Test
////    void enter_emptyData(){
////         enterFormData(EfConstants.deOsFormMap_empty);              //submitOsForm(); //getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
////    }
////
////    @Test(dependsOnMethods = { "enter_emptyData" })
////    void validateTheFormElementNumber(){
////        assertTrue(isNoOfFormElements(getWebDriver(), By.cssSelector(formElementSelector), noOfWebFormElements), " Failed no of form element test ..!"); //validateNoOfInputElements("", noOfWebFormElements);   // .et-sp-form-realtime input String selectorLocation="isInitStatically on the method";
////    }
////    @Test (dependsOnMethods = { "validateTheFormElementNumber" })
////    void click_submit(){
////        submitOsForm();
////    }
////      //validate message
////    @Test (dependsOnMethods = { "validateTheFormElementNumber" })
////    void validateFormMsg(){    //et-cnt
////        WebElement we = WebElementHelper.safeFindElement(getWebDriver(), By.className("et-cnt"));
////        assert we.isDisplayed();
////        assert we.getText().contains("enter your");
////    }
