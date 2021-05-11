package com.englishtown.tests.core.landingpages;

import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseLandingPageTest;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;

/**
 * 2017
 * Nikol
 *
 * Base Class for all OE test
 *
 */
public abstract class BaseOETest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestHelper.class);



    @Test
    protected void enterFormData() {
        if (isPopupShown) {            // need to click to remove pop up            //click(getWebDriver(), By.cssSelector(".pagination-left .cq-dd-image") ); //this.click( getWebDriver().findElement( By.cssSelector(".pagination-left .cq-dd-image")) );
            waitForElementAndclickAtXY(By.className("modal-dialog"), 5, 5);
            sleep(1000);// clickAtWindow(getWebDriver(), 1, 1);            sleep(1000);
            logger.info(" POP up should be closed ...!");
        }
        if (isUseCssEnterFormData) {
            this.enterFormDataCss(formDataMap);
        } else
            this.enterFormData(formDataMap);
    }                                                                                                                        //    @Test (dependsOnMethods = { "enterOeFormdata" }) protected void verifyTheNumberOfFormElement(){ assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);}

    @Test(dependsOnMethods = {"enterFormData"})
    protected void submitForm() {
        click(By.cssSelector(submitBtn));
    }

    @Test(dependsOnMethods = {"submitForm"})
    protected void verifyAtThankyouPage() {
        myAssertThat(getWebDriver(),
                "Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",
                BasePage.waitForUrlContains(this.getWebDriver(), this.urlContainsThankyou, 25), is(true), true);                                         //        assertThat("Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",  BasePage.waitForUrlContains(this.getWebDriver(),//                        this.thankyou_page_url_contains, 15), is(true));
    }

    @Test(dependsOnMethods = {"verifyAtThankyouPage"})
    protected void verifyThankyouPageStateObjectEvents() {
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }

    @Test(dependsOnMethods = {"verifyThankyouPageStateObjectEvents"})
    protected void verifyStateObjectLeadId() {
        assertThankyouPageStateObjectLpOeLeadId();
    }

    @Test(dependsOnMethods = {"verifyThankyouPageStateObjectEvents"})
    public void isLeadType() {
        logger.info("Check lead type is [" + formLeadTypeValue + "]");
        assertStateObjectElementValue(formLeadTypeKey, formLeadTypeValue, false);   // there is type as well ==
    }

}