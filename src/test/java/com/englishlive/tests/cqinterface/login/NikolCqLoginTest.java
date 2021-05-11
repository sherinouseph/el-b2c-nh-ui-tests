//package com.englishlive.tests.cqinterface.login;
///**
// * Created by nikol.marku on 1/3/2017.
// */
//import com.englishlive.tests.cqinterface.login.core.BaseCqLoginTest;
//import com.englishtown.pages.cq.CqLoginPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// Sept 2017 Can not login using login url as it shows onclick 403  error in console
//public class NikolCqLoginTest extends BaseCqLoginTest{
//    private static final Logger logger = LoggerFactory.getLogger(NikolCqLoginTest.class);
//
//
//    @BeforeClass
//    protected void testSetup(){
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), CQ_QA_BASE_URL) ; //CQ_LIVE_BASE_URL CQ_QA_BASE_URL getCQ_QA_LOGIN_URL());
//        loginPage = new CqLoginPage(getWebDriver());
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
