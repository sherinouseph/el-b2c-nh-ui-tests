//package com.englishlive.tests.misc.rola;
///**
// * Open  URL
// * check page source contains text 'text...'
// * on -> page source
// * on -> a tags
// * on -> src tags
// * Note : need to set domain and country when creating URL domain+country+url from map
// * https://jira-bos.englishtown.com/browse/SAND-2488
// */
//
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.dataprovider.bin.UrlBean;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.core.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//
//public class CheckPageContainsNglishtownTextTest extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(CheckPageContainsNglishtownTextTest.class);
//    //@Value("#{applicationPropertiesList['cl.url']}")
//    private String testUrl = "englishlive.ef.com/es-mx/"; //="englishlive.ef.com/es-co/ ";    //TO DO url should be based on ENV test run- qa etc    //protected static String urlFirstPart ="http://";
//    private String countryFolder = "";
//    protected String url  ;
//    private String ctr ="ctr=mx"; //ar
//
//    protected static String containingText ="nglishlive"; //"nglishtown";
//    protected static List<WebElement> allTextList = null;
//    protected static List<WebElement> titleList = null;
//    protected static List<WebElement> hrefList = null;
//    protected static List<String> titleListGetTitle = null;
//    protected static String currentURL = null;
//    protected static String currentURLDescription = null;
//    protected static List<WebElement> srcList  = null;
//
//    protected static int TEST_COUNT =0;
//    protected static int TEST_ENDCOUNT =0;
//    protected static int TOTAL_MATCH_COUNT =0;
//
//
//    @Test(dataProvider = "noDomainAllUrlListMap", dataProviderClass = UrlDataProvider.class)
//    void openUrl_Check_PageSource_href_src_Contains_nglishtown(UrlBean urlBean) {
//        TEST_COUNT++;                                                                                                     //for(UrlBean urlBean : UrlDataProvider.getUrlBeanList(EfConstants.ROLA_ALL_LINKS_URLS) ) {
//        try {            //if(TEST_COUNT==1){ //first time open homepage }else {
//            url = UrlMapper.mapBaseUrlToELive(getBASEURL())+testUrl + urlBean.getUrl()+ctr;
//            currentURL= url;
//            currentURLDescription = urlBean.getDescription();
//            logger.info("\n-----------------------------------------------------------------------------------");
//            openUrl(getWebDriver(), url);
//            sleep(3000);
//            //Search page source
//            allTextList = getWebDriver().findElements(By.xpath("//*[contains(text(),'"+containingText+"')]"));
//            titleList   = getWebDriver().findElements(By.xpath("//title[contains(text(),'"+containingText+"')]"));
//            hrefList    = getWebDriver().findElements(By.cssSelector("*[href*='"+containingText+"']"));
//            srcList     = getWebDriver().findElements(By.cssSelector("*[src*='"+containingText+"']"));
//            logger.info("Page Title is : " + getWebDriver().getTitle());
//        } catch (WebDriverException we) {
//            logger.error("WebDriverException  " + TestUtil.getException(we));
//        }
//        TestUtil.webElementContainText(allTextList, containingText, currentURL, currentURLDescription);
//        TestUtil.webElementContainText(titleList, containingText, currentURL, currentURLDescription) ;
//        TestUtil.webElementContainText(hrefList, containingText, currentURL, currentURLDescription);
//        TestUtil.webElementContainText(srcList, containingText, currentURL, currentURLDescription) ;
//        /*try{ checkSourceCodeContainsTextTest();  }catch (AssertionError ae){logger.error("checkSourceCodeContainsTextTest Failed ...!");}        try{ checkAllTextListSizeTest();         }catch (AssertionError ae){logger.error("checkAllTextListSizeTest Failed ...!");}
//        try{ checkHrefListSizeTest();            }catch (AssertionError ae){logger.error("checkHrefListSizeTest Failed ...!");}        try{ checkAllTitlteListSizeTest();       }catch (AssertionError ae){logger.error("checkAllTitlteListSizeTest Failed ...!");}
//        try{ checkSrcListSizeTest();             }catch (AssertionError ae){logger.error("checkSrcListSizeTest Failed ...!");}*/
//        checkSourceCodeContainsTextTest();
//        checkAllTextListSizeTest();
//        checkHrefListSizeTest();
//        checkAllTitlteListSizeTest();
//        checkSrcListSizeTest();
//        TEST_ENDCOUNT++;
//    }
//
//    void checkSourceCodeContainsTextTest() {
//        logger.info("checkSourceCodeContainsTextTest run test on url :" + url);
//        AssertHelper.myAssertThat(getWebDriver(), "isSourceContainsText() found text on source code ...!",
//                !TestUtil.isPageSourceContainsText(getWebDriver(), containingText), false);
//    }
//    void checkAllTextListSizeTest() {
//        logger.info("checkAllTextListSizeTest run test on url :"+url);
//        AssertHelper.myAssertThat(getWebDriver(),"check_AllTextLisSizeTest is greater than Zero - text found ",
//                allTextList.size() <= 0, true);
//    }
//    void checkAllTitlteListSizeTest() {
//        logger.info("checkAllTitlteListSizeTest run test on url :"+url);
//        AssertHelper.myAssertThat(getWebDriver(),"checkAllTitlteListSizeTest is greater than Zero - text found ",
//                titleList.size() <= 0, true);
//    }
//    void checkHrefListSizeTest() {
//        AssertHelper.myAssertThat(getWebDriver(),"check_HrefListSizeTest is greater than Zero - text found ",
//                hrefList.size() <= 0, true);
//    }
//    void checkSrcListSizeTest() {
//        AssertHelper.myAssertThat(getWebDriver(),"check_SrcLisSizeTest is greater than Zero - text found ",
//                srcList.size() <= 0, true);
//    }
//
//    @AfterMethod
//    void updateCountMatchFound(){
//        TOTAL_MATCH_COUNT = TOTAL_MATCH_COUNT + allTextList.size();
//        logger.info("\n\nTOTAL_MATCH_COUNT Total match so far : "+TOTAL_MATCH_COUNT+"\n\n");
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        logger.info("\n\nTOTAL_MATCH_COUNT : "+TOTAL_MATCH_COUNT+"\n\n");
//        if(TEST_COUNT - TEST_ENDCOUNT == 0){
//            logger.info("\n\n\t\tAll test passed ...!\n\n");
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT+" - Test Failure :" +(TEST_COUNT - TEST_ENDCOUNT)+"\n\n");
//        }
//    }
//
//
//}