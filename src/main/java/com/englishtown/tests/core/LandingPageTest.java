package com.englishtown.tests.core;
/**
 * Base class for Most of the test
 * If a specific for is need extend from the base test classes *
 *
 */
import com.englishtown.driver.local.DriverManager;
import com.englishtown.pages.core.EnglishtownStateObject;
import com.englishtown.pages.core.InteractiveLandingPage;
import com.englishtown.pages.forms.BaseForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public abstract class LandingPageTest<TForm extends BaseForm, TLandingPage extends InteractiveLandingPage<TForm>>
                                                                     extends InteractivePageTest<TForm, TLandingPage> {
    private static final Logger logger = LoggerFactory.getLogger(LandingPageTest.class);

    public boolean isMyPasswordSelector = true;
    public boolean isSpecialSubmit = false; // test
    public boolean isUseFormEmailToSubmit = false;
    public boolean isDifferentButton = false;
    public String isSpecialCssSubmitButton = "Test-should-init-this";
    public String cssSubmitBt = "TestCase-should-init-this and ~BaseTest set isSpecialCssSubmitButton to this ";

    public String inputFirstNameCss = "input[name='first_name']";
    public String inputLastNameCss  = "input[name='last_name']";
    public int listSize = 1;

    @Value("#{applicationPropertiesList['test.firstname']}")
    private String testFirstName;
    @Value("#{applicationPropertiesList['test.lastname']}")
    private String testLastName;
    @Value("#{applicationPropertiesList['test.password']}")
    private String testPassword;

    protected boolean isConfirmPassword = false; // br os form need to reenter the pass

    public static int stepWait = 2000;
    //DefaultValues
    WebElement webElement = null;
    public String [] stateObjectObjects = {"form.","order.","page.","session.","tracking.","user.","persisted."};
    public String etagId        ="etag";           //on the page OBJ
    public String partnerCode   ="partner_code";   //on the page OBJ
    public String partner       ="partner";
    public String etagValue     ="goes";           //on the page OBJ
    public String partnerValue  ="MKGE";

    public String thankyou_page_url_contains ="ty" ;

    public String getTestFirstName() {
        return testFirstName;
    }

    public String getTestLastName() {
        return testLastName;
    }

    public String getTestPassword() {
        return testPassword;
    }


}

