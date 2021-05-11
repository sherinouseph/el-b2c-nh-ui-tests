package com.englishlive.tests.galen.core;
/**
 *
 *
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.ForgottenPassPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;


public abstract class MobileTabletBaseGalenAllPagesAllMarkets extends BaseGalen {
    private static final Logger logger = LoggerFactory.getLogger(MobileTabletBaseGalenAllPagesAllMarkets.class);

    private  String IT_GSPEC_FILENAME = "homepage_IT.gspec";
    private  String IT_PRICEPAGE_GSPEC = "pricepage_IT.gspec";
    private  String IT_HOWITWORKS_GSPEC = "howitworkspage_IT.gspec";
    private  String SA_HOME_GSPEC_FILENAME = "homepage_SA.gspec";
    private  String DE_HOME_ILLUSTRATOR_GSPEC = "imagecompareHomePageDe.gspec";
    private  String DE_PRICEPAGE_BG_GSPEC = "bgImagePricePageDe.gspec";
    private String itUrl          = getBaseUrl()+"englishlive.ef.com/it-it/";
    private String itPPUrl        = itUrl+"offerta-inglese/";
    private String itHowItWorksUrl= itUrl+"imparare-l-inglese/";
    private String mxUrl          = getBaseUrl()+"englishlive.ef.com/es-mx/";
    private String saUrl          = getBaseUrl()+"englishlive.ef.com/ar-sa/";
    private String ukUrl          = getBaseUrl()+"englishlive.ef.com/en-gb/";
    private String ukPPUrl        = ukUrl+"study-plans-and-prices/";
    private String deHomePageUrl  = getBaseUrl()+"englishlive.ef.com/de-de/";
    private String dePricePageUrl  = getBaseUrl()+"englishlive.ef.com/de-de/angebote-und-preise/";
    protected String closeCookieCss = ".cookie-policy .close'";

    // CRM magic Forms
    protected String crmMagicFormNewUser = "englishlive.ef.com/en-gb/lp/os/crm-lp-2017/";
    protected String crmMagicFormExistingUser = crmMagicFormNewUser + "?crmmb=1";

    private String CRM_GB_NEWUSER_GSPEC = "CrmNewUserFormGb.gspec";
    private String CRM_GB_EXISTUSER_LOGIN_GSPEC = "CrmExistUserLoginFormGb.gspec";

    private String CRM_GB_EXISTUSER_FORGETPASS_GSPEC = "crmExistUserForgetPassFormGb.gspec";
    protected String forgottenPassWeCss = ".forgotten-your-passowrd";
    // bg image
    //bgImagePricePageDe
    private final String TEST_GSPEC_FILENAME = IT_GSPEC_FILENAME;

    protected String GB_GSPEC_ILLUSTROTOR_FILENAME = "modules/illustrator/illustrator_component.gspec"; // "illustrator.gspec";
    protected String illustratorUrl = getBaseUrl()+"englishlive.ef.com/en-gb/lp/illustrator-automationtest/?ctr=gb";

    // devicesMobileTablet

    @Test(dataProvider = "devicesMobileTablet", dataProviderClass = DevicesDataProvider.class)
    public void illustratorComponentTest(TestDevice device) throws IOException {
        testUrl = illustratorUrl;
        setupGalenTestData(illustratorUrl, GB_GSPEC_ILLUSTROTOR_FILENAME);
        setDriverType(MyBrowserType.CHROME);
        load("");
        printSetup();
        checkLayout(gspecPath, device.getTags());
        //LayoutReport layoutReport = Galen.checkLayout(getDriver(), gspecPath, device.getTags());
        //generateReport(layoutReport, "illustratorComponentTest"+device.getTags(), GALEN_REPORTS_DIR+"illustrator"+device.getTags()+"/");
    }



    @Test(dataProvider = "devicesMobileTablet", dataProviderClass = DevicesDataProvider.class)
    public void UK_HomePage_Chrome_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( ukUrl, TEST_GSPEC_FILENAME);
        setDriverType(MyBrowserType.CHROME);
        // use this to generate reports ror many galen test .. setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags()); //layoutReport = Galen.checkLayout(getDriver(),gspecPath, device.getTags());
    }

     /**
     * UK price and package page
     */
    @Test(dataProvider = "devicesMobileTablet", dataProviderClass = DevicesDataProvider.class)
    public void UK_PriceAndPackagePage_Chrome_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( ukPPUrl, IT_PRICEPAGE_GSPEC);
        setDriverType(MyBrowserType.CHROME);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags());
    }


    /**
     *  IT home page
     **/
    @Test(dataProvider = "devicesMobileTablet", dataProviderClass = DevicesDataProvider.class)
    public void IT_HomePage_Chrome_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( itUrl, TEST_GSPEC_FILENAME);
        setDriverType(MyBrowserType.CHROME);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags());
    }

    /**
     *  IT How it Works page
     */
    @Test(dataProvider = "devicesMobileTablet", dataProviderClass = DevicesDataProvider.class)
    public void IT_HowItWorksPage_Chrome_onDevices(TestDevice device) throws IOException {
        setupGalenTestData(itHowItWorksUrl, IT_HOWITWORKS_GSPEC);
        setDriverType(MyBrowserType.CHROME);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        /*if(device.getName().contains("mobile")){
            waitForTabsShown(getDriver(), ".tabs .tab-item");
            sleep(1000);
        }*/

        sleep(1000);
        checkLayout(gspecPath, device.getTags());
    }

   @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
    public void MX_homePage_Chrome_onDevices(TestDevice device) throws IOException    {
        setupGalenTestData( mxUrl, TEST_GSPEC_FILENAME);
        setDriverType(MyBrowserType.CHROME);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        checkLayout(gspecPath, device.getTags());
    }

    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
    public void SA_homePage_Chrome_onDevices(TestDevice device) throws IOException    {
        setupGalenTestData( saUrl, SA_HOME_GSPEC_FILENAME);
        setDriverType(MyBrowserType.CHROME);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        checkLayout(gspecPath, device.getTags());
    }


    public static void waitForTabsShown(WebDriver driver, String waitForMeCss){
        WaitTool.findElementDontFailTest(driver, By.cssSelector(waitForMeCss));
    }


}






        /*
    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
    public void UK_PriceAndPackagePage_IE_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( ukPPUrl, IT_PRICEPAGE_GSPEC);
        setDriverType(MyBrowserType.EXPLORER11);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags());
    }*/
    /* need more ie browser for this as it cant init browsers
    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
    public void IT_HomePage_IE_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( itUrl, TEST_GSPEC_FILENAME);
        setDriverType(MyBrowserType.EXPLORER11);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags());
    }*/



    /*@Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
    public void IT_HomePage_Firefox_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( itUrl, TEST_GSPEC_FILENAME);
        setDriverType(MyBrowserType.FIREFOX);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags());
    }*/

    /*@Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
    public void UK_PriceAndPackagePage_Firefox_onDevices(TestDevice device) throws IOException {
        setupGalenTestData( ukPPUrl, IT_PRICEPAGE_GSPEC);
        setDriverType(MyBrowserType.FIREFOX);
        //setCurrentRunningMethod(device);
        printSetup();
        load("");
        waitAndCloseCookieLayer();
        checkLayout(gspecPath, device.getTags());
    }*/



