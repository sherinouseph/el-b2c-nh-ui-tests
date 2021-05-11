package com.englishtown.tests.core;

/**
 *  Testing logs
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;


public class TestngListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestngListener.class);
    public static boolean isStoreScreenShotOnFailure = true;  // test cases that do not need to store screendump set this to false
    public static boolean isStoreScreenShotAllTest   = false; // store screen shot for all tests

    //TestUtil testUtil = new TestUtil();
    // This belongs to ITestListener and will execute before starting of Test set/batch
    public void onStart(ITestContext arg0) {
        //Reporter.log("Begin executing Test " + arg0.getName(), true);
    }

    // This belongs to ITestListener and will execute, once the Test set/batch is finished
    public void onFinish(ITestContext arg0) {
       //
       // Reporter.log("Completed executing test " + arg0.getName(), true);
    }

    // This belongs to ITestListener and will execute only when the test is pass
    public void onTestSuccess(ITestResult arg0) {
        // This is calling the printTestResults metho   // printTestResults(arg0);
        Reporter.log("onTestSuccess " + arg0.getInstance().getClass().getSimpleName());
        if(isStoreScreenShotAllTest){
            takeScreenShot(arg0,false);
        }

        if(BaseRemoteWebDriver.isMobileDevice && BaseTest.LOG_STEP_IMAGE){
            //takeScreenShot(arg0,false);
        }
    }

    // This belongs to ITestListener and will execute only on the event of fail test
    public void onTestFailure(ITestResult arg0) {
        // This is calling the printTestResults method
        try {//logger.info("testConfig :"+FrFreeTrialTest.testConfig);  FieldUtils.readField(arg0.getInstance(), "testMemberPageUrl", true)
            Reporter.log("onTestFailure " +arg0.getInstance().getClass().getSimpleName());                                 //System.out.println("onTestFailure  Test Failure ..! ");//printTestResults(arg0);
        }catch (Exception e){
            //logger.error("onTestFailure Exception ...! "+e.getMessage());
        }
        if( getWebDriver(arg0) != null ) {
            if(BaseTest.LOG_PAGE_SOURCE) {
               // logger.error(" On test failure print Page source ...! \n" + getWebDriver(arg0).getPageSource());
            }
            // cant get screen shot for headless browser
            boolean isHtmlUnit = "htmlunit".equals(BaseRemoteWebDriver.getCurrentBrowserName());
            if(isStoreScreenShotOnFailure && !isHtmlUnit ) {
                takeScreenShot(arg0, true);
            }
        }else {
            //logger.warn(" Webdriver is null .....!");
        }

    }

    // This belongs to ITestListener and will execute before the main test start (@Test)
    public void onTestStart(ITestResult arg0) {
        //System.out.println("The execution of the main test starts now");

    }

    // This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult arg0) {
       // printTestResults(arg0);
    }

    // This is just a piece of shit, ignore this
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        //System.out.println(" onTestFailedButWithinSuccessPercentage ....");
    }

    // This is the method which will be executed in case of test pass or fail
    // This will provide the information on the test
    private void printTestResults(ITestResult result) {
        Reporter.log("Test Method  " + result.getTestClass().getTestName(), true);

        if (result.getParameters().length != 0) {
            String params = "";
            for (Object parameter : result.getParameters()) {
                params += parameter.toString() + ",";
            }
            Reporter.log("Test Method had the following parameters : " + params, true);
        }

        String status = null;

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                 status = "Pass";
                 break;
            case ITestResult.FAILURE:
                 status = "Failed";
                 break;
            case ITestResult.SKIP:
                 status = "Skipped";
        }
        Reporter.log("Test Status: " + status, true);
    }

    // This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());
        Reporter.log(textMsg, true);
    }

    // This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());
        Reporter.log(textMsg, true);
    }

    // This will return method names to the calling function
    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }


//    // This belongs to ISuiteListener and will execute before the Suite start
//    @Override
//    public void onStart(ISuite arg0) {
//        Reporter.log("About to begin executing Suite " + arg0.getName(), true);
//    }
//
//    // This belongs to ISuiteListener and will execute, once the Suite is finished
//    @Override
//    public void onFinish(ISuite arg0) {
//        Reporter.log("About to end executing Suite " + arg0.getName(), true);
//    }


    // Helpers

    /**
     * Take screenshot if BaseTest instance
     * @param arg0
     * @param isFailure
     */
     public synchronized void takeScreenShot(ITestResult arg0, boolean isFailure){
         logger.info(" takeScreenShoot ...!");
         BaseTest baseTest=null;
         TestUtil testUtil = new TestUtil();
         String filename = "_";
         try {
             filename = arg0.getTestClass().getName().replace("com.englishlive.tests.", "") ;               //+ "_" + arg0.getMethod().getMethodName();
                                                                                                                            //  logger.info("0- filename [{}]", filename);
             filename = filename.replace(".","_");                                                       //  logger.info("1- filename [{}]", filename);
             filename = filename+"_" + arg0.getMethod().getMethodName();                                                    //  logger.info("2- filename [{}]", filename);
             if (isFailure) {
                 filename = "fail_" + filename;
             }
             logger.info("File Name Set to [{}]", filename);
             // Get the current test webdriver instance
             Object instance = arg0.getInstance();
             if (instance instanceof BaseTest) {
                 baseTest = (BaseTest) instance;
                 WebDriver webDriver = baseTest.getWebDriver();
                 testUtil.takeScreenshot(filename, webDriver, isFailure);                                               //Reporter.log("takeScreenShot(...) ");
                 logger.info("Screenshot taken ....!");
                 JavaScriptHelper.scrollToXY(getWebDriver(arg0), 0, -2000);
                 try{ Thread.sleep(500);}catch (InterruptedException e){}
             } else {
                 logger.error("NO screenshot taken. Not an instance of BaseTest ...!");                                 //Reporter.log("NO screenshot taken. Not an instance of BaseTest!", true);
             }
         }catch (WebDriverException e){
             logger.error("WebDriverException takeScreenShoot "+e.getMessage());
         }catch (Exception e){
             logger.error("Exception takeScreenShoot "+e.getMessage());                                       //Reporter.log("Exception, screenshot NOT taken. !", true);
         }
     }

    /**
     * Return webdriver instance used in basetest or NULL
     *
     */
    public static WebDriver getWebDriver(ITestResult arg0){
        Object instance =arg0.getInstance();
        if(instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;
            return baseTest.getWebDriver();
        }
        return  null;
    }



    public static boolean isIsStoreScreenShotAllTest() {
        return isStoreScreenShotAllTest;
    }

    public static void setIsStoreScreenShotAllTest(boolean isStoreScreenShotAllTest) {
        logger.info("setIsStoreScreenShotAllTest [{}]", isStoreScreenShotAllTest);
        TestngListener.isStoreScreenShotAllTest = isStoreScreenShotAllTest;
    }


}