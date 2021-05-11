package com.englishlive.tests.crm;
/**
 * Created by nikol.marku on 25-May-17.
 *  https://jira.eflabs.io/browse/SAND-3943
 *
 */

import com.englishlive.tests.crm.core.BaseCrmMagicForm;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.NewHouseForgottenPassPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CrmMagicFormForgotenPassFlowTest extends BaseCrmMagicForm{// implements ISharedConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CrmMagicFormForgotenPassFlowTest.class);


    @BeforeClass
    protected void setupOpenCrmUrl()  {
        testStartUrl = getBASEURL()+crmMagicFormExistingUser;

        forgotPassTyMessage = "Thanks, your password reset information";
        username = "auto_gb_crm_forgetpass@qp1.org"; // TODO user need to setup in QA as checkout is in old house ... //"eLiveTesCrmMagict@qp1.org";
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl );
    }


    @Test
    void CheckForgotenPassCrmFlow(){
        //when: "I open CMR magic form login page as existing user"  and "Click forgotten pass link"
        WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(forgottenPassWeCss), WaitTool.DEFAULT_IMPLICIT_WAIT);
        click(By.cssSelector(forgottenPassWeCss));

        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(forgottenpassEmailOrUsernameCss)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);

        sendKey(getWebDriver(), findElement(By.cssSelector(forgottenpassEmailOrUsernameCss)), username, true);

        // Submit form
        click(By.cssSelector(giveMyPassBackBtnCss));
        sleep(3000);
        NewHouseForgottenPassPage newHouseforgottenPassPage = new NewHouseForgottenPassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        newHouseforgottenPassPage.getPageLoadedCondition();
        AssertHelper.assertWebElementTextContains(forgotPassTyMessage, findElement(By.cssSelector(".formset--login .the.message")));
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
