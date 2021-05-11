package com.englishlive.tests.newhouse.school.account;
/**
 *
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 */
import com.englishtown.tests.core.school.useraccount.BaseCheckMyAccountContentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CheckMyAccountContentTest extends BaseCheckMyAccountContentTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckMyAccountContentTest.class);

    @Value("#{applicationPropertiesList['user.myaccount']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        username = "sf-4f8t@qp1.org";
        password = "passpass";
        setThreadSafeDriver();
        openUrl(getWebDriver(), getBASEURL());
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
