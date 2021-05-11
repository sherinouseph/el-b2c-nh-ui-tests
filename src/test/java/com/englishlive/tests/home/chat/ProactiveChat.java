package com.englishlive.tests.home.chat;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * open testurl "https://qa-englishlive.ef.com/fr-fr/lp/oe/autotest_proactive-click2chat/";
 * check to see if the selector class="click2chat--proactive" is  present
 *
 */

public class ProactiveChat extends BaseChat{
    private static final Logger logger = LoggerFactory.getLogger(ProactiveChat.class);
    @Value("#{applicationPropertiesList['fr.pro.url']}")
    public String testprourl;



    @BeforeClass
    protected void setupOpenChatpage() {
        proactiveSelector  = "click2chat--proactive";
        setThreadSafeDriver();
        openUrl(getWebDriver(), testprourl, WaitTool.MED_WAIT_4_ELEMENT);
    }



    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }

}
