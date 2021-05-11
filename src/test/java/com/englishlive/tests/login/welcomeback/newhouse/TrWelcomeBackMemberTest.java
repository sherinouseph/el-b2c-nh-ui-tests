package com.englishlive.tests.login.welcomeback.newhouse;
/**
 * Nikol 2018
 *   this is a new house user
 */

import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.WaitTool;
import  com.englishtown.tests.core.login.flows.BaseWelcomeBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TrWelcomeBackMemberTest extends BaseWelcomeBack {
    private static final Logger logger = LoggerFactory.getLogger(TrWelcomeBackMemberTest.class);
    @Value("#{applicationPropertiesList['newhouse.tr.login']}")
    private String login;

    @Value("#{applicationPropertiesList['testuser.tr.oh.notpaid']}")
    protected String testUsername;



    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        username = testUsername;
        password = "passpass" ;
        isTestCheckoutFlowType = true;
        checkoutFlowType = CheckoutFlowType.WELCOMEBACK;
        welcomeBackUrlContains = WELCOME_BACK_MEMBER;
        setSubmitBtn("input[type=submit]");
        this.openUrl(getWebDriver(), this.login, WaitTool.MED_WAIT_4_ELEMENT) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }





}

