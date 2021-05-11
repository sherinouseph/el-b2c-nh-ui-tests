package com.englishtown.pages.common.core;
/**
 * New website ... homepage , howitworks, price login, try ... etc
 * User: nikol.marku
 *  *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.MyBasePage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.number.OrderingComparison.greaterThan;


public class BaseHeaderAndFooterPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(BaseHeaderAndFooterPage.class);
    public static int FOOTER_SIZE = 15; // the minimun number of links in the footer
      /**
     * Main components
     */
    @FindBy(css = "nav.primary")       //".navigation-bar nav")
    public WebElement headerTopNav;  //primary nav

    @FindBy(css = ".logo img") //class=logo
    public List<WebElement> logoList;  // 2 top and bottom //PC and Mob/TAB

    @FindBy(css = ".logo a")
    public WebElement logoAtag;

    @FindBy(tagName = "footer")
    public WebElement footer;

    @FindBy(css = "footer li")
    public List<WebElement> footerAllLinks;   // note countries are invisible

    @FindBy(css = "footer .links li")   //     HELP CONTACT US PRIVACY POLICY CHANGE COUNTRY
    public List<WebElement> footerLinks;

    @FindBy(css = ".icon.icon-burger")   // mobile menu icon
    public WebElement mobileMenuIcon;


    @FindBy(css = ".flag-icon.dynamic-country")   //change country flag
    public WebElement changeCountryFlagIcon;

    public BaseHeaderAndFooterPage(WebDriver webDriver){
        super(webDriver);
    }
    public BaseHeaderAndFooterPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BaseHeaderAndFooterPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() footerAllLinks.size() :"+footerAllLinks.size());
        if (StringUtils.isBlank(BaseRemoteWebDriver.getCurrentDeviceName() )) {
            List <WebElement> visibleFooterLinks = WaitTool.getVisibleElements(getWebDriver(), WaitTool.findElements(
                    getWebDriver(), By.cssSelector(WebElementHelper.getElementLocator(footerAllLinks.get(0))))); // JavaScriptHelper.jQuery_getVisibleElements("footer li", getWebDriver(), 5, false);
            int footerLinkSize = -1;

            if(!CollectionUtils.isEmpty(visibleFooterLinks) ) {
                footerLinkSize = visibleFooterLinks.size();
            }
            logger.info(" webElements.size :"+footerLinkSize);
            logger.info("BaseRemoteWebDriver.getCurrentDeviceName [{}] ",BaseRemoteWebDriver.getCurrentDeviceName());
            //if (StringUtils.isBlank(BaseRemoteWebDriver.getCurrentDeviceName() )) {
            logger.info(" is not mobile device so running simple test ....!");
            AssertHelper.assertWebElementDisplayed(headerTopNav);     ///AssertHelper.assertThat("Top navigation in the header should be displayed ...!", headerTopNav.isDisplayed(), is(true));
            AssertHelper.assertWebElementDisplayed(footer);          //AssertHelper.assertThat("footer should be displayed ...!", footer.isDisplayed(), is(true));
            AssertHelper.assertThat("footer should be displayed ...!", footerLinkSize, greaterThan(FOOTER_SIZE));
        }else {
            logger.info("Is Mobile device so no simple test run ....!");
            AssertHelper.assertWebElementDisplayed(mobileMenuIcon);
        }
        return true;
    }

    public boolean simpleMobileTest() {
        logger.info("simpleMobileTest check mobileMenuIcon ....!");
        AssertHelper.assertWebElementDisplayed(mobileMenuIcon);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(headerTopNav);
    }

    public void clickMobileMenuIcon(){
        logger.info("clickMobileMenu ...!");
        click(mobileMenuIcon);
    }

}