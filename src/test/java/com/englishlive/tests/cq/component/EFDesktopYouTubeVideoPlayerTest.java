//package com.englishlive.tests.cq.component;
///**
// * Created by nikol.marku on 4/5/2017.
// *
// */
//import com.englishtown.tests.core.common.BaseVideoPlayerTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//
//
//public class EFDesktopYouTubeVideoPlayerTest extends BaseVideoPlayerTest {
//    private static final Logger logger = LoggerFactory.getLogger(EFDesktopYouTubeVideoPlayerTest.class);
//    @Value("#{applicationPropertiesList['en.gb.videopage']}")
//    protected String testUrl;
//
//
//    @Override
//    protected void setPageURL() {
//        setThreadSafeDriver();
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
