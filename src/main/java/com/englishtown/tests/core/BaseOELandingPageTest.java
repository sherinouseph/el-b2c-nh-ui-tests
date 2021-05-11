package com.englishtown.tests.core;

import com.englishtown.pages.forms.OEForm;
import com.englishtown.pages.landing.OELandingPage;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 *
 * Add base test for most of the landing pages in here
 * Helper methods are defined in here
 * Date: 27/08/14
 *
 */

public abstract class BaseOELandingPageTest extends LandingPageTest<OEForm, OELandingPage>{

    private static final Logger logger = LoggerFactory.getLogger(BaseOELandingPageTest.class);
//    protected String osPageUrl;
    protected String localizedTestPhoneNumber;
    protected String thankyou_page_url_contains ="thankyou" ;
    protected int noOfWebFormElements = 1000 ; // make sure it fails if not reInitialized
    protected Map formDataMap;
    protected boolean isPopupShown = false;
    public String tyMessageCss = ".the.message";

    public boolean isUseCssEnterFormData = false;

    WebElement webElement;
    protected String validationMsgWe = "popover-content";   //et-cnt
    protected String allformElementSelector = ".form .controls";    // oe incude send button

    public void submitOeFormFromBaseOe() {
        this.getPage().getForm().submit();
    }


    protected String getLocalizedTestPhoneNumber(){
        return localizedTestPhoneNumber;
    }

    @Override
    protected OELandingPage createPage() {
        return new OELandingPage(getWebDriver(), this.getPage().getUrl());
    }


}

