package com.englishlive.tests.cq.component;
/**
 *
 * https://jira-bos.englishtown.com/browse/SAND-3258
 When I go to PP page help section: e.g  http://englishlive.ef.com/it-it/aiuto/
 1. Questions txt is collapsed (not shown) by default
 2. When I click on the down arrow section expand and collapse - can not test this as cant get the arrow element is done using JS
 3. When I click on the help it does the same as well
 *
 */
import com.englishlive.tests.cq.component.core.BaseComponent;
import com.englishtown.helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class FAQsComponentTest extends BaseComponent {
    private static final Logger logger = LoggerFactory.getLogger(FAQsComponentTest.class);
    @Value("#{applicationPropertiesList['it.aiuto']}")
    protected String testUrl;
    protected List<WebElement> tempWeList = null;


    @BeforeClass
    public void setupOpenUrl(){
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), this.testUrl, -1 ) ;
    }

    @Test
    public void checkFAQsTextIsCollapsedByDefault(){
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(FAQS_DESCRIPTION_LIST));// WaitTool.DEFAULT_IMPLICIT_WAIT);
        if(tempWeList != null && !tempWeList.isEmpty()) {
            AssertHelper.assertThat("FAQs question description is shown and should not by default ...!",
                    !WaitTool.isElementVisible(tempWeList.get(FAQS_TEST_ID)));
        }else {
            failTest("Could not get list of webElements ....! WE FAQS_DESCRIPTION_LIST css :"+FAQS_DESCRIPTION_LIST);
        }
    }
    @Test(priority = 2)
    public void checkFAQsTextIsShownOnClick(){
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(FAQS_QUESTION_LIST));
        if(tempWeList != null && !tempWeList.isEmpty()) {
            WebElementHelper.scrollAndClick(getWebDriver(),tempWeList.get(FAQS_TEST_ID) );
        }else {
            failTest("Could not scroll to list Element ["+FAQS_TEST_ID+"]....! WE FAQS_QUESTION_LIST css :"+FAQS_QUESTION_LIST);
        }
        sleep(1000);
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(FAQS_DESCRIPTION_LIST));
        if(tempWeList != null && !tempWeList.isEmpty()) {
            AssertHelper.assertThat("FAQs question description Should be shown and is NOT ...!",
                    WaitTool.isElementVisible(tempWeList.get(FAQS_TEST_ID)));
        }else {
            failTest("Could not find list Element ["+FAQS_TEST_ID+"]....! WE FAQS_DESCRIPTION_LIST css :"+FAQS_DESCRIPTION_LIST);
        }

    }

    @Test(priority = 3)
    public void checkFAQsTextIsCollapsedAfterClick(){
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(FAQS_QUESTION_LIST));  //+" .caption"));
        if(tempWeList != null && !tempWeList.isEmpty()) {
            click(tempWeList.get(FAQS_TEST_ID));
        }else {
            failTest("Could not scroll to list Element ["+FAQS_TEST_ID+"]....! WE FAQS_QUESTION_LIST .captiom css :"+FAQS_QUESTION_LIST);
        }

        sleep(2000);
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(FAQS_DESCRIPTION_LIST));
        if(tempWeList != null && !tempWeList.isEmpty()) {
            AssertHelper.assertThat("FAQs question description Should Not be shown ...!",
                    !WaitTool.isElementVisible(tempWeList.get(FAQS_TEST_ID)));
        }else {
            failTest("Could not find list Element ["+FAQS_TEST_ID+"]....! WE FAQS_DESCRIPTION_LIST css :"+FAQS_DESCRIPTION_LIST);
        }

    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
