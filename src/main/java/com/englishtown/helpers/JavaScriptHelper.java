package com.englishtown.helpers;

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by nikol.marku on 09/03/2015.
 *
 * Helper method using Webdriver JS executor
 * http://www.swtestacademy.com/selenium-11-javascriptexecutor/
 * https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html#executeAsyncScript-java.lang.String-java.lang.Object...-
 */
public class JavaScriptHelper implements IJavaScriptHelper{
    private static final Logger logger = LoggerFactory.getLogger(JavaScriptHelper.class);

    public static final String DOCUMENT_READYSTATE_SCRIPT  = "return document.readyState";
    public static final String HIGHLIGHT_ELEMENT_SCRIPT    = "element = arguments[0];original_style = element.getAttribute('style');" +
            "element.setAttribute('style', original_style + \"; background: yellow; border: 2px solid red;\");" +
            "setTimeout(function(){element.setAttribute('style', original_style);}, 5000);";
    private static final String CLEAR_LOCAL_STOREAGE = "localStorage.clear()";
    public static final String CHECKOUT_FLOW_TYPE = "tracking.checkout_flow_type" ;
    // construct this $('nav .menu a').filter(':visible')
    public static final String JQUERY_SCRIPT_START = "return $('";
    public static final String JQUERY_SCRIPT_FILTER = "').filter(':visible')";
    public static final String JS_SCROLL_INSIDE_DIV_VERTICALLY   = "arguments[0].scrollTop = arguments[1];";
    public static final String JS_SCROLL_INSIDE_DIV_HORIZONTALLY = "arguments[0].scrollLeft = arguments[1];";


