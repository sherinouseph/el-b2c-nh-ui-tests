//package com.englishlive.tests.galen.core;
///**
// *https://jira.eflabs.io/browse/SAND-4718
// * test different illustrator configuration
// *
// */
//import com.englishtown.driver.MyBrowserType;
//import com.galenframework.api.Galen;
//import com.galenframework.reports.GalenTestInfo;
//import com.galenframework.reports.HtmlReportBuilder;
//import com.galenframework.reports.model.LayoutReport;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.List;
//
//
//public abstract class BaseIllustrator extends BaseGalen {
//    private static final Logger logger = LoggerFactory.getLogger(BaseIllustrator.class);
//
//    //protected String GB_GSPEC_ILLUSTROTOR_FILENAME = "illustrator.gspec";
//    protected String GB_GSPEC_ILLUSTROTOR_FILENAME = "modules/illustrator/illustrator_component.gspec";
//    protected String illustratorUrl = getBaseUrl()+"englishlive.ef.com/en-gb/lp/illustrator-automationtest/?ctr=gb";
//
//
//    @Test(dataProvider = "devicesDesktopMobile", dataProviderClass = DevicesDataProvider.class)
//    public void illustratorComponentTest(TestDevice device) throws IOException {
//        testUrl = illustratorUrl;
//        setupGalenTestData(illustratorUrl, GB_GSPEC_ILLUSTROTOR_FILENAME);
//        setDriverType(MyBrowserType.CHROME);
//        load("");
//        printSetup();
//
//                                                                    //checkLayout(gspecPath, device.getTags());
//        LayoutReport layoutReport = Galen.checkLayout(getDriver(), gspecPath, device.getTags());
//        generateReport(layoutReport, "illustratorComponentTest"+device.getTags(), GALEN_REPORTS_DIR+"illustrator"+device.getTags()+"/");
//
//
//    }
//
//}




/*// generate separate report
        LayoutReport layoutReport = Galen.checkLayout(getDriver(), gspecPath, device.getTags());
        // Creating a list of tests
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

        // Creating an object that will contain the information about the test
        GalenTestInfo test = GalenTestInfo.fromString("illustratorComponentTest");

        // Adding layout report to the test report
        test.getReport().layout(layoutReport, "check layout for Illustrator component");
        tests.add(test);

        // Exporting all test reports to html
        new HtmlReportBuilder().build(tests, GALEN_REPORTS_DIR+"illustrator/");
        */
//    Test 1 : Regular parsys default untick Start 2 End Top green default
//    Test 2 : Small parsys top untick end to start bottom Purple Align with start
//    Test 3: Regular parsys button Narrower Start 2 End bottom Purple Align with start
//    Test 4: Regular form default untick Start 2 End Top green default
//    Test 5: Small form top untick end to start bottom Purple Align with start
//    Test 6: Regular form button Narrower Start 2 End bottom Purple Align with start
//    Test 7:Regular Image default untick Start 2 End top green default
//    Test 8: Small Image top untick end to start top Purple Align with start
//    Test 9: Regular image button Narrower Start 2 End bottom Purple lign with start
//    Test 10: Regular image button Narrower Start 2 End bottom Purple lign with start caption position center
//    Test 11: Default config

/**
 // Creating a list of tests
 List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

 // Creating an object that will contain the information about the test
 GalenTestInfo test = GalenTestInfo.fromString("Login page on mobile device test");

 // Adding layout report to the test report
 test.getReport().layout(layoutReport, "check layout on mobile device");
 tests.add(test);


 // Exporting all test reports to html
 new HtmlReportBuilder().build(tests, "target/galen-html-reports");

 */