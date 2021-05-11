package com.englishtown.tests.checkout.common.core;
/**
 * All new checkout should extend this
 *       1. Enter user details
 *       2. Submit form
 *       3. Click payment tab type if needed
 *
 * Created on 27/02/2015.
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;


/**
 * Note: Should this extend PageTest instead of StandardCheckoutFlowTest .... need to think !
 */
public abstract class NewBaseCheckoutFlow extends StandardCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(NewBaseCheckoutFlow.class);

    //protected String payDdWeId = "form_tabctrl_tab-0_button";
    protected String payDdWeId = "dcInfo.AccountName";
    //moved to basetest public static String memberSpinnerCss = ".container-fluid .spinner";
//    public boolean isJCBpayment = false; // use this for JP JCB payment
    static int waitTime = WaitTool.MED_WAIT_4_ELEMENT;
    protected boolean isCCpay = false; // use this to use same test but different pay method ... used in returning flow
    protected boolean isDDpay = false;
    protected Map ddPayInfoMap= EfConstants.deDdPayFormMap;
    protected static boolean isOpenHomePageBeforeLoginPage = false;
    protected boolean isNewDesignLogin = false; // there is a new login page
    protected boolean isNewHouseEnroll = false;  // set this to true for new house enroll test .. TR

    @Test(priority = 0)
    public void  enterMemberDetails(){
        logger.info("start enterMemberDetails ....!");
        printUserDateDebug("Before Creating Member");
        if(BaseRemoteWebDriver.isMobileDevice){
            waitTime =  waitTime+10;
        }
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),waitTime);
        init_MembersPageAndEnterDetails(formDataMap);
    }
//   TODO to run in paralled need some work ... remove statics from AssertHelper and WaitTool
//    @Test(dependsOnMethods = { "enterMemberDetails" })
//    public void checkOnlyOneInputNameIsLastName() {
//          AssertHelper.assertElementSizeLessThanOrEqual(getWebDriver(), By.cssSelector(inputLastNameCss), listSize, 3);
//    }

    @Test(dependsOnMethods = { "enterMemberDetails" })
    public void isCheckoutFlowTypeDefaultAtMemberPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }

//    @Test(dependsOnMethods = { "checkOnlyOneInputNameIsLastName" })
//    public void isTrackingEfEducationFirst_windowDotS(){
//        myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER,
//                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
//    }

    @Test(dependsOnMethods = { "isCheckoutFlowTypeDefaultAtMemberPage" })
    public void submitMemberForm() {
        logger.info("start submitMemberForm");
        sleep(1000);
        logger.info("slept 1s");
        submit_MembersForm(getWebDriver());
        sleep(3000);
    }

    @Test(dependsOnMethods = {"submitMemberForm"})
    public void clickTab(){
        sleep(1000);

        if(isNewhousePayment)
            setEfIdFromStateObj();

        if(isRadioButonAtPaymentPage)   // FR pay page
            clickRadioButtonOnPaymentPage(tabId);
        else
            clickOnPaymentPageTab(tabId);
    }
    /*******************************************************************************************************************
     *  New checkout Helper methods
     ******************************************************************************************************************/
    public void check_EnrolmentPage() {
        // new flow
        assertIsUrlContaining("enrollment");
        //identify flow new or old
        /*if(null != WaitTool.findElementDontFailTest(getWebDriver(), By.cssSelector(".btn.btn-primary") )){
            logger.info(" IS New Flow ...!");
            waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary")), getWebDriver(), 30);
        }else {
            logger.info(" IS Old Flow ...!");
            //old flow
            enrolmentPage = PageFactory.initElements(getWebDriver(), EnrolmentPage.class);
            enrolmentPage.setWebDriver(getWebDriver());
            ExpectedCondition pageLoadCondition = enrolmentPage.getPageLoadedCondition();
            enrolmentPage.waitForPageToLoad(pageLoadCondition);
            myAssertThat(getWebDriver(), "Failed, URL does not contains enrollment : url is : " + enrolmentPage.getUrl(),
                    waitForUrlContains(this.getWebDriver(), "enrollment", WaitTool.DEFAULT_WAIT_4_ELEMENT), true);
        }*/
    }

    public void click_StartLearning(){
        logger.info("click start learning ...!");
        sleep(3000);
        thankyouPage = new PaymentThankyouPage(getWebDriver()) ;
        if(isNewhouseTyPage)
            click(thankyouPage.startLearningNewCheckOut);
        else
            click(thankyouPage.startLearning);
        sleep(3000);
    }
    /**     * Wrapper  (PaymentThankyouPage thankyouPage, WebDriver driver, String urlContainsStr, int waitTimeSec )    */