//    /**
//     * IT price and package page
//     */
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
//    public void IT_PriceAndPackagePage_Chrome_onDevices(TestDevice device) throws IOException {
//        setupGalenTestData( itPPUrl, IT_PRICEPAGE_GSPEC);
//        setDriverType(MyBrowserType.CHROME);
//        //setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        checkLayout(gspecPath, device.getTags());
//    }
//
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
//    public void IT_PriceAndPackagePage_Firefox_onDevices(TestDevice device) throws IOException {
//        setupGalenTestData( itPPUrl, IT_PRICEPAGE_GSPEC);
//        setDriverType(MyBrowserType.FIREFOX);
//        //setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        checkLayout(gspecPath, device.getTags());
//    }
//
//    @Test(dataProvider = "devices", dataProviderClass = DevicesDataProvider.class)
//    public void IT_PriceAndPackagePage_IE_onDevices(TestDevice device) throws IOException {
//        setupGalenTestData( itPPUrl, IT_PRICEPAGE_GSPEC);
//        setDriverType(MyBrowserType.EXPLORER11);
//        //setCurrentRunningMethod(device);
//        printSetup();
//        load("");
//        checkLayout(gspecPath, device.getTags());
//    }


/***

 WebElement we =  WaitTool.findElementDontFailTest(driver, By.cssSelector(".illustrator"));
 WebElementHelper.click(we);// to scroll
 sleep(2000);

 galen -Dwebdriver.chrome.driver=C:\selenium\grid\exe\chromedriver dump "C:\work\project\nikol\qa\src\test\java\com\englishlive\tests\galen\specs\imagecompareHomePageDe.spec"
 --url "https://englishlive.ef.com/de-de/"
 --size "1466x1068"
 --export "deHomepageIllustrator"
 --max-width "1500"
 --max-height "800"
 **/