package com.englishtown.pages.checkout.legacy;

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.InteractiveCheckoutPage;
import com.englishtown.pages.forms.legacy.PaymentForm;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentPage extends InteractiveCheckoutPage<PaymentForm> {
    private static final Logger logger = LoggerFactory.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public boolean isUrlValidForThisPage() {
        return super.isUrlValidForThisPage() && this.isUrlValidForThisPage("/checkout/payment");
    }

    /**
     * Disabled the credit card validation for testing purposes and reloads the page.
     * Click visa card radio button
     */
    public void disableCreditCardValidation() {
        logger.info("disableCreditCardValidation ....!");
        waitForUrlContains(getWebDriver(),"payment", 10);
        String debugUrl = getWebDriver().getCurrentUrl();  //this.getUrl();
        debugUrl = debugUrl + "?debug=ccval=false";
        this.url = debugUrl;
        logger.info("URL is :"+this.url);
        this.loadPage();        //logger.info("\n\n 1 getCookies PaymentPage disableCreditCardValidation ()  "+webDriver.manage().getCookies().toString()+"\n\n");
                                //        waitForElementCondition( ExpectedConditions.elementToBeClickable(
                                //                getWebDriver().findElement(By.name("CreditCardNumber"))),getWebDriver(), 15);
        WebElement visaCard = WebElementHelper.safeFindElement(this.getWebDriver(),
                By.xpath("//label/input[@name='creditCardGroup' and @value='Visa']"));        //logger.info("\n\n 2 getCookies PaymentPage disableCreditCardValidation ()  "+webDriver.manage().getCookies().toString()+"\n\n");
        if (visaCard != null) {
            visaCard.click() ; // fails    scrollAndClick(visaCard) ;//visaCard.click();            //logger.info("\n\n 3 if getCookies PaymentPage disableCreditCardValidation ()  "+webDriver.manage().getCookies().toString()+"\n\n");
        }
    }

    @Override
    public PaymentForm createForm() {
        logger.info(" PaymentPage createForm()");
        return new PaymentForm(this.getWebDriver());
    }
}
