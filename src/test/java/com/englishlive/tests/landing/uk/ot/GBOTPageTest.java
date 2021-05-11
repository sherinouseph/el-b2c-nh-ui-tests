package com.englishlive.tests.landing.uk.ot;
/**
* EE test
*/

import com.englishlive.tests.landing.base.BaseOTPageTest;
import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GBOTPageTest extends BaseOTPageTest {
    @Value("#{applicationPropertiesList['gb.ot.url']}")
    private String otPageUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        formLeadTypeValue = "ot";
        this.getPage().isUrlValidForThisPage();
        try{Thread.sleep(300);}catch (Exception e){}
        noOfWebFormElements = 8;
        //clickKey = "osformsubmit";
        formDataMap = EfConstants.itOTFormMap;
        thankyou_page_url_contains = "lp/ty";
    }

    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.otPageUrl);
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}