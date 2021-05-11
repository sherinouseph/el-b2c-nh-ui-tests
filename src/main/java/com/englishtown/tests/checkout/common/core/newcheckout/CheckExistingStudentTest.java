package com.englishtown.tests.checkout.common.core.newcheckout;
/**
 * 1. Click Start learning
 * 2. Check Enrolment page (URL should contain 'enrollment')
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.CheckCampusPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;




public abstract class CheckExistingStudentTest extends CheckCampusPageTest{
    private static final Logger logger = LoggerFactory.getLogger(CheckExistingStudentTest.class);
    protected String validationMsgEmailTxt = "notinit";

    //TODO remove this and use TRMemberPageNegativeTest for all the negative test ????

    @Test(dependsOnMethods = {"checkAtCampusPage"})
    public void deleteUserCookies() {
        CookieHandler.deleteCookies(getWebDriver());
    }

    @Test(dependsOnMethods = {"deleteUserCookies"})
    public void enterMemberDetailsWithExistingemail() {
        openUrl(getWebDriver(),memberPageUrl, -1 ) ;
        initMemberPage();
        enterFormData(formDataMap);
        WebElementHelper.sendKeys(getWebDriver(), findElement(By.name("email")), getUserEmail(), false);
        logger.info("enter email"+getUserEmail());
    }

    @Test(dependsOnMethods = {"enterMemberDetailsWithExistingemail"})
    public void submitMemberAndCheckErrorMessages() {
        logger.info("start submitMemberForm");
        click(By.cssSelector(".btn.btn-primary"));
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")), getWebDriver(), 15);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(findElement(By.className("tooltip-inner"))),validationMsgEmailTxt,"Validation Message is Wrong");

    }


}