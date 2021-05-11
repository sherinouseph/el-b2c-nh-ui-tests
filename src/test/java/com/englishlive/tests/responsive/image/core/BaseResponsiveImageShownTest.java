package com.englishlive.tests.responsive.image.core;
/**
 * Check image src contains data:image ... and this is not an image from a source file
 *
 */

import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseResponsiveImageShownTest extends BaseResponsiveImage {
    private static final Logger logger = LoggerFactory.getLogger(BaseResponsiveImageShownTest.class);
    protected String imgSrcContains = "data:image/gif";


    @Test
    void isResponsiveImageShown() { // no request send ; use data image ... small invisible....
        //resizeScreenAndCheckWebElementNotShown(getWebDriver(), 767, 1500);
        logger.info("Check image src contains [ data:image/gif ]");
        WebElement imgWe = WaitTool.findElements(getWebDriver(), By.cssSelector(testImgCss)).get(0); //".adaptiveimage img.img-responsive";
        checkImageSrcValueContains(imgWe, imgSrcContains );
    }


}