    /**  highlight Element. */
    public static void highlightElement(WebElement element, WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(HIGHLIGHT_ELEMENT_SCRIPT, element);
        }catch (Exception e){
            logger.error("highlightElement() Exception : " + TestUtil.getException(e, driver));
        }
    }

    public static void clearLocalStorageJS(WebDriver driver){
        JavaScriptHelper.executeJavaScript(CLEAR_LOCAL_STOREAGE, driver);
    }

    public static void javaScriptWindowFocus(WebDriver driver){
        logger.info("jsWindowFocus() ....");
        String js = "window.focus();";
        try{
            ((JavascriptExecutor) driver).executeScript(js);
        }catch(Exception e){
            logger.error("jsWindowFocus Exception executing script :" + js + " ....!" + TestUtil.getException(e, driver));
        }
    }
    /*******************************************************************************************************************
     * Wait for : document.readyState==complete
     * Nullify script timeout and set it back to default
     *
     */
    public static void waitForPageLoaded(WebDriver driver, int waitTimeSec) {
        logger.info("waitForPageLoaded ....! document.readyState is equals to [complete] ");
        WaitTool.setJavaScriptTimeout(driver, waitTimeSec);
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                  public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript(DOCUMENT_READYSTATE_SCRIPT).equals("complete");
                  }
                };
        WebDriverWait wait = new WebDriverWait(driver, waitTimeSec);
        try {
            wait.until(expectation);
            WaitTool.setJavaScriptDefaultTimeout(driver);
            logger.info(" Page loaded ....!");
        } catch (Exception error) {
            WaitTool.setJavaScriptDefaultTimeout(driver);
            logger.error("waitForPageLoaded Error ...!"+TestUtil.getException(error, driver));
            assertFalse("Timeout waiting for Page Load Request to complete. Time waited : " + waitTimeSec, true);
        }
    }

    /*******************************************************************************************************************
     * Click
     *
     */
    public static void clickAtWindowXY(WebDriver webDriver, int x, int y){
        logger.info("Click at window : x ="+x+" ; y = "+y  );
        String jsClickScript=("document.elementFromPoint("+x+","+y+").click();");
        try{
            ((JavascriptExecutor) webDriver).executeScript(jsClickScript);
            logger.info("JS Clicked at window : x ="+x+" ; y = "+y  );
        }catch (Exception e){
            logger.error("clickAtWindow Exception  ...! " + TestUtil.getException(e, webDriver));
        }
    }
    // click at X and Y of an web element
    public static void clickAtWebElementXY(WebDriver webDriver, WebElement webElement){
        JavaScriptHelper.clickAtWindowXY(webDriver, webElement.getLocation().getX(), webElement.getLocation().getX());
    }

    public static void click(WebDriver driver, String elementCssSelector) throws WebDriverException{
        logger.info("JavaScript click on element Css ["+elementCssSelector+"]");
        try {
            ((JavascriptExecutor)driver).executeScript("document.querySelector('"+elementCssSelector+"').click()");
        }catch (WebDriverException e){
            e.printStackTrace();
            BasePage.failTest("JavascriptExecutor Failed to click on WebElement elementCssSelector ["+
                    elementCssSelector+"] \n"+e.getCause(), true);
        }
    }

    public static void click(WebDriver driver, String elementCssSelector, int elementId) throws WebDriverException{
        logger.info("JavaScript click on element Css ["+elementCssSelector+"]");
        try {
            ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('"+elementCssSelector+"')["+elementId+"].click()");
        }catch (WebDriverException e){
            e.printStackTrace();
            BasePage.failTest("JavascriptExecutor Failed to click on WebElement elementCssSelector ["+
                    elementCssSelector+"] \n"+e.getCause(), true);
        }
    }


    /******************************************************************************************************************
     *  JS scroll     *
     */
    public static void scrollIntoViewById(WebDriver driver, String elementId, boolean isView){
        String script ="document.getElementById('"+elementId+"').scrollIntoView("+isView+");";
        executeJavaScript(script, driver);
    }
    public static void scrollByLines(WebDriver driver, int noOfLines){
        String script = "window.scrollByLines("+noOfLines+")";
        executeJavaScript(script, driver);
    }

    // document.body.scrollTop = 0; // For Safari
    // document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
    /**
     *
     * @param driver
     * @param x
     * @param y
     */
    public static void scrollToXY(WebDriver driver, int x, int y){
        String script ="javascript:window.scrollBy("+x+","+y+")";
        executeJavaScript(script, driver);
    }

    /**
     * window.innerHeight - the inner height of the browser window (in pixels)
     * window.innerWidth - the inner width of the browser window (in pixels)
     * Bring element to view - Middle of screen
     * Note : get window view port [visible window] - > use window.innerHeight = y   window.innerWidth  = x OR  window.screen :   Screen {orientation: ScreenOrientation, availWidth: 1920, availHeight: 1080, availTop: 0, availLeft: 1920…}
     * Note: this does not fail the test
     *scrollRegulator  - to make sure element is on view increase the scroll by this value - default = 20
     */
    public static void scrollWebElementToView(WebDriver webDriver, WebElement webElement, ElementScreenPosition elementScreenPosition,  int scrollRegulator){
        logger.info("scrollWebElementToView .....");
        boolean isWeInView = false;
        Point scrollToPoint = new Point(0,0);
        int outOfViewXdif;
        int outOfViewYdif;

        if(webElement != null ) {
            if( webDriver != null) {
                try {
                    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;                              //Object result = (Object)javascriptExecutor.executeScript(" var input = window.screen; return input;","");
                    Dimension winSize = webDriver.manage().window().getSize();                                           // dimension seen to consider full window size
                    Point wePoint = webElement.getLocation();
                    logger.info("dimension width :'"       + winSize.getWidth() + "' heigh :'"+winSize.getHeight()+"'");
                    logger.info("WebElement Point X is :'" + wePoint.getX()     + "' Y is  :'"+wePoint.getY() + "'");
                    // not working try to use element.scrollIntoView({behavior: "instant", block: “center”});
                    // need to find the view window coordinates
                    if (wePoint.getY() < winSize.getHeight() && wePoint.getX() < winSize.getWidth()) {
                        isWeInView = true;
                        logger.info("NO need to scroll. Element is in view ...!");
                    } else {
                        logger.info("Need to scroll Element in view ...!");
                        if(elementScreenPosition == ElementScreenPosition.TOP ){
                            logger.info("Scroll to top ...!");
                            scrollToPoint = new Point(wePoint.getX(), wePoint.getY());
                        }
                        else if(elementScreenPosition == ElementScreenPosition.BUTTON ){
                            logger.info("Scroll to button ...!");
                            scrollToPoint = getScrollingPoint(wePoint, winSize);
                            scrollToPoint = new Point(scrollToPoint.getX(), scrollToPoint.getY()+scrollRegulator );
                        }
                        else {
                            logger.info("Scroll to Middle ...!");
                            outOfViewXdif = Math.abs(wePoint.getX() - winSize.getWidth() / 2) + scrollRegulator;             // to bring in the middle
                            outOfViewYdif = Math.abs(wePoint.getY() - winSize.getHeight() / 2) + scrollRegulator;
                            logger.info("outOfView X and Y dif plus 10 regulator value is :" + outOfViewXdif + ", " + outOfViewYdif);
                            scrollToPoint = new Point(outOfViewXdif, outOfViewYdif);
                        }
                        logger.info("Scroll to Point X and Y :" + scrollToPoint.getX() + ", " + scrollToPoint.getY());
                        javascriptExecutor.executeScript("window.scrollTo(" + scrollToPoint.getX() + "," + scrollToPoint.getY() + ")", "");
                        sleep(300);
                    }
                }catch (Exception e){
                    logger.error(" scrollWebElementToView Exception :  " + TestUtil.getException(e, webDriver));
                }
            }else { logger.error(" Cant't scroll webdriver is null...!");   }
        } else {     logger.error(" Cant't scroll to null webElement, OR use null webdriver ...!");    }
    }

    /**
     * Scroll horisontally to view
     * @param webDriver
     * @param by
     * @param elementScreenPosition
     * @param scrollRegulator
     *
     */
    public static void scrollWebElementToView(WebDriver webDriver, By by, ElementScreenPosition elementScreenPosition,  int scrollRegulator){
        logger.info("scrollWebElementToView .....");
        Dimension browserWindowDimension = null; //inner view or view
        Dimension webElementDimension  = null ;
        Point webElementPoint =null;
        Point webElementLowerRightPoint = null;
        WebElement webElement = null;

        try{
            webElement = webDriver.findElement(by);
            webElementDimension = webElement.getSize();
            webElementPoint = webElement.getLocation();        // top left hand corner of element
            logger.info("WE dimensions : "+ webElementDimension.toString()) ;
            logger.info("WE Point TopLeftCorner : "+ webElementPoint.toString()) ;
        } catch (WebDriverException  wde){
            logger.error(" Cant find WebElement : "+by);
            logger.error(wde.getMessage());
        }

        if(webElement != null ) {
            if( webDriver != null) {
                try {
                    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
                    try {
                        int tempWindWidth = Integer.parseInt(executeJavaScript("return window.innerWidth", webDriver, 3));
                        int tempWindHight = Integer.parseInt(executeJavaScript("return window.innerHeight", webDriver, 3));
                        browserWindowDimension = new Dimension(tempWindWidth, tempWindHight);
                        logger.info("Window innerWidth and Height : "+browserWindowDimension.toString());
                    }catch (NumberFormatException nfe){ logger.error(" Cant get Window width : "+nfe.getMessage());}
                    //get lower right corner point of web element
                    webElementLowerRightPoint = new Point(webElementPoint.getX()+webElementDimension.getWidth(), webElementPoint.getY()+webElementDimension.getHeight());
                    /**
                     * Check if element is in full view ; if not then scroll it to view
                     */
                    if (isWebElementInView(browserWindowDimension, webElementLowerRightPoint) ){
                        logger.info("NO need to scroll. Element is in view ...!");
                    } else {
                        scrollToPoint(browserWindowDimension, webElementPoint, webElementLowerRightPoint, elementScreenPosition, javascriptExecutor, scrollRegulator );
                    }
                }catch (Exception e){
                    logger.error(" scrollWebElementToView Exception :  " + TestUtil.getException(e, webDriver));
                }
            }else { logger.error(" Cant't scroll webdriver is null...!");   }
        } else {     logger.error(" Cant't scroll to null webElement, OR use null webdriver ...!");    }
    }


    /**
     *  Scroll inside the window (div pop up)
     *
     *
     * @param driver
     * @param element
     * @param scrollPixes
     * @param scrollDirection
     *
     */
      public static void scrollInsidePopupWindow(WebDriver driver, WebElement element, int scrollPixes, ScrollDirection scrollDirection){
          String scrollScript = JS_SCROLL_INSIDE_DIV_HORIZONTALLY;

          if(scrollDirection == ScrollDirection.VERTICALLY){
              scrollScript = JS_SCROLL_INSIDE_DIV_VERTICALLY;
              logger.info(" Scrolling Vertically ....!");
          }else{
              logger.info(" Scrolling Vertically ....!");
          }

          logger.info("Scroll script is ['"+scrollScript+"']");

          try {
              JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].scrollTop = arguments[1];", element, scrollPixes);
          }catch (Exception e){
              logger.error(" scrollInsidePopupWindow Exception :  " + e.getCause());
              BaseTest.failTest("Could Notscroll to element ....!");
          }
      }



    // get the diference between window size and element location
    public static Point getScrollingPoint( Point wePoint, Dimension windSize){
        logger.info("getScrollingPoint() ...!");
        int outOfViewXdif = ( Math.abs(wePoint.getX() - windSize.getWidth() ));
        int outOfViewYdif = ( Math.abs(wePoint.getY() - windSize.getHeight()));
        logger.info("outOfView X and Y dif value is :" + outOfViewXdif + ", " + outOfViewYdif);
        Point scrollToPoint = new Point(outOfViewXdif, outOfViewYdif);

        return scrollToPoint;
    }


    /**
     * Scroll vertically and horizontally to view Document
     * @param windowSize
     * @param weTopLeftPoint
     * @param weBottomRightCorner
     * @param wePosition
     * @param javascriptExecutor
     *  scrollRegulator : pixels just in case there is a floating bar on the top to cover the element
     *
     */
    public static void scrollToPoint(Dimension windowSize, Point weTopLeftPoint, Point weBottomRightCorner,
                                 ElementScreenPosition wePosition, JavascriptExecutor javascriptExecutor, int scrollRegulator ){
        Point scrollToPoint = new Point(0, 0);
        int x = 0;
        int y = 0;
       //
        //TODO scroll horizontally as well
        logger.info("Scroll ...!");
        try {
            if (wePosition == ElementScreenPosition.TOP) {
                logger.info("Scroll to top ...!");
                y = Math.abs(weTopLeftPoint.getY()-scrollRegulator);
                int weBRC = weBottomRightCorner.getX();
                x = weBRC > windowSize.getWidth() ? Math.abs((weBRC -windowSize.getWidth())+scrollRegulator) : 0 ;
                scrollToPoint = new Point(x, y);
            } else if (wePosition == ElementScreenPosition.BUTTON) {
                logger.info("Scroll to button right corner ...!");
                y = Math.abs(weBottomRightCorner.getY() - windowSize.getHeight());
                x = Math.abs(weBottomRightCorner.getX() - windowSize.getWidth() );
                scrollToPoint = new Point(x, y);
            } else {
                logger.info("Scroll to Middle ...!");
                y = Math.abs(weBottomRightCorner.getY() - (windowSize.getHeight()/2));
                x = Math.abs(weBottomRightCorner.getX() - (windowSize.getWidth()/2));
                scrollToPoint = new Point(x, y);
            }
            logger.info("Scroll to Point :" + scrollToPoint.toString());
            javascriptExecutor.executeScript("window.scrollTo(" + scrollToPoint.getX() + "," + scrollToPoint.getY() + ")", "");
            sleep(10000);
        }catch (Exception e ){
            logger.error("getScrollToPoint exception : "+e.getMessage());
        }
    }

    /**
     * Check if an web element is in view or not
     * @param windowSize        - Html doc view     * //@param webElementPoint   - topLeft corner ... could be replaced with bottom right corner    * @param webElementDimension - WE size H and W
     * @return false or true
     */
    public static boolean isWebElementInView(Dimension windowSize, Point webElementBottomRightCornerPoint ){
        boolean isWePointXinView = webElementBottomRightCornerPoint.getX() <= windowSize.getWidth();
        boolean isWePointYinView = webElementBottomRightCornerPoint.getY() <= windowSize.getHeight();
        if(isWePointXinView && isWePointYinView){
            return true;
        }else
        return false;
    }

    /**
     * Add Div to form html
     *
     */
    public static void addDivToForm(WebDriver driver, By by, String html) {
        logger.info(" Start addDivToHTML ...!");
        try {
            WebElement webElement = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("var form=document.getElementsByTagName('form')[0];" +
                    "var div = document.createElement('div');" +
                    " div.innerHTML='" + StringEscapeUtils.escapeJavaScript(html) +
                    "'; input=div.children[0]; " +
                    "form.appendChild(div)",webElement);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
    * Replace add new html on the page
    */
    public static void replaceHTML(WebDriver driver, By by, String html) {
        logger.info(" Start replaceHTML");
        WebElement e = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML='" + StringEscapeUtils.escapeJavaScript(html) + "'", e);
        logger.info("Page Source after replace : \n " + driver.getPageSource());
    }

    /**
     * Set value of an element using JS
     * TODO: this need testing .....
     *
     */
    public static void seValue(WebDriver driver, String attr, String value, By byLocator) {
        try {
            String script = "arguments[0].setAttribute('"+attr+"', '"+value+"')";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(byLocator);
            js.executeScript(script, element);
        }catch (Exception e){
            logger.error(" set value exception ...!"+TestUtil.getException(e,driver) );
        }
    }

    public static void executeJavaScript(String script, WebDriver webDriver)   {
        logger.info("execute JavaScript [{}] ...!", script);
        try {
            ((JavascriptExecutor) webDriver).executeScript(script);
        }catch (Exception e){
            logger.error("executeJavaScript Exception ..."+TestUtil.getException(e));
        }
    }

    /**
     * Get the Java script result using async method
     * @param script
     * @param driver
     * @param jsTimeout
     * @return result as string or null
     */
    public static String executeAsyncScript(String script, WebDriver driver, int jsTimeout) throws NullPointerException{
        String resultStr = null;
        try{
            WaitTool.setJavaScriptTimeout(driver, jsTimeout);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

            if (javascriptExecutor != null) {
                Object resultObj = javascriptExecutor.executeAsyncScript(script);

                if(null != resultObj)
                     resultStr = resultObj.toString();

                if ( StringUtils.isBlank(resultStr) || resultStr.contains("error") ) {
                    logger.info(" BLANK or ERROR .... returned , result ["+resultStr+"]");
                }                                                                                                       /* if you need to return map :> JsonFactory factory = new JsonFactory();         ObjectMapper mapper = new ObjectMapper(factory);                TypeReference<HashMap<java.lang.String, Object>> typeRef = new TypeReference<HashMap<java.lang.String, Object>>() {  };*/
            }
        }catch (WebDriverException e) {
            //e.printStackTrace();
            logger.error("executeAsyncScriptt FAILED...!WebDriverException :"+e.getMessage());
        }catch (Exception e){
            //e.printStackTrace();
            logger.error("executeAsyncScriptt FAILED...!Exception :"+e.getMessage());
        }
        return resultStr;
    }

    /**
     * Return any type
     * e.g $(".menu .hide-mobile.show-expand a").is(':visible')
     */
    public static Object executeJavaScriptReturnAnyType(String script, WebDriver webDriver) {
        logger.info("execute JavaScript [{}] ...!", script);
        try {
            return ((JavascriptExecutor) webDriver).executeScript(script);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("executeJavaScript Exception ..."+TestUtil.getException(e));
        }
        return  null;
    }

    /**
     * Check if an element is displayed using javascript and jquery
     *
     * Will return a list of visible elements for the css selector based on [jquery :visible] or null
     *  jQuery( ":visible" )
     *  In jQuery 1.3.2 an element is visible if its browser-reported offsetWidth or
     *  offsetHeight is greater than 0. It means that if your element’s CSS display is “none”,
     *  or any of its parent/ancestor element’s display is “none”, or if the element’s height/width is less than 0
     *  then will be reported as hidden.
     * https://api.jquery.com/visible-selector/
     *
     */
    public static List<WebElement> jQuery_getVisibleElements(String cssSelector, WebDriver webDriver, int waitTimeSec,
                                                             boolean failtestIfNotFound) {
        String selectVisibleElementScript = JQUERY_SCRIPT_START+cssSelector+JQUERY_SCRIPT_FILTER;
        logger.info(".. jQuery_getVisibleElements ...!; selectVisibleElementScript ["+selectVisibleElementScript+"]");
        List <WebElement> visibleWebElementList = null;
        try {
            visibleWebElementList = ((List<WebElement>)JavaScriptHelper.executeJavaScriptReturnAnyType(
                                                                               selectVisibleElementScript, webDriver));
            if(visibleWebElementList.isEmpty()){
                while (waitTimeSec > 0 ) {
                    BaseTestHelper.sleep(1000);
                    waitTimeSec--;
                    logger.info("null or empty so Try again .. try left :"+waitTimeSec);
                    visibleWebElementList =  ((List<WebElement>)
                            JavaScriptHelper.executeJavaScriptReturnAnyType(selectVisibleElementScript, webDriver));
                    if (!visibleWebElementList.isEmpty()){
                        logger.info(" Found visible elements ...! List Size :"+visibleWebElementList.size());
                        break;
                    }
                }
            }
            if(visibleWebElementList == null || visibleWebElementList.isEmpty()){
                logger.info(" No Visible Elements Found ...!   JScript->["+selectVisibleElementScript+"] ; searched for :"+waitTimeSec+" seconds");
                if(failtestIfNotFound)
                    BaseTest.failTest("No Visible Elements found ...! JScript->["+selectVisibleElementScript+"]; searched for :"+waitTimeSec+" seconds");
            }else {
                logger.info("Visible Elements Found ...! - Size "+visibleWebElementList.size()  );
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("executeJavaScript Exception ..."+TestUtil.getException(e));
            BaseTest.failTest("executeJavaScript Exception ; script ->["+selectVisibleElementScript+"];\n Excepion :"+e.getCause());
        }

        return visibleWebElementList;
    }

    public static boolean jQuery_isVisibleElement(String cssSelector, WebDriver webDriver, int waitTimeSec ) {
        String selectVisibleElementScript = JQUERY_SCRIPT_START+cssSelector+JQUERY_SCRIPT_FILTER;
        logger.info(".. jQuery_getVisibleElements ...!");
        List <WebElement> visibleWebElementList = null;
        try {
            visibleWebElementList =((List<WebElement>)JavaScriptHelper.executeJavaScriptReturnAnyType(selectVisibleElementScript, webDriver));
            if(visibleWebElementList.isEmpty()){
                while (waitTimeSec > 0 ) {
                    BaseTestHelper.sleep(1000);
                    waitTimeSec--;
                    logger.info("null or empty so Try again .. try left :"+waitTimeSec);
                    visibleWebElementList =  ((List<WebElement>)
                            JavaScriptHelper.executeJavaScriptReturnAnyType(selectVisibleElementScript, webDriver));
                    if (!visibleWebElementList.isEmpty()){
                        logger.info(" Found visible elements ...! List Size :"+visibleWebElementList.size());
                        return true;
                    }
                }
            }
        }catch (Exception e){
            logger.error("executeJavaScript Exception ..."+TestUtil.getException(e));
        }
        return false;
    }

    public static WebElement jsGetAllElements(String cssSelector, WebDriver driver){
        return (WebElement) executeJavaScriptReturnAnyType("document.querySelectorAll("+cssSelector+")", driver);
    }

    /**
     * Execute JS and return result as string null or empty
     *
     */
    public static String executeJavaScript(String script, WebDriver webDriver, int waitTime)   {
        logger.info("executeJavaScript() execute JavaScript [{}] ...!", script);
        logger.info("Start executeJavaScript Time : "+System.currentTimeMillis());
        Object scriptResult = null;
        String failMessage= "FailMessage : ";

        while (waitTime > 0) {
            waitTime--;
            try {
                sleep(995);           // script takes time to execute e.g 35 sec will take 37 sec if sleep 400
                scriptResult = ((JavascriptExecutor) webDriver).executeScript(script);
                logger.info(" Wait time left : "+waitTime+" Script result :" +scriptResult);
                if(scriptResult != null && StringUtils.isNotBlank(scriptResult.toString())) {
                    logger.info(" END executeJavaScript Time : "+System.currentTimeMillis());
                    return scriptResult.toString();
                }
            } catch (UnsupportedOperationException | WebDriverException we ) {
                if(waitTime<1)logger.error("executeJavaScript WebDriverException ..."+TestUtil.getExceptionFirstLine(we));
            } catch (InterruptedException ie){
                if(waitTime<1)logger.error("executeJavaScript InterruptedException ..."+TestUtil.getExceptionFirstLine(ie));
            }
            catch (Exception e){
                if(waitTime<1)logger.error("executeJavaScript Exception ..."+TestUtil.getExceptionFirstLine(e)) ;
            }
        }
        logger.info(" END executeJavaScript Time : "+System.currentTimeMillis());
        if (scriptResult != null){
            return scriptResult.toString();
        } else{
            return null;
        }

    }

    public static void executeJavaScriptNoReturn(String script, WebDriver webDriver, int waitTime)   {
        logger.info("executeJavaScript() execute JavaScript [{}] ...!", script);
        logger.info("Start executeJavaScript Time : "+System.currentTimeMillis());
        Object scriptResult = null;
        String failMessage= "FailMessage : ";
            try {
                sleep(995);           // script takes time to execute e.g 35 sec will take 37 sec if sleep 400
                scriptResult = ((JavascriptExecutor) webDriver).executeScript(script);
                logger.info(" Wait time left : "+waitTime+" Script result :" +scriptResult);
                if(scriptResult != null && StringUtils.isNotBlank(scriptResult.toString())) {
                    logger.info(" END executeJavaScript Time : "+System.currentTimeMillis());
                }
            } catch (UnsupportedOperationException | WebDriverException we ) {
                if(waitTime<1)logger.error("executeJavaScript WebDriverException ..."+TestUtil.getExceptionFirstLine(we));
            } catch (InterruptedException ie){
                if(waitTime<1)logger.error("executeJavaScript InterruptedException ..."+TestUtil.getExceptionFirstLine(ie));
            }
            catch (Exception e){
                if(waitTime<1)logger.error("executeJavaScript Exception ..."+TestUtil.getExceptionFirstLine(e)) ;
            }
        logger.info(" END executeJavaScript Time : "+System.currentTimeMillis());
    }

    public static void executeJavaScriptOnWe(WebDriver webDriver, String script, WebElement we, int waitTime) {
        logger.info("executeJavaScriptOnWe() execute JavaScript [{}] ...!", script);
        logger.info("Start executeJavaScript Time : "+System.currentTimeMillis());
        Object scriptResult = null;
        String failMessage= "FailMessage : ";
        try {
            sleep(995);           // script takes time to execute e.g 35 sec will take 37 sec if sleep 400
            scriptResult = ((JavascriptExecutor) webDriver).executeScript(script, we);
            logger.info(" Wait time left : "+waitTime+" Script result :" +scriptResult);
        } catch (UnsupportedOperationException | WebDriverException wex ) {
            if(waitTime<1)logger.error("executeJavaScript WebDriverException ..."+TestUtil.getExceptionFirstLine(wex));
        } catch (InterruptedException ie){
            if(waitTime<1)logger.error("executeJavaScript InterruptedException ..."+TestUtil.getExceptionFirstLine(ie));
        }
        catch (Exception e){
            e.printStackTrace();
            if(waitTime<1)logger.error("executeJavaScript Exception ..."+TestUtil.getExceptionFirstLine(e)) ;
        }
        logger.info(" END executeJavaScript Time : "+System.currentTimeMillis());
    }


    /**
     * Execute script and wait for JS variable not present; not there; ThrowsException
     */
    public static boolean waitJSvariableNotPresent(String script, WebDriver webDriver, int waitTime)   {
        logger.info("executeJavaScript() execute JavaScript [{}] ...!", script);
        logger.info("Start executeJavaScript Time : "+System.currentTimeMillis());
        Object scriptResult = null;
        String failMessage= "FailMessage : ";

        while (waitTime > 0) {
            waitTime--;
            try {
                sleep(990);           // script takes time to execute e.g 35 sec will take 37 sec if sleep 400
                scriptResult = ((JavascriptExecutor) webDriver).executeScript(script);
                logger.info(" Wait time left : "+waitTime+" Script result :" +scriptResult);
                if(scriptResult == null) {
                    logger.info(" END executeJavaScript result is null[JS variable not found ...], Time : "+System.currentTimeMillis());
                    return true;
                }
            } catch (UnsupportedOperationException | WebDriverException we ) {
                if(waitTime<1)logger.error("executeJavaScript WebDriverException ..."+TestUtil.getExceptionFirstLine(we));
            } catch (InterruptedException ie){
                if(waitTime<1)logger.error("executeJavaScript InterruptedException ..."+TestUtil.getExceptionFirstLine(ie));
            }
            catch (Exception e){
                if(waitTime<1)logger.error("executeJavaScript Exception ..."+TestUtil.getExceptionFirstLine(e)) ;
            }
        }
        logger.info(" END executeJavaScript Time : "+System.currentTimeMillis());

        return false;
    }

    /*******************************************************************************************************************
     * Return hidden field value      *
     * Use ID to get the element
     * JS uses $('#telephone')[0].value
     ******************************************************************************************************************/
    public String getHidenFieldBy(WebDriver driver, String selectorOpt, String selectorValue, int waitTime){
        String input = null;
        while(waitTime > 0){
            waitTime--;
            try{
                logger.info(" wait time left in seconds :"+waitTime);
                Object inputObj = ((JavascriptExecutor)driver).executeScript( getJSselector(selectorOpt, selectorValue),"");//.toString() ;
                if(inputObj != null) {
                    input = inputObj.toString();
                }
                if(StringUtils.isNotBlank(input)){
                    return input;
                }try{
                    sleep(1000);}catch(Exception e){   }
            }catch (WebDriverException we){
                if(waitTime < 1){
                    logger.error("GetHiddenField by ID Failed ...!" +TestUtil.getException(we));
                }
            }
        }
        if(input != null){
            return input;
        } else {
            BasePage.failTest(" Failed to get hidden field selectorOpt'"+selectorOpt+"', selectorValue '"+selectorValue+", got NULL :"+input, true);
            return input;
        }
    }

    /**
     * Retrun JS selector based on input
     * {"Id","ClassName","Name","TagName","TagNameNS", "CssSelector"}
     * @param selectorOpt
     * @param selectorValue
     * @return
     */
    public static synchronized String getJSselector(String selectorOpt, String selectorValue){
        logger.info("getJSselector for selectorOpt: "+selectorOpt+", selector :"+selectorValue);
        String jsSelectorScript = null;
        String selectElementBy = null;

        switch (selectorOpt){
            case "Id":
                logger.info(" Case Id ...!");
                selectElementBy = "getElementById('"+selectorValue+"')";
                break;
            case "ClassName":
                logger.info(" Case ClassName ...!");
                selectElementBy = "getElementByClassName('"+selectorValue+"')";
                break;
            case "Name":
                logger.info(" Case Name ...!");
                selectElementBy = "getElementsByName('"+selectorValue+"')";//getelementbyname will not work
                break;
            case "TagName":
                logger.info(" Case TagName ...!");
                selectElementBy = "getElementByTagName('"+selectorValue+"')";
                break;
            case "TagNameNS":
                logger.info(" Case TagNameNS ...!");
                selectElementBy = "getElementByTagNameNS('"+selectorValue+"')";
                break;
            case "CssSelector":
               logger.info(" Case CssSelector ...!");
                selectElementBy = "getElementByCssSelector('"+selectorValue+"')";
                break;
            default:
                System.out.println("INVALID JavaScript selector :"+selectorOpt);
        }
        if (selectorOpt=="Name")
           jsSelectorScript = "var input = document."+selectElementBy+"[0]"+"; return input && input.value;";
        else
            jsSelectorScript = "var input = document."+selectElementBy+"; return input && input.value;";
        logger.info("jsSelectorScript is '"+jsSelectorScript+"'");

        return jsSelectorScript;
    }


    /**
     * Works only on Firefox
     *
     * @param driver
     * @return error list or empty list
     */
    public static List getJavaScriptErrors(WebDriver driver, int waitTimeSeconds){
        logger.info("getJavaScriptErrors works only for Firefox driver ....!");
        List<JavaScriptError> jsErrors = ListUtils.EMPTY_LIST;
        //BaseRemoteWebDriver.isBrowser("firefox") || DriverManager.getDriver() != null
        //if(BaseRemoteWebDriver.isBrowser("firefox") || BaseRemoteWebDriver.isBrowser(WebDriverFactory.browserName, "firefox") ) {
            do{
                logger.info("time left :"+waitTimeSeconds);
                waitTimeSeconds--;
                jsErrors = JavaScriptError.readErrors(driver);
                BaseTest.sleep(1000);
            }while (CollectionUtils.isEmpty(jsErrors) && waitTimeSeconds > 0);

            if (CollectionUtils.isEmpty(jsErrors)) {
                logger.info("No JavaScript errors found ....!");
            } else {
                for (JavaScriptError jError : jsErrors) {
                    logger.warn(jError.toString());
                } logger.warn("Number of Errors Found ["+jsErrors.size()+"]");
            }
        //} else {
            //logger.info("\t Not firefox browser; Can get the errors only for FF; Empty list returned ....!");
        //}
        return jsErrors;
    }

  /**
   * Check if scroll bar shown on the browser
   * isCheckBarVertical if this is true then check Vertical bar otherwise check horizontal
   */
    public static boolean isScrollBarShown(WebDriver driver, boolean isCheckBarVertical){
        String execVBarScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
        String execHBarScript = "return document.documentElement.scrollWidth>document.documentElement.clientWidth;";
        String script = null;
        String currentScrollBarType = null;

        if(isCheckBarVertical){
            script = execVBarScript;
            currentScrollBarType = "V E R T I C A L" ;
        }else {
            script = execHBarScript;
            currentScrollBarType = "H O R I Z O N T A L" ;
        }
        logger.info("Bar to check is :"+currentScrollBarType+" Executing Script : "+script);
        boolean isScrollBar = (Boolean) executeJavaScriptReturnAnyType(script, driver);                                 //   JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;//(scrollBarPresent.executeScript(script));
        logger.info("Script Result :"+isScrollBar);

        if (isScrollBar == true) {
            logger.info(currentScrollBarType+" Scrollbar is present ...!");
        } else if (isScrollBar == false){
            logger.info(currentScrollBarType+" Scrollbar is not present ...!");
        }else {
            logger.info("Script did not returned a value in [true or false] ...!");
        }
        return isScrollBar;
    }


    public static void  executeBlurOnWebelement(WebDriver driver, WebElement webElement ){
        JavaScriptHelper.executeJavaScriptOnWe(driver, "arguments[0].focus(); arguments[0].blur(); return true", webElement, 3);
    }

}


/***
 //Scroll Bar code For move Upwards
 Actions dragger = new Actions(driver);
 WebElement draggablePartOfScrollbar = driver.findElement(By.className("mCSB_dragger_bar"));
 int numberOfPixelsToDragTheScrollbarDown1 = 1500;
 for (int i=10;i<1000;i=i+numberOfPixelsToDragTheScrollbarDown1){
 try{
 // this causes a gradual drag of the scroll bar, 10 units at a time
 dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown1).release().perform();
 Thread.sleep(1000L);
 }catch(Exception e1){}


 http://www.swtestacademy.com/selenium-11-javascriptexecutor/
 https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html#executeAsyncScript-java.lang.String-java.lang.Object...-

 Alert PopupJava

 JavascriptExecutor js =(JavascriptExecutor)driver;
 js.executeScript("alert('SW Test Academy!');");
 driver.switchTo().alert().accept();


 Get Page TitleJava

 JavascriptExecutor js =(JavascriptExecutor)driver;
 String title = js.executeScript("return document.title;").toString();
 assertThat(driver.getTitle(), is(title));


 Refresh Browser WindowJava

 JavascriptExecutor js =(JavascriptExecutor)driver;
 js.executeScript("history.go(0);");


 Scroll-Down Until an Element DisplayedJava

 WebElement element = driver.findElement(By.xpath("//*[text()[contains(.,'JavaScript for DoExponent')]]"));
 JavascriptExecutor js =(JavascriptExecutor)driver;
 js.executeScript("arguments[0].scrollIntoView(true);",element);

 Highlight an ElementJava

 WebElement sevenButton = driver.findElement(By.name("seven"));
 JavascriptExecutor js = (JavascriptExecutor) driver;
 js.executeScript("arguments[0].style.border='3px dotted blue'", sevenButton);

 Hide and Show an Element

 Hide and Show ElementJava

 JavascriptExecutor js = (JavascriptExecutor) driver;
 //Hide an element
 js.executeScript("document.getElementsByName('five')[0].style.display='none'");
 //Show an element
 js.executeScript("document.getElementsByName('five')[0].style.display='block'");


 */