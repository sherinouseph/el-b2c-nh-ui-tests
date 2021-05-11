//package com.englishlive.tests.checkout.newcheckout.de;
///**
// * open member page
// * Click submit
// * Check validation page
// *
// */
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.BaseCheckoutMemberPageNegativeTest;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.testng.AssertJUnit.assertTrue;
//
//
//public class DETestSafariWaitTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(DETestSafariWaitTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
//    protected String currMemberPageUrl;
//    String script = // "return document.title;";
//            "var callback = arguments[arguments.length - 1]; window.et = window.et || {}; window.et.state = window.et.state || [];" +
//                    "et.state.push(null, function(){et.state.get('',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })});";
//
//
//
//    @Test
//    public void testAsyncScriptiPadSafari(){
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        getWebDriver().manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//        this.openUrl(getWebDriver(),"https://englishlive.ef.com/it-it/"); // this.memberPageUrl, -1 ) ;
//        sleep(5000);
//        Object result = null;
//        int timeSec = 5;
//
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
//        result = javascriptExecutor.executeAsyncScript(script);
//        if( null != result){
//            logger.info("Not null state ....!");
//            logger.info("Script Result is : "+result.toString());
//        } else logger.info("Result is NULL ....!");
//
//    }
//
//    //@Test
//    public void testSafari(){
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        getWebDriver().manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//        this.openUrl(getWebDriver(),"https://englishlive.ef.com/it-it/"); // this.memberPageUrl, -1 ) ;
//        sleep(5000);
//        Object result = null;
//        int timeSec = 5;
//
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
//        result = javascriptExecutor.executeAsyncScript(script);
///*        getWebDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
//        javascriptExecutor.executeScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
//        javascriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
//*/
//        //while (timeSec > 1) {
//            //timeSec --;
//            //logger.info("Try : "+timeSec);
//            //result = javascriptExecutor.executeAsyncScript(script); //Async
//            if( null != result){
//                logger.info("Not null state ....!");
//                logger.info("Script Result is : "+result.toString());
//               // break;
//            } else logger.info("Result is NULL ....!");
//        //}
//
//
//        /*WebElement webElement = WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector("input[name=firstname]"), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=firstname]"), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//
//        result = ((JavascriptExecutor) getWebDriver()).executeAsyncScript("var c = arguments[0];alert(c);c(1);");
//        logger.info("Script Result is : "+result.toString());
//        */
//    }
//
//    ///http://www.swtestacademy.com/selenium-11-javascriptexecutor/
//   // @Test
//    void testScritpAsync(){
//        //Set ScriptTimeout
//        getWebDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
//
//        //Declare and set start time
//        long startTime = System.currentTimeMillis();
//
//        //Declare JavascriptExecutor
//        JavascriptExecutor js =(JavascriptExecutor)getWebDriver();
//
//        //Call executeAsyncScript() method
//        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");
//
//        //Get the difference (currentTime - startTime) it should be greater than 1500
//        System.out.println("Passed time: " + (System.currentTimeMillis() - startTime));
//
//        //Assert that the time difference is greater than 4000
//        assertTrue("Time difference must be greater than 4000 milliseconds",
//                (System.currentTimeMillis() - startTime) > 4000);
//    }
//
//
//
//}
//
