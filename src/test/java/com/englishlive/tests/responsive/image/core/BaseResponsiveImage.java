package com.englishlive.tests.responsive.image.core;
/**
 * Created by nikol.marku on 24/03/2016.
 *
 * OPen test page
 * check image not shown if screen size less than W : 768px
 * https://jira-bos.englishtown.com/browse/SAND-2876
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.login.BaseMobileHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseResponsiveImage extends BaseMobileHelper{
    private static final Logger logger = LoggerFactory.getLogger(BaseResponsiveImage.class);
    protected String testUrl = "englishlive.ef.com/pt-br/lp/ee/automated-responsive-image-test-only/" ; //martin-test/";
    protected static String testImgCss = ".adaptiveimage img.img-responsive";


    public void resizeScreenAndCheckWebElementNotShown(WebDriver driver, int width, int hight){
        Dimension screenSize = new Dimension(width+16, hight);// need to add 17 for chrome as zize works on window size not the innerWidht
        driver.manage().window().setSize(screenSize);
        sleep(1000);
        WebElement imgWe =WaitTool.safeFindDisplayedAndEnabled(driver, By.cssSelector(testImgCss), 15 ) ;

    }
    public void resizeScreenAndCheckWebElementShown(WebDriver driver, int width, int hight){
        Dimension screenSize = new Dimension(width+17, hight);
        driver.manage().window().setSize(screenSize);
        sleep(3000);
        WebElement imgWe =WaitTool.safeFindDisplayedAndEnabled(driver, By.cssSelector(testImgCss), 15 ) ;
        if(imgWe == null){
            BasePage.failTest("Image is Not shown and should be ...!"+testImgCss);
        }
    }

    /**
     * Check the src attribute contains value
     * if > http:// then is real image if > "data:image/gif" is the smollest invisible iamge
     * @param imgWe
     * @param imageSrcContains
     */
    public void checkImageSrcValueContains(WebElement imgWe, String imageSrcContains){
        String imgSrc = getAttributeValue(imgWe, "src");
        logger.info("Image src ["+imgSrc+"]  - Should contain ["+imageSrcContains+"]");
        AssertHelper.assertThat("Image src ["+imgSrc+"] Does Not Contains ["+imageSrcContains+"] ...! this test should run on Mobile only ...",
                StringUtils.contains(imgSrc, imageSrcContains));
    }
}




//    @BeforeClass
//    public void setup() {
//        testUrl = UrlMapper.mapEliveBaseUrlToEtown(getBASEURL())+testUrl;
//        this.openUrl(getWebDriver(), testUrl, -1);
//        sleep(3000);
//    }
//
//    @Test
//    void isImageShown(){
//        WebElement imgWe = findElement(By.cssSelector(testImgCss) ) ; // src = http://et1.ef-cdn.com/pt-br/lp/ee/martin-test/_jcr_content/contentPar/adaptiveimage.img.full.medium.jpg/1458756315856.jpg
//        if(imgWe == null){
//            BasePage.failTest("Image is not shown and should be ...!"+testImgCss);
//        }
//        String imgSrc = getAttributeValue(imgWe, "src");
//        logger.info("Image src ["+imgSrc+"]");
//    }
//    @Test (dependsOnMethods = {"isImageShown"})
//    void isImageShown768WideScreen(){
//        resizeScreenAndCheckWebElementShown(getWebDriver(), 768, 1500); //chrome768+17 to make selenium setZize work for view size //751
//    }
//
//    @Test (dependsOnMethods = {"isImageShown768WideScreen"})
//    void isImageNotShown767WideScreen(){  //src = data:image/gif
//        resizeScreenAndCheckWebElementNotShown(getWebDriver(), 767, 1500);
//    }