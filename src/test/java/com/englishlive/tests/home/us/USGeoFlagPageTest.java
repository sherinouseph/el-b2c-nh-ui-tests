package com.englishlive.tests.home.us;
/**
 * Created by sherin 14/09/2017
 * open en-us
 * click en-gb flag and see if we redirect to en-gb site(geolocated country)
 * click on en-us flag and see if we are in the same url(en-us/site-country)
 * close the popup,check if you are in same-url(en-us/site-country)
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class USGeoFlagPageTest extends BaseGeoFlagPopupTest {
    @Value("#{applicationPropertiesList['us.homepage.url']}")
    private String pageUrl;
    public static final Logger logger = LoggerFactory.getLogger(USGeoFlagPageTest.class);



    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setTestStartUrl(pageUrl);
        openUrl(getWebDriver(), pageUrl);
        String urlContains="en-us";
    }

    @AfterClass

    protected void tearDownAfterClass(){
       destroyDriver();
    }
}
