package com.englishlive.tests.landing.core;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

/**
 * Date: 03/11/14
 * Time: 11:03
 *
 */
public abstract class BaseForgottenPassComponenttest extends BaseTestHelper{
    private static final Logger logger = LoggerFactory.getLogger(BaseForgottenPassComponenttest.class);

    protected final String emailWeId            = "emailOrUsername";
    protected final String submitEmailId        = "submitForgotPasswordForm";
    protected final String thankYouMessageWeId  = "forgotPasswordThankYouMessage";
    protected final String tyMsg                = "Thank You";


    @Test
    protected void enterEmailAddress_AndClickSubmit(){
        String emailAddress = "testForgotpassNiko"+System.currentTimeMillis()+"@qp1.org";
        logger.info("And wait for email Address element is clickable ...!");
        WebElement emailWe = WaitTool.waitForElementClickable(getWebDriver(), By.id(emailWeId), 20);
        logger.info("And enter email Address on forgotten pass txt : "+emailAddress);
        emailWe.sendKeys(emailAddress);
        logger.info("And Clicked submit ...! ");
        WebElement submit = findElement(By.id(submitEmailId));
        click(submit);
    }

    @Test (dependsOnMethods = "enterEmailAddress_AndClickSubmit")
    protected void checkThankyouMsgShown(){
        WebElement thankYouMessageWe = findElement(By.id(thankYouMessageWeId));
        String currentTyMsg = getText(thankYouMessageWe);
        logger.info("Then I should see  Thank You message ...! MSG ["+tyMsg+"]");
        AssertHelper.myAssertThat(getWebDriver(), "Expected text ["+tyMsg+" Not Shown ....! it shows :"+currentTyMsg,
                currentTyMsg,  	containsString(tyMsg), true);


    }

}
