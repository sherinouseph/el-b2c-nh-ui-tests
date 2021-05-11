package com.englishlive.tests.landing.de.hiddenfields;
/**
* Hidden field test for : crt, lng,
* User: nikol.marku
* Date: 01/09/14 .
 *
 *
 *
*/
import com.englishtown.pages.landing.OSLandingPage;
import com.englishlive.tests.landing.base.BaseOsPartnerPtnGoesToCheckPayPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DePartnerPtnGoesToCheckPayPageTest extends BaseOsPartnerPtnGoesToCheckPayPage {
    private static final Logger logger = LoggerFactory.getLogger(DePartnerPtnGoesToCheckPayPageTest.class);
    @Value("#{applicationPropertiesList['de1.os.url.ptn']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['test.telephone.de']}")
    private String localizedTestPhoneNumber;

    @BeforeClass
    protected void setupBeforeClass(){
        setThreadSafeDriver();
    }

    @Override
    protected String getLocalizedTestPhoneNumber(){
        return localizedTestPhoneNumber;
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



