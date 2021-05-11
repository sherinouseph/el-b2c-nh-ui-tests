package com.englishlive.tests.landing.base;
/***
 * User: nikol.marku
 * Date: 01/09/14
 *
 */
import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.By;


public abstract class BaseSendTagOnUrlTest extends BaseOsLandingPageHiddenFieldTest {

    public String itagValue      ="PTN";
    public String itagId         ="etag";
    public String tag            ="?etag=" ;
    public String partnerTag     ="?ptn=" ;
    public String partnerId      = "partner";
    public String partnerValue   = "goes";

    public void testItagCodeHiddenFieldTest(String itagId, String itagValue, int waitTime){
        checkOsHiddenFildTest(itagId, itagValue, waitTime);
    }


    //@beforeClass
    public void openPageSendTagUrl(String tagId, String currentValue, String webElementIdToWaitFor){
        this.getPage().loadPage();
        try{Thread.sleep(1000);}catch (Exception e){}
        WebElementHelper.safeFindElement(getWebDriver(), By.id(webElementIdToWaitFor));
        //TODO refactor below to use the url injected on the testcase
        openUrl(getWebDriver(),testStartUrl+tagId+currentValue );
        try{Thread.sleep(1000);}catch (Exception e){}
       // getWebDriver().get(getWebDriver().getCurrentUrl()+tagId+currentValue);     //"?etag="  tagid      // getWebDriver().get(+tagId+currentValue);
        WebElementHelper.safeFindElement(getWebDriver(), By.id(webElementIdToWaitFor));
    }



}
