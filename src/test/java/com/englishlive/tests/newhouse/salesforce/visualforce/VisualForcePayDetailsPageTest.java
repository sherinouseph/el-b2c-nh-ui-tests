package com.englishlive.tests.newhouse.salesforce.visualforce;
/**
 * Open visual salesforce for different countries
 *
 * check page content shows payment details
 *
 1.	Arabic
 2.	German
 3.	English
 4.	Spanish
 5.	French
 6.	Italian
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishtown.dataprovider.HomePageDataProvider;
import com.englishtown.dataprovider.SFVisualForceLang;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.salesforce.pages.HomeSalesForcePage;
import com.englishtown.newhouse.salesforce.pages.LoginSalesForcePage;
import com.englishtown.newhouse.salesforce.pages.VisualForcePayDetailsPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class VisualForcePayDetailsPageTest extends BaseSalesforceTest{
    private static final Logger logger = LoggerFactory.getLogger(VisualForcePayDetailsPageTest.class);

    /**
     * this url was generated from Meast Site
     */
    protected static String basePageUrl = "https://qa-ef.cs5.force.com/force/WelcomeMailPaymentDetailsSection?act=a00O000000clorTIAQ&lng=";

    protected String headingCss = "strong span";
    protected String currentText ;


    @Test(dataProvider = "languages", dataProviderClass = SFVisualForceLang.class, threadPoolSize = 5 )
    void checkVisualForcePayDetails(String headingTxt, String lang){
        try {
            setThreadSafeDriver();
            testStartUrl = basePageUrl + lang;
            openUrl(getWebDriver(), testStartUrl);
            sleep(1000);
            VisualForcePayDetailsPage vfpdp = new VisualForcePayDetailsPage(getWebDriver(), 80);
            vfpdp.simpleTest();
            vfpdp.extendedTest();
            vfpdp.checkEmail();
            vfpdp.checkActual();
            logger.info("Check Heading Text ...!");

            currWebElement = findElements(By.cssSelector(headingCss)).get(1); // second span
            currentText = getText(currWebElement);
            logger.info("currentText: "+currentText);
            AssertHelper.assertStringContains(currentText, headingTxt,"Heading Text is not the expected one ...!");

        }finally {
            destroyDriver();
        }
    }


}
