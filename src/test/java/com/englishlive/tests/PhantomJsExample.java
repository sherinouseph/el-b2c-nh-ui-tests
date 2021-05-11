//package com.englishlive.tests;
//
///**
// * Created by nikol.marku on 11/04/2015.
// */
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.tests.core.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//public class PhantomJsExample extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(PhantomJsExample.class);
//
//    private static String URL = "http://www.englishtown.de"; //"http://www.google.com"; //
//
//    @Test
//    public void testPhantomJS1(){
//        //DesiredCapabilities DesireCaps = new DesiredCapabilities();
//        //DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\tools\\selenium\\phantomjs-2.0.0\\bin\\phantomjs.exe");
//        //WebDriver driver=new PhantomJSDriver(DesireCaps);
//        WebDriver driver = getWebDriver();
//        logger.info(" Open URL : "+URL);
//        driver.get(URL);
//        logger.info("Page loaded ...! ");        //                                                                                  WebElement element = driver.findElement(By.name("q"));       element.sendKeys("Cheese!");       element.submit();
//        WebElement testWe = WebElementHelper.safeFindElement(driver, By.cssSelector(".login-link a"));
//        logger.info(" found Element testWe ...! ");
//        testWe.click();
//        logger.info(" Clicked @ testWe ...! ");//        try{ Thread.sleep(5000);} catch (InterruptedException ie){}
//        //
//        logger.info("Page title is: " + driver.getTitle());
//        //System.out.println("Page source : " + driver.getPageSource());
//        logger.info("Page URL is: " + driver.getCurrentUrl());
//        // take screenshot
//        TestUtil.takeScreenshot("nikoGostDriver", driver, false);
//        // end
//        logger.info("Quit ...!");
//        driver.quit();
//    }
//
//}
