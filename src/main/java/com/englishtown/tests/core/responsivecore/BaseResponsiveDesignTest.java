package com.englishtown.tests.core.responsivecore;
/**
 * Test for Responsive design
 *
 * Created by nikol.marku on 01/06/2015.
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;


public abstract class BaseResponsiveDesignTest extends BaseResponsiveHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseResponsiveDesignTest.class);

    protected boolean assertMe = true;
    protected String screenShotTestName="";
    protected String fileName="";
    protected String selectorCss = "should be set by test";
    protected  int regulator = 0;    // window size regulator as set size set the size of window and not inner documment  // X is less than  Window width - 100)

    protected static String SCREENSHOT_DIRECTORY = TestUtil.SCREENSHOT_DIRECTORY+"responsive/";

    @Test(dataProvider = "getWindowDimensions", dataProviderClass = ResponsiveDesignDataProvider.class )
    public void checkResponsiveDesignByResizingTheWindow(String comment, Dimension dimension) throws Exception{
        if(!BaseRemoteWebDriver.isMobileDevice) {
            testResponsiveDesign(comment, dimension, true);
        }else {
            logger.info(" Is mobile device - No need to run this test ...!");
        }
    }


    public void testResponsiveDesign(String comment, Dimension windowDimension, boolean takeScreenshotEachStep){
        int elementX    = 0;    // webelement x
        int windowWidth = 0;

        logger.info(comment+" Set Window Sise to - W="+windowDimension.getWidth() + " ;  H="+windowDimension.getHeight());
        windowWidth = windowDimension.getWidth();
        setBrowserPads(getWebDriver());
        windowDimension= new Dimension( windowDimension.getWidth() + browserWindowWidthPads,
                                        windowDimension.getHeight()+ browserWindowHeightPads);

        getWebDriver().manage().window().setSize(windowDimension);
        sleep(300);
        Dimension newWindowDimension = getWebDriver().manage().window().getSize();
        logger.info(" Window size is now : X = "+newWindowDimension.getWidth()+" - Y = "+newWindowDimension.getHeight());
        if(assertMe) {
            WebElement we = findElement(By.cssSelector(selectorCss));
            if(we != null ) {
                elementX = we.getLocation().getX();
                logger.info("we.getLocation().getX() X : " + elementX + " Y : " + we.getLocation().getY());
            } else {
                BasePage.failTest("Cant find WebElement ...!", we, false);
            }
        }
        fileName = screenShotTestName.trim()+"_"+comment;
        logger.info("fileName is : " + fileName);
        testUtil.takeScreenshot(fileName, getWebDriver(), false);
        if(assertMe) {
            AssertHelper.myAssertThat(getWebDriver(), "" + comment + "  Element X point is not less than window size ...!",
                    elementX, lessThan(windowWidth - regulator), true);
        }

    }

    protected void setBrowserPads(WebDriver driver){
        browserWindowHeightPads = getWindowOuterHeightJs(driver) - getWindowInnerHeightJs(driver);
        browserWindowWidthPads   = getWindowOuterWidthJs(driver) - getWindowInnerWidthJs(driver);
        //logger.info(" " +getWindowOuterHeightJs(driver) +" - "+ getWindowInnerHeightJs(driver) +" - "+ getWindowOuterWidthJs(driver) +" - "+ getWindowInnerWidthJs(driver));
        logger.info("browserWindowHeightPads :"+browserWindowHeightPads +" - browserWindowWidthPads :"+browserWindowWidthPads);
    }


}
