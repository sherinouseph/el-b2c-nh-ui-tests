package com.englishtown.pages.component.core;

import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by nikol.marku on 31/05/2016.
 */
public abstract class BaseComponentPage extends MyBasePage implements IComponentPage {

    public BaseComponentPage(WebDriver webDriver){
        super(webDriver);
    }


}
