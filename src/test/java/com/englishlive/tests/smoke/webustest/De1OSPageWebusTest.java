package com.englishlive.tests.smoke.webustest;

import com.englishtown.pages.landing.OSLandingPage;
import com.englishlive.tests.landing.base.BaseOSPageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;

public class De1OSPageWebusTest extends BaseOSPageTest {
    @Value("#{applicationPropertiesList['webus.de1.os.url']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['test.telephone.de']}")
    private String localizedTestPhoneNumber;

//    private String formAllElementSelector = "form .controls input";
//    private int noOfFormElemetns = 6; // 5 input txt and one check box
    @Override
    protected String getLocalizedTestPhoneNumber(){
        return this.localizedTestPhoneNumber;
    }
    @Override
    protected OSLandingPage createPage() {
        setThreadSafeDriver();
        formLeadTypeValue="os";
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }
}