//    public void checkPaymentThankyouPage() {
//        checkPaymentThankyouPage(thankyouPage, getWebDriver(), urlContainsThankyou, WaitTool.MED_WAIT_4_ELEMENT);
//    }
    /**
     * check URL contains thankyou text TEst will wait for URL to load
     */
/*    public static void checkThankyouPage(WebDriver driver, int waitTimeSec ) {
        thankyouPage = new PaymentThankyouPage(driver) ;
        thankyouPage.waitForPageToLoad(thankyouPage.getPageLoadedCondition());
        --assertThat("Failed, URL does not contains thankyou : url is : "+thankyouPage.getUrl(),
                PaymentThankyouPage.waitForUrlContains(driver,"thankyou", waitTimeSec),  Matchers.is(true));
        --assertThat("simpleTest Fails ...!", thankyouPage.simpleTest(), Matchers.is(true));
     }*/

    public void init_MembersPageAndEnterDetails(Map formData){
        initMemberPage();
        enterFormData(formData);
        if(isUseCustommEmail){
            setUserTospecificEmail(userEmail);
        }else
            enterEmail(getWebDriver(), true);
    }

    /**
     * Create user with defined email
     * @param email
     */
    public void setUserTospecificEmail(String email){
        WebElement we =  findElement(By.name("email"));
        WebElementHelper.sendKeys(getWebDriver(), we, email, false);
        we.sendKeys(Keys.TAB);we.sendKeys(Keys.TAB);
        logger.info("Email : " + email);
        setUserEmail(email);
    }

    /**
     * Open url and then call this method
     */
    public void initMemberPage(){
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=firstname]"), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        memberPage = new DynamicMemberPage(getWebDriver());
        myAssertThat(getWebDriver(), " SimpleTest failed on DynamicMemberPage: form_button is not displayed",
                memberPage.simpleTest(), true);
    }

    public void submit_MembersForm(WebDriver driver) {
        String deviceName = BaseRemoteWebDriver.currentDeviceName;
        DynamicMemberPage memberPage = new DynamicMemberPage(driver, WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("-Submit member form ....!");
        // logger.info("-Thread id = " + Thread.currentThread().getId());

        try {
            memberPage.submit();
        }catch (Exception e){
            e.printStackTrace();
            BasePage.failTest(e, "FAIL submit_MembersForm ...!"+e.getCause().toString(), true );
        }

    }


    /**
     * Now most of returning flow just open login ...
     * For xx-wws need to add ?crt=xx at the end of url
     *
     */
    public void openLoginPage() {
        String[] tempUrl;
        String loginUrl = "not_init";

        try{
            tempUrl = getMemberPageUrl().split("/"); //getWebDriver().getCurrentUrl().split("/");
            loginUrl = tempUrl[0] + "//" + tempUrl[2]+"/"+tempUrl[3]+"/";
            loginUrl = loginUrl+getLoginRelativeUrl(getMarket());
            loginUrl = loginUrl+"/?ctr="+getMarket();
//            if(TestUtil.getCurrentUrl(getWebDriver()).contains("-wws")){
//                logger.info("need to add ?ctr=xx to the end of url");
//                loginUrl = loginUrl+"/?ctr="+getMarket();
//            }
        }catch (Exception e){
            logger.error(e.toString());
            failTest("Could Not create Login Url from current url...!"+e.getCause());
        }
        // Sweden test fails as page.market is not set to se when open url with ctr=se and payment fails general error
        if(isOpenHomePageBeforeLoginPage){
            // if(loginUrl.contains("ctr=be") || loginUrl.contains("se")|| loginUrl.contains("ch") ) {
            logger.info("Open Homepage then login page for Sweden/Switzerland!");
            String homePageUrl = loginUrl.replace("login/", "");
            logger.info("Homepage url is : " + homePageUrl);
            openUrl(getWebDriver(), homePageUrl);
            // }
        }/* should not be this way add param
        String returnByWithOfferId = "";
        if(!StringUtils.isBlank(offer_id)){
            returnByWithOfferId = "?offerid="+offer_id;
        }*/
        logger.info("Open this url to login :"+loginUrl); //+returnByWithOfferId);//loginUrl = loginUrl+"?ctr="+getMarket();
        openUrl(getWebDriver(), loginUrl); //+returnByWithOfferId);
    }

    /***
     * Enroll student old house or new house 2018
     *
     */
    public void enrolStudentCheckAtSchool(boolean isNewHouseEnroll, int motivationId, int levelId) {
        if(isNewHouseEnroll){
            logger.info("is new house enrol ...!");
            waitForElementCondition(ExpectedConditions.elementToBeClickable(By.tagName("button")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
            click(By.tagName("button"));
            enrolStudentCheckAtSchoolNewHouse(motivationId, levelId);
        }else {
            logger.info("is old house enrol ...!");
            enrolStudentCheckAtSchoolOldHouse(motivationId, levelId);
        }

    }

    public void enrolStudentCheckAtSchoolOldHouse(int motivationId, int levelId) {
        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        enrolmentPage.startEnrolment();
        // Step 1
        enrolmentPage.simpleTest();
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        enrolmentPage.selectImproveEnglishFor(motivationId);
        // Step 2
        sleep(2000);
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        enrolmentPage.selectEnglishLevel(levelId);
        // Step 3
        sleep(5000);
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
        enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        enrolmentPage.getPageLoadedCondition();
        //enrolmentPage.simpleTest();
        enrolmentPage.clickStartLearning();
        sleep(5000);
        //clickSavebtnInTimeZonePopUp();
        //enrolmentPage.checkStudentIsAtSchoolCampus();
    }

    public void enrolStudentCheckAtSchoolNewHouse(int motivationId, int levelId) {
        MotivationPage motivationPage = new MotivationPage(getWebDriver());
        //enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        motivationPage.clickToSelectMotivation(motivationId);
        // Step 2
        sleep(2000);
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        //enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        // enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        englishLevelPage.selectEnglishLevel(levelId);
        englishLevelPage.clickStartLearning();
        sleep(5000);
        waitForUrlContains(getWebDriver(), "campus", 55);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"campus","Not the expected URL ...!");
        //clickSavebtnInTimeZonePopUp();
    }



}




// mobile click
//logger.info("-Hashcode of webDriver instance = " + driver.hashCode());
 ///////if(deviceName != null){     //if( "r32d1034yky".contains(deviceName) ) {  // NexusOne
// logger.info("Is mobile Device  ....");
// JavaScriptHelper.highlightElement(memberPage.getSubmitBtn(), driver);
// MyWebDriverAction.moveToElementAndClick(driver, memberPage.getSubmitBtn());           // does not work for ipad mini
 // }else {   //( deviceName.toLowerCase().contains("ipad") || deviceName.toLowerCase().contains("nexus") ||    deviceName.toLowerCase().contains("iphone") || deviceName.toLowerCase().contains("amsung")  ) {
 // memberPage.submit();       //submit.click();             //} else {   logger.info("deviceName does not contains ipad or nexus one. No click done ....");                }
// }else { */
        ///*if(isBrowser(MyBrowserType.EDGE)){ memberPage.getSubmitBtn().click();   //JavaScriptHelper.clickAtWindowXY(getWebDriver(), submit.getLocation().getX(),submit.getLocation().getX() );  /* IE11 click is not working*/                 /*}else*/
///////        memberPage.submit();                                                                                //submit.click();

