package com.englishlive.tests.newhouse.school.upsell.adyen;
/**
 * Add products in the upsell page and buy with a new Payment method
 *
 * User: Sherin Ouseph
 * Date:05/11/2019

 */

import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.tests.core.school.upsell.BaseAdyenUpsellPaymentTest;
import com.englishtown.tests.core.school.upsell.BaseUpsellPaymentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;


public class ITUpsellTest extends BaseAdyenUpsellPaymentTest {
    private static final Logger logger = LoggerFactory.getLogger(ITUpsellTest.class);
    @Value("#{applicationPropertiesList['it.it.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.itupsell_buy']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = testUrl;
        this.username = testUsername;
        this.setUserEmail(testUsername);
        adyenTestCard= AdyenTestCard.VISA;
        isNewhousePayment=false;
        is_adyen3DSecure=true;
        is_adyenPayment=true;
        this.password = "passpass";
        upsellUrl ="englishlive.ef.com/it-it/buy/upsell/upsell?ctr=it";

        currencySymbol = getCurrencySymbol(Locale.ITALY);    //Currency.getInstance(Locale.UK).getSymbol(Locale.UK);
        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
