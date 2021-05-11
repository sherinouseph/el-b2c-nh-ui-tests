package com.englishtown.pages.landing;

import com.englishtown.pages.core.InteractiveLandingPage;
import com.englishtown.pages.forms.OSForm;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class OSLandingPage extends InteractiveLandingPage<OSForm> {

    public OSLandingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public OSForm createForm() {
        return new OSForm(this.webDriver);
    }
}
