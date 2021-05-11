//package com.englishlive.tests.System;
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.utils.AutoItHelper;
//import com.englishtown.helpers.utils.SystemInfo;
//import com.englishtown.tests.core.SimpleChromeBaseTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
//
///**
// * Created by nikol.marku on 18/04/2016.
// * Open Home page and check CPU load
// * If cpu load > 95% [=loadThreshold] Fail the test
// *
// * Note: Test will onli check the cpu if 500 error or any shown test will not fail ...
// *    it will fail if driver.get fails
// *
// */
//// Cant run this test on parallel as require to kill all browsers so removing it ..
//public abstract class BaseCpuLoad extends SimpleChromeBaseTest{  //AbstractTestNGSpringContextTests
//    private static final Logger logger = LoggerFactory.getLogger(BaseCpuLoad.class);
//    protected static final int CPU_LOAD_THRESHOLD = 80; // %
//    protected static final String [] RUNTEST_ON_BROWSERS = {"chrome"};
//    protected SystemInfo systemInfo;
//
//    protected int noOfCpuReads = 3;
//    protected int sleepTimeBetweenReadings = 1500; //sec
//    protected int averageCpuLoad = 0;
//    protected boolean stopVideoPlaying = false;
//    protected String STOP_VIDEO_PLAY = "$('video')[0].pause()";
//
//
//    @BeforeTest
//    void setupKillChrome(){
//        logger.info(" @BeforeClass   Autoit kill chrome ....!");
//        AutoItHelper.killProcess(AutoItHelper.getAutoitKillChromeScript());
//    }
//
//    @Test
//    public void checkCpuLoad(){
//        sleep(500);
//        if(stopVideoPlaying) {
//            JavaScriptHelper.executeJavaScript(STOP_VIDEO_PLAY, getLocalThreadDriver());
//        }
//        logger.info("CPU load should be less than the threshold set to : "+CPU_LOAD_THRESHOLD+" For the number of cpu reads :"+noOfCpuReads);
//        averageCpuLoad = systemInfo.getChromeAverageCpuLoad(noOfCpuReads, sleepTimeBetweenReadings);
//        AssertHelper.assertThat("CPU Load should not be more than ["+CPU_LOAD_THRESHOLD+"] ...!", averageCpuLoad, lessThanOrEqualTo(CPU_LOAD_THRESHOLD) );
//    }
//
//
//}
