package com.englishlive.tests.cookie.core;
/**
 * On tablet is a stripe  on desktop is popup
 */

import com.englishtown.enumpack.RectangleSide;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.CookiePage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.number.IsCloseTo.closeTo;


public abstract class BaseCookieWindowTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseCookieWindowTest.class);

    protected CookiePage cookiePage;
    protected String howToManageCookieUrlContains         = "de-de/datenschutzhinweis/";
    protected String howToManageCookiesPageListHeadersCss = ".quote b"; //section headers on how to mange. privacy-policy/
    protected String privacyPageCookieHeaderTxt           = "Cookies";
    protected final int EXPECTED_COOKIE_HEADER_MIN_Y    = 71; // Y axis between
    protected final int EXPECTED_COOKIE_HEADER_MAX_Y    = 112;
    protected String mainNavLogoCss = ".logo a";
    protected String homePageUrlEndsWith = "/de-de/";
    protected boolean isMobileExperience = false; // if is mobile cookie shown as stripe
    protected final int regulator = 10;


    @Test
    public void checkCookieWindowShown(){
        cookiePage = new CookiePage(getWebDriver());
        cookiePage.fullTest();        //String weTopBeforeClick = executeJSscript("return document.querySelectorAll('.bs3 .btn.btn-primary')[2].getBoundingClientRect().top", getWebDriver(), 5);
                                       //getWebElementRectangleCoordinate(getWebDriver(), RectangleSide.RIGHT, cookiePage.getMainCookieWeCss(), 0);
        logger.info(cookiePage.getCookieDesc());
    }
    //stripe on mobiles
    @Test(dependsOnMethods = "checkCookieWindowShown")
    public void checkDesktopOrMobileExp(){
        sleep(2000);
        int cookiePopupRSideCoordinate = getWebElementRectangleCoordinate(getWebDriver(), RectangleSide.RIGHT, cookiePage.getMainCookieWeCss(), 0);
        String windowViewWidthStr = executeJSscript("return document.documentElement.clientWidth", getWebDriver(), 5);
        int windowViewWidth = -1;
        try {
            if(StringUtils.isBlank(windowViewWidthStr)){
                failTest("Could not get windowViewWidthStr ... document.documentElement.clientWidth Failed ...!");
            }
            windowViewWidth = Integer.parseInt(windowViewWidthStr);
        }catch (NumberFormatException nfe){
            logger.error("Integer.parseInt exception ...!["+windowViewWidthStr+"]; "+ nfe.getMessage());
            failTest("Could not parse string to int ...! ["+windowViewWidthStr+"]");
        }        //Point cookiePoint = ((RemoteWebElement) cookieHeaderWe).getCoordinates().inViewPort();

        if(windowViewWidth == -1)
            failTest("Could not get windowViewWidth - it is the default -1  ... document.documentElement.clientWidth Failed ...!");

        logger.info("cookiePopupRSideCoordinate ["+cookiePopupRSideCoordinate+"]");
        logger.info("windowViewWidthStr ....... ["+windowViewWidthStr+"]");
        if(isMobileExperience){
            AssertHelper.assertThat("Cookie is not show as stripe for Mobile experience ...!",
                    (double)cookiePopupRSideCoordinate, is(closeTo(windowViewWidth+regulator , windowViewWidth-regulator )));
        }else {
            AssertHelper.assertThat("Cookie is not show as stripe for Mobile experience ...!",
                    cookiePopupRSideCoordinate, lessThan(windowViewWidth-300));
        }
    }

    @Test(dependsOnMethods = "checkDesktopOrMobileExp")
    public void clickHowToManageLinkAndCheckPage(){
        click(cookiePage.manageCookieWe);
        assertIsUrlContaining(howToManageCookieUrlContains);
    }

    // Cookie Section should be under the main nav
    @Test(dependsOnMethods = "clickHowToManageLinkAndCheckPage")
    public void checkCookieSectionShowJustUnderMainNav(){
        List<WebElement> sectionListHeaders = WaitTool.findElements(getWebDriver(),
                By.cssSelector(howToManageCookiesPageListHeadersCss));
        WebElement cookieHeaderWe = getWebElementFromList(getWebDriver(),sectionListHeaders,privacyPageCookieHeaderTxt);
        Point wePoint = ((RemoteWebElement) cookieHeaderWe).getCoordinates().inViewPort();

        logger.info("Should be between ["+EXPECTED_COOKIE_HEADER_MIN_Y+"; "+EXPECTED_COOKIE_HEADER_MAX_Y+"] ;" +
                " element poin is ["+wePoint.toString()+"]");
        Double weYaxis = new Double(wePoint.getY());

        AssertHelper.assertThat("Cookie anchor is not with in expected range",
                weYaxis, is(closeTo(EXPECTED_COOKIE_HEADER_MIN_Y, EXPECTED_COOKIE_HEADER_MAX_Y)));
    }

    @Test(dependsOnMethods = "clickHowToManageLinkAndCheckPage")
    public void closeCookie(){
        cookiePage = new CookiePage(getWebDriver());
        cookiePage.closeCookie();
        cookiePage.isCookieNotShown();
    }

    @Test(dependsOnMethods = "closeCookie")
    public void goToHomePageCheckCookieNotShown(){
        click(getWebDriver(), By.cssSelector(mainNavLogoCss));
        AssertHelper.assertThat("URL does not ends with the expected string ....!"+homePageUrlEndsWith,
                BasePage.isUrlWitWaitToEndWith(getWebDriver(), homePageUrlEndsWith, 15), is(true));
        cookiePage = new CookiePage(getWebDriver());
        //cookiePage.simpleTest();
        cookiePage.isCookieNotShown();
    }


}
