//package com.englishlive.tests.landing.fr.freetrial;
////
/////**
//// * Created by sherin 28/11/2017
////
//// */
//
//import com.englishlive.tests.landing.base.BaseFreeTrial;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.tests.core.BaseTestConfig;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class FrFreeTrialWorldCapTest extends BaseFreeTrial {
//    public static final Logger logger = LoggerFactory.getLogger(FrFreeTrialWorldCapTest.class);
//    @Value("#{applicationPropertiesList['fr.freepl8']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['new.checkout.member.fr.fr.url']}")
//    protected String testMemberPageUrl;
//    private String loginUrl;
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        testStartUrl = testUrl;
//        memberPageUrl = testMemberPageUrl ;
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), testStartUrl);
//        formDataMap = EfConstants.frFreeTrialFormMap;
//        boolean showPassword=false;
////        passwordFormMsgContains = "Bienvenido";
////         welcomeBackMsgContains ="Bienvenido de" ;
////        urlContainsquestionnaire = "welcome";
//
//    }
//
//    @Override
//    public void fillPasswordForm(){
//        WebElementHelper.sendKeys(getWebDriver(),findElement(By.name("password")), BaseTestConfig.getPassword8(),true);
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//               destroyDriver();
//    }
//
//}
