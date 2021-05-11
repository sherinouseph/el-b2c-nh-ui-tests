package com.englishtown.tests.checkout.common;
/**
 * Checkout flows
 * mostly used by old checkout
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.forms.DynamicMembersForm;
import com.englishtown.tests.core.BaseTestHelper;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;


public abstract class StandardCheckoutFlowTest extends BaseTestHelper {

    private static final Logger logger = LoggerFactory.getLogger(StandardCheckoutFlowTest.class);

    @Value("#{applicationPropertiesList['test.firstname']}")
    private String testFirstName;
    @Value("#{applicationPropertiesList['test.lastname']}")
    private String testLastName;
    @Value("#{applicationPropertiesList['test.password']}")
    private String testPassword;
    @Value("#{applicationPropertiesList['test.cc.exp.month']}")
    private String testCreditCardExpiryMonth;
    @Value("#{applicationPropertiesList['test.cc.exp.year']}")
    private String testCreditCardExpiryYear;
    @Value("#{applicationPropertiesList['test.cc.num.live']}")
    private String testCreditCardNumber;
    @Value("#{applicationPropertiesList['test.cc.ccv.num']}")
    private String testCreditCardVerificationCode;


    protected StandardMemberPageTest getMemberPageTest(WebDriver webDriver) {
        return new StandardMemberPageTest(webDriver, this.testFirstName, this.testLastName,
                this.testPassword, this.getMemberPageUrl() );
    }
     protected DynamicMemberPageTest getDynamicMemberPageTest(WebDriver webDriver, String country) {
         return new DynamicMemberPageTest(webDriver, this.testFirstName, this.testLastName,
                 this.testPassword, this.getMemberPageUrl(), "","","",false,3, country);

     }
    protected StandardPaymentPageTest getPaymentPageTest(WebDriver webDriver) {
         return new StandardPaymentPageTest(webDriver, this.testCreditCardExpiryMonth,
                 this.testCreditCardExpiryYear,
                 this.testCreditCardNumber, this.testCreditCardVerificationCode,
                 this.getWebDriver().getCurrentUrl());
     }
     protected StandardPaymentPageTest getPaymentPageTest(WebDriver webDriver, String url) {
         return new StandardPaymentPageTest(webDriver, this.testCreditCardExpiryMonth,
                 this.testCreditCardExpiryYear,
                 this.testCreditCardNumber, this.testCreditCardVerificationCode,
                 url);
     }

    private StandardThankYouPageTest getThankYouPageTest(WebDriver webDriver) {
        return new StandardThankYouPageTest(webDriver, this.getWebDriver().getCurrentUrl());
    }

   // @Test //(enabled = false)
    public void testFlow() {
        isStoreData = false; // store data for user  // old checkout
        StandardMemberPageTest memberPageTest = this.getMemberPageTest(this.getWebDriver());
        memberPageTest.createMember();  // and submit
        
        StandardPaymentPageTest paymentPageTest = this.getPaymentPageTest(this.getWebDriver());
        boolean isEmailEnglish=true;
        sleep(3000);
        assertCheckoutPaymentPageStateObjectElements(isEmailEnglish);                                                   // assertCheckoutPayMentPageStateObjectElements();
        logger.info(" assert true : isTrackingEfEducationFirst - CONTAINS_TRACKING_SERVER :" + CONTAINS_TRACKING_SERVER);
        /*AssertHelper.myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER +
                        "'; Waited for :" + WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT),
                is(true), true
        ); */                                                                                                      //        assertTrue(isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER,  getDefaultJsScriptTimeout() ), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER);
        stopCheckoutAbortPopup();
        paymentPageTest.fillCreditCardForm();
        // for rusia need to add : CCAddress1   CCState  CCCity  CCPostalCode
