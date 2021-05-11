package com.englishtown.pages.landing;

import com.englishtown.driver.local.DriverManager;
import com.englishtown.pages.core.InteractiveLandingPage;
import com.englishtown.pages.forms.EEForm;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class EELandingPage extends InteractiveLandingPage<EEForm> {

    public EELandingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }


    @Override
    public EEForm createForm() {
        return new EEForm(DriverManager.getDriver()); //this.webDriver);
    }
}