package com.englishlive.tests.landing.de.hiddenfields.utm;
/**
 *  Open homepage URL with params then oppen member page and check hidden fields  see $oldHiddenFieldIds
 */
import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeHomeToOsUtmHiddenFieldTest extends BaseUtmHiddenField {
    private static final Logger logger = LoggerFactory.getLogger(DeHomeToOsUtmHiddenFieldTest.class);

    @Value("#{applicationPropertiesList['de.home.utm.url']}")
    private String homepage;
    @Value("#{applicationPropertiesList['de1.os.url']}")
    private String memberPage;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), this.homepage, -1 ) ;
        sleep(2000);//!!!!!
        this.openUrl(getWebDriver(), this.memberPage, -1 ) ;
        waitForHidenField(oldHiddenFieldIds[0], 35);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}




