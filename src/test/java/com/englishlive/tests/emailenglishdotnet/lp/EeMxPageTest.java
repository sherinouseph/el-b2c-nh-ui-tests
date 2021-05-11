package com.englishlive.tests.emailenglishdotnet.lp;
/**
* EE test
*/

import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// TODO refactor test cases - this is a different flow - uniq so far
public class EeMxPageTest extends BaseEEtoThankyouFormFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(EeMxPageTest.class);

    @Value("#{applicationPropertiesList['ee.lp.mx']}")
    private String eePageUrl;
    @Value("#{applicationPropertiesList['test.tel.mx.mobile']}")
    private String localizedTestPhoneNumber;


    @BeforeClass
    protected void setup(){
        formLeadTypeValue = "ee";
        eePageUrl = UrlMapper.mapBaseUrlToEtown(eePageUrl, getBASEURL());
        setLanguageAndMarket("es","mx");

        setThreadSafeDriver();
        this.getPage().isUrlValidForThisPage();
        try{Thread.sleep(1000);}catch (Exception e){}
        noOfWebFormElements = 10;
        formDataMap = EfConstants.mxEEFormMap_noPhone;
        phoneNO = "4492270000";
        isEnterPhoneOneByOne = true;
        thankyou_page_url_contains = "/ee-tyou";
    }


    protected String getLocalizedTestPhoneNumber(){
        return this.localizedTestPhoneNumber;
    }

    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.eePageUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }
}
