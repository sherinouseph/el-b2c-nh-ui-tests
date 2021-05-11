package com.englishtown.tests.core;
/**
 * All testcases should use this class
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.*;
import com.englishtown.helpers.exception.MyMessage;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.CheckoutPaymentPage;
import com.englishtown.pages.checkout.newcheckout.DynamicPaymentMemberPage;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.core.EnglishtownStateObject;
import com.englishtown.tests.core.common.CommonTestHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.englishtown.helpers.AssertHelper.assertThat;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


public abstract class BaseTest extends BaseTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public String phase1OfferPrice;
    public String phase0OfferPrice;
    public AdyenTestCard adyenTestCard;

    public String paymentSubmitBtnCss = "div.active .bs3 .btn";
    protected boolean isEnsureCheckedEmailEnglish = true;
    /*******************************************************************************************************************
     * Wrappers
     *
     ******************************************************************************************************************/
    protected void waitForElementCondition( ExpectedCondition condition, WebDriver webdriver, int waitTime) {
        logger.info("waitForElementCondition  : ExpectedCondition :"+condition);
        WaitTool.waitForCondition(condition, webdriver, waitTime);
    }
    public WebElement getFirstElementVisible(WebDriver driver, By bySelector){
        return WebElementHelper.getFirstVisibleElement(driver, bySelector);
    }
    public boolean verifyUrlContains(String urlContains, int waitTimeSec) {
        return BasePage.waitForUrlContains(getWebDriver(), urlContains, waitTimeSec);                                   // return getWebDriver().getCurrentUrl().contains(urlContains)  ;
    }
    public void jsWindowFocus(){
        JavaScriptHelper.javaScriptWindowFocus(getWebDriver());
    }
    public static String executeJSscript(String script, WebDriver webDriver, int waitTime){
        return JavaScriptHelper.executeJavaScript(script, webDriver, waitTime);
    }
    public void stopCheckoutAbortPopup(){
        logger.info("stopCheckoutAbortPopup ...!");
        String typeOfScrip    = "if(typeof stopPopup =='function'){stopPopup();}";
        String result =  executeJSscript(typeOfScrip, getWebDriver(), 3);
    }
    public void webDriverSwitchToDefautContent(){
        try {
            getWebDriver().switchTo().defaultContent();
        }catch (Exception e){
            logger.error("webDriverSwitchToDefautContent Exception  ...! "+TestUtil.getException(e, getWebDriver()));
        }
    }
    public void clickAtWindow(WebDriver webDriver, int x, int y){
        JavaScriptHelper.clickAtWindowXY(webDriver, x, y);
    }

    /**
     *
     * @param formFields
     */
    public void enterFormData(Map formFields) {
        TestUtil.enterFormData(getWebDriver(), formFields);

    }
    /**
     * Use css to populate form fields
     *
     * @param formFieldsWithCss   .. composite css selector
     */
    public void enterFormDataCss(Map formFieldsWithCss) {
        logger.info("enterFormData ....!");
        TestUtil.enterFormDataCss(getWebDriver(), formFieldsWithCss);
    }

    public Cookie getCookie(WebDriver driver, String cookieName) {
        return CookieHandler.getCookie(driver,cookieName);
    }
    /*******************************************************************************************************************
     * Return hidden field value      *
     ******************************************************************************************************************/
    public String getHidenFieldValue(String bySelector, String selectorTag ,int waitTime) {
        JavaScriptHelper js = new JavaScriptHelper();
        return js.getHidenFieldBy(getWebDriver(), bySelector, selectorTag, waitTime); //DriverManager.getDriver()
    }
    public String getHidenFieldById(String selectorId, int waitTime){
        JavaScriptHelper js = new JavaScriptHelper();
        return js.getHidenFieldBy(getWebDriver(), "Id", selectorId, waitTime); //DriverManager.getDriver()
    }

    public String getHidenFieldByName(String selectorName, int waitTime){
        JavaScriptHelper js = new JavaScriptHelper();
        return js.getHidenFieldBy(getWebDriver(), "Name", selectorName, waitTime); //DriverManager.getDriver()
    }

    public void waitForHidenField(String elementName, int waitTime){
        getHidenFieldByName(elementName, waitTime);
    }
    /**
     * Assert a hidden field value
     */
    public void assertHiddenField(String elementName, String elementValue, int waitTime){
        String hidenFieldName = getHidenFieldByName(elementName, waitTime);
        logger.info("assertHiddenField : assert hidden field :"+hidenFieldName+" value is equal to :"+
                elementValue+" wait time is "+waitTime+" seconds;");
        myAssertThat(getWebDriver(), " Failed - Hidden field is not equal to expected value ..!  ",
                hidenFieldName.toLowerCase(), CoreMatchers.is(elementValue), true);
    }

    public void assertHiddenFieldById(String elementId, String elementValue, int waitTime){
        String hidenFieldId = getHidenFieldById(elementId, waitTime);
        logger.info("assertHiddenField : assert hidden field :"+hidenFieldId+" value is equal to :"+
                elementValue+" wait time is "+waitTime+" seconds;");
        myAssertThat(getWebDriver(), " Failed - Hidden field is not equal to expected value ..!  ",
                hidenFieldId.toLowerCase(), CoreMatchers.is(elementValue), true);
    }

    /**
     *  Assert an array of hidden fields IDs     *
     *  TODO ....!
     */

    public void click( WebDriver driver, By selector){
        WebElement webElement = WebElementHelper.safeFindDisplayedAndEnabled(driver, selector, WaitTool.MED_WAIT_4_ELEMENT25);
        if(webElement !=null){
            //assertThat("assert currentWe.isEnabled , selectgor :"+selector, loginWe.isEnabled());
            myAssertThat(getWebDriver(), MyMessage.MSG_WE_NOT_ENABLED+" : "+selector, webElement.isEnabled(), is(true),true);
            try{Thread.sleep(100);}catch (Exception e){}
            scrollToWeAndClick(driver,webElement,0,200);
        }else {
            BasePage.failTest("clickLogin() - "+MyMessage.MSG_WE_NULL+" : "+selector, true);
        }
        try{Thread.sleep(2000);}catch (Exception e){}
    }
    public void clickListWebElement( WebDriver driver, By selector, int weId){
        List<WebElement> webElement = WebElementHelper.safeFindListOfElementsPresent(driver, selector, WaitTool.MED_WAIT_4_ELEMENT25);
        if(webElement !=null){

            myAssertThat(getWebDriver(), MyMessage.MSG_WE_NOT_ENABLED+" : "+selector, webElement.get(weId).isEnabled(), is(true),true);
            try{Thread.sleep(100);}catch (Exception e){}
            scrollToWeAndClick(driver, webElement.get(weId),0,200);
        }else {
            BasePage.failTest("clickLogin() - "+MyMessage.MSG_WE_NULL+" : "+selector+"; we id :"+weId, true);
        }
        try{Thread.sleep(2000);}catch (Exception e){}
    }

    public void click(WebElement webElement){
        logger.info("click we ["+webElement+"]");
        WebElementHelper.click(webElement);
    }

    public void waitForVisibleClickableAndClick(WebElement clickMeWe, int waitTimeSec){
        logger.info("waitForClickableAndClick ...!");
        if(waitTimeSec < 1)
            waitTimeSec =  WaitTool.DEFAULT_IMPLICIT_WAIT;
        waitForElementCondition(ExpectedConditions.visibilityOf(clickMeWe),
                getWebDriver(), waitTimeSec);   //currentCourseUnitPage.startBtnWe.get(0
        waitForElementCondition(ExpectedConditions.elementToBeClickable(clickMeWe),
                getWebDriver(), waitTimeSec);   //currentCourseUnitPage.startBtnWe.get(0)
        click(clickMeWe);
    }
    public void click(By weCss){
        logger.info("find and click we by css ["+weCss+"]");
        WebElementHelper.click(WaitTool.findElement(getWebDriver(), weCss));
    }

    public void submit(WebElement webElement){
        WebElementHelper.submit(webElement);
    }

    public WebElement findElement(By by){
        return WaitTool.waitForElementVisible(getWebDriver(), by, WaitTool.DEFAULT_WAIT_4_ELEMENT, 1000);
    }
    public WebElement findElement(By by, int waitTime){
        return WaitTool.waitForElementVisible(getWebDriver(), by, waitTime, 1000);
    }
    // find displayed elements
    public List<WebElement> findElements(By by, int waitTimeSec){
        return WaitTool.waitForListElementsDisplayed(getWebDriver(), by, waitTimeSec);
    }
    //find elements without wait and no check for is visible
    public List<WebElement> findElements(By bySelector){
        return WaitTool.findElements(getWebDriver(), bySelector);
    }

    /**
     *
     * @param selector
     * @param optionValue
     * @param optionId -> if select by ID
     */
    public void select(By selector, String optionValue, String optionId){
        TestUtil.actionOnSelectElement(getWebDriver(), true, optionId, optionValue, selector);
    }
    /*******************************************************************************************************************
     * Scroll element into view and then click
     ******************************************************************************************************************/
    public void scrollToWeAndClick(WebDriver webDriver, WebElement webElement, int x, int y){
        logger.info("scrollToWeAndClick : X='" + x + "' ; Y='" + y + "'");
        try {
            WebElementHelper.scrollToElementLocation(webDriver, webElement, x, y);
            try { Thread.sleep(1000);  } catch (Exception e) {   }
            webElement.click();
        }catch (Exception e) {
            logger.error(" scrollToWeAndClick Excepiton :"+TestUtil.getExceptionFirstLine(e)); //+e.getCause()
        }
    }
    /**
     *  Check the number of form elements
     */
    public void validateNoOfInputElements(String weSelector, int weSize){
        weSelector = "form .controls input";
        List<WebElement> we =  getWebDriver().findElements(By.cssSelector(weSelector)) ;
        myAssertThat(getWebDriver(), "Failed Validate form size ...!", we.size(), is(weSize), true);       //assertThat("Failed Validate form size ", we.size(), is(weSize));
    }

    public boolean isNoOfFormElements(WebDriver webDriver, By weSelector, int weSize){
        List<WebElement> we =  getWebDriver().findElements(weSelector) ;
        logger.info("WebElement size : " + we.size() + " - should be equal to : " + weSize);
        return (weSize== we.size());
    }
    public void assertNoOfFormElements(WebDriver webDriver, By weSelector, int weExpectedSize){
        List<WebElement> we =  getWebDriver().findElements(weSelector) ;
        logger.info("WebElement size : "+ we.size()+" - should be equal to : "+weExpectedSize);
        myAssertThat(getWebDriver(), "FAILED : Number of form elements is not " + weExpectedSize, we.size(), greaterThan(weExpectedSize), true);  //assertThat("FAILED : Number of form elements is not " + weExpectedSize, we.size(), equalTo(weExpectedSize));
    }

    //Go to member page, check member_id, type, username inside user OBJ on state Obj, make sure they do not exist
    public void assertStateOjectKeysAreEmptyNotNull(String[] keys){
        assertStateObjectListOfKeysDontExistIsNull(keys);
    }
    public void assertMemberPageStateOjectKeysAreEmptyNotNull(){
        assertStateObjectListOfKeysDontExistIsNull(userObjectNonExistentKeys);
    }
    /**
     *  State object key does not exist - is null
     */
    public void assertIsStateObjectKeyNonExistentNull(String stateObjectElementKey, boolean isLoadStateObject ) {
        String value =  getStateObjectValue(stateObjectElementKey, isLoadStateObject);
        //assertThat(" Failed state object key " + stateObjectElementKey +  " EXIST - is N O T  NULL - when it should be null! ", value == null, is(true));
        myAssertThat(getWebDriver(), " Failed state object key " + stateObjectElementKey +
                " EXIST - is N O T  NULL - when it should be null! ", value, is(nullValue()), true);
    }

    public void assertStateObjectListOfKeysDontExistIsNull(String[] stateObjectElementKeys ) {
        loadStateObject(true); // load only once
        for (String key : stateObjectElementKeys){
            assertIsStateObjectKeyNonExistentNull( key, false) ;
        }
    }

    public void assertCheckoutPaymentPageStateObjectElements(boolean isEmailEnglish){
        if (isEmailEnglish){
            assertStateObjectValue("tracking.events", "MemberRegistration", "EmailEnglish" ); //"MemberRevenue", "EmailEnglishRevenue"
        }else {
            assertStateObjectValue("tracking.events", "MemberRegistration");  //, "MemberRevenue"
        }
        //user
        assertStateObjectValueNotBlankNorEmpty("user.member_id", false);
        assertStateObjectValueNotBlankNorEmpty("user.username", false);
        assertStateObjectValue("user.member_type","member");
        //form
        assertStateObjectValueNotBlankNorEmpty("form.first_name", false);
        assertStateObjectValueNotBlankNorEmpty("form.last_name", false);
        assertStateObjectValueNotBlankNorEmpty("form.local_name", false);
        //order
        assertStateObjectValueNotBlankNorEmpty("order.phase0.currency", false);
        assertStateObjectValueNotBlankNorEmpty("order.phase1.currency", false);
        assertStateObjectValueNotBlankNorEmpty("order.offer_id", false);
                            // no order id should exist in here
        String element = "order.order_id";
        String value =  getStateObjectValue(element, false);
        //assertThat(" Failed state object key " + element + " value EXIST - is not NULL - when it should be null! ", value, nullValue())  ;
        myAssertThat(getWebDriver(), " Failed state object key " + element +
                " value EXIST - is not NULL - when it should be null! ", value, is(nullValue()), true);                     //        assertFalse(englishtownStateObject.isStateObjectKey(englishtownStateObject.getStateObjectMap(), "order.order_id"), " Failed state object key DOES NOT EXIST : " + "order.order_id")  ;
    }

    public void assertThankyouPageStateObjectElements(){
        try{Thread.sleep(3000);} catch(Exception e){e.printStackTrace();}
        assertStateObjectValue("tracking.events", "OrderCreation", "FTORevenue");
        //user
        assertStateObjectValue("user.member_type", "member");
        assertStateObjectValueNotBlankNorEmpty("user.member_id", true);
        assertStateObjectValueNotBlankNorEmpty("user.username", false);
        //order
        assertStateObjectValueNotBlankNorEmpty("order.offer_id", false);
        assertStateObjectValueNotBlankNorEmpty("order.order_id", false);
        assertStateObjectValueNotBlankNorEmpty("order.order_amount", false);
        assertStateObjectValueNotBlankNorEmpty("order.items.item_id", false);  //order items item_id
        assertStateObjectValueNotBlankNorEmpty("order.items.name", false);
        assertStateObjectValue("order.phase1.price", phase1OfferPrice);
    }
    public void assertThankyouPageFormStateObjectElements( ){
        logger.info("assertThankyouPageFormStateObjectElements()....");                                                 // String [] keys   = {"form.first_name", "form.last_name", "form.local_name"};        String [] values = {"testing",         "tester",         "testing tester"};
        assertStateObjectValue("form.first_name", "testing");
        assertStateObjectValue("form.last_name", "tester");
        assertStateObjectValue("form.local_name", "testing tester");
    }
    public void assertThankyouPageFormStateObjectElements(String[] keys, String[] values ){
        int count = 0;
        if(keys.length == values.length) {
            for (String key: keys){
                assertStateObjectValue(key , values[count]);
                count++ ;
            }
        } else {
            logger.error("Cant compare deffernt size arrays ... keys.length:" + keys.length + " values.length :" + values.length);
            BasePage.failTest("Incompatible array size ...!");
        }
    }
    public static void failTestIfNullWebElement(WebElement webElement){
        if(webElement == null){
            BasePage.failTest("Failed ...! -> WebElement is not found [null] ...!. WebElement :" + WebElementHelper.getElementLocator(webElement));
        }
    }

    public static void failTest(String reason){
        BasePage.failTest(reason);
    }

    public static void failTestIfEmptyList(List<WebElement> webElement){
        if(CollectionUtils.isEmpty(webElement) ){
            BasePage.failTest("Failed ...! -> List of WebElement is not found or [null] ...!" );
        }
    }

    public String getText(WebElement webElement){
        return TestUtil.getWebElementText(webElement);
    }

        // TODO refactor
    public void assertThankyouPageStateObjectElementsNewCheckout(){
        assertStateObjectValue("tracking.events",  "OrderCreation"); //"FTORevenue"
        assertStateObjectValueNotBlankNorEmpty("order.offer_id", false);
        assertStateObjectValueNotBlankNorEmpty("user.member_id", false);
        if(phase1OfferPrice != null)
            assertStateObjectValue("order.phase1.price", phase1OfferPrice);
        else if(phase0OfferPrice != null)
            assertStateObjectValue("order.phase0.price", phase0OfferPrice);

        //Fail last check 06/02/2015     //assertStateObjectValueNotBlankNorEmpty("order.items.item_id", false);
    }

    public void assertThankyouPageStateObjectElementsNewhouse(){
        assertStateObjectValue("tracking.events",  "OrderCreation"); //"FTORevenue"
        //offer id todo new house this is an array need to update script to get this for the new house
        //assertStateObjectValueNotBlankNorEmpty("order.offer_id", false);
        assertStateObjectValueNotBlankNorEmpty("session.efid", false);
    }

    public void assertThankyouPageStateObject_trakingEvents(){
        assertStateObjectValue("tracking.events", "OrderCreation", "FTORevenue");
    }
    public void assertThankyouPageStateObject_orderOfferId_NotBlankNorEmpty(){
        assertStateObjectValueNotBlankNorEmpty("order.offer_id", false);
    }
    public void assertThankyouPageStateObject_userMemberId_NotBlankNorEmpty(){
        assertStateObjectValueNotBlankNorEmpty("user.member_id", false);
    }

    public void assertPaymentPageTrackingEvents(){
        logger.info("assertStateObjectValue 's  \"tracking.events\", \"MemberRegistration\" "); // "MemberRevenue"
        assertStateObjectValue("tracking.events", "MemberRegistration");  //"EmailEnglish", "EmailEnglishRevenue"
    }

    public void assertThankyouPageStateObjectLpOeTrackingEvents(){
        logger.info("assertStateObjectValue 's  \"tracking.events\",  \"LeadOnlineEnquiry\", \"EmailEnglish\"");
        assertStateObjectValue("tracking.events", "LeadOnlineEnquiry","EmailEnglish");  // "LeadOERevenue",  "EmailEnglishRevenue",  "LeadOERevenue",
    }
    public void assertThankyouPageStateObjectLpOeLeadId(){
        logger.info(" assertStateObjectValueNotBlankNorEmpty -  form.lead_id ");
        assertStateObjectValueNotBlankNorEmpty("form.lead_id", true);
    }

    public void assertStateObjectLeadIdCreated(){
        logger.info(" assertStateObjectValueNotBlankNorEmpty -  form.lead_id ");
        assertStateObjectValueNotBlankNorEmpty("form.lead_id", true);
    }

    public void assertStateObjectMemberIdCreated(){
        logger.info(" assertStateObjectMemberIdCreated ValueNotBlankNorEmpty -  user.member_id ");
        assertStateObjectValueNotBlankNorEmpty("user.member_id", true);
    }
    public void assertStateObjectEfIdCreated(){
        logger.info(" assertStateObjectEfIdCreated ValueNotBlankNorEmpty -  session.efid");
        assertStateObjectValueNotBlankNorEmpty("session.efid", true);
    }
    // live env
    public void assertUserLogedInStateObjectElementsDe(){
        logger.info("assertUserLogedInStateObjectElementsDe");
        assertStateObjectElementValue("page.application", "Etown", true);
        assertStateObjectElementValue("session.is_logged_in","true", false);
        assertStateObjectElementValue("session.partner_site","Englishtown", false);
        assertStateObjectElementValue("session.is_returning", "false", false);          //assertStateObjectElementValue("session.vmsi","34330", false);
        if(getWebDriver().getCurrentUrl().contains("//qa") || getWebDriver().getCurrentUrl().contains("//staging")) {
            logger.info("isStateObjectValueMatchRegex for user.member_id qa and staging match : "+MATCH_ANY_CHAR_THREE_OR_MORE_TIMES.toString());
            isStateObjectValueMatchRegex("user.member_id",false, MATCH_ANY_CHAR_THREE_OR_MORE_TIMES);
        } else {
            assertStateObjectElementValue("user.member_id","29768318", false);
        }
        assertStateObjectElementValue("user.member_type", "member", false);
    }
    // could use map
    public void assertUserLogedInStateObjectElements(String... values){
        logger.info("assertUserLogedInStateObjectElements "+values.toString());
        assertStateObjectElementValue("page.application",values[0], true);
        assertStateObjectElementValue("session.is_logged_in",values[1], false);
        assertStateObjectElementValue("session.is_returning",values[2], false);
        assertStateObjectElementValue("user.member_id",values[3], false);
        assertStateObjectElementValue("user.member_type",values[4], false);

    }
    //partner ptn and etag test
    public void assertStateObjectParnterCodeAndEtag(String ptnId, String etagId, String ptnValue, String etagValue){
        logger.info("assertStateObjectParnterCodeAndEtag   Parnter :" + ptnValue + " And Etag :" + etagValue);
        assertStateObjectElementValue(ptnId, ptnValue, true);
        assertStateObjectElementValue(etagId, etagValue, true);
    }

    public void assertStateObjectParnterCode(String ptnId, String ptnValue){
        logger.info("assertStateObjectParnterCode   Partner Key[{}] :", ptnId+" \t Value :" + ptnValue);
        assertStateObjectElementValue(ptnId, ptnValue, true);
    }
    public void assertStateObjectEtag(String etagId, String etagValue){
        logger.info("assertStateObjectEtag  Etag Key[{}] : :" + etagId + " \t Value :" + etagValue);
        assertStateObjectElementValue(etagId, etagValue, true);
    }

    public void assertHidenFieldsParnterCodeAndEtag(String ptnId, String etagId, String ptnValue, String etagValue){
        logger.info("assert Hidden fields - Parnter :"+ptnValue+" And Etag :"+etagValue);
        String hiddenValue =getHidenFieldById(ptnId, 20);
        //assertThat(hiddenValue, is(ptnValue));          //assertTrue(hiddenValue.equals(ptnValue), "FAILED .. assert PTN HidenField value : " + hiddenValue + " does not match expected ptnValue " +ptnValue);
        myAssertThat(getWebDriver(), "Assert Hidded value Failed ...!", hiddenValue, equalTo(ptnValue), true);
        hiddenValue =getHidenFieldById(etagId, 5);
       // assertThat(hiddenValue, is(etagValue));        //assertTrue(hiddenValue.equals(etagValue), "FAILED .. assert etag HidenField value : " + hiddenValue+" does not match expected ptnValue " +etagValue);
        myAssertThat(getWebDriver(), "Assert Hidden value Failed ...!", hiddenValue, equalTo(etagValue), true);
    }

    public boolean isUrlWithWait(String urlContains, int waitTime){
        return BasePage.waitForUrlContains(getWebDriver(), urlContains, waitTime)  ;                                             //   new "/buy/default/payment/"
    }
    public boolean isPaymentUrlWithWait(String urlContains, int waitTime){
        return BasePage.waitForUrlContains(getWebDriver(), urlContains, waitTime)  ;                                             //   new "/buy/default/payment/"
    }
    public void assertIsUrlContaining(String urlContains){
        myAssertThat(getWebDriver(), TestUtil.getCurrentUrl(getWebDriver())+"  -> URL does not contain : "+urlContains,
                isUrlWithWait(urlContains, WaitTool.MED_WAIT_4_ELEMENT25),true);
    }
    public void assertIsPaymentForm(String urlContains){
        myAssertThat(getWebDriver(), "FAIlED -assertIsPaymentForm() URL does not contain 'payment' ",
                isPaymentUrlWithWait(urlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT),true);
    }
    public void assertIsPaymentThankyou(String urlContains){
        myAssertThat(getWebDriver(), "FAIlED -assertIsPaymentForm() URL does not contain 'payment' ",
                isPaymentUrlWithWait(urlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT),true);
    }
    public void assertIsPaymentFormNotShown(){
        myAssertThat( getWebDriver(), "assertIsPaymentFormNotShown Failed ...!",
                                   isPaymentUrlWithWait("payment", WaitTool.SHORT_WAIT_4_ELEMENT), is(false), true);         //);//assertFalse(isPaymentUrlWithWait("payment"); //); //(isPaymentUrlWithWait());
    }
    /*******************************************************************************************************************
     *
     * Test State Object values  , split on comma ','
     * Assert 1 to 1 ; 1 to *; * to * (contains a list of items )
     *
     ******************************************************************************************************************/
    public void assertStateObjectValue(String stateObjectElementKey, String... valuesToMatch) {
        try{
            if(valuesToMatch != null){
                logger.info("assertStateObjectValue(..) stateObjectElementKey "+stateObjectElementKey);
                int count = 1;
                for (String match : valuesToMatch){
                    logger.info(" valuesToMatch -"+count+" - "+match);
                    count++;
                }
            }
            boolean isStateObjectOneValue    =false;  // not a list nor [] e.g "oneValue"
            boolean isManyValuesToMatchTest  =false;
            boolean assertResult = false;
            StringBuffer resultList = new StringBuffer();
            String currentStateObjectValue;
            englishtownStateObject = new EnglishtownStateObject(DriverManager.getDriver());
            String argument =  "";
            int waitForSec = 25;
            logger.info("Max waitForSec ....:"+waitForSec);
            int count=0;

            do{
                waitForSec--;
                count++;
                sleep(999);
                logger.info("DO LOOP ..., Start  loading state object...! try count is : "+count);
                englishtownStateObject.load(DriverManager.getDriver());
                currentStateObjectValue = englishtownStateObject.getStateObjectValueFromMap(
                                                     englishtownStateObject.getStateObjectMap(), stateObjectElementKey);
                if(isNotEmpty_And_isNotBlank(currentStateObjectValue) )
                {
                    logger.info(" Found state object value ...! : "+currentStateObjectValue+", tried for Sec : "+count);
                    break;
                }
                if(waitForSec < 1){
                    BasePage.failTest("State Object Key ["+stateObjectElementKey+"] NOT Found or missing or Timeout " +
                            "loading state object : waited for :"+count+" seconds", true);
                }
            } while (waitForSec > 0);

            String[] stateObjectSplitValueList;
            logger.info("currentStateObjectValue : " + currentStateObjectValue);
            if (currentStateObjectValue.contains(",")) {
                stateObjectSplitValueList = currentStateObjectValue.split(",");
            } else {
                isStateObjectOneValue = true;  // only one value  - match 1 to 1 or 1 to many
                stateObjectSplitValueList = null;
            }
            if (valuesToMatch.length > 1) {
                isManyValuesToMatchTest = true;
            } else {
                argument = valuesToMatch[0];
            }
            /* Start matching
             * Many To Many  all match     */
            if (isManyValuesToMatchTest && !isStateObjectOneValue) {
                List<String> stateObjList    = Arrays.asList(stateObjectSplitValueList);
                assertThat("Not matched ...!", stateObjList , hasItems(valuesToMatch));
                logger.info("Found list of items in state object list ...!");
            }

            // One to Many (stateObjects)
            else if (!isStateObjectOneValue && !isManyValuesToMatchTest) {
                myAssertThat(getWebDriver(), "Match Not Found ...!", stateObjectSplitValueList, hasItemInArray(valuesToMatch[0]), true );
                logger.info("Value ["+valuesToMatch[0]+"]; Found in state object ...!");
            }

            // One TO One
            else if (isStateObjectOneValue && !isManyValuesToMatchTest) {
                myAssertThat(getWebDriver(), "Match Not Found ...!", currentStateObjectValue.toLowerCase(), is(valuesToMatch[0].toLowerCase()), true );
                logger.info("Value ["+valuesToMatch[0]+"]; Found in state object ...!");
            }

            // Many TO One
            else if (isManyValuesToMatchTest && !isStateObjectOneValue) {
                BasePage.failTest("Many to One : Can't match Many Values to One stateObject Value ! ", true);
            }

        }catch (WebDriverException e ){
            BasePage.failTest(e, "assertStateObjectValue() Failure ...!;", true);
        }
    }

    /*******************************************************************************************************************
     * Check element not null/blank/empty  and is an integer
     ******************************************************************************************************************/
    public void assertStateObjectValueNotBlankNorEmpty(String stateObjectElement,  boolean isLoadStateObject) {
        if (isNotEmpty(stateObjectElement) ) {
            String currentStateObjectValue = getStateObjectValue(stateObjectElement,isLoadStateObject );
            logger.info("assertStateObjectValueNotBlankNorEmpty... State object value element : "+stateObjectElement+" is :"+currentStateObjectValue);
            myAssertThat(getWebDriver(), "FAILED State Object Value is Empty Or Blank ...!"+
                    stateObjectElement+" is :"+currentStateObjectValue,
                    isNotEmpty_And_isNotBlank(currentStateObjectValue), is(true), true);
             //TODO move this out of this methods as it needs to be on its on as some items have one chars and some have more
            //assertThat(" value does not contais any chars , MATCH_ANY_CHAR_ONE_OR_MORE_TIMES", currentStateObjectValue.matches(MATCH_ANY_CHAR_ONE_OR_MORE_TIMES));
            myAssertThat(getWebDriver()," Value does not contains any chars , MATCH_ANY_CHAR_ONE_OR_MORE_TIMES",
                    currentStateObjectValue.matches(MATCH_ANY_CHAR_ONE_OR_MORE_TIMES) , is(true), true);
        } else {         // fail test
            BasePage.failTest("Not possible to Assert, the Element stateObjectElement IS EMPTY " + stateObjectElement, true);            //Assert.fail("Not possible to Assert, the Element stateObjectElement IS EMPTY " + stateObjectElement);
        }
    }


    public String getStateObjectValueWithWait(String stateObjectElementKey,boolean isWait) {
        int waitForSec= WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT;
        logger.info("getStateObjectValueWithWait Max waitForSec ....:" + waitForSec);
        int count=0;
        String currentStateObjectValue;

        if(isWait) {
            do {
                waitForSec--;
                count++;
                logger.info("DO LOOP ..., Start  loading state object...! try count is : " + count);                    //try{        // englishtownStateObject.load();    //englishtownStateObject.getStateObjectValueFromMap(englishtownStateObject.getStateObjectMap(), stateObjectElement);
                currentStateObjectValue = englishtownStateObject.getStateObjectValueFromMap(englishtownStateObject.getStateObjectMap(), stateObjectElementKey);
                if (isNotEmpty_And_isNotBlank(currentStateObjectValue)) {
                    logger.info(" Found state object value ...! : " + currentStateObjectValue + ", tried for Sec : " + count);
                    break;
                }
                if (waitForSec < 1) {                                                                                   //logger.info("Timeout loading state object ....!, waitForSec :[{}] ", count);
                    BasePage.failTest("getStateObjectValueWithWait, Value is empty or blank ...!\n State object Key is :'"+stateObjectElementKey+"' Waited for :"+count+" seconds", true);       //fail(" Timeout loading state object : waited for :" + count + " seconds");
                }
                sleep(1000);
            } while (waitForSec > 0);
        } else {
            currentStateObjectValue = englishtownStateObject.getStateObjectValueFromMap(
                    englishtownStateObject.getStateObjectMap(), stateObjectElementKey);
        }
        return currentStateObjectValue;
    }

    public static boolean isNotEmpty_And_isNotBlank(String amIemptyAndBlankStr){
        return StringUtils.isNotEmpty(amIemptyAndBlankStr) && StringUtils.isNotBlank(amIemptyAndBlankStr);
    }

    /*******************************************************************************************************************
     * Match the value to the regex e.g "\\d+"
     ******************************************************************************************************************/
    public void isStateObjectValueMatchRegex(String stateObjectElement,  boolean isLoadStateObject, String regex) {
        String currentStateObjectValue = getStateObjectValueWithWait(stateObjectElement, true);
        //assertTrue(currentStateObjectValue.matches(regex), "Failed regex is :"+regex + " value is : "+currentStateObjectValue);
        myAssertThat( getWebDriver()," isStateObjectValueMatchRegex Failed ...!; regex is :"+
               regex + " value is : "+currentStateObjectValue , currentStateObjectValue.matches(regex), is(true), true);
    }

    /*******************************************************************************************************************
     * @param isLoadStateObject  -> reload it again or not
     ******************************************************************************************************************/
    public void assertStateObjectElementValue(String stateObjectElement, String value, boolean isLoadStateObject) {
        logger.info("assertStateObjectElementValue to check for :[{}] ", value);
        if (isNotEmpty(stateObjectElement) ) {
            loadStateObject(isLoadStateObject );
            String currentStateObjectValue = getStateObjectValueWithWait(stateObjectElement, true);
            logger.info("currentStateObjectValue is : "+currentStateObjectValue);
            if(currentStateObjectValue!=null){
                myAssertThat(getWebDriver()," assertStateObjectElementValue Failed ...! ; stateObjectElement : "+stateObjectElement+" values should be :"+value,
                        currentStateObjectValue.toLowerCase(), is(value.toLowerCase()),true);
            }else {
                BasePage.failTest("Not possible to Assert, the Element currentStateObjectValue IS NULL ...!"+ currentStateObjectValue, true);                     //Assert.fail("Not possible to Assert, the Element currentStateObjectValue IS NULL " + currentStateObjectValue);
            }
        } else {
            BasePage.failTest("Not possible to Assert, the Element :"+ stateObjectElement+"   IS EMPTY ", true); //Assert.fail("Not possible to Assert, the Element :"+ stateObjectElement+"   IS EMPTY ");
        }
    }
    public boolean isStateObjectElement(String stateObjectElementKey, boolean isLoadStateObject) {
        logger.info("assertIsStateObjectElement :" + stateObjectElementKey + " Reload state object : " + isLoadStateObject);
        loadStateObject( isLoadStateObject);
        return englishtownStateObject.isStateObjectKey(englishtownStateObject.getStateObjectMap(), stateObjectElementKey);
    }

    public boolean isValueInMap(Map offer, boolean isAllMatch, String ... containsValues){
        return TestUtil.isValueInMap(offer, isAllMatch, containsValues);
    }

    // Element interaction
    public void waitForElementVisibleAndClick(String cssSelector, int timeSec){
        waitForElementCondition( ExpectedConditions.visibilityOf(getWebDriver().findElement(
                By.cssSelector(cssSelector))), getWebDriver(), timeSec);
        WebElement webElement = findElement(By.cssSelector(cssSelector));
        click(webElement);// webElement.click();
        try{Thread.sleep(2000);}catch (Exception e){}
    }
    public void waitForElementVisibleAndClick(WebDriver driver, String cssSelector, int timeSec){
        waitForElementCondition( ExpectedConditions.visibilityOf(driver.findElement(
                By.cssSelector(cssSelector))), driver, timeSec);
        WebElement webElement = findElement(By.cssSelector(cssSelector));
        click(webElement);// webElement.click();
        try{Thread.sleep(2000);}catch (Exception e){}
    }

    public void waitForElementVisibleAndClick(WebDriver driver, WebElement webElement, int timeSec){
        waitForElementCondition( ExpectedConditions.visibilityOf(webElement), driver, timeSec);
        click(webElement);// webElement.click();
        try{Thread.sleep(2000);}catch (Exception e){}
    }


    /** wait for an element visible; then click at  X,Y     */
    protected void waitForElementAndclickAtXY( String elementToWaitId, int x, int y){
        WebElement we = WebElementHelper.safeFindElement(getWebDriver(), By.id(elementToWaitId));
        clickAtWindow(getWebDriver(), x, y);
    }
    protected void waitForElementAndclickAtXY( By locator, int x, int y){
        logger.info("waitForElementAndclickAtXY   : we :"+locator);
        WebElement we = WaitTool.waitForElementPresent(getWebDriver(), locator, WaitTool.DEFAULT_WAIT_4_ELEMENT) ;  //WebElementHelper.safeFindElement(getWebDriver(), locator);
        clickAtWindow(getWebDriver(), x,y);
    }

    /**
     * Check window.s object exist
     * DO NOT use - this take forever      *
     */
    public static void testWindowDotS_exist(WebDriver webDriver, int waitTime){
        logger.info("testWindowDotS_exist : '"+JS_WINDOWS_S_OBJ);
        String jsResult = null;
        jsResult= JavaScriptHelper.executeJavaScript(JS_WINDOWS_S_OBJ, webDriver, waitTime);
        logger.info(" jsResult is : '" + jsResult + "' -> Should Exist ...!");
        if(jsResult != null && !jsResult.isEmpty() ){            logger.info(" jsResult is : '"+jsResult);
        } else {
            BasePage.failTest(JS_WINDOWS_S_OBJ+" is null/Empty ...!", true);
        }
    }

    /**
     *
     * @param webDriver
     * @param isEmptyOrNull -> if true it validate object is empty or null otherwise Not empty or null
     * @param value         -> just in case we need to check the exact value in the future
     * @param jsScriptWaitTime
     *
    public static void checkWindowDotSevents(WebDriver webDriver, boolean isEmptyOrNull, String value, int jsScriptWaitTime){
        logger.info("checkWindowDotSevents : '"+JS_WINDOWS_S_EVENTS_OBJ);
        String jsResult = null;
        jsResult= JavaScriptHelper.executeJavaScript(JS_WINDOWS_S_EVENTS_OBJ, webDriver, jsScriptWaitTime);
        logger.info(JS_WINDOWS_S_EVENTS_OBJ+" jsResult is [" + jsResult + "] ...!");
        if(isEmptyOrNull) {
            AssertHelper.assertThat(JS_WINDOWS_S_EVENTS_OBJ+" Should be empty or null ....!", jsResult, isEmptyOrNullString());
        } else {
            AssertHelper.assertThat(JS_WINDOWS_S_EVENTS_OBJ+" Should contains values : "+value, jsResult, containsString(value));
        }
    }
    public static void checkWindowDotSeventsDoesNotContains(WebDriver webDriver, int jsScriptWaitTime, String ... events){
        logger.info("checkWindowDotSeventsDoesNotContains : '"+JS_WINDOWS_S_EVENTS_OBJ);
        String jsResult = null;
        jsResult= JavaScriptHelper.executeJavaScript(JS_WINDOWS_S_EVENTS_OBJ, webDriver, jsScriptWaitTime);
        logger.info(JS_WINDOWS_S_EVENTS_OBJ+" jsResult is [" + jsResult + "] ...!");
        for(String event : events) {
            AssertHelper.assertThat(JS_WINDOWS_S_EVENTS_OBJ + " Should NOT contain the value :"+event, jsResult, not(containsString(event)));
        }
    }*/
   /* no more windows .s
    public static boolean isTrackingEfEducationFirst(String script, WebDriver webDriver, String contains, int waitTime){
        logger.info("isTrackingEfEducationFirst ...!");
        String jsResult = null;
        jsResult= JavaScriptHelper.executeJavaScript(script, webDriver, waitTime);
        logger.info(" jsResult is : '"+jsResult+"' -> and should contain :"+contains);
        if(jsResult != null && !jsResult.isEmpty() ){
            return  jsResult.contains(contains);
        } else {
            BasePage.failTest("isTrackingEfEducationFirst is null/Empty ...!. Waited ["+waitTime+"]", true);
            return false;
        }
    }*/

    /**
     * Note: test pass if jsResult = " "; but fail if null or ""
     *       So adding trim to fail on this case =" "
     */
    public static void checkTrackingServeExist(WebDriver webDriver, int waitTime){
        logger.info("running checkTrackingServeExist ...");
        String jsResult = JavaScriptHelper.executeJavaScript(BaseTest.JS_TRACKING_EF, webDriver, waitTime);
        logger.info(" jsResult is :'" +jsResult+"' ");
        if(jsResult != null) {
            myAssertThat(webDriver, " Failed ...! Window.s.trackingServer is empty or null :'" + jsResult + "' ",
                    jsResult.trim(), not(isEmptyOrNullString()), true);
        } else {
            BasePage.failTest("Javascript result is null ...! for 'return window.s.trackingServer'; Waited for  "+waitTime);
        }
    }

    /**
     * member creation window.s.events [event..]
     * window.s.events.event42  ==  "purchase,event42"   event2 on payment page and 42 on thankyou page
     */

    public static void checkMemberCreationEvent(WebDriver webDriver, String event, int waitTime){
        logger.info("checkMemberCreationEvent - window.s.events  contains '"+event+"'");
        String jsResult = JavaScriptHelper.executeJavaScript(BaseTest.JS_WINDOWS_S_EVENTS_OBJ, webDriver, waitTime);
        logger.info(" jsResult is :'" +jsResult+"' ");
        if(StringUtils.isBlank(jsResult)){
            BasePage.failTest("Window S Events is empty/null or not Found ...! js return : '"+jsResult+"'");
        }else {
            myAssertThat(webDriver, "window.s.events '" + jsResult + "' Does not contains ["+event+"]",
                    jsResult.trim(), containsString(event), true);
        }
    }

    //-----------------------------------------------------------   where to move these methods ??????
    public void isExpectedPcodeOnStateObject(String offerIdKey, String pcode, boolean isReloadStateObj){
        logger.info("isExpectedPcodeOnStateObject:"+pcode);
        assertStateObjectElementValue(offerIdKey, pcode, isReloadStateObj);
    }

    public void isOfferIdRelatedToPcode(String offerIdKey, String offerId, boolean isReloadStateObj){
        logger.info(" Offer id should be :"+offerId);
        assertStateObjectElementValue(offerIdKey, offerId, isReloadStateObj);
    }
    public void isOrderCurrencyRelatedToPcodeOnTY(String offerIdKey, String currency, boolean isReloadStateObj){
        logger.info(" Order Offer currency should be :"+currency);
        assertStateObjectElementValue(offerIdKey, currency, isReloadStateObj);
    }
    public void isOrderPriceRelatedToPcodeOnTY(String offerIdKey, String price, boolean isReloadStateObj){
        logger.info("Order Offer price should be :"+price);
        assertStateObjectElementValue(offerIdKey, price, isReloadStateObj);
    }

    public void isOrderOfferPriceOnStateObjectSameAsOfferPrice(String offerIdKey, String price, boolean isReloadStateObj){
        logger.info("isOrderOfferPriceOnStateObjectSameAsOfferPrice Order Offer price should be :"+price);
        assertStateObjectElementValue(offerIdKey, price, isReloadStateObj);
    }
    // --------------------------------------------------------
    //TODO refactored from down up to here
    /*********************************
     *  sleep wrapper
     ********************************/
    public static void sleep(int sleepTimeMls){
        TestUtil.mySleep(sleepTimeMls);
    }

    /*******************************************************************************************************************
     * NEW Checkout and landing.uk.os
     ******************************************************************************************************************/
    // used on landing.uk.os and new checkout test test - cant move this at the moment
    public synchronized  void remove_PaymentValidation() {
        logger.info("remove_PaymentValidation() live only ...! - ENV [{}]", getENVIRONMENT());
        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "live")) {
            paymentPage = new DynamicPaymentMemberPage(getWebDriver());
            paymentPage.removePaymentValidationNew();
            sleep(3000);
            paymentPage = new DynamicPaymentMemberPage(getWebDriver());
            paymentPage.waitForPageToLoad(paymentPage.getPageLoadedCondition());
        } else
            logger.info("QA ENV so pay validation not needed to be removed ...!");
    }

    public void remove_PaymentValidation(WebDriver driver) {
        logger.info("remove_PaymentValidation() live only ...! - ENV [{}]", getENVIRONMENT());
        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "live")) {
            paymentPage = new DynamicPaymentMemberPage(driver);
            try{Thread.sleep(3000);  }catch(Exception e){}
            paymentPage.removePaymentValidationNew(driver, isNewhousePayment);
            try{Thread.sleep(3000);  }catch(Exception e){}
            paymentPage = new DynamicPaymentMemberPage(driver);
            paymentPage.waitForPageToLoad(paymentPage.getPageLoadedCondition());
        } else
            logger.info("QA ENV so pay validation not needed to be removed ...!");
    }

    public void removePaymentValidation() {
        logger.info("remove_PaymentValidation() live only ...! - ENV [{}]", getENVIRONMENT());
        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "live")) {
            paymentPage = new DynamicPaymentMemberPage(getWebDriver());
            paymentPage.removePaymentValidationNew(getWebDriver(), isNewhousePayment);
            sleep(1000);
        } else
            logger.info("QA ENV so pay validation not needed to be removed ...!");
    }

    public void enter_PayFormDataAndSubmit() {
        enter_PaymentDetails();
        //WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.name(submitId));
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(paymentSubmitBtnCss)),getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(paymentSubmitBtnCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(paymentSubmitBtnCss));
        click(submitElement);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    public void enter3DSecurePassAnd_Submit(String password) {
        getWebDriver().switchTo().frame("threeDSIframe");
        AssertHelper.assertWebElementDisplayed(findElement(By.name("answer")));
        getWebDriver().findElement(By.name("answer")).sendKeys(password);
        click(By.className("button--primary"));
    }

    public void enter_AdyenPayFormDataAndSubmit(WebDriver webdriver) {
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(webdriver,true);
        sleep(5000);
        checkoutPaymentPage.adyenPaymentModule.checkAllPageComponentsDisplayed();
        checkoutPaymentPage.adyenPaymentModule.enterCardDetails(adyenTestCard.getCardNumber(),adyenTestCard.getExpiryDate(),adyenTestCard.getCvv());
        paymentSubmitBtnCss = ".chckt-button.chckt-pm-list__button";
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(paymentSubmitBtnCss)),getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(paymentSubmitBtnCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(paymentSubmitBtnCss));
        click(submitElement);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    public void enter_AdyenPayFormDataAndSubmit(WebDriver webdriver,String cardNumber,String expiryDate,String cvv) {
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(webdriver,true);
        checkoutPaymentPage.adyenPaymentModule.enterCardDetails(cardNumber,expiryDate,cvv);
        paymentSubmitBtnCss = ".chckt-button.chckt-pm-list__button";
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(paymentSubmitBtnCss)),getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(paymentSubmitBtnCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(paymentSubmitBtnCss));
        click(submitElement);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    public void enrolStudentCheckAtSchool() {
        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.startEnrolment();
        // Step 1
        enrolmentPage.simpleTest();
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        enrolmentPage.selectImproveEnglishFor(0);
        // Step 2
        sleep(2000);
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        enrolmentPage.selectEnglishLevel(1);
        // Step 3
        sleep(2000);
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.clickStartLearning();
        sleep(2000);
        //as the popup is shown cant check this enrolmentPage.checkStudentIsAtSchoolCampus();
    }

    public void enter_PaymentDetails() {
        Map<String, String> paymentMap = EfConstants.ukMembersPayMap_new;

        try{
            //if US then need to enter the address
            String currURL = TestUtil.getCurrentUrl(getWebDriver()) ;
            String usUrlContains="-us/buy";
            String mxUrlContains="-mx/buy/default";

            setTestCardNumber(getENVIRONMENT(), getTestCardType());//by default test will run with visa card type

            if(currURL != null ) {
                if( currURL.contains(usUrlContains)  ) {
                    TestUtil.setMapKeyValue(EfConstants.payPageWithAddressMap, "CreditCardNumber", getTestCardNumber());
                    enterFormData(EfConstants.payPageWithAddressMap);
                }
                else {
                    TestUtil.setMapKeyValue(paymentMap, "CreditCardNumber", getTestCardNumber());
                    enterFormData(paymentMap);
                }
            }else{ logger.error("Current urls is null ...! "+currURL);}
        }catch(Exception e){
            logger.error("enter_PayFormDataAndSubmit() ..enterFormData and  paymentPage.submitForm Exception" +
                    TestUtil.getException(e, getWebDriver()));
            BasePage.failTest(e, "enter_PayFormDataAndSubmit  FAIL", true);
        }
    }
    public void  enter_adyenPaymentDetails(Map formData) {
        logger.error("Data Entered ...! ");
        try{
            enterFormDataCss(formData);
            logger.error("Data Entered ...! ");
        }catch(Exception e){
            logger.error("enterCreditCardFormData() ..enterFormData " +       TestUtil.getException(e, getWebDriver()));
            BasePage.failTest(e, "enter_PayFormDataAndSubmit  FAIL", true);
        }
    }



    public void enterCreditCardFormData(Map formData) {
        logger.error("Data Entered ...! ");
        try{
            enterFormData(formData);
            logger.error("Data Entered ...! ");
        }catch(Exception e){
            logger.error("enterCreditCardFormData() ..enterFormData " +       TestUtil.getException(e, getWebDriver()));
            BasePage.failTest(e, "enter_PayFormDataAndSubmit  FAIL", true);
        }
    }
    public void submitPaymentForm(){
        WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.name(submitId));
        submitElement.submit();
        try{Thread.sleep(3000);}catch (Exception e){}
    }
    /*******************************************************************************************************************
     * Switch to window if available
     * wrapper
     ******************************************************************************************************************/
