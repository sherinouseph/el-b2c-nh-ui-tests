package com.englishtown.tests.core.common;
/**
 *  Add helpers for common test performed on all pages
 *  BaseTest will use rappers to expose these test
 *
 * Created by nikol.marku on 21/05/2015.
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.core.Is.is;
//TODO move to basetesthelper
public class CommonTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(CommonTestHelper.class);
//
//    /**
//     *  Check URL contains text e.g  "thankyou"
//     *  Test will wait for URL to load and then assert it contains test, run simple Page test as well
//     */
//    //TODO refactor this remove creating
//    public static void checkPaymentThankyouPage(PaymentThankyouPage paymentThankyouPage, WebDriver driver, String urlContainsStr, int waitTimeSec ) {
//        paymentThankyouPage = new PaymentThankyouPage(driver) ;
//        paymentThankyouPage.waitForPageToLoad(paymentThankyouPage.getPageLoadedCondition());
//        myAssertThat(driver, "Failed ...!. URL does not contains 'thankyou'. Current URL is :"+ paymentThankyouPage.getUrl() +
//         ". Seconds Waited for :" + waitTimeSec, PaymentThankyouPage.waitForUrlContains(driver, urlContainsStr, waitTimeSec), true);
//        myAssertThat(driver, "ThankyouPage simpleTest Failed ...!", paymentThankyouPage.simpleTest(), true);
//    }


    public static boolean waitForUrlContainsText(WebDriver webDriver, String containsStr, int waitSeconds){
        logger.info("waitForUrlContains() : '"+containsStr+"'");
        Boolean isContainSting = false;
        String currentUrl="";
        int waitTime = waitSeconds;

        do{
            waitSeconds--;
            logger.info(" DO Try left :"+waitSeconds);
            try{
                currentUrl = TestUtil.getCurrentUrl(webDriver) ;    //webDriver.getCurrentUrl().toLowerCase();
                currentUrl = currentUrl.toLowerCase();
                containsStr = containsStr.toLowerCase();
                logger.info("currentUrl is :'"+currentUrl+"' ; Waiting to contain ['"+containsStr+"']");
                // "get browser"  this is the default value .... as @ getCurrentUrl  !currentUrl.contains("get browser") &&
                if ( null != currentUrl && currentUrl.contains(containsStr) ) {
                    logger.info(" url :'"+currentUrl+"'\t Contains '"+containsStr+"'");
                    isContainSting=true;
                    break;
                }
            }catch (WebDriverException e) {
                if(waitSeconds <1){
                    logger.error("waitAssertUrl ....URL :`"+currentUrl+"` does not contains :"+containsStr+
                            " Seconds Waited for '"+waitTime+"' Error "+ TestUtil.getException(e, webDriver));
                }
            }
            try { Thread.sleep(1000);} catch(Exception e1) {  }
        } while (waitSeconds > 0 )  ;

        return isContainSting;
    }

    public static boolean waitForUrlDoesNotContainingText(WebDriver webDriver, String not_containsStr, int waitSeconds){
        logger.info("waitForUrlNotContainingText() : '"+not_containsStr+"'");
        Boolean isContainSting = true;
        String currentUrl="";
        int waitTime = waitSeconds;

        do{
            waitSeconds--;
            logger.info(" DO Try left :"+waitSeconds);
            try{
                currentUrl = TestUtil.getCurrentUrl(webDriver) ;
                currentUrl = currentUrl.toLowerCase();
                not_containsStr = not_containsStr.toLowerCase();
                logger.info("currentUrl is :'"+currentUrl+"' ; Waiting to Not containing  ['"+not_containsStr+"']");

                if ( null != currentUrl && !currentUrl.contains(not_containsStr) ) {
                    logger.info(" url :'"+currentUrl+"'\t Contains '"+not_containsStr+"'");
                    isContainSting = false;
                    break;
                }
            }catch (WebDriverException e) {
                if(waitSeconds <1){
                    logger.error("waitForUrlNotContainingText ....URL :`"+currentUrl+"` does contains :"+not_containsStr+
                            " Seconds Waited for '"+waitTime+"' Error "+ TestUtil.getException(e, webDriver));
                }
            }
            try { Thread.sleep(1000);} catch(Exception e1) {  }
        } while (waitSeconds > 0 )  ;

        try { Thread.sleep(1000);} catch(Exception e1) {  }

        return isContainSting;
    }


    public static boolean waitForUrlEndsWith(WebDriver webDriver, String endsWith, int waitSeconds){
        logger.info("waitForUrlContains() : '"+endsWith+"'");
        Boolean isEndsWith = false;
        String currentUrl="";
        int waitTime = waitSeconds;

        do{
            waitSeconds--;
            logger.info(" DO Try left :"+waitSeconds);
            try{
                currentUrl = TestUtil.getCurrentUrl(webDriver) ;    //webDriver.getCurrentUrl().toLowerCase();
                currentUrl = currentUrl.toLowerCase();
                logger.info("currentUrl is :'"+currentUrl+"' ");
                // "get browser"  this is the default value .... as @ getCurrentUrl
                if ( currentUrl.contains(endsWith) ) {
                    logger.info(" url :'"+currentUrl+"'\t Contains '"+endsWith+"'");
                    isEndsWith=true;
                    break;
                }
            }catch (WebDriverException e) {
                if(waitSeconds <1){
                    logger.error("waitAssertUrl ....URL :`"+currentUrl+"` does not contains :"+endsWith+
                            " Seconds Waited for '"+waitTime+"' Error "+ TestUtil.getException(e, webDriver));
                }
            }
            try { Thread.sleep(1000);} catch(Exception e1) {  }
        } while (waitSeconds > 0 )  ;

        return isEndsWith;
    }



    /**
     * Wait certain time for current browser url to containing text
     * Does not fail the test
     */
    public static void waitForCurrentUrlContainsText(WebDriver webDriver, String containsStr, int waitSeconds){
        logger.info("waitForUrlContains() : '"+containsStr+"'");
        String currentUrl="";
        int waitTime = waitSeconds;
        
        do{
            waitSeconds--;
            logger.info(" DO Try left :"+waitSeconds);
            try{
                currentUrl = TestUtil.getCurrentUrl(webDriver) ;    //webDriver.getCurrentUrl().toLowerCase();
                logger.info("currentUrl is :'"+currentUrl+"' ");

                if ( !currentUrl.contains("get browser") && currentUrl.contains(containsStr) ) {
                    logger.info(" url :'"+currentUrl+"'\t Contains '"+containsStr+"'");
                    break;
                }
            }catch (WebDriverException e) {
                if(waitSeconds <1){
                    logger.error("waitAssertUrl ....URL :`"+currentUrl+"` does not contains :"+containsStr+
                            " Seconds Waited for '"+waitTime+"' Error "+ TestUtil.getException(e, webDriver));
                }
            }
            try { Thread.sleep(1000);} catch(Exception e1) {  }
        } while (waitSeconds > 0 )  ;
    }


    /**
     * Select option in the selectDropdownValue menu if not selected already
     *
     */
    public static void selectByValue(WebDriver driver, By bySelector, String selectValue){
        try{
            WebElement mySelectElm = driver.findElement(bySelector); //option:checked
            Select mySelect= new Select(mySelectElm);
            // check if required option is selected

            WebElement option = mySelect.getFirstSelectedOption();
            String selectedOptionTxt =  option.getAttribute("value"); //TestUtil.getWebElementText(option);
            logger.info("selectedOptionTxt :"+selectedOptionTxt );

            if(StringUtils.containsIgnoreCase( option.getAttribute("value"),selectValue )){
                logger.info("Selected value is the required one ...! ["+selectValue+"]");
            }else {
                logger.info("Selecting it ....!");
                mySelect .selectByValue(selectValue);
            }

            logger.info("Select drop down is not selected ... so selecting it ...! byValue :"+selectValue);
            mySelect .selectByValue(selectValue);

        }catch (WebDriverException wde){
            BaseTest.failTest("select Could not select the option value...! ["+selectValue+"] err .."+wde.toString());
        }
    }


}
