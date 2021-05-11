package com.englishlive.tests.login.checkcomponents.core;
/**
 *
 */

import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.pages.common.ResetPasswordPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseResetPassTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseResetPassTest.class);


    @Test(dataProvider = "mainMarketResetPassUrls", dataProviderClass = MainMarketsHomeUrlsDataProvider.class) //,      threadPoolSize = 7, invocationCount = 1, timeOut = 120000)
    protected void openResetPassPageAncCheckMainComponents(String country, String resetPassUrl) {
       try {
           setThreadSafeDriver();
           CookieHandler.deleteCookies(getWebDriver());
           resetPassUrl = getBASEURL() + resetPassUrl;
           logger.info("Test Url : " + resetPassUrl);
           openUrl(getWebDriver(), resetPassUrl, -1);
           sleep(1000);
           ResetPasswordPage resetPasswordPage = new ResetPasswordPage(getWebDriver());
           resetPasswordPage.checkMainComponetsTest();
       }finally {
           destroyDriver();
       }
    }


}
