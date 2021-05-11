package com.englishtown.tests.core.responsivecore;
/**
 * test
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.mail.SendMail;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.parseBoolean;

/**
 * Created by nikol.marku on 03/06/2015.
 */
public abstract class BaseSendScreenshot extends BaseTest implements ISendScreenshot {
    private static final Logger logger = LoggerFactory.getLogger(BaseSendScreenshot.class);

// moved to basetest   public static boolean is_SEND_EMAIL = false; // parseBoolean(System.getProperty("baseReportDir")); //true;
    protected String BASE_URL      ="";             //TEST START URL E.G http://www.englishtown.de/
    protected String memberUrl     ="buy/default/member/";
    protected String pricingUrl    ="";
    protected String paymentUrl    ="";
    protected String aboutusUrl    ="";
    protected String howitWorksUrl ="";
    protected String MARKET   ="";             // E.G DE, IT
    protected String subjectDate = "";
    protected String subject = "[Screenshots] - [";    //"Englishtown Screenshots of main pages, Home, Member, Price&Package, AboutUs, How it Works";
    protected static String filenameStartWith ="";
    protected String selector  =".topbar.container .login-link a";  // default homepage selector
    protected String memberPageSelector ="firstname" ; // de "form_button";  //id
    protected String pricingSelector = ".offer-table-footer a.btn-primary";
    protected String aboutUsSelector = ".child-page div.breadcrumb";
    protected String howItWorksSelector = "a.btn.btn-primary.btn-block";
    protected static List<String> message = new ArrayList();
    protected String emailHeader = "Dear Subscriber,\n\n Find attached the latest screenshots:\n";
    protected static String screenShotFriendlyName = "";
    protected static int screenshotCount = 1;
    protected static int errorCount=0;
    protected static final String[] RUN_TEST_ON_BROWSERS = {"chrome"}; //"firefox", "explore",
    protected String memberSpinnerCss = ".container-fluid .spinner";


    @Test (priority = 0)
    public void getHomePageScreenDumpTest(){
        TestUtil.printMethodName(logger);
        openUrlGetScreenDumpAndAddToMessage(null, By.cssSelector(selector),                              "HomePage" );
    }
    @Test (priority = 1)
    public void getMemberPageScreenDumpTest(){
        TestUtil.printMethodName(logger);
        openUrlGetScreenDumpAndAddToMessage(BASE_URL+memberUrl, By.id(memberPageSelector),               "MemberPage" );
    }

    @Test (priority = 2)
    public void getPricingrPageScreenDumpTest(){
        TestUtil.printMethodName(logger);
        openUrlGetScreenDumpAndAddToMessage(BASE_URL+pricingUrl, By.cssSelector(pricingSelector),         "Pricing" );
    }

    @Test (priority = 3)
    public void getAboutUsPageScreenDumpTest(){
        TestUtil.printMethodName(logger);
        openUrlGetScreenDumpAndAddToMessage(BASE_URL+aboutusUrl, By.cssSelector(aboutUsSelector),        "AboutUs" );
    }

    @Test (priority = 4)
    public void getHowItWorksPageScreenDumpTest(){
        TestUtil.printMethodName(logger);
        openUrlGetScreenDumpAndAddToMessage(BASE_URL+howitWorksUrl, By.cssSelector(howItWorksSelector),  "HowItWorks" );
    }

    /**
     * Lastly send email
     */
    @Test (priority = 10)
    public void sendMailTest(){
        try {
            setIsSendEmailFromSysGetProperties();
            List<String> filenames = SendMail.getFiles(SendMail.SCREENSHOT_DIRECTORY+MARKET+"/");
            if(errorCount == 0){
                //is_SEND_EMAIL=true; //command line argument - use for testing only and comment out setIsEmail...
                if(is_SEND_EMAIL){
                    SendMail.sendMail(SendMail.getToEmail(), subject + MARKET.toUpperCase() + "] - [" +
                            TestUtil.getYYMMDD() + "]", message, SendMail.SCREENSHOT_DIRECTORY, MARKET, filenames);
                }else {
                    logger.info("\n\tSending emails comment only. NO email is sent ...!");
                }
            }else {
                logger.warn("Email Not Send. There are errors, Error count = "+errorCount);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Exception - sendMailTest ...!\n"+e.toString());
            BasePage.failTest(e, "Failed sendMailTest ...!");
        }
    }

    // helpers
    public void openUrlGetScreenDumpAndAddToMessage(String url, By by, String friendlyName ){
        setStartWithAndPicName(friendlyName, MARKET);
        try {
            if(url != null) {
                openUrl(getWebDriver(), url, -1);
                if (url.contains("default/member")) {
                    WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(
                            By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
                }
            }
            waitForConditionAndTakeScreenShot(by);
            logger.info(friendlyName+" Screenshot stored ...!");
            message.add("\t"+screenshotCount +" - "+screenShotFriendlyName+"\n");
            screenshotCount++;
        }catch (Exception e){
            errorCount++;
            logger.error("getScreenDumpAndAddToMessage Exception ...!\n"+e.toString()+TestUtil.getException(e));
        }
    }
    protected void waitForConditionAndTakeScreenShot(By by){
        WaitTool.waitForCondition( ExpectedConditions.visibilityOfElementLocated(by),getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        testUtil.takeScreenshot(getWebDriver(),SendMail.SCREENSHOT_DIRECTORY, MARKET, filenameStartWith );
    }
    protected void setStartWith(String startWith, String market){
        filenameStartWith = startWith+"_"+market+"_";
    }
    protected void setPicFriendlyName(String name){
        screenShotFriendlyName = name;
    }
    protected void setStartWithAndPicName(String name, String market){
        setPicFriendlyName(name);
        setStartWith(name, market);
    }
    protected void setupTestData(){
        this.setupBaseUrl();
        this.setupMarket();
        this.setupUrls();
        this.setSelectors();
    }
    protected void setIsSendEmailFromSysGetProperties(){
        is_SEND_EMAIL = false;
        try {
            is_SEND_EMAIL = parseBoolean(System.getProperty("sendScreenshotEmail"));
            logger.info("set IsSendEmailFromSysGetProperties   is_SEND_EMAIL : "+is_SEND_EMAIL);
        }catch (Exception e){
            logger.error("setIsSendEmailFromSysGetProperties Exception ...! "+e.getMessage());
        }
    }
    protected void setIsSendEmail(boolean isSendEmail){
        is_SEND_EMAIL = isSendEmail;
    }

    @Override
    public void setupBaseUrl(){ }
    @Override
    public void setupUrls(){ }
    @Override
    public void setupMarket(){ }
    @Override
    public void setSelectors(){};
    @Override
    public void setupEmailSubject(){};

}
