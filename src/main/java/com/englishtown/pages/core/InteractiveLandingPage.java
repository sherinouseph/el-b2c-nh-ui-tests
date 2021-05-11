package com.englishtown.pages.core;

import com.englishtown.pages.forms.BaseForm;
import org.openqa.selenium.WebDriver;

public abstract class InteractiveLandingPage<TForm extends BaseForm> extends LandingPage implements InteractivePage<TForm> {
    protected TForm form;

    protected InteractiveLandingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public TForm getForm() {
        if(this.form == null) {
            this.form = this.createForm();
        }
        return this.form;
    }
}
