package com.englishlive.tests.landing.de.to;

import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.landing.OSLandingPage;
import com.englishlive.tests.landing.base.BaseOSPageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class De1OsToPageTest extends BaseOSPageTest {
    @Value("#{applicationPropertiesList['de1.to.url']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['test.telephone.de']}")
    private String localizedTestPhoneNumber;

    @Override
    protected String getLocalizedTestPhoneNumber(){
        return localizedTestPhoneNumber;
    }

    @Override
    protected OSLandingPage createPage() {
        formLeadTypeValue = "os";
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }

    @BeforeClass
    protected void setupBrowser(){
        setThreadSafeDriver();
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}

