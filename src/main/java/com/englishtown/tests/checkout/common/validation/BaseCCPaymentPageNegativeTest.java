package com.englishtown.tests.checkout.common.validation;
/**
 * Create member and Check validation messages on pay page
 *
 */
import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCCPaymentPageNegativeTest extends BaseCheckoutNegativeTest implements IPaymentPageNegativeTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseCCPaymentPageNegativeTest.class);

    @Test
    public void createMemberTest(){
        create_Member();
    }

    @Test (dependsOnMethods ={"createMemberTest"} )
    public void clickTabCreditCard(){
        clickOnPaymentPageTab(tabId);
    }

    @Test (dependsOnMethods ={"clickTabCreditCard"} )
    public void submitCCpay(){
        remove_PaymentValidation();
        submitPaymentPage();
    }

    @Test (dependsOnMethods ={"submitCCpay"} )
    public void checkCreditCardNumberErrorShownAndNotBlank(){
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(formErrorSelector), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        sleep(1000);
    }

    @Test (dependsOnMethods ={"checkCreditCardNumberErrorShownAndNotBlank"} )
    public void isCcCardErrorMessageShown(){
        isCcCard_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isCcCardErrorMessageShown"} )
    public void isNameErrorMessageShown(){
        isName_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isNameErrorMessageShown"} )
    public void isMonthMessageShown(){
        isMonth_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isMonthMessageShown"} )
    public void isYearMessageShown(){
        isYear_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isYearMessageShown"} )
    public void isCodeMessageShown(){
        isCode_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isCodeMessageShown"} )
    public void isAuthoriseMessageShown(){
        isAuthorise_ErrorMessageShown();
    }


    /*
    @Test (dependsOnMethods ={"assertCreditCardValidationMessageNotEmptyOrNull"} )    public void remove_pay_validation(){        remove_PaymentValidation();        JavaScriptHelper.waitForPageLoaded(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT );        logger.info("Go to sleep ....!");    }
     //TODO
    @Test (dependsOnMethods ={"remove_pay_validation"} )
    public void enterCCdetailsNoSpacesInNameCheckValidationMsgShown(){
        enterFormData(EfConstants.CC_FULLNAME_NO_SPACE);
        try{Thread.sleep(500);}catch(Exception e){}
        submitPaymentForm();
        try{Thread.sleep(3000);}catch(Exception e){}
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(formErrorSelector), 3);
    }
*/


}

