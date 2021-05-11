//package com.englishlive.tests.newsite.mobileandtablet.landingtest.mx;
//
///**
// * Created by sherin 12/09/2017
// */
//
//import com.englishlive.tests.landing.mx.freetrial.BaseFreeTrialMob;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.pages.common.CookiePage;
//import com.englishtown.tests.core.EfConstants;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
// // Karim jan 2018 removed free trial
//public class COFreeTrialMobTabTest extends BaseFreeTrialMob {
//    public static final Logger logger = LoggerFactory.getLogger(COFreeTrialMobTabTest.class);
//    @Value("#{applicationPropertiesList['home.es.co.url']}")
//    protected String testUrl ;
//    @Value("#{applicationPropertiesList['member.es.mx']}")
//    protected String testMemberPageUrl;
//
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        testStartUrl = testUrl;
//        memberPageUrl = testMemberPageUrl ;
//        setThreadSafeDriver();
//        try {
//            String deviceName = BaseRemoteWebDriver.getCurrentDeviceName();
//            logger.info("device name" + deviceName);
//            if(StringUtils.containsIgnoreCase(deviceName, "iphone") ||
//                    StringUtils.containsIgnoreCase(deviceName, "ipad")){
//                    is_iOStest = true;
//            }
//        }catch (Exception e){
//            logger.error("Can not get device name ...!"+e.getMessage());
//        }
//        openUrl(getWebDriver(), testStartUrl);
//        CookiePage cookiePage = new CookiePage(getWebDriver());
//        cookiePage.closeCookie();
//        formDataMap = EfConstants.mxFreeTrialFormMapWithPhoneType;
//        passwordmap=   EfConstants.passwordform;
//        thankYouMsgContains="Gracias";
//        loginFormMsgContains = "Hola";
//        urlContainsquestionnaire = "welcome";
//        passwordFormMsgContains = "Bienvenido";
//        welcomeBackMsgContains = "Bienvenido de nuevo";
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//       destroyDriver();
//    }
//
//}
