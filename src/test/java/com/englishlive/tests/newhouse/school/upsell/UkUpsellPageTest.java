package com.englishlive.tests.newhouse.school.upsell;
/**
 *
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 *qa: and live : auto_upsell@qp1.org auto_upsell@qp1.org
 */

import com.englishtown.tests.core.school.upsell.BaseUpsellPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;


public class UkUpsellPageTest extends BaseUpsellPageTest {
    private static final Logger logger = LoggerFactory.getLogger(UkUpsellPageTest.class);
    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.upsell']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = testUrl;
        this.username = testUsername;

        upsellUrl ="englishlive.ef.com/en-gb/buy/upsell/upsell?ctr=gb";

        currencySymbol = getCurrencySymbol(Locale.UK);    //Currency.getInstance(Locale.UK).getSymbol(Locale.UK);
        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
