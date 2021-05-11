package com.englishlive.tests.landing.form;
/***
 * https://jira.eflabs.io/browse/SAND-4055
 * Phone numbers have set of numbers allowed to start with for mobile and home per CTR:
 CTR: Oman          - OM ->  landline " [+968-2{ddd}-{ddd}]  ; Mobile  [+968-9{ddd}-{dddd}] "
 CTR: Bahrain        - BH ->  landline " [+973-{dddd}-{ddd}]  ; Mobile  [+973-3{ddd}-{dddd}] "
 CTR: Saudi Arabia - SA -> landline " [+966-{1[1-4 OR 6-7]}-{ddd}-{dddd}]  ; Mobile  [+966-5-{dddd}-{dddd}] "
 */
import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaFormValidation;
import com.englishtown.dataprovider.TelephoneNoDataProvider;
import com.englishtown.dataprovider.bin.CountryBean;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.common.CommonTestHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public abstract class BasePhoneMaskValidationTest extends BaseRolaFormValidation {
    private static final Logger logger = LoggerFactory.getLogger(BasePhoneMaskValidationTest.class);

    protected CountryBean countryBean;


    @Test                                                                                                                //(dataProvider = "saTopCountrieBean", dataProviderClass = TelephoneNoDataProvider.class)//, threadPoolSize = 3, invocationCount = 1, timeOut = 25000)
    protected void openUrlsValidateMobileAndLandlinePhoneMask(){                                                         //CountryBean countryBean) {
        //try {
            testStartUrl = testStartUrl + "?ctr=" + countryBean.getTwoLetterCode();//testStartUrl = testStartUrl + "?ctr=" + countryBean.getTwoLetterCode();
            logger.info("\nWHEN I open URL ...! [" + testStartUrl + "]");
            openUrl(getWebDriver(), testStartUrl, -1);
            logger.info("\nAND Select Mobile Phone Type...! Css [" + PHONE_TYPE_SELECT_CSS + "]");                          //select(By.cssSelector(PHONE_TYPE_SELECT_CSS), null, "0");
            CommonTestHelper.selectByValue(getWebDriver(), By.cssSelector(PHONE_TYPE_SELECT_CSS), MOBILE_PHONE_TYPE_VALUE_EN);
            sleep(1000);
            logger.info("\nThen phone type [" + MOBILE_PHONE_TYPE_VALUE_EN + "] is selected ...!");                              // arabic ... checkSelectElementValue(defaultPhoneTypeValue, By.cssSelector(PHONE_TYPE_SELECT_CSS));
            logger.info("\nAND Click on phone text Field ...! Css [" + phoneCss + "]");
            waitForElementVisibleAndClick(getWebDriver(), phoneCss, 25);
            // Mobile is selected by default
            logger.info("\nTHEN Default Mobile Mask is shown  ...! [" + countryBean.getDefaultMobilePhoneMask() + "]");
            validatePhoneValue(phoneCss, countryBean.getDefaultMobilePhoneMask());
            /**
             *  Second phone type
             */
            logger.info("\nWHEN I change Phone type to [" + LANDLINE_TYPE_VALUE_EN + "]");
            CommonTestHelper.selectByValue(getWebDriver(), By.cssSelector(PHONE_TYPE_SELECT_CSS), LANDLINE_TYPE_VALUE_EN);
            sleep(1000);
            logger.info("\nThen phone type [" + LANDLINE_TYPE_VALUE_EN + "] is selected ...!");
            logger.info("\nAND Click on phone text Field ...! Css [" + phoneCss + "]");
            waitForElementVisibleAndClick(phoneCss, 25);
            logger.info("\nTHEN Default Mobile Mask is shown  ...! [" + countryBean.getDefaultHomePhoneMask() + "]");
            validatePhoneValue(phoneCss, countryBean.getDefaultHomePhoneMask());
        //}finally {  DriverManager.destroyLocalDriver();    }
    }


}

