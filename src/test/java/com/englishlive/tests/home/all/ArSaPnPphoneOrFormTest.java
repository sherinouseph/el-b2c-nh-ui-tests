package com.englishlive.tests.home.all;

/**
 * https://jira.eflabs.io/browse/SAND-4053
 * On PP page /ar-sa/
 if CTR = gulf country and click on free consultation then form is shown
 if CTR = non gulf country then phone/call number show
 *
 * Gulf: Bahrain, UAE, Kuwait, Oman, Qatar, Saudi Arabia - Blue CTA on P&P page should take you to FREE CONSULTATION
 Non-gulf: EG SD YE IQ JO LB SY DZ MA LY TN - Blue CTA on P&P should CALL

 May 2018 Karim ... eg and tng goes to form Member now ...
 */

import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.dataprovider.bin.GullUrlBean;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.SimpleBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class ArSaPnPphoneOrFormTest extends SimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ArSaPnPphoneOrFormTest.class);

    protected String waitForPnPpageElemetnCss   = ".btn.btn-secondary";
    protected String waitForConsultatonWeCss   = "input[name='first_name']";
    protected String urlContainsFreeConsult = "free-consultation";
    protected String pnpUrlContains         = "study-plans-and-prices";

    @Test(dataProvider = "ArSaUrlsGulfNoGalf", dataProviderClass = MainMarketsHomeUrlsDataProvider.class)//, threadPoolSize = 1, invocationCount = 1, timeOut = 155000)
    public void openArSaPnPPagesCheckPhoneOrForm(GullUrlBean gullUrlBean){
        gullUrlBean.print();

        try {
            setThreadSafeDriver(); //DriverManager.createDriver(MyBrowserType.CHROME, 25);
            openUrl(DriverManager.getDriver(), getBASE_URL() + gullUrlBean.getUrl());
            sleep(1000);
            WaitTool.waitForElementClickable(DriverManager.getDriver(), By.cssSelector(waitForPnPpageElemetnCss), 20);
            WebElement consultationBtnWe = WaitTool.safeFindDisplayedAndEnabled(DriverManager.getDriver(), By.cssSelector(waitForPnPpageElemetnCss), 10);

            WebElementHelper.click(consultationBtnWe);
            sleep(1000);
            /*
                Gulf: Bahrain, UAE, Kuwait, Oman, Qatar, Saudi Arabia - Blue CTA on P&P page should take you to FREE CONSULTATION
                Non-gulf: EG SD YE IQ JO LB SY DZ MA LY TN - Blue CTA on P&P should CALL
            */
            if(gullUrlBean.isGulf()) {   // gulf
                WaitTool.waitForElementClickable(DriverManager.getDriver(), By.cssSelector(waitForConsultatonWeCss), 15);
                AssertHelper.assertWebElementDisplayed(DriverManager.getDriver(), By.cssSelector(waitForConsultatonWeCss));
                AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(DriverManager.getDriver()), urlContainsFreeConsult,
                        "Current url is not the expected one ...!");
            }else { //no gulf stay same page  2018 goes to buy/default/member
                //WaitTool.waitForElementClickable(DriverManager.getDriver(), By.cssSelector(waitForPnPpageElemetnCss), 15);
                AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(DriverManager.getDriver()), "buy",
                        "Current url is not the expected one ...! ");
            }

        }finally{
            //destroyDriver(); does not close all drivers
             DriverManager.destroyLocalDriver();
        }
    }


}