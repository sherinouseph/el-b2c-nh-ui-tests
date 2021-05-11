package com.englishtown.helpers;
/**************************************************************************************
*
* Just to make the whole element interaction easier as our markup
* really sucks and error messages are too cryptic.
*
**************************************************************************************/
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.cq.CqEditAuthoringPage;
//import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.commons.collections.ListUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import static java.lang.Thread.sleep;
import com.englishtown.driver.WebElementStatus;

public class WebElementHelper<T> {
    private static final Logger log = LoggerFactory.getLogger(WebElementHelper.class);
    private WebElement webElement;
    private WebElement parentElement;
    private WebDriver webDriver;
    private T parentContainer;
    private Collection<By> selectors;
    private boolean enableAutoScroll;
    public static final int SAFE_FIND_WAIT_TIME = 15;
    public static int DEFAULT_EXCEPTION_LINE = 0;

    public WebElementHelper(T parentContainer, WebDriver webDriver, WebElement parent, By... selectors) {
        this.parentContainer = parentContainer;
        this.parentElement = parent;
        this.selectors = new ArrayList<By>();
        this.selectors.addAll(Arrays.asList(selectors));
        this.webDriver = webDriver;
        this.webElement = null;
        enableAutoScroll = false;
    }

    /**
     * waitForElementVisible could return null - handle it
     * @throws NullPointerException
     */
    public static WebElement safeFindElement(WebDriver webDriver, By selector) throws NullPointerException{
        return WaitTool.waitForElementVisible(webDriver, selector, WaitTool.DEFAULT_WAIT_4_ELEMENT, 1000); //safeFindDisplayedAndEnabled(webDriver, selector, SAFE_FIND_WAIT_TIME);
    }

    /**
     *  Return null if element not found is NOT visible and Not enabled
     *
     */

    public static WebElement safeFindDisplayedAndEnabled(WebDriver webDriver, By selector, int waitTimeSec) {
        return WaitTool.safeFindDisplayedAndEnabled(webDriver, selector, waitTimeSec);
    }
    public static List<WebElement> safeFindListOfElementsPresent(WebDriver webDriver, By selector, int waitTimeSec) {
        return WaitTool.waitForListElementsPresent(webDriver, selector, waitTimeSec);
    }

