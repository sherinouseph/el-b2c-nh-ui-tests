package com.englishtown.helpers;
/***********************************************************************************************************************
 *
 * Created by nikol.marku on 04/03/2015.
 * Handle all the cookie operations
 *
 **********************************************************************************************************************/
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.core.IsNull.notNullValue;


public class CookieHandler {
    private static final Logger log = LoggerFactory.getLogger(CookieHandler.class);
    protected static Long cookieExpireDate = 1362002400000l; // 27/02/13 'Wed, 27 Feb 2013 10:00:00 GMT'
    public static String[] deDomainList = {".englishtown.com",".englishtown.de", ".www.englishtown.de",
             "etvt.englishtown.com","www.englishtown.de"};
    WebDriver webDriver;

    public CookieHandler(WebDriver driver){
        webDriver = driver;
    }

    /*******************************************************************************************************************
    *   Cookies handlers
    *******************************************************************************************************************/
    public static void deleteCookies(WebDriver driver) {
        log.info(" CookieHandler start deleting Cookies ...!; CMus and all ...");
        try {
            JavaScriptHelper.executeJavaScriptNoReturn("localStorage.clear()",driver, 5); // did not driver.get("javascript:localStorage.clear"); driver.get("javascript:localStorage.clear");
            JavaScriptHelper.executeJavaScriptNoReturn("sessionStorage.clear()",driver, 5);
            //driver.getSessionStorage().clear();            driver.getLocalStorage().clear();
            driver.manage().deleteCookieNamed("CMus");
            driver.manage().deleteAllCookies();
            log.info("deleted Cookies ...!");
        }catch (WebDriverException e){
            e.printStackTrace();
            log.info(" deleteCookies exception :  "+TestUtil.getExceptionFirstLine(e)+"\n"+e.getCause());
        }
    }
    public static void deleteCookies(WebDriver.Options options) {
        try {
            options.deleteCookieNamed("CMus");
            options.deleteAllCookies();
            log.info(" Webdriver deleted Cookies ...!");
        }catch (WebDriverException e){
            e.printStackTrace();
            log.info(" deleteCookies exception :  "+TestUtil.getExceptionFirstLine(e)+"\n"+e.getCause());
        }
    }

    public static void setCookies(WebDriver driver,String cookieHolder, String cookieValue) {
        log.info("setCookies for cookieHolder :"+cookieHolder+" to value :"+cookieValue);
        if(null != driver && null != cookieHolder) {
            if (cookieHolder.contains("ipad") || cookieHolder.contains("iphone") ) { //|| cookieHolder.contains("safari")
                log.info(" Set cookies for .. Is ipad / iphone/ safari on mac ...!");
                setCookiesValue(driver, cookieValue);
            } else {
                log.info("No Cookies Set for current browser :" + cookieHolder);
            }
        } else {
            log.error(" Can't Set cookies as driver or driver name is null");
        }
    }

    /**
     * Set cookies
     *
     * @param driver
     * @param cookieValue
     */
    public static void setCookiesValue(WebDriver driver, String cookieValue){
        log.info("setCookiesValue ...!");
        int count=0;
        String [] etCookies ={"et_uc","et_sc","et_u","et_s", "CMus"};

        deleteCookies(driver);       // CMus , open this after test for cookies on safari //DEBUG printCookies(WebDriver driver)

        try {
            String cookieDomainValue = TestUtil.getDomainFromUrl(driver.getCurrentUrl());
            log.info(" setCookiesValue :  cookieDomainValue is : "+cookieDomainValue);
            if(driver !=null) {
                Set<Cookie> cookies = driver.manage().getCookies();

                if (!cookies.isEmpty()) {
                    log.info("Current Cookie size " + cookies.size());
                    log.info("All Cookies Data : " + cookies.toString());
                    Iterator<Cookie> iter = driver.manage().getCookies().iterator();

                    while (iter.hasNext()) {
                        count++;
                        Cookie C = iter.next();
                        boolean isInList = TestUtil.isStringInTheList(C.getName(), etCookies);
                        if("safari".contains(BaseRemoteWebDriver.currentBrowserName) && isInList ) {
                            Cookie currentCookie = new Cookie(C.getName(), "",cookieDomainValue, C.getPath() ,
                                    new Date(cookieExpireDate) );
                            driver.manage().addCookie(currentCookie);
                            log.info("Web driver Added Cookie :"+currentCookie.toString());
                        }   // issue with running same test twice on IPAD mini safari - cookies
                        if(BaseRemoteWebDriver.is_IOS_MobileDevise  ) {
                            Cookie currentMobileCookie = new Cookie( C.getName(), "",cookieDomainValue, C.getPath() ,
                                                                                           new Date(cookieExpireDate) );
                            driver.manage().addCookie(currentMobileCookie);
                            log.info("Web driver Added MOBILE iOS Cookie :"+currentMobileCookie.toString());
                        }
                    }
                    Thread.sleep(1000);
                    if(!cookies.isEmpty()) {
                        cookies.clear();
                    }
                }
                Set<Cookie> cookies1 = driver.manage().getCookies();
                log.info("cookie size after all deletion : [{}]" , cookies1.size());
                if(!cookies1.isEmpty()) {
                    cookies1.clear();
                }
            } else {
                log.info("webdriver is NULL .....!");
            }
        } catch (WebDriverException | InterruptedException e) {
            log.info(" setCookies exception :  " +TestUtil.getExceptionFirstLine(e));
        }
    }


