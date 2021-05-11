package com.englishlive.tests.login.checkcomponents.core;
/**
 *
 */
import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseForgotPassTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseForgotPassTest.class);
    String absUrl = "forgotten-password/";
    String testUrl = "";



    @Test(dataProvider = "mainMarketHomePages", dataProviderClass = MainMarketsHomeUrlsDataProvider.class)
    protected void openResetPassPageAncCheckMainComponents(boolean isOldLoginPage, String homePageUrl) {
        try {
            setThreadSafeDriver();
            CookieHandler.deleteCookies(getWebDriver());
            testUrl = getBASEURL() + homePageUrl + absUrl;
            logger.info("Test Url : " + testUrl);
            openUrl(getWebDriver(), testUrl, -1);
            ForgottenPassPage forgottenPassPage = new ForgottenPassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            forgottenPassPage.isOldPage = isOldLoginPage;
            if (StringUtils.contains(testUrl, "/it-it/")) {
                forgottenPassPage.isOldPage = false;
            }
            forgottenPassPage.checkMainComponentsDisplayed();
        }finally {
            destroyDriver();
        }
    }




}
