package com.englishlive.tests.landing.de.os;

import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.BaseLandingPageTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Negative testing
 * User: nikol.marku
 * Date: 27/08/14
 *
 */
//TODO refactor this to be base negative test for OS

public class De1OSPageExtensiveNegativeTest extends BaseLandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(De1OSPageExtensiveNegativeTest.class);

    @Value("#{applicationPropertiesList['de1.os.url']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['test.telephone.de']}")
    private String localizedTestPhoneNumber;

    protected int noOfWebFormElements=8;
    WebElement webElement;
    String validationMsgWe = "popover-content";
    static String userName = "noInit";
    Map userMap; // init this  dynamic email address

    @BeforeClass
    void setup(){
        setThreadSafeDriver();
        userName =  "test12345et_os"+System.currentTimeMillis()+"@qp1.org"; //"noInit";
        userMap = EfConstants.createMap(userName, getLocalizedTestPhoneNumber())  ;
        logger.info("Setup map with username : "+userName);
        EfConstants.dumpMap(userMap);
    }

    @Test
    void enter_empty_click_submit(){
       enter_data_click_submit_check_validation_Shown(EfConstants.deOsFormMap_empty);
    }

    @Test(dependsOnMethods = { "enter_empty_click_submit" })
    void enter_all_except_noPass_submit(){
        enter_data_click_submit_check_validation_Shown(EfConstants.deOsFormMap_noPass);
    }

    @Test(dependsOnMethods = { "enter_all_except_noPass_submit" })
    void become_A_Lead(){
        becomeALead(userMap);
    }

    @Test(dependsOnMethods = { "become_A_Lead" })
    void gobackToOsPageReuseSameEmailAndSubmit(){
        //delete cookies
        destroyDriver(getWebDriver());
        setThreadSafeDriver();
        //CookieHandler.deleteCookies(getWebDriver());
        sleep(10000); // wait for systems to update data on back end
        gobackToOsPageEnterDetailsAndSubmit(this.osPageUrl, userMap);
    }
    //TODO fix text looks like validation is shown for password - form change
    @Test(dependsOnMethods = { "gobackToOsPageReuseSameEmailAndSubmit" })
    void testUserExistMsgShownAndUserIsnNotAtCheckoutPage(){
        testOsValidationMessageShown("email") ;
        assertIsPaymentFormNotShown();
    }

    protected String getLocalizedTestPhoneNumber(){
        return localizedTestPhoneNumber;
    }

    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}
