package com.englishlive.tests.landing.de.ot;
/**
* OT test use ptn and etag
*/

import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import com.englishlive.tests.landing.base.BaseOtPtnAndEtagPageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeOTPtnAndEtagTest extends BaseOtPtnAndEtagPageTest {
    @Value("#{applicationPropertiesList['de.ot.url.ptn.etag']}")
    private String otPageUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        this.getPage().isUrlValidForThisPage();
        try{Thread.sleep(1000);}catch (Exception e){}
        noOfWebFormElements = 8;
        formDataMap = EfConstants.deOTFormMap;
        thankyou_page_url_contains = "lp/ty";
    }

    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.otPageUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}