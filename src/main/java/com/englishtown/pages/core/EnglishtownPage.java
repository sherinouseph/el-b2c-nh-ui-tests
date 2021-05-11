package com.englishtown.pages.core;

import org.openqa.selenium.WebDriver;

public abstract class EnglishtownPage extends BasePage {
    protected EnglishtownPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
}
