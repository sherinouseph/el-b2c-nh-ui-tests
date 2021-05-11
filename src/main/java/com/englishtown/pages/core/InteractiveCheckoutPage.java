package com.englishtown.pages.core;

import com.englishtown.pages.forms.BaseForm;
import org.openqa.selenium.WebDriver;

public abstract class InteractiveCheckoutPage<TForm extends BaseForm> extends CheckoutPage
        implements InteractivePage<TForm> {
    private TForm form;

    protected InteractiveCheckoutPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public TForm getForm() {
        if (this.form == null) {
            this.form = this.createForm();
        }
        return form;
    }
}