//    public static void safeSwitchToWindow(WebDriver driver, int windowId)  {
//        BasePage.switchToWindow(driver, windowId);
//    }
    /*******************************************************************************************************************
     * Fail test if not the correct ENV the test should run
     * Currently some test can not run on live
     *
     * live, qa, staging, uat
     ******************************************************************************************************************/
    public void failTestPerEnvironment(String environment, String message){
        if(getENVIRONMENT() !=null && getENVIRONMENT().equals(environment)){
            destroyDriver();
            BasePage.failTest("This test is set to FAIL FOR '" + getENVIRONMENT()
                                            + "' Environment -check other Environments \n" +"Extra info :" + message);
        }
    }
    public void runTestOnThisEnvironmentOnly(String environment, String message){
        if(getENVIRONMENT() !=null && !getENVIRONMENT().equals(environment)){
            destroyDriver();
            BasePage.failTest("This test is set to FAIL FOR '" + getENVIRONMENT()
                    + "' Environment -check other Environments \n" +"Extra info : " +
                    "\n Test set to run only on Environment :"+environment+" \n" + message);
        }
    }
    public void runTestOnLiveOnly(){
        runTestOnThisEnvironmentOnly("live", " Live only test");
    }
    /**
     * Fail test per browser
     */
    public void failTestPerBrowser(String browserNameContains, String message){
        String currentBrowser = BaseRemoteWebDriver.getCurrentBrowserName();
        if(currentBrowser.contains(browserNameContains)){
            BasePage.failTest("This test is set to FAIL FOR Browser : '" + currentBrowser + "' -check other Browsers  \n" +
                    "Extra info :" + message);
        }
    }
    public void failTestPerBrowsers( String message, String... browserNameContains){
        String currentBrowser = BaseRemoteWebDriver.getCurrentBrowserName();
        for(String bName : browserNameContains){
            if(currentBrowser.contains(bName)){
                BasePage.failTest("This test is set to FAIL FOR Browser : '" + currentBrowser + "' -check other Browsers  \n" +
                        "Extra info :" + message);
            }
        }
    }

    public void failTestPerBrowser(String browserNameContains, String bVersion, String failMsg){
        String currentBrowser = BaseRemoteWebDriver.getCapability().getBrowserName();
        String currentBrowserVersion =  BaseRemoteWebDriver.getCapability().getVersion();

        if(currentBrowser.contains(browserNameContains) && currentBrowserVersion.contains(bVersion)){
            BasePage.failTest("This test is set to FAIL FOR Browser : '" + currentBrowser +"' and Version :"+bVersion+ " -check other Browsers/Version ...! \n" +
                    "Extra info :" + failMsg);
        }
    }

    public static void failTestIfIsNotBrowser(String [] browserNameContains, String message){
        String currentBrowser = BaseRemoteWebDriver.getCurrentBrowserName();
        int count = 0;
        try{
            for(String browser : browserNameContains) {                                                                 // if (currentBrowser.contains(browserNameContains[0]) || currentBrowser.contains(browserNameContains[1]) || currentBrowser.contains(browserNameContains[2])) {
                if( currentBrowser.contains(browser) )
                    count ++;
            }
            if(count > 0){
                //run test
            } else {
                BasePage.failTest("Test set to FAIL FOR Browser :'" + currentBrowser + "' -check other Browsers\n" + " Extra info :" + message);
            }
        }catch (Exception e){
           logger.error("failTestIfIsNotBrowser "+TestUtil.getException(e));
        }
    }
    public void failTestPerUrl(String currentTestUrl, String failTestUrl, String message){
        if(StringUtils.contains(currentTestUrl,failTestUrl )){
            BasePage.failTest("This test is set to FAIL FOR URL[" + currentTestUrl+"] "+ message);
        }
    }
    /*******************************************************************************************************************
     *
     * Open url,
     * if @timeout is less than 1 use default timeout and - NO timeout is changed
     * if timeOut is more than 1 then set pageload timeout to that value and reset it back at the end
     *
     ******************************************************************************************************************/
    public void openUrl(WebDriver driver, String url, int timeOut) {
        TestUtil.openUrl(driver, url, timeOut);
    }
    public void openUrl(WebDriver driver, String url) {
        TestUtil.openUrl(driver, url);
    }

    /**
     * All new house urls have /1/ after the domain ...ef.com/1/***
     *
     * @param url  - old house url
     *
     */
    public String convertUtlToNewHouse(String url) {
        return TestUtil.convertToNewHouseUrl(url);
    }


    public void enterUserLoginCredentials( WebDriver webDriver, String email, String pass, String emailId, String passwordId){
        logger.info("enterUserCredentials, username: '"+email+", pass : "+pass);
        currWebElement = WebElementHelper.safeFindElement(webDriver,By.id(emailId) );
        currWebElement.sendKeys(email);
        currWebElement = WebElementHelper.safeFindElement(webDriver, By.id(passwordId) );
        currWebElement.sendKeys(pass);
        try{Thread.sleep(200);}catch (Exception e){}
        clickLogin(webDriver, By.cssSelector(submitBtn));
    }

    public void enterUserLoginCredentialsCss( WebDriver webDriver, String email, String pass, String userNameCssName, String passwordCssName){
        logger.info("enterUserCredentials, username: '"+email+", pass : "+pass);
        currWebElement = WebElementHelper.safeFindElement(webDriver,By.name(userNameCssName) );
        currWebElement.sendKeys(email);
        currWebElement = WebElementHelper.safeFindElement(webDriver, By.name(passwordCssName) );
        currWebElement.sendKeys(pass);
        try{Thread.sleep(200);}catch (Exception e){}
        clickLogin(webDriver, By.cssSelector(submitBtn));
    }
    //Temporary test to check refer a friend

    public void enterCredentialsReferAFriend( WebDriver webDriver, String email, String pass, String emailId, String passwordId,String submitBtn){
        logger.info("enterUserCredentials, username: '"+email+", pass : "+pass);
        currWebElement = WebElementHelper.safeFindElement(webDriver,By.name(emailId) );
        currWebElement.sendKeys(email);
        currWebElement = WebElementHelper.safeFindElement(webDriver, By.name(passwordId) );
        currWebElement.sendKeys(pass);
        try{Thread.sleep(200);}catch (Exception e){}
        clickLogin(webDriver, By.cssSelector(submitBtn));
    }

    // note : getWebdriver returns null ..... to investigate - BaseTestConfig caused this
    public void clickLogin( WebDriver driver, By selector){
        WebElement loginWe = WebElementHelper.safeFindElement(driver, selector );
        if(loginWe !=null){
            //assertThat("assert currentWe.isEnabled , selectgor :"+selector, loginWe.isEnabled());
            myAssertThat(getWebDriver(),"WebElement is not Enabled ...!; "+selector, loginWe.isEnabled(), is(true),true);
            try{Thread.sleep(100);}catch (Exception e){}
            scrollToWeAndClick(driver,loginWe,0,200);
        }else {
            BasePage.failTest("clickLogin() - currentWe is NULL ...! "+selector, true);
        }
        try{Thread.sleep(2000);}catch (Exception e){}
    }

    public void ensureChecked(By selector) {
        try {
            WebElement we = WebElementHelper.safeFindElement(getWebDriver(), selector);
            if (!we.isSelected()) {
                we.click();
                logger.info("Clicked to select checkbox");
            }                                                                                                           //            if( ! this.getWebElement().isSelected()){ MyWebDriverAction.actionClick(webDriver, this.getWebElement());         log.info(" Used action to selected checkbox ...!");//            }
        }catch (WebDriverException e){
            logger.error(" Ensure element is Selected Exception :"+TestUtil.getExceptionFirstLine(e));
        }
    }

    public void checkImageIsDisplayed(By selector) throws Exception {
        WebElement imageElement = WebElementHelper.safeFindElement(getWebDriver(), selector);
        checkImageIsDisplayed(imageElement);
    }
    public void checkImageIsDisplayed(WebElement we) throws Exception {
       TestUtil.checkImageIsDisplayed(getWebDriver(), we);
    }

    //src   .getAttribute("title");
    public String getAttributeValue(By selector, String attribute){
        WebElement we = WebElementHelper.safeFindElement(getWebDriver(), selector);
        return  getAttributeValue(we, attribute);
    }
    public String getAttributeValue(WebElement webElement, String attribute){
        if (webElement !=null) {
            return webElement.getAttribute(attribute);      //if(isBrowser(MyBrowserType.EDGE)){          return webElement.getCssValue(attribute); // use this for edge as get attribute is not working correctly           }else
        } else
            return null;
    }

    public static void selectByValue(WebDriver driver, WebElement we, String selectValue){
        try {
            Select select = new Select(we);
            select.selectByValue(selectValue);
        }catch(WebDriverException e){
            e.printStackTrace();
            logger.error("Could not select By value Exception ...! value : "+selectValue+" \n"+TestUtil.getException(e, driver));
            BasePage.failTest(e, "selectByValue Failed ...!", false);
        }
    }

    public static String getSelectedOption(WebElement we){
        String optionTxt = "";
        try {
            Select mySelect = new Select(we);
            WebElement option = mySelect.getFirstSelectedOption();
            if(option.isSelected()) {
                optionTxt = option.getText();
            } else {
                throw new WebDriverException("Option is not selected ...!");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't get the option value ...!");
            return optionTxt;
        }
        logger.info(" Option selected value is: "+optionTxt);
        return optionTxt;
    }

    public static boolean waitForUrlContains(WebDriver webDriver, String containsStr, int waitSeconds){
        return CommonTestHelper.waitForUrlContainsText(webDriver, containsStr, waitSeconds);
    }
    public static boolean waitForUrlNotContaining(WebDriver webDriver, String not_containsStr, int waitSeconds){
        return CommonTestHelper.waitForUrlDoesNotContainingText(webDriver, not_containsStr, waitSeconds);
    }

    public static boolean waitForUrlEndsWithTxt(WebDriver webDriver, String endsWith, int waitSeconds){
        return CommonTestHelper.waitForUrlEndsWith(webDriver, endsWith, waitSeconds);
    }

    public static void setScreenShotOnFailure(boolean takeScreenshot){
        TestngListener.isStoreScreenShotOnFailure=takeScreenshot;
    }

    public void checkFlowType(CheckoutFlowType flowType, boolean isTestCheckoutFlowType){
        if(isTestCheckoutFlowType){
            logger.info("Checkout flow type should be :"+flowType.getCheckoutFlowType());
            assertStateObjectValue(JavaScriptHelper.CHECKOUT_FLOW_TYPE,  flowType.getCheckoutFlowType());
            logger.info("Checkout flow type is the expected one  :"+flowType.getCheckoutFlowType());
        }else{
            logger.info("Checkout flow type not tested ... need to set isTestCheckoutFlowType = true to run the test ...!");
        }
    }


    /**
     *
     */
    public String submitId = "CreditCardName";



    public void isStateObjectKey(WebDriver driver, String key, String expectedKeyValue) {
        logger.info("isStateObjectKey should be : "+expectedKeyValue);
        englishtownStateObject = new EnglishtownStateObject(driver);  //DriverManager.getDriver());//getWebDriver()
        String currentLanguage = englishtownStateObject.getStateObjectKeyValue(driver, key);

        myAssertThat(driver, " verification failed. - compare : " + expectedKeyValue +
                " With PageObject value: " + currentLanguage, expectedKeyValue, equalToIgnoringCase(currentLanguage), true);
        //verifyStateObjectLanguage();
    }

}



