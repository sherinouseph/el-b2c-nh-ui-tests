package com.englishlive.tests.landing.de.os;

/**
 *
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.landingpages.BaseLPtoPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class De1OSPageTest extends BaseLPtoPayment{ // BaseOSPageTest{
    private static final Logger logger = LoggerFactory.getLogger(De1OSPageTest.class);
    @Value("#{applicationPropertiesList['de1.os.url']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['test.telephone.de']}")
    private String localizedTestPhoneNumber;


    @BeforeClass
    protected void setupBeforeClass(){
        //isEnsureCheckedEmailEnglish = false;
        formDataMap = EfConstants.defaultDataMapNoConfirmPass;
        is_adyenPayment=true;
        FULL_NAME = formDataMap.get("firstname") + " " + formDataMap.get("lastname");
        formLeadTypeValue = "os";

        setThreadSafeDriver();
        openUrl(getWebDriver(), osPageUrl);
    }


//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }

//    @Override
//    protected OSLandingPage createPage() {
//        isEnsureCheckedEmailEnglish = false;
//        formLeadTypeValue = "os";
//        return new OSLandingPage(getWebDriver(), this.osPageUrl);
//    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }
}




