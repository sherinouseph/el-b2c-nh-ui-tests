package com.englishtown.pages.checkout.legacy;

import com.englishtown.pages.core.InteractiveCheckoutPage;
import com.englishtown.pages.forms.legacy.MemberForm;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberPage extends InteractiveCheckoutPage<MemberForm> {
    private static final Logger logger = LoggerFactory.getLogger(MemberPage.class);

    public MemberPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public MemberForm createForm() {
        //logger.info("\n\n getCookies MemberForm createForm() "+getWebDriver().manage().getCookies().toString()+"\n\n");
        return new MemberForm(this.webDriver);
    }

    @Override
    public boolean isUrlValidForThisPage() {
        return super.isUrlValidForThisPage() && this.isUrlValidForThisPage("/checkout/member");
    }
}
