package com.englishlive.tests.landing.sa.os;
/**
 *
 */

import com.englishtown.pages.landing.OSLandingPage;
import com.englishlive.tests.landing.base.BaseOSPageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Sa1OSPageTest extends BaseOSPageTest {
    @Value("#{applicationPropertiesList['sa1.os.url']}")
    private String osPageUrl;

    @Override
    protected String getLocalizedTestPhoneNumber(){
        return null;
    }

    @Override
    protected OSLandingPage createPage() {
        formLeadTypeValue = "os";
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }

    @BeforeClass
    protected void setupBeforeClass(){
        setThreadSafeDriver();
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


}
