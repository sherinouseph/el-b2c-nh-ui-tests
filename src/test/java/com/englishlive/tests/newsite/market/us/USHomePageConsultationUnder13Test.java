package com.englishlive.tests.newsite.market.us;

/**
 * Created by nikol.marku on 8/24/2016.
 * test if ate <13 then
 * Our services are not suitable for people below 13 years old
 */

import com.englishlive.tests.newsite.core.BaseConsultationTest;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class USHomePageConsultationUnder13Test extends BaseConsultationTest {
    public static final Logger logger = LoggerFactory.getLogger(USHomePageConsultationUnder13Test.class);
    @Value("#{applicationPropertiesList['us.homepage.url']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        formDataMap = EfConstants.usFreeConsultationUnder13FormMap;
        thankYouMsgContains = "thank you";
        submitFormBtnCss = ".formset-button";
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
    }

    @Override
    public void click_ConsultationButton(){
        logger.warn("No need to run this test for US ...!");
    }

    @Override
    public void check_ThankyouMsgShown(){
        logger.warn("No need to run this test as we need to check validation msg for edge <13 shown ...!");
        check_AgeValidationUnder13Shown();
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


}
