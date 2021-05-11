package com.englishtown.tests.checkout.common.validation;
/**
 * Create member and Check validation messages on pay page
 *
 */
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseDDPaymentPageNegativeTest extends BaseCheckoutNegativeTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseDDPaymentPageNegativeTest.class);

    @Test
    public void createMember(){
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),
                getWebDriver(), 25);
        create_Member(formDataMap);
        sleep(1000);
    }

    @Test (dependsOnMethods ={"createMember"} )
    public void submitDDpay(){
        click(getWebDriver(), By.cssSelector(payDdWeCss) );
    }

    @Test (dependsOnMethods ={"submitDDpay"} )
    public void assertBankCodeValidationMessage(){
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(formErrorSelector), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        sleep(1000);
    }

    @Test (dependsOnMethods ={"assertBankCodeValidationMessage"} )
    public void clickTabCreditCard(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(3000);
        if (isClickTabId) {
            findElement(By.cssSelector(paymentTabsListCss));
            WebElementHelper.scrollToElementLocation(getWebDriver(),findElement(By.cssSelector(paymentTabsListCss)),0,300);
            WebElementHelper.clickOnTabId(getWebDriver(), By.cssSelector(paymentTabsListCss), tabId);
            logger.info(" Tab clicked ...!");
        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
    }

    @Test (dependsOnMethods ={"clickTabCreditCard"} )
    public void submitCCpay(){
        click(getWebDriver(), By.cssSelector(submitCCbuttonSelector) );
    }

    @Test (dependsOnMethods ={"submitCCpay"} )
    public void assertCreditCardValidationMessage(){
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(formErrorSelector), WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    @Test (dependsOnMethods ={"submitCCpay"} )
    public void remove_pay_validation(){
        remove_PaymentValidation();
        JavaScriptHelper.waitForPageLoaded(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT );
        logger.info("Go to sleep ....!");
    }

    @Test (dependsOnMethods ={"remove_pay_validation"} )
    public void enterCCdetailsBlankNameSubmitAndCheckValidationMsgShown(){
        enterFormData(EfConstants.ukMembersPayMap_new);
        enterFormData(EfConstants.CC_FULLNAME_BLANKSPACE);
        try{Thread.sleep(500);}catch(Exception e){}
        // submitCCpay();
        submitPaymentForm();
        try{Thread.sleep(500);}catch(Exception e){}
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(formErrorSelector), 3);
    }

    @Test (dependsOnMethods ={"remove_pay_validation"} )
    public void enterCCdetailsNoSpacesInNameCheckValidationMsgShown(){
        enterFormData(EfConstants.CC_FULLNAME_NO_SPACE);
        try{Thread.sleep(500);}catch(Exception e){}
        submitPaymentForm();
        try{Thread.sleep(3000);}catch(Exception e){}
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(formErrorSelector), 3);
    }



}

