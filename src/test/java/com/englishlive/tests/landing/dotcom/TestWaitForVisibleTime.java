//package com.englishlive.tests.landing.dotcom;
//
//import com.englishtown.tests.core.BaseTestHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.Test;
//
///**
// * Created by nikol.marku on 05/04/2016.
// test wait for visible will wait for the time specified and not as neustar api waitfor
// */
//public class TestWaitForVisibleTime extends BaseTestHelper{
//
//    long time ;
//    long tempTime;
//
//    @Test
//    void testWaitForVisible(){
//        openUrl(getWebDriver(), "http://englishlive.ef.com/");
//        time = System.currentTimeMillis();
//        System.out.print(" Current time : "+time );
//        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.className("nikolcq-dd-image")),getWebDriver(), 15);
//        tempTime = System.currentTimeMillis();
//        System.out.print(" afterWaitFor  time : "+tempTime );
//        System.out.print(" Diff time : "+(tempTime - time) );
//
//    }
//}
