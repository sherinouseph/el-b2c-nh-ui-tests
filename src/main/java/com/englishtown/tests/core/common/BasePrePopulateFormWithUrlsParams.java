package com.englishtown.tests.core.common;
/**
 * SAND-2607
 As a user
 when I open a form url(os or oe)
 with params [firstname,/first_name, lastname/last_name, email]
 Then the form is prepopulated with that data
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class BasePrePopulateFormWithUrlsParams extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BasePrePopulateFormWithUrlsParams.class);
    // Default values
    protected String[] urlsParams = {"testfname","testlastname","nikoltest@qp1.org"};
    protected String[] weCss = {"input[name=firstname]","input[name=lastname]","input[name=email]"};
    protected boolean isCheckLastNameTest = true;
    protected int emailId = 2; // test set this up based on the form config

    @Test
    public void isFirstNamePopulated() {
        int weId=0;
        AssertHelper.assertThat("First Name is not populated ...!", getText(findElement(By.cssSelector(weCss[weId]))), equalTo(urlsParams[weId]) );
    }
    @Test
    public void isLastNamePopulated() {
        int weId=1;
        if(isCheckLastNameTest) {
            AssertHelper.assertThat("Last Name is not populated ...!", getText(findElement(By.cssSelector(weCss[weId]))), equalTo(urlsParams[weId]));
        } else {logger.warn("is isLastNamePopulated not RUN ... as this field is not there ....!");}
    }
    @Test  //DE does not have sen field
    public void isEmailPopulated() {
        int weId=emailId;
        AssertHelper.assertThat("Email is not populated ...!", getText(findElement(By.cssSelector(weCss[weId]))), equalTo(urlsParams[weId]));
    }


    protected void setupUrlParams(String [] urlsParams, String [] weIds ){
        this.urlsParams = urlsParams;
        this.weCss = weIds;
    }

    protected void setupWeIds(String [] weIds ){
        this.weCss = weIds;
    }


}
