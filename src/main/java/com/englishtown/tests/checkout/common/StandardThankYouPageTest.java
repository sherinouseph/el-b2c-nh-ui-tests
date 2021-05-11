package com.englishtown.tests.checkout.common;

import com.englishtown.pages.checkout.legacy.ThankYouPage;
import com.englishtown.tests.core.PageTest;
import org.openqa.selenium.WebDriver;

//@Test(enabled=false)
public class StandardThankYouPageTest extends PageTest<ThankYouPage> {
    private String pageUrl;

    public StandardThankYouPageTest(WebDriver webDriver, String pageUrl) {
        super();
        setWebDriver(webDriver); // this.webdriver = webDriver;
        this.pageUrl = pageUrl;
    }

    @Override
    protected ThankYouPage createPage() {
        return new ThankYouPage(getWebDriver(), pageUrl);
    }


}
