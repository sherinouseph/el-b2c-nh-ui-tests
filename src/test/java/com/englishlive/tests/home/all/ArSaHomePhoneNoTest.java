package com.englishlive.tests.home.all;

/**
 * https://jira.eflabs.io/browse/SAND-4053
 *
 *
 */

import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.dataprovider.bin.PhoneUrlBean;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.SimpleBaseTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;


public class ArSaHomePhoneNoTest extends SimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ArSaHomePhoneNoTest.class);

    
    @Test(dataProvider = "ArSaPhoneUrl", dataProviderClass = MainMarketsHomeUrlsDataProvider.class, threadPoolSize = 3, invocationCount = 1, timeOut = 205000)
    public void openArSaHomePagesCheckPhoneNumber(PhoneUrlBean phoneUrlBean){
        phoneUrlBean.print();
         String phoneNumber      = "notInit";
         String secondPhoneNumber = "notInit";

        try {
            setThreadSafeDriver();
           // DriverManager.createDriver(MyBrowserType.CHROME, 25);
            openUrl(DriverManager.getDriver(), getBASE_URL() + phoneUrlBean.getUrl());
            sleep(1000);

            List<WebElement> phoneWe = WaitTool.findElements(DriverManager.getDriver(), By.cssSelector(phoneUrlBean.getCssSelector())); //safeFindDisplayedAndEnabled
            if (phoneWe != null || !phoneWe.isEmpty()) {
                phoneNumber = TestUtil.getWebElementText(phoneWe.get(0));
                if (phoneWe.size() > 1) {
                    logger.info("Get second Number ...!");
                    secondPhoneNumber = TestUtil.getWebElementText(phoneWe.get(1));
                }
            } else {
                BaseTest.failTest("Can not get phone Number ...! Css selector [" + phoneUrlBean.getCssSelector() + "]");
            }
            logger.info("Url [" + phoneUrlBean.getUrl() + "] Phone Numbers [" + phoneUrlBean + " -2- " + secondPhoneNumber + "]");

            if (StringUtils.isBlank(phoneNumber) || StringUtils.equals(phoneNumber, "notInit")) {
                BaseTest.failTest("Could not get phone number from the web page [" + phoneUrlBean.getUrl() + "] ...!");
            } else {
                 AssertHelper.assertThat( phoneUrlBean.getUrl()+" Phone Number is not the expected one ....!", phoneNumber,
                        equalToIgnoringWhiteSpace(phoneUrlBean.getPhone()));
                logger.info("Phone Number [" + phoneNumber + "] is the expected one [" + phoneUrlBean.getPhone() + "] " +
                        "For url [" + phoneUrlBean.getUrl() + "]");
            }

            if (!StringUtils.isBlank(phoneUrlBean.getSecondPhone())) {
                if (StringUtils.isBlank(secondPhoneNumber) || StringUtils.equals(secondPhoneNumber, "notInit")) {
                    BaseTest.failTest("Could not get phone number from the web page [" + phoneUrlBean.getUrl() + "] ...!");
                } else {
                    AssertHelper.assertThat( phoneUrlBean.getUrl()+" Second Phone Number is not the expected one ....!", secondPhoneNumber,
                            equalToIgnoringWhiteSpace(phoneUrlBean.getSecondPhone()));
                    logger.info("Phone Number [" + secondPhoneNumber + "] is the expected one [" + phoneUrlBean.getSecondPhone() + "] " +
                            "For url [" + phoneUrlBean.getUrl() + "]");
                }
            } else
                logger.info("Only one phone number tested ...!");

        }finally{
            DriverManager.destroyLocalDriver();//destroyDriver();
        }
    }


}