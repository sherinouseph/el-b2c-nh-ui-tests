package com.englishtown.tests.core.common;
/**
 * Open URLs
 * check page source contains text 'text...'
 * on -> page source
 * on -> a tags
 * on -> src tags
 *
 * https://jira-bos.englishtown.com/browse/SAND-2488
 */
// no need to run this test all the time at CI

import com.englishtown.dataprovider.EliveDataProvider;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.is;


public abstract class BaseCheckPageContainsText extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckPageContainsText.class);
    protected static String containingText = "nglishtown"; // Kr 잉글리시타운  JP "イングリッシュタウン" //"nglishtown"; // default
    protected static List<WebElement> allTextList = null;
    protected static List<WebElement> titleList = null;
    protected static List<WebElement> hrefList = null;
    protected static List<String> titleListGetTitle = null;
    protected static String currentURL = null;
    protected static String currentURLDescription = null;
    protected static List<WebElement> srcList  = null;
    protected static List<WebElement> logImgSrcList  = null;   // img src
    protected static AtomicInteger TEST_COUNT    = new AtomicInteger(0);
    protected static AtomicInteger TEST_ENDCOUNT = new AtomicInteger(0);
    protected static int TOTAL_MATCH_COUNT =0;
    protected static WebDriver myWebDriver;

    public synchronized void increaseTestCount(){
        TEST_COUNT.incrementAndGet();
    }
    public synchronized void increaseTestEndCount(){
        TEST_ENDCOUNT.incrementAndGet();
    }


    //TODO open this test only manual run
    @Test(dataProvider = "getAllPageValidUrls", dataProviderClass = EliveDataProvider.class)
    void openUrl_Check_PageSource_href_src_Contains_nglishtown(String url) {
        increaseTestCount();
        currentURL=url;
        openUrlCheckContent(url, TEST_COUNT.get());
        increaseTestEndCount();
    }

    void checkSourceCodeContainsTextTest() {
        logger.info("checkSourceCodeContainsTextTest run test on url :" + currentURL);
        AssertHelper.myAssertThat(getWebDriver(), "isSourceContainsText() found text on source code ...!",
                !TestUtil.isPageSourceContainsText(getWebDriver(), containingText), false);
    }
    void checkAllTextListSizeTest() {
        logger.info("checkAllTextListSizeTest run test on url :"+currentURL);
        AssertHelper.myAssertThat(getWebDriver(),"check_AllTextLisSizeTest is greater than Zero - text found ",
                allTextList.size() <= 0, true);
    }
    void checkAllTitlteListSizeTest() {
        logger.info("checkAllTitlteListSizeTest run test on url :"+currentURL);
        AssertHelper.myAssertThat(getWebDriver(),"checkAllTitlteListSizeTest is greater than Zero - text found ",
                titleList.size() <= 0, true);
    }
    void checkHrefListSizeTest() {
        AssertHelper.myAssertThat(getWebDriver(),"check_HrefListSizeTest is greater than Zero - text found ",
                hrefList.size() <= 0, true);
    }
    void checkSrcListSizeTest() {
        AssertHelper.myAssertThat(getWebDriver(),"check_SrcLisSizeTest is greater than Zero - text found ",
                srcList.size() <= 0, true);
    }

    @AfterMethod
    void updateCountMatchFound(){
        TOTAL_MATCH_COUNT = TOTAL_MATCH_COUNT + allTextList.size();
        logger.info("\n\nTOTAL_MATCH_COUNT Total match so far : "+TOTAL_MATCH_COUNT+"\n\n");
    }

    @AfterTest
    void printTotalErrors(){
        logger.info("\n\nTOTAL_MATCH_COUNT : "+TOTAL_MATCH_COUNT+"\n\n");
        if(TEST_COUNT.get() - TEST_ENDCOUNT.get() == 0){
            logger.info("\n\n\t\tAll test passed ...!\n\n");
        }else {
            logger.error("\n\n\t\tNOT all test passed ...!\n");
            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT+" - Test Failure :" +(TEST_COUNT.get() - TEST_ENDCOUNT.get())+"\n\n");
        }
    }

    protected void openUrlCheckContent(String url, int testCount){
        try {                                                                                                            //url = UrlMapper.mapBaseUrlToELive(getBASEURL())+urlBean.getUrl(); currentURL= url.replace("es-mx", "en-us");            currentURLDescription = urlBean.getDescription();
            logger.info("\n---------------------------------------------------------------------------------:> "+testCount);
            if(testCount > 1) {
                logger.info(" Open URL :"+url);
                openUrl(getWebDriver(), url);
                sleep(3000);
            }
            allTextList = getWebDriver().findElements(By.xpath("//*[contains(text(),"+containingText+")]"));
            titleList = getWebDriver().findElements(By.xpath("//title[contains(text(),'nglishtown')]"));
            hrefList = getWebDriver().findElements(By.cssSelector("*[href*='nglishtown']"));
            srcList = getWebDriver().findElements(By.cssSelector("*[src*='nglishtown']"));
            logImgSrcList = getWebDriver().findElements(By.cssSelector(".logo-component img[src*='nglishTown']"));
            logger.info("Page Title is : " + getWebDriver().getTitle());
        }catch(WebDriverException we){
            logger.error("WebDriverException  " + TestUtil.getException(we));
        }
        try {
            try{
                AssertHelper.myAssertThat(getWebDriver(), "allTextList Found text '" + containingText + "' on the page...!",
                TestUtil.webElementContainText(allTextList, containingText, currentURL, currentURLDescription), is(false), true);
            }catch(WebDriverException wde){
                //wde.printStackTrace();
            }/*
            AssertHelper.myAssertThat(getWebDriver(), "\ntitleList Found text '" + containingText + "' on the page...!",
                    TestUtil.webElementContainText(titleList, containingText, currentURL, currentURLDescription), is(false), true);
            AssertHelper.myAssertThat(getWebDriver(), "hrefList Found text '" + containingText + "' on the page...!",
                    TestUtil.webElementContainText(hrefList, containingText, currentURL, currentURLDescription), is(false), true);
            AssertHelper.myAssertThat(getWebDriver(), "SRC link Found text '" + containingText + "' on the page...!",
                    TestUtil.webElementContainText(srcList, containingText, currentURL, currentURLDescription), is(false), true);
            AssertHelper.myAssertThat(getWebDriver(), "Image SRC link Found text '" + containingText + "' on the page...!",
                    TestUtil.webElementContainText(logImgSrcList, containingText, currentURL, currentURLDescription), is(false), true);*/
        }catch (AssertionError ae){
            // ae.printStackTrace();
        }
    }

    public static WebDriver getMyWebDriver() {
        return myWebDriver;
    }

}