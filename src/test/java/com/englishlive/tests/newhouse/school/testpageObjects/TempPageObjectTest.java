//package com.englishlive.tests.newhouse.school.testpageObjects;
///**
// * This is for test ONLY
// *
// *
// */
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.newhouse.school.pages.home.SchoolFooterPage;
//import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
//import com.englishtown.pages.common.LoginPage;
//import com.englishtown.tests.core.school.core.BaseSchoolTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class TempPageObjectTest extends BaseSchoolTest {
//    private static final Logger logger = LoggerFactory.getLogger(TempPageObjectTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//    SchoolHeaderPage schoolHeaderPage;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        testStartUrl = testUrl;
//        this.username = testUsername;
//        openUrl(getWebDriver(), testStartUrl);
//    }
//
//
//    @Test
//    protected void enterUserCredentialsAndLoginToSchool(){
//        logger.info("enterUserCredentialsAndLoginToSchool  ...!");
//        String user = "auto_91176753577554_OYSHRJH570270271_xdelx@qp1.org";
//        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        loginPage.simpleTest();
//        loginPage.enterCredentials(user, "passpass");
//        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
//        logger.info("checkUserIsAtSchoolHomePage  ...!"+waitForUrlContains);
//        waitForUrlEndsWithTxt(getWebDriver(),waitForUrlContains, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//
//    @Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")
//    protected void footerPomTest(){
//        SchoolFooterPage sfp = new SchoolFooterPage(getWebDriver());
//        sfp.simpleTest();
//        //sfp.clickOnEmailUs();// debug by calling all mentods .. test ok
//        sfp.assertCopyrightText();
//        /* lang
//        click(sfp.changeLanguageWe);
//        sleep(1000);
//        sfp = new SchoolFooterPage(getWebDriver());
//        sfp.selectLanguage("ge");
//        sleep(1000);*/
//    }
//
//    //@Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")
//    protected void checkHeaderPom(){
//        /*
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToMyAccountSetting();
//        sleep(5000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToMyAccountReferFriend();
//        sleep(3000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToMyAccountAndLogout();
//        sleep(3000);
//
//
//        /*schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToCurrentCourse();
//        sleep(300);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToProgressAndTests();
//        sleep(3000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToChangeCourse();
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToAppsAndTools();
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToBookPrivateClass();
//        sleep(3000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToBookGroupClass();
//        sleep(3000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToCurrentBooking();
//        sleep(3000);
//
//
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToSupportLiveHelp();
//        sleep(5000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToSupportEmailUs();
//        sleep(5000);
//
//        backward(getWebDriver());
//        sleep(3000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        schoolHeaderPage.simpleTest();
//        schoolHeaderPage.goToSupportHelplCenter();
//        sleep(3000);*/
//
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        //destroyDriver();
//    }
//
//}
