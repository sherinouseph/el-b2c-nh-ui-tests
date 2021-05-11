package com.englishtown.util.db.test;
/**
 *
 * Created by nikol.marku on 10/11/2015.
 * Connect to DB ; update run table  with test date
 * open URLs   update TestRun Table with url load time
 * Note: TODO : need to decide what data to store when test fail and how to calculate the averages when some of the test fails or no data entered in DB
 *
 */
import com.englishtown.dataprovider.UrlMonitoringDataProvider;
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.ChromeRemoteWebDriver;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.util.db.core.DbManager;

import com.englishtown.util.db.core.ExcelReportPeriod;
import com.englishtown.util.db.testdbbean.TestBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.sql.Date;


public abstract class BaseUrlMonitorStatsTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseUrlMonitorStatsTest.class);
    protected static String note="";
    protected static Date date;
    protected static ExcelReportPeriod period;
    protected static boolean isFirstRun = true;
    protected static boolean isDestroyBrowserForEachTest = true; // to get more realistic data stats ... distroy browser and reopen new one
    protected WebDriver webDriver;

    @Test(dataProvider = "monitorUrlsBeam", dataProviderClass = UrlMonitoringDataProvider.class)
    protected void openTestUrlUpdateDBwithPageLoadTime(TestBean testBean ) {
        int count = 0;

        try {
            logger.info("\nTest open URL [{}]....!  ", testBean.getUrl());
            if (isDestroyBrowserForEachTest) {
                executBeforeEachTest();
            }
            //openUrl(getWebDriver(), testBean.getUrl(), -1);
            TestUtil.getPageLoadTimings (getWebDriver(), testBean.getUrl());
            if (count == 0) {
                isFirstRun = false;
            }
            count++;
            logger.info("\nUpdate DB ....! Table Name : TestRun ...! with DATA:  \ngetCurrentRunId() :" + DbManager.getCurrentRunId() + "\n" +
                    "pageLoadTime : " + TestUtil.pageLoadTime + "\nTest ID : " + testBean.getId());
            if (isDestroyBrowserForEachTest) {
                executeAfterEachTest();
            } else {
                CookieHandler.safeDeleteCookies(getWebDriver(), 1);
            }
        }finally{
            logger.info("TestUtil.isOpenURLException :"+TestUtil.isOpenURLException);
            if(!TestUtil.isOpenURLException) {
                logger.info("Load time added to Batch job ...! Load time : "+TestUtil.pageLoadTime);
                DbManager.setSqlTestRunAndAdditToBatchPstmt(
                        DbManager.getPstmt(), DbManager.getCurrentRunId(), testBean.getId(), TestUtil.pageLoadTime,
                        TestUtil.performanceTimingBean.getNavigationStart(), TestUtil.performanceTimingBean.getConnectStart(),
                        TestUtil.performanceTimingBean.getRequestStart(), TestUtil.performanceTimingBean.getResponseStart(),
                        TestUtil.performanceTimingBean.getDomLoading(), TestUtil.performanceTimingBean.getDomInteractive(),
                        TestUtil.performanceTimingBean.getDomComplete(), TestUtil.performanceTimingBean.getLoadEventEnd(),
                        TestUtil.performanceTimingBean.getNetworkLatency(), TestUtil.performanceTimingBean.getPageLoadOnceReceivedFromServer(),
                        TestUtil.performanceTimingBean.getTimeToDomInteractive(), TestUtil.performanceTimingBean.getTimeToDomComplete(),
                        TestUtil.performanceTimingBean.getDomCompleteProcessingTime()
                );

            }else {
                logger.info("Load time is NOT added to Batch job ...! Load time : "+TestUtil.pageLoadTime);
            }
        }
    }
