package com.englishlive.tests.newsite.market.gb;

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

public class GBConsultationTest extends BaseConsultationTest {
    public static final Logger logger = LoggerFactory.getLogger(GBConsultationTest.class);
    @Value("#{applicationPropertiesList['gb.price.page']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        formDataMap = EfConstants.ukFreeConsultationFormMap;
        thankYouMsgContains = "hank you for";
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
