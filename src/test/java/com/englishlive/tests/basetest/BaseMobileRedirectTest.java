package com.englishlive.tests.basetest;
/**
 * when using mobile browser/device urls are redirected to mobile page
 * Run only on Mobile browser and chrome simulator
 */

import com.englishtown.dataprovider.UrlDataProvider;
import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.SimpleBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;

public abstract class BaseMobileRedirectTest extends SimpleBaseTest implements ITest{// BaseTestHelper BaseHtmlUnitDriverConfig implements ITest{
    private static final Logger logger = LoggerFactory.getLogger(BaseMobileRedirectTest.class);
    private static int waitTime = WaitTool.DEFAULT_WAIT_4_ELEMENT;
    protected volatile MyBrowserType browserType;
    protected static String url;


    @Test(dataProvider = "eLiveAllMobileUrlRedirect", dataProviderClass = UrlDataProvider.class)// fail when run on TC agent,threadPoolSize = 5, invocationCount = 1, timeOut = 35000 )
    public void opentUrlCheckRedirectUrlTest(UrlRedirectBean urlRedirectBean) throws Exception{
        try {
            increaseTestCount();
            createLocalThreadDriver(browserType, 30);
            if (urlRedirectBean.getUrl().contains("englishtown.")) {
                url = UrlMapper.mapEliveBaseUrlToEtownBaseUrl(getBASE_URL()) + urlRedirectBean.getUrl();
            } else if (urlRedirectBean.getUrl().contains("englishcenters.ef.com")) {
                url = getBASE_URL() + urlRedirectBean.getUrl();
            } else {
                logger.info("URL NOT MAPPED ....!");
                url = getBASE_URL() + urlRedirectBean.getUrl();
            }
            String expectedUrl = urlRedirectBean.getExpectedUrl();
            logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to -> " + urlRedirectBean.getExpectedUrl());
            //
            openUrl(getLocalThreadDriver(), url);
            sleep(200);

            boolean urlContains = BasePage.waitForUrlContains(getLocalThreadDriver(), expectedUrl, waitTime);
            myAssertThat(getLocalThreadDriver(), " Failed ...!;" + TestUtil.getCurrentUrl(getLocalThreadDriver()) + " URL does not contain : " + expectedUrl +
                    " waited for : " + waitTime + " >>> NOTE: run only on Mobile ...!", urlContains, true);
        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            increaseTestEndCount();
            destroyDriver(getLocalThreadDriver());
            DriverManager.destroyLocalDriver();
            DriverManager.unset();
        }
    }

    @Override
    public String getTestName() {
        return this.mTestCaseName;
    }

}







//    @AfterMethod
//    private void deleteCookies(){
//        logger.info("AfterMethod delete cookies ...!");
//        CookieHandler.deleteCookies(getWebDriver());
//    }
//    @AfterMethod
//    public void tearDownAfterMethod(){
//        logger.info("AfterMethod tearDown  ...!");
//        //destroyDriver(driver);
//        destroyLocalThreadDriver();
//        LocalDriverManager.unset();
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        if(TEST_COUNT - TEST_ENDCOUNT == 0){
//            logger.info("\n\n\t\tAll {[]} test passed ...!\n\n", TEST_COUNT);
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT+" - Test Failure :" +(TEST_COUNT - TEST_ENDCOUNT)+"\n\n");
//        }
//    }

//experiment
//http://stackoverflow.com/questions/15220262/custom-test-method-name-in-testng-reports
//    @BeforeMethod(alwaysRun = true)
//    public void testData(Method method, Object[] testData) {
//        String testCase = "";
//        if (testData != null && testData.length > 0) {
//            UrlRedirectBean testParams = null;
//            //Check if test method has actually received required parameters
//            for (Object testParameter : testData) {
//                if (testParameter instanceof UrlRedirectBean) {
//                    testParams = (UrlRedirectBean)testParameter;
//                    break;
//                }
//            }
//            if (testParams != null) {
//                testCase = testParams.getTestName();
//            }
//        }//this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
//        this.mTestCaseName = String.format("%s(%s)", "", testCase);
//    }
//
//    @BeforeClass
//    public void setup(){
//        //this test will always run on htmlunit
//        //setUpHtmlUnitDriver();
////        try {
////            String url = getBASEURL()+".englishtown.com/";
////            logger.info("Open url : "+url);
////            getWebDriver().get(url);
////            Thread.sleep(100);
////        }catch (Exception e){
////            logger.error(TestUtil.getException(e, getWebDriver()));
////        }
//    }
