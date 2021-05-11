package com.englishlive.tests.cqinterface.core;

import com.englishtown.pages.cq.CQI;
import com.englishtown.pages.cq.CqHomePage;
import com.englishtown.pages.cq.CqLoginPage;
import com.englishtown.tests.core.BaseTestHelper;
import com.sun.org.apache.bcel.internal.generic.PUSH;

/**
 * Created by nikol.marku on 1/3/2017.
 * All CQ test extends this one
 *
 */
public abstract class BaseCqTest extends BaseTestHelper implements CQI {

    protected CqLoginPage loginPage;
    protected CqHomePage cqHomePage;
    protected String CQ_PASSWORD         =  CODI;

    public String CQ_USER_PERMISSION     = "CN=Nikol Marku,OU=Staff,OU=Users,OU=RC,OU=WorkSpace,OU=GBLCM,OU=EMEA,DC=ef,DC=com"; //for nikol
    public String failMsg                = "CQ test are dangerous and should only run on QA environment ...! ";
    public String CQ_USERNAME            = CQ_USER ;

    public CqHomePage openUrlAndLoginToCQ(){
        openUrl(getWebDriver(), getCQ_LOGIN_URL());
        failTestPerUrl(getWebDriver().getCurrentUrl(), getCQ_BASE_URL(), failMsg);

        CqLoginPage loginPage = new CqLoginPage(getWebDriver());
        loginPage.enterCredentialsAndClickLogin(CQ_USERNAME, CQ_PASSWORD);
        sleep(2000);
        CqHomePage cqHomePage = new CqHomePage(getWebDriver());
        cqHomePage.simpleTest();
        assertIsUrlContaining(cqHomePage.pageUrl);
        return cqHomePage;
    }



    //*************************
    public CqLoginPage getLoginPage() {
        return loginPage;
    }

    public CqHomePage getCqHomePage() {
        return cqHomePage;
    }

    public String getCQ_USERNAME() {
        return CQ_USERNAME;
    }

    public String getCQ_PASSWORD() {
        return CQ_PASSWORD;
    }

    public String getCQ_PROTOCOL() {
        return CQ_PROTOCOL;
    }

   private String getCQ_BASE_URL() {
        return CQ_BASE_URL;
    }

    public String getCQ_QATEST_PAGE_URL() {
        return CQ_QATEST_PAGE_URL;
    }

    public String getCQ_QA_BASE_URL() {
        return CQ_QA_BASE_URL;
    }

    public String getCQ_LOGIN_URL() {
        return CQ_LOGIN_URL;
    }

    public String getCQ_USER_PERMISSION() {
        return CQ_USER_PERMISSION;
    }

    public String getCQ_QATEST_MAINSITE_URL() {
        return CQ_QATEST_MAINSITE_URL;
    }




}
