package com.englishtown.pages.core;

import org.openqa.selenium.WebDriver;

/**
 * User: nikol.marku
 * Date: 03/09/14
 *
 * use this for all page objects classes that user page factory
 */

//TODO refactor page object that use pagefactory

public abstract class MyBasePage extends BasePage {

    protected MyBasePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    protected MyBasePage(WebDriver webDriver, int timeout) {
        super(webDriver, timeout);
    }

    public MyBasePage(WebDriver webDriver) {
        super(webDriver);
    }




}
