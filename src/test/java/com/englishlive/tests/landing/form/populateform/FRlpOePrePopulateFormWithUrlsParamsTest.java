package com.englishlive.tests.landing.form.populateform;
/**
 *
 */
////page does not exist....hence commenting out.....this test should run with a different url..will work on that
import com.englishtown.tests.core.common.BasePrePopulateFormWithUrlsParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class FRlpOePrePopulateFormWithUrlsParamsTest extends BasePrePopulateFormWithUrlsParams {
    private static final Logger logger = LoggerFactory.getLogger(FRlpOePrePopulateFormWithUrlsParamsTest.class);
    @Value("#{applicationPropertiesList['fr.lp.oe.form.params.url']}")
    protected String testUrl;

    private String[] testWeCss = {"input[name=first_name]","input[name=last_name]", "input[name=email]"};

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        setupWeIds(testWeCss);
        openUrl(getWebDriver(), this.testUrl, -1) ;
    }

    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}
