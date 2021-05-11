package com.englishtown.tests.core;
/**
 * Created by nikol.marku on 05/05/2016.
 *
 * Use this if you don't need the selenium grid and all the helper methods [see BaseTestConfig]
 *
 * e.g For headless tests and shared resources
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.enumpack.GridEnvironment;
import com.englishtown.exception.WebDriverNotInitialisedException;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.core.EnglishtownStateObject;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;


@ContextConfiguration(locations = {"/applicationContext-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@Configuration
public abstract class SimpleBaseTest extends AbstractTestNGSpringContextTests implements IBaseTest { // ISimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SimpleBaseTest.class);
    //@Resource(name="driver")
    protected WebDriver myWebDriver;  // driver passed as params from spring profiles on command line
    @Value("#{applicationPropertiesList['env.id']}")
    public String ENVIRONMENT;
    @Value("#{applicationPropertiesList['base.url']}")
    public String BASE_URL;

    protected WebDriver htmlUnitDriver;
    protected WebDriver chrome ; // local driver
    //protected static WebDriver myWebDriver;
    protected String testUrl;
    protected String browserName;
    protected long startTime;
    protected long endTime;
    protected String mTestCaseName = "";   // use this to show the method name when data provider used
    protected String market;
    protected AtomicInteger TEST_COUNT    = new AtomicInteger(0);
    protected AtomicInteger TEST_ENDCOUNT = new AtomicInteger(0);


    @BeforeSuite  // was test 1* runs before class annotation
    public void baseSetUp(){
        logger.info("setUp BeforeSuite ...!");
        startTime = System.currentTimeMillis();
        logger.info("Start Time is : " + startTime);
        setGridEnvironmentFromDargs();
    }

    @AfterSuite //test
    public void baseTearDown(){
        logger.info("tearDown AfterSuite calculateTestEndTime only...!");
        calculateTestEndTime();

        if(getMyWebDriver() != null){
            try {
                getMyWebDriver().quit();
            }catch (WebDriverException e){
                logger.error("Can not quit driver ....! "+e.getCause());
            }
        }

    }

    protected void calculateTestEndTime(){
        try {
            endTime = System.currentTimeMillis();
            logger.info("end Time is : " + endTime);
            float totalTime = endTime - startTime;
            logger.info("Total Time is : " + totalTime + " milliseconds  ...!");
            NumberFormat format = new DecimalFormat("#.####");
            logger.info("Total Time is :" + format.format(totalTime / 1000) + " Seconds ...!");
        }catch (Exception e){e.printStackTrace();}
    }

    protected void destroyDriver(WebDriver driver){
        logger.info("Kill browser :"+driver);
        try{
            if( driver != null) {
                driver.quit();
                logger.info(" ...Browser Destroyed ...!");
            }else{
                logger.info("Don't need to Destroy browser; it is null ...!");
            }
        }catch (Exception e){
            driver = null;
            logger.error("Driver could not be destroyed. Driver .quite throws error :"+e.getMessage());
        }
    }

    protected static WebDriver createLocalThreadDriver(MyBrowserType browserType, int waitTimeSec){
        logger.info("createLocalThreadDriver() :"+browserType.getBrowser());
        DriverManager.createDriver(browserType, waitTimeSec);
        return  DriverManager.getDriver();
    }
//    protected static WebDriver createLocalThreadDriver(String browserName, int waitTimeSec){
//        LocalDriverManager.createDriver(browserName, waitTimeSec);
//        return  LocalDriverManager.getDriver();
//    }

    protected static void destroyLocalThreadDriver(){
        DriverManager.destroyLocalDriver();
    }

    protected static WebDriver getLocalThreadDriver(){
        return DriverManager.getDriver();
    }

    // -----------------  Helpers
    public static void sleep(int sleepTimeMls){
        TestUtil.mySleep(sleepTimeMls);
    }

    public void openUrl(WebDriver driver, String url) {
        TestUtil.openUrl(driver, url);
    }

    public void runTestOnThisEnvironmentOnly(String environment, String message){
        if(getENVIRONMENT() !=null && !getENVIRONMENT().toLowerCase().equals(environment.toLowerCase())){
            BasePage.failTest("This test is set to FAIL FOR '" + getENVIRONMENT()
                    + "' Environment -check other Environments \n" +"Extra info : " +
                    "\n Test set to run only on Environment :"+environment+" \n" + message);
        }
    }

    /**
     * get browser name or return null
     * @param driver
     * @return
     * @throws NullPointerException
     */
    public static String getBrowserName(WebDriver driver)throws NullPointerException{
        logger.info("get Browser name for : "+driver);
        String browsername = null;
        Capabilities cap   = null;

        try {
            cap = ((RemoteWebDriver)driver).getCapabilities();
            browsername = cap.getBrowserName();
        }catch (WebDriverException wde){
            logger.error("Can't get browser name ...! "+wde.getMessage());
        }
        finally {
            return browsername;
        }
    }

    public void failTestIfIsNotBrowser(String browserName, String [] browserNameContains, String message){
        String currentBrowser = getBrowserName();
        int count = 0;
        try{
            for(String browser : browserNameContains) {                                                                 // if (currentBrowser.contains(browserNameContains[0]) || currentBrowser.contains(browserNameContains[1]) || currentBrowser.contains(browserNameContains[2])) {
                if(StringUtils.containsIgnoreCase(currentBrowser, browser) )
                    count ++;
            }
            if(count > 0){
                //run test
            } else {
                BasePage.failTest("Test set to FAIL FOR Browser :'" + currentBrowser + "' -check other Browsers\n" + " Extra info :" + message);
            }
        }catch (Exception e){
            logger.error("failTestIfIsNotBrowser "+TestUtil.getException(e));
        }
    }

    public void initChrome() {
        chrome = createLocalThreadDriver(MyBrowserType.CHROME, 25) ;// LocalWebDriverFactory.getBrowser("chrome", 25);
    }

    public static String getStateObjectPageName(WebDriver driver, int jsTimeoutSec) throws NullPointerException{
        return getStateObjectKeyValue(driver, "page.name", jsTimeoutSec);
    }

    /**
     * Get state object key value
     * @param driver
     * @param key          e.g page.name
     * @param jsTimeoutSec
     * @return double quoted string e.g "page:home"
     * @throws NullPointerException
     */
    public static String getStateObjectKeyValue(WebDriver driver, String key, int jsTimeoutSec) throws NullPointerException{
        String stateObjPageName = "JS could not get page name";
        String script = "var callback = arguments[arguments.length - 1];" +
                        "window.et = window.et || {}; window.et.state = window.et.state || [];" +
                        "et.state.push(null, function(){" +
                        "et.state.get('"+key+"',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })" +
                        "});";
        try{
            stateObjPageName = JavaScriptHelper.executeAsyncScript(script, getLocalThreadDriver(), jsTimeoutSec);
            logger.info("js stateObject Page Name ["+stateObjPageName+"]");                                                                         //stateObjPageName= getStateObjectKeyValue(getLocalThreadDriver(), STATEOBJECT_PAGENAME_KEY, true); //"SalesPages:Home"
            // remove start " and end "
            stateObjPageName = stateObjPageName.replace("\"", "");
            logger.info("js stateObject Page Name removed ticks ["+stateObjPageName+"]");
        }catch (Exception e){
            logger.error("Could not get state object page name ....! "+e.getMessage());
        }

        return stateObjPageName;
    }


    public static String getWebDriverPageTitle(WebDriver driver) throws NullPointerException{
        String pageTitle = "Driver could not get page name";

        try {
            pageTitle = driver.getTitle();
        }catch (WebDriverException e){
            logger.error("Could not get browser page title ....! "+e.getMessage());
        }

        logger.info("WebDriver Page title ["+pageTitle+"]");

        return pageTitle;
    }


    //------------------  SET GET

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public String getENVIRONMENT() {
        return ENVIRONMENT;
    }

    public void setENVIRONMENT(String ENVIRONMENT) {
        this.ENVIRONMENT = ENVIRONMENT;
    }

    public WebDriver getHtmlUnitDriver() {
        return this.htmlUnitDriver;
    }

    public void setHtmlUnitDriver(WebDriver htmlUnitDriver) {
        this.htmlUnitDriver = htmlUnitDriver;
    }

    public WebDriver getChrome() {
        return chrome;
    }

    public void setChrome(WebDriver chrome) {
        this.chrome = chrome;
    }

    public WebDriver getMyWebDriver() {
        return myWebDriver;
    }

    public void setMyWebDriver(WebDriver myWebDriver) {
        myWebDriver = myWebDriver;
    }

    /**
     * Thread safe increase count
     *
     */
    public synchronized void increaseCount(int count){
        count++;
    }
    public synchronized int increaseCountBy(int count, int increaseBy){
        return count+increaseBy;
    }
    public synchronized void increaseTestCount(){
        TEST_COUNT.incrementAndGet();
    }
    public synchronized void increaseTestEndCount(){
        TEST_ENDCOUNT.incrementAndGet();
    }
    public String getBrowserName() {
        return browserName;
    }
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
    public static EnglishtownStateObject getStateObject(WebDriver driver){
        return new EnglishtownStateObject(driver) ;
    }
    public static String getStateObjectKeyValue(WebDriver driver, String stateObjectKey, boolean isLoadStateObject)
            throws NullPointerException{
        EnglishtownStateObject stateObject = new EnglishtownStateObject(driver);

        if(isLoadStateObject) {
            stateObject.load(driver);
        }
        String keyValue = stateObject.getStateObjectValueFromMap(stateObject.getStateObjectMap(), stateObjectKey);
        logger.info("Key ["+stateObjectKey+"] value is ["+keyValue+"]");
        return keyValue ;
    }


    /*************************************************************************************************
     *
     *                 Parallel execution configuration
     *
     *$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
     */
    protected void destroyDriver(){
        try {
            if (myWebDriver != null) {
                myWebDriver.quit();
                logger.info("webDriver Destroyed ...!");
            } else {
                logger.info("Driver Not Destroyed ...is NULL ...!");
            }
            DriverManager.destroyLocalDriver();
        }catch (Exception e){
            logger.error("Destroy  webDriver failed :"+e.getMessage());
        }
        myWebDriver = null;
        logger.info("BaseTestConfig webDriver set to null ...!");
    }

    /**
     * get driver or throw error if driver not set/init
     * @return
     */
    protected WebDriver getThreadSafeDriver(){
        logger.info("getThreadSafeDriver [threadSafeDriver]...!");
        if(null != myWebDriver){
            return myWebDriver;
        }else {
            logger.error("Driver is null . Not init ...!");
            throw new WebDriverNotInitialisedException();
        }
    }

    /**
     * this method create new driver and set threaded driver to the new created driver
     */
    @Override
    public void setThreadSafeDriver(){
        myWebDriver = DriverManager.getNewDriver(MyBrowserType.CHROME, WaitTool.MED_WAIT_4_ELEMENT25);
        //TODO set name dynamically
        BaseRemoteWebDriver.setCurrentBrowserName("chrome");
    }

    /**
     *
     * @param browserType
     * @param waitTimeSec
     */
    @Override
    public void setThreadSafeDriver(MyBrowserType browserType, int waitTimeSec) {
        myWebDriver = DriverManager.getNewDriver(browserType, waitTimeSec);
    }

    /**
     * Set grid ENV from -D args in command line
     *
     */
    public static void setGridEnvironmentFromDargs() {
        BaseTestConfig.gridEnvironment = GridEnvironment.getGridEnvFromString(TestUtil.getProperty("grid"));
    }

}
