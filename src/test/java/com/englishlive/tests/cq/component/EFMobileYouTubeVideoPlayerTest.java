//package com.englishlive.tests.cq.component;
///**
// * Created by nikol.marku on 4/5/2017.
// *
// */
//import com.englishtown.helpers.WebDriverWindowHelper;
//import com.englishtown.tests.core.common.BaseVideoPlayerTest;
//import org.openqa.selenium.Dimension;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//
//
//public class EFMobileYouTubeVideoPlayerTest extends BaseVideoPlayerTest {
//    private static final Logger logger = LoggerFactory.getLogger(EFMobileYouTubeVideoPlayerTest.class);
//    @Value("#{applicationPropertiesList['en.gb.videopage']}")
//    protected String testUrl;
//
//
//    @Override
//    protected void setPageURL() {
//        setThreadSafeDriver();
//        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(), new Dimension(360, 640));
//        logger.info("setPageURL testUrl :"+testUrl);
//        pageURL = testUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
