package com.englishlive.tests.home.chat;

import com.englishtown.helpers.WaitTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**

 *
 * open testurl "https://qa-englishlive.ef.com/fr-fr/lp/oe/autotest_nonproactive-click2chat/";
 * check to see if the selector Class=  click2chat--small is  present
 *
 */

public class NonProactiveChat extends BaseChat{
    private static final Logger logger = LoggerFactory.getLogger(NonProactiveChat.class);
    @Value("#{applicationPropertiesList['fr.nonpro.url']}")
    public String test_non_pro_url;



    @BeforeClass
    protected void setupOpenChatpage() {
        proactiveSelector  = "click2chat--small";
        setThreadSafeDriver();
        openUrl(getWebDriver(), test_non_pro_url, WaitTool.MED_WAIT_4_ELEMENT);
    }



    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }

}
