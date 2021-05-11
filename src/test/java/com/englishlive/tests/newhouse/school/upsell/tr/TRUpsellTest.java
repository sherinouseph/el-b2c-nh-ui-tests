package com.englishlive.tests.newhouse.school.upsell.tr;
/**
 * Add products and buy
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 *auto_upsell@qp1.org
 */

import com.englishtown.tests.core.school.upsell.BaseUpsellPaymentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;


public class TRUpsellTest extends BaseUpsellPaymentTest {
    private static final Logger logger = LoggerFactory.getLogger(TRUpsellTest.class);
    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.tr.upsell_buy']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        isNewHouseUser = true;
        isNewhousePayment = true;
        testStartUrl = testUrl;
        username = testUsername;
        setUserEmail(testUsername);
        password = "passpass";
        setLanguageAndMarket("tr", "tr");
        Locale locale = new Locale("tr", "tr");
        upsellUrl ="englishlive.ef.com/"+getLanguage()+"-"+getMarket()+"/buy/upsell-nh/upsell";
        otherOfferRowIndex = 1;
        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

