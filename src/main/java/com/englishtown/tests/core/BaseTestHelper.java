package com.englishtown.tests.core;
/**
 * All helper test methods should be in here
 *
 *
 *
 */

import com.englishtown.commerceclient.ActionResult;
import com.englishtown.commerceclient.Environment;
import com.englishtown.commerceclient.Wrapper;
import com.englishtown.commerceclient.generated.SubscriptionInfo;
import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.enumpack.RectangleSide;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.outsideschool.mix.SchoolTermsAndConditionPage;
import com.englishtown.newhouse.school.beanandenum.*;
import com.englishtown.newhouse.school.beanandenum.bean.StudentProfileSettingBean;
import com.englishtown.newhouse.school.pages.ReferAFriendPage;
import com.englishtown.newhouse.school.pages.account.*;
import com.englishtown.newhouse.school.pages.appstools.assessmenttest.AssessmentTestGrammarPage;
import com.englishtown.newhouse.school.pages.appstools.assessmenttest.StartAssessmentTestPage;
import com.englishtown.newhouse.school.pages.classroom.BookEFTVPage;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.ConversationClassPage;
import com.englishtown.newhouse.school.pages.classroom.CurrentBookingsPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.AppsAndToolsPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.TranslatorPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.GrammarlabPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseMainPage;
import com.englishtown.newhouse.school.pages.course.changecourse.ChangeCourseModulePage;
import com.englishtown.newhouse.school.pages.course.changecourse.ToeflToeicPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.ChangeYourGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.goal.SetNewGoalPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.UnitOverviewPage;
import com.englishtown.newhouse.school.pages.course.progressandtests.LevelCertificatePage;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.newhouse.school.pages.support.EmailUsPage;
import com.englishtown.newhouse.school.pages.support.HelpCenterPage;
import com.englishtown.newhouse.school.pages.support.newhouse.SupportPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPaymentPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellThankyouPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.schoollite.EfIdLoginPage;
import com.englishtown.tests.core.common.CommonTestHelper;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;


//TODO Move all BaseTest methods in here and only few main one should stay on baseTest as is getting to big

