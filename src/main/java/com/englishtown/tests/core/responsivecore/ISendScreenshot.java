package com.englishtown.tests.core.responsivecore;

/**
 * Created by nikol.marku on 04/06/2015.
 */
public interface ISendScreenshot {
    void setupUrls();
    void setupMarket();
    void setupBaseUrl();
    void setSelectors(); // id not default used
    void setupEmailSubject();
}
