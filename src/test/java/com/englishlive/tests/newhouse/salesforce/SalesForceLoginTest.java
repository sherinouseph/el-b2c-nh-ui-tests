package com.englishlive.tests.newhouse.salesforce;
/**
 * Login to sales force
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishtown.newhouse.salesforce.pages.HomeSalesForcePage;
import com.englishtown.newhouse.salesforce.pages.LoginSalesForcePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class SalesForceLoginTest extends BaseSalesforceTest{
    private static final Logger logger = LoggerFactory.getLogger(SalesForceLoginTest.class);


    @BeforeMethod
    public void setup(){
        testStartUrl = SALESFORCE_QA_URL;
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl);
    }

    @Test
    void loginAsAdmin(){
        LoginSalesForcePage loginSalesForcePage = new LoginSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        loginSalesForcePage.login(ADMIN_QA, SALESFORCE_PASS );
        HomeSalesForcePage homeSalesForcePage = new HomeSalesForcePage(getWebDriver());
        homeSalesForcePage.simpleTest();
    }

    @Test
    void loginAsFrSalesAgent(){
        LoginSalesForcePage loginSalesForcePage = new LoginSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        loginSalesForcePage.login(FRANCE_SALESAGENT_QA, SALESFORCE_PASS );
        HomeSalesForcePage homeSalesForcePage = new HomeSalesForcePage(getWebDriver());
        homeSalesForcePage.simpleTest();
    }


    @AfterMethod
    protected void testAftertest(){
        destroyDriver();
    }


}
