package com.englishtown.tests.core.school;
/**
 * On login page Login an existing user [ctr]
 * User: nikol.marku
 * Date: 29/01/18
 *
 * Note : All school test should extend this one
 *
 *
 */


import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.pages.schoollite.EfIdLoginPage;
import com.englishtown.tests.core.school.core.BaseSchoolTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.WaitToolConfig.*;


public abstract class BaseSimpleLogin extends BaseSchoolTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseSimpleLogin.class);


    /**
     * Expected to be on login page
     * Test should set username and pass
     * TODO: loginBtnLatest should be dynamic for some page ... need to see how this performs
     */
    @Test
    protected void enterUserCredentialsAndLoginToSchool(){
        logger.info("enterUserCredentialsAndLogin  ...!");
        efIdLoginPage = new EfIdLoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        efIdLoginPage.getPageLoadedCondition();
        efIdLoginPage.simpleTest();
        //CookieHandler.setCookiesValueForTimeZone(getWebDriver(),"1");
        efIdLoginPage.enterCredentials(username, password);
        sleep(1000);
        efIdLoginPage.clickLoginBtn(efIdLoginPage.loginBtn);
    }

    /**
     * TODO: Need to see if we need to separate the below to another abstract class
     */
    @Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")
    protected void checkUserIsAtSchoolHomePage(){
        logger.info("checkUserIsAtSchoolHomePage  ...!"+waitForUrlContains);
        sleep(5000);
        initSchoolHeaderAndFooter();
//To be uncommented when we setup new users
       // WebElement timezonePopup=findElement(By.cssSelector(".timezone-management-form-submit span:first-child"));
//        boolean isTimeZonePopupShown =WaitTool.waitForIsDisplayed(getWebDriver(), By.cssSelector(".timezone-management-form-submit span:first-child"),
//              recommendPopupWaitTimeSec);

        //boolean isTimeZonePopupShown =   WaitTool.waitForElementClickable_fluentWait(getWebDriver(),timezonePopup,10,1000);
//        boolean isCloseButtonShown =   WaitTool.waitForIsDisplayed(getWebDriver(), By.cssSelector(".fancybox-close"),
//                recommendPopupWaitTimeSec);
//      if(isTimeZonePopupShown)
//           clickSavebtnInTimeZonePopUp();
//        else if(isCloseButtonShown)
//            click(By.className(closeRecommendPopupCss));
//        else
//           logger.info("no popup shown");


//        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        schoolHeaderAndFooterPage.getPageLoadedCondition();
        //schoolHeaderAndFooterPage.simpleTest();

}




}
