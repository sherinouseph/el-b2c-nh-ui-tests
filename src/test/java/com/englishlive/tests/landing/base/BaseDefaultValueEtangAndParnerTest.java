package com.englishlive.tests.landing.base;

import org.testng.annotations.Test;

/**
 * Test default value for ptn and etag
 * etag=""; partner="None"
 * Date: 04/09/14  *
 */
public abstract class BaseDefaultValueEtangAndParnerTest extends BaseOsLandingPageHiddenFieldTest {

    @Test
    void itagDefalultValueTest(){
        testItagDefalultValueTest() ;
    }

    @Test
    void partnerDefalultValueTest(){
        testPartnerDefalultValueTest();
    }

}
