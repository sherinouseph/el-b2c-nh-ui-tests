//package com.englishlive.tests.galen.core;
///**
// * Created by nikol.marku on 10/26/2016.
// * Galen FW test
// *  All test in on test suite
// *  each test setup spec and URL and will run on 3 devices
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
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import com.galenframework.api.Galen;
//import com.galenframework.reports.GalenTestInfo;
//import net.sf.uadetector.internal.data.domain.Device;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.LinkedList;
//import java.util.List;
//
//
//public abstract class BaseHomePageTest extends BaseGalen {
//    private static final Logger logger = LoggerFactory.getLogger(BaseHomePageTest.class);
//
//    protected String testGspecFilename ; //= "homepage_IT.gspec";
//    protected String testUrl;
//
//
//    /**
//     * Each test setup spec and url by overriding this method
//     */
//    protected abstract void setupSpecFileAndTestUrl();
//
//    @BeforeClass
//    protected void setup(){
//        this.setupSpecFileAndTestUrl();
//    }
//
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
//    public void homePage_designTest_onChrome_(TestDevice device) throws IOException {
//        setupGalenTestData( testUrl, testGspecFilename);
//        setDriverType(MyBrowserType.CHROME);
//        setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        layoutReport = Galen.checkLayout(getDriver(), gspecPath, device.getTags());  //checkLayout(gspecPath, device.getTags());
//    }
//
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
//    public void homePage_designTest_onIE11_(TestDevice device) throws IOException {
//        setupGalenTestData( testUrl, testGspecFilename);
//        setDriverType(MyBrowserType.EXPLORER11);
//        setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        layoutReport = Galen.checkLayout(getDriver(), gspecPath, device.getTags());
//
//    }
//
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
//    public void homePage_designTest_onFF_(TestDevice device) throws IOException {
//        setupGalenTestData( testUrl, testGspecFilename);
//        setDriverType(MyBrowserType.FIREFOX);
//        setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        layoutReport = Galen.checkLayout(getDriver(),gspecPath, device.getTags());
//    }
//
//
//    @AfterMethod
//    protected void afterTestMethod(){
//        logger.info("After Test method add test to report ....!");
//        // beforeClass set this up once per test Creating a list of tests//       tests = new LinkedList<GalenTestInfo>();
//        // Creating an object that will contain the information about the test
//        test = GalenTestInfo.fromString(currentRunningMethod);
//        // Adding layout report to the test report
//        test.getReport().layout(layoutReport, currentRunningMethod); //"homePage_designTest_onIE11_onDevices");
//        tests.add(test);
//    }
//
//}
//
//