    /**
     * Set all cookies to expire date for the session
     *
     *
     */
    public static void setAllCookiesToExpired(WebDriver driver){
        log.info("setExpiredAllCookies ...!");
        int count=0;

        Set<Cookie> cookies = getCookies(driver);       // String cookieDomainValue = TestUtil.getDomainFromUrl(driver.getCurrentUrl()); log.info(" getDomainFromUrl - cookieDomainValue is : "+cookieDomainValue);

        if(null != cookies) {
            log.info("Current Cookie size " + cookies.size());
            log.info("All Cookies Data : " + cookies.toString());
        }

        if (!cookies.isEmpty()) {
            for (Cookie tempCookie : cookies) {
                count++;
                log.info("tempCookie.getDomain() : " + tempCookie.getDomain());
                Cookie tempExpiredCookie = new Cookie(tempCookie.getName(), "", tempCookie.getDomain(), tempCookie.getPath(), new Date(cookieExpireDate));
                driver.manage().addCookie(tempExpiredCookie);
                log.info("Web driver Added Cookie :" + tempExpiredCookie.toString());
            }
            if (!cookies.isEmpty()) {
                cookies.clear();
            }

            Set<Cookie> newCookies = driver.manage().getCookies();
            log.info("cookie size after all deletion : [{}]", newCookies.size());
            if (!newCookies.isEmpty()) {
                newCookies.clear();
            }
        }else {
            log.info("Cookies list is empty ....!");
        }

    }

    /****
     * Delete all cookies one by one using name
     *
     */
    public static void deleteAllCookiesOneByOne(WebDriver driver){
        log.info("deleteAllCookiesOneByOne using name ...!");
        int count=0;

        Set<Cookie> cookies = getCookies(driver);
        if(null != cookies) {
            log.info("Current Cookie size " + cookies.size());
            log.info("All Cookies Data : " + cookies.toString());
        }

        if (!cookies.isEmpty()) {
            for (Cookie tempCookie : cookies) {
                count++;
                log.info("tempCookie.getDomain() : " + tempCookie.getDomain());
                Cookie tempExpiredCookie = new Cookie(tempCookie.getName(), "", tempCookie.getDomain(), tempCookie.getPath(), new Date(cookieExpireDate));
                try{
                    driver.manage().deleteCookieNamed(tempCookie.getName());
                    //driver.manage().addCookie(tempExpiredCookie);
                }catch (Exception e ) {
                    log.error("Delete cookie exception ...! ;"+e.getCause());
                    driver.manage().deleteCookie(tempCookie);
                    //driver.manage().addCookie(tempExpiredCookie);
                }
                log.info("Web driver Added Cookie :" + tempExpiredCookie.toString());
            }
            if (!cookies.isEmpty()) {
                cookies.clear();
            }            /*            Set<Cookie> newCookies = driver.manage().getCookies();            log.info("cookie size after all deletion : [{}]", newCookies.size());            if (!newCookies.isEmpty()) {                newCookies.clear();            }*/
        }else {
            log.info("Cookies list is empty ....!");
        }

    }




    /**
     * Create and add cookie using a predefined domain list
     *Note - if IPAD test run again - e.g checkout it fails - network issue - caused by setting the cookies I guess
     */
    public static void addCookie(WebDriver driver, Cookie currentCookie, String[] domainList){
        log.info(" Current cookie is : "+currentCookie.toString());
        Cookie newCookie;
        Date cookieDate;

        try {
            cookieDate = new Date(cookieExpireDate);
            Cookie cCookie = new Cookie(currentCookie.getName(), "" );
            driver.manage().addCookie(cCookie);
            for (String domain : domainList) {
                newCookie = new Cookie(currentCookie.getName(), "", domain, currentCookie.getPath(), cookieDate);
                try {
                    driver.manage().addCookie(newCookie);
                }catch (Exception e){
                    log.error("Exception try to add cookie : "+newCookie+"  try to add domain "+domain+"\n");
                    log.error(TestUtil.getException(e));
                }
                log.info("addCookie() added cookie :" + newCookie.toString()+" : for domain ->"+domain);
            }
        }catch (Exception e){
            WaitTool.setJavaScriptTimeout(driver, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT);
            log.error(" cookie to add empty value is cCookie : "+ currentCookie.toString()+"\n"+TestUtil.getException(e));
        } WaitTool.setJavaScriptTimeout(driver, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT);
    }

