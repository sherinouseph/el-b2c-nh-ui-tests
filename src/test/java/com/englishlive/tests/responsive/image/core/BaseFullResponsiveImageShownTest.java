package com.englishlive.tests.responsive.image.core;
/**
 * Check image src contains "http://"... this is an image from a source file
 *
 */
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseFullResponsiveImageShownTest extends BaseResponsiveImage {
    private static final Logger logger = LoggerFactory.getLogger(BaseFullResponsiveImageShownTest.class);
    protected String imgSrcContains = "https://";


    @Test
    void isFullImageShown() {
        WebElement imgWe = findElement(By.cssSelector(testImgCss));
        if (imgWe == null) {
            BasePage.failTest("Image is not shown and should be ...!" + testImgCss);
        }
        checkImageSrcValueContains(imgWe, imgSrcContains );
    }


}