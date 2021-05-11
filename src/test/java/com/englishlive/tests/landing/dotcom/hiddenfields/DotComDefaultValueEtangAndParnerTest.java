package com.englishlive.tests.landing.dotcom.hiddenfields;

import com.englishtown.pages.landing.OSLandingPage;
import com.englishlive.tests.landing.base.BaseDefaultValueEtangAndParnerTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Test default value for ptn and etag
 * etag=""; partner="None"
 * Date: 04/09/14  *
 */
public class DotComDefaultValueEtangAndParnerTest extends BaseDefaultValueEtangAndParnerTest {
    @Value("#{applicationPropertiesList['eu.en.os.url1']}")
    private String osPageUrl;

    @BeforeClass
    void openPage(){
        setThreadSafeDriver();
        openPageAndValidate("et-sp-ppcmember-submit");
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
