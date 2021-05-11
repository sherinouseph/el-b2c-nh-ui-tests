package com.englishlive.tests.checkout.newcheckout.core.worldpay.core;
/**
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.isEmptyString;


public abstract class BaseNegativeWorldPayTest extends BaseWorldPay {
    private static final Logger logger = LoggerFactory.getLogger(BaseNegativeWorldPayTest.class);

    protected String errorMsgCss = ".message.alert.alert-danger:first-of-type";
    protected String errorMsgContains = "orldpay payment failed";

    @Test
    public void enterMemberDetails(){
        logger.info("start enterMemberDetails ....!");
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), 25);
        enterFormData(formDataMap);
        enterEmail(getWebDriver(), true);
    }

    @Test(dependsOnMethods = { "enterMemberDetails" })
    public void submitMemberForm() {
        click(getWebDriver(), By.cssSelector(memberPageSubmitBtnCss) );
    }


    @Test(dependsOnMethods = {"submitMemberForm"})
    public void clickTabAndSwitchFrame(){
        clickPayTabAndSwitchFrame(creditCardLinkText, payFrameId, By.cssSelector(iFrameSelector), 25 );
    }

    @Test(dependsOnMethods = {"clickTabAndSwitchFrame"})
    public void enterPaymentDetails(){
        logger.info("start enterPaymentDetails ....!");
        enterFormData(paymentCardDetails);
    }

    @Test(dependsOnMethods = {"enterPaymentDetails"})
    public void submitPayment(){
        logger.info("start submitPayment ....!");
        click(getWebDriver(), By.id(SUBMMIT_PAYMENNT_ID));
        sleep(5000);
    }

    @Test(dependsOnMethods = {"submitPayment"})
    public void isPayFailedMessage(){
        logger.info("start isPayFailedMessage ....!");
        //WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(errorMsgCss), 20, 1000);
        WebElement errMsgWe = findElement(By.cssSelector(errorMsgCss));        //try { logger.info(" errMsWE list lize : " + errMsgWe.size());      }catch (IndexOutOfBoundsException e){ logger.info("Can't get size of list element ....!"+e.getMessage());}
        if(errMsgWe == null){
            failTest("Error message web element is not shown/found ...! Css ["+errorMsgCss+"]");
        }else {
            AssertHelper.myAssertThat(getWebDriver(), "Error message is not the expected one ...!",
                    getText(errMsgWe), containsString(errorMsgContains), true);
        }
    }

    @Test(dependsOnMethods = {"isPayFailedMessage"})
    public void switchDriverToPayFrame(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss) ),getWebDriver(), 25);
        switchToPayFrame(creditCardLinkText, payFrameId, By.cssSelector(iFrameSelector), 15 );
    }

    @Test(dependsOnMethods = {"switchDriverToPayFrame"})
    public void isCardNumberTxtFieldClearedAndEmpty(){
        logger.info("Form should ber refreshed and empty ... no data on text field...!");
        WebElement cardNumberWe = findElement(By.id("cardNumber"));
        AssertHelper.myAssertThat(getWebDriver(), "Pay form Card number text field should be cleared and empty ...!",
                getText(cardNumberWe),isEmptyString()  ,true);     // Note getText return "" on element that got no text
    }

}
