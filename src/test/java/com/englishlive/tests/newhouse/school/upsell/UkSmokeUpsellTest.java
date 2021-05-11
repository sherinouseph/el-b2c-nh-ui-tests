package com.englishlive.tests.newhouse.school.upsell;
/**
 * Add products and buy
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 *auto_upsell@qp1.org
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.school.upsell.BaseSmokeUpsellTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;


public class UkSmokeUpsellTest extends BaseSmokeUpsellTest {
    private static final Logger logger = LoggerFactory.getLogger(UkSmokeUpsellTest.class);
    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.smokeupsell']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver(); //MyBrowserType.EXPLORER11, 25);
        testStartUrl = testUrl;
        this.username = testUsername;
        this.setUserEmail(testUsername);

        upsellUrl ="englishlive.ef.com/en-gb/buy/upsell/upsell?ctr=gb";

        currencySymbol = getCurrencySymbol(Locale.UK);    //Currency.getInstance(Locale.UK).getSymbol(Locale.UK);
        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
        openUrl(getWebDriver(), testStartUrl);
    }

    @Override
    protected void checkUserIsAtSchoolHomePage(){
        logger.info("Override checkUserIsAtSchoolHomePage  check URL not contains login .... as user might not be in this page ...!");
        waitForUrlNotContaining(getWebDriver(), "login", WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
