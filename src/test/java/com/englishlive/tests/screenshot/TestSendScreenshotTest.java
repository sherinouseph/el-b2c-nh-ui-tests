//package com.englishtown.tests.screenshot;
///**
// * Created by nikol.marku on 03/06/2015.
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.mail.SendMail;
//import com.englishtown.tests.core.responsivecore.BaseSendScreenshot;
//import com.englishtown.tests.core.responsivecore.TestBaseSendScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class TestSendScreenshotTest extends TestBaseSendScreenshot {
//    private static final Logger logger = LoggerFactory.getLogger(TestSendScreenshotTest.class);
//    @Value("#{applicationPropertiesList['home.de.de.url']}")
//    protected String testUrl ;
//
//    /**
//     * Setup test market, selectors, URLs or use defaults
//     */
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        failTestIfIsNotBrowser(RUN_TEST_ON_BROWSERS, " This test should run only on  Chrome, IE and FF ...!");
//        setupTestData();
//        message.add(emailHeader);
//        openUrl(getWebDriver(), BASE_URL, -1) ;
//        TestUtil.cleanDir(SendMail.SCREENSHOT_DIRECTORY+MARKET);
//        logger.info("Directory cleared ....!");
//    }
//
//
//    @Override
//    public void setupBaseUrl(){
//        BASE_URL =testUrl;  //TEST START URL
//    }
//    @Override
//    public void setupUrls(){
//        pricingUrl    = "angebote-und-preise/";
//        aboutusUrl    = "uber-ef-englishtown/";
//        howitWorksUrl = "englisch-lernen-online/";
//    }
//    @Override
//    public void setupMarket(){
//        MARKET   ="de";
//    }
//    @Override
//    public void setSelectors(){
//        //use default
//    }
//
//
//}
