package com.englishlive.tests.home.all;

/**
 * https://jira-bos.englishtown.com/browse/SAND-3838
 * Open homepage and check phone number is equal to the expected one
 *
 */

import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.dataprovider.bin.CountryPhoneUrlBean;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.SimpleBaseTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;


public class OpenMainMarketPagesCheckPhoneNoTest extends SimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(OpenMainMarketPagesCheckPhoneNoTest.class);

    protected String phoneNumber = "notInit";

    @BeforeMethod
    protected void setupBeforeMethod(){
        setThreadSafeDriver();
    }

    @Test(dataProvider = "mainMarketHomePagesAndPhoneNo", dataProviderClass = MainMarketsHomeUrlsDataProvider.class)    //, threadPoolSize = 3, invocationCount = 1, timeOut = 55000)
    public void checkPhoneNumbers(CountryPhoneUrlBean countryPhoneUrlBean){
        countryPhoneUrlBean.print();                                                                                     //createLocalThreadDriver(MyBrowserType.EXPLORER11, 15);

        openUrl(DriverManager.getDriver(), getBASE_URL() + countryPhoneUrlBean.getUrl());
        sleep(3000);

        WebElement phoneWe = WaitTool.findElement(DriverManager.getDriver(), By.cssSelector(countryPhoneUrlBean.getCssSelector()) ); //safeFindDisplayedAndEnabled
        phoneNumber = TestUtil.getWebElementText(phoneWe);
        logger.info("Phone Number [" + TestUtil.getWebElementText(phoneWe) + "]");

        if(StringUtils.isBlank(phoneNumber) && StringUtils.equals(phoneNumber, "notInit")){
                BaseTest.failTest("Could not get phone number from the web page ["+countryPhoneUrlBean.getUrl()+"] ...!");
        }else {
            AssertHelper.assertThat("Phone Number is not the expected one ....!", phoneNumber,
                        equalToIgnoringWhiteSpace(countryPhoneUrlBean.getPhone()));
            logger.info("Phone Number [" + phoneNumber +"] is the expected one ["+countryPhoneUrlBean.getPhone()+"] " +
                        "For url ["+countryPhoneUrlBean.getUrl()+"]");
        }
    }


    @AfterMethod
    protected void setupAfterMethod(){
        destroyDriver();
    }


}