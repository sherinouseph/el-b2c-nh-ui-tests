package com.englishlive.tests.responsive;
/**
 * Created by nikol.marku on 1/12/2017.
 * https://jira-bos.englishtown.com/browse/SAND-3367
 *
 */
import com.englishlive.tests.responsive.core.BaseComponentInsideOtherTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class UsSubmitButtonShownTest extends BaseComponentInsideOtherTest{
    private static final Logger logger = LoggerFactory.getLogger(UsSubmitButtonShownTest.class);
    @Value("#{applicationPropertiesList['us.free.consultation.url']}")
    protected String testUrl ;


    @BeforeClass
    public void setup() {
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), testUrl, -1);
        logger.info("Check form on full size ...!");
        checkFormInsideIllustratorSection(); // check on full screen
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}