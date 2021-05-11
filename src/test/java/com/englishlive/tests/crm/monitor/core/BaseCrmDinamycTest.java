package com.englishlive.tests.crm.monitor.core;
/**
 * Created by nikol.marku on 10-Jul-17.
 * https://jira.eflabs.io/browse/SAND-4167
 *
 */
//import com.englishlive.tests.crm.checkout.CrmMagicFormNewUserFlowTest;
import com.englishlive.tests.crm.core.BaseCrmMagicForm;
import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public abstract class BaseCrmDinamycTest extends BaseCrmMagicForm{
    private static final Logger logger = LoggerFactory.getLogger(BaseCrmDinamycTest.class);

    protected CrmMonitOSOEUrlBean crmMonitOSOEUrlBean;


    /*********************************
     * Helpers
     ********************************/
    /**
     * Enter new user details and submit
     * @param formMap
     */
    public void enterNewUserFormDataAndSubmit(Map<String, String> formMap) {
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(waitForFormElementCss), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        enterFormData(formMap);
        enterEmail(getWebDriver(), true);
        findElement(By.cssSelector(submitWeCss)).submit();
    }

    /**
     * Check payment page content and url
     */
    public void checkPaymentPage(int waitTimeSec){
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(waitForPayPageCss), getWebDriver(), waitTimeSec);
        String currentUrl = getWebDriver().getCurrentUrl();
        if(StringUtils.isBlank(currentUrl))
            failTest("[checkPaymentPage]-> Can not get URL from browser ....!");
        AssertHelper.assertUrlContains(currentUrl, payPageUrlContains, " Url does not contains expected string ....!");
    }

    //------------------------------------------------------------------------------------
    // Login
    /**
     * Login user and check welcome back page url and buy button
     * @param username
     * @param loginBtnCss
     * @param welcomeBackUrlContains
     * @param welcomeBackSubmitBtnCss
     *
     * if url .. page name contains -cxs- usersers are send to   * buy/default/payment url and it shows an error
     *     and thats OK reina adviced as those pages are only for alumny .... and test user has not paid yet .. so not a real user case
     *     we can leave with it
     */
    public void loginExistingUserCheckWelcomeBackPage(String username, String loginBtnCss, String welcomeBackUrlContains,
                                                      String welcomeBackSubmitBtnCss ){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(loginBtnCss)), getWebDriver(), 20);
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterCredentials(username, PASS);
        sleep(500);
        WebElement webElement = findElement(By.cssSelector(loginBtnCss));
        click(getWebDriver(), By.cssSelector(loginBtnCss));
        waitForUrlContains(getWebDriver(),welcomeBackUrlContains ,15);
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),
                welcomeBackUrlContains, " Url does not contains expected string ....!");
    }

    //----------------------------------------------------------------------------------------
    // Forgotten pass
    /**
     * when: "I open CMR magic form login page as existing user"  and "Click forgotten pass link"
     * then: "I am at forgotten pas page"
     * when: "I enter email or username"
     *     and: "Submit form "
     * then: "Login form is shown and TY Message Shown"
     */
    public void checkForgottenPassCrmFlow(String username, String forgotPassTyMessage){
        WebElement we = WaitTool.findElement(getWebDriver(), By.cssSelector(forgottenPassWeCss));       // if(StringUtils.contains(getWebDriver().getCurrentUrl(),"de-wws")) {          //  click(getWebDriver(),By.cssSelector(forgottenPassWeCss) );       // } else
        scrollToWeAndClick(getWebDriver(),WaitTool.findElement(getWebDriver(), By.cssSelector(forgottenPassWeCss)), 2, 300);

        sleep(2000);

        WaitTool.waitForElementClickable(getWebDriver(), By.name("EmailOrUserName"), WaitTool.DEFAULT_IMPLICIT_WAIT);
        ForgottenPassPage forgottenPassPage = new ForgottenPassPage(getWebDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT);
        forgottenPassPage.enterEmailOrUserName(username);        //executeJSscript("window.scrollTo(0, 0);", getWebDriver(), 3);        //WebElement givePassWe =  findElement(By.cssSelector(giveMyPassBackBtnCss));       // if(StringUtils.contains(getWebDriver().getCurrentUrl(),"de-wws")) {         //   JavaScriptHelper.scrollWebElementToView(getWebDriver(), givePassWe, ElementScreenPosition.MIDDLE, 50);            //click(findElement(By.cssSelector(giveMyPassBackBtnCss)));        //} else         //   click(givePassWe);        //scrollToWeAndClick(getWebDriver(),WaitTool.findElement(getWebDriver(), By.cssSelector(giveMyPassBackBtnCss)), 2, 300);            //click(findElement(By.cssSelector(giveMyPassBackBtnCss))); //WebElement emailOrUserNameTxtWe = findElement(By.name("EmailOrUserName"));                                                               //executeBlurOnWebelement(getWebDriver(), givePassWe);            emailOrUserNameTxtWe.sendKeys(Keys.ENTER);

        WebElement weC = findElement(By.cssSelector(giveMyPassBackBtnCss));
        logger.info("Y: "+(((RemoteWebElement) weC).getCoordinates().onPage().getY()) + " " + executeJSscript("return $('.formset--forgot-password .btn')[0].getBoundingClientRect().top + document.body.scrollTop", getWebDriver(), 1));
        //355.984375
        click(weC);
        //MyWebDriverAction.moveToElementAndClick(getWebDriver(), weC);

        logger.info("Clicked giveMyPassBackBtnCss : "+giveMyPassBackBtnCss);
        loginPage = new LoginPage(getWebDriver());

        WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(forgotPassThankYouTxtWe), WaitTool.DEFAULT_IMPLICIT_WAIT);
        findElement( By.cssSelector(forgotPassThankYouTxtWe), 20);
        loginPage.isUsernameDisplayed();
        WebElement tyPassListWe = findElement( By.cssSelector(forgotPassThankYouTxtWe), 20);
        AssertHelper.assertWebElementDisplayed(tyPassListWe);
        String currentTyMsg = TestUtil.getWebElementText(tyPassListWe);
        logger.info("Reset pass msg :"+currentTyMsg);
        //assertThat("Is not the expected Thank you message ....!",  currentTyMsg, containsIgnoringCase(forgotPassTyMessage));
    }


    /**
     * Setup css selectors per country as our Authors strive to astonishing different design for same thing
     * @param country2LetterCode  e.g it
     */
    public void setupWebElementCssPerMarket(String country2LetterCode){
        logger.info("Set CSS selectors per market if needed ...!; country2LetterCode [{}]", country2LetterCode);

        if(null != country2LetterCode) {
                                                                                                                        //crmLoginBtnCss = ".formset--login .formset-button";            //payPageUrlContains     = "payment";
            switch (country2LetterCode) {
                case "it":
                    //giveMyPassBackBtnCss = "#-rsrc--content--englishtown--it--it--lp--os--crm-acq-summer-ipad-17--jcr__content--main-parsys--illustrator_1045993701--form-panel--panel-forgot-password--button";
                    break;
                case "de":
                    //crmLoginBtnCss = "input.btn.btn-block";  //.formset--login button                    //forgottenPassWeCss = "form [href='/customerservice/contactus/contactus.aspx']";
                    break;
                case "fr":
                    break;
                case "tw":
                    break;
                case "jp":
                    //giveMyPassBackBtnCss = "#-rsrc--content--englishtown--jp--ja--lp--os--crm-cxs-teacher-elissa--jcr__content--main-parsys--illustrator_1045993701--form-panel--panel-forgot-password--button";
                    break;
                case "mx":
                    submitWeCss = "input[name='firstname']"; //"#-rsrc--content--englishtown--mx--es--lp--os--crm-acq-30-day-challenge--jcr__content--main-parsys--stage_stretchable_583874939--form-panel--form-button";
                    break;
                case "br":

                    break;
                case "gb":
                    //giveMyPassBackBtnCss = "#-rsrc--content--englishtown-gb--en--lp--os--crm-cxs-teacher-elissa--jcr__content--main-parsys--illustrator_1045993701--form-panel--panel-forgot-password--button";                    /*if(!StringUtils.isBlank(getTestStartUrl()) && StringUtils.contains(getTestStartUrl(), "en-gb") ) {        crmLoginBtnCss       = StringUtils.replace(crmLoginBtnCss, "wws--en", "gb--en");                     giveMyPassBackBtnCss = StringUtils.replace(giveMyPassBackBtnCss, "wws--en", "gb--en");                    }*/

                    break;
                case "en":

                    break;

                case "tr":

                    break;
                case "us":

                    break;
                case "wws":// "en": TODO need some thinking how to deal with wws sites
                    //giveMyPassBackBtnCss = "#-rsrc--content--englishtown--wws--en--lp--os--crm-cxs-teacher-elissa--jcr__content--main-parsys--illustrator_1045993701--form-panel--panel-forgot-password--button";
                    break;
                default:
                    logger.warn(country2LetterCode + " Is not on the switch case options use defaolt CSS ...!");
            }
        } else {
            logger.error("country2LetterCode is null ...!");
        }
    }


    /**
     * setup form data to be entered based on country
     * @param country2LetterCode
     * // TODO ..
     */
    public Map getOSFormDataMap(String country2LetterCode){
        logger.info("setupFormDataMap ...!; for country2LetterCode [{}]", country2LetterCode);
        // default
        formDataMap = EfConstants.CRM_IT;

        if(null != country2LetterCode) {
            switch (country2LetterCode) {
                case "gb":
                    formDataMap = EfConstants.CRM_GB;
                    break;
                case "it":
                    formDataMap = EfConstants.CRM_IT;
                    break;
                case "de":
                    formDataMap = EfConstants.CRM_DE;
                    break;
                case "fr":
                    formDataMap = EfConstants.frOEFormMap;
                    break;
                case "tw":
                    formDataMap = EfConstants.TW_CRM_OE_MAP;
                    break;
                case "mx":
                    formDataMap = EfConstants.MX_CRM;
                    break;
                case "sa":
                    formDataMap = EfConstants.CRM_SA;
                    break;
                case "es":
                    formDataMap = EfConstants.CRM_IT; //CRM_OE_ES_MAP;
                    break;
                case "br":
                    formDataMap = EfConstants.CRM_OE_ES_MAP;
                    break;
                case "jp":
                    formDataMap = EfConstants.CRM_JP;
                    break;
                case "tr":
                    formDataMap = EfConstants.CRM_TR;
                    break;
                case "-1":     // getCountry() will return -1 if cant find country
                default:
                    logger.warn(country2LetterCode + " Is not on the switch case options use Default IT [itFCoeFormMap] form data ...!");
            }
        } else {
            logger.error("country2LetterCode is null ...!");
        }

        return formDataMap;
    }

    public Map getOEFormDataMap(String country2LetterCode){
        logger.info("setupFormDataMap ...!; for country2LetterCode [{}]", country2LetterCode);
        // default
        formDataMap = EfConstants.CRM_IT_OEMAP; //itFCoeFormMap; //CRM_MONIT_OE;

        if(null != country2LetterCode) {
            switch (country2LetterCode) {
                case "it":
                    //formDataMap = EfConstants.CRM_IT_OEMAP;
                    break;
                case "de":
                    formDataMap = EfConstants.CRM_DE_OEMAP; //.deOeFormMap;
                    break;
                case "fr":
                    formDataMap = EfConstants.CRM_FR_OEMAP;
                    break;
                case "tw":
                    formDataMap = EfConstants.TW_CRM_OE_MAP;
                    break;
                case "mx":
                    formDataMap = EfConstants.CRM_MX_EEFormMap;
                    break;
                case "sa":
                    formDataMap = EfConstants.CRM_SA_OECMRM_MAP;
                    break;
                case "es":
                    formDataMap = EfConstants.CRM_OE_ES_MAP;
                    break;
                case "br":
                    formDataMap = EfConstants.CRM_OE_ES_MAP;
                    break;
                case "jp":
                    formDataMap = EfConstants.UK_SB_MAP;
                    break;
                case "-1":     // getCountry() will return -1 if cant find country
                default:
                    logger.warn(country2LetterCode + " Is not on the switch case options use Default IT [itFCoeFormMap] form data ...!");
            }
        } else {
            logger.error("country2LetterCode is null ...!");
        }

        return formDataMap;
    }



}




//        if(StringUtils.contains(getWebDriver().getCurrentUrl(), "-wws/")) {     //executeJSscript("document.querySelectorAll('.formset--forgot-password .btn-primary')["+weId+"].blur()", getWebDriver(), 2);//JavaScriptHelper.click(getWebDriver(), giveMyPassBackBtnCss);
//            executeJSscript("document.querySelectorAll('[name=EmailOrUserName]').blur()", getWebDriver(), 2); //.formset--forgot-password .btn-primary
//            forgottenPassPage.emailOrUserName.sendKeys(Keys.ENTER);
//        } else {
// click(By.cssSelector(giveMyPassBackBtnCss));
//        }