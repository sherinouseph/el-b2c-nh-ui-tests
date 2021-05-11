package com.englishtown.tests.checkout.common;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.IWebDriverSetting;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.checkout.legacy.PaymentPage;
import com.englishtown.pages.forms.legacy.MemberForm;
import com.englishtown.pages.forms.legacy.PaymentForm;
import com.englishtown.tests.core.InteractiveCheckoutPageTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StandardPaymentPageTest
        extends InteractiveCheckoutPageTest<PaymentForm, PaymentPage> {

    private static final Logger logger = LoggerFactory.getLogger(StandardPaymentPageTest.class);

    private String testCreditCardExpiryMonth;
    private String testCreditCardExpiryYear;
    private String testCreditCardNumber;
    private String testCreditCardVerificationCode;
    private String pageUrl;


    public StandardPaymentPageTest(WebDriver webDriver, String testCreditCardExpiryMonth, String testCreditCardExpiryYear, String testCreditCardNumber, String testCreditCardVerificationCode, String pageUrl) {
        super(webDriver);
        this.testCreditCardExpiryMonth = testCreditCardExpiryMonth;
        this.testCreditCardExpiryYear = testCreditCardExpiryYear;
        if(StringUtils.containsIgnoreCase(getWebDriver().getCurrentUrl(), "//qa") ){
            this.testCreditCardNumber = "4111111111111111";
        }else
            this.testCreditCardNumber = testCreditCardNumber;
        this.testCreditCardVerificationCode = testCreditCardVerificationCode;
        this.pageUrl = pageUrl;
    }

    public String getTestCreditCardVerificationCode() {
        return testCreditCardVerificationCode;
    }

    public String getTestCreditCardNumber() {
        return testCreditCardNumber;
    }

    public String getTestCreditCardExpiryYear() {
        return testCreditCardExpiryYear;
    }

    public String getTestCreditCardExpiryMonth() {
        return testCreditCardExpiryMonth;
    }

    public void fillCreditCardForm() {
        PaymentPage page = this.getPage();
        page.disableCreditCardValidation();
        page.loadPage();
        webDriverSwitchToDefautContent();
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("[name=CreditCardNumber]"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        PaymentForm form = page.getForm();
        jsWindowFocus();
        WebElementHelper.focusOnElementUsingSendKeyOrAction(form.getCreditCardNumber().getWebElement(), getWebDriver());
        form.getCreditCardNumber().setTextValue(this.getTestCreditCardNumber());

        if(! BaseRemoteWebDriver.isBrowser("firefox")) {
            form.getCreditCardNumber().sendKeys("\t");
        }

        if( BaseRemoteWebDriver.isBrowser("chrome") || BaseRemoteWebDriver.isBrowser("firefox") || "10" == BaseRemoteWebDriver.browserVersion) {
            // use this for chrome as select is not working on chrome 43
            WebElementHelper.selectOptinUsingDownArrowKey(findElement(By.name("ExpirationMonth")), 3, Keys.ARROW_DOWN);
            form.getCreditCardExpirationMonth().sendKeys("\t");
            WebElementHelper.selectOptinUsingDownArrowKey(findElement(By.name("ExpirationYear")),3, Keys.ARROW_DOWN);
        }
        else {
            form.getCreditCardExpirationMonth().selectValue(this.getTestCreditCardExpiryMonth());
            sleep(1000);
            form.getCreditCardExpirationMonth().sendKeys("\t");
            /*if(BaseRemoteWebDriver.getCurrentBrowserName().contains("firefox")){
                clickAtWindow(getWebDriver(), 7, 7);
                //findElement(By.name("ExpirationMonth")).sendKeys(Keys.ENTER);
            }*/
            sleep(500);
            form.getCreditCardExpirationYear().selectValue(this.getTestCreditCardExpiryYear());        }

        form.getCreditCardExpirationYear().sendKeys("\t");                      //form.getCreditCardExpirationYear().selectText("2015");               //no for JP
        if(StandardCheckoutFlowWithTests.isCardVerification) {
            form.getCreditCardVerificationCode().setTextValue(this.getTestCreditCardVerificationCode());
            if(! BaseRemoteWebDriver.isBrowser("firefox")) {
                form.getCreditCardVerificationCode().sendKeys("\t");
            }
        }        //form.getCreditCardAuthorizeUsage().setAutoScroll(true);
        form.getCreditCardAuthorizeUsage().ensureChecked();
        //mobile Nexus
       // if(BaseRemoteWebDriver.currentDeviceName !=null && "NexusOne".contains(BaseRemoteWebDriver.currentDeviceName)) {
           /* WebElement we = WaitTool.findElement(getWebDriver(),By.id("creditCardSubmit") ) ; //By.name("CreditCardNumber"));
            JavaScriptHelper.highlightElement(we , webDriver); //creditCardSubmit
            we.submit();*/
        //}else {
            form.submit();
        //}
    }

    @Override
    protected PaymentPage createPage() {
        return new PaymentPage(this.getWebDriver(), this.pageUrl);
    }
}