    public static void printCookies(WebDriver driver){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String command = "return document.cookie :  ";
            log.info("document.cookies" + js.executeScript(command).toString());
        }catch (Exception e){
            log.warn(" "+TestUtil.getException(e));
        }
    }

    public static Cookie getCookie(WebDriver driver, String cookieName){
        Cookie cookie = null;
        int i = 15;

        while (i > 0) {
            i--;
            TestUtil.mySleep(1000);

            cookie = driver.manage().getCookieNamed(cookieName);

            if (cookie != null && cookie.getValue() != "") {
                log.info("Found Cookie name : " + cookieName);
                break;
            } else
                log.info("try again to find Cookie : " + cookieName + " Try left [{}] ", i);
        }

        if (cookie != null){
            log.info("Cookie : "+cookieName+" is : "+cookie.toString());
        }else {
            log.warn("Cookie : " + cookieName + " is : NULL");
        }

        return cookie;
    }

    public static Set<Cookie> getCookies(WebDriver driver){
        Set<Cookie> cookies = null;
        try {
            cookies = driver.manage().getCookies();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Can't get Set of cookies ....!");
        }
        return cookies;
    }

    public static void safeDeleteCookies(WebDriver driver, int waitTimeSeconds){
        int count = 0;
        while (waitTimeSeconds > 0){
            waitTimeSeconds--;
            count++;
            try{
                log.info("delete cookies Count  :"+count+" waitTimeSeconds left :"+waitTimeSeconds);
                if(null != driver) {
                    driver.manage().deleteAllCookies();
                }else {
                    log.info("Driver is null ...! Can not delete cookies on null driver ...!");
                }
                Thread.sleep(1000);
                break;
            }catch (WebDriverException | InterruptedException e) {
                log.error("safeDeleteCookies Exception ...! "+TestUtil.getException(e) );
            }

        }
    }

    public void setCookiesMoblieDevice(WebDriver driver, String currentDeviceName){
        if("ipad".contains(currentDeviceName) ){
            log.info(" isMoblileDevice ipad...!") ;
            CookieHandler.setCookies(driver, "ipad", "");
        }
        if ("iphone".contains(currentDeviceName) ){
            log.info(" isMoblileDevice iphone...!") ;
            CookieHandler.setCookies(driver,"iphone", "");
        }
    }

    public static void checkCookieWithRegx(WebDriver driver, String cookieName, String regEx){
        Cookie cookie = getCookie(driver, cookieName);
        myAssertThat(driver, "Fail checkCookieWithRegx, cookieName :'"+cookieName+"' data is : " +
                cookie.toString() + " does not match regex :" +regEx, cookie.toString().matches(regEx), true );
    }
    public static void checkCookieNotNull(WebDriver driver, String cookieName){
        myAssertThat(driver, "Fail cookie is not null ...!; CookieName :"+cookieName,
                getCookie(driver, cookieName), notNullValue(), true);
    }

    /**
     *
     * GET UUID from cookie efid_tokens .. need to spit it
     *
     *
     * @param driver
     * @return string UUID
     */
    public static synchronized String getUUID(WebDriver driver){
        String uuid = "";
        try {
            Cookie efid_tokens_cookie = CookieHandler.getCookie(driver, "efid_tokens");
            String efid_tokens_cookieValue = efid_tokens_cookie.getValue();
            // document.cookie
            String[] cookiesParts = efid_tokens_cookieValue.split("uuid:");
            uuid = cookiesParts[1].split("%")[0];
            log.info("UUID IS [{}]", uuid);
        }catch (NullPointerException n){
            log.error("Cant get cookie or toke value .. NULL ...! "+n.getMessage());
        }
        catch (IndexOutOfBoundsException i){
            log.error("cant get uuid from cookie at index specified ...!"+i.getMessage());
        }
        catch (WebDriverException e){
            log.error(e.getMessage());
        }
        return uuid;
    }

    public static String getAccountXEFid(WebDriver driver){
        String xefaccess = "";
        try {
            Cookie efid_tokens_cookie = CookieHandler.getCookie(driver, "efid_tokens");
            String efid_tokens_cookieValue = efid_tokens_cookie.getValue();

            String[] cookiesParts = efid_tokens_cookieValue.split("account");
            xefaccess = cookiesParts[1].replace("%22:%22", "").replace("%22}", "");//.split("%22:%22")[0].split("%22:%22")[0];

            log.info("xefaccess IS [{}]", xefaccess);
        }catch (NullPointerException n){
            log.error("Cant get cookie or toke value .. NULL ...! "+n.getMessage());
        }
        catch (IndexOutOfBoundsException i){
            log.error("cant get xefaccess from cookie at index specified ...!"+i.getMessage());
        }
        catch (WebDriverException e){
            log.error(e.getMessage());
        }
        return xefaccess;
    }
    public static void setCookiesValueForTimeZone(WebDriver driver, String cookieValue){
        log.info("setCookiesValue ...!");
        Cookie tz = new Cookie("mypage_timezone_confirmation", cookieValue);
        driver.manage().addCookie(tz);

    }

}