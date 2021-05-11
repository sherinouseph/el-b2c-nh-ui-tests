package com.englishlive.tests.newhouse.school.account;
/**
 *
 * Billing page test ....
 * User: nikol.marku
 * Date: 23/10/18 updated sept 2019
 *
 */

import com.englishtown.tests.core.school.useraccount.BaseCheckBillingPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BillingPageTest extends BaseCheckBillingPageTest{
    private static final Logger logger = LoggerFactory.getLogger(BillingPageTest.class);
    @Value("#{applicationPropertiesList['user.profile']}")
    protected String testUsername;

    @BeforeClass
    protected void setup(){
        username = "testuser24thaugust@qp1.org";
        password = "Cardinal2020";
        setThreadSafeDriver();
        openUrl(getWebDriver(), getBASEURL());
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
