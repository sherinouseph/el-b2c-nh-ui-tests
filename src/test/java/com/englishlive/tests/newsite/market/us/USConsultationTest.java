package com.englishlive.tests.newsite.market.us;

/**
 * Created by nikol.marku on 8/24/2016.
 *
 *
 */

import com.englishlive.tests.newsite.core.BaseConsultationTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class USConsultationTest extends BaseConsultationTest {
    public static final Logger logger = LoggerFactory.getLogger(USConsultationTest.class);
    @Value("#{applicationPropertiesList['us.free.consultation.url']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        isInlineTyMsg = false;
        urlContainsThankyou = "thank-you";
        formDataMap = EfConstants.usFreeConsultationFormMap;
        thankYouMsgContains = "thank you";
        submitFormBtnCss = ".formset-button button";
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
    }

    @Override
    public void click_ConsultationButton(){
        logger.info("No need to run this test for US ...!");
    }
/*
    @Override
    public void check_ThankyouMsgShown(){
        check_ThankyouMsgShownUS();
    }*/

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}