/*
    @Test(dataProvider = "monitorUrls", dataProviderClass = UrlMonitoringDataProvider.class)
    protected void openTestUrlUpdateDBwithPageLoadTime(int testId, String url ) {
        int count = 0;

        try {
            logger.info("\nTest open URL [{}]....!  ", url);
            if (isDestroyBrowserForEachTest) {
                executBeforeEachTest();
            }
            TestUtil.getPageLoadTimings (getWebDriver(), url); //openUrl(getWebDriver(), url, -1);
            if (count == 0) {
                isFirstRun = false;
            }
            count++;
            logger.info("\nUpdate DB ....! Table Name : TestRun ...! with DATA:  \ngetCurrentRunId() :" + 0000000000+ "\n" + //DbManager.getCurrentRunId()
                    "pageLoadTime : " + TestUtil.pageLoadTime + "\nTest ID : " + testId);
            if (isDestroyBrowserForEachTest) {
                executeAfterEachTest();
            } else {
                CookieHandler.safeDeleteCookies(getWebDriver(), 1);
            }
        }finally{
            logger.info("TestUtil.isOpenURLException :"+TestUtil.isOpenURLException);
            if(!TestUtil.isOpenURLException) {
                logger.info("Load time added to Batch job ...! Load time : "+TestUtil.pageLoadTime);
                //DbManager.setSqlTestRunAndAdditToBatchPstmt(DbManager.getPstmt(), DbManager.getCurrentRunId(), testId, TestUtil.pageLoadTime);            // replaced with batch above DbManager.insert_TestRun_TestData(DbManager.INSERT_INTO_TESTRUN_SQL, DbManager.getCurrentRunId(), testId, TestUtil.pageLoadTime);
            }else {
                logger.info("Load time is NOT added to Batch job ...! Load time : "+TestUtil.pageLoadTime);
            }
        }
    }
    */

    /**
     * To get more realistic the
     */
    void executBeforeEachTest(){
        logger.info("BeforeEachTest  create driver...!");
        BaseRemoteWebDriver.isSetTimeout = false;
        if(isFirstRun){
            logger.info("First Time run ...!");
        }else {
            try {
                webDriver = new ChromeRemoteWebDriver();
            }catch (Exception we){
                TestUtil.isOpenURLException = true;
                we.printStackTrace();
                logger.error("Failed to create ChromeRemoteWebDriver., will try to create local ChromeDriver ...!"+we.getMessage());
                try{
                    webDriver = new ChromeDriver();
                }catch (WebDriverException wec){
                    TestUtil.isOpenURLException = true;
                    wec.printStackTrace();
                    //logger.error("Failed to create local (Not using grid) ChromeDriver ...!");
                    BasePage.failTest("Could not create local (Not using grid) ChromeDriver  driver ...!");
                }catch (Exception e){
                    TestUtil.isOpenURLException = true;
                    e.printStackTrace();
                    logger.error("Failed to create ChromeDriver ...!");
                    BasePage.failTest("Could not create Chrome  driver ...!"+e.getMessage());
                }
            }
        }
//        if(!isFirstRun){BaseRemoteWebDriver.destroyDriver(getWebDriver());}
    }

    void executeAfterEachTest(){
        logger.info("AfterTest delete cookies ...!");
        //CookieHandler.safeDeleteCookies(getWebDriver(), 1);
        if(!isFirstRun){BaseRemoteWebDriver.destroyDriver(getWebDriver());}
    }

}






/**
 * Init DB connection and update RUN table and setup current runId
 */
//    @BeforeClass
//    void setupConnectToDBupdateRunTable(){
//        DbManager.connectToDB();
//        period = ExcelReportPeriod.LAST_WEEK;
//        date = new Date(new java.util.Date().getTime());
//        logger.info("Update DB ....! : Table Name : RUN :> "+date ) ;
//        DbManager.insert_Run_TestData(DbManager.INSERT_INTO_RUN_SQL, date, note);
//        // used for batch processing
//        DbManager.setAutoCommit(false);
//        DbManager.createPrepareStatement(DbManager.INSERT_INTO_TESTRUN_SQL);
//
//    }


/**
 * Execute batch sql insert test run result
 */
//    @AfterClass
//    void executeBatchStmpt(){
//        DbManager.executeBatchPstmtAndCommit(DbManager.getPstmt());
//        DbManager.closeAllDBthreads();
//    }











/**
 * Store test data to DB and Close all connections, resources, nullify Objects
 */
//    @AfterClass
//    void tearDownCloseAll() {
//        if(isGenerateExcel) {
//            ReadWriteToFile.createStatsCsvFromDB(DbManager.getUrlMonitoringStatistics(DbManager.SELECT_MONIT_STATS_DATA_SQL));
//        }
//        //email excel file
//        try {
//            File csvFile = new File(ReadWriteToFile.statisticsFile);
//            Date date = new Date(System.currentTimeMillis());
//            if(isSendMail) {
//                SendMail.sendMail("nikol.marku@ef.com", "[" + date + "] Latest Monitoring Stats .", " Dear Subscriber, \n\n " +
//                        "Find Attached Latest Monitoring Statistics.\n\n" +
//                        "Kind Regards\nNiko\n\n EnglishLive QA Engineer", csvFile);
//            }
//        }catch (Exception e){
//            logger.error(" File not created ...! so no email is sent...!");
//        }
//
//        DbManager.closeAllDBthreads();
//    }