package com.englishtown.tests.checkout.common.core;
/**
 * Created by nikol.marku on 11/03/2015.

 Open URL : baseURL/buy/
 URL should redirect to page : baseURL/buy/default/member/

 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class CheckoutRedirectBaseTest extends StandardCheckoutFlowTest {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutRedirectBaseTest.class);

    public static final String URL_CONTAINS = "/buy/default/member/";

    @Test(priority = 0)
    public void checkUrlRedirected(){
        logger.info("checkUrlRederected ....!");
        try{Thread.sleep(2000);  }catch(Exception e){}
        checkRederiction(getWebDriver(), URL_CONTAINS);
    }


    public static void checkRederiction(WebDriver driver, String urlContains ) {
        //assertThat("Failed, URL does not contains :'"+urlContains+"' url is : "+driver.getCurrentUrl(),BasePage.waitForUrlContains(driver,urlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT),  Matchers.is(true));
        myAssertThat(driver, "Failed, URL does not contains :'" + urlContains + "' url is : " + driver.getCurrentUrl(),
                BasePage.waitForUrlContains(driver, urlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT), true);
    }

    @Override
    protected String getMemberPageUrl() {
        return null;
    }
    @Override
    protected String getPaymentPageUrl() {
        return null;
    }
    @Override
    protected String getThankYouPageUrl() {
        return null;
    }


}
