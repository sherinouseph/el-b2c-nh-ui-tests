package com.englishlive.tests.galen.core;
/**
 * Created by nikol.marku on 10/26/2016.
 *
 * GalenJavaTestBase
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.support.GalenReportsContainer;
import com.galenframework.testng.GalenTestNgTestBase;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.lang.reflect.Method;
import java.util.List;


@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@Configuration

public abstract class BaseGalenConfig extends GalenTestNgTestBase implements IGalen{
    private static final Logger logger = LoggerFactory.getLogger(BaseGalenConfig.class);

    protected String testUrl;
    protected String gspecPath;
    protected String gspecFileName ;
    protected static Dimension screenSize;  // screen size
    protected WebDriver driver ;
    protected MyBrowserType driverType;
    private static String galenTestEnvironment = "live"; //  or qa or staging setup from maven or live by default +System.getProperty("galen.test.env")
    public static String baseUrl ;
    private static final String HTTP_PROTOCOL = "https";
    protected LayoutReport layoutReport;  // used for reporting
    protected List<GalenTestInfo> tests;
    protected GalenTestInfo test;
    protected static final String GALEN_REPORTS_DIR = "target/galen-html-reports/";
    protected String currentRunningMethod;


    @Override
    public WebDriver createDriver(Object[] args) {
//        failTestPerEnvironment(this.getTestUrl());

        if(driverType == null){
            driverType = MyBrowserType.CHROME;
            logger.info("Set default browser type [ "+driverType+" ]...!");
        }
        logger.info("Set Grid and Create Driver :[ "+driverType.getBrowser()+" ]");
        BaseTest.setGridEnvironmentFromDargs();
        BaseRemoteWebDriver.setHubUrl(BaseTest.getGridEnvironment());
        DriverManager.createDriver(driverType, 20);
        driver = DriverManager.getDriver();

        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof TestDevice) {
                TestDevice device = (TestDevice)args[0];
                    if (driver.manage().window().getSize() != null) {
                        driver.manage().window().setSize(device.getScreenSize());
                    }
            }
        }
        return driver;
    }

    public void load(String uri) {
        getDriver().get(testUrl + uri);
        TestUtil.mySleep(1000);

    }

    protected void setTestUrl(String url){
        this.testUrl = url;
    }

    protected void setGspec(String gspecFilename){
        String userDir =  System.getProperty("user.dir");
        this.gspecPath = userDir+GALEN_SPEC_LOCATION+gspecFilename;
    }
    protected String getGspec() {
        return gspecPath;
    }

    protected void setScreenSize(Dimension screenSize){
        this.screenSize = screenSize;
    }
    protected String getTestUrl() {
        return testUrl;
    }



    protected Dimension getScreenSize() {
        return screenSize;
    }

    protected void printSetup(){
        logger.info("*************************************************");
        logger.info("Test URL   \t:[ "+testUrl+" ]");
        logger.info("Test GSpec \t:[ "+getGspec()+" ]");
        logger.info("Test Browser\t:[ "+getDriverType()+" ]");
        //logger.info("Screen Size\t:[ "+screenSize.toString()+" ]");
        logger.info("*************************************************");
    }

    public static void sleep(int mls){
        logger.info("Sleeping for [ "+mls+" ]");
        try{   Thread.sleep(mls); }catch (InterruptedException i){}
    }


    public MyBrowserType getDriverType() {
        return driverType;
    }

    public void setDriverType(MyBrowserType driverType) {
        logger.info("SetDriverType to :"+driverType);
        this.driverType = driverType;
    }

    public void setupGalenTestData(MyBrowserType browserType, String testUrl, String testGspecFilename){
        this.setDriverType(browserType);
        this.setTestUrl(testUrl);
        this.setGspec(testGspecFilename);
    }
    public void setupGalenTestData( String testUrl, String testGspecFilename){
        this.setTestUrl(testUrl);
        this.setGspec(testGspecFilename);
    }


    public void failTestPerEnvironment(String url){
        if(url !=null && StringUtils.contains(url,"//qa-")){
            BasePage.failTest("This test is set to FAIL FOR  QA, This Test is set to Run only live Environment'");
        }
    }

    public static String getGalenTestEnvironment() {
        return galenTestEnvironment;
    }

    public static void setGalenTestEnvironment(String galenTestEnvironment) {
        galenTestEnvironment = galenTestEnvironment;
    }

    public static void initGalenTestEnvFromSysProps(){
        try {
            String tmpEnv = System.getProperty("galen.test.env");
            if(null != tmpEnv) {
                galenTestEnvironment = tmpEnv;
            }
            logger.info("galenTestEnvironment :"+galenTestEnvironment);
        }catch (Exception e){
            logger.error("Could not init galenTestEnvironment from SysProperties;  Exception : "+e.getMessage());
        }
    }

    /**
     *  Set Base url from maven
     *  getGalenTestEnvironment()
     */
    public static void setBaseUrl(String galenTestEnvironment){
        switch (galenTestEnvironment){
            case "live":
                baseUrl = HTTP_PROTOCOL + "://";
                break;
            case "qa":
                baseUrl = HTTP_PROTOCOL + "://qa-";
                break;
            case "staging":
                baseUrl = HTTP_PROTOCOL + "://stg-";
                break;
            default:
                logger.error("Invalid Environment { "+galenTestEnvironment+"]");
                break;
        }
        logger.info("Base url is :"+baseUrl);
    }

    public static String getBaseUrl(){
        initGalenTestEnvFromSysProps();
        setBaseUrl(getGalenTestEnvironment());
        return baseUrl;
    }


}

