package com.englishlive.tests.nogrid.proxy;

/**
 * Created by nikol.marku on 05/04/2016.
 *
 * Validate post data content is as expected
 *  and response content is the expected one .. true .. leadId>0 and success status
 *  and check DB data is stored in DB by sending a request and
 *  check the api call response e.g: http://qa-englishlive.ef.com/services/commerce-v4/leadsmanager/getbyemail?email=auto_1486741682154_xdelx@qp1.org
 *
 *  BasicLandingHandlerTest
 10.06 spassedBasicLandingHandlerTest.enterFormdataAndSubmit
 2 mspassedBasicLandingHandlerTest.validateEmail_PostData
 1 mspassedBasicLandingHandlerTest.validateFirstName_PostData
 0 mspassedBasicLandingHandlerTest.validateLeadType_PostData
 0 mspassedBasicLandingHandlerTest.validateLocale_PostData
 0 mspassedBasicLandingHandlerTest.x_validateResponseStatusCode
 0 mspassedBasicLandingHandlerTest.y_validateResponseSuccessStatusTrue
 2 mspassedBasicLandingHandlerTest.z_validateResponseLeadIdGreaterThanZero
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.bean.handler.EfFullDataBean;
import com.englishtown.helpers.reader.MyJsonReader;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;

import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;


public abstract class BaseLandingHandlerTest extends BaseProxyFactory {
    private static final Logger logger = LoggerFactory.getLogger(BaseLandingHandlerTest.class);


    @Test(timeOut = TEST_DEFAULT_TIMEOUT_MLS)
    public void enterFormDataSubmitAndGetPostData() {
        enterFormData(driver, testDataMap);
        if(isEnterPhoneNumber){
            WaitTool.waitForCondition( ExpectedConditions.elementToBeClickable(By.cssSelector(telephoneCss)), driver, 20 );
            WebElement phoneWe = findElement(driver, By.cssSelector(telephoneCss));
            WebElementHelper.sendKeyWithWait(phoneWe, telephoneValue, 100);
        }
        sleep(500);

        WebElementHelper.click(findElement(driver, By.cssSelector(submitBtnCss)));                                        //if(phoneWe !=null) phoneWe.submit();        //WebElementHelper.safeFindAndClick(driver, By.cssSelector(submitBtnCss));

        sleep(7000);
        if(isInlineTyMsg){
            AssertHelper.assertWebElementDisplayed(findElement(driver, By.cssSelector(inlineTyMsgCss)));
            String thankyouMsg = TestUtil.getWebElementText(findElement(driver, By.cssSelector(inlineTyMsgCss)));
            AssertHelper.myAssertThat(driver, "Not the expected TY msg ...!", thankyouMsg, containsString(thankYouMsgContains), true);
            logger.info("Thank you message shown ....! " + thankyouMsg);
        } else {
            BaseTestHelper.waitForUrlContains(driver, waitForUrlContains, 15);
            AssertHelper.assertThat("Is not the expected url after submitting ...!", TestUtil.getCurrentUrl(driver), containsString(waitForUrlContains));
        }
        // delay the test to make sure response returned
        try{
            logger.info("starttime : "+System.currentTimeMillis());
            sleep(1000);
            WaitTool.isElementPresentAndDisplay(driver, By.cssSelector(".btn-blockDontfindme"));
            logger.info("endtime : "+System.currentTimeMillis());
        }catch (Exception e){}


        try {
            postedDataBean = new EfFullDataBean();
            postedDataBean = getFullDataBeamAndSetResponseObj(proxyServer, harFilter);
            if(postedDataBean != null) {
                logger.info("postedDataBean : " + postedDataBean.toString());
            }else BaseTest.failTest("Can not get har from request ....! ... Null har ...! ");
        }catch (NullPointerException npe){
            npe.printStackTrace();
            logger.error(" Null Object ...! "+npe.getMessage());
            BasePage.failTest("Can't get basic post data handler ...!");
        }
    }

    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
    public void validateFirstName_PostData(){
        String testName = "First Name";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                postedDataBean.getFirstname(), equalTo(expectedPostData.getFirstname()) );
    }

    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
    public void validateEmail_PostData(){
        String testName = "Email";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getEmail(), equalToIgnoringCase(postedDataBean.getEmail()));
    }

    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
    public void validateLocale_PostData(){
        String testName = "Locale";
        try{Thread.sleep(5000);} catch (Exception e){};
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getLocal(), equalToIgnoringCase(postedDataBean.getLocal()));
    }

    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
    public void validateLeadType_PostData(){
        String testName = "Lead Type";
        if(isSubmitOeFormHandler) {
            AssertHelper.assertThat(testName + " posted is not the expected one ...!",
                    expectedPostData.getLeadtype(), equalToIgnoringCase(postedDataBean.getLeadtype()));
        } else { logger.info("There is no lead type for this request ... so this test is not checking it");}
    }

    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
    public void x_validateResponseStatusCode(){
        String testName = "ValidateResponseStatusCode";
        AssertHelper.assertThat(testName+" received is not the expected one ...!",
                basicResponseDataHandler.getResponseStatus(), equalTo(200)  ) ;
    }
    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
    public void y_validateResponseSuccessStatusTrue(){
        String testName = "ValidateResponseStatusCode";
        AssertHelper.assertThat(testName+" received is not the expected one ...!",
                basicResponseDataHandler.getSuccessStatus(), equalTo("true")  ) ;
    }

    @Test (dependsOnMethods = { "enterFormDataSubmitAndGetPostData" })
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

    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void getDataStoredOnDBandValidateitIsThePostedUserData(){
        logger.info("Run on QA / Live /STG  ...!");
        String url = "http://qa-englishlive.ef.com/services/commerce-v4/leadsmanager/getbyemail?email="+
                expectedPostData.getEmail();
        if(testURL.contains("/qa-")){
            //do nothing
        }else if(testURL.contains("//englishlive")){
            url = url.replace("qa-","");
        }
        else if(testURL.contains("/stg-")){
            url = url.replace("qa-","stg-");
        }

        try{
            logger.info("Get DB data URL is :"+url);
            responseFromDbDataBean = MyJsonReader.getFullPostDataHandlerFromUrl(url);
            logger.info("Data retrived from DB :"+responseFromDbDataBean.toString());
        }catch (IOException | JSONException e){
            BasePage.failTest(e, "Can't get BasicPostDataHandler from url ...!");
        }
        //AssertHelper.assertThat(expectedPostData, samePropertyValuesAs(responseFromDbDataBean) );
    }

    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void validateFirstName_StoredOnDB(){
        String testName = "First Name";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getFirstname(), equalTo(responseFromDbDataBean.getFirstname()) );
    }

    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void validateEmail_StoredOnDB(){
        String testName = "Email";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getEmail().equals(responseFromDbDataBean.getEmail()));
    }

    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void validateLocale_StoredOnDB(){
        String testName = "Locale";
        try{Thread.sleep(5000);} catch (Exception e){};
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getLocal(), equalTo(responseFromDbDataBean.getLocal()));
    }

    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void validatePhone_StoredOnDB(){
        String testName = "Locale";
        try{Thread.sleep(5000);} catch (Exception e){};

        String phoneNoFromDBresponse = responseFromDbDataBean.getHomePhone();

        if(StringUtils.isBlank(phoneNoFromDBresponse) ){
            phoneNoFromDBresponse = responseFromDbDataBean.getMobilePhone();

            if(phoneNoFromDBresponse == null)
                BaseTest.failTest("Phone number is not the expected one ... it is null ...!");
        } else {
            phoneNoFromDBresponse = phoneNoFromDBresponse.replace("-", "");
            AssertHelper.assertThat(testName + " posted is not the expected one ...!",
                    phoneNoFromDBresponse, endsWith(expectedPostData.getMobilePhone()));
        }
    }

    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void validateLeadType_StoredOnDB(){
        String testName = "Lead Type";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                expectedPostData.getLeadtype(), equalTo(responseFromDbDataBean.getLeadtype()));
    }


    @Test (dependsOnMethods = { "w_validateResponseLeadIdGreaterThanZero" })
    public void w_validateResponseFromDBLeadIdGreaterThanZero(){
        String testName = "w_validateResponseLeadIdGreaterThanZero";
        int leadID = -1; // not setup
        try {
            leadID = Integer.valueOf(responseFromDbDataBean.getLead_id());
        }catch (NumberFormatException nfe){
            logger.error("Can't get number leadId from String ...!"+nfe.getMessage());
            BasePage.failTest("Can't get leadId from string : "+responseFromDbDataBean.getLead_id());
        }
        AssertHelper.assertThat(testName+" received is not greater than 0 ...!" , leadID, greaterThan(0) ) ;
    }


}



/*
assertThat(person, has(
                            property("firstName", equalTo("Another dude")), // Mistmatch
                            property("age", greaterThan(18)), // Use any matcher
                            property("lastName", equalTo("Mancuso"))));

    WebDriverWait wait = new WebDriverWait(driver, 20);
            if(isWaitForTyUrl) {
                    wait.until(ExpectedConditions.urlContains(waitForUrlContains));
                    driver.findElement(By.cssSelector(".btn-block"));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary.btn-block")));
                    }
*/