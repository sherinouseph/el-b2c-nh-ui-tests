package com.englishlive.tests.landing.de.os;
/**
 * Hidden field test for : crt, lng,
 * User: nikol.marku
 * Date: 01/09/14 .
 */
import com.englishtown.pages.landing.OSLandingPage;
import com.englishlive.tests.landing.base.BaseSendTagOnUrlTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DeOS1SendTagOnUrlTest extends BaseSendTagOnUrlTest {
    @Value("#{applicationPropertiesList['de1.os.url']}")
    private String osPageUrl;

    @BeforeClass
    void openPage(){
        setThreadSafeDriver();
        testStartUrl = osPageUrl;
        openPageSendTagUrl(tag, itagValue, osformsubmitId);
    }

    @Test
    void testEtagHiddenFieldTest(){
        checkOsHiddenFildTest(itagId, itagValue, 15);
    }

    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }



    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }



}
