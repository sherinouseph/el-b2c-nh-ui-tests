//package com.englishlive.tests.screenshot;
///**
// * Created by nikol.marku on 03/06/2015.
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.mail.SendMail;
//import com.englishtown.tests.core.responsivecore.BaseSendScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class FrSendScreenshot extends BaseSendScreenshot {
//    private static final Logger logger = LoggerFactory.getLogger(FrSendScreenshot.class);
//    @Value("#{applicationPropertiesList['home.fr.fr.url']}")
//    protected String testUrl ;
//
//
//    @BeforeClass
//    public void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        runTestOnLiveOnly();
//        TestUtil.printMethodName(logger);
//        pricingSelector = "a.btn-primary";
//        failTestIfIsNotBrowser(RUN_TEST_ON_BROWSERS, " This test should run only on  Chrome ...!");
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
//        pricingUrl    = "formations-et-tarifs/";
//        aboutusUrl    = "qui-sommes-nous/";
//        howitWorksUrl = "apprendre-l-anglais-en-ligne/";
//    }
//    @Override
//    public void setupMarket(){
//        MARKET   ="fr";
//    }
//    @Override
//    public void setSelectors(){
//        //use default
//    }
//
//
//}
