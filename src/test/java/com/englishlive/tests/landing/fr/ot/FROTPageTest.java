package com.englishlive.tests.landing.fr.ot;
/**
* EE test
*/

import com.englishlive.tests.landing.base.BaseOTPageTest;
import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FROTPageTest extends BaseOTPageTest {
    @Value("#{applicationPropertiesList['fr.ot.url']}")
    private String otPageUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        formLeadTypeValue = "ot";
        this.getPage().isUrlValidForThisPage();
        try{Thread.sleep(300);}catch (Exception e){}
        noOfWebFormElements = 8;
        formDataMap = EfConstants.frOTFormMap;
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