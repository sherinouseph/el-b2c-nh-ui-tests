package com.englishlive.tests.checkout.newcheckout.fr;
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


public class FrRedirectTest extends CheckoutRedirectBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(FrRedirectTest.class);
    @Value("#{applicationPropertiesList['new.checkout.base.fr.fr.url']}")
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

