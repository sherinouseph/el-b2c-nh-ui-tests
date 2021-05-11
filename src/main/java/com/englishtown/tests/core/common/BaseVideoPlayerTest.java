package com.englishtown.tests.core.common;
/**
 * Created by nikol.marku on 4/5/2017.
 * Video start auto play
 *
 * EFYouTubeVideoPlayerTest
     .openVideoPage
     .clickPlayVideoTest
     .moveToVideoIframeSetVideoTimeAndDuration
     .checkVideoPlaytimeChanges
     .checkVideoTimeNotZero
     .closeVideoPopup
 *
 */
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.component.core.YoutubeVideoPage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.ISharedConfiguration;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public abstract class BaseVideoPlayerTest extends BaseTestHelper implements ISharedConfiguration{
    private static final Logger logger = LoggerFactory.getLogger(BaseVideoPlayerTest.class);
    protected String pageURL ;
    protected String videoURL;

    private YoutubeVideoPage youtubeVideoPage;

    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected By videoSelectorWithSrcTag;
    protected String playSelectorCss  = ".StartVideoNikol";
    protected String youTubeIframeCss = "body iframe#widget2"; //".youtube-video-compent iframe";
    protected String closeVideoCss = ".layerContent .close";

    protected Object videoPlayTime, newVideoPlayTime, videoDuration;


    @Test
    void openVideoPage() {
        TestUtil.printMethodName(logger);
        setPageURL();
        openUrl(getWebDriver(), pageURL);
        sleep(1000);
    }

    @Test (dependsOnMethods = "openVideoPage" )
    void clickPlayVideoTest() {
        TestUtil.printMethodName(logger);
        WebElement play1Circle = getWebDriver().findElement(By.cssSelector(playSelectorCss));        //JavaScriptHelper.scrollWebElementToView(getWebDriver(), play1Circle, ElementScreenPosition.MIDDLE, 0);        //BaseTest.sleep(500);
        play1Circle.click();
        BaseTest.sleep(3000);
    }

    @Test (dependsOnMethods = "clickPlayVideoTest" )
    void moveToVideoIframeSetVideoTimeAndDuration() {
        TestUtil.printMethodName(logger);
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 25);
        WebElement playerIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(youTubeIframeCss)));        //WebElement playerIframe = JavaScriptHelper.jsGetAllElements(youTubeIframeCss, driver);
        getWebDriver().switchTo().frame(playerIframe);
        BaseTest.sleep(500);
        MyWebDriverAction.mouseOver(getWebDriver(), findElement(By.id("player")));
        BaseTest.sleep(500);

        jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript(JavaScriptHelper.JS_PAUSE_YOUTUBE_VIDEO);

        youtubeVideoPage = new YoutubeVideoPage(getWebDriver());
        youtubeVideoPage.simpleTest();
        logger.info(".........");
        videoPlayTime = youtubeVideoPage.currentPlayedTimeWe.getText().trim();
        videoDuration  = youtubeVideoPage.playTimeDurationWe.getText().trim();
        /*boolean isVideoError = false;
        try {
            getWebDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            Object videoError = jse.executeAsyncScript(JavaScriptHelper.JS_YOUTUBE_VIDEO_ERROR);
        }catch (Exception e){
            isVideoError = true;
            logger.error("Error with video: "+e.getMessage());
        }*/
        logger.info("videoPlayTime: "+videoPlayTime+"; videoDuration: "+videoDuration); //+";  isVideoError ["+isVideoError+"]");

        jse.executeScript(JavaScriptHelper.JS_PLAY_YOUTUBE_VIDEO);
        BaseTest.sleep(10000);
        jse.executeScript(JavaScriptHelper.JS_PAUSE_YOUTUBE_VIDEO);
        BaseTest.sleep(1000);
        youtubeVideoPage = new YoutubeVideoPage(getWebDriver());
        youtubeVideoPage.simpleTest();
        newVideoPlayTime = youtubeVideoPage.currentPlayedTimeWe.getText().trim();
        logger.info("videoPlayTime: "+newVideoPlayTime);
    }

    @Test (dependsOnMethods = "moveToVideoIframeSetVideoTimeAndDuration" )
    void checkVideoPlaytimeChanges() {
        TestUtil.printMethodName(logger);
        AssertHelper.assertThat("Video play time should change but has not ....!", videoPlayTime, is(not(newVideoPlayTime)));
    }

    @Test (dependsOnMethods = "moveToVideoIframeSetVideoTimeAndDuration" )
    void checkVideoTimeNotZero() {
        TestUtil.printMethodName(logger);

        if(null == videoDuration)
            failTest("Video Duration is NULL ...!");

        AssertHelper.assertThat("Video duration is empty or null, or cant get it ....!",
                videoDuration.toString(), is(not(isEmptyOrNullString())) );

        int videoTime = 0;

        try{
            videoTime = Integer.parseInt(StringUtils.replace(videoDuration.toString().trim(), ":", ""));
        }catch (Exception e){
            failTest(e.getMessage());
        }

        AssertHelper.assertThat("Video duration is zero ...!", videoTime, greaterThan(0) );
        BaseTest.sleep(2000);
    }

    @Test (dependsOnMethods = "checkVideoTimeNotZero" )
    void closeVideoPopup() {
        getWebDriver().switchTo().defaultContent();
        sleep(1000);
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(closeVideoCss));
        waitForElementCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(closeVideoCss)),getWebDriver(), 7);

    }


    //************************************************************
    protected abstract void setPageURL();
   //protected abstract void setVideoSelectorWithSrcTag();


    protected void setVideoURL(){
        WebElement videoElementWithVideoSrc = getWebDriver().findElement(videoSelectorWithSrcTag); //By.id("video_iframe"));
        videoURL = videoElementWithVideoSrc.getAttribute("src");
        logger.info("Video src ... Url [" + videoURL+"] ...!");
    }

}