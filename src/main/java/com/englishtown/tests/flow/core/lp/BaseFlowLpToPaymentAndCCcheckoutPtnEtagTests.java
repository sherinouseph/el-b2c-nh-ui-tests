package com.englishtown.tests.flow.core.lp;
/**
 * Test ptn and etag
 *
 */



import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;




public abstract class BaseFlowLpToPaymentAndCCcheckoutPtnEtagTests extends BaseFlowOsToPayment {
    private static final Logger logger = LoggerFactory.getLogger(BaseFlowLpToPaymentAndCCcheckoutPtnEtagTests.class);


    @Test
    public void enterFormTestData(){
        enterFormData(lpFormData);
        setUserEmail(lpFormData.get("email").toString());
    }

    @Test(dependsOnMethods = "enterFormTestData")
    public void submitForm(){
        click(getWebDriver(), By.cssSelector(submitBtnCss));
        sleep(2000);
    }

    @Test(dependsOnMethods = "submitForm")
    public void isPaymentForm(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        isPaymentUrlWithWait("payment", WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(navPayTabsCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }
    @Test(dependsOnMethods = "isPaymentForm")
    public void clickCCtab(){
        WebElementHelper.clickOnTabByLinkText(getWebDriver(), creditCardLinkText_DE) ;
    }

    @Test(dependsOnMethods = "clickCCtab")
    public void removePaymentValidation() {
        remove_PaymentValidation();
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "removePaymentValidation")
    public void enterPaymentDetails(){
        WebElement ccNameWe = findElement(By.id("CreditCardName"));
        WebElementHelper.sendKeys(getWebDriver(), ccNameWe, "Test NameCC", true);        //ccNameWe.sendKeys();
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(2000);  }catch(Exception e){}
    }

    @Test(dependsOnMethods = "enterPaymentDetails")
    public void check_ThankyouPage(){                                                                                   // CommonTestHelper.checkPaymentThankyouPage(thankyouPage, getWebDriver(), urlContainsThankyou, WaitTool.MED_WAIT_4_ELEMENT25);
        assertIsPaymentThankyou("thankyou");
    }

    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void checkTYPage_stateObject_Events__OfferId_MemberId_NotBlank(){
        if(BaseRemoteWebDriver.isMobileDevice){
            logger.warn("Is mobile device, Test not run testThankyouPageStateObject()...! ");
        } else {
            assertThankyouPageStateObjectElementsNewCheckout();
            testUtil.takeScreenshot(TestUtil.generateRandomFilename("NewChecoutOffer_" + this.getClass().getSimpleName() + "_"), getWebDriver(), false);
        }
    }

    @Test(dependsOnMethods = "checkTYPage_stateObject_Events__OfferId_MemberId_NotBlank")
    public void isPtnOnSessionStateObject(){
        assertStateObjectParnterCode(stoPtnKey, stoPtnValue);
    }

    @Test(dependsOnMethods = "checkTYPage_stateObject_Events__OfferId_MemberId_NotBlank")
    public void isEtagOnSessionStateObject(){                                                                                   // CommonTestHelper.checkPaymentThankyouPage(thankyouPage, getWebDriver(), urlContainsThankyou, WaitTool.MED_WAIT_4_ELEMENT25);
        assertStateObjectEtag(stoEtagKey, stoEtagValue);
    }

    @AfterClass
    public void cancelSubscription(){
        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            cancelUserSubscription(getUserEmail());
        } else {
            logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
        }
    }


}
