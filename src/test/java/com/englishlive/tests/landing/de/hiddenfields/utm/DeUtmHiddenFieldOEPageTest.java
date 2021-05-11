package com.englishlive.tests.landing.de.hiddenfields.utm;
/**
 *  Open URL and check hidden fields  see $oldHiddenFieldIds
 */
import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeUtmHiddenFieldOEPageTest extends BaseUtmHiddenField {
    private static final Logger logger = LoggerFactory.getLogger(DeUtmHiddenFieldOEPageTest.class);

    @Value("#{applicationPropertiesList['de1.oe.utm.url']}")
    private String osPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), this.osPageUrl, -1 ) ;
        sleep(200);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}




