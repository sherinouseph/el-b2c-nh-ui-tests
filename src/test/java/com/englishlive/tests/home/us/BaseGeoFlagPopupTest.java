package com.englishlive.tests.home.us;
/**
 * Created by sherin 14/09/2017
 * open en-us
 * click en-gb flag and see if we redirect to en-gb site(geolocated country)
 * click on en-us flag and see if we are in the same url(en-us/site-country)
 * close the popup,check if you are in same-url(en-us/site-country)
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.core.StringContains.containsString;

public abstract class BaseGeoFlagPopupTest extends BaseTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(BaseGeoFlagPopupTest.class);

    protected String closebutton         = ".close.close--common";
    protected String geo_countryselector = ".geolocated.flag";
    protected String site_countryselctor = ".site.flag";
    protected String urlContains         = "en-us";
    protected String geourlcontains      = "en-gb";


    @Test()
    public void checkThePresenceofGeoFlag() {
        logger.info("Checking for the presence of Geo Located Country Flag");
        WebElement geoflag = findElement(By.cssSelector(geo_countryselector));
        AssertHelper.assertWebElementDisplayed(geoflag);
    }

    @Test(dependsOnMethods = "checkThePresenceofGeoFlag")
    public void clickonGeoFlag() {
        logger.info("clicking on Flag of Geo Located Country");
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(closebutton)), getWebDriver(),
                WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(geo_countryselector)),
                getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        sleep(1000);
        click(getWebDriver().findElement(By.cssSelector(geo_countryselector)));

    }

    @Test(dependsOnMethods = "clickonGeoFlag")
    public void checkUrlContainsGeoCountry() {
        logger.info("Checking if you directed to Geo Located Country");
        waitForUrlContains(getWebDriver(), geourlcontains, 15);
        AssertHelper.assertThat("URL is not the expected one" + "url should contain" + geourlcontains, TestUtil.getCurrentUrl(getWebDriver()), containsString(geourlcontains));
    }

    @Test(dependsOnMethods = "checkUrlContainsGeoCountry")
    void delete_cookies() {
        CookieHandler.deleteCookies(getWebDriver());
        destroyDriver();
        sleep(1000);
    }

    @Test(dependsOnMethods = "delete_cookies")
    public void openUrl_1() {
        setThreadSafeDriver();
        openUrl(getWebDriver(),getTestStartUrl());
    }

    @Test(dependsOnMethods = "openUrl_1")
    void checkThePresenceofSiteFlag() {
        logger.info("Checking for the presence of Site Country Flag");
        //refresh(getWebDriver());
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(site_countryselctor)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WebElement siteflag = findElement(By.cssSelector(site_countryselctor), WaitTool.MED_WAIT_4_ELEMENT);
        AssertHelper.assertWebElementDisplayed(siteflag);
    }

    @Test(dependsOnMethods = "checkThePresenceofSiteFlag")
    public void clickonSiteFlag() {
        logger.info("clicking on Flag of site Country");
        WebElement siteflag = getWebDriver().findElement(By.cssSelector(site_countryselctor));
        click(siteflag);
    }

    @Test(dependsOnMethods = "clickonSiteFlag")
    public void checkUrlContainsSiteCountry() {
        logger.info("Checking if you directed to Site Country");
        waitForUrlContains(getWebDriver(), urlContains, 15);
        AssertHelper.assertThat("URL is not the expected one" + "url should contain" + urlContains, TestUtil.getCurrentUrl(getWebDriver()), containsString(urlContains));
    }
    @Test(dependsOnMethods ="checkUrlContainsSiteCountry")
    void openurlAgain(){
        logger.info("Deleting the cookies and opening the url again");
        CookieHandler.deleteCookies(getWebDriver());
        destroyDriver();
        setThreadSafeDriver();
        openUrl(getWebDriver(),getTestStartUrl());
    }
    @Test(dependsOnMethods ="openurlAgain")
    void closePopUp(){
        logger.info("Closing the Popup");
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(closebutton)), getWebDriver(),
                WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(closebutton)), getWebDriver(),
                WaitTool.MED_WAIT_4_ELEMENT25);
        sleep(1000);
        WebElement close = findElement(By.cssSelector(closebutton));
        click(close);
        AssertHelper.assertThat("URL is not the expected one." + "url should contain" + urlContains, TestUtil.getCurrentUrl(getWebDriver()), containsString(urlContains));
    }
}
