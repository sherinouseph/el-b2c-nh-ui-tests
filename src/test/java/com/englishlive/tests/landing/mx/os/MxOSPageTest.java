package com.englishlive.tests.landing.mx.os;

import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.EfConstants;
import com.englishlive.tests.landing.base.DynamicBaseOSPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MxOSPageTest extends DynamicBaseOSPageTest {
    private static final Logger logger = LoggerFactory.getLogger(MxOSPageTest.class);
    @Value("#{applicationPropertiesList['mx.os.url']}")
    private String osPageUrl;

    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        isEnterNumberOneByOne = true;
        this.getPage().isUrlValidForThisPage();
        noOfWebFormElements = 8;
        formDataMap = EfConstants.mxOSFormMap;
        pay_page_url_contains = "payment";
    }

    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}

