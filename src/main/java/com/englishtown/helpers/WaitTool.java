package com.englishtown.helpers;
/**
 *
 * Date: 05/03/2015
 * Nikol Marku
 *
 * TODO:
 * 1. move all waits to here from BasePage and BaseTest and refactor
 * 2.
 *
 * WebElement myDynamicElement = (new WebDriverWait(getWebDriver(), 20)).until(ExpectedConditions.presenceOfElementLocated(By.className("cq-dd-image")));
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Wait tool class.  Provides Wait methods for an element/s, and AJAX elements to load.
 * It uses WebDriverWait (explicit wait) for waiting an element or javaScript.
 *
 * To use implicitlyWait() and WebDriverWait() in the same test, we would have to nullify implicitlyWait()
 * before calling WebDriverWait(), and reset after it.  This class takes care of it.
 * implicitlyWait time also set "driver.findElement()" wait time.
 * info from: https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
 *
 * Generally relying on implicitlyWait slows things down so use WaitTool’s explicit wait methods as much as possible.
 * Also, consider (DEFAULT_IMPLICIT_WAIT = 0) for not using implicitlyWait for a certain test.*
 *
 * Note implicitWait Does NOT consider page load
 *
 */


public class WaitTool extends WaitToolConfig{
    private static final Logger log = LoggerFactory.getLogger(WaitTool.class);

