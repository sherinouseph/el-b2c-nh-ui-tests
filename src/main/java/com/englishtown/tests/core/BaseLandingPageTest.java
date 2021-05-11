package com.englishtown.tests.core;
/**
 *
 * Add base test for most of the landing pages in here
 * OSForm tests
 * Date: 27/08/14
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.SafariRemoteWebDriver;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.forms.OSForm;
import com.englishtown.pages.landing.OSLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;



public class BaseLandingPageTest extends LandingPageTest<OSForm, OSLandingPage>{

    private static final Logger logger = LoggerFactory.getLogger(BaseLandingPageTest.class);
    protected String osPageUrl;
    protected String localizedTestPhoneNumber; //="0000000000";
    protected String pcode   = "notInitPcode";
    protected String offerId ="notInitOfferId";        // this is related to pcode
    protected String partnerPtnCode = "goes";
    protected String allformElementSelector = ".form .controls";    // oe incude send button
//    protected String formAllElementSelector = "form .controls input"; // default
    protected int noOfWebFormElements = 100; // 5 input txt and one check box
    protected Map formDataMap;
    protected String pay_page_url_contains ="containUrlNotInit" ;
    // validate name is persited to next step - pay page
    public String scriptGetCCName = "return $('input[name=\"CreditCardName\"]').val()";
    public String FULL_NAME = "testing tester";
//    public boolean isSpecialSubmit = false; // test
    protected boolean isEnsureCheckedEmailEnglish = true;

    WebElement webElement;
    String validationMsgWe = "tooltip-inner"; //.tooltip-inner"popover-content";   //et-cnt

    protected static boolean isEnterNumberOneByOne = false; // issue with mx typing the number as cursor moves

    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.getPage().getUrl());
    }

    protected String getLocalizedTestPhoneNumber(){
        return this.localizedTestPhoneNumber;
    }


    protected String getPcodeFromUrl(){
        return pcode;
    }
    protected String getOfferId(){
        return offerId;
    }

    public void validInputSubmissionGoesToPaymentPage(String localizedTestPhoneNumber) {
        myAssertThat(getWebDriver(), "FAILED Url is not valid for this page ...!", this.getPage().isUrlValidForThisPage(), true);
        // and the mess I have to get into for not having unique/common selectors for the tests
        /*boolean isExperience2 =  waitForUrlContains(getWebDriver(),"englisch-lernen-online-2", 10 );
        if(isExperience2){
            BaseForm.isDifferentButton = true;
            BaseForm.isSpecialCssSubmitButton = BaseForm.cssSubmitBt;
        }*/
        sleep(3000);
        clickAtWindow(getWebDriver(), 10, 10);
        getFormData(localizedTestPhoneNumber);
    }
    public void validInputSubmissionGoesToPaymentPage() {
        myAssertThat(getWebDriver(), "Url is not valid for this page ...!", this.getPage().isUrlValidForThisPage(), true);
        getFormDataNoPhone();
    }

    public void getFormData(String localizedTestPhoneNumber){
        logger.info("getFormData() ...!");
        jsWindowFocus();
        String browserWithExtraFocus ="explore";
        try {
            //  NOTE : TEST will pass this step if element not present // added focus on for IE: surname, phone and pass
            this.getPage().getForm()
                    .getFirstName().focusByTypeClearClick()
                    .getFirstName().setTextValue(getTestFirstName())
                    .getLastName().focusByTypeClearClick(browserWithExtraFocus)
                    .getLastName().setTextValue(getTestLastName(), true, 2)
                    .getEmailAddress().focusByTypeClearClick()
                    .getEmailAddress().setTextValue(generateEmail())
//                    .getPhoneNumber().focusByTypeClearClick(browserWithExtraFocus)
//                    .getPhoneNumber().setTextValue(localizedTestPhoneNumber)
                    .getPassword().focusByTypeClearClick(browserWithExtraFocus)
                    .getPassword().setTextValue(getTestPassword());
                    if(isEnsureCheckedEmailEnglish)
                        this.getPage().getForm().getEmailEnglish().ensureChecked();
            //.submit();
            if (localizedTestPhoneNumber != null) {
                this.getPage().getForm().getPhoneNumber().focusByTypeClearClick(browserWithExtraFocus);
                this.getPage().getForm().getPhoneNumber().setTextValue(localizedTestPhoneNumber);
            }
            if(isConfirmPassword){
                WebElementHelper.sendKeys(getWebDriver(), findElement(By.cssSelector("input[name=confirmpassword]")) ,"password" , true);
            }
            wait(1); // this calls to  WaitTool.setImplicitWaitToDefault(this.webDriver);
            if (isSpecialSubmit) { //BaseForm.*
                click(getWebDriver(), By.cssSelector("[id*=submit] , [class*=submit-nikol-]"));
            }else if(isUseFormEmailToSubmit){
                click(getWebDriver(), By.name("email") );
            } else if(isDifferentButton){
                click(getWebDriver(), By.cssSelector(isSpecialCssSubmitButton) );
            }
            else {
                this.getPage().getForm().submit();
            }
        }catch (Exception e){
            logger.error("getFormData Exception : "+ TestUtil.getException(e));
            WaitTool.setImplicitWaitToDefault(getWebDriver());
        }
    }
    public void getFormDataNoPhone(){
        jsWindowFocus();
        this.getPage().getForm()
                .getFirstName().focusByTypeClearClick()
                .getFirstName().setTextValue(getTestFirstName())
                .getLastName().setTextValue(getTestLastName())
                .getEmailAddress().focusByTypeClearClick()
                .getEmailAddress().setTextValue(generateEmail())
                .getPassword().setTextValue(getTestPassword())
                .submit();
        wait(1);
    }

    public void enterFormDataAll(Map map) {
        enterFormData(map);
    }
    //  Helper
    public void enter_data_click_submit_check_validation_Shown(Map formDataMap){
        myAssertThat(getWebDriver(), "Url is not valid for this page ...!", this.getPage().isUrlValidForThisPage(), true);
        enterFormDataAll(formDataMap)  ;      //  int length= osPageUrl.length();   //   assertTrue("The current page is OS page", getWebDriver().getCurrentUrl().toLowerCase().endsWith(osPageUrl.substring(length-10, length)));
        submitOsForm();
        checkOsValidationMessageElementDisplayed();
    }
      //TODO refactor
    public void checkOsValidationMessageElementDisplayed(){
        webElement = getOsValidationMessageWe();
        if(webElement != null) {
            myAssertThat(getWebDriver(), "Failed Is popover message shown ...!", webElement.isDisplayed(), true);
        }else {
            BasePage.failTest("Validation message not shown ; Web element NOT found ...!; URL: "+TestUtil.getCurrentUrl(getWebDriver()));
        }
    }
    public void assertOsValidationMessageText(WebElement webElement, String msg){
        webElement = getOsValidationMessageWe();
        if(webElement != null) {
            myAssertThat(getWebDriver(), "assertOsValidationMessageText ...!", webElement.getText().toLowerCase(), is(equalTo(msg)), true);
        }else {
            BasePage.failTest("Validation message text is not the expected one; Web Element is NULL ...! ");
        }
    }
    public void assertOsValidationMessageContainsText(String msg){
        webElement = getOsValidationMessageWe();
        if(webElement != null) {
            myAssertThat(getWebDriver(), "FAILED .. Validation message Does NOT contains'" + msg + "'",
                webElement.getText().toLowerCase(), containsString(msg), true);
        }else {
            BasePage.failTest("Validation message does not contain text; Web Element is NULL ...! ");
        }
    }
    public void testOsValidationMessageShown(String containText){
        checkOsValidationMessageElementDisplayed();
        assertOsValidationMessageContainsText(containText);
    }
    public WebElement getOsValidationMessageWe(){
        WebElement we = null;
        we = WaitTool.findElementDontFailTest(getWebDriver(), By.className(this.validationMsgWe)) ; //WebElementHelper.safeFindElement(getWebDriver(), By.className(this.validationMsgWe));
        return we;
    }
    //********
    public WebElement getWebElement(WebElement we, By bySelector){
        logger.info(" webElement text : " + we.getText());
         WebElementHelper.safeFindElement(getWebDriver(), By.className(this.validationMsgWe));
        return we;
    }

    public void isTelFieldText(String isText){
        myAssertThat(getWebDriver(),"isTelFieldText Failed ...!", WebElementHelper.safeFindElement(getWebDriver(), By.className(validationMsgWe)).getText().trim(),
                is(equalTo(isText)), true );
    }

