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


public abstract class BaseOEPageToBrochurePageTest extends BaseOELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOEPageToBrochurePageTest.class);
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
    protected void isBrochurePage(){
       // is free brochure page : url contains ef.com.fr/oct/englishtown/
//        assertThat("Failed, urls does not contain the expected text :"+this.thankyou_page_url_contains,
//                    BasePage.waitForUrlContains(this.getWebDriver(),
//                    this.thankyou_page_url_contains, WaitTool.MED_WAIT_4_ELEMENT25), is(true));
        myAssertThat(getWebDriver(), "Failed, urls does not contain the expected text :"+this.thankyou_page_url_contains,
                BasePage.waitForUrlContains(this.getWebDriver(), this.thankyou_page_url_contains, WaitTool.MED_WAIT_4_ELEMENT25), true);
    }

//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}

}
