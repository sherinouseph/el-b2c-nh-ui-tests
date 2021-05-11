package com.englishlive.tests.responsive.image;
/**
 * Created by nikol.marku on 24/03/2016.
 *
 *
 */
import com.englishlive.tests.responsive.image.core.BaseFullResponsiveImageShownTest;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FullSizeImageShownTest extends BaseFullResponsiveImageShownTest {
    private static final Logger logger = LoggerFactory.getLogger(FullSizeImageShownTest.class);

    protected static String testImgCss = ".adaptiveimage img.img-responsive";


    @BeforeClass
    public void setup() {
        setThreadSafeDriver();
        testUrl = getBASEURL() + testUrl ; //UrlMapper.mapEliveBaseUrlToEtown(getBASEURL()) + testUrl;
        this.openUrl(getWebDriver(), testUrl, -1);
        sleep(3000);
    }

    @Test
    void isImageShown() {
        WebElement imgWe = findElement(By.cssSelector(testImgCss)); // src = http://et1.ef-cdn.com/pt-br/lp/ee/martin-test/_jcr_content/contentPar/adaptiveimage.img.full.medium.jpg/1458756315856.jpg
        if (imgWe == null) {
            BasePage.failTest("Image is not shown and should be ...!" + testImgCss);
        }
        String imgSrc = getAttributeValue(imgWe, "src");
        logger.info("Image src [" + imgSrc + "]");
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }

}


/**
 *
 *
 @Test (dependsOnMethods = {"isImageShown"})
 void isImageShown768WideScreen(){
 resizeScreenAndCheckWebElementShown(getWebDriver(), 768, 1500); //chrome768+17 to make selenium setZize work for view size //751
 }

 @Test (dependsOnMethods = {"isImageShown768WideScreen"})
 void isImageNotShown767WideScreen(){  //src = data:image/gif
 resizeScreenAndCheckWebElementNotShown(getWebDriver(), 767, 1500);
 }
 */

