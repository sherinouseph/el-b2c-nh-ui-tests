package com.englishtown.pages.landing;

import com.englishtown.pages.core.InteractiveLandingPage;
import com.englishtown.pages.forms.OEForm;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;

/**
 * OE online enquire page
 * User: nikol.marku
 * Date: 09/09/14
 */

@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class OELandingPage extends InteractiveLandingPage<OEForm> {

    public OELandingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public OEForm createForm() {
        return new OEForm(this.webDriver);
    }
}