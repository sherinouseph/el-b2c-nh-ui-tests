//package com.englishlive.tests.jserror.locales;
///**
// * Created by nikol.marku on 9/1/2016.
// * Create new FF driver
// */
//import com.englishlive.tests.jserror.core.BaseTestCheckJSerror;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.local.DriverManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//// not fixed for long time so removed
//public class UKCheckJSerrorReturnLoginUrlTest extends BaseTestCheckJSerror {
//    private static final Logger logger = LoggerFactory.getLogger(UKCheckJSerrorReturnLoginUrlTest.class);
//    @Value("#{applicationPropertiesList['uk.return.to.school.url']}")
//    protected String testUrl;
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        DriverManager.createDriver(MyBrowserType.FIREFOX, 15);
//        openUrl(DriverManager.getDriver(), testUrl);
//    }
//
//
//    @AfterClass
//    void killFFDriver(){
//        DriverManager.destroyLocalDriver();
//    }
//
//
//}
