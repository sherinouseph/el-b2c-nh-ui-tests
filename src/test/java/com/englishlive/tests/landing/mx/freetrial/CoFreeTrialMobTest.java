//package com.englishlive.tests.landing.mx.freetrial;
////
/////**Test flow for mobile  ?ctr=CO
//// * Created by sherin 12/09/2017
//// */
//
//import com.englishtown.helpers.WebDriverWindowHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.Dimension;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//// no more jan 2018 karim removed
//// real device test added for this  CoFreetrialMob
//public class CoFreeTrialMobTest extends BaseFreeTrialMob {
//    public static final Logger logger = LoggerFactory.getLogger(CoFreeTrialMobTest.class);
//    @Value("#{applicationPropertiesList['page.home.es.mx.url']}")
//    protected String testUrl ;
//    @Value("#{applicationPropertiesList['member.es.mx']}")
//    protected String testMemberPageUrl;
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        testStartUrl = testUrl.replace("=mx","=co");
//        memberPageUrl = testMemberPageUrl ;
//        setThreadSafeDriver();
//        Dimension windowSize = new Dimension(600, 900);
//        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),windowSize );
//        /*if( ! StringUtils.equals(getENVIRONMENT(), "live")){
//            testStartUrl = testStartUrl+"&rcode=martin-norman-mx";
//        }*/
//        openUrl(getWebDriver(), testStartUrl);
//        formDataMap = EfConstants.mxFreeTrialFormMapWithPhoneType;
//        passwordmap=   EfConstants.passwordform;
//        thankYouMsgContains="Gracias";
//        loginFormMsgContains = "Hola";
//        urlContainsquestionnaire = "welcome";
//        passwordFormMsgContains = "Bienvenido";
//        welcomeBackMsgContains = "Bienvenido de nuevo";
//    }
//
//    @Override
//    void checkAndroidOrAppleStoreUrlsContainsAppId(){
//        checkAppleStore();
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//       destroyDriver();
//    }
//
//}
