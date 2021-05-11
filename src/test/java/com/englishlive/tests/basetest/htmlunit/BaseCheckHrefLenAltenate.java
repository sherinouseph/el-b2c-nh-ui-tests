//package com.englishlive.tests.basetest.htmlunit;
///**
// * Open URL
// * get a list of urls [for tag link and rel="alternate"] and open each one of them
// * Check Response code is not [200, 301, 302]
// *  e.g <link href="http://www.englishtown.com/zh-tw/content/englishtown/tw/zh/" hreflang="zh" rel="alternate"/>
// *
// *
// * Note:  2017 site changed and we dontt use rel=alternate
// */
//
//
//import com.englishlive.tests.provider.data.HrefLenProvider;
//import com.englishtown.dataprovider.bin.UrlRedirectBean;
//import com.englishtown.helpers.WebClientResponseHelper;
//import com.englishtown.pages.core.BasePage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.ITest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//
//
//public abstract class BaseCheckHrefLenAltenate extends BaseHtmlUnitDriverConfig implements ITest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseCheckHrefLenAltenate.class);
//    protected static String currentURL = null;
//    protected static int TEST_COUNT =0;
//    protected static int TEST_ENDCOUNT =0;
//    private int testResponseCode = -1;
//    private int responseCodeErros = 0; // count response no if no match to [200, 301, 302]
//
//
//    @Test(dataProvider = "getAllHrefLenUrls", dataProviderClass = HrefLenProvider.class, threadPoolSize = 10, invocationCount = 1, timeOut = 15000 )
//    void openUrl_Check_Response(String url) {
//       synchronized ((Object) TEST_COUNT){TEST_COUNT++;}
//        if(url.contains("-wws") ){
//            url = url + "?ctr=" + market; // test is running on build agent 5 and geolocaiton is not finding the page if no country
//        }
//        logger.info("Open URL : "+url);
//        testResponseCode = -1;
//        testResponseCode = WebClientResponseHelper.getWebClientResponseCode(url);
//        if(testResponseCode == -1){
//            BasePage.failTest(" No response code received from request for url : "+url);
//        }else {
//            if(testResponseCode ==200 || testResponseCode ==301 || testResponseCode ==302){
//                logger.info(" Response code OK, it is one of => [200, 301, 302] : url : "+url);
//            }else{
//                responseCodeErros++;
//                BasePage.failTest(" Response code is not in this list => [200, 301, 302] : url : "+url);
//            }
//        }
//        synchronized ((Object)TEST_ENDCOUNT) { TEST_ENDCOUNT++;}
//    }
//
//    //experiment  http://stackoverflow.com/questions/15220262/custom-test-method-name-in-testng-reports
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
//
//    @Override
//    public String getTestName() {
//        return this.mTestCaseName;
//    }
//
//
//
//
//}