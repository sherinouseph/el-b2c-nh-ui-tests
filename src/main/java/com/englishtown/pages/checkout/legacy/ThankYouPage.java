package com.englishtown.pages.checkout.legacy;

import com.englishtown.pages.core.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class ThankYouPage extends CheckoutPage {
    public ThankYouPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public boolean isUrlValidForThisPage() {
        return super.isUrlValidForThisPage() && this.isUrlValidForThisPage("/checkout/thankyou");
    }
}