//        if(getPaymentPageUrl() != null && getPaymentPageUrl().contains("town.ru")){
//            enterFormData(EfConstants.address); //creditCardSubmit  .et_btn_m
//            click(getWebDriver(), By.id("creditCardSubmit"));    // currWebElement = findElement(By.id("creditCardSubmit"));
//        }
        //WaitTool.setImplicitWaitToDefault(getWebDriver());
        StandardThankYouPageTest thankYouPageTest = this.getThankYouPageTest(this.getWebDriver());
        AssertHelper.myAssertThat(getWebDriver(), " Failed ... is thankyou page, waitForUrlContains 'thankyou' : seconds waited : " +
                        WaitTool.MED_WAIT_4_ELEMENT25,
                BasePage.waitForUrlContains(this.getWebDriver(), "thankyou", WaitTool.MED_WAIT_4_ELEMENT25), is(true), true);
        stopCheckoutAbortPopup();
    }
    public void checkoutFlowGoToPay() {
        StandardMemberPageTest memberPageTest = this.getMemberPageTest(this.getWebDriver());
        memberPageTest.createMember(); //and submit
    }

    public void openMemberPage(StandardMemberPageTest memberPageTest) {
        memberPageTest = this.getMemberPageTest(this.getWebDriver());
        memberPageTest.createMember(false);
    }

    public void submitMemberPage( StandardPaymentPageTest paymentPageTest) {
        getWebDriver().findElement(By.id("submit")).click();
        paymentPageTest = this.getPaymentPageTest(this.getWebDriver());
    }
    public void isCheckoutPaymentStateObject(boolean isEmailEnglish){
        assertCheckoutPaymentPageStateObjectElements(isEmailEnglish);
    }
    public void enterCreditCardFormDetailsAndCheckThankyouPage(StandardPaymentPageTest paymentPageTest) {
        paymentPageTest.fillCreditCardForm(); // and submit
        StandardThankYouPageTest thankYouPageTest = this.getThankYouPageTest(this.getWebDriver());
        AssertHelper.myAssertThat( getWebDriver(), "Failed ...!. is thankyou page; URL does not contains 'thankyou'. "+
                                    " Waited for :"+WaitTool.MED_WAIT_4_ELEMENT25,
                                   BasePage.waitForUrlContains(this.getWebDriver(), "thankyou", WaitTool.MED_WAIT_4_ELEMENT25), is(true), true);
    }
    public void isCheckoutPaymentPageStateObject(){
        assertThankyouPageStateObjectElements();
    }


     // TODO refactor the below method is used for the .com locals test
     public void testFlow(String url) {
         StandardMemberPageTest memberPageTest = this.getMemberPageTest(this.getWebDriver());
         memberPageTest.createMember();
         this.getWebDriver().get(url);
         StandardPaymentPageTest paymentPageTest = this.getPaymentPageTest(this.getWebDriver());
         paymentPageTest.fillCreditCardForm();
         StandardThankYouPageTest thankYouPageTest = this.getThankYouPageTest(this.getWebDriver());
     }
     //TODO JP only   // test method
     public void testFlowDynamic( String country) {
         DynamicMemberPageTest memberPageTest = this.getDynamicMemberPageTest(this.getWebDriver(), country);
         DynamicMembersForm form = memberPageTest.createMemberAndReturnMForm(country);
         form.submit();
         StandardPaymentPageTest paymentPageTest = this.getPaymentPageTest(this.getWebDriver());
         paymentPageTest.fillCreditCardForm();
         StandardThankYouPageTest thankYouPageTest = this.getThankYouPageTest(this.getWebDriver());
         try{Thread.sleep(1000);}catch (Exception e){e.printStackTrace();}
     }

    protected void clickCreditCardTab(WebDriver webDriver, String urlContains, By byElement){
        if (getMemberPageUrl().contains(urlContains)){
            logger.info(" urlContains :"+urlContains);
            try {
                WebElement we = WebElementHelper.safeFindElement(webDriver, byElement);
                we.click();
                sleep(1000);
            }catch ( NullPointerException e){
                BasePage.failTest(e, " Failed to click on credit card tab ...!", true) ;
            }
        }
    }

    // -----
    public void check_NameOnCardValueMatchesPrevStepEnteredData() {
        String fullName =  formDataMap.get("firstname")+" "+ formDataMap.get("lastname");
        String nameOnCardHidden =getHidenFieldByName("CCFirstName", WaitTool.MED_WAIT_4_ELEMENT)+" "+getHidenFieldByName("CCLastName", 7);//gethidenfieldbyname because norman removed ids because of duplicate ids.hence using name in the test
        AssertHelper.myAssertThat(getWebDriver(),"Fails -! First name and last name not progressed from previous step," +
                        " hidden field full name value :'" + nameOnCardHidden + "' should be equal to :'" + fullName + "'",
                nameOnCardHidden, equalTo(fullName), true);  
    }
    public void check_NameOnCardValueMatchesPrevStepEnteredData(String userFullName) {
        String fullName =  userFullName;
        String nameOnCardHidden =getHidenFieldById("CCFirstName", WaitTool.MED_WAIT_4_ELEMENT)+" "+getHidenFieldById("CCLastName", 7);
        AssertHelper.myAssertThat(getWebDriver(), "Fail ...!. First name and last name not progressed from previous step," +
                     " hidden field full name value :'" + nameOnCardHidden + "' should be equal to :'" + fullName + "'",
                     nameOnCardHidden.equals(fullName), Matchers.is(true), true);
    }

    protected abstract String getMemberPageUrl();

    protected abstract String getPaymentPageUrl();

    protected abstract String getThankYouPageUrl();

}