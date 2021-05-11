//package com.englishlive.tests.nogrid.proxy.landinghandler;
///**
// * Open es-wws/?ctr=ar
// * change country to pe
// * submit form
// * Locale should be pe on landinghandler post data
// *
// */
//import com.englishlive.tests.nogrid.proxy.BaseLandingHandlerTest;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.reader.MyJsonReader;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
// // todo jbroser proxy form changed need to use selectors F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS and enterformdataCss

//public class PeWwsLandingHandlerTest extends BaseLandingHandlerTest {
//    private static final Logger logger = LoggerFactory.getLogger(PeWwsLandingHandlerTest.class);
//    @Value("#{applicationPropertiesList['home.es.ar.url']}")
//    protected String currTestUrl;
//
// ////TODO fix form css popup
//    @BeforeClass
//    public void setupTestDataOpenUrl(){
//        setupJBorwserProxyDriver(currTestUrl); //setUpProxy();
//        testDataMap =  EfConstants.F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP;
//        userName = (String)testDataMap.get("email");
//        expectedPostData = MyJsonReader.getEfFullDataBeanFromJsonFile(MyJsonReader.getEfBeanJasonFilePath());                   // new BasicPostDataHandler((String)testDataMap.get("first_name"),(String)testDataMap.get("email"), "oe","pe" ); //("testPostData","db1_" + System.currentTimeMillis() + "@qp1.org","oe","pe" );
//        expectedPostData.setEmail(userName);
//        testURL = currTestUrl;
//        isWaitForTyUrl = false;
//        isInlineTyMsg = true;
//        isEnterPhoneNumber = true;
//        thankYouMsgContains = "Muchas gracias por registrate";
//        isSubmitOeFormHandler = true;
//        TestUtil.openUrl(driver, currTestUrl);
//        findElement(driver, By.cssSelector(".popup-offer-and-form-content.section"));
//        JavaScriptHelper.clickAtWindowXY(driver, 6, 7);
//
//
//    }
//
//}
//
//
//
////enterFormData(driver, EfConstants.LNAME_CTR_STATE_TEL_EDGE_MAP);
//          /*
//        WaitTool.waitForElementVisible(driver, By.name("country"), 7);
//        WaitTool.waitForCondition( ExpectedConditions.elementToBeClickable(By.name("telephone")), driver, 20 );
//        WebElement phoneWe = findElement(driver, By.name("telephone"));
//        WebElementHelper.sendKeyWithWait(phoneWe, "22334454", 100);*/
//
//
///*select(driver, By.id("country"), selectCountryValue, null );
//        sleep(500);
//        select(driver, By.id("location-state"), "amazonas", null );
//        sleep(500);
//        select(driver, By.id("age"), "21-25", null );
//        sleep(1000);
//        WaitTool.waitForElementVisible(driver, By.id("country"), 7);
//        WebElementHelper.sendKeys(driver, findElement(driver, By.id("last_name")), "Lname" , false);
//        WaitTool.waitForCondition( ExpectedConditions.elementToBeClickable(By.id("telephone")), driver, 20 );
//        WebElement phoneWe = findElement(driver, By.id("telephone"));
//        WebElementHelper.sendKeyWithWait(phoneWe, "22334454", 100);
//        sleep(300);
//        */