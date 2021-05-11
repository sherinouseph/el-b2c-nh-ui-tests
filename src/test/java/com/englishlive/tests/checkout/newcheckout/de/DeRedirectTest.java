package com.englishlive.tests.checkout.newcheckout.de;
/**
 *
 *
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.CheckoutRedirectBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeRedirectTest extends CheckoutRedirectBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(DeRedirectTest.class);
    @Value("#{applicationPropertiesList['new.checkout.base.de.de.url']}")
    protected String pageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        TestUtil.printMethodName(logger);
        logger.info("setup url: "+pageUrl);
        this.openUrl(getWebDriver(), this.pageUrl, -1 ) ;
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }



}

