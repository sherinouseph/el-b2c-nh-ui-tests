package com.englishlive.tests.landing.de.ee;
/**
* EE test
*/

import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.EnglishtownStateObject;
import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class De1EEPageTest extends BaseEEtoThankyouFormFlowTest {
    @Value("#{applicationPropertiesList['de1.ee.url']}")
    private String eePageUrl;

    private static final Logger logger = LoggerFactory.getLogger(De1EEPageTest.class);


    @BeforeClass
    protected void setup(){
        setLanguageAndMarket("de", "de");
        setThreadSafeDriver();
        formLeadTypeValue = "ee";
        this.getPage().isUrlValidForThisPage();
        try{Thread.sleep(1000);}catch (Exception e){}
        noOfWebFormElements = 6;
        formDataMap = EfConstants.deEEFormMap;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.eePageUrl);
    }


    @Test//(priority=3)
    public void verifyMarket() throws Exception{
        isStateObjectKey(getWebDriver(),"page.market", getMarket());
    }

    @Test//(priority=3)
    public void verifyLanguage() {
        sleep(1000);
        isStateObjectKey(getWebDriver(),"page.language", getLanguage());
    }


}