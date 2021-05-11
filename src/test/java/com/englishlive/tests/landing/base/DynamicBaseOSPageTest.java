package com.englishlive.tests.landing.base;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.BaseLandingPageTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;


public abstract class DynamicBaseOSPageTest extends BaseLandingPageTest {


    @Test
    public void enterOSformData(){
        try{Thread.sleep(1000);}catch (Exception e){}
        this.enterFormData(formDataMap);
        if(isEnterNumberOneByOne){
            WebElementHelper.sendKeyWithWait(findElement(By.name("telephone")), "4492270000",  300);
        }
    }

    @Test(dependsOnMethods = { "enterOSformData" })
    protected void submitOsFormTest(){
        this.getPage().getForm().submit();
    }

    @Test (dependsOnMethods = { "submitOsFormTest" })
    void validateIsCheckoutPageUrlTest(){
        AssertHelper.myAssertThat(getWebDriver(), " Failed ... url does not contain :" + this.pay_page_url_contains,
                isPaymentUrlWithWait(this.pay_page_url_contains, WaitTool.DEFAULT_WAIT_4_ELEMENT), is(true), true );
    }


    @Test(dependsOnMethods = { "validateIsCheckoutPageUrlTest" })
    protected void verifyPaymentPageTrackingDotEvents(){
        assertPaymentPageTrackingEvents();
    }


}



