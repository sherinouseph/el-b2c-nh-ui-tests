package com.englishtown.pages.core;

import org.openqa.selenium.WebDriver;

public interface Page {
    public WebDriver getWebDriver();

    public void loadPage();

    public boolean isAtExpectedPage();

    public String getCurrentUrl();

    public boolean isPageLoaded();

    public long getPageLoadDurationMilliSeconds();

    public String getKey();

    public boolean isUrlValidForThisPage();

    public String getUrl();

    public EnglishtownStateObject getEnglishtownStateObject(WebDriver driver);

    public String getPageSpeedIndexAnalysisReport();
    boolean isPageUrl(String url);

   // public void setLanguageAndMarket(String language, String market);
}
