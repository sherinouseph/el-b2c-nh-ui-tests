package com.englishlive.tests.newhouse.school.upsell.adyen;
/**
 * Add products and buy through stored payment token via Adyen
 *
 * User: Sherin Ouseph
 * Date: 05/11/2019
 *
 *
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.school.upsell.BaseSmokeUpsellTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;


public class ITSmokeUpsellTest extends BaseSmokeUpsellTest {
    private static final Logger logger = LoggerFactory.getLogger(ITSmokeUpsellTest.class);
    @Value("#{applicationPropertiesList['it.it.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.itadyensmokeupsell']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver(); //MyBrowserType.EXPLORER11, 25);
        testStartUrl = testUrl;
        this.username = testUsername;
        password="passpass";
        is_adyenPayment=true;
        this.setUserEmail(testUsername);
        upsellUrl ="englishlive.ef.com/it-it/buy/upsell/upsell?ctr=it";
        currencySymbol = getCurrencySymbol(Locale.ITALY);    //Currency.getInstance(Locale.UK).getSymbol(Locale.UK);
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
