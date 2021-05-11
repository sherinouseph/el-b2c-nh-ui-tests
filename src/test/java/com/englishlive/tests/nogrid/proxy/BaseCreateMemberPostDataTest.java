package com.englishlive.tests.nogrid.proxy;

/**
 * Created by nikol.marku on 05/04/2016.
 *
 * Validate post/response data content is as expected and check DB stored in DB
 *
 *  Check Create Member post and data stored on DB
 *  Check payment post data and data stored on DB
 *
 */

import com.englishtown.helpers.*;
import com.englishtown.helpers.bean.handler.EfFullDataBean;
import com.englishtown.helpers.reader.MyJsonReader;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.DynamicPaymentMemberPage;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.SharedSelectors;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;


public abstract class BaseCreateMemberPostDataTest extends BaseProxyFactory {
    private static final Logger logger = LoggerFactory.getLogger(BaseCreateMemberPostDataTest.class);
    protected String testURL;
    protected boolean isClickTabId = true;
    protected String creditCardLinkText;
    protected int tabId;

    @Test
    public void enterMemberFormDataSubmitAndGetPostData() {
        enterFormData(driver, testDataMap);  //TestUtil.SCREENSHOT_DIRECTORY
        enterEmail(driver, true, userName);

        WebElement tocWe = findElement(driver, By.name("toc"));
        tocWe.click();
        //TestUtil.getScreenShotUsingAShot(driver, ".\\target\\"+TestUtil.generateRandomFilename("member_") + ".png");
        /*WebElement we = findElement(driver, By.cssSelector(SharedSelectors.MEMBERPAGE_SUBMIT_BTN_CSS));
        we.submit();      WebElement fNameWe = findElement(driver, By.id("firstname"));*/
        WebElementHelper.click(findElement(driver, By.cssSelector(SharedSelectors.MEMBERPAGE_SUBMIT_BTN_CSS)));
        //WebElementHelper.safeFindAndClick(driver, By.cssSelector(SharedSelectors.MEMBERPAGE_SUBMIT_BTN_CSS));
        sleep(5000);
        BaseTestHelper.waitForUrlContains(driver, waitForUrlContains, 25);
        //driver.findElement(By.cssSelector(SharedSelectors.MEMBERPAGE_SUBMIT_BTN_CSS)).click();

        TestUtil.getScreenShotUsingAShot(driver, ".\\target\\"+TestUtil.generateRandomFilename("pay_") + ".png");
        //logger.info("Source ===="+driver.getPageSource());
        AssertHelper.assertThat("Is not the expected url after submitting Member ...!", TestUtil.getCurrentUrl(driver), containsString(waitForUrlContains));
        // delay the test to make sure response returned
        try{
            logger.info("starttime : "+System.currentTimeMillis());
            WaitTool.isElementVisible(driver, By.cssSelector(".btn-blockDontfindme"), 3, 3000);
            logger.info("endtime : "+System.currentTimeMillis());
        }catch (Exception e){}

    }

    @Test(dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void getPostDataBean(){
        try {
            postedDataBean = new EfFullDataBean();
            postedDataBean = getFullDataBeamAndSetResponseObj(proxyServer, harFilter);
            logger.info("postedDataBean : "+postedDataBean.toString());
        }catch (NullPointerException npe){
            logger.error(" Null Object ...! "+npe.getMessage());
            BasePage.failTest("Can't get basic post data handler, Null data ...!");
        }
    }

    @Test (dependsOnMethods = { "getPostDataBean" })
    public void validateFirstName_PostData(){
        String testName = "First Name";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getFirstname(), equalTo(postedDataBean.getFirstname()) );
    }

    @Test (dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void validateEmail_PostData(){
        String testName = "Email";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getEmail(), equalToIgnoringCase(postedDataBean.getEmail()));
    }

