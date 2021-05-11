package com.englishlive.tests.newsite.market.us;

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

public class USHomePageConsultationTest extends BaseConsultationTest {
    public static final Logger logger = LoggerFactory.getLogger(USHomePageConsultationTest.class);
    @Value("#{applicationPropertiesList['us.homepage.url']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        formDataMap = EfConstants.usFreeConsultationFormMap;
        thankYouMsgContains = "thank you";
        submitFormBtnCss = ".formset-button button";
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
    }

    @Override
    public void click_ConsultationButton(){
        logger.info("No need to run this test for US ...!");
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}
