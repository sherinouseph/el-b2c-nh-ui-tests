package com.englishlive.tests.landing.base;
/**
* Hidden field test for : crt, lng,
* User: nikol.marku
* Date: 01/09/14 .
*/
import com.englishtown.helpers.WaitTool;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class BasePartnerTest extends BaseSendTagOnUrlTest {

    @Test
    void getOsPageAndValidateIt(){
        myAssertThat(getWebDriver(), "Url is not valid for this page.", this.getPage().isUrlValidForThisPage(), true);
    }

    @Test  (dependsOnMethods = { "getOsPageAndValidateIt" })
    void testEtagHiddenFieldTest(){
        checkOsHiddenFildTest(partnerId, partnerValue, WaitTool.SHORT_WAIT_4_ELEMENT);
    }
}
