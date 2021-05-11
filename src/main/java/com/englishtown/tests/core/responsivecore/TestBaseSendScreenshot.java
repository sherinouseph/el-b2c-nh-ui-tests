//package com.englishtown.tests.core.responsivecore;
///**
// * Only to test emails
// */
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.mail.SendMail;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static java.lang.Boolean.parseBoolean;
//
///**
// * Created by nikol.marku on 03/06/2015.
// */
//public abstract class TestBaseSendScreenshot extends BaseSendScreenshot {
//    private static final Logger logger = LoggerFactory.getLogger(TestBaseSendScreenshot.class);
//
//
//    @Test (priority = 0)
//    public void getHomePageScreenDumpTest(){
//        TestUtil.printMethodName(logger);
//        openUrlGetScreenDumpAndAddToMessage(null, By.cssSelector(selector),                              "HomePage" );
//    }
//    @Test (priority = 1)
//    public void getMemberPageScreenDumpTest(){
//
//    }
//
//    @Test (priority = 2)
//    public void getPricingrPageScreenDumpTest(){
//
//    }
//
//    @Test (priority = 3)
//    public void getAboutUsPageScreenDumpTest(){
//
//    }
//
//    @Test (priority = 4)
//    public void getHowItWorksPageScreenDumpTest(){
//
//    }
//
//    /**
//     * Lastly send email
//     */
//    @Test (priority = 10)
//    public void sendMailTest(){
//        try {
//            setIsSendEmailFromSysGetProperties();
//            List<String> filenames = SendMail.getFiles(SendMail.SCREENSHOT_DIRECTORY+MARKET+"/");
//            if(errorCount == 0){
//                //is_SEND_EMAIL=true; //command line argument
//                if(is_SEND_EMAIL){
//                    SendMail.sendMail(SendMail.getToEmail(), subject + MARKET.toUpperCase() + "] - [" +
//                            TestUtil.getYYMMDD() + "]", message, SendMail.SCREENSHOT_DIRECTORY, MARKET, filenames);
//                }else {
//                    logger.info("\n\tSending emails comment only. NO email is sent ...!");
//                }
//            }else {
//                logger.warn("Email Not Send. There are errors, Error count = "+errorCount);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            logger.error("Exception - sendMailTest ...!\n"+e.toString());
//            BasePage.failTest(e, "Failed sendMailTest ...!");
//        }
//    }

//    // helpers      // base
//    public void openUrlGetScreenDumpAndAddToMessage(String url, By by, String friendlyName ){
//        setStartWithAndPicName(friendlyName, MARKET);
//        try {
//            if(url != null){openUrl(getWebDriver(), url, -1) ;}
//            waitForConditionAndTakeScreenShot(by);
//            logger.info(friendlyName+" Screenshot stored ...!");
//            message.add("\t"+screenshotCount +" - "+screenShotFriendlyName+"\n");
//            screenshotCount++;
//        }catch (Exception e){
//            errorCount++;
//            logger.error("getScreenDumpAndAddToMessage Exception ...!\n"+e.toString());
//        }
//    }
//    protected void waitForConditionAndTakeScreenShot(By by){
//        WaitTool.waitForCondition( ExpectedConditions.visibilityOfElementLocated(by),getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        TestUtil.takeScreenshot(getWebDriver(),SendMail.SCREENSHOT_DIRECTORY, MARKET, filenameStartWith );
//    }
//    protected void setStartWith(String startWith, String market){
//        filenameStartWith = startWith+"_"+market+"_";
//    }
//    protected void setPicFriendlyName(String name){
//        screenShotFriendlyName = name;
//    }
//    protected void setStartWithAndPicName(String name, String market){
//        setPicFriendlyName(name);
//        setStartWith(name, market);
//    }
//    protected void setupTestData(){
//        this.setupBaseUrl();
//        this.setupMarket();
//        this.setupUrls();
//        this.setSelectors();
//    }
//    protected void setIsSendEmailFromSysGetProperties(){
//        is_SEND_EMAIL = false;
//        try {
//            is_SEND_EMAIL = parseBoolean(System.getProperty("sendScreenshotEmail"));
//            logger.info("set IsSendEmailFromSysGetProperties   is_SEND_EMAIL : "+is_SEND_EMAIL);
//        }catch (Exception e){
//            logger.error("setIsSendEmailFromSysGetProperties Exception ...! "+e.getMessage());
//        }
//    }
//    protected void setIsSendEmail(boolean isSendEmail){
//        is_SEND_EMAIL = isSendEmail;
//    }
//
//    @Override
//    public void setupBaseUrl(){ }
//    @Override
//    public void setupUrls(){ }
//    @Override
//    public void setupMarket(){ }
//    @Override
//    public void setSelectors(){};
//    @Override
//    public void setupEmailSubject(){};
//
//}
