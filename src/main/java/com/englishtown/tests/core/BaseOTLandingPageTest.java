package com.englishtown.tests.core;

import com.englishtown.pages.forms.EEForm;
import com.englishtown.pages.landing.EELandingPage;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
/**
 * Date: 27/08/14
 *
 */
public abstract class BaseOTLandingPageTest extends LandingPageTest<EEForm, EELandingPage> {

    private static final Logger logger = LoggerFactory.getLogger(BaseOTLandingPageTest.class);

    protected String localizedTestPhoneNumber;
    protected String thankyou_page_url_contains ="emailenglish-ty" ;
    protected int noOfWebFormElements = 1000 ;
    protected Map formDataMap;
    protected String sendEmailEnglisCheckBoxId="emailenglish";       // or englishemail

    WebElement webElement;
    protected String validationMsgWe = "popover-content";           //et-cnt
    protected String allformElementSelector = ".form .controls";    // oe include send button

    public void submitOeFormFromBaseOe() {
        this.getPage().getForm().submit();
    }
    protected void testEtagAndPartnerOnOTLoandingPage(){
        assertStateObjectParnterCodeAndEtag(stateObjectObjects[2] + partnerCode, stateObjectObjects[2] + etagId, partnerValue, etagValue);
    }

    @Override
    protected EELandingPage createPage() {
        return new EELandingPage(getWebDriver(), this.getPage().getUrl());

    }


}

