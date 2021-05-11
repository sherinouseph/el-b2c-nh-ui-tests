package com.englishlive.tests.checkout.newcheckout.core;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

/**
 * Created by nikol.marku on 25-May-17.
 *  Note this test will fail for QA as QA pay will not check/validate and will go to ty page
 *
 *
 * https://jira-bos.englishtown.com/browse/SAND-3897
 *
 As a Student on payment page
 When I enter card number 2221001234123450
 and move to next field
 Then cc number validation is green(passed)  [NOt tested as ::before tag added and not testable ]
 When I enter the rest of payment details with submit
 Then hidden filed input[name=CCType] value="MasterCard"
 */



public abstract class BaseCheckCCTypeCard extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckCCTypeCard.class);

    protected DynamicMemberPage memberPage;
    protected Map ddPayMap;
    protected String expectedCcTypeValue; // hidden field value

    @Test
    public void enterMemberFormDataAndSubmitAndCheckPayPageShown(){
        // when I enter form data and submit
        enterFormData(formDataMap); //EfConstants.deMembersFormMap);

        enterEmail(getWebDriver(), true);

        memberPage = new DynamicMemberPage(getWebDriver());
        memberPage.submit();
        // then payment page shown
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.isElementVisible(getWebDriver(), By.name("CreditCardName"), WaitTool.MED_WAIT_4_ELEMENT, 1000);
    }

    @Test(dependsOnMethods = "enterMemberFormDataAndSubmitAndCheckPayPageShown")
    public void enterCCpayDetailsAndSubmit(){
        // when I Enter payment details using CC number 2221001234123450
        enterFormData(EfConstants.MASTERCARD_TEST);
        // and submit form
        WaitTool.findElement(getWebDriver(), By.name("CreditCardName"));
        WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.name("CreditCardName"));
        submitElement.submit();
        sleep(1000);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = "enterCCpayDetailsAndSubmit")
    public void hiddenFieldCcTypeValueIsMasterCard(){
        // when I get hidden field
        JavaScriptHelper js = new JavaScriptHelper();
        String currentCctypeValue = js.getHidenFieldBy(getWebDriver(), "Name", "CCType", 15);
        logger.info("CCtypeValue ["+currentCctypeValue+"]");
        //then: "Hidden field CCType value is MasterCard"
        AssertHelper.myAssertThat(getWebDriver(), "CctypeValue is not MasterCard ...!",currentCctypeValue,
                equalToIgnoringCase(expectedCcTypeValue) , true);

    }




}
