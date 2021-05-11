//package com.englishlive.tests.screenshot;
///**
// * Created by nikol.marku on 03/06/2015.
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.mail.SendMail;
//import com.englishtown.tests.core.responsivecore.BaseSendScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class UkSendScreenshot extends BaseSendScreenshot {
//    private static final Logger logger = LoggerFactory.getLogger(UkSendScreenshot.class);
//    @Value("#{applicationPropertiesList['home.en.en.url']}")
//    protected String testUrl ;
//
//    @BeforeClass
//    public void setup(){
//        runTestOnLiveOnly();
//        selector = "a[href=\"login/\"]";
//        pricingSelector = ".package .btn-primary";
//        aboutUsSelector = ".scroll-indicator";
//        howItWorksSelector = ".scroll-indicator";
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
//        pricingUrl    = "study-plans-and-prices/";
//        aboutusUrl    = "about-us/";
//        howitWorksUrl = "learn-english-online/";
//    }
//    @Override
//    public void setupMarket(){
//        MARKET   ="uk";
//    }
//    @Override
//    public void setSelectors(){   }
//
//
//
//}
