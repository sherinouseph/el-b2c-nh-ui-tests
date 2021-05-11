package com.englishtown.tests.core;

import com.englishtown.pages.core.InteractivePage;
import com.englishtown.pages.forms.BaseForm;

import java.util.Date;

public abstract class InteractivePageTest<TForm extends BaseForm, TInteractivePage extends InteractivePage<TForm>>
        extends PageTest<TInteractivePage> {
    //@Value("#{applicationPropertiesList['test.email']}")
    private String emailAddressTemplate = EfConstants.TEST_MAIL_START_TOKEN+"@STAMP@"+EfConstants.TEST_MAIL_END_TOKEN+"@qp1.org" ;  //"test@STAMP@@qp1.org";

    public String generateEmail() {
        String sDate = String.valueOf(new Date().getTime());
        String testEmail = this.emailAddressTemplate.replace("@STAMP@", sDate);
        setUserEmail(testEmail);
        return testEmail;
    }
}
