package com.englishlive.tests.landing.sa.os;
/**
 *
 */

import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.landingpages.BaseLPtoPayment;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Sa79OSPageTest extends BaseLPtoPayment{// BaseOSPageTest {
    @Value("#{applicationPropertiesList['sa.os79.url']}")
    private String osPageUrl;


    @BeforeClass
    protected void setupBeforeClass(){
        formDataMap = EfConstants.fNameLNameEmailPass;
        FULL_NAME = formDataMap.get("firstname")+ " " + formDataMap.get("lastname");
        formLeadTypeValue = "os";
        submitBtn = ".bs3 .btn-primary-blue";
        setThreadSafeDriver();
        openUrl(getWebDriver(), osPageUrl);
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


}