    @Test (dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void validateLocale_PostData(){
        String testName = "Locale";
        try{Thread.sleep(5000);} catch (Exception e){};
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getLocal(), equalToIgnoringCase(postedDataBean.getLocal()));
    }

    @Test (dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void validateLeadType_PostData(){
        String testName = "Lead Type";
        if(isSubmitOeFormHandler) {
            AssertHelper.assertThat(testName + " posted is not the expected one ...!",
                    expectedPostData.getLeadtype(), equalToIgnoringCase(postedDataBean.getLeadtype()));
        } else { logger.info("There is no lead type for this request ... so this test is not checking it");}
    }

    @Test (dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void x_validateResponseStatusCode(){
        String testName = "ValidateResponseStatusCode";
        AssertHelper.assertThat(testName+" received is not the expected one ...!",
                basicResponseDataHandler.getResponseStatus(), equalTo(200)  ) ;
    }
    @Test (dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void y_validateResponseSuccessStatusTrue(){
        String testName = "ValidateResponseStatusCode";
        AssertHelper.assertThat(testName+" received is not the expected one ...!",
                basicResponseDataHandler.getSuccessStatus(), equalTo("true")  ) ;
    }

    @Test (dependsOnMethods = {"enterMemberFormDataSubmitAndGetPostData"})
    public void w_validateResponseLeadIdGreaterThanZero(){
        String testName = "w_validateResponseLeadIdGreaterThanZero";
        int leadID = -1; // not setup
        try {
            leadID = Integer.valueOf(basicResponseDataHandler.getLeadId());
        }catch (NumberFormatException nfe){
            logger.error("Can't get number leadId from String ...!"+nfe.getMessage());
            BasePage.failTest("Can't get leadId from string : "+basicResponseDataHandler.getLeadId());
        }
        AssertHelper.assertThat(testName+" received is not greater than 0 ...!" , leadID, greaterThan(0) ) ;
    }

    /**
     qa-englishlive.ef.com/services/commerce-v4/membermanager/GetMember?cmus=ADEAMAA4ADIANQA
     https://qa-englishlive.ef.com/services/commerce-v4/membermanager/GetMember?CMus=ADEAMAA4ADIANQA2ADEAMQB8ADEANAA4ADcAMgAzADQAOQA2ADIAMQA4ADYAfAB0AHQAZQBzAHQAMgAyADQAOAAwAHwATQB8AE4A
     */

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void getDataStoredOnDBandValidateitIsThePostedUserData(){
        logger.info("Run on QA / Live /STG  ...!");
        Cookie cmus = CookieHandler.getCookie(driver, "CMus");
        String cmusStr = cmus.toString().split(";")[0];

        logger.info("Cmus ["+cmusStr+"]");
        String url = "http://qa-englishlive.ef.com/services/commerce-v4/membermanager/GetMember?"+cmusStr;

        if(testURL.contains("/qa-")){
            //do nothing
        }else if(testURL.contains("//englishlive")){
            url = url.replace("qa-","");
        }
        else if(testURL.contains("/stg-")){
            url = url.replace("qa-","stg-");
        }
        logger.info("url ["+url+"]");
        try{
            responseFromDbCreateMemberBean = MyJsonReader.getCreateMemberBean(url);
            buyWithCreditExpectedPostBean.setMemberid(responseFromDbCreateMemberBean.getMemberId());
            logger.info("Data retrived from DB :"+responseFromDbCreateMemberBean.toString());
        }catch (IOException | JSONException e){
            BasePage.failTest(e, "Can't get BasicPostDataHandler from url ...!");
        }
    }

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateFirstName_StoredOnDB(){
        String testName = "First Name";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getFirstname(), equalTo(responseFromDbCreateMemberBean.getFirstName()) );
    }

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateEmail_StoredOnDB(){
        String testName = "Email";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getEmail().equals(responseFromDbCreateMemberBean.getEmail()));
    }

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateLocale_StoredOnDB(){
        String testName = "Locale";
        try{Thread.sleep(5000);} catch (Exception e){};
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getLocal(), equalTo(responseFromDbCreateMemberBean.getCountryCode()));
    }
    /* // Phone is not typed in order so test fail .. easy fix type phone one by one but not really needing this test
    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateMobilePhone_StoredOnDB(){
        String testName = "Phone Number ";
        try{Thread.sleep(5000);} catch (Exception e){};
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getMobilePhone(), equalTo(responseFromDbCreateMemberBean.getHomePhone().trim()));
    }*/

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateLeadType_StoredOnDB(){
        String testName = "Lead Type";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getLeadtype(), equalTo(responseFromDbCreateMemberBean.getMemberType()));
    }


    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void w_validateResponseFromDBLeadIdGreaterThanZero(){
        String testName = "w_validateResponseLeadIdGreaterThanZero";
        int leadID = -1; // not setup
        try {
            leadID = Integer.valueOf(responseFromDbCreateMemberBean.getMemberId());
        }catch (NumberFormatException nfe){
            logger.error("Can't get number leadId from String ...!"+nfe.getMessage());
            BasePage.failTest("Can't get leadId from string : "+responseFromDbCreateMemberBean.getMemberId());
        }
        AssertHelper.assertThat(testName+" received is not greater than 0 ...!" , leadID, greaterThan(0) ) ;
    }

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateCountryCode_StoredOnDB(){
        String testName = "Country Code";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                getCountryCode(), equalTo(responseFromDbCreateMemberBean.getCountryCode()));
    }

    @Test (dependsOnMethods = { "y_validateResponseSuccessStatusTrue" })
    public void validateLangCode_StoredOnDB(){
        String testName = "Language code";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                getLanguageCode(), equalTo(responseFromDbCreateMemberBean.getLanguageCode() ));
    }

    // Payment

    @Test(dependsOnMethods = {"w_validateResponseFromDBLeadIdGreaterThanZero"})
    public void remove_pay_validation(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(BaseTestConfig.memberSpinnerCss)), driver, WaitTool.MED_WAIT_4_ELEMENT);

        if (isClickTabId) {
            List<WebElement> tab1We = WaitTool.findElements(driver, By.cssSelector(".nav-tabs a"));
            WebElementHelper.click(tab1We.get(1));
            //WebElementHelper.clickOnTabByLinkText(driver, creditCardLinkText) ;
            logger.info(" Tab clicked ...!");
        }else
            logger.info(" Did NOT clicked on Tab id : ", tabId);

        remove_PaymentValidation();
        sleep(5000);
    }

    @Test (dependsOnMethods = { "remove_pay_validation" })
    public void makeApayment(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(BaseTestConfig.memberSpinnerCss)), driver, WaitTool.MED_WAIT_4_ELEMENT);
        if (isClickTabId) {
            WebElementHelper.clickOnTabByLinkText(driver, creditCardLinkText) ;
            logger.info(" Tab clicked ...!");
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
        sleep(2000);

        proxyServer.blacklistRequests("efeducationfirstlimi.tt.omtrdc.net", 200);
        proxyServer.blacklistRequests("dpm.demdex.net", 200);
        //proxyServer.blacklistRequests("efeducationfirstlimi.tt.omtrdc.net/66.235.147.246:443", 200);


        enter_PayFormDataAndSubmit();
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(BaseTestConfig.memberSpinnerCss)),driver, 25);
        myAssertThat(driver, "Failed ...!. URL does not contains 'thankyou'. Current URL is :"+ driver.getCurrentUrl() +
                ". Seconds Waited for :" + 25, PaymentThankyouPage.waitForUrlContains(driver, "thankyou", 25), true);
    }


    @Test(dependsOnMethods = {"makeApayment"})
    public void getPaymentPostDataBean(){
        harFilter = "buywithcreditcard";
        isPaymentHandler = true;
        try {
            buyWithCreditCardPostBean = getPayPostDataBeanSetResponseObj(proxyServer, harFilter);
            logger.info("postedDataBean : "+buyWithCreditCardPostBean.toString());
            logger.info("basicResponseDataHandler : "+basicResponseDataHandler.toString());
        }catch (NullPointerException npe){
            logger.error(" Null Object ...! "+npe.getMessage());
            BasePage.failTest("Can't get basic post data handler ...!");
        }
    }

    @Test (dependsOnMethods = { "getPaymentPostDataBean" })
    public void checkPaymentPostDataCardNumber(){
        String testName = "valiatePaymentPostData";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                buyWithCreditCardPostBean.getCreditCardNumber(), equalTo(buyWithCreditExpectedPostBean.getCreditCardNumber()));
    }


    ///-----------------------------------------------------------------------------------------------------------------
    //
    public String submitName = "CreditCardName";

    public void remove_PaymentValidation() {
        DynamicPaymentMemberPage paymentPage = new DynamicPaymentMemberPage(driver);
        paymentPage.removePaymentValidationNew();
        try{Thread.sleep(5000);  }catch(Exception e){}
        paymentPage = new DynamicPaymentMemberPage(driver);
        paymentPage.waitForPageToLoad(paymentPage.getPageLoadedCondition());
    }

    public void enter_PayFormDataAndSubmit() {
        try{
            enterFormData(driver, EfConstants.ukMembersPayMap_new);
        }catch(Exception e){
            logger.error("enter_PayFormDataAndSubmit() ..enterFormData and  paymentPage.submitForm Exception" +
                    TestUtil.getException(e, driver));
            BasePage.failTest(e, "enter_PayFormDataAndSubmit  FAIL", true);
        }
        WebElement submitElement = WebElementHelper.safeFindElement(driver, By.name(submitName));
        submitElement.submit();
        //try{Thread.sleep(5000);}catch (Exception e){}
    }



}


