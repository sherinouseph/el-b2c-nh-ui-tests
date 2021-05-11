//package com.englishlive.tests.responsive.image;
///**
// *
// * Note:  run on chrome onlySAND-3205
// * on 22/06/2018 - Norman said horizontal bar shouldn't be there when we maximise the window.Hence nikol told to comment this test
// */
//import com.englishlive.tests.responsive.image.core.BaseScreenResizeShowScrollBar;
////import com.englishlive.tests.screenshot.DeSendScreenshot;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WebDriverWindowHelper;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.core.Is.is;
//
//public class ITScreenResizeShowScrollBarTest extends BaseScreenResizeShowScrollBar {
//    private static final Logger logger = LoggerFactory.getLogger(ITScreenResizeShowScrollBarTest.class);
//    @Value("#{applicationPropertiesList['home.it.it.url']}")
//    protected String testUrl ;
//
//    protected static final String[] RUN_TEST_ON_BROWSERS = {"chrome"};
//
//    @BeforeClass (description = "Open URL, Set Overflow to visible and set Size to x=["+smallViewWidth+"]; y=["+smallViewHeight+"]")
//    public void setup() {
//        BaseRemoteWebDriver.setCurrentBrowserName("chrome");
//        setThreadSafeDriver();
//        failTestIfIsNotBrowser(RUN_TEST_ON_BROWSERS, "This test works only on chrome browser ....!"+RUN_TEST_ON_BROWSERS.toString());
//        openUrl(getWebDriver(), testUrl);
//        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(), smallViewWidth, smallViewWidth);
//        JavaScriptHelper.executeJavaScript(removeOverflowJS, getWebDriver());
//        sleep(1000);
//    }
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//
//        //destroyDriver();
//    }
//
//}
