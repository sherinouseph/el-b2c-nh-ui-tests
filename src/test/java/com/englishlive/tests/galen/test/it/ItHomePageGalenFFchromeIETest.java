//package com.englishlive.tests.galen.test.it;
///**
// *
// */
//import com.englishtown.helpers.utils.SystemInfo;
//import com.englishtown.helpers.utils.TestUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
////import java.io.*;
//import java.io.*;
//import java.nio.file.*;
//
//
//public class ItHomePageGalenFFchromeIETest extends ItBaseGalen {
//    private static final Logger logger = LoggerFactory.getLogger(ItHomePageGalenFFchromeIETest.class);
//
//
//    @BeforeTest
//    void setupTestData(){
//        setupGalenTestData(URL, TEST_GSPEC_FILENAME);
//        this.setGspec(TEST_GSPEC_FILENAME);
//        logger.info("gspecFilename ["+gspecPath+"]");
//        printSetup();
//        logger.info("System.getProperty(galen.test.env); "+System.getProperty("galen.test.env"));
//    }
//
//}
//
///**
// String targetDirName = TestUtil.generateRandomFolderName(this.getClass().getName());
// File sourceLocation = new File(System.getProperty("user.dir") + "/target/galen-html-reports");
// File targetLocation = new File(sourceLocation+targetDirName);
//
// //@AfterSuite
// void copyGalenReport(){
// try {
// Long startMoveTime = System.currentTimeMillis();
// logger.info("AfterSuite started copping files ......!"+startMoveTime );
//
// String baseReportDestinationPath = System.getProperty("user.dir") + "/target/surefire-reports/";
// String filename  = this.getClass().getName().replace("com.englishlive.tests.galen.test.", "");
// Path source      = Paths.get(System.getProperty("user.dir") + "/target/galen-html-reports");
// Path destination = Paths.get(baseReportDestinationPath + TestUtil.generateRandomFilename(filename));
//
// logger.info("Report sourceLocation is "+source);
// logger.info("Report targetLocation is "+destination);
//
// TestUtil.moveDir(source, destination);
//
// Long endMoveTime = System.currentTimeMillis();
// Long moveTime = endMoveTime-startMoveTime;
// logger.info("Dir/Files Moved ... Time to complete ["+moveTime+"] milliseconds");
// }catch (Exception e){
// logger.error("Failed to copy Galen Reports ...!"+e.getMessage());
// }
// }
//
//
// */
