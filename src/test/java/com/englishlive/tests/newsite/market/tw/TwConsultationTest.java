package com.englishlive.tests.newsite.market.tw;

/**
 * Created by nikol.marku on 8/24/2016.
 *
 * 1. open mx honme page
 * 2. Enter form data and submit
 * 3.
 *
 */

import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TwConsultationTest extends EnterFormDataSubmitCheckTyMsgTest {
    public static final Logger logger = LoggerFactory.getLogger(TwConsultationTest.class);
    @Value("#{applicationPropertiesList['home.page.tw']}")
    protected String testUrl;
    private String saConsultationUrl = "free-consultation/";


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        formDataMap = EfConstants.twFreeConsultationFormMap;
        isInlineTyMsg = false;
        formLeadTypeValue = "oe";
        urlContainsThankyou = "thank-you";

        submitFormBtnCss = ".formset .btn.btn-primary";
        openUrl(getWebDriver(), testUrl+saConsultationUrl);
        thankYouMsgContains = "خطة تعليمية تناسب";
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


}
