package com.englishlive.tests.login.welcomeback;
/**
 * Open login url; Enter credetials and click login, welcome back msg shown
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseWelcomeBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class JpWelcomeBackTest extends BaseWelcomeBack {
    private static final Logger logger = LoggerFactory.getLogger(JpWelcomeBackTest.class);
    @Value("#{applicationPropertiesList['login.jp.url']}")
    private String login;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        username = "studyplan001@gmail.com";
        password = "ef123456" ;
        emailId="UserName";//Aki changed login Page on 12th august .hence updated selectors
        passwordId="Password";
        setSubmitBtn(".btn.btn-secondary");//("input[type=submit]");
        this.openUrl(getWebDriver(), this.login, WaitTool.MED_WAIT_4_ELEMENT) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }





}

