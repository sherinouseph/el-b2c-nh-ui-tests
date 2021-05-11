//package com.englishlive.tests.screenshot;
///**
// * Created by nikol.marku on 03/06/2015.
// */
//import com.englishtown.helpers.mail.SendMail;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.responsivecore.BaseSendScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class ItSendScreenshot extends BaseSendScreenshot {
//    private static final Logger logger = LoggerFactory.getLogger(ItSendScreenshot.class);
//    @Value("#{applicationPropertiesList['home.it.it.url']}")
//    protected String testUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        selector = "a[href=\"login/\"]";
//        pricingSelector = ".formset button";
//        aboutUsSelector = ".scroll-indicator";
//        howItWorksSelector = ".scroll-indicator";
//        runTestOnLiveOnly();
//        TestUtil.printMethodName(logger);
//        failTestIfIsNotBrowser(RUN_TEST_ON_BROWSERS, " This test should run only on Chrome ...!");
//        setupTestData();
//        message.add(emailHeader);
//        openUrl(getWebDriver(), BASE_URL, -1) ;
//        TestUtil.cleanDir(SendMail.SCREENSHOT_DIRECTORY+MARKET);
//        logger.info("Directory cleared ....!");
//    }
//
//    @Override
//    public void setupBaseUrl(){
//        BASE_URL =testUrl;
//    }
//    @Override
//    public void setupUrls(){
//        pricingUrl    = "offerta-inglese/"; //"offerta-corso-inglese/";
//        aboutusUrl    = "scuola-di-inglese/";
//        howitWorksUrl = "imparare-l-inglese/";
//    }
//    @Override
//    public void setupMarket(){
//        MARKET   ="it";
//    }
//    @Override
//    public void setSelectors(){
//        //use default
//    }
//
//
//}
