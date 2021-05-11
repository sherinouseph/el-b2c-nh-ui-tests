//package com.englishlive.tests.nogrid;
//
//import com.englishtown.helpers.WebClientResponseHelper;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
///**
// * Created by nikol.marku on 27/04/2016.
// */
//public class TestHttpClient {
//
//    static int count = 0;
//    static long startTime;
//    static long endTime;
//
//
//    @BeforeClass
//    void setup(){
//        startTime = System.currentTimeMillis();
//        System.out.println("Start Time is : " + startTime);
//    }
//
//
//    @Test(threadPoolSize = 10, invocationCount = 10,  timeOut = 110000)
//    void checkResponseContent() {
//        try{Thread.sleep(2000);}catch (Exception e){}
//        WebClientResponseHelper.getHttpURLConnectionResponseCode("http://usb-etcqpub3.englishtown.com:4503/content/englishtown/de/de.html");
//        synchronized ((Integer) count) {
//            count++;
//            System.out.println("Count is : " + count);
//        }
//    }
//
////    @Test
////    void checkResponseContent() {
////        //try {
////        for (int c = 0; c < 10; c++) {
////            try{Thread.sleep(2000);}catch (Exception e){}
////            WebClientResponseHelper.getHttpURLConnectionResponseCode("http://usb-etcqpub3.englishtown.com:4503/content/englishtown/de/de.html");
////            synchronized ((Integer) count) {
////                count++;
////                System.out.println("Count is : " + count);
////            }
////        }
////    }
//
//
//    @AfterClass
//    void tearDown(){
//        endTime = System.currentTimeMillis();
//        System.out.println("end Time is : " + endTime);
//        long totalTime = endTime - startTime;
//        System.out.println("Total Time is : " + totalTime+" Seconds ...!");
//    }
//
//}
