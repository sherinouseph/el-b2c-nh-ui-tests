package com.englishtown.pages.cq;
/**
 * Created by nikol.marku on 12/29/2016.
 * All CQ interface pages
 */

import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;


public class CqCorePage extends MyBasePage implements CQI {

    protected CqCorePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqCorePage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getCQ_MAINSITE_RELATIVE_URL() {
        return CQ_QATEST_MAINSITE_URL;
    }
}
