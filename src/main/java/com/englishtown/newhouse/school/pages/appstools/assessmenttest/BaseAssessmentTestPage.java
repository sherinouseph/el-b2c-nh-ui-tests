package com.englishtown.newhouse.school.pages.appstools.assessmenttest;
/**
 * Nikol  Feb 2019
 *
 */

import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseAssessmentTestPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(BaseAssessmentTestPage.class);
    public static final String pageUrl = "/1/school/test/assessmenttest/";

    protected final String startTestlinkText = "Start the Test";


    //--------------------------------------------------------------------------------------

    public BaseAssessmentTestPage(WebDriver webDriver){
        super(webDriver);
    }


    public BaseAssessmentTestPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BaseAssessmentTestPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public BaseAssessmentTestPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    public String getPageUrl() {
        return pageUrl;
    }



}
