//package com.englishlive.tests.newsite.market.mx;
///**
// *
// * Mobile view/resize
// * Open https://englishlive.ef.com/es-mx/como-aprender-ingles/
// * scroll XX px
// * click on .second-navigation-bar    second nav expands
// * click on 4th nav itm .second-navigation-bar li
// * .step-container the forth element is just under second nav +-OVERLAP_THRESHOLD
// *
// *
// */
//import com.englishlive.tests.newsite.core.BaseNewSite;
//import com.englishtown.enumpack.RectangleSide;
//import com.englishtown.helpers.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.Matchers.lessThan;
//
//// mx page changed so remove
//public class MxSecondaryNavTest extends BaseNewSite {
//    private static final Logger logger = LoggerFactory.getLogger(MxSecondaryNavTest.class);
//
//    //@Value("#{applicationPropertiesList['home.page.mx']}")
//    protected String testUrl = "https://englishlive.ef.com/es-mx/como-aprender-ingles/";
//
//    public static String secondaryNavCss  = ".second-navigation-bar";  //document.querySelectorAll('.second-navigation-bar')[0].getBoundingClientRect().bottom
//    public static String secondaryNavItemsCss = ".second-navigation-bar li";
//    public static String stepConatinerCss  = ".step-container";  //document.querySelectorAll('.step-container')[3].getBoundingClientRect().bottom
//    public int sectionId = 3;
//    public static final int OVERLAP_THRESHOLD = 6 ; // USE THIS TO CHECK IF SECTION OVERLAP
//
//
//    @BeforeClass
//    protected void setupGoToSectionMenu(){
//        setThreadSafeDriver();
//        String[] browserList = {"chrome"} ;
//        failTestIfIsNotBrowser(browserList, "Run chrome only TEST ...!");
//        runTestCheckTryUs = false;
//        runTestGotoPPpage = true;
//        Dimension windowSize = new Dimension(600, 900);
//        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),windowSize );
//        openUrl(getWebDriver(), testUrl); sleep(3000);
//        WebElement secondNavWe = findElement(By.cssSelector(secondaryNavCss));
//        JavaScriptHelper.scrollWebElementToView(getWebDriver(), secondNavWe,  ElementScreenPosition.TOP, 0);
//        sleep(300);
//        click(secondNavWe);
//        sleep(3000);
//        List<WebElement> secondNavListWe = WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(secondaryNavItemsCss), 15 );
//        click(secondNavListWe.get(sectionId));
//        sleep(5000);
//    }
//
//    @Test
//    public void testSecondNavAndSectionDontOverlap(){
//        int secondNavBottom    = getWebElementRectangleCoordinate(getWebDriver(), RectangleSide.BOTTOM , secondaryNavCss, 0);
//        int forthSectionTop    = getWebElementRectangleCoordinate(getWebDriver(), RectangleSide.TOP , stepConatinerCss, sectionId);
//        logger.info("secondNavBottom :"+secondNavBottom+" - forthSectionTop :"+forthSectionTop);
//        AssertHelper.assertThat("Section is not under secondary nav; +-"+OVERLAP_THRESHOLD+" pixel of :"+secondNavBottom,
//                forthSectionTop, allOf(greaterThan(secondNavBottom-OVERLAP_THRESHOLD),lessThan(secondNavBottom+OVERLAP_THRESHOLD)));
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
