package com.englishtown.tests.core;

import com.englishtown.driver.local.DriverManager;
import com.englishtown.pages.core.EnglishtownStateObject;
import com.englishtown.pages.forms.EEForm;
import com.englishtown.pages.landing.EELandingPage;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


/**
 *
 * Add base test for most of the landing pages in here
 * Helper methods are defined in here
 * Date: 27/08/14
 *
 */

public abstract class BaseEELandingPageTest extends LandingPageTest<EEForm, EELandingPage>{  //<OEForm, OELandingPage>

    private static final Logger logger = LoggerFactory.getLogger(BaseEELandingPageTest.class);

    protected String localizedTestPhoneNumber;
    protected int noOfWebFormElements = 1000 ;
    protected Map formDataMap;
    protected String weEmailId = "email";
    protected String submitElementId            = "osformsubmit"; //"email"; //
    protected String weEmailContainingText      = "qp1.org";
    protected String sendEmailEnglisCheckBoxId  ="emailenglish";  // or englishemail
    protected String thankyou_page_url_contains ="emailenglish-ty" ;

    WebElement webElement;
    protected String validationMsgWe = "popover-content";   //et-cnt
    protected String allformElementSelector = ".form .controls";    // oe incude send button

    public void submitOeFormFromBaseOe() {
        this.getPage().getForm().submit();
    }

    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.getPage().getUrl());

    }



}