//    public WebElement getOsValidationMessageWe(){
//        return WebElementHelper.safeFindElement(getWebDriver(), By.className(validationMsgWe));
//    }

    public void submitOsForm(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector("[id*=submit]")),
                getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector("[id*=submit]"));
    }
    public void submitOsForm(By by){
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector("[id*=submit]"));
    }
    public void becomeALead(Map userMap) {
        enterFormDataAll(userMap);
        //click(By.name("toc"));//select terms and conditions checkbox
        submitOsForm();
        assertIsPaymentForm("payment");
    }

    public void gobackToOsPageEnterDetailsAndSubmit(String url, Map userMap){
        logger.info("deleteAllCookies");
        //CookieHandler.deleteCookies(getWebDriver());
        //getWebDriver().manage().deleteAllCookies();                                                                     //this will not work for Safary
        sleep(2000);
        //for safari only, close the window and open a new one
        if(BaseRemoteWebDriver.isBrowser("safari")) {
            logger.info("Is safari browser, need to close the window and oppen new one to clear cookies ...!");
            CookieHandler.setCookies(getWebDriver(), BaseRemoteWebDriver.getCurrentBrowserName(), "");
            getWebDriver().close();
            try {
                setWebDriver(new SafariRemoteWebDriver());
            } catch (Exception e) {
                logger.error("Exception creating new SafariRemoteWebDriver ...! "+ TestUtil.getException(e));
            }
        }

        getWebDriver().get(url);
        sleep(2000);
       // BasePage.waitForUrlContains(getWebDriver(), url, WaitTool.MED_WAIT_4_ELEMENT25 );
        enterFormDataAll(userMap);
        submitOsForm();
    }

}