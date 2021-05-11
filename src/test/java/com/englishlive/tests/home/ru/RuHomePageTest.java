//package com.englishlive.tests.home.ru;
//
////New russian website - sherin - 20/04/2018
//
////go to home page.check login button
////click consultation button
////click two buttons in the consultation page and click on them and verify if it is going to the correct page
////Submit the form after clicking on the second get button and see if you get a thank you page
////Submit form for the first Get button - completed in another test(ruconsultationtest)
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//
//import com.englishtown.pages.common.core.PriceAndPackagekPage;
//import com.englishtown.tests.core.BaseTest;
//import com.englishtown.tests.core.BaseTestHelper;
//
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//Karim told to remove this test..only consulation test is required
//
//public class RuHomePageTest extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(RuHomePageTest.class);
//
//    @Value("#{applicationPropertiesList['home.ru.ru.url']}")
//    private String testurl;
//
//    protected String consulationurl;
//
//
//    @BeforeClass
//    void setupBeforeClass(){
//        setThreadSafeDriver();
//        testStartUrl=testurl;
//        openUrl(getWebDriver(),testStartUrl);
//        setLanguageAndMarket("ru","ru");
//        formDataMap = EfConstants.ruFreeConsultationFormMap;
//        urlContainsThankyou = "thank-you";
//
//    }
//
//
//    @Test
//    public void ensurePageIsValidForTheUrl() {
//        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"ef.ru/englishlive","url incorrect");
//       AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.cssSelector("[href*='englishlive/login']")));
//    }
//
//    @Test(dependsOnMethods = "ensurePageIsValidForTheUrl")
//    public void checkMarketTest(){
//        assertStateObjectElementValue("page.market",getMarket(),true);
//    }
//
//    @Test(dependsOnMethods = "checkMarketTest")
//    public void checkLanguageTest(){
//        assertStateObjectElementValue("page.language",getLanguage(),false);
//    }
//
//    @Test(dependsOnMethods = "checkLanguageTest")
//    public void click_ConsultationButton(){
//        logger.info("click_ConsultationButton");
//        click(findElements(By.cssSelector("button.btn-primary")).get(0));
//        consulationurl= TestUtil.getCurrentUrl(getWebDriver());
//        AssertHelper.assertUrlContains(consulationurl,"study-plans-and-prices/","url incorrect");
//    }
//
//    @Test(dependsOnMethods = "click_ConsultationButton")
//    public void clickGetButton_package1(){
//        logger.info("clickGetButton_package1");
//        click(findElements(By.cssSelector("button.btn-primary")).get(0));
//        AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.name("city")));
//    }
//
//    @Test(dependsOnMethods = "clickGetButton_package1")
//    public void clickGetButton_package2(){
//        logger.info("open url again and clickGetButton_package2");
//        openUrl(getWebDriver(),consulationurl);
//        WaitTool.waitForElementClickable(getWebDriver(),By.cssSelector("button.btn-secondary"),30);
//        click(findElements(By.cssSelector("button.btn-secondary")).get(0));
//        AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.name("city")));
//    }
//
//    @Test(dependsOnMethods = "clickGetButton_package2")
//    public void enterDetailsAndSubmitForm(){
//        logger.info("enterDetailsAndSubmitForm");
//        WaitTool.waitForElementClickable(getWebDriver(),By.cssSelector(".form-submit"),30);
//        enterFormData(formDataMap);
//        logger.info("submit the form");
//        click(findElement(By.cssSelector((".form-submit"))));
//        assertIsUrlContaining(urlContainsThankyou);
//    }
//
//    @AfterClass
//    protected void tearDownAfterClass(){
//        destroyDriver();
//    }
//
//}
