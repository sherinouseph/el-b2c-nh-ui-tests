package com.englishlive.tests.galen.core;
/**
 * Created by nikol.marku on 10/26/2016.
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.LinkedList;
import java.util.List;


public abstract class BaseGalen extends BaseGalenConfig{
    private static final Logger logger = LoggerFactory.getLogger(BaseGalen.class);

    protected String closeCookieCss = ".cookie-policy .close";

//
//    @BeforeClass
//    protected void beforeClassSetup(){
//        tests = new LinkedList<GalenTestInfo>();
//    }


    protected void setCurrentRunningMethod(TestDevice device){
        this.currentRunningMethod = Thread.currentThread().getStackTrace()[2].getMethodName()+"["+device.getName()+
                "_"+device.getScreenSize().toString().replace(","," x")+"]";
        logger.info("runningMethodName ["+currentRunningMethod+"]");
    }

    public void waitAndCloseCookieLayer(){
        sleep(1000);
        WebElement closeWe = getDriver().findElement(By.cssSelector(closeCookieCss)); //WaitTool.waitForElementClickable(getDriver(),  By.cssSelector(closeCookieCss), 25);
        WebElementHelper.click( closeWe);
        sleep(1000);
    }

    /**
     * TODO need some work
     * @param layoutReport
     * @param testInfo
     * @param newReportDir
     */

    public void generateReport(LayoutReport layoutReport, String testInfo, String newReportDir){
        // Creating a list of tests
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

        // Creating an object that will contain the information about the test
        GalenTestInfo test = GalenTestInfo.fromString(testInfo);

        // Adding layout report to the test report
        test.getReport().layout(layoutReport, "check layout "+"illustratorComponentTest");
        tests.add(test);

        // Exporting all test reports to html
        try {
            new HtmlReportBuilder().build(tests, newReportDir);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }


}

