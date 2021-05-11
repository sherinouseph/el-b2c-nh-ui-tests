package com.englishlive.tests.cqinterface.login.core;
/**
 * Created by nikol.marku on 1/3/2017.
 */

import com.englishlive.tests.cqinterface.core.BaseCqTest;
import com.englishtown.pages.cq.CqHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCqLoginTest extends BaseCqTest implements ICqHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCqLoginTest.class);


    @Test
    protected void loginToCqAndCheckUserLoggedIn(){
        loginPage.enterCredentialsAndClickLogin(CQ_USERNAME, CQ_PASSWORD);
        sleep(1000);
        cqHomePage = new CqHomePage(getWebDriver());
        cqHomePage.simpleTest();
        assertIsUrlContaining(cqHomePage.pageUrl);
    }

    @Test (dependsOnMethods = "loginToCqAndCheckUserLoggedIn")
    protected void checkUserPermission(){
        cqHomePage.assertUsersPermission(CQ_USER_PERMISSION);
    }

    public void setUserCredentials(String username, String pass){
        CQ_USERNAME = username;
        CQ_PASSWORD = pass;
    }

    public void setUserPermission(String permissionStr){
        this.CQ_USER_PERMISSION = permissionStr;
    }
}
