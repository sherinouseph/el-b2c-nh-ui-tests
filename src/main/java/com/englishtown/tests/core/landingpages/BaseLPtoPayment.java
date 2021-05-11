package com.englishtown.tests.core.landingpages;

import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.common.BaseEnterFormDataAndSubmit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;

/**
 * 2017
 * Nikol
 *
 * Base Class for all LP to payment test
 *
 */
public abstract class BaseLPtoPayment extends BaseEnterFormDataAndSubmit {    //BaseTestHelper{ //BaseEnterFormDataAndSubmit {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestHelper.class);


    /*@Test
    protected void enterFormDataTest() {
        if (isPopupShown) {            // need to click to remove pop up            //click(getWebDriver(), By.cssSelector(".pagination-left .cq-dd-image") ); //this.click( getWebDriver().findElement( By.cssSelector(".pagination-left .cq-dd-image")) );
            waitForElementAndclickAtXY(By.className("modal-dialog"), 5, 5);
            sleep(500);// clickAtWindow(getWebDriver(), 1, 1);            sleep(1000);
            logger.info(" POP up should be closed ...!");
        }
        if (isUseCssEnterFormData) {
            enterFormDataCss(formDataMap);
        } else
            enterFormData(formDataMap);
    }                                                                                                                        //    @Test (dependsOnMethods = { "enterOeFormdata" }) protected void verifyTheNumberOfFormElement(){ assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);}

    @Test(dependsOnMethods = {"enterFormDataTest"})
    protected void submitFormTest() {
        logger.info("Call click to submit form ....!");
        click(By.cssSelector(submitBtn));
    }*/


    @Test(dependsOnMethods = {"submitFormTest"})
    protected void verifyAtPaymentPageUrl() {
        myAssertThat(getWebDriver(),
                "Failed Test : verifyAtPaymentPage. urls does not contain the expected text '...!' ",
                BasePage.waitForUrlContains(this.getWebDriver(), urlContainsPayment, 25), is(true), true);                                         //        assertThat("Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",  BasePage.waitForUrlContains(this.getWebDriver(),//                        this.thankyou_page_url_contains, 15), is(true));
    }

    @Test(dependsOnMethods = { "verifyAtPaymentPageUrl" })
    protected void verifyPaymentPageTrackingDotEvents(){
        assertPaymentPageTrackingEvents();
    }

    @Test(dependsOnMethods = {"verifyPaymentPageTrackingDotEvents"})
    protected void assertStateObjectMemberIdCreatedTest() {
        if(isNewhousePayment)
            assertStateObjectEfIdCreated();
        else
            assertStateObjectMemberIdCreated();
    }

    @Test(dependsOnMethods = {"verifyPaymentPageTrackingDotEvents"})
    public void isLeadType() {
        if(formTypeValue=="member"){//isNewhousePayment && //https://jira.eflabs.io/browse/SAND-7478, Axel said it is ok to consider os submission as member in OH{
            logger.info("Check form type is [" + formTypeValue + "]");
            assertStateObjectElementValue(formTypeKey, formTypeValue, true);
        }else {
            logger.info("Check lead type is [" + formLeadTypeValue + "]");
            assertStateObjectElementValue(formLeadTypeKey, formLeadTypeValue, false);
        }
    }

    @Test(dependsOnMethods = "verifyPaymentPageTrackingDotEvents")
    void validate_is_FirstLastNamePersisted(){
        if(!is_adyenPayment)
        isFirstLastNamePersisted( getWebDriver(), scriptGetCCName, FULL_NAME);
    }

}