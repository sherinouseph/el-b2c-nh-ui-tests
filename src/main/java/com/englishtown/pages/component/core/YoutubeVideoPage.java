package com.englishtown.pages.component.core;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.ForgottenPassPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 12/29/2016.
 * on "https://qa-englishlive.ef.com/en-gb/learn-english-online/online-english-teacher/";
 * click on play video on the bottom opens an Iframe
 * This page object represent that Iframe with the video WebElements
 *
 */
public class YoutubeVideoPage extends BaseComponentPage {
    public static final Logger logger = LoggerFactory.getLogger(YoutubeVideoPage.class);
    public String relativePageUrl = "";

    //# Main page component
    /*public static final String youTubeIframeCss = "body iframe#widget2";                                                           // use this to switchTo iFrame ...   or ".youtube-video-compent iframe";
    public static final String playSelectorCss  = ".indicator svg";
    public static final String closeVideoCss    = ".layerContent .close";*/

    //# video Iframe component ... all inside iFrame ... from youtube
    private static final String playerCss            = "#player";                            // main player web component pause and play by clicking on it
    private static final String playVideoBtnCss      = playerCss+" button.ytp-play-button";
    private static final String playTimeDurationCss  = playerCss+" .ytp-time-duration";      // use get text
    private static final String currentPlayedTimeCss = playerCss+" .ytp-time-current";
    private static final String progressBarCss       = playerCss+" .ytp-progress-bar";


    /**
     * Main components
     */
    @FindBy(css = playerCss)
    public WebElement playerWe;

    @FindBy(css = playVideoBtnCss)   // this could be on the state of Play or Pause
    public WebElement playVideoBtnWe;

    @FindBy(css = playVideoBtnCss+"[aria-label=Play]" )  // video is not playing
    public WebElement playVideoBtnPauseStateWe;

    @FindBy(css = playVideoBtnCss+"[aria-label=Pause]" )  // video is playing
    public WebElement playVideoBtnPlayStateWe;

    @FindBy(css = playTimeDurationCss)
    public WebElement playTimeDurationWe;

    @FindBy(css = currentPlayedTimeCss)
    public WebElement currentPlayedTimeWe;

    @FindBy(css = progressBarCss)
    public WebElement progressBarWe;

    @FindBy(css = ".message.alert.alert-danger")
    public WebElement loginFailedMsgWe;


    public YoutubeVideoPage(WebDriver webDriver){
        super(webDriver);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(playerWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(playerWe);
    }

    public void mouseOverPlayer(WebDriver driver){
        MyWebDriverAction.mouseOver(driver, playerWe);
    }


    public void play( ){
        click(playVideoBtnPauseStateWe);
    }

    public void pause( ){
        click(playVideoBtnPlayStateWe);
    }



}
