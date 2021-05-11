package com.englishlive.tests.newsite.core;

/**
 * Created by nikol.marku on 8/24/2016.
 *
 * 1.
 * 2.
 * 3. Enter form data and submit
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;

public abstract class BaseConsultationTest extends BaseTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(BaseConsultationTest.class);

    public PriceAndPackagekPage priceAndPackagekPage ;
    public String firstWindow ;
    public String newWindow   ;
    public String thankYouMsgContains = "notInit";
    public String tyMessageCss = ".the.message";
    public String tyMessageTxtCss = ".the.message b";
    public String submitFormBtnCss = ".form-submit button";
    public String validationMsgWeCss = ".tooltip-inner"; // age validation
    public String validationMsgTxt = "not suitable for people below 13";
    public boolean isClickConsultationBtn = true; // click btn to to open popup form
    protected boolean isInlineTyMsg = true;

    @Test
    public void clickConsultationButton(){
        if(isClickConsultationBtn)
            click_ConsultationButton();
    }

    @Test(dependsOnMethods = "clickConsultationButton")
    void enterConsultationFormDetails(){
        enterFormData(formDataMap);
    }

    @Test(dependsOnMethods = "enterConsultationFormDetails")
    void submitForm(){
        click(findElement(By.cssSelector(submitFormBtnCss)));
        //click(getWebDriver(), By.cssSelector(submitFormBtnCss));
        sleep(2000);
    }

    @Test(dependsOnMethods = "submitForm")
    void checkThankyouMsgShown(){
        if(isInlineTyMsg ) {
            check_ThankyouMsgShown();
        } else {
            assertIsUrlContaining(urlContainsThankyou);
        }
    }


    public void click_ConsultationButton(){
        firstWindow = getWebDriver().getWindowHandle();
        logger.info("First window :"+firstWindow.toString());
        click(priceAndPackagekPage.consultationBtn);
        sleep(3000);
    }

    public void check_ThankyouMsgShown(){
        getWebDriver().switchTo().defaultContent();
        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(tyMessageCss)));
        String thankyouMsg = getText( findElement(By.cssSelector(tyMessageTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "",thankyouMsg, containsIgnoringCase(thankYouMsgContains), true );
        logger.info("Thank you message shown ....! "+thankyouMsg);
    }

    public void check_ThankyouMsgShownUS(){
        tyMessageTxtCss = ".stage h1";
        getWebDriver().switchTo().defaultContent();
        String thankyouMsg = getText( findElement(By.cssSelector(tyMessageTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "",thankyouMsg, containsIgnoringCase(thankYouMsgContains), true );
        logger.info("Thank you message shown ....! "+thankyouMsg);
    }

    public void check_AgeValidationUnder13Shown(){
        String edgeValidationMsg = getText( findElement(By.cssSelector(validationMsgWeCss)));
        AssertHelper.myAssertThat(getWebDriver(), "",edgeValidationMsg, containsIgnoringCase(validationMsgTxt), true );
        logger.info("Validation message shown ....! "+edgeValidationMsg);
    }


}
