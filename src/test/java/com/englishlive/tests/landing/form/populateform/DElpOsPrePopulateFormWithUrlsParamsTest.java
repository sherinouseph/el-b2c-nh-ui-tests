package com.englishlive.tests.landing.form.populateform;
/**
 *
 */
import com.englishtown.tests.core.common.BasePrePopulateFormWithUrlsParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class DElpOsPrePopulateFormWithUrlsParamsTest extends BasePrePopulateFormWithUrlsParams {
    private static final Logger logger = LoggerFactory.getLogger(DElpOsPrePopulateFormWithUrlsParamsTest.class);
    @Value("#{applicationPropertiesList['de.lp.os.form.params.url']}")
    protected String testUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), this.testUrl, -1) ;
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}
