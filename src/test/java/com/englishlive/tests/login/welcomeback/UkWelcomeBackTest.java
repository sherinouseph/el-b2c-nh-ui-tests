//package com.englishlive.tests.login.welcomeback;
///**
// * Open login url; Enter credetials and click login, welcome back msg shown
// *
// */
//
//import com.englishtown.enumpack.CheckoutFlowType;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.BaseWelcomeBack;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class UkWelcomeBackTest extends BaseWelcomeBack {
//    private static final Logger logger = LoggerFactory.getLogger(UkWelcomeBackTest.class);
//    @Value("#{applicationPropertiesList['login.uk.url']}")
//    private String login;
//
//
////test12345et15@qp1.org test12345et1429889111615@qp1.org
//
//    @BeforeClass
//    public void setup(){
//        isTestCheckoutFlowType = true;
//        checkoutFlowType = CheckoutFlowType.WELCOMEBACK;
//        username = "test12345et15@qp1.org"; //"test12345et1424104790823@qp1.org";
//        password = "pass" ;
//        this.openUrl(getWebDriver(), this.login, WaitTool.DEFAULT_WAIT_4_ELEMENT) ;
//    }
//
//
//
//}
//
