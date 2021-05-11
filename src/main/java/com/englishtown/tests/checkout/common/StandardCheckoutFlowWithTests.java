package com.englishtown.tests.checkout.common;
/**
 * This class has tests for standard checkout
 * User: nikol.marku
 * Date: 30/10/14
 *
 */

import com.englishtown.helpers.WebDriverWindowHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public abstract class StandardCheckoutFlowWithTests extends StandardCheckoutFlowTest  {

    private static final Logger logger = LoggerFactory.getLogger(StandardCheckoutFlowWithTests.class);
    public static boolean isCardVerification = false;


    @Test
    public void testCheckoutFlow(){
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST , "Chrome only TEST ....!");
        isStoreData=false;
        testFlow();
    }
    @Test(dependsOnMethods = { "testCheckoutFlow" })
    public void testThankyouPageStateObject(){
        assertThankyouPageStateObjectElements();
    }
    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    public void testThankyouPage_Form_StateObjectValues(){
        assertThankyouPageFormStateObjectElements();
    }

//    @Test(dependsOnMethods = { "testThankyouPage_Form_StateObjectValues" })
//    public void goToSchool(){
//        String urlContainsEnroll = "b2c/entrance#1";
//        WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
//        click(getWebDriver(), By.id("thankyouSubmitparent"));
//        sleep(3000);
//        assertIsUrlContaining(urlContainsEnroll);
//    }

    @AfterClass
    public void cancelSubscription(){
        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
            cancelUserSubscription(getUserEmail());
        } else {
            logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
        }
    }

}
