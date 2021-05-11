package com.englishlive.tests.login.checkcomponents.core;
/**
 *
 */
import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseLoginTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginTest.class);
    protected String absUrl = "login/";
    protected String testUrl = "";
    
    //protected String loginPageAge;  protected String homePageUrl;
    /*protected BaseLoginTest(){}
    public BaseLoginTest(String loginPageAge, String homePageUrl) {
        this.loginPageAge = loginPageAge;
        this.homePageUrl  = homePageUrl;
    }*/

    @Test(dataProvider = "mainMarketHomePagesLogin", dataProviderClass = MainMarketsHomeUrlsDataProvider.class)//, threadPoolSize = 3, invocationCount = 1, timeOut = 120000 )
    protected void openResetPassPageAncCheckMainComponents(String loginPageAge, String homePageUrl) {
        try {
            testUrl = getBASEURL() + homePageUrl + absUrl;
            logger.info("Test Url : " + testUrl);
            setThreadSafeDriver();  // DriverManager.createDriver(MyBrowserType.CHROME, 15);
            logger.info("Test Thread ID : " + Thread.currentThread().getId());

            CookieHandler.deleteCookies(DriverManager.getDriver());

            openUrl(DriverManager.getDriver(), testUrl, -1);
            sleep(500);
            LoginPage loginPage = new LoginPage(DriverManager.getDriver(), 20);
            loginPage.getPageLoadedCondition();
            loginPage.checkUserNameAndPassTxtDisplayed();
            loginPage.loginFormCurrentType = loginPageAge;

            if (StringUtils.equalsIgnoreCase("old", loginPageAge)) {
                loginPage.isOldPage = true;
            } else if (StringUtils.equalsIgnoreCase("new", loginPageAge)) {
                loginPage.isNewPage = true;
            } else if (StringUtils.equalsIgnoreCase("latest", loginPageAge)) {
                loginPage.isLatest = true;
            } else {
                logger.info("Use default login page is New ...!");
                loginPage.isNewPage = true;
            }

            loginPage.checkLoginBtnDisplayed();

            if (loginPage.isLatest)
                loginPage.isSignupDisplayed();
            //}catch (Exception e){      e.printStackTrace(); throw new WebDriverException(e);       }
        }finally {
            System.out.println("closeDriverAfterEachTest .. destroy driver");
            DriverManager.destroyLocalDriver();
        }
    }



}
