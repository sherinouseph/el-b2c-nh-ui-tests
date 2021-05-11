package com.englishlive.tests.landing.tw.oe;

import com.englishlive.tests.landing.base.BaseOEPageTest;
import com.englishtown.pages.landing.OELandingPage;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TW1OEPageTest extends BaseTWOEPageTest {
    private static final Logger logger = LoggerFactory.getLogger(TW1OEPageTest.class);

    @Value("#{applicationPropertiesList['tw.oe1.url']}")
    private String oePageUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        this.getPage().isUrlValidForThisPage();
        formLeadTypeValue = "oe";
        thankyou_page_url_contains ="lp/ty" ;
        noOfWebFormElements = 9;
        formDataMap = EfConstants.twOE1FormMap;
    }

    @Override
    protected OELandingPage createPage() {
        return new OELandingPage(getWebDriver(), this.oePageUrl);
    }


    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}

