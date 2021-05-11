package com.englishlive.tests.landing.sa.oe;

import com.englishlive.tests.landing.base.BaseOEPageTest;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.landing.OELandingPage;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *2017
 */
public class ArSaOEPageTest extends BaseOEPageTest{
    private static final Logger logger = LoggerFactory.getLogger(ArSaOEPageTest.class);

    @Value("#{applicationPropertiesList['sa.oe.crm.sa']}")
    private String oePageUrl;
    @Value("#{applicationPropertiesList['test.telephone.frh']}")
    private String localizedTestPhoneNumber;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        TestUtil.printMethodName(logger, 2);
        formLeadTypeValue = "oe";
        this.getPage().isUrlValidForThisPage();
        thankyou_page_url_contains ="thank-you" ;
        noOfWebFormElements = 9;
        formDataMap = EfConstants.SA_OECMRM_MAP; //frOEFormMap;
    }

    @Override
    protected String getLocalizedTestPhoneNumber(){
        return localizedTestPhoneNumber;
    }
    @Override
    protected OELandingPage createPage() {
        return new OELandingPage(getWebDriver(), this.oePageUrl);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }

}
