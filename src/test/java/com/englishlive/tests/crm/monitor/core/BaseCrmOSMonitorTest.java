package com.englishlive.tests.crm.monitor.core;
/**
 * Created by nikol.marku on 10-Jul-17.
 *
 *
 */

import com.englishtown.dataprovider.CrmOSOEMonitorDatatProvider;
import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;


public abstract class BaseCrmOSMonitorTest extends BaseCrmDinamycTest{

    private static final Logger logger = LoggerFactory.getLogger(BaseCrmDinamycTest.class);

    protected CrmMonitOSOEUrlBean crmBean;
    protected Map formDataMap = EfConstants.CRM_MAGICFORM_MAP;


    /**
     *
     * @param crmBean
     *
     * Deleting cookies did not work well as some issues with ctr cookie
     */
    //@Test(dataProvider = "getCrmMonitOSurlsObj", dataProviderClass = CrmOSOEMonitorDatatProvider.class)  //local test
    @Test(dataProvider = "getCrmMonitOSurls", dataProviderClass = CrmOSOEMonitorDatatProvider.class)
    void createNewUser_login_forgetPassFlowTest(CrmMonitOSOEUrlBean crmBean) {
        this.crmBean = crmBean;
        this.crmBean.print();

            try {
                setThreadSafeDriver();
                newCRMuserEnterFormDataAndSubmitAndCheckPayPage();
            }finally {
                CookieHandler.deleteCookies(getWebDriver());
                destroyDriver();
            }

            try {
                setThreadSafeDriver();
                loginCRMnewUserCheckWelcomeBackPage();
            }finally {
                //CookieHandler.deleteCookies(getWebDriver());
                destroyDriver();
            }

            try {
                setThreadSafeDriver();
                crmUserForgottenPasFlowTest();
            }finally {
                //CookieHandler.deleteCookies(getWebDriver());
                destroyDriver();
            }
            //TestUtil.getScreenShotUsingAShot(getWebDriver(), ".\\target\\"+TestUtil.generateRandomFilename("crmOS_") + ".png");
            //testUtil.takeScreenshot(TestUtil.generateRandomFilename("crmOS_" + this.getClass().getSimpleName() + "_"), getWebDriver(), true);

    }

  //  @Test
    void newCRMuserEnterFormDataAndSubmitAndCheckPayPage(){
        testStartUrl = getBASEURL()+crmBean.getUrl();                                                                   //(StringUtils.containsIgnoreCase(testStartUrl, "es-mx/lp/os")){ testStartUrl = testStartUrl + "?ctr=mx";      }
        openUrl( getWebDriver(), testStartUrl);
        setupWebElementCssPerMarket(crmBean.getCountryTwoLetterCode());
        formDataMap = getOSFormDataMap( crmBean.getCountryTwoLetterCode());
        logger.info("FormDataMap is [{}] ", formDataMap);
        enterNewUserFormDataAndSubmit(formDataMap);
        waitForUrlContains(getWebDriver(), payPageUrlContains, 15);

        assertIsUrlContaining(payPageUrlContains);
        //CookieHandler.safeDeleteCookies(getWebDriver(), 2);
    }

    /**
     * open url as existing user [crmmb=1 ] and login
     */
    //@Test(dependsOnMethods = "newCRMuserEnterFormDataAndSubmitAndCheckPayPage")
    void loginCRMnewUserCheckWelcomeBackPage() {
        testStartUrl = testStartUrl+"?crmmb=1";
             // common sites need ctr param
        if(StringUtils.containsIgnoreCase(testStartUrl, "es-mx/lp/os")) {
            testStartUrl = testStartUrl + "&ctr=mx";
        }

        openUrl( getWebDriver(), testStartUrl);
        loginExistingUserCheckWelcomeBackPage(getUserEmail(), crmLoginBtnCss, welcomeBackUrlContains, welcomeBackSubmitBtnCss );
        //CookieHandler.deleteCookies(getWebDriver());
        sleep(1000);
    }

    /**
     * submit forgotten pass form for the new user and check confirmation message
     */
    //@Test(dependsOnMethods = "loginCRMnewUserCheckWelcomeBackPage")
    void crmUserForgottenPasFlowTest() {
        openUrl( getWebDriver(), testStartUrl);                                                                           //if(StringUtils.equals(crmBean.getCountryTwoLetterCode(), "de")){   // de page got no link for this    } else {
        checkForgottenPassCrmFlow(getUserEmail(), forgotPassTyMessage);
    }



}


/**  dont run forget pass on this once as click is not working reliably
 ar-sa/lp/os/crm-acq-30-day-challenge/?crmmb=1
 en-gb/lp/os/crm-acq-30-day-challenge/?crmmb=1
 en-wws/lp/os/crm-acq-30-day-challenge/?crmmb=1
 */
            /*List<String> excludeUrls = new ArrayList();
            excludeUrls.add("ar-sa/lp/os/crm-acq-30-day-challenge");
            excludeUrls.add("en-gb/lp/os/crm-acq-30-day-challenge");
            excludeUrls.add("en-wws/lp/os/crm-acq-30-day-challenge");
            if(ListUtils.)
            if(StringUtils.contains(TestUtil.getCurrentUrl(getWebDriver()), "crm-acq-30-day-challenge") && StringUtils.contains("")) {*/


//
//    @Test
//    void newCRMuserEnterFormDataAndSubmitAndCheckPayPage(){
//        crmBean.print();
//
//        testStartUrl = getBASEURL()+crmBean.getUrl();
//        if(StringUtils.containsIgnoreCase(testStartUrl, "es-mx/lp/os")){
//            testStartUrl = testStartUrl + "?ctr=mx";
//        }
//        openUrl( getWebDriver(), testStartUrl);
//         sleep(3000);
//        setupWebElementCssPerMarket(crmBean.getCountryTwoLetterCode());
//
//        enterNewUserFormDataAndSubmit(formDataMap);
//         sleep(2000);
//        waitForUrlContains(getWebDriver(), payPageUrlContains, 15);
//
//        assertIsUrlContaining(payPageUrlContains);
//        CookieHandler.safeDeleteCookies(getWebDriver(), 2);                                                         //getWebDriver().close(); destroyDriver();setThreadSafeDriver();
//    }
//
//    /**
//     * open url as existing user [crmmb=1 ] and login
//     */
//    @Test(dependsOnMethods = "newCRMuserEnterFormDataAndSubmitAndCheckPayPage")
//    void loginCRMnewUserCheckWelcomeBackPage() {
//        openUrl( getWebDriver(), testStartUrl+"?crmmb=1");
//        setupWebElementCssPerMarket(crmBean.getCountryTwoLetterCode());
//        loginExistingUserCheckWelcomeBackPage(getUserEmail(), crmLoginBtnCss, welcomeBackUrlContains, welcomeBackSubmitBtnCss );
//        CookieHandler.safeDeleteCookies(getWebDriver(), 2);
//        sleep(1000);
//    }
//
//    /**
//     * submit forgotten pass form for the new user and check confirmation message
//     */
//    @Test(dependsOnMethods = "loginCRMnewUserCheckWelcomeBackPage")
//    void crmUserForgottenPasFlowTest() {
//        openUrl( getWebDriver(), testStartUrl+"?crmmb=1");
//        sleep(1000);
//        if(StringUtils.equals(crmBean.getCountryTwoLetterCode(), "de")){
//            // de page got no link for this
//        } else {
//            checkForgottenPassCrmFlow(getUserEmail(), forgotPassTyMessage);
//        }
//        sleep(1000);
//    }

