package com.englishlive.tests.responsive.image.core;
/**
 * Created by nikol.marku on 10/21/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3205
 * Story : Page responsive when resized, Image get smaller
 1. Open x home page
 2. Resize browser to 400 x 600
 2.a and remove overflow $('body').css('overflow-x', 'visible')
 3. Check NO horizontal scroll bar shown
 4. Resize browser to 1300 x 900
 4. Check horizontal scroll bar shown
 *
 *  var hasScrollbar = window.innerWidth > document.documentElement.clientWidth  var scrollElement = (document.scrollingElement || document.documentElement)
    horizontal bar shown when :      $(scrollElement).width()) < $(scrollElement)[0].scrollWidth) and not shown when they equal
 *
 *  Note : this is not a mobile device screen as it will go to mobile home page and that has no images
 *
 */
//import com.englishlive.tests.screenshot.DeSendScreenshot;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;


public abstract class BaseScreenResizeShowScrollBar extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseScreenResizeShowScrollBar.class);

    protected final int smallViewWidth  = 450;
    protected final int smallViewHeight = 650;
    protected final int bigWidth  = 1350; // size that show horizontal scroll in this page
    protected final int bigHeight = 850;
    protected final String removeOverflowJS = "$('body').css('overflow-x', 'visible')";


    @Test
    void checkNoHorizontalScrollShow(){
        AssertHelper.assertThat("No Horizontal bar should be shown here ...!",
                JavaScriptHelper.isScrollBarShown(getWebDriver(), false),is(false));
    }

    @Test (dependsOnMethods = "checkNoHorizontalScrollShow", description = "Resize and check horizontal bar shown")
    void checkHorizontalScrollBarShown(){
        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(), bigWidth, bigHeight);
        sleep(1000);
        AssertHelper.assertThat("Horizontal bar should be shown here  and is NOT...!",
                JavaScriptHelper.isScrollBarShown(getWebDriver(), false),is(true));
    }


}
