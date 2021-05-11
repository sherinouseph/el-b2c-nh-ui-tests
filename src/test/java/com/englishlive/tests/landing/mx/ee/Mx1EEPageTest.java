package com.englishlive.tests.landing.mx.ee;
/**
* EE test
*/

import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// TODO refactor test cases - this is a different flow - unique so far
public class Mx1EEPageTest extends BaseEEtoThankyouFormFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(Mx1EEPageTest.class);

    @Value("#{applicationPropertiesList['mx1.ee.url']}")
    private String eePageUrl;
    @Value("#{applicationPropertiesList['test.tel.mx.mobile']}")
    private String localizedTestPhoneNumber;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        formLeadTypeValue = "ee";
        this.getPage().isUrlValidForThisPage();
        try{Thread.sleep(3000);}catch (Exception e){}
        noOfWebFormElements = 10;
        isEnterPhoneOneByOne = true;
        phoneNO = "4492270000";
        formDataMap = EfConstants.mxEEFormMap;
        thankyou_page_url_contains = "lp/ty"; //"pt-tyou-generic";
    }


    protected String getLocalizedTestPhoneNumber(){
        return this.localizedTestPhoneNumber;
    }

    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.eePageUrl);
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}
