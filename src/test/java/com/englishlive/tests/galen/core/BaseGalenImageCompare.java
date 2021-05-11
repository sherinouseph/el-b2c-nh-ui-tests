//package com.englishlive.tests.galen.core;
///**
// * Created by nikol.marku on 10/26/2016.
// * Image compare
// *
// */
//
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.common.ForgottenPassPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//
//public abstract class BaseGalenImageCompare extends BaseGalen {
//    private static final Logger logger = LoggerFactory.getLogger(BaseGalenImageCompare.class);
//    //
//    protected String crmMagicFormNewUser = "englishlive.ef.com/en-gb/lp/os/crm-lp-2017/";
//    protected String crmMagicFormExistingUser = crmMagicFormNewUser + "?crmmb=1";
//
//    private String CRM_GB_NEWUSER_GSPEC = "CrmNewUserFormGb.gspec";
//    private String CRM_GB_EXISTUSER_LOGIN_GSPEC = "CrmExistUserLoginFormGb.gspec";
//
//    private String CRM_GB_EXISTUSER_FORGETPASS_GSPEC = "crmExistUserForgetPassFormGb.gspec";
//    protected String forgottenPassWeCss = ".forgotten-your-passowrd";
//
//
//    @Test(dataProvider = "devicesImageTest", dataProviderClass = DevicesDataProvider.class)
//    public void GB_CrmMagicExistUserForgetPassForm_imageTest(TestDevice device) throws IOException {
//        setupGalenTestData( getBaseUrl()+crmMagicFormExistingUser, CRM_GB_EXISTUSER_FORGETPASS_GSPEC);
//        setDriverType(MyBrowserType.CHROME);
//        printSetup();
//        load("");
//        WaitTool.waitForElementClickable(getDriver(), By.cssSelector(forgottenPassWeCss), WaitTool.DEFAULT_IMPLICIT_WAIT);
//        WaitTool.findElement(getDriver(), By.cssSelector(forgottenPassWeCss)).click();
//        ForgottenPassPage forgottenPassPage = new ForgottenPassPage(getDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT);
//        forgottenPassPage.simpleTest();
//        checkLayout(gspecPath, device.getTags());
//    }
//
//    //
//
//    @Test(dataProvider = "devicesImageTest", dataProviderClass = DevicesDataProvider.class)
//    public void GB_CrmMagicExistUserLoginForm_imageTest(TestDevice device) throws IOException {
//        setupGalenTestData( getBaseUrl()+crmMagicFormExistingUser, CRM_GB_EXISTUSER_LOGIN_GSPEC);
//        setDriverType(MyBrowserType.CHROME);
//        // use this to generate reports ror many galen test .. setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        checkLayout(gspecPath, device.getTags());
//    }
//
//    @Test(dataProvider = "devicesImageTest", dataProviderClass = DevicesDataProvider.class)
//    public void GB_CrmMagicNewUserForm_imageTest(TestDevice device) throws IOException {
//        setupGalenTestData( getBaseUrl()+crmMagicFormNewUser, CRM_GB_NEWUSER_GSPEC);
//        setDriverType(MyBrowserType.CHROME);
//        // use this to generate reports ror many galen test .. setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        checkLayout(gspecPath, device.getTags());
//    }
///*
//    @Test(dataProvider = "devicesImageTest", dataProviderClass = DevicesDataProvider.class)
//    public void DE_PricePage_bg_imageTest(TestDevice device) throws IOException {
//        setupGalenTestData( dePricePageUrl, DE_PRICEPAGE_BG_GSPEC);
//        setDriverType(MyBrowserType.CHROME);
//        // use this to generate reports ror many galen test .. setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        waitAndCloseCookieLayer();
//        checkLayout(gspecPath, device.getTags());
//    }
//
//    @Test(dataProvider = "devicesImageTest", dataProviderClass = DevicesDataProvider.class)
//    public void DE_HomePage_Illustator1_imageTest(TestDevice device) throws IOException {
//        setupGalenTestData( deHomePageUrl, DE_HOME_ILLUSTRATOR_GSPEC);
//        setDriverType(MyBrowserType.CHROME);
//        // use this to generate reports ror many galen test .. setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        waitAndCloseCookieLayer();
//        checkLayout(gspecPath, device.getTags());
//    }*/
//
//}