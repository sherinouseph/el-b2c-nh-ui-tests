package com.englishlive.tests.home.chat;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.google.common.base.Predicates.notNull;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Add manual test for click to chat - SAND-4334
 * This is a base test for proactive and nonProactive modes- chat functionality
 *
 * open url
 * check to see if the selectors are present
 * class="click2chat--proactive" or click2chat--small
 */

public abstract class BaseChat extends BaseTestHelper{
    private static final Logger logger = LoggerFactory.getLogger(BaseChat.class);
    public String proactiveSelector = "click2chat--proactive";

    @Test
    public void checkPageSourceContainsElement(){
                WebElement chat_pro_element = getWebDriver().findElement(By.className(proactiveSelector));

        AssertHelper.assertThat("Does Not contains the expected css", null != chat_pro_element);

    }



}
