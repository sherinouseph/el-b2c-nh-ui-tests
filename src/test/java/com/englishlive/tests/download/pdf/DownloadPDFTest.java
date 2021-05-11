//package com.englishlive.tests.download.pdf;
///**
// * open url click to
// * Download pdf file directly and check  page and response = 200;
// *
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
//import com.englishtown.driver.FirefoxOnWinRemoteWebDriver;
//import com.englishtown.helpers.*;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Set;
//
//import static org.hamcrest.CoreMatchers.containsString;
//
//// ff only test
//public class DownloadPDFTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(DownloadPDFTest.class);
//    @Value("#{applicationPropertiesList['co.pdf.test.url']}")
//    private String testUrl;
//    protected String checkContent = "NOT_INIT";
//    protected String currentUrl;
//    protected String urlContains = ".pdf?";
//    protected String downloadPdfBtnCss = ".column1 h2 a";    //"a.btn"
//    protected String pdfPageFileContentToCheckCss = ".pdfViewer #pageContainer2 .textLayer";
//    protected String pdfPageHtmlContentToCheckCss = "#viewerContainer .pdfViewer"; //"a[title=\"http://englishlive.ef.com:nth-of-type(1)\"]";
//    String parentHandle ;
//    WebDriver driver;
//
//    @BeforeClass
//    private void setup(){
//        logger.info("User firefox for this test all the time as Webdriver can not focus on pdf tab on chrome ...!");
//        try{
//            driver  = new FirefoxOnWinRemoteWebDriver();
//        }catch (Exception e){e.printStackTrace();}
//        setWebDriver(driver);
//
//        openUrl(getWebDriver(), testUrl);
//    }
//
//    @Test
//    void clickDownloadButton() {
//        WebElement downloadBtn = findElement(By.cssSelector(downloadPdfBtnCss) );
//        click(downloadBtn);
//        sleep(7000);
//    }
//
//    @Test(dependsOnMethods = "clickDownloadButton")
//    void checkPdfPageShowsHtmlContent() {
//        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
//        WebDriverWindowHelper.switchToWindow(getWebDriver(), 1);
//        sleep(1000);
//        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pdfPageHtmlContentToCheckCss) ), getWebDriver(), 15);
//    }
//
//    @Test(dependsOnMethods = "clickDownloadButton")
//    void checkPdfPageShowsPdfContent() {
//        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pdfPageFileContentToCheckCss) ), getWebDriver(), 5);
//    }
//
//    @Test(dependsOnMethods = "checkPdfPageShowsPdfContent")
//    void checkCurrentURL() {
//        currentUrl = getWebDriver().getCurrentUrl(); //ef-english-live-vocabulario.pdf?v=AVQx/XgH
//        logger.info("current url is : "+currentUrl);
//        AssertHelper.assertThat("Current url ["+currentUrl+" Does not contain ["+urlContains+" ...!", currentUrl, containsString(urlContains));
//    }
//
//    @AfterTest
//    void testTearDown(){
//        try {
//            driver.quit();
//        }catch (Exception e){e.printStackTrace();}
//    }
//}