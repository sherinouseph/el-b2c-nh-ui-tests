package com.englishlive.tests.smoke;

/**
* Smoke test for Home pages  :  DE, FR, IT, JA, GB, etc
Not pub1 and pub2
*/

import com.englishtown.dataprovider.bin.SmokeTestBeanNew;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.SmokeBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;


public class SmokeHomePagesTest extends SmokeBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SmokeHomePagesTest.class);

    String popupSelector =".modal.in";

    //@Value("#{applicationPropertiesList['base.url.site']}")
    //protected String publisher;

    public SmokeHomePagesTest(String pageUrl) {
        super(pageUrl);
    }


    @Test(dataProvider = "smokeTestBeannew", dataProviderClass = SmokeDataProvider.class,threadPoolSize = 3, invocationCount = 1, timeOut = 355000)
    public void checkheaderAndText(SmokeTestBeanNew smokebean) {
        smokebean.print();

        try {
            setThreadSafeDriver();
            openUrl(DriverManager.getDriver(), getBASEURL() + smokebean.getUrl());
            /*if (smokebean.getCountry().contains("br")) {
                testBrazil(smokebean.getCountry(),smokebean.getUrl(),smokebean.getLogin_Selector(),smokebean.getPrice_selector(),smokebean.getBodyText());

            }else {
                if (smokebean.getCountry().contains("mx")) {
                    logger.info(" Checking for the presence of popup for es-mx...!"+smokebean.getUrl());
                    waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(
                            By.cssSelector(".popup-offer-and-form-content"))), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
                    //AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(".popup-offer-and-form-content.section")));
                    clickAtWindow(getWebDriver(), 10, 10);// need to click to remove pop up
                    logger.info(" POP up should be closed ...!");
                } else{
                    logger.info(("No PopUp Present"));
                }*/

                assertIsUrlContaining("-" + smokebean.getCountry());
                waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(
                        By.cssSelector(smokebean.getLogin_Selector()))), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
                AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(smokebean.getLogin_Selector())));
                checkBodyText(smokebean.getBodyText());
            //}
        } finally {
            DriverManager.destroyLocalDriver();
        }
    }


    void checkBodyText(String contains) {
        String bodytext = getText(getWebDriver().findElement(By.tagName("body")));
        //AssertHelper.assertStringContains(bodytext, contains,"Body does not contain the expected String");
        AssertHelper.assertThat("Body does not contain the expected String", bodytext, containsIgnoringCase(contains));
    }

    void testBrazil(String country,String Url,String loginSelector,String priceSelector,String content){
        waitForElementAndclickAtXY(By.cssSelector(popupSelector), 6, 6);
        assertIsUrlContaining(country);
        waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(
               By.cssSelector(loginSelector))), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(priceSelector)));
        checkBodyText(content);
    }





}


