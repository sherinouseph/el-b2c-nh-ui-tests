package com.englishlive.tests.landing.base;
/**
 *
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseOELandingPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;


public abstract class BaseOEPageUnder13Test extends BaseOELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOEPageUnder13Test.class);
    protected Map formDataMap;


    @Test
    protected void enterOeFormdata(){
        TestUtil.printMethodName(logger, 2);
        this.enterFormData(this.formDataMap);
    }

    @Test(dependsOnMethods = { "enterOeFormdata" })
    protected void submitOeFormTest(){
        this.getPage().getForm().submit();
    }

    @Test(dependsOnMethods = { "submitOeFormTest" })
    protected void isValidatonMessage(){
        sleep(1000);
        myAssertThat(getWebDriver(), "Failed, urls does not contain the expected text :" + this.thankyou_page_url_contains,
                BasePage.waitForUrlContains(this.getWebDriver(),
                        this.thankyou_page_url_contains, WaitTool.SHORT_WAIT_4_ELEMENT), true);
        //BasePage.failTest(" Fail test as NO message is currently show ... need update from vahid - see sand-1952");
    }
//
//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}

}
