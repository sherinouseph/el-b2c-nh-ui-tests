package com.englishtown.tests.core;
/**
 *
 */
import com.englishtown.pages.core.InteractiveCheckoutPage;
import com.englishtown.pages.forms.BaseForm;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class InteractiveCheckoutPageTest<TForm extends BaseForm,
        TCheckoutPage extends InteractiveCheckoutPage<TForm>>
        extends InteractivePageTest<TForm, TCheckoutPage> {

    protected InteractiveCheckoutPageTest(WebDriver webDriver) {
        super();
        setWebDriver(webDriver) ; //      this.webDriver = webDriver;
    }

    @Test
    public void verifyPage() {
        //assertThat("The page is not at expected location.", this.getPage().isUrlValidForThisPage(), is(true));
        myAssertThat(getWebDriver(), "verifyPage The page is not at expected location.", this.getPage().isUrlValidForThisPage(), true);
    }
}