/*

Original ...
public void assertStateObjectValue(String stateObjectElementKey, String... valuesToMatch) {
        try{
            if(valuesToMatch != null){
                logger.info("assertStateObjectValue(..) stateObjectElementKey "+stateObjectElementKey);
                int count = 1;
                for (String match : valuesToMatch){
                    logger.info(" valuesToMatch -"+count+" - "+match);
                    count++;
                }
            }
            boolean isStateObjectOneValue    =false;  // not a list nor [] e.g "oneValue"
            boolean isManyValuesToMatchTest  =false;
            boolean assertResult = false;
            StringBuffer resultList = new StringBuffer();
            String currentStateObjectValue;
            englishtownStateObject = new EnglishtownStateObject(this.getWebDriver());
            String argument =  "";
            int waitForSec = 25;
            logger.info("Max waitForSec ....:"+waitForSec);
            int count=0;

            do{
                waitForSec--;
                count++;
                sleep(999); // take longer than the specified time so changed this to 500 from 1000
                logger.info("DO LOOP ..., Start  loading state object...! try count is : "+count);
                englishtownStateObject.load();
                currentStateObjectValue = englishtownStateObject.getStateObjectValueFromMap(
                                                     englishtownStateObject.getStateObjectMap(), stateObjectElementKey);                                                                                        //currentStateObjectValue !=null
                if(isNotEmpty_And_isNotBlank(currentStateObjectValue) )
                {
                    logger.info(" Found state object value ...! : "+currentStateObjectValue+", tried for Sec : "+count);
                    break;
                }
                if(waitForSec < 1){                    //logger.info("Timeout loading state object ....!, waitForSec :[{}] ", count);
                    BasePage.failTest(" Timeout loading state object : waited for :"+count+" seconds", true);           //fail(" Timeout loading state object : waited for :"+count+" seconds");
                }                                                                                                       //}catch (NullPointerException e) {       logger.info("NullPointerException ....!!"+e.getCause());                // }catch (Exception e) {   logger.info("Exception ....!!"+e.getCause());         }
            } while (waitForSec > 0);

            String[] stateObjectSplitValueList;
            logger.info("currentStateObjectValue : " + currentStateObjectValue);
            if (currentStateObjectValue.contains(",")) {
                stateObjectSplitValueList = currentStateObjectValue.split(",");
            } else {
                isStateObjectOneValue = true;  // only one value  - match 1 to 1 or 1 to many
                stateObjectSplitValueList = null;
            }
            if (valuesToMatch.length > 1) {
                isManyValuesToMatchTest = true;
            } else {
                argument = valuesToMatch[0];
            }
            //TODO refactor - need some thinking  [4 cases - 1 to 1, 1 to *, * to 1, * to *]
            //Many To Many  all match
            if (isManyValuesToMatchTest && !isStateObjectOneValue) {
                for (String value : valuesToMatch) {
                    boolean tempAssertResult = false;
                    for (String objValue : stateObjectSplitValueList) {
                        tempAssertResult = value.equals(objValue);
                        if (tempAssertResult) {
                            logger.info(" Found Match for value :"+value+" on current state object value :"+objValue);
                            assertResult = true;
                            resultList.append("true,");  // assertTrue(assertResult, "List Assert Failed..!"+value+" did not match "+objValue);
                            break;
                        } else {
                            logger.info(" No Match for value    : "+value+" on current state object value :"+objValue);
                        }
                    }
                }
                //assertThat("List Assert Failed ! ", assertResult, is(true));  // at least one
                myAssertThat(getWebDriver(),"List Assert Failed ! ",assertResult, is(true), true );
                int trueResultNo = resultList.toString().split(",").length;
                //TODO use harmcrest to multimatch
                //assertThat("List Assert Failed..!  Match only :" + trueResultNo + " out of " + valuesToMatch.length, trueResultNo == valuesToMatch.length, is(true));
                myAssertThat(getWebDriver(),"List Assert Failed..!  Match only :" + trueResultNo +
                        " out of " + valuesToMatch.length, trueResultNo , is(valuesToMatch.length), false );
            }
            // One to Many (stateObjects)
            else if (!isStateObjectOneValue && !isManyValuesToMatchTest) {    // match one value to the list returned from state object

                assertResult = false;
                for (String objValue : stateObjectSplitValueList) {
                    assertResult = valuesToMatch[0].equals(objValue);
                    if (assertResult) {    break;                }
                }
                myAssertThat(getWebDriver(), "List Assert Failed 1 to many state objects values ...! ", valuesToMatch, is(true), true);

}
        // One TO One
        else if (isStateObjectOneValue && !isManyValuesToMatchTest) {
        assertResult = valuesToMatch[0].equals(currentStateObjectValue);
        //assertThat("List Assert Failed : valuesToMatch[0] : " + valuesToMatch[0] +" Did not match state object value : " + currentStateObjectValue, assertResult, is(true));
        myAssertThat(getWebDriver(),"Assert Failed : valuesToMatch : " + valuesToMatch[0] +
        " Did not match state object value : " + currentStateObjectValue, assertResult, is(true), false);
        }
        // Many TO One
        else if (isManyValuesToMatchTest && !isStateObjectOneValue) {
        BasePage.failTest("Many to One : Can't match Many Values to One stateObject Value ! ", true);    //fail("Many to One : Cant match Many Values to One stateObject Value ! ");
        }
        }catch (WebDriverException e ){
        BasePage.failTest(e, "assertStateObjectValue() Failure ...!;", true);
        }
        }


 */