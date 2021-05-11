package com.englishtown.tests.core.responsivecore;
/**
 * Base test helpers for responsive design
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseResponsiveHelper extends BaseTest {
     private static final Logger logger = LoggerFactory.getLogger(BaseResponsiveHelper.class);
     public static String GET_WINDOW_INNER_HEIGHT_JS = "return window.innerHeight";
     public static String GET_WINDOW_OUTER_HEIGHT_JS = "return window.outerHeight";
     public static String GET_WINDOW_INNER_WIDTH_JS  = "return window.innerWidth";
     public static String GET_WINDOW_OUTER_WIDTH_JS  = "return window.outerWidth";
     public static int browserWindowHeightPads = 0; // browser window - doc window
     public static int browserWindowWidthPads  = 0;

     // getters and setters
     public int getWindowInnerHeightJs(WebDriver driver) {
      return TestUtil.getIntFromString(executeJSscript(GET_WINDOW_INNER_HEIGHT_JS, driver, 3));
     }
     public int getWindowOuterHeightJs(WebDriver driver) {
      return TestUtil.getIntFromString(executeJSscript(GET_WINDOW_OUTER_HEIGHT_JS, driver, 3));
     }
     public int getWindowInnerWidthJs(WebDriver driver) {
      return TestUtil.getIntFromString(executeJSscript(GET_WINDOW_INNER_WIDTH_JS, driver, 3));
     }
     public int getWindowOuterWidthJs(WebDriver driver) {
      return TestUtil.getIntFromString(executeJSscript(GET_WINDOW_OUTER_WIDTH_JS, driver, 3));
     }



}


// ref  http://jagadeeshmanne.blogspot.in/2014/03/checking-website-is-responsive-or-not.html
/**
 1. Screenshot comparison : Using selenium webdriver go to the given website url and change the browser to different sizes and compare the screenshots.If both screenshots are same then the given website is not responsive.If both screenshots are different then given website is responsive. This method is not good because Lets assume if slideshows are present in given website while taking the screenshots of that website, the slideshow images present in the given website may change and we will get different screenshots so if we compare the screenshots we will get result as both screenshots are different and we may get response as the given site is responsive

 2. The document width : Using selenium webdriver go to the given website url and change the browser to mobile device size and execute the javascript to get document width. If width is less than mobile devices maximum width we can assume that the given website is responsive

 3. Screenshot width : Using selenium webdriver go to the given website url and change the browser to mobile device size and take the screenshot and get the width of the screenshot image. If width is less than mobile devices maximum width we can assume that the given website is responsive. I tested multiple sites with this approach and got the expected result Steps to check given site is responsive or not

 1. Add selenium dependencies in BuildConig.groovy
 ?
 1
 2
 3
 4
 5
 compile 'org.seleniumhq.selenium:selenium-support:2.15.0'
 compile 'org.seleniumhq.selenium:selenium-htmlunit-driver:2.25.0'
 runtime('org.seleniumhq.selenium:selenium-java:2.29.1'){
 excludes "selenium-htmlunit-driver"
 }

 2. Create firefoxprofile
 ?
 1
 2
 DesiredCapabilities capabilities = new DesiredCapabilities("firefox", "3.6.", Platform.LINUX);
 FirefoxProfile profile = new FirefoxProfile();

 3. Create Remote Web Driver by specifying selenium server url
 ?
 1
 driver = new RemoteWebDriver(new java.net.URL("http://127.0.0.1:4444//wd/hub"), capabilities);

 4. Set the window size to mobile device size
 ?
 1
 driver.manage().window().setSize(new Dimension(320, 480))

 5. Open the url
 ?
 1
 driver.get(urlString)

 6. Method 1 : Take the Screenshot and get the width of the screenshot. RemoteDriver doesnt implement the TAkeScreenShot class. If the driver does have the Capabilities to take a screenshot.Then Augmenter will add the TakesScreenshot methods to the instance
 ?
 1
 2
 3
 File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 BufferedImage bufferedImage = ImageIO.read(screenShot);
 int width = bufferedImage?.width

 Method 2 : Execute the javascript and get the document width
 ?
 1
 2
 JavascriptExecutor js = (JavascriptExecutor)driver;
 int width = js.executeScript("return \$(document).width()")

 7. Compare the width with mobile device maximum width
 ?
 1
 2
 //Asuming mobile device width is 480
 boolean isResponsive = (width <= 480)

 */