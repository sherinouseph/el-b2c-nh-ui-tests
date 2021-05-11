package com.englishtown.tests.core.landingpages;
/**
 * Open URL : http://www.englishtown.fr/lp/oe/anglais-en-ligne/
 * Click Test notre demo
 * validate video shown
 *
 * Created by nikol.marku on 14/07/2015.
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.pages.landing.OELandingPage;
import com.englishtown.tests.core.BaseOELandingPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;


public class BaseVideoDemo extends BaseOELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseVideoDemo.class);

    protected static String testDemoCss = ".cta-in-stage .btn-primary-blue";
    protected static String videoIframe = ".school-demo iframe";
    protected static String videoSpiner ="#svg-loader";
    protected static String videoId     = "contentPar_columnscontrol_column0_spacer-5"; //"et-video-demo";
    protected static int frameId = 1;
    protected static String iFrammeId = "destination_publishing_iframe_efenglishtown_undefined";
    //$('iframe[src*=demo]').contents().find('#et-video-demo')

    @Test
    public void clickTestDemoButton(){
        click(getWebDriver(), By.cssSelector(testDemoCss));
        sleep(3000);
    }

    @Test
    public void isDemoVideoShown(){
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(videoIframe)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
       // WebDriverWait wait = new WebDriverWait(getWebDriver(), 15, 1);                                                 //            WebDriverWait wait = new WebDriverWait(webdriver, waitTime,DEFAULT_POLL_SLEEP);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(videoSpiner)));
        waitForElementCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(videoSpiner)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        WebDriverWindowHelper.switchToFrameByFrameElementId(getWebDriver(), iFrammeId);
//        WebElement webElement = findElement(By.cssSelector("iframe #et-video-demo"));// AssertHelper.assertThat(" Check WE not null ...!", webElement != null);
//        waitForElementCondition(ExpectedConditions.visibilityOf(webElement), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }


//    @Override
//    public  void verifyLanguage(){logger.warn("verifyLanguage - This test is set not to run ...!");}
//    @Override
//    public  void verifyMarket(){logger.warn("verifyMarket - This test is set not to run ...!");}
    /*@Override    public void isTrackingEfEducationFirst(){ logger.warn("isTrackingEfEducationFirst - This test is set not to run ...!");    }*/
}