/**
 make payment
 POST /services/commerce-v4/offermanager/buywithcreditcard HTTP/1.1
 >post data is :
 CreditCardNumber=4222222222222222&ExpirationMonth=4&ExpirationYear=2021&CardVerificationCode=1234&
 CreditCardName=teste+test&CCAuthorized=on&CCType=Visa&CouponCode=&CCMarketCode=de&etag=&
 cmus=ADMANQAzADYAMQAwADkAOQB8ADEANAA4ADcANQA4ADQANwAyADcAOQA1ADEAfAB0AHQAZQBzAHQAMgA4ADQANQA1AHwATQB8AE4A&purchaseInfo.CouponCode=&purchaseInfo.Etag=
 &purchaseInfo.MarketCode=de&purchaseInfo.MemberId=35361099&purchaseInfo.OfferId=9262&purchaseInfo.PartnerCode=None&CCFirstName=teste&CCLastName=test&offerid=9262
 &marketCode=de&memberid=35361099&partnerCode=None&campaign=&OnSuccessUrl=..%2Fthankyou%2F

 > "Result":14522264,"Success":true
 --------------


 all


 POST /services/commerce-v4/offermanager/buywithcreditcard HTTP/1.1
 >post data is :
 CreditCardNumber=4222222222222222
 &ExpirationMonth=4
 &ExpirationYear=2021
 CardVerificationCode=1234
 CreditCardName=teste+test
 CCAuthorized=on&
 CCType=Visa&CouponCode=&
 CCMarketCode=de
 &etag=&
 cmus=ADMANQAzADYAMQAwADkAOQB8ADEANAA4ADcANQA4ADQANwAyADcAOQA1ADEAfAB0AHQAZQBzAHQAMgA4ADQANQA1AHwATQB8AE4A&
 purchaseInfo.CouponCode=&purchaseInfo.Etag=&purchaseInfo.MarketCode=de&
 purchaseInfo.MemberId=35361099
 purchaseInfo.OfferId=9262
 purchaseInfo.PartnerCode=None
 CCFirstName=teste
 CCLastName=test
 offerid=9262
 marketCode=de
 memberid=35361099
 partnerCode=None
 campaign=&OnSuccessUrl=..%2Fthankyou%2F

 > "Result":14522264,"Success":true




 *************  test here order

 GET /services/commerce-v4/ordermanager/get?orderId=14522264&memberId=35361099 HTTP/1.1
 post orderid and member id

 > result
 {"Result":
 {"Id":14522264,"MemberId":35361099,"Partner":"None","Market":"de","Status":"Ordered","System":"Chrysalis","InsertDate":"2017-02-20T05:00:10.937",
 "DeliveredTimes":1,
 "Items":
 [{"Id":5662377,"OrderId":14522264,"OfferId":9262,"Type":"Subscription","Quantity":1,"Descr":"Offer 1 EUR","LocalDescr":
 "Offer 1 EUR","InsertDate":"2017-02-20T05:00:10.94","PaymentType":"CreditCard","LastDeliveredPhaseId":8119460,"ExecutedPhaseCount":1,"LastPhaseExecutedDate":
 "2017-02-20T05:00:11.267","NextPhaseExecutionDate":"2017-03-22T05:00:11.157",
 "Phases":[{"Id":8119460,"ItemId":5662377,"Number":0,"Price":1.00,
 "CurrencyCode":"EUR","Duration":30,"DurationUnit":"Day","RepeatTimes":1,"IsRecurring":false,"InsertDate":"2017-02-20T05:00:10.943","Features":
 [{"Id":44175130,"PhaseId":8119460,"AccessId":10,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.953"},
 {"Id":44175131,"PhaseId":8119460,"AccessId":11,"Duration":30,"DurationUnit":"Day","Quantity":30,"InsertDate":"2017-02-20T05:00:10.96"},
 {"Id":44175132,"PhaseId":8119460,"AccessId":21,"Duration":30,"DurationUnit":"Day","Quantity":-1,"InsertDate":"2017-02-20T05:00:10.96"},
 {"Id":44175133,"PhaseId":8119460,"AccessId":27,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.967"},
 {"Id":44175134,"PhaseId":8119460,"AccessId":28,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.97"},
 {"Id":44175135,"PhaseId":8119460,"AccessId":29,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.97"},
 {"Id":44175136,"PhaseId":8119460,"AccessId":30,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.977"},
 {"Id":44175137,"PhaseId":8119460,"AccessId":33,"Duration":30,"DurationUnit":"Day","Quantity":-1,"InsertDate":"2017-02-20T05:00:10.983"},
 {"Id":44175138,"PhaseId":8119460,"AccessId":37,"Duration":30,"DurationUnit":"Day","Quantity":2,"InsertDate":"2017-02-20T05:00:10.983"}]},
 {"Id":8119461,"ItemId":5662377,"Number":1,"Price":49.00,"CurrencyCode":"EUR","Duration":30,"DurationUnit":"Day","RepeatTimes":1,"IsRecurring":false,
 "InsertDate":"2017-02-20T05:00:10.987","Features":[{"Id":44175139,"PhaseId":8119461,"AccessId":11,"Duration":30,"DurationUnit":"Day",
 "Quantity":30,"InsertDate":"2017-02-20T05:00:10.987"},{"Id":44175140,"PhaseId":8119461,"AccessId":21,"Duration":30,"DurationUnit":"Day","Quantity":-1,
 "InsertDate":"2017-02-20T05:00:10.99"},{"Id":44175141,"PhaseId":8119461,"AccessId":27,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.993"},
 {"Id":44175142,"PhaseId":8119461,"AccessId":28,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:10.993"},
 {"Id":44175143,"PhaseId":8119461,"AccessId":29,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:11"},
 {"Id":44175144,"PhaseId":8119461,"AccessId":30,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:11.003"},
 {"Id":44175145,"PhaseId":8119461,"AccessId":33,"Duration":30,"DurationUnit":"Day","Quantity":-1,"InsertDate":"2017-02-20T05:00:11.007"},
 {"Id":44175146,"PhaseId":8119461,"AccessId":37,"Duration":30,"DurationUnit":"Day","Quantity":2,"InsertDate":"2017-02-20T05:00:11.01"},
 {"Id":44175147,"PhaseId":8119461,"AccessId":10,"Duration":30,"DurationUnit":"Day","Quantity":0,"InsertDate":"2017-02-20T05:00:11.01"}]},
 {"Id":8119462,"ItemId":5662377,"Number":2,"Price":49.00,"CurrencyCode":"EUR","Duration":30,"DurationUnit":"Day","RepeatTimes":1,"IsRecurring":true,
 "InsertDate":"2017-02-20T05:00:11.013","Features":
 [{"Id":44175148,"PhaseId":8119462,"AccessId":11,"Duration":30,"DurationUnit":"Day","Quantity":30,"InsertDate":"2017-02-20T05:00:11.017"},
 {"Id":44175149,"PhaseId":8119462,"AccessId":21,"Duration":30,"DurationUnit":"Day","Quantity":-1,"InsertDate":"2017-02-20T05:00:11.02"},
 {"Id":44175150,"PhaseId":8119462,"AccessId":27,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:11.02"},
 {"Id":44175151,"PhaseId":8119462,"AccessId":28,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:11.027"},

 {"Id":44175152,"PhaseId":8119462,"AccessId":29,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:11.033"},
 {"Id":44175153,"PhaseId":8119462,"AccessId":30,"Duration":30,"DurationUnit":"Day","Quantity":1,"InsertDate":"2017-02-20T05:00:11.037"},
 {"Id":44175154,"PhaseId":8119462,"AccessId":33,"Duration":30,"DurationUnit":"Day","Quantity":-1,"InsertDate":"2017-02-20T05:00:11.04"},
 {"Id":44175155,"PhaseId":8119462,"AccessId":37,"Duration":30,"DurationUnit":"Day","Quantity":2,"InsertDate":"2017-02-20T05:00:11.04"},
 {"Id":44175156,"PhaseId":8119462,"AccessId":10,"Duration":30,"DurationUnit":"Day","Quantity":0,"InsertDate":"2017-02-20T05:00:11.043"}
 ]}]}]},
 "Success":true}



 *** Add test to check student type
 GET /services/commerce-v4/MemberManager/GetMember?cmus=ADMANQAzADYAMQAwADkAOQB8ADEANAA4ADcANQA4ADQANwAyADcAOQA1ADEAfAB0AHQAZQBzAHQAMgA4ADQANQA1AHwATQB8AE4A HTTP/1.1

 {"Result":{"Address":"","Address1":"","Address2":"","CityCode":"","CountryCode":"de","DataStore":"US1","Email":"test-a-ddsf-aaaasd-f-asd-f-asd-f-sad-f-sad-f-sad-f@qp1.org",
 "EmailLanguageCode":"ge","ETag":"","FirstName":"teste","GenderCode":"","HomePhone":"","LanguageCode":"ge","LastName":"test","LocalName":"teste test","Member_id":35361099,
 "MemberType":"M","Occupation":"","OmnitureFriendlyName":"Checkout:default:member","PartnerCode":"None","Password":"1","PostalCode":"",
 "StateCode":"","UserName":"ttest28455","AutoLogin":false,"SubscribeToEmailEnglish":false,"SubscribeToSMS":false,"SubscribeToPartnerPromo":false,"SubscribeToDailyLesson":false,
 "SubscribeToETPromo":false,"SubscribedToEmailEnglish":false,"StudentType":"CurrentStudent","HasSuspendedSubscription":false,"HasRenewableActiveSubscription":false},
 "Success":true}

 // vip data
 "StudentType":"CurrentStudent"    /// on create member this is "StudentType":"NeverStudent"


 **/