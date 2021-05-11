package com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync;
/**
 * open OE landing page
 * fill form and submit
 * check stateobject(Lead id)
 * open salesforce
 * Check for the lead in salesforce
 *
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static com.englishtown.tests.core.EfConstants.TEST_MAIL_END_TOKEN;
import static com.englishtown.tests.core.EfConstants.currTime;
import static org.hamcrest.Matchers.is;

public abstract class BaseEELandingPageToSalesforceTest extends BaseSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseEELandingPageToSalesforceTest.class);
    protected LoginPage loginPage;
    protected String oeLandingPageUrl="https://qa-englishlive.ef.com/tr-tr/lp/oe/autotest-oeleadtosalesforce";


    @Test
    protected void openUrlAndEnterOeFormdata() {
        openUrl(getWebDriver(), testStartUrl);
        this.enterFormData(formDataMap);
        leadEmail = "auto_" + currTime + "_" +leadRecordType+ TestUtil.generateRandomString("", 5) + "_" + TEST_MAIL_END_TOKEN + "@qp1.org";
        logger.info("lead email is " + leadEmail);
        findElement(By.name("email")).sendKeys(leadEmail);
    }                                                                                                                        //    @Test (dependsOnMethods = { "enterOeFormdata" }) protected void verifyTheNumberOfFormElement(){ assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);}

    @Test(dependsOnMethods = {"openUrlAndEnterOeFormdata"})
    protected void submitOeFormTest() {
        findElement(By.name("age")).submit();
    }

    @Test(dependsOnMethods = {"submitOeFormTest"})
    protected void verifyAtThankyouPage() {
        myAssertThat(getWebDriver(),
                "Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",
                BasePage.waitForUrlContains(this.getWebDriver(),
                        "thank-you", 25), is(true), true);                                         //        assertThat("Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",  BasePage.waitForUrlContains(this.getWebDriver(),//                        this.thankyou_page_url_contains, 15), is(true));
    }

    @Test(dependsOnMethods = { "verifyAtThankyouPage" })
    protected void verifyThankyouPageStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }

    @Test(dependsOnMethods = { "verifyThankyouPageStateObjectEvents" })
    protected void verifyStateObjectLeadId(){
               assertThankyouPageStateObjectLpOeLeadId() ;
    }

    @Test(dependsOnMethods = { "verifyStateObjectLeadId"})
    protected void loginToSalesForceAndSearchLead() {
        openSalesForceAndlogin(salesForceAgentName, SALESFORCE_PASS);
        sleep(20000);
        sendKey(getWebDriver(), findElement(By.id("phSearchInput")), leadEmail, false);
        click(By.id("phSearchButton"));
    }

    @Test(dependsOnMethods = {"loginToSalesForceAndSearchLead"})
    protected void verifyLead() {
        logger.info("verify Lead type is "+leadType);
        verifyLeadType(leadType);
    }

}