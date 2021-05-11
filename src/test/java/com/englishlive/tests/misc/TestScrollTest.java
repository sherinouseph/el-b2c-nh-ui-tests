//package com.englishlive.tests.misc;
///**
// *
// */
//import com.englishtown.helpers.ElementScreenPosition;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.tests.core.BaseTest;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class TestScrollTest extends BaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(TestScrollTest.class);
//    //@Value("#{applicationPropertiesList['home.en.de.url']}")
//    private String osPageUrl ="http://englishlive.ef.com/ja-jp/"; //http://englishlive.ef.com/zh-tw/lp/oe/cnn_2016_01_11/"; //"; //http://englishlive.ef.com/community/Secure/Login.aspx?return=/community/home/default.aspx";
//
//    @BeforeClass
//    public void setup(){
//        getWebDriver().get(osPageUrl);
//        try {  Thread.sleep(2000); }catch (Exception e){}
//        clickAtWindow(getWebDriver(), 1,1);
//    }
//    @Test
//    void testWebElementLocation(){
//        JavaScriptHelper.scrollWebElementToView(getWebDriver(), By.cssSelector(".teacher-title h2"), ElementScreenPosition.TOP, 100);
//  //      JavaScriptHelper.scrollWebElementToView(getWebDriver(), getWebDriver().findElement(By.cssSelector(".socialmedia li .icon-facebook")), ElementScreenPosition.BUTTON, 40);
//  //      JavaScriptHelper.scrollWebElementToView(getWebDriver(), getWebDriver().findElement(By.cssSelector(".socialmedia li .icon-facebook")), ElementScreenPosition.MIDDLE, 20);
//        logger.info("2");
//        try {  Thread.sleep(15000); }catch (Exception e){}
//
//    }
//
//}
//
