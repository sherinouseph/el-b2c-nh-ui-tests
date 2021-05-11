package com.englishlive.tests.newsite.market.de;

/**
 * Created by nikol.marku on 8/24/2016.
 *
 *
 */

import com.englishlive.tests.newsite.core.BaseConsultationTest;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DEConsultationTest extends BaseConsultationTest {
    public static final Logger logger = LoggerFactory.getLogger(DEConsultationTest.class);
    @Value("#{applicationPropertiesList['de.price.page']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        formDataMap = EfConstants.deFreeConsultationFormMap;
        isInlineTyMsg = false;
        urlContainsThankyou = "thank-you";
        thankYouMsgContains = "Vielen Dank";
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