public abstract class BaseTestHelper extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestHelper.class);
    protected WebDriver htmlUnitDriver;
    public boolean isEnterFormDataUsingCssMap = false;
    public boolean is_iOStest = false;
    public boolean is_adyenPayment = false;
    public boolean is_adyen3DSecure = false;
    public boolean is_AndroidTest = false;
    protected SchoolStudentBean schoolStudentUpdatedBean2;

    public boolean isUseGmail = false; // to use a shorter email and Gmail account
    public boolean isUseCustommEmail = false; // to create user with desired email
    protected boolean isPopupShown       = false;
    public boolean isUseCssEnterFormData = false;
    public String phoneNubmer = "07856878"; // defalut


    protected String freeTrialRcode = "?rcode=martin-norman-mx";

    public String scriptGetCCName = "return $('input[name=\"CreditCardName\"]').val()";
    public String FULL_NAME = "testing tester";


    /**
     * Page Objects
     */
    protected SchoolStudentBean schoolStudentBean;
    protected StudentProfileSettingBean studentProfileSettingBean;
    protected StudentProfileSettingBean updatedStudentProfileSettingBean;
    protected LevelTestScoresBean levelTestScoresBean;
    protected SchoolStudentBean schoolStudentUpdatedBean; // when update the details use this one
    protected LoginPage loginPage;
    protected EfIdLoginPage efIdLoginPage;
    protected SchoolHomePage schoolHomePage;
    protected SchoolHeaderAndFooterPage schoolHeaderAndFooterPage;
    protected SchoolHeaderPage schoolHeaderPage;
    protected CurrentCourseUnitPage currentCourseUnitPage;

    protected AppsAndToolsPage appsAndToolsPage;
    protected TranslatorPage translatorPage;
    protected GrammarlabPage grammarlabPage;
    protected StartAssessmentTestPage startPlacementTestPage;
    protected AssessmentTestGrammarPage placementTestGrammarPage;

    protected ChangeCourseMainPage changeCourseMainPage;
    protected ChangeCourseModulePage changeCourseModulePage;
    protected ChangeYourGoalPage changeYourGoalPage;
    protected ProgressPage progressPage;
    protected SetNewGoalPage setNewGoalPage;
    protected UnitOverviewPage unitOverviewPage;
    protected ToeflToeicPage toeflToeicPage;
    protected LevelCertificatePage levelCertificatePage;

    protected BookPrivateLessonPage bookPrivateLessonPage;
    protected CurrentBookingsPage currentBookingsPage;
    protected ConversationClassPage conversationClassPage;
    protected BookEFTVPage bookEFTVPage;

    protected MyAccountPage myAccountPage;
    protected PersonalDetailsPage personalDetailsPage;
    protected BillingPage billingPage;
    protected EmailAndNotificationPage emailAndNotificationPage;
    protected ReferAFriendPage referAFriendPage;
    protected UpdatePaymentPage updatePaymentPage;
    protected PrivacySettingPage privacySettingPage;
    // lite
    protected ProfilePage profilePage;

    protected SupportPage supportPage;
    protected EmailUsPage emailUsPage;
    protected HelpCenterPage helpCenterPage;

    protected SchoolUpsellPage schoolUpsellPage;
    protected SchoolUpsellPaymentPage schoolUpsellPaymentPage;
    protected SchoolUpsellThankyouPage schoolUpsellThankyouPage;

    protected SchoolTermsAndConditionPage schoolTermsAndConditionPage;

    //enums
    protected CourseCodeNumber courseCodeNumber;
    protected StepStatus stepStatus;
    protected GeneralEnglishCourseLevels generalEnglishCourseLevels;
    protected BusinessCourseLevels businessCourseLevels;
    protected StudyGoals studyGoals;
    protected ToeflToeicLevels toeflToeicLevels;
    protected EnabledCourses enabledCourses;





    /**
     * Check web element is shown/visible on the page and fail the test if Not
     */
    public void validateWebElementShown(By by, String failMsg, int waitTime ) {
        WebElement we = findElement(by, waitTime);
        if(we == null) {
            BasePage.failTest(failMsg);
        } else {
            logger.info("WebElement [{}] is shown, as expected ....! ", by);
        }
    }

    /**
     *
     * @param by  return a list of lements
     * @param failMsg
     *
     */
    public void validateListWebElementShown(By by, int weId, String failMsg ) {
        List<WebElement> wes = WaitTool.findElements(getWebDriver(), by);
        try{
            wes.get(weId).isDisplayed();
        }catch (WebDriverException wde){
            failTest("List web element is not shown ... id ["+weId+"]  - "+wde.getMessage());
        }
    }

    /**
     * Check web element is not shown/visible on the page and fail the test if it is
     */
    public void validateWebElementNotShown(By by, String failMsg, int waitTime ) {
        WebElement we = findElement(by, waitTime);
        if(we != null) {
            BasePage.failTest(failMsg+"; WebElement :"+by);
        } else {
            logger.info("WebElement [{}] is NOT shown, as expected ....! ", by);
        }
    }

    /**
     * Open URL with ctr=xx , url opens es-mx site and country TXT filed updated accordingly based on ctr
     */
    public void checkSelectedCountry(String country, String cCode, By byWe) {
        String urlContains = "es-mx";
        BasePage.waitForUrlContains(getWebDriver(),urlContains, 15 );
        waitForElementCondition(ExpectedConditions.elementToBeClickable(byWe), getWebDriver(), 20);

        AssertHelper.assertThat("URL is not the expected one  ...!",
                                 TestUtil.getCurrentUrl(getWebDriver()), containsString(urlContains));
        checkSelectElementValue(country, byWe);
    }

    public void checkSelectElementValue(String weValue, By byWe) {
        waitForElementCondition(ExpectedConditions.elementToBeClickable(byWe), getWebDriver(), 20);
        WebElement we = findElement(byWe) ;

        if(we != null) {
            AssertHelper.assertThat("Country field is not the expected one ...!; Should be country :" + weValue,
                    getSelectedOption(we).trim(), equalTo(weValue));
        } else {
            BasePage.failTest("select Country Web element is NULL ....! ");
        }
    }

    public void assertWebElementText(String weCss, String weExpectedTxt){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected text ...!",
                TestUtil.getWebElementText(getWebDriver(), weCss), containsIgnoringCase(weExpectedTxt), true);
    }

    public void assertWebElementText(WebElement we, String weExpectedTxt){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected text ...!",
                TestUtil.getWebElementText(we), containsIgnoringCase(weExpectedTxt), true);
    }

    public void assertWebElementTextEqualsTo(WebElement we, String weExpectedTxt){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected text ...!",
                TestUtil.getWebElementText(we).trim(), equalTo(weExpectedTxt), true);
    }

    public void enterPhoneNumber(String phoneNumber, boolean isClearKey){
        currWebElement = findElement(By.id("telephone"));
        if(isClearKey) {
            WebElementHelper.clearAndsendKeys(getWebDriver(), currWebElement, phoneNumber, false);
        }else {
            WebElementHelper.sendKeys(getWebDriver(), currWebElement, phoneNumber, false);
        }
    }

    public void checkValidationMessageDisplayed(String validationMsgWeSelector){
        logger.info("checkValidationMessageDisplayed ...!");
        if(getValidationMessageWe(validationMsgWeSelector) != null) {
            myAssertThat(getWebDriver(), "Failed Is Validation message NOT displayed/shown ...!",
                    getValidationMessageWe(validationMsgWeSelector).isDisplayed(), true);
        } else {
            failTestIfNullWebElement(getValidationMessageWe(validationMsgWeSelector));
        }
    }

    public void checkValidationMessageNotDisplayed(String validationMsgWeSelector){
        logger.info("checkValidationMessageNotDisplayed ...!");
        if(getValidationMessageWe(validationMsgWeSelector) != null) {
            BasePage.failTest("Failed; Validation message is Displayed/shown ...! : Locator selector -> ["+
                    WebElementHelper.getElementLocator(currWebElement)+"]");
        } else {
            logger.info("Valid phone so Validation message is not shown ...!");
        }
    }

    public WebElement getValidationMessageWe(String validationMsgWeSelector){
        logger.info("getValidationMessageWe ...!");
        currWebElement = WaitTool.findElementDontFailTest(getWebDriver(), By.cssSelector(validationMsgWeSelector));
        if(currWebElement !=null){
            logger.info(" webElement text : " + currWebElement.getText()); //Por favor, inserta
        }
        return currWebElement;
    }


    public void clickToClosePopup(By waitForMeVisible, int x, int y){
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(waitForMeVisible), getWebDriver(), 5); //"modal-dialog"
        clickAtWindow(getWebDriver(), x, y);
        sleep(50);
    }

    public void enterPhoneNoCheckValidation(String phoneNO, String phoneValidationPopUpCss, boolean isValidationShown, boolean isClearKey){
        enterPhoneNumber(phoneNO, isClearKey);
        currWebElement.sendKeys(Keys.TAB);
        sleep(500);
        if(isValidationShown){
            checkValidationMessageDisplayed(phoneValidationPopUpCss);
        }else {
            checkValidationMessageNotDisplayed(phoneValidationPopUpCss);
        }
    }

    public void sendKey(WebDriver webDriver, WebElement webElement, String keys, boolean autoScroll){
        WebElementHelper.sendKeys(webDriver, webElement, keys, autoScroll);
    }

    /**
     * wrapper
     * @param environment
     * @return
     */
    public static String getRedemptionCode(String environment){
        return getRedemption( environment);
    }

    public String getRedemptionCodePerEnv(){
        String env = getENVIRONMENT();
        return getRedemption(env);
    }

    public static String getRedemption(String env){
        String redemptionCode = "notInit";
        if(StringUtils.isNotBlank(env)){
            switch (env){
                case "live"     : redemptionCode = "TEST1DSS35095CC912FE";
                    break;
                case "qa"       : redemptionCode = "grd";
                    break;
                case "stg"      : redemptionCode = "MARTINCUI";
                    break;
                case "staging"  : redemptionCode = "MARTINCUI";
                    break;
                default         : redemptionCode = "Invalid Environment :['"+env+"']";
                    logger.error("Invalid Environment...!");
                    break;
            }
        } else {
            logger.error("Can't get Environment test is running ...!");
        }
        return redemptionCode;
    }

    /**
     * Check if cookie exist only once
      * @param cookieName
     */
    public void isOnlyOneCookie(String cookieName, int waitTimeSec){
        logger.info("check is OnlyOne Cookie ...! "+cookieName);
        String allCookies = executeJSscript("var cookies=document.cookie; return cookies;", getWebDriver(), waitTimeSec);
        AssertHelper.assertThat("Cookie et_s is not there or Cookie Name appears more than once ....!",splitStringAndFindHowManyMatches(allCookies, cookieName,";","=") , is(1));
    }

    /**
     * Split a string on splitChar, then split on '=' and see how many matches could you find for each first part split
     * @param str
     * @param match
     */
    public static int splitStringAndFindHowManyMatches(String str, String match, String firstSplitChar, String secondSplitChar){
        boolean isDebug=true;
        int matchCount=0;
        String[] firstSplitList  = null;
        String tmpStr = null;
        if(str !=null ) {
            if(str.contains(firstSplitChar)) {
                firstSplitList = str.split(firstSplitChar);  // split on ';'
                try {
                    for(String part : firstSplitList){  //
                        if(isDebug) logger.info(". First split part is : ["+part+"]");
                        // split on = get first part, trim it , check it match 'match string'
                        tmpStr = part.split(secondSplitChar)[0].trim();
                        if(isDebug) logger.info(". Second Split tmpStr : ["+tmpStr+"] .. Check if is equal to ["+match+"]");
                        if(StringUtils.equals(tmpStr, match)){
                            matchCount++;
                            if(isDebug) logger.info("Match found; matchCount is now : "+matchCount);
                        }
                        tmpStr = null;
                        part   = null;
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    logger.error("splitStringAndFindHowManyMatches erros : " + e.getCause());
                }
            }
        }else {
            logger.error(" Cant split null string ...!");
        }
        return matchCount;
    }


    /**
     *  Check URL contains text e.g  "thankyou"
     *  Test will wait for URL to load and then assert it contains test, run simple Page test as well
     */
    //TODO refactor this remove creating
    public void checkPaymentThankyouPage(PaymentThankyouPage paymentThankyouPage, WebDriver driver, String urlContainsStr, int waitTimeSec ) {
        paymentThankyouPage = new PaymentThankyouPage(driver) ;
        paymentThankyouPage.waitForPageToLoad(paymentThankyouPage.getPageLoadedCondition(isNewhouseTyPage));
        myAssertThat(driver, "Failed ...!. URL does not contains 'thankyou'. Current URL is :"+ paymentThankyouPage.getUrl() +
                ". Seconds Waited for :" + waitTimeSec, PaymentThankyouPage.waitForUrlContains(driver, urlContainsStr, waitTimeSec), true);
        //myAssertThat(driver, "ThankyouPage simpleTest Failed ...!", paymentThankyouPage.simpleTest(isNewhouseTyPage), true);
    }

    public void checkPaymentThankyouPage() {
        checkPaymentThankyouPage(thankyouPage, getWebDriver(), urlContainsThankyou, WaitTool.MED_WAIT_4_ELEMENT);

    }


    // test helpers

    /**
     *
     * @param formLeadTypeKey   form.leadtype
     * @param formLeadTypeValue
     * @param isLoadStateObject
     */
    public void isLeadType(String formLeadTypeKey, String formLeadTypeValue, boolean isLoadStateObject){
        assertStateObjectElementValue(formLeadTypeKey,formLeadTypeValue, false);
    }
    public void isLeadType(String formLeadTypeValue, boolean isLoadStateObject){
        assertStateObjectElementValue(formLeadTypeKey,formLeadTypeValue, false);
    }

    /********************************************
     * Broser Actions
     * @param driver
     ********************************************/

    public static void refresh(WebDriver driver){
        logger.info("Refresh browser ....!");
        try {
            driver.navigate().refresh();
        }catch (WebDriverException wde){
            failTest("CAN NOT < REFRESH > THE BROWSER ...! "+wde.getMessage());
        }
    }
    public static void forward(WebDriver driver){
        try {
            driver.navigate().forward();
        }catch (WebDriverException wde){
            failTest("CAN NOT GO < FORWARD > THE BROWSER ...! "+wde.getMessage());
        }
    }

    public static void backward(WebDriver driver){
        try {
            driver.navigate().back();
        }catch (WebDriverException wde){
            failTest("CAN NOT GO < BACK > THE BROWSER ...! "+wde.getMessage());
        }
    }

    /**
     * Get login relative path e.g login/ for most of market or for FR is connection
     *
     * @param market = e.g fr
     * @return
     */
    public static String getLoginRelativeUrl(String market) {
        String loginRelativeUrl = "login";
        switch (market) {
            //case "fr":
               // loginRelativeUrl = "connexion/";
               // break;
            default:
                logger.warn(" All markets Using default [login/] "+market+"] ....!");
                //throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return loginRelativeUrl;
    }

    /**
     * Change Live url to qa url if test are runing on QA
     * e.g https://englishlive.ef.com/de-de to https://qa-englishlive.ef.com/de-de
     *
     * @param liveUrl
     * @param currentEnvironment
     * @return null or Qa Url
     *
     */
    public static String changeLiveUrlToQaUrl(String liveUrl, String currentEnvironment) throws NullPointerException {
        String qaUrl = null;
        try {
            if (liveUrl.length() > 6) {// to handel when url is only set equal to "https"
                qaUrl = liveUrl.replace("://eng", "://qa-eng");
                logger.info("Live url converted to expected QA Url is :" + qaUrl);
            } else {
                qaUrl = liveUrl;
                logger.info("liveUrl length is < 6 so no need to replace ... QA Url is : " + qaUrl);
            }
        } catch (Exception e) {
            failTest("Can not convert this url to QA Url ...! " + e.getCause());
        }
        return qaUrl;
    }


    /**
     * Get webElement from list containing text or fail test
     * @param driver
     * @param elements
     * @param weText
     * @return
     */
    public static WebElement getWebElementFromList(WebDriver driver, List<WebElement> elements, String weText){
        try {
            for (WebElement we : elements) {
                if (StringUtils.equals(weText, TestUtil.getWebElementText(we))) {
                    return we;
                }
            }
        }catch (Exception e) {
            BaseTest.failTest("Can not get Web element [" + elements + "] containing text [" + weText + "] ...! \n"+e.getCause());
        }
        return null;
    }

    public WebElement getWebElementFromListContains(WebDriver driver, List<WebElement> elements, String weText){
        try {
            for (WebElement we : elements) {
                if (StringUtils.contains(weText, TestUtil.getWebElementText(we))) {
                    return we;
                }
            }
        }catch (Exception e) {
            BaseTest.failTest("Can not get Web element [" + elements + "] containing text [" + weText + "] ...! \n"+e.getCause());
        }
        return null;
    }

    /**
     *
     * @param driver
     * @param weBySelector    e.g By.tagName("h1")
     * @param containsStr     e.g "PAGE NOT FOUND"
     */
    public void assertPageNotFound(WebDriver driver, By weBySelector, final String containsStr){
        AssertHelper.myAssertThat(driver, "404: PAGE NOT FOUND Shown .... on page ...",
                getText(findElement(weBySelector)), is(not(CoreMatchers.containsString(containsStr))), true ) ;
    }

    public static int getIntFromString(String convertMeToInt){
        int i = 0;
        try {
            Float n =  Float.parseFloat(convertMeToInt);
            i = Math.round(n);
            logger.info("int i = " + i);
        } catch (Exception nfe)        {
            failTest("NumberFormatException Could not convert to Number ....!"+nfe.getMessage());
        }
        return i;
    }

    /**
     * need to check if value not 999999999 before use this
     *
     * @param driver
     * @param cssSelector
     * @param weId .. if the selector return more than one Element, enter -1 if only one element
     * @return
     */
    public static int getWebElementRectangleCoordinate(WebDriver driver, RectangleSide rectSide,  String cssSelector, int weId){
        return getRectCoordinateOfWe(driver, cssSelector, rectSide, weId);
    }
    /**
     * document.querySelectorAll('a')[1].getBoundingClientRect()     ClientRect {top: 0, right: 0, bottom: 0, left: 0, width: 0…}
     * @param driver
     * @param cssSelector
     * @param rectSide enum -> top: 0, right: 0, bottom: 0, left: 0, width: 0
     * @param weId
     * @return
     */
    public static int getRectCoordinateOfWe(WebDriver driver, String cssSelector, RectangleSide rectSide, int weId){
        String weTopAfterClick = "notInit" ;
        int top = 999999999;
        int id = 0;
        if(weId > -1){
            id = weId;
        }
        try {
            weTopAfterClick = executeJSscript("return document.querySelectorAll('" + cssSelector + "')["+weId+"].getBoundingClientRect()."+rectSide.getRectSide(), driver, 5);
        }catch (WebDriverException wde){
            failTest("Could not get top coordinate ...!"+wde.getMessage());
        }
        top = BaseTestHelper.getIntFromString(weTopAfterClick);
        logger.info("top coordinate : "+top) ;

        return top;
    }


    public void cancelUserSubscription(String email){
        logger.info("Cancel Subscription for user {{}}", email);
        try{
            Wrapper client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
            ActionResult result = client.cancelSubscriptionByEmail(email);
            AssertHelper.assertThat("Failed to cancel subscription ...", result.getSucceed(), is(true) );
            logger.info("    <<<<<<<<       Subscription Cancelled OK ...! {{}}  >>>>>>>>>", email );
        } catch (AssertionError ae) {
            ae.printStackTrace();
            logger.error("Could not Cancel subscription ....!"+ae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            // Should not fail the test if user not cancelled but how should I know if this is working ... so have to
             logger.error("Could not Cancel subscription ....!"+e.getMessage());
            //BasePage.failTest(e, "Cancel Subscription failed ...!");
        }
    }
    public void cancelUserSubscription(int memberId){
        try{
            Wrapper client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
            ActionResult result = client.cancelSubscriptionForMember(memberId); //Integer.parseInt
            myAssertThat(getWebDriver(), "Failed to cancel subscription ...", result.getSucceed(), true);
        } catch (Exception e) {
            BasePage.failTest(e, "Cancel Subscrition failed ...!");
        }
    }
    /**
     * Get All subscription info
     */
    public ActionResult getAllSubscription( int memberId){
        logger.info("Action result ...{{}}", memberId);
        ActionResult resultAllSubscripitons = null;

        try{
            Wrapper client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
            resultAllSubscripitons = client.getAllSubscriptions(memberId);                                               //ActionResult resultMember = client.getMemberByEmail(email);            //
            AssertHelper.assertThat("Failed to get subscription ...", resultAllSubscripitons.getSucceed(), is(true) );
            logger.info("     Subscriptions"+ resultAllSubscripitons.toString() );                                       //logger.info("     Subscriptions"+ resultMember.toString() );
        } catch (AssertionError ae) { //((SubscriptionInfo) ((ArrayList) resultAllSubscripitons.getResult()).get(0)).isActive
            ae.printStackTrace();
            logger.error("Could not get subscription/member ....!"+ae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Could not get subscription/member ....!"+e.getMessage());
        }
        return resultAllSubscripitons;
    }

    /**
     * Get member info
     */
    public SubscriptionInfo getSubscriptioInfo(int memberId) {
        logger.info("getSubscriptioInfo ...{{}}", memberId);

        SubscriptionInfo subscriptionInfo = null;

        try{
            subscriptionInfo = ((SubscriptionInfo) ((ArrayList) getAllSubscription(memberId).getResult()).get(0));
        }catch (Exception e){
            logger.error("Can't get subscription info ...!"+e.getMessage());
        }

        return subscriptionInfo;
    }





    /**
     * Enter unique email and send tabk key twice to remove funy popups for validation
     * @param driver
     */
    public void enterEmail(WebDriver driver, boolean isSendKeyTab){
        UniqueDataObject udo = new UniqueDataObject();
        WebElement we =  findElement(By.name("email"));

        // use Gmail
        if(isUseGmail)
            setUserEmail(udo.getGmail(getMarket(), 3, 3));
        else
            setUserEmail(udo.getEmail(getMarket()));


        WebElementHelper.sendKeys(driver, we, getUserEmail(), false);

        if(isSendKeyTab) {
            we.sendKeys(Keys.TAB);
            we.sendKeys(Keys.TAB);
        }
        logger.info("(email) : " + getUserEmail());

    }

    public void enterEmail(WebDriver driver, String email, boolean isSendKeyTab){
        WebElement we =  findElement(By.name("email"));
        WebElementHelper.sendKeys(driver, we, email, false);
        if(isSendKeyTab) {
            we.sendKeys(Keys.TAB);
            we.sendKeys(Keys.TAB);
        }
        logger.info("email : " + email);
        setUserEmail(email);
    }


    public boolean isMobileDevice(){
        return BaseRemoteWebDriver.isMobileDevice;
    }

    public static void isFirstLastNamePersisted(WebDriver webDriver, String scriptGetCCName, String equalTo){
        String fullName =  JavaScriptHelper.executeJavaScript(scriptGetCCName, webDriver, WaitTool.DEFAULT_WAIT_4_ELEMENT);
        logger.info("validate_is_FirstLastNamePersisted() ...fullName is :" + fullName);
        if(fullName!=null) {
            AssertHelper.myAssertThat(webDriver, "FAILED...!, Name not persisted ", fullName, CoreMatchers.equalTo(equalTo), true); // assertThat("FAILED...!, Name not persisted ", fullName, equalTo(equalTo));
        } else {
            BasePage.failTest(" fullName is null ...!", true);
        }

    }

    public void openUrl_AssertResponse(String url, int expectedResponseCode) {
        logger.info("openUrl_AssertResponse :"+url);

        if(StringUtils.isBlank(url))
            failTest("URL is empty or null ...!");

        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();
        webClientResponseHelper.setJavaScriptEnabled(false);
        webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);
        int responseCode = webClientResponseHelper.getWebClientResponseCode(url);
        webClientResponseHelper = null;
        logger.info("testResponseCode is [" + expectedResponseCode + "]");
        AssertHelper.assertThat("Response Code is not [" + expectedResponseCode + " ] ...!", responseCode,
                    Is.is(expectedResponseCode));
    }

    public String getCurrencySymbol(Locale locale){
        return Currency.getInstance(locale).getSymbol(locale);
    }

    public void printTestName(Logger logger){
        logger.info("\n**************************************************************************************");
        logger.info(" Start test  *******************");
        logger.info("\n****************************************************************************************");
    }

    /**
     * On payment page some markets have 2 tabs and some have no tabs
     *
     */
    public void clickOnPaymentPageTab(int tabId){
        logger.info("Click on Tab if needed ......! id [{}]", tabId);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
        if (isClickTabId) {
            findElement(By.cssSelector(paymentTabsListCss));
            List<WebElement> tabsWe = WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(paymentTabsListCss), 25);

            click(tabsWe.get(tabId));
            sleep(1000);
            logger.info(" Tab clicked ...!");
        }else
            logger.info(" Did NOT click on Tab id : ", tabId);
    }

    public void clickRadioButtonOnPaymentPage(int radioId){
        logger.info("Click on Radio Btn if needed ......! id [{}]", radioId);
        String radioBtnListCss = ".inner .indicator";
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
        if (isClickTabId) {
            findElement(By.cssSelector(radioBtnListCss));
            List<WebElement> radioListWe = WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(radioBtnListCss), 25);

            click(radioListWe.get(radioId));
            sleep(1000);
            logger.info(" Tab clicked ...!");
        }else
            logger.info(" Did NOT click on Tab id : ", radioId);

    }

    protected void clickSavebtnInTimeZonePopUp(){
        logger.info("clickSavebtnInTimeZonePopUp  ...!");
        String continueBtnCss = ".timezone-management-form-submit span:first-child";
        try {
//            waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(continueBtnCss)), //"timezone-management-form-submit")),
//                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//            sleep(8000);
            waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(continueBtnCss)), //"timezone-management-form-submit")),
                    getWebDriver(), 5000);
            click(findElement(By.cssSelector(continueBtnCss))); //"timezone-management-form-submit")));
            logger.info("Clicked to save TimeZone ....!");
        }
        catch (AssertionError e){
            logger.warn("AssertionError timezone ...."+e.getMessage());
        }
        catch (Exception e){
            logger.warn("No timezone shown ...."+e.getMessage());
        }

        sleep(3000);
    }


    /**
     * Open url and check the browser current url
     * it waits for the expected url
     * 
     * @param driver
     * @param baseUrl
     * @param urlRedirectBean
     * @param waitTime
     *
     */
    public void openUrlCheckIsRedirected(WebDriver driver, String baseUrl, UrlRedirectBean urlRedirectBean, int waitTime){
        logger.info("openUrlCheckIsRedirected  Test URL " + urlRedirectBean.getUrl() + "should redirects to ->" + urlRedirectBean.getExpectedUrl());
        openUrl(driver, baseUrl+urlRedirectBean.getUrl());

        boolean urlContains =  CommonTestHelper.waitForUrlContainsText(driver, urlRedirectBean.getExpectedUrl(), waitTime);

        myAssertThat(driver, "Current URL :" + TestUtil.getCurrentUrl(driver) + " URL does not contain :" +
                urlRedirectBean.getExpectedUrl() +
                " ; test Open URL : "+baseUrl+urlRedirectBean.getUrl()+ " - waited for : " + waitTime, urlContains, false);                              //myAssertThat(driver, "["+urlRedirectBean.getUrl()+"] URL does not contain expectedUrl ...!",           TestUtil.getCurrentUrl(driver), containsIgnoringCase(urlRedirectBean.getExpectedUrl()),  false);
    }

    /**
     * Help debug
     */
    public void printUserDateDebug(String stepName){
        if(isLogDebug) {
            logger.info("\n printUserDateDebug [{}]", stepName);
            try {
                setEfIdFromStateObj();
            } catch (Exception e) {
                logger.warn("Could not get user data efid....! " + e.getMessage());
            }
            try {
                CookieHandler.getUUID(getWebDriver());
            } catch (Exception e) {
                logger.warn("Could not get user data getUUID ....! " + e.getMessage());
            }
            try {
                getStateObjectValue(EFID_KEY, true);
            } catch (Exception e) {
                logger.warn("Could not get user data EFID_KEY ....! " + e.getMessage());
            }
            logger.info("\n <<<<<<<<<  END printUserDateDebug >>>>>>>>> [{}]\n", stepName);
        }
    }

}
