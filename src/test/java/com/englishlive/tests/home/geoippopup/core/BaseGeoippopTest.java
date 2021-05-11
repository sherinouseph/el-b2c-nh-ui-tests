package com.englishlive.tests.home.geoippopup.core;
/**
 * Created by nikol.marku on 11/21/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3262
 * All depends on GEO location and the URL
 *
 If page.geo_located_ctr value is different from the value of page.market
 Then show a popup that would suggest the user :
 to "stay" in the current site, or change to the right site.
 User can select the option and the selected site is shown
 >The language of the popup, should be in the default language for the geolocatedctr.

 From UK
 Chrome 56.0.2* ; Firefox, IE [POP up miss images], Edge
 1. Open URL http://qa-englishlive.ef.com/en-us/ [geo_located_ctr:"gb"]
 2. Update cookie document.cookie ="ipctr=br; domain=.qa-englishlive.ef.com; path=/"
 3. Refresh
 :: POPup shown, geo_located_ctr:"br"
 4. Select BR  BR site shown;
 *
 */

import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGeoippopTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseGeoippopTest.class);

    protected String ipctrValue ;
    protected String domain = "englishlive.ef.com" ;
    protected String cookieScript ;                                                                                     //= "document.cookie ='ipctr="+ipctrValue+"; domain="+domain+"; path=/'";
    protected String changeCountryPopupCss = ".geolocated-country-popup-content";
    protected String geoLocationCtr = ".geolocated.flag a";
    protected String siteFlagLocationCtr = ".site.flag a";
    protected String requestSiteCtr = ".site.flag";
    protected String endUrl ;   // after selecting a country on pop up
    protected String endUrl2 ;   // after selecting a country on pop up again



    @Test
    public void clickOnPopupCountry(){
        logger.info("Test 0 ...!");
        waitForElementVisibleAndClick(geoLocationCtr, WaitTool.DEFAULT_IMPLICIT_WAIT);
    }


    @Test (dependsOnMethods = "clickOnPopupCountry")
    public void checkGeoIpCtrSiteShow(){
        waitForUrlEndsWithTxt(getWebDriver(), endUrl, WaitTool.DEFAULT_WAIT_4_ELEMENT);
        assertIsUrlContaining(endUrl);
    }

    @Test(dependsOnMethods = "checkGeoIpCtrSiteShow")
    public void clearLocalStorageOpenUrl(){
        JavaScriptHelper.executeJavaScript(CLEAR_LOCAL_STOREAGE, getWebDriver());
        CookieHandler.safeDeleteCookies(getWebDriver(), 1);
        sleep(1000);
        openUrl(getWebDriver(), testStartUrl);        //refresh(getWebDriver());
        sleep(200);
        waitForElementVisibleAndClick(".pagination-left .cq-dd-image", 10);
        sleep(2000);
    }

    @Test(dependsOnMethods = "clearLocalStorageOpenUrl")
    public void clickOnPopupCountryEs(){
        logger.info("Test 0 ...!");
        waitForElementVisibleAndClick(siteFlagLocationCtr, WaitTool.DEFAULT_IMPLICIT_WAIT);
    }

    @Test (dependsOnMethods = "clickOnPopupCountryEs")
    public void checkGeoIpCtrSiteShowAgain(){
        waitForUrlEndsWithTxt(getWebDriver(), endUrl2, WaitTool.DEFAULT_WAIT_4_ELEMENT);
        assertIsUrlContaining(endUrl2);
    }

    //To Do
    protected boolean isPopupShown(){
        return false;
    }

    //To Do
    protected boolean getPopupLanguage(){
        return false;
    }

    // go to geo site or second one
    protected void goToSite(){

    }


}



/*logger.info("Page.market :"+getMarket()); logger.info("Page.geo_located_ctr "+getPageGeoLocatedCtr());    }*/
//setLanguageAndMarket(geoPopupTestDataBean.getPopupLanguage(), geoPopupTestDataBean.getMarket());
// TODO setup State object DATA .. ask norman how to update state obj
//openUrl(getWebDriver(), getBASEURL()+testUrl);
// AssertHelper.assertThat("", isPopupShown());
// AssertHelper.assertThat("", getPopupLanguage(), is(geoPopupTestDataBean.getPopupLanguage()));
//(dataProvider = "geoIppopupUrls", dataProviderClass = GeoipPopupDataProvider.class, threadPoolSize = 6, invocationCount = 1, timeOut = 60000 )