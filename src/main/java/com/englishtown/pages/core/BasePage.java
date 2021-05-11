package com.englishtown.pages.core;
/**
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.common.CommonTestHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static org.testng.Assert.fail;

public abstract class BasePage implements Page {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public String DESKTOP_MENU_SCRIPT ="return $('nav .menu a').is(':visible')";
    public boolean isMobileOrTablet=false; // mobile/tab test should set this to true
    public WebDriver webDriver;
    protected String url;
    protected String testName;
    protected boolean pageLoaded;
    protected boolean initialized;
    protected long pageLoadDurationMilliSeconds;
    public EnglishtownStateObject englishtownStateObject;
    protected WebElement currWebElement;

    public static final String schoolSpinnerCss = "ets-spinning"; //"ets-backdrop"; // class name


    protected BasePage(WebDriver webDriver, String url) {
        this.webDriver = webDriver;
        this.pageLoaded = false;
        this.url = url;
        this.initialized = false;
    }
    public BasePage() {
    }

    // Observer the time wait for ojb
    public BasePage(WebDriver webDriver){
        safePageFactoryInitElements(webDriver);
    }

    public BasePage(WebDriver webDriver, Class myClass){
        safePageFactoryInitElements(webDriver, myClass);
    }

    public BasePage(WebDriver webDriver, int pageLoadTime){
        safePageFactoryInitElements(webDriver, pageLoadTime);
    }

   // rapper
   public void safePageFactoryInitElements(WebDriver webDriver){
       logger.info(" init page ["+WaitTool.DEFAULT_IMPLICIT_WAIT+" seconds timeout: AjaxElementLocatorFactory :"+this.getClass().getSimpleName()+" StartTime : "+System.currentTimeMillis());
       this.webDriver = webDriver;
       try{
           PageFactory.initElements(new AjaxElementLocatorFactory(getWebDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT), this); //WaitTool.MED_WAIT_4_ELEMENT25
       }catch (Exception e){
           e.printStackTrace();
           logger.error("Could Not init Page Object : "+e.getMessage());
           failTest(e);
       }
       logger.info("End init page ; time :"+System.currentTimeMillis());
   }

   public void safePageFactoryInitElements(WebDriver webDriver, Class myClass){
        logger.info(" init page 15 seconds timeout: AjaxElementLocatorFactory :"+this.getClass().getSimpleName()+" StartTime : "+System.currentTimeMillis());
        this.webDriver = webDriver;
        try{
            PageFactory.initElements(new AjaxElementLocatorFactory(getWebDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT), myClass);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Could not Not Page Object : "+e.getMessage());
            failTest(e);
        }
        logger.info("End init page ; time :"+System.currentTimeMillis());
   }

   public void safePageFactoryInitElements(WebDriver webDriver, int pageLoadTime){
        logger.info(pageLoadTime +" init page seconds timeout: AjaxElementLocatorFactory :"+this.getClass().getSimpleName()+" StartTime : "+System.currentTimeMillis());
        this.webDriver = webDriver;
        try{
            PageFactory.initElements(new AjaxElementLocatorFactory(getWebDriver(), pageLoadTime), this);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Could Not init Page Object : "+e.getMessage());
            failTest(e);
        }
        logger.info("End init page ; time :"+System.currentTimeMillis());
   }


    @Override
    public WebDriver getWebDriver() {
        return webDriver;  //DriverManager.getDriver(); //webDriver; //ThreadGuardedWebDriverFactory.getDriver(); // webDriver;
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // override this
    public boolean simpleTest(){ return true;}

    /**
     * Check url contains expected text/string and return true or false
     */
    public boolean isPageUrl(String urlContains){
        boolean isURL = false;
        try {
            isURL = getCurrentUrl().contains(urlContains);
        }catch (Exception e){
            failTest("Can not verify the URL contains ["+urlContains+"] ...! "+e.getMessage());
        }
        return isURL;
    }

    public void sendKey(WebDriver webDriver, WebElement webElement, String keys, boolean autoScroll){
        WebElementHelper.sendKeys(webDriver, webElement, keys, autoScroll);
    }

    /***************************************************************************************************
     *
     * Open URL on the browser using get(url) method
     *
     * WebDriver will wait until the page has fully loaded (that is, the onload event has fired)
     * before returning control to your test or script.
     * If your page uses a lot of AJAX on load then WebDriver may not know when it has completely loaded.
     * If you need to ensure such pages are fully loaded then you can use waits.
     *
     */
    @Override
    public void loadPage() {
        try {
            if (!initialized) {
                this.pageLoadDurationMilliSeconds = 0;
                this.pageLoaded = false;
                long startTime = System.currentTimeMillis();
                getWebDriver().get(url);   //   this.webDriver.get(this.url);
                long endTime = System.currentTimeMillis();
                this.pageLoaded = true;
                this.pageLoadDurationMilliSeconds = (endTime - startTime);
                logger.info("Loaded page [{}] in {} seconds", this.url, (pageLoadDurationMilliSeconds / 1000F));
                this.initialized = true;
            }
        }catch (TimeoutException toe){
            logger.error("loadPage TimeoutException - wait:["+ WaitTool.DEFAULT_PAGELOAD_TIMEOUT+"] seconds; -> " + TestUtil.getException(toe));
            // this bit is dirty -> test seem to fail on IE10 ...! some say refresh the page will load the page
            //countException++; if(countException == 1){  logger.info("Executing windows.stop() .... on timeout exception ...!");  BaseTest.executeJSscript("window.stop()",getWebDriver(), 5);            }
            if( BaseRemoteWebDriver.isBrowserAndVersion("explore", "10") ) {
                try {
                    this.webDriver.navigate().refresh();
                }catch (TimeoutException e){
                    failTest(toe, " DEFAULT_PAGELOAD_TIMEOUT :["+ WaitTool.DEFAULT_PAGELOAD_TIMEOUT+"] ");
                }
            }else{
                failTest(toe, " DEFAULT_PAGELOAD_TIMEOUT :["+ WaitTool.DEFAULT_PAGELOAD_TIMEOUT+"] ");
            }
        }
        catch ( NullPointerException e){
            failTest(e, "  NullPointerException  ");
        }
        catch ( WebDriverException e){
            failTest(e, this.url+" WebDriverException ");
        }
    }

    @Override
    public boolean isAtExpectedPage() {
        String containsUrl = this.getUrl().trim();
        this.loadPage();
        //remove protocol  https://
        containsUrl = containsUrl.substring(8);
        //remove param as does not show on url
        if(this.getUrl().contains("/?ctr=")){
            containsUrl = containsUrl.replaceAll("\\?ctr=[a-z]{2}", "");
        }//        containsUrl = containsUrl.substring(0, containsUrl.length()-7);
        logger.info("isAtExpectedPage browser url is "+this.getCurrentUrl()+" -  contains - "+containsUrl);
        if(this.getUrl().contains("://qa") && this.getUrl().endsWith("it-it/")){
            logger.info("QA env");
            return this.getCurrentUrl().contains(containsUrl); //return this.getCurrentUrl().contains(this.getUrl().substring(0,this.getUrl().length()-8));
        }else  {
            logger.info("Live env");
            return this.getCurrentUrl().contains(containsUrl);//this.getUrl()
        }
    }

    @Override
    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    /************************************************************
     * This just load the page using webdriver get(url) method
     *
     */
    //TODO this need refactoring as it does not validate url valid per page
    // but page is loaded - does not work for ajax pages
    @Override
    public boolean isUrlValidForThisPage() {
        this.loadPage();
        return true;
    }

    protected boolean isUrlValidForThisPage(String urlPattern) {
        this.loadPage();
        String currentUrl = this.getCurrentUrl();
        boolean result = this.getCurrentUrl().toLowerCase().contains(urlPattern);
        if (!result) {
            logger.error("current page [{}] does not contain the expected pattern [{}].", currentUrl, urlPattern);
        }
        return result;
    }

    @Override
    public boolean isPageLoaded() {
        this.loadPage();
        return this.pageLoaded;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return null;
    }

    @Override
    public long getPageLoadDurationMilliSeconds() {
        this.loadPage();
        return this.pageLoadDurationMilliSeconds;
    }

    @Override
    public String getKey() {
        return this.url.toLowerCase();
    }
    public String setTestName(String testName) {
        return this.testName =testName;
    }
    public String getTestName() {
        return this.testName;
    }

    @Override
    public EnglishtownStateObject getEnglishtownStateObject(WebDriver driver) {
        logger.info("Base page getEnglishtownStateObject() ..");
        englishtownStateObject = new EnglishtownStateObject(driver);        //this.englishtownStateObject = new EnglishtownStateObject(this.getWebDriver());//this.getWebDriver());        //if (this.englishtownStateObject == null) {                     // Force init every time expensive !!  need to monitor this  //if(this.englishtownStateObject != null) {            //this.englishtownStateObject.load();               //}
        englishtownStateObject.load(driver);
        return englishtownStateObject; //this.englishtownStateObject;
    }

    @Override
    public String getPageSpeedIndexAnalysisReport() {
        // https://www.googleapis.com/pagespeedonline/v1/runPagespeed?url=http%3A%2F%2Fwww.englishtown.fr%2F&key=AIzaSyAKzaBT18-sE0cIQzq3jlYRKC-rf3Vt_jM
        StringBuilder responseBuffer = new StringBuilder();
        try {
            URL url = new URL("https://www.googleapis.com/pagespeedonline/v1/runPagespeed?key=AIzaSyAKzaBT18-sE0cIQzq3jlYRKC-rf3Vt_jM&url=" + this.getUrl());
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuffer.append(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            // ...
        } catch (IOException e) {
            // ...
        }
        return responseBuffer.toString();
    }

    public void waitForPageToLoad(ExpectedCondition pageLoadCondition){
        logger.info("  waitForPageToLoad Condition... [{}]", pageLoadCondition.toString());
        try{
            WebDriverWait wait = new WebDriverWait(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT, WaitTool.DEFAULT_POLL_SLEEP);
            wait.until(pageLoadCondition);
        } catch (WebDriverException e){
            logger.error("waitForPageToLoad failed; waitTime ["+WaitTool.MED_WAIT_4_ELEMENT+"] : Condition :'"+
                    pageLoadCondition+"' .Exception..!"+e.getMessage()+
                    "\n @ Current page URL : "+getWebDriver().getCurrentUrl());
            failTest(e);
        }
    }

    public static void failTest(String msg){
        failTest(msg, false);
    }
    public static void failTest(String msg, boolean isPrintUrl){
        if(isPrintUrl){
            fail("\nFailed ...! :'"+msg+"' ");//+TestUtil.getCurrentUrl(webDriver));
        }else {
            fail("\nFailed ...! :'" + msg );
        }
    }
    public static void failTest(String msg, WebElement we, boolean isPrintUrl){
        if(isPrintUrl){
            fail("\n"+msg+"['"+WebElementHelper.getElementLocator(we)+"' ");//+TestUtil.getCurrentUrl(webDriver));
        }else {
            fail("\n" + msg+"['"+WebElementHelper.getElementLocator(we)+"' " );
        }
    }
    public static void failTest(Exception e){
        fail("\nFail Test : Exception..! :'" + TestUtil.getException(e) + "' ");
    }
    public static void failTest(Exception e, String msg){
        failTest(e, msg, false);
    }
    public static void failTest(Exception e, String msg, boolean isPrintUrl){
        if(isPrintUrl) {
            fail("\nTest Failed ...!, \n\tCustom message :'" + msg + "'\n\t Exception..! :'\n" + e.getMessage()+"\n"+e.getCause());// TestUtil.getException(e, webDriver) + "' ");
        }else {
            fail("\nTest Failed ...!, \n\tCustom message :'" + msg + "'\n\t Exception..! :'\n" + e.getMessage()+"\n"+e.getCause());
        }
    }
    public static void failTest(Exception e, WebElement webElement, String msg, boolean isPrintUrl){
        if(isPrintUrl) {
            fail("\nTest Failed ...!, \n\tCustom message :'" + msg + "'\n\t Exception ..! :'" +
                    "' WebElement "+WebElementHelper.getElementLocator(webElement)+ "\n"+ e.getMessage()+"\n"+e.getCause());
                    //TestUtil.getException(e, webDriver) );
        }else {
            fail("\nTest Failed ...!, \n\tCustom message :'" + msg + "'\n\t Exception ..! :'" +
                            "' WebElement \n"+  e.getMessage()+"\n"+e.getCause());
        }
    }

    /**
     * Return true or false if URL contain text
     * This Method will not fail if URL does not contain text
     */
    public static boolean waitForUrlContains(WebDriver webDriver, String containsStr, int waitSeconds){
        return CommonTestHelper.waitForUrlContainsText(webDriver, containsStr, waitSeconds);
    }

    public static String getUrlWitWaitToEndWith(WebDriver webDriver, String endsWith, int waitSeconds){
        logger.info("waitForUrlEndsWith() : '"+endsWith+"'");
        Boolean isContainSting = false;
        String currentUrl="";

        do{
            waitSeconds--;
            logger.info(" DO Try left :"+waitSeconds);
            try{
                currentUrl = webDriver.getCurrentUrl().toLowerCase() ;
                logger.info("currentUrl is :'"+currentUrl+"' ");
                if (currentUrl != null && currentUrl.endsWith(endsWith) ) {
                    logger.info(" url :'"+currentUrl+"'\t endsWith '"+endsWith+"'");
                    isContainSting=true;
                    break;
                }
            }catch (WebDriverException e) {
                if(waitSeconds <1){
                    logger.error("waitAssertUrl ....URL :`"+currentUrl+"` does not endsWith :"+endsWith+
                            " Waitfor '"+waitSeconds+"' Error "+TestUtil.getException(e, webDriver));
                }
            }
            try { Thread.sleep(1000);} catch(Exception e1) {  }
        } while (waitSeconds > 0 )  ;

        return currentUrl;
    }

    public static boolean isUrlWitWaitToEndWith(WebDriver webDriver, String endsWith, int waitSeconds){
        logger.info("waitForUrlEndsWith() : '"+endsWith+"'");
        Boolean isUrlEndsWith = false;
        String currentUrl="";
        do{
            waitSeconds--;
            logger.info(" DO Try left :"+waitSeconds);
            try{
                currentUrl = webDriver.getCurrentUrl().toLowerCase() ;
                logger.info("currentUrl is :'"+currentUrl+"' ");
                if (currentUrl != null && currentUrl.endsWith(endsWith) ) {
                    logger.info(" url :'"+currentUrl+"'\t endsWith '"+endsWith+"'");
                    isUrlEndsWith=true;
                    break;
                }
            }catch (WebDriverException e) {
                if(waitSeconds <1){
                    logger.error("waitAssertUrl ....URL :`"+currentUrl+"` does not endsWith :"+endsWith+
                            " Waitfor '"+waitSeconds+"' Error "+TestUtil.getException(e, webDriver));
                }
            }
            try { Thread.sleep(1000);} catch(Exception e1) {  }
        } while (waitSeconds > 0 )  ;

        return isUrlEndsWith;
    }

    /**
     * Only old payment page     * ?debug=ccval=false
     */
    public void removePaymentValidation(){
        String debugUrl = "?debug=ccval=false";
        String currentUrl= getWebDriver().getCurrentUrl();
        getWebDriver().get(currentUrl + debugUrl);
        try{Thread.sleep(2000);}catch (Exception e){e.printStackTrace();}
    }
    public void removePaymentValidationNew(){
        logger.info("removePaymentValidationNew ...!");
        String script = "var callback = arguments[arguments.length - 1];\n" +
                "require(['shared/util/validate/validators/creditCard'], function(validatorCreditCard){ validatorCreditCard.debug = true; callback() });" ;
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
            if (javascriptExecutor != null) {
                long startTime = System.currentTimeMillis();
                logger.info("Started executing JS ...! Time : "+startTime);
                javascriptExecutor.executeAsyncScript( script + WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT   );
                long endTime = System.currentTimeMillis();
                logger.info("Ended executing JS ...!/n Script time : "+(endTime-startTime) );
            }
        }catch ( WebDriverException e){
            e.printStackTrace();            //failTest(e);
            failTest(e," Remove payment Validation failed ...!",true);
        }
    }

    public void removePaymentValidationNew(WebDriver driver, boolean isNewHouse){
        logger.info("removePaymentValidationNew ...!");
        String scriptOldHouse = "var callback = arguments[arguments.length - 1];\n" +
                "require(['shared/util/validate/validators/creditCard'], function(validatorCreditCard){ validatorCreditCard.debug = true; callback() });" ;

        /*String scriptNewHouse = "require(['shared/util/state', 'shared/util/state/adapters/persistent'], function(state, persistentAdapter){\n" +
                "  state.adapters.add(persistentAdapter).then(function(){\n" +
                "    return state.push('persistent.debugger_nocard_payment', {value: true});\n" +
                "  })\n" +
                "})";*/
        String scriptNewHouse = "var callback = arguments[arguments.length - 1];\n" +
                "require(['shared/util/state', 'shared/util/state/adapters/persistent'], function(state, persistentAdapter){\n" +
                "  state.adapters.add(persistentAdapter).then(function(){\n" +
                "    return state.push('persistent.debugger_nocard_payment', {value: true}) } ) \n" +
                "callback()})";

        String script = scriptOldHouse;

        if(isNewHouse) {
            script = scriptNewHouse;
            logger.info("use new house script ...!\n"+script);
        }

        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            if (javascriptExecutor != null) {
                long startTime = System.currentTimeMillis();
                logger.info("Started executing JS ...! Time : "+startTime);
                if(isNewHouse)
                    javascriptExecutor.executeAsyncScript( script );
                else
                    javascriptExecutor.executeAsyncScript( script + WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT  );

                long endTime = System.currentTimeMillis();
                logger.info("Ended executing JS ...!/n Script time : "+(endTime-startTime) );
            }
        }catch ( WebDriverException e){
            e.printStackTrace();            //failTest(e);
            failTest(e," Remove payment Validation failed ...!",true);
        }
    }

    public void click(WebElement webElement){
        WebElementHelper.click(webElement);
    }

    public void click(List<WebElement> listWebElement, int index){
        WebElementHelper.click(listWebElement, index);
    }


    /*********************************
     *  sleep wrapper
     ********************************/
    public static void sleep(int sleepTimeMls){
        TestUtil.mySleep(sleepTimeMls);
    }



    public void scrollToWeAndClick(WebDriver webDriver, WebElement webElement, int x, int y){
        logger.info("scrollToWeAndClick : X='" + x + "' ; Y='" + y + "'");
        try {
            WebElementHelper.scrollToElementLocation(webDriver, webElement, x, y);
            try { Thread.sleep(1000);  } catch (Exception e) {   }
            webElement.click();
        }catch (Exception e) {
            logger.error(" scrollToWeAndClick Exception :"+TestUtil.getExceptionFirstLine(e));
        }
    }


    /**
     * Wrapper
     * @param webElements
     * @return
     */
    public boolean checkAllPageComponentsDisplayed(WebElement... webElements) {
        return AssertHelper.assertComponentsDisplayed(webElements);
    }

}
