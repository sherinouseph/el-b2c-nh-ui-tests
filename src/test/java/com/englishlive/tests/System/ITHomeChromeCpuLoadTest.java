//package com.englishlive.tests.System;
///**
// * Created by nikol.marku on 18/04/2016.
// *
// *
// */
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.utils.SystemInfo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class ITHomeChromeCpuLoadTest extends BaseCpuLoad{
//    private static final Logger logger = LoggerFactory.getLogger(ITHomeChromeCpuLoadTest.class);
//    @Value("#{applicationPropertiesList['home.page.it']}")
//    public String testUrl;
//
//
//    @BeforeClass
//    void setupOpenUrl(){
//        logger.info("@BeforeClass   init chrome and open url ....!");
//        try{
//            initChrome();
//        } catch (Exception e){
//            //logger.error("Can't create chrome driver ...!"+e.getMessage()) ;
//            AssertHelper.assertThat("Can't create chrome driver ...! ", getLocalThreadDriver() != null);
//        }
//        openUrl(getLocalThreadDriver(), testUrl);
//        systemInfo = new SystemInfo();
//    }
//
//}
