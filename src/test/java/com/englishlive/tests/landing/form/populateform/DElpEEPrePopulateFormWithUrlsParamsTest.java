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


public class DElpEEPrePopulateFormWithUrlsParamsTest extends BasePrePopulateFormWithUrlsParams {
    private static final Logger logger = LoggerFactory.getLogger(DElpEEPrePopulateFormWithUrlsParamsTest.class);
    @Value("#{applicationPropertiesList['de.lp.ee.form.params.url']}")
    protected String testUrl;

    private String[] testWeCsss      = {"input[name=first_name]", "input[name=last_name]","input[name=email]"};

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        isCheckLastNameTest = false;
        this.setupWeIds(testWeCsss);
        openUrl(getWebDriver(), this.testUrl, -1) ;
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}