    /*******************************************************************************************
     *  Composite selectors : find Children : NO wait facility : uses default implicit wait    *
     ******************************************************************************************/
    // Note; one use - resolve element
    public static WebElement safeFindElement(WebElement parent, By selector) {
        try {
            if(parent == null) {
                log.error("Parent container is null.");
                return null;
            } else {
                return parent.findElement(selector);
            }
        } catch (NoSuchElementException e) {
            log.warn("Selector [{}] did not find any element for parent [{}]", selector, parent);
            return null;
        } catch (NoSuchSessionException snfe){
            log.warn("NoSuchSessionException [{}]", TestUtil.getExceptionFirstLine(snfe)); // snfe.getCause().getMessage()
            return null;
        }
    }
    public static boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }

    public static void sendKeys(WebDriver webDriver, WebElement webElement, String keys, boolean autoScroll) {
        if (webElement == null) {
            log.error("Cannot send keys as element is not initialized.");  //fail("Cannot send keys '"+keys+"'as element is not initialized/present.");
        } else {
            if (!webElement.isDisplayed()) {
                log.warn("Element [{}] is not displayed.", webElement);
            }
            if (autoScroll) {
                scrollToElementLocation(webDriver, webElement, 0, 150);
            }
            webElement.sendKeys(keys);
            String value = null;
            try{ sleep(1000);} catch (InterruptedException ie){ie.printStackTrace();}
            try{
                value = webElement.getAttribute("value");
            }catch (WebDriverException wde){
                log.error("Can't get webelement value using getAttribute.value ...!");
            }
            log.info(" Web Element Text now is : "+value);
        }
    }

    /*************************************************************************
     *   Type one by one
     ************************************************************************/
    public static void typeOneCharAtATime(String keys, WebElement webElement){
            char[] charArray = keys.toCharArray();
            int keySize = charArray.length;

            for(int i=0; i < keySize; i++){
                String s = String.valueOf(charArray[i]);
                log.info("Typed Key "+charArray[i]);
                webElement.sendKeys(s);
            }
    }
    /**
     * use this for all the text input fields and text area that need to be cleared before test or for repetitive test
     */
    public static void clearAndsendKeys(WebDriver webDriver, WebElement webElement, String keys, boolean autoScroll) {
        log.info("clearAndsendKeys .. Click to select, then clear, then type  ");
        webElement.clear();
        try{
            sleep(300);}catch (Exception e){e.printStackTrace();}
        sendKeys(webDriver, webElement,  keys,  autoScroll);
    }

    public static void sendKeyWithWait(WebElement webElement, String input, int wait){
        char[] charArray = input.toCharArray();
        log.info(" input is :"+input);
        log.info(" chatArray is :" + charArray.toString());
        String typeStr = null;
        if (charArray.length > 0){
            for(int i=0; i<charArray.length ; i++) {
                log.info(i+" type char : "+charArray[i]);
                typeStr=String.valueOf(charArray[i]);
                webElement.sendKeys(typeStr);
                try{ sleep(wait);} catch (InterruptedException ie){ie.printStackTrace();}
            }
        }
        String value = null;
        try{
            value = webElement.getAttribute("value");
            log.info(" Web Element Text now is : "+value);
        }catch (WebDriverException wde){
            log.error("Can't get webelement value using getAttribute.value ...!");
        }
    }

    /**
     * Note: Not sure if this scrolling is working 100%
     * Scroll to point webElement y value - y param
     */
    public static void scrollToElementLocation(WebDriver webDriver, WebElement webElement, int x, int y) {
        try {
            Point elementLocation = webElement.getLocation();
            log.info("Attempting to scroll to element [{}] location [{}]", webElement, elementLocation);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
            int scrollToY = elementLocation.getY() - y;
            javascriptExecutor.executeScript("window.scrollTo(" + x + "," + scrollToY + ")", "");
            sleep(10);
        } catch (WebDriverException | InterruptedException | NullPointerException e) {
            log.error("Failed to scroll to element [{}] location", webElement);
        }
    }


    public static void scrollAndClick(WebDriver webDriver, WebElement webElement) {
        String weLocatedBy = null;
        try {
            weLocatedBy = WebElementHelper.getElementLocator(webElement);
            log.info(" scrollAndClick WebElement [{}]", weLocatedBy);
            String errMsg = "scrollAndClick Element '" + weLocatedBy + "' is not displayed or enabled ...! Note: this is not working for JBrowser";

            if (webElement.isDisplayed() && webElement.isEnabled() ) {
                WebElementHelper.scrollToElementLocation(webDriver, webElement, 0, 300);
                try {Thread.sleep(1000);} catch (Exception e) {  }
                webElement.click();
                log.info(" scrollAndClick Clicked...!");
            } else {
                log.error(errMsg);
                BasePage.failTest(errMsg, true);
            }
        } catch ( NullPointerException | WebDriverException   e) {
            log.error("scrollAndClick Exception, WebElement is null or not clickable ...!" +
                    TestUtil.getException(e, webDriver)) ;
            BasePage.failTest(e, "scrollAndClick Exception ...!"+" web element :"+weLocatedBy, true);
        }
    }

    public static boolean isNullWebElement(WebElement webElement, String msg){
        if(webElement == null ){
            log.error("WebElement is NULL ....! [{}]", webElement, msg);
            return true;
        } else {
            return false;
        }
    }

    public WebElement getWebElement() {
        if (this.webElement == null) {
            this.resolveElement();
        }
        return webElement;
    }

    public T sendKeys(String keys) {
        sendKeys(this.webDriver, this.getWebElement(), keys, this.enableAutoScroll);
        return parentContainer;
    }

    public T setTextValue(String value) {
        //todo : investigate why sometime second name or pass not entered on form
        if(value != null) {
            log.info(" setTextValue() to : " + value);
            return this.sendKeys(value);
        } else {
            log.info(" Text value not set ...!");
            return null;
        }
    }
    // need to change default wait : use this method
    public T setTextValue(String value, boolean setImplecitWait, int waitTimeSec) {
        log.info(" setTextValue() to : " + value);
        //try{Thread.sleep(10);}catch (Exception e){} // todo : investigate why sometime second name or pass not entered on form
        /*if(setImplecitWait) {
            WaitTool.resetImplicitWait(this.webDriver, waitTimeSec );
        }*/
        return this.sendKeys(value);
    }
    public T clearAndClickInInput() {
        this.getWebElement().clear();
        return this.click();
    }

    public T focusByTypeClearClick(){
        try {
            this.sendKeys("n");
            this.getWebElement().clear();
            return this.click();
        } catch (Exception e){
            log.error("Can't focusByTypeClearClick "+TestUtil.getException(e));
            return null;
        }
    }
    // focus only for a specific browser ; to speed up the test - only click for other browsers
    public T focusByTypeClearClick(String browser) {
        if (BaseRemoteWebDriver.getCurrentBrowserName().contains("explore")) {
            focusByTypeClearClick();
        } else {
            log.warn("Do not focus for this browser :  "+BaseRemoteWebDriver.getCurrentBrowserName());
        }
        return this.click();
    }

    // if click is not selecting the element action click is used . nOte : IE11 click is not working OS forms
    public T ensureChecked() {
        try {
            this.scrollTo();     try{sleep(200);}catch (InterruptedException ie){}
            if (!this.getWebElement().isSelected()) {
                this.getWebElement().click();
                log.info("Clicked to select checkbox");
            }
//            if( ! this.getWebElement().isSelected()){
//                MyWebDriverAction.actionClick(webDriver, this.getWebElement());
//                log.info(" Used action to selected checkbox ...!");
//            }
        }catch (Exception e){
            log.error(" Ensure element is Selected Exception :"+TestUtil.getExceptionFirstLine(e));//+e.getCause()
            //try this IE10 issue ...
            MyWebDriverAction.actionClick(webDriver, this.getWebElement());
            log.info(" got exception so actionClick ... Used action to selected checkbox ...!");

        }
        return parentContainer;
    }
    public static void ensureCheckBoxChecked(WebElement we) {
        try {
            if (!we.isSelected()) {
                we.click();
                log.info("Clicked to select checkbox");
            }
        }catch (Exception e){
            log.error(" Ensure element is Selected Exception :"+TestUtil.getExceptionFirstLine(e));

        }
    }

    public T selectValue(String value) {
        log.info("selectValue : "+value);
        try {
            scrollTo();
            click();
            Select select = new Select(this.getWebElement());
            select.selectByValue(value);
            sendReturnKey(); //this.getWebElement().sendKeys(Keys.RETURN);
            try{Thread.sleep(50);}catch(InterruptedException ie){}
        }catch(WebDriverException e){
            log.error(" selectValue Exception : "+ TestUtil.getException(e, webDriver));
        }
        return parentContainer;
    }

    public T selectIndex(int index) {
        log.info("selectIndex : " + index);
        try {
            scrollTo();
            click();
            Select select = new Select(this.getWebElement());
            select.selectByIndex(index);
            sendReturnKey(); //this.getWebElement().sendKeys(Keys.RETURN);

        }catch(WebDriverException e){
            log.error(" selectValue Exception : "+TestUtil.getException(e, webDriver));
        }
        return parentContainer;
    }

    public static void selectByIndex(WebDriver driver, By selector, int index) {
        WebElement we = driver.findElement(selector);
        selectByIndex(driver, we, index);
    }

    public static void selectByIndex(WebDriver driver, WebElement we, int index) {
        log.info("selectIndex : " + index);
        try {
            Select select = new Select(we);
            select.selectByIndex(index);            //if(!BaseRemoteWebDriver.isBrowser("explore")) {  // EC fail second step to send return key     //we.sendKeys(Keys.RETURN);            //}
        }catch(Exception e){
            log.error("Could not select By Index Exception ...! "+TestUtil.getException(e, driver));
            BasePage.failTest(e, "selectByIndex Failed ...!", true);
        }
    }

    public static void selectByValue(WebDriver driver, WebElement selectWe, String value) {
        log.info("selectByValue [{}]", value);
        try {
            Select select = new Select(selectWe);
            select.selectByValue(value);
            sleep(100);
        }catch(Exception e){
            log.error("Could not select By Value Exception ...! "+TestUtil.getException(e, driver));
            BasePage.failTest(e, "selectByValue Failed ...! Value :"+value, true);
        }
    }

    public static void selectByVisibilityText(WebDriver driver, WebElement selectWe, String text) {
        log.info("selectByText [{}]", text);
        try {
            Select select = new Select(selectWe);
            select.selectByVisibleText(text);
            sleep(100);
        }catch(Exception e){
            log.error("Could not select By Text Exception ...! "+TestUtil.getException(e, driver));
            BasePage.failTest(e, "selectByText Failed ...! Text :"+text, true);
        }
    }

    public T selectText(String value) {
        scrollTo();
        Select select = new Select(this.getWebElement());
        select.selectByVisibleText(value);
        return parentContainer;
    }

    public static WebElement getSelectedOptionWe(WebElement selectWe) {
        Select select = new Select(selectWe);
        return select.getFirstSelectedOption();
    }

    public static void selectOptinUsingDownArrowKey(WebElement webElement, int numberOfKeyPresed, Keys key){
        log.info("selectOptinUsingDownArrowKey ... press NO: " + numberOfKeyPresed);
        for(int i=0; i<numberOfKeyPresed; i++){
            webElement.sendKeys(key);
        }
    }
    public T scrollTo() {
        if(this.enableAutoScroll) {
            scrollToElementLocation(this.webDriver, this.getWebElement(),0,20);
        }
        return parentContainer;
    }

    public void sendReturnKey(){
        this.getWebElement().sendKeys(Keys.RETURN);
    }

    public void resolveElement() {
        for (By selector : selectors) {
            this.webElement = WaitTool.safeFindDisplayedAndEnabled(webDriver,selector, WaitTool.DEFAULT_WAIT_4_ELEMENT); //safeFindElement(this.parentElement, selector);
            if (this.webElement != null) {
                log.info("Found element [{}] with selector [{}]", this.webElement, selector);
                break;
            }
        }
    }

    public T click() {
        try {
            scrollTo();
            sleep(50);
            this.getWebElement().click();
        }catch(Exception e){}
        return parentContainer;
    }

    public static void click(WebElement webElement){
        log.info(" Click on WebElement [{}] ", webElement);
        try {
            if(webElement != null){
                //if(webElement.isEnabled() && webElement.isDisplayed())
                    webElement.click();
                //else       BasePage.failTest("Cant click on not Enabled or Not Displayed WebElement ...!", true);
            } else {
                BasePage.failTest("Can't click on NULL WebElement ...!", true);
            }
        }catch (WebDriverException wde){
            BasePage.failTest("Failed to click on WebElement ...!\n"+wde.getMessage(),webElement, true);
        }
    }

    public static void click(List<WebElement> listWebElement, int index){
        log.info(" Click on WebElement [{}] , index :"+index, listWebElement);
        try {
            if(listWebElement != null && index < (listWebElement.size())) {
                log.info(" will try to click on we ...!");
                click(listWebElement.get(index));
            } else {
                log.info("Can't click on NULL WebElement or Index greater or equal to size [OutOfBoundsException]...!", true);
            }
        }catch (IndexOutOfBoundsException e){
            BasePage.failTest("[IndexOutOfBoundsException] Failed to click on WebElement ...!\n"+e.getMessage(),true);
        }
    }

    public static void submit(WebElement webElement){
        log.info(" Call submit() on WebElement [{}] ", webElement);
        try {
            if(webElement != null) {
                webElement.submit();
            } else {
                BasePage.failTest("Can't submit on NULL WebElement ...!", true);
            }
        }catch (WebDriverException wde){
            BasePage.failTest("Failed to submit on WebElement ...!\n"+wde.getMessage(),webElement, true);
        }
    }

    public static void javaScriptClick(WebDriver driver, String elementCssSelector){
        try {
            JavaScriptHelper.click(driver, elementCssSelector);
        }catch (WebDriverException e){
            e.printStackTrace();
            BasePage.failTest("JavascriptExecutor Failed to click on WebElement elementCssSelector ["+
                    elementCssSelector+"] \n"+e.getCause(), true);
        }

    }

    public T setAutoScroll(boolean enableAutoScroll) {
        this.enableAutoScroll = enableAutoScroll;
        return parentContainer;
    }

    /***************************************************************
     * get WebElement by locator e.g : 'class name: nextBtn']
     ***************************************************************/
    //TODO check this with selenium 3
    public static String getElementLocator(WebElement webElement){
        String splitOn = " -> ";
        String locatedBy = null;
        String errorMsg = null;
        if(webElement != null) {
            try {
                locatedBy = webElement.toString().split(splitOn)[1].split("]")[0].split(":")[1].trim();
            }catch (ArrayIndexOutOfBoundsException e){
                errorMsg = "getElementLocator : Trying to get locatedBy from web Element; ArrayIndexOutOfBoundsException ...!";
                log.error(" ArrayIndexOutOfBoundsException ...! "+TestUtil.getException(e));
            }
        } else {
            log.warn(" WebElement is null ...!");
        }
        log.info("getElementLocator : "+locatedBy);
        return locatedBy;
    }

    /*************************************************************************************************************
     * Click on Tab using link text
     *
     * @param webDriver     * @param linkText
     */
    public static void clickOnTabByLinkText(WebDriver webDriver, String linkText){
        log.info(" click on tab : linkText = "+linkText);
        try {
            WaitTool.safeFindDisplayedAndEnabled(webDriver, By.linkText(linkText), WaitTool.MED_WAIT_4_ELEMENT);
            Thread.sleep(1500);
            
            WebElement tab = WaitTool.waitForElementClickable(webDriver, By.linkText(linkText), WaitTool.DEFAULT_WAIT_4_ELEMENT);

            if(BaseRemoteWebDriver.currentDeviceName !=null && "NexusOne".contains(BaseRemoteWebDriver.currentDeviceName)) {
                JavaScriptHelper.highlightElement(tab, webDriver);
                Thread.sleep(500);
                MyWebDriverAction.moveToElementAndClick(webDriver, tab);
            }else {
                tab.click(); // does not work on mobile nexus
            }
            log.info(" Clicked on Tab  ...!");
            Thread.sleep(500);
        }catch (NoSuchElementException | NullPointerException e){
            BasePage.failTest(e, " - clickOnTab  : Exception : ", true);                                                 //           fail(" - clickOnTab  : Exception : " + TestUtil.getException(e, webDriver));
        }catch (Exception ex){
            BasePage.failTest(ex, "General error - clickOnTab  : Exception : ", true);                                                    //            fail(" - clickOnTab  : Exception : "+ TestUtil.getException(ex, webDriver));
        }
    }
    // issue on FF 36.0  the click is not working
    public static void clickOnTabId(WebDriver webDriver, By byElement, int id){
        log.info(" click on tab id : " + id);
        try {
            List<WebElement> weAllTabs = getVisibleElements(webDriver, byElement);                              //WaitTool.waitForListElementsPresent(webDriver, byElement, WaitTool.DEFAULT_WAIT_4_ELEMENT);  //
            //nexus Cant click on point chrome on nexus error
            if(BaseRemoteWebDriver.currentDeviceName !=null && "NexusOne".contains(BaseRemoteWebDriver.currentDeviceName)) {
                JavaScriptHelper.highlightElement(weAllTabs.get(id), webDriver);
            }
            weAllTabs.get(id).click();
            log.info(" Clicked on Tab id : ", id);
            try{sleep(1000);}catch (InterruptedException e){}
        }catch (NoSuchElementException | NullPointerException | IndexOutOfBoundsException e){
            BasePage.failTest(e, " - clickOnTabId  : Exception : ", true);  //            fail(byElement+" - clickOnTabId  : Exception : "+ TestUtil.getException(e, webDriver));
        }catch (Exception ex){
            BasePage.failTest(ex," - clickOnTabId  : Exception : ", true); //            fail(byElement+" - clickOnTabId  : Exception : "+ TestUtil.getException(ex, webDriver));
        }
    }

    /*******************************************************************************************************************
     * Safe find element displayed and enabled,
     * wait to find it
     * scroll and click element
     ******************************************************************************************************************/
    public static void safeFindAndClick(WebDriver driver,By selector){
        WebElement submitElement = safeFindElement(driver, selector);
        scrollAndClick(driver, submitElement);
    }

    /**
     * Focus on element
     *  IF input tag : use :=> sendKey('n') then clear()
     *  ELSE Action.mobeToElement(we).perform()
     */
    public static void focusOnElementUsingSendKeyOrAction(WebElement webElement, WebDriver driver){
        try{
            if("input".equals(webElement.getTagName())) {
                webElement.sendKeys("n");
                webElement.clear();
                Thread.sleep(100);
                log.info("focusOnElementUsingSendKeyOrAction  .. send 'n' key to input");
            }else{
                new Actions(driver).moveToElement(webElement).perform();
                log.info("focusOnElementUsingSendKeyOrAction  .. send Action moveToElement then perform");
            }
        }catch (TimeoutException | NoSuchElementException |ElementNotVisibleException | StaleElementReferenceException
                                                                                      | InterruptedException e ){
            log.error("Exception ...! " +TestUtil.getExceptionFirstLine(e));
        }
    }

    /**
     * @Returns emptyLIst if no visible element found otherwise a list of visible elements
     *
     */
    public static List<WebElement> getVisibleElements(WebDriver driver, By bySelector){
        List <WebElement> webElementList = new ArrayList();
        int count = 0;
        try{
            // todo use safeFindElements - to wait longer for elements
            List<WebElement> allWe = driver.findElements(bySelector);
            int listSize = allWe.size();
            log.info(" Size of list is : "+listSize);

            if(listSize < 1){
                log.warn(" List is empty  for selector " + bySelector);
                return null;
            } else if(listSize==1){
                if(allWe.get(0).isDisplayed()){
                    webElementList.add(allWe.get(0));
                    log.info(" List size is =1 and Element is displayed ...!");
                    return webElementList;
                }else {
                    log.warn("  List size is =1 and Element is not Displayed ");
                    return null;
                }
            } else {
                for (WebElement ele : allWe) {
                    System.out.println(" ele " + count + " :  " + ele.getText() + "");
                    if (ele.isDisplayed()) {
                        webElementList.add(ele); //allWe.get(count));
                        log.info(" Found visible element at index :"+count);
                    }
                    count++;
                }
                log.info(" No of Visible element found :"+count);
                return webElementList;
            }
        }catch(NoSuchElementException | ElementNotVisibleException | StaleElementReferenceException e){
            log.error(" Exception ..."+ TestUtil.getExceptionFirstLine(e));  //+e.getCause()
            return Collections.emptyList();
        }
        catch(WebDriverException e){
            log.error(" WebDriverException ..."+ TestUtil.getExceptionFirstLine(e));  //+e.getCause()
            return Collections.emptyList();
        }

    }

    /***
     * Find all the elements and then get fist visible one
     * webdriver isDisplayed defines if a element is visible
     *  Note: No wait     *
     */
    public static WebElement getFirstVisibleElement(WebDriver driver, By bySelector){
        WebElement we = null;
        int count = 0;
        try{
            List<WebElement> allWe = driver.findElements(bySelector);
            int listSize = allWe.size();
            log.info(" Size of list is : "+listSize);

            if(listSize < 1){
                log.warn(" List is empty  for selector " + bySelector);
                return null;
            } else if(listSize==1){
                if(allWe.get(0).isDisplayed()){
                    we = allWe.get(0);
                    log.info(" List size is =1 and Element is displayed ...!");
                    return we;
                }else {
                    log.warn("  List size is =1 and Element is not Displayed " );
                    return null;
                }
            } else {
                for (WebElement ele : allWe) {
                    if (ele.isDisplayed()) {
                        we = ele;
                        return we;
                    }
                    count++;
                }
            }
        }catch(NoSuchElementException | StaleElementReferenceException | IndexOutOfBoundsException e){
            log.error(" Exception ... NoSuchElementException | StaleElementReferenceException " +
                    TestUtil.getException(e));
        }
        return we;
    }

    public static void clickListStep(WebDriver driver, By byWe, int index){
        try {
            driver.findElements(byWe).get(index).click();
        }catch (ElementNotVisibleException e){
            log.error("clickStep : ElementNotVisibleException .. "+TestUtil.getExceptionFirstLine(e));
        }
    }

    public static WebElementStatus isElementStatus(WebDriver driver, By by, WebElementStatus status){
        try{
            //List<WebElement> webElement = driver.findElements(by);//
            WebElement webElement = driver.findElement(by);
            if(webElement == null){
                throw new NoSuchElementException(by.toString());
            }
            switch (status){
                case ENABLED:
                    if(webElement.isEnabled())
                        return WebElementStatus.ENABLED;
                    return WebElementStatus.NOTENABLED;
                case VISIBLE:
                    if(webElement.isDisplayed())
                        return WebElementStatus.VISIBLE;
                    return WebElementStatus.NOTVISIBLE;
                case PRESENT:
                    if(webElement != null) // ??????
                        return WebElementStatus.PRESENT;
                    return WebElementStatus.NOTPRESENT;
                case SELECTED:
                    if(webElement.isSelected())
                        return WebElementStatus.SELECTED;
                    return WebElementStatus.NOTSELECTED;
                default: log.error("Status is not in the allowed list ....!"+status);
            }
        }catch(NoSuchElementException e){
            log.error(e.getMessage());
            return WebElementStatus.NOTPRESENT;
        }
        return WebElementStatus.UNKNOWN;
    }
    public static WebElementStatus isElementStatus(WebDriver driver, WebElement webElement, WebElementStatus status){
        try{
            switch (status){
                case ENABLED:
                    if(webElement.isEnabled())
                        return WebElementStatus.ENABLED;
                    return WebElementStatus.NOTENABLED;
                case VISIBLE:
                    if(webElement.isDisplayed())
                        return WebElementStatus.VISIBLE;
                    return WebElementStatus.NOTVISIBLE;
                case PRESENT:
                    if(webElement != null) // ??????
                        return WebElementStatus.PRESENT;
                    return WebElementStatus.NOTPRESENT;
                case SELECTED:
                    if(webElement.isSelected())
                        return WebElementStatus.SELECTED;
                    return WebElementStatus.NOTSELECTED;
                default: log.error("Status is not in the alowed list ....!"+status);
            }
        }catch( NoSuchElementException e){
            log.error(e.getMessage());
            return WebElementStatus.NOTPRESENT;
        }
        return WebElementStatus.UNKNOWN;
    }


    /**
     * handles exceptions
     * @param driver
     * @param sourceElement
     * Note : is not working draging to a frame in cq  stale
     */
    public static void dragAndDrop(WebDriver driver, WebElement sourceElement){ //, WebElement destinationElement) {
        try {
            //if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
                Actions action = new Actions(driver);
                action.clickAndHold(sourceElement).build().perform();
            WebDriverWindowHelper.switchToFrameByFrameId(driver, CqEditAuthoringPage.getFrameName(), 15);
            CqEditAuthoringPage cqEditAuthoringPage = new CqEditAuthoringPage(driver);
            WebElement toWe = cqEditAuthoringPage.dropContainerListWe.get(0);
            log.info(toWe.getLocation().toString());
                action.moveToElement(toWe, 3, 3).click().build().perform();
                action.release(toWe).build().perform();

                action.dragAndDrop(sourceElement, toWe).build().perform();       //Actions dragdrop = new Actions(driver);  dragdrop.clickAndHold(source).moveToElement(target).release(target).build().perform();
           // } else {
           //     BasePage.failTest("Element was not displayed; Can not do drag/drop on invisible element ...!");
           // }
        } catch (StaleElementReferenceException e) {
            //BasePage.failTest("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document " + e.getCause());
        } catch (NoSuchElementException e) {
            //BasePage.failTest("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getCause());
        } catch (Exception e) {
            BasePage.failTest("Error occurred while performing drag and drop operation "+ e.getCause());
        }
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        try {
            Actions action = new Actions(driver).doubleClick(element);
            action.build().perform();
            sleep(2000);
            log.info("Double clicked the element");
        } catch (StaleElementReferenceException e) {
            log.info("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            log.info("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            log.info("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();
            log.info("Successfully Right clicked on the element "+element);
        } catch (StaleElementReferenceException e) {
            log.error("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            log.error("Element " + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            log.error("Element " + element + " was not clickable " + e.getStackTrace());
        }
    }

    public static void rightClickArrowAndEnter(WebDriver driver, WebElement element, int noOfArrowDown) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            sleep(3000);
            for(int i=0; i< noOfArrowDown; i++) {
                action.sendKeys(Keys.ARROW_DOWN);
                log.info(" arrow down "+i);
            }
            action.sendKeys(Keys.ENTER).build().perform();
            log.info("Successfully Right clicked on the element "+element+" Arrow down ["+noOfArrowDown+"] times ...!");
        } catch (StaleElementReferenceException e) {
            log.error("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            log.error("Element " + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            log.error("Element " + element + " was not clickable " + e.getStackTrace());
        }
    }

    public static void arrowAndEnter(WebDriver driver, int noOfArrowDown) {
        try {
            Actions action = new Actions(driver);

            for(int i=0; i< noOfArrowDown; i++) {
                action.sendKeys(Keys.ARROW_DOWN);
                log.info(" arrow down "+i);
            }
            action.sendKeys(Keys.ENTER).build().perform();
            log.info("Successfully arrowAndEnter  ..["+noOfArrowDown+"] times ...!");
        } catch (Exception e) {
            log.error("arrowAndEnter action NOT performed ...! " + e.getStackTrace());
        }
    }


}

/**
 * Actions oAction=new Actions(driver);
 oAction.moveToElement(oWE);
 //method sendKeys(Keys.ARROW_DOWN) is used to select an option from the list.
 oAction.contextClick(oWE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
 builder.contextClick(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
 *
 Actions builder = new Actions(driver);
 Action dragAndDrop = builder.clickAndHold(FromWe)
    .moveToElement(ToWe)
    .release(ToWe)
    .build();
    dragAndDrop.perform();
 */

