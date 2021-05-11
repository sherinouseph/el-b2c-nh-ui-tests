package com.englishtown.pages.core;

import com.englishtown.pages.forms.BaseForm;

public interface InteractivePage<TForm extends BaseForm> extends Page {
    public TForm createForm();
    public TForm getForm();
}
