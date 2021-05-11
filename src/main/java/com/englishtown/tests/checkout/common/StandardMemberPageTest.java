package com.englishtown.tests.checkout.common;

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.checkout.legacy.MemberPage;
import com.englishtown.pages.forms.DynamicMembersForm;
import com.englishtown.pages.forms.legacy.MemberForm;
import com.englishtown.tests.core.InteractiveCheckoutPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Test(enabled=false)
public class StandardMemberPageTest
        extends InteractiveCheckoutPageTest<MemberForm, MemberPage> {
    private static final Logger logger = LoggerFactory.getLogger(StandardMemberPageTest.class);
    protected String testFirstName;
    protected String testLastName;
    protected String testPassword;
    protected String pageUrl;

    public StandardMemberPageTest(WebDriver webDriver, String testFirstName, String testLastName, String testPassword, String pageUrl) {
        super(webDriver);
        this.testFirstName = testFirstName;
        this.testLastName = testLastName;
        this.testPassword = testPassword;
        this.pageUrl = pageUrl;
    }

    public String getTestPassword() {
        return testPassword;
    }

    public String getTestLastName() {
        return testLastName;
    }

    public String getTestFirstName() {
        return testFirstName;
    }
    // TODO refactor for market
    public void createMember() {
        MemberPage memberPage = this.getPage();
        memberPage.loadPage();
        // hack to start on PP page .... dirty
        clickAtWindow(getWebDriver(), 5, 5);
        // there are 2 experiences  here
        // v1 and v2 user $('a[href="/checkout/"]')
        // old pnp page click(getWebDriver(), By.id("offerContainer_offertable-5aa4_fc2cta1"));
        //click(getWebDriver(), By.cssSelector("a[href='/checkout/']")); // use this for both experiences
        click(getWebDriver(), By.cssSelector(".plansandprices .btn.btn-primary")); // use this for both experiences

        webDriverSwitchToDefautContent();
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("[name=FirstName]"), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        jsWindowFocus();
        MemberForm form = memberPage.getForm();         // focusOnElementUsingJSAndWeId("FirstName", getWebDriver())  ; webDriverSwitchToDefautContent webDriverSwitchToActiveElement
        WebElementHelper.focusOnElementUsingSendKeyOrAction(form.getFirstName().getWebElement(), getWebDriver());
        form.getFirstName().setTextValue(this.getTestFirstName());
        form.getLastName().setTextValue(this.getTestLastName());
        // IPAD is not starting tes with clear textfields
//        if(BaseRemoteWebDriver.currentDeviceName !=null && BaseRemoteWebDriver.currentDeviceName.contains("iPad")){
//            getWebDriver().findElement(By.id("Email")).clear();
//        }
        form.getEmailAddress().setTextValue(this.generateEmail());
        form.getPassword().setTextValue(this.getTestPassword());
        form.getConfirmPassword().setTextValue(this.getTestPassword());
        form.getTelephone().setTextValue("7895586785");
        //form.getForm().
        form.getEmailEnglish().setAutoScroll(true);
        form.getEmailEnglish().ensureChecked();
        stopCheckoutAbortPopup();
        form.submit();
        //wait(1);
    }
    public void createMember(Boolean isSubmit) {
        MemberPage memberPage = this.getPage();
        memberPage.loadPage();
        webDriverSwitchToDefautContent();
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("[name=FirstName]"), getWebDriver(), WaitTool.WAIT_5s);
        jsWindowFocus();
        MemberForm form = memberPage.getForm();           //focusOnElementUsingSendKeyOrAction(form.getFirstName().getWebElement(),getWebDriver());            //form.getFirstName().getWebElement().clear();        form.getFirstName().click();
        WebElementHelper.focusOnElementUsingSendKeyOrAction(form.getFirstName().getWebElement(), getWebDriver());           //focusOnElementUsingJSAndWeId("FirstName", getWebDriver());          // webDriver.switchTo().defaultContent();         //webDriver.switchTo().activeElement();  ((JavascriptExecutor) webDriver).executeScript("window.focus();");
        form.getFirstName().setTextValue(this.getTestFirstName());
        form.getLastName().setTextValue(this.getTestLastName());
        form.getEmailAddress().setTextValue(this.generateEmail());
        form.getTelephone().setTextValue("7895586785");
        form.getPassword().setTextValue(this.getTestPassword());
        form.getConfirmPassword().setTextValue(this.getTestPassword());
        form.getEmailEnglish().setAutoScroll(true);
        form.getEmailEnglish().ensureChecked();

        if(isSubmit){
            form.submit();
            wait(1);//TODO remove wait - implicit wait is used as this sort of wait will wait for Time = e.g 1 x ImplicitWait
        }

    }
    public void submitMemberForm( ) {
        MemberForm form = new MemberForm(this.getWebDriver());
        form.submit();

    }
    //JP test
    public DynamicMembersForm createMemberAndReturnMForm() {
        createMember(false);
        DynamicMembersForm dmf = new DynamicMembersForm(getWebDriver());
        dmf.getAge().selectValue("23-25");
        dmf.getState().selectIndex(3);
        dmf.getPhoneNo().setTextValue("0941023130"); // jp 0941023130  add this to props         //try {Thread.sleep(3000);} catch(Exception e) {e.printStackTrace();}
        dmf.getAgreeSign().click();
        dmf.getAgreeSign().ensureChecked();              // try {Thread.sleep(3000);} catch(Exception e) {e.printStackTrace();}
        return dmf;
    }

    @Override
    protected MemberPage createPage() {
        return new MemberPage(this.getWebDriver(), this.pageUrl);
    }

}
