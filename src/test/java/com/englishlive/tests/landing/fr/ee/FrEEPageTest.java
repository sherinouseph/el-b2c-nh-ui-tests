package com.englishlive.tests.landing.fr.ee;
/*
 * this goes now to confirmation page and not TY page
 */
import com.englishtown.pages.landing.EELandingPage;
import com.englishtown.tests.core.EfConstants;
import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FrEEPageTest extends BaseEEtoThankyouFormFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(FrEEPageTest.class);

    @Value("#{applicationPropertiesList['fr.ee.url']}")
    private String eePageUrl;
    @Value("#{applicationPropertiesList['test.telephone.frh']}")
    private String localizedTestPhoneNumber;



    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        this.getPage().isUrlValidForThisPage();
        formLeadTypeValue = "ee";
        try{Thread.sleep(1000);}catch (Exception e){}
        noOfWebFormElements = 7;
        thankyou_page_url_contains ="lp/ty"; // "emailenglish";
        formDataMap = EfConstants.frEEFormMap;
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
