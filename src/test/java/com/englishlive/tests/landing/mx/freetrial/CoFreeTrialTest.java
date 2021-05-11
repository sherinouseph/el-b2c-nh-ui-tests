//package com.englishlive.tests.landing.mx.freetrial;
////
/////**
//// * Created by sherin 12/09/2017
//// * updated by sherin 20/10/2017-SAND-4717
//// */
////// this test is to check if the form is redirecting to password page, if we set the ctr to CO
//
//import com.englishlive.tests.landing.base.BaseFreeTrial;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//// Jan 2018 Karim removed free trial
//
//public class CoFreeTrialTest extends BaseFreeTrial {
//    public static final Logger logger = LoggerFactory.getLogger(CoFreeTrialTest.class);
//
//    @Value("#{applicationPropertiesList['page.home.es.mx.url']}")
//    protected String testUrl ;
//    @Value("#{applicationPropertiesList['member.es.mx']}")
//    protected String testMemberPageUrl;
//
//    private String loginUrl;
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        testStartUrl = testUrl.replace("=mx","=co");
//        memberPageUrl = testMemberPageUrl ;
//        submitFormBtnCss = ".form-panel .btn.btn-primary";
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), testStartUrl);
//        EfConstants.mxFreeTrialFormMapWithPhoneType.replace( "country",    "selectMeSelectOpt&true&co");
//        EfConstants.mxFreeTrialFormMapWithPhoneType.replace( "telephone",    "51-1111111");
//        formDataMap = EfConstants.mxFreeTrialFormMapWithPhoneType;
//        passwordmap=   EfConstants.passwordform;
//        boolean showPassword=true;
//        passwordFormMsgContains = "Bienvenido";
//        welcomeBackMsgContains ="Bienvenido de" ;
//        urlContainsquestionnaire = "welcome";
//        clickAtWindow(getWebDriver(), 5, 5);
//        sleep(300);
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//               destroyDriver();
//    }
//
//}
