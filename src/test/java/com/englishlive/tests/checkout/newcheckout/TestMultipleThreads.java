//package com.englishlive.tests.checkout.newcheckout;
//
///**
// * Created by nikol.marku on 18/03/2016.
// */
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.firefox.FirefoxDriver;
//        import org.testng.Assert;
//        import org.testng.annotations.Test;
//
//public class TestMultipleThreads {
//
//    @Test(invocationCount = 2, threadPoolSize = 3)
//    public void loadTest() {
//
//        System.out.printf("%n[START] Thread Id : %s is started!",
//                Thread.currentThread().getId());
//
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://yourwebsite.com");
//
//        //perform whatever actions, like login, submit form or navigation
//
//        System.out.printf("%n[END] Thread Id : %s",
//                Thread.currentThread().getId());
//
//        driver.quit();
//
//    }
//}