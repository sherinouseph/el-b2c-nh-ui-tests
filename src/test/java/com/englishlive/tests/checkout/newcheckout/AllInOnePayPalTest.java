//package com.englishlive.tests.checkout.newcheckout;
///**
// * PayPal test run manytimes
// */
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.MyWebDriverAction;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Created by nikol.marku on 18/03/2016.
// */
//@Test (invocationCount = 2, threadPoolSize = 2)
//public class AllInOnePayPalTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(AllInOnePayPalTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.ja.jp.url']}")
//    protected String currMemberPageUrl;
//
//    WebDriver driver;
//
//    Map formDataMap1 ;
//
//
//    @BeforeClass
//    public void setup(){
//        continuePayPalId = "continue";
//        submitToPpId = "submitLogin";
//        payPalDataMap = EfConstants.payPalJP;
//        tabLinkText="Paypal";
//        this.formDataMap = EfConstants.ukMembersFormMap_new;
//        this.memberPageUrl = currMemberPageUrl;
//        tabId = 1;
//        logger.info("setup url: "+memberPageUrl);
//
//    }
//
//
//
////    @BeforeTest
////    void openLoadTestMemberPage() {
////       // this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
////    }
//
//
////    @AfterTest
////    void DestroyBrowser(){
////        destroy();
////    }
//
//    @Test
//    public void payPallFullTest() {
//        sleep(500);
//        formDataMap1 = EfConstants.ukMembersFormMap_new;
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        this.openUrl(driver, this.memberPageUrl, -1 ) ;
//        logger.info("start enterMemberDetails ....!");
//              WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(memberSpinnerCss)),driver,25000);
//
//        TestUtil.enterFormData(driver,formDataMap1);
//        submit_MembersForm(driver);
//        sleep(5000);
//
//        logger.info("Payment page ....!");
//        WebElementHelper.clickOnTabByLinkText(driver, tabLinkText) ;
//        WebElement agreeWe = WebElementHelper.safeFindElement(driver, By.id(payPalAuthorizeId));
//        click(agreeWe);
//        logger.info(" Clicked to accecpt T&C");
//        try{Thread.sleep(200);  }catch(Exception e){}
//        WebElement confirmPPbt = WebElementHelper.safeFindElement(driver, By.id(confirPPWeId));
//        click(confirmPPbt) ;
//        try{Thread.sleep(3000);  }catch(Exception e){}
//        WebElementHelper.safeFindElement(driver, By.cssSelector(".securePayPalTabLogo")).click();
//        //jp/cgi-bin/
//        getWebDriver().manage().deleteAllCookies();
//        try{Thread.sleep(200);  }catch(Exception e){}
//        driver.manage().deleteAllCookies();
//        driver.close();
//
//    }
//
//
//
//
//
//
//    public void submit_MembersForm(WebDriver webDriver) {
//        String deviceName = BaseRemoteWebDriver.currentDeviceName;
//        logger.info("Submit member form .... on : "+deviceName);
//        try {
//
//            WebElement submit = WebElementHelper.safeFindDisplayedAndEnabled(webDriver, By.id("form_button"),
//                    WaitTool.DEFAULT_WAIT_4_ELEMENT);
//            if(deviceName !=null){
//                if( "r32d1034yky".contains(deviceName) ) {  // NexusOne
//                    logger.info("Is mobile Device ipad or nexus one ....");
//                    JavaScriptHelper.highlightElement(submit, webDriver);
//                    MyWebDriverAction.moveToElementAndClick(webDriver, submit);           // does not work for ipad mini
//                }if( deviceName.toLowerCase().contains("ipad") || deviceName.toLowerCase().contains("nexus") ||
//                        deviceName.toLowerCase().contains("iphone") || deviceName.toLowerCase().contains("amsung")  ) {
//                    submit.click();
//                } else {
//                    logger.info("deviceName does not contains ipad or nexus one. No click done ....");
//                }
//            }else {                                   //  if(BaseRemoteWebDriver.getCurrentBrowserName().contains("explore")){ JavaScriptHelper.clickAtWindowXY(getWebDriver(), submit.getLocation().getX(),submit.getLocation().getX() );  /* IE11 click is not working*/     }else
//                submit.click();
//            }
//        }catch (Exception e){
//            BasePage.failTest(e, "FAIL submit_MembersForm ...!", true );
//        }
//
//    }
//
//
//
//
//
//    protected static String tabLinkText ;
//    protected static int    tabId = 1;
//    protected static String confirPPWeId = "form_tabctrl_tab-1_button";//form_tabctrl_tab-0_button
//    //pp fr
//    protected static String payPalAuthorizeId = "PayPalAuthorized";
//    protected static String submitToPpId = "btnLogin";// "submitLogin";
//    protected static Map payPalDataMap= EfConstants.payPalFr;
//    protected static String continuePayPalId = "confirmButtonTop"; //"continue";
//    protected static String payPalLoginFrameName = "injectedUl";
//
//}