    public static long waitForConditionStartTime = 0;
    /**
     * Wait for the element to be present in the DOM, and displayed on the page.
     * And returns the first WebElement using the given method.
     *
     //* @param WebDriver	The driver object to be used
     //* @param By	selector to find the element
     //* @param int	The time in seconds to wait until returning a failure
     *
     * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
     */
    public static WebElement waitForElementVisible(WebDriver driver, final By by, int timeOutInSeconds, int pollIntervalMils) {
        log.info("waitForElementVisible [{}] ; Seconds to wait :"+timeOutInSeconds, by);
        WebElement element;
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            log.info("visibilityOfElemen OK ...!");
            return element;
        } catch (Exception e) {
            log.error("waitForElementVisible ["+by+"] Exception :" + TestUtil.getException(e, driver));
        }
        return null;
    }

    /**
     * Return true if web element found
     * @param driver
     * @param by
     * @param timeOutInSeconds
     * @param pollIntervalMils
     * @return
     */
    public static boolean findElement(WebDriver driver, final By by, int timeOutInSeconds, int pollIntervalMils) {
        log.info("waitForElementVisible [{}] ; Seconds to wait :"+timeOutInSeconds, by);
        WebElement element;
        boolean isFoundWe = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            if(null !=element)
                isFoundWe = true;
            log.info("found visible Element OK ...!");
            return isFoundWe;
        } catch (TimeoutException e) {
            log.error("TimeoutException ["+by+"]  :" + TestUtil.getException(e, driver));
        } catch (Exception e) {
            log.error("waitForElementVisible ["+by+"] Exception :" + TestUtil.getException(e, driver));
        }
        return isFoundWe;
    }

    public static boolean waitForElementVisible_fluentWait(WebDriver driver, final WebElement webElement, int timeOutInSeconds, int pollIntervalMils) {
        log.info("waitForElementVisible [{}] ; Seconds to wait :"+timeOutInSeconds);
        WebElement element;
        boolean isFoundWe = false;
        try{
            Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
                    .withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(pollIntervalMils, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);
            //WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            element = wait.until(ExpectedConditions.visibilityOf(webElement));
            if(null !=element)
                isFoundWe = true;
            log.info("found visible Element OK ...!");
            return isFoundWe;
        } catch (TimeoutException e) {
            log.error("TimeoutException   :" + TestUtil.getException(e, driver));
        } catch (Exception e) {
            log.error("waitForElementVisible ["+webElement+"] Exception :" + TestUtil.getException(e, driver));
        }
        return isFoundWe;
    }

    /**
     * Find element on existing element
     * @param driver
     * @param by
     * @param timeOutInSeconds
     * @param pollIntervalMils
     * @return
     */
    public static boolean findElement(WebDriver driver, final WebElement weElement, final By by, int timeOutInSeconds, int pollIntervalMils) {
        log.info("findElement [{}] ; Seconds to wait :"+timeOutInSeconds, by);
        WebElement element;
        boolean isFoundWe = false;

        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            element = wait.until(ExpectedConditions.visibilityOf(weElement.findElement(by)));
            if(null != element)
                isFoundWe = true;
            log.info("found visible Element OK ...!");
            return isFoundWe;
        } catch (TimeoutException e) {
            log.error("TimeoutException ["+by+"]  :" + TestUtil.getException(e, driver));
        } catch (Exception e) {
            log.error("waitForElementVisible ["+by+"] Exception :" + TestUtil.getException(e, driver));
        }
        return isFoundWe;
    }

    public static boolean isElementVisible(WebDriver driver, final By by, int timeOutInSeconds, int pollIntervalMils) {
        log.info("waitForElementVisible [{}] ; Seconds to wait :"+timeOutInSeconds, by);
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));  // return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor)).isDisplayed();
            log.info("isElementVisible => OK ...!");
        } catch (Exception e) {
            log.error("waitForElementVisible ["+by+"] Exception :" + TestUtil.getException(e, driver));
            return false;
        }
        return true;
    }

    public static boolean isElementVisible(WebElement webElement) {
        log.info("check isElementVisible ...!"+webElement);
        try{
            return webElement.isDisplayed();
        } catch (Exception e) {
            log.error("isElementVisible Exception or webElement is null:" + TestUtil.getException(e));
            return false;
        }
    }
    /**
     * To Replace isElementVisible method - this does not nullify implicitWait
     * Method can be used without passing the timeout parameter ; it will use the default = WAIT_5s
     */
    public static Boolean waitForIsDisplayed(WebDriver driver, By locator, int timeout){
        try{
            waitFor(driver, ExpectedConditions.visibilityOfElementLocated(locator), timeout);
        }catch (TimeoutException e){
            log.error("TimeoutException waiting for element to be displayed : "+locator+" TimeOut :"+timeout+"\n"+TestUtil.getException(e));
            return false;
        }
        return true;
    }
    /**
     * Wait for condition; Set default to WAIT_5s iF timeout is null
     */
    public static void waitFor(WebDriver driver, ExpectedCondition<WebElement> condition, int timeout){
        timeout = timeout < 0 ? timeout : WAIT_5s;
        log.info("time out set to [{}] seconds", timeout);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    /*******************************************************************************************************************
     * Wait for WebElement to be clickable; Does not fail the test
     * Note: if clickable -> WebElement is enabled or should be
     */
    public static WebElement waitForElementClickable(WebDriver driver, final By by, int timeOutInSeconds, int pollIntervalMils) {
        log.info("waitForElementClickable [{}] ; Seconds to wait :"+timeOutInSeconds, by);
        WebElement element;
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            log.info("ExpectedConditions elementToBeClickable OK ...!");
            return element;
        } catch (Exception e) {
            log.error("waitForElementClickable [" + by + "] Exception :" + TestUtil.getException(e, driver));
        }
        return null;
    }

    public static WebElement waitForElementClickable_fluentWait(WebDriver driver, final WebElement webElement, int timeOutInSeconds, int pollIntervalMils) {
        log.info("waitForElementClickable [{}] ; Seconds to wait :"+timeOutInSeconds, webElement);
        WebElement element;
        try{
            Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
                    .withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(pollIntervalMils, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);
            //WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, pollIntervalMils);
            element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
            log.info("ExpectedConditions elementToBeClickable OK ...!");
            return element;
        } catch (Exception e) {
            log.error("waitForElementClickable [" + webElement + "] Exception :" + TestUtil.getException(e, driver));
        }
        return null;
    }

    public static WebElement waitForElementClickable(WebDriver driver, By bySelector, int waitTime){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime, DEFAULT_POLL_SLEEP);
            element = wait.until(ExpectedConditions.elementToBeClickable(bySelector));
        }catch (Exception e){
            e.printStackTrace();
            BasePage.failTest("waitForElementClickable Failed ...! Selector : '"+ bySelector + "' Waited for ["+waitTime+"] Seconds : " ,true);
        }
        return element;
    }

    /**
     * Wait for the element to be present in the DOM, regardless of being displayed or not.
     * And returns the first WebElement using the given method.
     *
     * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
     */
    public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {
        log.info("waitForElementPresent [{}] ; Seconds to wait :" + timeOutInSeconds, by);
        WebElement element;
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        } catch (Exception e) {
            log.error("waitForElementPresent [" + by + "] Exception :" + TestUtil.getException(e, driver));
        }
        return null;
    }
    public static void waitForElementVisible(WebDriver driver, final By by, int timeOutInSeconds) {
        log.info("visibilityOfElementLocated  : selector :" + by);
        waitForCondition(ExpectedConditions.visibilityOfElementLocated(by), driver, timeOutInSeconds);
        log.info("visibilityOfElementLocated [{}]...! => OK ", by);
    }

    public static void waitForElementVisibleAndClickable (By by, WebDriver webDriver, int waitTime){
        log.info("waitForElementVisibleAndClickable  : selector :" + by);
        waitForCondition(ExpectedConditions.elementToBeClickable(by), webDriver, waitTime); // this check present and visible
        log.info("waitForElementVisibleAndClickableCondition [{}]...! => OK ", by);
    }
    // wrapper
    public static WebElement findElement(WebDriver driver, By bySelector){
        WebElement webElement = null;
        String currentUrl = "";
        try{
            webElement = driver.findElement(bySelector);
        }catch (Exception e){
            e.printStackTrace();
            if(null!= driver)
                currentUrl = driver.getCurrentUrl();
            BasePage.failTest(e, "Failed to find Element ...!, WebElement : " + bySelector+"; URL :"+currentUrl);
        }
        return webElement;
    }



    public static List <WebElement> findElements(WebDriver driver, By bySelector){
        List <WebElement> webElements = new ArrayList<WebElement>();
        try{
            webElements = driver.findElements(bySelector);
        }catch (Exception e){
            BasePage.failTest(e, "Failed to find Element ...!, WebElement : " + bySelector);
        }
        return webElements;
    }

    public static WebElement findElementDontFailTest(WebDriver driver, By bySelector){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(bySelector);
        }catch (Exception e){
            log.error("Failed to find Element ...!, WebElement : " + bySelector +" Exception :"+TestUtil.getException(e));
        }
        return webElement;
    }
    /**
     *  Return null if element not found is NOT visible and Not enabled
     * TODO - investigate and refactor
     */
    public static WebElement safeFindDisplayedAndEnabled(WebDriver webDriver, By selector, int waitTimeSec) {
        log.info(" safeFindDisplayedAndEnabled() : [{}]", selector);
        long waitTime = 0;
        WebElement we = null;
        int count = 0;
        count--;

       // try {
            while (waitTimeSec > 0) {
                count++;
                waitTimeSec--;
                try {
                    // TODO monitor this findElement and probably change it to findElements 's'
                    we = webDriver.findElement(selector);
                    if (we.isDisplayed() && we.isEnabled()) {
                        log.info("Element is displayed and enabled :" + WebElementHelper.getElementLocator(we));
                        return we;
                    } else if(waitTimeSec == 0){
                        log.error("Element not found Displayed and Enabled ...!");
                    }
                } catch (NullPointerException | NoSuchElementException | ElementNotVisibleException e) {
                    try{Thread.sleep(999);}catch (InterruptedException ie){}
                    if (waitTimeSec < 1) {
                        log.error("\n safeFindDisplayedAndEnabled() Can't find Element  enabled and displayed '" +
                                selector + "' Time waited :'" + count + "' seconds; \n Exception : '" +
                                TestUtil.getException(e, webDriver) + "'\n\n");
                    }
                }
            }
        return we;
    }
    /**
     * Wait for the List<WebElement> to be present in the DOM, regardless of being displayed or not.
     * Returns all elements within the current page DOM.
     *
     * @return List<WebElement> all elements within the current page DOM, or null (if the timeout is reached)
     *
     */
    public static List<WebElement> waitForListElementsPresent(WebDriver driver, final By by, int timeOutInSeconds)
            throws NullPointerException{
        List<WebElement> elements;
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            elements = driver.findElements(by);
            return elements;
        } catch (Exception e) {
            log.error("waitForListElementsPresent Exception : " + TestUtil.getException(e));
        }
        return null;
    }

    /**
     * Wait for elements to be displayed/visible [ ExpectedConditions.visibilityOfAllElementsLocatedBy(by) ]
     * @return List<WebElement>, or null (if the timeout is reached - This will fail the test so null never returned)
     */
    public static List<WebElement> waitForListElementsDisplayed(WebDriver driver, final By by, int timeOutInSeconds)
            throws NullPointerException{
        log.info("waitForListElementsDisplayed ...!");
        List<WebElement> elements;
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            elements = driver.findElements(by);
            return elements;
        } catch (Exception e) {
            BasePage.failTest(e, "waitForListElementsDisplayed Exception", false);
        }
        return null;
    }


    /**
     *  Get only the visible elements from the list
     * @param driver
     * @param webElementList
     * @return
     */
    public static List<WebElement> getVisibleElements(WebDriver driver,  List<WebElement> webElementList) {
        log.info("getVisibleListOfWebElement ...!");
        List<WebElement> visibleElements = new ArrayList<WebElement>();
        int count = -1;
        if(!CollectionUtils.isEmpty(webElementList)) {
            for (WebElement tempWe : webElementList) {
                count++;
                if (isElementVisible(tempWe)) {
                    visibleElements.add(tempWe);
                    //log.info("added WE no {{}} to list....!", count);
                }
            }    /*} catch (Exception e) {   BasePage.failTest(e, "getVisibleElements Exception", false);       }*/
        }else
            BasePage.failTest("webElementList is empty or null ....!");

        return visibleElements;
    }

    /*******************************************************************************************************************
     * Wait for an element to appear on the refreshed web-page.
     * And returns the first WebElement using the given method.
     * * This method is to deal with dynamic pages.
     *
     * @return WebElement	the first WebElement using the given method, or null(if the timeout is reached)
     */
    public static WebElement waitForElementRefresh(WebDriver driver, final By by, int timeOutInSeconds) {
        WebElement element;
        try{
            new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    driverObject.navigate().refresh(); //refresh the page ****************
                    return isElementPresentAndDisplay(driverObject, by);
                }
            });
            element = driver.findElement(by);
            return element; //return the element
        } catch (Exception e) {
            log.error("waitForElementRefresh " + TestUtil.getException(e, driver));
        }
        return null;
    }

    /**
     * Wait for the Text to be present in the given element, regardless of being displayed or not.
     *
     * @ WebDriver	The driver object to be used to wait and find the element
     * @ locator	selector of the given element, which should contain the text
     * @ String	The text we are looking
     * @ int	The time in seconds to wait until returning a failure
     *
     * @return boolean
     */
    public static void waitForTextPresent(WebDriver driver, final By by, final String text, int timeOutInSeconds,
                                          final boolean useGetAttributeValue) {
        log.info(" waitForTextPresent() '"+text+"' on element [{}]", by);
        boolean isPresent = false;
        try{
            new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    return isTextPresent(driverObject, by, text, useGetAttributeValue); //is the Text in the DOM
                }
            });
        }catch (Exception e) {
            BasePage.failTest(e, "waitForTextPresent Exception ...!; Can't find text: '" + text + "' on locator [" + by + "]", true);
        }

    }

    /** ????????????????????????????????????
     * Waits for the Condition of JavaScript - true or false.
     * TODO: this need testing
     * @ WebDriver		The driver object to be used to wait and find the element
     * @ String	The javaScript condition we are waiting. e.g. "return (xmlhttp.readyState >= 2 && xmlhttp.status == 200)"
     * @ int	The time in seconds to wait until returning a failure
     *
     * @return boolean true or false(condition fail, or if the timeout is reached)
     **/
    public static boolean waitForJavaScriptCondition(WebDriver driver,final String javaScript, int timeOutInSeconds) {
        boolean jscondition = false;
        try{
            new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
                }
            });
            jscondition =  (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
            return jscondition;
        } catch (Exception e) {
            log.error("waitForJavaScriptCondition Exception : "+TestUtil.getException(e));
        }
        return false;
    }

    /** Waits for the completion of Ajax jQuery processing by checking "return jQuery.active == 0" condition.
     *
     * @ WebDriver - The driver object to be used to wait and find the element
     * @ int - The time in seconds to wait until returning a failure
     *
     * @return boolean true or false(condition fail, or if the timeout is reached)
     * */
    public static boolean waitForJQueryProcessing(WebDriver driver, int timeOutInSeconds){
        boolean jQcondition = false;
        try{
            new WebDriverWait(driver, timeOutInSeconds, DEFAULT_POLL_SLEEP) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
                }
            });
            jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            return jQcondition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jQcondition;
    }

    /*******************************************************************************************************************
     * Fail test if condition is not met within waitTime in seconds                                  *******************
     * Can be used for all : org.openqa.selenium.support.ui.ExpectedConditions
     * see : https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
     * usage :  WaitTool.waitForCondition(ExpectedConditions.visibilityOf(
     *          getWebDriver().findElement(By.id(submitElementId))),  getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
     ******************************************************************************************************************/
    public static void waitForCondition( ExpectedCondition condition, WebDriver webdriver, int waitTimeSec) {
        log.info("waitForCondition :"+condition+", waitTime :"+waitTimeSec+";");
        String failMessage = " Failed  Expected Conditions ...! :"+condition+" - Wait time : "+waitTimeSec;
        try{
            WebDriverWait wait = new WebDriverWait(webdriver, waitTimeSec, DEFAULT_POLL_SLEEP);                                                 //            WebDriverWait wait = new WebDriverWait(webdriver, waitTime,DEFAULT_POLL_SLEEP);
            wait.until(condition);
        }catch ( TimeoutException e){
            //log.error("TimeoutException :waitForElementCondition -> "+condition+" \n "+ TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }catch ( NoSuchSessionException e){  // TO do maybe remove this
            //log.error("NoSuchSessionException :waitForElementCondition -> "+ TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }catch ( UnreachableBrowserException ube){
            //log.error("UnreachableBrowserException :waitForElementCondition -> "+ TestUtil.getException(ube, webdriver)) ;
            BasePage.failTest(ube, failMessage);
        }catch ( NoSuchElementException nse){
            //log.error("NoSuchElementException :waitForElementCondition -> "+ TestUtil.getException(nse, webdriver)) ;
            BasePage.failTest(nse, failMessage);
        }
        catch ( WebDriverException e){
            //log.error("WebDriverException :waitForElementCondition -> "+TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }catch ( Exception e){
            //log.error("Exception :waitForElementCondition -> "+ TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }
        log.info("waitForCondition :"+condition+", OK  waitTimeSec :"+waitTimeSec+";");
    }
    public static void waitForConditionSpinner( ExpectedCondition condition, WebDriver webdriver, int waitTime) {
        waitForConditionStartTime = System.currentTimeMillis();
        log.info("waitForCondition :"+condition+", waitTime :"+waitTime+"; Start time : "+waitForConditionStartTime);
        String failMessage = " Failed  Expected Conditions ...! :"+condition+" - Wait time : "+waitTime;
        try{
            WebDriverWait wait = new WebDriverWait(webdriver, waitTime, DEFAULT_POLL_SLEEP);                                                 //            WebDriverWait wait = new WebDriverWait(webdriver, waitTime,DEFAULT_POLL_SLEEP);
            wait.until(condition);
        }catch ( TimeoutException e){
            //log.error("TimeoutException :waitForElementCondition -> "+condition+" \n "+ TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }catch ( NoSuchSessionException e){  // TO do maybe remove this
            //log.error("NoSuchSessionException :waitForElementCondition -> "+ TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }catch ( UnreachableBrowserException ube){
            //log.error("UnreachableBrowserException :waitForElementCondition -> "+ TestUtil.getException(ube, webdriver)) ;
            BasePage.failTest(ube, failMessage);
        }catch ( NoSuchElementException nse){
            //log.error("NoSuchElementException :waitForElementCondition -> "+ TestUtil.getException(nse, webdriver)) ;
            BasePage.failTest(nse, failMessage);
        }
        catch ( WebDriverException e){
            //log.error("WebDriverException :waitForElementCondition -> "+TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }catch ( Exception e){
            //log.error("Exception :waitForElementCondition -> "+ TestUtil.getException(e, webdriver)) ;
            BasePage.failTest(e, failMessage);
        }
    }
    /******************************************************************************************************************
     *
     * Set driver implicitlyWait() time.
     * Once wait is set on the driver You would have to explicitly set it to zero to nullify it
     * To reset ImplicitWait time you would have to explicitly
     * set it to zero to nullify it before setting it with a new time value.
     *
     */
    public static void nullifyImplicitWait(WebDriver driver){
        log.warn("nullifyImplicitWait does nothing now ... testing remove implicit wait  " );
        /*try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }catch (UnhandledAlertException ae){
            log.error("UnhandledAlertException  " + TestUtil.getException(ae));
        }
        catch (Exception e) {
            log.error("nullifyImplicitWait Exception " + TestUtil.getException(e));
        }*/
    }
    public static void nullifyAndSetImplicitWait(WebDriver driver, int waitTimeSec) throws Exception{
        log.warn("nullifyAndSetImplicitWait does nothing now ... testing remove implicit wait  " );
        /*driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(waitTimeSec, TimeUnit.SECONDS);*/
    }
    public static void nullifyAndSetImplicitWait(WebDriver.Options options, int waitTimeSec)throws Exception{
        log.warn("nullifyAndSetImplicitWait does nothing now ... testing remove implicit wait  " );
        /*options.timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        options.timeouts().implicitlyWait(waitTimeSec, TimeUnit.SECONDS);*/
    }
    public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
        log.warn("setImplicitWait does nothing now ... testing remove implicit wait  " );
        /*log.info("setImplicitWait to :" + waitTime_InSeconds);
        try {
            nullifyAndSetImplicitWait(driver, waitTime_InSeconds);
        }catch (UnreachableBrowserException ube){
            log.error("setImplicitWait "+TestUtil.getException(ube));
        }catch (Exception e){
            log.error(" setImplicitWait Exception :" + TestUtil.getException(e));
        }*/
    }
    public static void setImplicitWait(WebDriver.Options options, int waitTime_InSeconds) {
        log.warn("nullifyAndSetImplicitWait does nothing now ... testing remove implicit wait  " );
        /*try {
            nullifyAndSetImplicitWait(options, waitTime_InSeconds);
        }catch (UnreachableBrowserException ube){
            log.error("setImplicitWait "+TestUtil.getException(ube));
        }catch (Exception e){
            log.error(" setImplicitWait Exception :" + TestUtil.getException(e));
        }*/
    }
    public static void setImplicitWaitToDefault(WebDriver driver) {
        log.warn("setImplicitWaitToDefault does nothing now ... testing remove implicit wait  " );
        //setImplicitWait(driver, DEFAULT_IMPLICIT_WAIT);
    }
    public static void setImplicitWaitToDefault(WebDriver.Options options) {
        log.warn("setImplicitWaitToDefault does nothing now ... testing remove implicit wait  " );
        //setImplicitWait(options, DEFAULT_IMPLICIT_WAIT);
    }
    /**
     * Reset ImplicitWait. Should use this to make the code more redeabalbe when implecit wiat it changed
     * @ int - a new wait time in seconds
     */
    public static void resetImplicitWait(WebDriver driver, int newWaittimeSec) {
        setImplicitWait(driver, newWaittimeSec);
    }
    /*******************************************************************************************************************
     *
     * Set page load timeout
     *  Could throw UnsupportedOperationException - so catch all with Exception and see
     *
     */
    public static void setPageLoadTimeOut(WebDriver driver, int pageTimeOutSec) {
        log.info("\n Set setPageLoadTimeOut ...!:" + pageTimeOutSec + " Seconds");
        try {
            driver.manage().timeouts().pageLoadTimeout(pageTimeOutSec, TimeUnit.SECONDS);
        }catch(Exception e) {
            log.error("setPageLoadTimeOut :pageLoadTimeout: Exception  " + TestUtil.getExceptionFirstLine(e));
        }
    }
    public static void setPageLoadTimeOut(WebDriver.Options options, int pageTimeOutSec) {
        log.info("\n Set PageLoadTimeOut very high as website is not that responsive ...!:"+pageTimeOutSec+" Seconds");
        try {
            options.timeouts().pageLoadTimeout(pageTimeOutSec, TimeUnit.SECONDS);
        }catch(Exception e) {
            log.error("setPageLoadTimeOut :pageLoadTimeout: Exception  " + TestUtil.getExceptionFirstLine(e));
        }
    }
    /*******************************************************************************************************************
     *
     * Set JavaScript timeout
     *
     */
    public static void setJavaScriptTimeout(WebDriver driver, int waitTimeoutSec) {
        log.info("Set JavaScriptTimeout ...! - to :" + waitTimeoutSec);
        try{
            driver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS); //nullify AND RESET
            driver.manage().timeouts().setScriptTimeout(waitTimeoutSec, TimeUnit.SECONDS);
        }catch (UnreachableBrowserException ube){
            log.error(" "+TestUtil.getException(ube));
        }catch (Exception e){
            log.error(" "+TestUtil.getException(e));
        }
    }
    public static void setJavaScriptDefaultTimeout(WebDriver driver) {
        log.info("setJavaScriptDefaultTimeout ...!"+JS_SCRIPT_DEFAULT_TIMEOUT);
        setJavaScriptTimeout(driver, JS_SCRIPT_DEFAULT_TIMEOUT);
    }
    public static void setJavaScriptDefaultTimeout(WebDriver.Options options) {
        log.info("Nullify it and setJavaScriptDefaultTimeout : "+JS_SCRIPT_DEFAULT_TIMEOUT );
        try{
            options.timeouts().setScriptTimeout(0, TimeUnit.SECONDS); //nullify AND RESET
            options.timeouts().setScriptTimeout(JS_SCRIPT_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }catch (UnreachableBrowserException ube){
            log.error(" "+TestUtil.getException(ube));
        }catch (Exception e){
            log.error(" "+TestUtil.getException(e));
        }
    }
    /**
     * Checks if the text is present in the element.
     * @param text - The Text element you are looking for     *
     * useGetAttributeValue  if true then use .getAttribute("value"); to get the text otherwise use getText()
     */
    private static boolean isTextPresent(WebDriver driver, By by, String text, boolean useGetAttributeValue) {
        try {
            String value="";
            if(useGetAttributeValue){
                value = driver.findElement(by).getAttribute("value");
            }else {
                value = driver.findElement(by).getText();
            }
            log.info("isTextPresent - Value is :'"+value+"'; Should contain :'"+text+"'");
            return value.contains(text);
        } catch (Exception e) {
            return false;                                                                                               //log.error("isTextPresent Exception : "+TestUtil.getException(e, driver));
        }
    }
    /**
     * Checks if the element is in the DOM, regardless of being displayed or not.
     */
    private static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);//if it does not find the element throw NoSuchElementException, which calls "catch(Exception)" and returns false;
            return true;
        } catch (Exception e) {
            log.error("isElementPresent Exception : "+TestUtil.getException(e, driver));
            return false;
        }
    }
    /**
     * Checks if the List<WebElement> are in the DOM, regardless of being displayed or not.
     */
    private static boolean areElementsPresent(WebDriver driver, By by) {
        try {
            driver.findElements(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /**
     * Checks if the element is in the DOM and displayed.
     */
    public static boolean isElementPresentAndDisplay(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /**
     * Simulates a delay in user input.
     * {Use this to wait for background events to complete in the page.}
     * @param delay delay time in seconds   Note: this sleep for 16 seconds if 1 is entered - implicit wait
     *  if null then @elementId = "-1"
     */
    public static void waitForNonExistentId(WebDriver driver, String elementId, int delay) {
        if(elementId == null){elementId="-1";}
        int retryCount = 0;
        //nullifyImplicitWait(driver);
        try {
            retryCount++;
            WebElement myDynamicElement = (new WebDriverWait(driver,delay, DEFAULT_POLL_SLEEP)).until(
                    ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
        }catch(TimeoutException te) {
            if ( (delay-retryCount) == 0){  }
        }catch(WebDriverException te) {
            if ( (delay-retryCount) == 0){  }
        }catch(Throwable th) {
            if ( (delay-retryCount) == 0){ log.warn("Throwable .... ", th); }
        }
        /*finally {
            //setImplicitWaitToDefault(driver);
        }*/
    }


    /**
     * Wait for document ready state = complete
     * @param driver
     * @param timeout
     * @throws TimeoutException
     */
    void JS_waitUntilDocumentIsReady(WebDriver driver, int timeout) throws TimeoutException{
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(pageLoadCondition);
    }


    /**
     * Wait for JS alert pop up and close it
     */
    public static void acceptAlert(WebDriver driver, int alertPopupWaitTimeSeconds){
        try{   //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, alertPopupWaitTimeSeconds);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            log.info("Alert text is :"+alertText);
            alert.accept();
            log.info("Accepted the alert successfully.");
        }catch(Throwable e){
            log.error("Error came while waiting for the alert popup. "+e.getMessage());
        }
    }

    public static void dismissAlert(WebDriver driver, int alertPopupWaitTimeSeconds){
        try{   //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, alertPopupWaitTimeSeconds);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            log.info("Alert text is :"+alertText);
            alert.dismiss();
            log.info("Dismissed the alert successfully.");
        }catch(Throwable e){
            log.error("Error came while waiting for the alert popup. "+e.getMessage());
        }
    }


    public static boolean isEnabled(WebDriver driver, WebElement webElement){
        try{
            if(webElement.isEnabled())
                return true;
            else
                return false;
        }catch (Exception e){
            BaseTest.failTest("Failed to determine Web element ["+webElement+"] isEnalbled ...! > "+e.getMessage());
        }

        return false;
    }
}


/***********************************************************************************************************************
 * Used  References:
 * 1. Mark Collin's post on: https://groups.google.com/forum/?fromgroups#!topic/webdriver/V9KqskkHmIs%5B1-25%5D
 * 	  Mark's code inspires me to write this class. Thank you! Mark.
 * 2. Andre, and Tarun Kumar's post on: https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
 * 3. Explicit and Implicit Waits: http://seleniumhq.org/docs/04_webdriver_advanced.html
 *
 * Note:
 * 1. Instead of creating new WebDriverWait() instance every time in each methods,
 *    I tried to reuse a single WebDriverWait() instance, but I found and tested
 *    that creating 100 WebDriverWait() instances takes less than one millisecond.
 *    So, it seems not necessary.
 */