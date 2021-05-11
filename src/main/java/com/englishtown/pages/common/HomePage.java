package com.englishtown.pages.common;

import com.englishtown.pages.core.EnglishtownPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends EnglishtownPage {
    public HomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public HomePage(){
           this(null, null);
    }
}
