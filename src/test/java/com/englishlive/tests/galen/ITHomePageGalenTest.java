//package com.englishlive.tests.galen;
///**
// * Created by nikol.marku on 10/26/2016.
// * Galen FW test
// *
// * see:
// * https://groups.google.com/forum/#!topic/galen-framework/EppJn4jAr-I]
// *http://axatrikx.com/test-responsive-design-galen-framework/
// * http://galenframework.com/docs/reference-galen-spec-language-guide/#SpecsReference
// *
// * Sections can be defined using = symbol and tags can be defined using @on notation
// *
// */
//
//import com.englishlive.tests.galen.core.BaseGalen;
//import com.englishlive.tests.galen.core.DevicesDataProvider;
//import com.englishlive.tests.galen.core.TestDevice;
//import com.englishtown.driver.MyBrowserType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import java.io.IOException;
//
//
//public class ITHomePageGalenTest extends BaseGalen {
//    private static final Logger logger = LoggerFactory.getLogger(ITHomePageGalenTest.class);
//    final String URL          = "https://englishlive.ef.com/it-it/";
//    final String TEST_GSPEC_FILENAME = "homepage_IT.gspec";
//
//    @BeforeTest
//    void setupTestData(){
//        failTestPerEnvironment(URL);
//        setupGalenTestData(MyBrowserType.FIREFOX, URL, TEST_GSPEC_FILENAME);
//        logger.info("gspecFilename ["+gspecPath+"]");
//        printSetup();
//    }
//
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class) //, threadPoolSize = 3, invocationCount = 1, timeOut = 60000) //)cant run on parallel
//    public void homePage_designTest_onDevices(TestDevice device) throws IOException {
//        load("");
//        checkLayout(gspecPath, device.getTags());
//    }
//
//}
//
//
//
//
///*
//    @Test(dataProvider = "devices")
//    public void loginPage_shouldLookGood_onDevice(TestDevice device) throws IOException {
//        load(""); //        getDriver().findElement(By.xpath("//button[.='Login']")).click();
//        checkLayout(gspecFilename, device.getTags());
//    }*/
//
//
