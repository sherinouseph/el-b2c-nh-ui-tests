package com.englishlive.tests.landing.base;
/**
 * Hidden field test for : crt, lng,
 * User: nikol.marku
 * Date: 01/09/14 .
 */

import org.testng.annotations.Test;


public abstract class BaseHiddenFieldsOsPageTest extends BaseOsLandingPageHiddenFieldTest {
    protected String ctrValue       =""; // this values should be init on extending class
    protected String langValue      ="";
    protected String leadTypeValue  ="";

    @Test
    void testCTRcodeHiddenFieldTest(){
        checkOsHiddenFildTest(ctrId, getCtrValue(), 10);
    }
    @Test
     void testLangCodeHiddenFieldTest(){
        checkOsHiddenFildTest(langId, getLangValue(), 5);
    }

    @Test
    void testLeadTypeCodeCodeHiddenFieldTest(){
        checkOsHiddenFildTest(leadId, getLeadTypeValue(), 5);
    }


    public String getCtrValue() {
        return ctrValue;
    }

    public String getLangValue() {
        return langValue;
    }

    public String getLeadTypeValue() {
        return leadTypeValue;
    }

    public String getOsformsubmitId() {
        return osformsubmitId;
    }

}
