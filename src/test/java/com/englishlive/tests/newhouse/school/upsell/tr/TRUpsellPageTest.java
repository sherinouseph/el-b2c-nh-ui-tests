package com.englishlive.tests.newhouse.school.upsell.tr;
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


public class TRUpsellPageTest extends BaseUpsellPageTest {
    private static final Logger logger = LoggerFactory.getLogger(TRUpsellPageTest.class);
    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.tr.upsell']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        password = "passpass";
        setLanguageAndMarket("tr", "tr");
        Locale locale = new Locale("tr", "tr");
        upsellUrl ="englishlive.ef.com/"+getLanguage()+"-"+getMarket()+"/buy/upsell-nh/upsell";
        testStartUrl = testUrl;
        this.username = testUsername;
        currencySymbol = "₺";
        initialTotalPriceTxt = currencySymbol+String.format("%.2f", initialTotalPrice);
        initialTotalPriceTxt = initialTotalPriceTxt.replace(".", ",");
        otherOfferRowIndex = 1;
        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

